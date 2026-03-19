package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class q0<T> {
    public static final String o;
    private static final String p;
    private static final boolean q;
    private static final int r;
    private static final boolean s;
    static final boolean t;
    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected int f;
    protected boolean g;
    protected File h;
    protected File i;
    private File j;
    protected T k;
    private int l;
    protected Class<T> m;
    protected boolean n;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(m10.a("am5p"));
        sb.append(File.separator);
        sb.append(lz.c() ? lz.a : lz.c);
        o = sb.toString();
        p = lz.c() ? "_64" : "_32";
        q = r1.d().f().a("acod", 0) == 1;
        int iA = r1.d().f().a("eo", 0);
        r = iA;
        s = (iA & 1) == 1;
        t = (iA & 2) == 2;
    }

    private Class j() throws Throwable {
        return (Class) pro.getobjresult(461, 0, this);
    }

    protected ClassLoader a(String str, String str2) {
        return (ClassLoader) pro.getobjresult(462, 0, this, str, str2);
    }

    protected abstract kc d();

    protected abstract boolean e() throws Throwable;

    protected boolean g() {
        int i = Build.VERSION.SDK_INT;
        return i <= 28 && i >= 27 && "XIAOMI".equals(Build.BRAND.toUpperCase());
    }

    protected void h() throws Throwable {
        Integer num;
        Context contextA;
        ApplicationInfo applicationInfo;
        if (Build.VERSION.SDK_INT >= 34 && (contextA = r1.d().a()) != null && (applicationInfo = contextA.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 34 && !this.i.setReadOnly()) {
            this.i.delete();
            a(9800002, 1, null);
            return;
        }
        jc.b(this.d);
        try {
            this.m = j();
            this.k = k();
            e = null;
            num = null;
        } catch (ClassNotFoundException e) {
            e = e;
            num = 3;
        } catch (IllegalAccessError e2) {
            e = e2;
            num = 9;
        } catch (IllegalAccessException e3) {
            e = e3;
            num = 5;
        } catch (InstantiationException e4) {
            e = e4;
            num = 6;
        } catch (NoSuchMethodException e5) {
            e = e5;
            num = 7;
        } catch (UnsatisfiedLinkError e6) {
            e = e6;
            num = 8;
        } catch (InvocationTargetException e7) {
            e = e7;
            num = 4;
        } catch (Throwable th) {
            e = th;
            num = 100;
        }
        if (num == null) {
            a(9800002, 0, null);
            jc.b(this.d, 0);
            return;
        }
        String str = this.d;
        int i = this.l + 1;
        this.l = i;
        jc.b(str, i);
        a(9800002, num.intValue(), e);
        if (f()) {
            a(9800003, 0, e);
        }
    }

    protected abstract boolean i();

    public T c() {
        return this.k;
    }

    protected T k() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Class<T> cls = this.m;
        if (cls != null) {
            return cls.getConstructor(Object[].class).newInstance(b());
        }
        throw new NoSuchMethodException("mMainClass is not initialized");
    }

    private boolean f() {
        int i = this.l;
        return i > 0 && i >= this.f;
    }

    private boolean a() throws JSONException {
        int iA = jc.a(this.d);
        this.l = iA;
        boolean z = s;
        if (z && iA == Integer.MAX_VALUE) {
            this.l = 1;
            jc.b(this.d, 1);
        }
        if (f()) {
            return true;
        }
        int i = z ? this.l + 1 : Integer.MAX_VALUE;
        if (!jc.a(this.d, i)) {
            return false;
        }
        a(9800002, 101, null);
        this.l = i;
        if (!z || !f()) {
            return !z;
        }
        a(9800003, 0, null);
        return true;
    }

    /* compiled from: A */
    private class b extends ez {
        private b() {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) throws JSONException {
            try {
                if (q0.this.a(file, true) && q0.this.i()) {
                    q0.this.h();
                }
            } catch (Throwable th) {
                q0.this.a(9800000, 198, th);
            }
        }

        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) throws JSONException {
            q0.this.a(9800000, 4, dbVar);
        }
    }

    protected Object[] b() {
        return new Object[]{r1.d().a(), su.i(), Integer.valueOf(r1.d().e().b()), Boolean.FALSE, r1.d().b().a(), this.h.getAbsolutePath(), this.a};
    }

    public void a(Context context, String str) throws JSONException {
        try {
            this.h = context.getDir(gu.a(str), 0);
        } catch (Throwable th) {
            a(9800000, 199, th);
        }
        if (!g() && e()) {
            if (Build.VERSION.SDK_INT < 21) {
                this.d += ".zip";
            }
            if (a()) {
                return;
            }
            this.i = new File(this.h, this.d);
            File file = !n3.c() ? new File(context.getDir(gu.a(str, context.getPackageName()), 0), this.d) : null;
            if (a(this.i, false)) {
                h();
            } else if (a(file, false)) {
                this.i = file;
                h();
            } else {
                gu.a(this.h);
                fb.a().a(new gb.b().d(this.b).a(this.h).a(this.d).b(false).d(this.g).a(), new b());
            }
            this.n = true;
        }
    }

    protected boolean a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder("up");
        String str = p;
        sb.append(str);
        String strOptString = jSONObject.optString(sb.toString());
        this.b = strOptString;
        if (!TextUtils.isEmpty(strOptString)) {
            String strOptString2 = jSONObject.optString("sgp" + str);
            this.c = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                return true;
            }
        }
        String strOptString3 = jSONObject.optString("up");
        this.b = strOptString3;
        if (!TextUtils.isEmpty(strOptString3)) {
            String strOptString4 = jSONObject.optString("sgp");
            this.c = strOptString4;
            if (!TextUtils.isEmpty(strOptString4)) {
                return true;
            }
        }
        return false;
    }

    void a(int i, int i2, Throwable th) throws JSONException {
        qc qcVar = new qc(i);
        qcVar.c(d().a);
        qcVar.d(i2);
        ja jaVar = new ja();
        String str = this.d;
        if (str != null) {
            jaVar.a("ver", str);
        }
        if (th != null) {
            jaVar.a("ot", Log.getStackTraceString(th));
        }
        qcVar.a(jaVar);
        b10.a(qcVar);
    }

    protected boolean a(File file, boolean z) throws JSONException, IOException {
        if (file != null && file.exists()) {
            ZipInputStream zipInputStream = null;
            if (!y30.a().a(this.c, file)) {
                if (z) {
                    a(9800000, 2, null);
                }
                return false;
            }
            File file2 = new File(this.h, o);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new FileInputStream(file));
                boolean z2 = false;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!nextEntry.isDirectory() && name.startsWith(o)) {
                            File file3 = new File(this.h, name);
                            if (!file3.exists() || nextEntry.getSize() != file3.length() || nextEntry.getCrc() != s60.a(file3)) {
                                file2.mkdirs();
                                gu.a(file3, zipInputStream2);
                            }
                            z2 = true;
                        }
                    } catch (Throwable unused) {
                        zipInputStream = zipInputStream2;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    }
                }
                if (z2) {
                    this.j = file2;
                }
                if (z) {
                    a(9800000, 0, null);
                }
                try {
                    zipInputStream2.close();
                } catch (IOException unused3) {
                }
                return true;
            } catch (Throwable unused4) {
            }
        }
        return false;
    }
}
