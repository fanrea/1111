package com.sigmob.sdk.mraid2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.dhylive.app.utils.SPConfig;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.MiMarketManager;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.an;
import com.sigmob.sdk.base.common.t;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.views.ap;
import com.sigmob.sdk.base.views.w;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.mraid2.p;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeAdData;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class p extends com.sigmob.sdk.videoAd.b {
    public static final String f = "p";
    List<BaseAdUnit> g;
    private final Bundle h;
    private int i;
    private boolean j;
    private d k;
    private ap l;
    private com.sigmob.sdk.nativead.a m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private w r;
    private final Handler s;
    private boolean t;
    private final View.OnClickListener u;

    /* renamed from: com.sigmob.sdk.mraid2.p$2, reason: invalid class name */
    class AnonymousClass2 implements d.b {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, BaseAdUnit baseAdUnit, String str2, String str3, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                if (baseAdUnit.getAndroidMarket() == null) {
                    return;
                }
                Map options = pointEntitySigmob.getOptions();
                options.put("app_package_name", str2);
                options.put("store_package_name", str3);
            }
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void a() {
            SigmobLog.d("MraidActivity failed to load. Finishing the activity");
            if (p.this.b != null) {
                p.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            p.this.d.a();
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void a(View view) {
            SigmobLog.d("onLoaded() called");
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void a(final g webView, final BaseAdUnit adUnit, JSONObject args) throws IntentNotResolvableException {
            p pVar;
            g gVar;
            BaseAdUnit baseAdUnit;
            String str;
            JSONObject jSONObject;
            String message;
            String str2;
            int interactionType = adUnit == null ? -1 : adUnit.getInteractionType();
            String deeplinkUrl = adUnit == null ? null : adUnit.getDeeplinkUrl();
            String str3 = "open: deeplinkUrl = " + deeplinkUrl + ", interactionType = " + interactionType;
            int i = 0;
            SigmobLogger.d(p.f, str3, new Object[0]);
            final String strOptString = args.optString("url");
            final String strOptString2 = args.optString(NotificationCompat.CATEGORY_EVENT);
            JSONObject jSONObjectOptJSONObject = args.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            final JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("log_data");
            final String strOptString3 = jSONObjectOptJSONObject.optString("default_url");
            final boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("in_app");
            boolean zOptBoolean2 = jSONObjectOptJSONObject.optBoolean("parse_302");
            int iOptInt = jSONObjectOptJSONObject.optInt("interaction_type");
            String message2 = "";
            if (iOptInt == 1) {
                if (zOptBoolean2) {
                    an.a(strOptString, new an.a() { // from class: com.sigmob.sdk.mraid2.p.2.1
                        @Override // com.sigmob.sdk.base.common.an.a
                        public void a(String resolvedUrl) throws IntentNotResolvableException {
                            p.this.a(webView, adUnit, strOptString2, resolvedUrl, jSONObjectOptJSONObject2, strOptString3, zOptBoolean);
                        }

                        @Override // com.sigmob.sdk.base.common.an.a
                        public void a(String message3, Throwable throwable) throws IntentNotResolvableException {
                            p.this.a(webView, adUnit, strOptString2, strOptString, jSONObjectOptJSONObject2, strOptString3, zOptBoolean);
                        }
                    });
                    return;
                } else {
                    p.this.a(webView, adUnit, strOptString2, strOptString, jSONObjectOptJSONObject2, strOptString3, zOptBoolean);
                    return;
                }
            }
            if (iOptInt != 2) {
                if (iOptInt != 3) {
                    String str4 = "1";
                    String str5 = "open_deeplink";
                    if (iOptInt == 7) {
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("program");
                        if (jSONObjectOptJSONObject3 == null) {
                            return;
                        }
                        try {
                            t.a(com.sigmob.sdk.b.e(), jSONObjectOptJSONObject3.optString(SPConfig.WX_APP_ID), jSONObjectOptJSONObject3.optString("wx_app_username"), jSONObjectOptJSONObject3.optString("wx_app_path"), jSONObjectOptJSONObject3.optInt("wx_business_type"), jSONObjectOptJSONObject3.optString("wx_ext_msg"));
                            message = "";
                        } catch (Throwable th) {
                            message = th.getMessage();
                        }
                        if (adUnit != null) {
                            try {
                                boolean zA = com.sigmob.sdk.base.utils.m.a((CharSequence) message);
                                if (!zA) {
                                    str5 = "open_deeplink_failed";
                                }
                                ClickCommon clickCommon = adUnit.getClickCommon();
                                if (!zA) {
                                    str4 = "0";
                                }
                                clickCommon.isDeeplink = str4;
                                com.sigmob.sdk.manager.b.b(adUnit, str5, strOptString);
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                pVar = p.this;
                                gVar = webView;
                                baseAdUnit = adUnit;
                                str = strOptString2;
                                jSONObject = jSONObjectOptJSONObject2;
                                pVar.a(gVar, baseAdUnit, str, jSONObject, message);
                            }
                        }
                        pVar = p.this;
                        gVar = webView;
                        baseAdUnit = adUnit;
                        str = strOptString2;
                        jSONObject = jSONObjectOptJSONObject2;
                    } else {
                        if (iOptInt != 8) {
                            return;
                        }
                        if (com.sigmob.sdk.base.utils.m.b(strOptString)) {
                            try {
                                t.b(p.this.l(), new Intent("android.intent.action.VIEW", Uri.parse(strOptString)));
                                message = "";
                            } catch (Throwable th2) {
                                message = th2.getMessage();
                            }
                        } else {
                            message = "market_url is null";
                        }
                        if (adUnit != null) {
                            try {
                                boolean zA2 = com.sigmob.sdk.base.utils.m.a((CharSequence) message);
                                if (!zA2) {
                                    str5 = "open_deeplink_failed";
                                }
                                ClickCommon clickCommon2 = adUnit.getClickCommon();
                                if (!zA2) {
                                    str4 = "0";
                                }
                                clickCommon2.isDeeplink = str4;
                                com.sigmob.sdk.manager.b.b(adUnit, str5, strOptString);
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                pVar = p.this;
                                gVar = webView;
                                baseAdUnit = adUnit;
                                str = strOptString2;
                                jSONObject = jSONObjectOptJSONObject2;
                                pVar.a(gVar, baseAdUnit, str, jSONObject, message);
                            }
                        }
                        pVar = p.this;
                        gVar = webView;
                        baseAdUnit = adUnit;
                        str = strOptString2;
                        jSONObject = jSONObjectOptJSONObject2;
                    }
                    pVar.a(gVar, baseAdUnit, str, jSONObject, message);
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("market");
                if (jSONObjectOptJSONObject4 == null) {
                    return;
                }
                final String strOptString4 = jSONObjectOptJSONObject4.optString("market_url");
                final String strOptString5 = jSONObjectOptJSONObject4.optString("app_package_name");
                final String strOptString6 = jSONObjectOptJSONObject4.optString("appstore_package_name");
                String strOptString7 = jSONObjectOptJSONObject4.optString("type");
                if (com.sigmob.sdk.base.utils.m.b(strOptString4)) {
                    if (com.sigmob.sdk.base.utils.m.b(strOptString7)) {
                        try {
                            i = Integer.parseInt(strOptString7);
                        } catch (Throwable unused) {
                        }
                    }
                    String strA = (!com.sigmob.sdk.base.utils.m.b(strOptString6) || AppPackageUtil.getPackageVersionCode(p.this.a, strOptString6) == -1) ? null : strOptString6;
                    Uri uri = Uri.parse(strOptString4);
                    if (com.sigmob.sdk.base.utils.m.a((CharSequence) strA) && adUnit != null) {
                        strA = t.a(p.this.a, uri, adUnit.getMarketPackageNameList());
                    }
                    if (i == 1) {
                        new MiMarketManager.DirectMailStatusReceiver().a(com.sigmob.sdk.b.e(), adUnit);
                    }
                    try {
                        t.a(p.this.l(), uri, strA);
                    } catch (Throwable th3) {
                        message2 = th3.getMessage();
                    }
                } else {
                    message2 = "market_url is null";
                }
                if (adUnit != null) {
                    try {
                        if (com.sigmob.sdk.base.utils.m.a((CharSequence) message2)) {
                            str2 = PointCategory.OPEN_MARKET;
                            if (com.sigmob.sdk.base.utils.m.b(strOptString5)) {
                                FileUtil.writeToCache(adUnit, new File(com.sigmob.sdk.base.utils.i.g(), strOptString5 + ".log").getAbsolutePath());
                            }
                            ac.a(PointCategory.APK_CLICK, i == 1 ? "mimarket" : "market", adUnit);
                        } else {
                            str2 = PointCategory.OPEN_MARKET_FAILED;
                        }
                        ac.a(str2, (String) null, adUnit, new ac.a() { // from class: com.sigmob.sdk.mraid2.p$2$$ExternalSyntheticLambda0
                            @Override // com.sigmob.sdk.base.common.ac.a
                            public final void onAddExtra(Object obj) {
                                p.AnonymousClass2.a(strOptString4, adUnit, strOptString5, strOptString6, obj);
                            }
                        });
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                if (adUnit == null) {
                    List<BaseAdUnit> adUnitList = webView.getAdUnitList();
                    if (adUnitList == null || adUnitList.isEmpty()) {
                        SigmobLog.d("adUnits is null or empty.");
                        return;
                    }
                    BaseAdUnit baseAdUnit2 = webView.getAdUnitList().get(0);
                    baseAdUnit2.setRecord(false);
                    com.sigmob.sdk.base.common.h.a(baseAdUnit2, strOptString, zOptBoolean2);
                    p.this.a(webView, baseAdUnit2, strOptString2, jSONObjectOptJSONObject2, "");
                    return;
                }
                adUnit.setRecord(true);
                com.sigmob.sdk.base.common.h.a(adUnit, strOptString, zOptBoolean2);
            }
            pVar = p.this;
            gVar = webView;
            baseAdUnit = adUnit;
            str = strOptString2;
            jSONObject = jSONObjectOptJSONObject2;
            message = message2;
            pVar.a(gVar, baseAdUnit, str, jSONObject, message);
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void a(WindAdError error) {
            SigmobLog.d("Finishing the activity due to a problem: " + error);
            if (p.this.b != null) {
                p.this.a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            }
            p.this.d.a();
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void a(boolean useCustomClose) {
            if (useCustomClose) {
                p.this.r();
            } else {
                p.this.s();
            }
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void b() {
            p.this.a(IntentActions.ACTION_REWARDED_VIDEO_CLOSE);
            p.this.o = true;
            p.this.d.a();
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void c() {
            if (p.this.j) {
                return;
            }
            p.this.j = true;
            p.this.a(IntentActions.ACTION_REWARDED_VIDEO_COMPLETE);
        }

        @Override // com.sigmob.sdk.mraid2.d.b
        public void d() {
            p.this.p = true;
        }
    }

    /* renamed from: com.sigmob.sdk.mraid2.p$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public p(Activity activity, BaseAdUnit baseAdUnit, Bundle intentExtras, Bundle savedInstanceState, String mBroadcastIdentifier, com.sigmob.sdk.base.common.j baseAdViewControllerListener) {
        super(activity, mBroadcastIdentifier, baseAdViewControllerListener);
        this.o = false;
        this.p = false;
        this.q = true;
        this.s = new Handler();
        this.u = new View.OnClickListener() { // from class: com.sigmob.sdk.mraid2.p.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BaseAdUnit baseAdUnit2;
                Activity activityN = p.this.n();
                if (activityN == null || com.sigmob.sdk.base.utils.e.a(p.this.g) || (baseAdUnit2 = p.this.g.get(0)) == null) {
                    return;
                }
                p pVar = p.this;
                if (pVar.a(pVar.m)) {
                    return;
                }
                p.this.m = new com.sigmob.sdk.nativead.a(activityN, baseAdUnit2);
                p.this.m.a();
                p.this.m.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid2.p.3.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() {
                        p.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int position, String value, boolean enforce) {
                        p.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() {
                    }
                });
            }
        };
        this.g = com.sigmob.sdk.base.common.g.e(baseAdUnit.getUuid());
        this.h = intentExtras;
        d dVarA = b.a().a(baseAdUnit.getUuid());
        this.k = dVarA;
        if (dVarA == null) {
            this.k = new d(com.sigmob.sdk.b.e(), this.g);
        }
        if (Build.VERSION.SDK_INT >= 20) {
            a(new View.OnApplyWindowInsetsListener() { // from class: com.sigmob.sdk.mraid2.p$$ExternalSyntheticLambda3
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return this.f$0.a(view, windowInsets);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets a(View view, WindowInsets windowInsets) {
        this.k.a(windowInsets, this.t);
        return windowInsets;
    }

    private void a(int position, RelativeLayout.LayoutParams layoutParams) {
        int i;
        int iDipsToIntPixels = Dips.dipsToIntPixels(10.0f, this.a);
        if (position == 1 || position == 2) {
            layoutParams.addRule(10);
            i = 9;
        } else {
            if (position != 3 && position != 4) {
                return;
            }
            layoutParams.addRule(10);
            i = 11;
        }
        layoutParams.addRule(i);
        layoutParams.setMargins(iDipsToIntPixels, iDipsToIntPixels * 2, iDipsToIntPixels, iDipsToIntPixels);
    }

    private void a(Context context, int visibility) {
        if (this.r == null) {
            w wVar = new w(context);
            this.r = wVar;
            wVar.setText("反馈");
            this.r.setOnClickListener(this.u);
            this.r.setId(ClientMetadata.generateViewId());
            int iDipsToIntPixels = Dips.dipsToIntPixels(3.0f, this.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            layoutParams.addRule(0, this.l.getId());
            layoutParams.addRule(6, this.l.getId());
            layoutParams.setMargins(0, -iDipsToIntPixels, 0, 0);
            m().addView(this.r, layoutParams);
        }
        w wVar2 = this.r;
        if (wVar2 != null) {
            wVar2.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(BaseAdUnit baseAdUnit, ClickCommon clickCommon, JSONObject jSONObject, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
            pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
            pointEntitySigmob.setIs_deeplink(clickCommon.isDeeplink);
            pointEntitySigmob.setFinal_url(clickCommon.clickUrl);
            pointEntitySigmob.setCoordinate(clickCommon.clickCoordinate);
            pointEntitySigmob.setVtime(String.format(Locale.getDefault(), "%.2f", Float.valueOf(0.0f)));
            Map options = pointEntitySigmob.getOptions();
            if (com.sigmob.sdk.base.utils.n.b(jSONObject)) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    options.put(next, jSONObject.optString(next));
                }
            }
            options.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
            options.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004d A[PHI: r7
  0x004d: PHI (r7v3 java.lang.String) = (r7v2 java.lang.String), (r7v2 java.lang.String), (r7v0 java.lang.String) binds: [B:44:0x00cc, B:46:0x00d2, B:10:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[Catch: Exception -> 0x0111, TryCatch #4 {Exception -> 0x0111, blocks: (B:40:0x00b5, B:42:0x00bb, B:43:0x00c8, B:45:0x00ce, B:49:0x00d8, B:51:0x00ee, B:50:0x00df, B:52:0x00fe), top: B:65:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.sigmob.sdk.mraid2.g r13, com.sigmob.sdk.base.models.BaseAdUnit r14, java.lang.String r15, java.lang.String r16, org.json.JSONObject r17, java.lang.String r18, boolean r19) throws com.czhj.sdk.common.exceptions.IntentNotResolvableException {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.p.a(com.sigmob.sdk.mraid2.g, com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, java.lang.String, org.json.JSONObject, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g webView, final BaseAdUnit adUnit, String key, final JSONObject logData, String errMsg) {
        c mraidBridge = webView.getMraidBridge();
        try {
            if (com.sigmob.sdk.base.utils.m.b(errMsg)) {
                if (com.sigmob.sdk.base.utils.n.b(mraidBridge)) {
                    mraidBridge.b(key + "_failed", errMsg);
                    return;
                }
                return;
            }
            if (adUnit != null && logData != null) {
                String requestId = adUnit.getRequestId();
                int iOptInt = logData.optInt(ClickCommon.CLICK_LOSE_RATE, 0);
                int iOptInt2 = logData.optInt(ClickCommon.CLICK_CB_STATE, com.sigmob.sdk.base.utils.c.b);
                com.sigmob.sdk.base.utils.c.a(requestId, Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                adUnit.getMacroCommon().addMarcoKey(SigMacroCommon._ISNC_, String.valueOf(iOptInt2));
                adUnit.getClickCommon().click_lose_rate = Integer.valueOf(iOptInt);
                adUnit.getClickCommon().click_cb_state = Integer.valueOf(iOptInt2);
            }
            a(IntentActions.ACTION_INTERSTITIAL_CLICK);
            if (com.sigmob.sdk.base.utils.n.b(mraidBridge)) {
                mraidBridge.b(key + "_success", "");
            }
            if (adUnit != null && adUnit.isRecord()) {
                final ClickCommon clickCommon = adUnit.getClickCommon();
                String strOptString = logData == null ? null : logData.optString("category");
                if (!com.sigmob.sdk.base.utils.m.b(strOptString)) {
                    strOptString = com.sigmob.sdk.base.a.ENDCARD.name().toLowerCase();
                }
                ac.a(strOptString, "click", adUnit, new ac.a() { // from class: com.sigmob.sdk.mraid2.p$$ExternalSyntheticLambda1
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        p.a(adUnit, clickCommon, logData, obj);
                    }
                });
                com.sigmob.sdk.base.network.g.a(adUnit, "click");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String event, boolean isViewable) throws JSONException {
        g gVarC;
        c mraidBridge;
        d dVar = this.k;
        if (dVar == null || (gVarC = dVar.c()) == null || (mraidBridge = gVarC.getMraidBridge()) == null) {
            return;
        }
        mraidBridge.a(event, (HashMap<String, Object>) null);
        mraidBridge.a(isViewable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.o = true;
            this.n = true;
            k().a();
        }
        return true;
    }

    private void b(Context context, int initialVisibility) {
        if (this.l != null) {
            return;
        }
        ap apVar = new ap(context);
        this.l = apVar;
        apVar.setVisibility(initialVisibility);
        this.l.setId(ClientMetadata.generateViewId());
        int iDipsToIntPixels = Dips.dipsToIntPixels(22.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        a(3, layoutParams);
        m().addView(this.l, layoutParams);
        this.l.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.mraid2.p$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.a(view, motionEvent);
            }
        });
        this.l.a(this.g.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.p || com.sigmob.sdk.base.utils.e.a(this.g)) {
            return;
        }
        ac.b("h5_state", "0", this.g.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.sigmob.sdk.nativead.a aVar = this.m;
        if (aVar == null) {
            return;
        }
        aVar.dismiss();
        this.m.b();
        this.m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        ap apVar = this.l;
        if (apVar != null) {
            apVar.setVisibility(4);
        }
        w wVar = this.r;
        if (wVar != null) {
            wVar.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.l == null) {
            b(this.a, 0);
        }
        this.l.setVisibility(0);
        a(l(), 0);
    }

    public View a() {
        if (this.k == null) {
            this.k = new d(this.a, this.g);
        }
        this.k.a(this.e);
        this.k.a(new d.a() { // from class: com.sigmob.sdk.mraid2.p.1
            @Override // com.sigmob.sdk.mraid2.d.a
            public void a() {
                p.this.c();
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void a(int red, int green, int blue, int alpha) {
                try {
                    if (alpha == 0) {
                        p.this.m().setBackgroundColor(0);
                    } else {
                        p.this.m().setBackgroundColor(Color.argb((int) ((alpha / 100.0f) * 255.0f), red, green, blue));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void a(BaseAdUnit adUnit) {
                if (adUnit == null && com.sigmob.sdk.base.utils.e.b(p.this.g)) {
                    adUnit = p.this.g.get(0);
                }
                Activity activityN = p.this.n();
                if (activityN == null || adUnit == null) {
                    return;
                }
                p pVar = p.this;
                if (pVar.a(pVar.m)) {
                    return;
                }
                p.this.m = new com.sigmob.sdk.nativead.a(activityN, adUnit);
                p.this.m.a();
                p.this.m.a(new WindNativeAdData.DislikeInteractionCallback() { // from class: com.sigmob.sdk.mraid2.p.1.1
                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onCancel() throws JSONException {
                        p.this.a("feedbackDidDisappear", true);
                        p.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onSelected(int position, String value, boolean enforce) throws JSONException {
                        p.this.a("feedbackDidDisappear", true);
                        p.this.q();
                    }

                    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
                    public void onShow() throws JSONException {
                        p.this.a("feedbackDidAppear", false);
                    }
                });
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public boolean a(ConsoleMessage consoleMessage) {
                if (AnonymousClass4.a[consoleMessage.messageLevel().ordinal()] == 1) {
                    SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                    ac.a("h5_error", "mraid2", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, p.this.g.get(0), (ac.a) null);
                }
                return false;
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public boolean a(String message, JsResult result) {
                return false;
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void b() {
                p.this.d();
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void c() {
                p.this.t = true;
            }

            @Override // com.sigmob.sdk.mraid2.d.a
            public void d() {
                p.this.a(IntentActions.ACTION_INTERSTITIAL_SHOW);
            }
        });
        this.k.a(new AnonymousClass2());
        return this.k.e();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Configuration configuration) throws JSONException {
        d dVar = this.k;
        if (dVar == null) {
            return;
        }
        dVar.a(configuration.orientation);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Bundle outState) {
    }

    @Override // com.sigmob.sdk.videoAd.b, com.sigmob.sdk.base.common.i
    public void e() {
        super.e();
        n().getWindow().addFlags(16778240);
        b(n(), this.i, this.h);
        BaseAdUnit baseAdUnit = this.g.get(0);
        if (baseAdUnit != null && (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1)) {
            b();
            m().setBackgroundColor(Color.argb(127, 0, 0, 0));
        }
        m().addView(a(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f() throws JSONException {
        if (!this.o) {
            this.k.a();
        } else {
            this.q = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void g() throws JSONException {
        this.k.b();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void h() {
        d dVar = this.k;
        if (dVar != null) {
            dVar.d();
        }
        q();
        if (com.sigmob.sdk.base.utils.e.b(this.g)) {
            if (this.n) {
                BaseAdUnit baseAdUnit = this.g.get(0);
                if (com.sigmob.sdk.base.utils.n.b(baseAdUnit)) {
                    com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_close");
                    ac.a("ad_close", (String) null, baseAdUnit);
                }
            }
            for (BaseAdUnit baseAdUnit2 : this.g) {
                if (baseAdUnit2 != null) {
                    baseAdUnit2.destroy();
                }
            }
        }
        if (!this.o || !this.q) {
            this.q = true;
            a(IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        Sigmob.getInstance().getMacroCommon().clearMacro();
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public boolean j() {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void o() {
        d dVar = this.k;
        if (dVar != null) {
            dVar.a(this.g.get(0));
        }
        this.s.postDelayed(new Runnable() { // from class: com.sigmob.sdk.mraid2.p$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        }, 5000L);
        a(IntentActions.ACTION_INTERSTITIAL_VOPEN);
    }
}
