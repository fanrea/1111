package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.c.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class q extends TextView implements android.support.v4.e.n, android.support.v4.widget.b {
    private final g mf;
    private final p mg;
    private Future<android.support.v4.c.a> nj;

    public q(Context context) {
        this(context, null);
    }

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public q(Context context, AttributeSet attributeSet, int i) {
        super(as.j(context), attributeSet, i);
        this.mf = new g(this);
        this.mf.a(attributeSet, i);
        this.mg = new p(this);
        this.mg.a(attributeSet, i);
        this.mg.cK();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        g gVar = this.mf;
        if (gVar != null) {
            gVar.aa(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        g gVar = this.mf;
        if (gVar != null) {
            gVar.cE();
        }
    }

    @Override // android.support.v4.e.n
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        g gVar = this.mf;
        if (gVar != null) {
            gVar.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.e.n
    public ColorStateList getSupportBackgroundTintList() {
        g gVar = this.mf;
        if (gVar != null) {
            return gVar.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.e.n
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        g gVar = this.mf;
        if (gVar != null) {
            gVar.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.e.n
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        g gVar = this.mf;
        if (gVar != null) {
            return gVar.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        p pVar = this.mg;
        if (pVar != null) {
            pVar.k(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        g gVar = this.mf;
        if (gVar != null) {
            gVar.cF();
        }
        p pVar = this.mg;
        if (pVar != null) {
            pVar.cK();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        p pVar = this.mg;
        if (pVar != null) {
            pVar.cL();
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (du) {
            super.setTextSize(i, f);
            return;
        }
        p pVar = this.mg;
        if (pVar != null) {
            pVar.setTextSize(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.mg == null || du || !this.mg.cN()) {
            return;
        }
        this.mg.cM();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (du) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        p pVar = this.mg;
        if (pVar != null) {
            pVar.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (du) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        p pVar = this.mg;
        if (pVar != null) {
            pVar.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (du) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        p pVar = this.mg;
        if (pVar != null) {
            pVar.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (du) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        p pVar = this.mg;
        if (pVar != null) {
            return pVar.getAutoSizeTextType();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (du) {
            return super.getAutoSizeStepGranularity();
        }
        p pVar = this.mg;
        if (pVar != null) {
            return pVar.getAutoSizeStepGranularity();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (du) {
            return super.getAutoSizeMinTextSize();
        }
        p pVar = this.mg;
        if (pVar != null) {
            return pVar.getAutoSizeMinTextSize();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (du) {
            return super.getAutoSizeMaxTextSize();
        }
        p pVar = this.mg;
        if (pVar != null) {
            return pVar.getAutoSizeMaxTextSize();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (du) {
            return super.getAutoSizeTextAvailableSizes();
        }
        p pVar = this.mg;
        return pVar != null ? pVar.getAutoSizeTextAvailableSizes() : new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            android.support.v4.widget.k.a(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            android.support.v4.widget.k.b(this, i);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return android.support.v4.widget.k.a(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return android.support.v4.widget.k.b(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        android.support.v4.widget.k.c(this, i);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.widget.k.a(this, callback));
    }

    public a.C0005a getTextMetricsParamsCompat() {
        return android.support.v4.widget.k.c(this);
    }

    public void setTextMetricsParamsCompat(a.C0005a c0005a) {
        android.support.v4.widget.k.a(this, c0005a);
    }

    public void setPrecomputedText(android.support.v4.c.a aVar) {
        android.support.v4.widget.k.a(this, aVar);
    }

    private void cO() {
        Future<android.support.v4.c.a> future = this.nj;
        if (future != null) {
            try {
                this.nj = null;
                android.support.v4.widget.k.a(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        cO();
        return super.getText();
    }

    public void setTextFuture(Future<android.support.v4.c.a> future) {
        this.nj = future;
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        cO();
        super.onMeasure(i, i2);
    }
}
