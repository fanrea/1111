package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.an.tt;
import com.component.a.a.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb extends hc implements tt.d {
    private int mk;
    private Handler mq;

    public gb(Context context) {
        super(context);
        this.mk = 500;
        this.mq = new tt(Looper.getMainLooper(), this);
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
            this.mq.sendEmptyMessageDelayed(1101, this.mk);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.mq.removeMessages(1101);
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.an.tt.d
    public void d(Message message) {
        if (message.what != 1101) {
            return;
        }
        if (this.d != null) {
            this.d.d(this.hc, this.an, this.b.hc());
        }
        Handler handler = this.mq;
        if (handler != null) {
            handler.removeMessages(1101);
        }
    }
}
