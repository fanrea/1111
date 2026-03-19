package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mm {
    private static volatile mm b;
    private final ExecutorService a = Executors.newFixedThreadPool(5, new a());

    /* compiled from: A */
    class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_IMAGE_LOADER_THREAD");
        }

        a() {
        }
    }

    private mm() {
    }

    public void a(File file, ImageView imageView, nm nmVar) throws JSONException {
        if (file != null && file.exists()) {
            a(new pm(file, imageView, nmVar, false, null), "", nmVar);
        } else if (nmVar != null) {
            nmVar.a("", 32768, new Exception());
        }
    }

    public void a(String str, ImageView imageView) throws JSONException {
        a(str, imageView, null, false, false, null, null);
    }

    public void b(String str, nm nmVar) throws JSONException {
        a(str, null, nmVar, true, true, null, null);
    }

    private String b() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            int size = allStackTraces.size();
            HashMap map = new HashMap();
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            while (it.hasNext()) {
                Thread key = it.next().getKey();
                if (key != null) {
                    String name = key.getName();
                    Object obj = map.get(name);
                    if (obj != null) {
                        map.put(name, Integer.valueOf(((Integer) obj).intValue() + 1));
                    } else {
                        map.put(name, 1);
                    }
                }
            }
            if (map.size() <= 0) {
                return "none";
            }
            String str = "";
            int iIntValue = 0;
            for (Map.Entry entry : map.entrySet()) {
                if (((Integer) entry.getValue()).intValue() > iIntValue) {
                    iIntValue = ((Integer) entry.getValue()).intValue();
                    str = (String) entry.getKey();
                }
            }
            return str + "," + iIntValue + "," + size;
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public void a(String str, ImageView imageView, nm nmVar) throws JSONException {
        a(str, imageView, nmVar, false, false, null, null);
    }

    public void a(String str, ImageView imageView, nm nmVar, Bitmap bitmap) throws JSONException {
        a(str, imageView, nmVar, false, false, bitmap, null);
    }

    private void a(String str, ImageView imageView, nm nmVar, boolean z, boolean z2, Bitmap bitmap, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            a(new pm(str, imageView, new om(nmVar), z, z2, bitmap, str2), str, nmVar);
        } else if (nmVar != null) {
            nmVar.a(str, 4, new Exception("UrlIsEmpty"));
        }
    }

    public void a(String str, nm nmVar) {
        a(str, nmVar, (String) null);
    }

    public void a(String str, nm nmVar, String str2) {
        a(str, null, nmVar, true, false, null, str2);
    }

    public void a(String str, nm nmVar, boolean z) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            if (nmVar != null) {
                nmVar.a(str, 4, new Exception("UrlIsEmpty"));
            }
        } else {
            pm pmVar = new pm(str, null, new om(nmVar), true, false, null, null);
            pmVar.a(z);
            a(pmVar, str, nmVar);
        }
    }

    private void a(pm pmVar, String str, nm nmVar) throws JSONException {
        try {
            this.a.submit(pmVar);
        } catch (OutOfMemoryError e) {
            if (nmVar != null) {
                nmVar.a(str, 8388608, new Exception(e));
            }
            ja jaVar = new ja();
            jaVar.a("msg", b());
            b10.a(9200008, null, 0, 0, jaVar);
        }
    }

    public static mm a() {
        if (b == null) {
            synchronized (mm.class) {
                if (b == null) {
                    b = new mm();
                }
            }
        }
        return b;
    }
}
