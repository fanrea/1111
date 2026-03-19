package com.style.widget;

import android.app.Activity;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.style.widget.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements PopupWindow.OnDismissListener {
    final /* synthetic */ WindowManager.LayoutParams a;
    final /* synthetic */ a b;

    g(a aVar, WindowManager.LayoutParams layoutParams) {
        this.b = aVar;
        this.a = layoutParams;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ((Activity) this.b.b).getWindow().clearFlags(2);
        ((Activity) this.b.b).getWindow().setAttributes(this.a);
        if (this.b.c instanceof a.c) {
            ((a.c) this.b.c).b();
        }
    }
}
