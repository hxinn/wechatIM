package com.sprit.portocol.request;

import com.sprit.portocol.AbstractPacket;
import lombok.Data;

import static com.sprit.portocol.command.Command.LOGIN_REQUEST;

/**
 * @author: xiaohuaxin
 * @Description: 登录协议
 * @Date: Created in 2018/10/16
 * @return
 */
@Data
public class LoginRequestPacket extends AbstractPacket {
    private Integer uid;
    private String userName;
    private String passWord;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
