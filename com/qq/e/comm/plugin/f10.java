package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f10 extends z4 {
    private final Object a;
    private Integer b;
    private Float c;
    private String d;
    private iz e;

    @Override // com.qq.e.comm.plugin.cm
    public cm a() {
        return this;
    }

    f10(Object obj) {
        this.a = obj;
    }

    @Override // com.qq.e.comm.plugin.cm
    public int f(JSONObject... jSONObjectArr) {
        if (this.b == null) {
            Integer numB = super.b(this.a);
            this.b = Integer.valueOf(numB == null ? 0 : numB.intValue());
        }
        return this.b.intValue();
    }

    @Override // com.qq.e.comm.plugin.cm
    public float b(JSONObject... jSONObjectArr) {
        if (this.c == null) {
            Float fA = super.a(this.a);
            this.c = Float.valueOf(fA == null ? 0.0f : fA.floatValue());
        }
        return this.c.floatValue();
    }

    @Override // com.qq.e.comm.plugin.cm
    public Object e(JSONObject... jSONObjectArr) {
        return this.a;
    }

    @Override // com.qq.e.comm.plugin.cm
    public String d(JSONObject... jSONObjectArr) {
        if (this.d == null) {
            this.d = super.d(this.a);
        }
        return this.d;
    }

    public String toString() {
        if (this.d == null) {
            this.d = super.d(this.a);
        }
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.cm
    public int a(JSONObject... jSONObjectArr) {
        iz izVarC = c(new JSONObject[0]);
        if (izVarC == null) {
            return 0;
        }
        return izVarC.e();
    }

    @Override // com.qq.e.comm.plugin.cm
    public iz c(JSONObject... jSONObjectArr) {
        iz izVar = this.e;
        if (izVar != null) {
            return izVar;
        }
        iz izVarC = super.c(this.a);
        this.e = izVarC;
        return izVarC;
    }

    public boolean equals(Object obj) {
        Object objE;
        if (this == obj) {
            return true;
        }
        if (this.a == null) {
            if (obj != null) {
                return (obj instanceof f10) && ((f10) obj).e(new JSONObject[0]) == null;
            }
            return true;
        }
        if (!(obj instanceof f10) || (objE = ((f10) obj).e(new JSONObject[0])) == null) {
            return false;
        }
        Object obj2 = this.a;
        if (objE == obj2) {
            return true;
        }
        if ((obj2 instanceof Number) && (objE instanceof Number)) {
            return (((obj2 instanceof Integer) || (obj2 instanceof Long)) && ((objE instanceof Integer) || (objE instanceof Long))) ? ((Number) obj2).longValue() == ((Number) objE).longValue() : ((Number) obj2).doubleValue() == ((Number) objE).doubleValue();
        }
        return toString().equals(obj.toString());
    }
}
