package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private c CV = new c();
    private C0438a CW = new C0438a();
    private final b CX = new b(com.kwad.components.ad.reward.a.b.hF());

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (as.aF(context, com.kwad.sdk.core.response.b.a.aB(e.eP(adTemplate)))) {
            aVar.kR();
        } else {
            aVar.kS();
        }
    }

    public final void kO() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.CV.kG();
        kQ();
    }

    public final void kR() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallCompleted");
        this.CW.kG();
        kQ();
    }

    private void kS() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallUncompleted");
        this.CW.kH();
        kQ();
    }

    public final void kT() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markUseAppCompleted");
        this.CX.kG();
        kQ();
    }

    public final boolean kU() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "isInstallCompleted");
        return this.CW.isCompleted();
    }

    public final boolean kP() {
        return this.CV.isCompleted();
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
        arrayList.add(this.CV);
        arrayList.add(this.CX);
        return arrayList;
    }

    private void kQ() {
        if (this.CV.isCompleted() && this.CW.isCompleted() && this.CX.isCompleted()) {
            kG();
        } else {
            kH();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.CW.isCompleted() && this.CX.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "mWatchVideoTask", this.CV);
        aa.a(jSONObject, "mInstallAppTask", this.CW);
        aa.a(jSONObject, "mUseAppTask", this.CX);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.CV.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.CX.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.CQ = "基础奖励：观看视频";
            this.CR = "基础奖励：需再观看%ss视频";
        }
    }

    /* renamed from: com.kwad.components.ad.reward.l.b.a$a, reason: collision with other inner class name */
    static class C0438a extends com.kwad.components.ad.reward.l.b {
        public C0438a() {
            this.CQ = "安装应用";
        }
    }

    static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i) {
            this.CQ = String.format("进阶奖励：安装并激活APP %ss", new StringBuilder().append(i).toString());
            this.CR = String.format("进阶奖励：安装并激活APP %ss", new StringBuilder().append(i).toString());
        }
    }
}
