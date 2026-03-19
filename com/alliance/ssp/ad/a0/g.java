package com.alliance.ssp.ad.a0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationTargetException;

/* compiled from: NMStreamAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g implements View.OnClickListener {
    public final /* synthetic */ b a;

    public g(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int i;
        int i2;
        Activity activityB = com.alliance.ssp.ad.o0.b.b();
        if (activityB != null) {
            activityB.setRequestedOrientation(0);
            b bVar = this.a;
            bVar.getClass();
            try {
                Context contextA = com.alliance.ssp.ad.o0.b.a(bVar.f);
                bVar.H0.setVisibility(0);
                bVar.G0.setVisibility(8);
                FrameLayout.LayoutParams layoutParams = bVar.I0;
                if (contextA != null) {
                    WindowManager windowManager = (WindowManager) contextA.getSystemService("window");
                    Point point = new Point();
                    windowManager.getDefaultDisplay().getSize(point);
                    i = point.x;
                } else {
                    i = 360;
                }
                layoutParams.width = i;
                FrameLayout.LayoutParams layoutParams2 = bVar.I0;
                if (contextA != null) {
                    WindowManager windowManager2 = (WindowManager) contextA.getSystemService("window");
                    Point point2 = new Point();
                    windowManager2.getDefaultDisplay().getSize(point2);
                    i2 = point2.y;
                } else {
                    i2 = 540;
                }
                layoutParams2.height = i2;
                bVar.D0.setLayoutParams(bVar.I0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
