package com.zp.designpattern.reactor.framework;


import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NioReactor {

    private final Selector selector;

    private final Dispatcher dispatcher;

    private final Queue<Runnable> pendingCommands = new ConcurrentLinkedQueue<>();

    private final ExecutorService reactorMain = Executors.newSingleThreadExecutor();

    public NioReactor(Dispatcher dispatcher) throws IOException {
        this.dispatcher = dispatcher;
        this.selector = Selector.open();
    }


    public void start(){

        reactorMain.execute(() ->{
            try {
                //log.info("Reactor started,waiting for events...");
                System.out.println("Reactor started,waiting for events...");
                eventLoop();
            }catch (IOException e){
                System.out.println("exception in event loop" + e.getMessage());
                //log.error("exception in event loop",e);
            }
        });

    }

    private void eventLoop() throws IOException{

        while (!Thread.interrupted()){

            processPendingCommands();

            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if(!next.isValid()){
                    iterator.remove();
                }
                processKey(next);
            }
            selectionKeys.clear();
        }

    }

    private void processKey(SelectionKey key) throws IOException{
        if(key.isAcceptable()){
            onChannelAcceptable(key);
        }else if(key.isReadable()){
            onChannelReadable(key);
        }else if(key.isWritable()){
            onChannelWritable(key);
        }
    }

    private void onChannelWritable(SelectionKey key) throws IOException{
        AbstractNioChannel abstractNioChannel = (AbstractNioChannel) key.attachment();
        abstractNioChannel.flush(key);
    }

    private void onChannelReadable(SelectionKey key) {
        try {
            Object readObj = ((AbstractNioChannel) key.attachment()).read(key);
            dispatchReadEvent(key,readObj);
        }catch (IOException e){
            try {
                key.channel().close();
            }catch(IOException e1){
                //log.error("error closing channel",e1);
                System.out.println("error closing channel" + e1.getMessage());
            }
        }
    }

    private void dispatchReadEvent(SelectionKey key, Object readObj) {
        AbstractNioChannel abstractNioChannel = (AbstractNioChannel) key.attachment();
        dispatcher.onChannelReadEvent(abstractNioChannel,readObj,key);
    }

    private void onChannelAcceptable(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel accept = serverSocketChannel.accept();
        accept.configureBlocking(false);
        SelectionKey register = accept.register(selector, SelectionKey.OP_READ);
        register.attach(key.attachment());
    }

    private void processPendingCommands() {
        //System.out.println("processPendingCommands");
        Iterator<Runnable> iterator = pendingCommands.iterator();
        while (iterator.hasNext()){
            Runnable command = iterator.next();
            command.run();
            iterator.remove();
        }
    }

    public void changeOps(SelectionKey key, int interestedOps) {
        pendingCommands.add(new ChangeKeyOpsCommand(key,interestedOps));
        selector.wakeup();
    }

    public NioReactor registerChannel(AbstractNioChannel channel) throws IOException {
        SelectionKey register = channel.getJavaChannel().register(selector, channel.getInterestedOps());
        register.attach(channel);
        channel.setReactor(this);
        return this;
    }

    public void stop() throws InterruptedException, IOException  {
        reactorMain.shutdown();
        selector.wakeup();
        if (!reactorMain.awaitTermination(4, TimeUnit.SECONDS)) {
            reactorMain.shutdownNow();
        }
        selector.close();
        System.out.println("Reactor stopped");
    }

    class ChangeKeyOpsCommand implements Runnable {
        private final SelectionKey key;
        private final int interestedOps;

        public ChangeKeyOpsCommand(SelectionKey key, int interestedOps) {
            this.key = key;
            this.interestedOps = interestedOps;
        }

        public void run() {
            key.interestOps(interestedOps);
        }

        @Override
        public String toString() {
            return "Change of ops to: " + interestedOps;
        }
    }
}
