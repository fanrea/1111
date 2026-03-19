package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.f;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class l {

    public enum a {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        CANCELED,
        UNKNOWN
    }

    public static a a(String url, String parentPath, String filename) {
        return b(d(url, parentPath, filename));
    }

    public static boolean a(f task) {
        return g.j().a().c(task) != null;
    }

    public static a b(f task) {
        a aVarD = d(task);
        if (aVarD == a.COMPLETED) {
            return a.COMPLETED;
        }
        com.sigmob.sdk.downloader.core.dispatcher.b bVarA = g.j().a();
        return bVarA.f(task) ? a.PENDING : bVarA.d(task) ? a.RUNNING : bVarA.e(task) ? a.CANCELED : aVarD;
    }

    public static boolean b(String url, String parentPath, String filename) {
        return c(d(url, parentPath, filename));
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c c(String url, String parentPath, String filename) {
        return e(d(url, parentPath, filename));
    }

    public static boolean c(f task) {
        return d(task) == a.COMPLETED;
    }

    public static f d(String url, String parentPath, String filename) {
        return new f.a(url, parentPath, filename).a();
    }

    public static a d(f task) {
        com.sigmob.sdk.downloader.core.breakpoint.g gVarC = g.j().c();
        com.sigmob.sdk.downloader.core.breakpoint.c cVarA = gVarC.a(task.c());
        String strD = task.d();
        File fileL = task.l();
        File fileN = task.n();
        if (cVarA != null) {
            if (!cVarA.b() && cVarA.j() <= 0) {
                return a.UNKNOWN;
            }
            if (fileN != null && fileN.equals(cVarA.o()) && fileN.exists() && cVarA.i() == cVarA.j()) {
                return a.COMPLETED;
            }
            if (strD == null && cVarA.o() != null && cVarA.o().exists()) {
                return a.IDLE;
            }
            if (fileN != null && fileN.equals(cVarA.o()) && fileN.exists()) {
                return a.IDLE;
            }
        } else {
            if (gVarC.a() || gVarC.c(task.c())) {
                return a.UNKNOWN;
            }
            if (fileN != null && fileN.exists()) {
                return a.COMPLETED;
            }
            String strA = gVarC.a(task.i());
            if (strA != null && new File(fileL, strA).exists()) {
                return a.COMPLETED;
            }
        }
        return a.UNKNOWN;
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c e(f task) {
        com.sigmob.sdk.downloader.core.breakpoint.g gVarC = g.j().c();
        com.sigmob.sdk.downloader.core.breakpoint.c cVarA = gVarC.a(gVarC.b(task));
        if (cVarA == null) {
            return null;
        }
        return cVarA.p();
    }
}
