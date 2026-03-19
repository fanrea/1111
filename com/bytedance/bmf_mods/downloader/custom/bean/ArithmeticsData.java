package com.bytedance.bmf_mods.downloader.custom.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArithmeticsBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/bean/ArithmeticsData;", "", "arithmetics", "Lcom/bytedance/bmf_mods/downloader/custom/bean/Arithmetics;", "(Lcom/bytedance/bmf_mods/downloader/custom/bean/Arithmetics;)V", "getArithmetics", "()Lcom/bytedance/bmf_mods/downloader/custom/bean/Arithmetics;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class ArithmeticsData {

    @SerializedName("arithmetics")
    private final Arithmetics arithmetics;

    /* JADX WARN: Illegal instructions before constructor call */
    public ArithmeticsData() {
        Arithmetics arithmetics = null;
        this(arithmetics, 1, arithmetics);
    }

    public static /* synthetic */ ArithmeticsData copy$default(ArithmeticsData arithmeticsData, Arithmetics arithmetics, int i, Object obj) {
        if ((i & 1) != 0) {
            arithmetics = arithmeticsData.arithmetics;
        }
        return arithmeticsData.copy(arithmetics);
    }

    /* renamed from: component1, reason: from getter */
    public final Arithmetics getArithmetics() {
        return this.arithmetics;
    }

    public final ArithmeticsData copy(Arithmetics arithmetics) {
        return new ArithmeticsData(arithmetics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ArithmeticsData) && Intrinsics.areEqual(this.arithmetics, ((ArithmeticsData) other).arithmetics);
    }

    public int hashCode() {
        Arithmetics arithmetics = this.arithmetics;
        if (arithmetics == null) {
            return 0;
        }
        return arithmetics.hashCode();
    }

    public String toString() {
        return "ArithmeticsData(arithmetics=" + this.arithmetics + ')';
    }

    public ArithmeticsData(Arithmetics arithmetics) {
        this.arithmetics = arithmetics;
    }

    public /* synthetic */ ArithmeticsData(Arithmetics arithmetics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arithmetics);
    }

    public final Arithmetics getArithmetics() {
        return this.arithmetics;
    }
}
