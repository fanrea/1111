package lkxssdk.e0;

import android.content.Context;
import java.io.File;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class d {
    public final Executor a;
    public final Executor b;
    public final int c;
    public final int d;
    public final j e;
    public final i f;
    public final b g;
    public boolean h;

    public static class a {
        public Context a;
        public Executor b;
        public Executor c;
        public i d;
        public b e;
        public boolean f = true;
        public String g;

        public a(Context context) {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.a = context.getApplicationContext();
            try {
                this.g = this.a.getExternalFilesDir("XSWDownload").getAbsolutePath() + File.separator + "image";
            } catch (Exception unused) {
                StringBuilder sbAppend = new StringBuilder().append(this.a.getFilesDir().getAbsolutePath());
                String str = File.separator;
                this.g = sbAppend.append(str).append("XSWDownload").append(str).append("image").toString();
            }
            j jVar = j.FIFO;
            this.b = lkxssdk.a.a.a(3, 3, jVar);
            this.c = lkxssdk.a.a.a(3, 3, jVar);
            b bVar = new b();
            this.e = bVar;
            bVar.a(this.g);
            this.d = new i();
        }

        public static /* synthetic */ int c(a aVar) {
            aVar.getClass();
            return 3;
        }

        public static /* synthetic */ int d(a aVar) {
            aVar.getClass();
            return 3;
        }

        public static /* synthetic */ j e(a aVar) {
            aVar.getClass();
            return j.FIFO;
        }
    }

    public d(a aVar) {
        this.a = aVar.b;
        this.b = aVar.c;
        a.c(aVar);
        this.c = 3;
        a.d(aVar);
        this.d = 3;
        a.e(aVar);
        this.e = j.FIFO;
        this.g = aVar.e;
        this.f = aVar.d;
        this.h = aVar.f;
    }
}
