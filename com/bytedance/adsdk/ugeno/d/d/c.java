package com.bytedance.adsdk.ugeno.d.d;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.baidu.mobads.container.n.f;
import com.bytedance.adsdk.ugeno.an.d;
import com.bytedance.adsdk.ugeno.an.gb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends d {
    private static final float cb;
    private static final float e;
    private static final float k;
    private static final float w;
    private d.C0171d an;
    private int b;
    private Paint c;
    private int gb;
    private int h;
    private int mk;
    private boolean mq;
    private int tc;
    private float tt;
    private Path u;
    private Path uo;
    private float yo;

    static {
        float radians = (float) Math.toRadians(30.0d);
        k = radians;
        e = (float) Math.tan(radians);
        cb = (float) Math.cos(radians);
        w = (float) Math.sin(radians);
    }

    public c(com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject) {
        super(bVar, jSONObject);
        this.mq = true;
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.u = new Path();
        this.tt = this.hc.sy();
        this.uo = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void hc() {
        this.b = (int) gb.d(this.hc.tt().getContext(), this.d.optInt("shineWidth", 30));
        String strOptString = this.d.optString(f.T, "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.an = com.bytedance.adsdk.ugeno.an.d.hc(str);
        } else {
            int iD = com.bytedance.adsdk.ugeno.an.d.d(str);
            this.h = iD;
            this.gb = com.bytedance.adsdk.ugeno.an.d.d(iD, 32);
            this.mq = false;
        }
        this.yo = cb * this.b;
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.hc.q() > 0.0f) {
                int i = this.tc;
                float f = e;
                float fQ = (i + (i * f)) * this.hc.q();
                this.uo.reset();
                this.uo.moveTo(fQ, 0.0f);
                int i2 = this.mk;
                float f2 = fQ - (i2 * f);
                this.uo.lineTo(f2, i2);
                this.uo.lineTo(f2 + this.b, this.mk);
                this.uo.lineTo(this.b + fQ, 0.0f);
                this.uo.close();
                float f3 = this.yo;
                float f4 = cb * f3;
                float f5 = f3 * w;
                if (this.mq && this.an != null) {
                    linearGradient = new LinearGradient(fQ, 0.0f, fQ + f4, f5, this.an.hc, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    int i3 = this.gb;
                    linearGradient = new LinearGradient(fQ, 0.0f, fQ + f4, f5, new int[]{i3, this.h, i3}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.c.setShader(linearGradient);
                Path path = this.u;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.uo, this.c);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(int i, int i2) {
        this.tc = i;
        this.mk = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.u;
            float f = this.tt;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public List<PropertyValuesHolder> b() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(c(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
