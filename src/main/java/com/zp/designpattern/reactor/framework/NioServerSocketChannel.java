package com.zp.designpattern.reactor.framework;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServerSocketChannel extends AbstractNioChannel{

    protected final int port;

    public NioServerSocketChannel(int port, ChannelHandler handler) throws IOException {
        super(handler, ServerSocketChannel.open());
        this.port = port;
    }

    @Override
    public int getInterestedOps() {
        return SelectionKey.OP_ACCEPT;
    }

    @Override
    public ServerSocketChannel getJavaChannel() {
        return (ServerSocketChannel) super.getJavaChannel();
    }

    @Override
    public void bind() throws IOException {
        ServerSocketChannel javaChannel = getJavaChannel();
        javaChannel.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
        javaChannel.configureBlocking(false);
        //log.info("Bound TCP socket at port: {}", port);
        System.out.println("Bound TCP socket at port: " + port);
    }

    @Override
    public Object read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = socketChannel.read(buffer);
        buffer.flip();
        if(read == -1) {
            throw new IOException("socket read error");
        }
        return buffer;
    }

    @Override
    protected void doWrite(Object pendingWrite, SelectionKey key) throws IOException {
        ByteBuffer pendingBuffer = (ByteBuffer) pendingWrite;
        ((SocketChannel)key.channel()).write(pendingBuffer);
    }
}
