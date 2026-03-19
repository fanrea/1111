package lkxssdk.e;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class k {
    public static final String[] a = {"date_added", "date_modified", "_display_name", "_data", "bucket_display_name", "orientation"};
    public static final String[] b = {"date_added", "_display_name", "_data", "duration", "bucket_display_name"};
    public static k c;
    public Context d = lkxssdk.a.a.d().getApplicationContext();
    public Handler e = new Handler(Looper.getMainLooper());
    public c f;
    public d g;
    public boolean h;
    public boolean i;
    public List<lkxssdk.e.a> j;
    public List<lkxssdk.e.a> k;
    public List<lkxssdk.e.a> l;
    public boolean m;
    public boolean n;
    public boolean o;

    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z;
            super.run();
            k kVar = k.this;
            kVar.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            lkxssdk.e.a aVar = new lkxssdk.e.a();
            aVar.b = "全部";
            aVar.c = new ArrayList<>();
            arrayList.add(aVar);
            Cursor cursorQuery = kVar.d.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, k.a, null, null, "date_added DESC");
            if (cursorQuery != null) {
                lkxssdk.h0.c.c("getAlbum pic cursor.size==" + cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    if (!TextUtils.isEmpty(string)) {
                        String lowerCase = string.toLowerCase(Locale.getDefault());
                        if (lowerCase.endsWith("jpg") || lowerCase.endsWith("jpeg") || lowerCase.endsWith("png") || lowerCase.endsWith("webp")) {
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                            if (!TextUtils.isEmpty(string2) && !string2.contains(bi.j)) {
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                                if (TextUtils.isEmpty(string3)) {
                                    string3 = "sdcard";
                                }
                                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("orientation"));
                                long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("date_added"));
                                long j2 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("date_modified"));
                                e eVar = new e();
                                eVar.b = string2;
                                eVar.a = string3;
                                eVar.e = 1;
                                eVar.g = i;
                                eVar.c = j;
                                eVar.d = j2;
                                aVar.c.add(eVar);
                                Iterator it = arrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    lkxssdk.e.a aVar2 = (lkxssdk.e.a) it.next();
                                    if (aVar2.b.equalsIgnoreCase(eVar.a)) {
                                        aVar2.c.add(eVar);
                                        z = true;
                                        break;
                                    }
                                }
                                if (!z) {
                                    lkxssdk.e.a aVar3 = new lkxssdk.e.a();
                                    aVar3.b = eVar.a;
                                    ArrayList<e> arrayList2 = new ArrayList<>();
                                    aVar3.c = arrayList2;
                                    arrayList2.add(eVar);
                                    arrayList.add(aVar3);
                                }
                            }
                        }
                    }
                }
                cursorQuery.close();
            }
            lkxssdk.h0.c.b("get piclist take time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            kVar.j = arrayList;
            lkxssdk.i0.b.a().a(20, 1, 0, null);
            kVar.h = false;
        }
    }

    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            boolean z;
            super.run();
            k kVar = k.this;
            kVar.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            lkxssdk.e.a aVar = new lkxssdk.e.a();
            aVar.b = "全部";
            aVar.c = new ArrayList<>();
            arrayList.add(aVar);
            Cursor cursorQuery = kVar.d.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, k.b, null, null, "date_added DESC");
            if (cursorQuery != null) {
                lkxssdk.h0.c.c("getVideos video cursor.size==" + cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    if (!TextUtils.isEmpty(string) && !string.contains(bi.j)) {
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("bucket_display_name"));
                        if (TextUtils.isEmpty(string2)) {
                            string2 = "sdcard";
                        }
                        long j = cursorQuery.getInt(cursorQuery.getColumnIndex("duration"));
                        e eVar = new e();
                        eVar.a = string2;
                        eVar.b = string;
                        eVar.f = j;
                        eVar.e = 2;
                        aVar.c.add(eVar);
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            lkxssdk.e.a aVar2 = (lkxssdk.e.a) it.next();
                            if (aVar2.b.equalsIgnoreCase(eVar.a)) {
                                aVar2.c.add(eVar);
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            lkxssdk.e.a aVar3 = new lkxssdk.e.a();
                            aVar3.b = eVar.a;
                            ArrayList<e> arrayList2 = new ArrayList<>();
                            aVar3.c = arrayList2;
                            arrayList2.add(eVar);
                            arrayList.add(aVar3);
                        }
                    }
                }
                cursorQuery.close();
            }
            lkxssdk.h0.c.b("take time:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            kVar.k = arrayList;
            lkxssdk.i0.b.a().a(20, 2, 0, null);
            kVar.i = false;
        }
    }

    public class c extends ContentObserver {

        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                k.this.m = false;
                k.this.a(true);
            }
        }

        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            lkxssdk.h0.c.c("tag", "Pic-------onChange-------- selfChange：" + (z ? "true" : "false"));
            k kVar = k.this;
            if (kVar.m) {
                return;
            }
            kVar.m = true;
            new Timer().schedule(new a(), com.alipay.sdk.m.u.b.a);
        }
    }

    public class d extends ContentObserver {

        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                k.this.n = false;
                k.this.b(true);
            }
        }

        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            lkxssdk.h0.c.c("tag", "video-------onChange-------- selfChange：" + (z ? "true" : "false"));
            k kVar = k.this;
            if (kVar.n) {
                return;
            }
            kVar.n = true;
            new Timer().schedule(new a(), com.alipay.sdk.m.u.b.a);
        }
    }

    public k() {
        if (lkxssdk.j0.d.b(this.d)) {
            this.o = true;
            this.f = new c(this.e);
            this.g = new d(this.e);
            this.d.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f);
            this.d.getContentResolver().registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, false, this.g);
        }
    }

    public static k a() {
        if (c == null) {
            synchronized (k.class) {
                if (c == null) {
                    c = new k();
                }
            }
        }
        return c;
    }

    public final void a(boolean z) {
        if (this.h) {
            return;
        }
        this.h = true;
        if (z) {
            lkxssdk.i0.b.a().a(201, 1, 0, null);
        }
        new a().start();
    }

    public List<lkxssdk.e.a> b() {
        List<lkxssdk.e.a> list = this.j;
        if (list != null) {
            return list;
        }
        a(false);
        return null;
    }

    public final void b(boolean z) {
        if (this.i) {
            return;
        }
        this.i = true;
        if (z) {
            lkxssdk.i0.b.a().a(201, 2, 0, null);
        }
        new b().start();
    }

    public List<lkxssdk.e.a> c() {
        List<lkxssdk.e.a> list = this.k;
        if (list != null) {
            return list;
        }
        b(false);
        return null;
    }
}
