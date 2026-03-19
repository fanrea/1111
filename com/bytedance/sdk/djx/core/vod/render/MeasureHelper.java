package com.bytedance.sdk.djx.core.vod.render;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.UIUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class MeasureHelper {
    private static final String TAG = "MeasureHelper";
    public static int sRealScreenHeightPixels = -1;
    public static int sRealScreenWidthPixels = -1;
    private int mVideoHeight;
    private int mVideoWidth;

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    public ViewGroup.LayoutParams doLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return layoutParams;
        }
        boolean z = layoutParams instanceof FrameLayout.LayoutParams;
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (z) {
            int screenWidth = UIUtil.getScreenWidth(InnerManager.getContext());
            int screenHeight = UIUtil.getScreenHeight(InnerManager.getContext());
            float fFloatValue = screenHeight / Float.valueOf(screenWidth).floatValue();
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams3.gravity = 17;
            if (fFloatValue >= 2.0f && this.mVideoWidth < this.mVideoHeight) {
                layoutParams3.gravity = 81;
            }
            layoutParams2 = layoutParams3;
            if (isSmallScreen()) {
                int i = this.mVideoWidth;
                layoutParams2 = layoutParams3;
                if (i > 0) {
                    int i2 = this.mVideoHeight;
                    layoutParams2 = layoutParams3;
                    if (i2 > 0) {
                        if ((i2 * screenWidth) / i < screenHeight) {
                            layoutParams3.gravity = 17;
                            layoutParams2 = layoutParams3;
                        } else {
                            layoutParams3.gravity = 49;
                            layoutParams2 = layoutParams3;
                        }
                    }
                }
            }
        }
        return layoutParams2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e8 A[PHI: r0 r10
  0x00e8: PHI (r0v19 int) = (r0v14 int), (r0v14 int), (r0v29 int) binds: [B:27:0x012f, B:29:0x0135, B:20:0x00e3] A[DONT_GENERATE, DONT_INLINE]
  0x00e8: PHI (r10v13 int) = (r10v3 int), (r10v3 int), (r10v14 int) binds: [B:27:0x012f, B:29:0x0135, B:20:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] doMeasure(int r10, int r11) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.vod.render.MeasureHelper.doMeasure(int, int):int[]");
    }

    public static boolean isSmallScreen() {
        return DeviceUtils.isHonor9() || (sRealScreenHeightPixels == 1920 && sRealScreenWidthPixels == 1080);
    }
}
