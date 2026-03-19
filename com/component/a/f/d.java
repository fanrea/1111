package com.component.a.f;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.component.a.f.e;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    public static final String a = "prepare";
    public static final String b = "create";
    public static final String c = "click";
    public static final String d = "interact";
    public static final String e = "root_attach";
    public static final String f = "attach";
    public static final String g = "detach";
    private final String h;
    private final e i;
    private View j;
    private Map<String, Object> k;
    private String l;
    private String m = "";
    private String n = "";
    private int o = 0;
    private int p = 0;
    private final com.baidu.mobads.container.o.b q = new com.baidu.mobads.container.o.b();

    public d(View view, String str, e eVar) {
        this.j = view;
        this.h = str;
        this.i = eVar;
    }

    public void a(View view) {
        this.j = view;
    }

    public void a(Map<String, Object> map) {
        this.k = map;
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(int i) {
        this.q.a(i);
    }

    public void a(String str, String str2) {
        this.q.a(str);
        this.q.b(str2);
    }

    public void a(View view, int i, MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.q.a(view, i, motionEvent, motionEvent2);
    }

    public void a(View view, float f2, float f3) {
        this.q.a(view, f2, f3);
    }

    public com.baidu.mobads.container.o.b a() {
        return this.q;
    }

    public int b() {
        return this.o;
    }

    public int c() {
        return this.p;
    }

    public String d() {
        return this.h;
    }

    public View e() {
        return this.j;
    }

    public e f() {
        return this.i;
    }

    public String g() {
        return this.i.n("");
    }

    public String h() {
        if (!TextUtils.isEmpty(this.l)) {
            return this.l;
        }
        if (TextUtils.equals(this.h, d)) {
            return this.i.r("ad_click");
        }
        return this.i.q("");
    }

    public String i() {
        if (TextUtils.isEmpty(this.m)) {
            return this.i.l("");
        }
        return this.m;
    }

    public String j() {
        if (TextUtils.isEmpty(this.n)) {
            return this.i.m("");
        }
        return this.n;
    }

    public e.d k() {
        return this.i.e();
    }

    public Map<String, Object> l() {
        return this.k;
    }
}
