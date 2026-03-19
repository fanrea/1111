package com.bytedance.sdk.commonsdk.api.detector_api;

import com.bytedance.sdk.commonsdk.api.detector_api.IAPSdkEvent;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IPangrowthDetectorService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0015H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/IPangrowthDetectorService;", "", "detectAd", "Lcom/bytedance/sdk/commonsdk/api/detector_api/DetectResult;", "Lcom/bytedance/sdk/commonsdk/api/detector_api/AdEvent;", "detectAdDelay", "", "delayMillis", "", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/commonsdk/api/detector_api/IDetectCallback;", "detectIAPSdk", "", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IAPSdkEvent$IAPSdk;", PointCategory.INIT, "config", "Lcom/bytedance/sdk/commonsdk/api/detector_api/InitConfig;", "registerAdObserver", "observer", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IAdObserver;", "registerIAPObserver", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IIAPObserver;", "unregisterAdObserver", "unregisterIAPObserver", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IPangrowthDetectorService {
    DetectResult<AdEvent> detectAd();

    void detectAdDelay(long delayMillis, IDetectCallback<DetectResult<AdEvent>> callback);

    List<IAPSdkEvent.IAPSdk> detectIAPSdk();

    void init(InitConfig config);

    void registerAdObserver(IAdObserver observer);

    void registerIAPObserver(IIAPObserver observer);

    void unregisterAdObserver(IAdObserver observer);

    void unregisterIAPObserver(IIAPObserver observer);
}
