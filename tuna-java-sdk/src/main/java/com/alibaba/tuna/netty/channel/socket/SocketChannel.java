/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.alibaba.tuna.netty.channel.socket;

import java.net.InetSocketAddress;
import java.net.Socket;

import com.alibaba.tuna.netty.channel.Channel;
import com.alibaba.tuna.netty.channel.ChannelFuture;
import com.alibaba.tuna.netty.channel.ChannelPromise;

/**
 * A TCP/IP socket {@link Channel}.
 */
public interface SocketChannel extends Channel {
    @Override
    ServerSocketChannel parent();

    @Override
    SocketChannelConfig config();
    @Override
    InetSocketAddress localAddress();
    @Override
    InetSocketAddress remoteAddress();

    /**
     * Returns {@code true} if and only if the remote peer shut down its output so that no more
     * data is received from this channel.  Note that the semantic of this method is different from
     * that of {@link Socket#shutdownInput()} and {@link Socket#isInputShutdown()}.
     */
    boolean isInputShutdown();

    /**
     * @see Socket#isOutputShutdown()
     */
    boolean isOutputShutdown();

    /**
     * @see Socket#shutdownOutput()
     */
    ChannelFuture shutdownOutput();

    /**
     * @see Socket#shutdownOutput()
     *
     * Will notify the given {@link ChannelPromise}
     */
    ChannelFuture shutdownOutput(ChannelPromise future);
}
