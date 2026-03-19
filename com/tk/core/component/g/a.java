package com.tk.core.component.g;

import android.widget.Toast;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public String content;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void show() {
        Toast.makeText(com.tk.core.a.Yb, this.content, 1).show();
    }
}
