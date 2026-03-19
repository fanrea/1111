package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.vv;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    private String d;
    private String hc;

    hc() {
    }

    public static com.ss.android.socialbase.downloader.h.c d(Context context) {
        h.hc(context);
        return new com.ss.android.socialbase.downloader.h.c();
    }

    public void d(int i) {
        c.d().c(i);
    }

    public int d(String str, String str2) {
        return c.d().d(str, str2);
    }

    public List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        return c.d().d(str);
    }

    public void hc(int i) {
        d(i, true);
    }

    public void d(int i, boolean z) {
        c.d().b(i, z);
    }

    public void b(int i) {
        c.d().an(i);
    }

    public boolean c(int i) {
        return c.d().u(i);
    }

    public void u(int i) {
        c.d().h(i);
    }

    public void d() {
        c.d().b();
    }

    public void d(List<String> list) {
        c.d().d(list);
    }

    public void hc(List<String> list) {
        c.d().hc(list);
    }

    public int an(int i) {
        return c.d().gb(i);
    }

    public boolean h(int i) {
        boolean zTt;
        if (com.ss.android.socialbase.downloader.e.d.d(4194304)) {
            synchronized (this) {
                zTt = c.d().tt(i);
            }
            return zTt;
        }
        return c.d().tt(i);
    }

    public com.ss.android.socialbase.downloader.h.b gb(int i) {
        return c.d().tc(i);
    }

    public com.ss.android.socialbase.downloader.h.b hc(String str, String str2) {
        return c.d().hc(str, str2);
    }

    public s tt(int i) {
        return c.d().mk(i);
    }

    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        return c.d().hc(str);
    }

    public void tc(int i) {
        c.d().c(i, true);
    }

    @Deprecated
    public void mk(int i) {
        c.d().d(i, null, com.ss.android.socialbase.downloader.hc.gb.MAIN, true);
    }

    @Deprecated
    public void d(int i, vv vvVar) {
        if (vvVar == null) {
            return;
        }
        c.d().hc(i, vvVar, com.ss.android.socialbase.downloader.hc.gb.MAIN, true);
    }

    @Deprecated
    public void d(int i, vv vvVar, boolean z) {
        if (vvVar == null) {
            return;
        }
        c.d().d(i, vvVar, com.ss.android.socialbase.downloader.hc.gb.MAIN, true, z);
    }

    public boolean d(com.ss.android.socialbase.downloader.h.b bVar) {
        return c.d().d(bVar);
    }

    public List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        return c.d().b(str);
    }

    public List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        return c.d().c(str);
    }

    public void d(com.ss.android.socialbase.downloader.c.mq mqVar) {
        c.d().d(mqVar);
    }

    public com.ss.android.socialbase.downloader.c.sy mq(int i) {
        return c.d().e(i);
    }

    public boolean uo(int i) {
        return c.d().b(i).hc();
    }

    public rf hc() {
        return b.wl();
    }

    public void d(rf rfVar) {
        b.d(rfVar);
    }

    public File b() {
        return d(this.d, true);
    }

    public File c() {
        return d(this.hc, false);
    }

    private File d(String str, boolean z) {
        File file;
        File file2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            file = new File(str);
        } catch (Throwable unused) {
        }
        try {
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                if (!z) {
                    return null;
                }
                file.delete();
                file.mkdirs();
            }
            return file;
        } catch (Throwable unused2) {
            file2 = file;
            return file2;
        }
    }

    public void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }
}
