package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.an.c;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.b.h;
import com.bytedance.adsdk.ugeno.d;
import com.bytedance.adsdk.ugeno.hc.b;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends b<RoundImageView> {
    protected String d;
    private float hg;
    private float hr;
    protected String ox;
    private int p;
    protected ImageView.ScaleType rs;
    protected boolean tj;

    public hc(Context context) {
        super(context);
        this.rs = ImageView.ScaleType.FIT_XY;
        this.p = -1;
        this.hr = -1.0f;
        this.hg = -1.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException, NumberFormatException {
        super.hc();
        xp();
        ((RoundImageView) this.u).setScaleType(this.rs);
        ((RoundImageView) this.u).setBorderColor(this.rw);
        ((RoundImageView) this.u).setCornerRadius(this.y);
        ((RoundImageView) this.u).setBorderWidth(this.ra);
        if (this.p != -1) {
            ((RoundImageView) this.u).setColorFilter(this.p);
        }
    }

    public void mq(String str) {
        this.d = str;
    }

    private void xp() throws NumberFormatException {
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        ((RoundImageView) this.u).setImageDrawable(null);
        if (this.d.startsWith("local://")) {
            try {
                String strReplace = this.d.replace("local://", "");
                if (TextUtils.equals(h(), "raw")) {
                    ((RoundImageView) this.u).setImageResource(c.d(this.hc, strReplace));
                    return;
                } else {
                    ((RoundImageView) this.u).setImageResource(c.hc(this.hc, strReplace));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (this.d.startsWith("@")) {
            try {
                ((RoundImageView) this.u).setImageResource(Integer.parseInt(this.d.substring(1)));
                return;
            } catch (Exception e) {
                mq.d(e);
                return;
            }
        }
        to();
    }

    private void to() {
        if (this.hr > 0.0f) {
            if (this.wb != null) {
                this.wb.d();
            }
            com.bytedance.adsdk.ugeno.c.d().hc().d(this.tt, this.d, new d.InterfaceC0174d() { // from class: com.bytedance.adsdk.ugeno.widget.image.hc.1
                @Override // com.bytedance.adsdk.ugeno.d.InterfaceC0174d
                public void d(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (hc.this.wb != null) {
                            h hVar = hc.this.wb;
                            hc hcVar = hc.this;
                            hVar.hc(hcVar, hcVar.d);
                            return;
                        }
                        return;
                    }
                    if (hc.this.wb != null) {
                        h hVar2 = hc.this.wb;
                        hc hcVar2 = hc.this;
                        hVar2.d(hcVar2, hcVar2.d);
                    }
                    final Bitmap bitmapD = gb.d(hc.this.hc, bitmap, (int) hc.this.hr);
                    if (bitmapD != null) {
                        gb.d(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hc.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) hc.this.u).setImageBitmap(bitmapD);
                            }
                        });
                    }
                    if (hc.this.tj || hc.this.hg > 0.0f) {
                        Bitmap bitmapD2 = gb.d(hc.this.hc, bitmap, hc.this.hg > 0.0f ? (int) hc.this.hg : 10);
                        if (bitmapD2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(hc.this.hc.getResources(), bitmapD2);
                            gb.d(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hc.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) hc.this.u).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        if (this.wb != null) {
            this.wb.d();
        }
        com.bytedance.adsdk.ugeno.c.d().hc().d(this.tt, this.d, (ImageView) this.u, ((RoundImageView) this.u).getWidth(), ((RoundImageView) this.u).getHeight(), new d.InterfaceC0174d() { // from class: com.bytedance.adsdk.ugeno.widget.image.hc.2
            @Override // com.bytedance.adsdk.ugeno.d.InterfaceC0174d
            public void d(Bitmap bitmap) {
                if (bitmap == null) {
                    if (hc.this.wb != null) {
                        h hVar = hc.this.wb;
                        hc hcVar = hc.this;
                        hVar.hc(hcVar, hcVar.d);
                        return;
                    }
                    return;
                }
                if (hc.this.wb != null) {
                    h hVar2 = hc.this.wb;
                    hc hcVar2 = hc.this;
                    hVar2.d(hcVar2, hcVar2.d);
                }
            }
        });
        if (this.tj || this.hg > 0.0f) {
            com.bytedance.adsdk.ugeno.c.d().hc().d(this.tt, this.d, new d.InterfaceC0174d() { // from class: com.bytedance.adsdk.ugeno.widget.image.hc.3
                @Override // com.bytedance.adsdk.ugeno.d.InterfaceC0174d
                public void d(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapD = gb.d(hc.this.hc, bitmap, hc.this.hg > 0.0f ? (int) hc.this.hg : 10);
                    gb.d(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hc.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapD != null) {
                                ((RoundImageView) hc.this.u).setBackground(new BitmapDrawable(hc.this.hc.getResources(), bitmapD));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: gb, reason: merged with bridge method [inline-methods] */
    public RoundImageView d() {
        RoundImageView roundImageView = new RoundImageView(this.hc);
        roundImageView.d(this);
        return roundImageView;
    }

    public void hc(Drawable drawable) {
        ((RoundImageView) this.u).setImageDrawable(drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.rs = mk(str2);
                break;
            case "imageBlur":
                this.hr = com.bytedance.adsdk.ugeno.an.b.d(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.tj = com.bytedance.adsdk.ugeno.an.b.d(str2, false);
                break;
            case "src":
                this.d = str2;
                break;
            case "tintColor":
                this.p = com.bytedance.adsdk.ugeno.an.d.d(str2);
                break;
            case "imageBgBlur":
                this.hg = com.bytedance.adsdk.ugeno.an.b.d(str2, -1.0f);
                break;
        }
    }

    private ImageView.ScaleType mk(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b, com.bytedance.adsdk.ugeno.b
    public void u() {
        super.u();
        ((RoundImageView) this.u).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hc.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) hc.this.u).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                    return;
                }
                ((AnimatedImageDrawable) drawable).start();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b, com.bytedance.adsdk.ugeno.b
    public void an() {
        super.an();
        Drawable drawable = ((RoundImageView) this.u).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }

    protected String h() {
        return this.ox;
    }
}
