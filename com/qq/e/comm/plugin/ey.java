package com.qq.e.comm.plugin;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ey {
    public static void b() {
        b10.a(9130040, (f5) null);
    }

    public static void b(long j, f5 f5Var) {
        b10.a(9130030, f5Var, 5, Integer.valueOf(a((int) j)), null);
    }

    private static int a(int i) {
        if (i > 100) {
            return 100;
        }
        return i / 5;
    }

    public static void b(int i, f5 f5Var) {
        b10.a(9130030, f5Var, 3, Integer.valueOf(a(i)), null);
    }

    public static void b(String str, f5 f5Var) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("eventId", -1);
            if (iOptInt == -1) {
                return;
            }
            int iOptInt2 = jSONObject.optInt("enumCode", -1);
            int iOptInt3 = jSONObject.optInt("errorCode", -1);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
            ja jaVar = null;
            Integer numValueOf = iOptInt2 == -1 ? null : Integer.valueOf(iOptInt2);
            Integer numValueOf2 = iOptInt3 == -1 ? null : Integer.valueOf(iOptInt3);
            if (jSONObjectOptJSONObject != null) {
                jaVar = new ja(jSONObjectOptJSONObject);
            }
            b10.a(iOptInt, f5Var, numValueOf, numValueOf2, jaVar);
        } catch (Exception unused) {
        }
    }

    public static void a() {
        b10.a(9130031, null, 1, 2, null);
    }

    public static void a(String str, f5 f5Var, Throwable th) throws JSONException {
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        String stackTraceString = Log.getStackTraceString(th);
        ja jaVar = new ja();
        jaVar.a("msg", str + "...\nstack: " + stackTraceString);
        b10.a(9130030, f5Var, 4, 0, jaVar);
    }

    public static void a(String str, f5 f5Var) throws JSONException {
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        ja jaVar = new ja();
        jaVar.a("msg", str);
        b10.a(9130030, f5Var, 4, 1, jaVar);
    }

    public static void a(int i, f5 f5Var) {
        b10.a(9130030, f5Var, 1, Integer.valueOf(a(i)), null);
    }

    public static void a(int i, f5 f5Var, String str) throws JSONException {
        ja jaVar;
        if (i > 100) {
            jaVar = new ja();
            jaVar.a("msg", str);
        } else {
            jaVar = null;
        }
        b10.a(9130030, f5Var, 2, Integer.valueOf(a(i)), jaVar);
    }

    public static void a(f5 f5Var) {
        b10.a(9130031, f5Var, 1, 1, null);
    }

    public static void a(long j, f5 f5Var) {
        b10.a(9130030, f5Var, 6, Integer.valueOf(a((int) j)), null);
    }
}
