package com.baidu.mobads.container.f;

import android.text.TextUtils;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cm;
import com.component.feed.an;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k implements an.a {
    final /* synthetic */ an a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ JSONObject d;
    final /* synthetic */ com.baidu.mobads.container.adrequest.j e;
    final /* synthetic */ b f;

    k(b bVar, an anVar, String str, String str2, JSONObject jSONObject, com.baidu.mobads.container.adrequest.j jVar) {
        this.f = bVar;
        this.a = anVar;
        this.b = str;
        this.c = str2;
        this.d = jSONObject;
        this.e = jVar;
    }

    @Override // com.component.feed.an.a
    public void a(float f, float f2) throws JSONException {
        this.f.mClickTracker.a(this.a, f, f2);
        this.f.mClickTracker.a(this.b);
        this.f.mClickTracker.b("shake_view");
        this.f.mClickTracker.b(this.f.getAdContainerView(this.c));
        JSONObject adStatus = this.f.mAdContainerCxt.q().getAdStatus();
        long jOptLong = adStatus != null ? adStatus.optLong(com.baidu.mobads.container.adrequest.n.H, 0L) : 0L;
        this.f.mClickTracker.a(this.a);
        this.f.setClickInfoForCK(this.f.mClickTracker, jOptLong);
        this.f.a(this.a, this.d, 2);
    }

    @Override // com.component.feed.an.a
    public void a() {
        if (!TextUtils.isEmpty(this.c) && !this.f.a(this.c, this.b)) {
            this.f.a(this.c, this.b, "1");
            by.a.a(this.f.mAppContext).a(809).a(this.e).a("viewId", this.b).a("expire", "" + (System.currentTimeMillis() - this.f.mAdContainerCxt.r().a())).a("forecurl", this.f.h(this.e.getClickThroughUrl())).b(this.f.mAdContainerCxt.l()).c(this.f.mAdContainerCxt.k()).a(this.f.mAdContainerCxt.z()).a("uniqueid", this.c).a("bidl", this.f.c(this.e)).a("ebidl", this.f.d(this.e)).f();
        }
    }

    @Override // com.component.feed.an.a
    public void b() {
        if (this.f.mAdContainerCxt != null) {
            HashMap map = new HashMap();
            map.put("type", "dismiss");
            map.put("uniqueId", this.c);
            this.f.mAdContainerCxt.s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.Q, (HashMap<String, Object>) map));
        }
    }
}
