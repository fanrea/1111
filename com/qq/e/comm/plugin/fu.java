package com.qq.e.comm.plugin;

import android.content.Context;
import java.io.File;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fu {
    private static final String a = gu.a("e_qq_com_plugin");
    private static final String b = gu.a("e_qq_com_plugin", r1.d().a().getPackageName());

    public static File b(Context context) {
        return new File(a(context), "gdt_plugin.jar");
    }

    static File c(Context context) {
        return new File(a(context), "gdt_plugin.jar.sig");
    }

    static File d(Context context) {
        return new File(f(context), "gdt_plugin.next");
    }

    static File e(Context context) {
        return new File(f(context), "gdt_plugin.next.sig");
    }

    static File g(Context context) {
        return new File(f(context), "gdt_plugin.tmp");
    }

    static File h(Context context) {
        return new File(f(context), "gdt_plugin.tmp.sig");
    }

    private static File f(Context context) {
        return context.getDir(a, 0);
    }

    static File a(Context context) {
        return context.getDir(b, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r2, boolean r3) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r2 = f(r2)
            java.lang.String r1 = "disdoat"
            r0.<init>(r2, r1)
            if (r3 == 0) goto L19
            boolean r2 = r0.exists()     // Catch: java.lang.Exception -> L17
            if (r2 != 0) goto L19
            r0.createNewFile()     // Catch: java.lang.Exception -> L17
            goto L28
        L17:
            r2 = move-exception
            goto L25
        L19:
            if (r3 != 0) goto L28
            boolean r2 = r0.exists()     // Catch: java.lang.Exception -> L17
            if (r2 == 0) goto L28
            r0.delete()     // Catch: java.lang.Exception -> L17
            goto L28
        L25:
            r2.getMessage()
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.fu.a(android.content.Context, boolean):void");
    }
}
