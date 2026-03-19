package com.dhylive.app.data.task;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XSTaskInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/dhylive/app/data/task/MtMoney;", "", "mtId", "", "rate", "unit", "", "(IILjava/lang/String;)V", "getMtId", "()I", "getRate", "getUnit", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class MtMoney {

    @SerializedName("mt_id")
    private final int mtId;

    @SerializedName("rate")
    private final int rate;

    @SerializedName("unit")
    private final String unit;

    public static /* synthetic */ MtMoney copy$default(MtMoney mtMoney, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = mtMoney.mtId;
        }
        if ((i3 & 2) != 0) {
            i2 = mtMoney.rate;
        }
        if ((i3 & 4) != 0) {
            str = mtMoney.unit;
        }
        return mtMoney.copy(i, i2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMtId() {
        return this.mtId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRate() {
        return this.rate;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    public final MtMoney copy(int mtId, int rate, String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new MtMoney(mtId, rate, unit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MtMoney)) {
            return false;
        }
        MtMoney mtMoney = (MtMoney) other;
        return this.mtId == mtMoney.mtId && this.rate == mtMoney.rate && Intrinsics.areEqual(this.unit, mtMoney.unit);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.mtId) * 31) + Integer.hashCode(this.rate)) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "MtMoney(mtId=" + this.mtId + ", rate=" + this.rate + ", unit=" + this.unit + ')';
    }

    public MtMoney(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "unit");
        this.mtId = i;
        this.rate = i2;
        this.unit = str;
    }

    public final int getMtId() {
        return this.mtId;
    }

    public final int getRate() {
        return this.rate;
    }

    public final String getUnit() {
        return this.unit;
    }
}
