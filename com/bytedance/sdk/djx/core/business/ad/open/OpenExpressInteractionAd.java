package com.bytedance.sdk.djx.core.business.ad.open;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.bytedance.sdk.djx.utils.Reflector;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenExpressInteractionAd extends OpenExpressAd {
    public OpenExpressInteractionAd(TTNativeExpressAd tTNativeExpressAd, long j) {
        super(tTNativeExpressAd, j);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void show(Context context) {
        if (!(context instanceof Activity) || this.mNativeExpressAd == null) {
            return;
        }
        this.mNativeExpressAd.showInteractionExpressAd((Activity) context);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void dismissByReflect() {
        if (this.mNativeExpressAd != null) {
            try {
                Field[] declaredFields = this.mNativeExpressAd.getClass().getDeclaredFields();
                if (declaredFields != null) {
                    for (Field field : declaredFields) {
                        if (field.getGenericType().toString().contains("android.app.Dialog")) {
                            Dialog dialog = (Dialog) Reflector.with(this.mNativeExpressAd).field(field.getName()).get(this.mNativeExpressAd);
                            if (dialog != null) {
                                dialog.dismiss();
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
