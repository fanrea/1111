package com.bytedance.sdk.djx.core.business.budrama.detail;

import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.model.DramaDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DramaNetCacheManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaDetailCacheItem;", "", "dramaDetail", "Lcom/bytedance/sdk/djx/model/DramaDetail;", "writeTimeSeconds", "", "(Lcom/bytedance/sdk/djx/model/DramaDetail;J)V", "getDramaDetail", "()Lcom/bytedance/sdk/djx/model/DramaDetail;", "getWriteTimeSeconds", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "Companion", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class DramaDetailCacheItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DRAMA_DETAIL = "drama_detail";
    public static final String WRITE_TIME_SECONDS = "write_time_seconds";
    private final DramaDetail dramaDetail;
    private final long writeTimeSeconds;

    public static /* synthetic */ DramaDetailCacheItem copy$default(DramaDetailCacheItem dramaDetailCacheItem, DramaDetail dramaDetail, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            dramaDetail = dramaDetailCacheItem.dramaDetail;
        }
        if ((i & 2) != 0) {
            j = dramaDetailCacheItem.writeTimeSeconds;
        }
        return dramaDetailCacheItem.copy(dramaDetail, j);
    }

    /* renamed from: component1, reason: from getter */
    public final DramaDetail getDramaDetail() {
        return this.dramaDetail;
    }

    /* renamed from: component2, reason: from getter */
    public final long getWriteTimeSeconds() {
        return this.writeTimeSeconds;
    }

    public final DramaDetailCacheItem copy(DramaDetail dramaDetail, long writeTimeSeconds) {
        Intrinsics.checkNotNullParameter(dramaDetail, "dramaDetail");
        return new DramaDetailCacheItem(dramaDetail, writeTimeSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DramaDetailCacheItem)) {
            return false;
        }
        DramaDetailCacheItem dramaDetailCacheItem = (DramaDetailCacheItem) other;
        return Intrinsics.areEqual(this.dramaDetail, dramaDetailCacheItem.dramaDetail) && this.writeTimeSeconds == dramaDetailCacheItem.writeTimeSeconds;
    }

    public int hashCode() {
        return (this.dramaDetail.hashCode() * 31) + Long.hashCode(this.writeTimeSeconds);
    }

    public String toString() {
        return "DramaDetailCacheItem(dramaDetail=" + this.dramaDetail + ", writeTimeSeconds=" + this.writeTimeSeconds + ')';
    }

    public DramaDetailCacheItem(DramaDetail dramaDetail, long j) {
        Intrinsics.checkNotNullParameter(dramaDetail, "dramaDetail");
        this.dramaDetail = dramaDetail;
        this.writeTimeSeconds = j;
    }

    public final DramaDetail getDramaDetail() {
        return this.dramaDetail;
    }

    public final long getWriteTimeSeconds() {
        return this.writeTimeSeconds;
    }

    /* compiled from: DramaNetCacheManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaDetailCacheItem$Companion;", "", "()V", "DRAMA_DETAIL", "", "WRITE_TIME_SECONDS", "parseFromJSONObject", "Lcom/bytedance/sdk/djx/core/business/budrama/detail/DramaDetailCacheItem;", "jsonObject", "Lorg/json/JSONObject;", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DramaDetailCacheItem parseFromJSONObject(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            long j = jsonObject.getLong(DramaDetailCacheItem.WRITE_TIME_SECONDS);
            DramaDetail dramaDetail = DramaApi.parseDramaDetail(jsonObject.getJSONObject("drama_detail"));
            Intrinsics.checkNotNullExpressionValue(dramaDetail, "dramaDetailTmp");
            return new DramaDetailCacheItem(dramaDetail, j);
        }
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("drama_detail", this.dramaDetail.toJSONObject());
            jSONObject.put(WRITE_TIME_SECONDS, this.writeTimeSeconds);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
