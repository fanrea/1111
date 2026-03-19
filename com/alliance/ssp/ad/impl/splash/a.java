package com.alliance.ssp.ad.impl.splash;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.o0.i;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.t.h;
import com.alliance.ssp.ad.video.VideoController;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;

/* compiled from: NMSplashAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements View.OnAttachStateChangeListener {
    public final /* synthetic */ NMSplashAdImpl a;

    public a(NMSplashAdImpl nMSplashAdImpl) {
        this.a = nMSplashAdImpl;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) throws IllegalStateException, IllegalAccessException, JSONException, NoSuchFieldException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, ClassNotFoundException, IOException, InvalidKeyException, IllegalArgumentException, InvocationTargetException {
        int i = l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.a.f);
        if (contextA != null) {
            if (contextA instanceof Activity) {
                Activity activity = (Activity) contextA;
                this.a.Z0 = activity.getRequestedOrientation();
                if (i.k(activity)) {
                    activity.setRequestedOrientation(0);
                } else {
                    activity.setRequestedOrientation(1);
                }
            } else {
                Activity activityB = com.alliance.ssp.ad.o0.b.b();
                if (activityB != null) {
                    this.a.Z0 = activityB.getRequestedOrientation();
                    if (i.k(activityB)) {
                        activityB.setRequestedOrientation(0);
                    } else {
                        activityB.setRequestedOrientation(1);
                    }
                }
            }
        }
        NMSplashAdImpl nMSplashAdImpl = this.a;
        if (nMSplashAdImpl.i1) {
            return;
        }
        nMSplashAdImpl.i1 = true;
        this.a.d(2);
        VideoController videoController = this.a.m1;
        if (videoController != null) {
            videoController.c();
        }
        this.a.B();
        NMSplashAdImpl nMSplashAdImpl2 = this.a;
        nMSplashAdImpl2.t("", "", nMSplashAdImpl2.h);
        NMSplashAdImpl nMSplashAdImpl3 = this.a;
        nMSplashAdImpl3.x1 = NMSplashAdImpl.SPLASH_STATE.SHOWING;
        VideoController videoController2 = nMSplashAdImpl3.m1;
        if (videoController2 != null) {
            videoController2.i();
        }
        NMSplashAdImpl nMSplashAdImpl4 = this.a;
        if (nMSplashAdImpl4.A >= 5.0f) {
            nMSplashAdImpl4.A = 4.0f;
        }
        TextView textView = nMSplashAdImpl4.P0;
        if (textView != null) {
            textView.setText("跳过 5");
        }
        com.alliance.ssp.ad.l.l lVar = this.a.C1;
        if (lVar != null) {
            lVar.c();
        }
        NMSplashAdImpl nMSplashAdImpl5 = this.a;
        h hVar = nMSplashAdImpl5.E;
        if (hVar != null) {
            hVar.a(contextA, nMSplashAdImpl5.X0, nMSplashAdImpl5.p1);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        int i = l.a;
        NMSplashAdImpl nMSplashAdImpl = this.a;
        nMSplashAdImpl.x1 = NMSplashAdImpl.SPLASH_STATE.NO_FORE;
        nMSplashAdImpl.q = true;
        com.alliance.ssp.ad.l.c cVar = this.a.R0;
        if (cVar != null) {
            cVar.a();
        }
    }
}
