package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.qq.e.comm.plugin.a50;
import com.qq.e.comm.plugin.ag;
import com.qq.e.comm.plugin.bg;
import com.qq.e.comm.plugin.cg;
import com.qq.e.comm.plugin.dg;
import com.qq.e.comm.plugin.eg;
import com.qq.e.comm.plugin.fg;
import com.qq.e.comm.plugin.gg;
import com.qq.e.comm.plugin.hg;
import com.qq.e.comm.plugin.ig;
import com.qq.e.comm.plugin.jg;
import com.qq.e.comm.plugin.tf;
import com.qq.e.comm.plugin.uf;
import com.qq.e.comm.plugin.v8;
import com.qq.e.comm.plugin.vf;
import com.qq.e.comm.plugin.wf;
import com.qq.e.comm.plugin.xf;
import com.qq.e.comm.plugin.yf;
import com.qq.e.comm.plugin.zf;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class q8 {
    static final int j;
    private static final boolean k;
    private static final int l;
    private static boolean m;
    private final t40 a;
    private final ConcurrentHashMap<String, yq> b;
    private final Map<String, yq> c;
    private final x10 d;
    private final w10 e;
    private final x10 f;
    private final b9 g;
    private final pk h;
    private final ol i;

    /* compiled from: A */
    private static class c {
        private static final q8 a = new q8(null);
    }

    static {
        int iA = r1.d().f().a(TypedValues.TransitionType.S_TO, 15);
        j = iA;
        k = (iA & 256) != 0;
        int iA2 = r1.d().f().a("ftp", 2);
        l = iA2;
        m = (iA2 & 1) == 0;
    }

    private q8() {
        t40 t40Var = new t40();
        this.a = t40Var;
        this.b = new ConcurrentHashMap<>();
        this.c = new HashMap();
        this.d = new x10();
        this.e = new w10();
        this.f = new x10();
        this.g = new b9();
        this.h = new l8();
        this.i = new w8();
        t40Var.a("GDTDLVideoView", new hg.a());
        t40Var.a("GDTDLProgressButton", new dg.c());
        t40Var.a("GDTDLVolumeView", new ig.b());
        t40Var.a("GDTDLGameEntryView", new zf.b());
        t40Var.a("GDTDLProgressView", new eg.d());
        t40Var.a("GDTDLDownloadProgressView", new yf.e());
        t40Var.a("GDTDLRewardTipView", new fg.b());
        t40Var.a("GDTDLAdLogoView", new tf.b());
        t40Var.a("GDTDLCTAView", new wf.a());
        t40Var.a("GDTDLAppInfoView", new uf.b());
        t40Var.a("GDTDLPopupView", new cg.b());
        t40Var.a("GDTDLLandingPageVideoView", new ag.b());
        t40Var.a("GDTDLWebView", new jg.a());
        t40Var.a("GDTDLTwistView", new gg.a());
        t40Var.a(vf.G, new vf.a());
        t40Var.a("GDTDLNovelPageView", new bg.b());
        t40Var.a("GDTDLCircleProgressView", new xf.a());
        u30.a(new e9());
    }

    /* synthetic */ q8(a aVar) {
        this();
    }

    public f9 c(Context context, h4 h4Var) {
        return a(context, h4Var, 5, n8.d());
    }

    private im a(Context context, yq yqVar, h4 h4Var, a9 a9Var) {
        if (a9Var == null) {
            if (yqVar.j == 13) {
                yqVar.j = h4Var.s1() ? 16 : 17;
                if (yqVar.j == 16 && (l & 2) == 2) {
                    m = false;
                }
            }
            c9.a(yqVar.j, h4Var, yqVar);
            return null;
        }
        im imVarA = a(context, h4Var, a9Var);
        if (imVarA != null && imVarA.g() != null) {
            c9.a(0, h4Var, yqVar);
            return imVarA;
        }
        c9.a(2, h4Var, yqVar);
        return null;
    }

    /* compiled from: A */
    class a implements a50.b {
        final /* synthetic */ e8 a;
        final /* synthetic */ a9 b;

        a(e8 e8Var, a9 a9Var) {
            this.a = e8Var;
            this.b = a9Var;
        }

        @Override // com.qq.e.comm.plugin.a50.b
        public void a(int i, int i2) {
            b10.a(1190203, this.a.c(), Integer.valueOf(i), Integer.valueOf(i2), null);
            String str = this.b.a;
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ v8.a a;
        final /* synthetic */ e8 b;

        b(v8.a aVar, e8 e8Var) {
            this.a = aVar;
            this.b = e8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            v8.b(2230110, this.a, this.b.c());
        }
    }

    public void b(e2 e2Var) {
        this.e.b(e2Var);
    }

    public Cif b(Context context, h4 h4Var) {
        return a(context, h4Var, true);
    }

    private im a(Context context, h4 h4Var, int i, String str, a9 a9Var) {
        im imVarA = a(context, h4Var, a9Var);
        if (imVarA != null && imVarA.g() != null) {
            if (h4Var != null) {
                c9.a(h4Var.k(), i, str, 0);
            }
            return imVarA;
        }
        if (h4Var == null) {
            return null;
        }
        c9.a(h4Var.k(), i, str, 1);
        return null;
    }

    private e8 a(Context context, h4 h4Var) {
        e8 e8Var = new e8(context);
        e8Var.a(this.h);
        e8Var.a(this.i);
        x8 x8Var = new x8();
        x8Var.a(h4Var);
        e8Var.a(x8Var);
        d9 d9Var = new d9();
        d9Var.a(h4Var);
        e8Var.a(d9Var);
        String strA = f8.a(h4Var);
        if (!TextUtils.isEmpty(strA)) {
            e8Var.a(strA);
        }
        if (h4Var != null) {
            e8Var.a(h4Var.k());
        }
        e8Var.a(f5.a(h4Var));
        return e8Var;
    }

    private a9 a(e2 e2Var, yq yqVar, String str) {
        if (yqVar == null) {
            return null;
        }
        String strU = yqVar.u();
        if (yqVar.j > 0 || TextUtils.isEmpty(strU)) {
            return null;
        }
        a9 a9VarA = this.d.a(new y10(str, yqVar.v()), strU);
        if (a9VarA == null) {
            yqVar.j = 11;
        }
        return a9VarA;
    }

    private im a(Context context, h4 h4Var, a9 a9Var) {
        v8.a aVarB = v8.b();
        aVarB.c = a50.d;
        e8 e8VarA = a(context, h4Var);
        if (h4Var != null) {
            h4Var.a(a9Var.c);
        }
        im imVarA = a50.a().a(a9Var.a, new a(e8VarA, a9Var));
        if (imVarA == null) {
            imVarA = this.a.a(a9Var, e8VarA.c());
        }
        if (imVarA == null) {
            return null;
        }
        v8.a aVarB2 = v8.b();
        aVarB2.c = a50.d;
        imVarA.a(e8VarA);
        v8.b(2230103, aVarB2, e8VarA.c());
        View viewG = imVarA.g();
        if (viewG != null) {
            viewG.post(new b(aVarB, e8VarA));
        }
        return imVarA;
    }

    private int a(h4 h4Var, e2 e2Var) {
        if (e2Var.k() || e2Var.h() || e2Var.i() || e2Var.l()) {
            return 1;
        }
        return xc.a("dlvnccma", h4Var.y0(), 2, h4Var.x0());
    }

    private f9 a(Context context, h4 h4Var, int i, String str) {
        a9 a9Var;
        yq yqVarA;
        e2 e2VarK;
        a9 a9VarA = this.f.a(str);
        if (a9VarA == null) {
            yqVarA = this.g.a(i, str);
            if (yqVarA == null) {
                return null;
            }
            a9 a9VarA2 = this.f.a(new y10(str, yqVarA.v()), yqVarA.u());
            this.c.put(str, yqVarA);
            a9Var = a9VarA2;
        } else {
            a9Var = a9VarA;
            yqVarA = this.c.get(str);
        }
        if (h4Var == null) {
            e2VarK = i == 4 ? e2.NATIVEEXPRESSAD : null;
        } else {
            e2VarK = h4Var.k();
        }
        if (a9Var == null) {
            c9.b(e2VarK, i, str, this.f.a());
            return null;
        }
        c9.b(e2VarK, i, str, 0);
        im imVarA = a(context, h4Var, i, str, a9Var);
        if (imVarA == null) {
            return null;
        }
        return new f9(imVarA, h4Var, yqVarA);
    }

    public Cif a(Context context, h4 h4Var, boolean z) {
        return a(context, h4Var, z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.qq.e.comm.plugin.Cif a(android.content.Context r12, com.qq.e.comm.plugin.h4 r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.q8.a(android.content.Context, com.qq.e.comm.plugin.h4, boolean, boolean):com.qq.e.comm.plugin.if");
    }

    public f9 a(Context context) {
        return a(context, (h4) null, 4, n8.b());
    }

    public f9 a(Context context, h4 h4Var, int i) {
        f9 f9VarA = a(context, h4Var, 2, n8.b(h4Var, i));
        return (f9VarA == null || f9VarA.l() == null) ? a(context, h4Var, 2, n8.a(h4Var, i)) : f9VarA;
    }

    public void a(h4 h4Var) {
        yq yqVarP0;
        if (h4Var == null || (yqVarP0 = h4Var.p0()) == null) {
            return;
        }
        String strM = yqVarP0.m();
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        e2 e2VarK = h4Var.k();
        a9 a9VarA = this.d.a(strM);
        if (yqVarP0.I()) {
            if (a9VarA == null) {
                if (k) {
                    Pair<Integer, JSONObject> pairA = this.e.a(e2VarK, strM);
                    Object obj = pairA.second;
                    if (obj == null) {
                        yqVarP0.j = ((Integer) pairA.first).intValue();
                    } else {
                        a9VarA = a(e2VarK, new yq((JSONObject) obj, 4), strM);
                    }
                } else {
                    a9VarA = a(e2VarK, this.e.a(e2VarK, yqVarP0, false), strM);
                }
            }
        } else if ((a9VarA == null || this.e.b(e2VarK, yqVarP0)) && (a9VarA = a(e2VarK, yqVarP0, strM)) != null) {
            this.e.a(e2VarK, yqVarP0);
        }
        if (a9VarA == null || !a50.a().a(a9VarA.a, yqVarP0.v())) {
            return;
        }
        a50.a().a(a9VarA.a, yqVarP0.v(), this.a.a(a9VarA, f5.a(h4Var)), a(h4Var, e2VarK));
    }

    public static q8 a() {
        return c.a;
    }

    public JSONArray a(e2 e2Var) {
        if (d2.b()) {
            return null;
        }
        return this.e.a(e2Var);
    }

    public void a(e2 e2Var, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (m || (jSONObjectOptJSONObject = jSONObject.optJSONObject("tpl_info_native")) == null || !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("data"))) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("id");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        Pair<Integer, JSONObject> pairA = this.e.a(e2Var, strOptString);
        JSONObject jSONObject2 = (JSONObject) pairA.second;
        if (jSONObject2 == null) {
            c9.a(e2Var, strOptString, ((Integer) pairA.first).intValue());
            return;
        }
        try {
            jSONObjectOptJSONObject.put("data", jSONObject2.optString("data"));
            jSONObjectOptJSONObject.put("ver", jSONObject2.optString("ver"));
            c9.a(e2Var, strOptString, 0);
        } catch (JSONException unused) {
            c9.a(e2Var, strOptString, 1000);
        }
    }
}
