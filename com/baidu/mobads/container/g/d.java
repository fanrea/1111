package com.baidu.mobads.container.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends View implements com.baidu.mobads.container.g.a {
    public h a;
    private com.baidu.mobads.container.g.b b;
    private Bitmap c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private Rect h;
    private a i;
    private b j;
    private boolean k;
    private final Paint l;
    private g m;
    private int n;
    private Handler o;

    public enum b {
        WAIT_FINISH(0),
        SYNC_DECODER(1),
        COVER(2);

        final int d;

        b(int i) {
            this.d = i;
        }
    }

    public d(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = true;
        this.e = false;
        this.f = -1;
        this.g = -1;
        this.h = null;
        this.i = null;
        this.j = b.SYNC_DECODER;
        this.k = true;
        this.l = new Paint();
        this.n = 255;
        this.o = new e(this);
    }

    public d(Context context, g gVar) {
        this(context);
        this.m = gVar;
        if (this.l != null) {
            this.l.setAlpha(this.n);
            this.l.setAntiAlias(true);
            this.l.setFilterBitmap(true);
            this.l.setDither(true);
        }
    }

    public void a(boolean z) {
        if (z && this.l != null) {
            setLayerType(1, this.l);
        }
    }

    private void b(byte[] bArr) throws IOException {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        this.b = new com.baidu.mobads.container.g.b(bArr, this);
        this.b.start();
    }

    private void b(InputStream inputStream, int i, int i2) throws IOException {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        this.b = new com.baidu.mobads.container.g.b(inputStream, this, i, i2);
        this.b.start();
    }

    private void b(InputStream inputStream, float f) throws IOException {
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        this.b = new com.baidu.mobads.container.g.b(inputStream, this, f);
        this.b.start();
    }

    public void a(byte[] bArr) throws IOException {
        b(bArr);
    }

    public void a(InputStream inputStream) throws IOException {
        a(inputStream, 1.0f);
    }

    public void a(InputStream inputStream, float f) throws IOException {
        b(inputStream, f);
    }

    public void a(InputStream inputStream, int i, int i2) throws IOException {
        b(inputStream, i, i2);
    }

    public void a(int i) throws IOException {
        a(i, 1.0f);
    }

    public void a(int i, float f) throws IOException {
        b(getResources().openRawResource(i), f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == null) {
            return;
        }
        if (this.c == null) {
            this.c = this.b.g();
        }
        if (this.c == null) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        if (this.f == -1) {
            canvas.drawBitmap(this.c, 0.0f, 0.0f, this.l);
        } else {
            canvas.drawBitmap(this.c, (Rect) null, this.h, this.l);
        }
        canvas.restoreToCount(saveCount);
        if (this.a != null && this.k) {
            this.a.a();
            this.k = false;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (this.b == null) {
            i3 = 1;
            i4 = 1;
        } else {
            i3 = this.b.e;
            i4 = this.b.f;
        }
        setMeasuredDimension(resolveSize(Math.max(i3 + paddingLeft + paddingRight, getSuggestedMinimumWidth()), i), resolveSize(Math.max(i4 + paddingTop + paddingBottom, getSuggestedMinimumHeight()), i2));
    }

    public Bitmap a() {
        return this.c;
    }

    public void b() {
        if (this.b == null) {
            return;
        }
        this.e = true;
        this.c = this.b.g();
        invalidate();
    }

    public void c() {
        if (this.e) {
            this.e = false;
        }
    }

    public void a(b bVar) {
        if (this.b == null) {
            this.j = bVar;
        }
    }

    public void a(float f) {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            this.f = width;
            this.g = height;
            this.h = new Rect();
            float f2 = f - 1.0f;
            double d = width * f2;
            Double.isNaN(d);
            int i = (int) (d * 0.5d);
            double d2 = height * f2;
            Double.isNaN(d2);
            int i2 = (int) (d2 * 0.5d);
            this.h.left = -i;
            this.h.top = -i2;
            this.h.right = width + i;
            this.h.bottom = height + i2;
        }
    }

    public void a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f = i;
            this.g = i2;
            this.h = new Rect();
            this.h.left = 0;
            this.h.top = 0;
            this.h.right = i;
            this.h.bottom = i2;
        }
    }

    @Override // com.baidu.mobads.container.g.a
    public void a(boolean z, int i) {
        if (z) {
            if (this.b != null) {
                e eVar = null;
                switch (this.j) {
                    case WAIT_FINISH:
                        if (i == -1) {
                            if (this.b.f() > 1) {
                                new a(this, eVar).start();
                                break;
                            } else {
                                g();
                                break;
                            }
                        }
                        break;
                    case COVER:
                        if (i == 1) {
                            this.c = this.b.g();
                            g();
                            break;
                        } else if (i == -1) {
                            if (this.b.f() > 1) {
                                if (this.i == null) {
                                    this.i = new a(this, eVar);
                                    this.i.start();
                                    break;
                                }
                            } else {
                                g();
                                break;
                            }
                        }
                        break;
                    case SYNC_DECODER:
                        if (i == 1) {
                            this.c = this.b.g();
                            g();
                            break;
                        } else if (i == -1) {
                            g();
                            break;
                        } else if (this.i == null) {
                            this.i = new a(this, eVar);
                            this.i.start();
                            break;
                        }
                        break;
                }
            }
            return;
        }
        if (this.o != null) {
            Message messageObtainMessage = this.o.obtainMessage();
            messageObtainMessage.what = -1;
            this.o.sendMessage(messageObtainMessage);
        }
    }

    private void g() {
        if (this.o != null) {
            this.o.sendMessage(this.o.obtainMessage());
        }
    }

    public void d() {
        this.e = true;
    }

    public void e() {
        this.e = false;
    }

    public void f() throws IOException {
        this.e = true;
        this.d = false;
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        if (this.a != null) {
            this.a = null;
        }
    }

    public void b(int i) {
        this.n = i;
        this.l.setAlpha(this.n);
        invalidate();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.e = i != 0;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() throws IOException {
        f();
        super.onDetachedFromWindow();
    }

    private class a extends Thread {
        private a() {
        }

        /* synthetic */ a(d dVar, e eVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (d.this.b != null) {
                    while (d.this.d) {
                        if (!d.this.e) {
                            c cVarK = d.this.b.k();
                            d.this.c = cVarK.a;
                            long j = cVarK.b;
                            if (d.this.o != null) {
                                d.this.o.sendMessage(d.this.o.obtainMessage());
                                if (j > 0) {
                                    SystemClock.sleep(j);
                                }
                            } else {
                                return;
                            }
                        } else {
                            SystemClock.sleep(500L);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
