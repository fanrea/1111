package com.bytedance.adsdk.d.d.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.bytedance.adsdk.d.d.d.tt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends tt<com.bytedance.adsdk.d.d.hc.d, com.bytedance.adsdk.d.d.hc.hc> {
    private int gb;
    private com.bytedance.adsdk.d.d.hc.hc h;
    private final d tc;
    private final Paint tt;

    private static class d {
        ByteBuffer b;
        byte d;
        Rect hc;

        private d() {
            this.hc = new Rect();
        }
    }

    public hc(com.bytedance.adsdk.d.d.b.hc hcVar, tt.d dVar) {
        super(hcVar, dVar);
        Paint paint = new Paint();
        this.tt = paint;
        this.tc = new d();
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.d.d.d.tt
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.d.d.hc.hc c() {
        if (this.h == null) {
            this.h = new com.bytedance.adsdk.d.d.hc.hc();
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.d.d.d.tt
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.d.d.hc.d b(com.bytedance.adsdk.d.d.hc.an anVar) {
        return new com.bytedance.adsdk.d.d.hc.d(anVar);
    }

    @Override // com.bytedance.adsdk.d.d.d.tt
    protected int hc() {
        return this.gb;
    }

    @Override // com.bytedance.adsdk.d.d.d.tt
    protected void b() {
        this.tc.b = null;
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.d.d.d.tt
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Rect hc(com.bytedance.adsdk.d.d.hc.d dVar) throws IOException {
        List<u> listD = c.d(dVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<u> it = listD.iterator();
        b bVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            u next = it.next();
            if (next instanceof com.bytedance.adsdk.d.d.d.d) {
                this.gb = ((com.bytedance.adsdk.d.d.d.d) next).b;
                z = true;
            } else if (next instanceof an) {
                bVar = new b(dVar, (an) next);
                bVar.u = arrayList;
                bVar.b = bArr;
                this.d.add(bVar);
            } else if (next instanceof h) {
                if (bVar != null) {
                    bVar.c.add(next);
                }
            } else if (next instanceof tc) {
                if (!z) {
                    uo uoVar = new uo(dVar);
                    uoVar.gb = i;
                    uoVar.tt = i2;
                    this.d.add(uoVar);
                    this.gb = 1;
                    break;
                }
                if (bVar != null) {
                    bVar.c.add(next);
                }
            } else if (next instanceof mq) {
                mq mqVar = (mq) next;
                i = mqVar.hc;
                i2 = mqVar.b;
                bArr = mqVar.gb;
            } else if (!(next instanceof mk)) {
                arrayList.add(next);
            }
        }
        int i3 = i * i2;
        this.u = ByteBuffer.allocate(((i3 / (this.b * this.b)) + 1) * 4);
        this.tc.b = ByteBuffer.allocate(((i3 / (this.b * this.b)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.bytedance.adsdk.d.d.d.tt
    protected void d(gb<com.bytedance.adsdk.d.d.hc.d, com.bytedance.adsdk.d.d.hc.hc> gbVar) {
        if (gbVar == null || this.an == null) {
            return;
        }
        try {
            Bitmap bitmapD = d(this.an.width() / this.b, this.an.height() / this.b);
            Canvas canvas = this.c.get(bitmapD);
            if (canvas == null) {
                canvas = new Canvas(bitmapD);
                this.c.put(bitmapD, canvas);
            }
            Canvas canvas2 = canvas;
            if (gbVar instanceof b) {
                this.u.rewind();
                bitmapD.copyPixelsFromBuffer(this.u);
                if (this.hc == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.tc.hc);
                    byte b = this.tc.d;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        this.tc.b.rewind();
                        bitmapD.copyPixelsFromBuffer(this.tc.b);
                    }
                    canvas2.restore();
                }
                if (((b) gbVar).hc == 2 && this.tc.d != 2) {
                    this.tc.b.rewind();
                    bitmapD.copyPixelsToBuffer(this.tc.b);
                }
                this.tc.d = ((b) gbVar).hc;
                canvas2.save();
                if (((b) gbVar).d == 0) {
                    canvas2.clipRect(gbVar.tc / this.b, gbVar.mk / this.b, (gbVar.tc + gbVar.gb) / this.b, (gbVar.mk + gbVar.tt) / this.b);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                this.tc.hc.set(gbVar.tc / this.b, gbVar.mk / this.b, (gbVar.tc + gbVar.gb) / this.b, (gbVar.mk + gbVar.tt) / this.b);
                canvas2.restore();
            }
            Bitmap bitmapD2 = d(gbVar.gb, gbVar.tt);
            d(gbVar.d(canvas2, this.tt, this.b, bitmapD2, c()));
            d(bitmapD2);
            this.u.rewind();
            bitmapD.copyPixelsToBuffer(this.u);
            d(bitmapD);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
