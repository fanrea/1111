package com.sigmob.sdk.base.common;

import android.os.Parcel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f {
    private int a;
    private int b;

    public f(int width, int height) {
        this.a = width;
        this.b = height;
    }

    protected f(Parcel in) {
        this.a = in.readInt();
        this.b = in.readInt();
    }

    public int a() {
        return this.a;
    }

    public void a(int width) {
        this.a = width;
    }

    public int b() {
        return this.b;
    }

    public void b(int height) {
        this.b = height;
    }
}
