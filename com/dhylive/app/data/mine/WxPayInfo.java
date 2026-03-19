package com.dhylive.app.data.mine;

import com.alipay.sdk.m.t.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WxPayInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/dhylive/app/data/mine/WxPayInfo;", "", "noncestr", "", a.k, "sign", "partnerid", "prepayid", "packageX", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNoncestr", "()Ljava/lang/String;", "getPackageX", "getPartnerid", "getPrepayid", "getSign", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class WxPayInfo {
    private final String noncestr;
    private final String packageX;
    private final String partnerid;
    private final String prepayid;
    private final String sign;
    private final String timestamp;

    public static /* synthetic */ WxPayInfo copy$default(WxPayInfo wxPayInfo, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wxPayInfo.noncestr;
        }
        if ((i & 2) != 0) {
            str2 = wxPayInfo.timestamp;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = wxPayInfo.sign;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = wxPayInfo.partnerid;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = wxPayInfo.prepayid;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = wxPayInfo.packageX;
        }
        return wxPayInfo.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNoncestr() {
        return this.noncestr;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPartnerid() {
        return this.partnerid;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPrepayid() {
        return this.prepayid;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPackageX() {
        return this.packageX;
    }

    public final WxPayInfo copy(String noncestr, String timestamp, String sign, String partnerid, String prepayid, String packageX) {
        Intrinsics.checkNotNullParameter(noncestr, "noncestr");
        Intrinsics.checkNotNullParameter(timestamp, a.k);
        Intrinsics.checkNotNullParameter(sign, "sign");
        Intrinsics.checkNotNullParameter(partnerid, "partnerid");
        Intrinsics.checkNotNullParameter(prepayid, "prepayid");
        Intrinsics.checkNotNullParameter(packageX, "packageX");
        return new WxPayInfo(noncestr, timestamp, sign, partnerid, prepayid, packageX);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WxPayInfo)) {
            return false;
        }
        WxPayInfo wxPayInfo = (WxPayInfo) other;
        return Intrinsics.areEqual(this.noncestr, wxPayInfo.noncestr) && Intrinsics.areEqual(this.timestamp, wxPayInfo.timestamp) && Intrinsics.areEqual(this.sign, wxPayInfo.sign) && Intrinsics.areEqual(this.partnerid, wxPayInfo.partnerid) && Intrinsics.areEqual(this.prepayid, wxPayInfo.prepayid) && Intrinsics.areEqual(this.packageX, wxPayInfo.packageX);
    }

    public int hashCode() {
        return (((((((((this.noncestr.hashCode() * 31) + this.timestamp.hashCode()) * 31) + this.sign.hashCode()) * 31) + this.partnerid.hashCode()) * 31) + this.prepayid.hashCode()) * 31) + this.packageX.hashCode();
    }

    public String toString() {
        return "WxPayInfo(noncestr=" + this.noncestr + ", timestamp=" + this.timestamp + ", sign=" + this.sign + ", partnerid=" + this.partnerid + ", prepayid=" + this.prepayid + ", packageX=" + this.packageX + ')';
    }

    public WxPayInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "noncestr");
        Intrinsics.checkNotNullParameter(str2, a.k);
        Intrinsics.checkNotNullParameter(str3, "sign");
        Intrinsics.checkNotNullParameter(str4, "partnerid");
        Intrinsics.checkNotNullParameter(str5, "prepayid");
        Intrinsics.checkNotNullParameter(str6, "packageX");
        this.noncestr = str;
        this.timestamp = str2;
        this.sign = str3;
        this.partnerid = str4;
        this.prepayid = str5;
        this.packageX = str6;
    }

    public final String getNoncestr() {
        return this.noncestr;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getSign() {
        return this.sign;
    }

    public final String getPartnerid() {
        return this.partnerid;
    }

    public final String getPrepayid() {
        return this.prepayid;
    }

    public final String getPackageX() {
        return this.packageX;
    }
}
