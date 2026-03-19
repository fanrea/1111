package com.kwad.components.ct.hotspot.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TrendsRollingTextContainer extends FrameLayout {
    public TextView[] aQG;
    private int aQH;
    private int aQI;
    private List<HotspotInfo> aQJ;
    private AlphaAnimation aQK;
    private AlphaAnimation aQL;
    private Runnable aQM;
    private Runnable aQN;
    public Handler mHandler;

    static /* synthetic */ int d(TrendsRollingTextContainer trendsRollingTextContainer) {
        int i = trendsRollingTextContainer.aQI;
        trendsRollingTextContainer.aQI = i + 1;
        return i;
    }

    public TrendsRollingTextContainer(Context context) {
        super(context);
        this.aQG = new TextView[2];
        this.aQH = 0;
        this.aQI = 0;
        this.aQJ = new ArrayList();
        this.aQK = null;
        this.aQL = null;
        this.aQM = new Runnable() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.e(trendsRollingTextContainer.aQG[TrendsRollingTextContainer.this.aQH]);
                TrendsRollingTextContainer.this.mHandler.removeCallbacks(TrendsRollingTextContainer.this.aQN);
                TrendsRollingTextContainer.this.mHandler.postDelayed(TrendsRollingTextContainer.this.aQN, 200L);
            }
        };
        this.aQN = new Runnable() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (TrendsRollingTextContainer.this.aQJ.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer.this.aQG[1 - TrendsRollingTextContainer.this.aQH].setText(((HotspotInfo) TrendsRollingTextContainer.this.aQJ.get(TrendsRollingTextContainer.this.aQI % TrendsRollingTextContainer.this.aQJ.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.d(trendsRollingTextContainer.aQG[1 - TrendsRollingTextContainer.this.aQH]);
                }
            }
        };
        init();
    }

    public TrendsRollingTextContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQG = new TextView[2];
        this.aQH = 0;
        this.aQI = 0;
        this.aQJ = new ArrayList();
        this.aQK = null;
        this.aQL = null;
        this.aQM = new Runnable() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.e(trendsRollingTextContainer.aQG[TrendsRollingTextContainer.this.aQH]);
                TrendsRollingTextContainer.this.mHandler.removeCallbacks(TrendsRollingTextContainer.this.aQN);
                TrendsRollingTextContainer.this.mHandler.postDelayed(TrendsRollingTextContainer.this.aQN, 200L);
            }
        };
        this.aQN = new Runnable() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (TrendsRollingTextContainer.this.aQJ.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer.this.aQG[1 - TrendsRollingTextContainer.this.aQH].setText(((HotspotInfo) TrendsRollingTextContainer.this.aQJ.get(TrendsRollingTextContainer.this.aQI % TrendsRollingTextContainer.this.aQJ.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.d(trendsRollingTextContainer.aQG[1 - TrendsRollingTextContainer.this.aQH]);
                }
            }
        };
        init();
    }

    public TrendsRollingTextContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQG = new TextView[2];
        this.aQH = 0;
        this.aQI = 0;
        this.aQJ = new ArrayList();
        this.aQK = null;
        this.aQL = null;
        this.aQM = new Runnable() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.e(trendsRollingTextContainer.aQG[TrendsRollingTextContainer.this.aQH]);
                TrendsRollingTextContainer.this.mHandler.removeCallbacks(TrendsRollingTextContainer.this.aQN);
                TrendsRollingTextContainer.this.mHandler.postDelayed(TrendsRollingTextContainer.this.aQN, 200L);
            }
        };
        this.aQN = new Runnable() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public final void run() {
                if (TrendsRollingTextContainer.this.aQJ.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer.this.aQG[1 - TrendsRollingTextContainer.this.aQH].setText(((HotspotInfo) TrendsRollingTextContainer.this.aQJ.get(TrendsRollingTextContainer.this.aQI % TrendsRollingTextContainer.this.aQJ.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.d(trendsRollingTextContainer.aQG[1 - TrendsRollingTextContainer.this.aQH]);
                }
            }
        };
        init();
    }

    private void init() {
        this.mHandler = new Handler(getContext().getMainLooper());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
        this.aQG[0] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name1);
        this.aQG[1] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name2);
    }

    public final void release() {
        setOnClickListener(null);
        AlphaAnimation alphaAnimation = this.aQK;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
            this.aQK.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation2 = this.aQL;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
            this.aQL.setAnimationListener(null);
        }
        stopScroll();
    }

    public final void K(List<HotspotInfo> list) {
        initView();
        this.aQJ = list;
        this.aQH = 0;
        this.aQI = 0;
        if (list.size() == 1) {
            IY();
            setVisibility(0);
        } else {
            if (this.aQJ.size() >= 2) {
                IY();
                setVisibility(0);
                Ja();
                IZ();
                return;
            }
            setVisibility(8);
        }
    }

    public final void stopScroll() {
        this.mHandler.removeCallbacks(this.aQN);
        this.mHandler.removeCallbacks(this.aQM);
        IY();
    }

    private void IY() {
        if (this.aQJ.size() > 0) {
            TextView textView = this.aQG[this.aQH];
            List<HotspotInfo> list = this.aQJ;
            textView.setText(list.get(this.aQI % list.size()).name);
            this.aQG[this.aQH].setVisibility(0);
            this.aQG[1 - this.aQH].setVisibility(8);
        }
    }

    public final void IZ() {
        if (this.aQJ.size() > 1) {
            this.mHandler.removeCallbacks(this.aQM);
            this.mHandler.postDelayed(this.aQM, 2000L);
        }
    }

    private void Ja() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.aQK = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.aQK.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer.this.aQG[TrendsRollingTextContainer.this.aQH].setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer.this.aQG[TrendsRollingTextContainer.this.aQH].setVisibility(8);
            }
        });
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.aQL = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.aQL.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ct.hotspot.view.TrendsRollingTextContainer.4
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer.this.aQG[1 - TrendsRollingTextContainer.this.aQH].setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer.this.aQG[1 - TrendsRollingTextContainer.this.aQH].setVisibility(0);
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.aQH = 1 - trendsRollingTextContainer.aQH;
                TrendsRollingTextContainer.this.IZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(TextView textView) {
        AlphaAnimation alphaAnimation = this.aQL;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(TextView textView) {
        AlphaAnimation alphaAnimation = this.aQK;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }
}
