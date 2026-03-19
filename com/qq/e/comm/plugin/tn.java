package com.qq.e.comm.plugin;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tn implements View.OnTouchListener {
    private boolean a;
    private float b;
    private float c;
    private final jm d;
    private int e;
    private final h4 f;
    private a g;

    /* compiled from: A */
    public interface a {
        void a();

        void a(i6 i6Var);
    }

    public tn(h4 h4Var, jm jmVar) {
        this.f = h4Var;
        this.d = jmVar;
        if (jmVar == null || jmVar.a() == null) {
            return;
        }
        u2.a().a(jmVar.a(), h4Var);
        this.e = ViewConfiguration.get(jmVar.a().getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        jm jmVar = this.d;
        if (jmVar == null || jmVar.a() == null) {
            return false;
        }
        r5 r5VarD = u2.a().d(this.d.a());
        if (r5VarD != null) {
            r5VarD.a(motionEvent, true);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = motionEvent.getRawX();
            this.c = motionEvent.getRawY();
        } else if (action == 1 || action == 3) {
            a(motionEvent);
        }
        return this.d.a().onTouchEvent(motionEvent);
    }

    private void a(MotionEvent motionEvent) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a();
        }
        if (Math.abs(motionEvent.getRawX() - this.b) <= this.e) {
            Math.abs(motionEvent.getRawY() - this.c);
        }
        this.d.c(true);
        r5 r5VarD = u2.a().d(this.d.a());
        i6 i6Var = new i6(this.f);
        i6Var.h = 4;
        if (r5VarD != null) {
            r5VarD.a(i6Var);
        }
        if (this.a) {
            return;
        }
        this.a = true;
        if (this.g != null) {
            i6Var.b = u2.a().a(this.d.a());
            this.g.a(i6Var);
        }
    }

    public void a(a aVar) {
        this.g = aVar;
    }
}
