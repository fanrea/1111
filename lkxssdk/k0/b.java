package lkxssdk.k0;

import android.content.Context;
import java.util.concurrent.Executor;
import lkxssdk.e0.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b {

    public static class a {
        public Context a;
        public Executor b;
        public int c = 2;
        public String d;

        public a(Context context) {
            this.b = null;
            j jVar = j.FIFO;
            this.a = context.getApplicationContext();
            this.b = lkxssdk.a.a.a(1, 5, jVar);
        }
    }

    public b(a aVar) {
        Context unused = aVar.a;
        Executor unused2 = aVar.b;
        String unused3 = aVar.d;
        int unused4 = aVar.c;
    }
}
