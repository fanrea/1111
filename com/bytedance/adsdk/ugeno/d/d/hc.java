package com.bytedance.adsdk.ugeno.d.d;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.baidu.mobads.container.n.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends d {
    private static final int h = Color.parseColor("#7ed321");
    private Paint an;
    private int b;
    private int c;
    private int u;

    public hc(com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject) {
        super(bVar, jSONObject);
        Paint paint = new Paint();
        this.an = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void hc() {
        this.b = com.bytedance.adsdk.ugeno.an.d.d(this.d.optString(f.T), h);
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(Canvas canvas) {
        try {
            if (this.hc.wl() > 0.0f) {
                this.an.setColor(this.b);
                this.an.setAlpha((int) ((1.0f - this.hc.wl()) * 255.0f));
                ((ViewGroup) this.hc.tt().getParent()).setClipChildren(true);
                canvas.drawCircle(this.c, this.u, Math.min(r0, r2) * 2 * this.hc.wl(), this.an);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public void d(int i, int i2) {
        this.c = i / 2;
        this.u = i2 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.d.d.d
    public List<PropertyValuesHolder> b() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(c(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
