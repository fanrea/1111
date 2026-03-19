package com.kwad.components.ct.emotion.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EmojiTextView extends TextView {
    private a aCG;
    e aCH;
    private boolean aCI;
    private boolean aCJ;
    private boolean aCK;

    public interface a {
    }

    static /* synthetic */ boolean a(EmojiTextView emojiTextView, boolean z) {
        emojiTextView.aCK = true;
        return true;
    }

    static /* synthetic */ boolean b(EmojiTextView emojiTextView, boolean z) {
        emojiTextView.aCJ = true;
        return true;
    }

    public EmojiTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCI = false;
        this.aCJ = false;
        this.aCK = false;
        initialize();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCI = false;
        this.aCJ = false;
        this.aCK = false;
        initialize();
    }

    public EmojiTextView(Context context) {
        super(context);
        this.aCI = false;
        this.aCJ = false;
        this.aCK = false;
        initialize();
    }

    private void initialize() {
        this.aCH = new d(this);
        addTextChangedListener(new TextWatcher() { // from class: com.kwad.components.ct.emotion.widget.EmojiTextView.1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                if (EmojiTextView.this.aCH == null) {
                    return;
                }
                if (EmojiTextView.this.aCI) {
                    if (EmojiTextView.this.aCK || TextUtils.isEmpty(EmojiTextView.this.getEditableText())) {
                        if (EmojiTextView.this.aCJ) {
                            return;
                        }
                        EmojiTextView.this.aCH.a(EmojiTextView.this.getEditableText());
                        if (EmojiTextView.this.aCI) {
                            EmojiTextView.b(EmojiTextView.this, true);
                            return;
                        }
                        return;
                    }
                    EmojiTextView.a(EmojiTextView.this, true);
                    EmojiTextView.this.aCH.a(EmojiTextView.this.getEditableText());
                    return;
                }
                EmojiTextView.this.aCH.a(EmojiTextView.this.getEditableText());
            }
        });
        if (getText() == null || getText().length() <= 0) {
            return;
        }
        this.aCH.a(getEditableText());
    }

    public void setPreventDeadCycleInvalidate(boolean z) {
        this.aCI = z;
    }

    @Override // android.view.View
    public void postInvalidate() {
        this.aCJ = true;
        super.postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException unused) {
            setText(getText().toString());
            try {
                super.onMeasure(i, i2);
            } catch (IndexOutOfBoundsException unused2) {
                setText("");
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        CharSequence text = super.getText();
        return text == null ? "" : text;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i, int i2) {
        try {
            super.append(charSequence, i, i2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        isPressed();
        super.setPressed(z);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        try {
            return super.performLongClick();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public e getKSTextDisplayHandler() {
        return this.aCH;
    }

    public void setKSTextDisplayHandler(e eVar) {
        this.aCH = eVar;
    }

    public void setOnPressedListener(a aVar) {
        this.aCG = aVar;
    }
}
