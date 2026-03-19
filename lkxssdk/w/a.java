package lkxssdk.w;

import android.content.Context;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
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

    /* renamed from: lkxssdk.w.a$a, reason: collision with other inner class name */
    public static class C0849a {
        public Context a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i = true;

        public C0849a(Context context) {
            this.a = context.getApplicationContext();
            try {
                this.b = this.a.getExternalFilesDir("XSWDownload").getAbsolutePath() + File.separator + PointCategory.APP;
            } catch (Exception unused) {
                StringBuilder sbAppend = new StringBuilder().append(this.a.getFilesDir().getAbsolutePath());
                String str = File.separator;
                this.b = sbAppend.append(str).append("XSWDownload").append(str).append(PointCategory.APP).toString();
            }
            this.c = 1;
            this.d = 1;
            this.e = 2;
            this.f = 5000;
            this.g = 10000;
            this.h = false;
        }
    }

    public a(C0849a c0849a) {
        this.a = c0849a.a;
        this.b = c0849a.b;
        this.c = c0849a.c;
        this.d = c0849a.d;
        this.e = c0849a.e;
        this.f = c0849a.f;
        this.g = c0849a.g;
        this.h = c0849a.h;
        this.i = Executors.newFixedThreadPool(c0849a.c);
        this.l = c0849a.i;
    }
}
