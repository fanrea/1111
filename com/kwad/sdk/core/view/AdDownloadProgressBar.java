package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdDownloadProgressBar extends c {
    private int XA;
    private Drawable Xz;
    private ImageView bKd;
    private TextView bKe;
    private View bKf;
    private a bKg;
    private com.kwad.sdk.core.view.a bKh;
    private Drawable bKi;
    private Drawable bKj;
    private Drawable bKk;

    public AdDownloadProgressBar(Context context) {
        this(context, null);
    }

    public AdDownloadProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKg = new a(this, (byte) 0);
        initViews();
    }

    private void initViews() {
        ads();
    }

    private void ads() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_download_progress_bar, (ViewGroup) this, true);
        this.bKe = (TextView) findViewById(R.id.ksad_status_tv);
        this.bKf = findViewById(R.id.ksad_click_mask);
        this.bKd = (ImageView) findViewById(R.id.ksad_progress_bg);
        setRadius(com.kwad.sdk.c.a.a.a(getContext(), 2.0f));
        this.bKf.setBackgroundResource(R.drawable.ksad_download_progress_mask_bg);
    }

    public void setProgressDrawable(int i) {
        this.bKd.setBackgroundColor(i);
        super.setBackground(null);
        if (Build.VERSION.SDK_INT > 23) {
            super.setForeground(null);
        }
    }

    public final void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, int i) {
        this.Xz = null;
        this.bKi = null;
        this.bKj = drawable3;
        this.bKk = null;
        this.XA = i;
        adu();
    }

    private void adt() {
        this.bKe.setCompoundDrawablePadding(0);
        this.bKe.setCompoundDrawables(null, null, null, null);
    }

    private void adu() {
        setDrawableBounds(this.Xz);
        setDrawableBounds(this.bKi);
        setDrawableBounds(this.bKj);
        setDrawableBounds(this.bKk);
        this.bKe.setCompoundDrawablePadding(this.XA);
        this.bKe.setCompoundDrawables(this.Xz, this.bKi, this.bKj, this.bKk);
    }

    private void setDrawableBounds(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
    }

    public void setTextSize(float f) {
        this.bKe.setTextSize(f);
    }

    public void setTextColor(int i) {
        this.bKe.setTextColor(i);
    }

    public final void b(String str, float f) {
        this.bKg.bKm = true;
        this.bKg.bKl = str;
        this.bKg.aTn = f;
        this.bKg.adv();
        adt();
    }

    public void setText(String str) {
        this.bKg.bKm = false;
        this.bKg.bKl = str;
        this.bKg.adv();
        adu();
    }

    public void setTextTypeface(Typeface typeface) {
        this.bKe.getPaint().setTypeface(typeface);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.bKe.setIncludeFontPadding(z);
    }

    public TextView getStatusTextView() {
        return this.bKe;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        View view = this.bKf;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    class a {
        private float aTn;
        private String bKl;
        private boolean bKm;

        private a() {
            this.aTn = -1.0f;
            this.bKm = false;
        }

        /* synthetic */ a(AdDownloadProgressBar adDownloadProgressBar, byte b) {
            this();
        }

        final void adv() {
            if (!this.bKm || this.aTn < 0.0f) {
                AdDownloadProgressBar.this.bKe.setText(this.bKl);
                return;
            }
            AdDownloadProgressBar.this.bKe.setText(this.bKl);
            if (AdDownloadProgressBar.this.bKh != null) {
                AdDownloadProgressBar.this.bKd.setImageDrawable(AdDownloadProgressBar.this.bKh);
                AdDownloadProgressBar.this.bKh.setProgress(this.aTn);
            }
        }
    }
}
