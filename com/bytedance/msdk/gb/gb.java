package com.bytedance.msdk.gb;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private static volatile gb b;
    private volatile String d = "";
    private volatile ExecutorService hc = com.bytedance.msdk.d.u.an.d(Config.GAID, 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.gb.gb.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });

    public static gb d() {
        if (b == null) {
            synchronized (gb.class) {
                if (b == null) {
                    b = new gb();
                }
            }
        }
        return b;
    }

    private gb() {
    }

    public String hc() {
        try {
            this.d = zw.d("tt_device_info", com.bytedance.msdk.core.hc.getContext()).hc(Config.GAID, "");
            com.bytedance.msdk.d.u.b.d(Config.GAID, "--==-- getGAIdTimeOut-mGAId = " + this.d);
            if (TextUtils.isEmpty(this.d)) {
                synchronized (this) {
                    if (this.hc != null) {
                        FutureTask futureTask = new FutureTask(new d());
                        this.hc.execute(futureTask);
                        this.d = (String) futureTask.get(1L, TimeUnit.MICROSECONDS);
                        if (!TextUtils.isEmpty(this.d)) {
                            this.hc.shutdown();
                            this.hc = null;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return this.d;
    }

    public synchronized void b() {
        try {
            this.d = zw.d("tt_device_info", com.bytedance.msdk.core.hc.getContext()).hc(Config.GAID, "");
            com.bytedance.msdk.d.u.b.d(Config.GAID, "--==-- initGAIdByAsyc-mGAId = " + this.d);
            if (TextUtils.isEmpty(this.d) && this.hc != null) {
                this.hc.execute(new FutureTask(new d()));
            }
        } catch (Throwable unused) {
        }
    }

    private class d implements Callable<String> {
        private d() {
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.hc.getContext());
                if (advertisingIdInfo != null) {
                    String id = advertisingIdInfo.getId();
                    com.bytedance.msdk.d.u.b.d("gaid-", "getAdvertisingId: ".concat(String.valueOf(id)));
                    gb.hc(id);
                }
            } catch (Throwable unused) {
            }
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.msdk.core.hc.getContext());
                if (advertisingIdInfo2 != null) {
                    gb.this.d = advertisingIdInfo2.getId();
                    advertisingIdInfo2.isLimitAdTrackingEnabled();
                }
            } catch (Throwable unused2) {
            }
            com.bytedance.msdk.d.u.b.d("AdvertisingIdHelper", "mGAId:" + gb.this.d + " , get gaid consume time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return gb.this.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zw.d("tt_device_info", com.bytedance.msdk.core.hc.getContext()).d(Config.GAID, str);
    }
}
