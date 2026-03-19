package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u extends xe<w, x> {
    private static final byte[] n = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] o = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final ThreadLocal<CRC32> p = new ThreadLocal<>();
    static final /* synthetic */ boolean q = true;
    public final byte i;
    public final byte j;
    byte[] k;
    List<e6> l;
    List<e6> m;

    public u(w wVar, kd kdVar) {
        super(wVar);
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = kdVar.m;
        this.j = kdVar.l;
        int i = kdVar.j * 1000;
        short s = kdVar.k;
        int i2 = i / (s == 0 ? (short) 100 : s);
        this.f = i2;
        if (i2 < 10) {
            this.f = 100;
        }
        this.b = kdVar.f;
        this.c = kdVar.g;
        this.d = kdVar.h;
        this.e = kdVar.i;
    }

    private ja b() throws JSONException {
        R r = this.a;
        if (r == 0) {
            return null;
        }
        w wVar = (w) r;
        se seVar = wVar.a instanceof se ? (se) wVar.a : null;
        if (seVar == null) {
            return null;
        }
        String str = seVar.c;
        ja jaVar = new ja();
        jaVar.a("url", str);
        return jaVar;
    }

    @Override // com.qq.e.comm.plugin.xe
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, x xVar) throws JSONException {
        Bitmap bitmapDecodeByteArray;
        try {
            int iA = a(xVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrB = xVar.b();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrB, 0, iA, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrB, 0, iA, options2);
            }
            if (!q && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            Rect rect = this.g;
            rect.left = 0;
            rect.top = 0;
            rect.right = bitmapDecodeByteArray.getWidth();
            this.g.bottom = bitmapDecodeByteArray.getHeight();
            Rect rect2 = this.h;
            float f = i;
            float f2 = this.d / f;
            rect2.left = (int) f2;
            rect2.top = (int) (this.e / f);
            rect2.right = (int) (f2 + bitmapDecodeByteArray.getWidth());
            this.h.bottom = (int) ((this.e / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.g, this.h, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            b10.a(9700001, null, 2, null, b());
            return null;
        }
    }

    private int a(x xVar) throws JSONException, IOException {
        int i;
        Iterator<e6> it = this.m.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().a + 12;
        }
        for (e6 e6Var : this.l) {
            if (e6Var instanceof uj) {
                i = e6Var.a + 12;
            } else if (e6Var instanceof ld) {
                i = e6Var.a + 8;
            }
            i2 += i;
        }
        int length = i2 + o.length;
        a(length);
        xVar.a(length);
        xVar.a(n);
        xVar.d(13);
        int iA = xVar.a();
        xVar.c(ok.h);
        xVar.d(this.b);
        xVar.d(this.c);
        xVar.a(this.k);
        CRC32 crc32A = a();
        crc32A.reset();
        crc32A.update(xVar.b(), iA, 17);
        xVar.d((int) crc32A.getValue());
        for (e6 e6Var2 : this.m) {
            if (!(e6Var2 instanceof ak)) {
                ((w) this.a).reset();
                ((w) this.a).skip(e6Var2.d);
                ((w) this.a).read(xVar.b(), xVar.a(), e6Var2.a + 12);
                xVar.b(e6Var2.a + 12);
            }
        }
        for (e6 e6Var3 : this.l) {
            if (e6Var3 instanceof uj) {
                ((w) this.a).reset();
                ((w) this.a).skip(e6Var3.d);
                ((w) this.a).read(xVar.b(), xVar.a(), e6Var3.a + 12);
                xVar.b(e6Var3.a + 12);
            } else if (e6Var3 instanceof ld) {
                xVar.d(e6Var3.a - 4);
                int iA2 = xVar.a();
                xVar.c(uj.e);
                ((w) this.a).reset();
                ((w) this.a).skip(e6Var3.d + 12);
                ((w) this.a).read(xVar.b(), xVar.a(), e6Var3.a - 4);
                xVar.b(e6Var3.a - 4);
                crc32A.reset();
                crc32A.update(xVar.b(), iA2, e6Var3.a);
                xVar.d((int) crc32A.getValue());
            }
        }
        xVar.a(o);
        return length;
    }

    private void a(int i) throws JSONException {
        ja jaVarB;
        if (i >= 10485760 && (jaVarB = b()) != null) {
            jaVarB.a("data", Integer.valueOf(i));
            b10.a(9700001, null, 1, null, jaVarB);
        }
    }

    private CRC32 a() {
        ThreadLocal<CRC32> threadLocal = p;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        threadLocal.set(crc322);
        return crc322;
    }
}
