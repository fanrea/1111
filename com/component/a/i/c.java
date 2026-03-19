package com.component.a.i;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final String i = "JsonButtonManager";
    com.component.a.a.d a;
    a b;
    boolean c = false;
    int d = 0;
    float e = 0.0f;
    float f = 0.0f;
    long g = 1500;
    boolean h = true;

    public interface a {
        boolean a(View view);

        boolean b(View view);
    }

    public c(com.component.a.a.d dVar, a aVar) {
        this.a = dVar;
        this.b = aVar;
    }

    public void a() {
        this.a.setOnTouchListener(new d(this));
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        try {
            return Math.abs(this.e - motionEvent.getX()) < 20.0f && Math.abs(this.f - motionEvent.getY()) < 20.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
