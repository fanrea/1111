package com.dhylive.app.data.mine;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdOrderInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/dhylive/app/data/mine/AdOrderInfo;", "", "orderNo", "", "sigmob_app_id", "sigmob_reward_ad_id", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getOrderNo", "()Ljava/lang/String;", "getSigmob_app_id", "getSigmob_reward_ad_id", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class AdOrderInfo {

    @SerializedName("order_no")
    private final String orderNo;
    private final String sigmob_app_id;
    private final List<String> sigmob_reward_ad_id;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdOrderInfo copy$default(AdOrderInfo adOrderInfo, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adOrderInfo.orderNo;
        }
        if ((i & 2) != 0) {
            str2 = adOrderInfo.sigmob_app_id;
        }
        if ((i & 4) != 0) {
            list = adOrderInfo.sigmob_reward_ad_id;
        }
        return adOrderInfo.copy(str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOrderNo() {
        return this.orderNo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSigmob_app_id() {
        return this.sigmob_app_id;
    }

    public final List<String> component3() {
        return this.sigmob_reward_ad_id;
    }

    public final AdOrderInfo copy(String orderNo, String sigmob_app_id, List<String> sigmob_reward_ad_id) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Intrinsics.checkNotNullParameter(sigmob_app_id, "sigmob_app_id");
        Intrinsics.checkNotNullParameter(sigmob_reward_ad_id, "sigmob_reward_ad_id");
        return new AdOrderInfo(orderNo, sigmob_app_id, sigmob_reward_ad_id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdOrderInfo)) {
            return false;
        }
        AdOrderInfo adOrderInfo = (AdOrderInfo) other;
        return Intrinsics.areEqual(this.orderNo, adOrderInfo.orderNo) && Intrinsics.areEqual(this.sigmob_app_id, adOrderInfo.sigmob_app_id) && Intrinsics.areEqual(this.sigmob_reward_ad_id, adOrderInfo.sigmob_reward_ad_id);
    }

    public int hashCode() {
        return (((this.orderNo.hashCode() * 31) + this.sigmob_app_id.hashCode()) * 31) + this.sigmob_reward_ad_id.hashCode();
    }

    public String toString() {
        return "AdOrderInfo(orderNo=" + this.orderNo + ", sigmob_app_id=" + this.sigmob_app_id + ", sigmob_reward_ad_id=" + this.sigmob_reward_ad_id + ')';
    }

    public AdOrderInfo(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "orderNo");
        Intrinsics.checkNotNullParameter(str2, "sigmob_app_id");
        Intrinsics.checkNotNullParameter(list, "sigmob_reward_ad_id");
        this.orderNo = str;
        this.sigmob_app_id = str2;
        this.sigmob_reward_ad_id = list;
    }

    public final String getOrderNo() {
        return this.orderNo;
    }

    public final String getSigmob_app_id() {
        return this.sigmob_app_id;
    }

    public final List<String> getSigmob_reward_ad_id() {
        return this.sigmob_reward_ad_id;
    }
}
