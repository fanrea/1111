package com.qq.e.comm.plugin;

import android.util.Pair;
import java.util.Map;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class v4 {
    private final boolean a;
    private final Map<String, Integer> c;
    protected String d = getClass().getSimpleName();
    private final int b = a();

    private void a(String str, String str2, String str3, e2 e2Var) {
        pro.getVresult(715, 0, this, str, str2, str3, e2Var);
    }

    protected abstract int a();

    int a(StackTraceElement[] stackTraceElementArr, String str, e2 e2Var) {
        return pro.getIresult(716, 0, this, stackTraceElementArr, str, e2Var);
    }

    protected Pair<String, Integer> a(String str) {
        return (Pair) pro.getobjresult(717, 0, this, str);
    }

    protected abstract Map<String, Integer> b();

    final boolean c() {
        return pro.getZresult(718, 0, this);
    }

    public v4() {
        Map<String, Integer> mapB = b();
        this.c = mapB;
        this.a = (mapB == null || mapB.isEmpty()) ? false : true;
    }
}
