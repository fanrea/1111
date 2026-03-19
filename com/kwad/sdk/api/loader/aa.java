package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.s;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class aa {
    private static final AtomicBoolean bta = new AtomicBoolean();

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (com.kwad.sdk.api.b.VL()) {
            return;
        }
        AtomicBoolean atomicBoolean = bta;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.aa.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - b.y(context, "lastUpdateTime")) < b.y(context, MetricsSQLiteCacheKt.METRICS_INTERVAL) * 1000) {
                        return;
                    }
                    s.VZ().a(new ab() { // from class: com.kwad.sdk.api.loader.aa.1.1
                        @Override // com.kwad.sdk.api.loader.ab
                        public final Context getContext() {
                            return context;
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final String Wb() {
                            return aa.Wa();
                        }

                        @Override // com.kwad.sdk.api.loader.ab
                        public final IKsAdSDK Wc() {
                            return iKsAdSDK;
                        }
                    }, new s.c<Boolean>() { // from class: com.kwad.sdk.api.loader.aa.1.2
                        @Override // com.kwad.sdk.api.loader.s.c
                        public final /* synthetic */ void o(Boolean bool) {
                            c(bool);
                        }

                        private static void c(Boolean bool) {
                            new StringBuilder("onNewResult: ").append(bool);
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void bq(Context context) {
        i.z(context, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Wa() {
        String strDD = com.kwad.sdk.api.b.dD("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        return !TextUtils.isEmpty(strDD) ? strDD : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    }
}
