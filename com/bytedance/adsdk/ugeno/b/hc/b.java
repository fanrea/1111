package com.bytedance.adsdk.ugeno.b.hc;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.b.cb;
import com.bytedance.adsdk.ugeno.b.yo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private final int an;
    private cb b;
    private Context c;
    private float d;
    private float hc;
    private boolean u;

    public b(Context context, cb cbVar) {
        this.c = context;
        this.b = cbVar;
        this.an = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean d(yo yoVar, com.bytedance.adsdk.ugeno.hc.b bVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            this.hc = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.d) >= this.an || Math.abs(y - this.hc) >= this.an) {
                    this.u = true;
                }
            } else if (action == 3) {
                this.u = false;
            }
        } else {
            if (this.u) {
                this.u = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.d) >= this.an || Math.abs(y2 - this.hc) >= this.an) {
                this.u = false;
            } else if (yoVar != null) {
                yoVar.d(this.b, bVar, bVar);
                return true;
            }
        }
        return true;
    }
}
