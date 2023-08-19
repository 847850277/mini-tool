package com.zp.designpattern.reactor.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppClient {

    private final ExecutorService service = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        AppClient appClient = new AppClient();
        appClient.start();
    }

    private void start() throws IOException {
        System.out.println("Starting logging clients");
        service.execute(new TcpLoggingClient("Client 1", 16666));
        service.execute(new TcpLoggingClient("Client 2", 16667));
        service.execute(new UdpLoggingClient("Client 3", 16668));
        service.execute(new UdpLoggingClient("Client 4", 16669));
    }

    private static void artificialDelayOf(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted" + e.getMessage());
        }
    }

    public void stop() {
        service.shutdown();
        if (!service.isTerminated()) {
            service.shutdownNow();
            try {
                service.awaitTermination(1000, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.out.println("exception awaiting termination" +  e.getMessage());
            }
        }
        System.out.println("Logging clients stopped");
    }

    static class TcpLoggingClient implements Runnable{

        private final int serverPort;
        private final String clientName;

        public TcpLoggingClient(String clientName,int serverPort) {
            this.serverPort = serverPort;
            this.clientName = clientName;
        }

        @Override
        public void run() {
            try {
                Socket socket = new Socket(InetAddress.getLocalHost(), serverPort);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                sendLogRequests(printWriter,socket.getInputStream());
            }catch (IOException e) {
                System.out.println("error sending requests" + e.getMessage());
                throw new RuntimeException(e);
            }

        }

        private void sendLogRequests(PrintWriter writer, InputStream inputStream) throws IOException {
//            int i = 0;
//            while (true){
//                writer.println(clientName + "- Log request:" + i);
//                writer.flush();
//                byte[] data = new byte[1024];
//                int read = inputStream.read(data, 0, data.length);
//                if(read == 0){
//                    System.out.println("read zero bytes");
//                }else {
//                    System.out.println(new String(data, 0,read));
//                }
//                artificialDelayOf(1000);
//                i++;
//            }
            for (int i = 0; i < 4; i++) {
                writer.println(clientName + "- Log request:" + i);
                writer.flush();
                byte[] data = new byte[1024];
                int read = inputStream.read(data, 0, data.length);
                if(read == 0){
                    System.out.println("read zero bytes");
                }else {
                    System.out.println(new String(data, 0,read));
                }
                artificialDelayOf(100);
            }
        }
    }

    static class UdpLoggingClient implements Runnable{

        private final String clientName;

        private final InetSocketAddress remoteAddress;

        public UdpLoggingClient(String clientName, int port) throws UnknownHostException{
            this.clientName = clientName;
            this.remoteAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
        }

        @Override
        public void run() {
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                for (int i = 0; i < 4; i++) {
                    String message = clientName + " - Log request: " + i;
                    byte[] bytes = message.getBytes();
                    DatagramPacket request = new DatagramPacket(bytes, bytes.length, remoteAddress);
                    datagramSocket.send(request);
                    byte[] data = new byte[1024];
                    DatagramPacket reply = new DatagramPacket(data, data.length);
                    datagramSocket.receive(reply);
                    if(reply.getLength() == 0){
                        System.out.println("Read zero bytes");
                    }else {
                        System.out.println(new String(reply.getData(),0,reply.getLength()));
                    }
                    artificialDelayOf(100);
                }
            }catch (IOException e) {
                System.out.println("error sending packets" + e.getMessage());
            }
        }
    }

}
