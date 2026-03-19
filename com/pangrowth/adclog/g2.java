package com.pangrowth.adclog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g2 extends r1 {
    @Override // com.pangrowth.adclog.r1
    public String b() {
        return "sp";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:30|3|(4:5|(1:(2:7|(2:33|12)(1:31))(0))|17|(3:19|20|21)(3:22|23|24))(0)|28|13|14|17|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00c4, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca A[Catch: all -> 0x00df, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0061, B:7:0x0069, B:9:0x0077, B:19:0x00ca, B:22:0x00d2, B:13:0x0085, B:14:0x00a2, B:16:0x00c4), top: B:30:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d2 A[Catch: all -> 0x00df, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0061, B:7:0x0069, B:9:0x0077, B:19:0x00ca, B:22:0x00d2, B:13:0x0085, B:14:0x00a2, B:16:0x00c4), top: B:30:0x0001, inners: #0 }] */
    @Override // com.pangrowth.adclog.r1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean b(com.pangrowth.adclog.p1 r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.pangrowth.adclog.f1 r0 = com.pangrowth.adclog.f1.c()     // Catch: java.lang.Throwable -> Ldf
            r0.getClass()     // Catch: java.lang.Throwable -> Ldf
            android.content.Context r0 = com.pangrowth.adclog.f1.f     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldf
            r1.<init>()     // Catch: java.lang.Throwable -> Ldf
            android.content.pm.ApplicationInfo r2 = r0.getApplicationInfo()     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r2 = r2.dataDir     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r2 = "/shared_prefs"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldf
            r2.<init>()     // Catch: java.lang.Throwable -> Ldf
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r0 = r0.dataDir     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r2 = "/spFiles"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldf
            r2.<init>()     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r3 = "/tmp"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ldf
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Ldf
            r3.<init>(r1)     // Catch: java.lang.Throwable -> Ldf
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> Ldf
            r4 = 0
            if (r1 == 0) goto L85
            java.io.File[] r1 = r3.listFiles()     // Catch: java.lang.Throwable -> Ldf
            int r3 = r1.length     // Catch: java.lang.Throwable -> Ldf
            r5 = 0
        L67:
            if (r5 >= r3) goto L85
            r6 = r1[r5]     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r7 = r6.getName()     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r8 = ".xml"
            boolean r8 = r7.endsWith(r8)     // Catch: java.lang.Throwable -> Ldf
            if (r8 == 0) goto L82
            java.lang.String r6 = r6.getAbsolutePath()     // Catch: java.lang.Throwable -> Ldf
            boolean r6 = com.pangrowth.adclog.s2.a(r6, r2, r7)     // Catch: java.lang.Throwable -> Ldf
            if (r6 != 0) goto L82
            goto Lc7
        L82:
            int r5 = r5 + 1
            goto L67
        L85:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            r1.<init>()     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            java.lang.StringBuilder r1 = r1.append(r0)     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            java.lang.String r5 = "sp.zip"
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            com.pangrowth.adclog.s2.b(r2, r1)     // Catch: java.lang.Exception -> Lc3 java.lang.Throwable -> Ldf
            com.pangrowth.adclog.s2.a(r2)     // Catch: java.lang.Throwable -> Ldf
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldf
            r1.<init>()     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r1 = "sp.zip"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ldf
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Ldf
            goto Lc7
        Lc3:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Ldf
        Lc7:
            r0 = 1
            if (r4 != 0) goto Ld2
            java.lang.String r1 = "sp文件拷贝失败"
            r9.a(r1, r10)     // Catch: java.lang.Throwable -> Ldf
            monitor-exit(r9)
            return r0
        Ld2:
            com.pangrowth.adclog.m2 r1 = com.pangrowth.adclog.m2.b.a     // Catch: java.lang.Throwable -> Ldf
            java.io.File r2 = r4.getParentFile()     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r3 = "default_sp_file_type"
            r1.a(r10, r2, r3)     // Catch: java.lang.Throwable -> Ldf
            monitor-exit(r9)
            return r0
        Ldf:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pangrowth.adclog.g2.b(com.pangrowth.adclog.p1):boolean");
    }
}
