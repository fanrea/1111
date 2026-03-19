package com.tk.component.container.round;

import android.content.Context;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.component.container.round.RoundTKYogaLayout;
import com.tk.core.component.f;
import com.tk.core.component.view.TKView;
import com.tk.core.o.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKView {
    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    @Override // com.tk.core.component.view.TKView, com.tk.core.component.e
    /* renamed from: s */
    public final f n(Context context) {
        return new RoundTKYogaLayout(context);
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        super.bY(i);
        ((RoundTKYogaLayout) getView()).a(o.eb(i), RoundTKYogaLayout.RadiusMode.ALL);
    }

    @Override // com.tk.core.component.e
    public final void bZ(int i) {
        super.bZ(i);
        ((RoundTKYogaLayout) getView()).a(o.eb(i), RoundTKYogaLayout.RadiusMode.TOP_LEFT);
    }

    @Override // com.tk.core.component.e
    public final void ca(int i) {
        super.ca(i);
        ((RoundTKYogaLayout) getView()).a(o.eb(i), RoundTKYogaLayout.RadiusMode.TOP_RIGHT);
    }

    @Override // com.tk.core.component.e
    public final void cc(int i) {
        super.cc(i);
        ((RoundTKYogaLayout) getView()).a(o.eb(i), RoundTKYogaLayout.RadiusMode.BOTTOM_RIGHT);
    }

    @Override // com.tk.core.component.e
    public final void cb(int i) {
        super.cb(i);
        ((RoundTKYogaLayout) getView()).a(o.eb(i), RoundTKYogaLayout.RadiusMode.BOTTOM_LEFT);
    }
}
