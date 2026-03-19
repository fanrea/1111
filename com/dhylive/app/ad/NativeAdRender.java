package com.dhylive.app.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dhylive.app.R;
import com.dhylive.app.utils.ExtensionKt;
import com.tkruntime.v8.V8Trace;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdRender.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\fH\u0017J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0002H\u0017J\u0012\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/dhylive/app/ad/NativeAdRender;", "Lcom/windmill/sdk/natives/WMNativeAdRender;", "Lcom/windmill/sdk/natives/WMNativeAdData;", "()V", "adChoice", "Landroid/widget/RelativeLayout;", "adLogo", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "developViewMap", "", "", "Landroid/view/View;", "img1", "img2", "img3", "imgDislike", "imgLogo", "mButtonsContainer", "mCTAButton", "Landroid/widget/Button;", "mImagePoster", "mMediaViewLayout", "Landroid/widget/FrameLayout;", "mPauseButton", "mPlayButton", "mStopButton", "native3imgAdContainer", "Landroid/widget/LinearLayout;", "textDesc", "Landroid/widget/TextView;", "textTitle", V8Trace.SECTION_CREATE_VIEW, "adPatternType", "renderAdView", "", "view", "adData", "updateAdAction", "ctaText", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class NativeAdRender implements WMNativeAdRender<WMNativeAdData> {
    private RelativeLayout adChoice;
    private ImageView adLogo;
    private Context context;
    private final Map<Integer, View> developViewMap = new HashMap();
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView imgDislike;
    private ImageView imgLogo;
    private View mButtonsContainer;
    private Button mCTAButton;
    private ImageView mImagePoster;
    private FrameLayout mMediaViewLayout;
    private Button mPauseButton;
    private Button mPlayButton;
    private Button mStopButton;
    private LinearLayout native3imgAdContainer;
    private TextView textDesc;
    private TextView textTitle;

    public View createView(Context context, int adPatternType) {
        View viewInflate;
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d("lance", "---------createView----------" + adPatternType);
        this.context = context;
        View view = this.developViewMap.get(Integer.valueOf(adPatternType));
        if (view == null) {
            if (adPatternType == 1) {
                viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_native_ad_small, (ViewGroup) null);
            } else {
                viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_native_ad_normal, (ViewGroup) null);
            }
            view = viewInflate;
            this.developViewMap.put(Integer.valueOf(adPatternType), view);
        }
        Intrinsics.checkNotNull(view);
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
        return view;
    }

    public void renderAdView(View view, final WMNativeAdData adData) {
        Context context;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adData, "adData");
        Log.d("lance", "renderAdView:" + adData.getTitle());
        this.imgLogo = (ImageView) view.findViewById(R.id.img_logo);
        this.adLogo = (ImageView) view.findViewById(R.id.channel_ad_logo);
        this.adChoice = (RelativeLayout) view.findViewById(R.id.channel_ad_choice);
        this.imgDislike = (ImageView) view.findViewById(R.id.iv_dislike);
        this.textDesc = (TextView) view.findViewById(R.id.text_desc);
        this.mButtonsContainer = view.findViewById(R.id.video_btn_container);
        this.mPlayButton = (Button) view.findViewById(R.id.btn_play);
        this.mPauseButton = (Button) view.findViewById(R.id.btn_pause);
        this.mStopButton = (Button) view.findViewById(R.id.btn_stop);
        this.mMediaViewLayout = (FrameLayout) view.findViewById(R.id.media_layout);
        this.mImagePoster = (ImageView) view.findViewById(R.id.img_poster);
        this.native3imgAdContainer = (LinearLayout) view.findViewById(R.id.native_3img_ad_container);
        this.img1 = (ImageView) view.findViewById(R.id.img_1);
        this.img2 = (ImageView) view.findViewById(R.id.img_2);
        this.img3 = (ImageView) view.findViewById(R.id.img_3);
        this.textTitle = (TextView) view.findViewById(R.id.text_title);
        this.mCTAButton = (Button) view.findViewById(R.id.btn_cta);
        if (!TextUtils.isEmpty(adData.getIconUrl())) {
            ImageView imageView = this.imgLogo;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.imgLogo;
            if (imageView2 != null) {
                ExtensionKt.loadImage$default(imageView2, adData.getIconUrl(), 0, (Function0) null, 6, (Object) null);
            }
        }
        if (!TextUtils.isEmpty(adData.getTitle())) {
            TextView textView = this.textTitle;
            if (textView != null) {
                textView.setText(adData.getTitle());
            }
        } else {
            TextView textView2 = this.textTitle;
            if (textView2 != null) {
                textView2.setText("点开有惊喜");
            }
        }
        if (!TextUtils.isEmpty(adData.getDesc())) {
            TextView textView3 = this.textDesc;
            if (textView3 != null) {
                textView3.setText(adData.getDesc());
            }
        } else {
            TextView textView4 = this.textDesc;
            if (textView4 != null) {
                textView4.setText("听说点开它的人都交了好运!");
            }
        }
        if (adData.getAdLogo() != null) {
            ImageView imageView3 = this.adLogo;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.adLogo;
            if (imageView4 != null) {
                imageView4.setImageBitmap(adData.getAdLogo());
            }
        } else {
            ImageView imageView5 = this.adLogo;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
        }
        if (adData.getAdChoice() != null) {
            RelativeLayout relativeLayout = this.adChoice;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            RelativeLayout relativeLayout2 = this.adChoice;
            if (relativeLayout2 != null) {
                relativeLayout2.removeAllViews();
            }
            RelativeLayout relativeLayout3 = this.adChoice;
            if (relativeLayout3 != null) {
                relativeLayout3.addView(adData.getAdChoice());
            }
        } else {
            RelativeLayout relativeLayout4 = this.adChoice;
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(8);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.mCTAButton);
        ArrayList arrayList3 = new ArrayList();
        int adPatternType = adData.getAdPatternType();
        Log.d("lance", "patternType:" + adPatternType);
        if (adPatternType == 1 || adPatternType == 2) {
            ImageView imageView6 = this.mImagePoster;
            if (imageView6 != null) {
                imageView6.setVisibility(0);
            }
            View view2 = this.mButtonsContainer;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            LinearLayout linearLayout = this.native3imgAdContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FrameLayout frameLayout = this.mMediaViewLayout;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            arrayList.add(this.mImagePoster);
            arrayList3.add(this.mImagePoster);
        } else if (adPatternType == 3) {
            LinearLayout linearLayout2 = this.native3imgAdContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            ImageView imageView7 = this.mImagePoster;
            if (imageView7 != null) {
                imageView7.setVisibility(8);
            }
            View view3 = this.mButtonsContainer;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            FrameLayout frameLayout2 = this.mMediaViewLayout;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            arrayList.add(this.native3imgAdContainer);
            arrayList3.add(this.img1);
            arrayList3.add(this.img2);
            arrayList3.add(this.img3);
        }
        Context context2 = this.context;
        Context context3 = null;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        } else {
            context = context2;
        }
        adData.bindViewForInteraction(context, view, arrayList, arrayList2, this.imgDislike);
        if (!arrayList3.isEmpty()) {
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context3 = context4;
            }
            adData.bindImageViews(context3, arrayList3, 0);
        } else if (adPatternType == 4) {
            ImageView imageView8 = this.mImagePoster;
            if (imageView8 != null) {
                imageView8.setVisibility(8);
            }
            LinearLayout linearLayout3 = this.native3imgAdContainer;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            FrameLayout frameLayout3 = this.mMediaViewLayout;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(0);
            }
            Context context5 = this.context;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context3 = context5;
            }
            adData.bindMediaView(context3, this.mMediaViewLayout);
            View view4 = this.mButtonsContainer;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.dhylive.app.ad.NativeAdRender$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    NativeAdRender.renderAdView$lambda$0(this.f$0, adData, view5);
                }
            };
            Button button = this.mPlayButton;
            if (button != null) {
                button.setOnClickListener(onClickListener);
            }
            Button button2 = this.mPauseButton;
            if (button2 != null) {
                button2.setOnClickListener(onClickListener);
            }
            Button button3 = this.mStopButton;
            if (button3 != null) {
                button3.setOnClickListener(onClickListener);
            }
        }
        String cTAText = adData.getCTAText();
        Log.d("lance", "ctaText:" + cTAText);
        updateAdAction(cTAText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderAdView$lambda$0(NativeAdRender nativeAdRender, WMNativeAdData wMNativeAdData, View view) {
        Intrinsics.checkNotNullParameter(nativeAdRender, "this$0");
        Intrinsics.checkNotNullParameter(wMNativeAdData, "$adData");
        if (view == nativeAdRender.mPlayButton) {
            wMNativeAdData.startVideo();
        } else if (view == nativeAdRender.mPauseButton) {
            wMNativeAdData.pauseVideo();
        } else if (view == nativeAdRender.mStopButton) {
            wMNativeAdData.stopVideo();
        }
    }

    private final void updateAdAction(String ctaText) {
        String str = ctaText;
        if (!TextUtils.isEmpty(str)) {
            Button button = this.mCTAButton;
            if (button != null) {
                button.setText(str);
            }
            Button button2 = this.mCTAButton;
            if (button2 == null) {
                return;
            }
            button2.setVisibility(0);
            return;
        }
        Button button3 = this.mCTAButton;
        if (button3 == null) {
            return;
        }
        button3.setVisibility(4);
    }
}
