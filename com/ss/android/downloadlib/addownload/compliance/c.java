package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.b;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.socialbase.downloader.tt.tt;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c extends com.ss.android.socialbase.downloader.e.gb<Long, Bitmap> {
    private final Map<Long, SoftReference<d>> d;

    public interface d {
        void d(Bitmap bitmap);
    }

    private static class hc {
        private static c d = new c();
    }

    public static c d() {
        return hc.d;
    }

    private c() {
        super(8, 8);
        this.d = new HashMap();
    }

    public void d(long j, d dVar) {
        if (get(Long.valueOf(j)) != null) {
            dVar.d((Bitmap) get(Long.valueOf(j)));
        } else {
            this.d.put(Long.valueOf(j), new SoftReference<>(dVar));
        }
    }

    public void d(final long j, final long j2, final String str) throws JSONException {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<d> softReferenceRemove = this.d.remove(Long.valueOf(j));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().d((Bitmap) get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            h.d(12, j2);
        } else {
            com.ss.android.downloadlib.h.b.d((b.d<Object, R>) new b.d<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.c.2
                @Override // com.ss.android.downloadlib.h.b.d
                public Object d(Object obj) throws Throwable {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    tt ttVarD;
                    try {
                        ttVarD = com.ss.android.socialbase.downloader.downloader.b.d(true, 0, str, null);
                    } catch (Exception e) {
                        e = e;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        com.ss.android.socialbase.downloader.e.an.d(bufferedInputStream);
                        throw th;
                    }
                    if (ttVarD != null) {
                        bufferedInputStream = new BufferedInputStream(ttVarD.d());
                        try {
                            try {
                                bufferedInputStream.mark(bufferedInputStream.available());
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                int i = options.outWidth;
                                int i2 = options.outHeight;
                                int iD = uo.d(mq.getContext(), 60.0f);
                                options.inSampleSize = c.hc(iD, iD, options);
                                options.inJustDecodeBounds = false;
                                bufferedInputStream.reset();
                                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                    jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                    jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                    jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                                } catch (Exception e2) {
                                    com.bytedance.sdk.component.utils.mq.d(e2);
                                }
                                com.ss.android.downloadlib.c.d.d().d("ttd_pref_monitor", jSONObject, j2);
                                c.this.put(Long.valueOf(j), bitmapDecodeStream);
                                com.ss.android.socialbase.downloader.e.an.d(bufferedInputStream);
                            } catch (Throwable th3) {
                                th = th3;
                                com.ss.android.socialbase.downloader.e.an.d(bufferedInputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            com.ss.android.downloadlib.u.b.d().d(e, "BitmapCache loadBitmap");
                            com.ss.android.socialbase.downloader.e.an.d(bufferedInputStream);
                            return null;
                        }
                        return null;
                    }
                    com.ss.android.socialbase.downloader.e.an.d(null);
                    return null;
                }
            }, (Object) null).d(new b.d<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.c.1
                @Override // com.ss.android.downloadlib.h.b.d
                public Object d(Object obj) {
                    SoftReference softReference = (SoftReference) c.this.d.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((d) softReference.get()).d((Bitmap) c.this.get(Long.valueOf(j)));
                    return null;
                }
            }).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hc(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
