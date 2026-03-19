package com.kuaishou.common.netty;

import com.kuaishou.socket.nano.SocketMessages;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class NanoSocketMessageEncoder extends AbstractSocketMessageEncoder<SocketMessages.SocketMessage> {
    @Override // com.kuaishou.common.netty.AbstractSocketMessageEncoder
    public byte[] toByteArray(SocketMessages.SocketMessage socketMessage) {
        return SocketMessages.SocketMessage.toByteArray(socketMessage);
    }
}
