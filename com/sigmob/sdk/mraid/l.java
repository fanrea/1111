package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class l {
    private final Context a;
    private final Rect b = new Rect();
    private final Rect c = new Rect();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final float j;

    public l(Context context, float density) {
        this.a = context.getApplicationContext();
        this.j = density;
    }

    private void a(Rect sourceRect, Rect outRect) {
        outRect.set(Dips.pixelsToIntDips(sourceRect.left, this.a), Dips.pixelsToIntDips(sourceRect.top, this.a), Dips.pixelsToIntDips(sourceRect.right, this.a), Dips.pixelsToIntDips(sourceRect.bottom, this.a));
    }

    public float a() {
        return this.j;
    }

    public void a(int width, int height) {
        this.b.set(0, 0, width, height);
        a(this.b, this.c);
    }

    public void a(int x, int y, int width, int height) {
        this.d.set(x, y, width + x, height + y);
        a(this.d, this.e);
    }

    Rect b() {
        return this.b;
    }

    public void b(int x, int y, int width, int height) {
        this.f.set(x, y, width + x, height + y);
        a(this.f, this.g);
    }

    public Rect c() {
        return this.c;
    }

    public void c(int x, int y, int width, int height) {
        this.h.set(x, y, width + x, height + y);
        a(this.h, this.i);
    }

    Rect d() {
        return this.d;
    }

    public Rect e() {
        return this.e;
    }

    Rect f() {
        return this.f;
    }

    public Rect g() {
        return this.g;
    }

    Rect h() {
        return this.h;
    }

    public Rect i() {
        return this.i;
    }
}
