package com.tk.core.o;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class e {
    private static volatile e aiP;
    private String aiI;
    private String aiJ;
    private String aiK;
    private int aiL = 0;
    private int aiM = 0;
    private int aiN = 0;
    private int aiO = 0;

    public static String sC() {
        return "Android";
    }

    public static e sy() {
        if (aiP == null) {
            synchronized (e.class) {
                if (aiP == null) {
                    aiP = new e();
                }
            }
        }
        return aiP;
    }

    public final void dZ(int i) {
        this.aiN = i;
    }

    public final void ea(int i) {
        this.aiO = i;
    }

    public final String sz() {
        if (TextUtils.isEmpty(this.aiI)) {
            this.aiI = com.tk.core.bridge.d.F(s.getContext());
        }
        return this.aiI;
    }

    public final String getAppVersion() {
        if (TextUtils.isEmpty(this.aiJ)) {
            this.aiJ = com.tk.core.bridge.d.G(s.getContext());
        }
        return this.aiJ;
    }

    public final String sA() {
        if (TextUtils.isEmpty(this.aiJ)) {
            this.aiJ = com.tk.core.bridge.d.G(s.getContext());
        }
        return this.aiJ;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static float sB() {
        return o.getDisplayMetrics().density;
    }

    private String getKpn() {
        if (TextUtils.isEmpty(this.aiK)) {
            com.tk.core.a.oP().getCommonParams();
            this.aiK = null;
        }
        return this.aiK;
    }

    public final String getProductName() {
        return getKpn();
    }

    public final int sD() {
        if (this.aiL == 0) {
            Point pointAa = ae.aa(s.getContext());
            this.aiL = o.ec(pointAa.x);
            this.aiM = o.ec(pointAa.y);
        }
        return this.aiL;
    }

    public final int sE() {
        if (this.aiM == 0) {
            Point pointAa = ae.aa(s.getContext());
            this.aiL = o.ec(pointAa.x);
            this.aiM = o.ec(pointAa.y);
        }
        return this.aiM;
    }

    public final int P(Context context) {
        if (!(context instanceof Activity)) {
            return o.ec(ae.P(context));
        }
        a aVarB = b((Activity) context);
        if (aVarB.aiQ) {
            return aVarB.height > 0 ? aVarB.height : o.ec(ae.P(context));
        }
        return 0;
    }

    private static boolean Q(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private a b(Activity activity) {
        View viewFindViewById;
        a aVar = new a();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getId() == 16908336) {
                if (childAt.isShown()) {
                    aVar.aiQ = true;
                    if (Q(activity)) {
                        aVar.height = o.ec(childAt.getVisibility() == 0 ? childAt.getWidth() : 0);
                    } else {
                        aVar.height = o.ec(childAt.getVisibility() == 0 ? childAt.getHeight() : 0);
                    }
                }
                i = 1;
            } else {
                i++;
            }
        }
        if (i == 0 && Build.VERSION.SDK_INT >= 21 && (viewFindViewById = viewGroup.findViewById(R.id.navigationBarBackground)) != null && viewFindViewById.isShown()) {
            aVar.aiQ = true;
        }
        return aVar;
    }

    class a {
        boolean aiQ = false;
        int height = 0;

        a() {
        }
    }
}
