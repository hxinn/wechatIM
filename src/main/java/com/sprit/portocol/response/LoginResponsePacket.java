package com.sprit.portocol.response;

import com.sprit.portocol.command.AbstractPacket;
import lombok.Data;

import static com.sprit.portocol.command.Command.LOGIN_RESPONSE;

@Data
public class LoginResponsePacket extends AbstractPacket {
    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}