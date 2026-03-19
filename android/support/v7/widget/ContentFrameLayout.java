package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ContentFrameLayout extends FrameLayout {
    private TypedValue nC;
    private TypedValue nD;
    private TypedValue nE;
    private TypedValue nF;
    private TypedValue nG;
    private TypedValue nH;
    private final Rect nI;
    private a nJ;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface a {
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nI = new Rect();
    }

    public final void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(a aVar) {
        this.nJ = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.nC == null) {
            this.nC = new TypedValue();
        }
        return this.nC;
    }

    public TypedValue getMinWidthMinor() {
        if (this.nD == null) {
            this.nD = new TypedValue();
        }
        return this.nD;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.nE == null) {
            this.nE = new TypedValue();
        }
        return this.nE;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.nF == null) {
            this.nF = new TypedValue();
        }
        return this.nF;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.nG == null) {
            this.nG = new TypedValue();
        }
        return this.nG;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.nH == null) {
            this.nH = new TypedValue();
        }
        return this.nH;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
