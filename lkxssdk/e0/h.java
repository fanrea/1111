package lkxssdk.e0;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.just.agentweb.AgentWebPermissions;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class h implements Runnable {
    public final f a;
    public final Handler b;
    public final d c;
    public final String d;
    public final String e;
    public final lkxssdk.d0.a f;
    public final lkxssdk.g0.a g;
    public ReentrantLock h;
    public int i;
    public int j;
    public boolean k;

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.g.a(hVar.d, hVar.f.b(), this.a);
        }
    }

    public class b extends Exception {
        public b(h hVar) {
        }
    }

    public h(f fVar, Handler handler, String str, lkxssdk.d0.a aVar, String str2, lkxssdk.g0.a aVar2, ReentrantLock reentrantLock) {
        this.a = fVar;
        this.b = handler;
        this.c = fVar.a;
        this.d = str;
        this.e = str2;
        this.f = aVar;
        this.g = aVar2;
        this.h = reentrantLock;
    }

    public final void a() throws b {
        if (this.f.a()) {
            throw new b(this);
        }
        if (c()) {
            throw new b(this);
        }
    }

    public final void b(String str) {
        if (Thread.interrupted() || b()) {
            return;
        }
        a aVar = new a(str);
        Handler handler = this.b;
        f fVar = this.a;
        if (handler == null) {
            fVar.d.execute(aVar);
        } else {
            handler.post(aVar);
        }
    }

    public final boolean c() {
        return !this.e.equals(this.a.e.get(this.f.getId() + ""));
    }

    public final Bitmap d() throws Throwable {
        File file;
        lkxssdk.e0.b bVar = this.c.g;
        String str = this.d;
        bVar.getClass();
        Bitmap bitmapA = null;
        if (TextUtils.isEmpty(str)) {
            file = null;
        } else {
            file = new File(bVar.a, lkxssdk.a0.c.a(str));
        }
        if (file != null && file.exists() && file.length() > 0) {
            a();
            lkxssdk.e0.b bVar2 = this.c.g;
            String str2 = this.d;
            bVar2.getClass();
            if (!TextUtils.isEmpty(str2)) {
                File file2 = new File(bVar2.a, lkxssdk.a0.c.a(str2));
                if (file2.exists()) {
                    bitmapA = BitmapFactory.decodeFile(file2.getAbsolutePath());
                }
            }
        }
        if (bitmapA == null) {
            try {
                bitmapA = a(this.d);
                if (bitmapA != null) {
                    this.c.g.a(this.d, bitmapA, false);
                    this.c.f.a(this.e, bitmapA);
                } else {
                    lkxssdk.h0.c.a("LK_LoadImageTask", "download image from server [" + this.d + "] fail");
                    b("download pic fail");
                }
            } catch (Exception e) {
                e.printStackTrace();
                b("download pic fail");
            }
        } else {
            lkxssdk.h0.c.a("LK_LoadImageTask", "get image from disk success [" + this.d + "]");
        }
        return bitmapA;
    }

    public final Bitmap e() throws IOException {
        Bitmap frameAtTime;
        Bitmap bitmapA = null;
        try {
            if (this.k) {
                String str = this.d;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    } catch (Exception e) {
                        e.printStackTrace();
                        frameAtTime = null;
                    }
                    if (frameAtTime != null) {
                        int i = this.i;
                        if (i > 0) {
                            bitmapA = lkxssdk.a.a.a(frameAtTime, i, i, k.CROP);
                            frameAtTime.recycle();
                        } else {
                            bitmapA = frameAtTime;
                        }
                    }
                } finally {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused) {
                    }
                }
            } else {
                bitmapA = a(this.d, this.i, this.j);
            }
            if (bitmapA != null) {
                int i2 = this.j;
                if (i2 > 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(i2);
                    bitmapA = Bitmap.createBitmap(bitmapA, 0, 0, bitmapA.getWidth(), bitmapA.getHeight(), matrix, true);
                }
                this.c.f.a(this.e, bitmapA);
            } else {
                lkxssdk.h0.c.a("LK_LoadImageTask", "download image from SDCard [" + this.d + "] fail");
                b("download pic fail");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            b("download pic fail");
        }
        return bitmapA;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zB;
        AtomicBoolean atomicBoolean = this.a.g;
        if (atomicBoolean.get()) {
            synchronized (this.a.h) {
                if (atomicBoolean.get()) {
                    lkxssdk.h0.c.a("LK_LoadImageTask", "ImageLoader is paused. Waiting..." + this.e);
                    try {
                        this.a.h.wait();
                        lkxssdk.h0.c.a("LK_LoadImageTask", "Resume loading..." + this.e);
                    } catch (InterruptedException unused) {
                        zB = true;
                    }
                }
            }
            zB = b();
        } else {
            zB = b();
        }
        if (zB) {
            lkxssdk.h0.c.a("LK_LoadImageTask", "waitIfPaused()");
            return;
        }
        if (this.h.isLocked()) {
            lkxssdk.h0.c.a("LK_LoadImageTask", "Image already is loading. Waiting... [" + this.d + "]");
        }
        this.h.lock();
        try {
            a();
            Bitmap bitmapA = this.c.f.a(this.e);
            if (bitmapA == null || bitmapA.isRecycled()) {
                if (this.d.startsWith(com.alipay.sdk.m.l.a.r) || this.d.startsWith("//")) {
                    lkxssdk.h0.c.a("LK_LoadImageTask", "uri network pic uri:" + this.d);
                    bitmapA = d();
                } else {
                    lkxssdk.h0.c.a("LK_LoadImageTask", "uri native pic uri:" + this.d);
                    bitmapA = e();
                }
                if (bitmapA == null) {
                    return;
                }
            }
            a();
            if (Thread.interrupted()) {
                throw new b(this);
            }
            this.h.unlock();
            g gVar = new g(this, bitmapA);
            Handler handler = this.b;
            f fVar = this.a;
            if (handler == null) {
                fVar.d.execute(gVar);
            } else {
                handler.post(gVar);
            }
        } catch (b unused2) {
        } finally {
            this.h.unlock();
        }
    }

    public final boolean b() {
        return this.f.a() || c();
    }

    public final Bitmap a(String str) throws Throwable {
        InputStream inputStream;
        int responseCode;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection = null;
        Bitmap bitmapDecodeStream = null;
        InputStream inputStream3 = null;
        try {
            lkxssdk.c0.c cVar = new lkxssdk.c0.c(lkxssdk.a0.b.a(this.c.h, str));
            cVar.b = 5000;
            HttpURLConnection httpURLConnectionA = lkxssdk.a.a.a(cVar);
            while (true) {
                try {
                    responseCode = httpURLConnectionA.getResponseCode();
                    if (responseCode / 100 != 3) {
                        break;
                    }
                    cVar.a = lkxssdk.a0.b.a(this.c.h, httpURLConnectionA.getHeaderField(AgentWebPermissions.ACTION_LOCATION));
                    httpURLConnectionA = lkxssdk.a.a.a(cVar);
                } catch (Throwable th) {
                    th = th;
                    InputStream inputStream4 = inputStream3;
                    httpURLConnection = httpURLConnectionA;
                    inputStream = inputStream4;
                    lkxssdk.a.a.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (responseCode == 200) {
                inputStream3 = httpURLConnectionA.getInputStream();
                inputStream2 = inputStream3;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream3);
            } else {
                inputStream2 = null;
            }
            lkxssdk.a.a.a(inputStream2);
            httpURLConnectionA.disconnect();
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public final Bitmap a(String str, int i, int i2) {
        Uri uriFromFile;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            if (Build.VERSION.SDK_INT >= 24) {
                Application applicationD = lkxssdk.a.a.d();
                uriFromFile = FileProvider.getUriForFile(applicationD, applicationD.getPackageName() + ".lkxs.fileprovider", new File(str));
            } else {
                uriFromFile = Uri.fromFile(new File(str));
            }
            BitmapFactory.decodeStream(lkxssdk.a.a.d().getContentResolver().openInputStream(uriFromFile), null, options);
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            if (i2 > 0) {
                if (i5 > i && i > 0) {
                    options.inSampleSize = i5 / i;
                }
            } else if (i4 > i && i > 0) {
                while (i4 > i) {
                    i4 >>= 1;
                    i3 <<= 1;
                }
                options.inSampleSize = i3;
            }
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            ContentResolver contentResolver = lkxssdk.a.a.d().getContentResolver();
            Application applicationD2 = lkxssdk.a.a.d();
            return BitmapFactory.decodeStream(contentResolver.openInputStream(FileProvider.getUriForFile(applicationD2, applicationD2.getPackageName() + ".lkxs.fileprovider", new File(str))));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
