package ru.isaevisa05.nra.components;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    private final ServerBootstrap server = new ServerBootstrap();
    private final NioEventLoopGroup parentGroup = new NioEventLoopGroup();
    private final NioEventLoopGroup childGroup = new NioEventLoopGroup();
    private final String ip;
    private final int port;

    public Server(int port) {
        this.ip = "0.0.0.0";
        this.port = port;
        NIOBuilder.build(parentGroup, childGroup);
        ServerBuilder();
    }

    public void ServerBuilder() {
        server.group(parentGroup, childGroup);
        server.channel(NioServerSocketChannel.class);
        server.childHandler(new Handler());
    }
}

class NIOBuilder {
    public static void build(NioEventLoopGroup parentGroup, NioEventLoopGroup childGroup) {
        parentGroup = new NioEventLoopGroup();
        childGroup = new NioEventLoopGroup();
    }

    public static void build(NioEventLoopGroup parentGroup, NioEventLoopGroup childGroup, int parentThreads) {
        parentGroup = new NioEventLoopGroup(parentThreads);
        childGroup = new NioEventLoopGroup();
    }

    public static void build(NioEventLoopGroup parentGroup, NioEventLoopGroup childGroup, int parentThreads, int childThreads) {
        parentGroup = new NioEventLoopGroup(parentThreads);
        childGroup = new NioEventLoopGroup(childThreads);
    }
}
