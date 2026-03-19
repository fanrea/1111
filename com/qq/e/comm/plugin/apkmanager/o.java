package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.b;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.apkmanager.d;
import com.qq.e.comm.plugin.apkmanager.e;
import com.qq.e.comm.plugin.apkmanager.s;
import com.qq.e.comm.plugin.callback.biz.ApkCallback;
import com.qq.e.comm.plugin.ct;
import com.qq.e.comm.plugin.e3;
import com.qq.e.comm.plugin.ea;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.j3;
import com.qq.e.comm.plugin.ja;
import com.qq.e.comm.plugin.on;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.re;
import com.qq.e.comm.plugin.s3;
import com.qq.e.comm.plugin.t3;
import com.qq.e.comm.plugin.v20;
import com.qq.e.comm.plugin.x5;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class o implements com.qq.e.comm.plugin.apkmanager.c {
    private final Context a;
    private final ApkDownloadTask b;
    private c.a c;
    private final String d;
    private c.a f = new f();
    private int e = e3.a();

    /* compiled from: A */
    class a implements i {
        a() {
        }

        @Override // com.qq.e.comm.plugin.apkmanager.o.i
        public void a(boolean z) throws JSONException {
            o.this.a(z);
        }
    }

    /* compiled from: A */
    class b implements i {
        final /* synthetic */ boolean a;
        final /* synthetic */ File b;
        final /* synthetic */ boolean c;

        b(boolean z, File file, boolean z2) {
            this.a = z;
            this.b = file;
            this.c = z2;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.o.i
        public void a(boolean z) throws JSONException {
            o.this.a(z);
            if (z) {
                ((ApkCallback) x5.b(o.this.d, ApkCallback.class)).b0().b(Integer.valueOf(this.a ? 2 : 1));
                o.this.b(this.b, this.c);
            }
        }
    }

    /* compiled from: A */
    class c implements d.InterfaceC0699d {
        final /* synthetic */ File a;
        final /* synthetic */ boolean b;

        /* compiled from: A */
        class a implements i {
            a() {
            }

            @Override // com.qq.e.comm.plugin.apkmanager.o.i
            public void a(boolean z) {
                if (!z || o.this.e <= 0) {
                    return;
                }
                c cVar = c.this;
                o.this.b(cVar.a, cVar.b);
            }
        }

        c(File file, boolean z) {
            this.a = file;
            this.b = z;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.d.InterfaceC0699d
        public void a() {
            o.this.a(this.a, new a());
        }
    }

    /* compiled from: A */
    class d implements i {
        final /* synthetic */ i a;

        d(i iVar) {
            this.a = iVar;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.o.i
        public void a(boolean z) {
            i iVar = this.a;
            if (iVar != null) {
                iVar.a(z);
            }
            if (z) {
                t3.c(1100905, o.this.b);
            }
        }
    }

    /* compiled from: A */
    class f implements c.a {
        f() {
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return false;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i, String str, boolean z) throws JSONException {
            if (i == 0) {
                o oVar = o.this;
                oVar.a(oVar.b);
            }
            if (o.this.c != null) {
                o.this.c.a(i, str, z);
            }
        }
    }

    /* compiled from: A */
    private interface i {
        void a(boolean z);
    }

    public o(Context context, ApkDownloadTask apkDownloadTask) {
        this.a = context.getApplicationContext();
        this.b = apkDownloadTask;
        this.d = apkDownloadTask.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file, boolean z) {
        this.e--;
        com.qq.e.comm.plugin.apkmanager.d.a().a(file, this.d, z, new c(file, z));
    }

    public boolean b(File file) throws JSONException {
        int i2;
        a();
        t3.f();
        Intent intentA = a(this.a, file);
        String message = "";
        if (this.a.getPackageManager().resolveActivity(intentA, 0) != null) {
            try {
                this.a.startActivity(intentA);
                i2 = 0;
            } catch (Exception e2) {
                message = e2.getMessage();
                i2 = 1;
            }
        } else {
            i2 = 2;
        }
        if (i2 == 0) {
            return true;
        }
        t3.a(1100923, this.b, i2, new ja().a("msg", message).a("url", intentA.getData()));
        return false;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c
    public void a(File file) {
        a(file, new a());
    }

    /* compiled from: A */
    public static final class h implements e.b, b.InterfaceC0697b, s3.g {
        public static final h c = new h();
        private ConcurrentHashMap<String, c.a> a = new ConcurrentHashMap<>();
        private com.qq.e.comm.plugin.apkmanager.b b;

        /* compiled from: A */
        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.e().a(this.a, 1);
            }
        }

        private h() {
            com.qq.e.comm.plugin.apkmanager.e eVarA = com.qq.e.comm.plugin.apkmanager.e.a();
            eVarA.a(this);
            eVarA.c();
            this.b = new com.qq.e.comm.plugin.apkmanager.b(this);
            s3.b().a(this);
        }

        public void a(c.a aVar, ApkDownloadTask apkDownloadTask) {
            if (aVar == null) {
                return;
            }
            String strR = apkDownloadTask.r();
            if (TextUtils.isEmpty(strR)) {
                return;
            }
            this.a.put(strR, new t3.a(apkDownloadTask, aVar));
            this.b.a(strR);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.e.b
        public void b(String str) {
            c.a aVarRemove;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.a.containsKey(str) && (aVarRemove = this.a.remove(str)) != null) {
                aVarRemove.a(0, "", aVarRemove.a());
            }
            qg.b.submit(new a(str));
            com.qq.e.comm.plugin.n.a().a(str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.b.InterfaceC0697b
        public boolean c(String str) {
            return this.a.containsKey(str);
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean d() {
            Iterator<Map.Entry<String, c.a>> it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                this.b.a(it.next().getKey());
            }
            return false;
        }

        @Override // com.qq.e.comm.plugin.s3.g
        public boolean h() {
            return false;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.b.InterfaceC0697b
        public void a(String str) {
            b(str);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c
    public void a(File file, boolean z) {
        if (!z) {
            com.qq.e.comm.plugin.apkmanager.f.a(this.b, file);
        }
        v20 v20VarA = j3.a(this.d);
        boolean z2 = v20VarA.b == 4;
        if (this.b.x()) {
            v20VarA.d = 10;
        } else if (z) {
            v20VarA.d = z2 ? 12 : 1;
        } else {
            v20VarA.d = z2 ? 13 : 2;
        }
        a(file, new b(z2, file, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) throws JSONException {
        j3.a(this.d).c = System.currentTimeMillis();
        j3.a(4001010, this.b, 1);
        if (z) {
            h.c.a(this.f, this.b);
            return;
        }
        c.a aVar = this.c;
        if (aVar != null) {
            aVar.a(1, "", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, i iVar) {
        d dVar = new d(iVar);
        s.a().c(new e(j3.a(this.d), dVar, file));
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c
    public void a(c.a aVar) {
        this.c = aVar;
    }

    private void a() {
        on.a(new g(3, f5.a(this.b.v())));
    }

    private Intent a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uriA = re.a(context, file);
        intent.addFlags(1);
        intent.setDataAndType(uriA, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkDownloadTask apkDownloadTask) throws JSONException {
        j3.a(4001011, apkDownloadTask, 1, 0);
        Context contextA = r1.d().a();
        Intent intentA = ct.a(contextA, apkDownloadTask.r(), apkDownloadTask.f());
        if (intentA == null) {
            return;
        }
        com.qq.e.comm.plugin.p pVar = new com.qq.e.comm.plugin.p(contextA, apkDownloadTask);
        pVar.a(new ea(intentA, apkDownloadTask, contextA));
        pVar.b();
    }

    /* compiled from: A */
    class e implements s.d {
        final /* synthetic */ v20 a;
        final /* synthetic */ i b;
        final /* synthetic */ File c;

        @Override // com.qq.e.comm.plugin.apkmanager.s.d
        public void a(boolean z) {
            if (z) {
                this.a.f = 3;
            } else {
                this.a.f = 1;
            }
            this.b.a(o.this.b(this.c));
        }

        e(v20 v20Var, i iVar, File file) {
            this.a = v20Var;
            this.b = iVar;
            this.c = file;
        }
    }

    /* compiled from: A */
    class g extends on.c {
        @Override // com.qq.e.comm.plugin.on.c, com.qq.e.comm.plugin.s3.g
        public boolean h() {
            super.h();
            t3.g();
            t3.b(1100920, o.this.b, 1);
            return true;
        }

        g(int i, f5 f5Var) {
            super(i, f5Var);
        }
    }
}
