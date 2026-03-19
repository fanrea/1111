package com.bytedance.sdk.djx.interfaces.listener;

import com.bytedance.sdk.djx.DJXRewardAdResult;
import com.bytedance.sdk.djx.model.DJXDrama;
import com.bytedance.sdk.djx.model.DJXDramaUnlockInfo;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDJXDramaUnlockListener.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&J.\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000f2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/djx/interfaces/listener/IDJXDramaUnlockListener;", "", "showCustomAd", "", "drama", "Lcom/bytedance/sdk/djx/model/DJXDrama;", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/interfaces/listener/IDJXDramaUnlockListener$CustomAdCallback;", "unlockFlowEnd", "errCode", "Lcom/bytedance/sdk/djx/interfaces/listener/IDJXDramaUnlockListener$UnlockErrorStatus;", "map", "", "", "unlockFlowStart", "Lcom/bytedance/sdk/djx/interfaces/listener/IDJXDramaUnlockListener$UnlockCallback;", "CustomAdCallback", "UnlockCallback", "UnlockErrorStatus", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXDramaUnlockListener {

    /* compiled from: IDJXDramaUnlockListener.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/djx/interfaces/listener/IDJXDramaUnlockListener$CustomAdCallback;", "", "onError", "", "onRewardVerify", "result", "Lcom/bytedance/sdk/djx/DJXRewardAdResult;", "onShow", "cpm", "", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CustomAdCallback {
        void onError();

        void onRewardVerify(DJXRewardAdResult result);

        void onShow(String cpm);
    }

    /* compiled from: IDJXDramaUnlockListener.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void showCustomAd(IDJXDramaUnlockListener iDJXDramaUnlockListener, DJXDrama dJXDrama, CustomAdCallback customAdCallback) {
            Intrinsics.checkNotNullParameter(iDJXDramaUnlockListener, "this");
            Intrinsics.checkNotNullParameter(dJXDrama, "drama");
            Intrinsics.checkNotNullParameter(customAdCallback, TextureRenderKeys.KEY_IS_CALLBACK);
        }
    }

    /* compiled from: IDJXDramaUnlockListener.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/djx/interfaces/listener/IDJXDramaUnlockListener$UnlockCallback;", "", "onConfirm", "", "unlockInfo", "Lcom/bytedance/sdk/djx/model/DJXDramaUnlockInfo;", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UnlockCallback {
        void onConfirm(DJXDramaUnlockInfo unlockInfo);
    }

    /* compiled from: IDJXDramaUnlockListener.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/djx/interfaces/listener/IDJXDramaUnlockListener$UnlockErrorStatus;", "", "(Ljava/lang/String;I)V", "ERROR_AD_NOT_SHOWN", "ERROR_REQUEST_ERROR", "ERROR_AD_ERROR", "ERROR_PAY", "USER_CANCEL", "USER_SKIP_AD", "DEV_RETURN_VERIFY_FAILED", "ERROR_GET_VIDEO_AD_ERROR", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum UnlockErrorStatus {
        ERROR_AD_NOT_SHOWN,
        ERROR_REQUEST_ERROR,
        ERROR_AD_ERROR,
        ERROR_PAY,
        USER_CANCEL,
        USER_SKIP_AD,
        DEV_RETURN_VERIFY_FAILED,
        ERROR_GET_VIDEO_AD_ERROR
    }

    void showCustomAd(DJXDrama drama, CustomAdCallback callback);

    void unlockFlowEnd(DJXDrama drama, UnlockErrorStatus errCode, Map<String, ? extends Object> map);

    void unlockFlowStart(DJXDrama drama, UnlockCallback callback, Map<String, ? extends Object> map);
}
