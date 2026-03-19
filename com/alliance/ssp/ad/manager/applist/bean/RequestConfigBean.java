package com.alliance.ssp.ad.manager.applist.bean;

import com.baidu.mobads.container.adrequest.g;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class RequestConfigBean {
    private String androidid;
    private String apppackage;
    private String appstoreversion;
    private String b;
    private String birthtime;
    private String bootmark;
    private String boottime;
    private String brand;
    private String carrier;
    private String cgid;
    private Integer connectiontype;
    private String cookieid;
    private String countrycode;
    private String density;
    private String devicename;
    private Integer devicetype;
    private String disk;
    private String dpi;
    private String enablePersonalized;
    private String fulllanguage;
    private Object geo;
    private String gid;
    private String hmsAGVerCode;
    private String hmsCoreVer;
    private String hmsversion;
    private String hwmodel;
    private String imei;
    private String installTime;
    private String ip;
    private String ipv6;
    private Integer isnew;
    private String itime;
    private String language;
    private String lgid;
    private String ltime;
    private String mac;
    private String make;
    private String memory;
    private String model;
    private String oaid;
    private String onetime;
    private String orientation;
    private String os;
    private String osupdatetime;
    private String osv;
    private Integer platform;
    private String ppi;
    private String resolution;
    private String sdkver;
    private String secondsfromgmt;
    private String startuptime;
    private String sysid;
    private String timezone;
    private String ua;
    private String updatemark;
    private String ver;

    public RequestConfigBean(HashMap<String, Object> map) {
        this.b = getString(map, "appid");
        this.cookieid = getString(map, "cookieid");
        this.platform = getInteger(map, "platform");
        this.ver = getString(map, "ver");
        this.appstoreversion = getString(map, "appstoreversion");
        this.hmsversion = getString(map, "hmsversion");
        this.ua = getString(map, "ua");
        this.geo = getString(map, "geo");
        this.devicetype = getInteger(map, "devicetype");
        this.os = getString(map, "os");
        this.dpi = getString(map, "dpi");
        this.ppi = getString(map, "ppi");
        this.density = getString(map, "density");
        this.orientation = getString(map, "orientation");
        this.connectiontype = getInteger(map, "connectiontype");
        this.mac = getString(map, g.w);
        this.make = getString(map, "make");
        this.updatemark = getString(map, "updatemark");
        this.startuptime = getString(map, "startuptime");
        this.imei = getString(map, g.z);
        this.androidid = getString(map, "androidid");
        this.oaid = getString(map, "oaid");
        this.brand = getString(map, "brand");
        this.gid = getString(map, "gid");
        this.resolution = getString(map, "resolution");
        this.sdkver = getString(map, "sdkver");
        this.lgid = getString(map, "lgid");
        this.ltime = getString(map, "ltime");
        this.isnew = getInteger(map, "isnew");
        this.onetime = getString(map, "onetime");
        this.itime = getString(map, "itime");
        this.installTime = getString(map, "installTime");
        this.timezone = getString(map, "timezone");
        this.boottime = getString(map, "boottime");
        this.countrycode = getString(map, "countrycode");
        this.language = getString(map, "language");
        this.devicename = getString(map, "devicename");
        this.osv = getString(map, "osv");
        this.bootmark = getString(map, "bootmark");
        this.carrier = getString(map, "carrier");
        this.memory = getString(map, "memory");
        this.disk = getString(map, "disk");
        this.osupdatetime = getString(map, "osupdatetime");
        this.model = getString(map, "model");
        this.birthtime = getString(map, "birthtime");
        this.secondsfromgmt = getString(map, "secondsfromgmt");
        this.fulllanguage = getString(map, "fulllanguage");
        this.hwmodel = getString(map, "hwmodel");
        this.hmsAGVerCode = getString(map, "hmsAGVerCode");
        this.hmsCoreVer = getString(map, "hmsCoreVer");
        this.ip = getString(map, "ip");
        this.ipv6 = getString(map, "ipv6");
        this.sysid = getString(map, "sysid");
        this.cgid = getString(map, "cgid");
        this.enablePersonalized = getString(map, "enablePersonalized");
        this.apppackage = getString(map, "apppackage");
    }

    private Integer getInteger(HashMap<String, Object> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj != null) {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        }
        return null;
    }

    private String getString(HashMap<String, Object> map, String str) {
        try {
            return (!map.containsKey(str) || map.get(str) == null) ? "" : map.get(str).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String getAndroidid() {
        return this.androidid;
    }

    public String getApppackage() {
        return this.apppackage;
    }

    public String getAppstoreversion() {
        return this.appstoreversion;
    }

    public String getB() {
        return this.b;
    }

    public String getBirthtime() {
        return this.birthtime;
    }

    public String getBootmark() {
        return this.bootmark;
    }

    public String getBoottime() {
        return this.boottime;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getCgid() {
        return this.cgid;
    }

    public Integer getConnectiontype() {
        return this.connectiontype;
    }

    public String getCookieid() {
        return this.cookieid;
    }

    public String getCountrycode() {
        return this.countrycode;
    }

    public String getDensity() {
        return this.density;
    }

    public String getDevicename() {
        return this.devicename;
    }

    public Integer getDevicetype() {
        return this.devicetype;
    }

    public String getDisk() {
        return this.disk;
    }

    public String getDpi() {
        return this.dpi;
    }

    public String getEnablePersonalized() {
        return this.enablePersonalized;
    }

    public String getFulllanguage() {
        return this.fulllanguage;
    }

    public Object getGeo() {
        return this.geo;
    }

    public String getGid() {
        return this.gid;
    }

    public String getHmsAGVerCode() {
        return this.hmsAGVerCode;
    }

    public String getHmsCoreVer() {
        return this.hmsCoreVer;
    }

    public String getHmsversion() {
        return this.hmsversion;
    }

    public String getHwmodel() {
        return this.hwmodel;
    }

    public String getImei() {
        return this.imei;
    }

    public String getInstallTime() {
        return this.installTime;
    }

    public String getIp() {
        return this.ip;
    }

    public String getIpv6() {
        return this.ipv6;
    }

    public Integer getIsnew() {
        return this.isnew;
    }

    public String getItime() {
        return this.itime;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLgid() {
        return this.lgid;
    }

    public String getLtime() {
        return this.ltime;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMake() {
        return this.make;
    }

    public String getMemory() {
        return this.memory;
    }

    public String getModel() {
        return this.model;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOnetime() {
        return this.onetime;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getOs() {
        return this.os;
    }

    public String getOsupdatetime() {
        return this.osupdatetime;
    }

    public String getOsv() {
        return this.osv;
    }

    public Integer getPlatform() {
        return this.platform;
    }

    public String getPpi() {
        return this.ppi;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getSdkver() {
        return this.sdkver;
    }

    public String getSecondsfromgmt() {
        return this.secondsfromgmt;
    }

    public String getStartuptime() {
        return this.startuptime;
    }

    public String getSysid() {
        return this.sysid;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public String getUa() {
        return this.ua;
    }

    public String getUpdatemark() {
        return this.updatemark;
    }

    public String getVer() {
        return this.ver;
    }

    public void setAndroidid(String str) {
        this.androidid = str;
    }

    public void setApppackage(String str) {
        this.apppackage = str;
    }

    public void setAppstoreversion(String str) {
        this.appstoreversion = str;
    }

    public void setB(String str) {
        this.b = str;
    }

    public void setBirthtime(String str) {
        this.birthtime = str;
    }

    public void setBootmark(String str) {
        this.bootmark = str;
    }

    public void setBoottime(String str) {
        this.boottime = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setCgid(String str) {
        this.cgid = str;
    }

    public void setConnectiontype(Integer num) {
        this.connectiontype = num;
    }

    public void setCookieid(String str) {
        this.cookieid = str;
    }

    public void setCountrycode(String str) {
        this.countrycode = str;
    }

    public void setDensity(String str) {
        this.density = str;
    }

    public void setDevicename(String str) {
        this.devicename = str;
    }

    public void setDevicetype(Integer num) {
        this.devicetype = num;
    }

    public void setDisk(String str) {
        this.disk = str;
    }

    public void setDpi(String str) {
        this.dpi = str;
    }

    public void setEnablePersonalized(String str) {
        this.enablePersonalized = str;
    }

    public void setFulllanguage(String str) {
        this.fulllanguage = str;
    }

    public void setGeo(Object obj) {
        this.geo = obj;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public void setHmsAGVerCode(String str) {
        this.hmsAGVerCode = str;
    }

    public void setHmsCoreVer(String str) {
        this.hmsCoreVer = str;
    }

    public void setHmsversion(String str) {
        this.hmsversion = str;
    }

    public void setHwmodel(String str) {
        this.hwmodel = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setInstallTime(String str) {
        this.installTime = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setIpv6(String str) {
        this.ipv6 = str;
    }

    public void setIsnew(Integer num) {
        this.isnew = num;
    }

    public void setItime(String str) {
        this.itime = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLgid(String str) {
        this.lgid = str;
    }

    public void setLtime(String str) {
        this.ltime = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMake(String str) {
        this.make = str;
    }

    public void setMemory(String str) {
        this.memory = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOnetime(String str) {
        this.onetime = str;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setOsupdatetime(String str) {
        this.osupdatetime = str;
    }

    public void setOsv(String str) {
        this.osv = str;
    }

    public void setPlatform(Integer num) {
        this.platform = num;
    }

    public void setPpi(String str) {
        this.ppi = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setSdkver(String str) {
        this.sdkver = str;
    }

    public void setSecondsfromgmt(String str) {
        this.secondsfromgmt = str;
    }

    public void setStartuptime(String str) {
        this.startuptime = str;
    }

    public void setSysid(String str) {
        this.sysid = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setUa(String str) {
        this.ua = str;
    }

    public void setUpdatemark(String str) {
        this.updatemark = str;
    }

    public void setVer(String str) {
        this.ver = str;
    }
}
