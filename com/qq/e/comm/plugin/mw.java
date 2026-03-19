package com.qq.e.comm.plugin;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mw {

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ com.qq.e.comm.dynamic.b b;
        final /* synthetic */ f5 c;
        final /* synthetic */ JSONObject d;

        a(String str, com.qq.e.comm.dynamic.b bVar, f5 f5Var, JSONObject jSONObject) {
            this.a = str;
            this.b = bVar;
            this.c = f5Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            if (TextUtils.equals("get", this.a)) {
                mw.b(this.b, this.c);
            } else if (TextUtils.equals("remove", this.a)) {
                mw.b(this.d);
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ jn a;
        final /* synthetic */ com.qq.e.comm.dynamic.b b;
        final /* synthetic */ f5 c;

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            in.b().a("biz_onRetentionPkgInfo", this.a.toString()).c().a(this.b, this.c);
        }

        b(jn jnVar, com.qq.e.comm.dynamic.b bVar, f5 f5Var) {
            this.a = jnVar;
            this.b = bVar;
            this.c = f5Var;
        }
    }

    public static String a(h4 h4Var, JSONObject jSONObject, com.qq.e.comm.dynamic.b bVar, f5 f5Var) {
        if (jSONObject == null || xc.a("rndr", 0, h4Var) <= 0) {
            return "";
        }
        qg.c.execute(new a(jSONObject.optString(NotificationCompat.CATEGORY_EVENT), bVar, f5Var, jSONObject));
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(Config.INPUT_DEF_PKG);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        nw.a(strOptString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.qq.e.comm.dynamic.b bVar, f5 f5Var) throws JSONException {
        String strA = nw.a();
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        String strA2 = ct.a(r1.d().a(), strA);
        jn jnVar = new jn();
        jnVar.a(Config.INPUT_DEF_PKG, strA);
        jnVar.a("appname", strA2);
        xo.a((Runnable) new b(jnVar, bVar, f5Var));
    }
}
