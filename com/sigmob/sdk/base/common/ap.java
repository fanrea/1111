package com.sigmob.sdk.base.common;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ap extends GestureDetector {
    private final View a;
    private final b b;

    private ap(Context context, View view, b adAlertGestureListener) {
        super(context, adAlertGestureListener);
        this.b = adAlertGestureListener;
        this.a = view;
        setIsLongpressEnabled(false);
    }

    public ap(Context context, View view, BaseAdUnit adUnit) {
        this(context, view, new b(view, adUnit));
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (motionEvent == null || view == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return x >= 0.0f && x <= ((float) view.getWidth()) && y >= 0.0f && y <= ((float) view.getHeight());
    }

    void a() {
        this.b.b();
    }

    public void b() {
        this.b.c();
    }

    public boolean c() {
        return this.b.d();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            this.b.a();
        } else if (action == 2 && !a(motionEvent, this.a)) {
            a();
        }
        return zOnTouchEvent;
    }
}
