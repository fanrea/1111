package com.qq.e.comm.plugin;

import android.view.ViewGroup;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ve extends ViewGroup.MarginLayoutParams {

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[q60.values().length];
            a = iArr;
            try {
                iArr[q60.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[q60.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[q60.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[q60.PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ve(i8 i8Var) {
        super(a(i8Var.s().j()), a(i8Var.s().d()));
    }

    private static int a(com.qq.e.lib.yoga.c cVar) {
        int i = a.a[cVar.b.ordinal()];
        if (i == 1) {
            return -2;
        }
        if (i != 2) {
            return -1;
        }
        return zu.a(cVar.a);
    }
}
