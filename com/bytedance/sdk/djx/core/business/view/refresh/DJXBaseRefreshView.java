package com.bytedance.sdk.djx.core.business.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class DJXBaseRefreshView extends RelativeLayout implements IRefresh {
    public abstract void setReleaseToSecondFloor();

    public abstract void setToFirstFloor();

    public abstract void setToSecondFloor();

    public DJXBaseRefreshView(Context context) {
        this(context, null);
    }

    public DJXBaseRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
