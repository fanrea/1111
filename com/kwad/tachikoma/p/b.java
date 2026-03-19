package com.kwad.tachikoma.p;

import android.content.Context;
import android.view.View;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends e<a> {
    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return p(context);
    }

    public b(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    private static a p(Context context) {
        return new a(context);
    }

    public final void g(float f) {
        getView().setCurrent((int) (f * 100.0f));
    }
}
