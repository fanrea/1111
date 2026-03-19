package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.mobads.container.rewardvideo.NativeRewardActivity;
import com.baidu.mobads.container.util.cm;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.luck.picture.lib.config.CustomIntentKey;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.ap;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AdSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.mraid.i;
import com.sigmob.sdk.mraid.p;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import io.netty.util.internal.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    public static final String a = "MraidBridge";
    static final String b = "mraid://open?url=";
    private final BaseAdUnit c;
    private final PlacementType d;
    private final i e;
    private String f;
    private InterfaceC0739b g;
    private p h;
    private ap i;
    private boolean j;
    private final q k;
    private c l;

    /* renamed from: com.sigmob.sdk.mraid.b$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.UNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.OPENFOURELEMENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g.RESIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[g.EXPAND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[g.USE_CUSTOM_CLOSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[g.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[g.feedBack.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SET_ORIENTATION_PROPERTIES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.PLAY_VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[g.STORE_PICTURE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[g.CREATE_CALENDAR_EVENT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[g.VPAID.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[g.EXTENSION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[g.UNSPECIFIED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    static class a {
        private final WeakReference<b> a;

        public a(b mraidBridge) {
            this.a = new WeakReference<>(mraidBridge);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, b bVar) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bVar.a(jSONObject.optString(NotificationCompat.CATEGORY_EVENT), jSONObject.optString("subEvent"), jSONObject.optJSONObject("args"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bVar.e(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(JSONObject jSONObject, BaseAdUnit baseAdUnit, Object obj) {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next.equalsIgnoreCase("ext")) {
                    try {
                        try {
                            JSONObject jSONObject2 = new JSONObject(jSONObject.optString(next));
                            Iterator<String> itKeys2 = jSONObject2.keys();
                            while (itKeys2.hasNext()) {
                                String next2 = itKeys2.next();
                                map.put(next2, jSONObject2.optString(next2));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception unused) {
                        map.put("ext", Base64.encodeToString(jSONObject.getString("ext").getBytes(), 2));
                    }
                } else if (!next.equalsIgnoreCase(PointParamKey._AC_TYPE)) {
                    try {
                        map.put(next, jSONObject.getString(next));
                    } catch (Throwable unused2) {
                    }
                }
            }
            map.put(com.sigmob.sdk.base.n.l, "js");
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                String str = (String) map.get("sub_category");
                if (com.sigmob.sdk.base.utils.n.b(baseAdUnit) && com.sigmob.sdk.base.utils.m.a(str, "click")) {
                    ClickCommon clickCommon = baseAdUnit.getClickCommon();
                    if (com.sigmob.sdk.base.utils.n.b(clickCommon)) {
                        map.put(ClickCommon.CLICK_LOSE_RATE, String.valueOf(clickCommon.click_lose_rate));
                        map.put(ClickCommon.CLICK_CB_STATE, String.valueOf(clickCommon.click_cb_state));
                    }
                }
                pointEntitySigmob.setOptions(map);
            }
        }

        public b a() {
            return this.a.get();
        }

        @JavascriptInterface
        public String addMacro(JSONObject jsonData) {
            try {
                BaseAdUnit baseAdUnitB = b();
                String string = jsonData.has("key") ? jsonData.getString("key") : null;
                String string2 = jsonData.has(com.alipay.sdk.m.p0.b.d) ? jsonData.getString(com.alipay.sdk.m.p0.b.d) : null;
                if (!com.sigmob.sdk.base.utils.m.a((CharSequence) string) && !com.sigmob.sdk.base.utils.m.a((CharSequence) string2)) {
                    baseAdUnitB.getMacroCommon().addMarcoKey(string, string2);
                    return b.a(200, "addMacro success", (Object) null);
                }
                return b.a(300, "key or value is empty", (Object) null);
            } catch (Throwable th) {
                return b.a(500, "addMacro add fail " + th.getMessage(), (Object) null);
            }
        }

        public BaseAdUnit b() {
            b bVarA = a();
            if (bVarA == null) {
                return null;
            }
            return bVarA.c;
        }

        @JavascriptInterface
        public String excuteRewardAdTrack(JSONObject jsonData) {
            try {
                BaseAdUnit baseAdUnitB = b();
                String string = jsonData.getString(NotificationCompat.CATEGORY_EVENT);
                if (!com.sigmob.sdk.base.utils.m.a((CharSequence) string) && string.equals("click")) {
                    com.sigmob.sdk.base.utils.c.a(b.a, baseAdUnitB);
                }
                int iB = com.sigmob.sdk.base.network.g.b(baseAdUnitB, string, true);
                return iB == 0 ? b.a(200, "excuteRewardAdTrack success", (Object) null) : iB == -1 ? b.a(300, "event is empty", (Object) null) : iB == -2 ? b.a(300, string + " can't find in trackers", (Object) null) : b.a(400, "unknown error: " + iB, (Object) null);
            } catch (Throwable th) {
                return b.a(500, "unknown error: " + th.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String func(String jsonData) {
            try {
                JSONObject jSONObject = new JSONObject(jsonData);
                String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
                if (com.sigmob.sdk.base.utils.m.a((CharSequence) string)) {
                    return b.a(400, "func is empty", (Object) null);
                }
                ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
                methodBuilder.addParam(JSONObject.class, jSONObject);
                return (String) methodBuilder.execute();
            } catch (Throwable th) {
                return b.a(500, th.getMessage(), (Object) null);
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JavascriptInterface
        public String getAppInfo(JSONObject jsonData) {
            Object androidId;
            int densityDpi;
            try {
                JSONObject jSONObject = new JSONObject();
                BaseAdUnit baseAdUnitB = b();
                if (jsonData != null && baseAdUnitB != null && jsonData.has("arguments")) {
                    JSONArray jSONArray = jsonData.getJSONArray("arguments");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        char c = 65535;
                        try {
                            switch (string.hashCode()) {
                                case -1776992973:
                                    if (string.equals("ad_source_logo")) {
                                        c = 20;
                                        break;
                                    }
                                    break;
                                case -1590994477:
                                    if (string.equals("display_orientation")) {
                                        c = ' ';
                                        break;
                                    }
                                    break;
                                case -1581153970:
                                    if (string.equals("settlement_price_enc")) {
                                        c = 29;
                                        break;
                                    }
                                    break;
                                case -1534836170:
                                    if (string.equals("google_aid")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case -1342627961:
                                    if (string.equals("bid_price")) {
                                        c = 27;
                                        break;
                                    }
                                    break;
                                case -1295727824:
                                    if (string.equals("device_height")) {
                                        c = '\n';
                                        break;
                                    }
                                    break;
                                case -1152230954:
                                    if (string.equals("ad_type")) {
                                        c = 16;
                                        break;
                                    }
                                    break;
                                case -1093016302:
                                    if (string.equals("client_pixel")) {
                                        c = '\b';
                                        break;
                                    }
                                    break;
                                case -918718184:
                                    if (string.equals("forbiden_parse_landingpage")) {
                                        c = 31;
                                        break;
                                    }
                                    break;
                                case -901870406:
                                    if (string.equals("app_version")) {
                                        c = 5;
                                        break;
                                    }
                                    break;
                                case -702722614:
                                    if (string.equals("creative_type")) {
                                        c = 15;
                                        break;
                                    }
                                    break;
                                case -582019427:
                                    if (string.equals("device_width")) {
                                        c = '\t';
                                        break;
                                    }
                                    break;
                                case -568274923:
                                    if (string.equals("screen_density")) {
                                        c = 11;
                                        break;
                                    }
                                    break;
                                case -516987305:
                                    if (string.equals("pkgname")) {
                                        c = StringUtil.CARRIAGE_RETURN;
                                        break;
                                    }
                                    break;
                                case -376724013:
                                    if (string.equals("sdk_version")) {
                                        c = 6;
                                        break;
                                    }
                                    break;
                                case -205033663:
                                    if (string.equals("is_override")) {
                                        c = 30;
                                        break;
                                    }
                                    break;
                                case -41411609:
                                    if (string.equals("screenangle")) {
                                        c = 14;
                                        break;
                                    }
                                    break;
                                case -19457365:
                                    if (string.equals("network_type")) {
                                        c = '\f';
                                        break;
                                    }
                                    break;
                                case 3556:
                                    if (string.equals("os")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 116753:
                                    if (string.equals(PointParamKey.VID)) {
                                        c = 23;
                                        break;
                                    }
                                    break;
                                case 3062218:
                                    if (string.equals(com.baidu.mobads.container.f.a.a)) {
                                        c = 24;
                                        break;
                                    }
                                    break;
                                case 3236040:
                                    if (string.equals(com.baidu.mobads.container.adrequest.g.z)) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 37109963:
                                    if (string.equals("request_id")) {
                                        c = 17;
                                        break;
                                    }
                                    break;
                                case 93029116:
                                    if (string.equals("appid")) {
                                        c = 19;
                                        break;
                                    }
                                    break;
                                case 549673881:
                                    if (string.equals("camp_id")) {
                                        c = 25;
                                        break;
                                    }
                                    break;
                                case 672836989:
                                    if (string.equals("os_version")) {
                                        c = 7;
                                        break;
                                    }
                                    break;
                                case 722989291:
                                    if (string.equals("android_id")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 1103406469:
                                    if (string.equals("clienttype")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case 1127917191:
                                    if (string.equals("cust_id")) {
                                        c = JSONLexer.EOI;
                                        break;
                                    }
                                    break;
                                case 1139668345:
                                    if (string.equals("adslot_id")) {
                                        c = 22;
                                        break;
                                    }
                                    break;
                                case 1224358069:
                                    if (string.equals(PointParamKey.PLACEMENT_ID)) {
                                        c = 18;
                                        break;
                                    }
                                    break;
                                case 1437471655:
                                    if (string.equals("expired_time")) {
                                        c = '!';
                                        break;
                                    }
                                    break;
                                case 1753008747:
                                    if (string.equals("product_id")) {
                                        c = 28;
                                        break;
                                    }
                                    break;
                                case 1765767291:
                                    if (string.equals("ad_source_channel")) {
                                        c = 21;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    jSONObject.put(string, 2);
                                    break;
                                case 1:
                                    androidId = "";
                                    jSONObject.put(string, androidId);
                                    break;
                                case 2:
                                    androidId = ClientMetadata.getInstance().getAndroidId();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 3:
                                    androidId = ClientMetadata.getInstance().getAdvertisingId();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 4:
                                    androidId = ClientMetadata.getDeviceModel();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 5:
                                    androidId = ClientMetadata.getInstance().getAppVersion();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 6:
                                    androidId = com.sigmob.sdk.base.n.k;
                                    jSONObject.put(string, androidId);
                                    break;
                                case 7:
                                    androidId = ClientMetadata.getDeviceOsVersion();
                                    jSONObject.put(string, androidId);
                                    break;
                                case '\b':
                                    androidId = String.format("%sx%s", Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().widthPixels), Integer.valueOf(ClientMetadata.getInstance().getDisplayMetrics().heightPixels));
                                    jSONObject.put(string, androidId);
                                    break;
                                case '\t':
                                    androidId = ClientMetadata.getInstance().getDeviceScreenWidthDip();
                                    jSONObject.put(string, androidId);
                                    break;
                                case '\n':
                                    androidId = ClientMetadata.getInstance().getDeviceScreenHeightDip();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 11:
                                    densityDpi = ClientMetadata.getInstance().getDensityDpi();
                                    jSONObject.put(string, densityDpi);
                                    break;
                                case '\f':
                                    densityDpi = ClientMetadata.getInstance().getActiveNetworkType();
                                    jSONObject.put(string, densityDpi);
                                    break;
                                case '\r':
                                    androidId = ClientMetadata.getInstance().getAppPackageName();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 14:
                                    densityDpi = Math.abs(ClientMetadata.getInstance().getOrientationInt().intValue() - 1) * 90;
                                    jSONObject.put(string, densityDpi);
                                    break;
                                case 15:
                                    densityDpi = baseAdUnitB.getCreativeType();
                                    jSONObject.put(string, densityDpi);
                                    break;
                                case 16:
                                    densityDpi = baseAdUnitB.getAd_type();
                                    jSONObject.put(string, densityDpi);
                                    break;
                                case 17:
                                    androidId = baseAdUnitB.getRequestId();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 18:
                                case 22:
                                    androidId = baseAdUnitB.getAdslot_id();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 19:
                                    androidId = WindAds.sharedAds().getAppId();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 20:
                                    androidId = baseAdUnitB.getAd_source_logo();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 21:
                                    androidId = baseAdUnitB.getAd_source_channel();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 23:
                                    androidId = baseAdUnitB.getAd().vid;
                                    jSONObject.put(string, androidId);
                                    break;
                                case 24:
                                    androidId = baseAdUnitB.getCrid();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 25:
                                    androidId = baseAdUnitB.getCamp_id();
                                    jSONObject.put(string, androidId);
                                    break;
                                case 26:
                                    androidId = baseAdUnitB.getAd().cust_id;
                                    jSONObject.put(string, androidId);
                                    break;
                                case 27:
                                    androidId = baseAdUnitB.getAd().bid_price;
                                    jSONObject.put(string, androidId);
                                    break;
                                case 28:
                                    androidId = baseAdUnitB.getAd().product_id;
                                    jSONObject.put(string, androidId);
                                    break;
                                case 29:
                                    androidId = baseAdUnitB.getAd().settlement_price_enc;
                                    jSONObject.put(string, androidId);
                                    break;
                                case 30:
                                    androidId = baseAdUnitB.getAd().is_override;
                                    jSONObject.put(string, androidId);
                                    break;
                                case 31:
                                    androidId = baseAdUnitB.getAd().forbiden_parse_landingpage;
                                    jSONObject.put(string, androidId);
                                    break;
                                case ' ':
                                    densityDpi = baseAdUnitB.getDisplay_orientation();
                                    jSONObject.put(string, densityDpi);
                                    break;
                                case '!':
                                    androidId = baseAdUnitB.getAd().expired_time;
                                    jSONObject.put(string, androidId);
                                    break;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                return b.a(200, "getAppInfo success ", jSONObject);
            } catch (Throwable th) {
                return b.a(500, "getAppInfo error: " + th.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String hello(JSONObject jsonData) {
            try {
                return jsonData.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        @JavascriptInterface
        public String javascriptAddDcLog(final JSONObject jsonData) {
            try {
                if (jsonData == null) {
                    return b.a(400, "not params", (Object) null);
                }
                if (!jsonData.has(PointParamKey._AC_TYPE)) {
                    return b.a(300, "_ac_type is empty", (Object) null);
                }
                String string = jsonData.getString(PointParamKey._AC_TYPE);
                final BaseAdUnit baseAdUnitB = b();
                ac.a(string, baseAdUnitB, (LoadAdRequest) null, new ac.a() { // from class: com.sigmob.sdk.mraid.b$a$$ExternalSyntheticLambda0
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        b.a.a(jsonData, baseAdUnitB, obj);
                    }
                });
                return b.a(200, "add dc log success", (Object) null);
            } catch (Throwable th) {
                return b.a(500, th.toString(), (Object) null);
            }
        }

        @JavascriptInterface
        public String mraidJsLoaded() {
            b bVarA = a();
            if (bVarA != null && bVarA.g != null) {
                bVarA.g.b();
            }
            return null;
        }

        @JavascriptInterface
        public void postMessage(final String data) {
            SigmobLog.d("postMessage: raw " + data);
            final b bVarA = a();
            if (bVarA == null) {
                return;
            }
            bVarA.h.post(new Runnable() { // from class: com.sigmob.sdk.mraid.b$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.a(data, bVarA);
                }
            });
        }

        @JavascriptInterface
        public String tracking(JSONObject jsonData) {
            try {
                BaseAdUnit baseAdUnitB = b();
                String strOptString = jsonData.optString(NotificationCompat.CATEGORY_EVENT);
                JSONArray jSONArrayOptJSONArray = jsonData.optJSONArray("urls");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        ag agVar = new ag(jSONArrayOptJSONArray.optString(i), strOptString, baseAdUnitB.getRequestId());
                        agVar.setRetryNum(Integer.valueOf(baseAdUnitB.getTrackingRetryNum()));
                        agVar.setSource("js");
                        com.sigmob.sdk.base.network.g.a((AdTracker) agVar, baseAdUnitB, false);
                    }
                    return b.a(200, "tracking success.", (Object) null);
                }
                return b.a(300, "urls is empty.", (Object) null);
            } catch (Throwable th) {
                return b.a(500, "unknown error: " + th.getMessage(), (Object) null);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.b$b, reason: collision with other inner class name */
    public interface InterfaceC0739b {
        void a();

        void a(int width, int height, int offsetX, int offsetY, a.EnumC0738a closePosition, boolean allowOffscreen);

        void a(final WindAdError error);

        void a(String event, Map<String, String> params);

        void a(URI uri);

        void a(URI uri, int interActionType, String ext);

        void a(URI uri, boolean shouldUseCustomClose) throws com.sigmob.sdk.mraid.c;

        void a(boolean isVisible);

        void a(boolean allowOrientationChange, k forceOrientation) throws com.sigmob.sdk.mraid.c;

        boolean a(ConsoleMessage consoleMessage);

        boolean a(String message, JsResult result);

        void b();

        void b(String event, Map<String, String> params);

        void b(boolean shouldUseCustomClose);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    public interface c {
        void a(String subEvent, JSONObject args);

        void b(String subEvent, JSONObject args);

        void c(String subEvent, JSONObject args);

        void d(String subEvent, JSONObject args);

        void e(String subEvent, JSONObject args);
    }

    private interface d {
        void a(String event, Map<String, String> params);
    }

    b(BaseAdUnit adUnit, PlacementType placementType) {
        this(adUnit, placementType, new i());
    }

    b(BaseAdUnit adUnit, PlacementType placementType, i mraidNativeCommandHandler) {
        this.k = new q() { // from class: com.sigmob.sdk.mraid.b.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                b.this.o();
            }

            @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                ac.a("h5_error", "mraid1", errorCode, failingUrl + " error:" + description, (WindAdRequest) null, (LoadAdRequest) null, b.this.c, (ac.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                SigmobLog.i("onReceivedError:" + error.toString());
                if (Build.VERSION.SDK_INT >= 23) {
                    ac.a("h5_error", "mraid1", 0, request.getUrl() + " error:" + ((Object) error.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, b.this.c, (ac.a) null);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ac.a("h5_error", "mraid1", errorResponse.getStatusCode(), request.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, b.this.c, (ac.a) null);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(final WebView view, final RenderProcessGoneDetail detail) {
                b.this.a(detail);
                return true;
            }

            @Override // com.sigmob.sdk.mraid.q, com.sigmob.sdk.base.l, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if (!com.sigmob.sdk.base.utils.m.a((CharSequence) b.this.c.getVideoPath()) && url.endsWith(b.this.c.getVideoPath()) && b.this.c.isVideoExist()) {
                    try {
                        return new WebResourceResponse("video/mp4", "UTF-8", new FileInputStream(b.this.c.getVideoPath()));
                    } catch (FileNotFoundException e) {
                        SigmobLog.e(e.getMessage());
                    }
                }
                return super.shouldInterceptRequest(view, url);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return b.this.a(view, url);
            }
        };
        this.c = adUnit;
        this.d = placementType;
        this.e = mraidNativeCommandHandler;
    }

    private int a(int value, int min, int max) throws com.sigmob.sdk.mraid.c {
        if (value < min || value > max) {
            throw new com.sigmob.sdk.mraid.c("Integer parameter out of range: " + value);
        }
        return value;
    }

    private a.EnumC0738a a(String text, a.EnumC0738a defaultValue) throws com.sigmob.sdk.mraid.c {
        if (com.sigmob.sdk.base.utils.m.a((CharSequence) text)) {
            return defaultValue;
        }
        text.hashCode();
        switch (text) {
            case "center":
                return a.EnumC0738a.CENTER;
            case "top-right":
                return a.EnumC0738a.TOP_RIGHT;
            case "top-left":
                return a.EnumC0738a.TOP_LEFT;
            case "bottom-left":
                return a.EnumC0738a.BOTTOM_LEFT;
            case "bottom-right":
                return a.EnumC0738a.BOTTOM_RIGHT;
            case "bottom-center":
                return a.EnumC0738a.BOTTOM_CENTER;
            case "top-center":
                return a.EnumC0738a.TOP_CENTER;
            default:
                throw new com.sigmob.sdk.mraid.c("Invalid close position: " + text);
        }
    }

    public static String a(int code, String message, Object data) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", code);
            if (!com.sigmob.sdk.base.utils.m.a((CharSequence) message)) {
                jSONObject.put(cm.V, message);
            }
            if (data != null) {
                jSONObject.put("data", data);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    private String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    public static String a(String value) {
        if (value == null || value.equalsIgnoreCase(ILogConst.CACHE_PLAY_REASON_NULL) || value.equalsIgnoreCase("undefined")) {
            return null;
        }
        return value;
    }

    private URI a(String encodedText, URI defaultValue) throws com.sigmob.sdk.mraid.c {
        return encodedText == null ? defaultValue : i(encodedText);
    }

    private void a(g command) {
        c("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(command.a()) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar, com.sigmob.sdk.mraid.c cVar) {
        a(gVar, cVar.getMessage());
    }

    private void a(g command, String message) {
        c("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(command.a()) + ", " + JSONObject.quote(message) + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String event, String subEvent, JSONObject args) {
        if (this.l == null) {
        }
        event.hashCode();
        switch (event) {
            case "motion":
                this.l.d(subEvent, args);
                break;
            case "motionView":
                this.l.e(subEvent, args);
                break;
            case "addSubview":
                this.l.c(subEvent, args);
                break;
            case "vpaid":
                this.l.a(subEvent, args);
                break;
            case "belowSubview":
                this.l.b(subEvent, args);
                break;
        }
    }

    private boolean a(String text, boolean defaultValue) throws com.sigmob.sdk.mraid.c {
        return text == null ? defaultValue : h(text);
    }

    private String b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        InterfaceC0739b interfaceC0739b = this.g;
        if (interfaceC0739b == null) {
            return;
        }
        interfaceC0739b.a(z);
    }

    private URI c(String encodedText, String defaultValue) throws com.sigmob.sdk.mraid.c {
        try {
            try {
                return encodedText == null ? new URI(defaultValue) : new URI(encodedText);
            } catch (URISyntaxException unused) {
                throw new com.sigmob.sdk.mraid.c("Invalid URL parameter: " + encodedText);
            }
        } catch (URISyntaxException unused2) {
            return new URI(defaultValue);
        }
    }

    private int f(String text) throws com.sigmob.sdk.mraid.c {
        try {
            return Integer.parseInt(text, 10);
        } catch (NumberFormatException unused) {
            throw new com.sigmob.sdk.mraid.c("Invalid numeric parameter: " + text);
        }
    }

    private k g(String text) throws com.sigmob.sdk.mraid.c {
        if (NativeRewardActivity.SCREEN_PORTRAIT.equals(text)) {
            return k.PORTRAIT;
        }
        if (NativeRewardActivity.SCREEN_LANDSCAPE.equals(text)) {
            return k.LANDSCAPE;
        }
        if ("none".equals(text)) {
            return k.NONE;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid orientation: " + text);
    }

    private boolean h(String text) throws com.sigmob.sdk.mraid.c {
        if ("true".equals(text)) {
            return true;
        }
        if ("false".equals(text)) {
            return false;
        }
        throw new com.sigmob.sdk.mraid.c("Invalid boolean parameter: " + text);
    }

    private URI i(String encodedText) throws com.sigmob.sdk.mraid.c {
        if (encodedText == null) {
            throw new com.sigmob.sdk.mraid.c("Parameter cannot be null");
        }
        try {
            return new URI(encodedText);
        } catch (URISyntaxException unused) {
            throw new com.sigmob.sdk.mraid.c("Invalid URL parameter: " + encodedText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.j) {
            return;
        }
        this.j = true;
        InterfaceC0739b interfaceC0739b = this.g;
        if (interfaceC0739b != null) {
            interfaceC0739b.a();
        }
    }

    public String a() {
        return this.f;
    }

    void a(int process) {
        c("bridge.notifyApkDownloadProcessEvent(" + process + ");");
    }

    void a(int top, int left, int bottom, int right) {
        c("mraidbridge.setSafeAreaInsets(" + (top + "," + left + "," + bottom + "," + right) + ")");
    }

    public void a(Context context, String htmlData) {
        p pVar = this.h;
        if (pVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        pVar.addJavascriptInterface(new a(this), "sigandroid");
        this.j = false;
        File fileB = com.sigmob.sdk.base.utils.i.b(htmlData, Md5Util.md5(htmlData) + ".html");
        if (fileB == null || com.sigmob.sdk.base.utils.m.a((CharSequence) fileB.getAbsolutePath())) {
            this.h.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", htmlData, "text/html", "UTF-8", null);
        } else {
            this.h.loadUrl(UriUtils.FILE_PREFIX + fileB.getAbsolutePath());
        }
    }

    public void a(Location location) {
        c("mraidbridge.setLocation(" + location.getLatitude() + "," + location.getLongitude() + ",\"" + location.getProvider() + "\");");
    }

    void a(RenderProcessGoneDetail detail) {
        WindAdError windAdError = (detail == null || !detail.didCrash()) ? WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED : WindAdError.RENDER_PROCESS_GONE_WITH_CRASH;
        SigmobLog.e("handleRenderProcessGone " + windAdError);
        b();
        InterfaceC0739b interfaceC0739b = this.g;
        if (interfaceC0739b != null) {
            interfaceC0739b.a(windAdError);
        }
    }

    void a(ValueCallback callback) {
        a("mraidbridge.getPlayProgress();", callback);
    }

    void a(AppInfo appInfo) {
        c("bridge.fireChangeEvent({" + appInfo.toString().replace("=", ":") + "});");
    }

    void a(CurrentAppOrientation appOrientation) {
        c("mraidbridge.fireChangeEvent({" + appOrientation.toString().replace("=", ":") + "});");
    }

    void a(ExposureChange exposedProperty) {
        c("mraidbridge.fireChangeEvent({" + exposedProperty.toString().replace("=", ":") + "});");
    }

    void a(MraidEnv env) {
        c("mraidbridge.fireChangeEvent(" + JSONSerializer.Serialize(env, "env", true) + ");");
    }

    void a(PlacementType placementType) {
        c("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.toJavascriptString()) + ")");
    }

    void a(VideoItem videoItem) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(videoItem, "video", false) + ");");
    }

    void a(ViewState state) {
        c("mraidbridge.setState(" + JSONObject.quote(state.toJavascriptString()) + ")");
    }

    void a(Ad ad, SlotAdSetting adSetting) throws JSONException {
        String strSerialize = JSONSerializer.Serialize(ad, "ad", true);
        try {
            String strSerialize2 = JSONSerializer.Serialize(adSetting, (String) null, true);
            JSONObject jSONObject = new JSONObject(strSerialize);
            jSONObject.getJSONObject("ad").put("slotAdSetting", new JSONObject(strSerialize2));
            c("bridge.fireChangeEvent(" + jSONObject.toString() + ");");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    void a(MaterialMeta materialMeta) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(materialMeta, ClickCommon.CLICK_AREA_MATERIAL, true) + ");");
    }

    void a(RvAdSetting rvAdSetting) {
        c("bridge.fireChangeEvent(" + JSONSerializer.Serialize(rvAdSetting, "rvSetting", false) + ");");
    }

    void a(InterfaceC0739b listener) {
        this.g = listener;
    }

    void a(c listener) {
        this.l = listener;
    }

    void a(final g command, Map<String, String> params) throws com.sigmob.sdk.mraid.c {
        if (this.g == null) {
            throw new com.sigmob.sdk.mraid.c("Invalid state to execute this command.");
        }
        if (this.h == null) {
            throw new com.sigmob.sdk.mraid.c("The current WebView is being destroyed.");
        }
        switch (AnonymousClass3.a[command.ordinal()]) {
            case 1:
                this.g.d();
                return;
            case 2:
                this.g.e();
                return;
            case 3:
                this.g.f();
                return;
            case 4:
                this.g.a(a(f(params.get("width")), 0, KSTubeParamInner.FREE_ALL), a(f(params.get("height")), 0, KSTubeParamInner.FREE_ALL), a(f(params.get(CustomIntentKey.EXTRA_OFFSET_X)), LiveError.PARSE_JSON, KSTubeParamInner.FREE_ALL), a(f(params.get(CustomIntentKey.EXTRA_OFFSET_Y)), LiveError.PARSE_JSON, KSTubeParamInner.FREE_ALL), a(params.get("customClosePosition"), a.EnumC0738a.TOP_RIGHT), a(params.get("allowOffscreen"), true));
                return;
            case 5:
                this.g.a(a(params.get("url"), (URI) null), a(params.get("shouldUseCustomClose"), false));
                return;
            case 6:
                this.g.b(a(params.get("shouldUseCustomClose"), false));
                return;
            case 7:
                this.g.a(c(params.get("url"), ""), 1, a(params.get("ext")));
                return;
            case 8:
                this.g.g();
                return;
            case 9:
                this.g.a(h(params.get("allowOrientationChange")), g(params.get("forceOrientation")));
                return;
            case 10:
                this.g.a(i(params.get(ContentProviderManager.PROVIDER_URI)));
                return;
            case 11:
                this.e.a(this.h.getContext(), i(params.get(ContentProviderManager.PROVIDER_URI)).toString(), new i.a() { // from class: com.sigmob.sdk.mraid.b$$ExternalSyntheticLambda0
                    @Override // com.sigmob.sdk.mraid.i.a
                    public final void onFailure(c cVar) {
                        this.f$0.a(command, cVar);
                    }
                });
                return;
            case 12:
                this.e.a(this.h.getContext(), params);
                return;
            case 13:
                this.g.a(params.get(NotificationCompat.CATEGORY_EVENT), params);
                return;
            case 14:
                this.g.b(params.get(NotificationCompat.CATEGORY_EVENT), params);
                return;
            case 15:
                throw new com.sigmob.sdk.mraid.c("Unspecified MRAID Javascript command");
            default:
                return;
        }
    }

    public void a(final l screenMetrics) {
        c("mraidbridge.setScreenSize(" + b(screenMetrics.c()) + ");mraidbridge.setMaxSize(" + b(screenMetrics.e()) + ");mraidbridge.setCurrentPosition(" + a(screenMetrics.g()) + ");mraidbridge.setDefaultPosition(" + a(screenMetrics.i()) + ")");
        c("mraidbridge.notifySizeChangeEvent(" + b(screenMetrics.g()) + ")");
    }

    public void a(p mraidWebView) {
        this.h = mraidWebView;
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(mraidWebView.getSettings(), new String(Base64.decode(com.sigmob.sdk.base.n.D, 2)));
            methodBuilder.addParam(Boolean.TYPE, true);
            methodBuilder.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(mraidWebView.getSettings(), new String(Base64.decode(com.sigmob.sdk.base.n.F, 2)));
            methodBuilder2.addParam(Boolean.TYPE, true);
            methodBuilder2.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 17 && this.d == PlacementType.INTERSTITIAL) {
            mraidWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.k.b(this.c.isDisablexRequestWith());
        this.k.a(com.sigmob.sdk.base.o.a().ag());
        this.h.setScrollContainer(false);
        this.h.setVerticalScrollBarEnabled(false);
        this.h.setHorizontalScrollBarEnabled(false);
        this.h.setBackgroundColor(0);
        this.h.setAdUnit(this.c);
        this.h.a((n.a) null);
        this.h.setWebViewClient(this.k);
        this.h.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.mraid.b.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return b.this.g == null ? super.onConsoleMessage(consoleMessage) : b.this.g.a(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return b.this.g == null ? super.onJsAlert(view, url, message, result) : b.this.g.a(message, result);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
            }
        });
        this.i = new ap(this.h.getContext(), this.h, this.c);
        this.h.setVisibilityChangedListener(new p.a() { // from class: com.sigmob.sdk.mraid.b$$ExternalSyntheticLambda1
            @Override // com.sigmob.sdk.mraid.p.a
            public final void onVisibilityChanged(boolean z) {
                this.f$0.b(z);
            }
        });
    }

    public void a(String uniqueId, int position) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", uniqueId);
            jSONObject.put("currentTime", position / 1000.0f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayToEnd(" + jSONObject + ")");
    }

    public void a(String uniqueId, int position, int duration) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", uniqueId);
            jSONObject.put("currentTime", position / 1000.0f);
            jSONObject.put("duration", duration / 1000.0f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayCurrentTime(" + jSONObject + ")");
    }

    void a(String uniqueId, int duration, int width, int height) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", uniqueId);
            jSONObject.put("duration", duration / 1000.0f);
            jSONObject.put("width", width);
            jSONObject.put("height", height);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdReadyToPlay(" + jSONObject + ")");
    }

    void a(String javascript, ValueCallback callback) {
        if (this.h == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + javascript);
            return;
        }
        if (javascript.startsWith("bridge")) {
            javascript = javascript.replaceFirst("bridge", com.czhj.volley.toolbox.StringUtil.decode(com.czhj.volley.toolbox.StringUtil.s));
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + javascript);
        if (Build.VERSION.SDK_INT >= 19) {
            this.h.evaluateJavascript(javascript, callback);
        } else {
            SigmobLog.e("Injecting Javascript into MRAID WebView:\n\t can't support less KITKAT" + javascript);
        }
    }

    void a(String x, String y) {
        this.f = String.format("%s,%s,%s,%s", x, y, x, y);
        this.c.getMacroCommon().updateClickMarco(x, y, x, y);
        this.c.getClickCommon().down = new TouchLocation(Integer.parseInt(x), Integer.parseInt(y));
        this.c.getClickCommon().up = new TouchLocation(Integer.parseInt(x), Integer.parseInt(y));
    }

    void a(String uniqueId, String type, String event, HashMap<String, Object> args) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, event);
            jSONObject2.put("uniqueId", uniqueId);
            if (args != null) {
                jSONObject2.put("args", new JSONObject(args));
            }
            jSONObject.put("onChangeFired", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(String event, HashMap<String, Object> args) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, event);
            if (args != null) {
                jSONObject2.put("args", new JSONObject(args));
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(boolean isViewable) {
        c("mraidbridge.setIsViewable(" + isViewable + ")");
    }

    void a(boolean sms, boolean telephone, boolean calendar, boolean storePicture, boolean inlineVideo, boolean vpaid, boolean location) {
        c("mraidbridge.setSupports(" + sms + "," + telephone + "," + calendar + "," + storePicture + "," + inlineVideo + "," + vpaid + "," + location + ")");
    }

    boolean a(WebView view, String url) throws IntentNotResolvableException {
        int i;
        InterfaceC0739b interfaceC0739b;
        SigmobLog.d("MraidBridge#handleShouldOverrideUrl: url = " + url);
        try {
            new URI(url);
            Uri uri = Uri.parse(url);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (com.czhj.volley.toolbox.StringUtil.decode(com.czhj.volley.toolbox.StringUtil.s).equals(scheme)) {
                if ("failLoad".equals(host) && this.d == PlacementType.INLINE && (interfaceC0739b = this.g) != null) {
                    interfaceC0739b.c();
                }
                return true;
            }
            if (BaseAdActivity.c.equals(scheme)) {
                g gVarA = g.a(host);
                try {
                    a(gVarA, ClientMetadata.getQueryParamMap(uri));
                } catch (Throwable th) {
                    a(gVarA, th.getMessage());
                }
                a(gVarA);
                return true;
            }
            if (com.sigmob.sdk.base.utils.m.b(url)) {
                if (url.startsWith(com.alipay.sdk.m.l.a.r)) {
                    view.loadUrl(url);
                } else {
                    try {
                        AdSetting adSetting = this.c.getAdSetting();
                        List<String> list = adSetting == null ? null : adSetting.scheme_white_list;
                        if (com.sigmob.sdk.base.utils.e.a(list)) {
                            return true;
                        }
                        while (i < list.size()) {
                            String str = list.get(i);
                            i = (url.startsWith(str) || str.equals("*")) ? 0 : i + 1;
                            com.sigmob.sdk.base.common.t.a(this.h.getContext(), Uri.parse(url));
                            return true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        } catch (URISyntaxException unused) {
            SigmobLog.e("Invalid MRAID URL: " + url);
            a(g.UNSPECIFIED, "Mraid command sent an invalid URL");
            return true;
        }
    }

    void b() {
        this.g = null;
        this.l = null;
        p pVar = this.h;
        if (pVar != null) {
            pVar.destroy();
            this.h = null;
        }
    }

    void b(ValueCallback callback) {
        a("mraidbridge.getAdDuration();", callback);
    }

    public void b(String url) {
        p pVar = this.h;
        if (pVar == null) {
            SigmobLog.e("MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        pVar.addJavascriptInterface(new a(this), "sigandroid");
        this.j = false;
        this.h.loadUrl(url);
    }

    public void b(String uniqueId, int state) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", uniqueId);
            jSONObject.put("state", state);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdLoadStateChanged(" + jSONObject + ")");
    }

    public void b(String uniqueId, String error) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", uniqueId);
            jSONObject.put("error", error);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayError(" + jSONObject + ")");
    }

    void c() {
        c("bridge.fireChangeEvent({\"osType\":2});");
    }

    void c(String javascript) {
        if (this.h == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + javascript);
            return;
        }
        if (javascript.startsWith("bridge")) {
            javascript = javascript.replaceFirst("bridge", com.czhj.volley.toolbox.StringUtil.decode(com.czhj.volley.toolbox.StringUtil.s));
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + javascript);
        if (Build.VERSION.SDK_INT >= 19) {
            this.h.evaluateJavascript(javascript, null);
        } else {
            this.h.loadUrl("javascript:" + javascript);
        }
    }

    public void c(String uniqueId, int state) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uniqueId", uniqueId);
            jSONObject.put("state", state);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c("mraidbridge.setvdPlayStateChanged(" + jSONObject + ")");
    }

    void d() {
        c("mraidbridge.fireChangeEvent({\"hostSDKVersion\":4.24.0});");
    }

    void d(String url) {
        c("mraidbridge.fireVideoSrc(\"" + url + "\")");
    }

    void e() {
        c("mraidbridge.notifyReadyEvent();");
    }

    void e(String cmd) {
        c("mraidbridge.nativeCallCompleteV2(" + JSONObject.quote(cmd) + ")");
    }

    void f() {
        c("bridge.notifyApkDownloadStartEvent();");
    }

    void g() {
        c("bridge.notifyApkDownloadFailEvent();");
    }

    void h() {
        c("bridge.notifyApkDownloadEndEvent();");
    }

    void i() {
        c("bridge.notifyApkDownloadInstalledEvent();");
    }

    void j() {
        c("mraidbridge.startAd();");
    }

    boolean k() {
        ap apVar = this.i;
        return apVar != null && apVar.c();
    }

    boolean l() {
        p pVar = this.h;
        return pVar != null && pVar.j();
    }

    boolean m() {
        return this.h != null;
    }

    boolean n() {
        return this.j;
    }
}
