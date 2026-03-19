package com.apm.insight.entity;

import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.f;
import com.apm.insight.o.j;
import com.apm.insight.o.m;
import com.apm.insight.o.q;
import com.apm.insight.o.v;
import com.component.a.a.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b {
    private static ConcurrentLinkedQueue<f> a = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<Integer, f> b = new ConcurrentHashMap<>();

    public interface a {
        void a(JSONObject jSONObject);
    }

    public static File a(File file) {
        return new File(file, "all_data.json");
    }

    public static JSONArray a() {
        f next;
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            JSONObject jSONObjectD = next.d();
            if (jSONObjectD.has("package")) {
                jSONObjectD.remove("package");
            }
            jSONArray.put(jSONObjectD);
        }
        return jSONArray;
    }

    public static JSONArray a(Object obj) {
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f next = it.next();
            if (next != null && next.a(obj)) {
                jSONArray.put(next.a(CrashType.JAVA, null, true));
                break;
            }
        }
        return jSONArray;
    }

    public static JSONArray a(Object obj, Throwable th, StackTraceElement[] stackTraceElementArr) {
        Iterator<f> it = a.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next != null && next.a(obj)) {
                JSONArray jSONArrayA = next.a(stackTraceElementArr, th);
                JSONArray jSONArray = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("aid", next.c());
                    jSONObject.put(b.e.k, jSONArrayA);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
                return jSONArray;
            }
        }
        return null;
    }

    public static JSONArray a(String str) {
        f next;
        JSONArray jSONArray = new JSONArray();
        String[] strArrSplit = str.split("\n");
        Iterator<f> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.b(next.c())) {
                JSONArray jSONArrayA = next.a(strArrSplit);
                if (!m.a(jSONArrayA)) {
                    jSONArray.put(next.a(CrashType.ANR, jSONArrayA));
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray a(String str, String str2, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("header")) != null) {
                String strValueOf = String.valueOf(jSONObjectOptJSONObject.opt("aid"));
                if (com.apm.insight.runtime.a.c(strValueOf)) {
                    try {
                        String strC = f.c(strValueOf);
                        if (!TextUtils.isEmpty(strC)) {
                            jSONObjectOptJSONObject.put("x-auth-token", strC);
                        }
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("package"))) {
                        jSONArray2.put(jSONObjectOptJSONObject2);
                        break;
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("so_list");
                    if (!m.a(jSONArrayOptJSONArray)) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            if (str.contains(jSONArrayOptJSONArray.optString(i2))) {
                                jSONArray2.put(jSONObjectOptJSONObject2);
                                break;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return jSONArray2;
    }

    public static JSONArray a(Throwable th, Thread thread, File file) {
        f next;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] stackTraceElementArrB = v.b(th);
        Iterator<f> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.a(next.c())) {
                JSONArray jSONArrayA = next.a(stackTraceElementArrB, th);
                if (!m.a(jSONArrayA)) {
                    jSONArray.put(next.a(CrashType.JAVA, jSONArrayA));
                }
            } else {
                q.a((Object) ("not enable javaCrash aid: " + next.c()));
            }
        }
        if (m.a(jSONArray)) {
            return null;
        }
        if (file != null) {
            try {
                j.a(new File(file, "all_data.json"), jSONArray, false);
            } catch (IOException unused) {
            }
        }
        return jSONArray;
    }

    public static void a(f fVar) {
        a.add(fVar);
        if (fVar.e()) {
            b.put(4444, fVar);
        }
    }

    public static void a(File file, CrashType crashType) {
        f next;
        if (file == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.c(next.c())) {
                jSONArray.put(next.a(crashType));
            } else {
                q.a((Object) ("not enable NativeCrash aid: " + next.c()));
            }
        }
        if (m.a(jSONArray)) {
            return;
        }
        try {
            j.a(new File(file, "all_data.json"), jSONArray, false);
        } catch (Exception unused) {
        }
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray, a aVar) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        q.a((Object) ("uploadFromFile with allData " + jSONArray));
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length() && (jSONObjectOptJSONObject = jSONArray.optJSONObject(i)) != null; i++) {
            if (m.a(jSONObjectOptJSONObject, 0, "header", "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                com.apm.insight.entity.a.b(jSONObject2, jSONObject);
                com.apm.insight.entity.a.b(jSONObject2, jSONObjectOptJSONObject);
                aVar.a(jSONObject2);
            } else {
                try {
                    String strC = f.c(m.b(jSONObjectOptJSONObject, "header", "aid"));
                    if (!TextUtils.isEmpty(strC)) {
                        JSONObject jSONObject3 = (JSONObject) jSONObjectOptJSONObject.remove("header");
                        jSONObject3.put("x-auth-token", strC);
                        jSONObjectOptJSONObject.put("header", jSONObject3);
                    }
                } catch (Throwable unused) {
                }
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        if (jSONArray2.length() == 0) {
            return;
        }
        JSONObject jSONObject4 = new JSONObject();
        com.apm.insight.entity.a.b(jSONObject4, jSONObject);
        try {
            jSONObject4.put("all_data", jSONArray2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.a(jSONObject4);
    }

    public static String b(Object obj) {
        Iterator<f> it = a.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next != null && next.a(obj)) {
                return next.c();
            }
        }
        return null;
    }

    public static JSONArray b() {
        f next;
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.a((CrashType) null));
        }
        return jSONArray;
    }

    public static JSONArray b(String str) {
        f next;
        JSONArray jSONArray = new JSONArray();
        Iterator<f> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.d(next.c()) && next.b(str) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("aid", next.c());
                    jSONObject.put("header", jSONObject2);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public static int c() {
        return a.size();
    }

    public static List<String> d() {
        f next;
        ArrayList arrayList = new ArrayList();
        Iterator<f> it = a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next.c());
        }
        return arrayList;
    }
}
