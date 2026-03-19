package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.baidu.mobstat.forbes.Config;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ay implements jl {
    private JSONObject b(m7 m7Var) throws Throwable {
        Context contextA = g2.a();
        b0 b0VarB = r1.d().b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdk", a());
        jSONObject.put(PointCategory.APP, a(b0VarB));
        jSONObject.put("device", b(contextA));
        jSONObject.put("state", c(m7Var));
        jSONObject.put("crash", a(b0VarB, m7Var));
        return jSONObject;
    }

    private JSONObject c(m7 m7Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (s3.b().c()) {
            jSONObject.put("foreground", 1);
        }
        jSONObject.put("it", g2.f());
        jSONObject.put("net", as.f().c());
        jSONObject.put("life", m7Var.e);
        return jSONObject;
    }

    private JSONObject b(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os", 2);
        jSONObject.put("osVer", Build.VERSION.SDK_INT);
        jSONObject.put("tgtVer", context.getApplicationInfo().targetSdkVersion);
        jSONObject.put("name", a(context));
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("arch", lz.b());
        return jSONObject;
    }

    ay() {
    }

    private String a(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), m10.a("Ymx1ZXRvb3RoX25hbWU="));
        } catch (Throwable unused) {
            return "";
        }
    }

    private JSONObject a(b0 b0Var, m7 m7Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("crashID", m7Var.a);
        jSONObject.put("process", b0Var.f());
        jSONObject.put("thread", m7Var.b.getName());
        jSONObject.put("index", m7Var.b.getId());
        jSONObject.put("time", m7Var.d);
        jSONObject.put("type", "Java");
        Throwable cause = m7Var.c;
        String name = cause.getClass().getName();
        if (cause.getCause() != null && !name.startsWith("java") && !name.startsWith("android") && !name.startsWith("kotlin")) {
            cause = cause.getCause();
            name = cause.getClass().getName();
        }
        jSONObject.put("name", name);
        jSONObject.put("reason", cause.getMessage());
        jSONObject.put("stacktrace", a(m7Var.f));
        return jSONObject;
    }

    private JSONArray a(StackTraceElement[] stackTraceElementArr) throws JSONException {
        String fileName;
        JSONArray jSONArray = new JSONArray();
        if (stackTraceElementArr == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            JSONObject jSONObject = new JSONObject();
            if (stackTraceElement.isNativeMethod()) {
                fileName = "Native Method";
            } else {
                fileName = stackTraceElement.getFileName();
                if (fileName == null) {
                    fileName = "Unknown Source";
                }
            }
            jSONObject.put("object_name", fileName);
            jSONObject.put("symbol_name", stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
            int lineNumber = stackTraceElement.getLineNumber();
            if (lineNumber >= 0) {
                jSONObject.put("symbol_addr_offset", lineNumber);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    @Override // com.qq.e.comm.plugin.jl
    public boolean a(m7 m7Var) throws JSONException {
        JSONObject jSONObjectB;
        try {
            jSONObjectB = b(m7Var);
        } catch (Throwable th) {
            a(0, th);
        }
        if (jSONObjectB.length() == 0) {
            a(1, (Throwable) null);
            return true;
        }
        byte[] bArrA = k2.a(jSONObjectB.toString().getBytes(d6.a));
        if (bArrA != null && bArrA.length != 0) {
            m7Var.j = bArrA;
            File file = new File(g2.c(), m7Var.g);
            m7Var.h = file;
            gu.a(file, bArrA);
            return false;
        }
        a(2, (Throwable) null);
        return true;
    }

    private void a(int i, Throwable th) throws JSONException {
        qc qcVar = new qc(9801002);
        if (th != null) {
            ja jaVar = new ja();
            jaVar.a("ot", th.getMessage());
            qcVar.a(jaVar);
        }
        qcVar.d(i);
        b10.a(qcVar);
    }

    private JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", g2.b());
        jSONObject.put("ver", g2.j() + "." + g2.h());
        jSONObject.put("pv", g2.h());
        if (g2.k()) {
            jSONObject.put(Config.EVENT_NEXT_PAGENAME, 1);
        }
        return jSONObject;
    }

    private JSONObject a(b0 b0Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Config.INPUT_DEF_PKG, b0Var.b());
        jSONObject.put("ver", b0Var.d());
        return jSONObject;
    }
}
