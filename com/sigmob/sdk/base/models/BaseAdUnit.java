package com.sigmob.sdk.base.models;

import android.graphics.Color;
import android.net.Uri;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.czhj.wire.Wire;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.common.af;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.l;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.AdSetting;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.FrequencyControl;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.ResponseAssetImage;
import com.sigmob.sdk.base.models.rtb.ResponseAssetVideo;
import com.sigmob.sdk.base.models.rtb.ResponseNativeAd;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.models.rtb.Tracking;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.base.models.rtb.Widget;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.utils.e;
import com.sigmob.sdk.base.utils.i;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.base.views.n;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.videoAd.a;
import com.sigmob.sdk.videoAd.d;
import com.sigmob.windad.natives.AdAppInfo;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BaseAdUnit implements Serializable {
    private static final String TAG = "BaseAdUnit";
    private static final long serialVersionUID = 1;
    private Ad ad;
    private transient AdAppInfo adAppInfo;
    private transient h adConfig;
    private int adHeight;
    private LoadAdRequest adRequest;
    private HashMap<String, List<ag>> adTrackersMap;
    private int adWidth;
    private String ad_scene_desc;
    private String ad_scene_id;
    private String ad_source_channel;
    private int ad_type;
    private String adslot_id;
    private String adx_id;
    private String apkName;
    private String apkPackageName;
    private String bid_token;
    public BiddingResponse bidding_response;
    private String camp_id;
    private ClickCommon clickCommon;
    private long create_time;
    private String crid;
    private transient Uri deeplinkUri;
    private Long downloadId;
    private transient f downloadTask;
    private String downloadUrl;
    private List<d> download_trackers;
    private String endcard_md5;
    public int expiration_time;
    private transient List<SigImage> imageUrlList;
    private boolean isHalfInterstitial;
    private String landUrl;
    private String load_id;
    private AndroidMarket mCustomAndroidMarket;
    private String mCustomDeeplink;
    private String mCustomLandPageUrl;
    private transient HashMap<String, Integer> mRedirectCountMap;
    private transient af mSessionManager;
    private SigMacroCommon macroCommon;
    private int mraidInteractionType;
    private SigVideo nativeVideo;
    private String originVid;
    private int requestSceneType;
    private String request_id;
    private String rv_callback_url;
    public Template scene;
    public SlotAdSetting slotAdSetting;
    private String traceId;
    public String uid;
    private String uuid;
    private VideoStatusCommon videoCommon;
    private String video_md5;
    private double adPercent = -1.0d;
    private double realAdPercent = -1.0d;
    private boolean useDownloadedApk = false;
    private boolean isDislikeReported = false;
    private boolean record = true;
    private boolean catchVideo = false;

    public static BaseAdUnit adUnit(Ad ad, String request_id, LoadAdRequest adRequest, SlotAdSetting slotAdSetting, Template scene, String uid, Integer expiration_time, BiddingResponse bidding_response) {
        MaterialMeta materialMeta;
        ResponseNativeAd nativeAd;
        BaseAdUnit baseAdUnit = null;
        if (ad == null || ad.materials == null || ad.materials.isEmpty() || (materialMeta = ad.materials.get(0)) == null) {
            return null;
        }
        try {
            BaseAdUnit baseAdUnit2 = new BaseAdUnit();
            try {
                baseAdUnit2.create_time = System.currentTimeMillis();
                baseAdUnit2.adslot_id = ad.adslot_id;
                baseAdUnit2.ad_type = ad.ad_type.intValue();
                baseAdUnit2.ad = ad;
                baseAdUnit2.crid = ad.crid;
                baseAdUnit2.camp_id = ad.camp_id;
                baseAdUnit2.request_id = request_id;
                baseAdUnit2.endcard_md5 = materialMeta.endcard_md5;
                baseAdUnit2.video_md5 = materialMeta.video_md5;
                baseAdUnit2.load_id = adRequest.getLoadId();
                baseAdUnit2.ad_source_channel = ad.ad_source_channel;
                if ((materialMeta.creative_type.intValue() == l.CreativeTypeVideo_Html_Snippet.a() || materialMeta.creative_type.intValue() == l.CreativeTypeVideo_transparent_html.a()) && materialMeta.html_snippet != null) {
                    materialMeta.html_snippet.size();
                }
                baseAdUnit2.slotAdSetting = slotAdSetting;
                baseAdUnit2.adRequest = adRequest;
                baseAdUnit2.scene = scene;
                baseAdUnit2.uid = uid;
                if (expiration_time != null) {
                    baseAdUnit2.expiration_time = expiration_time.intValue();
                }
                if (ad.bidding_response != null) {
                    bidding_response = ad.bidding_response;
                }
                baseAdUnit2.bidding_response = bidding_response;
                baseAdUnit2.useDownloadedApk = ((Boolean) Wire.get(slotAdSetting.use_downloaded_apk, false)).booleanValue();
                initAdTrackerMap(baseAdUnit2);
                if (ad.ad_track_macro != null) {
                    baseAdUnit2.getMacroCommon().setServerMacroMap(ad.ad_track_macro);
                }
                if (baseAdUnit2.ad_type != 5 || (nativeAd = baseAdUnit2.getNativeAd()) == null) {
                    return baseAdUnit2;
                }
                if (nativeAd.type.intValue() == 1) {
                    baseAdUnit2.getNativeVideo();
                    return baseAdUnit2;
                }
                baseAdUnit2.getImageUrlList();
                return baseAdUnit2;
            } catch (Throwable th) {
                th = th;
                baseAdUnit = baseAdUnit2;
                SigmobLog.e("adUnit error", th);
                return baseAdUnit;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean checkFileMD5(String path, String md5) {
        String strFileMd5 = Md5Util.fileMd5(path);
        SigmobLog.d("path: [ " + path + " ] calc [ " + strFileMd5 + " ] origin " + md5);
        return strFileMd5 != null && strFileMd5.equalsIgnoreCase(md5);
    }

    public static List<ag> createTrackersForUrls(List<String> urls, String event, String requestId, Integer retryNum) {
        Preconditions.NoThrow.checkNotNull(urls);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = urls.iterator();
        while (it.hasNext()) {
            ag agVar = new ag(it.next(), event, requestId);
            agVar.setRetryNum(retryNum);
            arrayList.add(agVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAppSize() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy != null && adPrivacy.privacy_template_info != null) {
            String str = adPrivacy.privacy_template_info.get("app_size");
            if (m.a((CharSequence) str)) {
                return 0;
            }
            try {
                return Integer.parseInt(str);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

    public static String getTAG() {
        return TAG;
    }

    private static void initAdTrackerMap(BaseAdUnit adUnit) {
        List<Tracking> ad_tracking = adUnit.getAd_tracking();
        adUnit.adTrackersMap = new HashMap<>();
        for (Tracking tracking : ad_tracking) {
            String str = tracking.tracking_event_type;
            adUnit.adTrackersMap.put(str, createTrackersForUrls(tracking.tracking_url, str, adUnit.request_id, Integer.valueOf(adUnit.getTrackingRetryNum())));
        }
    }

    public void addRedirectCount(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return;
        }
        String str = uri.getScheme() + ":" + uri.getHost();
        int redirectCount = getRedirectCount(uri) + 1;
        synchronized (this) {
            if (this.mRedirectCountMap == null) {
                this.mRedirectCountMap = new HashMap<>();
            }
            this.mRedirectCountMap.put(str, Integer.valueOf(redirectCount));
        }
    }

    public Boolean allowClickToAutoClose() {
        InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
        if (newInterstitialSetting == null) {
            return null;
        }
        return newInterstitialSetting.click_close_ad;
    }

    public Integer allowCountdownEndsClose() {
        InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
        if (newInterstitialSetting == null) {
            return null;
        }
        return newInterstitialSetting.seconds_close_ad;
    }

    public boolean canInstall(String apkName) {
        boolean z = (m.a((CharSequence) getApkMd5()) && getDownloadTask() == null && getDownloadId() == null) ? false : true;
        if (canUseDownloadApk() && !m.a((CharSequence) apkName) && z) {
            File file = new File(i.a(b.e()), apkName);
            return file.exists() && ClientMetadata.getPackageInfoWithUri(b.e(), file.getAbsolutePath()) != null;
        }
        return false;
    }

    public boolean canOpen() {
        return o.a().b(m.a((CharSequence) this.apkPackageName) ? getProductId() : this.apkPackageName).booleanValue();
    }

    public boolean canUseDownloadApk() {
        return this.useDownloadedApk;
    }

    public boolean checkEndCardZipValid() {
        if (m.a((CharSequence) getEndcard_url()) || m.a((CharSequence) this.endcard_md5)) {
            return true;
        }
        return checkFileMD5(getEndCardZipPath(), getEndcard_md5());
    }

    public boolean checkVideoValid() {
        if (m.a((CharSequence) getVideo_url()) || m.a((CharSequence) this.video_md5)) {
            return true;
        }
        return checkFileMD5(getVideoPath(), getVideo_OriginMD5());
    }

    public void destroy() {
        h hVar = this.adConfig;
        if (hVar != null) {
            hVar.k();
            this.adConfig = null;
        }
        af afVar = this.mSessionManager;
        if (afVar != null) {
            afVar.a();
        }
    }

    public void dislikeReport() {
        this.isDislikeReported = true;
    }

    public boolean enableDetectPkg() {
        return o.a().N().booleanValue();
    }

    public boolean enableDevToRender(int index) {
        Widget widget = getWidget(index);
        if (widget == null) {
            return false;
        }
        return widget.enable_developer_render.booleanValue();
    }

    public Boolean enableSmallWindow() {
        Ad ad = getAd();
        if (ad == null) {
            return null;
        }
        return ad.enable_small_window;
    }

    public boolean enableSmallWindow(Integer interactionType) {
        int interactionType2 = interactionType == null ? getInteractionType() : interactionType.intValue();
        Boolean boolEnableSmallWindow = enableSmallWindow();
        return boolEnableSmallWindow != null && isValid(interactionType2) && boolEnableSmallWindow.booleanValue();
    }

    public void enableUseDownloadApk(boolean enable) {
        this.useDownloadedApk = enable;
    }

    public boolean enableWidgetInteraction() {
        NativeAdSetting nativeAdSetting = getNativeAdSetting();
        if (nativeAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(nativeAdSetting.enable_advanced_interaction, false)).booleanValue();
    }

    public boolean enable_full_click() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting == null) {
            return false;
        }
        return splashAdSetting.enable_full_click.booleanValue();
    }

    public boolean expiredAdCanReload() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(adSetting.can_expire_reload, false)).booleanValue();
    }

    public int expiredAdReloadNum() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.expire_reload_count, 0)).intValue();
    }

    public Ad getAd() {
        return this.ad;
    }

    public AdAppInfo getAdAppInfo() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (this.adAppInfo == null && adPrivacy != null) {
            try {
                this.adAppInfo = new AdAppInfo() { // from class: com.sigmob.sdk.base.models.BaseAdUnit.1
                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAppName() {
                        return BaseAdUnit.this.getPrivacyAppName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public int getAppSize() {
                        return BaseAdUnit.this.getAppSize();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAuthorName() {
                        return BaseAdUnit.this.getCompanyName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescription() {
                        return BaseAdUnit.this.getDescription();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescriptionUrl() {
                        return BaseAdUnit.this.getDescriptionUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissions() {
                        return BaseAdUnit.this.getPermissions();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissionsUrl() {
                        return BaseAdUnit.this.getPermissionsUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreement() {
                        return BaseAdUnit.this.getPrivacyAgreement();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreementUrl() {
                        return BaseAdUnit.this.getPrivacyAgreementUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getVersionName() {
                        return BaseAdUnit.this.getAppVersion();
                    }

                    public String toString() {
                        return String.format(Locale.getDefault(), "appName %s \n AuthorName %s \n  versionName %s \n permissionsUrl %s \n permissions %s \nprivacyAgreementUrl %s \n privacyAgreement %s \n descriptionUrl %s \n description %s \n  appsize %d", getAppName(), getAuthorName(), getVersionName(), getPermissionsUrl(), getPermissions(), getPrivacyAgreementUrl(), getPrivacyAgreement(), getDescriptionUrl(), getDescription(), Integer.valueOf(getAppSize()));
                    }
                };
            } catch (Throwable unused) {
            }
        }
        return this.adAppInfo;
    }

    public h getAdConfig() {
        h hVarF;
        if (this.adConfig == null) {
            switch (getAd_type()) {
                case 1:
                case 4:
                    hVarF = a.f(this);
                    break;
                case 2:
                    hVarF = com.sigmob.sdk.splash.a.f(this);
                    break;
                case 3:
                case 6:
                    hVarF = com.sigmob.sdk.newInterstitial.d.f(this);
                    break;
                case 5:
                    hVarF = com.sigmob.sdk.nativead.d.f(this);
                    break;
            }
            this.adConfig = hVarF;
            return hVarF;
        }
        return this.adConfig;
    }

    public Integer getAdExpiredTime() {
        Ad ad = this.ad;
        return Integer.valueOf((ad == null || ad.expired_time == null) ? 0 : this.ad.expired_time.intValue() * 1000);
    }

    public List<LinkAction> getAdLinkActions() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return null;
        }
        return adSetting.link_actions;
    }

    public String getAdLogo() {
        return getAd_source_logo();
    }

    public double getAdPercent() {
        double d = this.adPercent;
        if (d > 0.0d) {
            return d;
        }
        double d2 = this.realAdPercent;
        if (d2 > 0.0d) {
            return d2;
        }
        return 1.7777777910232544d;
    }

    public File getAdPrivacyTemplateFile() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null) {
            return null;
        }
        String str = adPrivacy.privacy_template_url;
        if (m.a((CharSequence) str)) {
            return null;
        }
        return i.a(i.d(i.b), Md5Util.md5(str) + ".html");
    }

    public LoadAdRequest getAdRequest() {
        return this.adRequest;
    }

    public AdSetting getAdSetting() {
        Ad ad = this.ad;
        if (ad == null) {
            return null;
        }
        return ad.ad_setting;
    }

    public List<ag> getAdTracker(String event) {
        HashMap<String, List<ag>> map = this.adTrackersMap;
        if (map == null) {
            return null;
        }
        return map.get(event);
    }

    public String getAd_scene_desc() {
        return this.ad_scene_desc;
    }

    public String getAd_scene_id() {
        return this.ad_scene_id;
    }

    public String getAd_source_channel() {
        return this.ad_source_channel;
    }

    public String getAd_source_logo() {
        Ad ad = this.ad;
        if (ad == null) {
            return null;
        }
        return ad.ad_source_logo;
    }

    public List<Tracking> getAd_tracking() {
        Ad ad = this.ad;
        if (ad == null) {
            return null;
        }
        return ad.ad_tracking;
    }

    public int getAd_type() {
        return this.ad_type;
    }

    public String getAdslot_id() {
        return this.adslot_id;
    }

    public String getAdxEncPrice() {
        BiddingResponse biddingResponse = this.bidding_response;
        return biddingResponse == null ? "" : (String) Wire.get(biddingResponse.price_for_ssp_enc, "");
    }

    public int getAdxPrice() {
        BiddingResponse biddingResponse = this.bidding_response;
        if (biddingResponse == null) {
            return 0;
        }
        return ((Integer) Wire.get(biddingResponse.price_for_ssp, 0)).intValue();
    }

    public String getAdx_id() {
        return this.adx_id;
    }

    public AndroidMarket getAndroidMarket() {
        AndroidMarket androidMarket;
        MaterialMeta material = getMaterial();
        AndroidMarket androidMarket2 = material != null ? material.android_market : null;
        return (androidMarket2 != null || (androidMarket = this.mCustomAndroidMarket) == null) ? androidMarket2 : androidMarket;
    }

    public int getApkDownloadType() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(slotAdSetting.apk_download_type, 0)).intValue();
    }

    public String getApkMd5() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return (String) Wire.get(material.apk_md5, (Object) null);
    }

    public String getApkName() {
        return this.apkName;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String getAppName() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.app_name;
    }

    public String getAppVersion() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_version");
    }

    public int getBP() {
        Ad ad = this.ad;
        if (ad == null) {
            return 0;
        }
        return ((Integer) Wire.get(ad.bid_price, 0)).intValue();
    }

    public int getBidEcpm() {
        BiddingResponse biddingResponse = this.bidding_response;
        if (biddingResponse == null) {
            return 0;
        }
        return ((Integer) Wire.get(biddingResponse.ecpm, 0)).intValue();
    }

    public String getBid_token() {
        return this.bid_token;
    }

    public int getButtonColor() {
        MaterialMeta material = getMaterial();
        return (material == null || material.button_color == null) ? Color.parseColor("#FF5A57") : Color.argb((int) (material.button_color.alpha.floatValue() * 255.0f), material.button_color.red.intValue(), material.button_color.green.intValue(), material.button_color.blue.intValue());
    }

    public String getCTAText() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.button_text : null;
        return !m.a((CharSequence) str) ? str : getInteractionType() != 2 ? "查看详情" : "立即下载";
    }

    public String getCamp_id() {
        return this.camp_id;
    }

    public int getChargePercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.charge_percent, 0)).intValue();
    }

    public int getChargeSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.charge_seconds, 0)).intValue();
    }

    public ClickAreaSetting getClickAreaSetting() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return null;
        }
        if (rvAdSetting.click_setting != null) {
            return rvAdSetting.click_setting;
        }
        ClickAreaSetting.Builder builder = new ClickAreaSetting.Builder();
        builder.bottom = Float.valueOf(0.1f);
        builder.right = Float.valueOf(0.1f);
        builder.top = Float.valueOf(0.1f);
        builder.left = Float.valueOf(0.1f);
        return builder.build();
    }

    public ClickCommon getClickCommon() {
        if (this.clickCommon == null) {
            this.clickCommon = new ClickCommon();
        }
        return this.clickCommon;
    }

    public int getClickType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return ((Integer) Wire.get(material.click_type, 0)).intValue();
    }

    public String getCloseCardHtmlData() {
        MaterialMeta material = getMaterial();
        if (material == null || material.closecard_html_snippet == null || material.closecard_html_snippet.size() < 10) {
            return null;
        }
        return material.closecard_html_snippet.utf8();
    }

    public String getCompanyName() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_company");
    }

    public int getConfirmDialog() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.confirm_dialog, 0)).intValue();
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public n.b getCreativeResourceType() {
        return (m.a((CharSequence) getEndcard_url()) || !(getCreativeType() == l.CreativeTypeVideo_Tar.a() || getCreativeType() == l.CreativeTypeVideo_Tar_Companion.a())) ? !m.a((CharSequence) getHtmlData()) ? n.b.HTML_RESOURCE : !m.a((CharSequence) getHtmlUrl()) ? n.b.URL_RESOURCE : n.b.NATIVE_RESOURCE : n.b.NATIVE_RESOURCE;
    }

    public String getCreativeTitle() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.creative_title;
    }

    public int getCreativeType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.creative_type.intValue();
    }

    public String getCrid() {
        return this.crid;
    }

    public Uri getDeeplinkUri() {
        return this.deeplinkUri;
    }

    public String getDeeplinkUrl() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.deeplink_url : null;
        return (!m.a((CharSequence) str) || m.a((CharSequence) this.mCustomDeeplink)) ? str : this.mCustomDeeplink;
    }

    public String getDesc() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.desc;
    }

    public String getDescription() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_func");
    }

    public String getDescriptionUrl() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_func_url");
    }

    public boolean getDisableAutoLoad() {
        Boolean bool;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return false;
            }
            bool = newInterstitialSetting.disable_auto_load;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return false;
            }
            bool = rvAdSetting.disable_auto_load;
        }
        return bool.booleanValue();
    }

    public int getDisplay_orientation() {
        Ad ad = getAd();
        if (ad == null) {
            return 0;
        }
        return ((Integer) Wire.get(ad.display_orientation, 0)).intValue();
    }

    public Long getDownloadId() {
        return this.downloadId;
    }

    public List<d> getDownloadQuarterTrack() {
        return this.download_trackers;
    }

    public f getDownloadTask() {
        return this.downloadTask;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getDuration() {
        int endTime = getEndTime();
        if (endTime > 0) {
            return endTime * 1000;
        }
        return 33333;
    }

    public boolean getEnableDeeplinkAndLandingPage() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(slotAdSetting.enable_deeplink_and_landing_page, false)).booleanValue();
    }

    public String getEndCardDirPath() {
        return i.b() + String.format("/%s/", getEndcard_md5());
    }

    public String getEndCardImageUrl() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.endcard_image_src;
    }

    public String getEndCardIndexPath() {
        return getEndCardDirPath() + "endcard.html";
    }

    public String getEndCardZipPath() {
        return i.b() + String.format("/%s.tgz", this.endcard_md5);
    }

    public String getEndCard_OriginMD5() {
        return this.endcard_md5;
    }

    public int getEndTime() {
        RvAdSetting rvAdSetting;
        if (this.ad_type == 6 || (rvAdSetting = getRvAdSetting()) == null) {
            return 0;
        }
        return rvAdSetting.end_time.intValue();
    }

    public int getEndcardCloseImage() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return rvAdSetting.endcard_close_image.intValue();
    }

    public String getEndcard_md5() {
        return !m.a((CharSequence) this.endcard_md5) ? this.endcard_md5 : Md5Util.md5(getCrid());
    }

    public String getEndcard_url() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.endcard_url;
    }

    public float getFinishedTime() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 1.0f;
        }
        return rvAdSetting.finished.floatValue();
    }

    public int getFloor() {
        NativeAdSetting nativeAdSetting = getNativeAdSetting();
        if (nativeAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(nativeAdSetting.media_expected_floor, 0)).intValue();
    }

    public List<FrequencyControl> getFrequencyControl() {
        Ad ad;
        if (m.b(this.bid_token) || (ad = getAd()) == null) {
            return null;
        }
        return ad.frequency_control;
    }

    public boolean getFullClickOnVideo() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return false;
        }
        return rvAdSetting.full_click_on_video.booleanValue();
    }

    public String getHtmlData() {
        MaterialMeta material = getMaterial();
        if (material == null || material.html_snippet == null || material.html_snippet.size() < 10) {
            return null;
        }
        return material.html_snippet.utf8();
    }

    public String getHtmlUrl() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.html_url;
    }

    public String getIconUrl() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.icon_url;
    }

    public List<SigImage> getImageUrlList() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.imageUrlList == null) {
            ArrayList arrayList = new ArrayList();
            this.imageUrlList = arrayList;
            if (nativeAd == null) {
                return arrayList;
            }
            if (nativeAd.type.intValue() == 1) {
                return this.imageUrlList;
            }
            Iterator<ResponseAsset> it = nativeAd.assets.iterator();
            while (it.hasNext()) {
                ResponseAssetImage responseAssetImage = it.next().image;
                if (responseAssetImage != null) {
                    SigImage sigImage = new SigImage(responseAssetImage.url, responseAssetImage.w.intValue(), responseAssetImage.h.intValue());
                    if (this.adPercent < 0.0d && responseAssetImage.w.intValue() > 0 && responseAssetImage.h.intValue() > 0) {
                        this.adPercent = (responseAssetImage.w.intValue() * 1.0f) / responseAssetImage.h.intValue();
                    }
                    this.imageUrlList.add(sigImage);
                }
            }
        }
        return this.imageUrlList;
    }

    public int getInteractionType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 1;
        }
        return material.interaction_type.intValue();
    }

    public boolean getInvisibleAdLabel() {
        RvAdSetting rvAdSetting;
        Boolean bool;
        int ad_type = getAd_type();
        if (ad_type == 2) {
            SplashAdSetting splashAdSetting = getSplashAdSetting();
            if (splashAdSetting == null) {
                return false;
            }
            bool = splashAdSetting.invisible_ad_label;
        } else {
            if ((ad_type != 1 && ad_type != 4) || (rvAdSetting = getRvAdSetting()) == null) {
                return false;
            }
            bool = rvAdSetting.invisible_ad_label;
        }
        return bool.booleanValue();
    }

    public int getIsMute() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return 0;
            }
            num = newInterstitialSetting.if_mute;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return 0;
            }
            num = rvAdSetting.if_mute;
        }
        return num.intValue();
    }

    public String getLandUrl() {
        return this.landUrl;
    }

    public String getLanding_page() {
        String str = getMaterial() != null ? getMaterial().landing_page : null;
        return (!m.a((CharSequence) str) || m.a((CharSequence) this.mCustomLandPageUrl)) ? str : this.mCustomLandPageUrl;
    }

    public String getLoad_id() {
        return this.load_id;
    }

    public SigMacroCommon getMacroCommon() throws UnsupportedEncodingException {
        if (this.macroCommon == null) {
            this.macroCommon = new SigMacroCommon();
            String video_url = getVideo_url();
            if (!m.a((CharSequence) video_url)) {
                try {
                    String strEncode = URLEncoder.encode(video_url, "UTF-8");
                    if (!m.a((CharSequence) strEncode)) {
                        this.macroCommon.addMarcoKey(SigMacroCommon._VURL_, strEncode);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.macroCommon;
    }

    public String getMainImage() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.image_src;
    }

    public List<String> getMarketPackageNameList() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.market_package_name;
    }

    public MaterialMeta getMaterial() {
        Ad ad = this.ad;
        if (ad == null || ad.materials == null || this.ad.materials.isEmpty()) {
            return null;
        }
        return this.ad.materials.get(0);
    }

    public int getMraidInteractionType() {
        return this.mraidInteractionType;
    }

    public ResponseNativeAd getNativeAd() {
        Ad ad = this.ad;
        if (ad == null || ad.materials == null || this.ad.materials.isEmpty()) {
            return null;
        }
        return this.ad.materials.get(0).native_ad;
    }

    public NativeAdSetting getNativeAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.native_setting;
    }

    public SigVideo getNativeVideo() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.nativeVideo == null && nativeAd != null && nativeAd.type.intValue() == 1) {
            for (ResponseAsset responseAsset : nativeAd.assets) {
                ResponseAssetVideo responseAssetVideo = responseAsset.video;
                if (responseAssetVideo != null) {
                    if (this.nativeVideo == null) {
                        this.nativeVideo = new SigVideo();
                    }
                    this.nativeVideo.url = responseAssetVideo.url;
                    this.nativeVideo.height = responseAssetVideo.h.intValue();
                    this.nativeVideo.width = responseAssetVideo.w.intValue();
                    if (this.adPercent < 0.0d && responseAssetVideo.h.intValue() > 0 && responseAssetVideo.w.intValue() > 0) {
                        this.adPercent = (responseAssetVideo.w.intValue() * 1.0f) / responseAssetVideo.h.intValue();
                    }
                }
                ResponseAssetImage responseAssetImage = responseAsset.image;
                if (responseAssetImage != null) {
                    if (this.nativeVideo == null) {
                        this.nativeVideo = new SigVideo();
                    }
                    this.nativeVideo.thumbUrl = responseAssetImage.url;
                }
            }
        }
        return this.nativeVideo;
    }

    public InterstitialSetting getNewInterstitialSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.interstitial_setting;
    }

    public String getOriginVid() {
        return this.originVid;
    }

    public String getPermissions() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_permission");
    }

    public String getPermissionsUrl() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_permission_url");
    }

    public int getPlayMode() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.play_mode.intValue();
    }

    public String getPrivacyAgreement() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_privacy_text");
    }

    public String getPrivacyAgreementUrl() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_privacy_url");
    }

    public String getPrivacyAppName() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || adPrivacy.privacy_template_info == null) {
            return null;
        }
        return adPrivacy.privacy_template_info.get("app_name");
    }

    public String getProductId() {
        Ad ad = getAd();
        if (ad == null) {
            return null;
        }
        return ad.product_id;
    }

    public String getProxyVideoUrl() {
        String video_url = getVideo_url();
        return m.a((CharSequence) video_url) ? video_url : g.d().a(video_url);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[Catch: all -> 0x0060, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:8:0x000b, B:12:0x0030, B:14:0x0036, B:15:0x0040, B:23:0x005a, B:16:0x0043, B:18:0x004b, B:19:0x0052), top: B:31:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int getRedirectCount(android.net.Uri r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            if (r4 == 0) goto L63
            java.lang.String r1 = r4.getScheme()     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto Lb
            goto L63
        Lb:
            java.lang.String r1 = r4.getScheme()     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = r4.getHost()     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r2.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = ":"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r4 = r1.append(r4)     // Catch: java.lang.Throwable -> L60
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L60
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r3.mRedirectCountMap     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L30
            monitor-exit(r3)
            return r0
        L30:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L60
            r2 = 24
            if (r1 < r2) goto L43
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r3.mRedirectCountMap     // Catch: java.lang.Throwable -> L60
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L60
            java.lang.Object r4 = r1.getOrDefault(r4, r2)     // Catch: java.lang.Throwable -> L60
        L40:
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L60
            goto L56
        L43:
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r3.mRedirectCountMap     // Catch: java.lang.Throwable -> L60
            boolean r1 = r1.containsKey(r4)     // Catch: java.lang.Throwable -> L60
            if (r1 == 0) goto L52
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r3.mRedirectCountMap     // Catch: java.lang.Throwable -> L60
            java.lang.Object r4 = r1.get(r4)     // Catch: java.lang.Throwable -> L60
            goto L40
        L52:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L60
        L56:
            if (r4 != 0) goto L5a
            monitor-exit(r3)
            return r0
        L5a:
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L60
            monitor-exit(r3)
            return r4
        L60:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L63:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.models.BaseAdUnit.getRedirectCount(android.net.Uri):int");
    }

    public String getRequestId() {
        return this.request_id;
    }

    public int getRequestSceneType() {
        return this.requestSceneType;
    }

    public int getRewardPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.reward_percent, 0)).intValue();
    }

    public int getRewardSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.reward_seconds, 0)).intValue();
    }

    public int getRewardStyle() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(rvAdSetting.reward_style, 0)).intValue();
    }

    public RvAdSetting getRvAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.rv_setting;
    }

    public String getRvCallBackUrl() {
        return this.rv_callback_url;
    }

    public Template getScene() {
        return this.scene;
    }

    public int getSensitivity() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.sensitivity, 0)).intValue();
    }

    public af getSessionManager() {
        return this.mSessionManager;
    }

    public int getShakeCount() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(adSetting.shake_count, 0)).intValue();
    }

    public SingleNativeAdSetting getSingleNativeSetting() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return null;
        }
        return adSetting.single_native_setting;
    }

    public int getSkipPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return -1;
        }
        return ((Integer) Wire.get(rvAdSetting.skip_percent, 0)).intValue();
    }

    public int getSkipSeconds() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return -1;
            }
            num = newInterstitialSetting.show_skip_seconds;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return -1;
            }
            num = (Integer) Wire.get(rvAdSetting.skip_seconds, 0);
        }
        return num.intValue();
    }

    public List<LinkAction> getSlotAdLinkActions() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.link_actions;
    }

    public SlotAdSetting getSlotAdSetting() {
        return this.slotAdSetting;
    }

    public SplashAdSetting getSplashAdSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting == null) {
            return null;
        }
        return slotAdSetting.splash_setting;
    }

    public String getSplashFilePath() {
        StringBuilder sbAppend;
        String str;
        if (l.CreativeTypeSplashVideo.a() == getMaterial().creative_type.intValue()) {
            sbAppend = new StringBuilder().append(i.e()).append(File.separator);
            str = getMaterial().video_url;
        } else {
            sbAppend = new StringBuilder().append(i.e()).append(File.separator);
            str = getMaterial().image_src;
        }
        return sbAppend.append(Md5Util.md5(str)).toString();
    }

    public String getSplashURL() {
        return l.CreativeTypeSplashVideo.a() == getMaterial().creative_type.intValue() ? getMaterial().video_url : getMaterial().image_src;
    }

    public int getTemplateId() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.template_id.intValue();
    }

    public int getTemplateType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.template_type.intValue();
    }

    public String getTitle() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.title;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public int getTrackingRetryNum() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return 0;
        }
        return ((Integer) Wire.get(slotAdSetting.retry_count, 0)).intValue();
    }

    public String getUuid() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID().toString();
        }
        return this.uuid;
    }

    public String getVid() {
        Ad ad = getAd();
        if (ad == null) {
            return null;
        }
        return ad.vid;
    }

    public VideoStatusCommon getVideoCommon() {
        if (this.videoCommon == null) {
            this.videoCommon = new VideoStatusCommon();
        }
        return this.videoCommon;
    }

    public String getVideoCoverImageUrl() {
        SigVideo sigVideo = this.nativeVideo;
        if (sigVideo == null) {
            return null;
        }
        return sigVideo.thumbUrl;
    }

    public boolean getVideoErrorReward() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(rvAdSetting.video_error_reward, false)).booleanValue();
    }

    public String getVideoPath() {
        File videoProxyFile = getVideoProxyFile();
        if (videoProxyFile == null) {
            return null;
        }
        return videoProxyFile.getAbsolutePath();
    }

    public File getVideoProxyFile() {
        String video_url = getVideo_url();
        if (m.a((CharSequence) video_url)) {
            return null;
        }
        return g.d().c(video_url);
    }

    public String getVideoTmpPath() {
        return i.a() + String.format("/%s.mp4.tmp", getVideo_md5());
    }

    public String getVideo_OriginMD5() {
        return this.video_md5;
    }

    public String getVideo_md5() {
        return !m.a((CharSequence) this.video_md5) ? this.video_md5 : Md5Util.md5(getVideo_url());
    }

    public String getVideo_url() {
        String str;
        Ad ad = this.ad;
        if (ad == null || ad.materials == null || this.ad.materials.isEmpty()) {
            return null;
        }
        if (this.ad_type == 5) {
            SigVideo nativeVideo = getNativeVideo();
            if (nativeVideo == null) {
                return null;
            }
            str = nativeVideo.url;
        } else {
            MaterialMeta materialMeta = this.ad.materials.get(0);
            if (materialMeta == null) {
                return null;
            }
            str = materialMeta.video_url;
        }
        return StringUtil.getUrl(str);
    }

    public WXProgramRes getWXProgramRes() {
        Ad ad = getAd();
        if (ad == null || ad.wx_program_res == null) {
            return null;
        }
        return ad.wx_program_res;
    }

    public Widget getWidget(int index) {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        List<Widget> list = material.Widget_list;
        if (!e.a(list) && e.a(index, list.size())) {
            return list.get(index);
        }
        return null;
    }

    public long getWidgetId(int index) {
        Widget widget = getWidget(index);
        if (widget == null) {
            return 0L;
        }
        return widget.widget_id.longValue();
    }

    public AdPrivacy getadPrivacy() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return null;
        }
        return material.ad_privacy;
    }

    public int getsubInteractionType() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return 0;
        }
        return material.sub_interaction_type.intValue();
    }

    public boolean hasEndCard() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return false;
        }
        return material.has_endcard.booleanValue();
    }

    public boolean isCatchVideo() {
        return this.catchVideo;
    }

    public boolean isClickAutoCloseSplash() {
        return false;
    }

    public boolean isDisable_download_listener() {
        AdSetting adSetting = getAdSetting();
        if (adSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(adSetting.disable_download_listener, false)).booleanValue();
    }

    public boolean isDisablexRequestWith() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(slotAdSetting.disable_x_requested_with, false)).booleanValue();
    }

    public boolean isDislikeReported() {
        return this.isDislikeReported;
    }

    public boolean isDownloadDialog() {
        MaterialMeta material = getMaterial();
        if (material == null) {
            return false;
        }
        return material.download_dialog.booleanValue();
    }

    public boolean isEndCardIndexExist() {
        if (m.a((CharSequence) getEndcard_url())) {
            return true;
        }
        if (getCreativeType() == l.CreativeTypeVideo_Tar.a() || getCreativeType() == l.CreativeTypeVideo_Tar_Companion.a()) {
            return new File(getEndCardIndexPath()).exists();
        }
        return true;
    }

    public boolean isExpiredAd() {
        long jIntValue = getAdExpiredTime().intValue();
        return (jIntValue == 0 || this.create_time == 0 || System.currentTimeMillis() - this.create_time < jIntValue) ? false : true;
    }

    public boolean isHalfInterstitial() {
        return this.isHalfInterstitial;
    }

    public boolean isNativeAdH5() {
        return true;
    }

    public boolean isRecord() {
        return this.record;
    }

    public boolean isResumableDownload() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting == null) {
            return false;
        }
        return ((Boolean) Wire.get(slotAdSetting.resumable_download, false)).booleanValue();
    }

    public boolean isSkipSigmobBrowser() {
        AdSetting adSetting = getAdSetting();
        return (adSetting == null || ((Boolean) Wire.get(adSetting.in_app, false)).booleanValue()) ? false : true;
    }

    public boolean isUse_floating_btn() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting == null) {
            return false;
        }
        return splashAdSetting.use_floating_btn.booleanValue();
    }

    public boolean isValid(int interactionType) {
        return (interactionType == 1 && m.b(getDeeplinkUrl())) || interactionType == 9;
    }

    public boolean isVideoExist() {
        if (m.a((CharSequence) getVideo_url())) {
            return true;
        }
        String videoPath = getVideoPath();
        boolean zExists = new File(videoPath).exists();
        SigmobLog.d("isVideoExist path :" + videoPath + " isExist: " + zExists);
        return zExists;
    }

    public boolean noHasDownloadDialog() {
        return ((getInteractionType() == 2 || getInteractionType() == 3) && getadPrivacy() != null && isDownloadDialog()) ? false : true;
    }

    public String resourcePath() {
        return (m.a((CharSequence) getEndcard_url()) || !(getCreativeType() == l.CreativeTypeVideo_Tar.a() || getCreativeType() == l.CreativeTypeVideo_Tar_Companion.a())) ? !m.a((CharSequence) getHtmlData()) ? getHtmlData() : getHtmlUrl() : getEndCardIndexPath();
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void setAdSize(int width, int height) {
        this.adWidth = width;
        this.adHeight = height;
        getMacroCommon().addMarcoKey(SigMacroCommon._WIDTH_, String.valueOf(width));
        getMacroCommon().addMarcoKey(SigMacroCommon._HEIGHT_, String.valueOf(height));
    }

    public void setAd_scene_desc(String ad_scene_desc) {
        this.ad_scene_desc = ad_scene_desc;
    }

    public void setAd_scene_id(String ad_scene_id) {
        this.ad_scene_id = ad_scene_id;
    }

    public void setAd_source_channel(String ad_source_channel) {
        this.ad_source_channel = ad_source_channel;
    }

    public void setAd_type(int ad_type) {
        this.ad_type = ad_type;
    }

    public void setAdslot_id(String adslot_id) {
        this.adslot_id = adslot_id;
    }

    public void setAdx_id(String adx_id) {
        this.adx_id = adx_id;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public void setApkPackageName(String packageName) {
        this.apkPackageName = packageName;
    }

    public void setBid_token(String bid_token) {
        this.bid_token = bid_token;
    }

    public void setCamp_id(String camp_id) {
        this.camp_id = camp_id;
    }

    public void setCatchVideo(boolean catchVideo) {
        this.catchVideo = catchVideo;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public void setCrid(String crid) {
        this.crid = crid;
    }

    public void setCustomAndroidMarket(AndroidMarket mCustomAndroidMarket) {
        this.mCustomAndroidMarket = mCustomAndroidMarket;
    }

    public void setCustomDeeplink(String mCustomDeeplink) {
        this.mCustomDeeplink = mCustomDeeplink;
    }

    public void setCustomLandPageUrl(String mCustomLandPageUrl) {
        this.mCustomLandPageUrl = mCustomLandPageUrl;
    }

    public void setDeeplinkUri(Uri uri) {
        this.deeplinkUri = uri;
    }

    public void setDownloadId(Long downloadId) {
        this.downloadId = downloadId;
    }

    public void setDownloadQuarterTrack(List<d> tracks) {
        this.download_trackers = tracks;
    }

    public void setDownloadTask(f task) {
        this.downloadTask = task;
    }

    public void setDownloadUrl(String url) {
        this.downloadUrl = url;
    }

    public void setEndcard_md5(String endcard_md5) {
        this.endcard_md5 = endcard_md5;
    }

    public void setHalfInterstitial(boolean halfInterstitial) {
        this.isHalfInterstitial = halfInterstitial;
    }

    public void setLoad_id(String load_id) {
        this.load_id = load_id;
    }

    public void setMacroCommon(SigMacroCommon macroCommon) {
        this.macroCommon = macroCommon;
    }

    public void setMraidInteractionType(int interactionType) {
        this.mraidInteractionType = interactionType;
    }

    public void setOriginVid(String originVid) {
        this.originVid = originVid;
    }

    public void setRecord(boolean record) {
        this.record = record;
    }

    public void setRequestSceneType(int requestSceneType) {
        this.requestSceneType = requestSceneType;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public void setRvCallBackUrl(String rv_callback_url) {
        this.rv_callback_url = rv_callback_url;
    }

    public void setSessionManager(af sessionManager) {
        this.mSessionManager = sessionManager;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public void setUrl(String url) {
        this.landUrl = url;
    }

    public void setVideo_md5(String video_md5) {
        this.video_md5 = video_md5;
    }

    public void updateRealAdPercent(double adPercent) {
        this.realAdPercent = adPercent;
    }
}
