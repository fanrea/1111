package com.alliance.ssp.ad.api;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import com.alliance.ssp.ad.a.a;
import com.alliance.ssp.ad.d0.b;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.d0.h;
import com.alliance.ssp.ad.o0.i;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceAdSdk {
    private static AtomicBoolean isInit = new AtomicBoolean(false);

    public static int getAdLogoResourceId(Context context) {
        if (context != null) {
            return context.getResources().getIdentifier("nmadssp_logo_ad", "drawable", context.getPackageName());
        }
        return -1;
    }

    public static ISAAllianceAdManager getSAAllianceAdManager() {
        return new h();
    }

    public static String getYouTuiADNSDKVersion() {
        return i.f();
    }

    @Deprecated
    public static void init(String str, Application application, SAAllianceAdInitParams sAAllianceAdInitParams) throws JSONException, PackageManager.NameNotFoundException, IOException {
        init(str, application, sAAllianceAdInitParams, (YTAdInitSdkListener) null);
    }

    public static void reportExitApp() {
    }

    @Deprecated
    public static void init(String str, Context context, SAAllianceAdInitParams sAAllianceAdInitParams) throws JSONException, PackageManager.NameNotFoundException, IOException {
        init(str, context, sAAllianceAdInitParams, (YTAdInitSdkListener) null);
    }

    public static void init(String str, Application application, SAAllianceAdInitParams sAAllianceAdInitParams, YTAdInitSdkListener yTAdInitSdkListener) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            b.b().a(str, application.getApplicationContext(), sAAllianceAdInitParams, yTAdInitSdkListener);
        } catch (Exception e) {
            new f().a(0, 0, "004", a.a(e, com.alliance.ssp.ad.a.b.a("SAAllianceAdSdk 001: ")), e);
        }
    }

    public static void init(String str, Context context, SAAllianceAdInitParams sAAllianceAdInitParams, YTAdInitSdkListener yTAdInitSdkListener) throws JSONException, PackageManager.NameNotFoundException, IOException {
        try {
            b.b().a(str, context, sAAllianceAdInitParams, yTAdInitSdkListener);
        } catch (Exception e) {
            new f().a(0, 0, "004", a.a(e, com.alliance.ssp.ad.a.b.a("SAAllianceAdSdk 001: ")), e);
        }
    }
}
