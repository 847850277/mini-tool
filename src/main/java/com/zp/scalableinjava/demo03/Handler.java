package com.zp.scalableinjava.demo03;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Handler implements Runnable{

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;


    // uses util.concurrent thread pool
    static ThreadPoolExecutor pool = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy());

    static final int PROCESSING = 3;


    final SocketChannel socket;
    final SelectionKey sk;
    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);
    static final int READING = 0, SENDING = 1;
    int state = READING;

    Handler(Selector sel, SocketChannel c) throws IOException {
        socket = c;
        c.configureBlocking(false);
        // Optionally try first read now
        sk = socket.register(sel, 0);
        sk.attach(this); //将Handler绑定到SelectionKey上
        sk.interestOps(SelectionKey.OP_READ);
        sel.wakeup();
    }
    boolean inputIsComplete() { /* ... */
        return false;
    }
    boolean outputIsComplete() { /* ... */
        return false;
    }
    void process() { /* ... */ }

    /**
     * 这是Handler处理类
     */
    /**/
    @Override
    public void run() {
        try {
            if (state == READING) read();
            else if (state == SENDING) send();
        } catch (IOException ex) {  }
    }

    synchronized void read() throws IOException {
        socket.read(input);
        if (inputIsComplete()) {
//            process();
//            state = SENDING;
//            // Normally also do first write now
//            sk.interestOps(SelectionKey.OP_WRITE);

            state = PROCESSING;
            pool.execute(new Processer());
        }
    }
    void send() throws IOException {
        socket.write(output);
        if (outputIsComplete()) sk.cancel();
    }

    synchronized void processAndHandOff() {
        process();
        state = SENDING; // or rebind attachment
        sk.interestOps(SelectionKey.OP_WRITE);
    }

    class Processer implements Runnable {
        public void run() { processAndHandOff(); }
    }

}
