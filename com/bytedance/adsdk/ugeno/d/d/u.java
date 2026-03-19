package com.bytedance.adsdk.ugeno.d.d;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends d {
    private float an;
    private float b;
    private float c;
    private boolean gb;
    private String h;
    private Path mk;
    private Path mq;
    private Path tc;
    private boolean tt;
    private Paint u;
    private PorterDuffXfermode uo;

    public u(com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject) {
        super(bVar, jSONObject);
        this.gb = true;
        this.tt = true;
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
        this.hc.tt().setLayerType(2, null);
        this.uo = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.tc = new Path();
        this.mk = new Path();
        this.mq = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void hc() {
        this.an = (float) this.d.optDouble("start", 0.0d);
        this.h = this.d.optString("direction", "center");
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(Canvas canvas) {
        int iRu;
        int iRu2;
        if (this.hc.ru() > 0.0f) {
            iRu = (int) (this.b * this.hc.ru());
            iRu2 = (int) (this.c * this.hc.ru());
            this.u.setXfermode(this.uo);
            String str = this.h;
            str.hashCode();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, iRu2, this.b, this.c, this.u);
                    break;
                case "center":
                    this.tc.reset();
                    this.mk.reset();
                    this.mq.reset();
                    this.tc.addCircle(this.b / 2.0f, this.c / 2.0f, iRu, Path.Direction.CW);
                    Path path = this.mk;
                    float f = this.b;
                    path.addRect(f / 2.0f, 0.0f, f, this.c, Path.Direction.CW);
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.mk.op(this.tc, Path.Op.DIFFERENCE);
                    }
                    this.mq.addRect(0.0f, 0.0f, this.b / 2.0f, this.c, Path.Direction.CW);
                    if (Build.VERSION.SDK_INT >= 19) {
                        this.mq.op(this.tc, Path.Op.DIFFERENCE);
                    }
                    canvas.drawPath(this.mk, this.u);
                    canvas.drawPath(this.mq, this.u);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.b, this.c - iRu2, this.u);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.b - iRu, this.c, this.u);
                    break;
                case "right":
                    canvas.drawRect(iRu, 0.0f, this.b, this.c, this.u);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(int i, int i2) {
        if (i > 0 && this.gb) {
            this.b = i;
            this.gb = false;
        }
        if (i2 <= 0 || !this.tt) {
            return;
        }
        this.c = i2;
        this.tt = false;
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public List<PropertyValuesHolder> b() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(c(), this.an, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
