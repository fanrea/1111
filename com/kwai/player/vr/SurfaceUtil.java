package com.kwai.player.vr;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SurfaceUtil {
    private static final String TAG = "SurfaceUtil";

    public static Surface create(SurfaceTexture surfaceTexture) {
        try {
            Surface surface = new Surface(surfaceTexture);
            Log.i(TAG, "create " + surface);
            return surface;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void release(Surface surface) {
        if (surface != null) {
            try {
                surface.release();
                Log.i(TAG, "release " + surface);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
