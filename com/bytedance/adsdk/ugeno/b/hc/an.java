package com.bytedance.adsdk.ugeno.b.hc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.an.tt;
import com.bytedance.adsdk.ugeno.b.cb;
import com.bytedance.adsdk.ugeno.b.yo;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements tt.d {
    private com.bytedance.adsdk.ugeno.hc.b an;
    private yo b;
    private Context c;
    private boolean d;
    private Handler h = new tt(Looper.getMainLooper(), this);
    private int hc;
    private cb u;

    public an(Context context, cb cbVar, com.bytedance.adsdk.ugeno.hc.b bVar) {
        this.c = context;
        this.u = cbVar;
        this.an = bVar;
    }

    public void d(yo yoVar) {
        this.b = yoVar;
    }

    public void d() {
        cb cbVar = this.u;
        if (cbVar == null) {
            return;
        }
        JSONObject jSONObjectB = cbVar.b();
        try {
            this.hc = Integer.parseInt(com.bytedance.adsdk.ugeno.c.hc.d(jSONObjectB.optString(MetricsSQLiteCacheKt.METRICS_INTERVAL, "8000"), this.an.tc()));
            this.d = jSONObjectB.optBoolean("repeat");
            this.h.sendEmptyMessageDelayed(1001, this.hc);
        } catch (NumberFormatException e) {
            mq.d(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.an.tt.d
    public void d(Message message) {
        if (message.what != 1001) {
            return;
        }
        yo yoVar = this.b;
        if (yoVar != null) {
            cb cbVar = this.u;
            com.bytedance.adsdk.ugeno.hc.b bVar = this.an;
            yoVar.d(cbVar, bVar, bVar);
        }
        if (this.d) {
            this.h.sendEmptyMessageDelayed(1001, this.hc);
        } else {
            this.h.removeMessages(1001);
        }
    }
}
