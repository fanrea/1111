package com.baidu.mobads.container;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.bj;
import com.baidu.mobads.container.util.bn;
import com.baidu.mobads.container.util.bp;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.t;
import com.baidu.mobstat.forbes.Config;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    public static final int a = 0;
    public static final String e = "permission_storage";
    public static final String f = "permission_app_list";
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final String j = "empty";
    private static final String m = "lpShoubaiStyle";
    private static final String n = "lpMurlStyle";
    public static com.baidu.mobads.container.b.a.a b = null;
    public static long c = 0;
    public static boolean d = true;
    private static bq k = bq.a();
    private static final f l = new f();

    public static f a() {
        return l;
    }

    private f() {
    }

    public static Context b() {
        return com.baidu.mobads.container.config.b.a().c();
    }

    public static void a(String str) {
        com.baidu.mobads.container.components.command.j jVarA;
        com.baidu.mobads.container.components.command.c cVarA = com.baidu.mobads.container.components.command.c.a(str);
        if (cVarA != null && (jVarA = cVarA.a()) != null) {
            jVarA.ao = true;
        }
    }

    public static void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new com.baidu.mobads.container.components.g.f(i2, str).a();
    }

    public static void a(List<String> list, int i2) {
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                a(it.next(), i2);
            }
        } catch (Exception e2) {
            bq.a().a(e2);
        }
    }

    public static String c() {
        return com.baidu.mobads.container.config.b.a().j();
    }

    public static void a(Context context, String str, com.baidu.mobads.container.adrequest.j jVar, String str2, String str3, boolean z) {
        boolean zIsNoticeDlNonWifiSecJump;
        String clickThroughUrl = jVar.getClickThroughUrl();
        String queryKey = jVar.getQueryKey();
        String appPackageName = jVar.getAppPackageName();
        com.baidu.mobads.container.components.command.o oVarA = com.baidu.mobads.container.components.command.o.a(jVar);
        oVarA.A = z;
        oVarA.x = str3;
        oVarA.b = str2;
        oVarA.a = str;
        oVarA.a("creative_id", bp.a().a(jVar.getOriginJsonObject(), "creative_id"));
        oVarA.a("uniqueId", jVar.getUniqueId());
        if ("lp_normal".equals(str3)) {
            appPackageName = com.baidu.mobads.container.util.ap.a(clickThroughUrl);
            oVarA.j = appPackageName;
        }
        com.baidu.mobads.container.components.command.j jVarA = com.baidu.mobads.container.components.command.j.a(context, appPackageName);
        if (jVarA != null) {
            a(jVarA, oVarA);
            if (jVarA.X == b.a.COMPLETED && a(context, jVarA, oVarA)) {
                a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_DL_COMPLETE);
                a(jVarA, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
                return;
            }
            by.a(oVarA.d());
        }
        try {
            zIsNoticeDlNonWifiSecJump = jVar.isNoticeDlNonWifiSecJump();
        } catch (Throwable th) {
            zIsNoticeDlNonWifiSecJump = false;
        }
        if (TextUtils.isEmpty(queryKey)) {
            String strA = a(context, clickThroughUrl);
            if (TextUtils.isEmpty(strA)) {
                strA = "empty_url";
            }
            jVar.setQueryKey(strA);
        }
        if (!com.baidu.mobads.container.util.ab.f(context) && z && zIsNoticeDlNonWifiSecJump) {
            com.baidu.mobads.container.util.ab.a(context, new g(context, oVarA));
        } else {
            a(context, 2, oVarA);
        }
        bp.a().a(context, 430, "startDownload", oVarA);
    }

    public static void a(Context context, int i2, com.baidu.mobads.container.components.command.o oVar) {
        oVar.B = 1 == i2;
        oVar.w = i2;
        oVar.a("pkgmd5", com.baidu.mobads.container.util.ap.a(oVar.i()));
        new com.baidu.mobads.container.components.command.m(context.getApplicationContext(), oVar).a();
        bp.a().a(context, 1046, "downloadConfirm", oVar);
    }

    public static String a(Context context, String str) {
        String strA;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(Config.replace);
        if (context == null) {
            strA = "";
        } else {
            strA = IDManager.getInstance().a(context);
        }
        sb.append(strA);
        return com.baidu.mobads.container.util.ap.a(sb.toString());
    }

    public static void a(Context context, String str, com.baidu.mobads.container.adrequest.j jVar) {
        a(context, str, jVar, null, "silence", false);
    }

    public void a(com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar) throws JSONException {
        Context contextT = tVar.t();
        if (jVar.getActionType() == 2 && com.baidu.mobads.container.util.e.a.a.equals(com.baidu.mobads.container.util.e.a.f(b()))) {
            b.a aVarC = c(jVar.getAppPackageName());
            if (!com.baidu.mobads.container.util.j.b(contextT, jVar.getAppPackageName()) && aVarC != b.a.COMPLETED) {
                jVar.setAutoOpen(false);
                jVar.setPopNotif(false);
                a(contextT, tVar.z(), jVar);
            }
        }
    }

    public static com.baidu.mobads.container.components.e.b b(String str) {
        Context contextC = com.baidu.mobads.container.config.b.a().c();
        if (contextC != null && !TextUtils.isEmpty(str)) {
            try {
                return com.baidu.mobads.container.components.e.f.a(contextC).b(str);
            } catch (Exception e2) {
                bq.a().a(e2.getMessage());
                return null;
            }
        }
        return null;
    }

    public static b.a c(String str) throws JSONException {
        int i2;
        String string;
        try {
            Context contextB = b();
            string = contextB.getSharedPreferences(com.baidu.mobads.container.util.j.a, 0).getString(str + com.baidu.mobads.container.components.command.j.b + bn.a().a(contextB), null);
        } catch (Exception e2) {
        }
        if (string != null) {
            int i3 = new JSONObject(string).getInt("dl");
            b.a[] aVarArrValues = b.a.values();
            b.a aVar = b.a.NONE;
            for (i2 = 0; i2 < aVarArrValues.length; i2++) {
                if (aVarArrValues[i2].b() == i3) {
                    aVar = aVarArrValues[i2];
                }
            }
            return aVar;
        }
        if (b(str) != null) {
            return b(str).i();
        }
        return b.a.NONE;
    }

    public static Field a(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredField(str);
            } catch (Exception e2) {
            }
        }
        return null;
    }

    public static HashMap<String, Object> b(com.baidu.mobads.container.adrequest.t tVar, com.baidu.mobads.container.adrequest.j jVar) {
        int iOptInt;
        try {
            JSONObject originJsonObject = jVar.getOriginJsonObject();
            int iOptInt2 = originJsonObject.optInt("midpage_type");
            String strOptString = originJsonObject.optString("murl");
            int iOptInt3 = originJsonObject.optInt("act");
            if (!"video".equals(jVar.getMaterialType())) {
                iOptInt = -1;
            } else {
                iOptInt = originJsonObject.optInt("video_lp_type", -1);
            }
            String str = "";
            if (iOptInt == 1) {
                str = App2Activity.LP_STYLE_VIDEO;
            } else if (iOptInt == 2) {
                str = App2Activity.LP_STYLE_FLOATING_VIDEO;
            }
            HashMap<String, Object> map = new HashMap<>();
            if (!TextUtils.isEmpty(str) && (("feed".equals(tVar.k()) || "pvideo".equals(tVar.k()) || "rvideo".equals(tVar.k()) || "fvideo".equals(tVar.k())) && iOptInt3 == 1)) {
                App2Activity.MURL_SECOND_CONFIRM.set(true);
                map.put(n, App2Activity.MURL_SECOND_CONFIRM_NEW);
                map.put(m, str);
                return map;
            }
            if (iOptInt == -1 && "feed".equals(tVar.k())) {
                if (TextUtils.isEmpty(strOptString) || iOptInt2 == 0) {
                    if (com.baidu.mobads.container.util.ab.a((Class<?>) com.baidu.mobads.container.adrequest.j.class, "getAction", (Class<?>[]) new Class[0])) {
                        String action = jVar.getAction();
                        if (!TextUtils.isEmpty(action) && action.equals("video")) {
                            map.put(m, App2Activity.LP_STYLE_VIDEO);
                        }
                    }
                } else if (Double.valueOf(c()).doubleValue() >= 8.5d) {
                    if (com.baidu.mobads.container.util.ab.a((Class<?>) com.baidu.mobads.container.adrequest.j.class, "setWebUrl", (Class<?>[]) new Class[]{String.class})) {
                        if (iOptInt2 == 1) {
                            App2Activity.MURL_SECOND_CONFIRM.set(true);
                            map.put(n, App2Activity.MURL_SECOND_CONFIRM_NEW);
                            map.put(m, App2Activity.LP_STYLE_VIDEO);
                        } else if (iOptInt2 == 2) {
                            App2Activity.MURL_WEB.set(true);
                            map.put(n, App2Activity.MURL_WEB_NEW);
                            map.put(m, App2Activity.LP_STYLE_VIDEO);
                            if (iOptInt3 == 1) {
                                jVar.setWebUrl(strOptString);
                            }
                        }
                    } else {
                        if (iOptInt3 == 2) {
                            jVar.setActionType(1);
                        }
                        if (iOptInt2 == 1) {
                            map.put(m, App2Activity.LP_STYLE_VIDEO);
                            App2Activity.MURL_SECOND_CONFIRM.set(true);
                            map.put(n, App2Activity.MURL_SECOND_CONFIRM_NEW);
                        } else if (iOptInt2 == 2) {
                            map.put(m, App2Activity.LP_STYLE_VIDEO);
                            App2Activity.MURL_WEB.set(true);
                            map.put(n, App2Activity.MURL_WEB_NEW);
                            jVar.setClickThroughUrl(strOptString);
                        }
                    }
                }
                return map;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private static void a(com.baidu.mobads.container.components.command.j jVar, com.baidu.mobads.container.components.h.a aVar) {
        if (jVar != null) {
            try {
                if (jVar.am != null && aVar != null) {
                    String str = jVar.am.get("uniqueId");
                    if (com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END.b() == aVar.b()) {
                        com.baidu.mobads.container.components.h.d.b(str);
                    } else {
                        com.baidu.mobads.container.components.h.d.a(str, aVar);
                    }
                }
            } catch (Exception e2) {
                bq.a().a(e2);
            }
        }
    }

    protected static boolean a(Context context, com.baidu.mobads.container.components.command.j jVar, com.baidu.mobads.container.components.command.o oVar) {
        boolean zB = com.baidu.mobads.container.util.j.b(context, jVar.Z);
        bp bpVarA = bp.a();
        if (zB) {
            bpVarA.a(context, bu.i, bp.a, oVar);
            new com.baidu.mobads.container.components.command.a().f(context, jVar);
            a(jVar, com.baidu.mobads.container.components.h.a.EVENT_DL_OPEN);
            bj.b(context, jVar.Z);
            if (oVar != null) {
                com.baidu.mobads.container.components.h.a.a.a().b(oVar.g(), oVar.a(), 301, true);
            }
            return true;
        }
        String str = jVar.T + jVar.S;
        File file = new File(str);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        bpVarA.a(context, bu.i, bp.b, oVar);
        new com.baidu.mobads.container.components.command.a().e(context, jVar);
        a(jVar, com.baidu.mobads.container.components.h.a.EVENT_DL_INSTALL);
        t.a aVarE = com.baidu.mobads.container.util.t.e(context, str);
        if (aVarE != null && !TextUtils.isEmpty(aVarE.c) && !aVarE.c.equals(jVar.Z)) {
            jVar.b(context);
            jVar.Z = aVarE.c;
            if (com.baidu.mobads.container.util.j.b(context, jVar.Z)) {
                bpVarA.a(context, bu.i, "alreadyinstalled_call_openapp1", oVar);
                a(jVar, com.baidu.mobads.container.components.h.a.EVENT_DL_OPEN);
                bj.b(context, jVar.Z);
                by.a(oVar.d());
                com.baidu.mobads.container.components.h.a.a.a().b(oVar.g(), oVar.a(), 301, true);
                return true;
            }
        }
        com.baidu.mobads.container.components.h.a.a.a().b(oVar.g(), oVar.a(), 300, false);
        com.baidu.mobads.container.components.c.g.a().a(context, jVar);
        com.baidu.mobads.container.util.j.a(context, file, jVar);
        return true;
    }

    private static void a(com.baidu.mobads.container.components.command.j jVar, com.baidu.mobads.container.components.command.o oVar) {
        if (jVar != null && oVar != null) {
            jVar.ad = oVar.k();
            jVar.ao = !oVar.e();
            jVar.ac = oVar.t();
            jVar.as = false;
            if (oVar.m() && !TextUtils.isEmpty(oVar.p())) {
                jVar.as = true;
                jVar.at = oVar.p();
            }
            jVar.a(oVar.x());
            jVar.a(oVar.x, oVar.w);
            jVar.c("cur_qk", oVar.g());
            jVar.c("cur_adid", oVar.a());
            jVar.c("cur_buyer", oVar.h);
            jVar.c("cur_apid", oVar.r());
            jVar.c("cur_prod", oVar.q());
            jVar.c("cur_appsid", oVar.s());
            jVar.c("cur_url", oVar.d());
            try {
                jVar.c("act", String.valueOf(oVar.b()));
            } catch (Exception e2) {
            }
        }
    }
}
