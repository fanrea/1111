package cn.net.shoot.sharetracesdk.e;

import com.baidu.mobads.container.util.x;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ f c;

    public b(String str, Map map, f fVar) {
        this.a = str;
        this.b = map;
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        cn.net.shoot.sharetracesdk.a.a.a(this.a, this.b, this.c, x.m);
    }
}
