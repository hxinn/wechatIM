package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import static com.sprit.portocol.command.Command.LOGOUT_REQUEST;

@Data
public class LogoutRequestPacket extends AbstractPacket {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
