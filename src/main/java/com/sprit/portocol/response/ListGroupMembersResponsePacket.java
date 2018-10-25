package com.sprit.portocol.response;

import com.sprit.portocol.AbstractPacket;
import com.sprit.session.Session;
import lombok.Data;

import java.util.List;

import static com.sprit.portocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

/**
 * @author: xiaohuaxin
 * @Description:
 * @Date: Created in 2018/10/25
 * @return
 */
@Data
public class ListGroupMembersResponsePacket extends AbstractPacket {
    private String groupId;
    private List<Session> sessions;

    @Override
    public Byte getCommand() {
        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
