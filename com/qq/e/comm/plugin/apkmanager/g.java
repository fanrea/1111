package com.qq.e.comm.plugin.apkmanager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.qq.e.comm.plugin.as;
import com.qq.e.comm.plugin.gp;
import com.qq.e.comm.plugin.gu;
import com.qq.e.comm.plugin.r30;
import com.qq.e.comm.plugin.wr;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class g implements Callable<Bitmap> {
    private String a;
    private int b;
    private int c;

    public g(String str) {
        this(str, 0, 0);
    }

    private Bitmap a(Bitmap bitmap) {
        int i;
        int i2 = this.b;
        return (i2 <= 0 || (i = this.c) <= 0) ? bitmap : Bitmap.createScaledBitmap(bitmap, i2, i, true);
    }

    private Bitmap c() throws Throwable {
        File fileG = gu.g();
        HttpURLConnection httpURLConnectionA = null;
        if (fileG == null) {
            return null;
        }
        fileG.mkdirs();
        File file = new File(fileG, gp.a(this.a));
        if (!file.exists()) {
            try {
                httpURLConnectionA = as.a(a());
                if (httpURLConnectionA.getResponseCode() == 200) {
                    gu.a(httpURLConnectionA.getInputStream(), file);
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    if (httpURLConnectionA != null) {
                        httpURLConnectionA.disconnect();
                    }
                }
            }
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile == null) {
            gp.a(file);
        }
        return a(bitmapDecodeFile);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap call() throws Exception {
        if (TextUtils.isEmpty(this.a)) {
            return null;
        }
        return c();
    }

    public g(String str, int i, int i2) {
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    private HttpURLConnection a() throws IOException {
        this.a = wr.a(this.a, 3);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
        httpURLConnection.setRequestProperty(r30.b(), r30.a());
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        return httpURLConnection;
    }
}
