package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import com.qq.e.comm.plugin.bf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s extends bf<w, x> {
    private static final String B = "s";
    private final b A;
    private x x;
    private int y;
    private final Paint z;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.bf
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public w a(jv jvVar) {
        return new w(jvVar);
    }

    /* compiled from: A */
    private static class b {
        byte a;
        Rect b;
        ByteBuffer c;

        private b() {
            this.b = new Rect();
        }
    }

    public s(mo moVar, bf.j jVar) {
        super(moVar, jVar);
        Paint paint = new Paint();
        this.z = paint;
        this.A = new b();
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.bf
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public x i() {
        if (this.x == null) {
            this.x = new x();
        }
        return this.x;
    }

    @Override // com.qq.e.comm.plugin.bf
    protected int f() {
        return this.y;
    }

    @Override // com.qq.e.comm.plugin.bf
    protected void m() {
        this.A.c = null;
        this.x = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.bf
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect b(w wVar) throws IOException {
        List<e6> listA = v.a(wVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<e6> it = listA.iterator();
        u uVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            e6 next = it.next();
            boolean z2 = next instanceof ak;
            if (z2) {
                Log.e(B, "chunk read reach to end");
                break;
            }
            if (next instanceof c) {
                this.y = ((c) next).f;
                z = true;
            } else if (next instanceof kd) {
                uVar = new u(wVar, (kd) next);
                uVar.m = arrayList;
                uVar.k = bArr;
                this.d.add(uVar);
            } else if (next instanceof ld) {
                if (uVar != null) {
                    uVar.l.add(next);
                }
            } else if (next instanceof uj) {
                if (!z) {
                    i10 i10Var = new i10(wVar);
                    i10Var.b = i2;
                    i10Var.c = i;
                    this.d.add(i10Var);
                    this.y = 1;
                    break;
                }
                if (uVar != null) {
                    uVar.l.add(next);
                }
            } else if (next instanceof ok) {
                ok okVar = (ok) next;
                i2 = okVar.e;
                i = okVar.f;
                bArr = okVar.g;
            } else if (!z2) {
                arrayList.add(next);
            }
        }
        int i3 = i2 * i;
        int i4 = this.k;
        this.o = ByteBuffer.allocate(((i3 / (i4 * i4)) + 1) * 4);
        b bVar = this.A;
        int i5 = this.k;
        bVar.c = ByteBuffer.allocate(((i3 / (i5 * i5)) + 1) * 4);
        return new Rect(0, 0, i2, i);
    }

    @Override // com.qq.e.comm.plugin.bf
    protected void a(xe<w, x> xeVar) {
        if (xeVar == null || this.p == null) {
            return;
        }
        try {
            Bitmap bitmapB = b(this.p.width() / this.k, this.p.height() / this.k);
            Canvas canvas = this.n.get(bitmapB);
            if (canvas == null) {
                canvas = new Canvas(bitmapB);
                this.n.put(bitmapB, canvas);
            }
            Canvas canvas2 = canvas;
            if (xeVar instanceof u) {
                this.o.rewind();
                bitmapB.copyPixelsFromBuffer(this.o);
                if (this.e == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.A.b);
                    b bVar = this.A;
                    byte b2 = bVar.a;
                    if (b2 == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b2 == 2) {
                        bVar.c.rewind();
                        bitmapB.copyPixelsFromBuffer(this.A.c);
                    }
                    canvas2.restore();
                }
                if (((u) xeVar).j == 2) {
                    b bVar2 = this.A;
                    if (bVar2.a != 2) {
                        bVar2.c.rewind();
                        bitmapB.copyPixelsToBuffer(this.A.c);
                    }
                }
                this.A.a = ((u) xeVar).j;
                canvas2.save();
                if (((u) xeVar).i == 0) {
                    int i = xeVar.d;
                    int i2 = this.k;
                    int i3 = xeVar.e;
                    canvas2.clipRect(i / i2, i3 / i2, (i + xeVar.b) / i2, (i3 + xeVar.c) / i2);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                Rect rect = this.A.b;
                int i4 = xeVar.d;
                int i5 = this.k;
                int i6 = xeVar.e;
                rect.set(i4 / i5, i6 / i5, (i4 + xeVar.b) / i5, (i6 + xeVar.c) / i5);
                canvas2.restore();
            }
            Bitmap bitmapB2 = b(xeVar.b, xeVar.c);
            a(xeVar.a(canvas2, this.z, this.k, bitmapB2, i()));
            a(bitmapB2);
            this.o.rewind();
            bitmapB.copyPixelsToBuffer(this.o);
            a(bitmapB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
