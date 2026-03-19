package com.kwad.tachikoma.o;

import android.content.IntentFilter;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends TKBaseNativeModule {
    private IntentFilter Ev;

    public b(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Ev = new IntentFilter();
    }

    public final void addAction(String str) {
        this.Ev.addAction(str);
    }

    public final void addDataScheme(String str) {
        this.Ev.addDataScheme(str);
    }

    public final String getDataScheme(int i) {
        return this.Ev.getDataScheme(i);
    }

    public final IntentFilter iT() {
        return this.Ev;
    }
}
