package com.sigmob.sdk.base.utils;

import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import java.util.HashMap;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    public static final HashMap<String, a> a = new HashMap<>();
    public static int b = 0;
    public static int c = 1;

    public static class a {
        public Integer a = 0;
        public Integer b = 0;

        public String toString() {
            return "CLickCallbackObj{clickLoseRate=" + this.a + ", clickCbState=" + this.b + '}';
        }
    }

    public static a a(String tag, BaseAdUnit adUnit) {
        SigmobLog.d(tag + "#calResultWithAssign");
        a aVarB = b(tag, adUnit);
        a(tag, adUnit, aVarB);
        return aVarB;
    }

    public static void a(BaseAdUnit adUnit) {
        SlotAdSetting slotAdSetting;
        if (adUnit == null || (slotAdSetting = adUnit.getSlotAdSetting()) == null) {
            return;
        }
        String requestId = adUnit.getRequestId();
        Integer num = slotAdSetting.click_lose_rate;
        if (num == null) {
            return;
        }
        a(requestId, num, Integer.valueOf(new Random().nextInt(100) + 1 > num.intValue() ? 0 : 1));
    }

    public static void a(String tag, BaseAdUnit adUnit, a obj) {
        SigmobLog.d(tag + "#assignValue: start");
        if (adUnit == null) {
            return;
        }
        Integer numValueOf = Integer.valueOf(obj == null ? 0 : obj.a.intValue());
        Integer numValueOf2 = Integer.valueOf(obj == null ? b : obj.b.intValue());
        ClickCommon clickCommon = adUnit.getClickCommon();
        clickCommon.click_lose_rate = numValueOf;
        clickCommon.click_cb_state = numValueOf2;
        adUnit.getMacroCommon().addMarcoKey(SigMacroCommon._ISNC_, String.valueOf(numValueOf2));
        SigmobLog.d(tag + "#assignValue: end");
    }

    public static void a(String requestId, Integer clickLoseRate, Integer clickCbState) {
        if (TextUtils.isEmpty(requestId)) {
            return;
        }
        HashMap<String, a> map = a;
        if (map.get(requestId) == null) {
            a aVar = new a();
            aVar.a = clickLoseRate;
            aVar.b = clickCbState;
            map.put(requestId, aVar);
        }
    }

    public static boolean a(a obj) {
        return obj == null || obj.b == null || obj.b.intValue() == b;
    }

    public static a b(String tag, BaseAdUnit adUnit) {
        if (adUnit == null) {
            return null;
        }
        String requestId = adUnit.getRequestId();
        int ad_type = adUnit.getAd_type();
        HashMap<String, a> map = a;
        if (map.get(requestId) == null) {
            a(adUnit);
        }
        a aVar = map.get(requestId);
        SigmobLog.d(tag + "#getObj: requestId = " + requestId + ", adType = " + ad_type + ", obj = " + aVar);
        return aVar;
    }
}
