package com.qq.e.comm.plugin.apkmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qq.e.comm.plugin.o3;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.s3;
import com.qq.e.comm.plugin.t3;
import com.qq.e.comm.plugin.yh;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class e extends BroadcastReceiver implements s3.g {
    private static final e f = new e();
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private b e;

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApkDownloadTask apkDownloadTaskC;
            o3.d().a(this.a, this.b);
            if (!this.b || (apkDownloadTaskC = l.e().c(this.a)) == null) {
                return;
            }
            t3.a(1100937, apkDownloadTaskC);
        }
    }

    /* compiled from: A */
    interface b {
        void b(String str);
    }

    private e() {
        this.b = r1.d().f().a("raisr", 0) == 1;
        boolean zA = yh.a("hieib");
        this.c = zA;
        boolean zA2 = yh.a("ribr");
        this.d = zA2;
        if (!zA || zA2) {
            return;
        }
        s3.b().a(this);
    }

    public static e a() {
        return f;
    }

    public void b() {
        if (!this.b || yh.a("ribrwss")) {
            return;
        }
        c();
    }

    void c() {
        if (this.d) {
            return;
        }
        if ((!this.c || s3.b().c()) && this.a.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            if (this.b) {
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            }
            intentFilter.addDataScheme("package");
            try {
                r1.d().a().registerReceiver(this, intentFilter);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.qq.e.comm.plugin.s3.g
    public boolean d() {
        c();
        return false;
    }

    void e() {
        if (this.a.compareAndSet(true, false)) {
            try {
                r1.d().a().unregisterReceiver(this);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.qq.e.comm.plugin.s3.g
    public boolean h() {
        e();
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString != null && dataString.startsWith("package:")) {
            dataString = dataString.substring(8);
        }
        String action = intent.getAction();
        if (!"android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
            if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                a(dataString, true);
            }
        } else {
            b bVar = this.e;
            if (bVar != null) {
                bVar.b(dataString);
            }
            a(dataString, false);
        }
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    private void a(String str, boolean z) {
        if (this.b) {
            qg.b.submit(new a(str, z));
        }
    }
}
