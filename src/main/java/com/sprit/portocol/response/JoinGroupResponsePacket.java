package com.sprit.portocol.response;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import static com.sprit.portocol.command.Command.JOIN_GROUP_RESPONSE;


@Data
public class JoinGroupResponsePacket extends AbstractPacket {
    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_RESPONSE;
    }
}
