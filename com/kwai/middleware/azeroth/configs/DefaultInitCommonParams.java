package com.kwai.middleware.azeroth.configs;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kwai.middleware.azeroth.utils.DeviceIDUtil;
import com.kwai.middleware.azeroth.utils.SystemUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class DefaultInitCommonParams implements InitCommonParams {
    private String mCountryIso;
    private String mLanguage;
    private String mManufacturerAndModel;
    private String mRelease;
    private PackageInfo mPackageInfo = null;
    private ApplicationInfo mAppInfo = null;

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public double getLatitude() {
        return 0.0d;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public double getLongitude() {
        return 0.0d;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getPlatform() {
        return "ANDROID_PHONE";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public boolean isTestMode() {
        return false;
    }

    public ApplicationInfo getAppInfo() {
        if (this.mAppInfo == null) {
            try {
                this.mAppInfo = getContext().getApplicationInfo();
            } catch (Exception unused) {
            }
        }
        return this.mAppInfo;
    }

    public PackageInfo getPackageInfo() {
        if (this.mPackageInfo == null) {
            try {
                this.mPackageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 64);
            } catch (Exception unused) {
            }
        }
        return this.mPackageInfo;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getAppVersion() {
        PackageInfo packageInfo = getPackageInfo();
        return packageInfo == null ? "" : packageInfo.versionName;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getManufacturerAndModel() {
        if (TextUtils.isEmpty(this.mManufacturerAndModel)) {
            this.mManufacturerAndModel = Build.MANUFACTURER + "(" + Build.MODEL + ")";
        }
        return this.mManufacturerAndModel;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getSysRelease() {
        if (TextUtils.isEmpty(this.mRelease)) {
            this.mRelease = DeviceIDUtil.DEVICE_ID_PREFIX + Build.VERSION.RELEASE;
        }
        return this.mRelease;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getLanguage() {
        if (TextUtils.isEmpty(this.mLanguage)) {
            this.mLanguage = SystemUtils.getAcceptLanguage();
        }
        return this.mLanguage;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getCountryIso() {
        if (TextUtils.isEmpty(this.mCountryIso)) {
            this.mCountryIso = SystemUtils.getCountryIso(getContext());
        }
        return this.mCountryIso;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public boolean isDebugMode() {
        ApplicationInfo appInfo = getAppInfo();
        return (appInfo == null || (appInfo.flags & 2) == 0) ? false : true;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public SharedPreferences getSharedPreferences(String str, int i) {
        return getContext().getSharedPreferences(str, i);
    }
}
