package com.lingku.xuanshang.core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ViewWelcome extends RelativeLayout {
    public ViewWelcome(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewWelcome(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.inflate(context, e.a().a("lkxs_view_welcome"), this);
    }
}
