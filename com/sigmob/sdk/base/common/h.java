package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.views.q;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    public static final String a = "h";
    protected Map<String, String> b;
    protected String c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    protected String h;
    protected String i;
    public boolean k;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;
    private aa q;
    private com.sigmob.sdk.base.views.q r;
    private WeakReference<Activity> s;
    private q.b t;
    private WeakReference<BaseAdUnit> u;
    private boolean v;
    private int w;
    protected int j = 1;
    private final List<com.sigmob.sdk.videoAd.d> l = new ArrayList();

    /* renamed from: com.sigmob.sdk.base.common.h$2, reason: invalid class name */
    class AnonymousClass2 implements JsonRequest.Listener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(h.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(h.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(h.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(h.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(h.this.o);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(h.this.o);
            }
        }

        public void onErrorResponse(VolleyError error) {
            ac.a("download_start", "0", h.this.l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$2$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    this.f$0.b(obj);
                }
            });
            ac.a("download_start", 0, error.getMessage(), h.this.l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$2$$ExternalSyntheticLambda1
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    this.f$0.a(obj);
                }
            });
            SigmobLog.e(error.getMessage());
        }

        public void onSuccess(JSONObject response) {
            try {
                SigmobLog.d("GDTConvertRequest response " + response);
                if (response.getInt("ret") == 0) {
                    String string = response.getJSONObject("data").getString("dstlink");
                    h.this.l().getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, response.getJSONObject("data").getString("clickid"));
                    h.this.o = string;
                    o.a(string, h.this.l());
                } else {
                    ac.a("download_start", "0", h.this.l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$2$$ExternalSyntheticLambda2
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            this.f$0.f(obj);
                        }
                    });
                    ac.a("download_start", 0, response.toString(), h.this.l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$2$$ExternalSyntheticLambda3
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            this.f$0.e(obj);
                        }
                    });
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                ac.a("download_start", "0", h.this.l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$2$$ExternalSyntheticLambda4
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        this.f$0.d(obj);
                    }
                });
                ac.a("download_start", 0, th.getMessage(), h.this.l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$2$$ExternalSyntheticLambda5
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        this.f$0.c(obj);
                    }
                });
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.h$3, reason: invalid class name */
    class AnonymousClass3 implements JsonRequest.Listener {
        final /* synthetic */ BaseAdUnit a;
        final /* synthetic */ String b;

        AnonymousClass3(final BaseAdUnit val$adUnit, final String val$tempUrl) {
            this.a = val$adUnit;
            this.b = val$tempUrl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(String str, Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(str);
            }
        }

        public void onErrorResponse(VolleyError error) {
            BaseAdUnit baseAdUnit = this.a;
            final String str = this.b;
            ac.a("download_start", "0", baseAdUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.h$3$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    h.AnonymousClass3.b(str, obj);
                }
            });
            String message = error.getMessage();
            BaseAdUnit baseAdUnit2 = this.a;
            final String str2 = this.b;
            ac.a("download_start", 0, message, baseAdUnit2, new ac.a() { // from class: com.sigmob.sdk.base.common.h$3$$ExternalSyntheticLambda1
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    h.AnonymousClass3.a(str2, obj);
                }
            });
            SigmobLog.e(error.getMessage());
        }

        public void onSuccess(JSONObject response) {
            try {
                SigmobLog.d("GDTConvertRequest response " + response);
                if (response.getInt("ret") == 0) {
                    String string = response.getJSONObject("data").getString("dstlink");
                    this.a.getMacroCommon().addMarcoKey(SigMacroCommon._CLICKID_, response.getJSONObject("data").getString("clickid"));
                    o.a(string, this.a);
                } else {
                    BaseAdUnit baseAdUnit = this.a;
                    final String str = this.b;
                    ac.a("download_start", "0", baseAdUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.h$3$$ExternalSyntheticLambda2
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            h.AnonymousClass3.f(str, obj);
                        }
                    });
                    String string2 = response.toString();
                    BaseAdUnit baseAdUnit2 = this.a;
                    final String str2 = this.b;
                    ac.a("download_start", 0, string2, baseAdUnit2, new ac.a() { // from class: com.sigmob.sdk.base.common.h$3$$ExternalSyntheticLambda3
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            h.AnonymousClass3.e(str2, obj);
                        }
                    });
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                BaseAdUnit baseAdUnit3 = this.a;
                final String str3 = this.b;
                ac.a("download_start", "0", baseAdUnit3, new ac.a() { // from class: com.sigmob.sdk.base.common.h$3$$ExternalSyntheticLambda4
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        h.AnonymousClass3.d(str3, obj);
                    }
                });
                String message = th.getMessage();
                BaseAdUnit baseAdUnit4 = this.a;
                final String str4 = this.b;
                ac.a("download_start", 0, message, baseAdUnit4, new ac.a() { // from class: com.sigmob.sdk.base.common.h$3$$ExternalSyntheticLambda5
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        h.AnonymousClass3.c(str4, obj);
                    }
                });
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.h$4, reason: invalid class name */
    class AnonymousClass4 implements am.b {
        final /* synthetic */ BaseAdUnit a;
        final /* synthetic */ boolean b;
        final /* synthetic */ AndroidMarket c;
        final /* synthetic */ boolean d;
        final /* synthetic */ com.sigmob.sdk.base.a e;

        AnonymousClass4(final BaseAdUnit val$baseAdUnit, final boolean val$isRecord, final AndroidMarket val$androidMarket, final boolean val$showAppElement, final com.sigmob.sdk.base.a val$clickUIType) {
            this.a = val$baseAdUnit;
            this.b = val$isRecord;
            this.c = val$androidMarket;
            this.d = val$showAppElement;
            this.e = val$clickUIType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, AndroidMarket androidMarket, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                Map options = pointEntitySigmob.getOptions();
                options.put("app_package_name", androidMarket.app_package_name);
                options.put("store_package_name", androidMarket.appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, AndroidMarket androidMarket, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(str);
                if (androidMarket == null) {
                    return;
                }
                Map options = pointEntitySigmob.getOptions();
                options.put("app_package_name", androidMarket.app_package_name);
                options.put("store_package_name", androidMarket.appstore_package_name);
                pointEntitySigmob.setOptions(options);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void a(final String url, al urlAction) {
            SigmobLog.d("urlHandlingSucceeded: " + urlAction.name() + " url: " + url);
            this.a.getClickCommon().is_final_click = true;
            if (!this.a.getAd().forbiden_parse_landingpage.booleanValue()) {
                ac.a(this.a, urlAction.name(), url);
            }
            this.a.getClickCommon().isDeeplink = "0";
            int i = AnonymousClass5.b[urlAction.ordinal()];
            if (i == 3) {
                if (this.b) {
                    com.sigmob.sdk.manager.b.b(this.a, "open_deeplink", url);
                }
                this.a.getClickCommon().isDeeplink = "1";
            } else if (i != 5) {
                if (i == 6) {
                    if (this.d && h.this.j()) {
                        this.a.getClickCommon().is_final_click = false;
                    } else {
                        h.this.f(url);
                    }
                }
            } else if (this.b) {
                AndroidMarket androidMarket = this.c;
                if (androidMarket != null) {
                    ac.a(PointCategory.APK_CLICK, ((Integer) Wire.get(androidMarket.type, 0)).intValue() == 0 ? "market" : "mimarket", this.a);
                    if (!com.sigmob.sdk.base.utils.m.a((CharSequence) this.c.app_package_name)) {
                        try {
                            FileUtil.writeToCache(this.a, new File(com.sigmob.sdk.base.utils.i.g(), this.c.app_package_name + ".log").getAbsolutePath());
                        } catch (Throwable th) {
                            SigmobLog.e("write ad info with package error " + th.getMessage());
                        }
                    }
                }
                BaseAdUnit baseAdUnit = this.a;
                final AndroidMarket androidMarket2 = this.c;
                ac.a(PointCategory.OPEN_MARKET, (String) null, baseAdUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.h$4$$ExternalSyntheticLambda1
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        h.AnonymousClass4.b(url, androidMarket2, obj);
                    }
                });
            }
            this.a.setCustomDeeplink(null);
            this.a.setCustomAndroidMarket(null);
            this.a.setCustomLandPageUrl(null);
            if (h.this.q != null) {
                h.this.q.onAdClick(this.b, this.e);
            }
        }

        @Override // com.sigmob.sdk.base.common.am.b
        public void b(final String url, al urlAction) {
            SigmobLog.d("urlHandlingFailed: " + urlAction.name() + " url: " + url);
            this.a.getClickCommon().isDeeplink = "0";
            int i = AnonymousClass5.b[urlAction.ordinal()];
            if (i == 3 || i == 4) {
                if (this.b) {
                    com.sigmob.sdk.manager.b.b(this.a, "open_deeplink_failed", url);
                    return;
                }
                return;
            }
            if (i == 5) {
                if (this.b) {
                    BaseAdUnit baseAdUnit = this.a;
                    final AndroidMarket androidMarket = this.c;
                    ac.a(PointCategory.OPEN_MARKET_FAILED, url, baseAdUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.h$4$$ExternalSyntheticLambda0
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            h.AnonymousClass4.a(url, androidMarket, obj);
                        }
                    });
                    return;
                }
                return;
            }
            if (i != 8) {
                return;
            }
            if (com.sigmob.sdk.base.utils.m.a((CharSequence) url) && !this.a.getAd().forbiden_parse_landingpage.booleanValue()) {
                ac.a(this.a, urlAction.name(), url);
            }
            this.a.setCustomDeeplink(null);
            this.a.setCustomAndroidMarket(null);
            this.a.setCustomLandPageUrl(null);
            if (h.this.q != null) {
                h.this.q.onAdClick(this.b, this.e);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.h$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[al.values().length];
            b = iArr;
            try {
                iArr[al.FOLLOW_PACKAGE_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[al.IGNORE_ABOUT_SCHEME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[al.MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[al.FOLLOW_DEEP_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[al.MARKET_SCHEME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[al.DOWNLOAD_APK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[al.OPEN_WITH_BROWSER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[al.NOOP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[com.sigmob.sdk.base.a.values().length];
            a = iArr2;
            try {
                iArr2[com.sigmob.sdk.base.a.COMPANION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.sigmob.sdk.base.a.VIDEO_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    protected h() {
    }

    public static h a(BaseAdUnit adUnit) {
        h hVar = new h();
        hVar.b(adUnit);
        return hVar;
    }

    public static void a(final BaseAdUnit adUnit, final String url, boolean parse302) {
        final String strMacroProcess = adUnit.getMacroCommon().macroProcess(url);
        String apkPackageName = adUnit.getApkPackageName();
        if (adUnit.getsubInteractionType() == 2 || !com.sigmob.sdk.base.utils.m.a((CharSequence) apkPackageName)) {
            String productId = adUnit.getProductId();
            if (com.sigmob.sdk.base.utils.m.a((CharSequence) apkPackageName)) {
                apkPackageName = productId;
            }
            if (!com.sigmob.sdk.base.utils.m.a((CharSequence) apkPackageName)) {
                try {
                    g.c(adUnit);
                    t.c(com.sigmob.sdk.b.e(), apkPackageName);
                    return;
                } catch (Throwable th) {
                    g.c((BaseAdUnit) null);
                    SigmobLog.e("launch fail", th);
                }
            }
        }
        if (adUnit.getsubInteractionType() != 1 || parse302) {
            o.a(strMacroProcess, adUnit);
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(strMacroProcess, new AnonymousClass3(adUnit, strMacroProcess), 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.h$$ExternalSyntheticLambda2
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    h.b(strMacroProcess, obj);
                }
            });
            ac.a("download_start", 0, "request queue is null", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.h$$ExternalSyntheticLambda3
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    h.a(strMacroProcess, obj);
                }
            });
        } else {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        }
    }

    private void a(BaseAdUnit adUnit, boolean isRecord) throws UnsupportedEncodingException {
        if (adUnit == null || !isRecord) {
            return;
        }
        String str = adUnit.getClickCommon().is_final_click ? "1" : "0";
        SigMacroCommon macroCommon = adUnit.getMacroCommon();
        macroCommon.addMarcoKey("_AX_", adUnit.getClickCommon().adarea_x);
        macroCommon.addMarcoKey("_AY_", adUnit.getClickCommon().adarea_y);
        macroCommon.addMarcoKey("_AW_", adUnit.getClickCommon().adarea_w);
        macroCommon.addMarcoKey("_AH_", adUnit.getClickCommon().adarea_h);
        if ("5".equals(adUnit.getClickCommon().sld)) {
            macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
            macroCommon.addMarcoKey(SigMacroCommon._SLD_, adUnit.getClickCommon().sld);
            macroCommon.addMarcoKey("_TURNX_", adUnit.getClickCommon().turn_x);
            macroCommon.addMarcoKey("_TURNY_", adUnit.getClickCommon().turn_y);
            macroCommon.addMarcoKey("_TURNZ_", adUnit.getClickCommon().turn_z);
            macroCommon.addMarcoKey("_TURNTIME_", adUnit.getClickCommon().turn_time);
            macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(adUnit.getClickCommon().widget_id));
        } else if ("2".equals(adUnit.getClickCommon().sld)) {
            macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
            macroCommon.addMarcoKey(SigMacroCommon._SLD_, adUnit.getClickCommon().sld);
            macroCommon.addMarcoKey("_CPTIDS_", String.valueOf(adUnit.getClickCommon().widget_id));
            macroCommon.addMarcoKey("_XMAXACC_", adUnit.getClickCommon().x_max_acc);
            macroCommon.addMarcoKey("_YMAXACC_", adUnit.getClickCommon().y_max_acc);
            macroCommon.addMarcoKey("_ZMAXACC_", adUnit.getClickCommon().z_max_acc);
        } else if (adUnit.getCreativeType() != 9) {
            adUnit.getClickCommon().sld = "0";
            macroCommon.updateClickMarco(adUnit.getClickCommon().down, adUnit.getClickCommon().up);
            macroCommon.addMarcoKey(SigMacroCommon._SLD_, "0");
        }
        if (adUnit.getTemplateId() > 0) {
            macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(adUnit.getTemplateId()));
        }
        if (!com.sigmob.sdk.base.utils.m.a((CharSequence) adUnit.getClickCommon().click_area)) {
            macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(adUnit.getClickCommon().click_area));
        }
        if (!com.sigmob.sdk.base.utils.m.a((CharSequence) adUnit.getClickCommon().click_scene)) {
            macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(adUnit.getClickCommon().click_scene));
        }
        macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            ((PointEntitySigmobError) obj).setFinal_url(str);
        }
    }

    private void b(com.sigmob.sdk.base.a clickUIType, String url, String coordinate, boolean isDeeplink) {
        af sessionManager;
        BaseAdUnit baseAdUnitL = l();
        if (baseAdUnitL == null || (sessionManager = baseAdUnitL.getSessionManager()) == null) {
            return;
        }
        int i = AnonymousClass5.a[clickUIType.ordinal()];
        sessionManager.a(i != 1 ? i != 2 ? "click" : "full_video_click" : a.w, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseAdUnit l() {
        WeakReference<BaseAdUnit> weakReference = this.u;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.sigmob.sdk.base.views.q qVar = this.r;
        if (qVar == null) {
            return;
        }
        qVar.dismiss();
        this.r.c();
        this.r = null;
        this.m = false;
    }

    public List<com.sigmob.sdk.videoAd.d> a(long currentPosition, long duration) {
        if (duration <= 0 || currentPosition <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        com.sigmob.sdk.videoAd.d dVar = new com.sigmob.sdk.videoAd.d("play_quarter", currentPosition / duration);
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            com.sigmob.sdk.videoAd.d dVar2 = this.l.get(i);
            if (dVar2.compareTo(dVar) > 0) {
                break;
            }
            if (!dVar2.isTracked()) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    public void a(int duration) {
        this.w = duration;
    }

    public void a(Activity context, BaseAdUnit adUnit, q.b onPrivacyClickListener) {
        if (adUnit == null) {
            return;
        }
        if (context != null) {
            this.s = new WeakReference<>(context);
        }
        this.t = onPrivacyClickListener;
    }

    public void a(Context context, int contentPlayHead, BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ac.b("start", null, adUnit);
        com.sigmob.sdk.base.network.g.a(adUnit, "start");
    }

    public void a(Context context, TouchLocation down, TouchLocation up, com.sigmob.sdk.base.a clickUIType, BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(Context context, BaseAdUnit adUnit) {
        ac.a(PointCategory.LANDING_PAGE_SHOW, (String) null, adUnit);
    }

    public void a(Context context, String error, BaseAdUnit adUnit, String cate, int duration) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ac.a(cate, duration, error, adUnit);
    }

    public void a(com.sigmob.sdk.base.a clickUIType, String url, String coordinate, boolean isRecord) throws UnsupportedEncodingException {
        a(clickUIType, url, coordinate, isRecord, false);
    }

    public void a(com.sigmob.sdk.base.a clickUIType, String url, String coordinate, boolean isRecord, boolean showAppElement) throws UnsupportedEncodingException {
        ClickCommon clickCommon;
        BaseAdUnit baseAdUnitL = l();
        if (baseAdUnitL == null || (clickCommon = baseAdUnitL.getClickCommon()) == null) {
            return;
        }
        AndroidMarket androidMarket = baseAdUnitL.getAndroidMarket();
        String str = com.sigmob.sdk.base.utils.m.a((CharSequence) url) ? this.c : url;
        clickCommon.clickUIType = clickUIType;
        clickCommon.clickCoordinate = coordinate;
        clickCommon.clickUrl = str;
        a(baseAdUnitL, isRecord);
        new am.a().a(al.IGNORE_ABOUT_SCHEME, al.OPEN_WITH_BROWSER, al.MARKET_SCHEME, al.DOWNLOAD_APK, al.FOLLOW_PACKAGE_NAME, al.FOLLOW_DEEP_LINK, al.MINI_PROGRAM).a(new AnonymousClass4(baseAdUnitL, isRecord, androidMarket, showAppElement, clickUIType)).a(l()).a(baseAdUnitL.isSkipSigmobBrowser()).b(baseAdUnitL.getAd().forbiden_parse_landingpage.booleanValue()).a().a(com.sigmob.sdk.b.e(), url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.sigmob.sdk.base.a r18, java.lang.String r19, java.lang.String r20, boolean r21, boolean r22, org.json.JSONObject r23) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.h.a(com.sigmob.sdk.base.a, java.lang.String, java.lang.String, boolean, boolean, org.json.JSONObject):void");
    }

    public void a(com.sigmob.sdk.base.a clickUIType, String coordinate, boolean isRecord) throws UnsupportedEncodingException {
        a(clickUIType, (String) null, coordinate, isRecord, true);
    }

    public void a(aa onClickListener) {
        this.q = onClickListener;
    }

    public void a(final String dspCreativeId) {
        this.i = dspCreativeId;
    }

    public void a(final List<com.sigmob.sdk.videoAd.d> fractionalTrackers) {
        Preconditions.NoThrow.checkNotNull(fractionalTrackers, "fractionalTrackers cannot be null");
        this.l.addAll(fractionalTrackers);
        Collections.sort(this.l);
    }

    public boolean a() {
        return this.v;
    }

    public String b() {
        return this.i;
    }

    public void b(Context context, int contentPlayHead, BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(Context context, BaseAdUnit adUnit) {
        ac.a(PointCategory.LANDING_PAGE_CLOSE, (String) null, adUnit);
    }

    public void b(BaseAdUnit adUnit) {
        this.u = new WeakReference<>(adUnit);
    }

    public void b(final String clickThroughUrl) {
        this.c = clickThroughUrl;
    }

    public String c() {
        return this.c;
    }

    public void c(Context context, int contentPlayHead, BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void c(final BaseAdUnit adUnit) {
        com.sigmob.sdk.base.network.g.a(adUnit, a.w);
    }

    public void c(final String customCtaText) {
        if (customCtaText == null) {
            return;
        }
        this.f = customCtaText;
    }

    public String d() {
        return this.f;
    }

    public void d(final BaseAdUnit adUnit) {
        com.sigmob.sdk.base.network.g.a(adUnit, "full_video_click");
    }

    public void d(final String customSkipText) {
        if (customSkipText == null) {
            return;
        }
        this.g = customSkipText;
    }

    public String e() {
        return this.g;
    }

    public void e(final BaseAdUnit adUnit) {
        com.sigmob.sdk.base.network.g.a(adUnit, "click");
    }

    public void e(String customCloseIconUrl) {
        if (customCloseIconUrl == null) {
            return;
        }
        this.h = customCloseIconUrl;
    }

    public String f() {
        return this.h;
    }

    public void f(String realClickUrl) {
        BaseAdUnit baseAdUnitL = l();
        if (baseAdUnitL == null) {
            return;
        }
        if (o.a(this.o)) {
            try {
                ai.a(com.sigmob.sdk.b.e(), "正在下载", 1).show();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String landing_page = baseAdUnitL.getLanding_page();
        if (!com.sigmob.sdk.base.utils.m.a((CharSequence) realClickUrl)) {
            landing_page = realClickUrl;
        }
        String strMacroProcess = baseAdUnitL.getMacroCommon().macroProcess(landing_page);
        if (baseAdUnitL.getsubInteractionType() != 1) {
            this.o = realClickUrl;
            o.a(realClickUrl, l());
            return;
        }
        JsonRequest jsonRequest = new JsonRequest(strMacroProcess, new AnonymousClass2(), 1);
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        if (sigRequestQueue == null) {
            ac.a("download_start", "0", l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    this.f$0.b(obj);
                }
            });
            ac.a("download_start", 0, "request queue is null", l(), new ac.a() { // from class: com.sigmob.sdk.base.common.h$$ExternalSyntheticLambda1
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    this.f$0.a(obj);
                }
            });
        } else {
            jsonRequest.setTag("GDTRequestConvert");
            sigRequestQueue.add(jsonRequest);
        }
    }

    public Map<String, String> g() {
        return this.b;
    }

    public boolean h() {
        return this.n;
    }

    public boolean i() {
        final BaseAdUnit baseAdUnitL = l();
        if (baseAdUnitL == null) {
            return false;
        }
        WeakReference<Activity> weakReference = this.s;
        Activity activity = weakReference == null ? null : weakReference.get();
        if (activity != null && baseAdUnitL.getadPrivacy() != null && this.r == null) {
            com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(activity, baseAdUnitL);
            this.r = qVar;
            qVar.a(new q.b() { // from class: com.sigmob.sdk.base.common.h.1
                @Override // com.sigmob.sdk.base.views.q.b
                public void a() {
                    h.this.m();
                    af sessionManager = baseAdUnitL.getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a(a.g, 0);
                    }
                    if (h.this.t != null) {
                        h.this.t.a();
                    }
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(Error error) {
                    Log.d("", "BaseAdConfig#showDownloadDialog: onShowFail");
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void a(String url, String clickCoordinate) throws UnsupportedEncodingException {
                    if (h.this.t != null) {
                        h.this.t.a(url, clickCoordinate);
                    }
                    h.this.a(baseAdUnitL.getClickCommon().clickUIType, url, clickCoordinate, true);
                }

                @Override // com.sigmob.sdk.base.views.q.b
                public void b() {
                    af sessionManager = baseAdUnitL.getSessionManager();
                    if (sessionManager != null) {
                        sessionManager.a(a.f, 0);
                    }
                    if (h.this.t == null || !h.this.m) {
                        return;
                    }
                    h.this.t.b();
                }
            });
        }
        SigmobLog.d("BaseAdConfig#showDownloadDialog: downloadDialog = " + this.r);
        com.sigmob.sdk.base.views.q qVar2 = this.r;
        if (qVar2 == null || !qVar2.a()) {
            return false;
        }
        if (activity != null && !this.m) {
            boolean zIsFinishing = activity.isFinishing();
            boolean zIsDestroyed = activity.isDestroyed();
            if (!zIsFinishing && !zIsDestroyed) {
                this.r.show();
                this.m = true;
                return true;
            }
            this.m = false;
            this.r.dismiss();
            this.r.c();
            this.r = null;
        }
        return true;
    }

    public boolean j() {
        BaseAdUnit baseAdUnitL = l();
        if (baseAdUnitL == null || !baseAdUnitL.isDownloadDialog()) {
            return false;
        }
        return i();
    }

    public void k() {
        this.t = null;
        this.q = null;
        m();
    }
}
