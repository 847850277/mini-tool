package com.zp.designpattern.reactor.framework;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class AbstractNioChannel {

    private final SelectableChannel channel;

    private final ChannelHandler handler;

    private final Map<SelectableChannel, Queue<Object>> channelToPendingWriters;

    private NioReactor reactor;

    public AbstractNioChannel(ChannelHandler handler,SelectableChannel channel) {
        this.handler = handler;
        this.channel = channel;
        this.channelToPendingWriters = new ConcurrentHashMap<>();
    }

    void setReactor(NioReactor reactor) {
        this.reactor = reactor;
    }

    public SelectableChannel getJavaChannel() {
        return channel;
    }

    public abstract int getInterestedOps();

    public abstract void bind() throws IOException;

    public abstract Object read(SelectionKey key) throws IOException;

    public ChannelHandler getHandler() {
        return handler;
    }

    void flush(SelectionKey key) throws IOException{
        Queue<Object> pendingWrites = channelToPendingWriters.get(key.channel());
        Object pendingWrite;
        while ((pendingWrite = pendingWrites.poll()) != null){
            doWrite(pendingWrite,key);
        }
        reactor.changeOps(key,SelectionKey.OP_READ);
    }

    protected  abstract void doWrite(Object pendingWrite, SelectionKey key) throws IOException;

    public void write(Object data, SelectionKey key){
        System.out.println(key.toString());
        Queue<Object> pendingWrites = this.channelToPendingWriters.get(key.channel());
        if(pendingWrites == null){
            synchronized (this.channelToPendingWriters){
                pendingWrites = this.channelToPendingWriters.get(key.channel());
                if(pendingWrites == null){
                    pendingWrites = new ConcurrentLinkedQueue<>();
                    this.channelToPendingWriters.put(key.channel(), pendingWrites);
                }
            }
        }
        pendingWrites.add(data);
        reactor.changeOps(key,SelectionKey.OP_WRITE);
    }

}
