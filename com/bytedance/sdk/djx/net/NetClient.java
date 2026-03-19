package com.bytedance.sdk.djx.net;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.t.a;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.bytedance.sdk.djx.net.k3.Cache;
import com.bytedance.sdk.djx.net.k3.Call;
import com.bytedance.sdk.djx.net.k3.Dispatcher;
import com.bytedance.sdk.djx.net.k3.Interceptor;
import com.bytedance.sdk.djx.net.k3.OkHttpClient;
import com.bytedance.sdk.djx.net.req.k.EncryptInterceptor;
import com.bytedance.sdk.djx.net.req.k.OkGetBuilder;
import com.bytedance.sdk.djx.net.req.k.OkPostBuilder;
import com.bytedance.sdk.djx.net.req.k.TNCInterceptor;
import com.bytedance.sdk.djx.net.req.k.UAInterceptor;
import com.bytedance.sdk.djx.net.ssl.TTHostNameVerifier;
import com.bytedance.sdk.djx.utils.AppSignUtils;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.FileUtil;
import com.bytedance.sdk.djx.utils.HostContext;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.Utils;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class NetClient {
    private static final int CACHE_MAX_SIZE = 20971520;
    private static final int MAX_REFLECTION_ATTEMPTS = 3;
    private static final String TAG = "NetClient";
    private static String sDpSdkVersion = "";
    private static volatile NetClient sInstance;
    private static int sReflectionAttempts;
    private final Handler mDelivery = new Handler(Looper.getMainLooper());
    private INetInitInject mInject;
    private OkHttpClient mOkHttpClient;

    public static NetClient getInstance() {
        if (sInstance == null) {
            synchronized (NetClient.class) {
                if (sInstance == null) {
                    sInstance = new NetClient();
                }
            }
        }
        return sInstance;
    }

    public void init(List<Interceptor> list, INetInitInject iNetInitInject) {
        File netCache = FileUtil.getNetCache(InnerManager.getContext());
        this.mInject = iNetInitInject;
        OkHttpClient.Builder builderWriteTimeout = new OkHttpClient.Builder().cache(new Cache(netCache, 20971520L)).hostnameVerifier(TTHostNameVerifier.INSTANCE).connectTimeout(15L, TimeUnit.SECONDS).addNetworkInterceptor(UAInterceptor.DEFAULT()).addInterceptor(TNCInterceptor.DEFAULT()).readTimeout(25L, TimeUnit.SECONDS).writeTimeout(25L, TimeUnit.SECONDS);
        Iterator<Interceptor> it = list.iterator();
        while (it.hasNext()) {
            builderWriteTimeout.addInterceptor(it.next());
        }
        this.mOkHttpClient = builderWriteTimeout.build();
    }

    public INetInitInject getInject() {
        return this.mInject;
    }

    private NetClient() {
    }

    public Handler getDelivery() {
        return this.mDelivery;
    }

    public OkHttpClient getOkHttpClient() {
        if (this.mOkHttpClient == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(EncryptInterceptor.build(DevInfo.sPartner));
            getInstance().init(arrayList, this.mInject);
            LG.e(TAG, "mOkHttpClient = null");
        }
        return this.mOkHttpClient;
    }

    public static OkGetBuilder get() {
        return new OkGetBuilder(getInstance().getOkHttpClient(), getInstance().getDelivery(), new ISendRequestLogCallback() { // from class: com.bytedance.sdk.djx.net.NetClient.1
            @Override // com.bytedance.sdk.djx.net.ISendRequestLogCallback
            public void sendRequestLog(String str, long j, boolean z, String str2) {
                RequestLogUtil.sendRequestLog(str, j, z, str2);
            }
        });
    }

    public static OkPostBuilder post() {
        return new OkPostBuilder(getInstance().getOkHttpClient(), getInstance().getDelivery(), new ISendRequestLogCallback() { // from class: com.bytedance.sdk.djx.net.NetClient.2
            @Override // com.bytedance.sdk.djx.net.ISendRequestLogCallback
            public void sendRequestLog(String str, long j, boolean z, String str2) {
                RequestLogUtil.sendRequestLog(str, j, z, str2);
            }
        });
    }

    public void cancelAll() {
        this.mOkHttpClient.dispatcher().cancelAll();
    }

    public void cancel(String str) {
        Dispatcher dispatcher;
        if (TextUtils.isEmpty(str) || (dispatcher = this.mOkHttpClient.dispatcher()) == null) {
            return;
        }
        for (Call call : dispatcher.queuedCalls()) {
            if (str.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call2 : dispatcher.runningCalls()) {
            if (str.equals(call2.request().tag())) {
                call2.cancel();
            }
        }
    }

    private static String getDpSdkVersion() {
        if (!TextUtils.isEmpty(sDpSdkVersion)) {
            return sDpSdkVersion;
        }
        int i = sReflectionAttempts + 1;
        sReflectionAttempts = i;
        if (i > 3) {
            LG.i(TAG, "尝试 3 次反射获取 DPSdk 版本号失败");
            return sDpSdkVersion;
        }
        try {
            sDpSdkVersion = (String) Class.forName("com.bytedance.sdk.dp.DPSdk1").getMethod(IFunc.IVK_VERSION, new Class[0]).invoke(null, new Object[0]);
            LG.i(TAG, "DPSdk 版本号: " + sDpSdkVersion);
        } catch (Exception unused) {
        }
        return sDpSdkVersion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map<String, String> getCommonParams() {
        HashMap map = new HashMap();
        map.put("siteid", DevInfo.sSiteId);
        map.put("dev_log_aid", DevInfo.sAppId);
        map.put("uuid", DeviceUtils.getDid());
        map.put("uuid_type", "bddid");
        if (getInstance().getInject() != null) {
            String playerVersion = getInstance().getInject().getPlayerVersion();
            if (TextUtils.isEmpty(playerVersion)) {
                playerVersion = "0.0.0.0";
            }
            map.put("vod_version", playerVersion);
        } else {
            map.put("vod_version", "0.0.0.0");
        }
        String dpSdkVersion = getDpSdkVersion();
        if (!TextUtils.isEmpty(dpSdkVersion)) {
            map.put("dp_sdk_version", dpSdkVersion);
        } else {
            map.put("dp_sdk_version", "0.0.0.0");
        }
        map.put("sdk_version", "2.9.0.2");
        map.put("type", String.valueOf(DeviceUtils.guessDeviceType(HostContext.getContext())));
        map.put("dt", DeviceUtils.getModel());
        map.put("os", "Android");
        map.put("os_version", DeviceUtils.getSystemVersion());
        map.put("ac", NetworkUtils.getNetworkTypeString(HostContext.getContext()));
        map.put("resolution", String.format(Locale.getDefault(), "%d*%d", Integer.valueOf(UIUtil.getScreenWidth(InnerManager.getContext())), Integer.valueOf(UIUtil.getScreenHeight(InnerManager.getContext()))));
        map.put("device_brand", DeviceUtils.getDeviceBrand());
        map.put("os_api", Build.VERSION.SDK_INT + "");
        map.put(a.k, String.valueOf(System.currentTimeMillis() / 1000));
        map.put("oaid", DeviceUtils.getOaid());
        map.put("openudid", DeviceUtils.getAndroidId());
        map.put("clientVersion", ToolUtils.getVersionName());
        map.put("install_id", DeviceUtils.getInstallId());
        map.put("plugin_mode", (Utils.pluginMode() ? 1 : 0) + "");
        map.put(n.p, ToolUtils.getPackageName());
        map.put("sha1", AppSignUtils.getFirstSignSHA1());
        map.put("is_teenager", DevInfo.getPrivacyController().isTeenagerMode() ? "1" : "0");
        if (getInstance().getInject() == null || !getInstance().getInject().isDidDegrade()) {
            map.put("sdk_did", DeviceUtils.getLocalDid());
        }
        map.put("exist_icp_number", DevInfo.getPrivacyController().isOnlyICPNumber() ? "1" : "0");
        return map;
    }
}
