package com.component.lottie.f;

import android.graphics.Rect;
import com.baidu.mobstat.forbes.Config;
import com.component.lottie.ax;
import com.component.lottie.d.c.g;
import com.component.lottie.f.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class y {
    private static final c.a b = c.a.a("w", "h", "ip", Config.OPERATOR, "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    static c.a a = c.a.a("id", "layers", "w", "h", "p", com.kuaishou.weapon.p0.t.i);
    private static final c.a c = c.a.a("list");
    private static final c.a d = c.a.a("cm", "tm", "dr");

    public static com.component.lottie.t a(com.component.lottie.f.a.c cVar) {
        HashMap map;
        ArrayList arrayList;
        com.component.lottie.f.a.c cVar2 = cVar;
        float fA = com.component.lottie.g.g.a();
        com.component.lottie.b.b<com.component.lottie.d.c.g> bVar = new com.component.lottie.b.b<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        com.component.lottie.b.e<com.component.lottie.d.d> eVar = new com.component.lottie.b.e<>();
        com.component.lottie.t tVar = new com.component.lottie.t();
        cVar.c();
        int iL = 0;
        float fK = 0.0f;
        float fK2 = 0.0f;
        float fK3 = 0.0f;
        int iL2 = 0;
        while (cVar.e()) {
            switch (cVar2.a(b)) {
                case 0:
                    iL = cVar.l();
                    cVar2 = cVar;
                    continue;
                case 1:
                    iL2 = cVar.l();
                    cVar2 = cVar;
                    continue;
                case 2:
                    fK = (float) cVar.k();
                    cVar2 = cVar;
                    continue;
                case 3:
                    fK2 = ((float) cVar.k()) - 0.01f;
                    map4 = map4;
                    arrayList3 = arrayList3;
                    cVar2 = cVar;
                    continue;
                case 4:
                    fK3 = (float) cVar.k();
                    map4 = map4;
                    arrayList3 = arrayList3;
                    cVar2 = cVar;
                    continue;
                case 5:
                    String[] strArrSplit = cVar.i().split("\\.");
                    if (com.component.lottie.g.g.a(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        map = map4;
                        arrayList = arrayList3;
                        break;
                    } else {
                        tVar.a("Lottie only supports bodymovin >= 4.4.0");
                        map = map4;
                        arrayList = arrayList3;
                        break;
                    }
                case 6:
                    a(cVar2, tVar, arrayList2, bVar);
                    map = map4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    a(cVar2, tVar, map2, map3);
                    map = map4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    a(cVar2, map4);
                    map = map4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    a(cVar2, tVar, eVar);
                    map = map4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    a(cVar2, arrayList3);
                    map = map4;
                    arrayList = arrayList3;
                    break;
                default:
                    map = map4;
                    arrayList = arrayList3;
                    cVar.h();
                    cVar.m();
                    break;
            }
            map4 = map;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        tVar.a(new Rect(0, 0, (int) (iL * fA), (int) (iL2 * fA)), fK, fK2, fK3, arrayList2, bVar, map2, map3, eVar, map4, arrayList3);
        return tVar;
    }

    private static void a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar, List<com.component.lottie.d.c.g> list, com.component.lottie.b.b<com.component.lottie.d.c.g> bVar) {
        cVar.a();
        int i = 0;
        while (cVar.e()) {
            com.component.lottie.d.c.g gVarA = w.a(cVar, tVar);
            if (gVarA.k() == g.a.IMAGE) {
                i++;
            }
            list.add(gVarA);
            bVar.d(gVarA.e(), gVarA);
            if (i > 4) {
                com.component.lottie.g.c.b("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.b();
    }

    private static void a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar, Map<String, List<com.component.lottie.d.c.g>> map, Map<String, ax> map2) {
        cVar.a();
        while (cVar.e()) {
            ArrayList arrayList = new ArrayList();
            com.component.lottie.b.b bVar = new com.component.lottie.b.b();
            cVar.c();
            String strI = null;
            String strI2 = null;
            String strI3 = null;
            int iL = 0;
            int iL2 = 0;
            while (cVar.e()) {
                switch (cVar.a(a)) {
                    case 0:
                        strI = cVar.i();
                        break;
                    case 1:
                        cVar.a();
                        while (cVar.e()) {
                            com.component.lottie.d.c.g gVarA = w.a(cVar, tVar);
                            bVar.d(gVarA.e(), gVarA);
                            arrayList.add(gVarA);
                        }
                        cVar.b();
                        break;
                    case 2:
                        iL = cVar.l();
                        break;
                    case 3:
                        iL2 = cVar.l();
                        break;
                    case 4:
                        strI2 = cVar.i();
                        break;
                    case 5:
                        strI3 = cVar.i();
                        break;
                    default:
                        cVar.h();
                        cVar.m();
                        break;
                }
            }
            cVar.d();
            if (strI2 != null) {
                ax axVar = new ax(iL, iL2, strI, strI2, strI3);
                map2.put(axVar.c(), axVar);
            } else {
                map.put(strI, arrayList);
            }
        }
        cVar.b();
    }

    private static void a(com.component.lottie.f.a.c cVar, Map<String, com.component.lottie.d.c> map) {
        cVar.c();
        while (cVar.e()) {
            switch (cVar.a(c)) {
                case 0:
                    cVar.a();
                    while (cVar.e()) {
                        com.component.lottie.d.c cVarA = n.a(cVar);
                        map.put(cVarA.b(), cVarA);
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
    }

    private static void a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar, com.component.lottie.b.e<com.component.lottie.d.d> eVar) {
        cVar.a();
        while (cVar.e()) {
            com.component.lottie.d.d dVarA = m.a(cVar, tVar);
            eVar.d(dVarA.hashCode(), dVarA);
        }
        cVar.b();
    }

    private static void a(com.component.lottie.f.a.c cVar, List<com.component.lottie.d.g> list) {
        cVar.a();
        while (cVar.e()) {
            cVar.c();
            float fK = 0.0f;
            String strI = null;
            float fK2 = 0.0f;
            while (cVar.e()) {
                switch (cVar.a(d)) {
                    case 0:
                        strI = cVar.i();
                        break;
                    case 1:
                        fK = (float) cVar.k();
                        break;
                    case 2:
                        fK2 = (float) cVar.k();
                        break;
                    default:
                        cVar.h();
                        cVar.m();
                        break;
                }
            }
            cVar.d();
            list.add(new com.component.lottie.d.g(strI, fK, fK2));
        }
        cVar.b();
    }
}
