package lkxssdk.i;

import android.content.Context;
import lkxssdk.l.j;
import lkxssdk.l.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b {
    public lkxssdk.k.a<String> a;

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            lkxssdk.k.a<String> aVar = b.this.a;
            if (aVar != null) {
                aVar.b(this.a);
            }
        }
    }

    public b(lkxssdk.k.a<String> aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String strD;
        try {
            strD = lkxssdk.a.a.d(lkxssdk.a.a.a((Context) lkxssdk.a.a.d()));
        } catch (Exception e) {
            lkxssdk.h0.c.b("checkEM", e);
            strD = "";
        }
        j.a.post(new a(strD));
    }

    public void b() {
        if (s.a == null) {
            synchronized (s.class) {
                if (s.a == null) {
                    s.a = new s();
                }
            }
        }
        s.a.execute(new Runnable() { // from class: lkxssdk.i.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }
}
