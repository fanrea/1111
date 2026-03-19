package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.hc.b;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b<UGRatingBar> {
    private int d;
    private float ox;
    private float p;
    private int rs;
    private float tj;
    private static final int hr = Color.parseColor("#FFC642");
    private static final int hg = Color.parseColor("#e3e3e4");

    public d(Context context) {
        super(context);
        this.d = hr;
        this.rs = hg;
        this.tj = 4.0f;
        this.ox = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public UGRatingBar d() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.hc);
        uGRatingBar.d(this);
        return uGRatingBar;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        if (j()) {
            ((UGRatingBar) this.u).d(this.tj, this.d, this.rs, this.ox, (int) this.p);
        } else {
            ((UGRatingBar) this.u).d(this.tj, this.d, this.rs, this.ox, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.d = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.rs = com.bytedance.adsdk.ugeno.an.d.d(str2, hg);
                break;
            case "gap":
                this.p = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case "size":
                this.ox = com.bytedance.adsdk.ugeno.an.b.d(str2, 20.0f);
                break;
            case "score":
                this.tj = com.bytedance.adsdk.ugeno.an.b.d(str2, 4.0f);
                break;
        }
    }
}
