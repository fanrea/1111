package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.dysi.IGDTADM;
import com.qq.e.comm.plugin.n;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lg implements IGDTADM {
    private final Handler a;
    private final com.qq.e.comm.dynamic.b b;
    private final h4 c;
    private final f5 d;
    private final boolean e;
    private int f;
    private m g;

    public lg(Handler handler, com.qq.e.comm.dynamic.b bVar, h4 h4Var, yq yqVar) {
        this.e = r1.d().f().a("dfwrdtmd", 1) == 1;
        this.a = handler;
        this.b = bVar;
        this.c = h4Var;
        this.d = f5.a(h4Var, yqVar);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public void setObserveFlag(int i) {
        this.f = i;
        if ((i & 2) == 2) {
            a();
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public void pause() throws JSONException {
        ApkDownloadTask apkDownloadTaskC;
        String strA = a(this.c);
        if (TextUtils.isEmpty(strA) || (apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(strA)) == null) {
            return;
        }
        com.qq.e.comm.plugin.apkmanager.l.e().a(apkDownloadTaskC);
        j3.b(4001004, apkDownloadTaskC, 1, 103);
        t3.a(strA, 1100954, this.d);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public void resume() throws JSONException {
        ApkDownloadTask apkDownloadTaskC;
        String strA = a(this.c);
        if (TextUtils.isEmpty(strA) || (apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(strA)) == null) {
            return;
        }
        com.qq.e.comm.plugin.apkmanager.l.e().b(apkDownloadTaskC);
        j3.b(4001005, apkDownloadTaskC, 1, 103);
        t3.a(strA, 1100955, this.d);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public void remove() throws JSONException {
        ApkDownloadTask apkDownloadTaskC;
        String strA = a(this.c);
        if (TextUtils.isEmpty(strA) || (apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(strA)) == null) {
            return;
        }
        j3.a(strA).b = 2;
        j3.a(4001074, apkDownloadTaskC, 1);
        if (com.qq.e.comm.plugin.apkmanager.l.e().a(apkDownloadTaskC, this.e)) {
            j3.a(4001075, apkDownloadTaskC, 1);
        }
        t3.a(strA, 1100956, this.d);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTADM
    public String status() throws JSONException {
        jn jnVar = new jn();
        String strA = a(this.c);
        if (TextUtils.isEmpty(strA)) {
            jnVar.a("status", 0);
            jnVar.a("totalSize", 0);
            jnVar.a("progress", 0);
            return jnVar.toString();
        }
        Context contextA = r1.d().a();
        n.b bVarB = n.a().b(contextA, strA);
        jnVar.a("status", n.a().d(contextA, strA));
        jnVar.a("totalSize", Long.toString(this.c.o().f()));
        jnVar.a("progress", bVarB.b);
        return jnVar.toString();
    }

    /* compiled from: A */
    class a implements m {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.qq.e.comm.plugin.m
        public void a(String str, int i, int i2, long j) {
            if (TextUtils.equals(this.a, str)) {
                lg.this.a(this.a, i, i2);
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Config.PACKAGE_NAME, this.a);
                jSONObject.putOpt("s", Integer.valueOf(this.b));
                jSONObject.putOpt("p", Integer.valueOf(this.c));
                in.b().a("event_onAPKStatusUpdate", jSONObject).c().a(lg.this.b, lg.this.d);
            } catch (JSONException unused) {
            }
        }

        b(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }
    }

    private void a() {
        String strA = a(this.c);
        if (!TextUtils.isEmpty(strA) && this.g == null) {
            a(strA, com.qq.e.comm.plugin.apkmanager.l.e().b(strA), -1);
            this.g = new a(strA);
            com.qq.e.comm.plugin.apkmanager.l.e().a(strA, this.g);
        }
    }

    public void b() {
        if (this.g != null) {
            com.qq.e.comm.plugin.apkmanager.l.e().b(this.g);
            this.g = null;
        }
    }

    private String a(h4 h4Var) {
        l3 l3VarO = h4Var.o();
        if (l3VarO == null) {
            return null;
        }
        return l3VarO.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        this.a.post(new b(str, i, i2));
    }
}
