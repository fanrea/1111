package android.support.v7.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.a.a;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class az {
    private final Context mContext;
    private final WindowManager.LayoutParams wA = new WindowManager.LayoutParams();
    private final Rect wB = new Rect();
    private final int[] wC = new int[2];
    private final int[] wD = new int[2];
    private final View wy;
    private final TextView wz;

    az(Context context) {
        this.mContext = context;
        this.wy = LayoutInflater.from(this.mContext).inflate(a.g.abc_tooltip, (ViewGroup) null);
        this.wz = (TextView) this.wy.findViewById(a.f.message);
        this.wA.setTitle(getClass().getSimpleName());
        this.wA.packageName = this.mContext.getPackageName();
        WindowManager.LayoutParams layoutParams = this.wA;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = a.i.Animation_AppCompat_Tooltip;
        this.wA.flags = 24;
    }

    final void a(View view, int i, int i2, boolean z, CharSequence charSequence) throws Resources.NotFoundException {
        if (isShowing()) {
            hide();
        }
        this.wz.setText(charSequence);
        a(view, i, i2, z, this.wA);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.wy, this.wA);
    }

    final void hide() {
        if (isShowing()) {
            ((WindowManager) this.mContext.getSystemService("window")).removeView(this.wy);
        }
    }

    private boolean isShowing() {
        return this.wy.getParent() != null;
    }

    private void a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) throws Resources.NotFoundException {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(a.d.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.mContext.getResources().getDimensionPixelOffset(z ? a.d.tooltip_y_offset_touch : a.d.tooltip_y_offset_non_touch);
        View viewAg = ag(view);
        if (viewAg == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewAg.getWindowVisibleDisplayFrame(this.wB);
        if (this.wB.left < 0 && this.wB.top < 0) {
            Resources resources = this.mContext.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.wB.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewAg.getLocationOnScreen(this.wD);
        view.getLocationOnScreen(this.wC);
        int[] iArr = this.wC;
        int i4 = iArr[0];
        int[] iArr2 = this.wD;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (viewAg.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.wy.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.wy.getMeasuredHeight();
        int[] iArr3 = this.wC;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i5 < 0) {
                layoutParams.y = i6;
                return;
            }
        } else if (measuredHeight + i6 <= this.wB.height()) {
            layoutParams.y = i6;
            return;
        }
        layoutParams.y = i5;
    }

    /* renamed from: android.support.v7.widget.az$1, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass1 implements View.OnClickListener {
        final android.support.v7.view.menu.a zH;

        AnonymousClass1() {
            this.zH = new android.support.v7.view.menu.a(az.this.zw.getContext(), 0, R.id.home, 0, 0, az.this.he);
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (az.this.zC == null || !az.this.zD) {
                return;
            }
            az.this.zC.onMenuItemSelected(0, this.zH);
        }
    }

    private static View ag(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
