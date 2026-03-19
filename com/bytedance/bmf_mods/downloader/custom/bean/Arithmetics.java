package com.bytedance.bmf_mods.downloader.custom.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArithmeticsBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/bean/Arithmetics;", "", "cakeCook", "", "Lcom/bytedance/bmf_mods/downloader/custom/bean/CakeCook;", "(Ljava/util/List;)V", "getCakeCook", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class Arithmetics {

    @SerializedName("cakeCook")
    private final List<CakeCook> cakeCook;

    /* JADX WARN: Illegal instructions before constructor call */
    public Arithmetics() {
        List list = null;
        this(list, 1, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Arithmetics copy$default(Arithmetics arithmetics, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = arithmetics.cakeCook;
        }
        return arithmetics.copy(list);
    }

    public final List<CakeCook> component1() {
        return this.cakeCook;
    }

    public final Arithmetics copy(List<CakeCook> cakeCook) {
        return new Arithmetics(cakeCook);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Arithmetics) && Intrinsics.areEqual(this.cakeCook, ((Arithmetics) other).cakeCook);
    }

    public int hashCode() {
        List<CakeCook> list = this.cakeCook;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "Arithmetics(cakeCook=" + this.cakeCook + ')';
    }

    public Arithmetics(List<CakeCook> list) {
        this.cakeCook = list;
    }

    public /* synthetic */ Arithmetics(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<CakeCook> getCakeCook() {
        return this.cakeCook;
    }
}
