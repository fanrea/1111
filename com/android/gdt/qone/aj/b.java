package com.android.gdt.qone.aj;

import com.android.gdt.qone.report.beat.BeatType;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[BeatType.values().length];
        a = iArr;
        try {
            iArr[BeatType.INIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[BeatType.REGISTER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[BeatType.AUDIT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[BeatType.NET_CHANGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
