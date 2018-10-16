package com.sprit.codec;

import com.sprit.portocol.AbstractPacket;
import com.sprit.portocol.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/16
 * @return
 */
public class PacketEncoder extends MessageToByteEncoder<AbstractPacket> {

    @Override
    protected void encode(ChannelHandlerContext ctx, AbstractPacket msg, ByteBuf out) throws Exception {
        PacketCodec.INSTANCE.encode(out, msg);
    }
}
