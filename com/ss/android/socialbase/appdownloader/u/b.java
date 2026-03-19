package com.ss.android.socialbase.appdownloader.u;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.tt.tt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static int d = 8;
    private static volatile b hc;
    private d<Integer, Bitmap> b;

    private static class d<K, T> extends LinkedHashMap<K, T> {
        final int d;

        public d(int i, int i2) {
            super(i2, 0.75f, true);
            this.d = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.d;
        }
    }

    public static b d() {
        if (hc == null) {
            synchronized (b.class) {
                if (hc == null) {
                    hc = new b();
                }
            }
        }
        return hc;
    }

    private b() {
        this.b = null;
        int i = d;
        this.b = new d<>(i, i / 2);
    }

    public Bitmap d(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public void d(final int i, final String str) {
        if (TextUtils.isEmpty(str) || d(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.mq().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.u.b.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamHc;
                ByteArrayInputStream byteArrayInputStream;
                Closeable closeable;
                Throwable th;
                InputStream inputStreamD;
                ByteArrayInputStream byteArrayInputStream2;
                Exception e;
                try {
                    try {
                        tt ttVarD = com.ss.android.socialbase.downloader.downloader.b.d(true, 0, str, null);
                        if (ttVarD != null) {
                            inputStreamD = ttVarD.d();
                            try {
                                byteArrayOutputStreamHc = b.hc(inputStreamD);
                                try {
                                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamHc.toByteArray());
                                } catch (Exception e2) {
                                    byteArrayInputStream2 = null;
                                    e = e2;
                                    byteArrayInputStream = null;
                                } catch (Throwable th2) {
                                    closeable = null;
                                    th = th2;
                                    byteArrayInputStream = null;
                                }
                            } catch (Exception e3) {
                                byteArrayInputStream = null;
                                byteArrayInputStream2 = null;
                                e = e3;
                                byteArrayOutputStreamHc = null;
                            } catch (Throwable th3) {
                                byteArrayInputStream = null;
                                closeable = null;
                                th = th3;
                                byteArrayOutputStreamHc = null;
                            }
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamHc.toByteArray());
                            } catch (Exception e4) {
                                byteArrayInputStream2 = null;
                                e = e4;
                            } catch (Throwable th4) {
                                closeable = null;
                                th = th4;
                                an.d(inputStreamD, byteArrayOutputStreamHc, byteArrayInputStream, closeable);
                                throw th;
                            }
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                int i2 = options.outWidth;
                                int i3 = options.outHeight;
                                int iD = com.ss.android.socialbase.appdownloader.b.d(com.ss.android.socialbase.downloader.downloader.b.tr(), 44.0f);
                                options.inSampleSize = b.d(iD, iD, options);
                                options.inJustDecodeBounds = false;
                                b.this.b.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                an.d(inputStreamD, byteArrayOutputStreamHc, byteArrayInputStream, byteArrayInputStream2);
                                return;
                            } catch (Exception e5) {
                                e = e5;
                                mq.d(e);
                                an.d(inputStreamD, byteArrayOutputStreamHc, byteArrayInputStream, byteArrayInputStream2);
                                return;
                            }
                        }
                        an.d(null, null, null, null);
                    } catch (Exception e6) {
                        byteArrayOutputStreamHc = null;
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e = e6;
                        inputStreamD = null;
                    } catch (Throwable th5) {
                        byteArrayOutputStreamHc = null;
                        byteArrayInputStream = null;
                        closeable = null;
                        th = th5;
                        inputStreamD = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        });
    }

    public static int d(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream hc(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i >= 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }
}
