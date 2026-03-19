package com.qq.e.comm.plugin;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e8 {
    private Context a;
    private WeakReference<Context> b;
    private pk c;
    private ol d;
    private ql e;
    private zl f;
    private int g;
    private int h;
    private String i = "";
    private e2 j;
    private f5 k;

    public Context d() {
        return a50.e ? this.b.get() : this.a;
    }

    public e8(Context context) {
        if (a50.e) {
            this.b = new WeakReference<>(context);
        } else {
            this.a = context;
        }
        zu.a(context);
    }

    public pk f() {
        return this.c;
    }

    public ol g() {
        return this.d;
    }

    public ql h() {
        return this.e;
    }

    public zl j() {
        return this.f;
    }

    public int a() {
        return this.g;
    }

    public boolean k() {
        int i = this.g;
        return i == 2 || i == 1;
    }

    public int i() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public e2 b() {
        return this.j;
    }

    public f5 c() {
        return this.k;
    }

    public void a(e2 e2Var) {
        this.j = e2Var;
    }

    public void b(int i) {
        this.h = i;
    }

    public void a(f5 f5Var) {
        this.k = f5Var;
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(pk pkVar) {
        this.c = pkVar;
    }

    public void a(ol olVar) {
        this.d = olVar;
    }

    public void a(ql qlVar) {
        this.e = qlVar;
    }

    public void a(zl zlVar) {
        this.f = zlVar;
    }
}
