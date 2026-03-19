package com.dhylive.app.net;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobstat.forbes.Config;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003JG\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/dhylive/app/net/ListData;", ExifInterface.GPS_DIRECTION_TRUE, "", "currentPage", "", "data", "", "lastPage", "perPage", Config.EXCEPTION_MEMORY_TOTAL, "(ILjava/util/List;III)V", "getCurrentPage", "()I", "getData", "()Ljava/util/List;", "getLastPage", "getPerPage", "getTotal", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class ListData<T> {

    @SerializedName("current_page")
    private final int currentPage;

    @SerializedName(alternate = {"list"}, value = "data")
    private final List<T> data;

    @SerializedName("last_page")
    private final int lastPage;

    @SerializedName("per_page")
    private final int perPage;
    private final int total;

    public static /* synthetic */ ListData copy$default(ListData listData, int i, List list, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = listData.currentPage;
        }
        if ((i5 & 2) != 0) {
            list = listData.data;
        }
        List list2 = list;
        if ((i5 & 4) != 0) {
            i2 = listData.lastPage;
        }
        int i6 = i2;
        if ((i5 & 8) != 0) {
            i3 = listData.perPage;
        }
        int i7 = i3;
        if ((i5 & 16) != 0) {
            i4 = listData.total;
        }
        return listData.copy(i, list2, i6, i7, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final List<T> component2() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLastPage() {
        return this.lastPage;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPerPage() {
        return this.perPage;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final ListData<T> copy(int currentPage, List<? extends T> data, int lastPage, int perPage, int total) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ListData<>(currentPage, data, lastPage, perPage, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListData)) {
            return false;
        }
        ListData listData = (ListData) other;
        return this.currentPage == listData.currentPage && Intrinsics.areEqual(this.data, listData.data) && this.lastPage == listData.lastPage && this.perPage == listData.perPage && this.total == listData.total;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.currentPage) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.lastPage)) * 31) + Integer.hashCode(this.perPage)) * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        return "ListData(currentPage=" + this.currentPage + ", data=" + this.data + ", lastPage=" + this.lastPage + ", perPage=" + this.perPage + ", total=" + this.total + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListData(int i, List<? extends T> list, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.currentPage = i;
        this.data = list;
        this.lastPage = i2;
        this.perPage = i3;
        this.total = i4;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final List<T> getData() {
        return this.data;
    }

    public final int getLastPage() {
        return this.lastPage;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final int getTotal() {
        return this.total;
    }
}
