package com.qq.e.comm.plugin;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import com.qq.e.comm.plugin.a30;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class q50 {
    private static final String l = "q50";
    private static volatile q50 m;
    private File a = d();
    private File b = gu.l();
    private volatile Set<String> c;
    private volatile Set<String> d;
    private volatile Set<String> e;
    private volatile Set<String> f;
    private volatile Boolean g;
    private volatile Boolean h;
    private volatile Boolean i;
    private volatile Boolean j;
    private volatile Set<String> k;

    /* compiled from: A */
    public interface d {
        void a(File file);

        void a(Exception exc, int i);
    }

    public static q50 e() {
        if (m == null) {
            synchronized (q50.class) {
                if (m == null) {
                    m = new q50();
                }
            }
        }
        return m;
    }

    public boolean b() {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    this.g = Boolean.valueOf(r1.d().f().a("web_proxy", 0) == 1);
                }
            }
        }
        return this.g.booleanValue();
    }

    public Set<String> g() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    String strC = r1.d().f().c("web_proxy_img_suffix");
                    if (TextUtils.isEmpty(strC)) {
                        strC = "jpg,jpeg,png";
                    }
                    this.d = new HashSet(Arrays.asList(TextUtils.split(strC, ",")));
                }
            }
        }
        return this.d;
    }

    private Set<String> f() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    String strB = r1.d().f().b("wimgup", "");
                    if (TextUtils.isEmpty(strB)) {
                        this.e = new HashSet();
                    } else {
                        this.e = new HashSet(Arrays.asList(TextUtils.split(strB, ",")));
                    }
                }
            }
        }
        return this.e;
    }

    private Set<String> i() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    this.f = new HashSet(Arrays.asList(TextUtils.split(r1.d().f().b("wupbl", "qzs.gdtimg.com/union/res/union_site/page/ANVideoEndcard/"), ",")));
                }
            }
        }
        return this.f;
    }

    private Set<String> c() {
        if (this.k == null) {
            synchronized (this) {
                if (this.k == null) {
                    String strB = r1.d().f().b("waohw", "");
                    if (TextUtils.isEmpty(strB)) {
                        this.k = new HashSet();
                    } else {
                        this.k = new HashSet(Arrays.asList(TextUtils.split(strB, ",")));
                    }
                }
            }
        }
        return this.k;
    }

    public Set<String> h() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    String strC = r1.d().f().c("web_proxy_res_suffix");
                    if (TextUtils.isEmpty(strC)) {
                        strC = "html,js,css";
                    }
                    this.c = new HashSet(Arrays.asList(TextUtils.split(strC, ",")));
                }
            }
        }
        return this.c;
    }

    private q50() {
    }

    private File d() {
        if (this.a == null) {
            this.a = gu.b();
        }
        if (!this.a.exists()) {
            this.a.mkdirs();
        }
        return this.a;
    }

    private boolean l() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = Boolean.valueOf(r1.d().f().a("web_proxy_not_hit_event", 0) == 1);
                }
            }
        }
        return this.h.booleanValue();
    }

    private boolean j() {
        if (this.i == null) {
            synchronized (this) {
                if (this.i == null) {
                    this.i = Boolean.valueOf(r1.d().f().a("web_proxy_img_cache", 0) == 1);
                }
            }
        }
        return this.i.booleanValue();
    }

    private boolean k() {
        if (this.j == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = Boolean.valueOf(r1.d().f().a("web_proxy_res_cache", 0) == 1);
                }
            }
        }
        return this.j.booleanValue();
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Set<String> setC = c();
        if (setC.size() <= 0) {
            return false;
        }
        try {
            if (setC.contains("*")) {
                return true;
            }
            return setC.contains(Uri.parse(str).getHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    /* compiled from: A */
    class a implements d {
        final /* synthetic */ e a;
        final /* synthetic */ CountDownLatch b;

        a(e eVar, CountDownLatch countDownLatch) {
            this.a = eVar;
            this.b = countDownLatch;
        }

        @Override // com.qq.e.comm.plugin.q50.d
        public void a(File file) {
            this.a.a = file;
            this.b.countDown();
        }

        @Override // com.qq.e.comm.plugin.q50.d
        public void a(Exception exc, int i) {
            this.b.countDown();
            String unused = q50.l;
            exc.getMessage();
        }
    }

    public File b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(str, this.b);
    }

    /* compiled from: A */
    class b implements nm {
        final /* synthetic */ d a;
        final /* synthetic */ long b;

        b(d dVar, long j) {
            this.a = dVar;
            this.b = j;
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            if (!koVar.a()) {
                b10.a(9130005, null, 1);
            }
            q50.this.a(2060001, koVar.d(), System.currentTimeMillis() - this.b, this.a);
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) throws JSONException {
            q50.this.a(str, this.a, exc, i);
        }
    }

    private FileInputStream d(String str) {
        return a(str, a30.a.IMAGE, false);
    }

    /* compiled from: A */
    class c extends ez {
        final /* synthetic */ String a;
        final /* synthetic */ d b;

        c(String str, d dVar) {
            this.a = str;
            this.b = dVar;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            String unused = q50.l;
            q50.this.a(2060003, file, j, this.b);
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void b() {
            d dVar = this.b;
            if (dVar != null) {
                dVar.a(new Exception("下载被取消"), 64);
            }
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) throws JSONException {
            String unused = q50.l;
            dbVar.a();
            dbVar.b();
            q50.this.a(this.a, this.b, dbVar, dbVar.a());
        }
    }

    /* compiled from: A */
    private static final class e {
        File a;

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public void a(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (new File(d(), gu.c(str)).exists()) {
            return;
        }
        mm.a().a(str, (nm) new b(dVar, System.currentTimeMillis()), true);
    }

    private boolean c(Uri uri) {
        Set<String> setF = f();
        if (setF.size() <= 0) {
            return false;
        }
        String str = uri.getHost() + uri.getPath();
        Iterator<String> it = setF.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private FileInputStream a(String str, a30.a aVar) {
        return a(str, aVar, true);
    }

    private FileInputStream b(String str, a30.a aVar) throws InterruptedException {
        int i = 1;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        e eVar = new e(null);
        a aVar2 = new a(eVar, countDownLatch);
        if (aVar == a30.a.IMAGE) {
            a(str, aVar2);
        } else {
            b(str, aVar2);
            i = 2;
        }
        try {
            System.currentTimeMillis();
            countDownLatch.await(3L, TimeUnit.SECONDS);
            if (eVar.a != null) {
                System.currentTimeMillis();
                return new FileInputStream(eVar.a);
            }
            b10.a(1110107, null, Integer.valueOf(i), null);
            return null;
        } catch (FileNotFoundException | InterruptedException unused) {
            return null;
        }
    }

    private FileInputStream a(String str, a30.a aVar, boolean z) {
        File fileB;
        a30.a aVar2 = a30.a.IMAGE;
        if (aVar == aVar2) {
            fileB = a(str);
        } else {
            fileB = b(str);
        }
        if (fileB != null) {
            a(aVar, 1);
            if (aVar == aVar2) {
                try {
                    if (e5.c(fileB)) {
                        return null;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return new FileInputStream(fileB);
        }
        a(aVar, -1);
        if (z) {
            if (aVar == aVar2 && j()) {
                return b(str, aVar);
            }
            if (k()) {
                return b(str, aVar);
            }
        }
        return null;
    }

    public boolean b(Uri uri) {
        Set<String> setI = i();
        if (setI.size() <= 0) {
            return false;
        }
        String str = uri.getHost() + uri.getPath();
        Iterator<String> it = setI.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void b(String str, d dVar) {
        fb.a().a(new gb.b().a(this.b).a(gu.c(str)).d(false).b(false).d(str).a(), new c(str, dVar));
    }

    private File a(String str, File file) {
        File file2 = new File(file, gu.c(str));
        if (file2.exists()) {
            if (file2.length() > 0) {
                return file2;
            }
            try {
                file2.delete();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private File a(String str) {
        return a(str, this.a);
    }

    public Pair<FileInputStream, a30.a> a(Uri uri) {
        FileInputStream fileInputStreamA;
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String strA = a30.a(uri);
        a30.a aVarB = a30.b(strA);
        if (!g().contains(strA) && !c(uri)) {
            if (h().contains(strA)) {
                fileInputStreamA = a(string, aVarB);
            } else if (TextUtils.isEmpty(strA)) {
                fileInputStreamA = d(string);
            } else {
                if (l()) {
                    qc qcVar = new qc(1110105);
                    qcVar.a(new ja().a("url", string));
                    b10.a(qcVar);
                }
                return null;
            }
        } else {
            aVarB = a30.a.IMAGE;
            fileInputStreamA = a(string, aVarB);
        }
        return new Pair<>(fileInputStreamA, aVarB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, File file, long j, d dVar) {
        wt wtVar = new wt(i);
        wtVar.b(j);
        if (file.exists()) {
            wtVar.b((int) (file.length() >> 10));
            if (dVar != null) {
                dVar.a(file);
            }
        } else {
            wtVar.b(-1);
            if (dVar != null) {
                dVar.a(new Exception("文件不存在"), 32768);
            }
        }
        b10.a(wtVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar, Exception exc, int i) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("url", str);
        jaVar.a("msg", exc.getMessage());
        b10.b(1110106, null, Integer.valueOf(i), jaVar);
        if (dVar != null) {
            dVar.a(exc, i);
        }
    }

    private void a(a30.a aVar, int i) {
        if (aVar == a30.a.IMAGE) {
            b10.a(1110108, null, Integer.valueOf(i), null);
        } else {
            b10.a(1110104, null, Integer.valueOf(i), null);
        }
    }
}
