package com.baidu.mobads.container.landingpage;

import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z implements View.OnLayoutChangeListener {
    int a;
    final /* synthetic */ App2Activity b;

    z(App2Activity app2Activity) {
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
            return;
        }
        int i9 = this.a - rect.bottom;
        int displayHeight = this.b.mRlViewTop == 0.0f ? (this.b.getDisplayHeight() - this.b.mVideoHeight) - i9 : this.b.getDisplayHeight() - i9;
        if (i9 <= 200) {
            if (i7 == i3 && this.b.mIsShowKeyboard) {
                this.b.executeJavaScript(this.b.mKeyboardOptimizeJsUtils.a(displayHeight, 0));
            }
            this.b.mIsShowKeyboard = false;
        } else if (i7 == i3) {
            this.b.mIsShowKeyboard = true;
            this.b.executeJavaScript(this.b.mKeyboardOptimizeJsUtils.a(displayHeight, i9));
        }
        this.a = rect.bottom;
    }
}
