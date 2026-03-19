package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b acl;
    private b acm;
    private TextView acn;
    private a aco;
    private PhotoInfo.VideoInfo acp;
    private boolean acq;
    private final RectF acr;
    private int acs;
    private int act;
    private final e acu;
    private Matrix mMatrix;
    public Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.acq = false;
        this.acr = new RectF();
        this.acs = 0;
        this.act = 0;
        this.acu = new e();
        B(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.acq = false;
        this.acr = new RectF();
        this.acs = 0;
        this.act = 0;
        this.acu = new e();
        B(context);
    }

    private void B(Context context) {
        this.mMatrix = new Matrix();
        this.acl = new com.kwad.components.core.page.widget.b(context);
        addView(this.acl, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        uf();
    }

    public void setIsAlphaVideoView(boolean z) {
        com.kwad.components.core.page.widget.b bVar;
        this.acq = z;
        if (!z || (bVar = this.acl) == null) {
            return;
        }
        bVar.setOpaque(false);
    }

    private void uf() {
        com.kwad.components.core.page.widget.b bVar;
        if (this.acq && (bVar = this.acl) != null) {
            bVar.setOpaque(false);
        }
        this.acl.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.mSurfaceTexture == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.mSurfaceTexture = surfaceTexture;
                DetailVideoView.this.ug();
                DetailVideoView.this.mSurface = new Surface(surfaceTexture);
                if (DetailVideoView.this.acm != null) {
                    DetailVideoView.this.acm.setSurface(DetailVideoView.this.mSurface);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ug() {
        Surface surface = this.mSurface;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            this.mSurface = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ug();
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        int i6 = this.acs;
        if (i6 <= 0 || (i5 = this.act) <= 0) {
            return;
        }
        adaptVideoSize(i6, i5);
    }

    public void setMediaPlayer(b bVar) {
        this.acm = bVar;
        Surface surface = this.mSurface;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    public final void adaptVideoSize(int i, int i2) {
        if (this.acl == null) {
            com.kwad.sdk.core.d.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.act = i2;
        this.acs = i;
        if (this.acu.uh()) {
            int iUi = this.acu.ui();
            d cVar = null;
            if (iUi == 1) {
                cVar = new VideoAdapters.c();
            } else if (iUi == 2) {
                cVar = new VideoAdapters.b();
            }
            if (cVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.acl;
                cVar.a(bVar, (View) bVar.getParent(), i, i2);
                return;
            }
            return;
        }
        if (this.acu.un()) {
            com.kwad.sdk.c.a.a.W(this.acl);
            return;
        }
        if (this.acu.uj()) {
            com.kwad.sdk.c.a.a.g(this.acl, i, i2);
            return;
        }
        if (this.acu.ul()) {
            com.kwad.sdk.c.a.a.h(this.acl, i, i2);
            return;
        }
        if (this.acu.uk()) {
            com.kwad.sdk.c.a.a.f(this.acl, i, i2);
            return;
        }
        if (this.acu.um()) {
            a(this.acl, i, i2);
            return;
        }
        View view = (View) this.acl.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        PhotoInfo.VideoInfo videoInfo = this.acp;
        if (videoInfo != null && com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
            ViewGroup.LayoutParams layoutParams = this.acl.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.acl.setTransform(this.mMatrix);
            this.acl.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.acl.getLayoutParams();
            layoutParams2.width = width;
            layoutParams2.height = (int) ((i2 / (i * 1.0f)) * width);
            this.mMatrix.reset();
            this.acl.setTransform(this.mMatrix);
            this.acl.setLayoutParams(layoutParams2);
        }
        this.acr.set(this.acl.getLeft(), this.acl.getTop(), this.acl.getRight(), this.acl.getBottom());
    }

    private void a(View view, long j, long j2) {
        View view2;
        if (view == null || j == 0 || j2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f = j / j2;
        float f2 = height * f;
        float f3 = width;
        if (f2 > f3) {
            height = (int) (f3 / f);
        } else {
            width = (int) f2;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.acl.setLayoutParams(layoutParams);
    }

    @Deprecated
    public void setAd(boolean z) {
        this.acu.setAd(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.acu.setHorizontalVideo(z);
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.acu.aX(z);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.acu.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.acu.setForce(z);
    }

    public final void g(boolean z, int i) {
        this.acu.setAd(true);
        this.acu.bj(i);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.acp = videoInfo;
    }

    public void setClickListener(a aVar) {
        this.aco = aVar;
        setOnClickListener(this);
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar = this.acl;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.acl.requestLayout();
        }
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.acl;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.acl) {
            a aVar = this.aco;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.aco;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.kwad.components.core.widget.i.b(this, f);
        }
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean zX = com.kwad.sdk.core.response.b.a.X(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt((int) height, i);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (zX) {
                    int i2 = (int) (iIntValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = iIntValue;
                        layoutParams.width = i2;
                        DetailVideoView.this.setLayoutParams(layoutParams);
                    }
                    DetailVideoView.this.adaptVideoSize(i2, iIntValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = iIntValue;
                        layoutParams.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.setInterpolator(interpolatorCreate);
        return valueAnimatorOfInt;
    }

    public final void bi(int i) {
        if (com.kwad.components.core.a.qr.booleanValue()) {
            if (this.acn == null) {
                if (getContext() == null) {
                    return;
                } else {
                    this.acn = new TextView(getContext());
                }
            }
            removeView(this.acn);
            this.acn.setText(String.valueOf(i));
            this.acn.setTextColor(SupportMenu.CATEGORY_MASK);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            addView(this.acn, getChildCount(), layoutParams);
        }
    }
}
