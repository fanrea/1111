package com.kwai.middleware.azeroth.network;

import android.text.TextUtils;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.AzerothStorage;
import com.kwai.middleware.azeroth.configs.OnConfigChangedListener;
import com.kwai.middleware.azeroth.model.AzerothSdkConfigs;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AzerothApiManager {
    private String mCurrentHost;
    private List<String> mHostList = new CopyOnWriteArrayList();
    private Random mRandom = new Random(System.currentTimeMillis());

    public static AzerothApiManager get() {
        return Holder.sInstance;
    }

    public final void init() {
        Azeroth.get().getConfigManager().addConfigChangeListener("open_azeroth", new OnConfigChangedListener() { // from class: com.kwai.middleware.azeroth.network.AzerothApiManager.1
            @Override // com.kwai.middleware.azeroth.configs.OnConfigChangedListener
            public void onConfigChanged(String str) {
                AzerothApiManager.this.updateConfig(str);
            }
        });
    }

    private void checkInitParams() {
        List<String> hosts = Azeroth.get().getInitParams().getApiRequesterParams().getHosts();
        if (hosts == null || hosts.isEmpty()) {
            throw new IllegalArgumentException("InitApiRequesterParams getHosts() cannot be null or empty. Please set correct host list");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            updateHostList(null);
            return;
        }
        AzerothSdkConfigs azerothSdkConfigs = (AzerothSdkConfigs) JsonUtils.fromJson(str, AzerothSdkConfigs.class);
        if (azerothSdkConfigs != null && azerothSdkConfigs.getConfig() != null) {
            updateHostList(azerothSdkConfigs.getConfig().getHostList());
        } else {
            updateHostList(null);
        }
    }

    public final void updateHostList(List<String> list) {
        checkInitParams();
        List<String> hosts = Azeroth.get().getInitParams().getApiRequesterParams().getHosts();
        if (list == null || list.isEmpty()) {
            list = hosts;
        } else if (hosts != null) {
            for (String str : hosts) {
                if (!list.contains(str)) {
                    list.add(str);
                }
            }
        }
        this.mHostList = new CopyOnWriteArrayList(list);
        if (com.kwai.middleware.azeroth.utils.TextUtils.isEmpty(this.mCurrentHost) || this.mHostList.isEmpty() || this.mHostList.contains(this.mCurrentHost)) {
            return;
        }
        switchHost();
    }

    private void ensureInit() {
        if (this.mHostList.isEmpty()) {
            updateConfig(Azeroth.get().getConfigManager().getConfig("open_azeroth"));
        }
    }

    public final String getHost() {
        ensureInit();
        if (com.kwai.middleware.azeroth.utils.TextUtils.isEmpty(this.mCurrentHost)) {
            String currentHost = AzerothStorage.get().getCurrentHost();
            if ((com.kwai.middleware.azeroth.utils.TextUtils.isEmpty(currentHost) || !this.mHostList.contains(currentHost)) && !this.mHostList.isEmpty()) {
                List<String> list = this.mHostList;
                this.mCurrentHost = list.get(this.mRandom.nextInt(list.size()));
                AzerothStorage.get().setCurrentHost(this.mCurrentHost);
            } else {
                this.mCurrentHost = currentHost;
            }
        }
        return this.mCurrentHost;
    }

    public final String switchHost() {
        ensureInit();
        if (!this.mHostList.isEmpty()) {
            int iIndexOf = this.mHostList.indexOf(this.mCurrentHost);
            if (iIndexOf >= 0 && iIndexOf < this.mHostList.size()) {
                List<String> list = this.mHostList;
                this.mCurrentHost = list.get((iIndexOf + 1) % list.size());
            } else {
                List<String> list2 = this.mHostList;
                this.mCurrentHost = list2.get(this.mRandom.nextInt(list2.size()));
            }
        }
        AzerothStorage.get().setCurrentHost(this.mCurrentHost);
        return this.mCurrentHost;
    }

    static class Holder {
        private static final AzerothApiManager sInstance = new AzerothApiManager();

        private Holder() {
        }
    }
}
