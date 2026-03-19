package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class n extends PopupWindow {
    private static final boolean mF;
    private boolean mG;

    static {
        mF = Build.VERSION.SDK_INT < 21;
    }

    public n(Context context, AttributeSet attributeSet, int i, int i2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        av avVarA = av.a(context, attributeSet, a.j.PopupWindow, i, i2);
        if (avVarA.hasValue(a.j.PopupWindow_overlapAnchor)) {
            y(avVarA.getBoolean(a.j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(avVarA.getDrawable(a.j.PopupWindow_android_popupBackground));
        avVarA.recycle();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i, int i2) {
        if (mF && this.mG) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View view, int i, int i2, int i3) {
        if (mF && this.mG) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public final void update(View view, int i, int i2, int i3, int i4) {
        if (mF && this.mG) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    private void y(boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (mF) {
            this.mG = z;
        } else {
            android.support.v4.widget.i.a(this, z);
        }
    }
}
