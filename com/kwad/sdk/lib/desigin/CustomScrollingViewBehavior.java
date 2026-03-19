package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CustomScrollingViewBehavior extends KSAppBarLayout.ScrollingViewBehavior {
    public CustomScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.ScrollingViewBehavior, com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
    public int getScrollRange(View view) {
        if (view instanceof KSAppBarLayout) {
            Object behavior = ((KSCoordinatorLayout.LayoutParams) view.getLayoutParams()).getBehavior();
            if (behavior instanceof CustomAppBarCustomAttrListener) {
                return ((KSAppBarLayout) view).getTotalScrollRange() - ((CustomAppBarCustomAttrListener) behavior).getExtraFixedSize();
            }
            return ((KSAppBarLayout) view).getTotalScrollRange();
        }
        return super.getScrollRange(view);
    }
}
