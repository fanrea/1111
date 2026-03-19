package com.kwad.sdk.components;

import com.kwad.sdk.components.DevelopMangerComponents;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g {
    public static boolean encryptDisable() {
        return ev("KEY_HOST_ENCRYPT_DISABLE");
    }

    public static boolean ev(String str) {
        DevelopMangerComponents.DevelopValue developValueEu = d.eu(str);
        return developValueEu != null && ((Boolean) developValueEu.getValue()).booleanValue();
    }
}
