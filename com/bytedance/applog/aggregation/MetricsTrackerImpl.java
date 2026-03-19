package com.bytedance.applog.aggregation;

import com.alipay.sdk.m.p0.b;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* compiled from: AggregationImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ$\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010#\u001a\u00020$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/bytedance/applog/aggregation/MetricsTrackerImpl;", "Lcom/bytedance/applog/aggregation/IMetricsTracker;", "metricsName", "", "types", "", "dimensions", "", MetricsSQLiteCacheKt.METRICS_INTERVAL, "", "cache", "Lcom/bytedance/applog/aggregation/IMetricsCache;", "worker", "Lcom/bytedance/applog/aggregation/IWorker;", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Lcom/bytedance/applog/aggregation/IMetricsCache;Lcom/bytedance/applog/aggregation/IWorker;)V", "getCache", "()Lcom/bytedance/applog/aggregation/IMetricsCache;", "getDimensions", "()Ljava/util/List;", "getInterval", "getMetricsName", "()Ljava/lang/String;", "getTypes", "()I", "getWorker", "()Lcom/bytedance/applog/aggregation/IWorker;", "calculateMetricsInterval", b.d, "", "getOrCreateMetrics", "Lcom/bytedance/applog/aggregation/Metrics;", "groupId", "params", "Lorg/json/JSONObject;", "metricsInterval", "track", "", "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MetricsTrackerImpl implements IMetricsTracker {
    private final IMetricsCache cache;
    private final List<String> dimensions;
    private final List<Number> interval;
    private final String metricsName;
    private final int types;
    private final IWorker worker;

    /* JADX WARN: Multi-variable type inference failed */
    public MetricsTrackerImpl(String str, int i, List<String> list, List<? extends Number> list2, IMetricsCache iMetricsCache, IWorker iWorker) {
        Intrinsics.checkParameterIsNotNull(str, "metricsName");
        Intrinsics.checkParameterIsNotNull(iMetricsCache, "cache");
        Intrinsics.checkParameterIsNotNull(iWorker, "worker");
        this.metricsName = str;
        this.types = i;
        this.dimensions = list;
        this.interval = list2;
        this.cache = iMetricsCache;
        this.worker = iWorker;
    }

    public final String getMetricsName() {
        return this.metricsName;
    }

    public final int getTypes() {
        return this.types;
    }

    public final List<String> getDimensions() {
        return this.dimensions;
    }

    public final List<Number> getInterval() {
        return this.interval;
    }

    public final IMetricsCache getCache() {
        return this.cache;
    }

    public final IWorker getWorker() {
        return this.worker;
    }

    @Override // com.bytedance.applog.aggregation.IMetricsTracker
    public void track(final Object value, final JSONObject params) {
        this.worker.post(new Function0<Unit>() { // from class: com.bytedance.applog.aggregation.MetricsTrackerImpl.track.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m346invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m346invoke() {
                String strJoinToString$default;
                MetricsTrackerImpl metricsTrackerImpl = MetricsTrackerImpl.this;
                String strCalculateMetricsInterval = metricsTrackerImpl.calculateMetricsInterval(value, metricsTrackerImpl.getInterval());
                List<String> dimensions = MetricsTrackerImpl.this.getDimensions();
                if (dimensions != null) {
                    List<String> list = dimensions;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (String str : list) {
                        JSONObject jSONObject = params;
                        arrayList.add(jSONObject != null ? jSONObject.opt(str) : null);
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "-", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                } else {
                    strJoinToString$default = null;
                }
                String str2 = MetricsTrackerImpl.this.getMetricsName() + '|' + MetricsTrackerImpl.this.getTypes() + '|' + strCalculateMetricsInterval + '|' + strJoinToString$default;
                Metrics metrics = MetricsTrackerImpl.this.getCache().get(str2);
                boolean z = metrics == null;
                if (metrics == null) {
                    String metricsName = MetricsTrackerImpl.this.getMetricsName();
                    int types = MetricsTrackerImpl.this.getTypes();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = params;
                    metrics = new Metrics(metricsName, str2, types, jCurrentTimeMillis, jSONObject2 != null ? UtilsKt.copy(jSONObject2) : null, strCalculateMetricsInterval);
                }
                metrics.append(value);
                if (z) {
                    MetricsTrackerImpl.this.getCache().insert(str2, metrics);
                } else {
                    MetricsTrackerImpl.this.getCache().update(str2, metrics);
                }
            }
        });
    }

    private final Metrics getOrCreateMetrics(String groupId, JSONObject params, String metricsInterval) {
        Metrics metrics = this.cache.get(groupId);
        if (metrics == null) {
            metrics = new Metrics(this.metricsName, groupId, this.types, System.currentTimeMillis(), params != null ? UtilsKt.copy(params) : null, metricsInterval);
        }
        return metrics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String calculateMetricsInterval(Object value, List<? extends Number> interval) {
        String str;
        if ((this.types & 16) <= 0 || interval == null || !(!interval.isEmpty()) || !(value instanceof Number)) {
            return null;
        }
        double dDoubleValue = ((Number) value).doubleValue();
        Iterator<? extends Number> it = interval.iterator();
        String str2 = "";
        while (true) {
            if (!it.hasNext()) {
                str = "+";
                break;
            }
            double dDoubleValue2 = it.next().doubleValue();
            if (dDoubleValue < dDoubleValue2) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                str = String.format("%.0f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue2)}, 1));
                Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
                break;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str2 = String.format("%.0f", Arrays.copyOf(new Object[]{Double.valueOf(dDoubleValue2)}, 1));
            Intrinsics.checkExpressionValueIsNotNull(str2, "java.lang.String.format(format, *args)");
        }
        return '(' + str2 + StringUtil.COMMA + str + ')';
    }
}
