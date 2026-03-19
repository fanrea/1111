package com.kwad.sdk.o;

import android.net.Uri;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private Uri ckF;
    private String ckG;

    public a(String str) {
        this.ckF = null;
        this.ckG = "";
        if (str != null) {
            this.ckG = str;
            this.ckF = Uri.parse(str);
        } else {
            this.ckG = "";
            this.ckF = Uri.parse("");
        }
    }

    public final String getType() {
        return this.ckF.getHost();
    }

    public final boolean ig(String str) {
        return this.ckF.getQueryParameterNames().contains(str);
    }

    public final String getUrl() {
        return this.ckG;
    }
}
