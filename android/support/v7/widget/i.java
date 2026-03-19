package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class i extends EditText implements android.support.v4.e.n {
    private final g mf;
    private final p mg;

    @Override // android.widget.EditText, android.widget.TextView
    public final Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
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

    @Override // android.widget.TextView, android.view.View
    protected final void drawableStateChanged() {
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

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        p pVar = this.mg;
        if (pVar != null) {
            pVar.k(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public final void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.widget.k.a(this, callback));
    }
}
