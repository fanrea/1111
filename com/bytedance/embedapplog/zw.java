package com.bytedance.embedapplog;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class zw {
    boolean b;
    boolean c;
    boolean d;
    boolean hc;

    protected abstract boolean d(JSONObject jSONObject);

    zw(boolean z, boolean z2) {
        this.hc = z;
        this.b = z2;
        this.c = false;
    }

    zw(boolean z, boolean z2, boolean z3) {
        this.hc = z;
        this.b = z2;
        this.c = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String d(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Ld
            return r9
        Ld:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getPath()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "/Android/data/com.snssdk.api.embed/cache"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r8 = r8.toString()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            if (r0 != 0) goto L52
            boolean r0 = r2.mkdirs()     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            if (r0 != 0) goto L52
            return r9
        L52:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            r0.<init>(r8)     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            java.lang.String r2 = "rwd"
            r8.<init>(r0, r2)     // Catch: java.lang.Throwable -> Lad java.io.IOException -> Lb0
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            java.nio.channels.FileLock r1 = r2.lock()     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            boolean r0 = r0.isFile()     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            java.lang.String r2 = "UTF-8"
            if (r0 == 0) goto L8f
            r0 = 129(0x81, float:1.81E-43)
            byte[] r3 = new byte[r0]     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            r4 = 0
            int r5 = r8.read(r3, r4, r0)     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            if (r5 <= 0) goto L8f
            if (r5 >= r0) goto L8f
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            r0.<init>(r3, r4, r5, r2)     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            boolean r3 = com.bytedance.embedapplog.ba.d(r0)     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            if (r3 == 0) goto L8f
            if (r1 == 0) goto L8b
            r1.release()     // Catch: java.lang.Exception -> L8b
        L8b:
            r8.close()     // Catch: java.lang.Exception -> L8e
        L8e:
            return r0
        L8f:
            byte[] r0 = r9.getBytes(r2)     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            r2 = 0
            r8.setLength(r2)     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            r8.write(r0)     // Catch: java.lang.Throwable -> La4 java.io.IOException -> La8
            if (r1 == 0) goto La0
            r1.release()     // Catch: java.lang.Exception -> La0
        La0:
            r8.close()     // Catch: java.lang.Exception -> La3
        La3:
            return r9
        La4:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Ldc
        La8:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto Lb2
        Lad:
            r8 = move-exception
            r0 = r1
            goto Ldc
        Lb0:
            r8 = move-exception
            r0 = r1
        Lb2:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ldb
            r3 = 23
            if (r2 < r3) goto Ld0
            com.bytedance.embedapplog.de r2 = com.bytedance.embedapplog.de.an()     // Catch: java.lang.Throwable -> Ldb
            android.app.Application r2 = r2.d     // Catch: java.lang.Throwable -> Ldb
            java.lang.String r3 = "android.permission.READ_EXTERNAL_STORAGE"
            int r2 = r2.checkSelfPermission(r3)     // Catch: java.lang.Throwable -> Ldb
            if (r2 != 0) goto Lca
            com.bytedance.embedapplog.um.hc(r8)     // Catch: java.lang.Throwable -> Ldb
            goto Ld0
        Lca:
            java.lang.SecurityException r9 = new java.lang.SecurityException     // Catch: java.lang.Throwable -> Ldb
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Ldb
            throw r9     // Catch: java.lang.Throwable -> Ldb
        Ld0:
            if (r1 == 0) goto Ld5
            r1.release()     // Catch: java.lang.Exception -> Ld5
        Ld5:
            if (r0 == 0) goto Lda
            r0.close()     // Catch: java.lang.Exception -> Lda
        Lda:
            return r9
        Ldb:
            r8 = move-exception
        Ldc:
            if (r1 == 0) goto Le1
            r1.release()     // Catch: java.lang.Exception -> Le1
        Le1:
            if (r0 == 0) goto Le6
            r0.close()     // Catch: java.lang.Exception -> Le6
        Le6:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.zw.d(java.lang.String, java.lang.String):java.lang.String");
    }
}
