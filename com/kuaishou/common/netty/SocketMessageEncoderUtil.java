package com.kuaishou.common.netty;

import io.netty.buffer.ByteBuf;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SocketMessageEncoderUtil {
    public static void write(byte[] bArr, ByteBuf byteBuf) {
        byteBuf.writeByte(1);
        byteBuf.writeBytes(Constants.MAGIC_BYTES);
        byteBuf.writeBytes(new byte[8]);
        byteBuf.writeInt(bArr.length);
        byteBuf.writeBytes(bArr);
    }
}
