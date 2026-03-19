package com.baidu.mobstat.forbes;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public interface ICooperService {
    boolean checkWifiLocationSetting(Context context);

    String getAppChannel(Context context);

    String getAppKey(Context context);

    int getAppVersionCode(Context context);

    String getAppVersionName(Context context);

    String getCUID(Context context, boolean z);

    String getDeviceId(TelephonyManager telephonyManager, Context context);

    String getHost();

    String getLinkedWay(Context context);

    String getMTJSDKVersion();

    String getOSVersion();

    String getOperator(TelephonyManager telephonyManager);

    String getPhoneModel();

    String getSecretValue(String str);

    int getTagValue();

    void installHeader(Context context, JSONObject jSONObject);
}
