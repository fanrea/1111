package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.w40;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hy extends zn<gy, jy> {
    private iy H;
    private fy I;
    private t40 J;

    /* compiled from: A */
    public static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            if (lv.a()) {
                return new hy();
            }
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.zn
    public boolean N() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public gy p() {
        return new gy(this, (jy) this.A);
    }

    private hy() {
    }

    @Override // com.qq.e.comm.plugin.w40
    public void a(z10 z10Var) {
        Map<String, f10> map;
        z10[] z10VarArr = z10Var.b;
        if (z10VarArr != null && z10VarArr.length > 0) {
            Map<String, ob> map2 = z10Var.e;
            iy iyVar = new iy((map2 != null && map2.containsKey("50")) || ((map = z10Var.c) != null && map.containsKey("50")), z10VarArr, this.J, this);
            this.H = iyVar;
            ((jy) this.A).setAdapter(iyVar);
            this.I = new fy(this);
        }
        super.a(z10Var);
    }

    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40
    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0 || !K() || x().a(jSONObject) || !K()) {
            return;
        }
        iy iyVar = this.H;
        if (iyVar != null && !iyVar.a()) {
            this.H.a(jSONObject);
        }
        super.c(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public jy b(e8 e8Var) {
        return new jy(e8Var.d());
    }

    @Override // com.qq.e.comm.plugin.w40
    public void a(t40 t40Var) {
        this.J = t40Var;
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void m() {
        iy iyVar = this.H;
        if (iyVar != null) {
            iyVar.a(this.u);
        }
    }

    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        this.I = null;
        this.H = null;
    }

    @Override // com.qq.e.comm.plugin.zn, com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "50":
                iy iyVar = this.H;
                if (iyVar != null && iyVar.a()) {
                    this.H.a(cmVar.e(new JSONObject[0]));
                }
                return true;
            case "51":
                ((gy) this.f).c(cmVar.f(new JSONObject[0]));
                return true;
            case "52":
                int iF = cmVar.f(new JSONObject[0]);
                iy iyVar2 = this.H;
                if (iyVar2 != null) {
                    iyVar2.a((iF & 2) != 0);
                }
                fy fyVar = this.I;
                if (fyVar != null) {
                    fyVar.a((iF & 1) == 0);
                    this.I.b(iF & 28);
                }
                return true;
            case "53":
                fy fyVar2 = this.I;
                if (fyVar2 != null) {
                    fyVar2.c(cmVar.f(new JSONObject[0]));
                }
                return true;
            default:
                return super.a(str, cmVar);
        }
    }
}
