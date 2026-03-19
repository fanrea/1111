package com.qq.e.comm.plugin;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f40 {
    private static volatile Set<String> a;
    private static volatile List<b> b;
    private static volatile boolean c;
    private static volatile boolean d;

    /* compiled from: A */
    private static class b {
        private final JSONObject a;
        private final int b;

        private b(JSONObject jSONObject) {
            this.a = jSONObject.optJSONObject("vfm");
            this.b = jSONObject.optInt("vt");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONArray a(String str) {
            JSONObject jSONObject = this.a;
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.optJSONArray(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(h4 h4Var) {
            int i = this.b;
            if (i == 1) {
                return oi.a().d();
            }
            if (i == 2) {
                return p40.a(h4Var.k(), h4Var.y0());
            }
            return true;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        a();
        if (!c) {
            return a(str);
        }
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(path) && a.contains(host)) {
            return a(path);
        }
        return a(str);
    }

    private static String a(String str) {
        return gp.a(str);
    }

    public static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(a(str), gu.o());
    }

    private static List<b> b(JSONArray jSONArray) {
        int length;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && (length = jSONArray.length()) != 0) {
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new b(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    public static File a(h4 h4Var) {
        JSONArray jSONArrayA;
        int length;
        File fileA;
        File fileA2;
        String strV0 = h4Var.V0();
        if (TextUtils.isEmpty(strV0)) {
            return null;
        }
        a();
        File fileO = gu.o();
        try {
        } catch (Throwable th) {
            th.getMessage();
        }
        if (!c) {
            return a(a(strV0), fileO);
        }
        Uri uri = Uri.parse(strV0);
        String host = uri.getHost();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(host) && a.contains(host)) {
            File fileA3 = a(a(path), fileO);
            if (fileA3 != null) {
                return fileA3;
            }
            if (d && (fileA2 = a(a(strV0), fileO)) != null) {
                a(-1, -1, null);
                return fileA2;
            }
            String[] strArrSplit = path.split("\\.");
            if (strArrSplit != null && strArrSplit.length == 3) {
                String str = strArrSplit[1];
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    b bVar = b.get(i);
                    if (bVar.a(h4Var) && (jSONArrayA = bVar.a(str)) != null && (length = jSONArrayA.length()) != 0) {
                        for (int i2 = 0; i2 < length; i2++) {
                            String strOptString = jSONArrayA.optString(i2);
                            if (!TextUtils.isEmpty(strOptString) && (fileA = a(a(String.format("%s.%s.%s", strArrSplit[0], strOptString, strArrSplit[2])), fileO)) != null) {
                                a(i, i2, str);
                                return fileA;
                            }
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return a(a(strV0), fileO);
    }

    private static File a(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file2 = new File(file, str + "_complete");
        if (!file2.exists()) {
            return null;
        }
        File file3 = new File(file, str);
        if (file3.exists()) {
            file3.setLastModified(System.currentTimeMillis());
            file2.setLastModified(System.currentTimeMillis());
            file3.getName();
            return file3;
        }
        file2.delete();
        return null;
    }

    private static Set<String> a(JSONArray jSONArray) {
        int length;
        HashSet hashSet = new HashSet();
        if (jSONArray != null && (length = jSONArray.length()) != 0) {
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    hashSet.add(strOptString);
                }
            }
        }
        return hashSet;
    }

    private static void a(int i, int i2, String str) {
        b10.a(1130303, null, Integer.valueOf(i), Integer.valueOf(i2), !TextUtils.isEmpty(str) ? new ja().a("data", str) : null);
    }

    private static void a() {
        String strB;
        if (a != null) {
            return;
        }
        synchronized (f40.class) {
            if (a != null) {
                return;
            }
            ku kuVarD = com.qq.e.comm.plugin.b.c().d();
            if (kuVarD == null) {
                return;
            }
            boolean z = false;
            if (xc.a("avunc", "APP", 0, kuVarD) != 1) {
                a = new HashSet();
                return;
            }
            try {
                strB = r1.d().f().b("avccfg", "");
                if (TextUtils.isEmpty(strB)) {
                    strB = m10.a("eyJkbCI6WyJhZHNtaW5kLnVnZHRpbWcuY29tIl0sInJvIjoxLCJjbCI6W3sidmZtIjp7ImYxMCI6WyJmMjAiLCJmMTQwMDEwIl0sImYyMCI6WyJmMTQwMDEwIl19LCJ2dCI6MH0seyJ2Zm0iOnsiZjEwIjpbImYxNDAxMTIiXSwiZjIwIjpbImYxNDAxMTIiXSwiZjE0MDAxMCI6WyJmMTQwMTEyIl0sImYxNDAyMTIiOlsiZjE0MDExMiJdfSwidnQiOjF9LHsidmZtIjp7ImYxMCI6WyJmMTQwMjEyIl0sImYyMCI6WyJmMTQwMjEyIl0sImYxNDAxMTIiOlsiZjE0MDIxMiJdLCJmMTQwMDEwIjpbImYxNDAyMTIiXX0sInZ0IjoyfV19");
                }
            } catch (Exception unused) {
                a = new HashSet();
            }
            if (TextUtils.isEmpty(strB)) {
                a = new HashSet();
                return;
            }
            JSONObject jSONObject = new JSONObject(strB);
            d = jSONObject.optInt("ro") == 1;
            b = b(jSONObject.optJSONArray("cl"));
            a = a(jSONObject.optJSONArray("dl"));
            if (!a.isEmpty() && !b.isEmpty()) {
                z = true;
            }
            c = z;
        }
    }
}
