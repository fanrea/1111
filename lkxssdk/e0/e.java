package lkxssdk.e0;

import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class e implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ f b;

    public e(f fVar, h hVar) {
        this.b = fVar;
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar = this.b.a.g;
        String str = this.a.d;
        bVar.getClass();
        File file = !TextUtils.isEmpty(str) ? new File(bVar.a, lkxssdk.a0.c.a(str)) : null;
        boolean z = file != null && file.exists();
        f fVar = this.b;
        if (((ExecutorService) fVar.b).isShutdown()) {
            d dVar = fVar.a;
            fVar.b = lkxssdk.a.a.a(dVar.c, dVar.d, dVar.e);
        }
        if (((ExecutorService) fVar.c).isShutdown()) {
            d dVar2 = fVar.a;
            fVar.c = lkxssdk.a.a.a(dVar2.c, dVar2.d, dVar2.e);
        }
        (z ? this.b.c : this.b.b).execute(this.a);
    }
}
