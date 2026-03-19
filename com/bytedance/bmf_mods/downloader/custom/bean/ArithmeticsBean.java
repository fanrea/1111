package com.bytedance.bmf_mods.downloader.custom.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArithmeticsBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsBean;", "", "statusCode", "", "data", "Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsData;", "(ILcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsData;)V", "getData", "()Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsData;", "getStatusCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class ArithmeticsBean {

    @SerializedName("data")
    private final ArithmeticsData data;

    @SerializedName("status_code")
    private final int statusCode;

    /* JADX WARN: Illegal instructions before constructor call */
    public ArithmeticsBean() {
        ArithmeticsData arithmeticsData = null;
        this(0, arithmeticsData, 3, arithmeticsData);
    }

    public static /* synthetic */ ArithmeticsBean copy$default(ArithmeticsBean arithmeticsBean, int i, ArithmeticsData arithmeticsData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = arithmeticsBean.statusCode;
        }
        if ((i2 & 2) != 0) {
            arithmeticsData = arithmeticsBean.data;
        }
        return arithmeticsBean.copy(i, arithmeticsData);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component2, reason: from getter */
    public final ArithmeticsData getData() {
        return this.data;
    }

    public final ArithmeticsBean copy(int statusCode, ArithmeticsData data) {
        return new ArithmeticsBean(statusCode, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArithmeticsBean)) {
            return false;
        }
        ArithmeticsBean arithmeticsBean = (ArithmeticsBean) other;
        return this.statusCode == arithmeticsBean.statusCode && Intrinsics.areEqual(this.data, arithmeticsBean.data);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.statusCode) * 31;
        ArithmeticsData arithmeticsData = this.data;
        return iHashCode + (arithmeticsData == null ? 0 : arithmeticsData.hashCode());
    }

    public String toString() {
        return "ArithmeticsBean(statusCode=" + this.statusCode + ", data=" + this.data + ')';
    }

    public ArithmeticsBean(int i, ArithmeticsData arithmeticsData) {
        this.statusCode = i;
        this.data = arithmeticsData;
    }

    public /* synthetic */ ArithmeticsBean(int i, ArithmeticsData arithmeticsData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : arithmeticsData);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final ArithmeticsData getData() {
        return this.data;
    }
}
