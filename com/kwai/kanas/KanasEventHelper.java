package com.kwai.kanas;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.kwai.kanas.a.a;
import com.kwai.kanas.a.b;
import com.kwai.kanas.a.c;
import com.kwai.kanas.interfaces.CommonParams;
import com.kwai.kanas.interfaces.KanasConfig;
import com.kwai.kanas.location.Location;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.configs.InitCommonParams;
import com.kwai.middleware.azeroth.function.Supplier;
import com.kwai.middleware.azeroth.utils.NetworkUtils;
import com.kwai.middleware.azeroth.utils.TextUtils;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KanasEventHelper {
    private static final String a = "KanasEventHelper";
    private static PackageInfo b;
    private Context c;
    private KanasConfig d;
    private Supplier<Location> e;
    private String f;
    private String g;
    private LifecycleCallbacks h;

    KanasEventHelper(Context context, KanasConfig kanasConfig, LifecycleCallbacks lifecycleCallbacks) {
        this.c = context;
        this.d = kanasConfig;
        this.e = kanasConfig.location();
        this.h = lifecycleCallbacks;
        context.getSharedPreferences(com.kwai.kanas.b.a.a, 0);
    }

    public static PackageInfo getPackageInfo(Context context) {
        try {
            if (b == null) {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }

    private static boolean a(Context context, String str) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }

    private static int a(Context context) {
        if (!NetworkUtils.isNetworkConnected(context)) {
            return 1;
        }
        if (NetworkUtils.getActiveNetworkInfo(context) == null) {
            return 0;
        }
        if (NetworkUtils.isWifiConnected(context)) {
            return 2;
        }
        String networkType = NetworkUtils.getNetworkType(context);
        char c = 65535;
        int iHashCode = networkType.hashCode();
        if (iHashCode != 1653) {
            if (iHashCode != 1684) {
                if (iHashCode != 1715) {
                    if (iHashCode == 1746 && networkType.equals(NetworkUtils.MOBILE_NETWORK_5G)) {
                        c = 3;
                    }
                } else if (networkType.equals(NetworkUtils.MOBILE_NETWORK_4G)) {
                    c = 2;
                }
            } else if (networkType.equals(NetworkUtils.MOBILE_NETWORK_3G)) {
                c = 1;
            }
        } else if (networkType.equals(NetworkUtils.MOBILE_NETWORK_2G)) {
            c = 0;
        }
        if (c == 0) {
            return 5;
        }
        if (c == 1) {
            return 4;
        }
        if (c != 2) {
            return c != 3 ? 6 : 7;
        }
        return 3;
    }

    private b.c a() {
        b.c cVar = new b.c();
        cVar.a = b();
        cVar.b = c();
        cVar.c = d();
        cVar.d = e();
        cVar.e = f();
        cVar.f = a.g;
        return cVar;
    }

    public c.b buildCommonReportEvent() {
        return buildCommonReportEvent(null);
    }

    public c.b buildCommonReportEvent(CommonParams commonParams) {
        String displayName;
        c.b bVar = new c.b();
        bVar.e = a();
        if (commonParams != null) {
            bVar.e.g = TextUtils.emptyIfNull(commonParams.sdkName());
            bVar.e.h = TextUtils.emptyIfNull(commonParams.subBiz());
            bVar.e.b.h = TextUtils.defaultIfEmpty(commonParams.container(), "NATIVE");
        }
        if (TextUtils.isEmpty(this.g)) {
            TimeZone timeZone = TimeZone.getDefault();
            try {
                displayName = timeZone.getDisplayName(false, 0);
            } catch (AssertionError | Exception e) {
                Log.e(a, "TimeZone displayName get failed", e);
                Kanas.get().getConfig().logger().logErrors(e);
                displayName = "";
            }
            this.g = displayName + " " + timeZone.getID();
        }
        bVar.d = this.g;
        bVar.c = this.h.a();
        return bVar;
    }

    private a.b b() {
        a.b bVar = new a.b();
        InitCommonParams commonParams = Azeroth.get().getCommonParams();
        bVar.c = TextUtils.emptyIfNull(commonParams.getUserId());
        bVar.a = this.d.deviceId();
        bVar.b = TextUtils.emptyIfNull(commonParams.getGlobalId());
        return bVar;
    }

    private b.C0648b c() {
        b.C0648b c0648b = new b.C0648b();
        PackageInfo packageInfo = getPackageInfo(this.c);
        c0648b.d = packageInfo != null ? packageInfo.versionName : "";
        c0648b.e = packageInfo != null ? packageInfo.versionCode : 0;
        InitCommonParams commonParams = Azeroth.get().getCommonParams();
        c0648b.c = TextUtils.emptyIfNull(commonParams.getChannel());
        c0648b.b = Locale.getDefault().getLanguage();
        c0648b.a = this.d.platform();
        c0648b.g = commonParams.getProductName();
        c0648b.f = this.c.getPackageName();
        return c0648b;
    }

    private a.C0645a d() {
        a.C0645a c0645a = new a.C0645a();
        c0645a.a = String.valueOf(Build.VERSION.SDK_INT);
        c0645a.b = Build.MANUFACTURER + "(" + Build.MODEL + ")";
        return c0645a;
    }

    private a.d e() {
        a.d dVar = new a.d();
        dVar.c = "";
        dVar.a = a(this.c);
        if (this.f == null) {
            this.f = NetworkUtils.getIspV2(this.c);
        }
        dVar.b = this.f;
        return dVar;
    }

    private a.c f() {
        a.c cVar = new a.c();
        Location location = this.e.get();
        if (location == null) {
            return cVar;
        }
        cVar.a = TextUtils.emptyIfNull(location.mCountry);
        cVar.b = TextUtils.emptyIfNull(location.mProvince);
        cVar.c = TextUtils.emptyIfNull(location.mCity);
        cVar.d = TextUtils.emptyIfNull(location.mCounty);
        cVar.e = TextUtils.emptyIfNull(location.mStreet);
        cVar.f = location.mLatitude;
        cVar.g = location.mLongitude;
        return cVar;
    }
}
