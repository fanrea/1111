package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.event.EventBuilder;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.applog.exposure.ViewExposureManager;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.oneid.IDBindCallback;
import com.bytedance.applog.profile.UserProfileCallback;
import com.bytedance.bdtracker.d;
import com.bytedance.bdtracker.f;
import com.bytedance.bdtracker.l0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AppLog {
    public static final IAppLogInstance a = newInstance();
    public static volatile boolean b = false;

    public static void activateALink(Uri uri) {
        a.activateALink(uri);
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        a.addDataObserver(iDataObserver);
    }

    public static void addEventObserver(IEventObserver iEventObserver) {
        a.addEventObserver(iEventObserver);
    }

    public static void addEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        a.addEventObserver(iEventObserver, iPresetEventObserver);
    }

    public static String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return a.addNetCommonParams(context, str, z, level);
    }

    public static void addSessionHook(ISessionObserver iSessionObserver) {
        a.addSessionHook(iSessionObserver);
    }

    public static void bind(Map<String, String> map, IDBindCallback iDBindCallback) {
        a.bind(map, iDBindCallback);
    }

    public static void clearDb() {
        a.clearDb();
    }

    public static void flush() {
        a.flush();
    }

    public static <T> T getAbConfig(String str, T t) {
        return (T) a.getAbConfig(str, t);
    }

    public static String getAbSdkVersion() {
        return a.getAbSdkVersion();
    }

    public static IActiveCustomParamsCallback getActiveCustomParams() {
        return a.getActiveCustomParams();
    }

    @Deprecated
    public static String getAid() {
        return a.getAid();
    }

    public static JSONObject getAllAbTestConfigs() {
        return a.getAllAbTestConfigs();
    }

    public static f getAppContext() {
        return a.getAppContext();
    }

    public static String getAppId() {
        return a.getAppId();
    }

    public static String getClientUdid() {
        return a.getClientUdid();
    }

    public static Context getContext() {
        return a.getContext();
    }

    public static String getDid() {
        return a.getDid();
    }

    public static boolean getEncryptAndCompress() {
        return a.getEncryptAndCompress();
    }

    public static JSONObject getHeader() {
        return a.getHeader();
    }

    public static IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return a.getHeaderCustomCallback();
    }

    public static <T> T getHeaderValue(String str, T t, Class<T> cls) {
        return (T) a.getHeaderValue(str, t, cls);
    }

    public static String getIid() {
        return a.getIid();
    }

    public static InitConfig getInitConfig() {
        return a.getInitConfig();
    }

    public static IAppLogInstance getInstance() {
        return a;
    }

    public static INetworkClient getNetClient() {
        return a.getNetClient();
    }

    public static String getOpenUdid() {
        return a.getOpenUdid();
    }

    public static Map<String, String> getRequestHeader() {
        return a.getRequestHeader();
    }

    public static String getSdkVersion() {
        return a.getSdkVersion();
    }

    public static String getSessionId() {
        return a.getSessionId();
    }

    public static String getSsid() {
        return a.getSsid();
    }

    public static void getSsidGroup(Map<String, String> map) {
        a.getSsidGroup(map);
    }

    public static String getUdid() {
        return a.getUdid();
    }

    public static UriConfig getUriRuntime() {
        return a.getUriRuntime();
    }

    public static String getUserID() {
        return a.getUserID();
    }

    public static String getUserUniqueID() {
        return a.getUserUniqueID();
    }

    public static ViewExposureManager getViewExposureManager() {
        return a.getViewExposureManager();
    }

    public static JSONObject getViewProperties(View view) {
        return a.getViewProperties(view);
    }

    public static boolean hasStarted() {
        return a.hasStarted();
    }

    public static void ignoreAutoTrackClick(View view) {
        a.ignoreAutoTrackClick(view);
    }

    public static void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        a.ignoreAutoTrackClickByViewType(clsArr);
    }

    public static void ignoreAutoTrackPage(Class<?>... clsArr) {
        a.ignoreAutoTrackPage(clsArr);
    }

    public static void init(Context context, InitConfig initConfig) {
        synchronized (AppLog.class) {
            if (l0.b.a(b, "Default AppLog is initialized, please create another instance by `AppLog.newInstance()`")) {
                return;
            }
            b = true;
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName("applog_stats");
            }
            a.init(context, initConfig);
        }
    }

    public static void init(Context context, InitConfig initConfig, Activity activity) {
        synchronized (AppLog.class) {
            if (l0.b.a(b, "Default AppLog is initialized, please create another instance by `new AppLogInstance()`")) {
                return;
            }
            b = true;
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName("applog_stats");
            }
            a.init(context, initConfig, activity);
        }
    }

    public static void initH5Bridge(View view, String str) {
        a.initH5Bridge(view, str);
    }

    public static void initWebViewBridge(View view, String str) {
        a.initWebViewBridge(view, str);
    }

    public static boolean isAutoTrackClickIgnored(View view) {
        return a.isAutoTrackClickIgnored(view);
    }

    public static boolean isAutoTrackPageIgnored(Class<?> cls) {
        return a.isAutoTrackPageIgnored(cls);
    }

    public static boolean isH5BridgeEnable() {
        return a.isH5BridgeEnable();
    }

    public static boolean isH5CollectEnable() {
        return a.isH5CollectEnable();
    }

    public static boolean isNewUser() {
        return a.isNewUser();
    }

    public static boolean isPrivacyMode() {
        return a.isPrivacyMode();
    }

    public static boolean manualActivate() {
        return a.manualActivate();
    }

    public static EventBuilder newEvent(String str) {
        return a.newEvent(str);
    }

    public static IAppLogInstance newInstance() {
        return new d();
    }

    public static void onActivityPause() {
        a.onActivityPause();
    }

    public static void onActivityResumed(Activity activity, int i) {
        a.onActivityResumed(activity, i);
    }

    public static void onEventV3(String str) {
        a.onEventV3(str);
    }

    public static void onEventV3(String str, Bundle bundle) {
        a.onEventV3(str, bundle);
    }

    public static void onEventV3(String str, Bundle bundle, int i) {
        a.onEventV3(str, bundle, i);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        a.onEventV3(str, jSONObject);
    }

    public static void onEventV3(String str, JSONObject jSONObject, int i) {
        a.onEventV3(str, jSONObject, i);
    }

    public static void onMiscEvent(String str, JSONObject jSONObject) {
        a.onMiscEvent(str, jSONObject);
    }

    public static void onPause(Context context) {
        a.onPause(context);
    }

    public static void onResume(Context context) {
        a.onResume(context);
    }

    public static void pauseDurationEvent(String str) {
        a.pauseDurationEvent(str);
    }

    public static void profileAppend(JSONObject jSONObject) {
        a.profileAppend(jSONObject);
    }

    public static void profileIncrement(JSONObject jSONObject) {
        a.profileIncrement(jSONObject);
    }

    public static void profileSet(JSONObject jSONObject) {
        a.profileSet(jSONObject);
    }

    public static void profileSetOnce(JSONObject jSONObject) {
        a.profileSetOnce(jSONObject);
    }

    public static void profileUnset(String str) {
        a.profileUnset(str);
    }

    public static void pullAbTestConfigs() {
        a.pullAbTestConfigs();
    }

    public static void pullAbTestConfigs(int i, IPullAbTestConfigCallback iPullAbTestConfigCallback) {
        a.pullAbTestConfigs(i, iPullAbTestConfigCallback);
    }

    public static void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        a.putCommonParams(context, map, z, level);
    }

    public static void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        a.registerHeaderCustomCallback(iHeaderCustomTimelyCallback);
    }

    public static void removeAllDataObserver() {
        a.removeAllDataObserver();
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        a.removeDataObserver(iDataObserver);
    }

    public static void removeEventObserver(IEventObserver iEventObserver) {
        a.removeEventObserver(iEventObserver);
    }

    public static void removeEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        a.removeEventObserver(iEventObserver, iPresetEventObserver);
    }

    public static void removeHeaderInfo(String str) {
        a.removeHeaderInfo(str);
    }

    public static void removeOaidObserver(IOaidObserver iOaidObserver) {
        a.removeOaidObserver(iOaidObserver);
    }

    public static void removeSessionHook(ISessionObserver iSessionObserver) {
        a.removeSessionHook(iSessionObserver);
    }

    @Deprecated
    public static boolean reportPhoneDetailInfo() {
        return a.reportPhoneDetailInfo();
    }

    public static void resumeDurationEvent(String str) {
        a.resumeDurationEvent(str);
    }

    public static void setALinkListener(IALinkListener iALinkListener) {
        a.setALinkListener(iALinkListener);
    }

    public static void setAccount(Account account) {
        a.setAccount(account);
    }

    public static void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        a.setActiveCustomParams(iActiveCustomParamsCallback);
    }

    public static void setAppContext(f fVar) {
        a.setAppContext(fVar);
    }

    public static void setAppLanguageAndRegion(String str, String str2) {
        a.setAppLanguageAndRegion(str, str2);
    }

    public static void setAppTrack(JSONObject jSONObject) {
        a.setAppTrack(jSONObject);
    }

    public static void setClipboardEnabled(boolean z) {
        a.setClipboardEnabled(z);
    }

    public static void setDevToolsEnable(boolean z) {
        LogUtils.setEnable(z);
    }

    public static void setEncryptAndCompress(boolean z) {
        a.setEncryptAndCompress(z);
    }

    public static void setEventFilterByClient(List<String> list, boolean z) {
        a.setEventFilterByClient(list, z);
    }

    public static void setEventHandler(IEventHandler iEventHandler) {
        a.setEventHandler(iEventHandler);
    }

    public static void setExternalAbVersion(String str) {
        a.setExternalAbVersion(str);
    }

    public static void setExtraParams(IExtraParams iExtraParams) {
        a.setExtraParams(iExtraParams);
    }

    @Deprecated
    public static void setForbidReportPhoneDetailInfo(boolean z) {
        a.setForbidReportPhoneDetailInfo(z);
    }

    public static void setGPSLocation(float f, float f2, String str) {
        a.setGPSLocation(f, f2, str);
    }

    public static void setGoogleAid(String str) {
        a.setGoogleAid(str);
    }

    public static void setHeaderInfo(String str, Object obj) {
        a.setHeaderInfo(str, obj);
    }

    public static void setHeaderInfo(HashMap<String, Object> map) {
        a.setHeaderInfo(map);
    }

    public static void setOaidObserver(IOaidObserver iOaidObserver) {
        a.setOaidObserver(iOaidObserver);
    }

    public static void setPrivacyMode(boolean z) {
        a.setPrivacyMode(z);
    }

    public static void setPullAbTestConfigsThrottleMills(Long l) {
        a.setPullAbTestConfigsThrottleMills(l);
    }

    public static void setRangersEventVerifyEnable(boolean z, String str) {
        a.setRangersEventVerifyEnable(z, str);
    }

    public static void setTouchPoint(String str) {
        a.setTouchPoint(str);
    }

    public static void setTracerData(JSONObject jSONObject) {
        a.setTracerData(jSONObject);
    }

    public static void setUriRuntime(UriConfig uriConfig) {
        a.setUriRuntime(uriConfig);
    }

    public static void setUserAgent(String str) {
        a.setUserAgent(str);
    }

    public static void setUserID(long j) {
        a.setUserID(j);
    }

    public static void setUserUniqueID(String str) {
        a.setUserUniqueID(str);
    }

    public static void setUserUniqueID(String str, String str2) {
        a.setUserUniqueID(str, str2);
    }

    public static void setViewId(Dialog dialog, String str) {
        a.setViewId(dialog, str);
    }

    public static void setViewId(View view, String str) {
        a.setViewId(view, str);
    }

    public static void setViewId(Object obj, String str) {
        a.setViewId(obj, str);
    }

    public static void setViewProperties(View view, JSONObject jSONObject) {
        a.setViewProperties(view, jSONObject);
    }

    public static void start() {
        a.start();
    }

    public static void startDurationEvent(String str) {
        a.startDurationEvent(str);
    }

    public static void startSimulator(String str) {
        a.startSimulator(str);
    }

    public static void stopDurationEvent(String str, JSONObject jSONObject) {
        a.stopDurationEvent(str, jSONObject);
    }

    public static void trackClick(View view) {
        a.trackClick(view);
    }

    public static void trackClick(View view, JSONObject jSONObject) {
        a.trackClick(view, jSONObject);
    }

    public static void trackPage(Activity activity) {
        a.trackPage(activity);
    }

    public static void trackPage(Activity activity, JSONObject jSONObject) {
        a.trackPage(activity, jSONObject);
    }

    public static void trackPage(Object obj) {
        a.trackPage(obj);
    }

    public static void trackPage(Object obj, JSONObject jSONObject) {
        a.trackPage(obj, jSONObject);
    }

    public static void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        a.userProfileSetOnce(jSONObject, userProfileCallback);
    }

    public static void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        a.userProfileSync(jSONObject, userProfileCallback);
    }
}
