package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.sdk.component.adexpress.c.an;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.c.tt;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.an.cb;
import com.bytedance.sdk.component.an.mk;
import com.bytedance.sdk.component.an.tc;
import com.bytedance.sdk.component.utils.np;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String jh = "";
    private Runnable d;
    private ImageView de;
    private Runnable hc;
    protected InteractViewContainer rf;
    private volatile boolean sy;

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.sy = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = gbVar.tc().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.gb - ((int) com.bytedance.sdk.component.adexpress.c.gb.d(context, this.mq.hc() + this.mq.d())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.gb - ((int) com.bytedance.sdk.component.adexpress.c.gb.d(context, this.mq.hc() + this.mq.d())));
        }
    }

    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.h, this.gb);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.c
    public boolean gb() {
        Drawable backgroundDrawable;
        JSONObject jSONObjectOptJSONObject;
        final View view = this.e == null ? this : this.e;
        setContentDescription(this.uo.d(this.mq.vv()));
        String strGw = this.mq.gw();
        String strVv = null;
        String strD = (TextUtils.isEmpty(strGw) || this.k == null || this.k.getRenderRequest() == null || this.k.getRenderRequest().u() == null || (jSONObjectOptJSONObject = this.k.getRenderRequest().u().optJSONObject("creative")) == null) ? null : d(jSONObjectOptJSONObject.opt(strGw));
        if (TextUtils.isEmpty(strD)) {
            strD = this.mq.sy();
        }
        if (this.mq.jh() && Build.VERSION.SDK_INT >= 17) {
            com.bytedance.sdk.component.adexpress.d.d.d.d().u().d(this.mq.hc).b(2).d(new b(this.mk, this.mq.rf())).d(new hc(view, this));
        } else if (!TextUtils.isEmpty(strD)) {
            if (!strD.startsWith("http:") && !strD.startsWith("https:")) {
                if (this.k != null && this.k.getRenderRequest() != null) {
                    strVv = this.k.getRenderRequest().vv();
                }
                strD = tt.hc(strD, strVv);
            }
            tc tcVarB = com.bytedance.sdk.component.adexpress.d.d.d.d().u().d(strD).b(2);
            d(tcVarB);
            if (!com.bytedance.sdk.component.adexpress.c.d()) {
                if ((view instanceof FrameLayout) && TextUtils.equals(this.uo.tc().getType(), "vessel")) {
                    if (com.bytedance.sdk.component.adexpress.c.tc.hc(strD)) {
                        this.de = new GifView(this.mk);
                    } else {
                        this.de = new ImageView(this.mk);
                    }
                    ((FrameLayout) view).addView(this.de, new FrameLayout.LayoutParams(-1, -1));
                    tcVarB.b(3).d(new cb() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.1
                        @Override // com.bytedance.sdk.component.an.cb
                        @ATSMethod(2)
                        public void d(int i, String str, Throwable th) {
                        }

                        @Override // com.bytedance.sdk.component.an.cb
                        @ATSMethod(1)
                        public void d(mk mkVar) {
                            Object objB = mkVar.b();
                            if (objB instanceof byte[]) {
                                an.hc(DynamicBaseWidgetImp.this.de, (byte[]) objB, DynamicBaseWidgetImp.this.h, DynamicBaseWidgetImp.this.gb);
                            }
                        }
                    }, 4);
                } else {
                    d(tcVarB, view);
                }
            } else {
                tcVarB.d(new d(view, this.k, this.uo));
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.mq.j() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.mq.ba() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable drawableHc = dynamicBaseWidgetImp.hc(dynamicBaseWidgetImp.k.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.mq.ba())));
                            if (drawableHc == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                drawableHc = dynamicBaseWidgetImp2.d(true, dynamicBaseWidgetImp2.k.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.mq.ba())));
                            }
                            if (drawableHc != null) {
                                view.setBackground(drawableHc);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.d(true, dynamicBaseWidgetImp3.k.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.mq.j() * 1000.0d));
        }
        if (this.e != null) {
            this.e.setPadding((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.b()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.hc()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.c()), (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.d()));
        }
        if (this.cb || this.mq.k() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    private static class b implements com.bytedance.sdk.component.an.gb {
        private final WeakReference<Context> d;
        private final int hc;

        public b(Context context, int i) {
            this.d = new WeakReference<>(context);
            this.hc = i;
        }

        @Override // com.bytedance.sdk.component.an.gb
        @ATSMethod(1)
        public Bitmap d(Bitmap bitmap) {
            Context context = this.d.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.c.hc.d(context, bitmap, this.hc);
            }
            return null;
        }
    }

    private static class hc implements cb<Bitmap> {
        private final WeakReference<View> d;
        private final WeakReference<DynamicBaseWidget> hc;

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(2)
        public void d(int i, String str, Throwable th) {
        }

        public hc(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.d = new WeakReference<>(view);
            this.hc = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(1)
        public void d(mk<Bitmap> mkVar) {
            Bitmap bitmapB;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.d.get();
            if (view == null || (bitmapB = mkVar.b()) == null || mkVar.c() == null || (dynamicBaseWidget = this.hc.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.d(bitmapB));
        }
    }

    private static class d implements cb<Bitmap> {
        private final gb b;
        private final WeakReference<View> d;
        private final WeakReference<DynamicRootView> hc;

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(2)
        public void d(int i, String str, Throwable th) {
        }

        public d(View view, DynamicRootView dynamicRootView, gb gbVar) {
            this.d = new WeakReference<>(view);
            this.hc = new WeakReference<>(dynamicRootView);
            this.b = gbVar;
        }

        @Override // com.bytedance.sdk.component.an.cb
        @ATSMethod(1)
        public void d(mk<Bitmap> mkVar) {
            View view = this.d.get();
            if (!com.bytedance.sdk.component.adexpress.c.d()) {
                DynamicRootView dynamicRootView = this.hc.get();
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().an()) && !"splash_ad".equals(dynamicRootView.getRenderRequest().an())) {
                    view.setBackground(new BitmapDrawable(mkVar.b()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(mkVar.b()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(mkVar.b()));
            gb gbVar = this.b;
            if (gbVar == null || gbVar.tc() == null || 6 != this.b.tc().d() || Build.VERSION.SDK_INT < 19 || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    private String d(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return d(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return d((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void d(tc tcVar, final View view) {
        tcVar.d(new cb<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.3
            @Override // com.bytedance.sdk.component.an.cb
            @ATSMethod(2)
            public void d(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.an.cb
            @ATSMethod(1)
            public void d(mk<Bitmap> mkVar) {
                if (DynamicBaseWidgetImp.this.k == null) {
                    return;
                }
                if (!"open_ad".equals(DynamicBaseWidgetImp.this.k.getRenderRequest().an()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.k.getRenderRequest().an())) {
                    view.setBackground(new BitmapDrawable(mkVar.b()));
                } else {
                    if (com.bytedance.sdk.component.adexpress.c.d()) {
                        view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d(mkVar.b(), ((DynamicRoot) DynamicBaseWidgetImp.this.k.getChildAt(0)).d));
                        return;
                    }
                    view.setBackground(new BitmapDrawable(mkVar.b()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable hc(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String string = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    string = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = h.d(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable gradientDrawableD = d(d(string), iArr);
            gradientDrawableD.setShape(0);
            gradientDrawableD.setCornerRadius(com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.e()));
            return gradientDrawableD;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void d(tc tcVar) {
        if (DeviceUtils.ROM_SMARTISAN.equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            tcVar.d(Bitmap.Config.ARGB_8888);
        }
    }

    private static String getBuildModel() {
        try {
            jh = np.d();
        } catch (Throwable unused) {
            jh = Build.MODEL;
        }
        if (TextUtils.isEmpty(jh)) {
            jh = Build.MODEL;
        }
        return jh;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View view = this.e == null ? this : this.e;
        double dJh = this.uo.tc().u().jh();
        if (dJh < 90.0d && dJh > 0.0d) {
            com.bytedance.sdk.component.utils.gb.hc().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (dJh * 1000.0d));
        }
        d(this.uo.tc().u().rf(), view);
        if (!TextUtils.isEmpty(this.mq.tr())) {
            tt();
        }
        super.onAttachedToWindow();
    }

    private void d(double d2, final View view) {
        if (d2 > 0.0d) {
            com.bytedance.sdk.component.utils.gb.hc().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.uo.tc().u().p() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d2 * 1000.0d));
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.d);
            removeCallbacks(this.hc);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }

    private void tt() {
        if (this.sy) {
            int iRu = this.mq.ru();
            int iYn = this.mq.yn();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.k != null && DynamicBaseWidgetImp.this.k.getRenderRequest() != null) {
                        uo renderRequest = DynamicBaseWidgetImp.this.k.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.b.tc tcVar = new com.bytedance.sdk.component.adexpress.dynamic.b.tc();
                        tcVar.d(renderRequest.yo());
                        tcVar.hc(renderRequest.rf());
                        tcVar.b(renderRequest.jh());
                        tcVar.d(renderRequest.sy());
                        tcVar.hc(renderRequest.de());
                        tcVar.b(renderRequest.v());
                        tcVar.c(renderRequest.np());
                        tcVar.u(renderRequest.yi());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        Context context = DynamicBaseWidgetImp.this.mk;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.rf = new InteractViewContainer(context, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.mq, tcVar, renderRequest);
                    } else {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        Context context2 = DynamicBaseWidgetImp.this.mk;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.rf = new InteractViewContainer(context2, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.mq);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.hc(dynamicBaseWidgetImp5.rf);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.rf.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.d((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.rf, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.rf.b();
                }
            };
            this.d = runnable;
            postDelayed(runnable, iRu * 1000);
            if (this.mq.l() || iYn >= Integer.MAX_VALUE || iRu >= iYn) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.rf != null) {
                        DynamicBaseWidgetImp.this.sy = false;
                        DynamicBaseWidgetImp.this.rf.c();
                        DynamicBaseWidgetImp.this.rf.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.removeView(dynamicBaseWidgetImp.rf);
                    }
                }
            };
            this.hc = runnable2;
            postDelayed(runnable2, iYn * 1000);
        }
    }
}
