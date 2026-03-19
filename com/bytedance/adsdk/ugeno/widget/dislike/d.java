package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.hc.b;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b<DislikeView> {
    private int d;
    private int rs;
    private int tj;

    public d(Context context) {
        super(context);
        this.d = 0;
        this.tj = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public DislikeView d() {
        DislikeView dislikeView = new DislikeView(this.hc);
        dislikeView.d(this);
        return dislikeView;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        ((DislikeView) this.u).setRadius(this.y);
        ((DislikeView) this.u).setStrokeWidth((int) this.ra);
        ((DislikeView) this.u).setDislikeColor(this.d);
        ((DislikeView) this.u).setStrokeColor(this.rw);
        ((DislikeView) this.u).setDislikeWidth(this.rs);
        ((DislikeView) this.u).setBgColor(this.tj);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "dislikeColor":
                this.d = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case "dislikeWidth":
                this.rs = (int) gb.d(this.hc, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.tj = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
        }
    }
}
