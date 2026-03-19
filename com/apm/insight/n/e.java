package com.apm.insight.n;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.runtime.s;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e {
    private static volatile e a;
    private volatile Context b;

    private e(Context context) {
        this.b = context;
    }

    public static e a() {
        if (a == null) {
            a = new e(com.apm.insight.g.f());
        }
        return a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strF = f.f();
            File file = new File(com.apm.insight.o.p.a(this.b), com.apm.insight.o.p.d());
            com.apm.insight.o.j.a(file, file.getName(), strF, jSONObject, f.b());
            if (f.a(strF, jSONObject.toString()).a()) {
                com.apm.insight.o.j.a(file);
            }
        } catch (Throwable th) {
            com.apm.insight.o.q.b(th);
        }
    }

    public boolean a(long j, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String strC = f.c();
                File file = new File(com.apm.insight.o.p.a(this.b), com.apm.insight.o.p.a(com.apm.insight.g.d()));
                com.apm.insight.o.j.a(file, file.getName(), strC, jSONObject, f.a());
                jSONObject.put("upload_scene", "direct");
                com.apm.insight.o.r.a(jSONObject);
                if (!f.b(strC, jSONObject.toString()).a()) {
                    return false;
                }
                com.apm.insight.o.j.a(file);
                return true;
            } catch (Throwable th) {
                com.apm.insight.o.q.b(th);
            }
        }
        return false;
    }

    public boolean a(String str, String str2, String str3, List<String> list) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && list != null && list.size() != 0) {
            try {
                return f.a(f.d(), str, str2, str3, list);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public boolean a(JSONObject jSONObject, long j, boolean z, String str, boolean z2, String str2) {
        File[] fileArr;
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String strC = f.c();
                if (str2 == null) {
                    str2 = com.apm.insight.g.a(j, CrashType.ANR, false, false);
                }
                File file = new File(com.apm.insight.o.p.a(this.b), str2);
                if (z2) {
                    com.apm.insight.o.j.a(file, file.getName(), strC, jSONObject, f.b());
                }
                if (z && !Npth.isStopUpload()) {
                    jSONObject.put("upload_scene", "direct");
                    jSONObject.put("crash_uuid", file.getName());
                    com.apm.insight.o.r.a(jSONObject);
                    if (com.apm.insight.runtime.a.j()) {
                        HashMap<String, s.a> mapA = s.a(j, "anr_trace");
                        fileArr = new File[mapA.size() + 2];
                        int i = 0;
                        for (Map.Entry<String, s.a> entry : mapA.entrySet()) {
                            if (!entry.getKey().equals(com.apm.insight.o.a.c(this.b))) {
                                fileArr[i] = com.apm.insight.o.p.a(this.b, entry.getValue().b);
                                i++;
                            }
                        }
                    } else {
                        fileArr = new File[2];
                    }
                    fileArr[fileArr.length - 1] = com.apm.insight.o.p.a(this.b, str);
                    fileArr[fileArr.length - 2] = s.a(j);
                    if (f.a(strC, jSONObject.toString(), fileArr).a()) {
                        com.apm.insight.o.j.a(file);
                        com.apm.insight.o.j.a(com.apm.insight.o.p.a(this.b, str));
                        com.apm.insight.o.j.a(com.apm.insight.o.p.b(this.b, str));
                        if (!Npth.hasCrash()) {
                            com.apm.insight.o.j.a(com.apm.insight.o.p.e(com.apm.insight.g.f()));
                        }
                        com.apm.insight.runtime.h.a(com.apm.insight.o.p.k(com.apm.insight.g.f()), CrashType.ANR, file.getName());
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public boolean a(JSONObject jSONObject, File file, File file2) {
        try {
            String strG = f.g();
            com.apm.insight.o.r.a(jSONObject);
            return f.a(strG, jSONObject.toString(), file, file2, s.a(System.currentTimeMillis())).a();
        } catch (Throwable th) {
            com.apm.insight.o.q.b(th);
            return false;
        }
    }

    public void b(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.n.e.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                String strC = f.c();
                try {
                    jSONObject.put("upload_scene", "direct");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                f.b(strC, jSONObject.toString());
            }
        });
    }

    public void c(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.n.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    StringBuilder sb = new StringBuilder(f.h());
                    String strF = com.apm.insight.f.f();
                    sb.append("?os=Android");
                    if (!TextUtils.isEmpty(strF)) {
                        sb.append("&aid=" + strF);
                        String strD = com.apm.insight.f.d(strF);
                        sb.append(!TextUtils.isEmpty(strD) ? "&device_id=" + strD : "&device_id=null_device_id");
                    }
                    f.b(sb.toString(), jSONObject.toString());
                } catch (Throwable unused) {
                }
            }
        });
    }
}
