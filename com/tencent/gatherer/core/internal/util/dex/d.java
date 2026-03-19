package com.tencent.gatherer.core.internal.util.dex;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d {
    public static int a(long j) {
        if (j < 0 || j > 2147483647L) {
            throw new ArithmeticException("unsigned integer overflow");
        }
        return (int) j;
    }
}
