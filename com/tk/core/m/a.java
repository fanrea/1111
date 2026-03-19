package com.tk.core.m;

import android.os.SystemClock;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public static String sw() {
        return String.valueOf(SystemClock.elapsedRealtime());
    }

    public static String sx() {
        return String.valueOf(System.currentTimeMillis());
    }
}
