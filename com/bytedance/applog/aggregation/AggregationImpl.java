package com.bytedance.applog.aggregation;

import android.os.Handler;
import android.os.Looper;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AggregationImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J8\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0016J\u0016\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/applog/aggregation/AggregationImpl;", "Lcom/bytedance/applog/aggregation/IAggregation;", "Lcom/bytedance/applog/aggregation/IWorker;", "cache", "Lcom/bytedance/applog/aggregation/IMetricsCache;", "looper", "Landroid/os/Looper;", "(Lcom/bytedance/applog/aggregation/IMetricsCache;Landroid/os/Looper;)V", "handler", "Landroid/os/Handler;", "trackers", "", "Lcom/bytedance/applog/aggregation/IMetricsTracker;", "flush", "", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/applog/aggregation/IAggregationFlushCallback;", "newMetricsTracker", "metricsName", "", "types", "", "dimensions", "", MetricsSQLiteCacheKt.METRICS_INTERVAL, "", "post", "block", "Lkotlin/Function0;", "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AggregationImpl implements IAggregation, IWorker {
    private final IMetricsCache cache;
    private final Handler handler;
    private final List<IMetricsTracker> trackers;

    public AggregationImpl(IMetricsCache iMetricsCache, Looper looper) {
        Intrinsics.checkParameterIsNotNull(iMetricsCache, "cache");
        this.cache = iMetricsCache;
        this.handler = looper != null ? new Handler(looper) : null;
        this.trackers = new ArrayList();
    }

    @Override // com.bytedance.applog.aggregation.IAggregation
    public IMetricsTracker newMetricsTracker(String metricsName, int types, List<String> dimensions, List<? extends Number> interval) {
        Intrinsics.checkParameterIsNotNull(metricsName, "metricsName");
        MetricsTrackerImpl metricsTrackerImpl = new MetricsTrackerImpl(metricsName, types, dimensions != null ? CollectionsKt.sorted(dimensions) : null, interval, this.cache, this);
        this.trackers.add(metricsTrackerImpl);
        return metricsTrackerImpl;
    }

    @Override // com.bytedance.applog.aggregation.IAggregation
    public void flush(final IAggregationFlushCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        post(new Function0<Unit>() { // from class: com.bytedance.applog.aggregation.AggregationImpl.flush.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m345invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m345invoke() {
                List<Metrics> all = AggregationImpl.this.cache.getAll();
                AggregationImpl.this.cache.clear();
                callback.onFinish(all);
            }
        });
    }

    @Override // com.bytedance.applog.aggregation.IWorker
    public void post(final Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        Handler handler = this.handler;
        if (handler == null) {
            block.invoke();
        } else {
            handler.post(new Runnable() { // from class: com.bytedance.applog.aggregation.AggregationImpl.post.1
                @Override // java.lang.Runnable
                public final void run() {
                    block.invoke();
                }
            });
        }
    }
}
