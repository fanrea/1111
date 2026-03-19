package com.kwad.sdk;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.sdk.init.LiveInitHelper;
import com.kwad.sdk.video.AdLivePlayModule;
import com.kwai.video.ksliveplayer.KSCoreLiveInitHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AdLiveOfflineCompoImpl implements IAdLiveOfflineCompo {
    public static final String SO_AEGON = "aegon";
    public static final String SO_HODOR = "hodor";
    public static final String SO_KSTE = "kste";
    public static final String SO_KWAI_PLAYER = "kwaiplayer";
    public static final String SO_SHARED = "c++_shared";
    private static final String TAG = "IAdLiveOfflineCompo";
    private static volatile boolean mHasInit;
    private static final AtomicBoolean sIsAdLiveSoLoaded = new AtomicBoolean(false);
    private static final AtomicBoolean sIsAdSDKInit = new AtomicBoolean(false);
    private InitCallBack mInitCallBack;
    private boolean sIsTkSoFromNet;

    @Override // com.kwad.components.offline.api.IOfflineCompo
    public int priority() {
        return 100;
    }

    @Override // com.kwad.components.offline.api.IOfflineCompo
    public Class<AdLiveOfflineCompoImpl> getComponentsType() {
        return AdLiveOfflineCompoImpl.class;
    }

    @Override // com.kwad.components.offline.api.IOfflineCompo
    public void init(Context context, IAdLiveOfflineCompoInitConfig iAdLiveOfflineCompoInitConfig, InitCallBack initCallBack) {
        if (mHasInit) {
            return;
        }
        mHasInit = true;
        this.mInitCallBack = initCallBack;
        KsAdLive.get().setConfig(iAdLiveOfflineCompoInitConfig);
        loadSo(context);
    }

    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo
    public IAdLiveOfflineCompo.AdLiveState getState() {
        if (sIsAdLiveSoLoaded.get() && sIsAdSDKInit.get()) {
            return IAdLiveOfflineCompo.AdLiveState.READY;
        }
        return IAdLiveOfflineCompo.AdLiveState.SO_FAIL;
    }

    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo
    public IAdLiveOfflineView getView(Context context, int i) {
        Context contextWrapContextIfNeed = KsAdLive.get().getConfig().wrapper().wrapContextIfNeed(context);
        if (i == 0) {
            AdLiveViewImpl adLiveViewImpl = new AdLiveViewImpl(contextWrapContextIfNeed);
            adLiveViewImpl.setShowMessageAndShopCard(false);
            return adLiveViewImpl;
        }
        if (i == 1) {
            AdLiveViewImpl adLiveViewImpl2 = new AdLiveViewImpl(contextWrapContextIfNeed);
            adLiveViewImpl2.setShowMessageAndShopCard(true);
            return adLiveViewImpl2;
        }
        if (i == 2) {
            return new TKAdLiveViewImpl(contextWrapContextIfNeed);
        }
        if (i == 3) {
            return new AdLiveVideoViewImpl(contextWrapContextIfNeed);
        }
        AdLiveViewImpl adLiveViewImpl3 = new AdLiveViewImpl(contextWrapContextIfNeed);
        adLiveViewImpl3.setShowMessageAndShopCard(false);
        return adLiveViewImpl3;
    }

    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo
    public IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        return new AdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j);
    }

    @Override // com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo
    public IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return new AdLiveRequest(str);
    }

    private void loadSo(final Context context) {
        KsAdLive.get().getConfig().soLoader().loadSo(context, new SoLoadListener() { // from class: com.kwad.sdk.AdLiveOfflineCompoImpl.1
            @Override // com.kwad.components.offline.api.core.soloader.SoLoadListener
            public void onLoaded() {
                try {
                    System.loadLibrary("c++_shared");
                    try {
                        System.loadLibrary(AdLiveOfflineCompoImpl.SO_KSTE);
                        try {
                            System.loadLibrary(AdLiveOfflineCompoImpl.SO_AEGON);
                            try {
                                System.loadLibrary(AdLiveOfflineCompoImpl.SO_HODOR);
                                try {
                                    System.loadLibrary(AdLiveOfflineCompoImpl.SO_KWAI_PLAYER);
                                    AdLiveOfflineCompoImpl.sIsAdLiveSoLoaded.set(true);
                                    OfflineHostProvider.getApi().log().d(AdLiveOfflineCompoImpl.TAG, "loadSo success");
                                    try {
                                        Application applicationWrapGetApplication = KsAdLive.get().getConfig().wrapper().wrapGetApplication(context);
                                        if (applicationWrapGetApplication == null) {
                                            Log.d(AdLiveOfflineCompoImpl.TAG, "LiveInitHelper application == null initLiveSDK");
                                            return;
                                        }
                                        String appId = OfflineHostProvider.getApi().env().getAppId();
                                        if (!KsAdLive.get().getConfig().usePhoneStateDisable()) {
                                            KSCoreLiveInitHelper.setCanGetAndroidId(true);
                                        } else {
                                            KSCoreLiveInitHelper.setCanGetAndroidId(false);
                                        }
                                        LiveInitHelper.initLiveSDK(applicationWrapGetApplication, appId, KsAdLive.get().getConfig().getAdLiveHttpRequestListenerDelegate());
                                        AdLiveOfflineCompoImpl.sIsAdSDKInit.set(true);
                                        AdLiveOfflineCompoImpl.this.mInitCallBack.onSuccess(AdLiveOfflineCompoImpl.this.sIsTkSoFromNet);
                                        OfflineHostProvider.getApi().log().d(AdLiveOfflineCompoImpl.TAG, "loadSo success");
                                    } catch (Throwable th) {
                                        Log.d(AdLiveOfflineCompoImpl.TAG, "LiveInitHelper step error: initLiveSDK" + Log.getStackTraceString(th));
                                    }
                                } catch (Throwable th2) {
                                    Log.d(AdLiveOfflineCompoImpl.TAG, "loadSo fail:kwaiplayer" + th2.getMessage());
                                }
                            } catch (Throwable th3) {
                                Log.d(AdLiveOfflineCompoImpl.TAG, "loadSo fail:hodor" + th3.getMessage());
                            }
                        } catch (Throwable th4) {
                            Log.d(AdLiveOfflineCompoImpl.TAG, "loadSo fail:aegon" + th4.getMessage());
                        }
                    } catch (Throwable th5) {
                        Log.d(AdLiveOfflineCompoImpl.TAG, "loadSo fail:kste" + th5.getMessage());
                    }
                } catch (Throwable th6) {
                    Log.d(AdLiveOfflineCompoImpl.TAG, "loadSo fail:c++_shared" + th6.getMessage());
                }
            }

            @Override // com.kwad.components.offline.api.core.soloader.SoLoadListener
            public void onPreUpdate() {
                AdLiveOfflineCompoImpl.this.sIsTkSoFromNet = true;
            }

            @Override // com.kwad.components.offline.api.core.soloader.SoLoadListener
            public void onFailed(int i, Throwable th) {
                AdLiveOfflineCompoImpl.this.mInitCallBack.onError(i);
                AdLiveOfflineCompoImpl.sIsAdLiveSoLoaded.set(false);
            }
        });
    }
}
