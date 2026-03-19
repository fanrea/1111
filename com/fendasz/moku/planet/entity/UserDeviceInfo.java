package com.fendasz.moku.planet.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class UserDeviceInfo implements Serializable {
    private static final long serialVersionUID = 2597970539613328037L;
    private Integer accessibleMode;
    private Integer adb;
    private String androidVersion;
    private Integer appShopFileCreate;
    private Integer appShopFileVisit;
    private String baseStationInfo;
    private Integer baseband;
    private String cpuArchitecture;
    private String cpuCurrentFreq;
    private String cpuMinFreq;
    private String currentCapacity;
    private Integer debugger;
    private String deviceId;
    private String elapsedRealtime;
    private Integer genemytion;
    private Integer haveAlipay;
    private Integer haveWechat;
    private String imei1;
    private String imei2;
    private String imsi;
    private String ip;
    private Integer isDevmode;
    private Integer isRooted;
    private Boolean isScript;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String longitudeAndLatitudeAddress;
    private String mobileBrandName;
    private String mobileBrandType;
    private String mobileNetwork;
    private String mobileOperators;
    private String oaid;
    private String operatingSystem;
    private String optical;
    private Integer qemuDrive;
    private Integer qemuFile;
    private Integer qemuPipeline;
    private Integer qqPackageExist;
    private String remainDisk;
    private String resolution;
    private Integer script;
    private String serialNum;
    private String startupTime;
    private Integer taskDataId;
    private String temperature;
    private String totalCapacity;
    private String totalDisk;
    private Integer tracerPid;
    private Integer trigger;
    private String uptimeMillis;
    private String voltage;
    private Integer wechatPackageExist;
    private String wifiFreq;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTrigger() {
        return this.trigger;
    }

    public void setTrigger(Integer num) {
        this.trigger = num;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getImei1() {
        return this.imei1;
    }

    public void setImei1(String str) {
        this.imei1 = str;
    }

    public String getImei2() {
        return this.imei2;
    }

    public void setImei2(String str) {
        this.imei2 = str;
    }

    public String getOaid() {
        return this.oaid;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public String getImsi() {
        return this.imsi;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public void setAndroidVersion(String str) {
        this.androidVersion = str;
    }

    public String getMobileBrandName() {
        return this.mobileBrandName;
    }

    public void setMobileBrandName(String str) {
        this.mobileBrandName = str;
    }

    public String getMobileBrandType() {
        return this.mobileBrandType;
    }

    public void setMobileBrandType(String str) {
        this.mobileBrandType = str;
    }

    public String getMobileOperators() {
        return this.mobileOperators;
    }

    public void setMobileOperators(String str) {
        this.mobileOperators = str;
    }

    public String getMobileNetwork() {
        return this.mobileNetwork;
    }

    public void setMobileNetwork(String str) {
        this.mobileNetwork = str;
    }

    public BigDecimal getLongitude() {
        return this.longitude;
    }

    public void setLongitude(BigDecimal bigDecimal) {
        this.longitude = bigDecimal;
    }

    public BigDecimal getLatitude() {
        return this.latitude;
    }

    public void setLatitude(BigDecimal bigDecimal) {
        this.latitude = bigDecimal;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public String getOptical() {
        return this.optical;
    }

    public void setOptical(String str) {
        this.optical = str;
    }

    public Integer getBaseband() {
        return this.baseband;
    }

    public void setBaseband(Integer num) {
        this.baseband = num;
    }

    public String getVoltage() {
        return this.voltage;
    }

    public void setVoltage(String str) {
        this.voltage = str;
    }

    public String getCurrentCapacity() {
        return this.currentCapacity;
    }

    public void setCurrentCapacity(String str) {
        this.currentCapacity = str;
    }

    public String getTotalCapacity() {
        return this.totalCapacity;
    }

    public void setTotalCapacity(String str) {
        this.totalCapacity = str;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String str) {
        this.temperature = str;
    }

    public String getTotalDisk() {
        return this.totalDisk;
    }

    public void setTotalDisk(String str) {
        this.totalDisk = str;
    }

    public String getRemainDisk() {
        return this.remainDisk;
    }

    public void setRemainDisk(String str) {
        this.remainDisk = str;
    }

    public Integer getIsRooted() {
        return this.isRooted;
    }

    public void setIsRooted(Integer num) {
        this.isRooted = num;
    }

    public Integer getIsDevmode() {
        return this.isDevmode;
    }

    public void setIsDevmode(Integer num) {
        this.isDevmode = num;
    }

    public String getCpuArchitecture() {
        return this.cpuArchitecture;
    }

    public void setCpuArchitecture(String str) {
        this.cpuArchitecture = str;
    }

    public String getCpuCurrentFreq() {
        return this.cpuCurrentFreq;
    }

    public void setCpuCurrentFreq(String str) {
        this.cpuCurrentFreq = str;
    }

    public String getCpuMinFreq() {
        return this.cpuMinFreq;
    }

    public void setCpuMinFreq(String str) {
        this.cpuMinFreq = str;
    }

    public String getWifiFreq() {
        return this.wifiFreq;
    }

    public void setWifiFreq(String str) {
        this.wifiFreq = str;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public Integer getHaveWechat() {
        return this.haveWechat;
    }

    public void setHaveWechat(Integer num) {
        this.haveWechat = num;
    }

    public Integer getHaveAlipay() {
        return this.haveAlipay;
    }

    public void setHaveAlipay(Integer num) {
        this.haveAlipay = num;
    }

    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    public void setTaskDataId(Integer num) {
        this.taskDataId = num;
    }

    public String getSerialNum() {
        return this.serialNum;
    }

    public void setSerialNum(String str) {
        this.serialNum = str;
    }

    public String getElapsedRealtime() {
        return this.elapsedRealtime;
    }

    public void setElapsedRealtime(String str) {
        this.elapsedRealtime = str;
    }

    public String getUptimeMillis() {
        return this.uptimeMillis;
    }

    public void setUptimeMillis(String str) {
        this.uptimeMillis = str;
    }

    public String getStartupTime() {
        return this.startupTime;
    }

    public void setStartupTime(String str) {
        this.startupTime = str;
    }

    public Boolean getScript() {
        return this.isScript;
    }

    public void setScript(Integer num) {
        this.script = num;
    }

    public Integer getQqPackageExist() {
        return this.qqPackageExist;
    }

    public void setQqPackageExist(Integer num) {
        this.qqPackageExist = num;
    }

    public Integer getWechatPackageExist() {
        return this.wechatPackageExist;
    }

    public void setWechatPackageExist(Integer num) {
        this.wechatPackageExist = num;
    }

    public Integer getAppShopFileCreate() {
        return this.appShopFileCreate;
    }

    public void setAppShopFileCreate(Integer num) {
        this.appShopFileCreate = num;
    }

    public Integer getAppShopFileVisit() {
        return this.appShopFileVisit;
    }

    public void setAppShopFileVisit(Integer num) {
        this.appShopFileVisit = num;
    }

    public void setScript(Boolean bool) {
        this.isScript = bool;
    }

    public Integer getTracerPid() {
        return this.tracerPid;
    }

    public void setTracerPid(Integer num) {
        this.tracerPid = num;
    }

    public String getBaseStationInfo() {
        return this.baseStationInfo;
    }

    public void setBaseStationInfo(String str) {
        this.baseStationInfo = str;
    }

    public Integer getAdb() {
        return this.adb;
    }

    public void setAdb(Integer num) {
        this.adb = num;
    }

    public Integer getGenemytion() {
        return this.genemytion;
    }

    public void setGenemytion(Integer num) {
        this.genemytion = num;
    }

    public Integer getQemuPipeline() {
        return this.qemuPipeline;
    }

    public void setQemuPipeline(Integer num) {
        this.qemuPipeline = num;
    }

    public Integer getQemuFile() {
        return this.qemuFile;
    }

    public void setQemuFile(Integer num) {
        this.qemuFile = num;
    }

    public Integer getQemuDrive() {
        return this.qemuDrive;
    }

    public void setQemuDrive(Integer num) {
        this.qemuDrive = num;
    }

    public Integer getDebugger() {
        return this.debugger;
    }

    public void setDebugger(Integer num) {
        this.debugger = num;
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(String str) {
        this.operatingSystem = str;
    }

    public Integer getAccessibleMode() {
        return this.accessibleMode;
    }

    public void setAccessibleMode(Integer num) {
        this.accessibleMode = num;
    }

    public String getLongitudeAndLatitudeAddress() {
        return this.longitudeAndLatitudeAddress;
    }

    public void setLongitudeAndLatitudeAddress(String str) {
        this.longitudeAndLatitudeAddress = str;
    }
}
