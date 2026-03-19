package com.ss.texturerender.vsync;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class VsyncHelperFactory {
    private static String TAG = "VsyncHelperFactory";

    public static IVsyncHelper createVsyncHelper(Context context, int i, Bundle bundle) {
        if (DeviceManager.isVRDevice()) {
            return new VRVsyncHelper();
        }
        float f = bundle != null ? bundle.getFloat(TextureRenderKeys.KEY_IS_VSYNC_FPS) : 60.0f;
        Display defaultDisplay = null;
        if (context != null) {
            context = context.getApplicationContext();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                defaultDisplay = windowManager.getDefaultDisplay();
            }
        }
        float refreshRate = defaultDisplay != null ? defaultDisplay.getRefreshRate() : 60.0f;
        TextureRenderLog.d(i, TAG, "fpsWanted:" + f + ",defaultDisplayRefreshRate:" + refreshRate);
        if (f >= refreshRate || f <= 0.0f) {
            return new VsyncHelper(context, i);
        }
        return new LocalVsyncHelper(i, f);
    }
}
