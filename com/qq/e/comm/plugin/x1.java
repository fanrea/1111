package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.GDTLogger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x1 {
    private static final Random a = new Random(System.currentTimeMillis());
    private static final Map<String, Integer> b = new ConcurrentHashMap();
    private static final Set<String> c;
    private static final AtomicInteger d;
    private static final AtomicInteger e;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e2.values().length];
            a = iArr;
            try {
                iArr[e2.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        c = copyOnWriteArraySet;
        copyOnWriteArraySet.add("shakable");
        copyOnWriteArraySet.add("sensor_ts");
        d = new AtomicInteger(1);
        e = new AtomicInteger(1);
    }

    private static String b() {
        return (String) pro.getobjresult(322, 1, new Object[0]);
    }

    private static void a(aw awVar, w1 w1Var) {
        String strA = h1.a(w1Var.f(), 1);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        awVar.a("dev_ext", strA);
    }

    private static String b(JSONObject jSONObject, w1 w1Var) {
        String str = jSONObject.optString("sdkver") + jSONObject.optString("c_os") + jSONObject.optString("muidtype") + jSONObject.optString("muid") + jSONObject.optString("c_pkgname") + jSONObject.optInt("postype") + w1Var.w();
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes(d6.a));
        return "0001" + Long.toHexString(crc32.getValue());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(63:0|2|(1:4)|5|(1:7)|8|(3:10|(1:12)|(1:15))(2:16|(56:18|21|(1:23)|24|(1:26)(1:27)|28|(1:30)(1:31)|32|(1:34)|35|(1:39)|143|40|(1:42)|45|(3:47|(2:50|48)|145)|51|(1:53)|54|(2:59|(1:65)(2:66|(1:70)))(1:58)|71|(1:73)|74|(1:76)|77|(1:79)|80|(1:82)|83|(1:85)|86|(1:89)|90|(1:92)|93|(1:97)|98|(1:100)|101|(1:103)|104|141|105|109|(1:111)|112|(1:114)|115|(1:117)|118|(4:120|(1:122)|123|(1:125))|126|(2:128|(2:130|136)(2:133|136))|137|(1:139)|140)(1:19))|20|21|(0)|24|(0)(0)|28|(0)(0)|32|(0)|35|(2:37|39)(0)|143|40|(0)|45|(0)|51|(0)|54|(3:56|59|(3:61|63|65)(2:63|65))(0)|71|(0)|74|(0)|77|(0)|80|(0)|83|(0)|86|(1:89)|90|(0)|93|(2:95|97)|98|(0)|101|(0)|104|141|105|109|(0)|112|(0)|115|(0)|118|(0)|126|(0)|137|(0)|140) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x040c, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x040d, code lost:
    
        r10.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x04a2, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f7 A[Catch: all -> 0x01fd, TRY_LEAVE, TryCatch #1 {all -> 0x01fd, blocks: (B:40:0x01ed, B:42:0x01f7), top: B:143:0x01ed }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0389  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject b(com.qq.e.comm.plugin.r1 r10, com.qq.e.comm.plugin.aw r11, com.qq.e.comm.plugin.w1 r12) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.x1.b(com.qq.e.comm.plugin.r1, com.qq.e.comm.plugin.aw, com.qq.e.comm.plugin.w1):org.json.JSONObject");
    }

    private static void c(JSONObject jSONObject, w1 w1Var) throws JSONException {
        int iX = w1Var.x();
        if (iX == e2.SPLASH.e()) {
            jSONObject.put("placement_type", 4);
            jSONObject.put("render_type", 1);
        } else if (iX == e2.NATIVEEXPRESSAD.e()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 3);
        }
        if (iX == e2.REWARDVIDEOAD.e()) {
            jSONObject.put("placement_type", 10);
            jSONObject.put("render_type", 1);
            return;
        }
        if (iX == e2.NATIVEUNIFIEDAD.e()) {
            jSONObject.put("placement_type", 9);
            jSONObject.put("render_type", 1);
            jSONObject.put("support_container", true);
        } else if (iX == e2.UNIFIED_BANNER.e()) {
            jSONObject.put("placement_type", 1);
            jSONObject.put("render_type", 3);
        } else if (iX == e2.UNIFIED_INTERSTITIAL.e() || iX == e2.UNIFIED_INTERSTITIAL_FULLSCREEN.e()) {
            jSONObject.put("placement_type", 2);
            jSONObject.put("render_type", 3);
        }
    }

    private static boolean b(int i) {
        String strC = r1.d().f().c("fixedDurationSupportPosTypes");
        if (TextUtils.isEmpty(strC)) {
            return e2.NATIVEEXPRESSAD.e() == i || e2.UNIFIED_INTERSTITIAL.e() == i || e2.NATIVEUNIFIEDAD.e() == i || e2.UNIFIED_INTERSTITIAL_FULLSCREEN.e() == i;
        }
        return Arrays.asList(strC.split(",")).contains(Integer.toString(i));
    }

    public static void a(JSONObject jSONObject, String str, w1 w1Var) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (w1Var == null || (!w1Var.K() && w1Var.z() == 0)) {
            jSONObject.putOpt("posrn", Integer.valueOf(t1.c().b(str)));
        }
    }

    private static void a(Context context, w1 w1Var, JSONObject jSONObject) throws JSONException {
        if (w1Var.g() == mb.UNION_ADAPTER) {
            if (!TextUtils.isEmpty(w1Var.q())) {
                jSONObject.put("mgpi", w1Var.q());
            }
            jSONObject.put("mc_f", 1);
            int iA = kp.b().a(w1Var.w(), context);
            if (iA >= 0) {
                jSONObject.put("mc_s", iA);
                return;
            }
            return;
        }
        int iC = kp.b().c(w1Var.w());
        if (iC >= 0) {
            jSONObject.put("mc_f", iC);
        }
        boolean z = r1.d().f().a("enpamedi", w1Var.w(), 1) == 1;
        Map<String, String> mapF = w1Var.f();
        if (mapF == null || mapF.size() <= 0) {
            return;
        }
        String strRemove = mapF.remove("staIn");
        String strRemove2 = mapF.remove("meSrc");
        String strRemove3 = mapF.remove("thrmei");
        if (z) {
            if (!TextUtils.isEmpty(strRemove2)) {
                try {
                    jSONObject.put("mc_f", Integer.valueOf(strRemove2));
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(strRemove3)) {
                jSONObject.put("thrmei", strRemove3);
            }
            int iA2 = kp.b().a(strRemove);
            if (iA2 > 0) {
                jSONObject.put("mc_s", iA2);
            }
        }
    }

    private static void a(w1 w1Var, JSONObject jSONObject) throws JSONException {
        int iR = w1Var.r();
        int iP = w1Var.p();
        if (iP > 0 && iP < iR) {
            GDTLogger.e("参数设置错误 , minVideoDuration不能大于maxVideoDuration");
            jSONObject.put("max_duration", r1.d().f().a("serverRequestMaxVideoDuration", 301));
            return;
        }
        if (iR > 0) {
            jSONObject.put("min_duration", iR);
        }
        if (iP > 0) {
            jSONObject.put("max_duration", iP);
        }
    }

    public static Map<String, String> a(aw awVar, r1 r1Var, w1 w1Var) throws JSONException {
        awVar.a("adposcount", String.valueOf(w1Var.a()));
        awVar.a("count", String.valueOf(w1Var.d()));
        if (qp.d(w1Var.w())) {
            awVar.a("mposid", w1Var.w());
            w1Var.a(true);
            if (!qp.b()) {
                b10.a(1450000, new f5().c(w1Var.w()), 0, null);
            }
        } else {
            awVar.a("posid", w1Var.w());
        }
        if (!u2.a().b() && o1.b()) {
            b10.a(9720003, new f5().c(w1Var.w()).a(w1Var.b()));
        } else {
            awVar.a("mu_p", u2.a().a(w1Var.w()));
        }
        if (!TextUtils.isEmpty(w1Var.E())) {
            awVar.a(NetworkDefine.PARAM_TOKEN, w1Var.E());
            awVar.a("sbt", "2");
        }
        int iX = w1Var.x();
        if (iX == e2.SPLASH.e()) {
            awVar.a("spsa", "1");
        } else if (iX == e2.NATIVEEXPRESSAD.e()) {
            awVar.a("template_count", String.valueOf(1));
            awVar.a("actual_width", String.valueOf(w1Var.u()));
            awVar.a("actual_height", String.valueOf(w1Var.t()));
        }
        int iY = w1Var.y();
        int iV = w1Var.v();
        if (iY > 0 && iV > 0) {
            awVar.a("posw", String.valueOf(iY));
            awVar.a("posh", String.valueOf(iV));
        }
        if (w1Var.e() > 0) {
            awVar.a("datatype", String.valueOf(w1Var.e()));
        }
        if (w1Var.o() != null && w1Var.o().getValue() > 0) {
            awVar.a("login_type", String.valueOf(w1Var.o().getValue()));
        }
        if (!TextUtils.isEmpty(w1Var.m())) {
            awVar.a("login_appid", w1Var.m());
        }
        if (!TextUtils.isEmpty(w1Var.n())) {
            awVar.a("login_openid", w1Var.n());
        }
        if (!TextUtils.isEmpty(w1Var.F())) {
            awVar.a("uin", w1Var.F());
        }
        if (r1Var.f().a("flow_control", 0) == 1) {
            awVar.a("fc", "1");
        }
        if (r1Var.f().a("support_https", 1) == 1) {
            awVar.a("support_https", "1");
        }
        awVar.a("ext", a(r1Var, awVar, w1Var).toString());
        a(awVar, w1Var);
        JSONObject jSONObjectA = a(w1Var);
        if (jSONObjectA != null) {
            awVar.a("outerext", jSONObjectA.toString());
        }
        awVar.a(com.kuaishou.weapon.p0.t.k, String.valueOf(Math.random()));
        return awVar.i();
    }

    private static JSONObject a(r1 r1Var, aw awVar, w1 w1Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("req", b(r1Var, awVar, w1Var));
        if (!TextUtils.isEmpty(w1Var.k())) {
            jSONObject.put("inex", Integer.parseInt(w1Var.k()));
        }
        return ln.a(jSONObject, w1Var.i());
    }

    private static JSONObject a(w1 w1Var) throws JSONException {
        if (w1Var.c() == null || w1Var.c().size() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("category", new JSONArray((Collection) w1Var.c()));
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c A[Catch: JSONException -> 0x0088, TryCatch #0 {JSONException -> 0x0088, blocks: (B:29:0x007b, B:31:0x0081, B:32:0x0084, B:36:0x008c, B:38:0x0092), top: B:51:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.qq.e.comm.plugin.r1 r6, org.json.JSONObject r7, com.qq.e.comm.plugin.w1 r8) throws org.json.JSONException {
        /*
            com.qq.e.comm.plugin.ma r0 = com.qq.e.comm.plugin.ma.IMEI
            com.qq.e.comm.plugin.la r1 = r0.c()
            android.content.Context r2 = r6.a()
            java.lang.String r1 = r1.b(r2)
            java.lang.String r0 = r0.b()
            r7.putOpt(r0, r1)
            com.qq.e.comm.plugin.ma r0 = com.qq.e.comm.plugin.ma.ANDROIDID
            java.lang.String r2 = r0.b()
            android.content.Context r6 = r6.a()
            java.lang.String r6 = r0.a(r6)
            r7.putOpt(r2, r6)
            com.qq.e.comm.plugin.r1 r6 = com.qq.e.comm.plugin.r1.d()
            com.qq.e.comm.plugin.vx r6 = r6.f()
            if (r6 == 0) goto L99
            java.lang.String r8 = r8.w()
            java.lang.String r0 = "ex_exp_info"
            java.lang.String r8 = r6.c(r0, r8)
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r3 = "exp_id"
            r4 = 0
            if (r2 != 0) goto L56
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4f
            r2.<init>(r8)     // Catch: org.json.JSONException -> L4f
            org.json.JSONArray r8 = r2.optJSONArray(r3)     // Catch: org.json.JSONException -> L4d
            goto L58
        L4d:
            r8 = move-exception
            goto L51
        L4f:
            r8 = move-exception
            r2 = r4
        L51:
            r8.getMessage()
            r8 = r4
            goto L58
        L56:
            r8 = r4
            r2 = r8
        L58:
            java.lang.String r6 = r6.c(r0)
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 != 0) goto L76
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> L6e
            r5.<init>(r6)     // Catch: org.json.JSONException -> L6e
            org.json.JSONArray r4 = r5.optJSONArray(r3)     // Catch: org.json.JSONException -> L6c
            goto L73
        L6c:
            r6 = move-exception
            goto L70
        L6e:
            r6 = move-exception
            r5 = r4
        L70:
            r6.getMessage()
        L73:
            r6 = r4
            r4 = r5
            goto L77
        L76:
            r6 = r4
        L77:
            if (r2 == 0) goto L8a
            if (r4 == 0) goto L8a
            org.json.JSONArray r6 = com.qq.e.comm.plugin.ln.b(r6, r8)     // Catch: org.json.JSONException -> L88
            if (r6 == 0) goto L84
            r4.putOpt(r3, r6)     // Catch: org.json.JSONException -> L88
        L84:
            r7.putOpt(r0, r4)     // Catch: org.json.JSONException -> L88
            goto L99
        L88:
            r6 = move-exception
            goto L96
        L8a:
            if (r4 == 0) goto L90
            r7.putOpt(r0, r4)     // Catch: org.json.JSONException -> L88
            goto L99
        L90:
            if (r2 == 0) goto L99
            r7.putOpt(r0, r2)     // Catch: org.json.JSONException -> L88
            goto L99
        L96:
            r6.getMessage()
        L99:
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            r8 = 1
            if (r6 != 0) goto Laa
            java.lang.String r6 = "muidtype"
            r7.put(r6, r8)
            java.lang.String r6 = "muid"
            r7.put(r6, r1)
        Laa:
            java.lang.String r6 = "/display"
            com.qq.e.comm.plugin.c20.a(r8, r7, r6)
            com.qq.e.comm.plugin.r1 r6 = com.qq.e.comm.plugin.r1.d()
            com.qq.e.comm.plugin.vx r6 = r6.f()
            java.lang.String r0 = "plainIdsOn"
            int r6 = r6.a(r0, r8)
            if (r6 != r8) goto Lc8
            java.lang.String r6 = b()
            java.lang.String r0 = "m9"
            r7.put(r0, r6)
        Lc8:
            com.qq.e.comm.plugin.r1 r6 = com.qq.e.comm.plugin.r1.d()
            com.qq.e.comm.plugin.vx r6 = r6.f()
            java.lang.String r0 = "adson"
            int r6 = r6.a(r0, r8)
            if (r6 != r8) goto Leb
            com.qq.e.comm.plugin.ma r6 = com.qq.e.comm.plugin.ma.ALLID
            com.qq.e.comm.plugin.la r8 = r6.c()
            com.qq.e.comm.plugin.l2 r8 = (com.qq.e.comm.plugin.l2) r8
            org.json.JSONObject r8 = r8.b()
            java.lang.String r6 = r6.b()
            r7.putOpt(r6, r8)
        Leb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.x1.a(com.qq.e.comm.plugin.r1, org.json.JSONObject, com.qq.e.comm.plugin.w1):void");
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        qa qaVarC = r1.d().c();
        String strU = qaVarC.u();
        if (!TextUtils.isEmpty(strU)) {
            jSONObject.putOpt("c_webua", strU);
            return;
        }
        int iN = qaVarC.n();
        if (iN <= 0) {
            iN = 1;
        }
        if (o50.c()) {
            jSONObject.putOpt("c_release", qaVarC.r());
            jSONObject.putOpt("c_codename", qaVarC.f());
            jSONObject.putOpt("c_buildid", qaVarC.b());
            jSONObject.putOpt("c_chrover", o1.b() ? qaVarC.c() : qaVarC.e());
            jSONObject.putOpt("c_sw_size", String.valueOf(iN));
        }
    }

    private static JSONObject a() throws JSONException {
        Integer num;
        JSONObject jSONObject = new JSONObject();
        Map<String, String> extraUserData = GlobalSetting.getExtraUserData();
        if (extraUserData != null && !extraUserData.isEmpty()) {
            if (b.isEmpty()) {
                try {
                    String[] strArrSplit = r1.d().f().b("oudw", "*#1000").split("#");
                    for (int i = 0; i < strArrSplit.length / 2; i++) {
                        int i2 = i * 2;
                        b.put(strArrSplit[i2], Integer.valueOf(strArrSplit[i2 + 1]));
                    }
                } catch (Exception unused) {
                    b.put("*", 1000);
                }
            }
            for (Map.Entry<String, String> entry : extraUserData.entrySet()) {
                int length = entry.getValue().length();
                Map<String, Integer> map = b;
                Integer num2 = map.get("*");
                if ((num2 != null && length <= num2.intValue()) || ((num = map.get(entry.getKey())) != null && length <= num.intValue())) {
                    jSONObject.put("outer_" + entry.getKey(), entry.getValue());
                } else if (!c.contains(entry.getKey())) {
                    GDTLogger.e("GlobalSetting.extraUserData 参数不合法，参数已丢弃，请检查！");
                }
            }
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject, w1 w1Var) throws JSONException {
        bv bvVarC = bv.c();
        String strD = bvVarC.d();
        if (!TextUtils.isEmpty(strD)) {
            jSONObject.putOpt("m12", strD);
        } else if (w1Var == null) {
            bvVarC.h();
        } else {
            bvVarC.a(w1Var.b(), w1Var.w());
        }
    }

    private static boolean a(int i) {
        double dNextDouble = a.nextDouble();
        double d2 = i;
        Double.isNaN(d2);
        return dNextDouble < d2 * 0.001d;
    }

    public static JSONObject a(r1 r1Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = y2.a;
        String str2 = y2.b;
        String str3 = y2.c;
        String str4 = y2.d;
        String str5 = y2.e;
        try {
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            jSONObject.put("br", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            jSONObject.put("de", str2);
            if (TextUtils.isEmpty(str3)) {
                str3 = null;
            }
            jSONObject.put("fp", str3);
            if (TextUtils.isEmpty(str4)) {
                str4 = null;
            }
            jSONObject.put("hw", str4);
            if (TextUtils.isEmpty(str5)) {
                str5 = null;
            }
            jSONObject.put(Config.PRINCIPAL_PART, str5);
            jSONObject.put("is_d", y2.a(r1Var.a()));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static b2 a(e2 e2Var, int i) {
        if (a.a[e2Var.ordinal()] != 1) {
            return null;
        }
        if (i >= 320) {
            return b2.e;
        }
        return b2.d;
    }
}
