package com.sigmob.sdk.mraid;

import android.content.Context;
import android.os.Build;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class p extends com.sigmob.sdk.base.views.g {
    private static final int a = 1;
    private a b;
    private boolean c;

    public interface a {
        void onVisibilityChanged(boolean isVisible);
    }

    public p(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT <= 22) {
            this.c = getVisibility() == 0;
        }
    }

    private void setMraidViewable(final boolean viewable) {
        if (this.c == viewable) {
            return;
        }
        this.c = viewable;
        a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.onVisibilityChanged(viewable);
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.b = null;
    }

    public boolean j() {
        return this.c;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            return;
        }
        setMraidViewable(false);
    }

    public void setVisibilityChangedListener(a listener) {
        this.b = listener;
    }
}
