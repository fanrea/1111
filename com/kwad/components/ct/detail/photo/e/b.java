package com.kwad.components.ct.detail.photo.e;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class b {
    public static void a(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ct.detail.photo.e.b.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    b.K(view2);
                    return false;
                }
                if (action == 1) {
                    b.L(view2);
                    return false;
                }
                if (action != 3) {
                    return false;
                }
                b.L(view2);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(View view) {
        if (view != null) {
            view.animate().cancel();
            view.animate().scaleX(0.8f).scaleY(0.8f).setDuration(100L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(View view) {
        if (view != null) {
            view.animate().cancel();
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100L).start();
        }
    }
}
