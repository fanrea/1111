package com.bytedance.adsdk.d.d.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends gb<com.bytedance.adsdk.d.d.hc.d, com.bytedance.adsdk.d.d.hc.hc> {
    static final /* synthetic */ boolean an = true;
    byte[] b;
    List<u> c;
    public final byte d;
    public final byte hc;
    List<u> u;
    private static final byte[] e = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] cb = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
    private static final ThreadLocal<CRC32> w = new ThreadLocal<>();

    private CRC32 d() {
        ThreadLocal<CRC32> threadLocal = w;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        threadLocal.set(crc322);
        return crc322;
    }

    public b(com.bytedance.adsdk.d.d.hc.d dVar, an anVar) {
        super(dVar);
        this.c = new ArrayList();
        this.u = new ArrayList();
        this.d = anVar.k;
        this.hc = anVar.uo;
        this.mq = (anVar.mk * 1000) / (anVar.mq == 0 ? (short) 100 : anVar.mq);
        if (this.mq < 10) {
            this.mq = 100;
        }
        this.gb = anVar.b;
        this.tt = anVar.gb;
        this.tc = anVar.tt;
        this.mk = anVar.tc;
    }

    private int d(com.bytedance.adsdk.d.d.hc.hc hcVar) throws IOException {
        int i;
        Iterator<u> it = this.u.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += it.next().c + 12;
        }
        for (u uVar : this.c) {
            if (uVar instanceof tc) {
                i = uVar.c + 12;
            } else if (uVar instanceof h) {
                i = uVar.c + 8;
            }
            i2 += i;
        }
        int length = i2 + cb.length;
        hcVar.b(length);
        hcVar.d(e);
        hcVar.hc(13);
        int iD = hcVar.d();
        hcVar.d(mq.d);
        hcVar.hc(this.gb);
        hcVar.hc(this.tt);
        hcVar.d(this.b);
        CRC32 crc32D = d();
        crc32D.reset();
        crc32D.update(hcVar.hc(), iD, 17);
        hcVar.hc((int) crc32D.getValue());
        for (u uVar2 : this.u) {
            if (!(uVar2 instanceof mk)) {
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d_();
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d(uVar2.h);
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d(hcVar.hc(), hcVar.d(), uVar2.c + 12);
                hcVar.c(uVar2.c + 12);
            }
        }
        for (u uVar3 : this.c) {
            if (uVar3 instanceof tc) {
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d_();
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d(uVar3.h);
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d(hcVar.hc(), hcVar.d(), uVar3.c + 12);
                hcVar.c(uVar3.c + 12);
            } else if (uVar3 instanceof h) {
                hcVar.hc(uVar3.c - 4);
                int iD2 = hcVar.d();
                hcVar.d(tc.d);
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d_();
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d(uVar3.h + 4 + 4 + 4);
                ((com.bytedance.adsdk.d.d.hc.d) this.h).d(hcVar.hc(), hcVar.d(), uVar3.c - 4);
                hcVar.c(uVar3.c - 4);
                crc32D.reset();
                crc32D.update(hcVar.hc(), iD2, uVar3.c);
                hcVar.hc((int) crc32D.getValue());
            }
        }
        hcVar.d(cb);
        return length;
    }

    @Override // com.bytedance.adsdk.d.d.d.gb
    public Bitmap d(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.d.d.hc.hc hcVar) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iD = d(hcVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] bArrHc = hcVar.hc();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrHc, 0, iD, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrHc, 0, iD, options2);
            }
            if (!an && bitmapDecodeByteArray == null) {
                throw new AssertionError();
            }
            this.uo.left = 0;
            this.uo.top = 0;
            this.uo.right = bitmapDecodeByteArray.getWidth();
            this.uo.bottom = bitmapDecodeByteArray.getHeight();
            float f = i;
            this.k.left = (int) (this.tc / f);
            this.k.top = (int) (this.mk / f);
            this.k.right = (int) ((this.tc / f) + bitmapDecodeByteArray.getWidth());
            this.k.bottom = (int) ((this.mk / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.uo, this.k, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e2) {
            com.bytedance.sdk.component.utils.mq.d(e2);
            return null;
        }
    }
}
