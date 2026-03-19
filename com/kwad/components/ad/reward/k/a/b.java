package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.tachikoma.d.e;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.core.webview.tachikoma.d.e {
    private static WeakReference<b> CG;
    private g CD;
    private long CF;

    private static boolean kx() {
        WeakReference<b> weakReference = CG;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static b a(g gVar, e.b bVar) {
        b bVar2 = new b();
        bVar2.CD = gVar;
        bVar2.mAdResultData = bVar.iy();
        bVar2.Cz = bVar.getTemplateId();
        bVar2.ajt = bVar.lr();
        bVar2.ajD = bVar.wj();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    public static b a(b bVar, Activity activity, long j, com.kwad.components.core.webview.tachikoma.f.c cVar, e.a aVar) {
        if (activity == null || activity.isFinishing() || kx()) {
            return null;
        }
        bVar.ZP = cVar;
        bVar.aju = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j > 0) {
            bVar.q(j);
        }
        CG = new WeakReference<>(bVar);
        return bVar;
    }

    public static b a(g gVar, Activity activity, long j, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.tachikoma.f.c cVar) {
        if (activity == null || activity.isFinishing() || kx()) {
            return null;
        }
        e.b bVar = new e.b();
        bVar.a(gVar.mAdResultData);
        bVar.bo(com.kwad.sdk.core.response.b.b.eo(gVar.mAdTemplate));
        b bVarA = a(gVar, bVar);
        bVarA.ZP = cVar;
        bVarA.d(onDismissListener);
        bVarA.q(j);
        bVarA.show(activity.getFragmentManager(), "tkExtraReward");
        CG = new WeakReference<>(bVarA);
        return bVarA;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.b ky() {
        return new a(this.CD);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.c kz() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final void kA() {
        super.kA();
        this.ajp.CF = this.CF;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.CD = null;
        CG = null;
    }

    private void q(long j) {
        this.CF = j;
        if (this.ajp != null) {
            this.ajp.CF = j;
        }
    }
}
