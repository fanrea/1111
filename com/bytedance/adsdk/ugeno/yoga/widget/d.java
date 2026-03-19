package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.an.gb;
import com.bytedance.adsdk.ugeno.b.h;
import com.bytedance.adsdk.ugeno.c;
import com.bytedance.adsdk.ugeno.d;
import com.bytedance.adsdk.ugeno.hc.b;
import com.bytedance.adsdk.ugeno.hc.d;
import com.bytedance.adsdk.ugeno.yoga.an;
import com.bytedance.adsdk.ugeno.yoga.k;
import com.bytedance.adsdk.ugeno.yoga.tc;
import com.bytedance.adsdk.ugeno.yoga.u;
import com.bytedance.adsdk.ugeno.yoga.uo;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.adsdk.ugeno.hc.d<YogaLayout> {
    private tc hg;
    private com.bytedance.adsdk.ugeno.yoga.d hr;
    private an ox;
    private com.bytedance.adsdk.ugeno.yoga.d p;
    private u rs;
    private k tj;

    public d(Context context) {
        super(context);
        this.rs = u.ROW;
        this.tj = k.NO_WRAP;
        this.ox = an.FLEX_START;
        this.p = com.bytedance.adsdk.ugeno.yoga.d.STRETCH;
        this.hr = com.bytedance.adsdk.ugeno.yoga.d.STRETCH;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    /* renamed from: xp, reason: merged with bridge method [inline-methods] */
    public YogaLayout d() {
        YogaLayout yogaLayout = new YogaLayout(this.hc);
        yogaLayout.d(this);
        this.hg = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    protected void he() {
        if (this.tr) {
            if (this.wb != null) {
                this.wb.d();
            }
            c.d().hc().d(this.tt, this.hv, new d.InterfaceC0174d() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.d.1
                @Override // com.bytedance.adsdk.ugeno.d.InterfaceC0174d
                public void d(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (d.this.wb != null) {
                            h hVar = d.this.wb;
                            d dVar = d.this;
                            hVar.hc(dVar, dVar.hv);
                            return;
                        }
                        return;
                    }
                    if (d.this.wb != null) {
                        h hVar2 = d.this.wb;
                        d dVar2 = d.this;
                        hVar2.d(dVar2, dVar2.hv);
                    }
                    final Bitmap bitmapD = gb.d(d.this.hc, bitmap, (int) d.this.dc);
                    if (bitmapD != null) {
                        gb.d(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.d(new BitmapDrawable(bitmapD));
                            }
                        });
                    }
                }
            });
            return;
        }
        if (this.wb != null) {
            this.wb.d();
        }
        ImageView imageView = new ImageView(this.hc);
        c.d().hc().d(this.tt, this.hv, imageView, this.u.getWidth(), this.u.getHeight(), new d.InterfaceC0174d() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.d.2
            @Override // com.bytedance.adsdk.ugeno.d.InterfaceC0174d
            public void d(Bitmap bitmap) {
                if (bitmap == null) {
                    if (d.this.wb != null) {
                        h hVar = d.this.wb;
                        d dVar = d.this;
                        hVar.hc(dVar, dVar.hv);
                        return;
                    }
                    return;
                }
                if (d.this.wb != null) {
                    h hVar2 = d.this.wb;
                    d dVar2 = d.this;
                    hVar2.d(dVar2, dVar2.hv);
                }
            }
        });
        if (!this.nv || this.bc == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.bc);
        }
        YogaLayout.d dVar = new YogaLayout.d(-1, -1);
        dVar.an(uo.ABSOLUTE.d());
        if (this.u instanceof YogaLayout) {
            ((YogaLayout) this.u).addView(imageView, 0, dVar);
            d(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    protected void d(Drawable drawable) {
        ImageView imageView = new ImageView(this.hc);
        imageView.setImageDrawable(drawable);
        if (!this.nv || this.bc == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(this.bc);
        }
        YogaLayout.d dVar = new YogaLayout.d(-1, -1);
        dVar.an(uo.ABSOLUTE.d());
        if (this.u instanceof YogaLayout) {
            ((YogaLayout) this.u).addView(imageView, 0, dVar);
            d(imageView);
        }
    }

    private void d(final ImageView imageView) {
        this.u.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.d.3
            @Override // java.lang.Runnable
            public void run() {
                tc tcVarD;
                if (d.this.u == null || (tcVarD = ((YogaLayout) d.this.u).d(imageView)) == null) {
                    return;
                }
                tcVarD.c(d.this.u.getWidth());
                tcVarD.an(d.this.u.getHeight());
                d.this.u.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d, com.bytedance.adsdk.ugeno.hc.b
    public void hc() throws JSONException {
        super.hc();
        this.hg.d(this.rs);
        this.hg.d(this.tj);
        this.hg.d(this.ox);
        this.hg.d(this.p);
        this.hg.b(this.hr);
        this.hg.d(true);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    protected void mq() {
        if (this.us) {
            this.hg.hc(com.bytedance.adsdk.ugeno.yoga.c.ALL, this.he);
        }
        if (this.z) {
            this.hg.hc(com.bytedance.adsdk.ugeno.yoga.c.LEFT, this.vv);
        }
        if (this.fs) {
            this.hg.hc(com.bytedance.adsdk.ugeno.yoga.c.RIGHT, this.zw);
        }
        if (this.ba) {
            this.hg.hc(com.bytedance.adsdk.ugeno.yoga.c.TOP, this.j);
        }
        if (this.mt) {
            this.hg.hc(com.bytedance.adsdk.ugeno.yoga.c.BOTTOM, this.s);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d
    public void d(b bVar) {
        super.d(bVar);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d
    public void d(b bVar, ViewGroup.LayoutParams layoutParams) {
        if (bVar == null) {
            return;
        }
        this.d.add(bVar);
        View viewTt = bVar.tt();
        if (viewTt != null) {
            ((YogaLayout) this.u).addView(viewTt, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.d
    /* renamed from: to, reason: merged with bridge method [inline-methods] */
    public C0182d gb() {
        return new C0182d(this);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.b
    public void d(String str, String str2) {
        super.d(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.p = com.bytedance.adsdk.ugeno.yoga.d.d(str2);
                break;
            case "flexDirection":
                this.rs = u.d(str2);
                break;
            case "alignContent":
                this.hr = com.bytedance.adsdk.ugeno.yoga.d.d(str2);
                break;
            case "flexWrap":
                this.tj = k.d(str2);
                break;
            case "justifyContent":
                this.ox = an.d(str2);
                break;
        }
    }

    public u ra() {
        return this.rs;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.yoga.widget.d$d, reason: collision with other inner class name */
    public static class C0182d extends d.C0176d {
        public int ba;
        private boolean bc;
        private boolean dc;
        public int fs;
        public int he;
        private boolean hv;
        public int j;
        public int mt;
        private boolean nv;
        public float r;
        public float s;
        private boolean tr;
        public int us;
        public float vv;
        private boolean y;
        public int z;
        public float zw;

        public C0182d(com.bytedance.adsdk.ugeno.hc.d dVar) {
            super(dVar);
            this.he = 1;
            this.vv = 0.0f;
            this.zw = 1.0f;
            this.j = com.bytedance.adsdk.ugeno.yoga.d.AUTO.d();
            this.s = -1.0f;
            this.us = uo.RELATIVE.d();
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        public void d(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.d(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasis":
                    this.hv = true;
                    float fD = com.bytedance.adsdk.ugeno.an.b.d(str2, -1.0f);
                    this.s = fD;
                    this.s = gb.d(context, fD);
                    break;
                case "bottom":
                    this.dc = true;
                    this.fs = (int) gb.d(context, com.bytedance.adsdk.ugeno.an.b.d(str2, 0));
                    break;
                case "top":
                    this.bc = true;
                    this.z = (int) gb.d(context, com.bytedance.adsdk.ugeno.an.b.d(str2, 0));
                    break;
                case "left":
                    this.tr = true;
                    this.ba = (int) gb.d(context, com.bytedance.adsdk.ugeno.an.b.d(str2, 0));
                    break;
                case "order":
                    this.he = com.bytedance.adsdk.ugeno.an.b.d(str2, 1);
                    break;
                case "ratio":
                    this.y = true;
                    this.r = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                    break;
                case "right":
                    this.nv = true;
                    this.mt = (int) gb.d(context, com.bytedance.adsdk.ugeno.an.b.d(str2, 0));
                    break;
                case "position":
                    this.us = uo.d(str2).d();
                    break;
                case "flexShrink":
                    this.zw = com.bytedance.adsdk.ugeno.an.b.d(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.vv = com.bytedance.adsdk.ugeno.an.b.d(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.j = com.bytedance.adsdk.ugeno.yoga.d.d(str2).d();
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        /* renamed from: hc, reason: merged with bridge method [inline-methods] */
        public YogaLayout.d d() {
            c();
            YogaLayout.d dVar = new YogaLayout.d((int) this.d, (int) this.hc);
            dVar.mq((int) (this.jh ? this.an : this.u));
            dVar.k((int) (this.sy ? this.h : this.u));
            dVar.mk((int) (this.de ? this.gb : this.u));
            dVar.uo((int) (this.v ? this.tt : this.u));
            dVar.d(this.he);
            dVar.u(this.j);
            dVar.hc(this.vv);
            dVar.b(this.zw);
            dVar.cb(this.b);
            dVar.w(this.c);
            if (this.hv) {
                dVar.c(this.s);
            }
            dVar.an(this.us);
            if (this.bc) {
                dVar.h(this.z);
            }
            if (this.dc) {
                dVar.tt(this.fs);
            }
            if (this.tr) {
                dVar.gb(this.ba);
            }
            if (this.nv) {
                dVar.tc(this.mt);
            }
            if (this.y && b()) {
                float f = this.r;
                if (f > 0.0f) {
                    dVar.e(f);
                    dVar.b(0.0f);
                    dVar.hc(0.0f);
                }
            }
            return dVar;
        }

        public boolean b() {
            if (this.d == -1.0f && this.hc == -1.0f) {
                return false;
            }
            return this.d == -2.0f || this.hc == -2.0f;
        }

        private void c() {
            if (this.yi instanceof d) {
                if (((d) this.yi).ra() == u.ROW && this.yi.fs() == -2 && this.d == -1.0f && !this.yi.y()) {
                    this.d = -2.0f;
                    this.zw = 1.0f;
                    this.vv = 1.0f;
                    this.hv = true;
                    this.s = -1.0f;
                }
                if (((d) this.yi).ra() == u.COLUMN && this.yi.ba() == -2 && this.hc == -1.0f && !this.yi.y()) {
                    this.hc = -2.0f;
                    this.zw = 1.0f;
                    this.vv = 1.0f;
                    this.hv = true;
                    this.s = -1.0f;
                }
            }
        }

        @Override // com.bytedance.adsdk.ugeno.hc.d.C0176d
        public String toString() {
            return "LayoutParams{mOrder=" + this.he + ", mFlexGrow=" + this.vv + ", mFlexShrink=" + this.zw + ", mAlignSelf=" + this.j + ", mFlexBasis=" + this.s + ", mPosition=" + this.us + ", mTop=" + this.z + ", mBottom=" + this.fs + ", mLeft=" + this.ba + ", mRight=" + this.mt + '}';
        }
    }
}
