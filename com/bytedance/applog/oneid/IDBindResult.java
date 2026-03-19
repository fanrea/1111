package com.bytedance.applog.oneid;

import com.bytedance.bdtracker.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/applog/oneid/IDBindResult;", "", "newSsid", "", "failedIdList", "(Ljava/lang/String;Ljava/lang/String;)V", "getFailedIdList", "()Ljava/lang/String;", "getNewSsid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class IDBindResult {
    public final String failedIdList;
    public final String newSsid;

    public IDBindResult(String str, String str2) {
        this.newSsid = str;
        this.failedIdList = str2;
    }

    public static /* synthetic */ IDBindResult copy$default(IDBindResult iDBindResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iDBindResult.newSsid;
        }
        if ((i & 2) != 0) {
            str2 = iDBindResult.failedIdList;
        }
        return iDBindResult.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNewSsid() {
        return this.newSsid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFailedIdList() {
        return this.failedIdList;
    }

    public final IDBindResult copy(String newSsid, String failedIdList) {
        return new IDBindResult(newSsid, failedIdList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IDBindResult)) {
            return false;
        }
        IDBindResult iDBindResult = (IDBindResult) other;
        return Intrinsics.areEqual(this.newSsid, iDBindResult.newSsid) && Intrinsics.areEqual(this.failedIdList, iDBindResult.failedIdList);
    }

    public final String getFailedIdList() {
        return this.failedIdList;
    }

    public final String getNewSsid() {
        return this.newSsid;
    }

    public int hashCode() {
        String str = this.newSsid;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.failedIdList;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return a.a("IDBindResult(newSsid=").append(this.newSsid).append(", failedIdList=").append(this.failedIdList).append(")").toString();
    }
}
