package com.fc.tjcpl.sdk.c;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.fc.tjcpl.sdk.c.i;
import com.just.agentweb.AgentWebPermissions;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class g implements Runnable, com.fc.tjcpl.sdk.e.d, i.a {
    public com.fc.tjcpl.sdk.f.a a;
    public com.fc.tjcpl.sdk.f.b b;
    public d c;
    public b d;
    public com.fc.tjcpl.sdk.e.c e;
    public e f;
    public List<com.fc.tjcpl.sdk.f.c> g;
    public List<i> h;
    public String i;
    public String j;
    public int k;
    public long l;
    public final Object m = new Object();
    public int n;
    public int o;
    public long p;
    public boolean q;
    public boolean r;

    public g(String str, com.fc.tjcpl.sdk.f.a aVar, b bVar, e eVar, d dVar, com.fc.tjcpl.sdk.e.c cVar) {
        this.a = aVar;
        this.d = bVar;
        this.f = eVar;
        this.c = dVar;
        this.e = cVar;
        b(str);
    }

    public final boolean a(String str) {
        if (!Environment.getExternalStorageState().equals(com.component.c.c.a)) {
            return false;
        }
        File file = new File(str);
        return !file.exists() ? file.mkdirs() : file.canWrite();
    }

    public final void b() {
        String string;
        if (TextUtils.isEmpty(this.b.f)) {
            com.fc.tjcpl.sdk.f.b bVar = this.b;
            String str = bVar.a;
            String str2 = this.j;
            String str3 = this.a.c;
            try {
                String strSubstring = str2.substring(str2.lastIndexOf("/") + 1, str2.length());
                int iLastIndexOf = strSubstring.lastIndexOf(46);
                if (iLastIndexOf > 0 && strSubstring.substring(iLastIndexOf).toLowerCase(Locale.getDefault()).equals(".apk")) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                }
                string = (!TextUtils.isEmpty(str3) ? new StringBuilder().append(strSubstring).append(Config.replace).append(str3) : new StringBuilder().append(strSubstring)).append(".apk").toString();
                String[] strArr = {"\\", "/", ":", "\"", "<", ">", "?", "|", "*"};
                for (int i = 0; i < 9; i++) {
                    if (string.contains(strArr[i])) {
                        string = string.replace(strArr[i], Config.replace);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                string = str + ".apk";
            }
            if (TextUtils.isEmpty(string)) {
                string = str + ".apk";
            }
            bVar.f = string;
        }
    }

    public final boolean b(int i) {
        return i == 21 || i == 22 || i == 23;
    }

    public final void c() {
        if (this.d.b.get()) {
            return;
        }
        if (com.fc.tjcpl.sdk.b.a.g()) {
            this.d.a();
        }
        if (this.d.a.get()) {
            synchronized (this.d.c) {
                if (this.d.a.get()) {
                    try {
                        this.d.c.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    public final boolean c(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        if (!com.fc.tjcpl.sdk.b.a.a(file.getAbsolutePath())) {
            return true;
        }
        file.delete();
        return false;
    }

    public final void d() throws com.fc.tjcpl.sdk.e.a {
        String str = this.d.d.b;
        com.fc.tjcpl.sdk.i.c.b("DownloadTask", "configSavePath:" + str);
        if (str.equals(this.b.e)) {
            if (TextUtils.isEmpty(str) || !str.startsWith(File.separator)) {
                throw new com.fc.tjcpl.sdk.e.a(2, 21);
            }
            if (!a(str)) {
                throw new com.fc.tjcpl.sdk.e.a(2, 23);
            }
            return;
        }
        if (a(this.b.e)) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = File.separator;
            if (str.startsWith(str2)) {
                if (!a(str)) {
                    throw new com.fc.tjcpl.sdk.e.a(2, 23);
                }
                com.fc.tjcpl.sdk.f.b bVar = this.b;
                bVar.e = str;
                bVar.g = str + str2 + "cache";
                return;
            }
        }
        throw new com.fc.tjcpl.sdk.e.a(2, 21);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0135, code lost:
    
        if (c(r8.b.e + java.io.File.separator + r8.b.f) == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.c.g.e():void");
    }

    public final void f() throws com.fc.tjcpl.sdk.e.a {
        long blockSize;
        long availableBlocks;
        int size = this.g.size();
        Iterator<com.fc.tjcpl.sdk.f.c> it = this.g.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().g;
        }
        StatFs statFs = new StatFs(new File(this.b.e).getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        }
        long j2 = availableBlocks * blockSize;
        com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",storage info：可用大小：" + com.fc.tjcpl.sdk.b.a.a(j2) + ",文件大小：" + com.fc.tjcpl.sdk.b.a.a(this.l) + ",需预留空间大小：" + com.fc.tjcpl.sdk.b.a.a(314572800L));
        long j3 = this.l;
        if (j3 <= 0) {
            if (j2 < 314572800) {
                throw new com.fc.tjcpl.sdk.e.a(2, 22);
            }
        } else {
            if (size > 1) {
                j3 *= 2;
            }
            if (j2 < (j3 - j) + 314572800) {
                throw new com.fc.tjcpl.sdk.e.a(2, 22);
            }
        }
    }

    public final void g() {
        Iterator<com.fc.tjcpl.sdk.f.c> it = this.g.iterator();
        while (it.hasNext()) {
            File file = new File(it.next().h);
            if (file.exists()) {
                file.delete();
            }
        }
        this.g.clear();
        this.c.a(this.b.a);
        if (b(this.b.h)) {
            h();
        }
    }

    public final void h() {
        this.b.h = 6;
        this.f.j(this.a);
        this.a.getClass();
        this.q = true;
        com.fc.tjcpl.sdk.b.a.j(this.b.e + File.separator + this.b.f);
        this.b.h = 7;
        this.f.k(this.a);
        ((h) this.e).a(this.b.a, false);
    }

    public void i() {
        this.q = true;
        com.fc.tjcpl.sdk.b.a.j(this.b.e + File.separator + this.b.f);
        this.b.h = 7;
        this.f.k(this.a);
    }

    public void j() {
        String str;
        synchronized (this.m) {
            com.fc.tjcpl.sdk.i.c.b("DownloadTask", "onDownloadComplete() taskLocked");
            if (b(this.b.h)) {
                k();
                int size = this.g.size();
                if (size > 1) {
                    int i = this.n + 1;
                    this.n = i;
                    if (i != size) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<com.fc.tjcpl.sdk.f.c> it = this.g.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().h);
                    }
                    str = this.b.e + File.separator + this.b.f + ".tmp";
                    if (!com.fc.tjcpl.sdk.l.b.a(str, arrayList)) {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        c(new com.fc.tjcpl.sdk.e.a(5, 53));
                        return;
                    }
                } else {
                    str = this.g.get(0).h;
                }
                File file2 = new File(this.b.e + File.separator + this.b.f);
                if (!new File(str).renameTo(file2)) {
                    c(new com.fc.tjcpl.sdk.e.a(5, 54));
                    return;
                }
                if (com.fc.tjcpl.sdk.b.a.a(file2.getAbsolutePath())) {
                    c(new com.fc.tjcpl.sdk.e.a(5, 56));
                } else {
                    g();
                }
            }
        }
    }

    public void k() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.p > 500) {
            synchronized (this.m) {
                if (b(this.b.h)) {
                    Iterator<com.fc.tjcpl.sdk.f.c> it = this.g.iterator();
                    long j = 0;
                    while (it.hasNext()) {
                        j += it.next().g;
                    }
                    com.fc.tjcpl.sdk.f.b bVar = this.b;
                    bVar.j = j;
                    this.f.a(this.a, bVar.c, j);
                    this.p = jCurrentTimeMillis;
                }
            }
        }
    }

    public void l() {
        com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",pause()");
        int i = this.b.h;
        if (i == 1) {
            com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",pause() status :" + this.b.h);
            this.b.h = 5;
            this.f.i(this.a);
            return;
        }
        if (!b(i)) {
            com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",pause() status :" + this.b.h);
            return;
        }
        com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",pause() status : downloading");
        this.b.h = 51;
        this.f.e(this.a);
        synchronized (this.m) {
            if (this.r) {
                this.r = false;
                com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",pause() status : pausing");
            } else {
                com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",pause() downloadThreads.size:" + this.h.size());
                if (this.h.size() > 0) {
                    Iterator<i> it = this.h.iterator();
                    while (it.hasNext()) {
                        it.next().d = true;
                    }
                }
                a(new com.fc.tjcpl.sdk.e.a(8, 0));
            }
        }
    }

    public final void m() throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        d dVar = this.c;
        String str = this.b.a;
        List<com.fc.tjcpl.sdk.f.c> list = this.g;
        dVar.getClass();
        try {
            try {
                dVar.a(str);
                dVar.b = dVar.a.getWritableDatabase();
                Iterator<com.fc.tjcpl.sdk.f.c> it = list.iterator();
                while (it.hasNext()) {
                    dVar.b.insert("download_thread_info", "_id", it.next().a());
                }
                sQLiteDatabase = dVar.b;
            } catch (Exception e) {
                e.printStackTrace();
                sQLiteDatabase = dVar.b;
                if (sQLiteDatabase != null) {
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
            int i = this.k;
            if (i == 1) {
                long j = this.l;
                String str2 = this.b.f;
                int size = this.g.size();
                try {
                    String str3 = this.b.g + File.separator + "." + this.b.a + ".cfg";
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fileName", str2);
                        jSONObject.put("fileSize", j);
                        jSONObject.put("threadCount", size);
                        jSONObject.put("acceptRange", i);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    com.fc.tjcpl.sdk.l.b.a(TextUtils.isEmpty(str3) ? null : new File(str3), com.fc.tjcpl.sdk.b.a.b("12345678asdfghjk", jSONObject.toString()), false);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase2 = dVar.b;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.close();
            }
            throw th;
        }
    }

    public final void n() {
        this.h.clear();
        com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",startDownloadThreads() status :" + this.b.h);
        this.b.h = 23;
        k();
        com.fc.tjcpl.sdk.i.c.b("DownloadTask", "threadInfos size()==" + this.g.size());
        for (com.fc.tjcpl.sdk.f.c cVar : this.g) {
            this.a.getClass();
            b bVar = this.d;
            i iVar = new i(false, bVar, cVar, bVar.d.f, this);
            this.h.add(iVar);
            this.d.d.j.execute(iVar);
        }
        com.fc.tjcpl.sdk.i.c.b("DownloadTask", "startDownloadThreads");
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        com.fc.tjcpl.sdk.i.c.b("DownloadTask", "run()");
        try {
            this.i = null;
            a(0);
            this.a.getClass();
            c();
            a(4);
            this.n = 0;
            this.o = 0;
            d();
            com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",step1: " + this.b.toString());
            a(this.a.b, this.d.d.g);
            this.b.k = 0;
            a(1);
            b();
            com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",step3: apkFileName:" + this.b.f);
            if (c(this.b.e + File.separator + this.b.f)) {
                this.c.a(this.b);
                h();
                return;
            }
            a(2);
            File file = new File(this.b.g);
            if (!file.exists() && !file.mkdirs()) {
                throw new com.fc.tjcpl.sdk.e.a(5, 51);
            }
            a();
            m();
            f();
            synchronized (this.m) {
                a(3);
                this.b.h = 22;
                this.f.d(this.a);
                n();
                this.r = false;
            }
        } catch (Exception e) {
            a(e instanceof com.fc.tjcpl.sdk.e.a ? (com.fc.tjcpl.sdk.e.a) e : new com.fc.tjcpl.sdk.e.a(7, 0));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c A[Catch: Exception -> 0x0089, TryCatch #1 {Exception -> 0x0089, blocks: (B:7:0x003e, B:12:0x004d, B:18:0x0059, B:34:0x0084, B:25:0x006c, B:27:0x0072, B:29:0x0078, B:32:0x007f, B:21:0x0064, B:10:0x0046), top: B:81:0x003e, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013e A[LOOP:0: B:68:0x013c->B:69:0x013e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.c.g.a():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050 A[PHI: r0 r6
  0x0050: PHI (r0v65 android.database.sqlite.SQLiteDatabase) = (r0v67 android.database.sqlite.SQLiteDatabase), (r0v70 android.database.sqlite.SQLiteDatabase) binds: [B:22:0x004e, B:15:0x0042] A[DONT_GENERATE, DONT_INLINE]
  0x0050: PHI (r6v7 com.fc.tjcpl.sdk.f.b) = (r6v8 com.fc.tjcpl.sdk.f.b), (r6v9 com.fc.tjcpl.sdk.f.b) binds: [B:22:0x004e, B:15:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.c.g.b(java.lang.String):void");
    }

    public final void c(com.fc.tjcpl.sdk.e.a aVar) {
        for (com.fc.tjcpl.sdk.f.c cVar : this.g) {
            File file = new File(cVar.h);
            if (file.exists()) {
                file.delete();
            }
            cVar.g = 0L;
        }
        File file2 = new File(this.b.e + File.separator + this.b.f);
        if (file2.exists()) {
            file2.delete();
        }
        int i = this.o;
        if (i >= this.d.d.e) {
            a(aVar);
        } else {
            this.o = i + 1;
            n();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(int r15) {
        /*
            r14 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "appID:"
            java.lang.StringBuilder r0 = r0.append(r1)
            com.fc.tjcpl.sdk.f.a r2 = r14.a
            java.lang.String r2 = r2.a
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = ",setThreadInfos("
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r15)
            java.lang.String r2 = ")"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "DownloadTask"
            com.fc.tjcpl.sdk.i.c.c(r2, r0)
            long r3 = r14.l
            long r5 = (long) r15
            long r3 = r3 / r5
            r0 = 0
        L31:
            if (r0 >= r15) goto Le0
            com.fc.tjcpl.sdk.f.c r5 = new com.fc.tjcpl.sdk.f.c
            r5.<init>()
            com.fc.tjcpl.sdk.f.b r6 = r14.b
            java.lang.String r6 = r6.a
            r5.a = r6
            com.fc.tjcpl.sdk.f.a r6 = r14.a
            java.lang.String r6 = r6.b
            r5.d = r6
            r5.b = r0
            int r6 = r14.k
            r5.c = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.fc.tjcpl.sdk.f.b r7 = r14.b
            java.lang.String r7 = r7.g
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = java.io.File.separator
            java.lang.StringBuilder r6 = r6.append(r7)
            com.fc.tjcpl.sdk.f.b r7 = r14.b
            java.lang.String r7 = r7.f
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = "_"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.h = r6
            long r7 = (long) r0
            long r7 = r7 * r3
            r5.e = r7
            int r7 = r15 + (-1)
            r8 = 1
            if (r0 != r7) goto L8b
            long r10 = r14.l
            r12 = 0
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 <= 0) goto L88
            goto L8f
        L88:
            r5.f = r10
            goto L92
        L8b:
            int r7 = r0 + 1
            long r10 = (long) r7
            long r10 = r10 * r3
        L8f:
            long r10 = r10 - r8
            r5.f = r10
        L92:
            java.io.File r7 = new java.io.File
            r7.<init>(r6)
            boolean r6 = r7.exists()
            if (r6 == 0) goto Lb1
            long r8 = r7.length()
            r10 = -1
            int r6 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r6 == 0) goto Lb1
            int r6 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r6 <= 0) goto Laf
            r7.delete()
            goto Lb1
        Laf:
            r5.g = r8
        Lb1:
            java.util.List<com.fc.tjcpl.sdk.f.c> r6 = r14.g
            r6.add(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r1)
            com.fc.tjcpl.sdk.f.a r7 = r14.a
            java.lang.String r7 = r7.a
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = ",create downloadThreadInfo,"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            com.fc.tjcpl.sdk.i.c.c(r2, r5)
            int r0 = r0 + 1
            goto L31
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.c.g.c(int):void");
    }

    public final void a(int i) throws com.fc.tjcpl.sdk.e.a {
        com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",checkPaused(" + i + ") status :" + this.b.h);
        int i2 = this.b.h;
        if (i2 == 51 || i2 == 5) {
            throw new com.fc.tjcpl.sdk.e.a(8, 0);
        }
    }

    public final void a(String str, int i) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                String strA = com.fc.tjcpl.sdk.b.a.a(this.d.d.l, str);
                com.fc.tjcpl.sdk.j.c cVar = new com.fc.tjcpl.sdk.j.c(strA);
                com.fc.tjcpl.sdk.i.c.b("DownloadTask", "connectTimeout==" + i);
                cVar.b = i;
                HttpURLConnection httpURLConnectionA = com.fc.tjcpl.sdk.b.a.a(cVar);
                int responseCode = httpURLConnectionA.getResponseCode();
                com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",getServerFileInfo()：responseCode:" + responseCode + ",url: " + strA);
                int i2 = 0;
                while (responseCode / 100 == 3 && i2 < 5) {
                    strA = com.fc.tjcpl.sdk.b.a.a(this.d.d.l, httpURLConnectionA.getHeaderField(AgentWebPermissions.ACTION_LOCATION));
                    cVar.a = strA;
                    httpURLConnectionA = com.fc.tjcpl.sdk.b.a.a(cVar);
                    responseCode = httpURLConnectionA.getResponseCode();
                    i2++;
                    com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",getServerFileInfo()：responseCode:" + responseCode + ",redirectCount：" + i2 + ",url: " + strA);
                }
                if (i2 >= 5 && responseCode / 100 == 3) {
                    throw new com.fc.tjcpl.sdk.e.a(3, 33);
                }
                if (responseCode != 200) {
                    if (responseCode == 404) {
                        throw new com.fc.tjcpl.sdk.e.a(3, 31);
                    }
                    String str2 = "HTTP Status-Code " + responseCode + ": can not read data";
                    throw new com.fc.tjcpl.sdk.e.a(3, 32);
                }
                this.j = strA;
                String headerField = httpURLConnectionA.getHeaderField("Accept-Ranges");
                String headerField2 = httpURLConnectionA.getHeaderField("Content-Type");
                com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",getServerFileInfo()：Http HeaderField Content-Type:" + headerField2);
                if (!TextUtils.isEmpty(headerField2) && headerField2.contains("html")) {
                    throw new com.fc.tjcpl.sdk.e.a(4, 43);
                }
                com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",getServerFileInfo()：Http HeaderField Accept-Ranges:" + headerField);
                this.k = TextUtils.equals(headerField, "bytes") ? 1 : 0;
                long contentLength = httpURLConnectionA.getContentLength();
                this.l = contentLength;
                if (contentLength <= 0) {
                    this.l = com.fc.tjcpl.sdk.b.a.a(httpURLConnectionA.getHeaderFields());
                }
                com.fc.tjcpl.sdk.i.c.c("DownloadTask", "appID:" + this.a.a + ",getServerFileInfo()：serverfileSize:" + this.l);
                httpURLConnectionA.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                if (com.fc.tjcpl.sdk.b.a.e().ordinal() != 0) {
                    throw new com.fc.tjcpl.sdk.e.a(4, 42);
                }
                throw new com.fc.tjcpl.sdk.e.a(4, 41);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!(e2 instanceof com.fc.tjcpl.sdk.e.a)) {
                    throw new com.fc.tjcpl.sdk.e.a(7, 0);
                }
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public void b(com.fc.tjcpl.sdk.e.a aVar) {
        synchronized (this.m) {
            int i = this.b.h;
            if (!(i == 51 || i == 5)) {
                Iterator<i> it = this.h.iterator();
                while (it.hasNext()) {
                    it.next().d = true;
                }
                this.h.clear();
                a(aVar);
            }
        }
    }

    public final void a(com.fc.tjcpl.sdk.e.a aVar) {
        com.fc.tjcpl.sdk.i.c.b("DownloadTask", "handleFail: DownloadException:" + aVar.a + Config.replace + aVar.b);
        com.fc.tjcpl.sdk.f.b bVar = this.b;
        if (bVar.h == 5) {
            return;
        }
        if (aVar.a == 4 && aVar.b != 43) {
            int i = bVar.k + 1;
            bVar.k = i;
            if (i <= this.d.d.e) {
                ((h) this.e).a(bVar.a, true);
                return;
            }
        }
        ((h) this.e).a(bVar.a, false);
        if (aVar.a != 8) {
            this.f.a(this.a, aVar);
        }
        com.fc.tjcpl.sdk.f.b bVar2 = this.b;
        bVar2.h = 5;
        bVar2.k = 0;
        this.f.i(this.a);
    }

    public void a(boolean z) {
        this.r = true;
        if (z) {
            return;
        }
        this.b.h = 21;
        this.f.g(this.a);
    }
}
