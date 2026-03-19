package com.sigmob.sdk.base.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Base64;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntityClick;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmobSuper;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ac {

    /* renamed from: com.sigmob.sdk.base.common.ac$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ BaseAdUnit c;
        final /* synthetic */ PackageInfo d;

        AnonymousClass1(final String val$event, final String val$subCate, final BaseAdUnit val$adUnit, final PackageInfo val$info) {
            this.a = val$event;
            this.b = val$subCate;
            this.c = val$adUnit;
            this.d = val$info;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(PackageInfo packageInfo, Object obj) {
            Context contextE = com.sigmob.sdk.b.e();
            if (obj instanceof PointEntitySigmob) {
                Map options = ((PointEntitySigmob) obj).getOptions();
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        options.put(com.sigmob.sdk.base.n.t, contextE.getPackageManager().canRequestPackageInstalls() ? "1" : "0");
                    } catch (Throwable th) {
                        SigmobLog.e(th.getMessage());
                    }
                }
                if (packageInfo == null) {
                    return;
                }
                try {
                    options.put("app_name", contextE.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString());
                } catch (Throwable unused) {
                }
                options.put(com.sigmob.sdk.base.n.p, packageInfo.packageName);
                options.put(com.sigmob.sdk.base.n.q, String.valueOf(packageInfo.lastUpdateTime));
                options.put("app_version", packageInfo.versionName);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
            String str2 = this.b;
            BaseAdUnit baseAdUnit = this.c;
            final PackageInfo packageInfo = this.d;
            ac.a(str, str2, baseAdUnit, new a() { // from class: com.sigmob.sdk.base.common.ac$1$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    ac.AnonymousClass1.a(packageInfo, obj);
                }
            });
        }
    }

    public interface a {
        void onAddExtra(Object pointEntityBase);
    }

    public static void a(PackageInfo info, int type) {
        if (info == null) {
            return;
        }
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.SIGMOB_APP);
        pointEntitySigmobSuper.setCategory(PointCategory.APP);
        Map options = pointEntitySigmobSuper.getOptions();
        try {
            options.put("app_name", String.valueOf(AppPackageUtil.getPackageManager(com.sigmob.sdk.b.e()).getApplicationLabel(info.applicationInfo)));
        } catch (Throwable unused) {
        }
        options.put(com.sigmob.sdk.base.n.p, info.packageName);
        options.put(com.sigmob.sdk.base.n.q, String.valueOf(info.lastUpdateTime));
        options.put("app_version", info.versionName);
        options.put(com.sigmob.sdk.base.n.s, String.valueOf(type));
        pointEntitySigmobSuper.commit();
    }

    public static void a(final AdTracker tracker, final String url, BaseAdUnit adUnit, final NetworkResponse response, final a extraInfo) {
        if (tracker == null) {
            return;
        }
        aj.a(tracker.getEvent()).a(adUnit).a(new a() { // from class: com.sigmob.sdk.base.common.ac$$ExternalSyntheticLambda4
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                ac.a(url, tracker, response, extraInfo, obj);
            }
        }).a();
    }

    public static void a(AdTracker tracker, String url, BaseAdUnit adUnit, final VolleyError volleyError) {
        NetworkResponse networkResponse = volleyError == null ? null : volleyError.networkResponse;
        if (com.sigmob.sdk.base.utils.n.b(networkResponse)) {
            a(tracker, url, adUnit, networkResponse, (a) null);
        } else {
            a(tracker, url, adUnit, (NetworkResponse) null, new a() { // from class: com.sigmob.sdk.base.common.ac$$ExternalSyntheticLambda2
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    ac.a(volleyError, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(VolleyError volleyError, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setHttp_code("-1");
            if (volleyError == null) {
                pointEntitySigmob.setTime_spend("0");
            } else {
                pointEntitySigmob.setTime_spend(String.valueOf(volleyError.getNetworkTimeMs()));
                pointEntitySigmob.setError_message(volleyError.getMessage());
            }
        }
    }

    public static void a(DownloadItem item, BaseAdUnit adUnit, String error, boolean isCache) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(PointType.DOWNLOAD_TRACKING);
        pointEntitySigmob.setIssuccess(String.valueOf(item.status));
        pointEntitySigmob.setIscached(isCache ? "1" : "0");
        pointEntitySigmob.setDuration(String.valueOf(item.networkMs));
        pointEntitySigmob.setFile_size(String.valueOf(item.size));
        pointEntitySigmob.setFile_name(Base64.encodeToString(item.url.getBytes(), 2));
        pointEntitySigmob.setError_message(error);
        pointEntitySigmob.setCategory(String.valueOf(item.type.getType()));
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), adUnit, pointEntitySigmob);
        pointEntitySigmob.commit();
    }

    public static void a(com.sigmob.sdk.base.a clickUIType, String sub_category, BaseAdUnit adUnit, String isDeepLink, String targetUrl, String coordinate) {
        a(clickUIType, sub_category, adUnit, isDeepLink, targetUrl, coordinate, 0L);
    }

    public static void a(com.sigmob.sdk.base.a clickUIType, String subCategory, BaseAdUnit adUnit, String isDeepLink, String targetUrl, String coordinate, long duration) {
        a(clickUIType, subCategory, adUnit, isDeepLink, targetUrl, coordinate, duration, (JSONObject) null);
    }

    public static void a(com.sigmob.sdk.base.a clickUIType, final String subCategory, final BaseAdUnit adUnit, final String isDeepLink, final String targetUrl, final String coordinate, final long duration, final JSONObject object) {
        a(clickUIType == null ? subCategory : clickUIType.name().toLowerCase(), subCategory, adUnit, new a() { // from class: com.sigmob.sdk.base.common.ac$$ExternalSyntheticLambda3
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                ac.a(adUnit, subCategory, isDeepLink, targetUrl, coordinate, duration, object, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, Object obj) {
        if (aVar == null) {
            return;
        }
        aVar.onAddExtra(obj);
    }

    public static void a(y item) {
        if (item != null) {
            if (item.a == 0 && item.b == 0) {
                return;
            }
            PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
            pointEntitySigmobSuper.setAc_type(PointType.LOAD_READY);
            pointEntitySigmobSuper.setCategory(PointCategory.LOAD_READY);
            Map options = pointEntitySigmobSuper.getOptions();
            options.put(PointParamKey.PLACEMENT_ID, String.valueOf(item.c));
            options.put(PointParamKey.FEED_PRE_REQUEST_COUNT, String.valueOf(item.a));
            options.put(PointParamKey.FEED_PRE_READY_COUNT, String.valueOf(item.b));
            pointEntitySigmobSuper.commit();
        }
    }

    public static void a(BaseAdUnit adUnit, MotionEvent event, String category, boolean isValidClick) {
        long eventTime = event.getEventTime() - event.getDownTime();
        PointEntityClick pointEntityClick = new PointEntityClick();
        pointEntityClick.setAc_type(PointType.ANTI_SPAM_TOUCH);
        pointEntityClick.setCategory(category);
        pointEntityClick.setLocation(String.format(Locale.getDefault(), "{x:%f,y:%f}", Float.valueOf(event.getRawX()), Float.valueOf(event.getRawY())));
        pointEntityClick.setClick_duration(String.valueOf(eventTime));
        pointEntityClick.setPressure(String.valueOf(event.getPressure()));
        pointEntityClick.setTouchSize(String.valueOf(event.getSize()));
        pointEntityClick.setTouchType(String.valueOf(event.getToolType(0)));
        pointEntityClick.setIs_valid_click(isValidClick ? "1" : "0");
        if (adUnit != null) {
            pointEntityClick.setLoad_id(adUnit.getLoad_id());
        }
        pointEntityClick.commit();
    }

    public static void a(BaseAdUnit adUnit, String event, PackageInfo info, String subCate) {
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new AnonymousClass1(event, subCate, adUnit, info));
    }

    public static void a(BaseAdUnit adUnit, String actionType, final String downloadUrl) {
        a(PointCategory.TARGET_URL, (String) null, adUnit, new a() { // from class: com.sigmob.sdk.base.common.ac$$ExternalSyntheticLambda1
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                ac.a(downloadUrl, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void a(com.sigmob.sdk.base.models.BaseAdUnit r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, long r8, org.json.JSONObject r10, java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.ac.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, org.json.JSONObject, java.lang.Object):void");
    }

    protected static void a(PointEntitySigmob entity) {
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options == null || options.getCustomController() == null) {
            entity.setIs_custom_imei("0");
            entity.setIs_custom_android_id("0");
            entity.setIs_custom_oaid("0");
        } else {
            WindCustomController customController = options.getCustomController();
            entity.setIs_custom_imei(customController.isCanUsePhoneState() ? "0" : "1");
            entity.setIs_custom_android_id(customController.isCanUseAndroidId() ? "0" : "1");
            entity.setIs_custom_oaid(com.sigmob.sdk.base.utils.m.a((CharSequence) customController.getDevOaid()) ? "0" : "1");
        }
    }

    public static void a(String category) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.ANTI_SPAM_TOUCH);
        pointEntitySigmobSuper.setCategory(category);
        pointEntitySigmobSuper.setSha1(ClientMetadata.getInstance().getApkSha1());
        pointEntitySigmobSuper.setMd5(ClientMetadata.getInstance().getApkMd5());
        pointEntitySigmobSuper.commit();
    }

    public static void a(String category, int code, String message, BaseAdUnit adUnit) {
        a(category, code, message, adUnit, (a) null);
    }

    public static void a(String category, int code, String message, BaseAdUnit adUnit, a extraInfo) {
        PointEntitySigmobError pointEntitySigmobErrorSigmobError = PointEntitySigmobError.SigmobError(category, code, message);
        if (extraInfo != null) {
            extraInfo.onAddExtra(pointEntitySigmobErrorSigmobError);
        }
        a(category, category, adUnit, pointEntitySigmobErrorSigmobError);
        pointEntitySigmobErrorSigmobError.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, AdTracker adTracker, NetworkResponse networkResponse, a aVar, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setAc_type(PointType.SIGMOB_REPORT_TRACKING);
            pointEntitySigmob.setUrl(str);
            pointEntitySigmob.setRetry(adTracker.getId() == null ? "0" : "1");
            pointEntitySigmob.setCategory(adTracker.getEvent());
            pointEntitySigmob.setRequest_id(adTracker.getRequest_id());
            pointEntitySigmob.setSource(adTracker.getSource());
            long timestamp = adTracker.getTimestamp();
            if (timestamp != 0) {
                pointEntitySigmob.setTimestamp(String.valueOf(timestamp));
            }
            if (networkResponse != null) {
                pointEntitySigmob.setResponse(networkResponse.data == null ? null : Base64.encodeToString(networkResponse.data, 2));
                pointEntitySigmob.setHttp_code(String.valueOf(networkResponse.statusCode));
                pointEntitySigmob.setTime_spend(String.valueOf(networkResponse.networkTimeMs));
                pointEntitySigmob.setContent_type((String) networkResponse.headers.get("Content-Type"));
                pointEntitySigmob.setContent_length((String) networkResponse.headers.get("Content-Length"));
            }
        }
        if (aVar != null) {
            aVar.onAddExtra(obj);
        }
    }

    public static void a(String category, a extraInfo) {
        ab abVar = new ab();
        abVar.setAc_type("1");
        abVar.setCategory(category);
        com.sigmob.sdk.base.o oVarA = com.sigmob.sdk.base.o.a();
        boolean zT = oVarA.T();
        boolean zS = oVarA.S();
        abVar.setAppinfo_switch(zT ? "0,0" : "1,1");
        int i = 1;
        int i2 = 0;
        if (zS) {
            i = 0;
        } else {
            DeviceContext deviceContextB = com.sigmob.sdk.b.b();
            if ((deviceContextB == null ? ClientMetadata.getInstance().getLocation() : deviceContextB.getLocation()) != null) {
                i2 = 1;
            }
        }
        abVar.setLocation_switch(i + "," + i2);
        if (extraInfo != null) {
            extraInfo.onAddExtra(abVar);
        }
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options == null || options.getCustomController() == null) {
            abVar.a("0");
            abVar.b("0");
            abVar.c("0");
        } else {
            WindCustomController customController = options.getCustomController();
            abVar.a(customController.isCanUsePhoneState() ? "0" : "1");
            abVar.b(customController.isCanUseAndroidId() ? "0" : "1");
            abVar.c(com.sigmob.sdk.base.utils.m.a((CharSequence) customController.getDevOaid()) ? "0" : "1");
        }
        abVar.commit();
    }

    public static void a(String ac_type, BaseAdUnit adUnit, LoadAdRequest adRequest, a extraInfo) {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type(ac_type);
        if (extraInfo != null) {
            extraInfo.onAddExtra(pointEntitySigmob);
        }
        a(pointEntitySigmob.getCategory(), pointEntitySigmob.getSub_category(), adUnit, pointEntitySigmob);
        if (adRequest != null) {
            pointEntitySigmob.setLoad_id(adRequest.getLoadId());
            pointEntitySigmob.setAdtype(String.valueOf(adRequest.getAdType()));
            pointEntitySigmob.setScene_id(adRequest.getAdSceneId());
            pointEntitySigmob.setScene_desc(adRequest.getAdSceneDesc());
            pointEntitySigmob.setPlacement_id(adRequest.getPlacementId());
        }
        pointEntitySigmob.commit();
    }

    public static void a(String category, BaseAdUnit adUnit, String isDeepLink, String targetUrl, String coordinate) {
        a(null, category, adUnit, isDeepLink, targetUrl, coordinate, 0L);
    }

    public static void a(String category, WindAdError error, BaseAdUnit adUnit) {
        a(category, (String) null, error.getErrorCode(), error.getMessage(), (WindAdRequest) null, (LoadAdRequest) null, adUnit, (a) null);
    }

    public static void a(String category, WindAdError adError, BaseAdUnit adUnit, a extraInfo) {
        if (adError == null) {
            return;
        }
        int errorCode = adError.getErrorCode();
        String message = adError.getMessage();
        PointEntitySigmobError pointEntitySigmobErrorSigmobError = PointEntitySigmobError.SigmobError(category, errorCode, message);
        a(category, category, adUnit, pointEntitySigmobErrorSigmobError);
        if (com.sigmob.sdk.base.utils.m.a((CharSequence) message, (CharSequence) WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage()) && com.sigmob.sdk.base.utils.m.a((CharSequence) category, (CharSequence) "load") && com.sigmob.sdk.base.utils.n.b(adUnit)) {
            pointEntitySigmobErrorSigmobError.getOptions().put("video_url", adUnit.getVideo_url());
        }
        if (extraInfo != null) {
            extraInfo.onAddExtra(pointEntitySigmobErrorSigmobError);
        }
        pointEntitySigmobErrorSigmobError.commit();
    }

    public static void a(String category, WindAdError error, BaseAdUnit adUnit, LoadAdRequest adRequest) {
        a(category, (String) null, error.getErrorCode(), error.getMessage(), (WindAdRequest) null, adRequest, adUnit, (a) null);
    }

    public static void a(String category, WindAdError error, WindAdRequest adRequest) {
        a(category, (String) null, error.getErrorCode(), error.getMessage(), adRequest, (LoadAdRequest) null, (BaseAdUnit) null, (a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setFinal_url(str);
        }
    }

    public static void a(String category, String subCategory, int errCode, String errMsg, LoadAdRequest adRequest) {
        a(category, subCategory, errCode, errMsg, (WindAdRequest) null, adRequest, (BaseAdUnit) null, (a) null);
    }

    public static void a(String category, String subCategory, int errCode, String errMsg, WindAdRequest adRequest, LoadAdRequest loadAdRequest, BaseAdUnit adUnit, a extraInfo) {
        PointEntitySigmobError pointEntitySigmobErrorSigmobError = PointEntitySigmobError.SigmobError(category, errCode, errMsg);
        pointEntitySigmobErrorSigmobError.setSub_category(subCategory);
        a(category, category, pointEntitySigmobErrorSigmobError, adRequest);
        a(category, category, pointEntitySigmobErrorSigmobError, loadAdRequest);
        a(category, category, adUnit, pointEntitySigmobErrorSigmobError);
        if (extraInfo != null) {
            extraInfo.onAddExtra(pointEntitySigmobErrorSigmobError);
        }
        pointEntitySigmobErrorSigmobError.commit();
    }

    public static void a(String category, String subCategory, BaseAdUnit adUnit) {
        a(category, subCategory, adUnit, (a) null);
    }

    public static void a(String category, String subCategory, BaseAdUnit adUnit, a extraInfo) {
        a(category, subCategory, adUnit, (WindAdRequest) null, (LoadAdRequest) null, extraInfo);
    }

    public static void a(String category, String subCategory, BaseAdUnit adUnit, LoadAdRequest adRequest, a extraInfo) {
        a(category, subCategory, adUnit, (WindAdRequest) null, adRequest, extraInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static void a(String str, String str2, BaseAdUnit baseAdUnit, PointEntitySigmob pointEntitySigmob) {
        if (baseAdUnit == null || pointEntitySigmob == null) {
            return;
        }
        try {
            int ad_type = baseAdUnit.getAd_type();
            pointEntitySigmob.setAdtype(String.valueOf(ad_type));
            pointEntitySigmob.setCampaign_id(baseAdUnit.getCamp_id());
            pointEntitySigmob.setCreative_id(baseAdUnit.getCrid());
            pointEntitySigmob.setRequest_id(baseAdUnit.getRequestId());
            pointEntitySigmob.setPlacement_id(baseAdUnit.getAdslot_id());
            pointEntitySigmob.setLoad_id(baseAdUnit.getLoad_id());
            pointEntitySigmob.setVid(baseAdUnit.getVid());
            pointEntitySigmob.setScene_id(baseAdUnit.getAd_scene_id());
            pointEntitySigmob.setScene_desc(baseAdUnit.getAd_scene_desc());
            pointEntitySigmob.setPlay_mode(String.valueOf(baseAdUnit.getPlayMode()));
            pointEntitySigmob.setCreative_type(String.valueOf(baseAdUnit.getCreativeType()));
            pointEntitySigmob.setBid_token(baseAdUnit.getBid_token());
            BiddingResponse biddingResponse = baseAdUnit.bidding_response;
            if (biddingResponse != null) {
                pointEntitySigmob.setHb_price(biddingResponse.ecpm.intValue());
            }
            pointEntitySigmob.setPrice(baseAdUnit.getAd().settlement_price_enc);
            if (com.sigmob.sdk.base.utils.m.b(baseAdUnit.getAd().product_id)) {
                pointEntitySigmob.setProduct_id(baseAdUnit.getAd().product_id);
            }
            if (baseAdUnit.getAdx_id() != null) {
                pointEntitySigmob.setAdx_id(baseAdUnit.getAdx_id());
            }
            pointEntitySigmob.setTemplate_id(String.valueOf(baseAdUnit.getTemplateId()));
            if (baseAdUnit.getMaterial() != null) {
                pointEntitySigmob.setTemplate_type(baseAdUnit.getMaterial().template_type.intValue());
            }
            if (com.sigmob.sdk.base.utils.m.a((CharSequence) pointEntitySigmob.getTarget_url())) {
                pointEntitySigmob.setTarget_url(baseAdUnit.getLanding_page());
            }
            WXProgramRes wXProgramRes = baseAdUnit.getWXProgramRes();
            if (com.sigmob.sdk.base.utils.n.b(wXProgramRes)) {
                if (com.sigmob.sdk.base.utils.m.b(wXProgramRes.wx_app_path)) {
                    pointEntitySigmob.setWx_app_path(URLEncoder.encode(wXProgramRes.wx_app_path, "UTF-8"));
                }
                if (com.sigmob.sdk.base.utils.m.b(wXProgramRes.wx_app_username)) {
                    pointEntitySigmob.setWx_app_username(wXProgramRes.wx_app_username);
                }
            }
            String apkMd5 = baseAdUnit.getApkMd5();
            if (com.sigmob.sdk.base.utils.m.b(apkMd5)) {
                pointEntitySigmob.getOptions().put(PointParamKey.APK_MD5, apkMd5);
            }
            pointEntitySigmob.setAd_source_channel(baseAdUnit.getAd_source_channel());
            a(str, str2, pointEntitySigmob, ad_type, baseAdUnit.isHalfInterstitial());
        } catch (Throwable unused) {
        }
        Map options = pointEntitySigmob.getOptions();
        if (com.sigmob.sdk.base.utils.m.a((CharSequence) pointEntitySigmob.getCategory())) {
            String str3 = com.sigmob.sdk.base.utils.m.b(str) ? str : (String) options.get("category");
            if (com.sigmob.sdk.base.utils.m.b(str3)) {
                pointEntitySigmob.setCategory(str3);
            }
        }
        if (com.sigmob.sdk.base.utils.m.b(str, "request")) {
            Integer adExpiredTime = baseAdUnit.getAdExpiredTime();
            Long lValueOf = Long.valueOf(baseAdUnit.getCreate_time());
            boolean zExpiredAdCanReload = baseAdUnit.expiredAdCanReload();
            options.put(PointParamKey.EXPIRE_RELOAD_COUNT, String.valueOf(baseAdUnit.expiredAdReloadNum()));
            options.put(PointParamKey.CAN_EXPIRE_RELOAD, String.valueOf(zExpiredAdCanReload ? 1 : 0));
            options.put(PointParamKey.EXPIRE_TIMESTAMP, String.valueOf(lValueOf.longValue() + adExpiredTime.intValue()));
            int requestSceneType = baseAdUnit.getRequestSceneType();
            if (requestSceneType > 0) {
                options.put(PointParamKey.REQUEST_SCENE_TYPE, String.valueOf(requestSceneType));
            }
            Boolean boolEnableSmallWindow = baseAdUnit.enableSmallWindow();
            baseAdUnit.getDeeplinkUrl();
            if (com.sigmob.sdk.base.utils.n.b((Object) boolEnableSmallWindow) && (baseAdUnit.isValid(baseAdUnit.getInteractionType()) || baseAdUnit.isValid(baseAdUnit.getMraidInteractionType()))) {
                options.put(PointParamKey.ENABLE_SMALL_WINDOW, boolEnableSmallWindow.booleanValue() ? "1" : "0");
            }
            if (baseAdUnit.getAd_type() == 6) {
                Boolean boolAllowClickToAutoClose = baseAdUnit.allowClickToAutoClose();
                if (com.sigmob.sdk.base.utils.n.b((Object) boolAllowClickToAutoClose)) {
                    options.put(PointParamKey.CLICK_CLOSE_AD, boolAllowClickToAutoClose.booleanValue() ? "1" : "0");
                }
                Integer numAllowCountdownEndsClose = baseAdUnit.allowCountdownEndsClose();
                if (com.sigmob.sdk.base.utils.n.b(numAllowCountdownEndsClose)) {
                    options.put(PointParamKey.SECONDS_CLOSE_AD, String.valueOf(numAllowCountdownEndsClose));
                }
            }
            options.put(PointParamKey.TRACE_ID, baseAdUnit.getTraceId());
            if (requestSceneType == com.sigmob.sdk.base.j.NormalRequest.a() || requestSceneType == com.sigmob.sdk.base.j.ReloadAfterExpiration.a() || requestSceneType == com.sigmob.sdk.base.j.ActiveFailureReload.a()) {
                options.put(PointParamKey.VID, baseAdUnit.getVid());
                String originVid = baseAdUnit.getOriginVid();
                if (com.sigmob.sdk.base.utils.m.b(originVid)) {
                    options.put(PointParamKey.ORIGIN_VID, originVid);
                }
            }
        }
    }

    public static void a(String category, String subCategory, BaseAdUnit adUnit, WindAdRequest adRequest, a extraInfo) {
        a(category, subCategory, adUnit, adRequest, (LoadAdRequest) null, extraInfo);
    }

    public static void a(String category, String subCategory, BaseAdUnit adUnit, WindAdRequest request, LoadAdRequest adRequest, final a extraInfo) {
        aj.a(category).c(subCategory).a(adUnit).a(request).a(adRequest).a(new a() { // from class: com.sigmob.sdk.base.common.ac$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                ac.a(extraInfo, obj);
            }
        }).a();
    }

    public static void a(String category, String subCategory, LoadAdRequest adRequest) {
        a(category, subCategory, (BaseAdUnit) null, (WindAdRequest) null, adRequest, (a) null);
    }

    private static void a(String category, String subCategory, PointEntitySigmob entity, int adType, boolean halfInterstitial) {
        if (com.sigmob.sdk.base.utils.m.a((CharSequence) entity.getShow_type()) && com.sigmob.sdk.base.utils.m.b(category)) {
            if ((category.equals("request") || category.equals(PointCategory.READY) || category.equals("start") || category.equals("endcard") || (com.sigmob.sdk.base.utils.m.b(subCategory) && subCategory.equals("click"))) && adType == 4) {
                entity.setShow_type(halfInterstitial ? "2" : "1");
            }
        }
    }

    protected static void a(String category, String subCategory, PointEntitySigmob entity, LoadAdRequest adRequest) {
        if (entity == null || adRequest == null) {
            return;
        }
        entity.setPlacement_id(adRequest.getPlacementId());
        String bidToken = adRequest.getBidToken();
        if (com.sigmob.sdk.base.utils.m.b(bidToken)) {
            entity.setBid_token(bidToken);
        }
        String loadId = adRequest.getLoadId();
        if (com.sigmob.sdk.base.utils.m.b(loadId)) {
            entity.setLoad_id(loadId);
        }
        String adx_id = adRequest.getAdx_id();
        if (com.sigmob.sdk.base.utils.m.b(adx_id)) {
            entity.setAdx_id(adx_id);
        }
        int adType = adRequest.getAdType();
        entity.setAdtype(String.valueOf(adType));
        String requestId = adRequest.getRequestId();
        if (com.sigmob.sdk.base.utils.m.b(requestId)) {
            entity.setRequest_id(requestId);
        }
        String traceId = adRequest.getTraceId();
        if (com.sigmob.sdk.base.utils.m.b(traceId)) {
            entity.setTrace_id(traceId);
        }
        Map<String, String> options = adRequest.getOptions();
        if (com.sigmob.sdk.base.utils.n.b(options)) {
            entity.setExtinfo(new JSONObject(options).toString());
        }
        a(category, subCategory, entity, adType, adRequest.isHalfInterstitial());
        int request_scene_type = adRequest.getRequest_scene_type();
        if (request_scene_type > 0) {
            entity.getOptions().put(PointParamKey.REQUEST_SCENE_TYPE, String.valueOf(request_scene_type));
        }
    }

    protected static void a(String category, String subCategory, PointEntitySigmob entity, WindAdRequest adRequest) {
        if (entity == null || adRequest == null) {
            return;
        }
        int adType = adRequest.getAdType();
        entity.setPlacement_id(adRequest.getPlacementId());
        entity.setLoad_id(adRequest.getLoadId());
        entity.setAdx_id(adRequest.getAdxId());
        entity.setAdtype(String.valueOf(adType));
        if (adRequest.hasOptions()) {
            try {
                entity.setExtinfo(new JSONObject(adRequest.getOptions()).toString());
            } catch (Throwable unused) {
            }
        }
        a(category, subCategory, entity, adType, adRequest.isHalfInterstitial());
    }

    public static void a(String category, String subCategory, WindAdRequest adRequest, LoadAdRequest loadAdRequest, a extraInfo) {
        PointEntitySigmobRequest pointEntitySigmobRequest = new PointEntitySigmobRequest();
        pointEntitySigmobRequest.setAc_type("5");
        pointEntitySigmobRequest.setCategory(category);
        pointEntitySigmobRequest.setSub_category(subCategory);
        a(category, category, pointEntitySigmobRequest, adRequest);
        a(category, category, pointEntitySigmobRequest, loadAdRequest);
        if (com.sigmob.sdk.base.utils.n.b(extraInfo)) {
            extraInfo.onAddExtra(pointEntitySigmobRequest);
        }
        a(pointEntitySigmobRequest);
        pointEntitySigmobRequest.commit();
    }

    public static void a(String pkgName, boolean isCanOpen, int type) {
        PointEntitySigmobSuper pointEntitySigmobSuper = new PointEntitySigmobSuper();
        pointEntitySigmobSuper.setAc_type(PointType.SIGMOB_CANOPEN_APP);
        pointEntitySigmobSuper.setCategory(PointCategory.OPEN_APP);
        Map options = pointEntitySigmobSuper.getOptions();
        options.put(PointParamKey.APP_PKG_NAME, pkgName);
        options.put(PointParamKey.CAN_OP, isCanOpen ? "1" : "0");
        options.put("type", String.valueOf(type));
        pointEntitySigmobSuper.commit();
    }

    public static void b(String category, String subCategory, BaseAdUnit adUnit) {
        a(category, subCategory, adUnit, (a) null);
    }
}
