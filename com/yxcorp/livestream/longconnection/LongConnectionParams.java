package com.yxcorp.livestream.longconnection;

import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LongConnectionParams implements Cloneable {
    private String mAnchorId;
    private String mAppId;
    private int mAppType;
    private String mAppVer;
    private String mAttach;
    private String mBiz;
    private String mBroadcastGiftToken;
    private String mChannel;
    private int mClientId;
    private String mDeviceId;
    private String mExpTag;
    private boolean mIsAuthor;
    private boolean mIsEscrow;
    private boolean mIsFirstEnterRoom;
    private boolean mIsSimpleLive;
    private String mKpf;
    private String mKpn;
    private int mLastErrorCode;
    private double mLatitude;
    private String mLiveStreamId;
    private int mLiveStreamStartPlaySourceType;
    private String mLocale;
    private double mLongitude;
    private String mOperator;
    private String mPhoneModel;
    private String mPushArrowRedPacketId;
    private int mRetryCount;
    private ServerUriInfo mServerUriInfo;
    private String mServiceToken;
    private String mSessionId;
    private String mSys;
    private String mSysVer;
    private String mToken;
    private long mUserId;

    public LongConnectionParams setAttach(String str) {
        this.mAttach = str;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongConnectionParams m1515clone() {
        try {
            return (LongConnectionParams) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAttach() {
        return this.mAttach;
    }

    public LongConnectionParams setAuthor(boolean z) {
        this.mIsAuthor = z;
        return this;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public LongConnectionParams setLatitude(double d) {
        this.mLatitude = d;
        return this;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public LongConnectionParams setLongitude(double d) {
        this.mLongitude = d;
        return this;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public LongConnectionParams setUserId(long j) {
        this.mUserId = j;
        return this;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public LongConnectionParams setRetryCount(int i) {
        this.mRetryCount = i;
        return this;
    }

    public int getLastErrorCode() {
        return this.mLastErrorCode;
    }

    public LongConnectionParams setLastErrorCode(int i) {
        this.mLastErrorCode = i;
        return this;
    }

    public String getToken() {
        String str = this.mToken;
        return str == null ? "" : str;
    }

    public String getLiveStreamId() {
        return this.mLiveStreamId;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public boolean isAuthor() {
        return this.mIsAuthor;
    }

    public boolean isEscrow() {
        return this.mIsEscrow;
    }

    public boolean isSimpleLive() {
        return this.mIsSimpleLive;
    }

    public LongConnectionParams setIsSimpleLive(boolean z) {
        this.mIsSimpleLive = z;
        return this;
    }

    public LongConnectionParams setIsEscrow(boolean z) {
        this.mIsEscrow = z;
        return this;
    }

    public LongConnectionParams setIsAuthor(boolean z) {
        this.mIsAuthor = z;
        return this;
    }

    public LongConnectionParams setToken(String str) {
        this.mToken = str;
        return this;
    }

    public LongConnectionParams setLiveStreamId(String str) {
        this.mLiveStreamId = str;
        return this;
    }

    public LongConnectionParams setDeviceId(String str) {
        this.mDeviceId = str;
        return this;
    }

    public LongConnectionParams setServerUriInfo(ServerUriInfo serverUriInfo) {
        this.mServerUriInfo = serverUriInfo;
        return this;
    }

    public ServerUriInfo getServerUriInfo() {
        return this.mServerUriInfo;
    }

    public String getAppVer() {
        return this.mAppVer;
    }

    public LongConnectionParams setAppVer(String str) {
        this.mAppVer = str;
        return this;
    }

    public String getSys() {
        return this.mSys;
    }

    public LongConnectionParams setSys(String str) {
        this.mSys = str;
        return this;
    }

    public String getSysVer() {
        return this.mSysVer;
    }

    public LongConnectionParams setSysVer(String str) {
        this.mSysVer = str;
        return this;
    }

    public String getPhoneModel() {
        return this.mPhoneModel;
    }

    public LongConnectionParams setPhoneModel(String str) {
        this.mPhoneModel = str;
        return this;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public LongConnectionParams setChannel(String str) {
        this.mChannel = str;
        return this;
    }

    public String getLocale() {
        return this.mLocale;
    }

    public LongConnectionParams setLocale(String str) {
        this.mLocale = str;
        return this;
    }

    public String getLocation() {
        return this.mLatitude + "," + this.mLongitude;
    }

    public String getOperator() {
        return this.mOperator;
    }

    public LongConnectionParams setOperator(String str) {
        this.mOperator = str;
        return this;
    }

    public boolean isFirstEnterRoom() {
        return this.mIsFirstEnterRoom;
    }

    public LongConnectionParams setFirstEnterRoom(boolean z) {
        this.mIsFirstEnterRoom = z;
        return this;
    }

    public String getExpTag() {
        return this.mExpTag;
    }

    public LongConnectionParams setExpTag(String str) {
        this.mExpTag = str;
        return this;
    }

    public LongConnectionParams setLiveStreamStartPlaySourceType(int i) {
        this.mLiveStreamStartPlaySourceType = i;
        return this;
    }

    public int getLiveStreamStartPlaySourceType() {
        return this.mLiveStreamStartPlaySourceType;
    }

    public LongConnectionParams setBroadcastGiftToken(String str) {
        this.mBroadcastGiftToken = str;
        return this;
    }

    public String getBroadcastGiftToken() {
        String str = this.mBroadcastGiftToken;
        return str == null ? "" : str;
    }

    public LongConnectionParams setPushArrowRedPacketId(String str) {
        this.mPushArrowRedPacketId = str;
        return this;
    }

    public String getPushArrowRedPacketId() {
        String str = this.mPushArrowRedPacketId;
        return str == null ? "" : str;
    }

    public LongConnectionParams setServiceToken(String str) {
        this.mServiceToken = str;
        return this;
    }

    public String getServiceToken() {
        String str = this.mServiceToken;
        return str == null ? "" : str;
    }

    public String getAnchorId() {
        String str = this.mAnchorId;
        return str == null ? "" : str;
    }

    public LongConnectionParams setAnchorId(String str) {
        this.mAnchorId = str;
        return this;
    }

    public String getSessionId() {
        String str = this.mSessionId;
        return str == null ? "" : str;
    }

    public LongConnectionParams setSessionId(String str) {
        this.mSessionId = str;
        return this;
    }

    public String getKpn() {
        return this.mKpn;
    }

    public LongConnectionParams setKpn(String str) {
        this.mKpn = str;
        return this;
    }

    public String getKpf() {
        return this.mKpf;
    }

    public LongConnectionParams setKpf(String str) {
        this.mKpf = str;
        return this;
    }

    public int getAppType() {
        return this.mAppType;
    }

    public LongConnectionParams setAppType(int i) {
        this.mAppType = i;
        return this;
    }

    public int getClientId() {
        return this.mClientId;
    }

    public LongConnectionParams setClientId(int i) {
        this.mClientId = i;
        return this;
    }

    public String getmAppId() {
        return this.mAppId;
    }

    public LongConnectionParams setmAppId(String str) {
        this.mAppId = str;
        return this;
    }

    public String getmBiz() {
        return this.mBiz;
    }

    public LongConnectionParams setmBiz(String str) {
        this.mBiz = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LongConnectionParams{");
        sb.append("mToken='");
        sb.append(this.mToken);
        sb.append('\'');
        sb.append(", mLiveStreamId='");
        sb.append(this.mLiveStreamId);
        sb.append('\'');
        sb.append(", mAppId='");
        sb.append(this.mAppId);
        sb.append('\'');
        sb.append(", mBiz='");
        sb.append(this.mBiz);
        sb.append('\'');
        sb.append(", mDeviceId='");
        sb.append(this.mDeviceId);
        sb.append('\'');
        sb.append(", mIsAuthor=");
        sb.append(this.mIsAuthor);
        sb.append(", mAppVer='");
        sb.append(this.mAppVer);
        sb.append('\'');
        sb.append(", mSys='");
        sb.append(this.mSys);
        sb.append('\'');
        sb.append(", mPhoneModel='");
        sb.append(this.mPhoneModel);
        sb.append('\'');
        sb.append(", mChannel='");
        sb.append(this.mChannel);
        sb.append('\'');
        sb.append(", mLocale='");
        sb.append(this.mLocale);
        sb.append('\'');
        sb.append(", mOperator='");
        sb.append(this.mOperator);
        sb.append('\'');
        sb.append(", mExpTag='");
        sb.append(this.mExpTag);
        sb.append('\'');
        sb.append(", mServerUriInfo=");
        sb.append(this.mServerUriInfo);
        sb.append(", mIsFirstEnterRoom=");
        sb.append(this.mIsFirstEnterRoom);
        sb.append(", mRetryCount=");
        sb.append(this.mRetryCount);
        sb.append(", mLastErrorCode=");
        sb.append(this.mLastErrorCode);
        sb.append(", mLatitude=");
        sb.append(this.mLatitude);
        sb.append(", mLongitude=");
        sb.append(this.mLongitude);
        sb.append(", mUserId=");
        sb.append(this.mUserId);
        sb.append(", mAttach='");
        sb.append(this.mAttach);
        sb.append('\'');
        sb.append(", mLiveStreamStartPlaySourceType='");
        sb.append(this.mLiveStreamStartPlaySourceType);
        sb.append('\'');
        sb.append(", mBroadcastGiftToken='");
        sb.append(this.mBroadcastGiftToken);
        sb.append('\'');
        sb.append(", mServiceToken='");
        sb.append(this.mServiceToken);
        sb.append('\'');
        sb.append(", mAnchorId='");
        sb.append(this.mAnchorId);
        sb.append('\'');
        sb.append(", mSessionId='");
        sb.append(this.mSessionId);
        sb.append('\'');
        sb.append(", mKpn='");
        sb.append(this.mKpn);
        sb.append('\'');
        sb.append(", mKpf='");
        sb.append(this.mKpf);
        sb.append('\'');
        sb.append(", mAppType='");
        sb.append(this.mAppType);
        sb.append('\'');
        sb.append(", mClientId='");
        sb.append(this.mClientId);
        sb.append('\'');
        sb.append('}');
        return sb.substring(0);
    }

    public static class ServerUriInfo {
        String mExtra;
        public String mServerUri;
        URL mURL;

        public ServerUriInfo(String str, String str2) {
            this.mServerUri = str;
            this.mExtra = str2;
            try {
                this.mURL = new URL("http://" + this.mServerUri);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ServerUriInfo) && this.mServerUri.equals(((ServerUriInfo) obj).mServerUri);
        }

        public String getHost() {
            URL url = this.mURL;
            return url == null ? "" : url.getHost();
        }

        public int getPort() {
            URL url = this.mURL;
            if (url == null) {
                return -1;
            }
            return url.getPort();
        }

        public String getExtra() {
            return this.mExtra;
        }

        public String getServerUri() {
            return this.mServerUri;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ServerUriInfo{");
            sb.append("mServerUri='");
            sb.append(this.mServerUri);
            sb.append('\'');
            sb.append(", mExtra='");
            sb.append(this.mExtra);
            sb.append('\'');
            sb.append(", mURL=");
            sb.append(this.mURL);
            sb.append('}');
            return sb.substring(0);
        }
    }
}
