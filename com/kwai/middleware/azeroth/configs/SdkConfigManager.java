package com.kwai.middleware.azeroth.configs;

import android.util.Log;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.AzerothStorage;
import com.kwai.middleware.azeroth.utils.Callback;
import com.kwai.middleware.azeroth.utils.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SdkConfigManager implements ISdkConfigManager {
    private static final String PATH_CONFIG = "/rest/zt/appsupport/configs";
    private static final String TAG = "SdkConfigManager";
    private final Map<String, List<OnConfigChangedListener>> mChangedListenerListMap;
    private Executor mExecutor;
    private volatile Map<String, String> mSdkConfigs;

    private SdkConfigManager() {
        this.mChangedListenerListMap = new ConcurrentHashMap();
        this.mExecutor = Executors.newSingleThreadExecutor();
    }

    public static SdkConfigManager get() {
        return Holder.sInstance;
    }

    @Override // com.kwai.middleware.azeroth.configs.ISdkConfigManager
    public String getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ensureInited();
        return this.mSdkConfigs == null ? "" : TextUtils.emptyIfNull(this.mSdkConfigs.get(str));
    }

    @Override // com.kwai.middleware.azeroth.configs.ISdkConfigManager
    public void addConfigChangeListener(String str, OnConfigChangedListener onConfigChangedListener) {
        if (onConfigChangedListener == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.mChangedListenerListMap) {
            List<OnConfigChangedListener> arrayList = this.mChangedListenerListMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mChangedListenerListMap.put(str, arrayList);
            }
            arrayList.add(onConfigChangedListener);
        }
    }

    public void init() {
        requestSdkConfigAsync();
    }

    private void ensureInited() {
        if (this.mSdkConfigs == null) {
            synchronized (this) {
                if (this.mSdkConfigs == null) {
                    setSdkConfigs(AzerothStorage.get().getSdkConfigMap());
                }
            }
        }
    }

    private void requestSdkConfigAsync() {
        this.mExecutor.execute(new Runnable() { // from class: com.kwai.middleware.azeroth.configs.SdkConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                SdkConfigManager.this.requestSdkConfig();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestSdkConfig() {
        Azeroth.get().newApiRequesterBuilder("open_azeroth").setAzerothApiParams(Azeroth.get().getInitParams().getApiRequesterParams().getApiParams()).setObserveOnMainThread(false).build().doPostRequest(PATH_CONFIG, null, SdkConfigResponse.class, new Callback<SdkConfigResponse>() { // from class: com.kwai.middleware.azeroth.configs.SdkConfigManager.2
            @Override // com.kwai.middleware.azeroth.utils.Callback
            public void onFailure(Throwable th) {
                Log.e(SdkConfigManager.TAG, "requestSdkConfig onFailure", th);
            }

            @Override // com.kwai.middleware.azeroth.utils.Callback
            public void onSuccess(SdkConfigResponse sdkConfigResponse) {
                SdkConfigManager.this.setSdkConfigs(sdkConfigResponse.mSdkConfigMap);
                AzerothStorage.get().setSdkConfigMap(sdkConfigResponse.mSdkConfigMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSdkConfigs(Map<String, String> map) {
        this.mSdkConfigs = new ConcurrentHashMap(map);
        synchronized (this.mChangedListenerListMap) {
            for (Map.Entry<String, List<OnConfigChangedListener>> entry : this.mChangedListenerListMap.entrySet()) {
                String config = getConfig(entry.getKey());
                if (entry.getValue() != null) {
                    for (OnConfigChangedListener onConfigChangedListener : entry.getValue()) {
                        if (onConfigChangedListener != null) {
                            try {
                                onConfigChangedListener.onConfigChanged(config);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public void onForeground(long j) {
        if (j < Azeroth.get().getInitParams().sdkConfigRequestBkgIntervalMs()) {
            return;
        }
        requestSdkConfigAsync();
    }

    static final class Holder {
        private static final SdkConfigManager sInstance = new SdkConfigManager();

        private Holder() {
        }
    }
}
