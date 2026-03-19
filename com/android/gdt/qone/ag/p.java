package com.android.gdt.qone.ag;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class p {
    public static p b;
    public q a = new q();

    public static p a() {
        if (b == null) {
            synchronized (p.class) {
                if (b == null) {
                    b = new p();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012c A[Catch: IOException -> 0x0128, TRY_LEAVE, TryCatch #1 {IOException -> 0x0128, blocks: (B:85:0x0124, B:89:0x012c), top: B:95:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(int r14, com.android.gdt.qone.ag.r r15) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.ag.p.b(int, com.android.gdt.qone.ag.r):java.lang.String");
    }

    public final String a(int i, r rVar) {
        String strA;
        synchronized (String.class) {
            strA = this.a.a(i);
            if (strA == null) {
                strA = b(i, rVar);
            }
        }
        return strA;
    }
}
