package com.zp.gateway.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ProxyHttpsServerTest {
    public static void main(String[] args) {

        //设置代理服务器的ip和端口
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080));
        //String api = "https://www.baidu.com";
        String api = "http://127.0.0.1:8002/helloWorld?name=123";
        HttpURLConnection connection = null;
        InputStream in = null;
        BufferedReader reader = null;
        try {
            //构造一个URL对象
            URL url = new URL(api);
            //获取URLConnection对象
            connection = (HttpURLConnection) url.openConnection(proxy);
            //getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法，所以在开发中不调用connect()也可以)
            in = connection.getInputStream();
            //通过InputStreamReader将字节流转换成字符串，在通过BufferedReader将字符流转换成自带缓冲流
            reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line = null;
            //按行读取
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String response = sb.toString();
            System.out.println(response);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
