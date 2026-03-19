package com.kwad.components.offline.c;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements com.kwad.sdk.core.d.a.a {
    private final IObiwanLogcat bbL;

    public c(IObiwanLogcat iObiwanLogcat) {
        this.bbL = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        this.bbL.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z) {
        this.bbL.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        this.bbL.d(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        this.bbL.i(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        this.bbL.w(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z) {
        this.bbL.w(str, str2, z);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        this.bbL.e(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
        this.bbL.printStackTraceOnly(th);
    }
}
