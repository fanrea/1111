package com.bytedance.adsdk.ugeno.widget.hc;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.widget.image.hc;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d extends hc {
    private int p;

    @Override // com.bytedance.adsdk.ugeno.widget.image.hc
    protected String h() {
        return "drawable";
    }

    public abstract String mk(String str);

    public d(Context context) {
        super(context);
        this.p = -16777216;
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.hc, com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException, NumberFormatException {
        this.d = uo(this.d);
        super.hc();
        ((RoundImageView) this.u).setColorFilter(this.p);
        ((RoundImageView) this.u).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String uo(String str) {
        String strMk = mk(str);
        return TextUtils.isEmpty(strMk) ? "" : "local://".concat(String.valueOf(strMk));
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.hc, com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        super.d(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.p = com.bytedance.adsdk.ugeno.an.d.d(str2);
        }
    }
}
