package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.vv;
import java.io.File;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h extends hc {
    private static volatile h d;

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ int an(int i) {
        return super.an(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ File b() {
        return super.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ List b(String str) {
        return super.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void b(int i) {
        super.b(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ File c() {
        return super.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ List c(String str) {
        return super.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ boolean c(int i) {
        return super.c(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ int d(String str, String str2) {
        return super.d(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ List d(String str) {
        return super.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void d(int i) {
        super.d(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    @Deprecated
    public /* bridge */ /* synthetic */ void d(int i, vv vvVar) {
        super.d(i, vvVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    @Deprecated
    public /* bridge */ /* synthetic */ void d(int i, vv vvVar, boolean z) {
        super.d(i, vvVar, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void d(int i, boolean z) {
        super.d(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void d(com.ss.android.socialbase.downloader.c.mq mqVar) {
        super.d(mqVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void d(rf rfVar) {
        super.d(rfVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void d(List list) {
        super.d((List<String>) list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        return super.d(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.h.b gb(int i) {
        return super.gb(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ boolean h(int i) {
        return super.h(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ rf hc() {
        return super.hc();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.h.b hc(String str, String str2) {
        return super.hc(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ List hc(String str) {
        return super.hc(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void hc(int i) {
        super.hc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void hc(List list) {
        super.hc((List<String>) list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    @Deprecated
    public /* bridge */ /* synthetic */ void mk(int i) {
        super.mk(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.c.sy mq(int i) {
        return super.mq(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void tc(int i) {
        super.tc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ s tt(int i) {
        return super.tt(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void u(int i) {
        super.u(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ void u(String str) {
        super.u(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.hc
    public /* bridge */ /* synthetic */ boolean uo(int i) {
        return super.uo(i);
    }

    static {
        b.d(new v());
        d = null;
    }

    private h() {
    }

    public static synchronized void d(gb gbVar, boolean z) {
        if (gbVar == null) {
            return;
        }
        if (d == null) {
            d = gbVar.zw();
        } else if (!b.q()) {
            b.d(gbVar);
        } else {
            if (z) {
                b.hc(gbVar);
            }
        }
    }

    h(gb gbVar) {
        b.d(gbVar);
    }

    public static h hc(Context context) {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    b.d(context);
                    d = new h();
                }
            }
        }
        return d;
    }
}
