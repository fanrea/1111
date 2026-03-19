package com.bytedance.sdk.djx.core.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Picture;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CheckWhiteUtils {
    public static final String TAG = "CheckWhiteUtils";

    public static Bitmap pick(WebView webView) {
        if (webView == null) {
            return null;
        }
        try {
            Bitmap screenShot = getScreenShot(webView, 0);
            return screenShot == null ? captureWebView(webView) : screenShot;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean checkRecycler(Bitmap bitmap) {
        return bitmap == null || bitmap.isRecycled();
    }

    private static Bitmap getScreenShot(View view, int i) {
        Bitmap drawingCache;
        if (view == null) {
            return null;
        }
        try {
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            drawingCache = view.getDrawingCache();
            if (i > 0 && drawingCache != null) {
                try {
                    if (checkRecycler(drawingCache)) {
                        return null;
                    }
                    if (drawingCache.getRowBytes() * drawingCache.getHeight() >= i) {
                        if (checkRecycler(drawingCache)) {
                            return null;
                        }
                        drawingCache = BitmapUtils.resizeBitmap(drawingCache, 720, 0);
                    }
                    if (checkRecycler(drawingCache)) {
                        return null;
                    }
                    if (drawingCache.getRowBytes() * drawingCache.getHeight() >= i) {
                        if (checkRecycler(drawingCache)) {
                            return null;
                        }
                        drawingCache = BitmapUtils.compressBitmap(drawingCache, i);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            drawingCache = null;
        }
        if (checkRecycler(drawingCache)) {
            return null;
        }
        return drawingCache;
    }

    private static Bitmap captureWebView(WebView webView) {
        Bitmap bitmapCreateBitmap = null;
        try {
            Picture pictureCapturePicture = webView.capturePicture();
            if (pictureCapturePicture != null && pictureCapturePicture.getWidth() > 0 && pictureCapturePicture.getHeight() > 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.ARGB_8888);
                pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
                return bitmapCreateBitmap;
            }
            return null;
        } catch (Throwable unused) {
            return bitmapCreateBitmap;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static boolean checkWebViewIsTransparent(Bitmap bitmap, int i) {
        LG.d(TAG, "checkWebViewIsTransparent start ..... bitmap = " + bitmap);
        ?? r1 = 0;
        if (bitmap == null) {
            return false;
        }
        try {
            if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                int iAlpha = Color.alpha(i);
                int iRed = Color.red(i);
                int iGreen = Color.green(i);
                int iBlue = Color.blue(i);
                if (checkRecycler(bitmap)) {
                    return false;
                }
                Bitmap bitmapResizeBitmap = BitmapUtils.resizeBitmap(bitmap, bitmap.getWidth() / 6, bitmap.getHeight() / 6);
                if (!checkRecycler(bitmap) && !checkRecycler(bitmapResizeBitmap)) {
                    int width = bitmapResizeBitmap.getWidth();
                    int height = bitmapResizeBitmap.getHeight();
                    double d = width * height;
                    long j = (long) (0.01d * d);
                    long j2 = (long) (d * 0.7d);
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    ?? r7 = bitmapResizeBitmap;
                    while (i2 < height) {
                        while (r1 < width) {
                            if (checkRecycler(r7)) {
                                return false;
                            }
                            int pixel = r7.getPixel(r1, i2);
                            int i5 = width;
                            int iRed2 = Color.red(pixel);
                            Object obj = r7;
                            int iGreen2 = Color.green(pixel);
                            int i6 = height;
                            int iBlue2 = Color.blue(pixel);
                            int i7 = i2;
                            int iAlpha2 = Color.alpha(pixel);
                            if (iRed != iRed2 || iGreen != iGreen2 || iBlue != iBlue2) {
                                i3++;
                            }
                            if (iRed2 == iRed && iGreen2 == iGreen && iBlue2 == iBlue && iAlpha2 == iAlpha) {
                                i4++;
                            }
                            if (i3 > j && i4 != i3) {
                                LG.d(TAG, "checkWebViewIsTransparent no report");
                                return false;
                            }
                            if (i4 >= j2) {
                                LG.d(TAG, "checkWebViewIsTransparent report");
                                return true;
                            }
                            r1++;
                            width = i5;
                            r7 = obj;
                            height = i6;
                            i2 = i7;
                        }
                        i2++;
                        r1 = 0;
                        r7 = r7;
                    }
                    return r1;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            LG.e(TAG, "checkWebViewIsTransparent->throwable ex>>>", th);
            return false;
        }
    }
}
