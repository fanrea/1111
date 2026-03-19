package com.kwad.tachikoma.h;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.tk.core.component.TKBaseNativeModule;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    static String t(String str) {
        return OfflineHostProvider.getApi().flowUuid().encryptLongToBase64(Long.parseLong(str));
    }

    static String u(String str) {
        return String.valueOf(OfflineHostProvider.getApi().flowUuid().decryptLongFromBase64(str));
    }
}
