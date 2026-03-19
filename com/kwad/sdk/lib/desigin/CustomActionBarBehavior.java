package com.kwad.sdk.lib.desigin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class CustomActionBarBehavior extends KSCoordinatorLayout.Behavior<RelativeLayout> {
    private int mActionBarBgColor;
    private float mActionBarColorChangeRange;
    private float mActionBarHeight;
    private Activity mActivity;

    protected abstract void initView(RelativeLayout relativeLayout);

    protected float transRatio(float f, float f2, float f3) {
        if (f3 < f) {
            return 0.0f;
        }
        if (f3 > f2) {
            return 1.0f;
        }
        return (f3 - f) / (f2 - f);
    }

    public CustomActionBarBehavior(Context context, AttributeSet attributeSet) {
        int dimension;
        super(context, attributeSet);
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
        Resources resources = context.getResources();
        if (resources != null) {
            this.mActionBarBgColor = -1;
            dimension = (int) resources.getDimension(R.dimen.ksad_title_bar_height);
        } else {
            dimension = 0;
        }
        int i = R.attr.ksad_action_bar_height;
        int i2 = R.attr.ksad_action_bar_bg_color;
        int[] iArr = {i, i2, R.attr.ksad_color_change_range};
        Arrays.sort(iArr);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.mActionBarHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i), dimension);
        this.mActionBarBgColor = typedArrayObtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i2), this.mActionBarBgColor);
        this.mActionBarColorChangeRange = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, r4), dimension);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean layoutDependsOn(KSCoordinatorLayout kSCoordinatorLayout, RelativeLayout relativeLayout, View view) {
        return view instanceof KSAppBarLayout;
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onDependentViewChanged(KSCoordinatorLayout kSCoordinatorLayout, RelativeLayout relativeLayout, View view) {
        onActionBarHeightChanged(relativeLayout, Math.min((-view.getTop()) / (this.mActionBarColorChangeRange - this.mActionBarHeight), 1.0f));
        return true;
    }

    public void setActionBarColorChangeRange(int i) {
        this.mActionBarColorChangeRange = i;
    }

    protected void onActionBarHeightChanged(RelativeLayout relativeLayout, float f) {
        initView(relativeLayout);
        relativeLayout.setBackgroundColor(getColorWithAlpha(transRatio(0.08f, 1.0f, f), this.mActionBarBgColor));
    }

    protected int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }
}
