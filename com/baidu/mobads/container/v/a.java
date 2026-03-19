package com.baidu.mobads.container.v;

import com.baidu.mobads.container.adrequest.n;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.components.j.c;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;

    public static void a(t tVar, int i, boolean z, int i2, int i3, String str, String str2) {
        if (tVar == null) {
            return;
        }
        try {
            by.a aVarA = by.a.a(tVar.t()).a(i3).c("rsplash").a(tVar.z()).a(tVar.q()).a("uniqueid", tVar.q().getUniqueId()).b(tVar.l()).a("rsplashtype", "" + i2).a("logversion", "4").a("p_ver", com.baidu.mobads.container.config.b.a().j()).a("isshowsended", "" + z).a("materialtype", tVar.q().getMaterialType()).a("impressionFrom", "" + str2).a("showstate", "" + i);
            if (i3 != 413) {
                if (i3 == 415) {
                    aVarA.a(n.B, n.a(tVar.q())).a(n.D, "splash_video").a("close_time", String.valueOf(System.currentTimeMillis()));
                    if (tVar.q() != null && tVar.q().getAdStatus() != null) {
                        aVarA.a(n.m, String.valueOf((System.currentTimeMillis() - tVar.q().getAdStatus().optLong(n.H, 0L)) / 1000.0f));
                    }
                }
            } else {
                aVarA.a(j.C, bk.a(tVar.q())).a("time", String.valueOf(System.currentTimeMillis())).a(tVar.q(), "rsplash");
                aVarA.a("adSrc", tVar.w() != null ? r2.optInt("adSrc", 0) : 0);
                aVarA.a(n.D, "splash");
            }
            if (str != null && !str.equals("")) {
                aVarA.a("showrecord", str);
            }
            com.baidu.mobads.container.components.j.c.a().a(tVar.z(), tVar.k(), tVar.l(), tVar.q(), c.d.e, "" + i3, "", 0, aVarA.d());
        } catch (Exception e) {
            bq.a().a(e.getMessage());
        }
    }
}
