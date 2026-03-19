package com.kwad.components.ad.reward.l;

import com.kwad.sdk.utils.aa;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean CP = false;
    protected String CQ;
    protected String CR;

    public final void kG() {
        if (this.CP) {
            return;
        }
        this.CP = true;
        kL();
    }

    public final void kH() {
        if (this.CP) {
            this.CP = false;
            kL();
        }
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String kI() {
        return this.CQ;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String kJ() {
        return this.CR;
    }

    public boolean isCompleted() {
        return kK();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "selfCompleted", this.CP);
        return jSONObject;
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.CP = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    private boolean kK() {
        return this.CP;
    }

    private void kL() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.CP));
    }
}
