package com.qq.e.comm.plugin;

import android.content.Intent;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class zs extends o0 {
    private String d;
    private Intent e;
    private int f;
    private boolean g = false;

    private void a(int i, l6 l6Var, int i2) {
        pro.getVresult(474, 0, this, Integer.valueOf(i), l6Var, Integer.valueOf(i2));
    }

    private void a(l6 l6Var, int i) {
        pro.getVresult(475, 0, this, l6Var, Integer.valueOf(i));
    }

    private String b(l6 l6Var) {
        return (String) pro.getobjresult(476, 0, this, l6Var);
    }

    private void c(l6 l6Var) {
        pro.getVresult(477, 0, this, l6Var);
    }

    private void f() {
        pro.getVresult(478, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    public boolean b() {
        return pro.getZresult(479, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    public boolean c() {
        return pro.getZresult(480, 0, this);
    }

    @Override // com.qq.e.comm.plugin.o0
    protected boolean d() {
        return pro.getZresult(481, 0, this);
    }

    zs() {
    }
}
