package com.bytedance.msdk.core.u;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.api.d.hc;
import com.bytedance.msdk.core.u.hc.h;
import com.bytedance.msdk.d.u.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private final Map<String, Integer> d = new HashMap();
    private final Map<String, Integer> hc = new HashMap();

    public void d(String str, String str2, int i) {
        this.d.put(str + Config.replace + str2, Integer.valueOf(i));
    }

    public int d(String str, String str2) {
        Integer num = this.d.get(str + Config.replace + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public void hc(String str, String str2, int i) {
        this.hc.put(str + Config.replace + str2, Integer.valueOf(i));
    }

    public int hc(String str, String str2) {
        Integer num = this.hc.get(str + Config.replace + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    protected int d(h hVar, hc hcVar, hc hcVar2, String str) {
        if (hVar == null || hVar.d == null) {
            return 4;
        }
        String strV = hcVar2 != null ? hcVar2.v() : "";
        String strNw = hVar.d.nw();
        String strPh = hVar.d.ph();
        Integer numAn = hVar.d.an();
        if (numAn.intValue() == 1) {
            if (hVar.d.xp()) {
                b.d("TTMediationSDK", "--==-- " + str + ":广告已show过 ---: " + strNw + ", adSlotId: " + strPh);
                return 7;
            }
            if (d(strV, hVar.d)) {
                b.d("TTMediationSDK", "--==-- " + str + ":广告过期了(M配置) ---: " + strNw + ", adSlotId: " + strPh);
                return 2;
            }
            if (!d(hcVar, hcVar2, hVar.d)) {
                b.d("TTMediationSDK", "--==-- " + str + ":AdSlot不符合 ---: " + strNw + ", adSlotId: " + strPh);
                return 6;
            }
            b.d("TTMediationSDK", "--==-- " + str + ":复用成功：---" + strNw + ", adSlotId: " + strPh);
            return -1;
        }
        if (hVar.d.xp()) {
            b.d("TTMediationSDK", "--==-- " + str + ":广告已show过 ---: " + strNw + ", adSlotId: " + strPh);
            return 7;
        }
        if (numAn.intValue() == 3) {
            b.d("TTMediationSDK", "--==-- " + str + ":广告过期了(adn api) ---: " + strNw + ", adSlotId: " + strPh);
            return 1;
        }
        if (numAn.intValue() == 4) {
            b.d("TTMediationSDK", "--==-- " + str + ":isReady是false ---: " + strNw + ", adSlotId: " + strPh);
            return 5;
        }
        if (!d(hcVar, hcVar2, hVar.d)) {
            b.d("TTMediationSDK", "--==-- " + str + ":AdSlot不符合 ---: " + strNw + ", adSlotId: " + strPh);
            return 6;
        }
        b.d("TTMediationSDK", "--==-- " + str + ":复用成功：---" + strNw + ", adSlotId: " + strPh);
        return -1;
    }

    public final boolean d(String str, com.bytedance.msdk.hc.b bVar) {
        if (bVar == null || bVar.u()) {
            b.d("TTMediationSDK", "--==-- 广告已经destroy了，视为过期 ------");
            return true;
        }
        boolean z = SystemClock.elapsedRealtime() > bVar.ra() + ((long) d(str, bVar.ph()));
        b.d("TTMediationSDK", "--==-- 使用了配置的过期时间进行判断 ------");
        return z;
    }

    public static boolean d(hc hcVar, hc hcVar2, com.bytedance.msdk.hc.b bVar) {
        if (hcVar == null || hcVar2 == null) {
            b.d("TMe", "--==-- adSlot = null, a1: " + hcVar + ", a2: " + hcVar2);
            return false;
        }
        if (hcVar.fs() != hcVar2.fs()) {
            b.d("TMe", "--==-- orientation, a1: " + hcVar.fs() + ", a2: " + hcVar2.fs());
            return false;
        }
        if (hcVar.ba() != hcVar2.ba()) {
            b.d("TMe", "--==-- isMuted, a1: " + hcVar.ba() + ", a2: " + hcVar2.ba());
            return false;
        }
        if (hcVar.yi() != hcVar2.yi()) {
            b.d("TMe", "--==-- ImgWidth, a1: " + hcVar.yi() + ", a2: " + hcVar2.yi());
            return false;
        }
        if (hcVar.he() != hcVar2.he()) {
            b.d("TMe", "--==-- ImgHeight, a1: " + hcVar.he() + ", a2: " + hcVar2.he());
            return false;
        }
        if (hcVar.j() != null && hcVar2.j() != null) {
            if (!hcVar.j().equals(hcVar2.j())) {
                b.d("TMe", "--==-- rewardName, a1: " + hcVar.j() + ", a2: " + hcVar2.j());
                return false;
            }
        } else if (hcVar.j() != null || hcVar2.j() != null) {
            b.d("TMe", "--==-- rewardName=null, a1: " + hcVar.j() + ", a2: " + hcVar2.j());
            return false;
        }
        if (hcVar.s() != hcVar2.s()) {
            b.d("TMe", "--==-- rewardAmount, a1: " + hcVar.s() + ", a2: " + hcVar2.s());
            return false;
        }
        if (hcVar.z() != null && hcVar2.z() != null) {
            if (!hcVar.z().equals(hcVar2.z())) {
                b.d("TMe", "--==-- reward, userId, a1: " + hcVar.z() + ", a2: " + hcVar2.z());
                return false;
            }
        } else if (hcVar.z() != null || hcVar2.z() != null) {
            b.d("TMe", "--==-- reward, userId=null, a1: " + hcVar.z() + ", a2: " + hcVar2.z());
            return false;
        }
        if (hcVar.hv() != null && hcVar2.hv() != null) {
            if (d(hcVar.hv(), hcVar2.hv())) {
                return true;
            }
            b.d("TMe", "--==-- customData, a1: " + hcVar.hv().toString() + ", a2: " + hcVar2.hv().toString());
            return false;
        }
        if (hcVar.hv() == null && hcVar2.hv() == null) {
            return true;
        }
        b.d("TMe", "--==-- customData=null, a1: " + hcVar.hv() + ", a2: " + hcVar2.hv());
        return false;
    }

    public static boolean d(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Set<String> setKeySet = map.keySet();
        if (setKeySet != null) {
            for (String str : setKeySet) {
                if (str != null) {
                    Object obj = map.get(str);
                    String str2 = obj instanceof String ? (String) obj : null;
                    Object obj2 = map2.get(str);
                    String str3 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 != null || str3 != null) {
                        if (!TextUtils.equals(str2, str3)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
