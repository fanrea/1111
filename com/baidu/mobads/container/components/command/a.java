package com.baidu.mobads.container.components.command;

import android.content.Context;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cd;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public void a(Context context, String str, com.baidu.mobads.container.adrequest.j jVar) {
        a(context, 2, str, jVar.getBuyer(), jVar.getQueryKey(), jVar.getAdId(), jVar.getAppPackageName(), 301, null, 0);
    }

    public void a(Context context, j jVar, boolean z) {
        a(context, jVar, z ? 2 : 1, z ? 307 : 107);
        com.baidu.mobads.container.components.a.o.a().a(204, jVar.Z);
    }

    public void b(Context context, j jVar, boolean z) {
        a(context, jVar, z ? 2 : 1, z ? 308 : 108);
    }

    public void a(Context context, j jVar, int i) {
        a(context, jVar, 2, i);
    }

    public void a(Context context, j jVar) {
        a(context, jVar, 1, 101);
    }

    public void b(Context context, j jVar) {
        a(context, jVar, 1, 102);
        com.baidu.mobads.container.components.a.o.a().a(203, jVar.d());
    }

    public void c(Context context, j jVar) {
        a(context, jVar, 1, 103);
        com.baidu.mobads.container.components.a.o.a().a(203, jVar);
    }

    public void a(Context context, String str) {
        com.baidu.mobads.container.components.a.o.a().a(203, str);
    }

    public void a(Context context, j jVar, String str) {
        a(context, jVar, 1, 104, str, 0);
    }

    public void d(Context context, j jVar) {
        a(context, jVar, 1, 105);
        com.baidu.mobads.container.components.a.o.a().a(204, jVar);
    }

    public void e(Context context, j jVar) {
        a(context, jVar, 1, 116);
        com.baidu.mobads.container.components.a.o.a().a(204, jVar);
    }

    public void f(Context context, j jVar) {
        a(context, jVar, 1, 118);
    }

    public void a(Context context, int i, int i2, j jVar, String str) {
        a(context, jVar, 1, i2, str, i);
    }

    private void a(Context context, j jVar, int i, int i2) {
        a(context, jVar, i, i2, null, 0);
    }

    private void a(Context context, j jVar, int i, int i2, String str, int i3) {
        if (context != null && jVar != null) {
            a(context, i, jVar.b("cur_prod", jVar.k()), jVar.b("cur_buyer", jVar.j()), jVar.b("cur_qk", jVar.i()), jVar.b("cur_adid", jVar.h()), jVar.Z, i2, str, i3);
        }
    }

    public void a(Context context, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, int i3) {
        HashMap map = new HashMap();
        map.put("dl_type", i + "");
        map.put("prod", str);
        map.put(j.f, str2);
        map.put("qk", str3);
        map.put("adid", str4);
        map.put("pk", str5);
        map.put("eventtime", System.currentTimeMillis() + "");
        map.put("eventtype", i2 + "");
        if (i3 > 0) {
            map.put("dialogtype", i3 + "");
        }
        if (str6 != null) {
            map.put("error", str6);
        }
        cd.a(context, 3, (HashMap<String, String>) map, false);
        by.a.a(context).a(1050).a("subtype", 3L).c(str).a("qk", str3).a("adid", str4).a(j.f, str2).a("pk", str5).a("dl_type", i).a("scene", i3).a("msg", i2).a("errormsg", str6).f();
    }
}
