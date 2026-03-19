package lkxssdk.e0;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class g implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ h b;

    public g(h hVar, Bitmap bitmap) {
        this.b = hVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.b()) {
            return;
        }
        h hVar = this.b;
        hVar.a.a(hVar.f);
        h hVar2 = this.b;
        hVar2.g.a(hVar2.d, hVar2.f.b(), this.a);
    }
}
