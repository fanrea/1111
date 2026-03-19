package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends FrameLayout {
    private boolean alz;
    protected Context mContext;
    protected h mI;
    protected boolean na;

    public g(Context context) {
        super(context);
        this.mContext = context;
        this.na = aq.apb();
    }

    public final void setOrientationChangeListener(h hVar) {
        this.mI = hVar;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.alz = i == 0;
        wI();
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        wI();
    }

    private void wI() {
        boolean zApb = aq.apb();
        if (!this.alz || zApb == this.na) {
            return;
        }
        this.na = zApb;
        h hVar = this.mI;
        if (hVar != null) {
            hVar.k(!zApb);
        }
    }
}
