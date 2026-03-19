package com.bytedance.applog.aggregation;

import android.os.Looper;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Defines.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applog/aggregation/IAggregation;", "", "flush", "", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/applog/aggregation/IAggregationFlushCallback;", "newMetricsTracker", "Lcom/bytedance/applog/aggregation/IMetricsTracker;", "metricsName", "", "types", "", "dimensions", "", MetricsSQLiteCacheKt.METRICS_INTERVAL, "", "Companion", "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IAggregation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_AVG = 4;
    public static final int TYPE_COUNT = 1;
    public static final int TYPE_INTERVAL = 16;
    public static final int TYPE_MERGE = 8;
    public static final int TYPE_SUM = 2;

    void flush(IAggregationFlushCallback callback);

    IMetricsTracker newMetricsTracker(String metricsName, int types, List<String> dimensions, List<? extends Number> interval);

    /* compiled from: Defines.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applog/aggregation/IAggregation$Companion;", "", "()V", "TYPE_AVG", "", "TYPE_COUNT", "TYPE_INTERVAL", "TYPE_MERGE", "TYPE_SUM", "newInstance", "Lcom/bytedance/applog/aggregation/IAggregation;", "cache", "Lcom/bytedance/applog/aggregation/IMetricsCache;", "looper", "Landroid/os/Looper;", "aggregation_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_AVG = 4;
        public static final int TYPE_COUNT = 1;
        public static final int TYPE_INTERVAL = 16;
        public static final int TYPE_MERGE = 8;
        public static final int TYPE_SUM = 2;

        public final IAggregation newInstance(IMetricsCache iMetricsCache) {
            return newInstance$default(this, iMetricsCache, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ IAggregation newInstance$default(Companion companion, IMetricsCache iMetricsCache, Looper looper, int i, Object obj) {
            if ((i & 2) != 0) {
                looper = null;
            }
            return companion.newInstance(iMetricsCache, looper);
        }

        public final IAggregation newInstance(IMetricsCache cache, Looper looper) {
            Intrinsics.checkParameterIsNotNull(cache, "cache");
            return new AggregationImpl(cache, looper);
        }
    }
}
