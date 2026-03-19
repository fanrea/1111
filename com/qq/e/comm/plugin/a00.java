package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class a00 {
    private final AtomicReference<Boolean> a = new AtomicReference<>(null);
    private final AtomicInteger b = new AtomicInteger(0);
    private final nl c = new nl();
    private volatile File d;
    private volatile String e;
    private final boolean f;
    private mu g;
    private boolean h;
    private xz i;

    public a00(boolean z) {
        this.f = z;
    }

    public boolean f() {
        return this.c.a == null;
    }

    public void b() {
        if (!f() && qm$h$$ExternalSyntheticBackport0.m(this.a, null, Boolean.FALSE) && this.b.compareAndSet(0, 2)) {
            a(this.g);
            a(this.g, false);
        }
    }

    public mu d() {
        return this.g;
    }

    public File c() {
        return this.d;
    }

    public String e() {
        if (this.h) {
            this.h = false;
            a(this.g, true);
        }
        return this.e;
    }

    /* compiled from: A */
    class a implements nm {
        a() {
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            File fileD = koVar.d();
            if (fileD == null || !fileD.exists()) {
                a00.this.a((File) null, (String) null);
            } else {
                a00.this.a(fileD, (String) null);
            }
            if (koVar.a()) {
                return;
            }
            f00.a(a00.this.i);
            b10.a(9130005, a00.this.i.c(), 3);
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
            f00.a(a00.this.i, str, i, exc);
            a00.this.a((File) null, (String) null);
        }
    }

    /* compiled from: A */
    class b implements bb {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ mu c;

        @Override // com.qq.e.comm.plugin.bb
        public void a() {
        }

        b(boolean z, String str, mu muVar) {
            this.a = z;
            this.b = str;
            this.c = muVar;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            a00.this.h = false;
            if (a00.this.a(file, this.c)) {
                a00.this.a((File) null, file.getAbsolutePath());
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void b() {
            a00.this.h = false;
            a00.this.a((File) null, (String) null);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, boolean z) {
            if (this.a) {
                a00.this.a((File) null, this.b);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            a00.this.h = false;
            a00.this.a((File) null, (String) null);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(boolean z) {
            if (!z || !this.a) {
                a00.this.h = false;
                a00.this.a((File) null, (String) null);
            } else {
                a00.this.h = true;
                a00.this.a((File) null, this.b);
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, long j2, int i) {
            if (this.a) {
                a00.this.a((File) null, this.b);
            }
        }
    }

    public void a() {
        this.a.set(null);
        this.e = null;
        this.d = null;
        this.c.a = null;
        this.b.set(0);
    }

    private void a(mu muVar) {
        if (muVar == null) {
            a((File) null, (String) null);
            return;
        }
        String strC0 = muVar.c0();
        if (TextUtils.isEmpty(strC0)) {
            a((File) null, (String) null);
            return;
        }
        File file = new File(gu.b(), gu.d(strC0));
        if (file.exists()) {
            a(file, (String) null);
            return;
        }
        mm.a().a(strC0, new a(), v5.b("vcri") + muVar.k().e());
    }

    private void a(mu muVar, boolean z) {
        if (muVar == null) {
            a((File) null, (String) null);
            return;
        }
        String strV0 = muVar.V0();
        if (TextUtils.isEmpty(strV0)) {
            a((File) null, (String) null);
            return;
        }
        File fileA = f40.a(muVar);
        if (a(fileA, muVar)) {
            a((File) null, fileA.getAbsolutePath());
            return;
        }
        String strB = f40.b(strV0);
        if (this.d != null && muVar.R1() && v5.e(muVar)) {
            a((File) null, (String) null);
            f00.a(this.i.c());
            return;
        }
        String strA = ui.a().a(strV0);
        boolean zIsEmpty = TextUtils.isEmpty(strA);
        boolean z2 = !zIsEmpty;
        gb.b bVarC = new gb.b().d(strV0).a(gu.o()).a(strB).d(zIsEmpty).a(f5.a(muVar)).c(v5.a(v5.b("vcrp"), muVar.k()));
        if (z2 && !this.f && !z && v5.c(muVar)) {
            double dK = muVar.K();
            if (v5.a(dK)) {
                this.h = true;
                a((File) null, strA);
                b10.a(1400011, this.i.c(), 0);
                return;
            } else if (v5.b(dK)) {
                this.h = true;
                bVarC.a(v5.a(dK, muVar.W0()));
            }
        }
        fb.a().a(bVarC.a(), new b(z2, strA, muVar));
    }

    public void a(xz xzVar, ml mlVar) {
        this.i = xzVar;
        this.g = xzVar.b();
        this.c.a = mlVar;
        this.a.set(null);
        this.b.set(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, String str) {
        if (f()) {
            return;
        }
        if (file != null) {
            if (this.d == null) {
                this.b.decrementAndGet();
            }
            this.d = file;
        } else if (str != null) {
            if (this.e == null) {
                this.b.decrementAndGet();
            }
            this.e = str;
        } else {
            this.b.decrementAndGet();
        }
        if (this.e == null && (this.d == null || this.b.get() != 0)) {
            if (this.b.get() == 0 && qm$h$$ExternalSyntheticBackport0.m(this.a, Boolean.FALSE, Boolean.TRUE)) {
                int i = this.g.C1() ? 5002 : ErrorCode.IMAGE_LOAD_ERROR;
                this.c.a(new db(i, ""));
                if (i == 5002 && k.b()) {
                    k.g(this.g);
                    return;
                }
                return;
            }
            return;
        }
        if (qm$h$$ExternalSyntheticBackport0.m(this.a, Boolean.FALSE, Boolean.TRUE)) {
            this.c.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(File file, mu muVar) {
        return (muVar == null || file == null || !file.exists()) ? false : true;
    }
}
