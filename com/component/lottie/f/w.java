package com.component.lottie.f;

import android.graphics.Color;
import android.graphics.Rect;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.component.lottie.d.c.g;
import com.component.lottie.f.a.c;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class w {
    private static final c.a a = c.a.a("nm", "ind", "refId", "ty", "parent", com.baidu.mobads.container.adrequest.g.f719K, "sh", Config.STAT_SDK_CHANNEL, "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", Config.STAT_SDK_TYPE, "w", "h", "ip", Config.OPERATOR, "tm", "cl", LiveConfigKey.HIGH);
    private static final c.a b = c.a.a("d", "a");
    private static final c.a c = c.a.a("ty", "nm");

    private w() {
    }

    public static com.component.lottie.d.c.g a(com.component.lottie.t tVar) {
        Rect rectE = tVar.e();
        return new com.component.lottie.d.c.g(Collections.emptyList(), tVar, "__container", -1L, g.a.PRE_COMP, -1L, null, Collections.emptyList(), new com.component.lottie.d.a.l(), 0, 0, 0, 0.0f, 0.0f, rectE.width(), rectE.height(), null, null, Collections.emptyList(), g.b.NONE, null, false, null, null);
    }

    public static com.component.lottie.d.c.g a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar) {
        ArrayList arrayList;
        ArrayList arrayList2;
        g.b bVar = g.b.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cVar.c();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        g.b bVar2 = bVar;
        String strI = "UNSET";
        g.a aVar = null;
        String strI2 = null;
        com.component.lottie.d.a.l lVarA = null;
        com.component.lottie.d.a.j jVarF = null;
        com.component.lottie.d.a.k kVarA = null;
        com.component.lottie.d.a.b bVarA = null;
        com.component.lottie.d.b.a aVarA = null;
        j jVarA = null;
        long jL = 0;
        long jL2 = -1;
        float fK = 0.0f;
        int iL = 0;
        int iL2 = 0;
        int color = 0;
        float fK2 = 1.0f;
        float fK3 = 0.0f;
        int iL3 = 0;
        int iL4 = 0;
        boolean zJ = false;
        float fH = 0.0f;
        String strI3 = null;
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    strI = cVar.i();
                    break;
                case 1:
                    jL = cVar.l();
                    break;
                case 2:
                    strI2 = cVar.i();
                    break;
                case 3:
                    int iL5 = cVar.l();
                    if (iL5 < g.a.UNKNOWN.ordinal()) {
                        aVar = g.a.values()[iL5];
                        break;
                    } else {
                        aVar = g.a.UNKNOWN;
                        break;
                    }
                case 4:
                    jL2 = cVar.l();
                    break;
                case 5:
                    iL = (int) (cVar.l() * com.component.lottie.g.g.a());
                    break;
                case 6:
                    iL2 = (int) (cVar.l() * com.component.lottie.g.g.a());
                    break;
                case 7:
                    color = Color.parseColor(cVar.i());
                    break;
                case 8:
                    lVarA = c.a(cVar, tVar);
                    break;
                case 9:
                    int iL6 = cVar.l();
                    if (iL6 >= g.b.values().length) {
                        tVar.a("Unsupported matte type: " + iL6);
                        break;
                    } else {
                        bVar2 = g.b.values()[iL6];
                        switch (x.a[bVar2.ordinal()]) {
                            case 1:
                                tVar.a("Unsupported matte type: Luma");
                                break;
                            case 2:
                                tVar.a("Unsupported matte type: Luma Inverted");
                                break;
                        }
                        tVar.a(1);
                        break;
                    }
                case 10:
                    cVar.a();
                    while (cVar.e()) {
                        arrayList3.add(z.a(cVar, tVar));
                    }
                    tVar.a(arrayList3.size());
                    cVar.b();
                    break;
                case 11:
                    cVar.a();
                    while (cVar.e()) {
                        com.component.lottie.d.b.c cVarA = h.a(cVar, tVar);
                        if (cVarA != null) {
                            arrayList4.add(cVarA);
                        }
                    }
                    cVar.b();
                    break;
                case 12:
                    cVar.c();
                    while (cVar.e()) {
                        switch (cVar.a(b)) {
                            case 0:
                                jVarF = d.f(cVar, tVar);
                                break;
                            case 1:
                                cVar.a();
                                if (cVar.e()) {
                                    kVarA = b.a(cVar, tVar);
                                }
                                while (cVar.e()) {
                                    cVar.m();
                                }
                                cVar.b();
                                break;
                            default:
                                cVar.h();
                                cVar.m();
                                break;
                        }
                    }
                    cVar.d();
                    break;
                case 13:
                    cVar.a();
                    ArrayList arrayList5 = new ArrayList();
                    while (cVar.e()) {
                        cVar.c();
                        while (cVar.e()) {
                            switch (cVar.a(c)) {
                                case 0:
                                    int iL7 = cVar.l();
                                    if (iL7 == 29) {
                                        aVarA = e.a(cVar, tVar);
                                        break;
                                    } else if (iL7 != 25) {
                                        break;
                                    } else {
                                        jVarA = new k().a(cVar, tVar);
                                        break;
                                    }
                                case 1:
                                    arrayList5.add(cVar.i());
                                    break;
                                default:
                                    cVar.h();
                                    cVar.m();
                                    break;
                            }
                        }
                        cVar.d();
                    }
                    cVar.b();
                    tVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    fK2 = (float) cVar.k();
                    break;
                case 15:
                    fK3 = (float) cVar.k();
                    break;
                case 16:
                    iL3 = (int) (cVar.l() * com.component.lottie.g.g.a());
                    break;
                case 17:
                    iL4 = (int) (cVar.l() * com.component.lottie.g.g.a());
                    break;
                case 18:
                    fK = (float) cVar.k();
                    break;
                case 19:
                    fH = (float) cVar.k();
                    break;
                case 20:
                    bVarA = d.a(cVar, tVar, false);
                    break;
                case 21:
                    strI3 = cVar.i();
                    break;
                case 22:
                    zJ = cVar.j();
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        ArrayList arrayList6 = new ArrayList();
        if (fK <= 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new com.component.lottie.h.a(tVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(fK)));
        }
        if (fH <= 0.0f) {
            fH = tVar.h();
        }
        arrayList2.add(new com.component.lottie.h.a(tVar, fValueOf, fValueOf, null, fK, Float.valueOf(fH)));
        arrayList2.add(new com.component.lottie.h.a(tVar, fValueOf2, fValueOf2, null, fH, Float.valueOf(Float.MAX_VALUE)));
        if (strI.endsWith(".ai") || "ai".equals(strI3)) {
            tVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new com.component.lottie.d.c.g(arrayList4, tVar, strI, jL, aVar, jL2, strI2, arrayList, lVarA, iL, iL2, color, fK2, fK3, iL3, iL4, jVarF, kVarA, arrayList2, bVar2, bVarA, zJ, aVarA, jVarA);
    }
}
