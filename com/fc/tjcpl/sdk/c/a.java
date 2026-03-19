package com.fc.tjcpl.sdk.c;

import android.content.Context;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    public final Context a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public final ExecutorService i;
    public final ExecutorService j = Executors.newCachedThreadPool();
    public final ExecutorService k = Executors.newCachedThreadPool();
    public boolean l;

    /* renamed from: com.fc.tjcpl.sdk.c.a$a, reason: collision with other inner class name */
    public static class C0359a {
        public Context a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i = true;

        public C0359a(Context context) {
            this.a = context.getApplicationContext();
            try {
                this.b = this.a.getExternalFilesDir("TJDownload").getAbsolutePath() + File.separator + PointCategory.APP;
            } catch (Exception unused) {
                StringBuilder sbAppend = new StringBuilder().append(this.a.getFilesDir().getAbsolutePath());
                String str = File.separator;
                this.b = sbAppend.append(str).append("TJDownload").append(str).append(PointCategory.APP).toString();
            }
            this.c = 1;
            this.d = 1;
            this.e = 2;
            this.f = 5000;
            this.g = 10000;
            this.h = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:4:0x0004 A[PHI: r0
  0x0004: PHI (r0v2 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0002, B:6:0x0009] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.fc.tjcpl.sdk.c.a.C0359a a(int r2) {
            /*
                r1 = this;
                r0 = 30000(0x7530, float:4.2039E-41)
                if (r2 <= r0) goto L7
            L4:
                r1.g = r0
                goto Le
            L7:
                r0 = 5000(0x1388, float:7.006E-42)
                if (r2 >= r0) goto Lc
                goto L4
            Lc:
                r1.g = r2
            Le:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.c.a.C0359a.a(int):com.fc.tjcpl.sdk.c.a$a");
        }

        public C0359a b(int i) {
            StringBuilder sb;
            if (i < 1) {
                sb = new StringBuilder();
            } else {
                if (i < 3) {
                    this.d = i;
                    return this;
                }
                this.d = 3;
                sb = new StringBuilder();
            }
            com.fc.tjcpl.sdk.i.c.a("AppLoaderConfiguration", sb.append("设置单个任务下载线程数：").append(i).append("，已修改为:").append(this.d).toString());
            return this;
        }

        public C0359a c(int i) {
            StringBuilder sb;
            if (i < 1) {
                sb = new StringBuilder();
            } else {
                if (i < 5) {
                    this.c = i;
                    return this;
                }
                this.c = 5;
                sb = new StringBuilder();
            }
            com.fc.tjcpl.sdk.i.c.a("AppLoaderConfiguration", sb.append("设置同时下载任务数：").append(i).append("，已修改为:").append(this.c).toString());
            return this;
        }
    }

    public a(C0359a c0359a) {
        this.a = c0359a.a;
        this.b = c0359a.b;
        this.c = c0359a.c;
        this.d = c0359a.d;
        this.e = c0359a.e;
        this.f = c0359a.f;
        this.g = c0359a.g;
        this.h = c0359a.h;
        this.i = Executors.newFixedThreadPool(c0359a.c);
        this.l = c0359a.i;
    }
}
