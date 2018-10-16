package com.sprit.portocol.command;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/16
 * @return
 */
public interface Command {
    //登录
    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}
