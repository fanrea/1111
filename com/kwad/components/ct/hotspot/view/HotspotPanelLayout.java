package com.kwad.components.ct.hotspot.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ct.e.b;
import com.kwad.components.ct.hotspot.d;
import com.kwad.components.ct.hotspot.e;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.c.a.a;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HotspotPanelLayout extends LinearLayout {
    private RelativeLayout aQB;
    private LinearLayout aQC;
    private TranslateAnimation aQD;
    private HotspotListRecyclerView aQE;
    private e aqP;
    private SceneImpl mSceneImpl;

    public HotspotPanelLayout(Context context) {
        super(context);
    }

    public HotspotPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HotspotPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_trend_list_panel_space);
        this.aQC = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.hotspot.view.HotspotPanelLayout.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotspotPanelLayout.this.cH(3);
            }
        });
        this.aQB = (RelativeLayout) findViewById(R.id.ksad_trend_list_panel_layout);
        this.aQE = (HotspotListRecyclerView) findViewById(R.id.ksad_host_list);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_trend_list_panel_close_button);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((TextView) findViewById(R.id.ksad_trend_panel_title)).getLayoutParams();
        layoutParams.addRule(9);
        layoutParams.leftMargin = a.a(getContext(), 16.0f);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.hotspot.view.HotspotPanelLayout.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HotspotPanelLayout.this.cH(1);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.hotspot.view.HotspotPanelLayout.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
    }

    public final void a(List<HotspotInfo> list, HotspotInfo hotspotInfo, SceneImpl sceneImpl) {
        this.mSceneImpl = sceneImpl;
        J(list);
        this.aQE.a(list, hotspotInfo);
        this.aQE.setItemClickListener(new d() { // from class: com.kwad.components.ct.hotspot.view.HotspotPanelLayout.4
            @Override // com.kwad.components.ct.hotspot.d
            public final void a(View view, HotspotInfo hotspotInfo2, int i) {
                if (HotspotPanelLayout.this.aqP != null) {
                    HotspotPanelLayout.this.aqP.a(view, hotspotInfo2, i);
                }
                b.JK().d(HotspotPanelLayout.this.mSceneImpl, hotspotInfo2);
                HotspotPanelLayout.this.cH(4);
            }

            @Override // com.kwad.components.ct.hotspot.d
            public final void c(HotspotInfo hotspotInfo2) {
                b.JK().c(HotspotPanelLayout.this.mSceneImpl, hotspotInfo2);
            }
        });
    }

    private static void J(List<HotspotInfo> list) {
        Iterator<HotspotInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().mHotPhotoImpressionReported = false;
        }
    }

    public void setHotspotPanelListener(e eVar) {
        this.aqP = eVar;
    }

    public final void show() {
        this.aQB.setVisibility(0);
        this.aQC.setVisibility(0);
        setVisibility(0);
        cD();
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() { // from class: com.kwad.components.ct.hotspot.view.HotspotPanelLayout.5
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1 || i != 4) {
                    return false;
                }
                HotspotPanelLayout.this.cH(5);
                return true;
            }
        });
        e eVar = this.aqP;
        if (eVar != null) {
            eVar.zp();
        }
        b.JK().e(this.mSceneImpl);
    }

    public final void cH(int i) {
        setFocusableInTouchMode(false);
        clearFocus();
        setOnKeyListener(null);
        IX();
        e eVar = this.aqP;
        if (eVar != null) {
            eVar.bB(i);
        }
        b.JK().b(this.mSceneImpl, i);
    }

    public final void release() {
        this.aqP = null;
        TranslateAnimation translateAnimation = this.aQD;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        setFocusableInTouchMode(false);
        clearFocus();
        setOnKeyListener(null);
    }

    private void cD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        this.aQD = translateAnimation;
        translateAnimation.setDuration(300L);
        this.aQD.setInterpolator(AnimationUtils.loadInterpolator(getContext(), android.R.anim.accelerate_decelerate_interpolator));
        this.aQB.startAnimation(this.aQD);
    }

    private void IX() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        this.aQD = translateAnimation;
        translateAnimation.setDuration(300L);
        this.aQD.setInterpolator(AnimationUtils.loadInterpolator(getContext(), android.R.anim.accelerate_decelerate_interpolator));
        this.aQD.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ct.hotspot.view.HotspotPanelLayout.6
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                HotspotPanelLayout.this.aQB.setVisibility(8);
                HotspotPanelLayout.this.aQC.setVisibility(8);
                HotspotPanelLayout.this.setVisibility(8);
            }
        });
        this.aQB.startAnimation(this.aQD);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
