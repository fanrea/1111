package com.kuaishou.live.longconnection;

import android.content.Context;
import com.kuaishou.android.live.model.Race;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class LiveLongConnectionContext {
    public String mAnchorId;
    public String mAppId;
    public int mAppType;
    public String mAppVer;
    public String mBiz;
    public String mChannel;
    public int mClientId;
    public Context mContext;
    public String mDeviceId;
    public boolean mIsAnchor;
    public boolean mIsEscrow;
    public boolean mIsSimpleLive;
    public String mKpf;
    public String mKpn;
    public int mLiveStreamStartPlaySourceType;
    public String mOldToken;
    public String mPhoneModel;
    public String mPushArrowRedPacketId;
    public String mSessionId;
    public String mSys;
    public String mSysVer;

    public abstract String getApiServiceToken();

    public abstract String getAttach();

    public abstract String getExpTag();

    public abstract List<String> getHostPorts();

    public abstract String getLiveStreamId();

    public abstract String getLocale();

    public abstract double[] getLocation();

    public abstract String getOperator();

    public abstract Race getRace();

    public abstract String getUserId();

    public abstract boolean isFirstEnterRoom();
}
