package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.bytedance.adsdk.ugeno.hc.b;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b<EditText> {
    private int d;
    private int gu;
    private String hg;
    private String ho;
    private int hr;
    private String ic;
    private String ox;
    private int p;
    private int rs;
    private float tj;

    public d(Context context) {
        super(context);
        this.d = 1;
        this.p = Integer.MAX_VALUE;
        this.gu = 2;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public EditText d() {
        UGEditText uGEditText = new UGEditText(this.hc);
        uGEditText.d(this);
        return uGEditText;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        ((EditText) this.u).setInputType(this.d);
        ((EditText) this.u).setText(this.ho);
        ((EditText) this.u).setTextSize(1, this.tj);
        ((EditText) this.u).setTextColor(this.rs);
        ((EditText) this.u).setLines(this.hr);
        ((EditText) this.u).setMaxLines(this.p);
        ((EditText) this.u).setGravity(this.gu);
        ((EditText) this.u).setHint(this.ic);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.gu = mq(str2);
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
            case "hint":
                this.ic = str2;
                break;
            case "text":
                this.ho = str2;
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
            case "inputType":
                this.d = mk(str2);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int mk(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1034364087: goto L33;
                case 3556653: goto L29;
                case 96619420: goto L1f;
                case 106642798: goto L15;
                case 1216985755: goto Lb;
                default: goto La;
            }
        La:
            goto L3d
        Lb:
            java.lang.String r0 = "password"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = 0
            goto L3e
        L15:
            java.lang.String r0 = "phone"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = r3
            goto L3e
        L1f:
            java.lang.String r0 = "email"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = r1
            goto L3e
        L29:
            java.lang.String r0 = "text"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = 4
            goto L3e
        L33:
            java.lang.String r0 = "number"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L3d
            r5 = r2
            goto L3e
        L3d:
            r5 = -1
        L3e:
            if (r5 == 0) goto L4c
            if (r5 == r3) goto L4b
            if (r5 == r2) goto L4a
            if (r5 == r1) goto L47
            return r3
        L47:
            r5 = 32
            return r5
        L4a:
            return r2
        L4b:
            return r1
        L4c:
            r5 = 128(0x80, float:1.8E-43)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.widget.input.d.mk(java.lang.String):int");
    }

    private int mq(String str) {
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
