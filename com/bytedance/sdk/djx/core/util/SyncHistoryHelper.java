package com.bytedance.sdk.djx.core.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.t.a;
import com.bytedance.sdk.djx.base.dynamic.DynamicManager;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.log.PartnerHelper;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.ev.BESettingUpdate;
import com.bytedance.sdk.djx.model.ev.BESyncHistory;
import com.bytedance.sdk.djx.net.UAUtil;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.io.Buffer;
import com.bytedance.sdk.djx.net.k3.Cache;
import com.bytedance.sdk.djx.net.k3.Call;
import com.bytedance.sdk.djx.net.k3.Callback;
import com.bytedance.sdk.djx.net.k3.FormBody;
import com.bytedance.sdk.djx.net.k3.OkHttpClient;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.RequestBody;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.ssl.TTHostNameVerifier;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.AES;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.Encrypt;
import com.bytedance.sdk.djx.utils.FileUtil;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.TimeDiff;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SyncHistoryHelper {
    private static final String HOST = "https://stream-sdk.feedcoopapi.com";
    private static final String TAG = "SyncHistoryHelper";
    private static final String URL_HISTORY = "https://stream-sdk.feedcoopapi.com/data/video/skit/recent";
    private static final String URL_REGISTER = "https://stream-sdk.feedcoopapi.com/access_token/register/wap/v4/";
    private static OkHttpClient sClient;
    private static final IBusListener sBusListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.util.SyncHistoryHelper.1
        public void onBusEvent(BusEvent busEvent) {
            if (busEvent instanceof BESyncHistory) {
                SyncHistoryHelper.doSyncTask();
                DJXBus.getInstance().removeListener(SyncHistoryHelper.sBusListener);
            }
        }
    };
    private static final IBusListener sSettingListener = new IBusListener() { // from class: com.bytedance.sdk.djx.core.util.SyncHistoryHelper.2
        public void onBusEvent(BusEvent busEvent) {
            if ((busEvent instanceof BESettingUpdate) && ((BESettingUpdate) busEvent).isOnline()) {
                SyncHistoryHelper.trySync();
                DJXBus.getInstance().removeListener(SyncHistoryHelper.sSettingListener);
            }
        }
    };

    private interface ISyncCallback {
        void onResult(boolean z, String str);
    }

    public static void init() {
        DJXBus.getInstance().addListener(sSettingListener);
    }

    public static void trySync() {
        if (TokenHelper.sHasSyncMark) {
            doSyncTask();
        } else {
            DJXBus.getInstance().addListener(sBusListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doSyncTask() {
        if (!SettingData.getInstance().isEnableSyncHistory()) {
            LG.d(TAG, "sync history stop by setting");
        } else if (!TokenHelper.getInstance().isSyncHistory()) {
            LG.d(TAG, "sync history stop by token");
        } else {
            registerByHuoshan();
        }
    }

    private static void registerByHuoshan() {
        String didOld = DeviceUtils.getDidOld();
        String lowerCase = Encrypt.getRandomString(7).toLowerCase();
        String strValueOf = String.valueOf(TimeDiff.getInstance().getServerTime() / 1000);
        String str = "https://stream-sdk.feedcoopapi.com/access_token/register/wap/v4/?nonce=" + lowerCase + "&timestamp=" + strValueOf + "&signature=" + Encrypt.sign(new String[]{lowerCase, DevInfo.sOldSecureKey, strValueOf, didOld}) + "&partner=" + DevInfo.sPartner;
        HashMap map = new HashMap();
        map.put("sdk_version", "5.0.0.0");
        map.put("uuid", didOld);
        map.put("oaid", DeviceUtils.getOaid());
        map.put("dev_log_aid", DevInfo.sAppId);
        post(str, map, new ISyncCallback() { // from class: com.bytedance.sdk.djx.core.util.SyncHistoryHelper.3
            @Override // com.bytedance.sdk.djx.core.util.SyncHistoryHelper.ISyncCallback
            public void onResult(boolean z, String str2) {
                try {
                    LG.d(SyncHistoryHelper.TAG, "get token huoshan: " + z + ", " + str2);
                    if (z) {
                        JSONObject jSONObjectBuild = JSON.build(str2);
                        if (JSON.getInt(jSONObjectBuild, "ret") == 0) {
                            SyncHistoryHelper.historyByHuoshan(JSON.getString(JSON.getJsonObject(jSONObjectBuild, "data"), "access_token"));
                        }
                    }
                } catch (Exception e) {
                    LG.e(SyncHistoryHelper.TAG, "get token huoshan error: ", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void historyByHuoshan(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "https://stream-sdk.feedcoopapi.com/data/video/skit/recent?partner=" + DevInfo.sPartner;
        HashMap map = new HashMap();
        String didOld = DeviceUtils.getDidOld();
        String lowerCase = Encrypt.getRandomString(7).toLowerCase();
        String strValueOf = String.valueOf(TimeDiff.getInstance().getServerTime() / 1000);
        String strSign = Encrypt.sign(new String[]{lowerCase, DevInfo.sOldSecureKey, strValueOf});
        map.put("sdk_version", "5.0.0.0");
        map.put("signature", strSign);
        map.put(a.k, strValueOf);
        map.put("nonce", lowerCase);
        map.put(b.z0, PartnerHelper.getPartner(null));
        map.put("access_token", str);
        map.put("dt", DeviceUtils.getModel());
        map.put("os_api", Build.VERSION.SDK_INT + "");
        map.put("ac", NetworkUtils.getNetworkTypeString(InnerManager.getContext()));
        map.put("uuid", didOld);
        map.put("type", DeviceUtils.guessDeviceType(InnerManager.getContext()) + "");
        map.put("os", "Android");
        map.put("os_version", DeviceUtils.getSystemVersion());
        map.put("device_brand", DeviceUtils.getDeviceBrand());
        map.put("clientVersion", ToolUtils.getVersionName());
        map.put("siteid", DynamicManager.getInstance().getInitSiteId());
        map.put("specific", ToolUtils.getVersionName());
        map.put("page", "0");
        map.put("num", "0");
        post(str2, map, new ISyncCallback() { // from class: com.bytedance.sdk.djx.core.util.SyncHistoryHelper.4
            @Override // com.bytedance.sdk.djx.core.util.SyncHistoryHelper.ISyncCallback
            public void onResult(boolean z, String str3) {
                try {
                    LG.d(SyncHistoryHelper.TAG, "get history huoshan: " + z + ", " + str3);
                    if (z) {
                        JSONObject jSONObjectBuild = JSON.build(str3);
                        if (JSON.getInt(jSONObjectBuild, "ret") == 0) {
                            SyncHistoryHelper.historySyncToDServer(JSON.getJsonArray(jSONObjectBuild, "data"));
                        }
                    }
                } catch (Exception e) {
                    LG.e(SyncHistoryHelper.TAG, "get history huoshan error: ", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void historySyncToDServer(JSONArray jSONArray) {
        JSONArray jSONArrayBuildArr = JSON.buildArr();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            JSONObject jSONObjectBuild = JSON.build();
            JSON.putLong(jSONObjectBuild, "shortplay_id", JSON.getLong(jSONObjectOptJSONObject, ILogConst.Keys.KEY_SKIT_ID));
            JSON.putInt(jSONObjectBuild, "index", JSON.getInt(jSONObjectOptJSONObject, "index"));
            JSON.putLong(jSONObjectBuild, "action_time", JSON.getLong(jSONObjectOptJSONObject, "action_time") / 1000);
            jSONArrayBuildArr.put(jSONObjectBuild);
        }
        DramaApi.syncHuoshanHistory(jSONArrayBuildArr, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.util.SyncHistoryHelper.5
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DramaActionRsp dramaActionRsp) {
            }
        });
    }

    private static void post(String str, Map<String, String> map, final ISyncCallback iSyncCallback) {
        try {
            String strSalt = Encrypt.salt(8);
            FormBody.Builder builder = new FormBody.Builder();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        builder.add(key, value);
                    }
                }
            }
            FormBody formBodyBuild = builder.build();
            Buffer buffer = new Buffer();
            try {
                formBodyBuild.writeTo(buffer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            client().newCall(new Request.Builder().url(str).addHeader("User-Agent", UAUtil.getUserAgent() + " dpsdk/5.0.0.0").addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).addHeader("Salt", strSalt).post(RequestBody.create(formBodyBuild.contentType(), Base64.encodeToString(AES.encrypt(buffer.readByteArray(), Encrypt.buildAesKey(DevInfo.sOldSecureKey, strSalt)), 0))).build()).enqueue(new Callback() { // from class: com.bytedance.sdk.djx.core.util.SyncHistoryHelper.6
                @Override // com.bytedance.sdk.djx.net.k3.Callback
                public void onFailure(Call call, IOException iOException) {
                    ISyncCallback iSyncCallback2 = iSyncCallback;
                    if (iSyncCallback2 != null) {
                        iSyncCallback2.onResult(false, null);
                    }
                }

                @Override // com.bytedance.sdk.djx.net.k3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        if (response.isSuccessful()) {
                            String str2 = new String(AES.decrypt(Base64.decode(response.body().bytes(), 0), Encrypt.buildAesKey(DevInfo.sOldSecureKey, response.header("Salt"))));
                            ISyncCallback iSyncCallback2 = iSyncCallback;
                            if (iSyncCallback2 != null) {
                                iSyncCallback2.onResult(true, str2);
                            }
                        } else {
                            ISyncCallback iSyncCallback3 = iSyncCallback;
                            if (iSyncCallback3 != null) {
                                iSyncCallback3.onResult(false, null);
                            }
                        }
                    } catch (Exception unused) {
                        ISyncCallback iSyncCallback4 = iSyncCallback;
                        if (iSyncCallback4 != null) {
                            iSyncCallback4.onResult(false, null);
                        }
                    }
                }
            });
        } catch (Exception unused) {
            if (iSyncCallback != null) {
                iSyncCallback.onResult(false, null);
            }
        }
    }

    private static OkHttpClient client() {
        File netCache = FileUtil.getNetCache(InnerManager.getContext());
        if (sClient == null) {
            sClient = new OkHttpClient.Builder().cache(new Cache(netCache, 20971520L)).hostnameVerifier(TTHostNameVerifier.INSTANCE).connectTimeout(15L, TimeUnit.SECONDS).readTimeout(25L, TimeUnit.SECONDS).writeTimeout(25L, TimeUnit.SECONDS).build();
        }
        return sClient;
    }
}
