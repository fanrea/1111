package com.qq.e.comm.plugin;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.qq.e.comm.plugin.m0;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s1 {
    private static final s1 d = new s1();
    private volatile JSONObject b;
    private final AtomicInteger c = new AtomicInteger(-1);
    private final v1 a = new v1();

    private void a() {
        pro.getVresult(379, 0, this);
    }

    static /* synthetic */ void a(s1 s1Var) {
        pro.getVresult(380, 1, s1Var);
    }

    static /* synthetic */ void a(s1 s1Var, String str, JSONArray jSONArray) {
        pro.getVresult(381, 1, s1Var, str, jSONArray);
    }

    private void a(String str, JSONArray jSONArray) {
        pro.getVresult(382, 0, this, str, jSONArray);
    }

    private boolean a(PackageManager packageManager, String str) {
        return pro.getZresult(383, 0, this, packageManager, str);
    }

    public static s1 d() {
        return (s1) pro.getobjresult(384, 1, new Object[0]);
    }

    private boolean e() {
        return pro.getZresult(385, 0, this);
    }

    public void b() {
        pro.getVresult(386, 0, this);
    }

    public JSONObject c() {
        return (JSONObject) pro.getobjresult(387, 0, this);
    }

    public void f() {
        pro.getVresult(388, 0, this);
    }

    private s1() {
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s1.a(s1.this);
        }
    }

    /* compiled from: A */
    class b implements m0.b {
        b() {
        }

        @Override // com.qq.e.comm.plugin.m0.b
        public void a(JSONObject jSONObject) {
            JSONArray jSONArrayOptJSONArray;
            if (jSONObject == null) {
                return;
            }
            String strOptString = jSONObject.optString("v");
            if (TextUtils.isEmpty(strOptString) || (jSONArrayOptJSONArray = jSONObject.optJSONArray("l")) == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            s1.a(s1.this, strOptString, jSONArrayOptJSONArray);
        }
    }
}
