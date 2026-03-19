package com.bytedance.applog.aggregation;

import com.alipay.sdk.m.p0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Defines.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001J(\u0010+\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0006\u0010,\u001a\u00020\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/bytedance/applog/aggregation/Metrics;", "", "name", "", "groupId", "aggregationTypes", "", "startTime", "", "params", "Lorg/json/JSONObject;", MetricsSQLiteCacheKt.METRICS_INTERVAL, "(Ljava/lang/String;Ljava/lang/String;IJLorg/json/JSONObject;Ljava/lang/String;)V", "getAggregationTypes", "()I", "<set-?>", "count", "getCount", "endTime", "getEndTime", "()J", "setEndTime", "(J)V", "getGroupId", "()Ljava/lang/String;", "getInterval", "getName", "getParams", "()Lorg/json/JSONObject;", "getStartTime", "", MetricsSQLiteCacheKt.METRICS_SUM, "getSum", "()D", "values", "Lorg/json/JSONArray;", "getValues", "()Lorg/json/JSONArray;", "setValues", "(Lorg/json/JSONArray;)V", "append", "", b.d, "restore", "toParams", "aggregation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class Metrics {
    private final int aggregationTypes;
    private int count;
    private long endTime;
    private final String groupId;
    private final String interval;
    private final String name;
    private final JSONObject params;
    private final long startTime;
    private double sum;
    private JSONArray values;

    public Metrics(String str, String str2, int i, long j, JSONObject jSONObject, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "groupId");
        this.name = str;
        this.groupId = str2;
        this.aggregationTypes = i;
        this.startTime = j;
        this.params = jSONObject;
        this.interval = str3;
        this.endTime = j;
    }

    public final String getName() {
        return this.name;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getAggregationTypes() {
        return this.aggregationTypes;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public final String getInterval() {
        return this.interval;
    }

    public final int getCount() {
        return this.count;
    }

    public final double getSum() {
        return this.sum;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final JSONArray getValues() {
        return this.values;
    }

    public final void setValues(JSONArray jSONArray) {
        this.values = jSONArray;
    }

    public final void restore(int count, double sum, long endTime, JSONArray values) {
        this.count = count;
        this.sum = sum;
        this.endTime = endTime;
        this.values = values;
    }

    public final void append(Object value) {
        this.count++;
        if ((this.aggregationTypes & 2) > 0 && (value instanceof Number)) {
            this.sum += ((Number) value).doubleValue();
        }
        if ((this.aggregationTypes & 8) > 0) {
            if (this.values == null) {
                this.values = new JSONArray();
            }
            JSONArray jSONArray = this.values;
            if (jSONArray != null) {
                jSONArray.put(value);
            }
        }
        this.endTime = System.currentTimeMillis();
    }

    public final JSONObject toParams() throws JSONException {
        JSONObject jSONObjectCopyFrom = UtilsKt.copyFrom(new JSONObject(), this.params);
        jSONObjectCopyFrom.put("metrics_start_ms", this.startTime);
        jSONObjectCopyFrom.put("metrics_end_ms", this.endTime);
        jSONObjectCopyFrom.put("metrics_aggregation", this.aggregationTypes);
        jSONObjectCopyFrom.put("metrics_count", this.count);
        if ((this.aggregationTypes & 2) > 0) {
            jSONObjectCopyFrom.put("metrics_sum", this.sum);
        }
        if ((this.aggregationTypes & 4) > 0) {
            jSONObjectCopyFrom.put("metrics_avg", this.sum / this.count);
        }
        if ((this.aggregationTypes & 8) > 0) {
            jSONObjectCopyFrom.put("metrics_values", this.values);
        }
        if ((this.aggregationTypes & 16) > 0) {
            jSONObjectCopyFrom.put("metrics_interval", this.interval);
        }
        return jSONObjectCopyFrom;
    }
}
