package com.android.gdt.qone.b;

import com.android.gdt.oaid2.VendorChecker;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[VendorChecker.values().length];
        a = iArr;
        try {
            iArr[VendorChecker.XM_TYPE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[VendorChecker.VV_TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[VendorChecker.HW_TYPE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[VendorChecker.OP_TYPE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[VendorChecker.LX_TYPE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[VendorChecker.HS_TYPE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            a[VendorChecker.SX_TYPE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[VendorChecker.MZ_TYPE.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[VendorChecker.NB_TYPE.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[VendorChecker.MSA_TYPE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[VendorChecker.HONOR_TYPE.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            a[VendorChecker.UNSUPPORTED.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
