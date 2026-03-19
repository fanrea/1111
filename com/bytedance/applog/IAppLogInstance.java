package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.event.EventBuilder;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.applog.exposure.ViewExposureManager;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.oneid.IDBindCallback;
import com.bytedance.applog.profile.UserProfileCallback;
import com.bytedance.bdtracker.b1;
import com.bytedance.bdtracker.f;
import com.bytedance.bdtracker.i2;
import com.bytedance.bdtracker.t3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IAppLogInstance {
    void activateALink(Uri uri);

    void addDataObserver(IDataObserver iDataObserver);

    void addEventObserver(IEventObserver iEventObserver);

    void addEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver);

    String addNetCommonParams(Context context, String str, boolean z, Level level);

    void addSessionHook(ISessionObserver iSessionObserver);

    void bind(Map<String, String> map, IDBindCallback iDBindCallback);

    void clearAbTestConfigsCache();

    void clearDb();

    void flush();

    IALinkListener getALinkListener();

    <T> T getAbConfig(String str, T t);

    String getAbSdkVersion();

    IActiveCustomParamsCallback getActiveCustomParams();

    @Deprecated
    String getAid();

    JSONObject getAllAbTestConfigs();

    f getAppContext();

    String getAppId();

    String getClientUdid();

    Context getContext();

    String getDeepLinkUrl();

    String getDid();

    boolean getEncryptAndCompress();

    b1 getEventFilterByClient();

    IEventHandler getEventHandler();

    JSONObject getHeader();

    IHeaderCustomTimelyCallback getHeaderCustomCallback();

    <T> T getHeaderValue(String str, T t, Class<T> cls);

    String getIid();

    InitConfig getInitConfig();

    int getLaunchFrom();

    i2 getMonitor();

    INetworkClient getNetClient();

    String getOpenUdid();

    Map<String, String> getRequestHeader();

    String getSdkVersion();

    String getSessionId();

    String getSsid();

    void getSsidGroup(Map<String, String> map);

    String getUdid();

    UriConfig getUriRuntime();

    String getUserID();

    String getUserUniqueID();

    ViewExposureManager getViewExposureManager();

    JSONObject getViewProperties(View view);

    boolean hasStarted();

    void ignoreAutoTrackClick(View view);

    void ignoreAutoTrackClickByViewType(Class<?>... clsArr);

    void ignoreAutoTrackPage(Class<?>... clsArr);

    void init(Context context, InitConfig initConfig);

    void init(Context context, InitConfig initConfig, Activity activity);

    void initH5Bridge(View view, String str);

    void initMetaSec(Context context);

    void initWebViewBridge(View view, String str);

    boolean isAutoTrackClickIgnored(View view);

    boolean isAutoTrackPageIgnored(Class<?> cls);

    boolean isBavEnabled();

    boolean isH5BridgeEnable();

    boolean isH5CollectEnable();

    boolean isNewUser();

    boolean isPrivacyMode();

    boolean manualActivate();

    EventBuilder newEvent(String str);

    void onActivityPause();

    void onActivityResumed(Activity activity, int i);

    void onEventV3(String str);

    void onEventV3(String str, Bundle bundle);

    void onEventV3(String str, Bundle bundle, int i);

    void onEventV3(String str, JSONObject jSONObject);

    void onEventV3(String str, JSONObject jSONObject, int i);

    void onMiscEvent(String str, JSONObject jSONObject);

    void onPause(Context context);

    void onResume(Context context);

    void pauseDurationEvent(String str);

    void profileAppend(JSONObject jSONObject);

    void profileIncrement(JSONObject jSONObject);

    void profileSet(JSONObject jSONObject);

    void profileSetOnce(JSONObject jSONObject);

    void profileUnset(String str);

    void pullAbTestConfigs();

    void pullAbTestConfigs(int i, IPullAbTestConfigCallback iPullAbTestConfigCallback);

    void putCommonParams(Context context, Map<String, String> map, boolean z, Level level);

    void receive(t3 t3Var);

    void receive(String[] strArr);

    void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback);

    void removeAllDataObserver();

    void removeDataObserver(IDataObserver iDataObserver);

    void removeEventObserver(IEventObserver iEventObserver);

    void removeEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver);

    void removeHeaderInfo(String str);

    void removeOaidObserver(IOaidObserver iOaidObserver);

    void removeSessionHook(ISessionObserver iSessionObserver);

    @Deprecated
    boolean reportPhoneDetailInfo();

    void resumeDurationEvent(String str);

    void setALinkListener(IALinkListener iALinkListener);

    void setAccount(Account account);

    void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback);

    void setAppContext(f fVar);

    void setAppLanguageAndRegion(String str, String str2);

    void setAppTrack(JSONObject jSONObject);

    void setClipboardEnabled(boolean z);

    void setEncryptAndCompress(boolean z);

    void setEventFilterByClient(List<String> list, boolean z);

    void setEventHandler(IEventHandler iEventHandler);

    void setExternalAbVersion(String str);

    void setExtraParams(IExtraParams iExtraParams);

    @Deprecated
    void setForbidReportPhoneDetailInfo(boolean z);

    void setGPSLocation(float f, float f2, String str);

    void setGoogleAid(String str);

    void setHeaderInfo(String str, Object obj);

    void setHeaderInfo(HashMap<String, Object> map);

    void setLaunchFrom(int i);

    void setOaidObserver(IOaidObserver iOaidObserver);

    void setPrivacyMode(boolean z);

    void setPullAbTestConfigsThrottleMills(Long l);

    void setRangersEventVerifyEnable(boolean z, String str);

    void setTouchPoint(String str);

    void setTracerData(JSONObject jSONObject);

    void setUriRuntime(UriConfig uriConfig);

    void setUserAgent(String str);

    void setUserID(long j);

    void setUserUniqueID(String str);

    void setUserUniqueID(String str, String str2);

    void setViewId(Dialog dialog, String str);

    void setViewId(View view, String str);

    void setViewId(Object obj, String str);

    void setViewProperties(View view, JSONObject jSONObject);

    void start();

    void startDurationEvent(String str);

    void startSimulator(String str);

    void stopDurationEvent(String str, JSONObject jSONObject);

    void trackClick(View view);

    void trackClick(View view, JSONObject jSONObject);

    void trackPage(Activity activity);

    void trackPage(Activity activity, JSONObject jSONObject);

    void trackPage(Object obj);

    void trackPage(Object obj, JSONObject jSONObject);

    void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback);

    void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback);
}
