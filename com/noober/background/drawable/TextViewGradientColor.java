package com.noober.background.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import com.noober.background.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TextViewGradientColor implements ITextViewOperator {
    private int endColor = -1;
    private int startColor = -1;
    private int orientation = 0;

    @Override // com.noober.background.drawable.ITextViewOperator
    public void invoke(Context context, AttributeSet attributeSet, final TextView textView) {
        int i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.bl_text);
        try {
        } catch (Exception unused) {
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
        if (typedArrayObtainStyledAttributes.getIndexCount() != 0) {
            for (int i2 = 0; i2 < typedArrayObtainStyledAttributes.getIndexCount(); i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.bl_text_bl_text_gradient_endColor) {
                    this.endColor = typedArrayObtainStyledAttributes.getColor(index, -1);
                } else if (index == R.styleable.bl_text_bl_text_gradient_startColor) {
                    this.startColor = typedArrayObtainStyledAttributes.getColor(index, -1);
                } else if (index == R.styleable.bl_text_bl_text_gradient_orientation) {
                    this.orientation = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            int i3 = this.endColor;
            if (i3 == -1 && (i = this.startColor) != -1) {
                textView.setTextColor(i);
            } else {
                int i4 = this.startColor;
                if (i4 == -1 && i3 != -1) {
                    textView.setTextColor(i3);
                } else if (i3 != -1 && i4 != -1) {
                    if (this.orientation == 0) {
                        textView.post(new Runnable() { // from class: com.noober.background.drawable.TextViewGradientColor.1
                            @Override // java.lang.Runnable
                            public void run() {
                                textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, textView.getPaint().descent() - textView.getPaint().ascent(), TextViewGradientColor.this.startColor, TextViewGradientColor.this.endColor, Shader.TileMode.REPEAT));
                                textView.invalidate();
                            }
                        });
                    } else {
                        textView.post(new Runnable() { // from class: com.noober.background.drawable.TextViewGradientColor.2
                            @Override // java.lang.Runnable
                            public void run() {
                                textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getMeasuredWidth(), 0.0f, TextViewGradientColor.this.startColor, TextViewGradientColor.this.endColor, Shader.TileMode.REPEAT));
                                textView.invalidate();
                            }
                        });
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
