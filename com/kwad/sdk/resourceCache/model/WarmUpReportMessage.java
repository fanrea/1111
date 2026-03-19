package com.kwad.sdk.resourceCache.model;

import com.kwad.sdk.commercial.c.a;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WarmUpReportMessage extends a implements Serializable {
    public static final int STATUS_DOWNLOAD_FAILED = 3;
    public static final int STATUS_DOWNLOAD_SUCCESS = 2;
    public static final int STATUS_MD5_ERROR = 4;
    public static final int STATUS_START = 1;
    private static final long serialVersionUID = 368743526206619387L;
    public String configItems;
    public int downloadStatus;
    public long freeDisk;
    public String localItems;
    public String resourceKey;
    public int resourceType;
    public String url;

    public WarmUpReportMessage setDownloadStatus(int i) {
        this.downloadStatus = i;
        return this;
    }

    public WarmUpReportMessage setResourceType(int i) {
        this.resourceType = i;
        return this;
    }

    public WarmUpReportMessage setResourceKey(String str) {
        this.resourceKey = str;
        return this;
    }

    public WarmUpReportMessage setUrl(String str) {
        this.url = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public WarmUpReportMessage setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public WarmUpReportMessage setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public WarmUpReportMessage setLocalItems(String str) {
        this.localItems = str;
        return this;
    }

    public WarmUpReportMessage setConfigItems(String str) {
        this.configItems = str;
        return this;
    }

    public WarmUpReportMessage setFreeDisk(long j) {
        this.freeDisk = j;
        return this;
    }
}
