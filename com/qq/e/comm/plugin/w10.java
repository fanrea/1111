package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class w10 {
    private static final boolean d;
    private final File a = gu.h();
    private final Map<e2, Map<String, Integer>> b = new HashMap(6);
    private JSONObject c;

    static {
        d = (q8.j & 512) != 0;
    }

    w10() {
        a();
    }

    void b(e2 e2Var) throws JSONException, NumberFormatException {
        if (this.b.get(e2Var) != null) {
            c9.a(e2Var, 4);
            return;
        }
        String[] list = !d2.b() ? a(e2Var, false).list() : null;
        int length = list == null ? 0 : list.length;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(length);
        if (length > 0) {
            for (String str : list) {
                String[] strArrSplit = str.split(Config.replace);
                try {
                    Integer numValueOf = Integer.valueOf(strArrSplit[1]);
                    Integer num = (Integer) concurrentHashMap.get(strArrSplit[0]);
                    if (num == null || numValueOf.intValue() > num.intValue()) {
                        concurrentHashMap.put(strArrSplit[0], numValueOf);
                    }
                } catch (Exception unused) {
                }
            }
        }
        this.b.put(e2Var, concurrentHashMap);
        JSONObject jSONObject = this.c;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        File fileA = a(e2Var, true);
        new a(fileA, this.c.optString(String.valueOf(e2Var.c)), true, fileA).b();
    }

    /* compiled from: A */
    class a extends l0 {
        final /* synthetic */ File f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(File file, String str, boolean z, File file2) {
            super(file, str, z);
            this.f = file2;
        }

        @Override // com.qq.e.comm.plugin.l0
        public void a(JSONObject jSONObject, boolean z) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                File file = new File(this.f, next);
                if (!z || !file.exists()) {
                    try {
                        gu.b(file, jSONObject.optString(next));
                    } catch (Exception unused) {
                        file.delete();
                    }
                }
            }
        }
    }

    boolean b(e2 e2Var, yq yqVar) throws JSONException {
        if (this.b.size() == 0) {
            c9.a(e2Var, 2);
            return true;
        }
        Map<String, Integer> map = this.b.get(e2Var);
        if (map != null && map.size() > 0) {
            Integer num = map.get(yqVar.m());
            return num == null || yqVar.v() > num.intValue();
        }
        c9.a(e2Var, 2);
        return true;
    }

    private boolean c(e2 e2Var) {
        JSONObject jSONObject = this.c;
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        return !TextUtils.isEmpty(this.c.optString(String.valueOf(e2Var.c)));
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ e2 a;
        final /* synthetic */ yq b;

        b(e2 e2Var, yq yqVar) {
            this.a = e2Var;
            this.b = yqVar;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            File fileA = w10.this.a(this.a, false);
            String strA = w10.this.a(this.b, false);
            File file = new File(fileA, strA);
            try {
                byte[] bytes = this.b.q().getBytes(d6.a);
                if (bytes != null && bytes.length != 0) {
                    gu.a(file, bytes);
                    if (file.length() == 0) {
                        c9.a(this.a, this.b, 3, (Exception) null);
                        file.delete();
                        return;
                    }
                    if (bytes.length != file.length()) {
                        c9.a(this.a, this.b, 4, (Exception) null);
                        file.delete();
                        return;
                    }
                    c9.a(this.a, this.b, 0, (Exception) null);
                    String strM = this.b.m();
                    for (String str : fileA.list()) {
                        if (str.startsWith(strM) && !strA.equals(str)) {
                            new File(fileA, str).delete();
                        }
                    }
                    return;
                }
                c9.a(this.a, this.b, 2, (Exception) null);
            } catch (Exception e) {
                file.delete();
                c9.a(this.a, this.b, ((e instanceof IOException) && e.getMessage().contains("No space left on device")) ? 1 : -1, e);
            }
        }
    }

    /* compiled from: A */
    class c extends l0 {
        c(File file, String str, boolean z) {
            super(file, str, z);
        }

        @Override // com.qq.e.comm.plugin.l0
        void a(JSONObject jSONObject, boolean z) {
            w10.this.c = jSONObject;
        }
    }

    void a(e2 e2Var, yq yqVar) throws JSONException {
        Map<String, Integer> map = this.b.get(e2Var);
        if (map == null) {
            c9.a(e2Var, 3);
            return;
        }
        Integer num = map.get(yqVar.m());
        if (num == null || num.intValue() < yqVar.v()) {
            map.put(yqVar.m(), Integer.valueOf(yqVar.v()));
            if (d2.b()) {
                return;
            }
            qg.c.submit(new b(e2Var, yqVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(yq yqVar, boolean z) {
        if (z) {
            return yqVar.m();
        }
        return yqVar.m() + Config.replace + yqVar.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(e2 e2Var, boolean z) {
        File file = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(e2Var.c);
        sb.append(z ? "_fb" : "_ol");
        return new File(file, sb.toString());
    }

    JSONArray a(e2 e2Var) throws JSONException {
        Map<String, Integer> map;
        if (this.b.size() > 0 && (map = this.b.get(e2Var)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value.intValue() > -1) {
                    jn jnVar = new jn();
                    jnVar.a("id", entry.getKey());
                    jnVar.a("ver", value);
                    jSONArray.put(jnVar.a());
                }
            }
            return jSONArray;
        }
        c9.a(e2Var, 1);
        return null;
    }

    yq a(e2 e2Var, String str, boolean z) {
        int i;
        int i2;
        if (c(e2Var)) {
            File file = new File(a(e2Var, true), str);
            if (!file.exists()) {
                i = 13;
            } else if (file.length() == 0) {
                file.delete();
                i = 21;
            } else {
                String strD = gu.d(file);
                if (TextUtils.isEmpty(strD)) {
                    file.delete();
                    i = 10;
                } else if ('{' != strD.charAt(0)) {
                    i = 5;
                } else {
                    try {
                        return new yq(new JSONObject(strD), 2);
                    } catch (JSONException unused) {
                        i = 20;
                    }
                }
            }
        } else {
            i = 0;
        }
        int i3 = i * 100;
        if (z) {
            yq yqVar = new yq(str, 2);
            yqVar.i = 2;
            yqVar.j = i3;
            return yqVar;
        }
        String strA = xm.a(e2Var, str, 3);
        if (TextUtils.isEmpty(strA)) {
            i2 = i3 + 10;
        } else if ('{' != strA.charAt(0)) {
            i2 = i3 + 5;
        } else {
            try {
                return new yq(new JSONObject(strA), 3);
            } catch (JSONException unused2) {
                i2 = i3 + 20;
            }
        }
        yq yqVar2 = new yq(str, 3);
        yqVar2.i = 3;
        yqVar2.j = i2;
        return yqVar2;
    }

    Pair<Integer, JSONObject> a(e2 e2Var, String str) {
        Map<String, Integer> map = this.b.get(e2Var);
        if (map == null) {
            return new Pair<>(14, null);
        }
        Integer num = map.get(str);
        if (num == null) {
            return new Pair<>(13, null);
        }
        if (num.intValue() == -3) {
            return new Pair<>(10, null);
        }
        if (num.intValue() == -2) {
            return new Pair<>(21, null);
        }
        if (num.intValue() == -1) {
            return new Pair<>(15, null);
        }
        File file = new File(a(e2Var, false), a(str, num.intValue()));
        if (!file.exists()) {
            map.put(str, -1);
            return new Pair<>(15, null);
        }
        if (file.length() == 0) {
            file.delete();
            map.put(str, -2);
            return new Pair<>(21, null);
        }
        String strD = gu.d(file);
        if (TextUtils.isEmpty(strD)) {
            if (d) {
                file.delete();
                map.put(str, -3);
            }
            return new Pair<>(10, null);
        }
        try {
            return new Pair<>(0, new JSONObject(strD));
        } catch (JSONException unused) {
            return new Pair<>(5, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.qq.e.comm.plugin.yq a(com.qq.e.comm.plugin.e2 r11, com.qq.e.comm.plugin.yq r12, boolean r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.w10.a(com.qq.e.comm.plugin.e2, com.qq.e.comm.plugin.yq, boolean):com.qq.e.comm.plugin.yq");
    }

    private void a() {
        new c(this.a, r1.d().f().b("bpts", ""), true).b();
    }

    private String a(String str, int i) {
        return str + Config.replace + i;
    }
}
