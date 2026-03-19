package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ed extends h4 implements bk {
    private static final boolean P1;
    private int I1;
    private int J1;
    private VideoOption K1;
    String L1;
    List<String> M1;
    int N1;
    private boolean O1;

    static {
        P1 = r1.d().f().a("uolp", 0) == 1;
    }

    public ed(String str, String str2, String str3, e2 e2Var, mb mbVar, JSONObject jSONObject, int i, int i2, VideoOption videoOption) {
        super(str, str2, str3, e2Var, jSONObject, mbVar);
        this.M1 = new ArrayList();
        this.O1 = P1;
        fd.a(this, jSONObject);
        this.I1 = i;
        this.J1 = i2;
        this.K1 = videoOption;
        f(3);
    }

    public final int L1() {
        return this.I1;
    }

    public final int J1() {
        return this.J1;
    }

    public final VideoOption K1() {
        return this.K1;
    }

    @Override // com.qq.e.comm.plugin.bk
    public String a() {
        return this.L1;
    }

    private boolean M1() {
        return this.M1.size() == 3;
    }

    public void P1() throws JSONException {
        if (M1() && TextUtils.isEmpty(this.f)) {
            try {
                this.M.put("img", this.M1.get(0));
            } catch (Exception unused) {
            }
            this.N = null;
        }
    }

    public void O1() throws JSONException {
        P1();
        if (M1() && TextUtils.isEmpty(this.g)) {
            try {
                this.M.put("img2", this.M1.get(0));
            } catch (Exception unused) {
            }
            this.N = null;
        }
    }

    public boolean N1() {
        return this.O1;
    }

    public void Q1() {
        this.O1 = true;
    }

    public void a(int i, int i2) {
        this.I1 = i;
        this.J1 = i2;
    }
}
