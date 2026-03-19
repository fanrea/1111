package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e implements d {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i, int i2, int i3) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i, String str2, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, String str2, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, Throwable th, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void b(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public void b(String str, String str2, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void c(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void d(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void e(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void f(String str, f fVar) {
    }

    @Override // com.kwad.sdk.core.download.d
    public final void g(String str, f fVar) {
    }

    public e(AdTemplate adTemplate) {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
    }

    @Override // com.kwad.sdk.core.download.d
    public final String pL() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.d
    public final String pM() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }
}
