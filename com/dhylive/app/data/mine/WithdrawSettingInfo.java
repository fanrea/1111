package com.dhylive.app.data.mine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WithdrawSettingInfo.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/dhylive/app/data/mine/WithdrawSettingInfo;", "", "alipay", "Lcom/dhylive/app/data/mine/Alipay;", "bing_wecheck", "", "is_open_alipay", "is_open_weixin", "(Lcom/dhylive/app/data/mine/Alipay;III)V", "getAlipay", "()Lcom/dhylive/app/data/mine/Alipay;", "getBing_wecheck", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class WithdrawSettingInfo {
    private final Alipay alipay;
    private final int bing_wecheck;
    private final int is_open_alipay;
    private final int is_open_weixin;

    public static /* synthetic */ WithdrawSettingInfo copy$default(WithdrawSettingInfo withdrawSettingInfo, Alipay alipay, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            alipay = withdrawSettingInfo.alipay;
        }
        if ((i4 & 2) != 0) {
            i = withdrawSettingInfo.bing_wecheck;
        }
        if ((i4 & 4) != 0) {
            i2 = withdrawSettingInfo.is_open_alipay;
        }
        if ((i4 & 8) != 0) {
            i3 = withdrawSettingInfo.is_open_weixin;
        }
        return withdrawSettingInfo.copy(alipay, i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final Alipay getAlipay() {
        return this.alipay;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBing_wecheck() {
        return this.bing_wecheck;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIs_open_alipay() {
        return this.is_open_alipay;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIs_open_weixin() {
        return this.is_open_weixin;
    }

    public final WithdrawSettingInfo copy(Alipay alipay, int bing_wecheck, int is_open_alipay, int is_open_weixin) {
        Intrinsics.checkNotNullParameter(alipay, "alipay");
        return new WithdrawSettingInfo(alipay, bing_wecheck, is_open_alipay, is_open_weixin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WithdrawSettingInfo)) {
            return false;
        }
        WithdrawSettingInfo withdrawSettingInfo = (WithdrawSettingInfo) other;
        return Intrinsics.areEqual(this.alipay, withdrawSettingInfo.alipay) && this.bing_wecheck == withdrawSettingInfo.bing_wecheck && this.is_open_alipay == withdrawSettingInfo.is_open_alipay && this.is_open_weixin == withdrawSettingInfo.is_open_weixin;
    }

    public int hashCode() {
        return (((((this.alipay.hashCode() * 31) + Integer.hashCode(this.bing_wecheck)) * 31) + Integer.hashCode(this.is_open_alipay)) * 31) + Integer.hashCode(this.is_open_weixin);
    }

    public String toString() {
        return "WithdrawSettingInfo(alipay=" + this.alipay + ", bing_wecheck=" + this.bing_wecheck + ", is_open_alipay=" + this.is_open_alipay + ", is_open_weixin=" + this.is_open_weixin + ')';
    }

    public WithdrawSettingInfo(Alipay alipay, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(alipay, "alipay");
        this.alipay = alipay;
        this.bing_wecheck = i;
        this.is_open_alipay = i2;
        this.is_open_weixin = i3;
    }

    public final Alipay getAlipay() {
        return this.alipay;
    }

    public final int getBing_wecheck() {
        return this.bing_wecheck;
    }

    public final int is_open_alipay() {
        return this.is_open_alipay;
    }

    public final int is_open_weixin() {
        return this.is_open_weixin;
    }
}
