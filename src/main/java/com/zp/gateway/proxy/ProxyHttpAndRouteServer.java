package com.zp.gateway.proxy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import java.util.Date;

public class ProxyHttpAndRouteServer {

    private final int bufferSize = 8092;
    private int defaultPort = 1080; //默认端口
    private int localPort ;
    private ServerSocket localServerSocket;

    public static void main(String[] args) {
        Integer port = args.length == 1 ? Integer.parseInt(args[0]) : null;
        new ProxyHttpAndRouteServer(port).startService();
    }

    public ProxyHttpAndRouteServer(Integer port){
        this.localPort = port == null ? defaultPort : port;
    }

    public void startService() {

        try {

            //开启一个ServerSocket服务器,监听请求的到来.
            localServerSocket = new ServerSocket(localPort);

            log("httpproxy server started , listen on " +localServerSocket.getInetAddress().getHostAddress()+":"+ localPort );

            // 一直监听，接收到新连接，则开启新线程去处理
            while (true) {
                Socket localSocket = localServerSocket.accept();

                //获取远程socket的地址，然后进行打印
                String addr = localSocket.getRemoteSocketAddress().toString();
                log("process one socket : %s", addr);

                try {
                    InputStream lin = localSocket.getInputStream();
                    OutputStream lout = localSocket.getOutputStream();

                    StringBuilder headStr = new StringBuilder();
                    BufferedReader br = new BufferedReader(new InputStreamReader(lin));
                    //读取HTTP请求头，并拿到HOST请求头和method

                    String line;
                    String host = "";
                    String proxy_Authorization = "";
                    while ((line = br.readLine()) != null) {
                        //打印http协议头
                        log(line);
                        headStr.append(line + "\r\n");
                        if (line.length() == 0) {
                            break;
                        } else {
                            String[] temp = line.split(" ");
                            if (temp[0].contains("Host")) {
                                host = temp[1];
                            }
                        }
                    }

                    String type = headStr.substring(0, headStr.indexOf(" "));
                    //根据host头解析出目标服务器的host和port
                    String[] hostTemp = host.split(":");
                    host = hostTemp[0];
                    int port = 80; //先设置成默认的Http端口80
                    //hostTemp的长度大于1表示用户指定了非80或443端口，解析出对应的端口出来
                    if (hostTemp.length > 1) {
                        port = Integer.valueOf(hostTemp[1]);
                    }else{
                        //端口如果没有指定，有可能是443,也有可能是80,因此尝试根据HTTP method来判断是https还是http请求,有CONNECT的是HTTPS请求，采用443端口
                        if ("CONNECT".equalsIgnoreCase(type)){
                            port = 443;
                        }
                    }

                    //连接到目标服务器
                    Socket remoteSocket = new Socket(host, port);//进行远程连接
                    InputStream rin = remoteSocket.getInputStream();
                    OutputStream rout = remoteSocket.getOutputStream();

                    //根据HTTP method来判断是https还是http请求
                    if ("CONNECT".equalsIgnoreCase(type)) {//https先建立隧道
                        lout.write("HTTP/1.1 200 Connection Established\r\n\r\n".getBytes());
                        lout.flush();
                    }else {//http直接将请求头转发
                        rout.write(headStr.toString().getBytes());
                        rout.flush();
                    }

                    try {
                        byte[] data = new byte[bufferSize];
                        int len = 0;
                        while((len = rin.read(data)) > 0){
                            if(len == bufferSize) {//读到了缓存大小一致的数据，不需要拷贝，直接使用
                                lout.write(data);
                                lout.flush();
                            }else {//读到了比缓存大小的数据，需要拷贝到新数组然后再使用
                                byte[] dest = new byte[len];
                                System.arraycopy(data, 0, dest, 0, len);
                                lout.write(dest);
                                lout.flush();
                            }
                        }
                    } catch (IOException e) {
                        //log(remoteSocket.getLocalAddress() + ":"+ remoteSocket.getPort() + " remoteSocket InputStream disconnected.");
                    } finally {

                    }

                    //设置超时，超过时间未收到客户端请求，关闭资源
                    //remoteSocket.setSoTimeout(10000);
                    //写数据,负责读取客户端发送过来的数据，转发给远程
                    byte[] data = new byte[bufferSize];
                    int len = 0;
                    while((len = lin.read(data)) > 0){
                        if(len == bufferSize) {//读到了缓存大小一致的数据，不需要拷贝，直接使用
                            rout.write(data);
                            rout.flush();
                        }else {//读到了比缓存大小的数据，需要拷贝到新数组然后再使用
                            byte[] dest = new byte[len];
                            System.arraycopy(data, 0, dest, 0, len);
                            rout.write(dest);
                            rout.flush();
                        }

                    }



                } catch (Exception e) {
                    log("exception : %s %s", e.getClass(), e.getLocalizedMessage());
                    //e.printStackTrace();
                } finally {
                    log("close socket, system cleanning ...  %s ", addr);
//                    closeIo(lin);
//                    closeIo(rin);
//                    closeIo(lout);
//                    closeIo(rout);
//                    closeIo(localSocket);
//                    closeIo(remoteSocket);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //格式化打印方法，用来打印信息
    private final void log(Object message, Object... args) {
        Date dat = new Date();
        String msg = String.format("%1$tF %1$tT %2$-5s %3$s%n", dat, Thread.currentThread().getId(), String.format(message.toString(),args));
        System.out.print(msg);
    }


}
