package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.qq.e.comm.plugin.bf;
import com.qq.e.comm.plugin.pk;
import com.qq.e.comm.plugin.w40;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rq extends p4 {
    private float[] R;

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public rq a() {
            return new rq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public sq b(e8 e8Var) {
        sq sqVar = new sq(c().d());
        sqVar.setScaleType(ImageView.ScaleType.FIT_XY);
        if (Build.VERSION.SDK_INT >= 16) {
            sqVar.setCropToPadding(true);
        }
        return sqVar;
    }

    @Override // com.qq.e.comm.plugin.w40
    protected v40<sq> p() {
        return new v40<>(this, this.A);
    }

    @Override // com.qq.e.comm.plugin.p4
    protected void a(float[] fArr) {
        if (fArr == null || fArr.length < 4) {
            return;
        }
        this.R = fArr;
    }

    @Override // com.qq.e.comm.plugin.p4
    public void m(int i) {
        ImageView.ScaleType scaleTypeN = n(i);
        if (Build.VERSION.SDK_INT >= 16 && scaleTypeN == ImageView.ScaleType.CENTER_CROP) {
            ((sq) this.A).setCropToPadding(true);
        }
        ((sq) this.A).setScaleType(scaleTypeN);
    }

    private ImageView.ScaleType n(int i) {
        if (i == 1) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        if (i == 2) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if (i != 4) {
            return ImageView.ScaleType.FIT_XY;
        }
        return ImageView.ScaleType.CENTER;
    }

    /* compiled from: A */
    private static class b implements pk.a {
        private final rq a;
        private final int b;
        private final float[] c;
        private final Object d;
        private final WeakReference<sq> e;
        protected JSONArray f;

        private int a(int i, float f) {
            if (i <= 0 || f <= 0.0f) {
                return 0;
            }
            if (f == 1.0f) {
                return i;
            }
            float f2 = i;
            return f >= f2 ? i : f > 1.0f ? (int) f : (int) (f2 * f);
        }

        public b(rq rqVar, int i, float[] fArr, Object obj, sq sqVar, JSONArray jSONArray) {
            this.a = rqVar;
            this.b = i;
            this.c = fArr;
            this.d = obj;
            this.e = new WeakReference<>(sqVar);
            this.f = jSONArray;
        }

        private Bitmap a(Bitmap bitmap, float[] fArr) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int iA = a(width, fArr[0]);
            int iA2 = a(height, fArr[1]);
            int iA3 = a(width, fArr[2]);
            int iA4 = a(height, fArr[3]);
            if (iA + iA3 > width) {
                iA3 = width - iA;
            }
            if (iA2 + iA4 > height) {
                iA4 = height - iA2;
            }
            return (iA3 == 0 || iA4 == 0) ? bitmap : Bitmap.createBitmap(bitmap, iA, iA2, iA3, iA4);
        }

        @Override // com.qq.e.comm.plugin.pk.a
        public void a(Object obj, int i, Exception exc) {
            va.a(obj, i, exc);
        }

        @Override // com.qq.e.comm.plugin.pk.a
        public void a(File file, Object obj) {
            sq sqVar = this.e.get();
            if (sqVar == null) {
                return;
            }
            if (obj instanceof Bitmap) {
                int i = this.b;
                if (i == 0) {
                    Bitmap bitmapA = (Bitmap) obj;
                    float[] fArr = this.c;
                    if (fArr != null) {
                        bitmapA = a(bitmapA, fArr);
                    }
                    sqVar.setImageBitmap(bitmapA);
                    return;
                }
                c8.a(this.d, sqVar, (Bitmap) obj, i, this.f);
                return;
            }
            if (obj instanceof Movie) {
                if (this.a.f781K) {
                    sqVar.a((Movie) obj);
                }
            } else if (obj instanceof Drawable) {
                a(sqVar, (Drawable) obj);
            }
        }

        private void a(sq sqVar, Drawable drawable) {
            rq rqVar = this.a;
            if (rqVar.f781K) {
                if (drawable instanceof t) {
                    t tVar = (t) drawable;
                    int iO = rqVar.O();
                    int iN = this.a.N();
                    if (iO > 0 && iN != 1) {
                        tVar.a(1);
                        tVar.c().a(new c(this.a, tVar));
                    } else {
                        tVar.a(iN);
                    }
                }
                if (this.a.Q() <= 0) {
                    sqVar.setImageDrawable(drawable);
                } else {
                    sqVar.postDelayed(new d(this.e, drawable), this.a.Q());
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.p4
    public void a(Object obj) {
        if (this.N == null) {
            return;
        }
        c().f().a(obj, new b(this, this.O, this.R, this.N, (sq) this.A, this.P));
    }

    @Override // com.qq.e.comm.plugin.p4, com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        this.R = null;
    }

    /* compiled from: A */
    private static class d implements Runnable {
        private final WeakReference<sq> a;
        private final Drawable b;

        public d(WeakReference<sq> weakReference, Drawable drawable) {
            this.a = weakReference;
            this.b = drawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            sq sqVar = this.a.get();
            if (sqVar == null) {
                return;
            }
            sqVar.setImageDrawable(this.b);
        }
    }

    /* compiled from: A */
    private static class c implements Runnable, bf.j {
        private final WeakReference<p4> a;
        private final t b;
        private int c;

        @Override // com.qq.e.comm.plugin.bf.j
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.bf.j
        public void a(ByteBuffer byteBuffer) {
        }

        public c(p4 p4Var, t tVar) {
            this.a = new WeakReference<>(p4Var);
            this.b = tVar;
            int iN = p4Var.N();
            this.c = iN == 0 ? -1 : iN;
        }

        @Override // com.qq.e.comm.plugin.bf.j
        public void b() {
            sq sqVarA;
            p4 p4Var = this.a.get();
            if (p4Var == null || (sqVarA = p4Var.A()) == null) {
                return;
            }
            int i = this.c - 1;
            this.c = i;
            if (i == 0) {
                r2 r2Var = p4Var.L;
                if (r2Var != null) {
                    r2Var.a(p4Var.J);
                    return;
                }
                return;
            }
            sqVarA.postDelayed(this, p4Var.O());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.start();
        }
    }
}
