package com.bytedance.common.utility;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ICustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2000;
    public static final int LENGTH_WITH_ICON = 1500;

    void dismissCustomToast();

    void showCustomLongToast(int i, String str);

    void showCustomToast(int i, String str);

    void showCustomToast(int i, String str, int i2, int i3);

    void showCustomToast(String str);

    void showCustomToast(String str, int i, int i2);
}
