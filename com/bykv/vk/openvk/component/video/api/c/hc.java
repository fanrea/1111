package com.bykv.vk.openvk.component.video.api.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface hc<T> extends com.bykv.vk.openvk.component.video.api.hc.d {

    public enum d {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    View b();

    void d();

    void d(int i);

    void d(Drawable drawable);

    void d(T t, WeakReference<Context> weakReference, boolean z);

    void d(boolean z);

    void hc();
}
