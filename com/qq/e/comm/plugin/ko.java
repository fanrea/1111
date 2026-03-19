package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class ko {
    private File a;
    private Bitmap b;
    private Movie c;
    private Drawable d;
    private boolean e;
    private int f;
    private boolean g;
    private boolean h;

    private ko() {
        this.f = 0;
    }

    public Movie e() {
        return this.c;
    }

    public Drawable c() {
        return this.d;
    }

    public File d() {
        return this.a;
    }

    public Bitmap b() {
        return this.b;
    }

    public boolean h() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    public int f() {
        return this.f;
    }

    /* compiled from: A */
    static class b {
        private ko a = new ko();

        b() {
        }

        b b(boolean z) {
            this.a.e = z;
            return this;
        }

        b c(boolean z) {
            this.a.g = z;
            return this;
        }

        ko a() {
            return this.a;
        }

        b a(t tVar) {
            this.a.d = tVar;
            this.a.f = 3;
            return this;
        }

        b a(boolean z) {
            this.a.h = z;
            return this;
        }

        b a(Bitmap bitmap) {
            this.a.b = bitmap;
            this.a.f = 1;
            return this;
        }

        b a(File file) {
            this.a.a = file;
            return this;
        }

        b a(Movie movie) {
            this.a.c = movie;
            this.a.f = 2;
            return this;
        }
    }

    public boolean a() {
        return this.e;
    }
}
