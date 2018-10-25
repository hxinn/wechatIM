package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import static com.sprit.portocol.command.Command.QUIT_GROUP_REQUEST;


@Data
public class QuitGroupRequestPacket extends AbstractPacket {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }
}
