package com.sigmob.sdk.base.network;

import android.util.Base64;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.App;
import com.czhj.sdk.common.models.BidRequest;
import com.czhj.sdk.common.models.ModelBuilderCreator;
import com.czhj.sdk.common.models.Permission;
import com.czhj.sdk.common.models.Privacy;
import com.czhj.sdk.common.models.User;
import com.czhj.sdk.common.network.SigmobRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.ParseError;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.HttpHeaderParser;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.i;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends SigmobRequest<BidResponse> {
    private final e.a a;
    private final LoadAdRequest b;
    private byte[] c;

    public a(String url, LoadAdRequest loadAdRequest, e.a listener) {
        super(url, 1, (Response.ErrorListener) null);
        Preconditions.NoThrow.checkNotNull(listener);
        this.a = listener;
        this.b = loadAdRequest;
        setRetryPolicy(new DefaultRetryPolicy(5000, 0, 0.0f));
        setShouldCache(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0196 A[Catch: all -> 0x03a6, TryCatch #0 {all -> 0x03a6, blocks: (B:3:0x000f, B:5:0x0035, B:6:0x003c, B:8:0x0043, B:12:0x0057, B:14:0x006d, B:16:0x007d, B:18:0x0087, B:19:0x00ab, B:21:0x00b1, B:24:0x00bf, B:37:0x0199, B:39:0x01c0, B:40:0x01c3, B:42:0x01ed, B:43:0x01f4, B:45:0x0214, B:46:0x0216, B:48:0x0220, B:49:0x0222, B:51:0x0231, B:52:0x0234, B:54:0x023e, B:55:0x0241, B:57:0x0252, B:59:0x0256, B:60:0x025d, B:62:0x0330, B:64:0x037f, B:65:0x038a, B:69:0x039f, B:31:0x0115, B:32:0x0130, B:34:0x018c, B:36:0x0196, B:33:0x0134, B:61:0x0266), top: B:75:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.czhj.sdk.common.models.BidRequest.Builder a(com.sigmob.sdk.base.models.LoadAdRequest r14) {
        /*
            Method dump skipped, instructions count: 943
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.network.a.a(com.sigmob.sdk.base.models.LoadAdRequest):com.czhj.sdk.common.models.BidRequest$Builder");
    }

    private void a(final int adType, final String placementId, final String requestId, int errorCode, String message) {
        ac.a(PointCategory.SERVER_ERROR, errorCode, message, (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.base.network.a$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                a.a(requestId, placementId, adType, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, int i, Object obj) {
        if (obj instanceof PointEntitySigmobError) {
            PointEntitySigmobError pointEntitySigmobError = (PointEntitySigmobError) obj;
            pointEntitySigmobError.setRequest_id(str);
            pointEntitySigmobError.setPlacement_id(str2);
            pointEntitySigmobError.setAdtype(String.valueOf(i));
        }
    }

    public static App.Builder b() {
        App.Builder builderCreateApp = ModelBuilderCreator.createApp();
        builderCreateApp.sdk_ext_cap.add(4);
        builderCreateApp.app_id(WindAds.sharedAds().getAppId());
        Permission.Builder builder = new Permission.Builder();
        boolean zJ = o.a().j();
        boolean sensorStatus = WindAds.sharedAds().getSensorStatus();
        boolean z = false;
        boolean zF = (!sensorStatus || zJ) ? false : com.sigmob.sdk.b.f();
        if (sensorStatus && zF) {
            z = true;
        }
        builder.accelerometer(Boolean.valueOf(z));
        builderCreateApp.permission(builder.build());
        return builderCreateApp;
    }

    public static User.Builder c() {
        User.Builder builder = new User.Builder();
        builder.is_minor = Boolean.valueOf(!i.a().d());
        builder.disable_personalized_recommendation = Boolean.valueOf(!i.a().e());
        builder.change_recommendation_state = Boolean.valueOf(i.a().f());
        return builder;
    }

    public static Privacy.Builder d() {
        int iG;
        Privacy.Builder builder = new Privacy.Builder();
        builder.age(Integer.valueOf(i.a().b()));
        builder.child_protection(Integer.valueOf(i.a().c()));
        try {
            iG = i.a().g();
        } catch (Throwable unused) {
            iG = 0;
        }
        builder.gdpr_consent(Integer.valueOf(iG));
        WindAdOptions options = WindAds.sharedAds().getOptions();
        WindCustomController windCustomController = (options == null || options.getCustomController() == null) ? new WindCustomController() : options.getCustomController();
        builder.allow_geo = Boolean.valueOf(windCustomController.isCanUseLocation());
        builder.allow_imei = Boolean.valueOf(windCustomController.isCanUsePhoneState());
        builder.allow_oaid = Boolean.valueOf(windCustomController.isCanUseOaid());
        builder.allow_android_id = Boolean.valueOf(windCustomController.isCanUseAndroidId());
        builder.allow_installed_apps = Boolean.valueOf(windCustomController.isCanUseAppList());
        builder.allow_carrier_code = Boolean.valueOf(windCustomController.isCanUseSimOperator());
        return builder;
    }

    public e.a a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deliverResponse(BidResponse bidResponse) {
        String strDecryptString;
        x xVarA;
        NativeAdSetting nativeAdSetting;
        x xVarA2;
        int adType = this.b.getAdType();
        if (bidResponse != null) {
            if (adType == 5) {
                x xVarA3 = x.a(this.b.getPlacementId());
                if (xVarA3 != null) {
                    xVarA3.c = System.currentTimeMillis();
                    xVarA3.g = xVarA3.c;
                    xVarA3.b = 0;
                    xVarA3.a = 0;
                    SlotAdSetting slotAdSetting = bidResponse.slot_ad_setting;
                    if (slotAdSetting != null && (nativeAdSetting = slotAdSetting.native_setting) != null) {
                        xVarA3.e = ((Integer) Wire.get(nativeAdSetting.ad_pool_size, 0)).intValue();
                        xVarA3.d = ((Integer) Wire.get(nativeAdSetting.req_interval_time, 0)).intValue();
                        xVarA3.f = ((Integer) Wire.get(nativeAdSetting.media_expected_floor, 0)).intValue();
                        z.a().a(((Integer) Wire.get(nativeAdSetting.log_interval_time, 0)).intValue());
                    }
                }
                x.a(this.b.getPlacementId(), xVarA3);
            }
            Boolean bool = bidResponse.noncompliance_mark;
            o.a = Boolean.valueOf(bool != null && bool.booleanValue());
            SigmobLog.d("noncomplianceMark(bid) = " + o.a);
            String str = bidResponse.uid;
            if (m.b(str)) {
                try {
                    strDecryptString = AESUtil.DecryptStringServer(str, "KGpfzbYsn4T9Jyuq");
                } catch (NoSuchMethodError unused) {
                    strDecryptString = AESUtil.DecryptString(str, "KGpfzbYsn4T9Jyuq");
                }
                ClientMetadata.getInstance().setUid(strDecryptString);
            }
            if (m.b(bidResponse.adx_id)) {
                this.b.setAdx_id(bidResponse.adx_id);
            }
            this.b.setRequestId(bidResponse.request_id);
            if (bidResponse.ads.isEmpty()) {
                a(adType, this.b.getPlacementId(), bidResponse.request_id, bidResponse.error_code.intValue(), bidResponse.error_message);
                e.a(this.a, bidResponse.error_code.intValue(), bidResponse.error_message, bidResponse.request_id, this.b);
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < bidResponse.ads.size(); i++) {
                    Ad ad = bidResponse.ads.get(i);
                    if (this.b.getAdType() == 6 && com.sigmob.sdk.base.utils.e.b(ad.materials) && n.b(bidResponse.slot_ad_setting) && n.b(bidResponse.slot_ad_setting.interstitial_setting)) {
                        for (MaterialMeta materialMeta : ad.materials) {
                            if (materialMeta != null && materialMeta.android_market != null && materialMeta.android_market.type != null) {
                                Boolean bool2 = bidResponse.slot_ad_setting.interstitial_setting.click_close_ad;
                                Integer num = bidResponse.slot_ad_setting.interstitial_setting.seconds_close_ad;
                                if (materialMeta.android_market.type.intValue() == 1 && (n.a(bool2) || n.a((Number) num))) {
                                    materialMeta.android_market = null;
                                }
                            }
                        }
                    }
                    BaseAdUnit baseAdUnitAdUnit = BaseAdUnit.adUnit(ad, bidResponse.request_id, this.b, bidResponse.slot_ad_setting, bidResponse.scene, bidResponse.uid, bidResponse.expiration_time, bidResponse.bidding_response);
                    baseAdUnitAdUnit.setAd_type(adType);
                    baseAdUnitAdUnit.setAdx_id(this.b.getAdx_id());
                    baseAdUnitAdUnit.setAdslot_id(this.b.getPlacementId());
                    baseAdUnitAdUnit.setHalfInterstitial(this.b.isHalfInterstitial());
                    baseAdUnitAdUnit.setRvCallBackUrl(bidResponse.rv_callback_url);
                    baseAdUnitAdUnit.setTraceId(this.b.getTraceId());
                    baseAdUnitAdUnit.setOriginVid(this.b.getOriginVid());
                    baseAdUnitAdUnit.setBid_token(this.b.getBidToken());
                    baseAdUnitAdUnit.setRequestSceneType(this.b.getRequest_scene_type());
                    arrayList.add(baseAdUnitAdUnit);
                }
                if (adType == 5 && (xVarA = x.a(this.b.getPlacementId())) != null) {
                    com.sigmob.sdk.base.common.g.a(this.b.getPlacementId(), arrayList, xVarA.e);
                }
                e.a(this.a, arrayList, this.b);
                if (adType == 6 || adType == 1 || adType == 4) {
                    com.sigmob.sdk.base.common.g.a(bidResponse.request_id, bidResponse);
                    return;
                }
                return;
            } catch (Throwable th) {
                SigmobLog.e("ads Response: error ", th);
            }
        } else if (adType == 5 && (xVarA2 = x.a(this.b.getPlacementId())) != null) {
            xVarA2.g = xVarA2.c;
        }
        e.a(this.a, WindAdError.ERROR_SIGMOB_INFORMATION_LOSE.getErrorCode(), "bidResponse is null", null, this.b);
    }

    public void deliverError(VolleyError error) {
        e.a aVar;
        WindAdError windAdError;
        x xVarA;
        if (this.b.getAdType() == 5 && (xVarA = x.a(this.b.getPlacementId())) != null) {
            xVarA.g = xVarA.c;
        }
        if (error instanceof ParseError) {
            aVar = this.a;
            windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
        } else {
            SigmobLog.e(this.b.getPlacementId() + " ERROR_SIGMOB_NETWORK " + error.getMessage());
            aVar = this.a;
            windAdError = WindAdError.ERROR_SIGMOB_NETWORK;
        }
        e.a(aVar, windAdError.getErrorCode(), error.getMessage(), null, this.b);
    }

    public byte[] getBody() {
        return this.c;
    }

    public String getBodyContentType() {
        return MediaTypeUtils.APPLICATION_OCTET_STREAM;
    }

    public Map<String, String> getHeaders() {
        LoadAdRequest loadAdRequest;
        Map<String, String> headers = super.getHeaders();
        try {
            headers.put("agn", Base64.encodeToString(AESUtil.generateNonce(), 2));
        } catch (NoSuchMethodError unused) {
            headers.put("e", "1");
        }
        try {
            loadAdRequest = this.b;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
        BidRequest bidRequestBuild = loadAdRequest != null ? a(loadAdRequest).build() : null;
        if (bidRequestBuild == null) {
            SigmobLog.e("builder Ads Post entry fail ");
            return null;
        }
        try {
            byte[] bArrEncode = bidRequestBuild.encode();
            this.c = bArrEncode;
            this.c = c.b(bArrEncode);
            headers.put(com.alipay.sdk.m.k.b.m, "1");
        } catch (Throwable unused2) {
            headers.remove(com.alipay.sdk.m.k.b.m);
            this.c = bidRequestBuild.encode();
        }
        try {
            this.c = AESUtil.Encrypt(this.c, "KGpfzbYsn4T9Jyuq");
        } catch (Exception e) {
            e.printStackTrace();
            headers.remove("e");
            headers.remove("agn");
        }
        return headers;
    }

    protected Response<BidResponse> parseNetworkResponse(final NetworkResponse networkResponse) {
        try {
            if (networkResponse.data == null) {
                return Response.error(new ParseError(networkResponse));
            }
            BidResponse bidResponse = (BidResponse) BidResponse.ADAPTER.decode((networkResponse.headers.containsKey(com.alipay.sdk.m.k.b.m) && "1".equals(networkResponse.headers.get(com.alipay.sdk.m.k.b.m))) ? c.a(networkResponse.data) : networkResponse.data);
            return bidResponse == null ? Response.error(new ParseError(networkResponse)) : Response.success(bidResponse, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return Response.error(new ParseError(th));
        }
    }
}
