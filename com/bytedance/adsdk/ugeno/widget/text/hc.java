package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.hc.b;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.component.a.a.b;
import io.netty.util.internal.StringUtil;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends b<UGTextView> {
    private int cj;
    protected String d;
    private float ec;

    @Deprecated
    private float ed;
    private float el;
    private float eu;
    private int gu;
    private int hg;

    @Deprecated
    private TextUtils.TruncateAt ho;
    private int hr;
    private TextUtils.TruncateAt ic;
    private float jm;
    private boolean lv;
    private float nk;
    private float om;
    private int ox;
    private int p;
    protected int rs;
    private float tj;

    @Deprecated
    private float zk;

    public hc(Context context) {
        super(context);
        this.rs = -16777216;
        this.tj = 12.0f;
        this.p = Integer.MAX_VALUE;
        this.hg = GravityCompat.START;
        this.ic = TextUtils.TruncateAt.END;
        this.ec = -1.0f;
        this.jm = 400.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public UGTextView d() {
        UGTextView uGTextView = new UGTextView(this.hc);
        uGTextView.d(this);
        return uGTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        if (TextUtils.equals(ILogConst.CACHE_PLAY_REASON_NULL, this.d)) {
            this.d = "";
        }
        mk(this.d);
        ((UGTextView) this.u).setTextSize(1, this.tj);
        ((UGTextView) this.u).setTextColor(this.rs);
        ((UGTextView) this.u).setLines(this.hr);
        ((UGTextView) this.u).setMaxLines(this.p);
        ((UGTextView) this.u).setGravity(this.hg);
        ((UGTextView) this.u).setIncludeFontPadding(false);
        an(this.gu);
        if (j()) {
            d(this.ic);
        } else {
            d(this.ho);
        }
        if (this.ec > 0.0f) {
            if (j()) {
                xp();
            } else {
                gb();
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ((UGTextView) this.u).setBreakStrategy(0);
        }
        if (j()) {
            if (this.lv) {
                if (this.om <= 0.0f) {
                    this.om = 1.0E-5f;
                }
                ((UGTextView) this.u).setShadowLayer(this.om, this.el, this.nk, this.cj);
            }
        } else {
            ((UGTextView) this.u).setShadowLayer(this.om, this.ed, this.zk, this.cj);
        }
        if (this.ox == 1) {
            ((UGTextView) this.u).setTypeface(Typeface.DEFAULT, this.ox);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ((UGTextView) this.u).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.jm, this.ox == 2));
        } else if (this.jm >= 500.0f) {
            ((UGTextView) this.u).setTypeface(Typeface.DEFAULT, 1);
        }
        if (Build.VERSION.SDK_INT < 21 || gb.d(this.hc, this.tj) <= 0.0f) {
            return;
        }
        ((UGTextView) this.u).setLetterSpacing(this.eu / gb.d(this.hc, this.tj));
    }

    private void gb() {
        ((UGTextView) this.u).setLineSpacing(0.0f, this.ec);
    }

    private void xp() {
        if (this.ec <= 3.0f) {
            ((UGTextView) this.u).setLineSpacing(0.0f, this.ec);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(gb.d(this.hc, (this.ec - (this.tj * 1.2f)) / 2.0f));
            ((UGTextView) this.u).setPadding(((UGTextView) this.u).getPaddingLeft(), ((UGTextView) this.u).getPaddingTop() + iRound, ((UGTextView) this.u).getPaddingRight(), ((UGTextView) this.u).getPaddingBottom() + iRound);
            ((UGTextView) this.u).setLineHeight(Math.round(gb.d(this.hc, this.ec)));
        }
    }

    public void mk(String str) {
        this.d = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(ILogConst.CACHE_PLAY_REASON_NULL, str)) {
            this.d = "";
        }
        ((UGTextView) this.u).setText(this.d);
    }

    public void an(int i) {
        this.gu = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.u).setPaintFlags(i);
    }

    public void d(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.u).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.d(str, str2);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    c = 0;
                    break;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    c = 1;
                    break;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    c = 2;
                    break;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    c = 3;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    c = 4;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c = 5;
                    break;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    c = 6;
                    break;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    c = 7;
                    break;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    c = '\b';
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    c = '\t';
                    break;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    c = '\n';
                    break;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    c = 11;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c = '\f';
                    break;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c = 14;
                    break;
                }
                break;
            case 102977279:
                if (str.equals(b.e.k)) {
                    c = 15;
                    break;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    c = 16;
                    break;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    c = 17;
                    break;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    c = 18;
                    break;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    c = 19;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 7:
                this.om = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 1:
                this.cj = com.bytedance.adsdk.ugeno.an.d.d(str2);
                this.lv = true;
                break;
            case 2:
                this.el = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
            case 3:
                this.nk = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
            case 4:
                this.hg = e(str2);
                break;
            case 5:
                this.rs = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case 6:
                this.ox = k(str2);
                break;
            case '\b':
                this.tj = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case '\t':
                this.gu = cb(str2);
                break;
            case '\n':
                this.ed = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case 11:
                this.zk = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                break;
            case '\f':
                float fD = com.bytedance.adsdk.ugeno.an.b.d(str2, -1.0f);
                this.jm = fD;
                if (fD < 1.0f || fD > 1000.0f) {
                    this.jm = 400.0f;
                    break;
                }
                break;
            case '\r':
                this.ec = com.bytedance.adsdk.ugeno.an.b.d(str2, 1.0f);
                break;
            case 14:
                this.d = str2;
                break;
            case 15:
                this.hr = com.bytedance.adsdk.ugeno.an.b.d(str2, 0);
                break;
            case 16:
                this.ic = uo(str2);
                break;
            case 17:
                int iD = com.bytedance.adsdk.ugeno.an.b.d(str2, Integer.MAX_VALUE);
                this.p = iD > 0 ? iD : Integer.MAX_VALUE;
                break;
            case 18:
                this.ho = mq(str2);
                break;
            case 19:
                this.eu = gb.d(this.hc, com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt mq(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.ho = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.ho = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.ho = TextUtils.TruncateAt.START;
                break;
            default:
                this.ho = null;
                break;
        }
        return this.ho;
    }

    private TextUtils.TruncateAt uo(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int k(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1178781136(0xffffffffb9bd3a30, float:-3.6092242E-4)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r0 == r1) goto L21
            r1 = 3029637(0x2e3a85, float:4.245426E-39)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "bold"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r2
            goto L36
        L21:
            java.lang.String r0 = "normal"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r3
            goto L36
        L2b:
            java.lang.String r0 = "italic"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r4
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3d
            if (r6 == r4) goto L3b
            goto L3e
        L3b:
            r2 = r3
            goto L3e
        L3d:
            r2 = r4
        L3e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.widget.text.hc.k(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int e(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 0;
                    break;
                }
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    c = 1;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(j.d)) {
                    c = 2;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(j.e)) {
                    c = 3;
                    break;
                }
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 17;
            case 1:
                return 16;
            case 2:
            default:
                return 3;
            case 3:
                return 5;
            case 4:
                return 1;
        }
    }

    private int cb(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }
}
