package cn.net.shoot.sharetracesdk.d;

import android.app.Activity;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ d b;

    public c(d dVar, Activity activity) {
        this.b = dVar;
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((ViewGroup) this.a.getWindow().getDecorView()).removeView(this.b.b);
    }
}
