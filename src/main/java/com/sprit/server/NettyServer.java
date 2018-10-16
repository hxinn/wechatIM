package com.sprit.server;

import com.sprit.server.handler.FirstServerHandler;
import com.sprit.server.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author: xiaohuaxin
 * @Description: netty 服务端
 * @Date: Created in 2018/10/15
 * @return
 */
public class NettyServer {

    public static void main(String[] args) {
        //处理链接
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        //处理读写操作
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        //引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap
                //1.配置线程组
                //2.指定IO模型
                //3.配置TCP参数，握手字符串长度设置
                //4.心跳
                //5.是否开启Nagle算法，true表示关闭，false表示开启，
                //  通俗地说，如果要求高实时性，有数据发送时就马上发送，就关闭，如果需要减少发送次数减少网络交互，就开启。
                .group(boosGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childOption(ChannelOption.TCP_NODELAY,true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) throws Exception {
                        channel.pipeline().addLast(new ServerHandler());
                        channel.pipeline().addLast();
                    }
                });
        bind(serverBootstrap,7911);
    }

    /**
     * 自动绑定递增端口 直至成功
     * @param serverBootstrap 启动引导类
     * @param port 端口
     */
    private static void bind(final ServerBootstrap serverBootstrap,final int port){
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()){
                System.out.println("端口[" + port + "]绑定成功!");
            }else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }
}
