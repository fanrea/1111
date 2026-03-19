package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.c.an;
import com.bytedance.sdk.component.adexpress.c.tc;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.dynamic.c.tt;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.an.cb;
import com.bytedance.sdk.component.an.e;
import com.bytedance.sdk.component.an.mk;
import com.bytedance.sdk.component.utils.jh;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {
    private String d;

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        if (!TextUtils.isEmpty(this.mq.ar()) && gbVar.rf()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.mq.t());
            dynamicLottieView.setImageLottieTosPath(this.mq.ar());
            dynamicLottieView.setLottieAppNameMaxLength(this.mq.qy());
            dynamicLottieView.setLottieAdTitleMaxLength(this.mq.gv());
            dynamicLottieView.setLottieAdDescMaxLength(this.mq.ph());
            dynamicLottieView.setData(gbVar.jh());
            this.e = dynamicLottieView;
        } else if (this.mq.e() > 0.0f) {
            this.e = new TTRoundRectImageView(context);
            ((TTRoundRectImageView) this.e).setXRound((int) com.bytedance.sdk.component.adexpress.c.gb.d(context, this.mq.e()));
            ((TTRoundRectImageView) this.e).setYRound((int) com.bytedance.sdk.component.adexpress.c.gb.d(context, this.mq.e()));
        } else if (!h() && "arrowButton".equals(gbVar.tc().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.mq);
            this.e = animationImageView;
        } else if (tc.hc(this.mq.mk())) {
            this.e = new GifView(context);
        } else {
            String strMk = this.mq.mk();
            uo renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest != null && renderRequest.hc() != null && TextUtils.equals(strMk, renderRequest.d())) {
                this.e = renderRequest.hc();
            } else {
                this.e = new ImageView(context);
            }
        }
        this.d = hc(this.mq.mk());
        this.e.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(gbVar.tc().getType())) {
            if (this.mq.hc() > 0 || this.mq.d() > 0) {
                this.h = Math.min(this.h, this.gb);
                this.gb = Math.min(this.h, this.gb);
                this.tt = (int) (this.tt + com.bytedance.sdk.component.adexpress.c.gb.d(context, this.mq.hc() + (this.mq.d() / 2) + 0.5f));
            } else {
                this.h = Math.max(this.h, this.gb);
                this.gb = Math.max(this.h, this.gb);
            }
            this.mq.d(this.h / 2);
        }
        addView(this.e, new FrameLayout.LayoutParams(this.h, this.gb));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e instanceof ImageView) {
            Drawable drawable = ((ImageView) this.e).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).start();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.e instanceof ImageView) {
            Drawable drawable = ((ImageView) this.e).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                return;
            }
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() throws Resources.NotFoundException, NumberFormatException {
        super.gb();
        try {
            if (this.e instanceof UpieImageView) {
                this.e.setBackgroundColor(this.mq.zw());
                if (tt() && Build.VERSION.SDK_INT >= 17) {
                    this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    this.e.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        if (!TextUtils.isEmpty(this.mq.ar())) {
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.uo.tc().getType())) {
            ((ImageView) this.e).setImageResource(jh.u(this.mk, "tt_white_righterbackicon_titlebar"));
            if (Build.VERSION.SDK_INT >= 19 && ((ImageView) this.e).getDrawable() != null) {
                ((ImageView) this.e).getDrawable().setAutoMirrored(true);
            }
            this.e.setPadding(0, 0, 0, 0);
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.e.setBackgroundColor(this.mq.zw());
        String strHc = this.uo.tc().hc();
        if ("user".equals(strHc)) {
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.e).setColorFilter(this.mq.h());
            jh.d(getContext(), "tt_user", (ImageView) this.e);
            ((ImageView) this.e).setPadding(this.h / 10, this.gb / 5, this.h / 10, 0);
        } else if (strHc != null && strHc.startsWith("@")) {
            try {
                ((ImageView) this.e).setImageResource(Integer.parseInt(strHc.substring(1)));
            } catch (Exception e) {
                mq.d(e);
            }
        }
        e eVarU = com.bytedance.sdk.component.adexpress.d.d.d.d().u();
        String strMk = this.mq.mk();
        if (!TextUtils.isEmpty(strMk) && !strMk.startsWith("http:") && !strMk.startsWith("https:")) {
            String strVv = null;
            if (this.k != null && this.k.getRenderRequest() != null) {
                strVv = this.k.getRenderRequest().vv();
            }
            strMk = tt.hc(strMk, strVv);
        }
        com.bytedance.sdk.component.an.tc tcVarHc = eVarU.d(strMk).hc(this.d);
        String strW = this.k.getRenderRequest().w();
        if (!TextUtils.isEmpty(strW)) {
            tcVarHc.b(strW);
        }
        if (tt() && Build.VERSION.SDK_INT >= 17) {
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.FIT_CENTER);
            tcVarHc.d(Bitmap.Config.ARGB_4444).b(2).d(new d(this.mk)).d(new hc(this.e, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.c.d()) {
                tcVarHc.d((ImageView) this.e);
            }
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.e instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.e).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.c.d()) {
            d(tcVarHc);
        }
        return true;
    }

    private static class d implements com.bytedance.sdk.component.an.gb {
        private final WeakReference<Context> d;

        public d(Context context) {
            this.d = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.an.gb
        @ATSMethod(1)
        public Bitmap d(Bitmap bitmap) {
            Context context = this.d.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.c.hc.d(context, bitmap, 25);
            }
            return null;
        }
    }

    private static class hc implements cb<Bitmap> {
        private WeakReference<View> d;
        private Resources hc;

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(2)
        public void d(int i, String str, Throwable th) {
        }

        public hc(View view, Resources resources) {
            this.d = new WeakReference<>(view);
            this.hc = resources;
        }

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(1)
        public void d(mk<Bitmap> mkVar) {
            Bitmap bitmapB;
            View view = this.d.get();
            if (view == null || (bitmapB = mkVar.b()) == null || mkVar.c() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.hc, bitmapB));
        }
    }

    private boolean tt() {
        String strMq = this.mq.mq();
        if (this.mq.jh()) {
            return true;
        }
        if (TextUtils.isEmpty(strMq)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strMq);
            return Math.abs((((float) this.h) / (((float) this.gb) * 1.0f)) - (((float) jSONObject.optInt("width")) / (((float) jSONObject.optInt("height")) * 1.0f))) > 0.01f;
        } catch (JSONException e) {
            mq.d(e);
            return false;
        }
    }

    protected String hc(String str) {
        Map<String, String> mapK = this.k.getRenderRequest().k();
        if (mapK == null || mapK.size() <= 0) {
            return null;
        }
        return mapK.get(str);
    }

    private void d(com.bytedance.sdk.component.an.tc tcVar) {
        tcVar.b(3).d(new cb() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.1
            @Override // com.bytedance.sdk.component.an.cb
            @ATSMethod(2)
            public void d(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.an.cb
            @ATSMethod(1)
            public void d(mk mkVar) {
                Object objB = mkVar.b();
                if ((objB instanceof byte[]) && (DynamicImageView.this.e instanceof ImageView)) {
                    an.hc((ImageView) DynamicImageView.this.e, (byte[]) objB, DynamicImageView.this.h, DynamicImageView.this.gb);
                }
            }
        }, 4);
    }
}
