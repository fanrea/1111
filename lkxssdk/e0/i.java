package lkxssdk.e0;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class i {
    public static LruCache<String, Bitmap> a;
    public static LinkedHashMap<String, SoftReference<Bitmap>> b;

    public class a extends LruCache<String, Bitmap> {
        public a(i iVar, int i) {
            super(i);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            String str2 = str;
            Bitmap bitmap3 = bitmap;
            if (bitmap3 != null) {
                i.b.put(str2, new SoftReference<>(bitmap3));
            }
        }

        @Override // android.util.LruCache
        public int sizeOf(String str, Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            return bitmap2 != null ? Build.VERSION.SDK_INT >= 19 ? bitmap2.getAllocationByteCount() : bitmap2.getRowBytes() * bitmap2.getHeight() : super.sizeOf(str, bitmap2);
        }
    }

    public class b extends LinkedHashMap<String, SoftReference<Bitmap>> {
        public b(i iVar, int i, float f, boolean z) {
            super(i, f, z);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, SoftReference<Bitmap>> entry) {
            return size() > 20;
        }
    }

    public i() {
        a = new a(this, 1048576);
        b = new b(this, 20, 0.75f, true);
    }

    public Bitmap a(String str) {
        synchronized (a) {
            Bitmap bitmap = a.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            synchronized (b) {
                SoftReference<Bitmap> softReference = b.get(str);
                if (softReference != null) {
                    Bitmap bitmap2 = softReference.get();
                    if (bitmap2 != null) {
                        a.put(str, bitmap2);
                        b.remove(str);
                        return bitmap2;
                    }
                    b.remove(str);
                }
                return null;
            }
        }
    }

    public void a(String str, Bitmap bitmap) {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (a) {
            a.put(str, bitmap);
        }
    }
}
