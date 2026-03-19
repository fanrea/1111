package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.hg;
import com.qq.e.comm.plugin.s3;
import com.qq.e.comm.plugin.w40;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cg extends pq {
    private static final Random M = new Random();
    private Integer H;
    private h4 I;
    private boolean J = false;

    /* renamed from: K, reason: collision with root package name */
    private final boolean f774K = M.nextBoolean();
    private JSONObject L;

    /* compiled from: A */
    public static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new cg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.pq, com.qq.e.comm.plugin.w40
    /* renamed from: c */
    public qq b(e8 e8Var) {
        c cVar = new c(e8Var.d());
        cVar.setVisibility(8);
        return cVar;
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void m() throws JSONException {
        Object objE;
        JSONObject jSONObject = this.L;
        if (jSONObject != null) {
            String str = this.f774K ? "errorOptions" : "correctOption";
            Object objOpt = jSONObject.opt(str);
            if (objOpt != null && (objE = t30.a(objOpt).e(this.I.h())) != null) {
                try {
                    this.L.put(str, objE);
                } catch (JSONException unused) {
                }
            }
            c(new jn().a("dlInfo", this.L).a());
        }
        super.m();
    }

    private void n(int i) throws JSONException {
        Integer num;
        if (this.J || (num = this.H) == null || i / 1000 < num.intValue()) {
            return;
        }
        this.J = true;
        b(this, true, null, false);
    }

    private void S() {
        mh mhVarB;
        b10.a(1403020, f5.a(this.I), 0);
        this.n.a("showPopup");
        hg.b bVar = (hg.b) this.n.g().findViewWithTag("GDTDLVideoView");
        if (bVar != null && (mhVarB = bVar.b()) != null) {
            mhVarB.pause();
        }
        k(0);
    }

    private void R() {
        if (!this.J || E() == 2) {
            return;
        }
        if (s3.b().c()) {
            this.n.b("dismissPopup", new a());
        } else {
            this.n.a("dismissPopup");
            k(2);
        }
    }

    /* compiled from: A */
    class a extends dz {
        a() {
        }

        @Override // com.qq.e.comm.plugin.r2
        public void a(String str) {
            mh mhVarB;
            cg.this.k(2);
            hg.b bVar = (hg.b) cg.this.n.g().findViewWithTag("GDTDLVideoView");
            if (bVar == null || (mhVarB = bVar.b()) == null) {
                return;
            }
            mhVarB.play();
        }
    }

    private void f(JSONObject jSONObject) throws JSONException {
        b10.a(1403020, f5.a(this.I), 1);
        if (jSONObject != null) {
            ke.a(jSONObject.optInt("reducedTime"));
        }
        this.n.a("showCorrectTip");
        b(this, false, "correctTipVis", true);
    }

    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40, com.qq.e.comm.plugin.fm
    public void a(String str, JSONObject jSONObject) throws JSONException {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "popupClose":
                d(jSONObject);
                break;
            case "popupSucceed":
                if (this.f774K) {
                    e(jSONObject);
                    break;
                } else {
                    f(jSONObject);
                    break;
                }
            case "popupFailed":
                if (this.f774K) {
                    f(jSONObject);
                    break;
                } else {
                    e(jSONObject);
                    break;
                }
            default:
                super.a(str, jSONObject);
                break;
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        b10.a(1403020, f5.a(this.I), 2);
        if (jSONObject != null) {
            ke.a(jSONObject.optInt("reduceTimeForFail"));
        }
        this.n.a("showErrorTip");
        b(this, false, "errorTipVis", true);
    }

    private void d(JSONObject jSONObject) throws JSONException {
        b10.a(1403020, f5.a(this.I), 3);
        b(this, false, null, false);
    }

    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        this.J = false;
        this.I = null;
        this.H = null;
    }

    /* compiled from: A */
    static class c extends qq {
        private final s3.g c;

        /* compiled from: A */
        class a implements s3.g {
            @Override // com.qq.e.comm.plugin.s3.g
            public boolean d() {
                return false;
            }

            a() {
            }

            @Override // com.qq.e.comm.plugin.s3.g
            public boolean h() throws JSONException {
                cg.b(c.this.a, false, null, false);
                return false;
            }
        }

        public c(Context context) {
            super(context);
            this.c = new a();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            s3.b().a(this.c);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            s3.b().c(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(w40 w40Var, boolean z, String str, boolean z2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("dlInfo", jSONObject2);
            int i = 0;
            jSONObject2.put("popupVis", z ? 0 : 2);
            if (TextUtils.isEmpty(str)) {
                w40Var.c(jSONObject);
            } else {
                if (!z2) {
                    i = 2;
                }
                jSONObject2.put(str, i);
                w40Var.D().a(jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    private JSONObject a(Object obj) throws Exception {
        JSONObject jSONObjectOptJSONObject;
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            if (length <= 0) {
                return null;
            }
            jSONObjectOptJSONObject = jSONArray.optJSONObject(M.nextInt(length));
        } else {
            if (!(obj instanceof JSONObject)) {
                return null;
            }
            jSONObjectOptJSONObject = (JSONObject) obj;
        }
        Object objOpt = jSONObjectOptJSONObject.opt("originCorrect");
        if (objOpt == null) {
            objOpt = jSONObjectOptJSONObject.opt("correctOption");
            jSONObjectOptJSONObject.put("originCorrect", objOpt);
        }
        String strOpt = jSONObjectOptJSONObject.opt("originError");
        if (strOpt == null) {
            strOpt = jSONObjectOptJSONObject.opt("errorOptions");
            jSONObjectOptJSONObject.put("originError", strOpt);
        }
        if (strOpt instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) strOpt;
            int length2 = jSONArray2.length();
            strOpt = length2 == 0 ? "" : jSONArray2.opt(M.nextInt(length2));
        }
        if (this.f774K) {
            jSONObjectOptJSONObject.put("correctOption", strOpt);
            jSONObjectOptJSONObject.put("errorOptions", objOpt);
        } else {
            jSONObjectOptJSONObject.put("correctOption", objOpt);
            jSONObjectOptJSONObject.put("errorOptions", strOpt);
        }
        return jSONObjectOptJSONObject;
    }

    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) throws JSONException {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "adModel":
                this.I = (h4) cmVar.e(new JSONObject[0]);
                return true;
            case "showTime":
                this.H = Integer.valueOf(cmVar.f(new JSONObject[0]));
                return true;
            case "15":
                int iF = cmVar.f(new JSONObject[0]);
                if (iF == 0) {
                    S();
                } else if (2 == iF) {
                    R();
                } else {
                    k(iF);
                }
                return true;
            case "data":
                try {
                    this.L = a(cmVar.e(new JSONObject[0]));
                } catch (Exception unused) {
                }
                return true;
            case "videoPlayTime":
                n(cmVar.f(new JSONObject[0]));
                return true;
            default:
                return super.a(str, cmVar);
        }
    }
}
