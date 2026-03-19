package com.lingku.xuanshang.core.ui.imagepicker.crop;

import aegon.chrome.net.NetError;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ViewCrop extends View {
    public final Paint a;
    public final Paint b;
    public final int c;
    public final int d;
    public final int e;
    public Bitmap f;
    public Rect g;
    public Rect h;
    public Rect i;
    public Rect j;
    public Rect k;
    public Rect l;
    public Rect m;
    public Rect n;
    public Rect o;
    public Rect p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;

    public ViewCrop(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setFilterBitmap(true);
        this.d = Color.parseColor("#90000000");
        this.c = Color.parseColor("#90FFFFFF");
        this.e = Color.parseColor("#00FF00");
    }

    public final void a(int i) {
        Rect rect = this.h;
        int i2 = rect.bottom + i;
        int i3 = rect.top + 150;
        if (i2 < i3 || i2 > (i3 = this.g.bottom)) {
            i2 = i3;
        }
        rect.bottom = i2;
    }

    public final void a(int i, int i2) {
        Rect rect = this.h;
        int i3 = rect.left;
        int i4 = i3 + i;
        int i5 = rect.top;
        int i6 = i5 + i2;
        int i7 = rect.right;
        int i8 = i + i7;
        int i9 = rect.bottom;
        int i10 = i2 + i9;
        Rect rect2 = this.g;
        int i11 = rect2.left;
        if (i4 < i11) {
            i8 = (i11 - i3) + i7;
            i4 = i11;
        } else {
            int i12 = rect2.right;
            if (i8 > i12) {
                i4 = i3 + (i12 - i7);
                i8 = i12;
            }
        }
        int i13 = rect2.top;
        if (i6 < i13) {
            int i14 = i13 - i5;
            i6 = i5 + i14;
            i10 = i9 + i14;
        } else {
            int i15 = rect2.bottom;
            if (i10 > i15) {
                int i16 = i15 - i9;
                i10 = i9 + i16;
                i6 = i5 + i16;
            }
        }
        rect.left = i4;
        rect.top = i6;
        rect.bottom = i10;
        rect.right = i8;
    }

    public final void b(int i) {
        Rect rect = this.h;
        int i2 = rect.left + i;
        int i3 = this.g.left;
        if (i2 < i3 || i2 > (i3 = rect.right + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) {
            i2 = i3;
        }
        rect.left = i2;
    }

    public final void c(int i) {
        Rect rect = this.h;
        int i2 = rect.right + i;
        int i3 = this.g.right;
        if (i2 > i3 || i2 < (i3 = rect.left + 150)) {
            i2 = i3;
        }
        rect.right = i2;
    }

    public final void d(int i) {
        Rect rect = this.h;
        int i2 = rect.top + i;
        int i3 = this.g.top;
        if (i2 < i3 || i2 > (i3 = rect.bottom + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) {
            i2 = i3;
        }
        rect.top = i2;
    }

    public Rect getCropFrame() {
        return this.h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.g, this.b);
        }
        if (this.h != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Rect rect = this.h;
            this.a.setColor(this.c);
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, rect.top, this.a);
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.a);
            canvas.drawRect(rect.right + 1, rect.top, f, rect.bottom + 1, this.a);
            canvas.drawRect(0.0f, rect.bottom + 1, f, height, this.a);
            Rect rect2 = this.h;
            this.a.setColor(this.d);
            canvas.drawRect(rect2.left, rect2.top, rect2.right + 1, r2 + 2, this.a);
            canvas.drawRect(rect2.left, rect2.top + 2, r2 + 2, rect2.bottom - 1, this.a);
            int i = rect2.right;
            canvas.drawRect(i - 1, rect2.top, i + 1, rect2.bottom - 1, this.a);
            float f2 = rect2.left;
            int i2 = rect2.bottom;
            canvas.drawRect(f2, i2 - 1, rect2.right + 1, i2 + 1, this.a);
            int iWidth = rect2.width();
            int iHeight = rect2.height();
            for (int i3 = 1; i3 < 3; i3++) {
                float f3 = i3;
                float f4 = rect2.left + ((iWidth / 3.0f) * f3);
                canvas.drawLine(f4, rect2.top, f4, rect2.bottom, this.a);
                float f5 = rect2.top + ((iHeight / 3.0f) * f3);
                canvas.drawLine(rect2.left, f5, rect2.right, f5, this.a);
            }
            Rect rect3 = this.h;
            int i4 = rect3.left;
            int i5 = rect3.top;
            this.i = new Rect(i4 - 100, i5 - 100, i4 + 100, i5 + 100);
            int i6 = rect3.right;
            int i7 = rect3.top;
            this.k = new Rect(i6 - 100, i7 - 100, i6 + 100, i7 + 100);
            int i8 = rect3.left;
            int i9 = rect3.bottom;
            this.n = new Rect(i8 - 100, i9 - 100, i8 + 100, i9 + 100);
            int i10 = rect3.right;
            int i11 = rect3.bottom;
            this.p = new Rect(i10 - 100, i11 - 100, i10 + 100, i11 + 100);
            this.j = new Rect((rect3.left + (rect3.width() / 2)) - 100, rect3.top - 100, rect3.left + (rect3.width() / 2) + 100, rect3.top + 100);
            this.l = new Rect(rect3.left - 100, (rect3.top + (rect3.height() / 2)) - 100, rect3.left + 100, rect3.top + (rect3.height() / 2) + 100);
            this.m = new Rect(rect3.right - 100, (rect3.top + (rect3.height() / 2)) - 100, rect3.right + 100, rect3.top + (rect3.height() / 2) + 100);
            this.o = new Rect((rect3.left + (rect3.width() / 2)) - 100, rect3.bottom - 100, rect3.left + (rect3.width() / 2) + 100, rect3.bottom + 100);
            this.a.setColor(this.e);
            if (!this.u) {
                canvas.drawRect(rect3.left + ((rect3.width() - 30) / 2), rect3.top, rect3.left + ((rect3.width() + 30) / 2), rect3.top + 6, this.a);
                canvas.drawRect(rect3.left + ((rect3.width() - 30) / 2), rect3.bottom - 6, rect3.left + ((rect3.width() + 30) / 2), rect3.bottom, this.a);
                canvas.drawRect(rect3.left, rect3.top + ((rect3.height() - 30) / 2), rect3.left + 6, rect3.top + ((rect3.height() + 30) / 2), this.a);
                canvas.drawRect(rect3.right - 6, rect3.top + ((rect3.height() - 30) / 2), rect3.right, rect3.top + ((rect3.height() + 30) / 2), this.a);
            }
            canvas.drawRect(rect3.left, rect3.top, r2 + 6, r3 + 30, this.a);
            canvas.drawRect(rect3.left, rect3.top, r2 + 30, r3 + 6, this.a);
            int i12 = rect3.right;
            canvas.drawRect(i12 - 6, rect3.top, i12, r3 + 30, this.a);
            int i13 = rect3.right;
            canvas.drawRect(i13 - 30, rect3.top, i13, r3 + 6, this.a);
            canvas.drawRect(rect3.left, r3 - 6, r2 + 30, rect3.bottom, this.a);
            canvas.drawRect(rect3.left, r3 - 30, r2 + 6, rect3.bottom, this.a);
            canvas.drawRect(r2 - 6, r3 - 30, rect3.right, rect3.bottom, this.a);
            canvas.drawRect(r2 - 30, r1 - 6, rect3.right, rect3.bottom, this.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01c3 A[PHI: r8
  0x01c3: PHI (r8v4 int) = (r8v2 int), (r8v0 int) binds: [B:133:0x01cd, B:127:0x01c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01cf A[PHI: r8
  0x01cf: PHI (r8v3 int) = (r8v2 int), (r8v0 int) binds: [B:133:0x01cd, B:127:0x01c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01dc A[PHI: r7
  0x01dc: PHI (r7v5 int) = (r7v3 int), (r7v1 int) binds: [B:144:0x01e6, B:138:0x01d9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e8 A[PHI: r7
  0x01e8: PHI (r7v4 int) = (r7v3 int), (r7v1 int) binds: [B:144:0x01e6, B:138:0x01d9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.core.ui.imagepicker.crop.ViewCrop.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
