package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.an.tt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends hc implements tt.d {
    private int k;
    private int mk;
    private int mq;
    private Handler uo;

    public an(Context context) {
        super(context);
        this.mq = 0;
        this.uo = new tt(Looper.getMainLooper(), this);
        this.k = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.u.b.hc
    public boolean d(Object... objArr) {
        if (this.u != null) {
            int iD = com.bytedance.adsdk.ugeno.an.b.d(this.u.get("loop"), 0);
            this.mk = iD;
            if (iD <= 0) {
                this.k = -1;
            } else {
                this.k = iD;
            }
            this.mq = com.bytedance.adsdk.ugeno.an.b.d(this.u.get("duration"), 0);
        }
        this.uo.sendEmptyMessageDelayed(1001, this.mq);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.an.tt.d
    public void d(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        this.d.d(this.hc, this.an, this.b.hc());
        int i3 = this.k - 1;
        this.k = i3;
        if (i3 < 0 && (i2 = this.mq) != 0) {
            this.uo.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.mq) != 0) {
            this.uo.sendEmptyMessageDelayed(1001, i);
        } else {
            this.uo.removeMessages(1001);
        }
    }
}
