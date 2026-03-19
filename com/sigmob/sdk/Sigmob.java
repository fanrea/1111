package com.sigmob.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.exceptions.CrashHandler;
import com.czhj.sdk.common.models.BidRequest;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.e;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobCrash;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.services.f;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Sigmob {
    private static Sigmob a;
    private static boolean b;
    public static SigMacroCommon macroCommon;
    private WindAdError c;

    private Sigmob() {
    }

    private String a(byte[] str) throws IOException {
        if (str == null || str.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(str);
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        g.b();
        g.l();
        g.j();
        g.i();
        g.h();
        g.k();
        g.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, boolean z, boolean z2, int i2, boolean z3, Object obj) {
        if (obj instanceof PointEntityCommon) {
            PointEntityCommon pointEntityCommon = (PointEntityCommon) obj;
            Map options = pointEntityCommon.getOptions();
            options.put(PointParamKey.IS_MINOR, i.a().d() ? "0" : "1");
            options.put(PointParamKey.IS_UNPERSONALIZED, i.a().e() ? "0" : "1");
            options.put("canUseAppList", String.valueOf(i));
            options.put("appListPermission", z ? "1" : "0");
            options.put("disableUpAppInfo", z2 ? "1" : "0");
            options.put("EnableAppList", String.valueOf(i2));
            options.put("uploadAppList", z3 ? "1" : "0");
            options.put("common_version", String.valueOf(WindAds.sharedAds().getCommonVersion()));
            pointEntityCommon.setOptions(options);
        }
    }

    private void a(final File file, String crash) {
        PointEntitySigmobCrash pointEntitySigmobCrashWindCrash = PointEntitySigmobCrash.WindCrash(crash);
        if (file != null) {
            try {
                pointEntitySigmobCrashWindCrash.setCrashTime(Long.parseLong(file.getName().replace(".log", "")));
            } catch (Throwable th) {
                SigmobLog.e("set crash time fail", th);
            }
        }
        pointEntitySigmobCrashWindCrash.sendServe(new BuriedPointRequest.RequestListener() { // from class: com.sigmob.sdk.Sigmob.3
            public void onErrorResponse(VolleyError error) {
            }

            public void onSuccess() {
                File file2 = file;
                if (file2 == null) {
                    return;
                }
                file2.delete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setPermission(ClientMetadata.getInstance().getPermission(b.e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.contains(str) || str2.contains("com.czhj.")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("crashTime", System.currentTimeMillis());
                jSONObject.put("appId", WindAds.sharedAds().getAppId());
                jSONObject.put("sdkVersion", WindAds.sharedAds().getAppId());
                jSONObject.put("commonVersion", n.k);
                jSONObject.put("wmsession_id", PointEntitySuper.getSessionId());
                jSONObject.put("crashLog", URLEncoder.encode(str2, "UTF-8"));
                String string = jSONObject.toString();
                SigmobLog.e("crashLog " + string);
                File fileJ = com.sigmob.sdk.base.utils.i.j();
                if (fileJ != null) {
                    FileUtil.writeToBuffer(string.getBytes(), fileJ.getAbsolutePath());
                }
                a(fileJ, string);
            } catch (Throwable th) {
                SigmobLog.e("error ", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z) {
        if (z) {
            b();
            com.sigmob.sdk.base.services.b.b();
            c();
            com.sigmob.sdk.base.services.b.d();
        }
    }

    private static void b() {
        try {
            if (o.a().S()) {
                return;
            }
            f.a(f.a, i.a().i());
        } catch (Throwable th) {
            SigmobLog.e("updateLocationMonitor fail", th);
        }
    }

    private static void c() {
        try {
            f.a(f.b, true);
        } catch (Throwable th) {
            SigmobLog.e("initAppInstallService fail", th);
        }
    }

    public static BidRequest createRequest() {
        BidRequest.Builder builder = new BidRequest.Builder();
        try {
            builder = com.sigmob.sdk.base.network.a.a((LoadAdRequest) null);
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        return builder.build();
    }

    private static void d() {
        try {
            f.a(f.c, i.a().i() && o.a().W());
        } catch (Throwable th) {
            SigmobLog.e("updateWifiScanService fail", th);
        }
    }

    private static void e() {
        try {
            f.a(f.d, true);
        } catch (Throwable th) {
            SigmobLog.e("initDownloadService fail", th);
        }
    }

    private void f() {
        Networking.getSigRequestQueue().add(new JsonRequest(o.d(), new JsonRequest.Listener() { // from class: com.sigmob.sdk.Sigmob.2
            public void onErrorResponse(VolleyError error) {
                Sigmob.this.h();
                i.a().a((Boolean) null);
            }

            public void onSuccess(JSONObject response) {
                if (response != null) {
                    try {
                        i.a().a(Boolean.valueOf(response.getBoolean("is_request_in_eea_or_unknown")));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                Sigmob.this.h();
            }
        }, 0));
    }

    private void g() {
        try {
            File[] fileArrK = com.sigmob.sdk.base.utils.i.k();
            if (fileArrK == null) {
                return;
            }
            for (File file : fileArrK) {
                String fileToString = FileUtil.readFileToString(file);
                if (!TextUtils.isEmpty(fileToString)) {
                    a(file, fileToString);
                }
            }
        } catch (Throwable th) {
            SigmobLog.e("send crash Log fail", th);
        }
    }

    public static synchronized Sigmob getInstance() {
        if (a == null) {
            synchronized (Sigmob.class) {
                a = new Sigmob();
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        e();
        b.d();
        o.a().a(new o.a() { // from class: com.sigmob.sdk.Sigmob$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.o.a
            public final void onUpdate(boolean z) {
                Sigmob.a(z);
            }
        }).f();
        if (o.a().aa()) {
            String[] strArrSplit = WindAds.class.getName().split("\\.");
            if (strArrSplit.length <= 2) {
                return;
            }
            final String str = strArrSplit[0] + "." + strArrSplit[1] + ".";
            CrashHandler.getInstance().add(new CrashHandler.CrashHandlerListener() { // from class: com.sigmob.sdk.Sigmob$$ExternalSyntheticLambda1
                public final void reportCrash(String str2) {
                    this.f$0.a(str, str2);
                }
            });
            g();
        }
        i();
    }

    private void i() {
        Context contextE = b.e();
        if (contextE == null) {
            return;
        }
        ImageManager.with(contextE).clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        ac.a(PointCategory.APP);
        this.c = e.b();
        f();
    }

    public SigMacroCommon getMacroCommon() {
        if (macroCommon == null) {
            macroCommon = new SigMacroCommon();
        }
        return macroCommon;
    }

    public String getSDKToken() {
        b.a(true);
        String str = "2.01|" + a(createRequest().encode());
        ac.a("token_request", (String) null, (BaseAdUnit) null, (ac.a) null);
        SigmobLog.d("getSDKToken: " + str);
        return str;
    }

    public WindAdError getSigMobError() {
        return this.c;
    }

    public void init() {
        int i;
        boolean zIsCanUseAppList;
        final boolean z;
        WindCustomController customController;
        VolleyLog.DEBUG = n.f.booleanValue();
        WindAdOptions options = WindAds.sharedAds().getOptions();
        o oVarA = o.a();
        final int iAe = oVarA.ae();
        boolean zJ = oVarA.j();
        final boolean zT = oVarA.T();
        boolean z2 = false;
        if (options == null || (customController = options.getCustomController()) == null) {
            i = 0;
            zIsCanUseAppList = true;
        } else {
            zIsCanUseAppList = customController.isCanUseAppList();
            i = zIsCanUseAppList ? 1 : 2;
        }
        if (zJ) {
            z = z2;
        } else if (iAe != 1) {
            if (iAe != 2 && zIsCanUseAppList && !zT) {
                z2 = true;
            }
            z = z2;
        } else {
            z = true;
        }
        final boolean zD = e.d();
        final int i2 = i;
        ac.a(PointCategory.INIT, new ac.a() { // from class: com.sigmob.sdk.Sigmob$$ExternalSyntheticLambda2
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                Sigmob.a(i2, zD, zT, iAe, z, obj);
            }
        });
        if (o.a().Y()) {
            ac.a("permission", PointCategory.INIT, (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.Sigmob$$ExternalSyntheticLambda3
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    Sigmob.a(obj);
                }
            });
        }
        g.e();
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.Sigmob$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j();
            }
        });
        TrackManager.getInstance().setSigmobTrackListener(new TrackManager.Listener() { // from class: com.sigmob.sdk.Sigmob.1
            public void onErrorResponse(AdTracker tracker, VolleyError error) {
                ac.a(tracker, tracker.getUrl(), (BaseAdUnit) null, error);
            }

            public void onSuccess(AdTracker tracker, NetworkResponse response) {
                ac.a(tracker, tracker.getUrl(), (BaseAdUnit) null, response, (ac.a) null);
            }
        });
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.sigmob.sdk.Sigmob$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
        TrackManager.getInstance().startRetryTracking();
        b = true;
    }
}
