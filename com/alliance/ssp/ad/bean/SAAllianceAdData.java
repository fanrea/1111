package com.alliance.ssp.ad.bean;

import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.alliance.ssp.ad.a.b;
import com.alliance.ssp.ad.d0.f;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceAdData implements Parcelable {
    public static final Parcelable.Creator<SAAllianceAdData> CREATOR = new a();
    private int adsequence;
    private String adtype;
    private String apksize;
    private long cacheTimeout;
    private int clickCallbackSwitch;
    private String crequestid;
    private long deadlineTime;
    private int dlConfig;
    private int dpdialogldp;
    private Extended extended;
    private Interaction interaction;
    private String istesting;
    private int loadtype;
    private Material material;
    private Monitor monitor;
    private String mtype;
    private boolean needCache;
    private String orderid;
    private String parentCrequestid;
    private String payload;
    private String price;
    private double priceD;
    private float probability;
    private int rdirection;
    private String renderId;
    private int renderRatio;
    private String requestid;
    private int restype;
    private int rewardTime;
    private String rewardUUID;
    private boolean rewardValid;
    private int rsize;
    private String rstyle;
    private List<Sdkinfo> sdkinfo;
    private int serialflag;
    private int splashClickFollow;
    private String sposid;
    private int spostype;
    private String tagCode;
    private String tagName;
    private String tagVer;
    private String template;
    private int unclickable;
    private String userId;
    private float validExposeTime;
    private int verifyWithServer;
    private String videoFile;
    private long waitLoadTimeout;
    private int webViewCloseAccess;
    private int webViewCloseCache;
    private int webViewReplaceTagCode;

    public class a implements Parcelable.Creator<SAAllianceAdData> {
        @Override // android.os.Parcelable.Creator
        public SAAllianceAdData createFromParcel(Parcel parcel) {
            return new SAAllianceAdData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SAAllianceAdData[] newArray(int i) {
            return new SAAllianceAdData[i];
        }
    }

    public SAAllianceAdData(Parcel parcel) throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.restype = 0;
        this.spostype = -1;
        this.adsequence = 0;
        this.serialflag = 0;
        this.unclickable = 0;
        this.loadtype = -1;
        this.rdirection = 1;
        this.rsize = 1;
        this.dlConfig = 0;
        this.splashClickFollow = 0;
        this.webViewReplaceTagCode = 0;
        this.webViewCloseAccess = 0;
        this.webViewCloseCache = 0;
        this.verifyWithServer = 0;
        this.rewardTime = 0;
        this.clickCallbackSwitch = 0;
        this.renderRatio = 0;
        this.dpdialogldp = 0;
        this.cacheTimeout = 0L;
        this.waitLoadTimeout = 0L;
        this.deadlineTime = 0L;
        this.probability = 0.0f;
        this.validExposeTime = 0.0f;
        this.priceD = 0.0d;
        this.crequestid = "";
        this.requestid = "";
        this.sposid = "";
        this.tagName = "";
        this.tagVer = "";
        this.tagCode = "";
        this.template = "";
        this.apksize = "";
        this.orderid = "";
        this.videoFile = "";
        this.price = "";
        this.rewardUUID = "";
        this.renderId = "";
        this.adtype = "";
        this.istesting = "";
        this.payload = "";
        this.mtype = "1";
        this.rstyle = "1";
        this.parentCrequestid = "";
        this.userId = "";
        try {
            this.restype = parcel.readInt();
            this.spostype = parcel.readInt();
            this.adsequence = parcel.readInt();
            this.serialflag = parcel.readInt();
            this.unclickable = parcel.readInt();
            this.loadtype = parcel.readInt();
            this.rdirection = parcel.readInt();
            this.rsize = parcel.readInt();
            this.dlConfig = parcel.readInt();
            this.splashClickFollow = parcel.readInt();
            this.webViewReplaceTagCode = parcel.readInt();
            this.webViewCloseAccess = parcel.readInt();
            this.webViewCloseCache = parcel.readInt();
            this.verifyWithServer = parcel.readInt();
            this.rewardTime = parcel.readInt();
            this.clickCallbackSwitch = parcel.readInt();
            this.renderRatio = parcel.readInt();
            this.dpdialogldp = parcel.readInt();
            this.cacheTimeout = parcel.readLong();
            this.waitLoadTimeout = parcel.readLong();
            this.deadlineTime = parcel.readLong();
            this.probability = parcel.readFloat();
            this.validExposeTime = parcel.readFloat();
            this.priceD = parcel.readDouble();
            this.crequestid = parcel.readString();
            this.requestid = parcel.readString();
            this.sposid = parcel.readString();
            this.tagName = parcel.readString();
            this.tagVer = parcel.readString();
            this.tagCode = parcel.readString();
            this.template = parcel.readString();
            this.apksize = parcel.readString();
            this.orderid = parcel.readString();
            this.videoFile = parcel.readString();
            this.price = parcel.readString();
            this.rewardUUID = parcel.readString();
            this.renderId = parcel.readString();
            this.adtype = parcel.readString();
            this.istesting = parcel.readString();
            this.payload = parcel.readString();
            this.mtype = parcel.readString();
            this.rstyle = parcel.readString();
            this.parentCrequestid = parcel.readString();
            this.userId = parcel.readString();
            this.needCache = parcel.readByte() == 1;
            this.rewardValid = parcel.readByte() == 1;
            this.material = (Material) parcel.readParcelable(Material.class.getClassLoader());
            this.interaction = (Interaction) parcel.readParcelable(Interaction.class.getClassLoader());
        } catch (Exception e) {
            f.b().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, b.a("SAAllianceAdData 001: ")), e);
        }
    }

    public SAAllianceAdData copy() throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeParcelable(this, 0);
            parcelObtain.setDataPosition(0);
            SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) parcelObtain.readParcelable(SAAllianceAdData.class.getClassLoader());
            parcelObtain.recycle();
            return sAAllianceAdData;
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, b.a("SAAllianceAdData 003: ")), e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdsequence() {
        return this.adsequence;
    }

    public String getAdtype() {
        return this.adtype;
    }

    public String getApksize() {
        return this.apksize;
    }

    public long getCacheTimeout() {
        return this.cacheTimeout;
    }

    public int getClickCallbackSwitch() {
        return this.clickCallbackSwitch;
    }

    public String getCrequestid() {
        return this.crequestid;
    }

    public long getDeadlineTime() {
        return this.deadlineTime;
    }

    public int getDlConfig() {
        return this.dlConfig;
    }

    public int getDpdialogldp() {
        return this.dpdialogldp;
    }

    public Extended getExtended() {
        return this.extended;
    }

    public Interaction getInteraction() {
        return this.interaction;
    }

    public String getIstesting() {
        return this.istesting;
    }

    public int getLoadtype() {
        return this.loadtype;
    }

    public Material getMaterial() {
        return this.material;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public String getMtype() {
        return this.mtype;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public String getParentCrequestid() {
        return this.parentCrequestid;
    }

    public String getPayload() {
        return this.payload;
    }

    public String getPrice() {
        return this.price;
    }

    public double getPriceD() {
        return this.priceD;
    }

    public float getProbability() {
        return this.probability;
    }

    public int getRdirection() {
        return this.rdirection;
    }

    public String getRenderId() {
        return this.renderId;
    }

    public int getRenderRatio() {
        return this.renderRatio;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public int getRestype() {
        return this.restype;
    }

    public int getRewardTime() {
        return this.rewardTime;
    }

    public String getRewardUUID() {
        return this.rewardUUID;
    }

    public int getRsize() {
        return this.rsize;
    }

    public String getRstyle() {
        return this.rstyle;
    }

    public List<Sdkinfo> getSdkinfo() {
        return this.sdkinfo;
    }

    public int getSerialflag() {
        return this.serialflag;
    }

    public int getSplashClickFollow() {
        return this.splashClickFollow;
    }

    public String getSposid() {
        return this.sposid;
    }

    public int getSpostype() {
        return this.spostype;
    }

    public String getTagCode() {
        return this.tagCode;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getTagVer() {
        return this.tagVer;
    }

    public String getTemplate() {
        return this.template;
    }

    public int getUnclickable() {
        return this.unclickable;
    }

    public String getUserId() {
        return this.userId;
    }

    public float getValidExposeTime() {
        return this.validExposeTime;
    }

    public int getVerifyWithServer() {
        return this.verifyWithServer;
    }

    public String getVideoFile() {
        return this.videoFile;
    }

    public long getWaitLoadTimeout() {
        return this.waitLoadTimeout;
    }

    public int getWebViewCloseAccess() {
        return this.webViewCloseAccess;
    }

    public int getWebViewCloseCache() {
        return this.webViewCloseCache;
    }

    public int getWebViewReplaceTagCode() {
        return this.webViewReplaceTagCode;
    }

    public boolean isNeedCache() {
        return this.needCache;
    }

    public boolean isRewardValid() {
        return this.rewardValid;
    }

    public void setAdsequence(int i) {
        this.adsequence = i;
    }

    public void setAdtype(String str) {
        this.adtype = str;
    }

    public void setApksize(String str) {
        this.apksize = str;
    }

    public void setCacheTimeout(long j) {
        this.cacheTimeout = j;
    }

    public void setClickCallbackSwitch(int i) {
        this.clickCallbackSwitch = i;
    }

    public void setCrequestid(String str) {
        this.crequestid = str;
    }

    public void setDeadlineTime(long j) {
        this.deadlineTime = j;
    }

    public void setDlConfig(int i) {
        this.dlConfig = i;
    }

    public void setDpdialogldp(int i) {
        this.dpdialogldp = i;
    }

    public void setExtended(Extended extended) {
        this.extended = extended;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public void setIstesting(String str) {
        this.istesting = str;
    }

    public void setLoadtype(int i) {
        this.loadtype = i;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setMtype(String str) {
        this.mtype = str;
    }

    public void setNeedCache(boolean z) {
        this.needCache = z;
    }

    public void setOrderid(String str) {
        this.orderid = str;
    }

    public void setParentCrequestid(String str) {
        this.parentCrequestid = str;
    }

    public void setPayload(String str) {
        this.payload = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPriceD(double d) {
        this.priceD = d;
    }

    public void setProbability(float f) {
        this.probability = f;
    }

    public void setRdirection(int i) {
        this.rdirection = i;
    }

    public void setRenderId(String str) {
        this.renderId = str;
    }

    public void setRenderRatio(int i) {
        this.renderRatio = i;
    }

    public void setRequestid(String str) {
        this.requestid = str;
    }

    public void setRestype(int i) {
        this.restype = i;
    }

    public void setRewardTime(int i) {
        this.rewardTime = i;
    }

    public void setRewardUUID(String str) {
        this.rewardUUID = str;
    }

    public void setRewardValid(boolean z) {
        this.rewardValid = z;
    }

    public void setRsize(int i) {
        this.rsize = i;
    }

    public void setRstyle(String str) {
        this.rstyle = str;
    }

    public void setSdkinfo(List<Sdkinfo> list) {
        this.sdkinfo = list;
    }

    public void setSerialflag(int i) {
        this.serialflag = i;
    }

    public void setSplashClickFollow(int i) {
        this.splashClickFollow = i;
    }

    public void setSposid(String str) {
        this.sposid = str;
    }

    public void setSpostype(int i) {
        this.spostype = i;
    }

    public void setTagCode(String str) {
        this.tagCode = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public void setTagVer(String str) {
        this.tagVer = str;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public void setUnclickable(int i) {
        this.unclickable = i;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setValidExposeTime(float f) {
        this.validExposeTime = f;
    }

    public void setVerifyWithServer(int i) {
        this.verifyWithServer = i;
    }

    public void setVideoFile(String str) {
        this.videoFile = str;
    }

    public void setWaitLoadTimeout(long j) {
        this.waitLoadTimeout = j;
    }

    public void setWebViewCloseAccess(int i) {
        this.webViewCloseAccess = i;
    }

    public void setWebViewCloseCache(int i) {
        this.webViewCloseCache = i;
    }

    public void setWebViewReplaceTagCode(int i) {
        this.webViewReplaceTagCode = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            parcel.writeInt(this.restype);
            parcel.writeInt(this.spostype);
            parcel.writeInt(this.adsequence);
            parcel.writeInt(this.serialflag);
            parcel.writeInt(this.unclickable);
            parcel.writeInt(this.loadtype);
            parcel.writeInt(this.rdirection);
            parcel.writeInt(this.rsize);
            parcel.writeInt(this.dlConfig);
            parcel.writeInt(this.splashClickFollow);
            parcel.writeInt(this.webViewReplaceTagCode);
            parcel.writeInt(this.webViewCloseAccess);
            parcel.writeInt(this.webViewCloseCache);
            parcel.writeInt(this.verifyWithServer);
            parcel.writeInt(this.rewardTime);
            parcel.writeInt(this.clickCallbackSwitch);
            parcel.writeInt(this.renderRatio);
            parcel.writeInt(this.dpdialogldp);
            parcel.writeLong(this.cacheTimeout);
            parcel.writeLong(this.waitLoadTimeout);
            parcel.writeLong(this.deadlineTime);
            parcel.writeFloat(this.probability);
            parcel.writeFloat(this.validExposeTime);
            parcel.writeDouble(this.priceD);
            parcel.writeString(this.crequestid);
            parcel.writeString(this.requestid);
            parcel.writeString(this.sposid);
            parcel.writeString(this.tagName);
            parcel.writeString(this.tagVer);
            parcel.writeString(this.tagCode);
            parcel.writeString(this.template);
            parcel.writeString(this.apksize);
            parcel.writeString(this.orderid);
            parcel.writeString(this.videoFile);
            parcel.writeString(this.price);
            parcel.writeString(this.rewardUUID);
            parcel.writeString(this.renderId);
            parcel.writeString(this.adtype);
            parcel.writeString(this.istesting);
            parcel.writeString(this.payload);
            parcel.writeString(this.mtype);
            parcel.writeString(this.rstyle);
            parcel.writeString(this.parentCrequestid);
            parcel.writeString(this.userId);
            parcel.writeByte(this.needCache ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.rewardValid ? (byte) 1 : (byte) 0);
            parcel.writeParcelable(this.material, i);
            parcel.writeParcelable(this.interaction, i);
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, b.a("SAAllianceAdData 002: ")), e);
        }
    }
}
