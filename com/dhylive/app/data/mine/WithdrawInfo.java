package com.dhylive.app.data.mine;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WithdrawInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/dhylive/app/data/mine/WithdrawInfo;", "", "description", "", "grade_list", "", "withdraw_type", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getGrade_list", "()Ljava/util/List;", "getWithdraw_type", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class WithdrawInfo {
    private final String description;
    private final List<String> grade_list;
    private final List<String> withdraw_type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WithdrawInfo copy$default(WithdrawInfo withdrawInfo, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = withdrawInfo.description;
        }
        if ((i & 2) != 0) {
            list = withdrawInfo.grade_list;
        }
        if ((i & 4) != 0) {
            list2 = withdrawInfo.withdraw_type;
        }
        return withdrawInfo.copy(str, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> component2() {
        return this.grade_list;
    }

    public final List<String> component3() {
        return this.withdraw_type;
    }

    public final WithdrawInfo copy(String description, List<String> grade_list, List<String> withdraw_type) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(grade_list, "grade_list");
        Intrinsics.checkNotNullParameter(withdraw_type, "withdraw_type");
        return new WithdrawInfo(description, grade_list, withdraw_type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WithdrawInfo)) {
            return false;
        }
        WithdrawInfo withdrawInfo = (WithdrawInfo) other;
        return Intrinsics.areEqual(this.description, withdrawInfo.description) && Intrinsics.areEqual(this.grade_list, withdrawInfo.grade_list) && Intrinsics.areEqual(this.withdraw_type, withdrawInfo.withdraw_type);
    }

    public int hashCode() {
        return (((this.description.hashCode() * 31) + this.grade_list.hashCode()) * 31) + this.withdraw_type.hashCode();
    }

    public String toString() {
        return "WithdrawInfo(description=" + this.description + ", grade_list=" + this.grade_list + ", withdraw_type=" + this.withdraw_type + ')';
    }

    public WithdrawInfo(String str, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(list, "grade_list");
        Intrinsics.checkNotNullParameter(list2, "withdraw_type");
        this.description = str;
        this.grade_list = list;
        this.withdraw_type = list2;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getGrade_list() {
        return this.grade_list;
    }

    public final List<String> getWithdraw_type() {
        return this.withdraw_type;
    }
}
