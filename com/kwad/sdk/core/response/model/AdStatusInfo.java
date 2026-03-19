package com.kwad.sdk.core.response.model;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdStatusInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 3728247893272878881L;
    public long downloadFinishTime;
    public long downloadSize;
    public int downloadStatus;
    public int downloadType;
    public long loadDataTime;
    public boolean loadFromCache;

    public boolean isLoadFromCache() {
        return this.loadFromCache;
    }

    public void setLoadFromCache(boolean z) {
        this.loadFromCache = z;
    }

    public long getLoadDataTime() {
        return this.loadDataTime;
    }

    public void setLoadDataTime(long j) {
        this.loadDataTime = j;
    }

    public long getDownloadFinishTime() {
        return this.downloadFinishTime;
    }

    public void setDownloadFinishTime(long j) {
        this.downloadFinishTime = j;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public void setDownloadType(int i) {
        this.downloadType = i;
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public void setDownloadSize(long j) {
        this.downloadSize = j;
    }
}
