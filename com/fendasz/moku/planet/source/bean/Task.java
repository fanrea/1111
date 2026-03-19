package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class Task implements Serializable {
    private String apkApplicationId;
    private String apkDownloadType;
    private String apkDownloadUrl;
    private Integer id;
    private String key;
    private String name;

    public String getApkApplicationId() {
        return this.apkApplicationId;
    }

    public void setApkApplicationId(String str) {
        this.apkApplicationId = str;
    }

    public String getApkDownloadType() {
        return this.apkDownloadType;
    }

    public void setApkDownloadType(String str) {
        this.apkDownloadType = str;
    }

    public String getApkDownloadUrl() {
        return this.apkDownloadUrl;
    }

    public void setApkDownloadUrl(String str) {
        this.apkDownloadUrl = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
