package com.bytedance.sdk.component.uo;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface hc {

    public interface d {
        Pair<Boolean, Boolean> d(View view, MotionEvent motionEvent);
    }

    void setTag(int i, Object obj);

    void setTouchEventListener(d dVar);
}
