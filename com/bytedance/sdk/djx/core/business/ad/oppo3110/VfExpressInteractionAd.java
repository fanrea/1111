package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.bykv.vk.openvk.TTNtExpressObject;
import com.bytedance.sdk.djx.utils.Reflector;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfExpressInteractionAd extends VfExpressAd {
    public VfExpressInteractionAd(TTNtExpressObject tTNtExpressObject, long j) {
        super(tTNtExpressObject, j);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void show(Context context) {
        if (!(context instanceof Activity) || this.mNativeExpressVf == null) {
            return;
        }
        this.mNativeExpressVf.showInteractionExpressAd((Activity) context);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void dismissByReflect() {
        if (this.mNativeExpressVf != null) {
            try {
                Field[] declaredFields = this.mNativeExpressVf.getClass().getDeclaredFields();
                if (declaredFields != null) {
                    for (Field field : declaredFields) {
                        if (field.getGenericType().toString().contains("android.app.Dialog")) {
                            Dialog dialog = (Dialog) Reflector.with(this.mNativeExpressVf).field(field.getName()).get(this.mNativeExpressVf);
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
