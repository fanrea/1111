package com.qq.e.comm.plugin.apkmanager;

import com.qq.e.comm.plugin.apkmanager.a;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.ct;
import com.qq.e.comm.plugin.j3;
import com.qq.e.comm.plugin.qg;
import java.io.File;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class p implements a.InterfaceC0696a, c.a {
    private final c a;
    private final a b;
    private final ApkDownloadTask c;

    public p(a aVar, c cVar, ApkDownloadTask apkDownloadTask) {
        this.a = cVar;
        this.b = aVar;
        this.c = apkDownloadTask;
        aVar.a(this);
        cVar.a(this);
    }

    public void a(int i, String str) {
        throw null;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a.InterfaceC0696a
    public void a(long j, long j2) {
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c.a
    public boolean a() {
        return false;
    }

    public void b() {
        qg.b.submit(this.b);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.c.a
    public void a(int i, String str, boolean z) {
        if (i == 0) {
            if (!z) {
                ct.a(this.c, 2);
            }
            j3.a(this.c.r()).i = 2;
            ct.a(this.c);
        }
        a(i, str);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a.InterfaceC0696a
    public void a(int i) {
        if (i == 3) {
            ct.a(this.c, 0);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a.InterfaceC0696a
    public void a(int i, String str, File file) {
        if (i == 0) {
            ct.a(this.c, 1);
        }
        if (i == 9 || (i == 0 && this.c.a("appInstall"))) {
            this.a.a(file, i == 0);
        }
        a(i, str);
    }
}
