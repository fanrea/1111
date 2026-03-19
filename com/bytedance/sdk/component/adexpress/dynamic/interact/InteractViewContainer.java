package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import com.ss.ttm.player.MediaPlayer;
import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class InteractViewContainer extends FrameLayout implements gb {
    private String an;
    private com.bytedance.sdk.component.adexpress.dynamic.b.h b;
    private View c;
    private Context d;
    private View.OnTouchListener gb;
    private RippleView h;
    private DynamicBaseWidget hc;
    private com.bytedance.sdk.component.adexpress.dynamic.b.tc mk;
    private com.bytedance.sdk.component.adexpress.hc.uo mq;
    private boolean tc;
    private int tt;
    private h u;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar) {
        super(context);
        this.d = context;
        this.hc = dynamicBaseWidget;
        this.b = hVar;
        h();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.b.h hVar, com.bytedance.sdk.component.adexpress.dynamic.b.tc tcVar, com.bytedance.sdk.component.adexpress.hc.uo uoVar) {
        super(context);
        this.d = context;
        this.hc = dynamicBaseWidget;
        this.b = hVar;
        this.mk = tcVar;
        this.mq = uoVar;
        h();
    }

    private void h() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.an = this.b.tr();
        this.tt = this.b.wl();
        this.tc = this.b.ra();
        h hVarD = tt.d(this.d, this.hc, this.b, this.mk, this.mq);
        this.u = hVarD;
        if (hVarD != null) {
            this.c = hVarD.b();
            if (this.b.nv()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.an, "6")) {
                if (this.b.rw() && !TextUtils.isEmpty(this.b.ia())) {
                    this.h = new RippleView(this.d, com.bytedance.sdk.component.adexpress.dynamic.b.h.d(this.b.ia()));
                } else {
                    this.h = new RippleView(this.d, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.d);
                frameLayout.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.h.hc();
                    }
                });
            }
            if (d(this.an) && com.bytedance.sdk.component.adexpress.c.d()) {
                int color = Color.parseColor("#99000000");
                if (this.b.rw() && !TextUtils.isEmpty(this.b.ia())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.b.h.d(this.b.ia());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.d);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.u.b());
            d(this.u.b());
            setVisibility(0);
        }
    }

    private boolean d(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gb instanceof com.bytedance.sdk.component.adexpress.dynamic.interact.d.b) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void d(ViewGroup viewGroup) {
        if (this.c == null) {
            return;
        }
        String str = this.an;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 2;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c = 4;
                    break;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    c = 5;
                    break;
                }
                break;
            case 56:
                if (str.equals(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD)) {
                    c = 6;
                    break;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    c = 7;
                    break;
                }
                break;
            case 1567:
                if (str.equals(PointType.SIGMOB_APP)) {
                    c = '\b';
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c = '\t';
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c = '\n';
                    break;
                }
                break;
            case 1570:
                if (str.equals(PointType.SIGMOB_REPORT_TRACKING)) {
                    c = 11;
                    break;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    c = '\f';
                    break;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1574:
                if (str.equals(PointType.LOAD_READY)) {
                    c = 14;
                    break;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    c = 15;
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    c = 16;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ADDITION_SUB_INFO /* 1600 */:
                if (str.equals("22")) {
                    c = 17;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUBTITLE_SENSE_BUFFERING /* 1601 */:
                if (str.equals("23")) {
                    c = 18;
                    break;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUBTITLE_LAZY_LOADING /* 1602 */:
                if (str.equals("24")) {
                    c = 19;
                    break;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    c = 20;
                    break;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    c = 21;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.u(this, this.tt);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.b.rw() || TextUtils.isEmpty(this.b.ia())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.an(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.hc(this, this);
                break;
            case 3:
                if (this.b.rw() && !TextUtils.isEmpty(this.b.ia())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.b.h.d(this.b.ia()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.b(this);
                this.c.setTag(2);
                break;
            case 6:
            case '\t':
                this.hc.setClipChildren(false);
                this.hc.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.hc.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.an(this);
                break;
            case 7:
            case 14:
                this.c.setTag(2);
                break;
            case '\b':
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.c(this, this.tt, this.tc);
                break;
            case '\n':
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.b(this);
                this.c.setTag(2);
                break;
            case 11:
            case 19:
                if (this.an.equals("24") && com.bytedance.sdk.component.adexpress.c.d()) {
                    this.hc.setClipChildren(false);
                    this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.an(this);
                    break;
                } else {
                    this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.u(this, this.tt);
                    break;
                }
                break;
            case '\f':
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.hc(this, this);
                break;
            case '\r':
                View view = this.c;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.c).getShakeLayout().setTag(2);
                }
                this.c.setTag(2);
                break;
            case 15:
                View view2 = this.c;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.c).getWriggleLayout().setTag(2);
                }
                this.c.setTag(2);
                break;
            case 16:
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.d(this, this.tt, viewGroup);
                break;
            case 17:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.gb(this, this.tc);
                    break;
                } else {
                    this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.h(this, this.tt, viewGroup);
                    break;
                }
            case 18:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.an(this);
                    break;
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.c.d()) {
                    this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.gb(this, this.tc);
                    break;
                }
                break;
            case 21:
                View view3 = this.c;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.c).getShakeView().setTag(2);
                }
                this.gb = new com.bytedance.sdk.component.adexpress.dynamic.interact.d.u(this, this.tt);
                break;
        }
        View.OnTouchListener onTouchListener = this.gb;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (gb()) {
            this.c.setTag(2);
            setOnClickListener((View.OnClickListener) this.hc.getDynamicClickListener());
        }
    }

    private boolean gb() {
        return (this.b.ra() || TextUtils.equals("9", this.an) || TextUtils.equals("16", this.an) || TextUtils.equals(PointType.LOAD_READY, this.an) || TextUtils.equals("18", this.an) || TextUtils.equals("20", this.an) || TextUtils.equals("29", this.an) || TextUtils.equals(PointType.SIGMOB_APP, this.an)) ? false : true;
    }

    public void b() {
        h hVar = this.u;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void c() {
        h hVar = this.u;
        if (hVar != null) {
            hVar.hc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            h hVar = this.u;
            if (hVar != null) {
                hVar.hc();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.b(e.getMessage());
        }
    }

    public void u() {
        if (this.c != null && TextUtils.equals(this.an, "2")) {
            View view = this.c;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).b();
            }
        }
    }

    public void an() {
        if (this.c != null && TextUtils.equals(this.an, "2")) {
            View view = this.c;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).c();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.gb
    public void d() {
        if (TextUtils.equals(this.an, "6")) {
            RippleView rippleView = this.h;
            if (rippleView != null) {
                rippleView.b();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.tt();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.an, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.tt();
                }
            }, 400L);
        } else {
            tt();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.gb
    public void hc() {
        if (gb()) {
            setOnClickListener((View.OnClickListener) this.hc.getDynamicClickListener());
            performClick();
            if (this.b.nf()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        if (this.gb != null) {
            setOnClickListener((View.OnClickListener) this.hc.getDynamicClickListener());
            performClick();
            if (this.b.nf()) {
                return;
            }
            setVisibility(8);
        }
    }
}
