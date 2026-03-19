package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class o extends ae {
    private CpuChannelListManager.CpuChannelListListener t;
    private String u;
    private int v;

    public o(Context context) {
        super(context);
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.t = cpuChannelListListener;
    }

    public void a(String str, int i) {
        this.u = str;
        this.v = i;
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.n = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prod", "cpu");
            this.m.createProdHandler(jSONObject2);
            p pVar = new p(this);
            this.m.addEventListener(z.ap, pVar);
            this.m.addEventListener(z.aq, pVar);
            jSONObject.put("appsid", this.u);
            jSONObject.put("subChannelId", this.v);
            jSONObject.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, "cpu_channelIds");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(jSONObject);
    }
}
