package com.lingku.xuanshang.xutils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface ViewInjector {
    View inject(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup);

    void inject(Activity activity);

    void inject(View view);

    void inject(Object obj, View view);
}
