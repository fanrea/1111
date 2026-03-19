package com.kwad.sdk.live.audience;

import android.app.Application;
import android.content.Context;
import com.getkeepsafe.relinker.b;
import com.kwad.sdk.live.audience.api.KSLiveHttpConfig;
import com.kwad.sdk.live.audience.listener.KSLiveHttpDelegate;
import com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig;
import com.kwad.sdk.live.audience.test.KSLiveTestConfig;
import com.kwai.video.ksliveplayer.KSCoreLiveInitHelper;
import com.kwai.video.ksliveplayer.KSCoreLiveParams;
import com.kwai.video.ksliveplayer.KSLiveSoLoader;
import com.kwai.video.ksliveplayer.switcher.DnsResolver;
import com.kwai.video.ksliveplayer.switcher.HttpDns;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveInitModule {
    private static KSLiveInitModule sInitModule;
    private Application mAppContext;
    private DnsResolver mDnsResolver;
    private LiveStreamLogger.ILogClient mILogClient;
    private KSLiveHttpConfig mKSLiveHttpConfig;
    private KSLiveHttpDelegate mLiveHttpDelegate;
    private KSLiveLog mLog;
    private KSLiveLongConnectionConfig mLongConnectionConfig;
    private KSLiveTestConfig mTestConfig;

    public static KSLiveInitModule getInstance() {
        if (sInitModule == null) {
            sInitModule = new KSLiveInitModule();
        }
        return sInitModule;
    }

    public KSLiveInitModule bindApplication(Application application) {
        this.mAppContext = application;
        return this;
    }

    public KSLiveInitModule setKSLiveHttpConfig(KSLiveHttpConfig kSLiveHttpConfig) {
        this.mKSLiveHttpConfig = kSLiveHttpConfig;
        return this;
    }

    public KSLiveInitModule setLongConnectionConfig(KSLiveLongConnectionConfig kSLiveLongConnectionConfig) {
        this.mLongConnectionConfig = kSLiveLongConnectionConfig;
        return this;
    }

    public KSLiveInitModule setLiveHttpDelegate(KSLiveHttpDelegate kSLiveHttpDelegate) {
        this.mLiveHttpDelegate = kSLiveHttpDelegate;
        return this;
    }

    public KSLiveInitModule setTestConfig(KSLiveTestConfig kSLiveTestConfig) {
        this.mTestConfig = kSLiveTestConfig;
        return this;
    }

    public KSLiveInitModule setDnsResolver(DnsResolver dnsResolver) {
        this.mDnsResolver = dnsResolver;
        return this;
    }

    public KSLiveInitModule setLog(KSLiveLog kSLiveLog) {
        this.mLog = kSLiveLog;
        return this;
    }

    public KSLiveInitModule setLongConnectionLog(LiveStreamLogger.ILogClient iLogClient) {
        this.mILogClient = iLogClient;
        return this;
    }

    public void init() {
        Utils.checkNoNull(this.mAppContext, this.mKSLiveHttpConfig, this.mLongConnectionConfig);
        KWEGIDDFP.instance().ksteInit(this.mAppContext);
        LiveStreamLogger.ILogClient iLogClient = this.mILogClient;
        if (iLogClient != null) {
            LiveStreamLogger.inject(iLogClient);
        }
        initKSCoreLivePlayer();
    }

    public KSLiveHttpConfig getKSLiveHttpConfig() {
        return this.mKSLiveHttpConfig;
    }

    public KSLiveLongConnectionConfig getLongConnectionConfig() {
        return this.mLongConnectionConfig;
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public KSLiveHttpDelegate getLiveHttpDelegate() {
        return this.mLiveHttpDelegate;
    }

    public KSLiveTestConfig getTestConfig() {
        return this.mTestConfig;
    }

    public KSLiveLog getLog() {
        return this.mLog;
    }

    public LiveStreamLogger.ILogClient getILogClient() {
        return this.mILogClient;
    }

    private void initKSCoreLivePlayer() {
        if (this.mDnsResolver != null) {
            HttpDns.get().setImpl(this.mDnsResolver);
        }
        KSCoreLiveInitHelper.setSoLoader(new KSLiveSoLoader() { // from class: com.kwad.sdk.live.audience.KSLiveInitModule.1
            @Override // com.kwai.video.ksliveplayer.KSLiveSoLoader
            public void loadLibrary(String str) {
                b.c(KSLiveInitModule.this.mAppContext, str);
            }
        });
        KSCoreLiveInitHelper.initAll(this.mAppContext, getKsCoreLiveParams());
    }

    private KSCoreLiveParams getKsCoreLiveParams() {
        KSCoreLiveParams kSCoreLiveParams = new KSCoreLiveParams();
        kSCoreLiveParams.appId = this.mLongConnectionConfig.getAppId();
        kSCoreLiveParams.deviceId = this.mLongConnectionConfig.getDeviceId();
        kSCoreLiveParams.kpn = this.mLongConnectionConfig.getKpn();
        return kSCoreLiveParams;
    }
}
