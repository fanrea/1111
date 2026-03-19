package com.bytedance.sdk.djx.core.util;

import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VisibilityChecker {
    private static final int SHOW_STATE_LOWER_THAN_MIN_SHOW_PERCENT = 2;
    private static final int SHOW_STATE_NOT_VISIBLE = 1;
    private static final int SHOW_STATE_SHOW = 0;

    public static boolean isVisible(View view) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            return ((long) view.getHeight()) * ((long) view.getWidth()) > 0 && (((long) rect.height()) * ((long) rect.width())) * 100 > 0;
        }
        return false;
    }

    private static boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        float visibleArea = getVisibleArea(view);
        return visibleArea > 0.0f && visibleArea * 100.0f >= ((float) i);
    }

    public static float getVisibleArea(View view) {
        if (view == null) {
            return -1.0f;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return -1.0f;
        }
        int iHeight = rect.height() * rect.width();
        int height = view.getHeight() * view.getWidth();
        if (height <= 0) {
            return -1.0f;
        }
        return Integer.valueOf(iHeight).floatValue() / Integer.valueOf(height).floatValue();
    }

    private static boolean isViewShown(View view) {
        return view != null && view.isShown();
    }

    private static int getViewState(View view, int i) throws Throwable {
        if (isViewShown(view)) {
            return !isVisible(view, i) ? 2 : 0;
        }
        return 1;
    }

    public static boolean isShow(View view, int i) {
        try {
            return getViewState(view, i) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }
}
