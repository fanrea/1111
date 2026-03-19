package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class f extends AutoCompleteTextView implements android.support.v4.e.n {
    private static final int[] hQ = {R.attr.popupBackground};
    private final g mf;
    private final p mg;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0010a.autoCompleteTextViewStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(as.j(context), attributeSet, i);
        av avVarA = av.a(getContext(), attributeSet, hQ, i, 0);
        if (avVarA.hasValue(0)) {
            setDropDownBackgroundDrawable(avVarA.getDrawable(0));
        }
        avVarA.recycle();
        this.mf = new g(this);
        this.mf.a(attributeSet, i);
        this.mg = new p(this);
        this.mg.a(attributeSet, i);
        this.mg.cK();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(android.support.v7.b.a.a.a(getContext(), i));
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        p pVar = this.mg;
        if (pVar != null) {
            pVar.k(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return j.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.widget.k.a(this, callback));
    }
}
