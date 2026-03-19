package com.tk.core.f;

import android.text.TextUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public boolean ahX;
    public List<String> ahY;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final boolean cz(String str) {
        List<String> list;
        return (TextUtils.isEmpty(str) || (list = this.ahY) == null || !list.contains(str)) ? false : true;
    }
}
