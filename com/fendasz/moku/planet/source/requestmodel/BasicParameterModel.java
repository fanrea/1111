package com.fendasz.moku.planet.source.requestmodel;

import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.utils.system.entity.PackageInfoEntity;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BasicParameterModel {
    public static final int LIST_TYPE_ALL = 0;
    public static final int LIST_TYPE_HIGH = 2;
    public static final int LIST_TYPE_SIMPLE = 1;
    private Boolean accessibilityEnabled;
    private Boolean adbEnabled;
    private String additionalData;
    private String appId;
    private String data;
    private Integer listType;
    private MokuOptions mokuOptions;
    private List<PackageInfoEntity> packageInfos;
    private Integer page;
    private Integer pageSize;
    private Integer simulatorCode;
    private List<String> taskClassifyList;

    public MokuOptions getMokuOptions() {
        return this.mokuOptions;
    }

    public void setMokuOptions(MokuOptions mokuOptions) {
        this.mokuOptions = mokuOptions;
    }

    public Integer getSimulatorCode() {
        return this.simulatorCode;
    }

    public void setSimulatorCode(Integer num) {
        this.simulatorCode = num;
    }

    public Boolean getAdbEnabled() {
        return this.adbEnabled;
    }

    public void setAdbEnabled(Boolean bool) {
        this.adbEnabled = bool;
    }

    public Boolean getAccessibilityEnabled() {
        return this.accessibilityEnabled;
    }

    public void setAccessibilityEnabled(Boolean bool) {
        this.accessibilityEnabled = bool;
    }

    public List<PackageInfoEntity> getPackageInfos() {
        return this.packageInfos;
    }

    public void setPackageInfos(List<PackageInfoEntity> list) {
        this.packageInfos = list;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public Integer getListType() {
        return this.listType;
    }

    public void setListType(Integer num) {
        this.listType = num;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getAdditionalData() {
        return this.additionalData;
    }

    public void setAdditionalData(String str) {
        this.additionalData = str;
    }

    public List<String> getTaskClassifyList() {
        return this.taskClassifyList;
    }

    public void setTaskClassifyList(List<String> list) {
        this.taskClassifyList = list;
    }
}
