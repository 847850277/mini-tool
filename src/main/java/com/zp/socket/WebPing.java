package com.zp.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.stream.Collectors;

public class WebPing {
    public static void main(String[] args) {

        try {
            InetAddress addr;
            Socket sock = new Socket("www.runoob.com", 80);
            addr = sock.getInetAddress();
            System.out.println("连接到 " + addr);

            /*
            InputStream inputStream = sock.getInputStream();
            String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining(System.lineSeparator()));
            System.out.println(result);
             */

            sock.close();
        } catch (Exception e) {
            System.out.println("无法连接 " + args[0]);
            System.out.println(e);
        }

    }
}
