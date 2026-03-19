package com.dhylive.app.data.task;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XSTaskInfo.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/dhylive/app/data/task/XSData;", "", "page", "Lcom/dhylive/app/data/task/Page;", "list", "", "Lcom/dhylive/app/data/task/XSTask;", "mtMoney", "Lcom/dhylive/app/data/task/MtMoney;", "(Lcom/dhylive/app/data/task/Page;Ljava/util/List;Lcom/dhylive/app/data/task/MtMoney;)V", "getList", "()Ljava/util/List;", "getMtMoney", "()Lcom/dhylive/app/data/task/MtMoney;", "getPage", "()Lcom/dhylive/app/data/task/Page;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class XSData {

    @SerializedName("list")
    private final List<XSTask> list;

    @SerializedName("mt_money")
    private final MtMoney mtMoney;

    @SerializedName("page")
    private final Page page;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ XSData copy$default(XSData xSData, Page page, List list, MtMoney mtMoney, int i, Object obj) {
        if ((i & 1) != 0) {
            page = xSData.page;
        }
        if ((i & 2) != 0) {
            list = xSData.list;
        }
        if ((i & 4) != 0) {
            mtMoney = xSData.mtMoney;
        }
        return xSData.copy(page, list, mtMoney);
    }

    /* renamed from: component1, reason: from getter */
    public final Page getPage() {
        return this.page;
    }

    public final List<XSTask> component2() {
        return this.list;
    }

    /* renamed from: component3, reason: from getter */
    public final MtMoney getMtMoney() {
        return this.mtMoney;
    }

    public final XSData copy(Page page, List<XSTask> list, MtMoney mtMoney) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(mtMoney, "mtMoney");
        return new XSData(page, list, mtMoney);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XSData)) {
            return false;
        }
        XSData xSData = (XSData) other;
        return Intrinsics.areEqual(this.page, xSData.page) && Intrinsics.areEqual(this.list, xSData.list) && Intrinsics.areEqual(this.mtMoney, xSData.mtMoney);
    }

    public int hashCode() {
        return (((this.page.hashCode() * 31) + this.list.hashCode()) * 31) + this.mtMoney.hashCode();
    }

    public String toString() {
        return "XSData(page=" + this.page + ", list=" + this.list + ", mtMoney=" + this.mtMoney + ')';
    }

    public XSData(Page page, List<XSTask> list, MtMoney mtMoney) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(mtMoney, "mtMoney");
        this.page = page;
        this.list = list;
        this.mtMoney = mtMoney;
    }

    public final Page getPage() {
        return this.page;
    }

    public final List<XSTask> getList() {
        return this.list;
    }

    public final MtMoney getMtMoney() {
        return this.mtMoney;
    }
}
