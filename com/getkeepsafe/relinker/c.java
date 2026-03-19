package com.getkeepsafe.relinker;

import android.content.Context;
import android.util.Log;
import com.getkeepsafe.relinker.a.f;
import com.getkeepsafe.relinker.b;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class c {
    protected final Set<String> xf;
    protected final b.InterfaceC0389b xg;
    protected final b.a xh;
    protected boolean xi;
    protected boolean xj;

    protected c() {
        this(new d(), new a());
    }

    private c(b.InterfaceC0389b interfaceC0389b, b.a aVar) {
        this.xf = new HashSet();
        this.xg = interfaceC0389b;
        this.xh = aVar;
    }

    public final c fO() {
        this.xj = true;
        return this;
    }

    public final void c(Context context, String str) {
        a(context, str, (String) null, (b.c) null);
    }

    public final void a(final Context context, final String str, final String str2, final b.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (e.isEmpty(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        a("Beginning load of %s...", str);
        if (cVar == null) {
            b(context, str, str2);
        } else {
            new Thread(new Runnable() { // from class: com.getkeepsafe.relinker.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        c.this.b(context, str, str2);
                    } catch (MissingLibraryException | UnsatisfiedLinkError unused) {
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, String str2) throws Throwable {
        f fVar;
        if (this.xf.contains(str) && !this.xi) {
            a("%s already loaded previously!", str);
            return;
        }
        try {
            this.xg.loadLibrary(str);
            this.xf.add(str);
            a("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            a("Loading the library normally failed: %s", Log.getStackTraceString(e));
            a("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileC = c(context, str, str2);
            if (!fileC.exists() || this.xi) {
                if (this.xi) {
                    a("Forcing a re-link of %s (%s)...", str, str2);
                }
                d(context, str, str2);
                this.xh.a(context, this.xg.supportedAbis(), this.xg.mapLibraryName(str), fileC, this);
            }
            try {
                if (this.xj) {
                    f fVar2 = null;
                    try {
                        fVar = new f(fileC);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List<String> listFQ = fVar.fQ();
                        fVar.close();
                        Iterator<String> it = listFQ.iterator();
                        while (it.hasNext()) {
                            c(context, this.xg.k(it.next()));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fVar2 = fVar;
                        fVar2.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.xg.j(fileC.getAbsolutePath());
            this.xf.add(str);
            a("%s (%s) was re-linked!", str, str2);
        }
    }

    private static File m(Context context) {
        return context.getDir("lib", 0);
    }

    private File c(Context context, String str, String str2) {
        String strMapLibraryName = this.xg.mapLibraryName(str);
        if (e.isEmpty(str2)) {
            return new File(m(context), strMapLibraryName);
        }
        return new File(m(context), strMapLibraryName + "." + str2);
    }

    private void d(Context context, String str, String str2) {
        File fileM = m(context);
        File fileC = c(context, str, str2);
        final String strMapLibraryName = this.xg.mapLibraryName(str);
        File[] fileArrListFiles = fileM.listFiles(new FilenameFilter() { // from class: com.getkeepsafe.relinker.c.2
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str3) {
                return str3.startsWith(strMapLibraryName);
            }
        });
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.xi || !file.getAbsolutePath().equals(fileC.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public final void a(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }
}
