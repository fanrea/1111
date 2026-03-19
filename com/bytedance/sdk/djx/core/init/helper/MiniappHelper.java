package com.bytedance.sdk.djx.core.init.helper;

import android.content.Context;
import com.bytedance.pangrowthsdk.miniapp.api.Config;
import com.bytedance.pangrowthsdk.miniapp.api.ConfigBuilder;
import com.bytedance.pangrowthsdk.miniapp.api.IPrivacyController;
import com.bytedance.pangrowthsdk.miniapp.api.MiniAppSDK;
import com.bytedance.pangrowthsdk.miniapp.api.callback.IMiniAppStartCallback;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.internal.utils.DJXLogger;
import com.bytedance.sdk.djx.utils.LG;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MiniappHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bJ\b\u0010\r\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/djx/core/init/helper/MiniappHelper;", "", "()V", "TAG", "", "initAndStart", "", "context", "Landroid/content/Context;", "jsonName", TextureRenderKeys.KEY_IS_CALLBACK, "Lkotlin/Function1;", "", "isExistMiniapp", "base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class MiniappHelper {
    public static final MiniappHelper INSTANCE = new MiniappHelper();
    private static final String TAG = "MiniappHelper";

    private MiniappHelper() {
    }

    public final void initAndStart(Context context, String jsonName, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonName, "jsonName");
        Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        if (!isExistMiniapp()) {
            callback.invoke(true);
            return;
        }
        Config configBuild = new ConfigBuilder().setAssetName(jsonName).setSiteId(DevInfo.sSiteId).setDebug(DevInfo.sIsDebug).setPrivacyController(new IPrivacyController() { // from class: com.bytedance.sdk.djx.core.init.helper.MiniappHelper$initAndStart$miniConfig$1
            public boolean isCanUsePhoneState() {
                return DevInfo.getPrivacyController().isCanUsePhoneState();
            }

            public boolean isCanUseMac() {
                return DevInfo.getPrivacyController().isCanUseMac();
            }

            public boolean isCanUseSerialNumber() {
                return DevInfo.getPrivacyController().isCanUseSerialNumber();
            }

            public boolean isCanUseOperatorInfo() {
                return DevInfo.getPrivacyController().isCanUseOperatorInfo();
            }

            public String getImei() {
                String imei = DevInfo.getPrivacyController().getImei();
                Intrinsics.checkNotNullExpressionValue(imei, "getPrivacyController().imei");
                return imei;
            }

            public String getImsi() {
                String imsi = DevInfo.getPrivacyController().getImsi();
                Intrinsics.checkNotNullExpressionValue(imsi, "getPrivacyController().imsi");
                return imsi;
            }
        }).build();
        MiniAppSDK miniAppSDK = MiniAppSDK.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(configBuild, "miniConfig");
        miniAppSDK.init(context, configBuild);
        MiniAppSDK.INSTANCE.start(new IMiniAppStartCallback() { // from class: com.bytedance.sdk.djx.core.init.helper.MiniappHelper.initAndStart.1
            public void onStartResult(boolean isSuccess, String msg) {
                callback.invoke(Boolean.valueOf(isSuccess));
                DJXLogger.d(MiniappHelper.TAG, "start result: " + isSuccess + ", " + ((Object) msg));
            }
        });
    }

    private final boolean isExistMiniapp() throws ClassNotFoundException {
        try {
            Class.forName("com.bytedance.pangrowthsdk.miniapp.api.MiniAppSDK");
            return true;
        } catch (ClassNotFoundException unused) {
            LG.d(TAG, "miniapp sdk not exist");
            return false;
        }
    }
}
