package com.kwad.framework.filedownloader.f;

import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private static Context bhi;

    public interface a {
        int at(long j);
    }

    public interface b {
        com.kwad.framework.filedownloader.a.b cq(String str);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$c, reason: collision with other inner class name */
    public interface InterfaceC0557c {
        com.kwad.framework.filedownloader.b.a OW();
    }

    public interface d {
        int h(String str, String str2, boolean z);

        int i(String str, String str2, boolean z);
    }

    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static void aT(Context context) {
        bhi = context;
    }

    public static Context OV() {
        return bhi;
    }

    public static boolean a(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.Op().s(com.kwad.framework.filedownloader.message.f.a(i, file, z2));
                return true;
            }
        }
        return false;
    }

    public static boolean a(int i, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.Op().s(com.kwad.framework.filedownloader.message.f.a(i, cVar.Ov(), cVar.getTotal(), z));
        return true;
    }

    public static boolean a(int i, long j, String str, String str2, y yVar) {
        int iP;
        if (str2 == null || str == null || (iP = yVar.p(str, i)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.Op().s(com.kwad.framework.filedownloader.message.f.a(i, j, new PathConflictException(iP, str, str2)));
        return true;
    }
}
