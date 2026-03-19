package com.qq.e.comm.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class v {

    /* compiled from: A */
    static class a extends IOException {
        a() {
            super("APNG Format error");
        }
    }

    public static boolean a(jv jvVar) throws a {
        w wVar = jvVar instanceof w ? (w) jvVar : new w(jvVar);
        try {
            if (wVar.a("\u0089PNG") && wVar.a("\r\n\u001a\n")) {
                while (wVar.available() > 0) {
                    if (b(wVar) instanceof c) {
                        return true;
                    }
                }
                return false;
            }
            throw new a();
        } catch (IOException e) {
            if (e instanceof a) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    private static e6 b(w wVar) throws IOException {
        e6 e6Var;
        int iB = wVar.b();
        int iF = wVar.f();
        int iE = wVar.e();
        if (iE == c.g) {
            e6Var = new c();
        } else if (iE == kd.n) {
            e6Var = new kd();
        } else if (iE == ld.f) {
            e6Var = new ld();
        } else if (iE == uj.e) {
            e6Var = new uj();
        } else if (iE == ak.e) {
            e6Var = new ak();
        } else if (iE == ok.h) {
            e6Var = new ok();
        } else {
            e6Var = new e6();
        }
        e6Var.d = iB;
        e6Var.b = iE;
        e6Var.a = iF;
        e6Var.b(wVar);
        e6Var.c = wVar.f();
        return e6Var;
    }

    public static boolean a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zA = a(new l10(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return zA;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return false;
            }
            try {
                fileInputStream2.close();
                return false;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static List<e6> a(w wVar) throws IOException {
        if (wVar.a("\u0089PNG") && wVar.a("\r\n\u001a\n")) {
            ArrayList arrayList = new ArrayList();
            while (wVar.available() > 0) {
                arrayList.add(b(wVar));
            }
            return arrayList;
        }
        throw new a();
    }
}
