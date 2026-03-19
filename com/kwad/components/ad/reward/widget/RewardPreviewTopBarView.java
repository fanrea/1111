package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    private String FY;
    private String FZ;
    private ProgressBar Ga;
    private TextView Gb;
    private long Gc;
    private long Gd;
    private boolean Ge;
    private a Gf;
    private ImageView ej;
    private TextView xN;

    public interface a {
        void G(boolean z);

        void H(boolean z);
    }

    public RewardPreviewTopBarView(Context context) {
        super(context);
        this.FY = " 秒后即可获得奖励";
        this.FZ = "恭喜你获得奖励";
        this.Gc = -1L;
        this.Ge = false;
    }

    public RewardPreviewTopBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FY = " 秒后即可获得奖励";
        this.FZ = "恭喜你获得奖励";
        this.Gc = -1L;
        this.Ge = false;
    }

    public RewardPreviewTopBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FY = " 秒后即可获得奖励";
        this.FZ = "恭喜你获得奖励";
        this.Gc = -1L;
        this.Ge = false;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        inflate(getContext(), R.layout.ksad_activity_preview_topbar, this);
        this.Ga = (ProgressBar) findViewById(R.id.ksad_preview_topbar_progress);
        this.xN = (TextView) findViewById(R.id.ksad_preview_topbar_reward_tips);
        this.Gb = (TextView) findViewById(R.id.ksad_preview_topbar_reward_count);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_preview_topbar_close);
        this.ej = imageView;
        imageView.setVisibility(8);
        this.ej.setOnClickListener(this);
    }

    public void setRewardTips(String str) {
        TextView textView = this.xN;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public void setCloseBtnDelayShowDuration(long j) {
        this.Gd = j;
        if (j <= 0) {
            this.ej.setVisibility(0);
        }
    }

    public void setTotalCountDuration(long j) {
        this.Gc = j;
        this.Ga.setMax((int) j);
    }

    public void setTopBarListener(a aVar) {
        this.Gf = aVar;
    }

    public final void s(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        TextView textView = this.Gb;
        if (textView != null) {
            textView.setText(iCeil + this.FY);
        }
        e(j, this.Gc);
        if (this.Gc - j >= this.Gd && this.ej.getVisibility() != 0) {
            this.ej.setVisibility(0);
        }
        if (iCeil <= 0) {
            e(true, false);
        }
    }

    public final boolean lr() {
        return this.Ge;
    }

    private void e(boolean z, boolean z2) {
        if (!this.Ge) {
            this.xN.setVisibility(8);
            this.Gb.setText(this.FZ);
            a aVar = this.Gf;
            if (aVar != null) {
                aVar.H(false);
            }
        } else {
            this.xN.setVisibility(0);
        }
        this.Ge = true;
    }

    private void e(long j, long j2) {
        this.Ga.setProgress((int) (j2 - j));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (!view.equals(this.ej) || (aVar = this.Gf) == null) {
            return;
        }
        aVar.G(this.Ge);
    }
}
