package com.bytedance.applog.aggregation;

import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetricsMemoryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/applog/aggregation/MetricsMemoryCache;", "Lcom/bytedance/applog/aggregation/IMetricsCache;", "()V", "cache", "Ljava/util/HashMap;", "", "Lcom/bytedance/applog/aggregation/Metrics;", "clear", "", "get", "groupId", "getAll", "", "getByMetricsName", "name", "insert", MetricsSQLiteCacheKt.METRICS_TABLE_NAME, n.q, "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MetricsMemoryCache implements IMetricsCache {
    private final HashMap<String, Metrics> cache = new HashMap<>();

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public Metrics get(String groupId) {
        Intrinsics.checkParameterIsNotNull(groupId, "groupId");
        return this.cache.get(groupId);
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public void insert(String groupId, Metrics metrics) {
        Intrinsics.checkParameterIsNotNull(groupId, "groupId");
        Intrinsics.checkParameterIsNotNull(metrics, MetricsSQLiteCacheKt.METRICS_TABLE_NAME);
        this.cache.put(groupId, metrics);
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public void update(String groupId, Metrics metrics) {
        Intrinsics.checkParameterIsNotNull(groupId, "groupId");
        Intrinsics.checkParameterIsNotNull(metrics, MetricsSQLiteCacheKt.METRICS_TABLE_NAME);
        insert(groupId, metrics);
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public List<Metrics> getAll() {
        Collection<Metrics> collectionValues = this.cache.values();
        Intrinsics.checkExpressionValueIsNotNull(collectionValues, "cache.values");
        return CollectionsKt.toList(collectionValues);
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public List<Metrics> getByMetricsName(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Collection<Metrics> collectionValues = this.cache.values();
        Intrinsics.checkExpressionValueIsNotNull(collectionValues, "cache.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (Intrinsics.areEqual(((Metrics) obj).getName(), name)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public void clear() {
        this.cache.clear();
    }
}
