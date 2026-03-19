package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.TextureView;
import android.view.View;
import com.bytedance.adsdk.lottie.tt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoFrame extends View {
    private long an;
    private final tt.d.C0170d b;
    private RenderScript c;
    private final TextureView d;
    private int gb;
    private Bitmap h;
    private final Matrix hc;
    private ScriptIntrinsicBlur u;

    public VideoFrame(Context context, TextureView textureView, tt.d.C0170d c0170d) {
        super(context);
        this.an = -1L;
        this.h = null;
        this.gb = 0;
        this.d = textureView;
        this.hc = new Matrix();
        this.b = c0170d;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.an >= 40) {
            this.an = jElapsedRealtime;
            TextureView textureView = this.d;
            if (textureView != null && textureView.isAvailable()) {
                float width = this.d.getWidth() / 160.0f;
                if (width > 0.0f) {
                    this.gb = (int) (this.d.getHeight() / width);
                }
                int i = this.gb;
                if (i > 0 && (bitmap2 = this.d.getBitmap(160, i)) != null) {
                    Bitmap bitmap3 = this.h;
                    if (bitmap3 != null && !bitmap3.isRecycled()) {
                        this.h.recycle();
                    }
                    this.h = d(bitmap2, this.b.d);
                    bitmap2.recycle();
                }
            }
        }
        if (this.gb <= 0 || (bitmap = this.h) == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        this.hc.reset();
        this.hc.setScale(getWidth() / 160.0f, getHeight() / this.gb);
        canvas.concat(this.hc);
        canvas.drawBitmap(this.h, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RenderScript renderScript = this.c;
        if (renderScript != null) {
            renderScript.destroy();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.u;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        RenderScript renderScriptCreate = RenderScript.create(getContext());
        this.c = renderScriptCreate;
        this.u = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.h.recycle();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.u;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.u = null;
        }
        RenderScript renderScript = this.c;
        if (renderScript != null) {
            renderScript.destroy();
            this.c = null;
        }
    }

    public Bitmap d(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        try {
            RenderScript renderScript = this.c;
            if (renderScript != null && this.u != null) {
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                Allocation allocationCreateTyped = Allocation.createTyped(this.c, allocationCreateFromBitmap.getType());
                this.u.setRadius(f);
                this.u.setInput(allocationCreateFromBitmap);
                this.u.forEach(allocationCreateTyped);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap);
                try {
                    allocationCreateTyped.copyTo(bitmapCreateBitmap);
                    allocationCreateTyped.destroy();
                    allocationCreateFromBitmap.destroy();
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    th = th;
                    com.bytedance.sdk.component.utils.mq.d(th);
                    if (bitmapCreateBitmap != null) {
                        bitmapCreateBitmap.recycle();
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bitmapCreateBitmap = null;
        }
    }
}
