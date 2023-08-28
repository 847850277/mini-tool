# reactor-netty-中文翻译

## 2 开始

- 本节包含的信息应该有助于您开始使用reatcor-netty,它包括以下信息
  - 介绍reatcor-netty
  - reatcor-netty依赖环境
  - 了解 BOM 和版本管理方案
  - 开始reatcor-netty


2.1 介绍reatcor-netty

reactor-netty 适用于微服务架构，它为`HTTP`,`TCP`,`UDP`提供了`backpressure-ready network engines`. 


2.2 reatcor-netty依赖环境

它运行的最低版本为JAVA8,依赖了以下的jar包

- Reactive Streams v1.0.4
- Reactor Core v3.x
- Netty v4.1.x


2.3 其他版本环境以及如何依赖的介绍，开始使用reatcor-netty，省略翻译，直接官方文档



## 3 TCP 服务

`Reactor Netty` 提供了容易使用且方便配置的`TcpServer`,它封装了`Netty`如何创建`TCP`服务,同时增加了
`Reactive Streams` backpressure.


3.1 起停


为了启动一个`TCP`服务,你必须创建和配置`TcpServer`实例，同时，你需要配置ip和端口。当调用`bind`操作的时候，若
你没有指定端口，那系统会绑定一个临时端口来启动`TcpServer`。

```java

import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				TcpServer.create()   
				         .bindNow(); 

		server.onDispose()
		      .block();
	}
}

```

- 根据你的配置来创建`TcpServer`
- 以阻塞方式启动服务器并等待它完成初始化。


`DisposableServer`对象提供了一些方便使用的API,包括`disposeNow()`,它以阻塞方式关闭服务器。


3.1.1 ip和端口

如果你想自定义ip和端口，你可以在运行的时候去指定它。

```java

import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				TcpServer.create()
				         .host("localhost") 
				         .port(8080)        
				         .bindNow();

		server.onDispose()
		      .block();
	}
}


```


要在多个地址上服务，在配置了 `TcpServer` 之后，您可以多次绑定它以获得单独的 `DisposableServer`。
所有创建的服务器将共享诸如`LoopResources`之类的资源，因为它们在底层使用相同的配置实例。

```java

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class MultiAddressApplication {

	public static void main(String[] args) {
		TcpServer tcpServer = TcpServer.create();
		DisposableServer server1 = tcpServer
				.host("localhost") 
				.port(8080)        
				.bindNow();

		DisposableServer server2 = tcpServer
				.host("0.0.0.0") 
				.port(8081)      
				.bindNow();

		Mono.when(server1.onDispose(), server2.onDispose())
				.block();
	}
}

```

3.2 热初始化

当你想在启动的时候预配置一些配置的时候，很方便的配置。可配置的项目有
- 事件循环组
- 本机传输库(当使用本机传输时)
- 用于安全性的本机库(对于 OpenSsl)


```java

import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class Application {

	public static void main(String[] args) {
		TcpServer tcpServer =
				TcpServer.create()
				         .handle((inbound, outbound) -> inbound.receive().then());

		tcpServer.warmup() 
		         .block();

		DisposableServer server = tcpServer.bindNow();

		server.onDispose()
		      .block();
	}
}

```

3.3 写数据

为了向已连接的客户端发送数据，必须附加 I/O 处理程序。
I/O 处理程序可以访问 `NettyOutbound` 以便能够写入数据。下面的示例演示如何附加 I/O 处理程序。

```java

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				TcpServer.create()
				         .handle((inbound, outbound) -> outbound.sendString(Mono.just("hello"))) 
				         .bindNow();

		server.onDispose()
		      .block();
	}
}


```

3.4 读数据

为了从已连接的客户端接收数据，必须附加 I/O 处理程序。
I/O 处理程序可以访问 `NettyInbound` 来读取数据。下面的示例演示如何使用它:


3.5 生命周期回调

为了扩展 TcpServer，提供了以下生命周期回调

- doOnBind  当服务器通道即将绑定时调用。
- doOnBound 在绑定服务器通道时调用。
- doOnChannelInit 初始化通道时调用。
- doOnConnection 连接远程客户端时调用
- doOnUnbound 当服务器通道未绑定时调用。

下面的示例使用 `doOnConnection` 和 `doOnChannelInit` 回调:

```java

import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				TcpServer.create()
				         .doOnConnection(conn ->
				             conn.addHandlerFirst(new ReadTimeoutHandler(10, TimeUnit.SECONDS))) 
				         .doOnChannelInit((observer, channel, remoteAddress) ->
				             channel.pipeline()
				                    .addFirst(new LoggingHandler("reactor.netty.examples")))     
				         .bindNow();

		server.onDispose()
		      .block();
	}
}

```

- 当连接远程客户端时，使用 ReadTimeoutHandler 扩展 Netty 管道。
- 在初始化通道时，使用 LoggingHandler 扩展 Netty 管道。


3.6 TCP-级别 配置

本节描述可以在 TCP 级别使用的三种配置:
- 设置`Channel`选项
- 线路记录配置
- 事件循环组


3.6.1 设置`Channel`选项


默认情况下，TCP 服务器配置为以下选项:

```java

TcpServerBind() {
	Map<ChannelOption<?>, Boolean> childOptions = new HashMap<>(MapUtils.calculateInitialCapacity(2));
	childOptions.put(ChannelOption.AUTO_READ, false);
	childOptions.put(ChannelOption.TCP_NODELAY, true);
	this.config = new TcpServerConfig(
			Collections.singletonMap(ChannelOption.SO_REUSEADDR, true),
			childOptions,
			() -> new InetSocketAddress(DEFAULT_PORT));
}
```

如果需要其他选项或需要更改当前选项，可以应用以下配置:

```java

import io.netty.channel.ChannelOption;
import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				TcpServer.create()
				         .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
				         .bindNow();

		server.onDispose()
		      .block();
	}
}

```

你可以通过以下连接找到更多关于`Netty channel`的配置

- [Common ChannelOption](https://netty.io/4.1/api/io/netty/channel/ChannelOption.html)
- [Epoll ChannelOption](https://netty.io/4.1/api/io/netty/channel/epoll/EpollChannelOption.html)
- [KQueue ChannelOption](https://netty.io/4.1/api/io/netty/channel/kqueue/KQueueChannelOption.html)
- [Socket Options](https://docs.oracle.com/javase/8/docs/technotes/guides/net/socketOpt.html)


3.6.2 线路记录配置

当需要检查对等点之间的通信时，reactor-netty提供有线记录。默认情况下，禁用有线日志记录。
要启用它，必须设置 `logger reactor.netty.tcp`。将 `TcpServer` 级别设置为 `DEBUG` 并应用以下配置:
有三种配置方式，具体请参见官方文档。

```java

import reactor.netty.DisposableServer;
import reactor.netty.tcp.TcpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				TcpServer.create()
				         .wiretap(true) 
				         .bindNow();

		server.onDispose()
		      .block();
	}
}

```


3.6.3 事件循环组

默认情况下，TCP 服务器使用`Event Loop Group`，
其中工作线程的数量等于初始化时运行时可用的处理器数量(但最小值为4)。
当需要不同的配置时，可以使用` LoopResource # create `。

事件循环组的默认配置如下:

```java

./../../reactor-netty-core/src/main/java/reactor/netty/ReactorNetty.java


        **
        * Default worker thread count, fallback to available processor
        * (but with a minimum value of 4)
        */
public static final String IO_WORKER_COUNT = "reactor.netty.ioWorkerCount";
/**
 * Default selector thread count, fallback to -1 (no selector thread)
 * <p><strong>Note:</strong> In most use cases using a worker thread also as a selector thread works well.
 * A possible use case for specifying a separate selector thread might be when the worker threads are too busy
 * and connections cannot be accepted fast enough.
 * <p><strong>Note:</strong> Although more than 1 can be configured as a selector thread count, in reality
 * only 1 thread will be used as a selector thread.
 */
public static final String IO_SELECT_COUNT = "reactor.netty.ioSelectCount";
/**
 * Default worker thread count for UDP, fallback to available processor
 * (but with a minimum value of 4)
 */
public static final String UDP_IO_THREAD_COUNT = "reactor.netty.udp.ioThreadCount";
/**
 * Default quiet period that guarantees that the disposal of the underlying LoopResources
 * will not happen, fallback to 2 seconds.
 */
public static final String SHUTDOWN_QUIET_PERIOD = "reactor.netty.ioShutdownQuietPeriod";
/**
 * Default maximum amount of time to wait until the disposal of the underlying LoopResources
 * regardless if a task was submitted during the quiet period, fallback to 15 seconds.
 */
public static final String SHUTDOWN_TIMEOUT = "reactor.netty.ioShutdownTimeout";

/**
 * Default value whether the native transport (epoll, kqueue) will be preferred,
 * fallback it will be preferred when available
 */
public static final String NATIVE = "reactor.netty.native";

```


如果需要更改这些设置，可以应用以下配置:

```java

import reactor.netty.DisposableServer;
import reactor.netty.resources.LoopResources;
import reactor.netty.tcp.TcpServer;

public class Application {

  public static void main(String[] args) {
    LoopResources loop = LoopResources.create("event-loop", 1, 4, true);

    DisposableServer server =
            TcpServer.create()
                    .runOn(loop)
                    .bindNow();

    server.onDispose()
            .block();
  }
}


```


3.7 SSL and TLS 略，参见官方文档


3.8 指标 略，参见官方文档

3.9 追溯 略，参见官方文档


## 4 TCP 客户端


`Reactor Netty` 提供了易于使用和配置的 TcpClient。它封装了 `TCP` 客户端所需的大部分 Netty 功能，
并添加了 `Reactive Streams backpressure`。


4.1 连接和断连

若要将 `TCP` 客户端连接到给定的端点，必须创建和配置 `TcpClient` 实例。默认情况下，主机是 localhost，端口是12012。下面的示例演示如何创建 TcpClient

```java


import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

public class Application {

    public static void main(String[] args) {

        /**  默认端口为12012

        Connection connection =
                TcpClient.create()
                        .connectNow();

        connection.onDispose()
                .block();
         */

        Connection connection =
                TcpClient.create()
                        .port(8080)
                        .host("localhost")
                        .connectNow();

        connection.onDispose()
                .block();
    }

}


```


4.2 热初始化


默认情况下，`TcpClient` 资源的初始化是按需进行的。这意味着连接操作吸收了初始化和加载所需的额外时间:
- 事件循环组
- 主机名解析器
- 本机传输库(当使用本机传输时)
- 用于安全性的本机库(对于 OpenSsl)


当需要预加载这些资源时，可以按照以下方式配置 TcpClient:

```java

import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

public class Application {

    public static void main(String[] args) {
        TcpClient tcpClient =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .handle((inbound, outbound) -> outbound.sendString(Mono.just("hello client")));

        tcpClient.warmup()
                .block();

        Connection connection = tcpClient.connectNow();

        connection.onDispose()
                .block();
    }

}

```

- 为安全性初始化并加载事件循环组、主机名解析器、本机传输库和本机库
- 连接到远程对等机时发生主机名解析



4.3 发送数据

要向给定端点发送数据，必须附加 I/O 处理程序。I/O 处理程序可以访问 `NettyOutbound` 以便能够写入数据。


发送 `hello client` 到连接的服务端点

```java

import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
public class Application {

    public static void main(String[] args) {
        Connection connection =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .handle((inbound, outbound) -> outbound.sendString(Mono.just("hello client")))
                        .connectNow();

        connection.onDispose()
                .block();
    }

}

```


当你需要对写入过程进行更多的控制时，作为 I/O 处理程序的替代方案，
你可以使用 `Connection # outbound`。在 I/O 处理程序中，当所提供的发布服务器完成时(对于有限的发布服务器)连接被关闭，
而在使用 `Connection # outbound` 时，必须显式调用 `Connection # pose` 来关闭连接。


```java

import reactor.core.publisher.Mono;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
public class Application {

    public static void main(String[] args) {
        Connection connection =
                TcpClient.create()
                        .host("localhost")
                        .port(8080)
                        .connectNow();

        connection.outbound()
                .sendString(Mono.just("hello 1"))
                .then()
                .subscribe();

        connection.outbound()
                .sendString(Mono.just("hello 2"))
                .then()
                .subscribe(null, null, connection::dispose);

        connection.onDispose()
                .block();
    }

}


```

- 发送 `Hello 1`字符串到服务器端点
- 发送 `Hello 2`字符串到服务器端点
- 将消息发送到端点后关闭连接


4.4 接收数据

从给定端点接收数据时，必须附加一个 I/O 处理程序。I/O 处理程序可以访问 `NettyInbound` 来读取数据。下面的示例说明如何做到这一点:

```java

import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

public class Application {

	public static void main(String[] args) {
		Connection connection =
				TcpClient.create()
				         .host("example.com")
				         .port(80)
				         .handle((inbound, outbound) -> inbound.receive().then()) 
				         .connectNow();

		connection.onDispose()
		          .block();
	}
}

```


当您需要对读取过程进行更多的控制时，作为 I/O 处理程序的替代方案，您可以使用 `Connection # inbound`。与所提供的发布服务器完成时连接关闭的 I/O 处理程序(对于有限的发布服务器)不同，在使用 `Connection # inbound` 的時候，您必須明確地调用 `Connection # dispose` 以便关闭连接。

```java

import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

public class Application {

	public static void main(String[] args) {
		Connection connection =
				TcpClient.create()
				         .host("example.com")
				         .port(80)
				         .connectNow();

		connection.inbound()
		          .receive() 
		          .then()
		          .subscribe();

		connection.onDispose()
		          .block();
	}
}

```


4.5 生命周期回调

下面提供的生命周期回调允许你扩展 TcpClient。
- doAfterResolve 在成功解析远程地址后调用。
- doOnChannelInit 初始化通道时调用。
- doOnConnect 当通道即将连接时调用。
- doOnConnected 连接通道后调用。
- doOnDisconnected 在断开通道之后调用。
- doOnResolve 在即将解析远程地址时调用。
- doOnResolveError 在远程地址未被成功解析时调用。


下面的示例使用 `doOnConnected` 和 `doOnChannelInit` 回调:

```java

import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) {
		Connection connection =
				TcpClient.create()
				         .host("example.com")
				         .port(80)
				         .doOnConnected(conn ->
				             conn.addHandlerFirst(new ReadTimeoutHandler(10, TimeUnit.SECONDS))) 
				         .doOnChannelInit((observer, channel, remoteAddress) ->
				             channel.pipeline()
				                    .addFirst(new LoggingHandler("reactor.netty.examples")))     
				         .connectNow();

		connection.onDispose()
		          .block();
	}
}

```

- 当通道已连接时，使用 `ReadTimeoutHandler` 扩展 Netty 管道。
- 在初始化通道时，使用 `LoggingHandler` 扩展 Netty 管道。


4.6 配置项

本节描述可以在 TCP 级别使用的三种配置:
- `Channel`选项配置
- 线路记录配置
- 事件循环组


4.6.1. `Channel` 选择配置


默认情况下，TCP 客户端配置为以下选项:

```java

./../../reactor-netty-core/src/main/java/reactor/netty/tcp/TcpClientConnect.java


        this.config = new TcpClientConfig(
        provider,
        Collections.singletonMap(ChannelOption.AUTO_READ, false),
        () -> AddressUtils.createUnresolved(NetUtil.LOCALHOST.getHostAddress(), DEFAULT_PORT));
}


```

如果需要其他选项或需要更改当前选项，可以应用以下配置:

```java

import io.netty.channel.ChannelOption;
import reactor.netty.Connection;
import reactor.netty.tcp.TcpClient;

public class Application {

	public static void main(String[] args) {
		Connection connection =
				TcpClient.create()
				         .host("example.com")
				         .port(80)
				         .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
				         .connectNow();

		connection.onDispose()
		          .block();
	}
}

```

你可以通过以下连接找到更多关于`Netty channel`的配置

- [Common ChannelOption](https://netty.io/4.1/api/io/netty/channel/ChannelOption.html)
- [Epoll ChannelOption](https://netty.io/4.1/api/io/netty/channel/epoll/EpollChannelOption.html)
- [KQueue ChannelOption](https://netty.io/4.1/api/io/netty/channel/kqueue/KQueueChannelOption.html)
- [Socket Options](https://docs.oracle.com/javase/8/docs/technotes/guides/net/socketOpt.html)


4.6.2. 线路记录配置 略 参考官网


4.6.3. 事件循环组 同server配置


4.7 连接池


默认情况下，`TcpClient` 使用一个`fixed`连接池，
其中`500`作为活动通道的最大数量，`1000`作为允许保持挂起状态的进一步通道获取尝试的最大数量(对于其余的配置，请检查系统属性或下面的构建器配置)。
这意味着，如果有人试图获取一个通道，只要创建的通道少于`500`个，并且由池管理，那么该实现就会创建一个新通道。
当池中的通道数达到最大值时，多达`1000`次获取通道的新尝试被延迟(挂起) ，直到一个通道关闭(因此一个时隙是空闲的，可以打开一个新连接) ，进一步的尝试被拒绝，并出现错误。

`TcpClient` 使用的连接从不返回到池，而是关闭。当连接关闭时，池中将释放一个槽，因此在需要时可以打开一个新连接。
这种行为只针对 `TcpClient`，并且是有意为之的，因为只有用户/框架知道实际的协议是否与重用连接兼容。(与 HttpClient 相反，HttpClient 的协议是已知的，`Reactor Netty` 可以在可能的情况下返回到池的连接)。

参见官网

- 使用连接池的方式
- 不使用连接池的方式


4.8. SSL and TLS 略

4.9. 代理支持 略



## 5 HTTP 服务

`Reactor Netty` 提供了易于使用和配置的 `HttpServer` 类。它隐藏了创建 HTTP 服务器所需的大部分 Netty 功能，并添加了 `Reactive Streams backpressure`。



5.1. 开始和停止

若要启动 `HTTP` 服务器，必须创建和配置 `HttpServer` 实例。默认情况下，主机配置为任何本地地址，当调用绑定操作时，系统会获取一个临时端口。
下面的示例演示如何创建 `HttpServer` 实例:


```java

import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()   
				          .bindNow(); 

		server.onDispose()
		      .block();
	}
}

```


- 创建一个准备配置的 HttpServer 实例。
- 以阻塞方式启动服务器并等待它完成初始化。

返回的 `DisposableServer` 封装了方便使用的服务器 API，包括 disposeNow () ，它以阻塞的方式关闭服务器。


5.1.1. ip和端口

要在特定的主机和端口上服务，可以对 HTTP 服务器应用以下配置:

```java

import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()
				          .host("localhost") 
				          .port(8080)        
				          .bindNow();

		server.onDispose()
		      .block();
	}
}

```


为了在多个地址上服务，在配置了 `HttpServer` 之后，您可以多次绑定它以获得单独的 `DisposableServer`。
所有创建的服务器将共享诸如 `LoopResources`之类的资源，因为它们在底层使用相同的配置实例

```java

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class MultiAddressApplication {
	public static void main(String[] args) {
		HttpServer httpServer = HttpServer.create();
		DisposableServer server1 = httpServer
				.host("localhost") 
				.port(8080)        
				.bindNow();

		DisposableServer server2 = httpServer
				.host("0.0.0.0") 
				.port(8081)      
				.bindNow();

		Mono.when(server1.onDispose(), server2.onDispose())
				.block();
	}
}


```


5.2. 热初始化


默认情况下，`HttpServer` 资源的初始化是按需进行的。这意味着绑定操作吸收了初始化和加载所需的额外时间:

- 事件循环组
- 本机传输库(当使用本机传输时)
- 用于安全性的本机库(对于 OpenSsl)


当需要预加载这些资源时，可以按照以下方式配置 `HttpServer`:

```java


import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		HttpServer httpServer =
				HttpServer.create()
				          .handle((request, response) -> request.receive().then());

		httpServer.warmup() 
		          .block();

		DisposableServer server = httpServer.bindNow();

		server.onDispose()
		      .block();
	}
}


```


5.3. 路由http

定义 HTTP 服务器的路由需要配置提供的 `HttpServerRoutes` 生成器:服务器路由是唯一的，并且只调用按声明顺序排列的第一个匹配。


```java

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()
				          .route(routes ->
				              routes.get("/hello",        
				                        (request, response) -> response.sendString(Mono.just("Hello World!")))
				                    .post("/echo",        
				                        (request, response) -> response.send(request.receive().retain()))
				                    .get("/path/{param}", 
				                        (request, response) -> response.sendString(Mono.just(request.param("param"))))
				                    .ws("/ws",            
				                        (wsInbound, wsOutbound) -> wsOutbound.send(wsInbound.receive().retain())))
				          .bindNow();

		server.onDispose()
		      .block();
	}
}


```

5.3.1. 服务端发送事件

下面的代码显示如何配置 HTTP 服务器以服务 `服务端发送事件`:
需要依赖jackson


```java

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>



import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.function.BiFunction;

public class Application {

  public static void main(String[] args) {
    DisposableServer server =
            HttpServer.create()
                    .route(routes -> routes.get("/sse", serveSse()))
                    .bindNow();

    server.onDispose()
            .block();
  }

  /**
   * Prepares SSE response
   * The "Content-Type" is "text/event-stream"
   * The flushing strategy is "flush after every element" emitted by the provided Publisher
   */
  private static BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>> serveSse() {
    Flux<Long> flux = Flux.interval(Duration.ofSeconds(10));
    return (request, response) ->
            response.sse()
                    .send(flux.map(Application::toByteBuf), b -> true);
  }

  /**
   * Transforms the Object to ByteBuf following the expected SSE format.
   */
  private static ByteBuf toByteBuf(Object any) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try {
      out.write("data: ".getBytes(Charset.defaultCharset()));
      MAPPER.writeValue(out, any);
      out.write("\n\n".getBytes(Charset.defaultCharset()));
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
    return ByteBufAllocator.DEFAULT
            .buffer()
            .writeBytes(out.toByteArray());
  }

  private static final ObjectMapper MAPPER = new ObjectMapper();
}


```


5.3.2. 静态资源，略 参见官网


5.4. 发送数据


要向已连接的客户端发送数据，必须使用 `handle (...)`或 `route (...)`附加 I/O 处理程序。
I/O 处理程序可以访问 `HttpServerResponse`，以便能够写入数据。下面的示例使用 `handle (...)`方法


```java

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()
				          .handle((request, response) -> response.sendString(Mono.just("hello"))) 
				          .bindNow();

		server.onDispose()
		      .block();
	}
}


```


5.4.1. 返回`Headers` 和其他元数据

当你向连接的客户端发送数据时，可能需要发送其他头、 cookie、状态代码和其他元数据。
可以使用 `HttpServerResponse` 提供此附加元数据。下面的示例演示如何这样做

```java

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()
				          .route(routes ->
				              routes.get("/hello",
				                  (request, response) ->
				                      response.status(HttpResponseStatus.OK)
				                              .header(HttpHeaderNames.CONTENT_LENGTH, "12")
				                              .sendString(Mono.just("Hello World!"))))
				          .bindNow();

		server.onDispose()
		      .block();
	}
}


```


5.4.2. 压缩响应

你可以配置 HTTP 服务器发送压缩响应，具体取决于请求头 Accept-Encoding。具体参见官网。



5.5. 接收数据

要从已连接的客户端接收数据，必须使用 `handle (...)`或 `route (...)`附加 I/O 处理程序。
I/O 处理程序可以访问 `HttpServerRequest`，以便能够读取数据。

```java

import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()
				          .handle((request, response) -> request.receive().then()) 
				          .bindNow();

		server.onDispose()
		      .block();
	}
}

```


5.5.1. 接收 `Headers`, `URI Params`, 和其他 ` Metadata`

从连接的客户端接收数据时，可能需要检查请求头、参数和其他元数据。
可以通过使用 `HttpServerRequest` 获取此附加元数据。下面的示例说明如何做到这一点:

```java

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()
				          .route(routes ->
				              routes.get("/{param}",
				                  (request, response) -> {
				                      if (request.requestHeaders().contains("Some-Header")) {
				                          return response.sendString(Mono.just(request.param("param")));
				                      }
				                      return response.sendNotFound();
				                  }))
				          .bindNow();

		server.onDispose()
		      .block();
	}
}


```


5.5.2. 文件上传


当从连接的客户机接收数据时，可能需要访问 POST 表单`(application/x-www-form-urlencode)`或多部分`(multipart/form-data)`数据。
可以使用 `HttpServerRequest` 获取此数据。具体参见官网。


获取连接客户端的地址


5.5.3. HTTP 请求解码器

默认情况下，Netty 为传入请求配置一些限制，具体参见官网例如:
- 初始行的最大长度。 
- 所有标头的最大长度。 
- 内容或每个块的最大长度。


5.6. 生命周期回调

为了扩展 HttpServer，提供了以下生命周期回调:
- doOnBind 当服务器通道即将绑定时调用。
- doOnBound 在绑定服务器通道时调用。
- doOnChannelInit 初始化通道时调用。
- doOnConnection 连接远程客户端时调用
- doOnUnbound 当服务器通道未绑定时调用。

下面的示例使用 doOnConnection 和 doOnChannelInit 回调:

```java

import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) {
		DisposableServer server =
				HttpServer.create()
				          .doOnConnection(conn ->
				              conn.addHandlerFirst(new ReadTimeoutHandler(10, TimeUnit.SECONDS))) 
				          .doOnChannelInit((observer, channel, remoteAddress) ->
				              channel.pipeline()
				                     .addFirst(new LoggingHandler("reactor.netty.examples")))    
				          .bindNow();

		server.onDispose()
		      .block();
	}
}

```

5.7. TCP 级别配置 略，参见官网

5.8. SSL and TLS 略，参见官网

5.9. HTTP Access Log 略，参见官网

5.10. HTTP/2 略，参见官网

5.11. Metrics 略，参见官网

5.12. Tracing 略，参见官网

5.13. Unix Domain Sockets 略，参见官网

5.14. Timeout Configuration 略，参见官网

## 6 HTTP 客户端 略，参见官网