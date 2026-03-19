package com.baidu.mobads.container.landingpage;

import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aa implements View.OnLayoutChangeListener {
    int a;
    final /* synthetic */ App2Activity b;

    aa(App2Activity app2Activity) {
        this.b = app2Activity;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Rect rect = new Rect();
        if (view == null) {
            return;
        }
        view.getWindowVisibleDisplayFrame(rect);
        if (rect.bottom == this.a || this.a == 0) {
            this.a = rect.bottom;
        } else if (this.a - rect.bottom > 200 && !this.b.mIsKeyBoardUp) {
            this.b.mIsKeyBoardUp = true;
        }
    }
}
