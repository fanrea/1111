package com.baidu.mobads.upgrade.remote.gray;

import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.l;
import com.baidu.mobads.container.w.b.g;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements g {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.mobads.container.w.b.g
    public void a(com.baidu.mobads.container.w.c.f fVar) {
        com.baidu.mobads.container.l.g.h("GodEye").c("onInit:" + fVar.e());
    }

    @Override // com.baidu.mobads.container.w.b.g
    public void b(com.baidu.mobads.container.w.c.f fVar) {
        com.baidu.mobads.container.l.g.h("GodEye").c("onStart:" + fVar.e());
    }

    @Override // com.baidu.mobads.container.w.b.g
    public void c(com.baidu.mobads.container.w.c.f fVar) {
        com.baidu.mobads.container.l.g.h("GodEye").c("onStop:" + fVar.e());
    }

    @Override // com.baidu.mobads.container.w.b.g
    public void d(com.baidu.mobads.container.w.c.f fVar) {
        com.baidu.mobads.container.l.g.h("GodEye").c("onDestroy:" + fVar.e());
    }

    @Override // com.baidu.mobads.container.w.b.g
    public void a(com.baidu.mobads.container.w.b.f fVar) {
        if (fVar == null) {
            return;
        }
        com.baidu.mobads.container.w.g.a aVarA = fVar.a();
        JSONObject jSONObjectB = fVar.b();
        if (aVarA == com.baidu.mobads.container.w.g.a.FRAME_TAG) {
            by.a aVarA2 = by.a.a(this.a.e).a(1008).a("subtype", aVarA.b()).a(DeviceUtils.getInstance().l(this.a.e));
            try {
                Iterator<String> itKeys = jSONObjectB.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    aVarA2.a(next, String.valueOf(jSONObjectB.get(next)));
                }
            } catch (Throwable th) {
            }
            aVarA2.f();
        } else {
            Iterator<String> itKeys2 = jSONObjectB.keys();
            HashMap map = new HashMap();
            while (itKeys2.hasNext()) {
                try {
                    String next2 = itKeys2.next();
                    map.put(next2, String.valueOf(jSONObjectB.get(next2)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            l.a(this.a.e, fVar.c(), String.valueOf(aVarA.b()), map);
        }
        com.baidu.mobads.container.l.g.h("GodEye").c("onReportIssue:" + fVar.toString());
    }
}
