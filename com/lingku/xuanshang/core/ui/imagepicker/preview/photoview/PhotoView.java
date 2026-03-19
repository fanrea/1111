package com.lingku.xuanshang.core.ui.imagepicker.preview.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import lkxssdk.a.a;
import lkxssdk.g.c;
import lkxssdk.g.d;
import lkxssdk.g.e;
import lkxssdk.g.f;
import lkxssdk.g.g;
import lkxssdk.g.h;
import lkxssdk.g.i;
import lkxssdk.g.j;
import lkxssdk.g.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PhotoView extends AppCompatImageView {
    public j a;
    public ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        this.a = new j(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public j getAttacher() {
        return this.a;
    }

    public RectF getDisplayRect() {
        return this.a.c();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.l;
    }

    public float getMaximumScale() {
        return this.a.e;
    }

    public float getMediumScale() {
        return this.a.d;
    }

    public float getMinimumScale() {
        return this.a.c;
    }

    public float getScale() {
        return this.a.e();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.a.C;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.f = z;
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.a.g();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        j jVar = this.a;
        if (jVar != null) {
            jVar.g();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        j jVar = this.a;
        if (jVar != null) {
            jVar.g();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        j jVar = this.a;
        if (jVar != null) {
            jVar.g();
        }
    }

    public void setMaximumScale(float f) {
        j jVar = this.a;
        a.a(jVar.c, jVar.d, f);
        jVar.e = f;
    }

    public void setMediumScale(float f) {
        j jVar = this.a;
        a.a(jVar.c, f, jVar.e);
        jVar.d = f;
    }

    public void setMinimumScale(float f) {
        j jVar = this.a;
        a.a(f, jVar.d, jVar.e);
        jVar.c = f;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.t = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.u = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.a.p = cVar;
    }

    public void setOnOutsidePhotoTapListener(d dVar) {
        this.a.r = dVar;
    }

    public void setOnPhotoTapListener(e eVar) {
        this.a.q = eVar;
    }

    public void setOnScaleChangeListener(f fVar) {
        this.a.v = fVar;
    }

    public void setOnSingleFlingListener(g gVar) {
        this.a.w = gVar;
    }

    public void setOnViewDragListener(h hVar) {
        this.a.x = hVar;
    }

    public void setOnViewTapListener(i iVar) {
        this.a.s = iVar;
    }

    public void setRotationBy(float f) {
        j jVar = this.a;
        jVar.m.postRotate(f % 360.0f);
        jVar.a();
    }

    public void setRotationTo(float f) {
        j jVar = this.a;
        jVar.m.setRotate(f % 360.0f);
        jVar.a();
    }

    public void setScale(float f) {
        this.a.a(f, r0.h.getRight() / 2, r0.h.getBottom() / 2, false);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        j jVar = this.a;
        if (jVar == null) {
            this.b = scaleType;
            return;
        }
        jVar.getClass();
        boolean z = true;
        if (scaleType == null) {
            z = false;
        } else if (k.a[scaleType.ordinal()] == 1) {
            throw new IllegalStateException("Matrix scale type is not supported");
        }
        if (!z || scaleType == jVar.C) {
            return;
        }
        jVar.C = scaleType;
        jVar.g();
    }

    public void setZoomTransitionDuration(int i) {
        this.a.b = i;
    }

    public void setZoomable(boolean z) {
        j jVar = this.a;
        jVar.B = z;
        jVar.g();
    }
}
