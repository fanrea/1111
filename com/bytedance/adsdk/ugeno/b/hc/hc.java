package com.bytedance.adsdk.ugeno.b.hc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.an.tt;
import com.bytedance.adsdk.ugeno.b.cb;
import com.bytedance.adsdk.ugeno.b.uo;
import com.bytedance.adsdk.ugeno.b.yo;
import com.bytedance.sdk.component.utils.mq;
import com.component.a.a.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements tt.d {
    private Handler an = new tt(Looper.getMainLooper(), this);
    private Context b;
    private cb c;
    private int d;
    private yo hc;
    private com.bytedance.adsdk.ugeno.hc.b u;

    public hc(Context context, cb cbVar, com.bytedance.adsdk.ugeno.hc.b bVar) {
        this.b = context;
        this.c = cbVar;
        this.u = bVar;
    }

    public void d(yo yoVar) {
        this.hc = yoVar;
    }

    public void d() {
        cb cbVar = this.c;
        if (cbVar == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.bytedance.adsdk.ugeno.c.hc.d(cbVar.b().optString(b.e.c), this.u.tc()));
            this.d = i;
            this.an.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException e) {
            mq.d(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.an.tt.d
    public void d(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectB = this.c.b();
        if (TextUtils.equals(jSONObjectB.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectB.optString("nodeId");
            com.bytedance.adsdk.ugeno.hc.b bVar = this.u;
            com.bytedance.adsdk.ugeno.hc.b bVarC = bVar.hc(bVar).c(strOptString);
            new uo(bVarC.tt(), com.bytedance.adsdk.ugeno.b.d.d(jSONObjectB.optJSONObject("animatorSet"), bVarC)).d();
        } else {
            yo yoVar = this.hc;
            if (yoVar != null) {
                cb cbVar = this.c;
                com.bytedance.adsdk.ugeno.hc.b bVar2 = this.u;
                yoVar.d(cbVar, bVar2, bVar2);
            }
        }
        this.an.removeMessages(1001);
    }
}
