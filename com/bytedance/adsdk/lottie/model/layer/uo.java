package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.adsdk.lottie.sy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo extends h {
    private int gb;
    private final Map<String, Object> tc;
    private int tt;

    public uo(com.bytedance.adsdk.lottie.gb gbVar, gb gbVar2, Context context) {
        super(gbVar, gbVar2);
        this.gb = -1;
        this.tt = -1;
        HashMap map = new HashMap();
        this.tc = map;
        if (this.h != null) {
            float fD = com.bytedance.adsdk.lottie.u.tt.d();
            this.gb = (int) (this.h.d() * fD);
            this.tt = (int) (this.h.hc() * fD);
            map.put("ugen_url", this.h.c());
            map.put("ugen_md5", this.h.u());
            map.put("ugen_v", this.h.an());
            map.put("ugen_w", Integer.valueOf(this.gb));
            map.put("ugen_h", Integer.valueOf(this.tt));
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.h, com.bytedance.adsdk.lottie.model.layer.b
    public void hc(Canvas canvas, Matrix matrix, int i) {
        sy syVarD = this.hc.d();
        View viewD = syVarD != null ? syVarD.d("view:", this.tc) : null;
        if (this.gb <= 0 || viewD == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        d(i);
        float fGb = gb();
        d(viewD, this.gb, this.tt);
        viewD.setAlpha(fGb);
        viewD.draw(canvas);
        canvas.restore();
    }

    private static void d(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
