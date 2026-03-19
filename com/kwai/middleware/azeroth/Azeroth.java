package com.kwai.middleware.azeroth;

import android.arch.lifecycle.ProcessLifecycleOwner;
import android.content.Context;
import android.content.SharedPreferences;
import com.kwai.middleware.azeroth.configs.ISdkConfigManager;
import com.kwai.middleware.azeroth.configs.InitCommonParams;
import com.kwai.middleware.azeroth.configs.InitParams;
import com.kwai.middleware.azeroth.configs.SdkConfigManager;
import com.kwai.middleware.azeroth.logger.IKwaiLogger;
import com.kwai.middleware.azeroth.network.AzerothApiManager;
import com.kwai.middleware.azeroth.network.AzerothApiRequester;
import com.kwai.middleware.azeroth.utils.Utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Azeroth {
    public static final String SDK_NAME = "open_azeroth";
    public static final String TAG = "open_azeroth";
    private Context mContext;
    private InitCommonParams mInitCommonParams;
    private InitParams mInitParams;
    private IKwaiLogger mLogger;

    public static Azeroth get() {
        return Holder.sInstance;
    }

    static final class Holder {
        private static final Azeroth sInstance = new Azeroth();

        private Holder() {
        }
    }

    public final Azeroth init(InitParams initParams) {
        this.mInitParams = initParams;
        this.mContext = initParams.getCommonParams().getContext().getApplicationContext();
        SdkConfigManager.get().init();
        AzerothApiManager.get().init();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AzerothLifeCallbacks());
        return this;
    }

    public final Azeroth setLogger(IKwaiLogger iKwaiLogger) {
        Utils.checkNotNull(iKwaiLogger);
        this.mLogger = iKwaiLogger;
        return this;
    }

    public final IKwaiLogger getLogger() {
        IKwaiLogger iKwaiLogger = this.mLogger;
        if (iKwaiLogger != null) {
            return iKwaiLogger;
        }
        throw new IllegalStateException("Invoker setLogger() first!!\n如果引用了Kanas, 请先初始化Kanas模块，并确保kanas是2.6.7+版本。");
    }

    public final ISdkConfigManager getConfigManager() {
        return SdkConfigManager.get();
    }

    public final InitParams getInitParams() {
        InitParams initParams = this.mInitParams;
        if (initParams != null) {
            return initParams;
        }
        throw new IllegalStateException("InitParams cannot be null! Please invoke Azeroth.get().init() first!");
    }

    public final InitCommonParams getCommonParams() {
        if (this.mInitCommonParams == null) {
            this.mInitCommonParams = getInitParams().getCommonParams();
        }
        InitCommonParams initCommonParams = this.mInitCommonParams;
        if (initCommonParams != null) {
            return initCommonParams;
        }
        throw new IllegalStateException("InitCommonParams cannot be null! Please return non null for method InitParams.getCommonParams()");
    }

    public final AzerothApiRequester newApiRequester(String str) {
        return AzerothApiRequester.newBuilder(str).build();
    }

    public final AzerothApiRequester.Builder newApiRequesterBuilder(String str) {
        return AzerothApiRequester.newBuilder(str);
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final boolean isDebugMode() {
        return getCommonParams().isDebugMode();
    }

    public final boolean isTest() {
        return getCommonParams().isTestMode();
    }

    public final SharedPreferences getSharedPreferences(String str, int i) {
        return getCommonParams().getSharedPreferences(str, i);
    }
}
