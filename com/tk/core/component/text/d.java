package com.tk.core.component.text;

import android.content.Context;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    public static void a(Context context, String str, String str2, final com.tk.core.a.f fVar) {
        com.tk.core.a.oP();
        h(context, str2);
        new com.tk.core.a.f() { // from class: com.tk.core.component.text.d.1
        };
    }

    public static boolean g(Context context, String str) {
        return h(context, str).exists();
    }

    public static File h(Context context, String str) {
        return new File(context.getFilesDir(), String.format("kds_native/font/%s", str));
    }
}
