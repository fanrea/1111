package com.kwad.sdk.a.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static volatile b brn;
    private File aIg;
    private Stack<AdTemplate> brm = new Stack<>();
    private boolean mHasInit;

    public interface a {
        void VB();

        void hC();
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized File Vy() {
        File file = this.aIg;
        if (file != null) {
            return file;
        }
        String strEA = bf.eA(ServiceProvider.getContext());
        File file2 = new File(strEA);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(strEA + File.separator + "uninstall_ad");
        this.aIg = file3;
        if (!file3.exists()) {
            try {
                this.aIg.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.aIg;
        }
        return this.aIg;
    }

    public final synchronized void a(final a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        h.execute(new bh() { // from class: com.kwad.sdk.a.a.b.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0116 A[Catch: all -> 0x0124, TryCatch #2 {all -> 0x0124, blocks: (B:3:0x0002, B:6:0x0009, B:9:0x0010, B:34:0x00b4, B:49:0x00f1, B:64:0x0112, B:66:0x0116, B:68:0x011a, B:69:0x011d, B:61:0x010b, B:63:0x010f, B:45:0x00da, B:72:0x0120, B:73:0x0123), top: B:79:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
            @Override // com.kwad.sdk.utils.bh
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void doTask() {
                /*
                    Method dump skipped, instructions count: 297
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.b.AnonymousClass1.doTask():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bj(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        boolean z = false;
        Iterator<AdTemplate> it = this.brm.iterator();
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.eV(it.next()) == com.kwad.sdk.core.response.b.e.eV(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (z) {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.aIg));
            } catch (Exception e2) {
                objectOutputStream = null;
                e = e2;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream.writeObject(this.brm);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bk(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e;
        this.brm.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(Vy()));
        } catch (Exception e2) {
            objectOutputStream = null;
            e = e2;
        } catch (Throwable th2) {
            objectOutputStream = null;
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(this.brm);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
        }
    }

    public static b Vz() {
        if (brn == null) {
            synchronized (b.class) {
                if (brn == null) {
                    brn = new b();
                }
            }
        }
        return brn;
    }

    public final void aS(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bh() { // from class: com.kwad.sdk.a.a.b.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                b.this.bk(adTemplate);
            }
        });
    }

    public final void aT(final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bh() { // from class: com.kwad.sdk.a.a.b.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                b.this.bj(adTemplate);
            }
        });
    }

    public final synchronized AdTemplate VA() {
        AdTemplate adTemplate;
        adTemplate = null;
        Stack stack = (Stack) this.brm.clone();
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            AdTemplate adTemplate2 = (AdTemplate) stack.pop();
            if (adTemplate2 != null) {
                String str = com.kwad.sdk.core.response.b.e.eP(adTemplate2).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File fileBl = bl(adTemplate2);
                if (fileBl != null && fileBl.exists() && fileBl.lastModified() + 604800000 > System.currentTimeMillis() && !as.aE(context, str)) {
                    adTemplate = adTemplate2;
                    break;
                }
            }
        }
        return adTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File bl(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.I(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
        if (w.Y(file)) {
            return file;
        }
        return null;
    }
}
