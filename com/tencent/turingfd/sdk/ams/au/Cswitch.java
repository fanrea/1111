package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.switch, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cswitch {
    public static void a(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append("T:");
        long j = Melon.a;
        sb.append(j);
        sb.append(",");
        sb.append("LT:");
        sb.append(System.currentTimeMillis() - j);
    }
}
