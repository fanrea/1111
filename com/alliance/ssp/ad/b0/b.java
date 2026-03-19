package com.alliance.ssp.ad.b0;

import android.app.Activity;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.unifiedfeed.SAUnifiedFeedAdLoadListener;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.d0.g;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.o0.l;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* compiled from: NMUnifiedFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends com.alliance.ssp.ad.b0.a {
    public SAAllianceAdData D0;

    public b(int i, WeakReference<Activity> weakReference, SAAllianceAdParams sAAllianceAdParams, SAUnifiedFeedAdLoadListener sAUnifiedFeedAdLoadListener, g gVar) {
        super(i, weakReference, "", "", sAAllianceAdParams, sAUnifiedFeedAdLoadListener, null, gVar);
        this.D0 = null;
        a(sAAllianceAdParams);
    }

    public static void a(b bVar, SAAllianceAdParams sAAllianceAdParams) {
        bVar.getClass();
        Objects.toString(sAAllianceAdParams);
        int i = l.a;
        if (sAAllianceAdParams == null) {
            bVar.a(100005, "001", "无填充");
            return;
        }
        bVar.D0.getRestype();
        Material material = bVar.D0.getMaterial();
        material.getTempid();
        material.getImgurl();
        material.getVideourl();
        material.getDesc();
        throw null;
    }

    /* compiled from: NMUnifiedFeedAdImpl.java */
    public class a implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ SAAllianceAdParams a;

        public a(SAAllianceAdParams sAAllianceAdParams) {
            this.a = sAAllianceAdParams;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(SAAllianceEngineData sAAllianceEngineData) {
            SAAllianceEngineData sAAllianceEngineData2 = sAAllianceEngineData;
            try {
                List<SAAllianceAdData> data = sAAllianceEngineData2.getData();
                if (data.size() > 0 && !sAAllianceEngineData2.getData().isEmpty() && sAAllianceEngineData2.getData() != null) {
                    for (SAAllianceAdData sAAllianceAdData : data) {
                        b bVar = b.this;
                        bVar.D0 = sAAllianceAdData;
                        b.a(bVar, this.a);
                    }
                    return;
                }
                b.this.a(100005, "002", "无填充");
            } catch (Exception unused) {
                b.this.a(100005, "001", "无填充");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            b.this.a(100005, "001", str);
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) {
        new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 0, new a(sAAllianceAdParams), BaseNetAction.Method.POST).a();
    }
}
