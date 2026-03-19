package com.pangrowth.adclog;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.ad.android.alog.Alog;
import com.pangrowth.adclog.t;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f {
    public static int a = 3;
    public static g b;
    public static HandlerThread f;
    public static Handler g;
    public static volatile List<h> c = new ArrayList();
    public static Alog d = null;
    public static ArrayList<WeakReference<Alog>> e = new ArrayList<>();
    public static long h = -1;
    public static boolean i = false;
    public static Object j = new Object();

    public static class a {
        public static final Object j = new Object();
        public static a k;
        public static int l;
        public int a;
        public String b;
        public String c;
        public Throwable d;
        public t.a e = null;
        public Object f;
        public long g;
        public long h;
        public a i;
    }

    public static void a(int i2, String str, String str2) {
        a(i2, str, str2, null, null, null);
    }

    public static void a(String str, String str2) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File file = new File(str);
        if (file.exists() && (fileArrListFiles2 = file.listFiles(new d())) != null) {
            for (File file2 : fileArrListFiles2) {
                file2.delete();
            }
        }
        File file3 = new File(str2);
        if (!file3.exists() || (fileArrListFiles = file3.listFiles(new e())) == null) {
            return;
        }
        for (File file4 : fileArrListFiles) {
            file4.delete();
        }
    }

    public static boolean a(int i2, String str) {
        return i2 >= a;
    }

    public static void a(int i2, String str, String str2, Throwable th, t.a aVar, Object obj) {
        a aVar2;
        if (h == -1) {
            h = Process.myTid();
        }
        synchronized (a.j) {
            aVar2 = a.k;
            if (aVar2 != null) {
                a.k = aVar2.i;
                aVar2.i = null;
                a.l--;
            } else {
                aVar2 = new a();
            }
        }
        aVar2.a = i2;
        aVar2.b = str;
        aVar2.c = str2;
        aVar2.d = th;
        aVar2.e = null;
        aVar2.f = null;
        aVar2.g = h;
        aVar2.h = System.currentTimeMillis();
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = aVar2;
        g.sendMessage(messageObtain);
    }
}
