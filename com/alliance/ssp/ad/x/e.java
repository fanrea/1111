package com.alliance.ssp.ad.x;

import android.content.pm.PackageManager;
import android.view.View;
import com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData;
import com.alliance.ssp.ad.l.l;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: NMNativeFeedAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements View.OnAttachStateChangeListener {
    public final /* synthetic */ c a;

    public e(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.a.a(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            c cVar = this.a;
            SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = cVar.l0;
            if (sAAllianceNativeFeedAdData.playerView != null) {
                sAAllianceNativeFeedAdData.isVideoStop = true;
                cVar.E();
            }
            c cVar2 = this.a;
            cVar2.J0 = false;
            l lVar = cVar2.g1;
            if (lVar != null) {
                lVar.b();
            }
            com.alliance.ssp.ad.c0.b bVar = this.a.I0;
            if (bVar != null) {
                bVar.a();
                this.a.I0 = null;
            }
            com.alliance.ssp.ad.m0.a aVar = this.a.h1;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMNativeFeedAdImpl 004: ")), e);
        }
    }
}
