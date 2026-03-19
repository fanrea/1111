package com.bytedance.bmf_mods.downloader.custom.bean;

import com.bytedance.pangle.provider.ContentProviderManager;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArithmeticsBean.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/bean/FileUrl;", "", ContentProviderManager.PROVIDER_URI, "", "urlList", "", "zipUrlList", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getUri", "()Ljava/lang/String;", "getUrlList", "()Ljava/util/List;", "getZipUrlList", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class FileUrl {

    @SerializedName(ContentProviderManager.PROVIDER_URI)
    private final String uri;

    @SerializedName("url_list")
    private final List<String> urlList;

    @SerializedName("zip_url_list")
    private final List<String> zipUrlList;

    public FileUrl() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileUrl copy$default(FileUrl fileUrl, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileUrl.uri;
        }
        if ((i & 2) != 0) {
            list = fileUrl.urlList;
        }
        if ((i & 4) != 0) {
            list2 = fileUrl.zipUrlList;
        }
        return fileUrl.copy(str, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    public final List<String> component2() {
        return this.urlList;
    }

    public final List<String> component3() {
        return this.zipUrlList;
    }

    public final FileUrl copy(String uri, List<String> urlList, List<String> zipUrlList) {
        return new FileUrl(uri, urlList, zipUrlList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileUrl)) {
            return false;
        }
        FileUrl fileUrl = (FileUrl) other;
        return Intrinsics.areEqual(this.uri, fileUrl.uri) && Intrinsics.areEqual(this.urlList, fileUrl.urlList) && Intrinsics.areEqual(this.zipUrlList, fileUrl.zipUrlList);
    }

    public int hashCode() {
        String str = this.uri;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.urlList;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.zipUrlList;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "FileUrl(uri=" + this.uri + ", urlList=" + this.urlList + ", zipUrlList=" + this.zipUrlList + ')';
    }

    public FileUrl(String str, List<String> list, List<String> list2) {
        this.uri = str;
        this.urlList = list;
        this.zipUrlList = list2;
    }

    public /* synthetic */ FileUrl(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2);
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final List<String> getZipUrlList() {
        return this.zipUrlList;
    }
}
