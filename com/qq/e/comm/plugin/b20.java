package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b20 extends ob implements fl {
    private final cm b;
    private final cm c;
    private final cm d;
    private boolean e;
    private final List<ob> f;

    b20(cm cmVar, cm cmVar2, cm cmVar3, String str) {
        super(str);
        this.b = cmVar;
        this.c = cmVar2;
        this.d = cmVar3;
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        if (cmVar instanceof ob) {
            arrayList.add((ob) cmVar);
        }
        if (cmVar2 instanceof ob) {
            arrayList.add((ob) cmVar2);
        }
        if (cmVar3 instanceof ob) {
            arrayList.add((ob) cmVar3);
        }
    }

    private boolean e(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return ((String) obj).length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return (obj instanceof JSONArray) && ((JSONArray) obj).length() == 0;
    }

    @Override // com.qq.e.comm.plugin.ob, com.qq.e.comm.plugin.z4
    public void c() {
        this.e = false;
    }

    @Override // com.qq.e.comm.plugin.fl
    public List<ob> b() {
        return this.f;
    }

    @Override // com.qq.e.comm.plugin.ob
    public Object a(mj mjVar) {
        Object objA = mjVar.a((ob) this.b);
        boolean zEquals = JSONObject.NULL.equals(objA);
        if (!zEquals && !e(objA)) {
            cm cmVar = this.c;
            if (cmVar != null) {
                if (cmVar instanceof ob) {
                    objA = mjVar.a((ob) cmVar);
                } else {
                    objA = cmVar.e(new JSONObject[0]);
                }
            }
        } else if (zEquals && this.e) {
            objA = null;
        } else {
            cm cmVar2 = this.d;
            if (cmVar2 instanceof ob) {
                objA = mjVar.a((ob) cmVar2);
            } else {
                objA = cmVar2.e(new JSONObject[0]);
            }
        }
        this.e = true;
        return objA;
    }

    @Override // com.qq.e.comm.plugin.ob
    Object a(JSONObject jSONObject) {
        Object objE = this.b.e(jSONObject);
        boolean zEquals = JSONObject.NULL.equals(objE);
        if (!zEquals && !e(objE)) {
            cm cmVar = this.c;
            if (cmVar != null) {
                objE = cmVar.e(jSONObject);
            }
        } else {
            objE = (zEquals && this.e) ? null : this.d.e(jSONObject);
        }
        this.e = true;
        return objE;
    }

    @Override // com.qq.e.comm.plugin.cm
    public cm a() {
        cm cmVar = this.c;
        return new b20(this.b.a(), cmVar == null ? null : cmVar.a(), this.d.a(), d());
    }
}
