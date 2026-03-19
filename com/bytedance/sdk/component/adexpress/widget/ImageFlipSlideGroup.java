package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.jh;
import com.sigmob.sdk.base.n;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ImageFlipSlideGroup extends FrameLayout {
    boolean an;
    ImageView b;
    float c;
    FrameLayout d;
    private ImageFlipSlide gb;
    boolean h;
    BookPageView hc;
    private String mk;
    private String mq;
    private String tc;
    private String tt;
    ObjectAnimator u;
    private List<String> uo;

    public ImageFlipSlideGroup(Context context, boolean z) {
        super(context);
        this.c = 0.0f;
        this.h = z;
        c();
        setVisibility(4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    public float getRatio() {
        return this.c;
    }

    public void setRatio(float f) {
        this.c = f;
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                if (ImageFlipSlideGroup.this.h) {
                    ImageFlipSlideGroup.this.gb.d(ImageFlipSlideGroup.this.c);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.d.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.c) - 0.5f) * ImageFlipSlideGroup.this.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.d.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                point.x = ((int) (ImageFlipSlideGroup.this.getWidth() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.c))) - 100;
                point.y = ((int) (ImageFlipSlideGroup.this.getHeight() - (ImageFlipSlideGroup.this.getWidth() * ImageFlipSlideGroup.this.c))) - 100;
                if (ImageFlipSlideGroup.this.c > 0.3f) {
                    point.x = (int) (point.x - ((ImageFlipSlideGroup.this.getWidth() * 2) * (ImageFlipSlideGroup.this.c - 0.3d)));
                    point.y = (int) (point.y + ((ImageFlipSlideGroup.this.getHeight() / 2) * (ImageFlipSlideGroup.this.c - 0.3d)));
                }
                ImageFlipSlideGroup.this.hc.d(point);
                ImageFlipSlideGroup.this.hc.setAlpha(1.0f - (ImageFlipSlideGroup.this.c - 0.3f));
                ImageFlipSlideGroup.this.gb.d(ImageFlipSlideGroup.this.hc.getFilterAreaPath());
            }
        });
    }

    public void d(final DynamicImageFlipSlide.d dVar) {
        if (this.an) {
            if (dVar != null) {
                dVar.d();
                return;
            }
            return;
        }
        this.an = true;
        this.u.cancel();
        if (this.b != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.b.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        float[] fArr = new float[2];
        fArr[0] = this.c;
        fArr[1] = this.h ? 1.1f : 1.3f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, n.C, fArr);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageFlipSlideGroup.this.d.setVisibility(8);
                DynamicImageFlipSlide.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.d();
                }
            }
        });
        objectAnimatorOfFloat.start();
    }

    private void c() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.h);
        this.gb = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        addView(frameLayout);
        if (this.h) {
            View view = new View(getContext());
            view.setBackgroundColor(-1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(j.d(getContext(), 2.0f), -1);
            layoutParams.gravity = 17;
            this.d.addView(view, layoutParams);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(jh.u(getContext(), "tt_im_fs_handle"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(j.d(getContext(), 44.0f), j.d(getContext(), 44.0f));
            layoutParams2.gravity = 17;
            this.d.addView(imageView, layoutParams2);
            ImageView imageView2 = new ImageView(getContext());
            this.b = imageView2;
            imageView2.setImageResource(jh.u(getContext(), "tt_im_fs_tip"));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(j.d(getContext(), 196.0f), j.d(getContext(), 300.0f));
            layoutParams3.gravity = 17;
            layoutParams3.topMargin = j.d(getContext(), 6.0f);
            this.d.addView(this.b, layoutParams3);
            return;
        }
        BookPageView bookPageView = new BookPageView(getContext());
        this.hc = bookPageView;
        this.d.addView(bookPageView);
    }

    public void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, n.C, 0.15f, 0.25f);
        this.u = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.u.setInterpolator(new LinearInterpolator());
        this.u.setRepeatCount(-1);
        this.u.setRepeatMode(2);
        this.u.start();
    }

    public void hc() {
        ObjectAnimator objectAnimator = this.u;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void d(String str, String str2) {
        this.tt = str;
        this.mk = str2;
    }

    public void hc(String str, String str2) {
        this.tc = str;
        this.mq = str2;
    }

    public void setFilterColors(List<String> list) {
        this.uo = list;
    }

    public void b() {
        if (!TextUtils.isEmpty(this.tc)) {
            this.gb.d(this.tc, this.mq, (List<String>) null);
        } else {
            this.gb.d(this.tt, this.mk, this.uo);
        }
    }
}
