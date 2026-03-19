package com.sigmob.sdk.newInterstitial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.sigmob.sdk.base.views.s;
import com.sigmob.sdk.base.views.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NewInterstitialHeaderView extends RelativeLayout {
    private ImageView a;
    private TextView b;
    private ImageView c;
    private int d;
    private Runnable e;
    private w f;
    private boolean g;
    private View h;
    private a i;

    public interface a {
        void a();

        void b();
    }

    public NewInterstitialHeaderView(Context context) {
        super(context);
        a(context);
    }

    public NewInterstitialHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public NewInterstitialHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    private void a(Context context) {
        View viewInflate = inflate(context, ResourceUtil.getLayoutId(context, "sig_new_interstitial_header_layout"), this);
        this.a = (ImageView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_close"));
        this.h = viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_rl_root"));
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageBitmap(s.CLOSE_OLD.a());
        }
        this.c = (ImageView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_sound"));
        TextView textView = (TextView) viewInflate.findViewById(ResourceUtil.getId(context, "sig_ad_timer"));
        this.b = textView;
        textView.setClickable(false);
        this.e = new Runnable() { // from class: com.sigmob.sdk.newInterstitial.NewInterstitialHeaderView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NewInterstitialHeaderView.this.d > 0) {
                    NewInterstitialHeaderView.this.b.setText(String.valueOf(NewInterstitialHeaderView.b(NewInterstitialHeaderView.this)));
                    NewInterstitialHeaderView.this.b.postDelayed(NewInterstitialHeaderView.this.e, 1000L);
                    return;
                }
                if (NewInterstitialHeaderView.this.g) {
                    if (NewInterstitialHeaderView.this.i != null) {
                        NewInterstitialHeaderView.this.i.a();
                    }
                    NewInterstitialHeaderView.this.b.setVisibility(8);
                    NewInterstitialHeaderView.this.a.setVisibility(0);
                } else {
                    if (NewInterstitialHeaderView.this.i != null) {
                        NewInterstitialHeaderView.this.i.b();
                    }
                    NewInterstitialHeaderView.this.b.setClickable(true);
                    NewInterstitialHeaderView.this.b.setText("   跳过   ");
                }
                NewInterstitialHeaderView.this.removeCallbacks(this);
            }
        };
    }

    static /* synthetic */ int b(NewInterstitialHeaderView newInterstitialHeaderView) {
        int i = newInterstitialHeaderView.d;
        newInterstitialHeaderView.d = i - 1;
        return i;
    }

    public void hideSoundIcon() {
        this.c.setVisibility(8);
    }

    public void setAdHeaderViewStateListener(a listener) {
        this.i = listener;
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public void setSkipClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setSoundClickListener(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public void setSoundStatus(boolean isMute) {
        this.c.setImageResource(ResourceUtil.getDrawableId(getContext(), isMute ? "sig_image_video_mute" : "sig_image_video_unmute"));
    }

    public void showCloseView() {
        this.a.setVisibility(0);
    }

    public void showFeedback(boolean isLeft, View.OnClickListener onClickListener) {
        if (this.f == null) {
            Context context = getContext();
            w wVar = new w(context);
            this.f = wVar;
            wVar.setText("反馈");
            this.f.setOnClickListener(onClickListener);
            this.f.setId(ClientMetadata.generateViewId());
            int iDipsToIntPixels = Dips.dipsToIntPixels(5.0f, context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Dips.dipsToIntPixels(45.0f, context), Dips.dipsToIntPixels(30.0f, context));
            if (isLeft) {
                layoutParams.addRule(9);
                ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).addRule(1, this.f.getId());
                layoutParams.setMargins(iDipsToIntPixels, 0, 0, 0);
            } else {
                layoutParams.addRule(0, this.h.getId());
                layoutParams.setMargins(0, 0, iDipsToIntPixels, 0);
            }
            layoutParams.addRule(4, this.h.getId());
            ViewParent parent = this.h.getParent();
            if (parent == null) {
                return;
            }
            ((ViewGroup) parent).addView(this.f, layoutParams);
        }
    }

    public void showSoundIcon() {
        this.c.setVisibility(0);
    }

    public void startAdTimer(int seconds, boolean closeAd) {
        this.g = closeAd;
        if (seconds > 0) {
            this.b.setVisibility(0);
            this.b.setText(String.valueOf(seconds));
            this.d = seconds - 1;
            this.b.setClickable(false);
            this.b.postDelayed(this.e, 1000L);
            return;
        }
        if (closeAd) {
            showCloseView();
            a aVar = this.i;
            if (aVar != null) {
                aVar.a();
            }
            this.b.setVisibility(8);
            return;
        }
        a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.b.setClickable(true);
        this.b.setText("   跳过   ");
    }
}
