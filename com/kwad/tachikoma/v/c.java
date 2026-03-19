package com.kwad.tachikoma.v;

import android.content.Context;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends com.tk.core.component.f {
    private int Fo;
    private a Fp;

    public interface a {
        void cs(int i);
    }

    public c(Context context) {
        super(context);
        this.Fo = 0;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.Fo = z ? 2 : 1;
        a aVar = this.Fp;
        if (aVar != null) {
            aVar.cs(this.Fo);
        }
    }

    public final int getFocusState() {
        if (Build.VERSION.SDK_INT >= 18) {
            return (getWindowId() == null || !getWindowId().isFocused()) ? 1 : 2;
        }
        return this.Fo;
    }

    public final void setOnWindowFocusChangeListener(a aVar) {
        this.Fp = aVar;
    }
}
