package com.baidu.mobads.container.landingpage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.x.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class af extends RelativeLayout {
    private static final int i = 45;
    private static final int j = 45;
    com.baidu.mobads.container.adrequest.j a;
    Context b;
    com.baidu.mobads.container.x.k c;
    int d;
    int e;
    c f;
    a g;
    b h;
    private JSONObject k;
    private int l;
    private List<String> m;
    private List<String> n;
    private List<String> o;
    private h.a p;

    interface b {
        void a();
    }

    public af(Context context, com.baidu.mobads.container.adrequest.j jVar) {
        super(context);
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ai(this);
        setBackgroundColor(-1);
        this.b = context;
        this.a = jVar;
        JSONObject extraParams = jVar.getExtraParams();
        if (extraParams != null) {
            this.k = extraParams.optJSONObject("trackingPlain");
            if (this.k != null) {
                com.baidu.mobads.container.util.ah.a(this.m, this.k.optJSONArray("videoAdStartUrl"), "");
                com.baidu.mobads.container.util.ah.a(this.n, this.k.optJSONArray("videoAdEndUrl"), "");
                com.baidu.mobads.container.util.ah.a(this.o, this.k.optJSONArray("videoAdRepeatedPlayUrl"), "");
            }
            this.l = extraParams.optInt("nowtime");
        }
        h();
    }

    private void h() {
        JSONObject jSONObjectOptJSONObject;
        this.d = com.baidu.mobads.container.util.ab.b(this.b);
        int iC = com.baidu.mobads.container.util.ab.c(this.b);
        if (this.a != null) {
            if (this.a.getVideoHeight() > this.a.getVideoWidth()) {
                this.e = iC / 3;
            } else {
                this.e = (this.d * this.a.getVideoHeight()) / (this.a.getVideoWidth() > 0 ? this.a.getVideoWidth() : 1);
            }
            setLayoutParams(new RelativeLayout.LayoutParams(this.d, this.e));
        }
        int iOptInt = 0;
        if (this.a != null && this.a.getOriginJsonObject() != null && (jSONObjectOptJSONObject = this.a.getOriginJsonObject().optJSONObject("cloud_control")) != null) {
            iOptInt = jSONObjectOptJSONObject.optInt("v_lp_rb_style", 0);
        }
        this.c = new com.baidu.mobads.container.x.k(this.b, iOptInt);
        this.c.a(this.p);
        this.c.a((Activity) this.b);
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        a(this.a.getMainPictureUrl());
    }

    public void a() {
        if (this.c != null) {
            this.c.a(g());
        }
    }

    public void b() {
        if (this.c != null) {
            this.c.f();
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.g();
        }
        if (this.f != null) {
            this.f.setVisibility(4);
        }
    }

    public void d() {
        if (this.c != null) {
            this.c.j();
        }
    }

    public com.baidu.mobads.container.x.k e() {
        return this.c;
    }

    private void a(String str) {
        com.baidu.mobads.container.util.d.d.a(this.b).a(str, false, (com.baidu.mobads.container.util.d.a) new ag(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        Bitmap bitmapA = com.baidu.mobads.container.util.ab.a(bitmap, this.e, this.d);
        if (bitmapA != null) {
            if (this.g != null) {
                this.g.a.setImageBitmap(bitmapA);
            }
            this.f = new c(this.b, bitmapA);
            this.f.setOnClickListener(new ah(this));
        }
    }

    static class c extends RelativeLayout {
        ImageView a;
        ImageView b;

        c(Context context, Bitmap bitmap) {
            this(context, bitmap, false);
        }

        c(Context context, Bitmap bitmap, boolean z) {
            super(context);
            a(context, bitmap);
            if (!z) {
                this.b = new ImageView(context);
                com.component.b.a.a().a(this.b, "ic_video_play");
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.b(context, 45), bv.b(context, 45));
                layoutParams.addRule(13);
                addView(this.b, layoutParams);
            }
        }

        void a(Context context, Bitmap bitmap) {
            this.a = new ImageView(context);
            this.a.setImageBitmap(bitmap);
            this.a.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    static class a extends RelativeLayout {
        ImageView a;

        a(Context context) {
            super(context);
            this.a = new ImageView(context);
            this.a.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public boolean f() {
        if (this.c != null) {
            return this.c.i();
        }
        return false;
    }

    public String g() {
        return this.a.getVideoUrl();
    }
}
