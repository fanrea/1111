package ms.bz.bd.c.Pgl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblf {
    private static final String d = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "1f8836", new byte[]{46, 101, 5, 79, 22, 45});

    /* JADX WARN: Removed duplicated region for block: B:49:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r14) {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 255(0xff, float:3.57E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            r6.<init>()     // Catch: java.lang.Throwable -> L99
            java.io.File r7 = com.bytedance.sdk.openadsdk.api.plugin.hc.d(r14)     // Catch: java.lang.Throwable -> L99
            java.lang.String r7 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L99
            r7 = 16777217(0x1000001, float:2.350989E-38)
            r8 = 0
            r9 = 0
            java.lang.String r11 = "661864"
            byte[] r12 = new byte[r2]     // Catch: java.lang.Throwable -> L99
            r13 = 104(0x68, float:1.46E-43)
            r12[r4] = r13     // Catch: java.lang.Throwable -> L99
            java.lang.Object r7 = com.volcengine.mobsecBiz.matrix.pgla.a(r7, r8, r9, r11, r12)     // Catch: java.lang.Throwable -> L99
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L99
            java.lang.String r7 = ms.bz.bd.c.Pgl.pblf.d     // Catch: java.lang.Throwable -> L99
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L99
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L99
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L99
            boolean r9 = r8.exists()     // Catch: java.lang.Throwable -> L99
            if (r9 == 0) goto L4c
            r8.delete()     // Catch: java.lang.Throwable -> L4a
            r5 = r1
            goto L4c
        L4a:
            r5 = r1
            goto L99
        L4c:
            android.content.res.Resources r14 = r14.getResources()     // Catch: java.lang.Throwable -> L99
            android.content.res.AssetManager r14 = r14.getAssets()     // Catch: java.lang.Throwable -> L99
            java.io.InputStream r14 = r14.open(r7)     // Catch: java.lang.Throwable -> L99
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L9a
            r7.<init>()     // Catch: java.lang.Throwable -> L9a
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r8 = new byte[r3]     // Catch: java.lang.Throwable -> L97
        L61:
            int r9 = r14.read(r8, r4, r3)     // Catch: java.lang.Throwable -> L97
            r10 = -1
            if (r9 == r10) goto L6c
            r7.write(r8, r4, r9)     // Catch: java.lang.Throwable -> L97
            goto L61
        L6c:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L97
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L97
            byte[] r8 = r7.toByteArray()     // Catch: java.lang.Throwable -> L97
            r3.write(r8)     // Catch: java.lang.Throwable -> L97
            r3.close()     // Catch: java.lang.Throwable -> L97
            int r3 = r7.size()     // Catch: java.lang.Throwable -> L97
            if (r3 > 0) goto L82
            goto L90
        L82:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L97
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L97
            boolean r0 = r3.exists()     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L8f
            r0 = r4
            goto L90
        L8f:
            r0 = r5
        L90:
            r14.close()     // Catch: java.lang.Throwable -> L93
        L93:
            r7.close()     // Catch: java.lang.Throwable -> Lc3
            goto Lc3
        L97:
            r3 = r7
            goto L9a
        L99:
            r14 = r3
        L9a:
            r6 = 16777217(0x1000001, float:2.350989E-38)
            r7 = 0
            r8 = 0
            java.lang.String r10 = "db1183"
            r11 = 4
            byte[] r11 = new byte[r11]     // Catch: java.lang.Throwable -> Lc4
            r12 = 116(0x74, float:1.63E-43)
            r11[r4] = r12     // Catch: java.lang.Throwable -> Lc4
            r4 = 99
            r11[r2] = r4     // Catch: java.lang.Throwable -> Lc4
            r2 = 125(0x7d, float:1.75E-43)
            r11[r1] = r2     // Catch: java.lang.Throwable -> Lc4
            r1 = 66
            r11[r0] = r1     // Catch: java.lang.Throwable -> Lc4
            com.volcengine.mobsecBiz.matrix.pgla.a(r6, r7, r8, r10, r11)     // Catch: java.lang.Throwable -> Lc4
            if (r14 == 0) goto Lbd
            r14.close()     // Catch: java.lang.Throwable -> Lbd
        Lbd:
            if (r3 == 0) goto Lc2
            r3.close()     // Catch: java.lang.Throwable -> Lc2
        Lc2:
            r0 = r5
        Lc3:
            return r0
        Lc4:
            r0 = move-exception
            if (r14 == 0) goto Lca
            r14.close()     // Catch: java.lang.Throwable -> Lca
        Lca:
            if (r3 == 0) goto Lcf
            r3.close()     // Catch: java.lang.Throwable -> Lcf
        Lcf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblf.d(android.content.Context):int");
    }
}
