package com.gyf.barlibrary;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BarParams implements Cloneable {
    int flymeOSStatusBarFontColor;
    OnKeyboardListener onKeyboardListener;
    View statusBarView;
    View titleBarView;
    int statusBarColor = 0;
    int navigationBarColor = -16777216;
    int defaultNavigationBarColor = -16777216;
    float statusBarAlpha = 0.0f;
    float navigationBarAlpha = 0.0f;
    public boolean fullScreen = false;
    boolean hideNavigationBar = false;
    BarHide barHide = BarHide.FLAG_SHOW_BAR;
    boolean statusBarDarkFont = false;
    boolean navigationBarDarkIcon = false;
    boolean autoStatusBarDarkModeEnable = false;
    boolean autoNavigationBarDarkModeEnable = false;
    float autoStatusBarDarkModeAlpha = 0.0f;
    float autoNavigationBarDarkModeAlpha = 0.0f;
    boolean statusBarColorEnabled = true;
    int statusBarColorTransform = -16777216;
    int navigationBarColorTransform = -16777216;
    Map<View, Map<Integer, Integer>> viewMap = new HashMap();
    float viewAlpha = 0.0f;
    int contentColor = 0;
    int contentColorTransform = -16777216;
    float contentAlpha = 0.0f;
    public boolean fits = false;
    boolean isSupportActionBar = false;
    public boolean keyboardEnable = false;
    int keyboardMode = 18;
    boolean navigationBarEnable = true;
    boolean navigationBarWithKitkatEnable = true;
    boolean navigationBarWithEMUI3Enable = true;

    @Deprecated
    boolean fixMarginAtBottom = false;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BarParams m451clone() {
        try {
            return (BarParams) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
