package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class ob extends z4 {
    private final String a;

    public abstract Object a(mj mjVar);

    abstract Object a(JSONObject jSONObject);

    public String toString() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.z4
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public ob(String str) {
        this.a = str;
    }

    @Override // com.qq.e.comm.plugin.cm
    public int f(JSONObject... jSONObjectArr) {
        Object objA;
        Integer numB;
        if (jSONObjectArr == null || jSONObjectArr.length <= 0 || (objA = a(jSONObjectArr[0])) == null || (numB = super.b(objA)) == null) {
            return 0;
        }
        return numB.intValue();
    }

    @Override // com.qq.e.comm.plugin.cm
    public float b(JSONObject... jSONObjectArr) {
        Object objA;
        Float fA;
        if (jSONObjectArr == null || jSONObjectArr.length <= 0 || (objA = a(jSONObjectArr[0])) == null || (fA = super.a(objA)) == null) {
            return 0.0f;
        }
        return fA.floatValue();
    }

    @Override // com.qq.e.comm.plugin.cm
    public Object e(JSONObject... jSONObjectArr) {
        if (jSONObjectArr == null || jSONObjectArr.length <= 0) {
            return null;
        }
        return a(jSONObjectArr[0]);
    }

    @Override // com.qq.e.comm.plugin.cm
    public int a(JSONObject... jSONObjectArr) {
        iz izVarC = c(jSONObjectArr);
        if (izVarC == null) {
            return 0;
        }
        return izVarC.e();
    }

    @Override // com.qq.e.comm.plugin.cm
    public iz c(JSONObject... jSONObjectArr) {
        Object objA;
        iz izVarC;
        return (jSONObjectArr == null || jSONObjectArr.length <= 0 || (objA = a(jSONObjectArr[0])) == null || (izVarC = super.c(objA)) == null) ? new iz(0) : izVarC;
    }

    public String d() {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.cm
    public String d(JSONObject... jSONObjectArr) {
        if (jSONObjectArr == null || jSONObjectArr.length <= 0) {
            return null;
        }
        return super.d(a(jSONObjectArr[0]));
    }
}
