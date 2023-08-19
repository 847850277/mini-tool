package com.zp.designpattern.reactor.app;

import com.zp.designpattern.reactor.framework.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    private NioReactor reactor;

    private final List<AbstractNioChannel> channels = new ArrayList<>();

    private final Dispatcher dispatcher;

    public App(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static void main(String[] args) throws IOException{
        new App(new ThreadPoolDispatcher(2)).start();
    }

    private void start() throws IOException {
        reactor = new NioReactor(dispatcher);
        LoggingHandler loggingHandler = new LoggingHandler();
        reactor
                .registerChannel(tcpChannel(16666, loggingHandler))
                .registerChannel(tcpChannel(16667, loggingHandler))
                .registerChannel(udpChannel(16668, loggingHandler))
                .registerChannel(udpChannel(16669, loggingHandler))
                .start();
    }

    public void stop() throws InterruptedException, IOException {
        reactor.stop();
        dispatcher.stop();
        for (AbstractNioChannel channel : channels) {
            channel.getJavaChannel().close();
        }
    }

    private AbstractNioChannel tcpChannel(int port, ChannelHandler handler) throws IOException{
        NioServerSocketChannel channel = new NioServerSocketChannel(port, handler);
        channel.bind();
        channels.add(channel);
        return channel;
    }

    private AbstractNioChannel udpChannel(int port, ChannelHandler handler) throws IOException{
        NioDatagramChannel channel = new NioDatagramChannel(port, handler);
        channel.bind();
        channels.add(channel);
        return channel;
    }
}
