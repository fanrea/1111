package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.widget.ImageView;
import com.pandora.common.utils.Times;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.fo;
import com.qq.e.comm.plugin.gb;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pu extends w4 {
    private static final pu e = new pu();
    private long b;
    private String c;
    private final Object a = new Object();
    private Map<String, Long> d = new ConcurrentHashMap();

    private pu() {
    }

    /* compiled from: A */
    class a implements fo.c {
        final /* synthetic */ e2 a;
        final /* synthetic */ mb b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ int f;
        final /* synthetic */ f5 g;

        a(e2 e2Var, mb mbVar, String str, String str2, String str3, int i, f5 f5Var) {
            this.a = e2Var;
            this.b = mbVar;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = i;
            this.g = f5Var;
        }

        @Override // com.qq.e.comm.plugin.fo.c
        public void a(eo eoVar) {
            GDTLogger.e("预加载失败！", eoVar);
            b10.a(1012004, this.g, Integer.valueOf(this.f));
        }

        @Override // com.qq.e.comm.plugin.fo.c
        public void a(JSONObject jSONObject) throws JSONException {
            pu.this.a(jSONObject, this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, e2 e2Var, mb mbVar, String str, String str2, String str3, int i) throws JSONException {
        a(jSONObject, e2Var, mbVar, str, str2, str3, (mu) null, i);
    }

    /* compiled from: A */
    class b implements nm {
        final /* synthetic */ f5 a;
        final /* synthetic */ int b;

        b(f5 f5Var, int i) {
            this.a = f5Var;
            this.b = i;
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            if (koVar.a()) {
                b10.a(1012012, this.a, Integer.valueOf(this.b));
            } else {
                b10.a(1012014, this.a, Integer.valueOf(this.b));
            }
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
            b10.a(1012015, this.a, Integer.valueOf(this.b));
        }
    }

    /* compiled from: A */
    class c extends ez {
        final /* synthetic */ f5 a;
        final /* synthetic */ int b;

        c(f5 f5Var, int i) {
            this.a = f5Var;
            this.b = i;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            b10.a(1012017, this.a, Integer.valueOf(this.b));
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            b10.a(1012016, this.a, Integer.valueOf(this.b));
        }
    }

    public List<mu> b(String str, String str2, String str3, e2 e2Var, mb mbVar) {
        return a(str, str2, str3, e2Var, mbVar, null);
    }

    private void a(JSONObject jSONObject, e2 e2Var, mb mbVar, String str, String str2, String str3, mu muVar, int i) throws JSONException {
        int length;
        mu muVar2;
        JSONArray jSONArray;
        f5 f5Var;
        mu muVar3;
        f5 f5VarA = new f5().c(str2).a(e2Var);
        if (jSONObject.optInt("ret") != 0) {
            b10.a(1012005, f5VarA, Integer.valueOf(i));
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject == null) {
            b10.a(1012005, f5VarA, Integer.valueOf(i));
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str2);
        if (jSONObjectOptJSONObject2 == null) {
            b10.a(1012005, f5VarA, Integer.valueOf(i));
            return;
        }
        if (jSONObjectOptJSONObject2.optInt("ret") != 0) {
            b10.a(1012005, f5VarA, Integer.valueOf(i));
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("list");
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                q8.a().a(e2.SPLASH, jSONArrayOptJSONArray.optJSONObject(i2));
            }
            ja jaVar = new ja();
            jaVar.a("cnt", Integer.valueOf(length));
            b10.a(1012006, f5VarA, Integer.valueOf(i), 0, jaVar);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("list", jSONArrayOptJSONArray);
                a(str2, jSONObject2);
            } catch (JSONException e2) {
                e2.getMessage();
            }
            synchronized (this.a) {
                File fileG = gu.g(str2);
                if (fileG.exists()) {
                    gu.a(fileG);
                    b10.a(1012007, f5VarA, Integer.valueOf(i));
                }
                fileG.mkdirs();
                g00.c(str2);
                this.d.clear();
                gu.c(gu.e(str2), jSONObject2.toString());
                b10.a(1012008, f5VarA, Integer.valueOf(i));
            }
            int i3 = 0;
            while (i3 < jSONArrayOptJSONArray.length()) {
                mu muVar4 = new mu(str, str2, str3, jSONArrayOptJSONArray.optJSONObject(i3), mbVar);
                if (TextUtils.isEmpty(muVar4.K1()) || TextUtils.isEmpty(muVar4.M1()) || str2.equals(muVar4.K1())) {
                    muVar2 = muVar4;
                    jSONArray = jSONArrayOptJSONArray;
                    f5Var = f5VarA;
                } else {
                    muVar2 = muVar4;
                    jSONArray = jSONArrayOptJSONArray;
                    f5Var = f5VarA;
                    a(jSONObject, e2Var, mbVar, str, muVar4.K1(), str3, muVar2, i);
                }
                muVar2.O1();
                gu.d(muVar2.c0());
                b10.a(1012013, f5Var);
                mm.a().a(muVar2.c0(), new b(f5Var, i));
                if (TextUtils.isEmpty(muVar2.V0())) {
                    muVar3 = muVar2;
                } else {
                    b10.a(1012011, f5Var, Integer.valueOf(i));
                    muVar3 = muVar2;
                    a(muVar3, f5Var, i);
                }
                if (muVar != null && muVar.L1() == null && muVar3.y0().equals(muVar.K1()) && muVar3.O1().equals(muVar.M1())) {
                    muVar.a(muVar3);
                    return;
                } else {
                    i3++;
                    f5VarA = f5Var;
                    jSONArrayOptJSONArray = jSONArray;
                }
            }
            return;
        }
        b10.a(1012005, f5VarA, Integer.valueOf(i));
        a(2011007, f5VarA, this.b);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static List<mu> a(List<mu> list) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            i = 0;
        } else {
            String str = new SimpleDateFormat(Times.YYYY_MM_DD, Locale.US).format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime());
            i = 0;
            int i3 = 0;
            for (mu muVar : list) {
                if (a(muVar)) {
                    ArrayList arrayList2 = new ArrayList();
                    List<kz> listN1 = muVar.N1();
                    if (listN1 != null && listN1.size() > 0) {
                        boolean z = false;
                        for (kz kzVar : listN1) {
                            if (str.equals(kzVar.a())) {
                                arrayList2.add(kzVar);
                                z = true;
                            }
                        }
                        if (z && !k.c(muVar)) {
                            muVar.a(arrayList2);
                            arrayList.add(muVar);
                        }
                    }
                    i3++;
                } else {
                    i++;
                }
            }
            i2 = i3;
        }
        if (arrayList.size() == 0) {
            b10.a(1013011, null, Integer.valueOf(i), Integer.valueOf(i2), null);
        }
        return arrayList;
    }

    public List<mu> a(String str, String str2, String str3, e2 e2Var, mb mbVar) {
        List<mu> listB = b(str, str2, str3, e2Var, mbVar);
        List<mu> listA = a(listB);
        if (listB.size() > 0 && listA.size() <= 0) {
            a(2011008, new f5().c(str2), this.b);
        }
        return listA;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fd A[EDGE_INSN: B:56:0x00fd->B:52:0x00fd BREAK  A[LOOP:0: B:23:0x0058->B:48:0x00f6], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.qq.e.comm.plugin.mu> a(java.lang.String r16, java.lang.String r17, java.lang.String r18, com.qq.e.comm.plugin.e2 r19, com.qq.e.comm.plugin.mb r20, com.qq.e.comm.plugin.mu r21) {
        /*
            r15 = this;
            r8 = r15
            r9 = r17
            r10 = r21
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            if (r0 != 0) goto Lfd
            java.lang.Object r1 = r8.a
            monitor-enter(r1)
            java.io.File r0 = com.qq.e.comm.plugin.gu.e(r17)     // Catch: java.lang.Throwable -> Lfa
            java.lang.String r0 = com.qq.e.comm.plugin.gu.d(r0)     // Catch: java.lang.Throwable -> Lfa
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lfa
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto Lfd
            r1 = 0
            java.lang.String r2 = "["
            boolean r2 = r0.startsWith(r2)     // Catch: org.json.JSONException -> L41
            if (r2 == 0) goto L32
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L41
            r2.<init>(r0)     // Catch: org.json.JSONException -> L41
            r0 = r2
            goto L46
        L32:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L41
            r2.<init>(r0)     // Catch: org.json.JSONException -> L41
            java.lang.String r0 = "list"
            org.json.JSONArray r1 = r2.optJSONArray(r0)     // Catch: org.json.JSONException -> L41
            r15.b(r9, r2)     // Catch: org.json.JSONException -> L41
            goto L45
        L41:
            r0 = move-exception
            r0.getMessage()
        L45:
            r0 = r1
        L46:
            if (r0 == 0) goto Lfd
            int r1 = r0.length()
            if (r1 <= 0) goto Lfd
            com.qq.e.comm.plugin.r1 r1 = com.qq.e.comm.plugin.r1.d()
            android.content.Context r12 = r1.a()
            r1 = 0
            r13 = 0
        L58:
            int r1 = r0.length()
            if (r13 >= r1) goto Lfd
            org.json.JSONObject r5 = r0.optJSONObject(r13)
            int r1 = com.qq.e.comm.plugin.k.a(r12, r5)
            if (r1 == 0) goto L6f
            java.lang.String r1 = "uoid"
            r5.optString(r1)
            goto Lf6
        L6f:
            com.qq.e.comm.plugin.mu r14 = new com.qq.e.comm.plugin.mu
            r1 = r14
            r2 = r16
            r3 = r17
            r4 = r18
            r6 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            java.lang.String r1 = r14.S0()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L9c
            java.util.Map<java.lang.String, java.lang.Long> r1 = r8.d
            java.lang.String r2 = r14.S0()
            java.lang.Object r1 = r1.get(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            if (r1 == 0) goto L9c
            long r1 = r1.longValue()
            r14.g(r1)
        L9c:
            r11.add(r14)
            java.lang.String r1 = r14.K1()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto Lce
            java.lang.String r1 = r14.M1()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto Lce
            java.lang.String r1 = r14.K1()
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto Lce
            java.lang.String r3 = r14.K1()
            r1 = r15
            r2 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r14
            r1.a(r2, r3, r4, r5, r6, r7)
        Lce:
            if (r10 == 0) goto Lf6
            com.qq.e.comm.plugin.mu r1 = r21.L1()
            if (r1 != 0) goto Lf6
            java.lang.String r1 = r14.y0()
            java.lang.String r2 = r21.K1()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lf6
            java.lang.String r1 = r14.O1()
            java.lang.String r2 = r21.M1()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lf6
            r10.a(r14)
            goto Lfd
        Lf6:
            int r13 = r13 + 1
            goto L58
        Lfa:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lfa
            throw r0
        Lfd:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.pu.a(java.lang.String, java.lang.String, java.lang.String, com.qq.e.comm.plugin.e2, com.qq.e.comm.plugin.mb, com.qq.e.comm.plugin.mu):java.util.List");
    }

    public void a(e2 e2Var, mb mbVar, String str, String str2, String str3, j jVar, LoadAdParams loadAdParams, int i) throws JSONException {
        f5 f5VarC = new f5().c(str2);
        b10.a(1012001, f5VarC, Integer.valueOf(i));
        int iA = r1.d().f().a("preloadNetwork", -1);
        zr zrVarP = r1.d().c().p();
        if ((iA & zrVarP.d()) <= 0) {
            b10.b(100052, f5VarC, Integer.valueOf(zrVarP.d()));
            GDTLogger.w("当前设备的网络类型不符合预加载广告的条件，请尝试WIFI环境。如仍有问题请联系客服");
            return;
        }
        b10.a(1012003, f5VarC, Integer.valueOf(i));
        w1 w1Var = new w1(e2Var);
        w1Var.l(1);
        w1Var.f(str2);
        w1Var.g(str3);
        w1Var.a(1);
        w1Var.b(r1.d().f().a("splashPreloadAdCount", 10));
        w1Var.c(2);
        w1Var.a(mbVar);
        w1Var.e(this.c);
        w1Var.a(q8.a().a(e2Var));
        b2 b2VarA = x1.a(e2Var, r1.d().c().h());
        w1Var.k(b2VarA.c());
        w1Var.j(b2VarA.b());
        if (loadAdParams != null) {
            w1Var.h(loadAdParams.getUin());
            w1Var.d(loadAdParams.getLoginOpenid());
            w1Var.c(loadAdParams.getLoginAppId());
            w1Var.a(loadAdParams.getDevExtra());
        }
        fo.a(w1Var, jVar, new a(e2Var, mbVar, str, str2, str3, i, f5VarC));
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str) {
        this.c = str;
    }

    public static pu a() {
        return e;
    }

    private void a(h4 h4Var, f5 f5Var, int i) {
        if ((r1.d().f().a("preloadResNetwork", -1) & r1.d().c().p().d()) <= 0) {
            GDTLogger.w("当前设备的网络类型不符合预加载广告资源的条件，请尝试WIFI环境。如仍有问题请联系客服");
            b10.a(1012010, f5Var, Integer.valueOf(i));
            return;
        }
        if (f40.a(h4Var) != null) {
            return;
        }
        String strV0 = h4Var.V0();
        File fileO = gu.o();
        gb.b bVarC = new gb.b().d(strV0).a(fileO).a(f40.b(strV0)).a(f5Var).c(v5.a(v5.b("vcrp"), h4Var.k()));
        if (v5.d(h4Var)) {
            double dK = h4Var.K();
            if (v5.a(dK)) {
                b10.a(1400014, f5Var);
                return;
            } else if (v5.b(dK)) {
                bVarC.a(v5.a(dK, h4Var.W0()));
            }
        }
        fb.a().a(bVarC.a(), new c(f5Var, i));
    }

    private static boolean a(mu muVar) {
        return new File(gu.b(), gu.d(muVar.c0())).exists();
    }

    private static void a(int i, f5 f5Var, long j) {
        wt wtVar = new wt(i);
        wtVar.b(j);
        wtVar.b(0);
        wtVar.a(f5Var);
        b10.a(wtVar);
    }
}
