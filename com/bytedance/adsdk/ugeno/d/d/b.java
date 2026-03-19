package com.bytedance.adsdk.ugeno.d.d;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends d {
    private View an;
    private String b;
    private float c;
    private Paint gb;
    private Paint h;
    private Matrix mk;
    private LinearGradient tc;
    private PorterDuffXfermode tt;
    private float u;

    public b(com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject) {
        super(bVar, jSONObject);
        this.an = this.hc.tt();
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.an.setLayerType(2, null);
        this.tt = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.gb = new Paint();
        this.mk = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void hc() {
        this.b = this.d.optString("direction", j.d);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(Canvas canvas) {
        try {
            if (this.hc.yn() > 0.0f) {
                int iYn = (int) (this.c * this.hc.yn());
                int iYn2 = (int) (this.u * this.hc.yn());
                this.h.setXfermode(this.tt);
                String str = this.b;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (str.equals(j.g)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 115029:
                        if (str.equals(j.f)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3317767:
                        if (str.equals(j.d)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 108511772:
                        if (str.equals(j.e)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    float f = iYn;
                    canvas.drawRect(f, 0.0f, this.c, this.u, this.h);
                    this.mk.setTranslate(f, this.u);
                    this.tc.setLocalMatrix(this.mk);
                    this.gb.setShader(this.tc);
                    if (this.hc.yn() <= 1.0f && this.hc.yn() > 0.9f) {
                        this.gb.setAlpha((int) (255.0f - (this.hc.yn() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f, this.u, this.gb);
                    return;
                }
                if (c == 1) {
                    float f2 = iYn;
                    canvas.drawRect(0.0f, 0.0f, this.c - f2, this.u, this.h);
                    this.mk.setTranslate(this.c - f2, 0.0f);
                    this.tc.setLocalMatrix(this.mk);
                    this.gb.setShader(this.tc);
                    if (this.hc.yn() <= 1.0f && this.hc.yn() > 0.9f) {
                        this.gb.setAlpha((int) (255.0f - (this.hc.yn() * 255.0f)));
                    }
                    float f3 = this.c;
                    canvas.drawRect(f3, this.u, f3 - f2, 0.0f, this.gb);
                    return;
                }
                if (c == 2) {
                    float f4 = iYn2;
                    canvas.drawRect(0.0f, f4, this.c, this.u, this.h);
                    this.mk.setTranslate(0.0f, f4);
                    this.tc.setLocalMatrix(this.mk);
                    this.gb.setShader(this.tc);
                    if (this.hc.yn() <= 1.0f && this.hc.yn() > 0.9f) {
                        this.gb.setAlpha((int) (255.0f - (this.hc.yn() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.c, f4, this.gb);
                    return;
                }
                if (c != 3) {
                    return;
                }
                float f5 = iYn2;
                canvas.drawRect(0.0f, 0.0f, this.c, this.u - f5, this.h);
                this.mk.setTranslate(0.0f, this.u - f5);
                this.tc.setLocalMatrix(this.mk);
                this.gb.setShader(this.tc);
                if (this.hc.yn() <= 1.0f && this.hc.yn() > 0.9f) {
                    this.gb.setAlpha((int) (255.0f - (this.hc.yn() * 255.0f)));
                }
                float f6 = this.c;
                float f7 = this.u;
                canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.gb);
            }
        } catch (Throwable th) {
            mq.c("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(int i, int i2) {
        this.c = i;
        this.u = i2;
        String str = this.b;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.tc = new LinearGradient(0.0f, -this.u, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.tc = new LinearGradient(0.0f, this.u, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.tc = new LinearGradient(this.c, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.tc = new LinearGradient(-this.c, 0.0f, 0.0f, this.u, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public List<PropertyValuesHolder> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.d.u.ALPHA.hc(), 0.0f, 1.0f));
        return arrayList;
    }
}
