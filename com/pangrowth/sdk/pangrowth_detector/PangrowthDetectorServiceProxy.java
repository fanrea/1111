package com.pangrowth.sdk.pangrowth_detector;

import com.bytedance.sdk.commonsdk.api.detector_api.AdEvent;
import com.bytedance.sdk.commonsdk.api.detector_api.DetectResult;
import com.bytedance.sdk.commonsdk.api.detector_api.IAPSdkEvent;
import com.bytedance.sdk.commonsdk.api.detector_api.IAdObserver;
import com.bytedance.sdk.commonsdk.api.detector_api.IDetectCallback;
import com.bytedance.sdk.commonsdk.api.detector_api.IIAPObserver;
import com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService;
import com.bytedance.sdk.commonsdk.api.detector_api.InitConfig;
import com.bytedance.sdk.djx.proguard3.g.a;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PangrowthDetectorServiceProxy.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/pangrowth/sdk/pangrowth_detector/PangrowthDetectorServiceProxy;", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IPangrowthDetectorService;", "()V", "serviceImpl", "detectAd", "Lcom/bytedance/sdk/commonsdk/api/detector_api/DetectResult;", "Lcom/bytedance/sdk/commonsdk/api/detector_api/AdEvent;", "detectAdDelay", "", "delayMillis", "", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/commonsdk/api/detector_api/IDetectCallback;", "detectIAPSdk", "", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IAPSdkEvent$IAPSdk;", PointCategory.INIT, "config", "Lcom/bytedance/sdk/commonsdk/api/detector_api/InitConfig;", "registerAdObserver", "observer", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IAdObserver;", "registerIAPObserver", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IIAPObserver;", "unregisterAdObserver", "unregisterIAPObserver", "pangrowth_detector_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PangrowthDetectorServiceProxy implements IPangrowthDetectorService {
    private final IPangrowthDetectorService serviceImpl = new a();

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public void init(InitConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.serviceImpl.init(config);
    }

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public void registerAdObserver(IAdObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.serviceImpl.registerAdObserver(observer);
    }

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public void unregisterAdObserver(IAdObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.serviceImpl.unregisterAdObserver(observer);
    }

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public DetectResult<AdEvent> detectAd() {
        return this.serviceImpl.detectAd();
    }

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public void detectAdDelay(long delayMillis, IDetectCallback<DetectResult<AdEvent>> callback) {
        Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        this.serviceImpl.detectAdDelay(delayMillis, callback);
    }

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public void registerIAPObserver(IIAPObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.serviceImpl.registerIAPObserver(observer);
    }

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public void unregisterIAPObserver(IIAPObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.serviceImpl.unregisterIAPObserver(observer);
    }

    @Override // com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService
    public List<IAPSdkEvent.IAPSdk> detectIAPSdk() {
        return this.serviceImpl.detectIAPSdk();
    }
}
