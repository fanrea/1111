package com.bytedance.applog.aggregation;

import com.sigmob.sdk.base.n;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Defines.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applog/aggregation/IMetricsCache;", "", "clear", "", "get", "Lcom/bytedance/applog/aggregation/Metrics;", "groupId", "", "getAll", "", "getByMetricsName", "name", "insert", MetricsSQLiteCacheKt.METRICS_TABLE_NAME, n.q, "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IMetricsCache {
    void clear();

    Metrics get(String groupId);

    List<Metrics> getAll();

    List<Metrics> getByMetricsName(String name);

    void insert(String groupId, Metrics metrics);

    void update(String groupId, Metrics metrics);
}
