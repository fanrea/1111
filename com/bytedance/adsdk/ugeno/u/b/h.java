package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.an.tt;
import com.component.a.a.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends hc implements tt.d {
    private int mk;
    private boolean mq;
    private Handler uo;

    public h(Context context) {
        super(context);
        this.mk = 500;
        this.uo = new tt(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.adsdk.ugeno.u.b.hc
    public boolean d(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.mk = com.bytedance.adsdk.ugeno.an.b.d(this.u.get(b.e.c), 500);
        return d(this.hc, motionEvent);
    }

    private boolean d(com.bytedance.adsdk.ugeno.hc.b bVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.uo.sendEmptyMessageDelayed(1102, this.mk);
        } else {
            if (action == 1) {
                if (this.mq && this.d != null) {
                    this.d.d(this.hc, this.an, this.b.hc());
                    this.mq = false;
                    Handler handler = this.uo;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.uo;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.mq = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.uo;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.mq = false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.an.tt.d
    public void d(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.mq = true;
        Handler handler = this.uo;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
