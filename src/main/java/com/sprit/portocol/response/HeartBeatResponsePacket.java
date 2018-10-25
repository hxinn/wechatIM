package com.sprit.portocol.response;

import com.sprit.portocol.AbstractPacket;

import static com.sprit.portocol.command.Command.HEARTBEAT_RESPONSE;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
public class HeartBeatResponsePacket extends AbstractPacket {

    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
