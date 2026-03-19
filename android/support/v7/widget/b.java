package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class b extends Drawable {
    final ActionBarContainer jB;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public b(ActionBarContainer actionBarContainer) {
        this.jB = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.jB.jI) {
            if (this.jB.jH != null) {
                this.jB.jH.draw(canvas);
            }
        } else {
            if (this.jB.ia != null) {
                this.jB.ia.draw(canvas);
            }
            if (this.jB.jG == null || !this.jB.jJ) {
                return;
            }
            this.jB.jG.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        if (this.jB.jI) {
            if (this.jB.jH != null) {
                this.jB.jH.getOutline(outline);
            }
        } else if (this.jB.ia != null) {
            this.jB.ia.getOutline(outline);
        }
    }
}
