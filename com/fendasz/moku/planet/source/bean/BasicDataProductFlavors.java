package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BasicDataProductFlavors implements Serializable {
    private ApplicationData applicationData;
    private String applicationId;
    private String applicationIdNew;
    private String durl;
    private Integer id;
    private String name;

    public String getApplicationIdNew() {
        return this.applicationIdNew;
    }

    public void setApplicationIdNew(String str) {
        this.applicationIdNew = str;
    }

    public ApplicationData getApplicationData() {
        return this.applicationData;
    }

    public void setApplicationData(ApplicationData applicationData) {
        this.applicationData = applicationData;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public String getDurl() {
        return this.durl;
    }

    public void setDurl(String str) {
        this.durl = str;
    }
}
