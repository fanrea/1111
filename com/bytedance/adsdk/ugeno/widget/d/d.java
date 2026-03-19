package com.bytedance.adsdk.ugeno.widget.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.an.c;
import com.bytedance.adsdk.ugeno.an.d;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.d;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import com.bytedance.adsdk.ugeno.widget.text.hc;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends hc {
    private boolean ec;
    private d.C0171d gu;
    private int hg;
    private int ho;
    private String hr;
    private boolean ic;
    private String ox;
    private String p;
    private String tj;

    public d(Context context) {
        super(context);
        this.ox = "row";
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hc, com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        gb();
        ((UGTextView) this.u).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    protected void dc() {
        super.dc();
        if (this.ic) {
            ((UGTextView) this.u).setTextColor(this.ho);
        }
        if (this.ec) {
            if (this.o) {
                d(this.gu);
            } else {
                b(this.hg);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    protected void tr() {
        super.tr();
        if (this.ic) {
            ((UGTextView) this.u).setTextColor(this.rs);
        }
        if (this.ec) {
            if (this.o) {
                d(this.f);
            } else {
                b(this.r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void hc(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        String str = this.ox;
        char c = 65535;
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    c = 2;
                    break;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c = 1;
                    break;
                }
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    c = 0;
                    break;
                }
                break;
            case 113114:
                if (str.equals("row")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0) {
            ((UGTextView) this.u).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (c == 1) {
            ((UGTextView) this.u).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (c == 2) {
            ((UGTextView) this.u).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        } else {
            ((UGTextView) this.u).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private void gb() {
        if (TextUtils.isEmpty(this.tj)) {
            return;
        }
        ((UGTextView) this.u).setCompoundDrawables(null, null, null, null);
        if (this.tj.startsWith("local://")) {
            try {
                hc(gb.d(this.hc, c.hc(this.hc, this.tj.replace("local://", ""))));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        com.bytedance.adsdk.ugeno.c.d().hc().d(this.tt, this.tj, new d.InterfaceC0174d() { // from class: com.bytedance.adsdk.ugeno.widget.d.d.1
            @Override // com.bytedance.adsdk.ugeno.d.InterfaceC0174d
            public void d(final Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                gb.d(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.d.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.hc(new BitmapDrawable(d.this.hc.getResources(), bitmap));
                    }
                });
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hc, com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.ox = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.ho = com.bytedance.adsdk.ugeno.an.d.d(str2);
                this.ic = true;
                break;
            case "image":
                this.tj = str2;
                break;
            case "highlightImage":
                this.p = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.an.d.b(str2)) {
                    this.o = true;
                    this.gu = com.bytedance.adsdk.ugeno.an.d.hc(str2);
                } else {
                    this.hg = com.bytedance.adsdk.ugeno.an.d.d(str2);
                    this.o = false;
                }
                this.ec = true;
                break;
            case "highlightBackgroundImage":
                this.hr = str2;
                break;
        }
    }
}
