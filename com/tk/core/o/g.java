package com.tk.core.o;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g {
    public static View R(Context context) {
        InputMethodManager inputMethodManager;
        if (!(context instanceof Activity)) {
            return null;
        }
        Activity activity = (Activity) context;
        if (activity.getCurrentFocus() == null || activity.getCurrentFocus().getWindowToken() == null || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null || !inputMethodManager.isActive()) {
            return null;
        }
        return activity.getCurrentFocus();
    }

    public static void S(Context context) {
        bh(R(context));
    }

    public static void bh(final View view) {
        if (view == null || view.getWindowToken() == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.tk.core.o.g.1
            @Override // java.lang.Runnable
            public final void run() {
                view.clearFocus();
                j.bi(view);
            }
        });
    }
}
