package cn.net.shoot.sharetracesdk.f;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static Handler b;
    public static final Object a = new Object();
    public static final ExecutorService c = Executors.newScheduledThreadPool(2);

    public static Handler a() {
        Handler handler;
        synchronized (a) {
            if (b == null) {
                b = new Handler(Looper.getMainLooper());
            }
            handler = b;
        }
        return handler;
    }

    public static void a(Runnable runnable) {
        ExecutorService executorService;
        if (runnable == null || (executorService = c) == null) {
            return;
        }
        executorService.execute(runnable);
    }
}
