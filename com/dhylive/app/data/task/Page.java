package com.dhylive.app.data.task;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: XSTaskInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/dhylive/app/data/task/Page;", "", "now", "", MetricsSQLiteCacheKt.METRICS_SUM, "limit", "count", "(IIII)V", "getCount", "()I", "getLimit", "getNow", "getSum", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class Page {

    @SerializedName("count")
    private final int count;

    @SerializedName("limit")
    private final int limit;

    @SerializedName("now")
    private final int now;

    @SerializedName(MetricsSQLiteCacheKt.METRICS_SUM)
    private final int sum;

    public static /* synthetic */ Page copy$default(Page page, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = page.now;
        }
        if ((i5 & 2) != 0) {
            i2 = page.sum;
        }
        if ((i5 & 4) != 0) {
            i3 = page.limit;
        }
        if ((i5 & 8) != 0) {
            i4 = page.count;
        }
        return page.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNow() {
        return this.now;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSum() {
        return this.sum;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final Page copy(int now, int sum, int limit, int count) {
        return new Page(now, sum, limit, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Page)) {
            return false;
        }
        Page page = (Page) other;
        return this.now == page.now && this.sum == page.sum && this.limit == page.limit && this.count == page.count;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.now) * 31) + Integer.hashCode(this.sum)) * 31) + Integer.hashCode(this.limit)) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "Page(now=" + this.now + ", sum=" + this.sum + ", limit=" + this.limit + ", count=" + this.count + ')';
    }

    public Page(int i, int i2, int i3, int i4) {
        this.now = i;
        this.sum = i2;
        this.limit = i3;
        this.count = i4;
    }

    public final int getNow() {
        return this.now;
    }

    public final int getSum() {
        return this.sum;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getCount() {
        return this.count;
    }
}
