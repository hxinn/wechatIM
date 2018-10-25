package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;

import static com.sprit.portocol.command.Command.HEARTBEAT_REQUEST;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
public class HeartBeatRequestPacket extends AbstractPacket {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
