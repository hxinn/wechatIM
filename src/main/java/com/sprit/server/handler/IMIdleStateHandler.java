package com.sprit.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
public class IMIdleStateHandler extends IdleStateHandler {
    private static final int READER_IDLE_TIME = 15;

    /**
     * 空闲检测
     * @param readerIdleTime 读空闲时间 指的是在这段时间内如果没有数据读到，就表示连接假死
     * @param writerIdleTime 写空闲时间 指的是 在这段时间如果没有写数据，就表示连接假死
     * @param allIdleTime 读写空闲时间 表示在这段时间内如果没有产生数据读或者写，就表示连接假死
     * @param unit 时间单位
     */
    public IMIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) {
        System.out.println(READER_IDLE_TIME + "秒内未读到数据，关闭连接");
        ctx.channel().close();
    }

}
