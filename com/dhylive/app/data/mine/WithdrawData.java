package com.dhylive.app.data.mine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WithdrawData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00065"}, d2 = {"Lcom/dhylive/app/data/mine/WithdrawData;", "", "coin", "", "commission", "", "create_time", "id", "package_info", "", "query", "remark", "state", "status", "type", "user_id", "withdraw_type", "(IDIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIII)V", "getCoin", "()I", "getCommission", "()D", "getCreate_time", "getId", "getPackage_info", "()Ljava/lang/String;", "getQuery", "getRemark", "getState", "getStatus", "setStatus", "(I)V", "getType", "getUser_id", "getWithdraw_type", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class WithdrawData {
    private final int coin;
    private final double commission;
    private final int create_time;
    private final int id;
    private final String package_info;
    private final String query;
    private final String remark;
    private final int state;
    private int status;
    private final int type;
    private final int user_id;
    private final int withdraw_type;

    /* renamed from: component1, reason: from getter */
    public final int getCoin() {
        return this.coin;
    }

    /* renamed from: component10, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component11, reason: from getter */
    public final int getUser_id() {
        return this.user_id;
    }

    /* renamed from: component12, reason: from getter */
    public final int getWithdraw_type() {
        return this.withdraw_type;
    }

    /* renamed from: component2, reason: from getter */
    public final double getCommission() {
        return this.commission;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCreate_time() {
        return this.create_time;
    }

    /* renamed from: component4, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPackage_info() {
        return this.package_info;
    }

    /* renamed from: component6, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    /* renamed from: component8, reason: from getter */
    public final int getState() {
        return this.state;
    }

    /* renamed from: component9, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final WithdrawData copy(int coin, double commission, int create_time, int id, String package_info, String query, String remark, int state, int status, int type, int user_id, int withdraw_type) {
        Intrinsics.checkNotNullParameter(package_info, "package_info");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(remark, "remark");
        return new WithdrawData(coin, commission, create_time, id, package_info, query, remark, state, status, type, user_id, withdraw_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WithdrawData)) {
            return false;
        }
        WithdrawData withdrawData = (WithdrawData) other;
        return this.coin == withdrawData.coin && Double.compare(this.commission, withdrawData.commission) == 0 && this.create_time == withdrawData.create_time && this.id == withdrawData.id && Intrinsics.areEqual(this.package_info, withdrawData.package_info) && Intrinsics.areEqual(this.query, withdrawData.query) && Intrinsics.areEqual(this.remark, withdrawData.remark) && this.state == withdrawData.state && this.status == withdrawData.status && this.type == withdrawData.type && this.user_id == withdrawData.user_id && this.withdraw_type == withdrawData.withdraw_type;
    }

    public int hashCode() {
        return (((((((((((((((((((((Integer.hashCode(this.coin) * 31) + Double.hashCode(this.commission)) * 31) + Integer.hashCode(this.create_time)) * 31) + Integer.hashCode(this.id)) * 31) + this.package_info.hashCode()) * 31) + this.query.hashCode()) * 31) + this.remark.hashCode()) * 31) + Integer.hashCode(this.state)) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.user_id)) * 31) + Integer.hashCode(this.withdraw_type);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WithdrawData(coin=").append(this.coin).append(", commission=").append(this.commission).append(", create_time=").append(this.create_time).append(", id=").append(this.id).append(", package_info=").append(this.package_info).append(", query=").append(this.query).append(", remark=").append(this.remark).append(", state=").append(this.state).append(", status=").append(this.status).append(", type=").append(this.type).append(", user_id=").append(this.user_id).append(", withdraw_type=");
        sb.append(this.withdraw_type).append(')');
        return sb.toString();
    }

    public WithdrawData(int i, double d, int i2, int i3, String str, String str2, String str3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(str, "package_info");
        Intrinsics.checkNotNullParameter(str2, "query");
        Intrinsics.checkNotNullParameter(str3, "remark");
        this.coin = i;
        this.commission = d;
        this.create_time = i2;
        this.id = i3;
        this.package_info = str;
        this.query = str2;
        this.remark = str3;
        this.state = i4;
        this.status = i5;
        this.type = i6;
        this.user_id = i7;
        this.withdraw_type = i8;
    }

    public final int getCoin() {
        return this.coin;
    }

    public final double getCommission() {
        return this.commission;
    }

    public final int getCreate_time() {
        return this.create_time;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPackage_info() {
        return this.package_info;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final int getState() {
        return this.state;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUser_id() {
        return this.user_id;
    }

    public final int getWithdraw_type() {
        return this.withdraw_type;
    }
}
