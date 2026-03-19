package com.component.lottie.d.b;

import android.graphics.Paint;
import com.component.lottie.a.a.x;
import com.component.lottie.af;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class r implements c {
    private final String a;
    private final com.component.lottie.d.a.b b;
    private final List<com.component.lottie.d.a.b> c;
    private final com.component.lottie.d.a.a d;
    private final com.component.lottie.d.a.d e;
    private final com.component.lottie.d.a.b f;
    private final a g;
    private final b h;
    private final float i;
    private final boolean j;

    public enum a {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap b() {
            switch (this) {
                case BUTT:
                    return Paint.Cap.BUTT;
                case ROUND:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    public enum b {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join b() {
            switch (this) {
                case BEVEL:
                    return Paint.Join.BEVEL;
                case MITER:
                    return Paint.Join.MITER;
                case ROUND:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    public r(String str, com.component.lottie.d.a.b bVar, List<com.component.lottie.d.a.b> list, com.component.lottie.d.a.a aVar, com.component.lottie.d.a.d dVar, com.component.lottie.d.a.b bVar2, a aVar2, b bVar3, float f, boolean z) {
        this.a = str;
        this.b = bVar;
        this.c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = aVar2;
        this.h = bVar3;
        this.i = f;
        this.j = z;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new x(afVar, aVar, this);
    }

    public String a() {
        return this.a;
    }

    public com.component.lottie.d.a.a b() {
        return this.d;
    }

    public com.component.lottie.d.a.d c() {
        return this.e;
    }

    public com.component.lottie.d.a.b d() {
        return this.f;
    }

    public List<com.component.lottie.d.a.b> e() {
        return this.c;
    }

    public com.component.lottie.d.a.b f() {
        return this.b;
    }

    public a g() {
        return this.g;
    }

    public b h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }
}
