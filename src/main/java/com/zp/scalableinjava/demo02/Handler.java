package com.zp.scalableinjava.demo02;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Handler implements Runnable{
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

    void read() throws IOException {
        socket.read(input);
        if (inputIsComplete()) {
            process();
            state = SENDING;
            // Normally also do first write now
            sk.interestOps(SelectionKey.OP_WRITE);
        }
    }
    void send() throws IOException {
        socket.write(output);
        if (outputIsComplete()) sk.cancel();
    }

    /**
     * 下面是基于GoF状态对象模式对Handler类的一个优化实现，不需要再进行状态的判断。
     */
    
    /*
    @Override
    public void run() { // initial state is reader
        try {
            socket.read(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (inputIsComplete()) {
            process();
            sk.attach(new Sender());
            sk.interestOps(SelectionKey.OP_WRITE);
            sk.selector().wakeup();
        }
    }





    class Sender implements Runnable {
        public void run(){ // ...
            try {
                socket.write(output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (outputIsComplete()) sk.cancel();
        }
    }

     */
}
