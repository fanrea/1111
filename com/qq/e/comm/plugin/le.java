package com.qq.e.comm.plugin;

import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class le {
    public static void c(h4 h4Var) {
        if (h4Var == null || h4Var.X() == 0) {
            return;
        }
        if (a(h4Var).equals(ExploreConstants.SCENE_REWARD)) {
            d(h4Var);
        } else {
            b(h4Var);
        }
    }

    private static void d(h4 h4Var) {
        f5 f5VarA = f5.a(h4Var);
        ax.a(f5VarA, h4Var.R() - h4Var.X());
        if (h4Var.Y0() > 0) {
            ax.d(f5VarA, h4Var.Y0() - h4Var.R());
        }
        List<Long> listW = h4Var.w();
        if (listW != null && listW.size() > 0) {
            Iterator<Long> it = listW.iterator();
            while (it.hasNext()) {
                ax.b(f5VarA, it.next().longValue() - h4Var.R());
            }
        }
        if (h4Var.Y() > 0) {
            ax.c(f5VarA, h4Var.Y() - h4Var.R());
        }
    }

    private static void b(h4 h4Var) {
        hn.a(f5.a(h4Var), h4Var.R() - h4Var.X());
        if (h4Var.Y0() > 0) {
            hn.d(f5.a(h4Var), h4Var.Y0() - h4Var.R());
        }
        List<Long> listW = h4Var.w();
        if (listW != null && listW.size() > 0) {
            Iterator<Long> it = listW.iterator();
            while (it.hasNext()) {
                hn.b(f5.a(h4Var), it.next().longValue() - h4Var.R());
            }
        }
        List<Long> listS = h4Var.s();
        if (listS != null && listS.size() > 0) {
            Iterator<Long> it2 = listS.iterator();
            while (it2.hasNext()) {
                hn.a(f5.a(h4Var), h4Var.W0(), it2.next().longValue() - h4Var.R());
            }
        }
        if (h4Var.Y() > 0) {
            hn.c(f5.a(h4Var), h4Var.Y() - h4Var.R());
        }
    }

    public static void e(h4 h4Var) {
        if (a(h4Var).equals(ExploreConstants.SCENE_REWARD)) {
            ax.c(f5.a(h4Var));
        }
    }

    public static void f(h4 h4Var) {
        String strA = a(h4Var);
        if (strA.equals(ExploreConstants.SCENE_REWARD)) {
            ax.d(f5.a(h4Var));
        } else if (strA.equals(ExploreConstants.SCENE_INTERSTITIAL)) {
            hn.b(f5.a(h4Var));
        }
    }

    private static String a(h4 h4Var) {
        return h4Var instanceof pw ? ExploreConstants.SCENE_REWARD : h4Var instanceof dn ? ExploreConstants.SCENE_INTERSTITIAL : "";
    }

    public static void a(h4 h4Var, int i) {
        b10.a(1403018, f5.a(h4Var), Integer.valueOf(i));
    }

    public static void a(h4 h4Var, boolean z) {
        if (a(h4Var).equals(ExploreConstants.SCENE_REWARD)) {
            return;
        }
        hn.a(z, f5.a(h4Var));
    }

    public static void a(j40 j40Var, h4 h4Var, long j, long j2, long j3) throws JSONException {
        String strA = a(h4Var);
        if (strA.equals(ExploreConstants.SCENE_REWARD) || strA.equals(ExploreConstants.SCENE_INTERSTITIAL)) {
            ax.a(j40Var, f5.a(h4Var), ax.a(j, j2, (int) j3, (String) null, (String) null));
        }
        if (ExploreConstants.SCENE_REWARD.equals(strA) || j40Var != j40.END) {
            return;
        }
        hn.c(f5.a(h4Var));
    }
}
