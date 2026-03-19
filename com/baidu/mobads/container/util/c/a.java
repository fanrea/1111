package com.baidu.mobads.container.util.c;

import android.content.Context;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.components.b.e;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cd;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static int a = 0;
    public static final int b = 100;
    public static final int c = 15000;
    public int g;
    private final Context j;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public long h = 0;
    public long i = 0;

    public a(Context context) {
        this.j = context;
    }

    public void a(t tVar, String str, JSONObject jSONObject, j jVar, HashMap<String, String> map, int i, com.baidu.mobads.container.components.k.a aVar) {
        b bVar;
        try {
            a();
            bVar = new b(this, i, tVar, jVar, map, str, jSONObject, aVar);
        } catch (Throwable th) {
            th = th;
        }
        try {
            com.baidu.mobads.container.components.b.c.a().a(this.j, bVar);
            com.baidu.mobads.container.d.b.a().a(new c(this, tVar, str, jVar, map, bVar), 100L, 100L, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
        }
    }

    private void a() {
        this.h = 0L;
        this.i = 0L;
        a = 0;
        this.e = false;
        this.d = false;
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, j jVar, HashMap<String, String> map, e eVar) {
        if (tVar == null) {
            return;
        }
        com.baidu.mobads.container.components.b.c.a().b(tVar.t(), eVar);
        a(tVar, jVar, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, String str, j jVar) {
        String str2 = "1";
        if (tVar == null) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put(FeedReqParams.REQ_TYPE_OPEN, "1");
            if (!this.d) {
                str2 = "2";
            }
            map.put("dia_select", str2);
            map.put("leavetime", String.valueOf(this.i));
            map.put("opentimec", String.valueOf(this.h));
            map.put("dp_fl_tp", String.valueOf(this.g));
            map.put("pk", str);
            map.put("appsid", tVar.z());
            map.put("prod", tVar.k());
            map.put("apid", tVar.l());
            map.put(com.baidu.mobads.container.components.command.j.C, bk.a(jVar));
            map.put(com.baidu.mobads.container.components.command.j.f, jVar.getBuyer());
            map.put("qk", jVar.getQueryKey());
            map.put("adid", jVar.getAdId());
            cd.a(tVar.t(), 2, (HashMap<String, String>) map, false);
        } catch (Throwable th) {
            bq.a().a(th.getMessage());
        }
    }

    private void a(t tVar, j jVar, HashMap<String, String> map) {
        if (tVar == null) {
            return;
        }
        try {
            by.a aVarA = by.a.a(tVar.t());
            aVarA.a(367).a(map).a("subType", 0L).a(FeedReqParams.REQ_TYPE_OPEN, true).a("real_open", this.d).a("open_timec", this.h).a("onpause", this.e).a("onstop", this.d).a("onp_dur", this.i).a("dp_fl_tp", this.g).a(com.baidu.mobads.container.components.command.j.C, bk.a(jVar));
            aVarA.a(jVar);
            aVarA.c(tVar.k());
            aVarA.a(tVar.z());
            aVarA.b(tVar.l());
            aVarA.f();
        } catch (Throwable th) {
            bq.a().a(th.getMessage());
        }
    }
}
