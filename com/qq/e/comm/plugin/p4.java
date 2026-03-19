package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class p4 extends w40<v40<sq>, sq> {
    private int G;
    private int H;
    private int I;
    protected String J;
    protected r2 L;
    private int M;
    protected Object N;
    protected JSONArray P;

    /* renamed from: K, reason: collision with root package name */
    protected boolean f781K = true;
    protected int O = 0;
    private boolean Q = false;

    protected abstract void a(Object obj);

    protected abstract void a(float[] fArr);

    protected abstract void m(int i);

    protected p4() {
    }

    protected int Q() {
        return this.G;
    }

    protected int O() {
        return this.H;
    }

    protected int N() {
        return this.I;
    }

    protected int P() {
        return this.M;
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "91":
                this.N = cmVar.e(new JSONObject[0]);
                this.Q = true;
                return true;
            case "93":
                int iF = cmVar.f(new JSONObject[0]);
                this.M = iF;
                m(iF);
                return true;
            case "94":
                this.O = cmVar.f(new JSONObject[0]);
                this.Q = true;
                return true;
            case "95":
                this.P = (JSONArray) cmVar.e(new JSONObject[0]);
                this.Q = true;
                return true;
            case "96":
                if (cmVar.e(new JSONObject[0]) instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) cmVar.e(new JSONObject[0]);
                    if (jSONArray.length() != 0) {
                        float fOptDouble = (float) jSONArray.optDouble(0, 0.0d);
                        float fOptDouble2 = (float) jSONArray.optDouble(1, 0.0d);
                        float fOptDouble3 = (float) jSONArray.optDouble(2, 1.0d);
                        float fOptDouble4 = (float) jSONArray.optDouble(3, 1.0d);
                        float[] fArr = {fOptDouble, fOptDouble2, fOptDouble3, fOptDouble4};
                        if (fOptDouble != 1.0f && fOptDouble2 != 1.0f && fOptDouble3 != 0.0f && fOptDouble4 != 0.0f && (fOptDouble != 0.0f || fOptDouble2 != 0.0f || fOptDouble3 != 1.0f || fOptDouble4 != 1.0f)) {
                            a(fArr);
                        }
                    }
                }
                return true;
            case "97":
                this.G = cmVar.f(new JSONObject[0]);
                return true;
            case "98":
                this.I = cmVar.f(new JSONObject[0]);
                return true;
            case "99":
                this.H = cmVar.f(new JSONObject[0]);
                return true;
            case "100":
                String string = cmVar.toString();
                this.J = string;
                if (TextUtils.isEmpty(string)) {
                    this.f781K = true;
                } else {
                    this.f781K = false;
                    im imVarD = D();
                    if (imVarD != null) {
                        imVarD.a(this.J, this);
                    }
                }
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        super.M();
        if (this.Q && this.f781K) {
            this.Q = false;
            a(this.N);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        this.M = 0;
        this.N = null;
        this.Q = false;
        this.O = 0;
        this.f781K = true;
        this.L = null;
    }

    public void a(r2 r2Var) {
        this.f781K = true;
        this.Q = false;
        this.L = r2Var;
        a(this.N);
    }
}
