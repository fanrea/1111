package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.l6;
import org.json.JSONException;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pd {

    /* compiled from: A */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e2.values().length];
            a = iArr;
            try {
                iArr[e2.UNIFIED_INTERSTITIAL_FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e2.REWARDVIDEOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void a(h4 h4Var, View view, int i) {
        pro.getVresult(339, 1, h4Var, view, Integer.valueOf(i));
    }

    public static void a(h4 h4Var, kk kkVar, boolean z, int i) {
        pro.getVresult(340, 1, h4Var, kkVar, Boolean.valueOf(z), Integer.valueOf(i));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ h4 b;
        final /* synthetic */ int c;

        @Override // java.lang.Runnable
        public void run() {
            ad.a(u2.a().c(this.a), this.b, null, this.c, null);
        }

        a(View view, h4 h4Var, int i) {
            this.a = view;
            this.b = h4Var;
            this.c = i;
        }
    }

    public static void a(cz czVar, i6 i6Var, boolean z, View view) throws JSONException {
        h4 h4VarA = i6Var.a();
        if (h4VarA == null) {
            return;
        }
        boolean z2 = (i6Var.g || i6Var.n) && !h4VarA.A1();
        i6Var.n = z2;
        j6.a(new l6.b(h4VarA).a(i6Var.b).d(i6Var.e).a((i6Var.g || z || !i6Var.t) ? false : true).b(h4VarA.k1()).c(i6Var.r).a(i6Var).a(), czVar);
        zv.a(view, h4VarA, i6Var.b);
        if (z2) {
            qn.a(h4VarA.k(), f5.a(h4VarA));
        }
    }

    public static int a(h4 h4Var, boolean z) {
        if (z) {
            return 8;
        }
        if (a(h4Var.k())) {
            return 147;
        }
        if (jb.a(h4Var)) {
            return 120;
        }
        return ef.a(h4Var) ? 105 : 96;
    }

    public static boolean a(h4 h4Var) {
        if (h4Var == null) {
            return false;
        }
        return r1.d().f().a(h4Var.k().h() ? "ibcke" : "rbcke", h4Var.y0(), 0) == 1;
    }

    public static boolean a(e2 e2Var) {
        if (e2Var == null) {
            return false;
        }
        int i = b.a[e2Var.ordinal()];
        if (i == 1) {
            return fn.a();
        }
        if (i != 2) {
            return false;
        }
        return dx.a();
    }

    private static void a(Context context, Intent intent, boolean z) {
        if (z) {
            intent.setClassName(context, wx.c());
        } else {
            intent.setClassName(context, wx.d());
        }
    }

    public static void a(Context context, h4 h4Var, boolean z) {
        yp.f();
        if (context == null) {
            context = r1.d().a();
            z = true;
        }
        Intent intent = new Intent();
        if (z) {
            intent.addFlags(268435456);
        }
        boolean zA = r1.d().c().A();
        yq yqVarP0 = h4Var.p0();
        a(context, intent, zA);
        if (yqVarP0 != null) {
            if (yqVarP0.B() && zA) {
                a(context, intent, true);
            } else if (!yqVarP0.B() && !zA) {
                a(context, intent, false);
            }
        }
        ((ud) zm.a(h4Var.s0(), ud.class)).a(h4Var);
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.FULLSCREEN_ACTIVITY);
        intent.putExtra("appid", h4Var.n());
        intent.putExtra("objectId", h4Var.s0());
        i20.a().c(1).a();
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void a(String str, String str2, int i, long j, String str3, String str4, f5 f5Var) throws JSONException {
        wt wtVarB = new wt(i == 1 ? 2020031 : i == 2 ? 2020034 : 2020030).b(j);
        wtVarB.a(f5Var);
        int iB = r1.d().c().p().b();
        ja jaVar = new ja();
        jaVar.a("adType", str);
        jaVar.a("area", str2);
        jaVar.a("nt", Integer.valueOf(iB));
        jaVar.a("wu", str3);
        if (!TextUtils.isEmpty(str4)) {
            jaVar.a("errorMsg", str4);
        }
        wtVarB.a(jaVar);
        b10.a(wtVarB);
    }
}
