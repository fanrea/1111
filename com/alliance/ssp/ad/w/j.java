package com.alliance.ssp.ad.w;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.video.VideoController;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: NMInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ com.alliance.ssp.ad.impl.interstitial.a b;

    public j(com.alliance.ssp.ad.impl.interstitial.a aVar, View view) {
        this.b = aVar;
        this.a = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) throws IllegalStateException, IllegalAccessException, JSONException, NoSuchFieldException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, ClassNotFoundException, IOException, InvalidKeyException, IllegalArgumentException, InvocationTargetException {
        int i = com.alliance.ssp.ad.o0.l.a;
        Activity activityB = com.alliance.ssp.ad.o0.b.b();
        if (activityB != null) {
            this.b.j1 = activityB.getRequestedOrientation();
            if (com.alliance.ssp.ad.o0.i.k(activityB)) {
                activityB.setRequestedOrientation(0);
            } else {
                activityB.setRequestedOrientation(1);
            }
        }
        this.b.a(0, 0, (String) null);
        VideoController videoController = this.b.L1;
        if (videoController != null) {
            videoController.c();
        }
        this.b.B();
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.b;
        aVar.t("", "", aVar.h);
        VideoController videoController2 = this.b.L1;
        if (videoController2 != null) {
            videoController2.i();
        }
        this.b.b(this.a.findViewById(R.id.express_show_view));
        com.alliance.ssp.ad.l.l lVar = this.b.h1;
        if (lVar != null) {
            lVar.c();
        }
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.b.f);
        com.alliance.ssp.ad.impl.interstitial.a aVar2 = this.b;
        com.alliance.ssp.ad.t.h hVar = aVar2.E;
        if (hVar != null) {
            hVar.a(contextA, aVar2.x1, aVar2.I1);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
