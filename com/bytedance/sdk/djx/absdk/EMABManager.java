package com.bytedance.sdk.djx.absdk;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class EMABManager {
    public static final int REFRESH_TYPE_AB_CONFIG = 1;
    public static final int REFRESH_TYPE_SETTINGS = 2;
    private static volatile EMABManager sInstance;
    private final ABPresenter mABPresenter = new ABPresenter();

    public static EMABManager getInstance() {
        if (sInstance == null) {
            synchronized (EMABManager.class) {
                if (sInstance == null) {
                    sInstance = new EMABManager();
                }
            }
        }
        return sInstance;
    }

    private EMABManager() {
    }

    public void init(ISettingABConfig iSettingABConfig) {
        this.mABPresenter.init(iSettingABConfig);
    }

    public <T> T getConfig(String str, T t) {
        return (T) this.mABPresenter.getConfig(str, t);
    }

    public JSONObject getAllABConfig() {
        return this.mABPresenter.getAllABConfig();
    }

    public void refresh(int i, String str) {
        this.mABPresenter.refresh(i, str);
    }

    public void registerListener(IABDataChangeListener iABDataChangeListener) {
        this.mABPresenter.registerListener(iABDataChangeListener);
    }

    public void unregisterListener(IABDataChangeListener iABDataChangeListener) {
        this.mABPresenter.removeListener(iABDataChangeListener);
    }
}
