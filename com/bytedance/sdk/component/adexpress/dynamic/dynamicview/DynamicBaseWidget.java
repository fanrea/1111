package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.an;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.utils.de;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.animation.view.hc, c, u {
    protected float an;
    protected float b;
    protected float c;
    protected boolean cb;
    private float d;
    private boolean de;
    protected View e;
    protected int gb;
    protected int h;
    private float hc;
    private float jh;
    protected DynamicRootView k;
    protected Context mk;
    protected h mq;
    private float rf;
    private de sy;
    protected int tc;
    protected int tt;
    protected float u;
    protected gb uo;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.d.hc w;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.d yo;
    private static final View.OnTouchListener v = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener np = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hc
    public float getShineValue() {
        return this.hc;
    }

    public void setShineValue(float f) {
        this.hc = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hc
    public float getRippleValue() {
        return this.d;
    }

    public void setRippleValue(float f) {
        this.d = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hc
    public float getMarqueeValue() {
        return this.rf;
    }

    public void setMarqueeValue(float f) {
        this.rf = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.jh;
    }

    public void setStretchValue(float f) {
        this.jh = f;
        this.yo.d(this, f);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context);
        this.de = true;
        this.mk = context;
        this.k = dynamicRootView;
        this.uo = gbVar;
        this.b = gbVar.an();
        this.c = gbVar.h();
        this.u = gbVar.gb();
        this.an = gbVar.tt();
        this.tt = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.b);
        this.tc = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.c);
        this.h = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.u);
        this.gb = (int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.an);
        h hVar = new h(gbVar.tc());
        this.mq = hVar;
        if (hVar.yo() > 0) {
            this.h += this.mq.yo() * 2;
            this.gb += this.mq.yo() * 2;
            this.tt -= this.mq.yo();
            this.tc -= this.mq.yo();
            List<gb> listMk = gbVar.mk();
            if (listMk != null) {
                for (gb gbVar2 : listMk) {
                    gbVar2.b(gbVar2.an() + com.bytedance.sdk.component.adexpress.c.gb.hc(this.mk, this.mq.yo()));
                    gbVar2.c(gbVar2.h() + com.bytedance.sdk.component.adexpress.c.gb.hc(this.mk, this.mq.yo()));
                    gbVar2.d(com.bytedance.sdk.component.adexpress.c.gb.hc(this.mk, this.mq.yo()));
                    gbVar2.hc(com.bytedance.sdk.component.adexpress.c.gb.hc(this.mk, this.mq.yo()));
                }
            }
        }
        this.cb = this.mq.k() > 0.0d;
        this.yo = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.d();
    }

    public void setShouldInvisible(boolean z) {
        this.cb = z;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.cb;
    }

    public boolean d() throws JSONException {
        gb();
        u();
        b();
        return true;
    }

    public void d(int i) {
        h hVar = this.mq;
        if (hVar != null && hVar.d(i)) {
            gb();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).d(i);
                }
            }
        }
    }

    protected boolean b() throws JSONException {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.e;
        if (view == null) {
            view = this;
        }
        if (c()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = v;
            onClickListener = np;
        }
        if (onTouchListener != null && onClickListener != null) {
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
            int iD = com.bytedance.sdk.component.adexpress.dynamic.hc.d.d(this.mq);
            if (iD == 2 || iD == 3) {
                view.setOnClickListener(np);
            } else {
                view.setOnClickListener(onClickListener);
            }
        }
        d(view);
        hc(view);
        return true;
    }

    protected void d(View view) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.uo.gb());
            jSONObject.put("height", this.uo.tt());
            if (com.bytedance.sdk.component.adexpress.c.d()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.d.jh, this.mq.r());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.d.sy, this.uo.tc().getType());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.d.de, this.uo.b());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.d.v, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.mq.r());
            view.setTag(2097610715, this.uo.tc().getType());
            view.setTag(2097610714, this.uo.b());
            view.setTag(2097610713, jSONObject.toString());
            int iD = com.bytedance.sdk.component.adexpress.dynamic.hc.d.d(this.mq);
            if (iD == 1) {
                view.setTag(2097610707, new Pair(this.mq.yi(), Long.valueOf(this.mq.he())));
                view.setTag(2097610708, Integer.valueOf(iD));
            }
        } catch (JSONException e) {
            mq.d(e);
        }
    }

    protected void hc(View view) {
        an anVarU;
        gb gbVar = this.uo;
        if (gbVar == null || (anVarU = gbVar.tc().u()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(anVarU.zk()));
    }

    public boolean c() {
        h hVar = this.mq;
        return (hVar == null || hVar.vv() == 0) ? false : true;
    }

    public void u() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.h, this.gb);
        layoutParams.topMargin = this.tc;
        layoutParams.leftMargin = this.tt;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    public int getClickArea() {
        return this.mq.vv();
    }

    public String getImageObjectFit() {
        return this.mq.xp();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.u.d getDynamicClickListener() {
        return this.k.getDynamicClickListener();
    }

    protected Drawable getBackgroundDrawable() {
        return d(false, "");
    }

    protected Drawable d(boolean z, String str) throws NumberFormatException {
        String[] strArrSplit;
        int[] iArr;
        int iZw;
        if (!TextUtils.isEmpty(this.mq.mt())) {
            try {
                String strMt = this.mq.mt();
                String strSubstring = strMt.substring(strMt.indexOf("(") + 1, strMt.length() - 1);
                if (strSubstring.contains("rgba") && strSubstring.contains("%")) {
                    strArrSplit = new String[]{strSubstring.substring(0, strSubstring.indexOf(",")).trim(), strSubstring.substring(strSubstring.indexOf(",") + 1, strSubstring.indexOf("%") + 1).trim(), strSubstring.substring(strSubstring.indexOf("%") + 2).trim()};
                    iArr = new int[]{h.d(strArrSplit[1]), h.d(strArrSplit[2])};
                } else {
                    strArrSplit = strSubstring.split(", ");
                    iArr = new int[]{h.d(strArrSplit[1].substring(0, 7)), h.d(strArrSplit[2].substring(0, 7))};
                }
                try {
                    double d = Double.parseDouble(strSubstring.substring(strSubstring.indexOf("linear-gradient(") + 1, strSubstring.indexOf("deg")));
                    if (d > 225.0d && d < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable gradientDrawableD = d(d(strArrSplit[0]), iArr);
                gradientDrawableD.setShape(0);
                gradientDrawableD.setCornerRadius(com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.e()));
                return gradientDrawableD;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float fD = com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.e());
        drawable.setCornerRadius(fD);
        if (fD < 1.0f) {
            float fD2 = com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.s());
            float fD3 = com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.us());
            float fD4 = com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.z());
            float fD5 = com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.fs());
            float[] fArr = new float[8];
            if (fD2 > 0.0f) {
                fArr[0] = fD2;
                fArr[1] = fD2;
            }
            if (fD3 > 0.0f) {
                fArr[2] = fD3;
                fArr[3] = fD3;
            }
            if (fD4 > 0.0f) {
                fArr[4] = fD4;
                fArr[5] = fD4;
            }
            if (fD5 > 0.0f) {
                fArr[6] = fD5;
                fArr[7] = fD5;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            iZw = Color.parseColor(str);
        } else {
            iZw = this.mq.zw();
        }
        drawable.setColor(iZw);
        if (this.mq.w() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.w()), this.mq.cb());
            return drawable;
        }
        if (this.mq.yo() <= 0) {
            return drawable;
        }
        drawable.setStroke(this.mq.yo(), this.mq.cb());
        drawable.setAlpha(50);
        if (!TextUtils.equals(this.uo.tc().getType(), "video-vd")) {
            return drawable;
        }
        setLayerType(1, null);
        return new b((int) fD, this.mq.yo());
    }

    protected hc d(Bitmap bitmap) {
        return new d(bitmap, null);
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(d(hc(this.mq.mt().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    private Drawable[] d(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = strArrSplit.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = h.d(strArrSplit[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable gradientDrawableD = d(d(strArrSplit[0]), iArr);
                gradientDrawableD.setShape(0);
                gradientDrawableD.setCornerRadius(com.bytedance.sdk.component.adexpress.c.gb.d(this.mk, this.mq.e()));
                drawableArr[(list.size() - 1) - i] = gradientDrawableD;
            }
        }
        return drawableArr;
    }

    private List<String> hc(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && i - 1 == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    protected GradientDrawable d(GradientDrawable.Orientation orientation, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return new GradientDrawable();
        }
        if (iArr.length == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iArr[0]);
            return gradientDrawable;
        }
        return new GradientDrawable(orientation, iArr);
    }

    protected GradientDrawable.Orientation d(String str) {
        try {
            int i = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (i <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (i <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (i <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.yo.d(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.d dVar = this.yo;
        View view = this.e;
        if (view == null) {
            view = this;
        }
        dVar.d(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        an();
        tt();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.sy != null) {
            DynamicRootView dynamicRootView = this.k;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.sy.d(0);
                    return;
                } else {
                    this.sy.hc(0);
                    return;
                }
            }
            if (z) {
                this.sy.d(this.k.getRenderRequest().j());
            } else {
                this.sy.hc(this.k.getRenderRequest().j());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        hc();
        super.onDetachedFromWindow();
        if (this.sy != null) {
            DynamicRootView dynamicRootView = this.k;
            if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                this.sy.hc(this.k.getRenderRequest().j());
            } else {
                this.sy.hc(0);
            }
        }
    }

    public void an() {
        if (h()) {
            return;
        }
        View view = this.e;
        if (view == null) {
            view = this;
        }
        com.bytedance.sdk.component.adexpress.dynamic.animation.d.hc hcVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.d.hc(view, this.uo.tc().u().p());
        this.w = hcVar;
        hcVar.d();
    }

    public void hc() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.d.hc hcVar = this.w;
        if (hcVar != null) {
            hcVar.hc();
        }
    }

    protected boolean h() {
        gb gbVar = this.uo;
        return gbVar == null || gbVar.tc() == null || this.uo.tc().u() == null || this.uo.tc().u().p() == null;
    }

    public int getDynamicWidth() {
        return this.h;
    }

    public int getDynamicHeight() {
        return this.gb;
    }

    public an getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.b.u uVarTc;
        gb gbVar = this.uo;
        if (gbVar == null || (uVarTc = gbVar.tc()) == null) {
            return null;
        }
        return uVarTc.u();
    }

    private void tt() {
        if (isShown()) {
            int iD = com.bytedance.sdk.component.adexpress.dynamic.hc.d.d(this.mq);
            if (iD == 2) {
                if (this.sy == null) {
                    this.sy = new de(getContext().getApplicationContext(), 1, this.de);
                }
                this.sy.d(new de.d() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.3
                    @Override // com.bytedance.sdk.component.utils.de.d
                    public void d(int i) {
                        if (i == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.tc();
                        }
                    }
                });
                uo renderRequest = this.k.getRenderRequest();
                if (renderRequest != null) {
                    this.sy.d(renderRequest.yo());
                    this.sy.u(renderRequest.np());
                    this.sy.b(renderRequest.de());
                    this.sy.hc(renderRequest.jh());
                    this.sy.an(renderRequest.yi());
                    this.sy.d(renderRequest.sy());
                    this.sy.hc(renderRequest.v());
                }
            } else if (iD == 3) {
                if (this.sy == null) {
                    this.sy = new de(getContext().getApplicationContext(), 2, this.de);
                }
                this.sy.d(new de.d() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.4
                    @Override // com.bytedance.sdk.component.utils.de.d
                    public void d(int i) {
                        if (i == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.tc();
                        }
                    }
                });
                uo renderRequest2 = this.k.getRenderRequest();
                if (renderRequest2 != null) {
                    this.sy.hc(renderRequest2.jh());
                    this.sy.an(renderRequest2.yi());
                    this.sy.d(renderRequest2.sy());
                    this.sy.hc(renderRequest2.v());
                }
            }
            de deVar = this.sy;
            if (deVar != null) {
                DynamicRootView dynamicRootView = this.k;
                if (dynamicRootView != null) {
                    uo renderRequest3 = dynamicRootView.getRenderRequest();
                    if (renderRequest3 != null) {
                        this.sy.d(renderRequest3.j());
                        return;
                    }
                    return;
                }
                deVar.d(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc() {
        try {
            View view = this.e;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(np);
        } catch (Exception unused) {
        }
    }

    public void setCanUseSensor(boolean z) {
        this.de = z;
    }
}
