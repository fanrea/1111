package lkxssdk.l;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class s extends ThreadPoolExecutor {
    public static volatile s a;

    public s() {
        super(0, 200, 30L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }
}
