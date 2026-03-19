package com.bytedance.msdk.core.tt;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.core.tc.tc;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    protected static List<tc> d(com.bytedance.msdk.core.tc.hc hcVar, String str) {
        return d(hcVar, str, 0.0d, 0.0d);
    }

    public static List<tc> d(com.bytedance.msdk.core.tc.hc hcVar, String str, double d, double d2) {
        int i;
        double d3;
        if (hcVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        com.bytedance.msdk.core.tc.c cVarU = com.bytedance.msdk.core.hc.hc().u(str);
        if (cVarU != null) {
            double d4 = cVarU.d();
            double dHc = cVarU.hc();
            int iB = cVarU.b();
            if (hcVar.an() == 3 || hcVar.an() == 4) {
                i = 1;
                double[] dArrD = hc.c().d(hcVar.an(), d, d2, hcVar.us(), str);
                double d5 = dArrD[0];
                hcVar.u().put("price_from", Integer.valueOf((int) dArrD[1]));
                d3 = d5;
            } else if (hcVar.an() == 2) {
                d3 = hc.c().d(3, str, iB);
                i = 1;
            } else {
                i = 1;
                d3 = 0.0d;
            }
            if (!cVarU.u() && d3 > 0.0d) {
                if (cVarU.getType() == i) {
                    hc(d3, d4, dHc, hcVar, copyOnWriteArrayList);
                } else if (cVarU.getType() == 2) {
                    d(d3, d4, dHc, hcVar, copyOnWriteArrayList);
                }
                List<com.bytedance.msdk.core.tc.b> listAn = com.bytedance.msdk.core.hc.hc().an(String.valueOf(hcVar.ba()));
                if (listAn != null) {
                    Iterator<com.bytedance.msdk.core.tc.b> it = listAn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bytedance.msdk.core.tc.b next = it.next();
                        if (d3 > next.an() && d3 <= next.u()) {
                            hcVar.u().put("user_label_value", next);
                            break;
                        }
                    }
                }
            }
            hcVar.u().put("rule_id", cVarU.c());
            hcVar.u().put(SplashAd.KEY_BIDFAIL_ECPM, Double.valueOf(d3));
            hcVar.u().put("rule_in_use", Integer.valueOf(copyOnWriteArrayList.size() == 0 ? 0 : i));
            hcVar.u().put("group_type", Integer.valueOf(hcVar.an()));
        }
        if (com.bytedance.msdk.d.u.b.hc()) {
            if (copyOnWriteArrayList.size() != 0) {
                for (int i2 = 0; i2 < copyOnWriteArrayList.size(); i2++) {
                    com.bytedance.msdk.d.u.b.d("DynamicRuleCalculate", "rit：" + ((tc) copyOnWriteArrayList.get(i2)).yo() + ",level：" + ((tc) copyOnWriteArrayList.get(i2)).np());
                }
            } else {
                com.bytedance.msdk.d.u.b.d("DynamicRuleCalculate", "走原waterfall，inUse ： 不生效");
            }
        }
        return copyOnWriteArrayList.size() != 0 ? copyOnWriteArrayList : hcVar.y();
    }

    private static void d(double d, double d2, double d3, com.bytedance.msdk.core.tc.hc hcVar, List<tc> list) {
        if (hcVar == null || d2 == 0.0d || d < hcVar.np()) {
            return;
        }
        if (d > hcVar.v() && d3 <= 0.0d) {
            list.addAll(hcVar.y());
        } else {
            d(hcVar, d, d2, d3, list);
        }
    }

    public static void d(com.bytedance.msdk.core.tc.hc hcVar, double d, double d2, double d3, List<tc> list) {
        Map<Integer, List<tc>> mapNv = hcVar.nv();
        if (mapNv != null) {
            ArrayList arrayList = new ArrayList(mapNv.keySet());
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((Integer) arrayList.get(i2)).intValue() > 0) {
                    arrayList2.add(arrayList.get(i2));
                } else {
                    List<tc> list2 = mapNv.get(arrayList.get(i2));
                    if (list2 != null) {
                        list.addAll(list2);
                    }
                }
            }
            com.bytedance.msdk.core.h.hc.d(arrayList2);
            int size = arrayList2.size();
            if (size <= 0) {
                return;
            }
            int iMax = -1;
            int iMin = size;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                double d4 = i3;
                List<tc> list3 = mapNv.get(arrayList2.get(i3));
                if (list3 != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list3.size()) {
                            break;
                        }
                        tc tcVar = list3.get(i4);
                        if (tcVar != null && tcVar.rf() == 0) {
                            double dDoubleValue = BigDecimal.valueOf(tcVar.v()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            if (d == dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) (d4 - d2), 0);
                                }
                                if (iMin == size || d == dDoubleValue) {
                                    if (d3 > 0.0d) {
                                        iMin = Math.min((int) (d4 + d3), size - 1);
                                    }
                                }
                            } else if (d > dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) Math.ceil(((d4 + (d4 - 1.0d)) / 2.0d) - d2), 0);
                                }
                                if (iMin == size) {
                                    if (d3 > 0.0d) {
                                        iMin = Math.min((int) Math.floor(((d4 + (d4 - 1.0d)) / 2.0d) + d3), size - 1);
                                    }
                                }
                            }
                        }
                        i4++;
                    }
                    iMin = size - 1;
                }
            }
            if (iMax < 0) {
                iMax = 0;
            }
            if (iMin >= size) {
                iMin = size - 1;
            }
            int i5 = iMax;
            double d5 = -1.0d;
            double dV = -1.0d;
            double dV2 = -1.0d;
            while (i5 <= iMin) {
                List<tc> list4 = mapNv.get(arrayList2.get(i5));
                if (list4 != null && list4.size() != 0) {
                    while (i < list4.size()) {
                        tc tcVar2 = list4.get(i);
                        if (tcVar2 != null) {
                            if (dV < tcVar2.v() || dV == -1.0d) {
                                dV = tcVar2.v();
                            }
                            if (dV2 > tcVar2.v() || dV2 == -1.0d) {
                                dV2 = tcVar2.v();
                            }
                            list.add(tcVar2);
                            if (i5 == iMax) {
                                d5 = dV;
                            }
                        }
                        i++;
                    }
                }
                i5++;
                i = 0;
            }
            hcVar.u().put("upper_cpm_x", Double.valueOf(d5));
            hcVar.u().put("max_ecpm", Double.valueOf(dV));
            hcVar.u().put("min_ecpm", Double.valueOf(dV2));
        }
    }

    private static void hc(double d, double d2, double d3, com.bytedance.msdk.core.tc.hc hcVar, List<tc> list) {
        if (d2 < d3 || d2 <= 0.0d || d < hcVar.np()) {
            return;
        }
        if (d > hcVar.v() && d3 <= 0.0d) {
            list.addAll(hcVar.y());
            return;
        }
        double dDoubleValue = BigDecimal.valueOf(d * d2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double dDoubleValue2 = BigDecimal.valueOf(d * d3).setScale(2, RoundingMode.HALF_UP).doubleValue();
        List<tc> listY = hcVar.y();
        double dV = -1.0d;
        double dV2 = -1.0d;
        for (int i = 0; i < listY.size(); i++) {
            tc tcVar = listY.get(i);
            if (tcVar.rf() == 0) {
                double dDoubleValue3 = BigDecimal.valueOf(tcVar.v()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                if (dDoubleValue3 <= dDoubleValue && dDoubleValue3 >= dDoubleValue2) {
                    if (dV == -1.0d || dV < tcVar.v()) {
                        dV = tcVar.v();
                    }
                    if (dV2 == -1.0d || dV2 > tcVar.v()) {
                        dV2 = tcVar.v();
                    }
                    list.add(tcVar);
                }
            } else {
                list.add(tcVar);
            }
        }
        hcVar.u().put("max_ecpm", Double.valueOf(dV));
        hcVar.u().put("min_ecpm", Double.valueOf(dV2));
        hcVar.u().put("upper_cpm_x", Double.valueOf(dDoubleValue));
    }
}
