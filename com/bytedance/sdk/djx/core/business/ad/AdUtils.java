package com.bytedance.sdk.djx.core.business.ad;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAdapter;
import com.bytedance.sdk.djx.core.business.ad.oppo.ObLoaderAdapter;
import com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAdapter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdUtils {
    static final String OPEN_CLASS = "com.bytedance.sdk.openadsdk.TTAdNative";
    static final String OPPO_3110_CLASS = "com.bykv.vk.openvk.TTVfNative";
    static final String OPPO_CLASS = "com.ttshell.sdk.api.TTObNative";

    static LoaderAdapter createDefaultAdapter() {
        if (isExist(OPPO_CLASS)) {
            return OppoAdapterCreator.create();
        }
        if (isExist(OPPO_3110_CLASS)) {
            return Oppo3110AdapterCreator.create();
        }
        if (isExist(OPEN_CLASS)) {
            return OpenAdapterCreator.create();
        }
        return DefaultAdapterCreator.create();
    }

    public static boolean isExist(String str) throws ClassNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isAdSdkExist() {
        return isExist(OPEN_CLASS) || isExist(OPPO_CLASS) || isExist(OPPO_3110_CLASS);
    }

    public static Map<String, Object> adExtraTransform(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                map2.put("open_ad_" + entry.getKey(), entry.getValue());
            }
            return map2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class OpenAdapterCreator {
        private OpenAdapterCreator() {
        }

        static LoaderAdapter create() {
            return new OpenLoaderAdapter();
        }
    }

    private static class OppoAdapterCreator {
        private OppoAdapterCreator() {
        }

        static LoaderAdapter create() {
            return new ObLoaderAdapter();
        }
    }

    private static class Oppo3110AdapterCreator {
        private Oppo3110AdapterCreator() {
        }

        static LoaderAdapter create() {
            return new VfLoaderAdapter();
        }
    }

    private static class DefaultAdapterCreator {
        private DefaultAdapterCreator() {
        }

        static LoaderAdapter create() {
            return new DefaultLoaderAdapter();
        }
    }

    public static void centerAd(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return;
        }
        try {
            View childAt = frameLayout.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 17;
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }
}
