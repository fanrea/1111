package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class UploadVideoReponse implements Serializable {
    private static final long serialVersionUID = 7351623192727004749L;
    private String downloadPath;
    private String fileName;
    private String md5;
    private String relativePath;
    private Long size;

    public String getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(String str) {
        this.relativePath = str;
    }

    public String getDownloadPath() {
        return this.downloadPath;
    }

    public void setDownloadPath(String str) {
        this.downloadPath = str;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long l) {
        this.size = l;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }
}
