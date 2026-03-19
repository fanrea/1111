package com.bytedance.pangle.res.d;

import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq {
    public static void d(h hVar) throws IOException {
        hVar.hc(1835009, 0);
        int i = hVar.readInt();
        int i2 = hVar.readInt();
        int i3 = hVar.readInt();
        hVar.d();
        int i4 = hVar.readInt();
        int i5 = hVar.readInt();
        hVar.skipBytes(i2 * 4);
        if (i3 != 0) {
            hVar.skipBytes(i3 * 4);
        }
        hVar.skipBytes((i5 == 0 ? i : i5) - i4);
        if (i5 == 0) {
            return;
        }
        int i6 = i - i5;
        hVar.skipBytes(i6);
        int i7 = i6 % 4;
        if (i7 <= 0) {
            return;
        }
        while (true) {
            int i8 = i7 - 1;
            if (i7 <= 0) {
                return;
            }
            hVar.readByte();
            i7 = i8;
        }
    }
}
