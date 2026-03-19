package com.alliance.ssp.ad.r;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: DownLoadTaskNew.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e extends Thread {
    public g a;
    public SQLiteDatabase b;
    public com.alliance.ssp.ad.r.a c;
    public j e;
    public String f;
    public int d = 0;
    public Looper g = Looper.getMainLooper();
    public Handler h = new Handler(this.g);
    public Handler i = new c(this.g);

    /* compiled from: DownLoadTaskNew.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(p.d);
            e eVar = e.this;
            eVar.a.d = eVar.d;
            Message message = new Message();
            message.what = 291;
            e eVar2 = e.this;
            g gVar = eVar2.a;
            message.arg1 = gVar.c;
            message.arg2 = gVar.d;
            eVar2.i.sendMessage(message);
        }
    }

    /* compiled from: DownLoadTaskNew.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setUncaughtExceptionHandler(p.d);
            e.this.a.getClass();
            e eVar = e.this;
            eVar.c.a(eVar.b, eVar.a);
        }
    }

    /* compiled from: DownLoadTaskNew.java */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar;
            int i = message.what;
            if (i != 291) {
                if (i == 292 && (jVar = e.this.e) != null) {
                    jVar.a(f.i.e);
                    return;
                }
                return;
            }
            j jVar2 = e.this.e;
            if (jVar2 != null) {
                jVar2.a(message.arg1, message.arg2, f.i.e);
            }
        }
    }

    public e(g gVar, com.alliance.ssp.ad.r.a aVar, j jVar, String str, com.alliance.ssp.ad.t.a aVar2) {
        this.f = "";
        this.f = str;
        this.a = gVar;
        this.c = aVar;
        this.b = aVar.getWritableDatabase();
        this.e = jVar;
        gVar.getClass();
    }

    public static long a(File file) throws IOException {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        file.createNewFile();
        int i = l.a;
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x008b, code lost:
    
        if (r11 == null) goto L45;
     */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x02e6: MOVE (r9 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:146:0x02e5 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x028d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d6 A[Catch: all -> 0x0277, Exception -> 0x0279, TryCatch #15 {Exception -> 0x0279, all -> 0x0277, blocks: (B:47:0x00a7, B:49:0x00d6, B:53:0x00e5, B:52:0x00e0), top: B:172:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011f A[Catch: all -> 0x0270, Exception -> 0x0274, TryCatch #18 {Exception -> 0x0274, all -> 0x0270, blocks: (B:55:0x010e, B:58:0x0119, B:60:0x0124, B:63:0x0130, B:75:0x0196, B:76:0x019c, B:78:0x01a3, B:80:0x01d4, B:81:0x01db, B:67:0x0141, B:69:0x014c, B:71:0x0155, B:73:0x015f, B:82:0x01ea, B:91:0x0213, B:92:0x0215, B:94:0x021c, B:96:0x0235, B:97:0x023c, B:86:0x01f7, B:88:0x0202, B:90:0x020b, B:59:0x011f), top: B:167:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0130 A[Catch: all -> 0x0270, Exception -> 0x0274, TRY_ENTER, TryCatch #18 {Exception -> 0x0274, all -> 0x0270, blocks: (B:55:0x010e, B:58:0x0119, B:60:0x0124, B:63:0x0130, B:75:0x0196, B:76:0x019c, B:78:0x01a3, B:80:0x01d4, B:81:0x01db, B:67:0x0141, B:69:0x014c, B:71:0x0155, B:73:0x015f, B:82:0x01ea, B:91:0x0213, B:92:0x0215, B:94:0x021c, B:96:0x0235, B:97:0x023c, B:86:0x01f7, B:88:0x0202, B:90:0x020b, B:59:0x011f), top: B:167:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ea A[Catch: all -> 0x0270, Exception -> 0x0274, TryCatch #18 {Exception -> 0x0274, all -> 0x0270, blocks: (B:55:0x010e, B:58:0x0119, B:60:0x0124, B:63:0x0130, B:75:0x0196, B:76:0x019c, B:78:0x01a3, B:80:0x01d4, B:81:0x01db, B:67:0x0141, B:69:0x014c, B:71:0x0155, B:73:0x015f, B:82:0x01ea, B:91:0x0213, B:92:0x0215, B:94:0x021c, B:96:0x0235, B:97:0x023c, B:86:0x01f7, B:88:0x0202, B:90:0x020b, B:59:0x011f), top: B:167:0x010e }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 755
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.r.e.run():void");
    }
}
