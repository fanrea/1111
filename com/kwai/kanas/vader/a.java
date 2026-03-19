package com.kwai.kanas.vader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class a {
    public static Channel a(int i) {
        if (i == Channel.NORMAL.getValue()) {
            return Channel.NORMAL;
        }
        if (i == Channel.HIGH_FREQ.getValue()) {
            return Channel.NORMAL;
        }
        if (i == Channel.REAL_TIME.getValue()) {
            return Channel.REAL_TIME;
        }
        throw new IllegalArgumentException("Unknown channel status: " + i);
    }

    public static int a(Channel channel) {
        return channel.getValue();
    }
}
