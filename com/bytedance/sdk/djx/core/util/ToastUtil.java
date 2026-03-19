package com.bytedance.sdk.djx.core.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.djx.DJXToastType;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.toast.DJXToast;
import com.bytedance.sdk.djx.core.toast.IToast;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ToastUtil {
    private static int Y_OFFSET = -1;

    private static void initOffset() {
        if (Y_OFFSET < 0) {
            int iDp2px = UIUtil.dp2px(50.0f);
            Y_OFFSET = iDp2px;
            if (iDp2px < 0) {
                Y_OFFSET = 50;
            }
        }
    }

    public static void show(Context context, String str) {
        show(context, str, DJXToastType.NONE);
    }

    public static void show(Context context, String str, DJXToastType dJXToastType) {
        show(context, null, 17, 0, 0, str, false, dJXToastType);
    }

    public static void showCenter(Context context, View view, String str) {
        show(context, view, 17, 0, 0, str, false, DJXToastType.NONE);
    }

    public static void showForce(Context context, String str) {
        show(context, null, 17, 0, 0, str, true, DJXToastType.NONE);
    }

    public static void show(Context context, View view, int i, int i2, int i3, String str, boolean z, DJXToastType dJXToastType) {
        if (z || DevInfo.sToastController == null || !DevInfo.sToastController.onToast(context, str, dJXToastType)) {
            try {
                IToast gravity = DJXToast.make(context).setView(view).setDuration(3500).setGravity(i, i2, i3);
                gravity.setText(R.id.djx_toast_tip, str);
                gravity.show();
            } catch (Throwable unused) {
            }
        }
    }

    public static void cancelAll(Context context) {
        try {
            if (context instanceof Activity) {
                DJXToast.cancelActivityToast((Activity) context);
            }
        } catch (Throwable unused) {
        }
    }
}
