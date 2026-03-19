package com.component.feed;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.bv;
import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class m extends a {
    public static final String U = "view_not_in_screen";
    public static final String V = "view_at_invalid_location_in_screen";
    public static final String W = "view_loss_window_focus";
    public static final String a = "CpuVideoViewWrapper";
    public static final String aa = "user_click_pause_icon";
    public static final String ab = "user_click_other_play_icon";
    public static final String ac = "ad_in_valid_location";
    public static final String ad = "content_in_valid_location";
    public static final String ae = "user_replay";
    public static final String af = "user_play";
    private static final int at = 23;
    public boolean T;
    private ImageView ag;
    private boolean ah;
    private boolean ai;
    private Runnable aj;
    private TextView ak;
    private SeekBar al;
    private TextView am;
    private TextView an;
    private boolean ao;
    private ImageView ap;
    private float aq;
    private ImageView ar;
    private LinearLayout as;
    private Handler au;
    private HandlerThread av;
    private final Handler aw;
    private volatile boolean ax;
    private boolean ay;
    private com.baidu.mobads.container.landingpage.al az;

    public m(Context context) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context);
        this.ah = false;
        this.T = false;
        this.aq = 1.0f;
        this.ay = false;
        R();
        T();
        U();
        this.aw = new Handler(Looper.getMainLooper(), new n(this));
    }

    @Override // com.component.feed.a
    public void c(Object obj) throws NoSuchFieldException {
        super.c(obj);
        this.aq = 1.0f;
        if (obj instanceof com.baidu.mobads.container.nativecpu.a) {
            this.r = (com.baidu.mobads.container.nativecpu.a) obj;
        } else {
            Field declaredField = obj.getClass().getDeclaredField("mInstance");
            declaredField.setAccessible(true);
            this.r = (com.baidu.mobads.container.nativecpu.a) declaredField.get(obj);
            if (((com.baidu.mobads.container.nativecpu.a) this.r).h() != null) {
                f(((com.baidu.mobads.container.nativecpu.a) this.r).g());
            }
            if (this.r.getMaterialType() == AbstractData.a.VIDEO) {
                e(obj);
                k();
            }
        }
        t();
        this.ax = N();
        this.ay = ((com.baidu.mobads.container.nativecpu.a) this.r).isCanGoLp();
        this.ah = false;
        this.T = false;
        this.P = false;
        this.ai = false;
        if (this.ap != null) {
            com.component.b.a.a().a(this.ap, "ic_white_voice_mute");
        }
        if (this.ag != null) {
            this.ag.setVisibility(0);
            com.component.b.a.a().a(this.ag, "ic_white_pause_gray_round");
        }
        if (this.am != null) {
            int duration = ((com.baidu.mobads.container.nativecpu.a) this.r).getDuration();
            this.am.setText(String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(duration / 60), Integer.valueOf(duration % 60)));
        }
        if (this.an != null) {
            int duration2 = ((com.baidu.mobads.container.nativecpu.a) this.r).getDuration();
            this.an.setText(String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(duration2 / 60), Integer.valueOf(duration2 % 60)));
            this.an.setVisibility(0);
        }
        if (this.al != null) {
            this.al.setMax(((com.baidu.mobads.container.nativecpu.a) this.r).getDuration() * 1000);
        }
        if (this.ar != null) {
            com.component.b.a.a().a(this.ar, "ic_white_speed100");
        }
        if (this.x != null) {
            this.x.setOnClickListener(new q(this));
        }
    }

    public void a() {
        i();
        j();
        this.aq = 1.0f;
        this.T = false;
        this.P = false;
        if (this.ar != null) {
            com.component.b.a.a().a(this.ar, "ic_white_speed100");
        }
    }

    @Override // com.component.feed.a
    protected void b() {
        this.ah = true;
        if (this.ag != null) {
            com.component.b.a.a().a(this.ag, "ic_video_play");
            this.ag.postDelayed(new u(this), 1000L);
        }
        if (this.an != null) {
            this.an.setVisibility(8);
        }
        J();
    }

    @Override // com.component.feed.a
    protected void c() {
        this.ah = false;
        if (this.ag != null) {
            this.ag.setVisibility(0);
            com.component.b.a.a().a(this.ag, "ic_white_voice_mute");
        }
    }

    @Override // com.component.feed.a
    protected void d() {
        this.ah = true;
        if (this.ag != null) {
            this.ag.setVisibility(0);
            com.component.b.a.a().a(this.ag, "ic_video_play");
            this.ag.postDelayed(new v(this), 2000L);
        }
        if (this.an.getVisibility() == 0) {
            this.an.setVisibility(8);
        }
        if (this.ar.getVisibility() == 0) {
            this.ar.setVisibility(8);
        }
        J();
    }

    private void J() {
        boolean zC = k.a().c();
        float fD = k.a().d();
        if (this.x != null) {
            this.x.b(zC);
            this.x.a(fD);
        }
        if (this.ap != null) {
            com.component.b.a.a().a(this.ap, zC ? "ic_white_voice_mute" : "ic_white_voice");
        }
        if (this.ar != null) {
            if (fD == 0.75f) {
                com.component.b.a.a().a(this.ar, "ic_white_speed075");
                return;
            }
            if (fD == 1.0f) {
                com.component.b.a.a().a(this.ar, "ic_white_speed100");
                return;
            }
            if (fD == 1.25f) {
                com.component.b.a.a().a(this.ar, "ic_white_speed125");
                return;
            }
            if (fD == 1.5f) {
                com.component.b.a.a().a(this.ar, "ic_white_speed150");
            } else if (fD == 1.75f) {
                com.component.b.a.a().a(this.ar, "ic_white_speed175");
            } else if (fD == 2.0f) {
                com.component.b.a.a().a(this.ar, "ic_white_speed200");
            }
        }
    }

    @Override // com.component.feed.a
    protected void e() {
        this.ah = false;
    }

    @Override // com.component.feed.a
    protected void f() {
        this.ah = false;
        this.T = true;
        if (!P()) {
            this.as.setVisibility(4);
            this.ag.setVisibility(0);
            com.component.b.a.a().a(this.ag, "ic_white_replay_gray_round");
            this.an.setVisibility(0);
            return;
        }
        this.ag.setVisibility(8);
        this.as.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q();
        S();
        this.aj = new w(this);
        postDelayed(this.aj, 500L);
        L();
        K();
    }

    private void K() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.az = new com.baidu.mobads.container.landingpage.al();
        this.az.a(new x(this));
        new com.component.c.b(getContext()).a(this.az, intentFilter);
    }

    private void L() {
        this.av = new HandlerThread("cpu-video-monitor");
        this.av.start();
        this.au = new Handler(this.av.getLooper(), new z(this));
        this.au.sendEmptyMessageDelayed(23, 200L);
    }

    public synchronized void c(String str) {
        if (this.ah) {
            return;
        }
        if (ae.equals(str) || af.equals(str)) {
            if (ae.equals(str)) {
                l();
            } else if (af.equals(str)) {
                n();
            }
            this.ai = true;
            this.ah = true;
        } else if ((ad.equals(str) || ac.equals(str)) && this.ax && !this.T && !this.P) {
            n();
            this.ah = true;
        }
    }

    public synchronized void d(String str) {
        if (this.ah && (U.equals(str) || W.equals(str) || aa.equals(str) || ab.equals(str))) {
            m();
            this.ah = false;
            if (aa.equals(str) || ab.equals(str)) {
                this.P = true;
            }
        }
        if (this.ah && !this.ai) {
            m();
            this.ah = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k.a().a(this);
        removeCallbacks(this.aj);
        this.aj = null;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                this.av.quitSafely();
            } else {
                this.av.quit();
            }
            this.au.removeCallbacksAndMessages(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        M();
    }

    private void M() {
        if (this.az != null) {
            new com.component.c.b(getContext()).a(this.az);
        }
    }

    private boolean N() {
        if (!(this.r instanceof com.baidu.mobads.container.nativecpu.a)) {
            return false;
        }
        if (P()) {
            if (com.baidu.mobads.container.util.ab.f(getContext())) {
                return true;
            }
            return ((com.baidu.mobads.container.nativecpu.a) this.r).isAutoplay();
        }
        return ((com.baidu.mobads.container.nativecpu.a) this.r).isAutoplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int O() {
        boolean globalVisibleRect;
        if (!hasWindowFocus()) {
            return -2;
        }
        Rect rect = new Rect();
        try {
            globalVisibleRect = getGlobalVisibleRect(rect);
        } catch (Exception e) {
            e.printStackTrace();
            globalVisibleRect = false;
        }
        if (!globalVisibleRect) {
            return 0;
        }
        if (P()) {
            int measuredHeight = getMeasuredHeight() * getMeasuredWidth();
            int iHeight = rect.height() * rect.width();
            if (isShown() && iHeight * 10 >= measuredHeight * 6) {
                return 1;
            }
        } else {
            int i = getContext().getResources().getDisplayMetrics().heightPixels;
            int measuredHeight2 = getMeasuredHeight() * getMeasuredWidth();
            int iHeight2 = rect.height() * rect.width();
            if (isShown() && rect.bottom * 2 * 10 < i * 12 && rect.bottom > 0 && iHeight2 * 10 >= measuredHeight2 * 6) {
                return 2;
            }
        }
        return -1;
    }

    private boolean P() {
        return (this.r == null || !"ad".equals(((com.baidu.mobads.container.nativecpu.a) this.r).getType()) || TextUtils.isEmpty(((com.baidu.mobads.container.nativecpu.a) this.r).getVUrl())) ? false : true;
    }

    private void Q() {
        if (this.r == null) {
            return;
        }
        int duration = ((com.baidu.mobads.container.nativecpu.a) this.r).getDuration();
        String str = String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(duration / 60), Integer.valueOf(duration % 60));
        if (this.an != null) {
            this.an.setText(str);
        }
    }

    private void R() {
        this.an = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = 20;
        layoutParams.rightMargin = 20;
        this.an.setTextColor(-1);
        if (com.baidu.mobads.container.util.x.a(this.y).a() >= 16) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f}, null, null));
            shapeDrawable.getPaint().setColor(-16777216);
            shapeDrawable.setPadding(4, 4, 4, 4);
            this.an.setBackground(shapeDrawable);
        }
        addView(this.an, layoutParams);
    }

    private void S() {
        if (this.r == null || this.al == null || this.am == null) {
            return;
        }
        this.al.setMax(((com.baidu.mobads.container.nativecpu.a) this.r).getDuration() * 1000);
        int duration = ((com.baidu.mobads.container.nativecpu.a) this.r).getDuration();
        this.am.setText(String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(duration / 60), Integer.valueOf(duration % 60)));
    }

    private void T() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.as = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.as.setOrientation(0);
        layoutParams.addRule(12);
        this.ap = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(getContext(), 20.0f), com.baidu.mobads.container.util.ab.a(getContext(), 20.0f));
        layoutParams2.gravity = 17;
        com.component.b.a.a().a(this.ap, "ic_white_voice_mute");
        this.as.addView(this.ap, layoutParams2);
        this.ap.setOnClickListener(new ab(this));
        this.ak = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(bv.a(getContext(), 55.0f), bv.a(getContext(), 20.0f));
        this.ak.setTextSize(14.0f);
        layoutParams3.gravity = 17;
        this.ak.setTextColor(-1);
        this.as.addView(this.ak, layoutParams3);
        this.al = new SeekBar(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.weight = 1.0f;
        if (com.baidu.mobads.container.util.x.a(this.y).a() >= 29) {
            this.al.setMinHeight(com.baidu.mobads.container.util.ab.a(getContext(), 3.0f));
            this.al.setMaxHeight(com.baidu.mobads.container.util.ab.a(getContext(), 3.0f));
        } else {
            try {
                Class<? super Object> superclass = this.al.getClass().getSuperclass().getSuperclass();
                Field declaredField = superclass.getDeclaredField("mMaxHeight");
                declaredField.setAccessible(true);
                declaredField.set(this.al, Integer.valueOf(com.baidu.mobads.container.util.ab.a(getContext(), 3.0f)));
                Field declaredField2 = superclass.getDeclaredField("mMinHeight");
                declaredField2.setAccessible(true);
                declaredField2.set(this.al, Integer.valueOf(com.baidu.mobads.container.util.ab.a(getContext(), 3.0f)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        layoutParams4.gravity = 16;
        RoundRectShape roundRectShape = new RoundRectShape(new float[]{8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f}, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(-7829368);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(roundRectShape);
        shapeDrawable2.getPaint().setColor(-1);
        this.al.setProgressDrawable(new LayerDrawable(new Drawable[]{shapeDrawable, new ClipDrawable(shapeDrawable2, GravityCompat.START, 1)}));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        int[] iArr = {-1, 1308622847};
        if (com.baidu.mobads.container.util.x.a(this.y).a() >= 16) {
            gradientDrawable.setColors(iArr);
        }
        gradientDrawable.setGradientType(1);
        gradientDrawable.setGradientRadius(25.0f);
        gradientDrawable.setDither(true);
        gradientDrawable.setSize(50, 50);
        this.al.setThumb(gradientDrawable);
        this.al.setThumbOffset(0);
        this.al.setOnSeekBarChangeListener(new ac(this));
        this.as.addView(this.al, layoutParams4);
        this.am = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.rightMargin = com.baidu.mobads.container.util.ab.a(getContext(), 5.0f);
        this.am.setTextColor(-1);
        this.as.addView(this.am, layoutParams5);
        addView(this.as, layoutParams);
        this.as.setVisibility(4);
    }

    private void U() {
        this.ag = new ImageView(getContext());
        com.component.b.a.a().a(this.ag, "ic_white_voice_mute");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(getContext(), 38.0f), com.baidu.mobads.container.util.ab.a(getContext(), 38.0f));
        layoutParams.addRule(13);
        addView(this.ag, layoutParams);
        this.ag.setOnClickListener(new o(this));
        this.ar = new ImageView(getContext());
        if (P()) {
            this.ar.setVisibility(8);
        }
        com.component.b.a.a().a(this.ar, "ic_white_speed100");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(getContext(), 23.0f), com.baidu.mobads.container.util.ab.a(getContext(), 23.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        addView(this.ar, layoutParams2);
        this.ar.setVisibility(8);
        this.ar.setOnClickListener(new p(this));
    }

    @Override // com.component.feed.a
    protected void a(Object obj) throws NoSuchFieldException {
        if (this.r == null) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("mInstance");
                declaredField.setAccessible(true);
                this.r = (com.baidu.mobads.container.nativecpu.a) declaredField.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean h() {
        return this.ah;
    }

    public com.baidu.mobads.container.nativecpu.a I() {
        if (this.r instanceof com.baidu.mobads.container.nativecpu.a) {
            return (com.baidu.mobads.container.nativecpu.a) this.r;
        }
        return null;
    }
}
