package com.kwad.components.ad.reward.l.a;

import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b CS = new b();
    private final C0437a CU = new C0437a(e.Yp());

    public final void kO() {
        c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.CS.kG();
        kQ();
    }

    public final void markOpenNsCompleted() {
        c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.CU.kG();
        kQ();
    }

    public final boolean kP() {
        return this.CS.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int kF() {
        Iterator<com.kwad.components.ad.reward.l.c> it = kE().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i++;
            }
        }
        return i;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> kE() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.CS);
        arrayList.add(this.CU);
        return arrayList;
    }

    private void kQ() {
        if (this.CU.isCompleted()) {
            kG();
        } else {
            kH();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.CU.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "mWatchVideoTask", this.CS);
        aa.a(jSONObject, "mOpenNsTask", this.CU);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.CS.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.CU.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.CQ = "基础奖励：观看视频";
            this.CR = "基础奖励：需再观看%ss视频";
        }
    }

    /* renamed from: com.kwad.components.ad.reward.l.a.a$a, reason: collision with other inner class name */
    static class C0437a extends com.kwad.components.ad.reward.l.b {
        public C0437a(int i) {
            this.CQ = String.format("进阶奖励：浏览详情页 %ss", new StringBuilder().append(i).toString());
            this.CR = String.format("进阶奖励：浏览详情页 %ss", new StringBuilder().append(i).toString());
        }
    }
}
