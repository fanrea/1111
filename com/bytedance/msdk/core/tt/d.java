package com.bytedance.msdk.core.tt;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.d.hc.h;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    protected final Map<String, String> d = new HashMap();
    protected final zw hc;

    public static String d(int i) {
        switch (i) {
            case 1:
                return "banner";
            case 2:
                return "interstitial";
            case 3:
            case 4:
                return "splash";
            case 5:
                return "native";
            case 6:
            default:
                return null;
            case 7:
                return "rewardVideo";
            case 8:
                return "fullscreenVideo";
            case 9:
                return "draw";
            case 10:
                return "interstitialFull";
        }
    }

    protected abstract Map<String, String> d();

    protected abstract JSONObject d(com.bytedance.msdk.core.tc.b bVar);

    protected abstract void d(String str, int i, String str2);

    protected abstract void d(String str, String str2);

    protected abstract boolean hc(String str, JSONObject jSONObject, Map<String, Object> map);

    public d(String str) {
        this.hc = zw.d(str, com.bytedance.msdk.core.hc.getContext());
        b();
    }

    protected void d(int i, String str, int i2, double d) {
        if (i2 == 1) {
            d(i, str, d);
        } else if (i2 == 3) {
            hc(i, str, d);
        } else if (i2 == 2) {
            b(i, str, d);
        }
    }

    protected double d(int i, String str, int i2) {
        if (i2 == 1) {
            return BigDecimal.valueOf(Double.parseDouble(d(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 3) {
            return BigDecimal.valueOf(Double.parseDouble(hc(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        if (i2 == 2) {
            return BigDecimal.valueOf(Double.parseDouble(b(i, str))).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0d;
    }

    public void d(double d, double d2, String str, String str2) {
        if (this.hc == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        d(str, "_last_post_cpm_", str2, d);
        d(str, "_last_bidding_cpm_", str2, d2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] d(int r18, double r19, double r21, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.tt.d.d(int, double, double, java.lang.String, java.lang.String):double[]");
    }

    protected void d(String str, String str2, String str3, double d) {
        this.hc.d(str + str2, str3 + Config.replace + d);
    }

    protected void hc() {
        Map<String, ?> mapHc = this.hc.hc();
        if (mapHc != null) {
            for (Map.Entry<String, ?> entry : mapHc.entrySet()) {
                if (entry != null) {
                    d(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
        }
    }

    private synchronized void d(int i, String str, double d) {
        String str2 = "label_size_" + str;
        int iHc = this.hc.hc(str2, 0) + 1;
        String strD = d(str, iHc);
        String strD2 = d(str, d);
        d(strD, i, strD2);
        this.hc.d(strD, strD2);
        this.hc.d(str2, iHc);
    }

    private String d(int i, String str) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return "0";
        }
        double[] dArr = new double[2];
        Iterator<Map.Entry<String, String>> it = d().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next != null) {
                String value = next.getValue();
                if (!TextUtils.isEmpty(value) && value.contains(str)) {
                    String[] strArrSplit = value.split(Config.replace);
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    String str4 = strArrSplit[2];
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (com.bytedance.msdk.core.hc.hc().d(System.currentTimeMillis() - Long.parseLong(str4))) {
                            dArr[0] = dArr[0] + 1.0d;
                            dArr[1] = dArr[1] + Double.parseDouble(str3);
                        } else {
                            it.remove();
                            this.hc.an(next.getKey());
                            String str5 = "label_size_" + str;
                            zw zwVar = this.hc;
                            zwVar.d(str5, zwVar.b(str5) - 1);
                        }
                    }
                }
            }
        }
        return d(dArr);
    }

    private void hc(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.hc.d(str, d + Config.replace + System.currentTimeMillis());
        d(str);
    }

    public void d(String str) {
        for (int iB = this.hc.b("label_size_" + str); iB > 0; iB--) {
            try {
                String strD = d(str, iB);
                this.hc.an(strD);
                d().remove(strD);
            } catch (Throwable th) {
                com.bytedance.msdk.d.u.b.c("CalculateLabelValueImpl", "clearFromSpByRit,ignore:" + th.toString());
            }
        }
    }

    private String d(String str, int i) {
        return "cpm_key_" + str + Config.replace + i;
    }

    private String hc(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String strHc = this.hc.hc(str);
            if (!TextUtils.isEmpty(strHc) && !"0".equals(strHc)) {
                String[] strArrSplit = strHc.split(Config.replace);
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (com.bytedance.msdk.core.hc.hc().d(System.currentTimeMillis() - Long.parseLong(str3))) {
                        return str2;
                    }
                    this.hc.an(str);
                }
            }
        }
        return "0";
    }

    private String d(String str, double d) {
        return str + Config.replace + d + Config.replace + System.currentTimeMillis();
    }

    private void b(int i, String str, double d) {
        if (TextUtils.isEmpty(str) || i != 3) {
            return;
        }
        this.hc.d(str, d + Config.replace + System.currentTimeMillis());
        d(str);
    }

    private String b(int i, String str) throws NumberFormatException {
        if (!TextUtils.isEmpty(str) && i == 3) {
            String strHc = this.hc.hc(str);
            if (!TextUtils.isEmpty(strHc) && !"0".equals(strHc)) {
                String[] strArrSplit = strHc.split(Config.replace);
                String str2 = strArrSplit[0];
                String str3 = strArrSplit[1];
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str3.matches("[0-9]+")) {
                        try {
                            if (com.bytedance.msdk.core.hc.hc().d(System.currentTimeMillis() - Long.parseLong(str3))) {
                                return str2;
                            }
                            this.hc.an(str);
                        } catch (NumberFormatException unused) {
                            this.hc.an(str);
                            h.d("自定义上报 saveTime format exception valueTimestamp " + strHc);
                        }
                    } else {
                        this.hc.an(str);
                        h.d("自定义上报 saveTime is not number valueTimestamp " + strHc);
                    }
                }
            }
        }
        return "0";
    }

    public String d(double[] dArr) {
        double d = dArr[0];
        return d != 0.0d ? new BigDecimal(dArr[1] / d).setScale(2, RoundingMode.HALF_UP).toString() : "-1.0";
    }

    protected void b() {
        this.d.put("0", "a");
        this.d.put("1", t.l);
        this.d.put("2", "c");
        this.d.put("3", "d");
        this.d.put("4", "e");
        this.d.put("5", "f");
        this.d.put("6", "g");
        this.d.put("7", "h");
        this.d.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, "i");
        this.d.put("9", "j");
        this.d.put(".", "k");
    }

    protected String hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(this.d.get(String.valueOf(c)));
        }
        return sb.toString();
    }

    protected void d(String str, JSONObject jSONObject, Map<String, Object> map) throws JSONException {
        if (!com.bytedance.msdk.core.hc.hc().ru() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (hc(str, jSONObject2, map == null ? new HashMap<>() : map)) {
            try {
                jSONObject.putOpt("label", jSONObject2);
                if (map == null || map.get("cost_time") == null) {
                    return;
                }
                jSONObject.put("uvalueExcTime", map.get("cost_time"));
            } catch (JSONException e) {
                mq.d(e);
            }
        }
    }
}
