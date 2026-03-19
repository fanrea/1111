package com.tk.core.component.c;

import android.R;
import android.content.Context;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends EditText {
    private a acZ;
    private boolean ada;
    private boolean adb;
    private JsValueRef<V8Function> adc;

    public interface a {
        void qV();

        void qW();

        void qX();
    }

    public b(Context context) {
        super(context);
    }

    public final void setMenuOptionListener(a aVar) {
        this.acZ = aVar;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        switch (i) {
            case R.id.cut:
                a aVar = this.acZ;
                if (aVar != null) {
                    aVar.qW();
                    break;
                }
                break;
            case R.id.copy:
                a aVar2 = this.acZ;
                if (aVar2 != null) {
                    aVar2.qV();
                    break;
                }
                break;
            case R.id.paste:
                a aVar3 = this.acZ;
                if (aVar3 != null) {
                    aVar3.qX();
                    break;
                }
                break;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adb) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (getLineCount() * getLineHeight() > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                this.ada = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (actionMasked == 1 && this.ada) {
            this.ada = false;
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        JsValueRef<V8Function> jsValueRef;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        return (inputConnectionOnCreateInputConnection == null || (jsValueRef = this.adc) == null) ? inputConnectionOnCreateInputConnection : new d(inputConnectionOnCreateInputConnection, this, jsValueRef);
    }

    public final void setOnKeyPressRef(JsValueRef<V8Function> jsValueRef) {
        this.adc = jsValueRef;
    }

    public final void setIsSingleLine(boolean z) {
        this.adb = z;
    }
}
