package com.qq.e.comm.plugin;

import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import com.qq.e.comm.plugin.w40;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cr extends y4 {

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new cr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public er p() {
        return new er(this, (dr) this.A);
    }

    @Override // com.qq.e.comm.plugin.y4, com.qq.e.comm.plugin.w40
    public /* bridge */ /* synthetic */ boolean a(String str, cm cmVar) {
        return super.a(str, cmVar);
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void n(int i) {
        ((dr) this.A).setMaxLines(i);
        ((dr) this.A).setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void m(int i) {
        ((dr) this.A).setGravity(i);
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void a(CharSequence charSequence) {
        b(charSequence);
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void p(int i) {
        ((dr) this.A).setTextSize(1, i);
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void q(int i) {
        int i2 = i & 3;
        if (i2 != 0) {
            if (i2 == 1) {
                ((dr) this.A).setTypeface(Typeface.defaultFromStyle(1));
            } else if (i2 == 2) {
                ((dr) this.A).setTypeface(Typeface.defaultFromStyle(2));
            } else if (i2 == 3) {
                ((dr) this.A).setTypeface(Typeface.defaultFromStyle(3));
            }
        }
        int i3 = (i & 4) != 0 ? 16 : 0;
        if ((i & 8) != 0) {
            i3 |= 8;
        }
        if (i3 != 0) {
            TextPaint paint = ((dr) this.A).getPaint();
            paint.setFlags(i3 | paint.getFlags());
        }
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void c(boolean z) {
        ((dr) this.A).a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public dr b(e8 e8Var) {
        return new dr(e8Var.d());
    }

    @Override // com.qq.e.comm.plugin.y4
    protected boolean c(int[] iArr) {
        int i;
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT < 26 || iArr == null || iArr.length != 3 || (i = iArr[0]) <= 0 || (i2 = iArr[2]) <= 0 || i >= (i3 = iArr[1]) || i2 > i3 - i) {
            return false;
        }
        ((dr) this.A).setAutoSizeTextTypeWithDefaults(1);
        ((dr) this.A).setAutoSizeTextTypeUniformWithConfiguration(iArr[0], iArr[1], iArr[2], 1);
        return true;
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void o(int i) {
        ((dr) this.A).setTextColor(i);
    }

    private void b(CharSequence charSequence) {
        ((dr) this.A).setText(charSequence);
    }

    @Override // com.qq.e.comm.plugin.w40
    public void b(int[] iArr) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        ((dr) this.A).setShadowLayer(iArr[2], iArr[0], iArr[1], iArr[3]);
    }

    @Override // com.qq.e.comm.plugin.y4
    protected void b(boolean z) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        ((dr) this.A).setAutoSizeTextTypeWithDefaults(z ? 1 : 0);
        ((dr) this.A).setAutoSizeTextTypeUniformWithConfiguration(12, 400, 1, 0);
    }
}
