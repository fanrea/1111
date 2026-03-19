package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.json.JSONSerializer;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.mraid2.c;
import com.sigmob.sdk.mraid2.d;
import com.sigmob.sdk.mraid2.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements i {
    private static final String a = "Mraid2Bridge";
    private static m e;
    private static final HashMap<String, List<String>> h = new HashMap<>();
    private final List<BaseAdUnit> b;
    private b c;
    private g d;
    private d.a f;
    private final List<BaseAdUnit> g;
    private volatile boolean i;
    private boolean j;
    private String k;

    /* renamed from: com.sigmob.sdk.mraid2.c$2, reason: invalid class name */
    class AnonymousClass2 implements e.a {
        final /* synthetic */ c a;
        final /* synthetic */ String b;

        AnonymousClass2(final c val$mraidBridge, final String val$ev) {
            this.a = val$mraidBridge;
            this.b = val$ev;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(List list, BaseAdUnit baseAdUnit, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                Map options = ((PointEntitySigmob) obj).getOptions();
                options.put(PointParamKey.AD_COUNT, String.valueOf(list.size()));
                options.put("request_id", baseAdUnit.getRequestId());
            }
        }

        @Override // com.sigmob.sdk.base.network.e.a
        public void a(int error, String message, String requestId, LoadAdRequest loadAdRequest) throws JSONException {
            Log.d(c.a, "onErrorResponse: error = " + error + ", message = " + message);
            this.a.a(this.b, (BidResponse) null, error, message);
            ac.a(PointCategory.RESPOND, "0", loadAdRequest);
        }

        @Override // com.sigmob.sdk.base.network.e.a
        public void a(final List<BaseAdUnit> adUnitList, LoadAdRequest loadAdRequest) throws JSONException {
            if (com.sigmob.sdk.base.utils.e.a(adUnitList)) {
                return;
            }
            Log.d(c.a, "onSuccess: size = " + adUnitList.size());
            c.this.g.addAll(adUnitList);
            this.a.a(this.b, c.this.a(adUnitList), 0, (String) null);
            final BaseAdUnit baseAdUnit = adUnitList.get(0);
            ac.a(PointCategory.RESPOND, "1", baseAdUnit, new ac.a() { // from class: com.sigmob.sdk.mraid2.c$2$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    c.AnonymousClass2.a(adUnitList, baseAdUnit, obj);
                }
            });
        }
    }

    static class a {
        private final WeakReference<c> a;

        public a(c mraidBridge) {
            this.a = new WeakReference<>(mraidBridge);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(final JSONObject jSONObject) {
            g gVarA;
            final c cVarA = a();
            if (cVarA == null || (gVarA = cVarA.a()) == null) {
                return;
            }
            gVarA.post(new Runnable() { // from class: com.sigmob.sdk.mraid2.c$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    cVarA.b(jSONObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(JSONObject jSONObject, Object obj) {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!next.equalsIgnoreCase(PointParamKey._AC_TYPE)) {
                    map.put(next, jSONObject.optString(next));
                }
            }
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                if (com.sigmob.sdk.base.utils.e.b(map)) {
                    pointEntitySigmob.getOptions().putAll(map);
                }
            }
        }

        public c a() {
            return this.a.get();
        }

        @JavascriptInterface
        public String addDclog(JSONObject jsonData) {
            Log.d(c.a, "addDclog: jsonData = " + jsonData);
            try {
                if (jsonData == null) {
                    return c.a(400, "not params", (Object) null);
                }
                c cVarA = a();
                final JSONObject jSONObjectOptJSONObject = jsonData.optJSONObject("data");
                if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has(PointParamKey._AC_TYPE)) {
                    return c.a(300, "_ac_type is empty", (Object) null);
                }
                String strOptString = jSONObjectOptJSONObject.optString(PointParamKey._AC_TYPE);
                String strOptString2 = jsonData.optString(PointParamKey.VID);
                if (jSONObjectOptJSONObject.optString("category").equals("start") && cVarA != null && cVarA.f != null) {
                    cVarA.f.d();
                }
                ac.a(strOptString, cVarA == null ? null : cVarA.b(strOptString2), cVarA == null ? null : cVarA.j(), new ac.a() { // from class: com.sigmob.sdk.mraid2.c$a$$ExternalSyntheticLambda1
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        c.a.a(jSONObjectOptJSONObject, obj);
                    }
                });
                return c.a(200, "add dc log success", (Object) null);
            } catch (Throwable th) {
                return c.a(500, th.toString(), (Object) null);
            }
        }

        @JavascriptInterface
        public String func(String jsonData) {
            try {
                JSONObject jSONObject = new JSONObject(jsonData);
                String string = jSONObject.has("func") ? jSONObject.getString("func") : null;
                if (TextUtils.isEmpty(string)) {
                    return c.a(400, "func is empty", (Object) null);
                }
                ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(this, string.replace(":", ""));
                methodBuilder.addParam(JSONObject.class, jSONObject);
                return (String) methodBuilder.execute();
            } catch (Throwable th) {
                return c.a(500, th.getMessage(), (Object) null);
            }
        }

        @JavascriptInterface
        public String getDeviceInfo() {
            try {
                Log.d(c.a, "getDeviceInfo");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clientType", ClientMetadata.getDeviceModel());
                jSONObject.put("osVersion", ClientMetadata.getDeviceOsVersion());
                jSONObject.put("appVersion", ClientMetadata.getInstance().getAppVersion());
                jSONObject.put("width", ClientMetadata.getInstance().getDisplayMetrics().widthPixels);
                jSONObject.put("height", ClientMetadata.getInstance().getDisplayMetrics().heightPixels);
                jSONObject.put("screenDensity", ClientMetadata.getInstance().getDensityDpi());
                jSONObject.put("networkType", ClientMetadata.getInstance().getActiveNetworkType());
                jSONObject.put("pkgName", ClientMetadata.getInstance().getAppPackageName());
                jSONObject.put("userAgent", Networking.getUserAgent());
                jSONObject.put(Config.CUSTOM_USER_ID, ClientMetadata.getUid());
                jSONObject.put("udid", ClientMetadata.getInstance().getUDID());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(com.baidu.mobads.container.adrequest.g.z, "");
                jSONObject2.put("androidId", ClientMetadata.getInstance().getAndroidId());
                jSONObject2.put("googleId", ClientMetadata.getInstance().getAdvertisingId());
                jSONObject2.put("oaid", ClientMetadata.getInstance().getOAID());
                jSONObject.put("android", jSONObject2);
                return jSONObject.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        @JavascriptInterface
        public String getUniqueId() {
            c cVarA = a();
            if (cVarA == null) {
                return null;
            }
            return cVarA.a().getUniqueId();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JavascriptInterface
        public String handleMacro(JSONObject jsonData) {
            String strOptString;
            JSONObject jSONObjectOptJSONObject;
            Log.d(c.a, "handleMacro: jsonData = " + jsonData);
            if (jsonData == null) {
                return null;
            }
            try {
                strOptString = jsonData.optString(NotificationCompat.CATEGORY_EVENT);
                jSONObjectOptJSONObject = jsonData.optJSONObject("args");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            String strOptString2 = jSONObjectOptJSONObject.optString("key");
            String strOptString3 = jSONObjectOptJSONObject.optString(com.alipay.sdk.m.p0.b.d);
            BaseAdUnit baseAdUnitB = a() != null ? a().b(jSONObjectOptJSONObject.optString(PointParamKey.VID)) : null;
            char c = 65535;
            switch (strOptString.hashCode()) {
                case -1253019733:
                    if (strOptString.equals("addMacro")) {
                        c = 1;
                        break;
                    }
                    break;
                case -759131257:
                    if (strOptString.equals("addAllMacros")) {
                        c = 0;
                        break;
                    }
                    break;
                case -750002817:
                    if (strOptString.equals("clearMacro")) {
                        c = 4;
                        break;
                    }
                    break;
                case -310745688:
                    if (strOptString.equals("removeMacro")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1959477782:
                    if (strOptString.equals("getMacro")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("maps");
                if (jSONObjectOptJSONObject2 == null) {
                    return null;
                }
                Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    (baseAdUnitB == null ? Sigmob.getInstance().getMacroCommon() : baseAdUnitB.getMacroCommon()).addMarcoKey(next, jSONObjectOptJSONObject2.optString(next));
                }
            } else if (c != 1) {
                if (c == 2) {
                    if (TextUtils.isEmpty(strOptString2)) {
                        return null;
                    }
                    return baseAdUnitB == null ? Sigmob.getInstance().getMacroCommon().getMarcoKey(strOptString2) : baseAdUnitB.getMacroCommon().getMarcoKey(strOptString2);
                }
                if (c != 3) {
                    if (c == 4) {
                        (baseAdUnitB == null ? Sigmob.getInstance().getMacroCommon() : baseAdUnitB.getMacroCommon()).clearMacro();
                    }
                } else {
                    if (TextUtils.isEmpty(strOptString2)) {
                        return null;
                    }
                    (baseAdUnitB == null ? Sigmob.getInstance().getMacroCommon() : baseAdUnitB.getMacroCommon()).removeMarcoKey(strOptString2);
                }
            } else {
                if (TextUtils.isEmpty(strOptString2)) {
                    return null;
                }
                (baseAdUnitB == null ? Sigmob.getInstance().getMacroCommon() : baseAdUnitB.getMacroCommon()).addMarcoKey(strOptString2, strOptString3);
            }
            return null;
        }

        @JavascriptInterface
        public void postMessage(final String data) {
            final c cVarA;
            Log.d(c.a, "postMessage: data = " + data);
            if (TextUtils.isEmpty(data) || (cVarA = a()) == null || cVarA.d == null) {
                return;
            }
            cVarA.d.post(new Runnable() { // from class: com.sigmob.sdk.mraid2.c$a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    c cVar = cVarA;
                    c.a(cVar, cVar, data);
                }
            });
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JavascriptInterface
        public String storage(String json) {
            String strOptString;
            JSONObject jSONObjectOptJSONObject;
            Log.d(c.a, "storage: json = " + json);
            if (TextUtils.isEmpty(json)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(json);
                strOptString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
                jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("type");
            String strOptString2 = jSONObjectOptJSONObject.optString("key");
            String strOptString3 = jSONObjectOptJSONObject.optString(com.alipay.sdk.m.p0.b.d);
            if (iOptInt == 1 || iOptInt == 2) {
                if (c.e == null) {
                    m unused = c.e = new m(a().d.getContext());
                }
                char c = 65535;
                switch (strOptString.hashCode()) {
                    case -1106363674:
                        if (strOptString.equals("length")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -625809843:
                        if (strOptString.equals("addEventListener")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -75439223:
                        if (strOptString.equals("getItem")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 94746189:
                        if (strOptString.equals("clear")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1098253751:
                        if (strOptString.equals("removeItem")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1984670357:
                        if (strOptString.equals("setItem")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    c.e.a(iOptInt, strOptString2, strOptString3);
                } else {
                    if (c == 1) {
                        return c.e.a(iOptInt, strOptString2);
                    }
                    if (c == 2) {
                        c.e.b(iOptInt, strOptString2);
                    } else if (c == 3) {
                        c.e.a(iOptInt);
                    } else {
                        if (c == 4) {
                            return String.valueOf(c.e.b(iOptInt));
                        }
                        if (c == 5) {
                            c.e.a(iOptInt, strOptString2, new m.a() { // from class: com.sigmob.sdk.mraid2.c$a$$ExternalSyntheticLambda3
                                @Override // com.sigmob.sdk.mraid2.m.a
                                public final void valueChange(JSONObject jSONObject2) {
                                    this.f$0.a(jSONObject2);
                                }
                            });
                        }
                    }
                }
            }
            return null;
        }

        @JavascriptInterface
        public String tracking(JSONObject jsonData) {
            boolean zOptBoolean;
            boolean zOptBoolean2;
            int iOptInt;
            String strOptString;
            boolean zOptBoolean3;
            Log.d(c.a, "tracking: jsonData = " + jsonData);
            try {
                if (jsonData == null) {
                    return c.a(400, "not params", (Object) null);
                }
                String strOptString2 = jsonData.optString(NotificationCompat.CATEGORY_EVENT);
                JSONArray jSONArrayOptJSONArray = jsonData.optJSONArray("urls");
                JSONObject jSONObjectOptJSONObject = jsonData.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    strOptString = "";
                    zOptBoolean = false;
                    zOptBoolean2 = false;
                    iOptInt = 0;
                    zOptBoolean3 = false;
                } else {
                    zOptBoolean = jSONObjectOptJSONObject.optBoolean("inQueue");
                    zOptBoolean2 = jSONObjectOptJSONObject.optBoolean("statistic");
                    iOptInt = jSONObjectOptJSONObject.optInt("retry");
                    strOptString = jSONObjectOptJSONObject.optString(PointParamKey.VID);
                    zOptBoolean3 = jSONObjectOptJSONObject.optBoolean("repeat");
                }
                c cVarA = a();
                Context context = cVarA == null ? null : cVarA.d.getContext();
                BaseAdUnit baseAdUnitB = cVarA == null ? null : cVarA.b(strOptString);
                if (TextUtils.equals(strOptString2, "click")) {
                    if (context == null || baseAdUnitB == null) {
                        Log.d(c.a, "tracking: value is null.");
                    } else {
                        String requestId = baseAdUnitB.getRequestId();
                        int iOptInt2 = jSONObjectOptJSONObject == null ? 0 : jSONObjectOptJSONObject.optInt("clickLoseRate");
                        int iOptInt3 = com.sigmob.sdk.base.utils.c.b;
                        if (jSONObjectOptJSONObject != null) {
                            iOptInt3 = jSONObjectOptJSONObject.optInt("clickCbState", iOptInt3);
                        }
                        com.sigmob.sdk.base.utils.c.a(requestId, Integer.valueOf(iOptInt2), Integer.valueOf(iOptInt3));
                        Log.d(c.a, "tracking: clickCbState = " + iOptInt3);
                        boolean z = true;
                        if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.optBoolean("normalClick", true)) {
                            z = false;
                        }
                        if (z) {
                            BaseBroadcastReceiver.a(context, baseAdUnitB.getUuid(), IntentActions.ACTION_INTERSTITIAL_CLICK);
                        }
                    }
                }
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        ag agVar = new ag(jSONArrayOptJSONArray.optString(i), strOptString2, baseAdUnitB != null ? baseAdUnitB.getRequestId() : "");
                        agVar.setRetryNum(Integer.valueOf(iOptInt));
                        agVar.setSource("js");
                        com.sigmob.sdk.base.network.g.a(agVar, baseAdUnitB, zOptBoolean3, zOptBoolean, zOptBoolean2, null);
                    }
                    return c.a(200, "tracking success", (Object) null);
                }
                List<ag> adTracker = baseAdUnitB != null ? baseAdUnitB.getAdTracker(strOptString2) : null;
                if (adTracker != null) {
                    for (ag agVar2 : adTracker) {
                        agVar2.setRetryNum(Integer.valueOf(iOptInt));
                        agVar2.setSource("js");
                        com.sigmob.sdk.base.network.g.a(agVar2, baseAdUnitB, zOptBoolean3, zOptBoolean, zOptBoolean2, null);
                    }
                }
                return c.a(300, "urls is empty", (Object) null);
            } catch (Throwable th) {
                return c.a(500, "unknown error: " + th.getMessage(), (Object) null);
            }
        }
    }

    public interface b {
        void a();

        void a(BaseAdUnit adUnit, JSONObject args);

        void a(String vid);

        void a(String subEvent, JSONObject args);

        void a(JSONObject args);

        void b();

        void b(String subEvent, JSONObject args);

        void b(JSONObject args);

        void c();

        void c(String subEvent, JSONObject args);

        void c(JSONObject args);

        void d();

        void d(JSONObject args);

        void e(JSONObject args);

        void f(JSONObject args);

        void g(JSONObject json);
    }

    /* renamed from: com.sigmob.sdk.mraid2.c$c, reason: collision with other inner class name */
    public interface InterfaceC0744c {
        void onPageChanged(g view, int type, int index);
    }

    c(final List<BaseAdUnit> adUnitList) {
        LinkedList linkedList = new LinkedList();
        this.g = linkedList;
        this.j = false;
        this.b = adUnitList;
        linkedList.addAll(adUnitList);
        ThreadPoolFactory.getFixIOExecutor().submit(new Runnable() { // from class: com.sigmob.sdk.mraid2.c$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(adUnitList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BidResponse a(List<BaseAdUnit> adUnitList) {
        Template templateBuild;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < adUnitList.size(); i++) {
            Ad ad = adUnitList.get(i).getAd();
            ArrayList arrayList2 = new ArrayList();
            if (ad != null && ad.materials != null && !ad.materials.isEmpty()) {
                MaterialMeta.Builder builderNewBuilder = ad.materials.get(0).newBuilder();
                if (builderNewBuilder.main_template != null && builderNewBuilder.main_template.type.intValue() == 2) {
                    Template templateBuild2 = builderNewBuilder.main_template.newBuilder().context(null).build();
                    templateBuild2.templateId = builderNewBuilder.main_template.templateId;
                    builderNewBuilder.main_template(templateBuild2);
                }
                if (builderNewBuilder.sub_template != null && builderNewBuilder.sub_template.type.intValue() == 2) {
                    Template templateBuild3 = builderNewBuilder.sub_template.newBuilder().context(null).build();
                    templateBuild3.templateId = builderNewBuilder.sub_template.templateId;
                    builderNewBuilder.sub_template(templateBuild3);
                }
                arrayList2.add(builderNewBuilder.html_snippet(null).build());
                arrayList.add(ad.newBuilder().materials(arrayList2).build());
            }
        }
        BidResponse.Builder builder = new BidResponse.Builder();
        BaseAdUnit baseAdUnit = adUnitList.get(0);
        if (baseAdUnit != null) {
            if (baseAdUnit.scene != null) {
                if (baseAdUnit.scene.type.intValue() == 2) {
                    templateBuild = baseAdUnit.scene.newBuilder().context(null).build();
                    templateBuild.templateId = baseAdUnit.scene.templateId;
                } else {
                    templateBuild = baseAdUnit.scene.newBuilder().build();
                }
                builder.scene(templateBuild);
            }
            if (baseAdUnit.slotAdSetting != null) {
                builder.slot_ad_setting(baseAdUnit.slotAdSetting.newBuilder().build());
            }
            if (baseAdUnit.bidding_response != null) {
                builder.bidding_response(baseAdUnit.bidding_response.newBuilder().build());
            }
            builder.request_id(baseAdUnit.getRequestId());
            builder.uid(baseAdUnit.uid);
            builder.expiration_time(Integer.valueOf(baseAdUnit.expiration_time));
        }
        return builder.ads(arrayList).build();
    }

    public static String a(int code, String message, Object data) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", code);
            if (!TextUtils.isEmpty(message)) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(c cVar, c cVar2, String str) throws JSONException {
        cVar.a(cVar2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f0 A[Catch: Exception -> 0x04c9, TryCatch #0 {Exception -> 0x04c9, blocks: (B:3:0x0008, B:7:0x0042, B:101:0x01af, B:102:0x01b2, B:103:0x01b7, B:104:0x01bb, B:105:0x01bf, B:120:0x01e8, B:122:0x01ec, B:123:0x01f0, B:125:0x01f4, B:110:0x01ce, B:113:0x01d8, B:126:0x01f8, B:128:0x01fc, B:129:0x021b, B:131:0x021f, B:132:0x0223, B:134:0x0227, B:135:0x022b, B:137:0x0233, B:138:0x0240, B:140:0x0248, B:141:0x0253, B:143:0x025b, B:144:0x0266, B:146:0x026a, B:147:0x026f, B:149:0x0273, B:150:0x0278, B:152:0x027c, B:153:0x0281, B:155:0x0285, B:156:0x028a, B:158:0x028e, B:159:0x0293, B:161:0x0297, B:162:0x029c, B:164:0x02a0, B:165:0x02a5, B:167:0x02a9, B:168:0x02ae, B:170:0x02b6, B:171:0x02bb, B:173:0x02bf, B:174:0x02c4, B:176:0x02c8, B:177:0x02cd, B:179:0x02d1, B:180:0x02d6, B:182:0x02dc, B:184:0x02e3, B:186:0x02e9, B:187:0x02ed, B:189:0x02f3, B:190:0x02f8, B:192:0x0302, B:194:0x0308, B:195:0x030d, B:197:0x032f, B:199:0x0337, B:201:0x035b, B:202:0x0362, B:204:0x036a, B:205:0x0371, B:217:0x03c3, B:221:0x03d3, B:225:0x03ec, B:227:0x03f9, B:209:0x037d, B:210:0x03b0, B:215:0x03bc, B:216:0x03c0, B:228:0x03fe, B:230:0x0408, B:232:0x040e, B:233:0x0413, B:234:0x041a, B:236:0x0420, B:237:0x0425, B:239:0x0434, B:240:0x0438, B:242:0x043e, B:243:0x044c, B:245:0x0458, B:246:0x0486, B:249:0x0498, B:251:0x04a8, B:253:0x04ae, B:254:0x04b5, B:255:0x04bd, B:257:0x04c1, B:258:0x04c5, B:10:0x004f, B:13:0x005a, B:16:0x0066, B:19:0x0073, B:22:0x007f, B:25:0x008b, B:28:0x0096, B:31:0x00a3, B:34:0x00b0, B:37:0x00b9, B:40:0x00c6, B:43:0x00d3, B:46:0x00e0, B:49:0x00eb, B:52:0x00f7, B:55:0x0103, B:58:0x010e, B:61:0x011a, B:64:0x0126, B:67:0x0132, B:70:0x013d, B:73:0x0149, B:76:0x0155, B:79:0x0160, B:82:0x016b, B:85:0x0175, B:88:0x0181, B:91:0x018d, B:94:0x0198), top: B:263:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(final com.sigmob.sdk.mraid2.c r18, java.lang.String r19) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.c.a(com.sigmob.sdk.mraid2.c, java.lang.String):void");
    }

    private void a(String key, Map extras) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, key);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        this.k = JSONSerializer.Serialize(a((List<BaseAdUnit>) list), "bidResponse", true, true);
    }

    private void c(JSONObject args) {
        List<String> list;
        if (args == null) {
            return;
        }
        String strOptString = args.optString("uniqId");
        String strOptString2 = args.optString(NotificationCompat.CATEGORY_EVENT);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || (list = h.get(strOptString + "~" + strOptString2)) == null) {
            return;
        }
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.equals(strOptString)) {
                list.remove(str);
            }
        }
    }

    private void d(JSONObject args) throws JSONException {
        List<String> list;
        HashMap<String, g> mraidWebViews;
        c mraidBridge;
        if (args == null) {
            return;
        }
        String uniqueId = a().getUniqueId();
        String strOptString = args.optString(NotificationCompat.CATEGORY_EVENT);
        if (TextUtils.isEmpty(uniqueId) || TextUtils.isEmpty(strOptString) || (list = h.get(uniqueId + "~" + strOptString)) == null || list.isEmpty() || (mraidWebViews = g.getMraidWebViews()) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            g gVar = mraidWebViews.get(it.next());
            if (gVar != null && (mraidBridge = gVar.getMraidBridge()) != null) {
                mraidBridge.a(uniqueId, strOptString, args);
            }
        }
    }

    private void e(JSONObject args) {
        if (args == null) {
            return;
        }
        String strOptString = args.optString("uniqId");
        String strOptString2 = args.optString(NotificationCompat.CATEGORY_EVENT);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return;
        }
        HashMap<String, List<String>> map = h;
        List<String> arrayList = map.get(strOptString2);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(strOptString + "~" + strOptString2, arrayList);
        }
        arrayList.add(this.d.getUniqueId());
    }

    private void i() {
        this.i = true;
        this.d.post(new Runnable() { // from class: com.sigmob.sdk.mraid2.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoadAdRequest j() {
        if (com.sigmob.sdk.base.utils.e.a(this.b)) {
            return null;
        }
        return this.b.get(0).getAdRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        try {
            d.a aVar = this.f;
            if (aVar != null) {
                aVar.c();
            }
            a(true);
            e();
            a(this.d.getAdSize());
            f();
            a(100);
            a(a(this.b), this.k);
        } catch (Throwable th) {
            SigmobLog.e("handleMraidLoad", th);
        }
    }

    public g a() {
        return this.d;
    }

    void a(int exposedPercentage) {
        a("mraidbridge.fireChangeEvent({\"exposure\":" + exposedPercentage + "});");
    }

    void a(int type, int index) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", type);
            jSONObject.put("index", index);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.notifyPageChangeEvent(" + jSONObject + ");");
    }

    void a(int top, int left, int bottom, int right) {
        a("mraidbridge.setSafeAreaInsets(" + (top + "," + left + "," + bottom + "," + right) + ")");
    }

    public void a(com.sigmob.sdk.base.common.f adSize) throws JSONException {
        int iPixelsToIntDips;
        int iPixelsToIntDips2;
        Context context = this.d.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (adSize == null) {
                iPixelsToIntDips2 = Dips.pixelsToIntDips(displayMetrics.widthPixels, context);
                iPixelsToIntDips = Dips.pixelsToIntDips(displayMetrics.heightPixels, context);
            } else {
                int iPixelsToIntDips3 = Dips.pixelsToIntDips(adSize.a(), context);
                iPixelsToIntDips = Dips.pixelsToIntDips(adSize.b(), context);
                iPixelsToIntDips2 = iPixelsToIntDips3;
            }
            jSONObject2.put("width", iPixelsToIntDips2);
            jSONObject2.put("height", iPixelsToIntDips);
            jSONObject.put("screenSize", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(BidResponse bidResponse, String bidResponseContent) {
        if (TextUtils.isEmpty(bidResponseContent)) {
            bidResponseContent = JSONSerializer.Serialize(bidResponse, "bidResponse", true, true);
        }
        a("mraidbridge.fireChangeEvent(" + bidResponseContent + ");");
    }

    void a(b listener) {
        this.c = listener;
    }

    public void a(d.a controllerListener) {
        this.f = controllerListener;
    }

    public void a(g mraidWebView) {
        this.d = mraidWebView;
        mraidWebView.setScrollContainer(false);
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setBackgroundColor(0);
        this.d.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.mraid2.c.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return c.this.f == null ? super.onConsoleMessage(consoleMessage) : c.this.f.a(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (c.this.i || c.this.j || newProgress <= 70) {
                    return;
                }
                c.this.j = true;
                c.this.a("javascript:(function () {\n    var uniqueId = 1;\n    var mraid = window.mraid = {};\n    var bridge = window.mraidbridge = {\n        nativeCallQueue: [],\n        nativeCallInFlight: false,\n        queue: {},\n    };\n    var bidResponse = {};\n    var bindData = undefined;\n    var isViewable = false;\n    var exposure = 0;\n    var sdkVersion = undefined;\n    var listeners = {};\n    var screenSize = {\n        width: 0,\n        height: 0\n    };\n    var currentAppOrientation = {\n        orientation: 0,\n        locked: true\n    };\n    var isNullOrEmpty = function(param) {\n        return param === null || param === undefined;\n    };\n    var EVENTS = mraid.EVENTS = {\n        error: 'error',\n        info: 'info',\n        ready: 'ready',\n        viewableChange: 'viewableChange',\n        sizeChange: 'sizeChange',\n        exposureChange: 'exposureChange',\n        playStateChanged: 'playStateChanged',\n        loadStateChanged: 'loadStateChanged',\n        currentTime: 'currentTime',\n        playEnd: 'playEnd',\n        pageChanged: 'pageChanged',\n        downloadStateChanged: 'downloadStateChanged',\n        safeAreaInsetsChange: 'safeAreaInsetsChange',\n    };\n\n    bridge.setScreenSize = function (val) {\n       if (screenSize.width != val.width || screenSize.height != val.height) {\n            screenSize = val;\n            broadcastEvent(listeners, EVENTS.sizeChange, val.width, val.height);\n        }\n    };\n    bridge.setIsViewable = function (val) {\n        if ((val ^ isViewable) == 1) {\n            isViewable = val;\n            broadcastEvent(listeners, EVENTS.viewableChange, isViewable)\n        }\n    };\n    bridge.setExposureChange = function (val) {\n        if (val != exposure) {\n            exposure = val;\n            broadcastEvent(listeners, EVENTS.exposureChange, val)\n        }\n    };\n    bridge.setBindData = function (val) { bindData = val; };\n    bridge.sdkVersion = function (val) { sdkVersion = val; }\n    bridge.orientation = function (val) { currentAppOrientation = val; }\n    bridge.onStorageChanged = function (evt) {\n        const key = 'storage_' + evt.key;\n        broadcastEvent(listeners, key, evt);\n    };\n    bridge.setBidResponse = function (val) {\n        bidResponse = val;\n    };\n    bridge.onChangeEvent = function(evt) {\n        broadcastEvent(listeners, evt.event, evt.data);\n    };\n    bridge.setvdReadyToPlay = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.ready, val);\n    };\n    bridge.setvdPlayStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playStateChanged, val);\n    };\n    bridge.setvdLoadStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.loadStateChanged, val);\n    };\n    bridge.setvdPlayCurrentTime = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.currentTime, val);\n    };\n    bridge.setvdPlayToEnd = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playEnd, val);\n    };\n    bridge.setvdPlayError = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.error, val);\n    };\n    bridge.onChangeFired = function (val) {\n        let obj = bridge.queue[val.uniqueId];\n        broadcastEvent(obj.handlers, val.event, val.args);\n    };\n    bridge.notify = function (val) {\n        console.log(val)\n        if (val.event.startsWith('fire_')) {\n            broadcastEvent(listeners, val.event)\n            return\n        }\n\n        if (val.event.startsWith('dispatch_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        if (val.event.startsWith('animation_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        broadcastEvent(listeners, val.event, val.message)\n        mraid.removeEventListener(val.event);\n    };\n    bridge.notifyPageChangeEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.pageChanged, val)\n    };\n    bridge.notifyApkDownloadStateEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.downloadStateChanged, val)\n    };\n    bridge.setWVFinished = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.ready);\n    };\n    bridge.setWVError = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.error, val.error);\n    };\n    bridge.postMessage = function (msg) {\n        var msgStr = JSON.stringify(msg);\n        sigandroid.postMessage(msgStr);\n    }\n    bridge.syncMessage = function (msg) {\n        if (this.nativeCallInFlight) {\n            this.nativeCallQueue.push(msg)\n        } else {\n            this.nativeCallInFlight = true;\n            var msgStr = JSON.stringify(msg);\n            sigandroid.postMessage(msgStr);\n        }\n    }\n    bridge.nativeCallComplete = function (command) {\n        console.log('nativeCallCompletecommand = ' + command)\n        if (this.nativeCallQueue.length === 0) {\n            this.nativeCallInFlight = false;\n            return\n        }\n        var nextCall = this.nativeCallQueue.shift();\n        bridge.postMessage(nextCall);\n    };\n    bridge.onMotionChanged = function (evt) {\n        const key = 'motion_' + evt.type+evt.event;\n        delete evt.type;\n        delete evt.event;\n        broadcastEvent(listeners, key, evt);\n    };\n    var changeHandlers = {\n        onChangeEvent: bridge.onChangeEvent,\n        vdReadyToPlay: bridge.setvdReadyToPlay,\n        vdPlayStateChanged: bridge.setvdPlayStateChanged,\n        vdLoadStateChanged: bridge.setvdLoadStateChanged,\n        vdPlayCurrentTime: bridge.setvdPlayCurrentTime,\n        vdPlayToEnd: bridge.setvdPlayToEnd,\n        vdPlayError: bridge.setvdPlayError,\n        wvFinished: bridge.setWVFinished,\n        wvError: bridge.setWVError,\n        screenSize: bridge.setScreenSize,\n        viewable: bridge.setIsViewable,\n        exposure: bridge.setExposureChange,\n        bindData: bridge.setBindData,\n        sdkVersion: bridge.sdkVersion,\n        orientation: bridge.orientation,\n        storageChanged: bridge.onStorageChanged,\n        bidResponse: bridge.setBidResponse,\n        notify: bridge.notify,\n        motionChanged: bridge.onMotionChanged,\n        onChangeFired: bridge.onChangeFired,\n    };\n    bridge.fireChangeEvent = function (properties) {\n        for (let p in properties) {\n            if (properties.hasOwnProperty(p)) {\n                let handler = changeHandlers[p];\n                try {\n                    handler(properties[p])\n                } catch (error) {\n                    console.log('error: ' + error.message);\n                }\n            }\n        }\n    };\n\n    var Storage = function (type) {\n        this.setItem = function (key, value) {\n            sigandroid.storage(JSON.stringify({ event: 'setItem', args: { type, key, value } }))\n        };\n        this.getItem = function (key) {\n            var result = sigandroid.storage(JSON.stringify({ event: 'getItem', args: { type, key } }));\n            return result\n        };\n        this.removeItem = function (key) {\n            sigandroid.storage(JSON.stringify({ event: 'removeItem', args: { type, key } }))\n        };\n        this.clear = function () {\n            sigandroid.storage(JSON.stringify({ event: 'clear', args: { type } }))\n        };\n        this.length = function () {\n            var result = sigandroid.storage(JSON.stringify({ event: 'length', args: { type } }));\n            return parseInt(result)\n        };\n        this.addEventListener = function (key, callback) {\n            sigandroid.storage(JSON.stringify({ event: 'addEventListener', args: { type, key } }))\n            mraid.addEventListener('storage_' + key, callback);\n        };\n    };\n    var EventListeners = function (event) {\n        this.event = event;\n        this.count = 0;\n        var listeners = {};\n        this.add = function (func) {\n            var id = String(func);\n            if (!listeners[id]) {\n                listeners[id] = func;\n                this.count++\n            }\n        };\n        this.remove = function (func) {\n            var id = String(func);\n            if (listeners[id]) {\n                listeners[id] = null;\n                delete listeners[id];\n                this.count--;\n                return true\n            } else {\n                return false\n            }\n        };\n        this.removeAll = function () {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) this.remove(listeners[id])\n            }\n        };\n        this.broadcast = function (args) {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) listeners[id].apply(mraid, args)\n            }\n        };\n        this.toString = function () {\n            var out = [event, ':'];\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) out.push('|', id, '|')\n            }\n            return out.join('')\n        }\n    };\n    var contains = function (value, array) {\n        if (value.indexOf('motion_') == 0) {\n            return true;\n        }\n        if (value.indexOf('storage_') == 0) {\n            return true;\n        }\n        if (value.indexOf('fire_') == 0) {\n            return true;\n        }\n        if (value.indexOf('dispatch_') == 0) {\n            return true;\n        }\n        if (value.indexOf('animation_') == 0) {\n            return true;\n        }\n        if (value.indexOf('open_') == 0) {\n            return true;\n        }\n        if (value.indexOf('lance_') == 0) {\n            return true;\n        }\n\n        for (var i in array) {\n            if (array[i] === value) return true\n        }\n        return false\n    };\n    var broadcastEvent = function () {\n        var args = new Array(arguments.length);\n        var l = arguments.length;\n        for (var i = 0; i < l; i++) args[i] = arguments[i];\n        var handlers = args.shift();\n        var event = args.shift();\n        if (handlers[event]) {\n            handlers[event].broadcast(args)\n        }\n    };\n    var addEventListener = function (handlers, event, listener) {\n        if (!event || !listener) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and listener are required.', 'addEventListener')\n        } else {\n            if (!handlers[event]) {\n                handlers[event] = new EventListeners(event)\n            }\n            handlers[event].add(listener)\n        }\n    };\n    var removeEventListener = function (funs, event, listener) {\n        if (!event) {\n            broadcastEvent(listeners, EVENTS.error, 'Event is required.', 'removeEventListener');\n            return\n        }\n        if (listener) {\n            var success = false;\n            if (funs[event]) {\n                success = funs[event].remove(listener)\n            }\n            if (!success) {\n                broadcastEvent(listeners, EVENTS.error, 'Listener not currently registered for event.', 'removeEventListener');\n                return\n            }\n        } else if (funs && funs[event]) {\n            funs[event].removeAll()\n        }\n        if (funs[event] && funs[event].count === 0) {\n            funs[event] = null;\n            delete funs[event]\n        }\n    };\n    \n    var Motion = function(type) {\n        this.uniqId = 'motion_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motion';\n        var events = [];\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        this.init = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init',args: { uniqueId: this.uniqId, type, sensitivity} });\n        };\n        this.initSensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init_sensitivity_raw', args: { uniqueId: this.uniqId, type, sensitivity_raw } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy',args: { uniqueId: this.uniqId, type } });\n        };\n        this.addEventListener = function (event,listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    bridge.fireReadyEvent = function () { broadcastEvent(listeners, EVENTS.ready) };\n    bridge.frame = function (event, uniqId, x, y, w, h) {\n        if (!w || !h) {\n            broadcastEvent(listeners, EVENTS.error, 'x,y,w,h is required!', 'frame');\n        } else {\n            bridge.syncMessage({ event: event, subEvent: 'frame', args: { uniqueId: uniqId, frame: { x, y, w, h } } });\n        }\n    }\n    var safeAreaInsets = {\n        top: 0,\n        left: 0,\n        bottom: 0,\n        right: 0\n    };\n    bridge.setSafeAreaInsets = function(top, left, bottom, right) {\n        if (safeAreaInsets.top == top && safeAreaInsets.left == left && safeAreaInsets.bottom == bottom && safeAreaInsets.right == right) {\n            return;\n        }\n        safeAreaInsets = {\n            top: top,\n            left: left,\n            bottom: bottom,\n            right: right\n          };\n         broadcastEvent(listeners,EVENTS.safeAreaInsetsChange, top, left, bottom, right);\n    };\n    mraid.getSafeAreaInsets = function() {\n        return {\n            top: safeAreaInsets.top,\n            left: safeAreaInsets.left,\n            bottom: safeAreaInsets.bottom,\n            right: safeAreaInsets.right\n        };\n    };\n   mraid.MotionView = function(type) {\n        this.uniqId = 'motion_view_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motionView';\n        this.rect = {x: 0, y: 0, w: 0, h: 0};\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, type } });\n        this.frame = function (x, y, w, h) {\n            this.rect = {x, y, w, h};\n            bridge.frame(this.event, this.uniqId, x, y, w, h);\n        };\n        this.hidden = function (hidden) {\n            bridge.syncMessage({ event: this.event, subEvent: 'hidden', args: { uniqueId: this.uniqId, hidden } });\n        };\n        this.sensitivity = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity', args: { uniqueId: this.uniqId, sensitivity } });\n        };\n        this.sensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity_raw', args: { uniqueId: this.uniqId, sensitivity_raw } });\n        };\n        this.start = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'start', args: { uniqueId: this.uniqId } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.Vpaid = function (val) {\n        if (typeof (val) == 'object' && val.uniqId) {\n            this.uniqId = val.uniqId;\n            uniqueId++;\n            this.rect = val.rect;\n        } else {\n            this.uniqId = 'vd_' + (uniqueId++) + '_' + new Date().getTime();\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'init', args: { uniqueId: this.uniqId } });\n            this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        }\n        bridge.queue[this.uniqId] = this;\n        this.handlers = {};\n        this.assetURL = function (URL,useProxy = true) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'assetURL', args: { uniqueId: this.uniqId, URL: URL,proxy:useProxy} });\n        };\n        this.play = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'play', args: { uniqueId: this.uniqId } });\n        };\n        this.replay = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'replay', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.stop = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'stop', args: { uniqueId: this.uniqId } });\n        };\n        this.muted = function (flag) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'muted', args: { uniqueId: this.uniqId, muted: flag } });\n        };\n        this.seek = function (val) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'seek', args: { uniqueId: this.uniqId, seekTime: val } });\n        };\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame('vpaid', this.uniqId, x, y, w, h)\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n\n    function callNativeFunc(kwargs, func) {\n        if (kwargs === undefined) return undefined;\n        if (func === undefined) return undefined;\n        kwargs['func'] = func;\n        var returnStr = sigandroid.func(JSON.stringify(kwargs));\n        if (returnStr) {\n            try {\n                return JSON.parse(returnStr)\n            } catch (e) {\n                return JSON.stringify(returnStr)\n            }\n        } else {\n            console.log('-------callNativeFunc return null-----');\n        }\n    };\n\n    mraid.Color = function(red, green, blue, alpha) {\n        this.red = red;\n        this.green = green;\n        this.blue = blue;\n        this.alpha = alpha;\n    };\n   mraid.backgroundColor = function (color) {\n        bridge.postMessage({ event: 'backgroundColor', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n    };\n   mraid.uniqId = function () {\n        return sigandroid.getUniqueId()\n    };    mraid.Timer = function (interval, repeats = false, callback) {\n        if (!interval || interval <= 0) return;\n        this.uniqId = 'timer_' + (uniqueId++) + '_' + new Date().getTime();\n        bridge.syncMessage({\n            event: 'timer',\n            subEvent: 'init',\n            args: {\n                uniqueId: this.uniqId,\n                interval: interval,\n                repeats: repeats\n            }\n        });\n        this.fire = function () {\n            mraid.addEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'fire', args: { uniqueId: this.uniqId } });\n        };\n        this.invalidate = function () {\n            mraid.removeEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'invalidate', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.resume = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'resume', args: { uniqueId: this.uniqId } });\n        };\n    };\n    mraid.WebView = function () {\n        this.uniqId = 'wv_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'webView'\n        this.handlers = {}\n        this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        var args = undefined;\n        if (arguments) {\n            args = JSON.stringify(arguments);\n        }\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, args } });\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame(this.event, this.uniqId, x, y, w, h)\n        };\n        this.loadURL = function (url) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURL', args: { uniqueId: this.uniqId, url } });\n        };\n        this.loadURLByPackage = function (URL) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURLByPackage', args: { uniqueId: this.uniqId, URL } });\n        };\n        this.loadHTMLString = function (html) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadHTMLString', args: { uniqueId: this.uniqId, html } });\n        };\n        this.loadById = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadId', args: { uniqueId: this.uniqId, id } });\n        };\n        this.reload = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'reload', args: { uniqueId: this.uniqId } });\n        };\n        this.stopLoading = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'stopLoading', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.motion = {\n        shake: new Motion('shake'),\n        twist: new Motion('twist'),\n        slope: new Motion('slope'),\n        swing: new Motion('swing'),\n    };\n    mraid.blurEffect = {\n        init: function (color) {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'init', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n        },\n        destroy: function () {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'destroy' });\n        },\n    };\n    mraid.localStorage = new Storage(1);\n    mraid.sessionStorage = new Storage(2);\n    mraid.getVersion = () => sdkVersion;\n    mraid.getOs = () => 2;\n    mraid.isViewable = () => isViewable;\n    mraid.getState = () => state;\n    mraid.version = () => '2.2'; \n     mraid.getScreenSize = () => screenSize;\n    mraid.getCurrentAppOrientation = () => currentAppOrientation;\n    mraid.bidResponse = () => bidResponse;\n    mraid.visible = function(visible) {\n        bridge.syncMessage({ event: 'visible', args: {visible} });\n    };\n    mraid.feedbackByVid = function(vid) {\n        bridge.postMessage({ event: 'feedbackByVid', args: { vid } });\n    };\n    mraid.openByVid = function(vid, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.syncMessage({ event: 'openByVid', args: {vid, event, data} });\n    };\n    mraid.open = function (url, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.postMessage({ event: 'open', args: { url, event, data } })\n    };\n   mraid.subscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'subscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        addEventListener(listeners, key, listener);\n        if (listeners[key] && listeners[key].count == 1) {\n            bridge.syncMessage({ event: 'subscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.unsubscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'unsubscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        removeEventListener(listeners, key, listener);\n        if (isNullOrEmpty(listeners[key])) {\n            bridge.syncMessage({ event: 'unsubscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.publish = function(event, data) {\n        if (isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'event are required.', 'publish');\n            return;\n        }\n        bridge.syncMessage({ event: 'publish', args: {event, data} });\n    };\n    mraid.ready = function () { bridge.postMessage({ event: 'ready' }); };\n    mraid.close = function () { bridge.postMessage({ event: 'close' }) };\n    mraid.unload = function () { bridge.postMessage({ event: 'unload' }) }\n    mraid.addSubview = function (val) { bridge.syncMessage({ event: 'addSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.belowSubview = function (val) { bridge.syncMessage({ event: 'belowSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.useScrollView = function (flag) { bridge.syncMessage({ event: 'useScrollView', args: { flag } }); };\n    mraid.touchStart = function (x, y) { bridge.postMessage({ event: 'touchStart', args: { x, y } }); };\n    mraid.touchMove = function (x, y) { bridge.postMessage({ event: 'touchMove', args: { x, y } }); };\n    mraid.touchEnd = function (x, y) { bridge.postMessage({ event: 'touchEnd', args: { x, y } }); };\n    mraid.dispatchAfter = function (delay, callback) {\n        var event = 'dispatch_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'dispatch_after', args: { 'event': event, 'delay': delay } });\n    };\n    mraid.useCustomClose = function (flag) { bridge.postMessage({ event: 'useCustomClose', args: { flag } }) };\n    mraid.addEventListener = function (event, listener) { addEventListener(listeners, event, listener); };\n    mraid.removeEventListener = function (event, listener) { removeEventListener(listeners, event, listener); };\n    mraid.arguments = () => bindData;\n    mraid.reward = function () {\n        bridge.postMessage({ event: 'reward' })\n    };\n    mraid.addMacro = function (key, value, vid) {\n        callNativeFunc({ event: 'addMacro', args: { key, value, vid } }, 'handleMacro:')\n    };\n    mraid.addAllMacros = function (maps, vid) {\n        callNativeFunc({ event: 'addAllMacros', args: { maps, vid } }, 'handleMacro:')\n    };\n    mraid.removeMacro = function (key, vid) {\n        callNativeFunc({ event: 'removeMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.clearMacro = function (vid) {\n        callNativeFunc({ event: 'clearMacro', args: { vid } }, 'handleMacro:')\n    };\n    mraid.getMacro = function (key, vid) {\n        return callNativeFunc({ event: 'getMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.addDclog = function (data, vid) {\n        return callNativeFunc({ data, vid }, 'addDclog:')\n    };\n    mraid.device = function () {\n        var device = sigandroid.getDeviceInfo()\n        if (device) {\n            return JSON.parse(device)\n        }\n    };\n    mraid.tracking = function (urls, event, data) {\n        if (urls.length > 0 || event) {\n            return callNativeFunc({ urls, event, data }, 'tracking:')\n        }\n    };\n    mraid.android = {\n        getApKDownloadProcess: function (vid) {\n            var process = sigandroidapk.getApKDownloadProcessId(vid);\n            return process\n        },\n        addEventListener: function (event, vid, listener) {\n            sigandroidapk.registerDownloadEvent(vid);\n            addEventListener(listeners, event, listener);\n        },\n        removeEventListener: function (event, listener) {\n            removeEventListener(listeners, event, listener);\n        }\n    };\n\n    mraid.loadAd = function (data, callback) {\n        var event = 'lance_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'mraidLoadAd', args: { 'event': event, 'data': data } });\n    };\n\n    mraid.setCurPlayAd = function (vid) { bridge.postMessage({ event: 'curPlayAd', args: { vid } }); };\n\n    mraid.animation = function (duration, obj, from, to, completion) {\n        const fromRect = { x: from.x, y: from.y, w: from.w, h: from.h };\n        const toRect = { x: to.x, y: to.y, w: to.w, h: to.h };\n        var event = 'animation_' + new Date().getTime();\n        mraid.addEventListener(event, completion);\n        bridge.postMessage({ event: 'animation', args: { 'event': event, duration, uniqueId: obj.uniqId, from: fromRect, to: toRect } });\n    };\n\n    (function () {\n        bridge.postMessage({ event: 'mraidJsLoaded' })\n    })();\n\n    console.log('mraid ---- successed!!!')\n}());\n", (ValueCallback) null);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(final View view, final WebChromeClient.CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
            }
        });
    }

    void a(String javascript) {
        StringBuilder sb;
        String str;
        if (!this.i) {
            sb = new StringBuilder();
            str = "MRAID JS Not Load attached:\n\t";
        } else {
            if (this.d != null) {
                SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + javascript);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.d.b(javascript, (ValueCallback) null);
                    return;
                } else {
                    this.d.a("javascript:" + javascript);
                    return;
                }
            }
            sb = new StringBuilder();
            str = "Attempted to inject Javascript into MRAID WebView while was not attached:\n\t";
        }
        SigmobLog.e(sb.append(str).append(javascript).toString());
    }

    public void a(String uniqueId, int state) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", uniqueId);
            jSONObject2.put("state", state);
            jSONObject.put("vdPlayStateChanged", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String uniqueId, int position, int duration) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", uniqueId);
            jSONObject2.put("currentTime", position / 1000.0f);
            jSONObject2.put("duration", duration / 1000.0f);
            jSONObject.put("vdPlayCurrentTime", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(String uniqueId, int duration, int width, int height) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", uniqueId);
            jSONObject2.put("duration", duration / 1000.0f);
            jSONObject2.put("width", width);
            jSONObject2.put("height", height);
            jSONObject.put("vdReadyToPlay", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String uniqueId, int code, String message) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", code);
            jSONObject2.put(cm.V, message);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("uniqueId", uniqueId);
            jSONObject3.put("error", jSONObject2);
            jSONObject.put("wvError", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(String javascript, ValueCallback callback) {
        if (this.d == null) {
            SigmobLog.e("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + javascript);
            return;
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + javascript);
        if (Build.VERSION.SDK_INT >= 19) {
            this.d.b(javascript, callback);
        } else {
            SigmobLog.e("Injecting Javascript into MRAID WebView:\n\t can't support less KITKAT" + javascript);
        }
    }

    void a(String event, BidResponse bidResponse, int code, String message) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (bidResponse == null) {
                jSONObject = new JSONObject();
                jSONObject.put("data", (Object) null);
            } else {
                jSONObject = new JSONObject(JSONSerializer.Serialize(bidResponse, "data", true, true));
            }
            jSONObject.put("code", code);
            jSONObject.put(cm.V, message);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NotificationCompat.CATEGORY_EVENT, event);
            jSONObject3.put(cm.V, jSONObject);
            jSONObject2.put("notify", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject2 + ");");
    }

    public void a(String uniqueId, String error) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", uniqueId);
            jSONObject2.put("error", error);
            jSONObject.put("vdPlayError", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    @Override // com.sigmob.sdk.mraid2.i
    public void a(String uniqueId, String type, String event, HashMap<String, Object> args) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, event);
            jSONObject2.put("uniqueId", uniqueId);
            if (args != null) {
                jSONObject2.put("args", new JSONObject(args));
            }
            jSONObject.put("onChangeFired", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(String uniqid, String event, JSONObject data) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Object objOpt = data.opt("data");
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, uniqid + "~" + event);
            if (objOpt != null) {
                jSONObject2.put("data", objOpt);
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void a(String event, HashMap<String, Object> args) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, event);
            if (args != null) {
                jSONObject2.put("args", new JSONObject(args));
            }
            jSONObject.put("onChangeEvent", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(JSONObject jsonObject) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bindData", jsonObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void a(boolean isViewable) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("viewable", isViewable);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ")");
    }

    public BaseAdUnit b(String vid) {
        if (!TextUtils.isEmpty(vid) && !com.sigmob.sdk.base.utils.e.a(this.g)) {
            for (int i = 0; i < this.g.size(); i++) {
                BaseAdUnit baseAdUnit = this.b.get(i);
                if (vid.equals(baseAdUnit.getAd().vid)) {
                    return baseAdUnit;
                }
            }
        }
        return null;
    }

    public void b(String uniqueId, int state) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", uniqueId);
            jSONObject2.put("state", state);
            jSONObject.put("vdLoadStateChanged", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void b(String event, String message) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, event);
            if (!TextUtils.isEmpty(message)) {
                jSONObject2.put(cm.V, message);
            }
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(JSONObject jsonObject) {
        a("mraidbridge.onStorageChanged(" + jsonObject.toString() + ");");
    }

    public boolean b() {
        return this.i;
    }

    public List<BaseAdUnit> c() {
        return this.g;
    }

    public void c(String uniqueId) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", uniqueId);
            jSONObject.put("wvFinished", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void c(String uniqueId, int position) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uniqueId", uniqueId);
            jSONObject2.put("currentTime", position / 1000.0f);
            jSONObject.put("vdPlayToEnd", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void d() {
        a("mraidbridge.fireReadyEvent();");
    }

    void d(String cmd) {
        a("mraidbridge.nativeCallComplete(" + JSONObject.quote(cmd) + ")");
    }

    void e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("orientation", ClientMetadata.getInstance().getOrientationInt());
            jSONObject2.put(PointCategory.LOCKED, true);
            jSONObject.put("orientation", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void e(String key) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, "fire_" + key);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    void f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkVersion", com.sigmob.sdk.base.n.k);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String key) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, key);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }

    public void g() {
        if (e != null) {
            e = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        a((b) null);
        a((d.a) null);
    }

    void g(String key) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, key);
            jSONObject.put("notify", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("mraidbridge.fireChangeEvent(" + jSONObject + ");");
    }
}
