package com.qq.e.comm.plugin;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class k5 implements xj {
    protected Paint f;
    protected Paint g;
    private Shader i;
    private int j;
    private int k;
    private int[] l;
    protected Object[] a = null;
    protected int b = 0;
    protected int[] c = null;
    protected int d = 0;
    protected int e = -16777216;
    private boolean h = false;

    k5() {
    }

    public boolean c(int i) {
        if (i == this.d) {
            return false;
        }
        this.d = i;
        return true;
    }

    @Override // com.qq.e.comm.plugin.xj
    public void a(Canvas canvas, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int[] iArr = this.c;
        if (iArr != null && this.l == null) {
            y5.a(canvas, i, i2, this.d, iArr);
        }
        if (this.l != null) {
            Paint paint = new Paint();
            paint.setShadowLayer(r3[2], r3[0], r3[1], this.l[3]);
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            if (this.c != null) {
                canvas.drawRoundRect(rectF, r4[0], r4[1], paint);
            } else {
                canvas.drawRect(rectF, paint);
            }
        }
        if (this.a == null && this.b == 0) {
            return;
        }
        if (this.f == null) {
            Paint paint2 = new Paint();
            this.f = paint2;
            paint2.setAntiAlias(true);
        }
        Object[] objArr = this.a;
        if (objArr != null) {
            if (this.i == null || this.h || this.j != i || this.k != i2) {
                this.i = ei.a(objArr, i, i2);
            }
            this.f.setShader(this.i);
            this.h = false;
        } else {
            this.f.setColor(this.b);
        }
        this.j = i;
        this.k = i2;
        y5.a(canvas, this.f, i, i2, this.d, this.c);
    }

    @Override // com.qq.e.comm.plugin.xj
    public void b(Canvas canvas, int i, int i2) {
        if (i <= 0 || i2 <= 0 || this.d <= 0) {
            return;
        }
        if (this.g == null) {
            Paint paint = new Paint();
            this.g = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.g.setAntiAlias(true);
        }
        this.g.setStrokeWidth(this.d);
        this.g.setColor(this.e);
        y5.b(canvas, this.g, i, i2, this.d, this.c);
    }

    public boolean b(int i) {
        if (i == this.e) {
            return false;
        }
        this.e = i;
        return true;
    }

    public boolean b(int[] iArr) {
        if (this.l == iArr) {
            return false;
        }
        this.l = iArr;
        return true;
    }

    public boolean a() {
        return (this.b == 0 && this.d == 0 && this.c == null && this.a == null && this.l == null) ? false : true;
    }

    public boolean a(int i) {
        if (i == this.b) {
            return false;
        }
        this.b = i;
        return this.a == null;
    }

    public boolean a(Object[] objArr) {
        Object[] objArr2 = this.a;
        int i = 0;
        if (objArr == objArr2) {
            this.h = false;
            return false;
        }
        if (objArr2 != null && objArr != null) {
            while (true) {
                if (i >= 4) {
                    break;
                }
                Object obj = this.a[i];
                if (obj instanceof int[]) {
                    if (!Arrays.equals((int[]) obj, (int[]) objArr[i])) {
                        this.h = true;
                        break;
                    }
                    i++;
                } else if (obj instanceof float[]) {
                    if (!Arrays.equals((float[]) obj, (float[]) objArr[i])) {
                        this.h = true;
                        break;
                    }
                    i++;
                } else {
                    if (obj != objArr[i]) {
                        this.h = true;
                        break;
                    }
                    i++;
                }
            }
        } else {
            this.h = true;
        }
        this.a = objArr;
        return this.h;
    }

    public boolean a(int[] iArr) {
        int[] iArr2;
        if (iArr == null || iArr.length < 4 || iArr == (iArr2 = this.c)) {
            return false;
        }
        if (iArr2 == null) {
            this.c = iArr;
            return true;
        }
        boolean z = false;
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            if (i2 >= 0) {
                int[] iArr3 = this.c;
                if (i2 != iArr3[i]) {
                    iArr3[i] = i2;
                    z = true;
                }
            }
        }
        return z;
    }
}
