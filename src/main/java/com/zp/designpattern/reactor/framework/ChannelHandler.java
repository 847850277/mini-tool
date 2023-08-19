package com.zp.designpattern.reactor.framework;

import java.nio.channels.SelectionKey;

public interface ChannelHandler {
    void handleChannelRead(AbstractNioChannel channel, Object readObj, SelectionKey key);
}
