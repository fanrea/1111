package com.sigmob.windad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.n;
import com.sigmob.windad.consent.ConsentStatus;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindAds {
    public static final String ADN_ID = "ADN_ID";
    public static final String ADX_ID = "_adx_id";
    public static final String AD_SCENE_DESC = "scene_desc";
    public static final String AD_SCENE_ID = "scene_id";
    public static final String AUCTION_PRICE = "AUCTION_PRICE";
    public static final String CNY = "CNY";
    public static final String CURRENCY = "CURRENCY";
    public static final String HIGHEST_LOSS_PRICE = "HIGHEST_LOSS_PRICE";
    public static final String LOSS_REASON = "LOSS_REASON";
    public static final String REWARD_TYPE = "reward_type";
    public static final String SERVER_ARRIVED = "server_arrived";
    public static final String TRANS_ID = "trans_id";
    public static final String USD = "USD";
    private static volatile WindAds a;
    private boolean e;
    private OnInitializationListener g;
    private int i;
    private int k;
    private int l;
    private Context m;
    private volatile boolean b = false;
    private volatile boolean c = false;
    private boolean h = true;
    private boolean j = true;
    private boolean n = true;
    private WindAdOptions d = null;
    private Handler f = new Handler(Looper.getMainLooper());

    /* renamed from: com.sigmob.windad.WindAds$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConsentStatus.values().length];
            a = iArr;
            try {
                iArr[ConsentStatus.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ConsentStatus.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ConsentStatus.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private WindAds() {
    }

    private void a(String error) {
        SigmobLog.e("startWithOptions " + error);
        OnInitializationListener onInitializationListener = this.g;
        if (onInitializationListener == null) {
            return;
        }
        onInitializationListener.onInitializationFail(error);
    }

    private void b() {
        OnInitializationListener onInitializationListener = this.g;
        if (onInitializationListener == null) {
            return;
        }
        onInitializationListener.onInitializationSuccess();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[Catch: all -> 0x002f, PHI: r1
  0x002d: PHI (r1v2 int) = (r1v1 int), (r1v3 int) binds: [B:8:0x0027, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {all -> 0x002f, blocks: (B:7:0x0012, B:12:0x002d), top: B:19:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() {
        /*
            r3 = this;
            int r0 = r3.i
            if (r0 != 0) goto L2f
            com.sigmob.sdk.base.i r0 = com.sigmob.sdk.base.i.a()     // Catch: java.lang.Throwable -> Le
            int r0 = r0.g()     // Catch: java.lang.Throwable -> Le
            r3.i = r0     // Catch: java.lang.Throwable -> Le
        Le:
            int r0 = r3.i
            if (r0 != 0) goto L2f
            android.content.Context r0 = com.sigmob.sdk.b.e()     // Catch: java.lang.Throwable -> L2f
            com.sigmob.windad.consent.WindAdConsentInformation r0 = com.sigmob.windad.consent.WindAdConsentInformation.getInstance(r0)     // Catch: java.lang.Throwable -> L2f
            com.sigmob.windad.consent.ConsentStatus r0 = r0.getConsentStatus()     // Catch: java.lang.Throwable -> L2f
            int[] r1 = com.sigmob.windad.WindAds.AnonymousClass2.a     // Catch: java.lang.Throwable -> L2f
            int r0 = r0.ordinal()     // Catch: java.lang.Throwable -> L2f
            r0 = r1[r0]     // Catch: java.lang.Throwable -> L2f
            r1 = 1
            if (r0 == r1) goto L2d
            r1 = 2
            if (r0 == r1) goto L2d
            goto L2f
        L2d:
            r3.i = r1     // Catch: java.lang.Throwable -> L2f
        L2f:
            com.sigmob.sdk.base.i r0 = com.sigmob.sdk.base.i.a()
            int r1 = r3.i
            r2 = 0
            r0.c(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.windad.WindAds.c():void");
    }

    private void d() {
        try {
            if (this.k == 0) {
                this.k = i.a().c();
            } else {
                i.a().b(this.k, false);
            }
            if (this.l == 0) {
                this.l = i.a().b();
            } else {
                i.a().a(this.l, false);
            }
        } catch (Throwable unused) {
        }
    }

    private void e() {
        try {
            d();
            c();
            i.a().b(this.j, false);
            i.a().a(this.h, false);
        } catch (Throwable th) {
            SigmobLog.e("loadPrivacyInfo", th);
        }
    }

    public static String getUserId() {
        return ClientMetadata.getUserId();
    }

    public static String getVersion() {
        return n.k;
    }

    public static void requestPermission(Activity activity) {
        if (activity == null || Build.VERSION.SDK_INT < 23 || ClientMetadata.isPermissionGranted(activity, "android.permission.READ_PHONE_STATE")) {
            return;
        }
        activity.requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 0);
    }

    public static void setOAIDCertPem(String certPem) {
        try {
            ClientMetadata.setOAIDCertPem(certPem);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setUserId(String userId) {
        ClientMetadata.setUserId(userId);
    }

    public static WindAds sharedAds() {
        if (a == null) {
            synchronized (WindAds.class) {
                if (a == null) {
                    WindAds windAds = new WindAds();
                    windAds.setDebugEnable(true);
                    a = windAds;
                }
            }
        }
        return a;
    }

    protected int a() {
        return 159;
    }

    public void checkAndResGuard(Context context) {
        if (ResourceUtil.getLayoutId(context, "sig_new_interstitial_layout") != 0) {
            return;
        }
        SigmobLog.e("The Wind SDK resources may have been obfuscated by AndResGuard. Please add the following " + new ArrayList<String>() { // from class: com.sigmob.windad.WindAds.1
            {
                add("R.string.sig_*");
                add("R.integer.sig_*");
                add("R.layout.sig_*");
                add("R.drawable.sig_*");
                add("R.style.sig_*");
                add("R.dimen.sig_*");
                add("R.anim.sig_*");
                add("R.color.sig_*");
                add("R.id.sig_*");
                add("R.attr.sig_*");
            }
        } + " to the whitelist.");
    }

    public int getAgeRestrictedStatus() {
        return this.k;
    }

    public String getAppId() {
        WindAdOptions windAdOptions = this.d;
        if (windAdOptions == null) {
            return null;
        }
        return windAdOptions.getAppId();
    }

    public String getAppKey() {
        WindAdOptions windAdOptions = this.d;
        if (windAdOptions == null) {
            return null;
        }
        return windAdOptions.getAppKey();
    }

    public int getCommonVersion() {
        try {
            return Constants.getVersion();
        } catch (Throwable unused) {
            return 183;
        }
    }

    public Handler getHandler() {
        if (this.f == null) {
            this.f = new Handler(Looper.getMainLooper());
        }
        return this.f;
    }

    public WindAdOptions getOptions() {
        return this.d;
    }

    public String getSDKToken() {
        if (this.c) {
            return Sigmob.getInstance().getSDKToken();
        }
        return null;
    }

    public boolean getSensorStatus() {
        return this.n;
    }

    public int getUserAge() {
        return this.l;
    }

    public int getUserGDPRConsentStatus() {
        return this.i;
    }

    public String getWindUid() {
        try {
            return ClientMetadata.getUid();
        } catch (Exception e) {
            e.printStackTrace();
            return "Please initialize the SDK properly first";
        }
    }

    public boolean init(Context context, WindAdOptions options, OnInitializationListener onInitializationListener) {
        synchronized (this) {
            this.g = onInitializationListener;
            if (!this.b) {
                if (Build.VERSION.SDK_INT < 18) {
                    a("Wind SDK Only Support Android API 18+.");
                    return false;
                }
                if (context == null) {
                    a("context is null.");
                    return false;
                }
                if (options == null) {
                    a("WindAdOptions is null.");
                    return false;
                }
                if (TextUtils.isEmpty(options.getAppId())) {
                    a("appId is empty.");
                    return false;
                }
                if (getCommonVersion() < 183) {
                    a("Your COMMON Lib version must be equal or higher than 183, current Version :[ " + getCommonVersion() + " ]");
                    return false;
                }
                this.d = options;
                this.m = context.getApplicationContext();
                this.b = true;
            }
            b();
            return true;
        }
    }

    public boolean isAdult() {
        return this.h;
    }

    public boolean isDebugEnable() {
        return this.e;
    }

    public boolean isInit() {
        return this.b;
    }

    public boolean isPersonalizedAdvertisingOn() {
        return this.j;
    }

    public void setAdult(boolean isAdult) {
        this.h = isAdult;
        SigmobLog.i("Windads -> setAdult " + isAdult);
        if (this.c) {
            i.a().a(isAdult, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDebugEnable(boolean r2) {
        /*
            r1 = this;
            r1.e = r2
            java.lang.Boolean r0 = com.sigmob.sdk.base.n.f
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Lf
            if (r2 == 0) goto L14
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            goto L16
        Lf:
            if (r2 == 0) goto L14
            java.util.logging.Level r2 = java.util.logging.Level.INFO
            goto L16
        L14:
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
        L16:
            com.czhj.sdk.logger.SigmobLog.setSdkHandlerLevel(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.windad.WindAds.setDebugEnable(boolean):void");
    }

    public void setIsAgeRestrictedUser(int windAgeRestrictedStatus) {
        this.k = windAgeRestrictedStatus;
        if (this.c) {
            i.a().b(windAgeRestrictedStatus, true);
        }
    }

    public void setOAIDCertFileName(String fileName) {
        ClientMetadata.setOaidCertFileName(fileName);
    }

    public void setPersonalizedAdvertisingOn(boolean isPersonalizedAdvertisingOn) {
        this.j = isPersonalizedAdvertisingOn;
        SigmobLog.i("Windads -> setPersonalized " + isPersonalizedAdvertisingOn);
        if (this.c) {
            i.a().b(isPersonalizedAdvertisingOn, true);
        }
    }

    public void setSensorStatus(boolean status) {
        this.n = status;
    }

    public void setUserAge(int userAge) {
        this.l = userAge;
        if (this.c) {
            i.a().a(userAge, true);
        }
    }

    public void setUserGDPRConsentStatus(int windConsentStatus) {
        this.i = windConsentStatus;
        if (this.c) {
            i.a().c(windConsentStatus, true);
        }
    }

    public void start(OnStartListener onStartListener) {
        synchronized (this) {
            if (this.b) {
                if (!this.c) {
                    try {
                        b.a(this.m.getApplicationContext());
                        e();
                        Sigmob.getInstance().init();
                        this.c = true;
                        SigmobLog.i("start appId: " + this.d.getAppId());
                    } catch (Throwable th) {
                        if (onStartListener != null) {
                            onStartListener.onStartFail("Wind SDK Start fail Exception " + th.getMessage());
                        }
                        SigmobLog.e("Wind SDK Start fail", th);
                        return;
                    }
                }
                if (onStartListener == null) {
                } else {
                    onStartListener.onStartSuccess();
                }
            } else if (onStartListener == null) {
            } else {
                onStartListener.onStartFail("Wind SDK Start fail, need Init SDK first.");
            }
        }
    }
}
