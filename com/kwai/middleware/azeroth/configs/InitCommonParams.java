package com.kwai.middleware.azeroth.configs;

import android.app.Application;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface InitCommonParams {
    String getAppId();

    String getAppVersion();

    String getChannel();

    Application getContext();

    String getCountryIso();

    String getDeviceId();

    String getGlobalId();

    String getLanguage();

    double getLatitude();

    double getLongitude();

    String getManufacturerAndModel();

    String getPassportPassToken();

    String getPassportServiceID();

    String getPassportServiceSecurity();

    String getPassportServiceToken();

    String getPlatform();

    String getProductName();

    SharedPreferences getSharedPreferences(String str, int i);

    String getSysRelease();

    String getUserId();

    boolean isDebugMode();

    boolean isLogined();

    boolean isTestMode();
}
