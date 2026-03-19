package com.bytedance.sdk.djx;

import android.content.Context;
import com.bytedance.sdk.djx.DJXSdkConfig;
import com.bytedance.sdk.djx.empty.EmptyBaseServiceImpl;
import com.bytedance.sdk.djx.impl.DJXSdkInstance;
import com.bytedance.sdk.djx.impl.EMBaseHelper;
import com.sigmob.sdk.base.mta.PointCategory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EMBaseSdk.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0002R\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/djx/EMBaseSdk;", "", "()V", "instance", "Lcom/bytedance/sdk/djx/impl/DJXSdkInstance;", "kotlin.jvm.PlatformType", PointCategory.INIT, "", "context", "Landroid/content/Context;", "configName", "", "config", "Lcom/bytedance/sdk/djx/EMSdkConfig;", "isStartSuccess", "", "service", "Lcom/bytedance/sdk/djx/IEMBaseService;", "start", "listener", "Lcom/bytedance/sdk/djx/IBaseStartListener;", "toDJXSdkConfig", "Lcom/bytedance/sdk/djx/DJXSdkConfig;", "emSdkConfig", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class EMBaseSdk {
    public static final EMBaseSdk INSTANCE = new EMBaseSdk();
    private static final DJXSdkInstance instance = DJXSdkInstance.getInstance();

    private EMBaseSdk() {
    }

    @JvmStatic
    public static final void init(Context context, String configName, EMSdkConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configName, "configName");
        Intrinsics.checkNotNullParameter(config, "config");
        instance.init(context, configName, INSTANCE.toDJXSdkConfig(config));
    }

    @JvmStatic
    public static final void start(IBaseStartListener listener) {
        instance.start(listener);
    }

    @JvmStatic
    public static final boolean isStartSuccess() {
        return instance.isStartSuccess();
    }

    @JvmStatic
    public static final IEMBaseService service() {
        IEMBaseService iEMBaseServiceImpl = EMBaseHelper.INSTANCE.impl();
        return iEMBaseServiceImpl == null ? new EmptyBaseServiceImpl() : iEMBaseServiceImpl;
    }

    private final DJXSdkConfig toDJXSdkConfig(EMSdkConfig emSdkConfig) {
        if (emSdkConfig instanceof DJXSdkConfig) {
            return (DJXSdkConfig) emSdkConfig;
        }
        DJXSdkConfig dJXSdkConfigBuild = new DJXSdkConfig.Builder().debug(emSdkConfig.isDebug()).aliveSeconds(emSdkConfig.getAliveSeconds()).newUser(emSdkConfig.isNewUser()).disableABTest(emSdkConfig.isDisableABTest()).imageCacheSize(emSdkConfig.getImageCacheSize()).interestType(emSdkConfig.getInterestType()).privacyController(emSdkConfig.getPrivacyController()).router(emSdkConfig.getRouter()).toastController(emSdkConfig.getToastController()).build();
        Intrinsics.checkNotNullExpressionValue(dJXSdkConfigBuild, "Builder()\n              …\n                .build()");
        return dJXSdkConfigBuild;
    }
}
