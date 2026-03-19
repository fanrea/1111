package com.bytedance.sdk.commonsdk.api.detector_api;

import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;

/* compiled from: PangrowthDetectorSDK.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/commonsdk/api/detector_api/PangrowthDetectorSDK;", "", "()V", "IMPL_CLASS", "", "newInstance", "Lcom/bytedance/sdk/commonsdk/api/detector_api/IPangrowthDetectorService;", "api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class PangrowthDetectorSDK {
    private static final String IMPL_CLASS = "com.pangrowth.sdk.pangrowth_detector.PangrowthDetectorServiceProxy";
    public static final PangrowthDetectorSDK INSTANCE = new PangrowthDetectorSDK();

    private PangrowthDetectorSDK() {
    }

    public final IPangrowthDetectorService newInstance() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance = Class.forName(IMPL_CLASS).getConstructor(new Class[0]).newInstance(new Object[0]);
        if (objNewInstance != null) {
            return (IPangrowthDetectorService) objNewInstance;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.sdk.commonsdk.api.detector_api.IPangrowthDetectorService");
    }
}
