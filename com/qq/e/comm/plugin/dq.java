package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.ut;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dq implements wj, ll {
    private static final bb B = new b();
    private final String a;
    private final File b;
    private int c;
    private final qt d;
    private final ut e;
    private final ExecutorService f;
    private pt g;
    private int i;
    private String j;
    private ll k;
    private eq l;
    private int n;
    private int o;
    private long p;
    private long q;
    private long r;
    private boolean s;
    private bb v;
    private volatile boolean w;
    private File y;
    private String z;
    private AtomicBoolean h = new AtomicBoolean(false);
    private long m = -1;
    private double t = 1.0d;
    private final List<ot> u = new ArrayList();
    private volatile boolean x = false;
    private Map<String, Object> A = new ConcurrentHashMap();

    private boolean m() throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.i = 0;
        this.j = "";
        if (!this.w) {
            n().a();
        }
        if (!q()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = b(arrayList, arrayList2) && a(arrayList, arrayList2) && b(arrayList) && this.i == 0;
        this.r = System.currentTimeMillis() - jCurrentTimeMillis;
        if (z && this.p <= 0) {
            this.p = this.b.length();
        }
        if (z) {
            if (this.t >= 1.0d || this.b.length() >= this.p) {
                k();
                l();
                n().a(this.b, this.r);
            } else {
                this.i = 128;
                this.j = "DownloaderIsPausedAuto";
                n().a(true);
            }
        } else if (mc.a(this.i)) {
            this.i = 64;
            this.j = "DownloaderIsCanceledManual";
            n().b();
            a(arrayList);
        } else if (mc.e(this.i)) {
            this.i = 128;
            this.j = "DownloaderIsPausedManual";
            n().a(false);
        } else {
            n().a(new db(this.i, this.j));
        }
        return z;
    }

    @Override // com.qq.e.comm.plugin.wj
    public Map<String, Object> e() {
        HashMap map = new HashMap();
        map.put("ltc", Integer.valueOf(this.n));
        map.put("ltcs", Integer.valueOf(this.o));
        map.put("mt", Long.valueOf(this.m));
        return map;
    }

    public dq(String str, File file, int i, cb cbVar, boolean z, String str2) {
        this.a = str;
        this.b = file;
        this.c = i;
        qt qtVar = new qt(cbVar.a(), cbVar.c(), cbVar.d());
        this.d = qtVar;
        this.e = new fa();
        this.f = cbVar.b();
        this.s = z;
        qtVar.a(str2);
    }

    private void l() {
        File file = this.y;
        if (file == null || !file.exists()) {
            return;
        }
        this.y.delete();
    }

    private int o() {
        File[] fileArrListFiles;
        int iA = m10.a(gu.d(this.y), 0);
        if (iA > 0) {
            this.o = 1;
            return iA;
        }
        File parentFile = this.b.getParentFile();
        if (parentFile == null || (fileArrListFiles = parentFile.listFiles(new a())) == null) {
            return 0;
        }
        this.o = 2;
        return fileArrListFiles.length;
    }

    /* compiled from: A */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getAbsolutePath().startsWith(dq.this.b.getAbsolutePath());
        }
    }

    @Override // com.qq.e.comm.plugin.wj
    public boolean i() {
        try {
            return m();
        } catch (Exception e) {
            n().a(new db(1, e.getMessage(), e));
            return false;
        }
    }

    private void k() throws IOException {
        if (this.s) {
            try {
                a(-1).createNewFile();
            } catch (IOException unused) {
            }
        }
    }

    private boolean q() {
        if (TextUtils.isEmpty(this.a)) {
            this.i |= 4;
            this.j = "UrlEmptyError";
            n().a(new db(this.i, this.j));
            return false;
        }
        File file = this.b;
        File parentFile = file == null ? null : file.getParentFile();
        if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
            File file2 = this.y;
            if (file2 == null || file2.exists()) {
                return true;
            }
            gu.c(this.y, String.valueOf(this.c));
            return true;
        }
        this.i |= 2048;
        this.j = "FailToCreateDirectory";
        n().a(new db(this.i, this.j));
        return false;
    }

    private boolean b(List<File> list) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (this.s) {
                    c(list);
                } else if (!d(list)) {
                    return false;
                }
                if (this.b.exists()) {
                    return true;
                }
                this.i |= 32768;
                this.j = "DownloadFileNotExist";
                return false;
            } catch (IOException e) {
                this.i |= 512;
                this.j = "UnknownIOExceptionWhileMerge:" + e.getMessage();
                return false;
            } catch (Throwable th) {
                this.i |= 1;
                this.j = "UnknownExceptionWhileMerge:" + th.getMessage();
                return false;
            }
        } finally {
            this.m = System.currentTimeMillis() - jCurrentTimeMillis;
        }
    }

    private void c(List<File> list) throws IOException {
        if (list.size() > 1) {
            a(list, 1, true);
        }
    }

    private boolean d(List<File> list) throws IOException {
        if (list.size() == 1) {
            if (!gu.b(list.get(0), this.b)) {
                this.i |= 16384;
                this.j = "ExceptionWhileRenameTmpFileToTargetFile";
                return false;
            }
        } else {
            a(list, 0, false);
        }
        return true;
    }

    private boolean a(File file, long j, boolean z) {
        try {
            pt ptVar = this.g;
            if (ptVar != null) {
                ptVar.b();
            }
            pt ptVarA = this.d.a(this.a, file.length(), j, z);
            this.g = ptVarA;
            if (!ptVarA.c()) {
                this.i |= this.g.g();
                this.j = this.g.h();
                this.g.b();
                if (mc.g(this.i) && file.exists()) {
                    file.delete();
                }
                this.g.g();
                this.g.h();
                return false;
            }
            this.A.put("ekaio", Long.valueOf(this.g.e()));
            return true;
        } catch (IOException e) {
            e.toString();
            this.i |= 524288;
            this.j = "IOExceptionWhileCreateConnection " + e.getMessage();
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.wj
    public long f() {
        return this.p;
    }

    @Override // com.qq.e.comm.plugin.wj
    public long j() {
        long jA;
        long j;
        if (this.i == 0) {
            jA = this.p;
            j = this.q;
        } else {
            eq eqVar = this.l;
            if (eqVar == null) {
                return 0L;
            }
            jA = eqVar.a();
            j = this.q;
        }
        return jA - j;
    }

    @Override // com.qq.e.comm.plugin.wj
    public int h() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.wj
    public String g() {
        return this.z;
    }

    /* compiled from: A */
    private static class c implements Callable<Pair<Integer, String>> {
        private final ot a;
        private final il b;

        public c(ot otVar, il ilVar) {
            this.a = otVar;
            this.b = ilVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair<Integer, String> call() throws Exception {
            this.a.a(this.b);
            return new Pair<>(Integer.valueOf(this.a.b()), this.a.a());
        }
    }

    private void p() {
        if (this.h.compareAndSet(false, true)) {
            Iterator<ot> it = this.u.iterator();
            while (it.hasNext()) {
                it.next().pause();
            }
        }
    }

    private bb n() {
        bb bbVar = this.v;
        return bbVar == null ? B : bbVar;
    }

    @Override // com.qq.e.comm.plugin.wj
    public void pause() {
        this.i |= 128;
        p();
    }

    @Override // com.qq.e.comm.plugin.wj
    public void cancel() {
        this.i |= 64;
        p();
    }

    /* compiled from: A */
    class b implements bb {
        @Override // com.qq.e.comm.plugin.bb
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, long j2, int i) {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, boolean z) {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(boolean z) {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void b() {
        }

        b() {
        }
    }

    private boolean b(List<File> list, List<ut.a> list2) {
        ut.a[] aVarArrA;
        File fileA = a(0);
        if (this.h.get()) {
            this.i |= 128;
            return false;
        }
        boolean z = this.t < 1.0d;
        if (!a(fileA, -1L, z)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (this.g.p()) {
            long jF = this.g.f() + fileA.length();
            this.p = jF;
            if (z) {
                double d = this.t;
                double d2 = jF;
                Double.isNaN(d2);
                long j = (long) (d * d2);
                long length = j - fileA.length();
                if (length <= 0) {
                    this.x = true;
                    a(true);
                    n().a(j, this.p, (int) (this.t * 100.0d));
                    this.g.b();
                    return true;
                }
                if (!a(fileA, length, false)) {
                    return false;
                }
                jF = j;
            }
            a(true);
            aVarArrA = this.e.a(jF, this.c);
        } else {
            if (fileA.exists() && !fileA.delete()) {
                this.i |= 8192;
                this.j = "FailToDeleteMainPartitionFile";
                return false;
            }
            this.p = this.g.f();
            if (z && !a(fileA, -1L, false)) {
                return false;
            }
            ut.a[] aVarArr = {new ut.a(0L, this.p)};
            a(false);
            aVarArrA = aVarArr;
        }
        a(this.p, aVarArrA);
        list2.add(aVarArrA[0]);
        zo zoVar = new zo(this.g, fileA, aVarArrA[0].a());
        arrayList.add(a(new c(zoVar, this.l.a(0))));
        list.add(fileA);
        this.u.add(zoVar);
        for (int i = 1; i < aVarArrA.length && !this.h.get(); i++) {
            list2.add(aVarArrA[i]);
            File fileA2 = a(i);
            list.add(fileA2);
            n10 n10Var = new n10(this.a, fileA2, aVarArrA[i].b(), aVarArrA[i].a(), this.d);
            this.u.add(n10Var);
            arrayList.add(a(new c(n10Var, this.l.a(i))));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                Pair pair = (Pair) ((Future) it.next()).get();
                if (((Integer) pair.first).intValue() != 0) {
                    this.i |= ((Integer) pair.first).intValue();
                    this.j += ((String) pair.second) + ";\t";
                }
            } catch (Throwable th) {
                this.i |= 1;
                this.j += "ExceptionWhileExecutePartitionWorks:" + th.getMessage() + "\t";
            }
        }
        this.g.b();
        return this.i == 0;
    }

    private void a(List<File> list) {
        if (this.b.exists()) {
            this.b.delete();
        }
        if (list.isEmpty()) {
            return;
        }
        for (File file : list) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.wj
    public long d() {
        return this.r;
    }

    @Override // com.qq.e.comm.plugin.wj
    public Map<String, Object> c() {
        return this.A;
    }

    private boolean a(List<File> list, List<ut.a> list2) {
        boolean z = true;
        if (this.x) {
            return true;
        }
        boolean z2 = false;
        if (list2.size() != list.size()) {
            this.i |= 1;
            this.j = "RangeCount!=PartitionFileCount";
        } else {
            for (int i = 0; i < list2.size(); i++) {
                long jA = list2.get(i).a();
                if (jA <= 0) {
                    break;
                }
                long length = list.get(i).length();
                if (jA != length) {
                    this.i |= 16;
                    this.j = "PartitionFileSize!=RangeSize," + length + "," + jA;
                    z = false;
                }
            }
            z2 = z;
        }
        if (!z2) {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                it.next().delete();
            }
        }
        return z2;
    }

    @Override // com.qq.e.comm.plugin.wj
    public int b() {
        return this.i;
    }

    private File c(int i) {
        String str;
        if (i == -1) {
            str = "_complete";
        } else if (i != 0) {
            str = Config.replace + i;
        } else {
            return this.b;
        }
        String name = this.b.getName();
        return new File(this.b.getParentFile(), name + str);
    }

    public void c(boolean z) {
        if (z) {
            this.y = new File(this.b.getAbsolutePath() + "_tc");
            int iO = o();
            this.n = iO;
            if (iO != 0) {
                this.c = iO;
            }
        }
    }

    private File a(int i) {
        if (this.s) {
            return c(i);
        }
        return b(i);
    }

    private File b(int i) {
        String name = this.b.getName();
        return new File(this.b.getParentFile(), name + Config.replace + i);
    }

    public void b(boolean z) {
        this.w = z;
    }

    @Override // com.qq.e.comm.plugin.wj
    public String a() {
        return this.j;
    }

    private void a(long j, ut.a[] aVarArr) {
        this.q = 0L;
        int length = aVarArr.length;
        long[] jArr = new long[length];
        long[] jArr2 = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = aVarArr[i].a();
            File fileA = a(i);
            long length2 = fileA != null ? fileA.length() : 0L;
            jArr2[i] = length2;
            this.q += length2;
        }
        eq eqVar = new eq(j, jArr, jArr2);
        this.l = eqVar;
        eqVar.a(this);
    }

    private void a(List<File> list, int i, boolean z) throws IOException {
        int size = list.size();
        if (i >= size) {
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(this.b, z);
        byte[] bArr = new byte[8192];
        for (int i2 = i; i2 < size; i2++) {
            FileInputStream fileInputStream = new FileInputStream(list.get(i2));
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 > 0) {
                    fileOutputStream.write(bArr, 0, i3);
                }
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
        while (i < size) {
            list.get(i).delete();
            i++;
        }
    }

    private void a(boolean z) {
        bb bbVarN = n();
        bbVarN.a(this.p, z);
        String strJ = this.g.j();
        this.z = strJ;
        if (bbVarN instanceof h7) {
            ((h7) bbVarN).a(strJ, this.p);
        }
    }

    @Override // com.qq.e.comm.plugin.ll
    public void a(long j, long j2) {
        bb bbVar = this.v;
        if (bbVar != null) {
            bbVar.a(j, j2, j2 <= 0 ? 0 : (int) ((100 * j) / j2));
        }
        ll llVar = this.k;
        if (llVar != null) {
            llVar.a(j, j2);
        }
    }

    private Future<Pair<Integer, String>> a(c cVar) {
        ExecutorService executorService = this.f;
        if (executorService == null) {
            return new q10(cVar);
        }
        return executorService.submit(cVar);
    }

    public void a(bb bbVar) {
        this.v = bbVar;
    }

    public void a(double d) {
        this.t = d;
    }

    @Override // com.qq.e.comm.plugin.wj
    public void a(ll llVar) {
        this.k = llVar;
    }
}
