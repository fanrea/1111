package com.kwad.components.ct.detail.photo.newui.d;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private Handler aeI;
    private ImageView auo;
    private b auq;
    private AnimatorSet aup = new AnimatorSet();
    private Runnable aur = new Runnable() { // from class: com.kwad.components.ct.detail.photo.newui.d.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.auq != null) {
                a.this.auq.onStart();
            }
            a.this.Av();
        }
    };
    private Runnable aus = new Runnable() { // from class: com.kwad.components.ct.detail.photo.newui.d.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.auq != null) {
                a.this.auq.onStop();
            }
            if (a.this.aup != null) {
                a.this.aup.cancel();
            }
        }
    };

    public a(ImageView imageView, Handler handler, b bVar) {
        this.auo = imageView;
        this.auq = bVar;
        this.aeI = handler;
    }

    public final void start(long j) {
        this.aeI.post(this.aur);
        this.aeI.postDelayed(this.aus, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Av() {
        ImageView imageView = this.auo;
        if (imageView == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.1f, 1.0f, 1.1f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.auo, "scaleY", 1.1f, 1.0f, 1.1f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.aup.setDuration(600L);
        this.aup.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        this.aup.start();
    }

    public final void stop() {
        b bVar = this.auq;
        if (bVar != null) {
            bVar.onStop();
        }
        Handler handler = this.aeI;
        if (handler != null) {
            handler.removeCallbacks(this.aur);
            this.aeI.removeCallbacks(this.aus);
        }
        AnimatorSet animatorSet = this.aup;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.auo = null;
        this.auq = null;
    }
}
