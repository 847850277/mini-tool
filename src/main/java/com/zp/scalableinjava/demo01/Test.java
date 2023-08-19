package com.zp.scalableinjava.demo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

    private static Integer PORT = 8080;

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    public static class Server implements Runnable {
        @Override
        public void run() {
            try {
                ServerSocket ss = new ServerSocket(PORT);
                while (!Thread.interrupted()) {
                    new Thread(new Handler(ss.accept())).start();
                }
            } catch (IOException ex) {
            }
        }

    }

    public static class Handler implements Runnable {

        final Socket socket;
        public Integer MAX_INPUT = 1024;

        Handler(Socket s) {
            socket = s;
        }
        @Override
        public void run() {
            try {
                byte[] input = new byte[MAX_INPUT];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) {
                /* ... */
            }
        }

        private byte[] process(byte[] cmd) {
            System.out.println(cmd);
            return cmd;
        }
    }
}
