package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class in {
    private final StringBuilder a = new StringBuilder();

    private in() {
    }

    public in b(String str) {
        StringBuilder sb = this.a;
        sb.append("if (");
        sb.append(str);
        sb.append(") { ");
        return this;
    }

    public in d() {
        this.a.append("} else ");
        return this;
    }

    public in c() {
        this.a.append("} ");
        return this;
    }

    public String a() {
        return this.a.toString();
    }

    public in b(String str, String str2, Object... objArr) {
        if (TextUtils.isEmpty(str2)) {
            return this;
        }
        if (str != null) {
            StringBuilder sb = this.a;
            sb.append(str);
            sb.append(".");
        }
        StringBuilder sb2 = this.a;
        sb2.append(str2);
        sb2.append('(');
        for (int i = 0; i < objArr.length; i++) {
            this.a.append(a(objArr[i]));
            if (i < objArr.length - 1) {
                this.a.append(", ");
            }
        }
        this.a.append("); ");
        return this;
    }

    private static String a(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    public static in b() {
        return new in();
    }

    private static String a(Object obj) {
        if (!(obj instanceof String)) {
            return obj == null ? ILogConst.CACHE_PLAY_REASON_NULL : obj.toString();
        }
        return "\"" + a((String) obj) + "\"";
    }

    public in a(String str, Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return a("GDTEventBus", "emit").b("GDTEventBus", "emit", str);
        }
        Object[] objArr2 = new Object[objArr.length + 2];
        objArr2[0] = str;
        objArr2[1] = null;
        System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
        return a("GDTEventBus", "emit").b("GDTEventBus", "emit", objArr2);
    }

    public in a(String str, String str2) {
        if (str != null) {
            return b("typeof " + str + " !== 'undefined' && typeof " + str + "." + str2 + " === 'function' ");
        }
        return b("typeof " + str2 + " === 'function' ");
    }

    public in a(String str, String str2, Object... objArr) {
        return a(str, str2).b(str, str2, objArr);
    }

    public Object a(com.qq.e.comm.dynamic.b bVar, f5 f5Var) throws JSONException {
        if (bVar == null) {
            return null;
        }
        String strA = a();
        try {
            return bVar.b(strA);
        } catch (Throwable th) {
            ey.a(strA, f5Var, th);
            return null;
        }
    }
}
