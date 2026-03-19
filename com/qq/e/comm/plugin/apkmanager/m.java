package com.qq.e.comm.plugin.apkmanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.plugin.apkmanager.q;
import com.qq.e.comm.plugin.apkmanager.r;
import com.qq.e.comm.plugin.b10;
import com.qq.e.comm.plugin.e3;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.h10;
import com.qq.e.comm.plugin.j3;
import com.qq.e.comm.plugin.ja;
import com.qq.e.comm.plugin.jz;
import com.qq.e.comm.plugin.qg;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.ra;
import com.qq.e.comm.plugin.t3;
import com.qq.e.comm.plugin.wm;
import com.qq.e.comm.plugin.wx;
import com.qq.e.comm.plugin.xo;
import com.qq.e.comm.plugin.zr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class m implements SVSD, q.a {
    private static final ArrayList<String> i = new ArrayList<>();
    private static final HashMap<String, ReentrantLock> j = new HashMap<>();
    private static long k = (r1.d().f().a("rdet", 24) * 3600) * 1000;
    private final Service a;
    private q b;
    private final Context c;
    private boolean e;
    private final k f;
    private boolean h;
    private final ConcurrentHashMap<String, Intent> d = new ConcurrentHashMap<>();
    private long g = System.currentTimeMillis();

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            m.this.f();
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.h();
        }
    }

    /* compiled from: A */
    class c implements ra.b {
        final /* synthetic */ ApkDownloadTask a;

        c(ApkDownloadTask apkDownloadTask) {
            this.a = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.ra.b
        public void a() throws JSONException {
            m.this.a(this.a);
            b10.a(1130033, (f5) null);
        }

        @Override // com.qq.e.comm.plugin.ra.b
        public void b() {
            m.this.f.a(this.a, false);
            b10.a(1130034, (f5) null);
        }
    }

    /* compiled from: A */
    class d extends p {
        final /* synthetic */ ApkDownloadTask d;
        final /* synthetic */ Intent e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.qq.e.comm.plugin.apkmanager.a aVar, com.qq.e.comm.plugin.apkmanager.c cVar, ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2, Intent intent) {
            super(aVar, cVar, apkDownloadTask);
            this.d = apkDownloadTask2;
            this.e = intent;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.p
        public void a(int i, String str) {
            if (i == 11) {
                m.this.d.put(this.d.s(), this.e);
            }
            m.j.remove(this.d.r());
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            m.this.e();
        }
    }

    /* compiled from: A */
    private class f extends r.a {
        private f() {
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public int a(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return m.this.f.a(apkDownloadTask);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public int b(String str, int i) throws RemoteException {
            return m.this.f.b(str, i);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public int c(String str) throws RemoteException {
            return com.qq.e.comm.plugin.n.a().d(m.this.c, str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public int d(String str) throws RemoteException {
            return com.qq.e.comm.plugin.n.a().c(m.this.c, str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean e(String str) throws RemoteException {
            return m.this.f.b(str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public List<ApkDownloadTask> f() throws RemoteException {
            return m.this.f.b();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public List<ApkDownloadTask> g() throws RemoteException {
            return m.this.f.c();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public List<ApkDownloadTask> h() throws RemoteException {
            return m.this.f.a();
        }

        /* synthetic */ f(m mVar, a aVar) {
            this();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean a(String str, int i) throws RemoteException {
            return m.this.f.a(str, i);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean b(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return m.this.f.a(apkDownloadTask, 1);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public int c(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return m.this.f.c(apkDownloadTask);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean d(int i) throws RemoteException {
            return m.this.f.a(i, 1);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public ApkDownloadTask f(String str) throws RemoteException {
            return m.this.f.a(str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean g(int i) throws RemoteException {
            return m.this.f.b(i);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean a(ApkDownloadTask apkDownloadTask, boolean z) throws RemoteException {
            return m.this.f.a(apkDownloadTask, z);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean d(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return m.this.f.b(apkDownloadTask);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public ApkDownloadTask f(int i) throws RemoteException {
            return m.this.f.a(i);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.r
        public boolean a(int i, int i2, long j) throws RemoteException {
            return m.this.f.a(i, i2, j);
        }
    }

    public m(Service service) {
        this.a = service;
        Context applicationContext = service.getApplicationContext();
        this.c = applicationContext;
        this.f = new k(applicationContext);
    }

    private void g() throws JSONException {
        if (this.d.isEmpty()) {
            return;
        }
        try {
            for (Intent intent : this.d.values()) {
                i.a(intent, false);
                this.a.startService(intent);
            }
            this.d.clear();
        } catch (Throwable th) {
            String string = th.toString();
            ja jaVar = new ja();
            jaVar.a("msg", string);
            b10.b(100252, null, Integer.valueOf(this.d.size()), jaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.b == null) {
            this.b = new q(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.c.registerReceiver(this.b, intentFilter);
            } catch (Exception unused) {
                this.b = null;
            }
        }
    }

    private void i() {
        if (this.e) {
            return;
        }
        for (ApkDownloadTask apkDownloadTask : this.f.d()) {
            if (!i.contains(apkDownloadTask.r())) {
                this.f.a(apkDownloadTask.t(), 0);
            }
        }
        this.e = true;
    }

    private void j() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (e3.h()) {
            qg.f.schedule(new a(), r1.d().f().a("rddt", 60), TimeUnit.SECONDS);
        }
    }

    private void k() {
        q qVar = this.b;
        if (qVar != null) {
            this.c.unregisterReceiver(qVar);
            this.b = null;
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.q.a
    public void b() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public IBinder onBind(Intent intent) {
        return new f(this, null);
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onCreate() {
        j.b(this.c);
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onDestroy() {
        j.clear();
        k();
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onLowMemory() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onRebind(Intent intent) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent != null && !i.c(intent)) {
            if (i.f(intent)) {
                j();
                return 2;
            }
            if ("com.qq.e.comm.ACTION_DOWNLOAD_LIST".equals(intent.getAction())) {
                d();
                return 2;
            }
            if (i.g(intent)) {
                i();
                return 2;
            }
            boolean zD = i.d(intent);
            ApkDownloadTask apkDownloadTaskA = ApkDownloadTask.a(i.b(intent));
            if (zD) {
                t3.a(1100913, apkDownloadTaskA);
            }
            if (apkDownloadTaskA == null) {
                if (zD) {
                    t3.a(1100914, (Integer) 3, apkDownloadTaskA);
                }
                return 2;
            }
            String strF = r1.d().b().f();
            String strA = i.a(intent);
            if (!TextUtils.isEmpty(strF) && !TextUtils.isEmpty(strA) && !strF.equals(strA)) {
                t3.a(2, strF + "#" + strA);
            }
            if (h10.e(com.qq.e.comm.plugin.n.a().d(this.c, apkDownloadTaskA.r()))) {
                t3.a(1100914, (Integer) 4, apkDownloadTaskA);
                return 2;
            }
            h();
            if (i.e(intent) && !this.d.isEmpty()) {
                this.d.remove(apkDownloadTaskA.s());
            }
            a(apkDownloadTaskA, intent);
        }
        return 2;
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onTaskRemoved(Intent intent) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onTrimMemory(int i2) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public boolean onUnbind(Intent intent) {
        return true;
    }

    private void d() {
        Intent intent = new Intent();
        intent.setClassName(this.c, wx.a());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.DOWNLOAD_MANAGE);
        intent.putExtra("appid", r1.d().b().a());
        intent.addFlags(268435456);
        this.c.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws JSONException {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws JSONException {
        List<ApkDownloadTask> listC = this.f.c();
        if (listC == null || listC.isEmpty()) {
            return;
        }
        if (r1.d().c().p() != zr.WIFI) {
            xo.a((Runnable) new b());
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - k;
        ApkDownloadTask apkDownloadTask = null;
        for (ApkDownloadTask apkDownloadTask2 : listC) {
            if (apkDownloadTask2 != null && apkDownloadTask2.e() < this.g && apkDownloadTask2.e() > jCurrentTimeMillis && !i.contains(apkDownloadTask2.r()) && (apkDownloadTask == null || apkDownloadTask.e() < apkDownloadTask2.e())) {
                apkDownloadTask = apkDownloadTask2;
            }
        }
        if (apkDownloadTask == null) {
            return;
        }
        apkDownloadTask.a(1);
        if (e3.i()) {
            b(apkDownloadTask);
        } else {
            a(apkDownloadTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkDownloadTask apkDownloadTask) throws JSONException {
        if (apkDownloadTask.o() != 0) {
            j3.b(4001005, apkDownloadTask, 3, 202);
        }
        a(apkDownloadTask, i.a(this.c, apkDownloadTask));
    }

    private void b(ApkDownloadTask apkDownloadTask) {
        long jC = apkDownloadTask.c("totalSize");
        ra.a(String.format("您已下载的“%s”未下载完成%s，要继续下载吗", apkDownloadTask.p(), jC > 0 ? String.format("（文件大小%s）", jz.c(jC)) : ""), "确认", "取消", new c(apkDownloadTask));
        b10.a(1130032, (f5) null);
    }

    private void a(ApkDownloadTask apkDownloadTask, Intent intent) {
        ReentrantLock reentrantLockA = a(apkDownloadTask.r());
        if (reentrantLockA != null && reentrantLockA.isLocked()) {
            t3.a(1100914, (Integer) 5, apkDownloadTask);
        } else {
            i.add(apkDownloadTask.r());
            new d(new n(this.c, apkDownloadTask, intent, reentrantLockA), new o(this.c, apkDownloadTask), apkDownloadTask, apkDownloadTask, intent).b();
        }
    }

    private ReentrantLock a(String str) {
        HashMap<String, ReentrantLock> map = j;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        map.put(str, reentrantLock);
        return reentrantLock;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.q.a
    public void a() {
        qg.b.submit(new e());
        j();
    }
}
