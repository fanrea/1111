package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class r {
    private static final Object bea = new Object();
    private static final Object bec = new Object();
    private w beb;
    private volatile v bed;

    public static void aS(Context context) {
        com.kwad.framework.filedownloader.f.c.aT(context.getApplicationContext());
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwad.framework.filedownloader.f.c.aT(context.getApplicationContext());
        com.kwad.framework.filedownloader.download.b.Ny().a(bVar);
    }

    static final class a {
        private static final r bee = new r();
    }

    public static r Ne() {
        return a.bee;
    }

    public static com.kwad.framework.filedownloader.a co(String str) {
        return new c(str);
    }

    private int di(int i) {
        List<a.InterfaceC0551a> listDd = h.MM().dd(i);
        if (listDd.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        Iterator<a.InterfaceC0551a> it = listDd.iterator();
        while (it.hasNext()) {
            it.next().Mo().pause();
        }
        return listDd.size();
    }

    public final boolean F(int i, String str) {
        di(i);
        if (!n.MW().dh(i)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(com.kwad.framework.filedownloader.f.f.cF(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        return true;
    }

    public final void Nf() {
        if (Ng()) {
            return;
        }
        n.MW().aR(com.kwad.framework.filedownloader.f.c.OV());
    }

    public static boolean Ng() {
        return n.MW().isConnected();
    }

    private static void a(e eVar) {
        f.MK().a("event.service.connect.changed", eVar);
    }

    final w Nh() {
        if (this.beb == null) {
            synchronized (bea) {
                if (this.beb == null) {
                    this.beb = new ab();
                }
            }
        }
        return this.beb;
    }

    final v Ni() {
        if (this.bed == null) {
            synchronized (bec) {
                if (this.bed == null) {
                    this.bed = new z();
                    a((e) this.bed);
                }
            }
        }
        return this.bed;
    }
}
