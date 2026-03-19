package com.bytedance.applog.aggregation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MetricsSQLiteCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/applog/aggregation/MetricsSQLiteCache;", "Lcom/bytedance/applog/aggregation/IMetricsCache;", "context", "Landroid/content/Context;", "dbName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "memCache", "Lcom/bytedance/applog/aggregation/MetricsMemoryCache;", "openHelper", "Lcom/bytedance/applog/aggregation/MetricsSQLiteOpenHelper;", "clear", "", "fillMetrics", "Lcom/bytedance/applog/aggregation/Metrics;", "cursor", "Landroid/database/Cursor;", "get", "groupId", "getAll", "", "getByMetricsName", "name", "insert", MetricsSQLiteCacheKt.METRICS_TABLE_NAME, n.q, "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MetricsSQLiteCache implements IMetricsCache {
    private final MetricsMemoryCache memCache;
    private final MetricsSQLiteOpenHelper openHelper;

    public MetricsSQLiteCache(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "dbName");
        this.openHelper = new MetricsSQLiteOpenHelper(context, str);
        this.memCache = new MetricsMemoryCache();
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public Metrics get(String groupId) {
        Intrinsics.checkParameterIsNotNull(groupId, "groupId");
        Metrics metrics = this.memCache.get(groupId);
        if (metrics != null) {
            return metrics;
        }
        Cursor cursorRawQuery = this.openHelper.getReadableDatabase().rawQuery("SELECT * FROM metrics WHERE group_id = ?", new String[]{groupId});
        if (!cursorRawQuery.moveToNext()) {
            return metrics;
        }
        Intrinsics.checkExpressionValueIsNotNull(cursorRawQuery, "cursor");
        Metrics metricsFillMetrics = fillMetrics(cursorRawQuery);
        this.memCache.insert(groupId, metricsFillMetrics);
        return metricsFillMetrics;
    }

    private final Metrics fillMetrics(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("name"));
        String string2 = cursor.getString(cursor.getColumnIndex("group_id"));
        int i = cursor.getInt(cursor.getColumnIndex(MetricsSQLiteCacheKt.METRICS_AGG_TYPES));
        long j = cursor.getLong(cursor.getColumnIndex(MetricsSQLiteCacheKt.METRICS_START_TIME));
        String string3 = cursor.getString(cursor.getColumnIndex("params"));
        JSONObject jSONObject = string3 != null ? UtilsKt.toJSONObject(string3) : null;
        String string4 = cursor.getString(cursor.getColumnIndex(MetricsSQLiteCacheKt.METRICS_INTERVAL));
        int i2 = cursor.getInt(cursor.getColumnIndex("count"));
        double d = cursor.getDouble(cursor.getColumnIndex(MetricsSQLiteCacheKt.METRICS_SUM));
        long j2 = cursor.getLong(cursor.getColumnIndex(MetricsSQLiteCacheKt.METRICS_END_TIME));
        String string5 = cursor.getString(cursor.getColumnIndex(MetricsSQLiteCacheKt.METRICS_VALUE_ARRAY));
        JSONArray jSONArray = string5 != null ? UtilsKt.toJSONArray(string5) : null;
        Intrinsics.checkExpressionValueIsNotNull(string, "name");
        Intrinsics.checkExpressionValueIsNotNull(string2, "groupId");
        Metrics metrics = new Metrics(string, string2, i, j, jSONObject, string4);
        metrics.restore(i2, d, j2, jSONArray);
        return metrics;
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public void insert(String groupId, Metrics metrics) {
        Intrinsics.checkParameterIsNotNull(groupId, "groupId");
        Intrinsics.checkParameterIsNotNull(metrics, MetricsSQLiteCacheKt.METRICS_TABLE_NAME);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", metrics.getName());
        contentValues.put("group_id", metrics.getGroupId());
        contentValues.put(MetricsSQLiteCacheKt.METRICS_AGG_TYPES, Integer.valueOf(metrics.getAggregationTypes()));
        contentValues.put(MetricsSQLiteCacheKt.METRICS_START_TIME, Long.valueOf(metrics.getStartTime()));
        JSONObject params = metrics.getParams();
        contentValues.put("params", params != null ? params.toString() : null);
        contentValues.put(MetricsSQLiteCacheKt.METRICS_INTERVAL, metrics.getInterval());
        contentValues.put("count", Integer.valueOf(metrics.getCount()));
        contentValues.put(MetricsSQLiteCacheKt.METRICS_SUM, Double.valueOf(metrics.getSum()));
        contentValues.put(MetricsSQLiteCacheKt.METRICS_END_TIME, Long.valueOf(metrics.getEndTime()));
        contentValues.put(MetricsSQLiteCacheKt.METRICS_VALUE_ARRAY, String.valueOf(metrics.getValues()));
        this.openHelper.getWritableDatabase().insert(MetricsSQLiteCacheKt.METRICS_TABLE_NAME, null, contentValues);
        this.memCache.insert(groupId, metrics);
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public void update(String groupId, Metrics metrics) {
        Intrinsics.checkParameterIsNotNull(groupId, "groupId");
        Intrinsics.checkParameterIsNotNull(metrics, MetricsSQLiteCacheKt.METRICS_TABLE_NAME);
        ContentValues contentValues = new ContentValues();
        contentValues.put("count", Integer.valueOf(metrics.getCount()));
        contentValues.put(MetricsSQLiteCacheKt.METRICS_SUM, Double.valueOf(metrics.getSum()));
        contentValues.put(MetricsSQLiteCacheKt.METRICS_END_TIME, Long.valueOf(metrics.getEndTime()));
        contentValues.put(MetricsSQLiteCacheKt.METRICS_VALUE_ARRAY, String.valueOf(metrics.getValues()));
        this.openHelper.getWritableDatabase().update(MetricsSQLiteCacheKt.METRICS_TABLE_NAME, contentValues, "group_id = ?", new String[]{groupId});
        this.memCache.update(groupId, metrics);
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public List<Metrics> getAll() {
        Cursor cursorRawQuery = this.openHelper.getReadableDatabase().rawQuery("SELECT * FROM metrics", null);
        ArrayList arrayList = new ArrayList();
        while (cursorRawQuery.moveToNext()) {
            Intrinsics.checkExpressionValueIsNotNull(cursorRawQuery, "cursor");
            arrayList.add(fillMetrics(cursorRawQuery));
        }
        return arrayList;
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public List<Metrics> getByMetricsName(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Cursor cursorRawQuery = this.openHelper.getReadableDatabase().rawQuery("SELECT * FROM metrics WHERE name = ?", new String[]{name});
        ArrayList arrayList = new ArrayList();
        while (cursorRawQuery.moveToNext()) {
            Intrinsics.checkExpressionValueIsNotNull(cursorRawQuery, "cursor");
            arrayList.add(fillMetrics(cursorRawQuery));
        }
        return arrayList;
    }

    @Override // com.bytedance.applog.aggregation.IMetricsCache
    public void clear() {
        this.openHelper.getWritableDatabase().delete(MetricsSQLiteCacheKt.METRICS_TABLE_NAME, null, null);
        this.memCache.clear();
    }
}
