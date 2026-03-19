package com.kwad.sdk.i;

import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class i implements b {
    public double bun;
    public String cfO;
    public String cfP;
    public String cfQ;
    public long cfR = System.currentTimeMillis();

    public static i alE() {
        return new i();
    }

    public final i hG(String str) {
        this.cfO = str;
        return this;
    }

    public final i hH(String str) {
        this.cfP = str;
        return this;
    }

    public final i hI(String str) {
        this.cfQ = str;
        return this;
    }

    public final i t(double d) {
        this.bun = d;
        return this;
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, com.sigmob.sdk.base.n.C, Double.valueOf(this.bun));
        c.a(jSONObject, "ratio_count", Double.valueOf(j.u(this.bun)));
        c.putValue(jSONObject, "log_build_time_ms", this.cfR);
        c.putValue(jSONObject, ICEffectKeys.KEY_IS_IC_EFFECT_LOG_LEVEL, this.cfO);
        c.putValue(jSONObject, "log_tag", this.cfP);
        c.putValue(jSONObject, "log_content", this.cfQ);
        return jSONObject;
    }
}
