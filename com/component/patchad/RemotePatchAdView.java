package com.component.patchad;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.components.k.b;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.d.d;
import com.component.b.a;
import com.component.data.PatchDataResponse;
import com.component.player.AdVideoViewListener;
import com.component.player.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class RemotePatchAdView extends RelativeLayout implements View.OnClickListener {
    private static final String a = "PacthAdView";
    private static final int b = 65537;
    private Context c;
    private PatchDataResponse d;
    private ImageView e;
    private c f;
    private boolean g;
    private IPatchAdListener h;
    private boolean i;
    private ImageView j;
    private ImageView k;
    private boolean l;
    private LinearLayout m;
    public bq mAdLogger;
    private ImageView n;
    private ImageView o;
    private TextView p;
    private AdVideoViewListener q;

    public RemotePatchAdView(Context context) {
        super(context);
        this.i = true;
        this.mAdLogger = bq.a();
        this.l = false;
        this.q = new AdVideoViewListener() { // from class: com.component.patchad.RemotePatchAdView.2
            @Override // com.component.player.AdVideoViewListener
            public void playCompletion() {
                RemotePatchAdView.this.i = false;
                RemotePatchAdView.this.mAdLogger.b(RemotePatchAdView.a, b.I);
                if (RemotePatchAdView.this.h != null) {
                    RemotePatchAdView.this.h.playCompletion();
                }
            }

            @Override // com.component.player.AdVideoViewListener
            public void playFailure(String str) {
                RemotePatchAdView.this.i = false;
                RemotePatchAdView.this.mAdLogger.b(RemotePatchAdView.a, "playFailure");
                if (RemotePatchAdView.this.h != null) {
                    RemotePatchAdView.this.h.playError();
                }
            }

            @Override // com.component.player.AdVideoViewListener
            public void renderingStart() {
                RemotePatchAdView.this.l();
                RemotePatchAdView.this.a();
                RemotePatchAdView.this.mAdLogger.b(RemotePatchAdView.a, "renderingStart");
            }

            @Override // com.component.player.AdVideoViewListener
            public void playStart() {
            }

            @Override // com.component.player.AdVideoViewListener
            public void playStop() {
            }

            @Override // com.component.player.AdVideoViewListener
            public void playPause() {
            }

            @Override // com.component.player.AdVideoViewListener
            public void playResume() {
            }
        };
        this.c = context;
    }

    public void setAdData(Object obj) {
        if (obj == null) {
            this.mAdLogger.b(a, "广告响应内容为空，无法播放");
            return;
        }
        this.d = new PatchDataResponse(obj);
        if ("video".equals(this.d.getMaterialType())) {
            g();
            this.f.b(this.l);
            this.f.a(this.d.getVideoUrl());
            h();
        } else {
            a();
        }
        a(this.d);
        f();
        setOnClickListener(this);
    }

    public void setPatchAdListener(IPatchAdListener iPatchAdListener) {
        this.h = iPatchAdListener;
    }

    public void setVideoVolume(boolean z) {
        this.l = z;
        e();
    }

    public long getCurrentPosition() {
        if (this.f != null) {
            return this.f.g();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.f != null) {
            return this.f.h();
        }
        return 0L;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d();
        b();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        k();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            j();
        } else {
            i();
        }
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.h != null) {
            this.h.onAdClicked();
        }
        if (this.d != null) {
            this.d.handleClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.h != null) {
            this.h.onAdShow();
        }
        if (this.d != null && !this.g) {
            this.g = true;
            this.d.recordImpression(this);
        }
    }

    private void b() {
        if (this.d != null && this.k == null && !TextUtils.isEmpty(this.d.getIconUrl())) {
            this.k = new ImageView(this.c);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a(this.c, 29.0f), a(this.c, 29.0f));
            double measuredWidth = getMeasuredWidth();
            Double.isNaN(measuredWidth);
            layoutParams.setMargins((int) (measuredWidth * 0.032d), 0, 0, 0);
            this.m.addView(this.k, layoutParams);
            d.a(this.c).b(this.k, this.d.getIconUrl());
        }
    }

    private void c() {
        if (this.d != null && this.p == null && !TextUtils.isEmpty(this.d.getTitle())) {
            RelativeLayout relativeLayout = new RelativeLayout(this.c);
            float fA = a(this.c, 15.0f);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}, null, null));
            try {
                shapeDrawable.getPaint().setColor(Color.parseColor("#66000000"));
            } catch (Exception e) {
            }
            relativeLayout.setBackgroundDrawable(shapeDrawable);
            this.p = new TextView(this.c);
            this.p.setSingleLine(true);
            this.p.setEllipsize(TextUtils.TruncateAt.END);
            this.p.setGravity(17);
            this.p.setText(this.d.getTitle());
            this.p.setTextColor(-1);
            this.p.setTextSize(2, 12.0f);
            this.p.setPadding(a(this.c, 8.0f), 0, a(this.c, 8.0f), 0);
            double measuredWidth = getMeasuredWidth();
            Double.isNaN(measuredWidth);
            this.p.setMaxWidth((int) (measuredWidth * 0.46d));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a(this.c, 16.0f));
            layoutParams.addRule(15);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, a(this.c, 22.0f));
            layoutParams2.addRule(15);
            layoutParams2.setMargins(a(this.c, 2.0f), 0, 0, 0);
            this.m.addView(relativeLayout, layoutParams2);
            relativeLayout.addView(this.p, layoutParams);
        }
    }

    private void d() {
        if (this.m == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a(this.c, 29.0f));
            this.m = new LinearLayout(this.c);
            this.m.setOrientation(0);
            this.m.setGravity(16);
            double measuredWidth = getMeasuredWidth();
            Double.isNaN(measuredWidth);
            int i = (int) (measuredWidth * 0.04d);
            double measuredWidth2 = getMeasuredWidth();
            Double.isNaN(measuredWidth2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.setMargins(i, 0, 0, (int) (measuredWidth2 * 0.032d));
            addView(this.m, layoutParams);
        }
        if (this.j == null) {
            this.j = new ImageView(this.c);
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.component.patchad.RemotePatchAdView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    RemotePatchAdView.this.l = !RemotePatchAdView.this.l;
                    RemotePatchAdView.this.e();
                }
            });
            e();
            this.m.addView(this.j, new LinearLayout.LayoutParams(a(this.c, 22.0f), a(this.c, 22.0f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.b(this.l);
        }
        if (this.j != null) {
            if (this.l) {
                a.a().a(this.j, "ic_white_voice_mute");
            } else {
                a.a().a(this.j, "ic_white_voice");
            }
        }
    }

    private void f() {
        if (this.d == null) {
            return;
        }
        if (this.n == null && !TextUtils.isEmpty(this.d.getAdLogoUrl())) {
            this.n = new ImageView(this.c);
            this.n.setId(65537);
            this.n.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(this.c, 24.0f), a(this.c, 15.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            this.n.setVisibility(0);
            addView(this.n, layoutParams);
            d.a(this.c).b(this.n, this.d.getAdLogoUrl());
        } else if (this.n != null && this.n.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        if (this.o == null && !TextUtils.isEmpty(this.d.getBaiduLogoUrl())) {
            this.o = new ImageView(this.c);
            this.o.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(this.c, 14.0f), a(this.c, 15.0f));
            layoutParams2.addRule(12);
            layoutParams2.addRule(0, 65537);
            this.o.setVisibility(0);
            addView(this.o, layoutParams2);
            d.a(this.c).b(this.o, this.d.getBaiduLogoUrl());
            return;
        }
        if (this.o != null && this.o.getVisibility() != 0) {
            this.o.setVisibility(0);
        }
    }

    private void g() {
        if (this.f == null) {
            this.f = new c(this.c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f, layoutParams);
            this.f.a(this.q);
            this.f.e();
            this.f.i();
        }
    }

    private void h() {
        if (this.f != null && this.d != null) {
            this.f.d();
        }
    }

    private void i() {
        if (this.f != null && this.i) {
            this.f.b();
        }
    }

    private void j() {
        this.mAdLogger.b(a, "resume");
        if (this.f != null && this.i) {
            this.f.c();
        }
    }

    private void k() {
        if (this.f != null) {
            this.f.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.e != null) {
            this.e.setVisibility(4);
        }
    }

    private void a(PatchDataResponse patchDataResponse) {
        if (patchDataResponse == null) {
            return;
        }
        if (this.e == null && !TextUtils.isEmpty(patchDataResponse.getImageUrl())) {
            this.e = new ImageView(getContext());
            this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            addView(this.e, new RelativeLayout.LayoutParams(-1, -1));
            d.a(this.c).b(this.e, patchDataResponse.getImageUrl());
            return;
        }
        if (this.e != null && this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
    }

    private int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
