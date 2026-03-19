package com.component.a.i;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements View.OnTouchListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.a.c) {
                    this.a.d = 0;
                    this.a.e = motionEvent.getX();
                    this.a.f = motionEvent.getY();
                    this.a.h = true;
                }
                return false;
            case 1:
                if (this.a.c) {
                    if (this.a.d == 1) {
                        return this.a.h;
                    }
                    if (this.a.d == 0) {
                        if (this.a.a(motionEvent) && motionEvent.getEventTime() - motionEvent.getDownTime() > this.a.g) {
                            if (this.a.b != null) {
                                return this.a.b.b(view);
                            }
                        } else if (this.a.b != null) {
                            return this.a.b.a(view);
                        }
                    } else if (this.a.d == 2 && this.a.b != null) {
                        return this.a.b.a(view);
                    }
                } else if (this.a.b != null) {
                    return this.a.b.a(view);
                }
                return false;
            case 2:
                if (this.a.c && this.a.d == 0) {
                    if (!this.a.a(motionEvent)) {
                        this.a.d = 2;
                    } else if (motionEvent.getEventTime() - motionEvent.getDownTime() > this.a.g) {
                        this.a.d = 1;
                        if (this.a.b != null) {
                            this.a.h = this.a.b.b(view);
                            return this.a.h;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
