package cn.net.shoot.sharetracesdk.d;

import android.app.Activity;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements Runnable {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ d b;

    public b(d dVar, Activity activity) {
        this.b = dVar;
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup viewGroup = (ViewGroup) this.a.getWindow().getDecorView();
        this.b.b = new e(this.a);
        viewGroup.addView(this.b.b, new ViewGroup.LayoutParams(1, 1));
    }
}
