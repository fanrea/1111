package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.hc.b;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b<UGProgressBar> {
    private int d;
    private float hr;
    private int ox;
    private float p;
    private int rs;
    private String tj;

    public d(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public UGProgressBar d() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.hc);
        uGProgressBar.d(this);
        return uGProgressBar;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        ((UGProgressBar) this.u).setBackgroundColor(this.rs);
        ((UGProgressBar) this.u).setText(this.tj);
        ((UGProgressBar) this.u).setProgressBgColor(this.rs);
        ((UGProgressBar) this.u).setProgressColor(this.d);
        ((UGProgressBar) this.u).setTextColor(this.ox);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "progressBgColor":
                this.rs = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case "textColor":
                this.ox = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case "textSize":
                this.p = gb.d(this.hc, str2);
                break;
            case "progress":
                this.hr = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case "text":
                this.tj = str2;
                break;
            case "progressColor":
                this.d = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
        }
    }
}
