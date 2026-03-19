package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f7 extends ob implements fl {
    List<cm> b;
    private final List<ob> c;

    @Override // com.qq.e.comm.plugin.cm
    public cm a() {
        return this;
    }

    public f7(List<cm> list, String str) {
        super(str);
        this.b = list;
        this.c = new ArrayList();
        for (cm cmVar : list) {
            if (cmVar instanceof ob) {
                this.c.add((ob) cmVar);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ob, com.qq.e.comm.plugin.cm
    public String d(JSONObject... jSONObjectArr) {
        List<cm> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (cm cmVar : this.b) {
            if (cmVar instanceof f10) {
                sb.append(cmVar.d(jSONObjectArr));
            } else if (cmVar instanceof ob) {
                String strD = cmVar.d(jSONObjectArr);
                if (strD == null) {
                    return null;
                }
                sb.append(strD);
            } else {
                continue;
            }
        }
        return sb.toString();
    }

    @Override // com.qq.e.comm.plugin.ob, com.qq.e.comm.plugin.cm
    public Object e(JSONObject... jSONObjectArr) {
        List<cm> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (cm cmVar : this.b) {
            if (cmVar instanceof f10) {
                sb.append(cmVar.e(jSONObjectArr));
            } else if (!(cmVar instanceof ob)) {
                continue;
            } else {
                if (cmVar.e(jSONObjectArr) == null) {
                    return null;
                }
                sb.append(cmVar.e(jSONObjectArr));
            }
        }
        return sb.toString();
    }

    @Override // com.qq.e.comm.plugin.fl
    public List<ob> b() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.ob
    public Object a(mj mjVar) {
        List<cm> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (cm cmVar : this.b) {
            if (cmVar instanceof f10) {
                sb.append(cmVar.toString());
            } else if (cmVar instanceof ob) {
                Object objA = mjVar.a((ob) cmVar);
                if (objA == null) {
                    return null;
                }
                sb.append(objA);
            } else {
                continue;
            }
        }
        return sb.toString();
    }

    @Override // com.qq.e.comm.plugin.ob
    Object a(JSONObject jSONObject) {
        List<cm> list = this.b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (cm cmVar : this.b) {
            if (cmVar instanceof f10) {
                sb.append(cmVar.d(jSONObject));
            } else if (cmVar instanceof ob) {
                Object objA = ((ob) cmVar).a(jSONObject);
                if (objA == null) {
                    return null;
                }
                sb.append(objA);
            } else {
                continue;
            }
        }
        return sb.toString();
    }
}
