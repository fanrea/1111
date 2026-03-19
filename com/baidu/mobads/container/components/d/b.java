package com.baidu.mobads.container.components.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.components.g.f;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.u;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public static final String a = "404";
    private static final String f = "temp_for_feed_response_html";
    protected final bq b = bq.a();
    private static b e = new b();
    public static volatile String c = "";
    public static volatile String d = "";
    private static boolean g = false;

    public static b a() {
        return e;
    }

    private b() {
    }

    public void a(Context context, j jVar) {
        try {
            a(context, 9, jVar);
            Iterator<String> it = jVar.aF.iterator();
            while (it.hasNext()) {
                new f(1, it.next()).a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(j jVar) {
    }

    public void b(Context context, j jVar) {
        a(context, 11, jVar);
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("ad", str3);
            map.put("stacktrace", str2);
            a(str, "404", map);
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> map) {
    }

    private void a(Context context, int i, j jVar) {
        if (jVar != null) {
            a aVar = new a(context, b(jVar));
            aVar.d = jVar.h();
            String message = jVar.T;
            if (!TextUtils.isEmpty(message)) {
                try {
                    String[] strArrSplit = message.split(context.getPackageName());
                    if (strArrSplit.length > 0) {
                        message = strArrSplit[strArrSplit.length - 1];
                    }
                } catch (Throwable th) {
                    message = th.getMessage();
                }
            }
            by.a.a(context).a(i).a("net", ab.g(context)).a(aVar.c()).a(j.m, u.a(message)).a("i_rc", com.baidu.mobads.container.h.a.a().B()).g();
        }
    }

    private j b(j jVar) {
        j jVar2 = new j(jVar.Z, jVar.R);
        jVar2.a(jVar.i(), jVar.h(), jVar.aa, jVar.ac, jVar.j());
        jVar2.a(jVar.n(), jVar.o(), jVar.p(), jVar.q(), jVar.r(), jVar.s(), jVar.t());
        jVar2.a(jVar.ay, jVar.az);
        jVar2.ad = jVar.ad;
        jVar2.a(jVar.S, jVar.T);
        jVar2.a(jVar.ah, jVar.ai, jVar.aj);
        jVar2.W = jVar.W;
        jVar2.ao = jVar.ao;
        jVar2.a(jVar.c());
        jVar2.b(jVar.e());
        jVar2.a(jVar.f());
        jVar2.av = jVar.av;
        jVar2.aw = jVar.aw;
        jVar2.ax = jVar.ax;
        jVar2.au = jVar.au;
        jVar2.as = jVar.as;
        jVar2.aA = jVar.aA;
        jVar2.aB = jVar.aB;
        jVar2.aC = jVar.aC;
        jVar2.aD = jVar.aD;
        jVar2.a(jVar.am);
        return jVar2;
    }
}
