package cn.net.shoot.sharetracesdk.e;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements f {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ f b;
    public final /* synthetic */ List c;
    public final /* synthetic */ CountDownLatch d;

    public a(AtomicBoolean atomicBoolean, f fVar, List list, CountDownLatch countDownLatch) {
        this.a = atomicBoolean;
        this.b = fVar;
        this.c = list;
        this.d = countDownLatch;
    }

    @Override // cn.net.shoot.sharetracesdk.e.f
    public void a(cn.net.shoot.sharetracesdk.c.c cVar) {
        String str = "proxy callback : " + (cVar == null ? ILogConst.CACHE_PLAY_REASON_NULL : cVar.toString());
        if (cVar != null && cVar.a == 200 && !TextUtils.isEmpty(cVar.c) && !this.a.get()) {
            this.a.set(true);
            this.b.a(cVar);
        }
        this.c.add(cVar);
        this.d.countDown();
    }
}
