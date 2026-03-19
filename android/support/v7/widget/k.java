package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class k extends ImageButton implements android.support.v4.e.n, android.support.v4.widget.l {
    private final l mB;
    private final g mf;

    public k(Context context, AttributeSet attributeSet, int i) {
        super(as.j(context), null, i);
        this.mf = new g(this);
        this.mf.a(null, i);
        this.mB = new l(this);
        this.mB.a(null, i);
    }

    @Override // android.widget.ImageView
    public final void setImageResource(int i) {
        this.mB.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public final void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.mB;
        if (lVar != null) {
            lVar.cI();
        }
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        l lVar = this.mB;
        if (lVar != null) {
            lVar.cI();
        }
    }

    @Override // android.widget.ImageView
    public final void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.mB;
        if (lVar != null) {
            lVar.cI();
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        g gVar = this.mf;
        if (gVar != null) {
            gVar.aa(i);
        }
    }

    @Override // android.view.View
    public final void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        g gVar = this.mf;
        if (gVar != null) {
            gVar.cE();
        }
    }

    @Override // android.support.v4.e.n
    public final void setSupportBackgroundTintList(ColorStateList colorStateList) {
        g gVar = this.mf;
        if (gVar != null) {
            gVar.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.e.n
    public final ColorStateList getSupportBackgroundTintList() {
        g gVar = this.mf;
        if (gVar != null) {
            return gVar.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.e.n
    public final void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        g gVar = this.mf;
        if (gVar != null) {
            gVar.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.e.n
    public final PorterDuff.Mode getSupportBackgroundTintMode() {
        g gVar = this.mf;
        if (gVar != null) {
            return gVar.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.support.v4.widget.l
    public final void setSupportImageTintList(ColorStateList colorStateList) {
        l lVar = this.mB;
        if (lVar != null) {
            lVar.setSupportImageTintList(colorStateList);
        }
    }

    @Override // android.support.v4.widget.l
    public final ColorStateList getSupportImageTintList() {
        l lVar = this.mB;
        if (lVar != null) {
            return lVar.getSupportImageTintList();
        }
        return null;
    }

    @Override // android.support.v4.widget.l
    public final void setSupportImageTintMode(PorterDuff.Mode mode) {
        l lVar = this.mB;
        if (lVar != null) {
            lVar.setSupportImageTintMode(mode);
        }
    }

    @Override // android.support.v4.widget.l
    public final PorterDuff.Mode getSupportImageTintMode() {
        l lVar = this.mB;
        if (lVar != null) {
            return lVar.getSupportImageTintMode();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected final void drawableStateChanged() {
        super.drawableStateChanged();
        g gVar = this.mf;
        if (gVar != null) {
            gVar.cF();
        }
        l lVar = this.mB;
        if (lVar != null) {
            lVar.cI();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return this.mB.hasOverlappingRendering() && super.hasOverlappingRendering();
    }
}
