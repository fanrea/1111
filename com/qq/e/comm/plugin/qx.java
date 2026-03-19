package com.qq.e.comm.plugin;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qx {
    private static final String a = "qx";

    boolean a(long j, long j2) {
        return j2 > 0 && j >= j2;
    }

    List<File> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(gu.p());
        arrayList.add(gu.a());
        arrayList.add(gu.o());
        return arrayList;
    }

    int d() {
        return r1.d().f().a("vacmt", 72);
    }

    Comparator<File> e() {
        return new b();
    }

    long f() {
        return System.currentTimeMillis() - (d() * 3600000);
    }

    long g() {
        return r1.d().f().a("vamcs", 500) * 1048576;
    }

    public void h() {
        try {
            List<File> listB = b();
            long jA = a(listB);
            long jG = g();
            if (a(jA, jG)) {
                a(listB, jA - jG);
            } else {
                jz.c(jA);
                jz.c(jG);
            }
        } catch (Exception unused) {
        }
    }

    public long c() {
        return a(b());
    }

    public void a(long j) {
        a(b(), j);
    }

    /* compiled from: A */
    class a implements FileFilter {
        final /* synthetic */ long a;
        final /* synthetic */ int b;

        a(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file.lastModified() < this.a) {
                return true;
            }
            String unused = qx.a;
            file.getAbsolutePath();
            return false;
        }
    }

    /* compiled from: A */
    class b implements Comparator<File> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLastModified = file.lastModified();
            long jLastModified2 = file2.lastModified();
            if (jLastModified < jLastModified2) {
                return -1;
            }
            return jLastModified == jLastModified2 ? 0 : 1;
        }
    }

    void a(List<File> list, long j) {
        if (list == null || list.isEmpty() || j <= 0) {
            return;
        }
        jz.c(j);
        long jF = f();
        int iD = d();
        Comparator<File> comparatorE = e();
        a aVar = new a(jF, iD);
        long jA = 0;
        for (File file : list) {
            if (jA < j) {
                jA += a(file, j, aVar, comparatorE);
            }
        }
        jz.c(jA);
    }

    long a(File file, long j, FileFilter fileFilter, Comparator<File> comparator) {
        long jA = 0;
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                if (file.listFiles().length == 0) {
                    file.getAbsolutePath();
                    file.delete();
                    return 0L;
                }
                File[] fileArrListFiles = file.listFiles(fileFilter);
                if (fileArrListFiles == null) {
                    return 0L;
                }
                Arrays.sort(fileArrListFiles, comparator);
                for (File file2 : fileArrListFiles) {
                    if (jA < j) {
                        jA += a(file2, j - jA, fileFilter, comparator);
                    }
                }
                if (file.listFiles().length == 0) {
                    file.getAbsolutePath();
                    file.delete();
                }
                return jA;
            }
            if (file.isFile()) {
                try {
                    long length = file.length();
                    if (file.delete()) {
                        file.getAbsolutePath();
                        return length;
                    }
                } catch (Exception unused) {
                    file.getAbsolutePath();
                }
            }
        }
        return 0L;
    }

    long a(List<File> list) {
        long jB = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                jB += gu.b(it.next());
            }
        }
        return jB;
    }
}
