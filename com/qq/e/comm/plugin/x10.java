package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.v8;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x10 {
    private final Map<String, a9> a = new ConcurrentHashMap();
    private final kn b = new kn();

    public a9 a(y10 y10Var, String str) {
        if (TextUtils.isEmpty(y10Var.a()) || TextUtils.isEmpty(str)) {
            return null;
        }
        v8.a aVarB = v8.b();
        vl vlVarA = this.b.a(str, new a(y10Var));
        if (vlVarA == null) {
            return null;
        }
        z10 z10Var = vlVarA.c;
        f5 f5Var = new f5();
        f5Var.d(y10Var.a());
        v8.b(2230101, aVarB, f5Var);
        if (z10Var == null) {
            return null;
        }
        if (!TextUtils.isEmpty(z10Var.l)) {
            com.qq.e.comm.dynamic.c.a().a(f5Var);
        }
        if (vlVarA.b) {
            j60.a().a(f5Var);
        }
        a9 a9Var = new a9(y10Var.a(), z10Var, vlVarA.a, vlVarA.b, y10Var);
        this.a.put(a9Var.a, a9Var);
        return a9Var;
    }

    /* compiled from: A */
    class a implements wl {
        final /* synthetic */ y10 a;

        @Override // com.qq.e.comm.plugin.wl
        public void a(z10 z10Var) {
        }

        a(y10 y10Var) {
            this.a = y10Var;
        }

        @Override // com.qq.e.comm.plugin.wl
        public void a(int i, JSONObject jSONObject) throws JSONException {
            if (i == 102 || i == 103) {
                c9.a(this.a.a(), this.a.b(), i, jSONObject);
            }
        }
    }

    public int a() {
        return this.b.a;
    }

    public a9 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.a.get(str);
    }
}
