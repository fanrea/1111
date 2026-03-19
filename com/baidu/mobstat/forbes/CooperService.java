package com.baidu.mobstat.forbes;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.ah;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class CooperService implements ICooperService {
    private static CooperService a;
    private HeadObject b = new HeadObject();
    private boolean c = true;
    private String d = "0";
    private boolean e = false;
    private boolean f = true;
    private int g = 1;
    private int h = 0;
    private int i = 0;
    private int j = 1;
    private int k = 1;
    private int l = 10;
    private String m = "t_t_allg_d_t_allk_s_all";
    private int n = 1;

    public static synchronized CooperService instance() {
        if (a == null) {
            a = new CooperService();
        }
        return a;
    }

    public HeadObject getHeadObject() {
        return this.b;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getHost() {
        return Config.LOG_SEND_URL;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public void installHeader(Context context, JSONObject jSONObject) {
        this.b.installHeader(context, jSONObject);
    }

    public JSONObject getHeaderExt(Context context) {
        String strJ = al.a().j(context);
        if (!TextUtils.isEmpty(strJ)) {
            try {
                return new JSONObject(strJ);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) throws JSONException {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.b.setHeaderExt(jSONObject);
        al.a().d(context, jSONObject.toString());
        if (extraInfo != null) {
            str = "Set global ExtraInfo: " + jSONObject;
        } else {
            str = "Clear global ExtraInfo";
        }
        v.c().a(str);
    }

    public JSONObject getPushId(Context context) {
        String strK = al.a().k(context);
        if (!TextUtils.isEmpty(strK)) {
            try {
                return new JSONObject(strK);
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public void setPushId(Context context, String str, String str2, String str3) throws JSONException {
        String str4;
        JSONObject pushId = getPushId(context);
        if (pushId == null) {
            pushId = new JSONObject();
        }
        try {
            if (!TextUtils.isEmpty(str3)) {
                pushId.put(str, str3);
            } else {
                pushId.remove(str);
            }
        } catch (Exception e) {
        }
        this.b.setPushInfo(pushId);
        al.a().e(context, pushId.toString());
        if (str3 != null) {
            str4 = "Set platform:" + str2 + " pushId: " + str3;
        } else {
            str4 = "Clear platform:" + str2 + " pushId";
        }
        v.c().a(str4);
    }

    public void setStartType(boolean z) {
        this.b.setStartType(z);
    }

    public String getPhoneAddress(Context context, boolean z) {
        return "";
    }

    public String getMacIdForTv(Context context) throws Throwable {
        if (!ap.a().e()) {
            return "";
        }
        if (!TextUtils.isEmpty(this.b.r)) {
            return this.b.r;
        }
        String strI = al.a().i(context);
        if (!TextUtils.isEmpty(strI)) {
            this.b.r = strI;
            return this.b.r;
        }
        String strH = ar.h(2, context);
        if (!TextUtils.isEmpty(strH)) {
            this.b.r = strH;
            al.a().c(context, strH);
            return this.b.r;
        }
        this.b.r = "";
        return this.b.r;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getCUID(Context context, boolean z) {
        return "";
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public int getTagValue() {
        return 2;
    }

    public String getDevicImei(Context context) {
        return "";
    }

    public void deleteCacheImei(Context context) {
        try {
            String strR = al.a().r(context);
            if (TextUtils.isEmpty(strR)) {
                return;
            }
            String str = new String(ah.b.b(2, ak.a(strR.getBytes())));
            if (!TextUtils.isEmpty(str) && !str.contains("hol") && !str.contains("0200")) {
                al.a().i(context, "");
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        if (!TextUtils.isEmpty(this.b.i)) {
            return this.b.i;
        }
        this.b.i = a(context);
        this.b.i = getSecretValue(this.b.i);
        return this.b.i;
    }

    public boolean filterCuid(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "";
        String strReplace = str.replace(":", "");
        if (strReplace.equals(Config.DEF_MAC_ID.replace(":", ""))) {
            if (TextUtils.isEmpty(this.b.f)) {
                this.b.i = getSecretValue(a(context));
                return true;
            }
            try {
                str2 = new String(ah.b.b(2, ak.a(this.b.f.getBytes())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str2)) {
                this.b.i = getSecretValue(a(context));
                z = true;
            } else {
                this.b.i = getSecretValue(strReplace);
            }
            return z;
        }
        this.b.i = getSecretValue(strReplace);
        return true;
    }

    private String a(Context context) {
        String strE = al.a().e(context);
        if (TextUtils.isEmpty(strE) || strE.equals(Config.NULL_DEVICE_ID)) {
            String str = "hol" + (new Date().getTime() + "").hashCode() + "mes";
            al.a().a(context, str);
            return str;
        }
        return strE;
    }

    public String getPlainDeviceIdForCar(Context context) {
        String strOptUUID = CarUUID.optUUID(context);
        if (TextUtils.isEmpty(strOptUUID)) {
            strOptUUID = a(context);
        }
        return TextUtils.isEmpty(strOptUUID) ? "" : strOptUUID;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getAppChannel(Context context) {
        return b(context);
    }

    private String b(Context context) {
        try {
            if ((this.b.l == null || this.b.l.equals("")) && al.a().g(context)) {
                this.b.l = al.a().f(context);
            }
        } catch (Exception e) {
        }
        return this.b.l;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getAppKey(Context context) {
        return this.b.e;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getMTJSDKVersion() {
        return "4.1.0.9";
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public int getAppVersionCode(Context context) {
        if (this.b.g == -1) {
            this.b.g = ar.e(context);
        }
        return this.b.g;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(this.b.h)) {
            this.b.h = ar.f(context);
        }
        return this.b.h;
    }

    public void setAppVersionName(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.h = str;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.b.m)) {
            this.b.m = telephonyManager.getNetworkOperator();
        }
        return this.b.m;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getLinkedWay(Context context) {
        if (TextUtils.isEmpty(this.b.p)) {
            this.b.p = ar.i(context);
        }
        return this.b.p;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getOSVersion() {
        if (TextUtils.isEmpty(this.b.b)) {
            this.b.b = Integer.toString(Build.VERSION.SDK_INT);
        }
        return this.b.b;
    }

    public String getOSSysVersion() {
        if (TextUtils.isEmpty(this.b.c)) {
            this.b.c = Build.VERSION.RELEASE;
        }
        return this.b.c;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.b.n)) {
            this.b.n = android.os.Build.MODEL;
        }
        return this.b.n;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.b.o)) {
            this.b.o = android.os.Build.MANUFACTURER;
        }
        return this.b.o;
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public boolean checkWifiLocationSetting(Context context) {
        return "true".equalsIgnoreCase("");
    }

    @Override // com.baidu.mobstat.forbes.ICooperService
    public String getSecretValue(String str) {
        return ah.b.c(2, str.getBytes());
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public void resetHeadSign() {
        this.b.x = instance().getUUID();
    }

    public void enableDeviceMac(Context context, boolean z) {
        al.a().d(context, z);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return al.a().l(context);
    }

    public void setUserId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        al.a().f(context, str);
        this.b.setUserId(str);
        v.c().a("Set user id " + str);
    }

    public String getUserId(Context context) {
        return al.a().o(context);
    }

    public String getLastUserId(Context context) {
        return al.a().p(context);
    }

    public void setLastUserId(Context context, String str) {
        al.a().g(context, str);
    }

    public void setUserProperty(Context context, Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        try {
        } catch (Exception e) {
            v.c().c("[Exception] " + e.getMessage());
            e.printStackTrace();
        }
        if (map == null) {
            al.a().j(context, "");
            this.b.setUserProperty("");
            return;
        }
        if (map.size() > 100) {
            v.c().c("[WARNING] setUserProperty failed,map size can not over 100 !");
            return;
        }
        boolean z2 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            String key = entry.getKey();
            String value = entry.getValue();
            if (TextUtils.isEmpty(key) || value == null) {
                v.c().c("[WARNING] setUserProperty failed,key or value can not null !");
                z2 = false;
            } else {
                if (key.length() <= 256 && (TextUtils.isEmpty(value) || value.length() <= 256)) {
                    jSONArray.put(value);
                    jSONArray.put("1");
                    jSONObject.put(key, jSONArray);
                }
                v.c().c("[WARNING] setUserProperty failed,key or value can not over 256 bytes !");
                z2 = false;
            }
        }
        z = z2;
        if (z) {
            al.a().j(context, jSONObject.toString());
            this.b.setUserProperty(jSONObject.toString());
        }
    }

    public void setHeaderPy(String str) {
        this.b.setHeaderPy(str);
    }

    public void setZid(String str) {
    }

    public boolean isEnabledAutoEvent() {
        return this.c;
    }

    public void setEnableAutoEvent(boolean z) {
        this.c = z;
    }

    public void setPlatformType(int i) {
        this.d = i + "";
    }

    public String getPlatformType() {
        return this.d;
    }

    public boolean isCloseTrace() {
        return this.e;
    }

    public void closeTrace() {
        this.e = true;
    }

    public boolean isEnableDownloadJs() {
        return this.f;
    }

    public void setEnableDownloadJs(boolean z) {
        this.f = z;
    }

    public boolean isEnableBplus(Context context) {
        return al.a().v(context);
    }

    public void setEnableBplus(Context context, boolean z) {
        al.a().e(context, z);
    }

    public int getCollectTitleMaxLevel() {
        return this.g;
    }

    public int getAndroidVersion() {
        return this.h;
    }

    public void setAndroidVersion(int i) {
        this.h = i;
    }

    public String getActivityExposureString() {
        return this.m;
    }

    public void setActivityExposureString(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.m = str;
        }
    }

    public int getActivityContentSwitch() {
        return this.n;
    }

    public void setActivityContentSwitch(int i) {
        this.n = i;
    }

    public int getFullPointDistinguishLogo() {
        return this.j;
    }

    public void setFullPointDistinguishLogo(int i) {
        this.j = i;
    }

    public int useNullAccessibilityDelegate() {
        return this.k;
    }

    public void setUseNullAccessibilityDelegate(int i) {
        this.k = i;
    }

    public int getLogPrint() {
        return this.i;
    }

    public void setLogPrint(int i) {
        this.i = i;
    }

    public void setCollectTitleMaxLevel(int i) {
        this.g = i;
    }

    public int getEvAutoSize() {
        return this.l;
    }

    public void setEvAutoSize(int i) {
        this.l = i;
    }
}
