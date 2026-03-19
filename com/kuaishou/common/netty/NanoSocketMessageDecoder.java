package com.kuaishou.common.netty;

import com.kuaishou.socket.nano.SocketMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class NanoSocketMessageDecoder extends AbstractSocketMessageDecoder {
    @Override // com.kuaishou.common.netty.AbstractSocketMessageDecoder
    public Object parseFrom(byte[] bArr) {
        return SocketMessages.SocketMessage.parseFrom(bArr);
    }
}
