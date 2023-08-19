package com.zp.designpattern.reactor.framework;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;

public class NioDatagramChannel extends AbstractNioChannel{

    private int port;

    public NioDatagramChannel(int port,ChannelHandler handler) throws IOException{
        super(handler, DatagramChannel.open());
        this.port = port;
    }


    @Override
    public int getInterestedOps() {
        return SelectionKey.OP_READ;
    }

    @Override
    public Object read(SelectionKey key) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketAddress send = ((DatagramChannel) key.channel()).receive(buffer);
        buffer.flip();
        DatagramPacket packet = new DatagramPacket(buffer);
        packet.setSender(send);
        return packet;
    }

    @Override
    public DatagramChannel getJavaChannel() {
        return (DatagramChannel) super.getJavaChannel();
    }

    @Override
    public void bind() throws IOException {
        getJavaChannel().socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
        getJavaChannel().configureBlocking(false);
        System.out.println("Bound UDP socket at port:" + port);
    }



    @Override
    protected void doWrite(Object pendingWrite, SelectionKey key) throws IOException {
        DatagramPacket pendingPacket = (DatagramPacket) pendingWrite;
        getJavaChannel().send(pendingPacket.getData(),pendingPacket.getReceiver());
    }

    public static class DatagramPacket {
        private SocketAddress sender;
        private final ByteBuffer data;
        private SocketAddress receiver;

        /**
         * Creates a container with underlying data.
         *
         * @param data the underlying message to be written on channel.
         */
        public DatagramPacket(ByteBuffer data) {
            this.data = data;
        }

        /**
         * Get sender address.
         *
         * @return the sender address.
         */
        public SocketAddress getSender() {
            return sender;
        }

        /**
         * Sets the sender address of this packet.
         *
         * @param sender the sender address.
         */
        public void setSender(SocketAddress sender) {
            this.sender = sender;
        }

        /**
         * Get receiver address.
         *
         * @return the receiver address.
         */
        public SocketAddress getReceiver() {
            return receiver;
        }

        /**
         * Sets the intended receiver address. This must be set when writing to the channel.
         *
         * @param receiver the receiver address.
         */
        public void setReceiver(SocketAddress receiver) {
            this.receiver = receiver;
        }

        /**
         * Get data.
         *
         * @return the underlying message that will be written on channel.
         */
        public ByteBuffer getData() {
            return data;
        }
    }
}
