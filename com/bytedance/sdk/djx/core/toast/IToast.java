package com.bytedance.sdk.djx.core.toast;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IToast {
    void cancel();

    View getView();

    IToast setAnimation(int i);

    IToast setDuration(int i);

    IToast setGravity(int i);

    IToast setGravity(int i, int i2, int i3);

    IToast setPriority(int i);

    IToast setText(int i, String str);

    IToast setText(int i, String str, float f);

    IToast setView(View view);

    void show();

    void showLong();
}
