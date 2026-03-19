package com.getkeepsafe.relinker;

import android.content.Context;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, com.getkeepsafe.relinker.c cVar);
    }

    /* renamed from: com.getkeepsafe.relinker.b$b, reason: collision with other inner class name */
    public interface InterfaceC0389b {
        void j(String str);

        String k(String str);

        void loadLibrary(String str);

        String mapLibraryName(String str);

        String[] supportedAbis();
    }

    public interface c {
    }

    public static void c(Context context, String str) {
        a(context, str, null, null);
    }

    private static void a(Context context, String str, String str2, c cVar) {
        new com.getkeepsafe.relinker.c().a(context, str, (String) null, (c) null);
    }

    public static com.getkeepsafe.relinker.c fO() {
        return new com.getkeepsafe.relinker.c().fO();
    }
}
