package com.kwad.components.core.u;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l {
    public static void a(com.kwad.components.core.widget.f fVar, ViewGroup viewGroup) {
        if (fVar == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.e) {
                ((com.kwad.components.core.widget.e) childAt).a(fVar);
            } else if (childAt instanceof ViewGroup) {
                a(fVar, (ViewGroup) childAt);
            }
        }
    }

    public static void b(com.kwad.components.core.widget.f fVar, Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(fVar.wH());
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(fVar.wH());
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(fVar.wH());
        }
    }
}
