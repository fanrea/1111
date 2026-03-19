package com.kwad.tachikoma.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends TKBaseNativeModule {
    private FrameLayout Bx;

    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void a(FrameLayout frameLayout) {
        this.Bx = frameLayout;
    }

    public final void d(V8Object v8Object) {
        com.tk.core.component.e eVar = (com.tk.core.component.e) getNativeModule(v8Object);
        if (eVar != null) {
            eVar.pL();
            View view = eVar.getView();
            FrameLayout frameLayout = this.Bx;
            if (frameLayout == null || view == null) {
                return;
            }
            frameLayout.removeAllViews();
            this.Bx.addView(view);
        }
    }

    public final void e(V8Object v8Object) {
        com.tk.core.component.e eVar = (com.tk.core.component.e) getNativeModule(v8Object);
        if (eVar != null) {
            eVar.pL();
            ViewGroup viewGroup = (ViewGroup) eVar.getView();
            FrameLayout frameLayout = this.Bx;
            if (frameLayout == null || viewGroup == null) {
                return;
            }
            frameLayout.removeView(viewGroup);
        }
    }

    public final void removeAll() {
        this.Bx.removeAllViews();
    }
}
