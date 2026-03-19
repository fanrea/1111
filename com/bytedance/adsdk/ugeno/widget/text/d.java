package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.hc.b;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b<RichTextView> {
    private String d;
    private int gu;
    private String hg;
    private int hr;
    private String ox;
    private int p;
    private int rs;
    private float tj;

    public d(Context context) {
        super(context);
        this.p = Integer.MAX_VALUE;
        this.gu = 2;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public RichTextView d() {
        RichTextView richTextView = new RichTextView(this.hc);
        richTextView.d(this);
        return richTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        ((RichTextView) this.u).setRichText(this.d);
        ((RichTextView) this.u).setTextSize(1, this.tj);
        ((RichTextView) this.u).setTextColor(this.rs);
        ((RichTextView) this.u).setLines(this.hr);
        ((RichTextView) this.u).setMaxLines(this.p);
        ((RichTextView) this.u).setGravity(this.gu);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.gu = mk(str2);
                break;
            case "textColor":
                this.rs = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case "textStyle":
                this.ox = str2;
                break;
            case "textSize":
                this.tj = Float.parseFloat(str2);
                break;
            case "text":
                this.d = str2;
                break;
            case "lines":
                this.hr = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.p = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.hg = str2;
                break;
        }
    }

    private int mk(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }
}
