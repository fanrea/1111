package com.tk.core.component.c;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends InputConnectionWrapper {
    private JsValueRef<V8Function> adc;
    private EditText aeb;
    private boolean aec;
    private String aed;

    public d(InputConnection inputConnection, EditText editText, JsValueRef<V8Function> jsValueRef) {
        super(inputConnection, false);
        this.aed = null;
        this.aeb = editText;
        this.adc = jsValueRef;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        this.aec = true;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        this.aec = false;
        String str = this.aed;
        if (str != null) {
            ch(str);
            this.aed = null;
        }
        return super.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        int selectionStart = this.aeb.getSelectionStart();
        int selectionEnd = this.aeb.getSelectionEnd();
        boolean composingText = super.setComposingText(charSequence, i);
        int selectionStart2 = this.aeb.getSelectionStart();
        cg(((selectionStart2 < selectionStart || selectionStart2 <= 0) || (!(selectionStart == selectionEnd) && (selectionStart2 == selectionStart))) ? "Backspace" : String.valueOf(this.aeb.getText().charAt(selectionStart2 - 1)));
        return composingText;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        String string = charSequence.toString();
        if (string.equals("")) {
            string = "Backspace";
        }
        cg(string);
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        ch("Backspace");
        return super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            boolean z = keyEvent.getUnicodeChar() < 58 && keyEvent.getUnicodeChar() > 47;
            if (keyEvent.getKeyCode() == 67) {
                ch("Backspace");
            } else if (keyEvent.getKeyCode() == 66) {
                ch("Enter");
            } else if (z) {
                ch(String.valueOf(keyEvent.getNumber()));
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    private void cg(String str) {
        if (this.aec) {
            this.aed = str;
        } else {
            ch(str);
        }
    }

    private void ch(String str) {
        if (str.equals("\n")) {
            str = "Enter";
        }
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.m.p0.b.d, str);
        HashMap map2 = new HashMap();
        map2.put(TypedValues.AttributesType.S_TARGET, map);
        map2.put("type", "keyPress");
        JsValueRef<V8Function> jsValueRef = this.adc;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            this.adc.get().call(null, map2);
        } catch (Throwable th) {
            com.tk.core.i.a.a("TKInput", "dispatchKeyEvent", th);
        }
    }
}
