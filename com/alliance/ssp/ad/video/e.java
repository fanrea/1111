package com.alliance.ssp.ad.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.video.VideoController;

/* compiled from: VideoDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e {
    public Context a;
    public MediaPlayer b;
    public Handler d;
    public TextView e;
    public ImageView f;
    public VideoController.e g;
    public int c = 0;
    public FrameLayout h = null;

    public e(Context context, MediaPlayer mediaPlayer) {
        this.a = context;
        this.b = mediaPlayer;
    }

    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    public final int a(float f) {
        return (int) ((f * this.a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void a(View view, String str, float f, float f2, float f3, float f4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{a(f), a(f), a(f2), a(f2), a(f3), a(f3), a(f4), a(f4)});
        view.setBackground(gradientDrawable);
    }

    public SeekBar a(SeekBar seekBar, String str, String str2) {
        seekBar.setPadding(0, 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.setMargins(0, 0, 0, 0);
        seekBar.setLayoutParams(layoutParams);
        seekBar.getProgressDrawable().setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_IN);
        Drawable background = seekBar.getBackground();
        if (background != null) {
            background.setColorFilter(Color.parseColor(str2), PorterDuff.Mode.SRC_IN);
        }
        seekBar.setThumb(null);
        seekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.alliance.ssp.ad.video.e$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return e.a(view, motionEvent);
            }
        });
        return seekBar;
    }

    public View a(VideoController.e eVar) {
        this.g = eVar;
        this.h = new FrameLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.h.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(this.a);
        this.f = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.video.e$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        this.h.addView(this.f);
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        int i = l.a;
        if (this.c == 1) {
            a(0);
        } else {
            a(1);
        }
    }

    public void a(int i) {
        ImageView imageView;
        MediaPlayer mediaPlayer;
        if (this.h != null && (imageView = this.f) != null && (mediaPlayer = this.b) != null && this.g != null) {
            try {
                if (i == 0) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                    this.f.setImageResource(R.drawable.nmadssp_audio_off);
                    b bVar = (b) this.g;
                    bVar.a.a(false);
                    bVar.b.f = true;
                } else if (i != 1) {
                    imageView.setImageResource(R.drawable.nmadssp_audio_off);
                    int i2 = l.a;
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                    this.f.setImageResource(R.drawable.nmadssp_audio_on);
                    b bVar2 = (b) this.g;
                    bVar2.a.a(true);
                    bVar2.b.f = false;
                }
                this.c = i;
                return;
            } catch (Exception e) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("VideoDecorator 001: ")), e);
                return;
            }
        }
        int i3 = l.a;
    }
}
