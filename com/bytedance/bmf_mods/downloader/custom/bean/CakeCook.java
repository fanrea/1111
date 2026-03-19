package com.bytedance.bmf_mods.downloader.custom.bean;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArithmeticsBean.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/bean/CakeCook;", "", "name", "", Config.INPUT_DEF_VERSION, "type", "", "status", "fileType", "fileUrl", "Lcom/bytedance/bmf_mods/downloader/custom/bean/FileUrl;", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/bytedance/bmf_mods/downloader/custom/bean/FileUrl;)V", "getFileType", "()Ljava/lang/String;", "getFileUrl", "()Lcom/bytedance/bmf_mods/downloader/custom/bean/FileUrl;", "getName", "getStatus", "()I", "getType", IFunc.IVK_VERSION, "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final /* data */ class CakeCook {

    @SerializedName("file_type")
    private final String fileType;

    @SerializedName("file_url")
    private final FileUrl fileUrl;

    @SerializedName("name")
    private final String name;

    @SerializedName("status")
    private final int status;

    @SerializedName("type")
    private final int type;

    @SerializedName(Config.INPUT_DEF_VERSION)
    private final String version;

    public CakeCook() {
        this(null, null, 0, 0, null, null, 63, null);
    }

    public static /* synthetic */ CakeCook copy$default(CakeCook cakeCook, String str, String str2, int i, int i2, String str3, FileUrl fileUrl, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cakeCook.name;
        }
        if ((i3 & 2) != 0) {
            str2 = cakeCook.version;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            i = cakeCook.type;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = cakeCook.status;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            str3 = cakeCook.fileType;
        }
        String str5 = str3;
        if ((i3 & 32) != 0) {
            fileUrl = cakeCook.fileUrl;
        }
        return cakeCook.copy(str, str4, i4, i5, str5, fileUrl);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFileType() {
        return this.fileType;
    }

    /* renamed from: component6, reason: from getter */
    public final FileUrl getFileUrl() {
        return this.fileUrl;
    }

    public final CakeCook copy(String name, String version, int type, int status, String fileType, FileUrl fileUrl) {
        return new CakeCook(name, version, type, status, fileType, fileUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CakeCook)) {
            return false;
        }
        CakeCook cakeCook = (CakeCook) other;
        return Intrinsics.areEqual(this.name, cakeCook.name) && Intrinsics.areEqual(this.version, cakeCook.version) && this.type == cakeCook.type && this.status == cakeCook.status && Intrinsics.areEqual(this.fileType, cakeCook.fileType) && Intrinsics.areEqual(this.fileUrl, cakeCook.fileUrl);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.version;
        int iHashCode2 = (((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.status)) * 31;
        String str3 = this.fileType;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        FileUrl fileUrl = this.fileUrl;
        return iHashCode3 + (fileUrl != null ? fileUrl.hashCode() : 0);
    }

    public String toString() {
        return "CakeCook(name=" + this.name + ", version=" + this.version + ", type=" + this.type + ", status=" + this.status + ", fileType=" + this.fileType + ", fileUrl=" + this.fileUrl + ')';
    }

    public CakeCook(String str, String str2, int i, int i2, String str3, FileUrl fileUrl) {
        this.name = str;
        this.version = str2;
        this.type = i;
        this.status = i2;
        this.fileType = str3;
        this.fileUrl = fileUrl;
    }

    public /* synthetic */ CakeCook(String str, String str2, int i, int i2, String str3, FileUrl fileUrl, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 1 : i2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : fileUrl);
    }

    public final String getName() {
        return this.name;
    }

    public final String getVersion() {
        return this.version;
    }

    public final int getType() {
        return this.type;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final FileUrl getFileUrl() {
        return this.fileUrl;
    }
}
