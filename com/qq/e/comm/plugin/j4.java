package com.qq.e.comm.plugin;

import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class j4 {
    protected final String a = getClass().getSimpleName();
    private final String[] b;
    private final int c;
    private final boolean d;

    private void a(String str) {
        pro.getVresult(1, 0, this, str);
    }

    void a() {
        pro.getVresult(2, 0, this);
    }

    protected abstract int b();

    protected abstract String[] c();

    j4() {
        String[] strArrC = c();
        this.b = strArrC;
        this.c = b();
        this.d = strArrC != null && strArrC.length > 0;
    }
}
