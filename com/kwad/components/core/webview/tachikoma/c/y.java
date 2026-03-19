package com.kwad.components.core.webview.tachikoma.c;

import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class y extends com.kwad.sdk.core.response.a.a {
    public String ajn;
    public int errorCode;
    public String errorReason;
    public int sp;

    public final boolean wb() {
        return TextUtils.equals("start", this.ajn);
    }

    public final boolean wc() {
        return TextUtils.equals(PointCategory.END, this.ajn);
    }

    public final boolean isFailed() {
        return TextUtils.equals(com.alipay.sdk.m.u.h.i, this.ajn);
    }

    public final boolean wd() {
        return TextUtils.equals("progress", this.ajn);
    }

    public final boolean we() {
        return TextUtils.equals("pause", this.ajn);
    }

    public final boolean wf() {
        return TextUtils.equals("resume", this.ajn);
    }

    public final int wg() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
