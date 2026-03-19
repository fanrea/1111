package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ce;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class be {
    public static String cmT = "";

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    static /* synthetic */ String dC(boolean z) {
        return dz(true);
    }

    static /* synthetic */ String dD(boolean z) {
        return apv();
    }

    static /* synthetic */ String dE(boolean z) {
        return apw();
    }

    static /* synthetic */ String dF(boolean z) {
        return dA(true);
    }

    static /* synthetic */ String dG(boolean z) {
        return dB(true);
    }

    static /* synthetic */ String dH(boolean z) {
        return apx();
    }

    static /* synthetic */ String dI(boolean z) {
        return apy();
    }

    static /* synthetic */ String dJ(boolean z) {
        return apz();
    }

    static /* synthetic */ String l(Context context, boolean z) {
        return e(context, true);
    }

    static /* synthetic */ String m(Context context, boolean z) {
        return f(context, true);
    }

    static /* synthetic */ String n(Context context, boolean z) {
        return g(context, true);
    }

    static /* synthetic */ String o(Context context, boolean z) {
        return h(context, true);
    }

    static /* synthetic */ String p(Context context, boolean z) {
        return i(context, true);
    }

    static /* synthetic */ String q(Context context, boolean z) {
        return j(context, true);
    }

    static /* synthetic */ String r(Context context, boolean z) {
        return k(context, true);
    }

    static /* synthetic */ String s(Context context, boolean z) {
        return eo(context);
    }

    static /* synthetic */ String t(Context context, boolean z) {
        return eq(context);
    }

    static /* synthetic */ String u(Context context, boolean z) {
        return et(context);
    }

    static /* synthetic */ String v(Context context, boolean z) {
        return es(context);
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(eu(context));
    }

    public static String eg(Context context) {
        return e(context, false);
    }

    private static String e(Context context, boolean z) {
        String strW = bs.w(context, z);
        if (!z) {
            return TextUtils.isEmpty(strW) ? "" : strW;
        }
        if (!TextUtils.isEmpty(strW)) {
            return com.kwad.sdk.e.b.a(bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevImei()), strW, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strW, 4);
        }
        if (bd.usePhoneStateDisable() || !s.aod()) {
            return com.kwad.sdk.e.b.a(false, strW, 1);
        }
        return com.kwad.sdk.e.b.a(false, strW, SystemUtil.eF(context) ? 3 : 1);
    }

    public static String getOaid() {
        return dz(false);
    }

    private static String dz(boolean z) {
        String strDK = bs.dK(z);
        if (!z) {
            return TextUtils.isEmpty(strDK) ? "" : strDK;
        }
        if (!TextUtils.isEmpty(strDK)) {
            return com.kwad.sdk.e.b.a(bd.useOaidDisable() && !TextUtils.isEmpty(bd.getDevOaid()), strDK, 0);
        }
        if (bd.useOaidDisable() || !s.anZ()) {
            return com.kwad.sdk.e.b.a(false, strDK, 1);
        }
        return com.kwad.sdk.e.b.a(false, strDK, 5);
    }

    public static String eh(Context context) {
        return f(context, false);
    }

    private static String f(Context context, boolean z) {
        String strEh = bs.eh(context);
        if (!z) {
            return TextUtils.isEmpty(strEh) ? "" : strEh;
        }
        if (!TextUtils.isEmpty(strEh)) {
            return com.kwad.sdk.e.b.a(bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevAndroidId()), strEh, 0);
        }
        if (bd.usePhoneStateDisable() || !s.anX()) {
            return com.kwad.sdk.e.b.a(false, strEh, 1);
        }
        return com.kwad.sdk.e.b.a(false, strEh, 5);
    }

    public static String ei(Context context) {
        return g(context, false);
    }

    private static String g(Context context, boolean z) {
        String strET = bs.eT(context);
        if (!z) {
            return TextUtils.isEmpty(strET) ? "" : strET;
        }
        if (!TextUtils.isEmpty(strET)) {
            return com.kwad.sdk.e.b.a(bd.useMacAddressDisable() && !TextUtils.isEmpty(bd.getDevMacAddress()), strET.toLowerCase(), 0);
        }
        if (bd.useMacAddressDisable() || !s.anY()) {
            return com.kwad.sdk.e.b.a(false, strET, 0);
        }
        return com.kwad.sdk.e.b.a(false, strET, au.aI(context, com.kuaishou.weapon.p0.g.d) == 0 ? 3 : 1);
    }

    public static String ej(Context context) {
        return h(context, false);
    }

    private static String h(Context context, boolean z) {
        String[] strArrEN = bs.eN(context);
        String str = (strArrEN == null || strArrEN.length <= 0) ? null : strArrEN[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bd.usePhoneStateDisable() || !s.aod()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.eF(context) ? 3 : 1);
    }

    public static String ek(Context context) {
        return i(context, false);
    }

    private static String i(Context context, boolean z) {
        String[] strArrEN = bs.eN(context);
        String str = (strArrEN == null || strArrEN.length <= 1) ? null : strArrEN[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bd.usePhoneStateDisable() || !s.aod()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.eF(context) ? 3 : 1);
    }

    public static String el(Context context) {
        return j(context, false);
    }

    private static String j(Context context, boolean z) {
        String strEl = bs.el(context);
        if (!z) {
            return TextUtils.isEmpty(strEl) ? "" : strEl;
        }
        if (!TextUtils.isEmpty(strEl)) {
            return com.kwad.sdk.e.b.a(bd.usePhoneStateDisable(), strEl, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strEl, 4);
        }
        if (bd.usePhoneStateDisable() || !s.aoe()) {
            return com.kwad.sdk.e.b.a(false, strEl, 1);
        }
        return com.kwad.sdk.e.b.a(false, strEl, SystemUtil.eF(context) ? 3 : 1);
    }

    public static String em(Context context) {
        return k(context, false);
    }

    private static String k(Context context, boolean z) {
        String strEQ = bs.eQ(context);
        if (!z) {
            return TextUtils.isEmpty(strEQ) ? "" : strEQ;
        }
        if (!TextUtils.isEmpty(strEQ)) {
            return com.kwad.sdk.e.b.a(bd.usePhoneStateDisable(), strEQ, 0);
        }
        if (bd.usePhoneStateDisable() || !s.aof()) {
            return com.kwad.sdk.e.b.a(false, strEQ, 1);
        }
        return com.kwad.sdk.e.b.a(false, strEQ, SystemUtil.eF(context) ? 3 : 1);
    }

    public static int en(Context context) {
        return bs.eO(context);
    }

    private static String eo(Context context) {
        int iEO = bs.eO(context);
        if (iEO > 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(iEO), 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(iEO), 1);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(iEO), 3);
    }

    public static com.kwad.sdk.l.a.f anh() {
        return com.kwad.sdk.l.a.f.anh();
    }

    public static int ep(Context context) {
        return bs.eP(context);
    }

    private static String apv() {
        com.kwad.sdk.l.a.f fVarAnh = com.kwad.sdk.l.a.f.anh();
        int i = fVarAnh != null ? fVarAnh.cjG : -1;
        if (i >= 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ub()) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i), 1);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(i), 2);
    }

    public static com.kwad.sdk.l.a.b ang() {
        return com.kwad.sdk.l.a.b.ang();
    }

    private static String apw() {
        com.kwad.sdk.l.a.b bVarAng = com.kwad.sdk.l.a.b.ang();
        if (bVarAng != null) {
            return com.kwad.sdk.e.b.a(false, bVarAng.toJson(), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ud()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", 2);
    }

    public static String getDeviceId() {
        return dA(false);
    }

    private static String dA(boolean z) {
        if (com.kwad.framework.a.a.qr.booleanValue() && !TextUtils.isEmpty(bt.getDeviceId())) {
            return bt.getDeviceId();
        }
        String deviceId = bs.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (!TextUtils.isEmpty(deviceId)) {
            return com.kwad.sdk.e.b.a(bd.usePhoneStateDisable() && !TextUtils.isEmpty(bd.getDevAndroidId()), deviceId, 0);
        }
        if (bd.usePhoneStateDisable() || !s.anX()) {
            return com.kwad.sdk.e.b.a(false, deviceId, 1);
        }
        return com.kwad.sdk.e.b.a(false, deviceId, 5);
    }

    private static String dB(boolean z) {
        String strAqm = bs.aqm();
        if (!z) {
            return TextUtils.isEmpty(strAqm) ? "" : strAqm;
        }
        if (!TextUtils.isEmpty(strAqm)) {
            return com.kwad.sdk.e.b.a(bd.useNetworkStateDisable(), strAqm, 0);
        }
        if (bd.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(8L)) {
            return com.kwad.sdk.e.b.a(false, strAqm, 1);
        }
        return com.kwad.sdk.e.b.a(false, strAqm, 2);
    }

    public static List<ce.a> r(Context context, int i) {
        return ce.r(context, 15);
    }

    private static String eq(Context context) {
        List<ce.a> listR = r(context, 15);
        if (listR != null && listR.size() > 0) {
            return com.kwad.sdk.e.b.a(bd.useNetworkStateDisable(), aa.aL(listR), 0);
        }
        if (bd.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(32L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", ce.eX(context) ? 1 : 3);
    }

    private static Map<String, AppPackageInfo> er(Context context) {
        com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.g(com.kwad.sdk.components.p.class);
        if (pVar != null && s.aob()) {
            return pVar.P(context);
        }
        return new HashMap();
    }

    private static String es(Context context) {
        com.kwad.sdk.core.c.b.aaf();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> mapEr = er(context);
        if (mapEr.size() > 0) {
            boolean z = bd.readInstalledPackagesDisable() && bd.getDevInstalledPackages() != null;
            com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.g(com.kwad.sdk.components.p.class);
            if (pVar != null && s.aob()) {
                return com.kwad.sdk.e.b.a(z, pVar.c(mapEr), 0);
            }
        }
        if (bd.readInstalledPackagesDisable() || !s.aob()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", bs.eV(context) ? 3 : 1);
    }

    public static com.kwad.sdk.utils.c.a dj(Context context) {
        return x.dj(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String et(Context context) {
        com.kwad.sdk.utils.c.a aVarDj = x.dj(context);
        if (aVarDj != null && aVarDj.cpr != null) {
            HashMap map = new HashMap();
            map.put("latitude", String.valueOf(aVarDj.cpr.getLatitude()));
            map.put("longitude", String.valueOf(aVarDj.cpr.getLongitude()));
            return com.kwad.sdk.e.b.a(bd.readLocationDisable() && bd.apt() != null, aa.parseMap2JSON(map), 0);
        }
        if (bd.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(64L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) == true ? 3 : 1);
    }

    private static String apx() {
        return com.kwad.sdk.e.b.a(false, "2", 0);
    }

    private static String apy() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    private static String apz() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    private static com.kwad.sdk.e.c eu(final Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.be.1
            @Override // com.kwad.sdk.e.a
            public final String aeF() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + be.l(context, true));
                return be.l(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + be.dC(true));
                return be.dC(true);
            }

            @Override // com.kwad.sdk.e.a
            public final String aeG() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + be.m(context, true));
                return be.m(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String aeH() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + be.n(context, true));
                return be.n(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String aeI() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + be.o(context, true));
                return be.o(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String aeJ() {
                String strP = be.p(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + strP);
                return strP;
            }

            @Override // com.kwad.sdk.e.a
            public final String aeK() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + be.q(context, true));
                return be.q(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + be.r(context, true));
                return be.r(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String aeL() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + be.s(context, true));
                return be.s(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String aeM() {
                String strDD = be.dD(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + strDD);
                return strDD;
            }

            @Override // com.kwad.sdk.e.a
            public final String aeN() {
                String strDE = be.dE(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + strDE);
                return strDE;
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String strDF = be.dF(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + strDF);
                return strDF;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String strDG = be.dG(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIp:" + strDG);
                return strDG;
            }

            @Override // com.kwad.sdk.e.a
            public final String aeO() {
                String strT = be.t(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + strT);
                return strT;
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String strU = be.u(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + strU);
                return strU;
            }

            @Override // com.kwad.sdk.e.a
            public final String aeP() {
                String strV = be.v(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + strV);
                return strV;
            }

            @Override // com.kwad.sdk.e.a
            public final String aeQ() {
                String strDH = be.dH(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + strDH);
                return strDH;
            }

            @Override // com.kwad.sdk.e.a
            public final String getSdkVersion() {
                String strDI = be.dI(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + strDI);
                return strDI;
            }

            @Override // com.kwad.sdk.e.a
            public final String getAppId() {
                String strDJ = be.dJ(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + strDJ);
                return strDJ;
            }
        };
    }
}
