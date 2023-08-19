package com.zp.designpattern.reactor.app;

import com.zp.designpattern.reactor.framework.AbstractNioChannel;
import com.zp.designpattern.reactor.framework.ChannelHandler;
import com.zp.designpattern.reactor.framework.NioDatagramChannel;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

public class LoggingHandler implements ChannelHandler {

    private static final byte[] ACK = "Data logged successfully".getBytes();


    @Override
    public void handleChannelRead(AbstractNioChannel channel, Object readObj, SelectionKey key) {
        if(readObj instanceof ByteBuffer){
            doLogging((ByteBuffer)readObj);
            sendReply(channel, key);
        }else if(readObj instanceof NioDatagramChannel.DatagramPacket){
            NioDatagramChannel.DatagramPacket datagramPacket = (NioDatagramChannel.DatagramPacket) readObj;
            doLogging(datagramPacket.getData());
            sendReply(channel,datagramPacket,key);
        }else {
            throw new IllegalStateException("unknown data received");
        }
    }

    private void sendReply(AbstractNioChannel channel, NioDatagramChannel.DatagramPacket incomingPacket, SelectionKey key) {
        NioDatagramChannel.DatagramPacket replyPacket = new NioDatagramChannel.DatagramPacket(ByteBuffer.wrap(ACK));
        replyPacket.setReceiver(incomingPacket.getSender());
        channel.write(replyPacket,key);
    }

    private void sendReply(AbstractNioChannel channel, SelectionKey key) {
        ByteBuffer buffer = ByteBuffer.wrap(ACK);
        channel.write(buffer,key);
    }

    private void doLogging(ByteBuffer data) {
        System.out.println(new String(data.array(),0,data.limit()));
    }
}
