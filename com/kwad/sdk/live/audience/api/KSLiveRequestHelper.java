package com.kwad.sdk.live.audience.api;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.n.a;
import com.dhylive.app.utils.JumpParam;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.KSLiveNetwork;
import com.kwad.sdk.live.audience.Utils;
import com.pandora.common.Constants;
import com.sigmob.sdk.base.e;
import com.sigmob.sdk.base.n;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveRequestHelper {
    private static void appendRequestCommonParams(Map<String, String> map, String str, long j) {
    }

    public static KSLiveRequest buildStartPlayRequest(String str, int i, String str2, String str3, String str4, long j) {
        HashMap map = new HashMap();
        map.put("author", str);
        map.put(n.l, String.valueOf(i));
        if (!TextUtils.isEmpty(str2)) {
            map.put("expTag", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put("reason", str3);
        }
        appendRequestCommonParams(map, str4, j);
        return new KSLiveRequest(KSLiveRequestPath.START_PLAY.path(), map, j, str4);
    }

    public static KSLiveRequest buildGetPlayUrlRequest(String str, String str2, long j) {
        HashMap map = new HashMap();
        map.put("author", str);
        appendRequestCommonParams(map, str2, j);
        return new KSLiveRequest(KSLiveRequestPath.GET_PLAY_URL.path(), map, j, str2);
    }

    public static KSLiveRequest buildGetNewProviderRequest(String str, String str2, long j) {
        HashMap map = new HashMap();
        map.put("author", str);
        appendRequestCommonParams(map, str2, j);
        return new KSLiveRequest(KSLiveRequestPath.GET_NEW_PROVIDER.path(), map, j, str2);
    }

    public static KSLiveRequest buildGetWatchingUsersRequest(String str, int i) {
        HashMap map = new HashMap();
        map.put("liveStreamId", str);
        map.put("sequenceId", String.valueOf(i));
        return new KSLiveRequest(KSLiveRequestPath.GET_WATCHING_USERS.path(), map, 0L, null);
    }

    public static KSLiveRequest buildGetTopUsersRequest(String str) {
        HashMap map = new HashMap();
        map.put("liveStreamId", str);
        return new KSLiveRequest(KSLiveRequestPath.GET_TOP_USERS.path(), map, 0L, null);
    }

    public static KSLiveRequest buildGetEndSummaryRequest(String str) {
        HashMap map = new HashMap();
        map.put("liveStreamId", str);
        return new KSLiveRequest(KSLiveRequestPath.GET_END_SUMMARY.path(), map, 0L, null);
    }

    public static KSLiveRequest buildStopLiveRequest(String str, String str2, long j) {
        HashMap map = new HashMap();
        map.put("liveStreamId", str);
        appendRequestCommonParams(map, str2, j);
        return new KSLiveRequest(KSLiveRequestPath.STOP_LIVE_PLAY.path(), map, j, str2);
    }

    public static KSLiveRequest buildGetFeedListRequest() {
        return new KSLiveRequest(KSLiveRequestPath.FEEDS_LIST.path(), new HashMap(), 0L, null);
    }

    public static KSLiveRequest buildGetFeedMoreRequest(String str) {
        HashMap map = new HashMap();
        map.put("pcursor", str);
        return new KSLiveRequest(KSLiveRequestPath.FEEDS_MORE.path(), map, 0L, null);
    }

    public static KSLiveRequest buildGetNewRaceRequest(String str) {
        HashMap map = new HashMap();
        map.put("liveStreamId", str);
        return new KSLiveRequest(KSLiveRequestPath.GET_NEW_RACE.path(), map, 0L, null);
    }

    public static Map<String, String> buildRequestHeader(String str, long j) {
        KSLiveHttpConfig kSLiveHttpConfig = KSLiveInitModule.getInstance().getKSLiveHttpConfig();
        HashMap map = new HashMap();
        map.put("Accept-Language", kSLiveHttpConfig.getAcceptLanguage());
        map.put("Connection", "keep-alive");
        map.put("REQUESTID", generateRequestId());
        String cookieString = getCookieString(str, j);
        if (!TextUtils.isEmpty(cookieString)) {
            map.put(e.b, cookieString);
        }
        return map;
    }

    public static Map<String, String> buildRequestUrlParams(long j) {
        KSLiveHttpConfig kSLiveHttpConfig = KSLiveInitModule.getInstance().getKSLiveHttpConfig();
        HashMap map = new HashMap();
        map.put("appver", kSLiveHttpConfig.getAppVersion());
        map.put("lat", kSLiveHttpConfig.getLatitude());
        map.put("lon", kSLiveHttpConfig.getLongitude());
        map.put("sys", kSLiveHttpConfig.getSystemVersion());
        map.put("ver", kSLiveHttpConfig.getVersion());
        map.put(Constants.APPLog.DEVICE_ID, kSLiveHttpConfig.getDeviceID());
        map.put("country_code", kSLiveHttpConfig.getCountryIso());
        map.put("language", kSLiveHttpConfig.getAcceptLanguage());
        map.put("kpn", kSLiveHttpConfig.getKpn());
        map.put("appId", kSLiveHttpConfig.getAppId());
        map.put("kpf", kSLiveHttpConfig.getKpf());
        map.put("egid", Utils.emptyIfNull(kSLiveHttpConfig.getEGid()));
        map.put(b.l, kSLiveHttpConfig.getBiz());
        if (j != 0) {
            map.put("ud", String.valueOf(j));
        }
        Context appContext = KSLiveInitModule.getInstance().getAppContext();
        map.put("net", KSLiveNetwork.getActiveNetworkTypeName(appContext));
        map.put("isp", getIsp(appContext));
        return map;
    }

    private static String generateRequestId() {
        return System.currentTimeMillis() + new DecimalFormat("00000").format(new Random().nextInt(KSTubeParamInner.FREE_ALL));
    }

    private static String getCookieString(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        HashMap map = new HashMap();
        map.put(JumpParam.USER_ID, String.valueOf(j));
        map.put("kuaishou.universeAd.live_st", str);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append(a.h);
            sb.append((String) entry.getValue());
            sb.append(';');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String getIsp(Context context) {
        return KSLiveNetwork.isMobileNetworkConnected(context) ? KSLiveNetwork.getIsp(context) : "";
    }
}
