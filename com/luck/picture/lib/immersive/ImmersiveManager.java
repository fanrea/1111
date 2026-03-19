package com.luck.picture.lib.immersive;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.kuaishou.socket.nano.SocketMessages;
import com.luck.picture.lib.utils.DensityUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ImmersiveManager {
    private static final String TAG_FAKE_STATUS_BAR_VIEW = "TAG_FAKE_STATUS_BAR_VIEW";
    private static final String TAG_MARGIN_ADDED = "TAG_MARGIN_ADDED";
    private static final String TAG_NAVIGATION_BAR_VIEW = "TAG_NAVIGATION_BAR_VIEW";

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, int i, int i2, boolean z) {
        immersiveAboveAPI23(appCompatActivity, false, false, i, i2, z);
    }

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, boolean z, boolean z2, int i, int i2, boolean z3) {
        try {
            Window window = appCompatActivity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                if (z3) {
                    initBarBelowLOLLIPOP(appCompatActivity);
                    return;
                } else {
                    window.setFlags(67108864, 67108864);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                boolean z4 = true;
                if (z && z2) {
                    window.clearFlags(201326592);
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, true, true, i == 0, z3);
                    window.addFlags(Integer.MIN_VALUE);
                } else if (z || z2) {
                    if (z) {
                        return;
                    }
                    window.requestFeature(1);
                    window.clearFlags(201326592);
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, true, i == 0, z3);
                    window.addFlags(Integer.MIN_VALUE);
                } else if (Build.VERSION.SDK_INT < 23 && z3) {
                    initBarBelowLOLLIPOP(appCompatActivity);
                } else {
                    window.requestFeature(1);
                    window.clearFlags(201326592);
                    if (i != 0) {
                        z4 = false;
                    }
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, false, z4, z3);
                    window.addFlags(Integer.MIN_VALUE);
                }
                window.setStatusBarColor(i);
                window.setNavigationBarColor(i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void translucentStatusBar(Activity activity, boolean z) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
        }
        window.clearFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(0);
        }
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT >= 23) {
            if (z) {
                decorView.setSystemUiVisibility(9472);
            } else {
                window.getDecorView().setSystemUiVisibility(SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);
            }
        } else if (z) {
            initBarBelowLOLLIPOP(activity);
        } else {
            window.getDecorView().setSystemUiVisibility(SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);
        }
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
            ViewCompat.requestApplyInsets(childAt);
        }
    }

    private static void initBarBelowLOLLIPOP(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        setupStatusBarView(activity);
        if (DensityUtil.isNavBarVisible(activity)) {
            window.addFlags(134217728);
            setupNavBarView(activity);
        }
    }

    private static void setupStatusBarView(Activity activity) {
        Window window = activity.getWindow();
        View viewFindViewWithTag = window.getDecorView().findViewWithTag(TAG_FAKE_STATUS_BAR_VIEW);
        if (viewFindViewWithTag == null) {
            viewFindViewWithTag = new View(activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DensityUtil.getStatusBarHeight(activity));
            layoutParams.gravity = 48;
            viewFindViewWithTag.setLayoutParams(layoutParams);
            viewFindViewWithTag.setVisibility(0);
            viewFindViewWithTag.setTag(TAG_MARGIN_ADDED);
            ((ViewGroup) window.getDecorView()).addView(viewFindViewWithTag);
        }
        viewFindViewWithTag.setBackgroundColor(0);
    }

    private static void setupNavBarView(Activity activity) {
        FrameLayout.LayoutParams layoutParams;
        Window window = activity.getWindow();
        View viewFindViewWithTag = window.getDecorView().findViewWithTag(TAG_NAVIGATION_BAR_VIEW);
        if (viewFindViewWithTag == null) {
            viewFindViewWithTag = new View(activity);
            viewFindViewWithTag.setTag(TAG_NAVIGATION_BAR_VIEW);
            ((ViewGroup) window.getDecorView()).addView(viewFindViewWithTag);
        }
        if (DensityUtil.isNavigationAtBottom(activity)) {
            layoutParams = new FrameLayout.LayoutParams(-1, DensityUtil.getNavigationBarHeight(activity));
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(DensityUtil.getNavigationBarWidth(activity), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        viewFindViewWithTag.setLayoutParams(layoutParams);
        viewFindViewWithTag.setBackgroundColor(0);
        viewFindViewWithTag.setVisibility(0);
    }
}
