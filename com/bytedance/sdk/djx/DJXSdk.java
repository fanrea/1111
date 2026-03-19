package com.bytedance.sdk.djx;

import android.content.Context;
import com.bytedance.sdk.djx.impl.DJXSdkInstance;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.utils.AssertHelper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXSdk {
    private static final DJXSdkInstance instance = DJXSdkInstance.getInstance();

    public interface StartListener {
        void onStartComplete(boolean z, String str, DJXError dJXError);
    }

    public static String getVersion() {
        return "2.9.0.2";
    }

    private DJXSdk() {
        AssertHelper.throwNow("DJXSdk can not access");
    }

    public static void init(Context context, String str, DJXSdkConfig dJXSdkConfig) {
        EMBaseSdk.init(context, str, dJXSdkConfig);
    }

    public static void start(final StartListener startListener) {
        EMBaseSdk.start(new IBaseStartListener() { // from class: com.bytedance.sdk.djx.DJXSdk.1
            @Override // com.bytedance.sdk.djx.IBaseStartListener
            public void onStartComplete(boolean z, String str, DJXError dJXError) {
                StartListener startListener2 = startListener;
                if (startListener2 != null) {
                    startListener2.onStartComplete(z, str, dJXError);
                }
            }
        });
    }

    public static IDJXWidgetFactory factory() {
        return instance.factory();
    }

    public static IDJXService service() {
        return instance.service();
    }

    public static boolean isStartSuccess() {
        return EMBaseSdk.isStartSuccess();
    }
}
