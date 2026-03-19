package com.bytedance.sdk.djx.core.business.budrama;

import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener;
import com.bytedance.sdk.djx.model.DJXDrama;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import com.bytedance.sdk.djx.model.DJXDramaUnlockAdMode;
import com.bytedance.sdk.djx.model.DJXDramaUnlockInfo;
import com.bytedance.sdk.djx.model.DJXDramaUnlockMethod;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.utils.LG;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultDramaParamsWrapper.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"FREE_SET", "", "LOCK_SET", "TAG", "", "getDefaultDramaDetailConfig", "Lcom/bytedance/sdk/djx/model/DJXDramaDetailConfig;", "getDefaultDramaUnlockInfo", "Lcom/bytedance/sdk/djx/model/DJXDramaUnlockInfo;", "drama", "Lcom/bytedance/sdk/djx/model/Drama;", "sdk_core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DefaultDramaParamsWrapperKt {
    private static final int FREE_SET = 1;
    private static final int LOCK_SET = 1;
    private static final String TAG = "DefaultDramaParams";

    public static final DJXDramaDetailConfig getDefaultDramaDetailConfig() {
        DJXDramaDetailConfig dJXDramaDetailConfigObtain = DJXDramaDetailConfig.obtain(DJXDramaUnlockAdMode.MODE_COMMON, 1, new IDJXDramaUnlockListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.DefaultDramaParamsWrapperKt.getDefaultDramaDetailConfig.1
            @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener
            public void showCustomAd(DJXDrama dJXDrama, IDJXDramaUnlockListener.CustomAdCallback customAdCallback) {
                IDJXDramaUnlockListener.DefaultImpls.showCustomAd(this, dJXDrama, customAdCallback);
            }

            @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener
            public void unlockFlowStart(DJXDrama drama, IDJXDramaUnlockListener.UnlockCallback callback, Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(drama, "drama");
                Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
                callback.onConfirm(new DJXDramaUnlockInfo(drama.id, 1, DJXDramaUnlockMethod.METHOD_AD, false, null, false, null, 112, null));
                LG.d(DefaultDramaParamsWrapperKt.TAG, "unlockFlowStart");
            }

            @Override // com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener
            public void unlockFlowEnd(DJXDrama drama, IDJXDramaUnlockListener.UnlockErrorStatus errCode, Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(drama, "drama");
                LG.d(DefaultDramaParamsWrapperKt.TAG, "unlockFlowEnd");
            }
        });
        Intrinsics.checkNotNullExpressionValue(dJXDramaDetailConfigObtain, "obtain(DJXDramaUnlockAdM…\"unlockFlowEnd\")\n    }\n})");
        return dJXDramaDetailConfigObtain;
    }

    public static final DJXDramaUnlockInfo getDefaultDramaUnlockInfo(Drama drama) {
        Intrinsics.checkNotNullParameter(drama, "drama");
        return new DJXDramaUnlockInfo(drama.id, 1, DJXDramaUnlockMethod.METHOD_AD, false, null, false, null, 64, null);
    }
}
