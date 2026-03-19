package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private int an;
    private int c;
    Paint d;
    private int u;
    Path hc = new Path();
    Path b = new Path();

    public d() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
    }

    public void d(Canvas canvas, hc hcVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        if (hcVar.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.d.d.d.d().b() != null) {
                float[] fArrHc = null;
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrHc = h.hc(str);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.d.setColor(Color.parseColor(str));
                    this.d.setAlpha(90);
                } else if (fArrHc != null) {
                    this.d.setColor(gb.d(fArrHc[3] * (1.0f - hcVar.getRippleValue()), fArrHc[0] / 256.0f, fArrHc[1] / 256.0f, fArrHc[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            canvas.drawCircle(this.c, this.u, Math.min(r1, r4) * 2 * hcVar.getRippleValue(), this.d);
        }
        if (hcVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.hc.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.c * 4) + (iIntValue2 * 2)) + (this.u * 2)) * hcVar.getShineValue())) - ((this.u * 2) + iIntValue2);
                float f = shineValue;
                int i = this.u;
                this.d.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i) / 2) + shineValue, i / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.d.setStrokeWidth(this.c * 2);
                Path path = this.b;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i2 = shineValue + iIntValue2;
                canvas.drawLine(f, 0.0f, i2 + r1, this.u, this.d);
            }
        }
        if (hcVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.hc.reset();
                this.hc.moveTo(0.0f, 0.0f);
                this.hc.lineTo(this.c * 2, 0.0f);
                this.hc.lineTo(this.c * 2, this.u * 2);
                this.hc.lineTo(0.0f, this.u * 2);
                this.hc.lineTo(0.0f, 0.0f);
                this.d.setShader(new LinearGradient(0.0f, 0.0f, this.c * 2, this.u * 2, new int[]{(int) (hcVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - hcVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.d.setColor(SupportMenu.CATEGORY_MASK);
                this.d.setStyle(Paint.Style.STROKE);
                this.d.setStrokeWidth(iIntValue);
                canvas.drawPath(this.hc, this.d);
            }
        }
    }

    public void d(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.an * f);
        view.setTranslationX((this.an - layoutParams.width) / 2);
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.an - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void d(View view, int i, int i2) {
        String str;
        this.c = i / 2;
        this.u = i2 / 2;
        if (this.an == 0 && view.getLayoutParams().width > 0) {
            this.an = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.b.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if (j.e.equals(str)) {
            view.setPivotX(this.c * 2);
            view.setPivotY(this.u);
        } else if (j.d.equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.u);
        } else {
            view.setPivotX(this.c);
            view.setPivotY(this.u);
        }
    }
}
