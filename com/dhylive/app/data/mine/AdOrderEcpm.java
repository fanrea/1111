package com.dhylive.app.data.mine;

import com.baidu.mobads.sdk.api.SplashAd;
import com.sigmob.sdk.base.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdOrderEcpm.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/dhylive/app/data/mine/AdOrderEcpm;", "", "coins", "", "coinsFixed", "orderSn", "", n.l, "sourceType", "status", SplashAd.KEY_BIDFAIL_ECPM, "type", "(IILjava/lang/String;IIIII)V", "getCoins", "()I", "getCoinsFixed", "getEcpm", "getOrderSn", "()Ljava/lang/String;", "getSource", "getSourceType", "getStatus", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class AdOrderEcpm {
    private final int coins;
    private final int coinsFixed;
    private final int ecpm;
    private final String orderSn;
    private final int source;
    private final int sourceType;
    private final int status;
    private final int type;

    /* renamed from: component1, reason: from getter */
    public final int getCoins() {
        return this.coins;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCoinsFixed() {
        return this.coinsFixed;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOrderSn() {
        return this.orderSn;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSourceType() {
        return this.sourceType;
    }

    /* renamed from: component6, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component7, reason: from getter */
    public final int getEcpm() {
        return this.ecpm;
    }

    /* renamed from: component8, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final AdOrderEcpm copy(int coins, int coinsFixed, String orderSn, int source, int sourceType, int status, int ecpm, int type) {
        Intrinsics.checkNotNullParameter(orderSn, "orderSn");
        return new AdOrderEcpm(coins, coinsFixed, orderSn, source, sourceType, status, ecpm, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdOrderEcpm)) {
            return false;
        }
        AdOrderEcpm adOrderEcpm = (AdOrderEcpm) other;
        return this.coins == adOrderEcpm.coins && this.coinsFixed == adOrderEcpm.coinsFixed && Intrinsics.areEqual(this.orderSn, adOrderEcpm.orderSn) && this.source == adOrderEcpm.source && this.sourceType == adOrderEcpm.sourceType && this.status == adOrderEcpm.status && this.ecpm == adOrderEcpm.ecpm && this.type == adOrderEcpm.type;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.coins) * 31) + Integer.hashCode(this.coinsFixed)) * 31) + this.orderSn.hashCode()) * 31) + Integer.hashCode(this.source)) * 31) + Integer.hashCode(this.sourceType)) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.ecpm)) * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        return "AdOrderEcpm(coins=" + this.coins + ", coinsFixed=" + this.coinsFixed + ", orderSn=" + this.orderSn + ", source=" + this.source + ", sourceType=" + this.sourceType + ", status=" + this.status + ", ecpm=" + this.ecpm + ", type=" + this.type + ')';
    }

    public AdOrderEcpm(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, "orderSn");
        this.coins = i;
        this.coinsFixed = i2;
        this.orderSn = str;
        this.source = i3;
        this.sourceType = i4;
        this.status = i5;
        this.ecpm = i6;
        this.type = i7;
    }

    public final int getCoins() {
        return this.coins;
    }

    public final int getCoinsFixed() {
        return this.coinsFixed;
    }

    public final String getOrderSn() {
        return this.orderSn;
    }

    public final int getSource() {
        return this.source;
    }

    public final int getSourceType() {
        return this.sourceType;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getEcpm() {
        return this.ecpm;
    }

    public final int getType() {
        return this.type;
    }
}
