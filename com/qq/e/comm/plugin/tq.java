package com.qq.e.comm.plugin;

import android.view.ViewGroup;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tq extends ViewGroup.MarginLayoutParams {
    private static int a(int i) {
        if (i >= 0) {
            return i;
        }
        if (i == -1) {
            return -1;
        }
        if (i == -2) {
            return -2;
        }
        return i;
    }

    public tq(rk rkVar) {
        super(a(rkVar.g()), a(rkVar.h()));
        ((ViewGroup.MarginLayoutParams) this).topMargin = rkVar.q();
        ((ViewGroup.MarginLayoutParams) this).bottomMargin = rkVar.k();
        ((ViewGroup.MarginLayoutParams) this).leftMargin = rkVar.m();
        ((ViewGroup.MarginLayoutParams) this).rightMargin = rkVar.a();
    }
}
