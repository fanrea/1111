package com.tk.component.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tk.core.o.r;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private RectF Ex;
    private Rect Ey;
    private Canvas NY;
    private volatile boolean NZ;

    static /* synthetic */ Canvas a(a aVar, Canvas canvas) {
        aVar.NY = null;
        return null;
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Ex = new RectF();
        this.Ey = new Rect();
    }

    public final void h(Canvas canvas) {
        this.NY = canvas;
    }

    public final void ai(String str) {
        Canvas canvas;
        if (this.NZ || (canvas = this.NY) == null) {
            return;
        }
        canvas.drawColor(r.parseColor(str));
    }

    public final void a(float f, float f2, float f3, V8Object v8Object) {
        if (this.NZ || this.NY == null) {
            return;
        }
        this.NY.drawCircle(o.P(f), o.P(f2), o.P(f3), ((e) getNativeModule(v8Object)).getPaint());
    }

    public final void a(Object obj, V8Object v8Object) {
        if (this.NZ || this.NY == null) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.NY.drawRect(this.Ex, ((e) getNativeModule(v8Object)).getPaint());
    }

    public final void b(Object obj, V8Object v8Object) {
        if (this.NZ || this.NY == null) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.NY.drawOval(this.Ex, ((e) getNativeModule(v8Object)).getPaint());
    }

    public final void a(float f, float f2, float f3, float f4, V8Object v8Object) {
        if (this.NZ || this.NY == null) {
            return;
        }
        this.NY.drawLine(o.P(f), o.P(f2), o.P(f3), o.P(f4), ((e) getNativeModule(v8Object)).getPaint());
    }

    public final void a(Object obj, float f, float f2, V8Object v8Object) {
        if (this.NZ || this.NY == null) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.NY.drawRoundRect(this.Ex, o.P(f), o.P(f2), ((e) getNativeModule(v8Object)).getPaint());
    }

    public final void a(Object obj, float f, float f2, boolean z, V8Object v8Object) {
        if (this.NZ || this.NY == null) {
            return;
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        this.NY.drawArc(this.Ex, f, f2, z, ((e) getNativeModule(v8Object)).getPaint());
    }

    public final void a(V8Object v8Object, V8Object v8Object2) {
        if (this.NZ || this.NY == null) {
            return;
        }
        this.NY.drawPath(((g) getNativeModule(v8Object)).getPath(), ((e) getNativeModule(v8Object2)).getPaint());
    }

    public final void a(String str, float f, float f2, V8Object v8Object) {
        if (this.NZ || this.NY == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.NY.drawText(str, o.P(f), o.P(f2), ((e) getNativeModule(v8Object)).getPaint());
    }

    public final void a(V8Object v8Object, Object obj, Object obj2, V8Object v8Object2) {
        if (this.NZ || this.NY == null) {
            return;
        }
        Rect rect = null;
        if (!ad.isV8Valid(v8Object)) {
            com.tk.core.i.a.a("Canvas2D", "drawImage() image has been released.", null);
            return;
        }
        com.tk.component.b.b.a aVar = (com.tk.component.b.b.a) getNativeModule(v8Object);
        if (aVar == null) {
            com.tk.core.i.a.a("Canvas2D", "drawImage() can't find native object from image.", null);
            return;
        }
        Bitmap bitmap = aVar.getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            com.tk.core.i.a.a("Canvas2D", "drawImage() can't find active bitmap from image.", null);
            return;
        }
        Paint paint = v8Object2 != null ? ((e) getNativeModule(v8Object2)).getPaint() : null;
        if (obj2 != null) {
            com.tk.component.a.a.a.a(this.Ey, (Map) V8ObjectUtilsQuick.getValue(obj2));
            rect = this.Ey;
            if (rect.right > aVar.getWidth()) {
                rect.right = aVar.getWidth();
            }
            if (rect.bottom > aVar.getHeight()) {
                rect.bottom = aVar.getHeight();
            }
        }
        com.tk.component.a.a.a.a(this.Ex, (Map) V8ObjectUtilsQuick.getValue(obj));
        if (bitmap.isRecycled()) {
            Log.e("Canvas2D", "drawImage() bitmap has been recycled before drawn.");
        } else {
            this.NY.drawBitmap(bitmap, rect, this.Ex, paint);
        }
    }

    public final void p(V8Object v8Object) {
        if (this.NZ || this.NY == null) {
            return;
        }
        this.NY.clipPath(((g) getNativeModule(v8Object)).getPath());
    }

    public final void translate(float f, float f2) {
        Canvas canvas;
        if (this.NZ || (canvas = this.NY) == null) {
            return;
        }
        canvas.translate(o.P(f), o.P(f2));
    }

    public final void rotate(float f) {
        Canvas canvas;
        if (this.NZ || (canvas = this.NY) == null) {
            return;
        }
        canvas.rotate(f);
    }

    public final void scale(float f, float f2) {
        Canvas canvas;
        if (this.NZ || (canvas = this.NY) == null) {
            return;
        }
        canvas.scale(f, f2);
    }

    public final void skew(float f, float f2) {
        Canvas canvas;
        if (this.NZ || (canvas = this.NY) == null) {
            return;
        }
        canvas.skew(f, f2);
    }

    public final void save() {
        Canvas canvas;
        if (this.NZ || (canvas = this.NY) == null) {
            return;
        }
        canvas.save();
    }

    public final void restore() {
        Canvas canvas;
        if (this.NZ || (canvas = this.NY) == null) {
            return;
        }
        try {
            canvas.restore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void ml() {
        this.NZ = true;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        ml();
        if (this.NY != null) {
            if (z) {
                this.NY = null;
            } else {
                ac.runOnUiThread(new Runnable() { // from class: com.tk.component.a.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.a(a.this, (Canvas) null);
                    }
                });
            }
        }
    }
}
