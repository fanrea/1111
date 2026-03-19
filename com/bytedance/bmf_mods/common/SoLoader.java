package com.bytedance.bmf_mods.common;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SoLoader {
    private static final SoLoader INSTANCE = new SoLoader();
    private static boolean sIsSoInitialized = false;
    private Context appContext;

    static {
        try {
            System.loadLibrary("hmp");
            System.loadLibrary("bmf_module_sdk");
            System.loadLibrary("bmf_hydra");
            sIsSoInitialized = true;
            Logging.d("Bmf so libraries are initialized. version = 2.43.1-tob");
        } catch (Throwable th) {
            Logging.e("Bmf so libraries are NOT initialized. version = 2.43.1-tob error msg = " + th.getMessage());
            sIsSoInitialized = false;
        }
    }

    private SoLoader() {
    }

    public void setContext(Context context) {
        this.appContext = context.getApplicationContext();
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public static SoLoader getInstance() {
        return INSTANCE;
    }

    public boolean isSoInitialized() {
        return sIsSoInitialized;
    }
}
