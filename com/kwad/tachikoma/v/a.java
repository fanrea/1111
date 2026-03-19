package com.kwad.tachikoma.v;

import android.content.Context;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.tachikoma.t.g;
import com.kwad.tachikoma.v.c;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.view.TKView;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKView {
    private c.a Fl;
    private g Fm;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    @Override // com.tk.core.component.view.TKView, com.tk.core.component.e
    /* renamed from: s */
    public final com.tk.core.component.f n(Context context) {
        return new c(context);
    }

    public final void z(V8Function v8Function) {
        this.Fm = new g(v8Function, pO());
        if (this.Fl != null) {
            this.Fl = new c.a() { // from class: com.kwad.tachikoma.v.a.1
                @Override // com.kwad.tachikoma.v.c.a
                public final void cs(int i) {
                    if (a.this.Fm != null) {
                        a.this.Fm.call(null, Integer.valueOf(i));
                    }
                }
            };
            if (getView() == null || !(getView() instanceof c)) {
                return;
            }
            ((c) getView()).setOnWindowFocusChangeListener(this.Fl);
        }
    }

    public final int jf() {
        if (getView() == null || !(getView() instanceof c)) {
            return 0;
        }
        return ((c) getView()).getFocusState();
    }

    @Override // com.tk.core.component.view.TKView, com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        g gVar = this.Fm;
        if (gVar != null) {
            gVar.destroy();
        }
    }
}
