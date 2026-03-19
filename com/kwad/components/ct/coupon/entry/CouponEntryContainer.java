package com.kwad.components.ct.coupon.entry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ct.coupon.entry.d;
import com.kwad.components.ct.coupon.model.CouponStatus;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CouponEntryContainer extends FrameLayout {
    private LottieAnimationView anA;
    private LinearLayout anB;
    private LinearLayout anC;
    private ImageView anD;
    private b anE;
    private CouponEntryProgress anv;
    private TextView anw;
    private TextView anx;
    private TextView any;
    private ImageView anz;

    public CouponEntryContainer(Context context) {
        super(context);
        this.anE = null;
    }

    public CouponEntryContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anE = null;
    }

    public CouponEntryContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anE = null;
    }

    public void setCloseListener(b bVar) {
        this.anE = bVar;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.anv = (CouponEntryProgress) findViewById(R.id.ksad_coupon_entry);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_coupon_entry_close_btn);
        this.anD = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.coupon.entry.CouponEntryContainer.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponEntryContainer.this.setVisibility(8);
                if (CouponEntryContainer.this.anE != null) {
                    CouponEntryContainer.this.anE.onClosed();
                }
            }
        });
        this.anz = (ImageView) findViewById(R.id.ksad_coupon_entry_image);
        ImageLoaderProxy.INSTANCE.load(this.anz, com.kwad.sdk.core.network.idc.a.aaw().fu("https://static.yximgs.com/udata/pkg/KSAdSDK/coupon/ksad_coupon_entry_status_0.webp"), new com.kwad.components.core.e.a());
        this.anA = (LottieAnimationView) findViewById(R.id.ksad_coupon_entry_image_lottie);
        this.anB = (LinearLayout) findViewById(R.id.ksad_coupon_entry_amount_layout);
        this.anC = (LinearLayout) findViewById(R.id.ksad_coupon_entry_play_count_layout);
        this.any = (TextView) findViewById(R.id.ksad_coupon_entry_current_total_amount);
        this.anw = (TextView) findViewById(R.id.ksad_coupon_entry_current_play_count);
        this.anx = (TextView) findViewById(R.id.ksad_coupon_entry_coupon_play_limit);
    }

    public void setCouponVideoThreshold(int i) {
        this.anx.setText(String.valueOf(i));
    }

    public void setCouponEntryPlayCount(int i) {
        this.anw.setText(String.valueOf(i));
    }

    public void setCouponEntryCurrentTotalAmount(double d) {
        if (d < 100.0d) {
            this.any.setText(String.format("%.2f", Double.valueOf(d)));
        } else {
            this.any.setText(String.format("%.1f", Double.valueOf(d)));
        }
    }

    public final void c(CouponStatus couponStatus) {
        String str;
        setCouponEntryCurrentTotalAmount(couponStatus.getCurrTotalAmount());
        setCouponEntryPlayCount(couponStatus.currentWatchVideoCount);
        setCouponVideoThreshold(couponStatus.getCouponVideoThreshold());
        int statusCode = couponStatus.getStatusCode();
        if (statusCode == 3) {
            this.anz.setVisibility(0);
            this.anA.setVisibility(8);
            this.anB.setVisibility(8);
            this.anC.setVisibility(8);
            str = "https://static.yximgs.com/udata/pkg/KSAdSDK/coupon/ksad_coupon_entry_status_3.webp";
        } else if (statusCode == 2) {
            this.anB.setVisibility(8);
            this.anC.setVisibility(8);
            this.anz.setVisibility(8);
            bz(R.raw.ksad_coupon_status_2_anim);
            str = "https://static.yximgs.com/udata/pkg/KSAdSDK/coupon/ksad_coupon_entry_status_2.webp";
        } else if (statusCode == 1) {
            this.anz.setVisibility(0);
            this.anA.setVisibility(8);
            this.anB.setVisibility(0);
            this.anC.setVisibility(8);
            str = "https://static.yximgs.com/udata/pkg/KSAdSDK/coupon/ksad_coupon_entry_status_1.webp";
        } else if (couponStatus.isWaitingOpen()) {
            this.anB.setVisibility(8);
            this.anC.setVisibility(8);
            this.anz.setVisibility(8);
            bz(R.raw.ksad_coupon_status_5_anim);
            str = "https://static.yximgs.com/udata/pkg/KSAdSDK/coupon/ksad_coupon_entry_status_4.webp";
        } else {
            this.anz.setVisibility(0);
            this.anA.setVisibility(8);
            this.anB.setVisibility(0);
            this.anC.setVisibility(0);
            str = "https://static.yximgs.com/udata/pkg/KSAdSDK/coupon/ksad_coupon_entry_status_0.webp";
        }
        ImageLoaderProxy.INSTANCE.load(this.anz, com.kwad.sdk.core.network.idc.a.aaw().fu(str), new com.kwad.components.core.e.a());
        d(couponStatus);
    }

    private void d(CouponStatus couponStatus) {
        this.anv.setShowProgress(couponStatus.getStatusCode() == 0 && !couponStatus.isWaitingOpen());
    }

    private void bz(int i) {
        this.anA.setAnimation(i);
        this.anA.setRepeatMode(1);
        this.anA.setRepeatCount(-1);
        this.anA.setAnimation(i);
        this.anA.setVisibility(8);
        this.anA.setVisibility(0);
        if (this.anA.isAnimating()) {
            return;
        }
        this.anA.PZ();
    }

    public final void xQ() {
        this.anv.setProgress(0);
        this.anv.setShowProgress(false);
        this.anv.xX();
    }

    public final void xR() {
        this.anv.pause();
    }

    public final void xS() {
        this.anv.resume();
    }

    public final void a(d.a aVar) {
        this.anv.setProgress(0);
        this.anv.setShowProgress(true);
        this.anv.a(aVar);
    }

    public void setProgressSpeed(int i) {
        this.anv.setSpeed(i);
    }

    public int getProgress() {
        return this.anv.getProgress();
    }

    public final boolean xT() {
        CouponEntryProgress couponEntryProgress = this.anv;
        if (couponEntryProgress != null) {
            return couponEntryProgress.xW();
        }
        return false;
    }
}
