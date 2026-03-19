package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fr extends h4 implements bk {
    int I1;
    List<String> J1;
    String K1;
    private int L1;
    private double M1;
    private String N1;
    private int O1;
    private long P1;
    private int Q1;

    public fr(String str, String str2, String str3, JSONObject jSONObject, mb mbVar) {
        super(str, str2, str3, e2.NATIVEUNIFIEDAD, jSONObject, mbVar);
        this.J1 = new ArrayList();
        this.Q1 = -1;
        gr.a(this, jSONObject);
        l3 l3Var = this.A;
        if (l3Var != null) {
            this.L1 = l3Var.i();
            this.M1 = this.A.g();
            this.N1 = this.A.e();
            this.O1 = this.A.j();
            this.P1 = this.A.c();
        }
    }

    public String N1() {
        String strA = z() != null ? z().a() : "";
        TextUtils.isEmpty(strA);
        return strA;
    }

    public int J1() {
        if (C1()) {
            return 2;
        }
        if (this.J1.size() == 3) {
            return 3;
        }
        return this.I1 == 31 ? 4 : 1;
    }

    public void S1() throws JSONException {
        if (J1() == 3 && TextUtils.isEmpty(c0())) {
            try {
                this.M.put("img", this.J1.get(0));
                this.f = this.J1.get(0);
            } catch (Exception unused) {
            }
        }
    }

    public final List<String> P1() {
        return this.J1;
    }

    public final void g(int i) {
        this.O1 = i;
    }

    public final int M1() {
        return this.O1;
    }

    public final long O1() {
        return this.P1;
    }

    public final int L1() {
        return this.L1;
    }

    public final double K1() {
        return this.M1;
    }

    public final String R1() {
        return this.N1;
    }

    @Override // com.qq.e.comm.plugin.bk
    public String a() {
        return this.K1;
    }

    public void h(int i) {
        this.Q1 = i;
    }

    public int Q1() {
        return this.Q1;
    }
}
