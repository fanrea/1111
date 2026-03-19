package com.sigmob.sdk.mraid2;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n {
    private final String a;
    private final int b;
    private final boolean c;
    private final c d;
    private Timer e = null;
    private TimerTask f = null;

    /* renamed from: com.sigmob.sdk.mraid2.n$1, reason: invalid class name */
    class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() throws JSONException {
            n.this.d.e(n.this.a);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (n.this.d == null) {
                return;
            }
            n.this.d.a().post(new Runnable() { // from class: com.sigmob.sdk.mraid2.n$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.a();
                }
            });
        }
    }

    public n(c bridge, JSONObject args) {
        this.d = bridge;
        this.b = args.optInt(MetricsSQLiteCacheKt.METRICS_INTERVAL);
        this.c = args.optBoolean("repeats");
        this.a = args.optString("uniqueId");
    }

    private void d() {
        this.e = new Timer();
        this.f = new AnonymousClass1();
    }

    public void a() {
        c();
    }

    public void b() {
        try {
            c();
            d();
            int i = this.b;
            if (i > 0) {
                if (this.c) {
                    this.e.schedule(this.f, i, i);
                } else {
                    this.e.schedule(this.f, i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        TimerTask timerTask = this.f;
        if (timerTask != null) {
            timerTask.cancel();
            this.f = null;
        }
        Timer timer = this.e;
        if (timer != null) {
            timer.cancel();
            this.e.purge();
            this.e = null;
        }
    }
}
