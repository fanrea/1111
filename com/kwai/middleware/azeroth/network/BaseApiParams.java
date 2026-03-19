package com.kwai.middleware.azeroth.network;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.dhylive.app.utils.JumpParam;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.configs.InitCommonParams;
import com.kwai.middleware.azeroth.utils.NetworkUtils;
import com.kwai.middleware.azeroth.utils.SignatureUtil;
import com.pandora.common.Constants;
import com.sigmob.sdk.base.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class BaseApiParams extends AzerothApiParams {
    private List<AzerothApiParams> mApiParamsList = new ArrayList();

    public BaseApiParams addApiParams(AzerothApiParams azerothApiParams) {
        if (azerothApiParams != null) {
            this.mApiParamsList.add(azerothApiParams);
        }
        return this;
    }

    @Override // com.kwai.middleware.azeroth.network.AzerothApiParams
    public Map<String, String> getHeaders() {
        HashMap map = new HashMap();
        map.put("Accept-Language", Azeroth.get().getCommonParams().getLanguage());
        map.put(NetworkDefine.HEADER_REQUEST_ID, String.valueOf(SystemClock.elapsedRealtime()));
        map.put("Connection", "keep-alive");
        HashMap map2 = new HashMap();
        processCookieMap(map2);
        String cookieString = toCookieString(map2);
        if (!TextUtils.isEmpty(cookieString)) {
            map.put(e.b, cookieString);
        }
        for (AzerothApiParams azerothApiParams : this.mApiParamsList) {
            if (azerothApiParams != null) {
                map.putAll(azerothApiParams.getHeaders());
            }
        }
        return map;
    }

    @Override // com.kwai.middleware.azeroth.network.AzerothApiParams
    public void processCookieMap(Map<String, String> map) {
        InitCommonParams commonParams = Azeroth.get().getCommonParams();
        String passportServiceToken = commonParams.getPassportServiceToken();
        String passportServiceID = commonParams.getPassportServiceID();
        if (!TextUtils.isEmpty(passportServiceID) && !TextUtils.isEmpty(passportServiceToken)) {
            map.put(passportServiceID + NetworkDefine.SUFFIX_SERVICE_TOKEN, passportServiceToken);
        }
        for (AzerothApiParams azerothApiParams : this.mApiParamsList) {
            if (azerothApiParams != null) {
                azerothApiParams.processCookieMap(map);
            }
        }
    }

    public String toCookieString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(a.h);
            sb.append(entry.getValue());
            sb.append("; ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override // com.kwai.middleware.azeroth.network.AzerothApiParams
    public Map<String, String> getUrlParams() {
        HashMap map = new HashMap();
        InitCommonParams commonParams = Azeroth.get().getCommonParams();
        map.put("kpn", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getProductName()));
        map.put("packageName", Azeroth.get().getContext().getPackageName());
        map.put("appId", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getAppId()));
        map.put("kpf", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getPlatform()));
        map.put("appver", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getAppVersion()));
        map.put("gid", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getGlobalId()));
        if (commonParams.isDebugMode() && com.kwai.middleware.azeroth.utils.TextUtils.isEmpty(commonParams.getDeviceId())) {
            throw new IllegalStateException("device id cannot be null when API request");
        }
        map.put(Constants.APPLog.DEVICE_ID, com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getDeviceId()));
        map.put(JumpParam.USER_ID, com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getUserId()));
        if (android.support.v4.content.a.b(Azeroth.get().getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            String strValueOf = String.valueOf(commonParams.getLatitude());
            String strValueOf2 = String.valueOf(commonParams.getLongitude());
            map.put("lat", strValueOf);
            map.put("lon", strValueOf2);
        }
        map.put("mod", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getManufacturerAndModel()));
        map.put("net", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(NetworkUtils.getSimpleActiveNetworkTypeName(Azeroth.get().getContext())));
        map.put("sys", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getSysRelease()));
        map.put("os", "android");
        map.put("c", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getChannel()));
        map.put("language", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getLanguage()));
        map.put("countryCode", com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(commonParams.getCountryIso()));
        for (AzerothApiParams azerothApiParams : this.mApiParamsList) {
            if (azerothApiParams != null) {
                map.putAll(azerothApiParams.getUrlParams());
            }
        }
        return map;
    }

    @Override // com.kwai.middleware.azeroth.network.AzerothApiParams
    public Map<String, String> getPostParams() {
        HashMap map = new HashMap();
        for (AzerothApiParams azerothApiParams : this.mApiParamsList) {
            if (azerothApiParams != null) {
                map.putAll(azerothApiParams.getPostParams());
            }
        }
        return map;
    }

    @Override // com.kwai.middleware.azeroth.network.AzerothApiParams
    public String processSignature(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        String strCreateSignature;
        String passportServiceSecurity = Azeroth.get().getCommonParams().getPassportServiceSecurity();
        if (com.kwai.middleware.azeroth.utils.TextUtils.isEmpty(passportServiceSecurity)) {
            strCreateSignature = "";
        } else {
            strCreateSignature = SignatureUtil.createSignature(str, str2, map, map2, passportServiceSecurity);
            map2.put(NetworkDefine.PARAM_CLIENT_SIGN, strCreateSignature);
        }
        for (AzerothApiParams azerothApiParams : this.mApiParamsList) {
            if (azerothApiParams != null) {
                azerothApiParams.processSignature(str, str2, map, map2);
            }
        }
        return strCreateSignature;
    }
}
