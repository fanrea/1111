package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.api.SAAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceAdSdk;
import com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData;
import com.alliance.ssp.ad.api.banner.SABannerAd;
import com.alliance.ssp.ad.api.nativead.SANativeFeedAdLoadListener;
import com.alliance.ssp.adapter.tobid.custom.YTNativeAdData;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.dhylive.app.R;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomBannerAdapter;
import com.windmill.sdk.models.BidPrice;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YCustomerBannerNativeAdapter extends WMCustomBannerAdapter {
    private static final String TAG = "YCustomerNativeBanner: ";
    public ImageView adLogoImageView;
    public View adLogoView;
    public TextView appSixElementTxtView;
    private SABannerAd bannerAd;
    private ViewGroup bannerView;
    public ImageView closeBtn;
    public TextView descriptionTextView;
    private String ecpm;
    public Button ldpBtn;
    public FrameLayout mAdContainer;
    public View mContentView;
    public ImageView mainImageView;
    public ViewGroup mediaContainer;
    private SAAllianceAd saAllianceAd;
    public TextView titleTextView;

    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
            return;
        }
        try {
            boolean zOptBoolean = new JSONObject((String) map2.get(GlobalSetting.CUSTOM_INFO_KEY)).optBoolean("isExpressAd");
            if (map != null && map.containsKey("isExpressAd")) {
                zOptBoolean = ((Boolean) map.get("isExpressAd")).booleanValue();
            }
            String str = (String) map2.get("placementId");
            Log.i("Adapter", "load native ad, placementId = " + str + ", isExpressAd ?= " + zOptBoolean);
            if (zOptBoolean) {
                return;
            }
            loadBannerNative(activity, str);
        } catch (Exception e) {
            Log.e("Adapter", "load native ad fail, error = " + e.getMessage());
        }
    }

    public boolean isReady() {
        return this.bannerView != null;
    }

    public void destroyAd() {
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerNativeAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                if (YCustomerBannerNativeAdapter.this.bannerAd != null) {
                    YCustomerBannerNativeAdapter.this.bannerAd.destroy();
                    YCustomerBannerNativeAdapter.this.bannerAd = null;
                }
            }
        });
    }

    public View getBannerView() {
        ViewGroup viewGroup = this.bannerView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Log.e(TAG, "ad view is null, please check if load finish");
        return null;
    }

    private void loadBannerNative(final Context context, final String str) {
        Log.i("Adapter", "加载优推自渲染广告， placementId = " + str);
        YThreadUtils.runOnThreadPool(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerNativeAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m335x2f593633(str, context);
            }
        });
    }

    /* renamed from: lambda$loadBannerNative$0$com-alliance-ssp-adapter-tobid-custom-YCustomerBannerNativeAdapter, reason: not valid java name */
    /* synthetic */ void m335x2f593633(String str, final Context context) {
        SAAllianceAdParams sAAllianceAdParams = new SAAllianceAdParams();
        sAAllianceAdParams.setPosId(str);
        SAAllianceAd sAAllianceAdCreateSAAllianceAd = SAAllianceAdSdk.getSAAllianceAdManager().createSAAllianceAd((Activity) context);
        this.saAllianceAd = sAAllianceAdCreateSAAllianceAd;
        if (sAAllianceAdCreateSAAllianceAd == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "create SAAllianceAd fail"));
        } else {
            sAAllianceAdCreateSAAllianceAd.loadSANativeFeedAd(sAAllianceAdParams, new SANativeFeedAdLoadListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerNativeAdapter.2
                @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                public void onResourceLoad() {
                }

                @Override // com.alliance.ssp.ad.api.nativead.SANativeFeedAdLoadListener
                public void onNativeFeedAdLoad(SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData) {
                    if (sAAllianceNativeFeedAdData == null) {
                        YCustomerBannerNativeAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load fail, ad list is null"));
                        return;
                    }
                    Log.i("Adapter", "优推自渲染广告加载成功，开始创建ToBid实例");
                    YCustomerBannerNativeAdapter yCustomerBannerNativeAdapter = YCustomerBannerNativeAdapter.this;
                    yCustomerBannerNativeAdapter.bannerView = yCustomerBannerNativeAdapter.createLayout(context, new YTNativeAdData(sAAllianceNativeFeedAdData, (Activity) context));
                    YCustomerBannerNativeAdapter.this.callLoadBiddingSuccess(new BidPrice(sAAllianceNativeFeedAdData.getECPM()));
                    YCustomerBannerNativeAdapter.this.callLoadSuccess();
                }

                @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                public void onError(int i, String str2) {
                    Log.i("Adapter", "优推自渲染广告加载失败, error msg = " + str2);
                    Log.e(YCustomerBannerNativeAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                    YCustomerBannerNativeAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                }
            });
        }
    }

    public ViewGroup createLayout(Context context, YTNativeAdData yTNativeAdData) throws JSONException, InterruptedException, PackageManager.NameNotFoundException, IOException {
        Button button;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        String iconUrl = null;
        View viewInflate = View.inflate(context, R.layout.layout_native_banner_ad, null);
        this.mContentView = viewInflate;
        this.mAdContainer = (FrameLayout) viewInflate.findViewById(R.id.native_ad_container);
        this.mediaContainer = (ViewGroup) viewInflate.findViewById(R.id.native_ad_media_container);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.native_ad_main_image_view);
        this.titleTextView = (TextView) viewInflate.findViewById(R.id.native_ad_title_text_view);
        this.descriptionTextView = (TextView) viewInflate.findViewById(R.id.native_ad_description_text_view);
        this.appSixElementTxtView = (TextView) viewInflate.findViewById(R.id.native_ad_six_element_text_view);
        this.adLogoView = viewInflate.findViewById(R.id.native_ad_logo_view);
        this.adLogoImageView = (ImageView) viewInflate.findViewById(R.id.native_ad_logo_image_view);
        this.closeBtn = (ImageView) viewInflate.findViewById(R.id.native_ad_close_btn);
        this.ldpBtn = (Button) viewInflate.findViewById(R.id.native_cta_btn);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        YTNativeAdData.YTNativeADMediaMode feedAdMode = yTNativeAdData.getFeedAdMode();
        if (feedAdMode == YTNativeAdData.YTNativeADMediaMode.Video) {
            this.mainImageView.setVisibility(8);
            this.mediaContainer.setVisibility(0);
        } else if (feedAdMode == YTNativeAdData.YTNativeADMediaMode.OneImage || feedAdMode == YTNativeAdData.YTNativeADMediaMode.OnlyIcon) {
            if (feedAdMode == YTNativeAdData.YTNativeADMediaMode.OneImage && yTNativeAdData.getImageList() != null) {
                iconUrl = yTNativeAdData.getImageList().get(0);
            } else if (yTNativeAdData.getFeedAdMode() == YTNativeAdData.YTNativeADMediaMode.OnlyIcon) {
                iconUrl = yTNativeAdData.getIconUrl();
            }
            if (iconUrl != null) {
                loadImage(iconUrl, this.mainImageView);
            }
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
            arrayList2.add(this.mainImageView);
        }
        ImageView imageView = this.adLogoImageView;
        arrayList.add(this.mainImageView);
        arrayList.add(this.ldpBtn);
        this.adLogoView.setVisibility(0);
        if (yTNativeAdData.getAdLogo() != null) {
            this.adLogoImageView.setImageBitmap(yTNativeAdData.getAdLogo());
        } else if (yTNativeAdData.getAdLogoUrl() != null) {
            loadImage(yTNativeAdData.getAdLogoUrl(), this.adLogoImageView);
        } else {
            this.adLogoView.setVisibility(8);
        }
        if (yTNativeAdData.isDownAPPAd() && yTNativeAdData.getDownAppInfo() != null) {
            setAppSixElementTxt(this.appSixElementTxtView, yTNativeAdData.getDownAppInfo());
            this.appSixElementTxtView.setVisibility(0);
        } else {
            this.appSixElementTxtView.setVisibility(8);
        }
        yTNativeAdData.bindAdToView(this.mAdContainer, null, imageView, arrayList, null, null, this.mediaContainer, arrayList2, new YTNativeAdData.InteractionListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerNativeAdapter.3
            @Override // com.alliance.ssp.adapter.tobid.custom.YTNativeAdData.InteractionListener
            public void onAdShow() {
                Log.i(YCustomerBannerNativeAdapter.TAG, ": 展示");
                YCustomerBannerNativeAdapter.this.callBannerAdShow();
            }

            @Override // com.alliance.ssp.adapter.tobid.custom.YTNativeAdData.InteractionListener
            public void onAdClick() {
                Log.i(YCustomerBannerNativeAdapter.TAG, ": 点击");
                YCustomerBannerNativeAdapter.this.callBannerAdClick();
            }

            @Override // com.alliance.ssp.adapter.tobid.custom.YTNativeAdData.InteractionListener
            public void onAdError(int i, String str) {
                Log.i(YCustomerBannerNativeAdapter.TAG, ": 展示失败, " + str);
                YCustomerBannerNativeAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str));
            }
        });
        if ("".equals(yTNativeAdData.getDescription())) {
            this.descriptionTextView.setVisibility(8);
        } else {
            this.descriptionTextView.setVisibility(0);
        }
        String title = yTNativeAdData.getTitle();
        if (title == null || title.isEmpty()) {
            title = "自渲染广告标题";
        }
        this.titleTextView.setText(title);
        this.descriptionTextView.setText(yTNativeAdData.getDescription());
        if (yTNativeAdData.isDownAPPAd() && (button = this.ldpBtn) != null) {
            button.setText("点击下载");
        }
        this.closeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerNativeAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m334xd8f54555(view);
            }
        });
        frameLayout.addView(viewInflate);
        return frameLayout;
    }

    /* renamed from: lambda$createLayout$1$com-alliance-ssp-adapter-tobid-custom-YCustomerBannerNativeAdapter, reason: not valid java name */
    /* synthetic */ void m334xd8f54555(View view) {
        callBannerAdClosed();
    }

    void setAppSixElementTxt(TextView textView, YTDownAppInfo yTDownAppInfo) {
        textView.setText((CharSequence) null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.add("应用：" + yTDownAppInfo.getAppName());
        arrayList.add("版本：" + yTDownAppInfo.getAppVersionName());
        arrayList.add("开发者：" + yTDownAppInfo.getAuthorName());
        arrayList.add("隐私协议");
        arrayList.add("功能介绍");
        arrayList.add("权限介绍");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(null);
        arrayList2.add(null);
        arrayList2.add(null);
        arrayList2.add(yTDownAppInfo.getPrivacyUrl());
        arrayList2.add(yTDownAppInfo.getAppFunctionUrl());
        arrayList2.add(yTDownAppInfo.getAppPermissionUrl());
        for (int i = 0; i < arrayList.size(); i++) {
            final String str = (String) arrayList.get(i);
            final String str2 = (String) arrayList2.get(i);
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerNativeAdapter.4
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        Log.i(YCustomerBannerNativeAdapter.TAG, "6要素点击：" + str + ", " + str2);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(true);
                        textPaint.setColor(-12541697);
                    }
                }, length, spannableStringBuilder.length(), 33);
            }
            if (i < arrayList.size() - 1) {
                spannableStringBuilder.append((CharSequence) " | ");
            }
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private static void loadImage(final String str, ImageView imageView) throws InterruptedException {
        if (str == null || str.isEmpty()) {
            return;
        }
        final Bitmap[] bitmapArr = new Bitmap[1];
        YThreadUtils.runOnThreadPool(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerNativeAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    bitmapArr[0] = YCustomerBannerNativeAdapter.download(str);
                } catch (Exception unused) {
                }
            }
        });
        try {
            Thread.sleep(500L);
            if (imageView != null) {
                Log.i("Adapter", "bitmap download success");
                imageView.setImageBitmap(bitmapArr[0]);
            } else {
                Log.i("Adapter", "bitmap download fail");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0033 -> B:32:0x0045). Please report as a decompilation issue!!! */
    public static Bitmap download(String str) throws Throwable {
        ?? inputStream;
        Log.i("Adapter", "download: " + str);
        Bitmap bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        bitmapDecodeStream = null;
        ?? r1 = null;
        try {
            try {
            } catch (Exception e) {
                e.printStackTrace();
                str = e;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                inputStream = getURLConnection(str).getInputStream();
            } catch (Exception e2) {
                e = e2;
                inputStream = 0;
            } catch (Throwable th) {
                th = th;
                if (r1 != null) {
                    try {
                        r1.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                str = inputStream;
                if (inputStream != 0) {
                    inputStream.close();
                    str = inputStream;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                str = inputStream;
                if (inputStream != 0) {
                    inputStream.close();
                    str = inputStream;
                }
                return bitmapDecodeStream;
            }
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
            r1 = str;
        }
    }

    private static HttpURLConnection getURLConnection(String str) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str);
            if (url.getProtocol().toLowerCase().equals("https")) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            return httpURLConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
