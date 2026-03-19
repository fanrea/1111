package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.s;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d implements a.c, x, x.a, x.b {
    private final Object bdg;
    private t bdk;
    private final a bdl;
    private volatile long bdn;
    private final s.b bdp;
    private final s.a bdq;
    private long bdr;
    private int bds;
    private boolean bdt;
    private boolean bdu;
    private String bdv;
    private long mTotalBytes;
    private volatile byte bdm = 0;
    private Throwable bdo = null;
    private boolean bdw = false;

    interface a {
        com.kwad.framework.filedownloader.d.b MB();

        a.InterfaceC0551a MC();

        ArrayList<Object> MD();

        void setFileName(String str);
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean a(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.D(Mg(), messageSnapshot.Mg())) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep ahead, %d, but the current mStatus is %d, %d", Byte.valueOf(this.bdm), Byte.valueOf(Mg()), Integer.valueOf(getId()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean b(MessageSnapshot messageSnapshot) {
        byte bMg = Mg();
        byte bMg2 = messageSnapshot.Mg();
        if (-2 == bMg && com.kwad.framework.filedownloader.d.d.dI(bMg2)) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, callback pending, but has already be paused %d", Integer.valueOf(getId()));
            }
            return true;
        }
        if (!com.kwad.framework.filedownloader.d.d.E(bMg, bMg2)) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "can't update mStatus change by keep flow, %d, but the current mStatus is %d, %d", Byte.valueOf(this.bdm), Byte.valueOf(Mg()), Integer.valueOf(getId()));
            }
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean c(MessageSnapshot messageSnapshot) {
        if (!com.kwad.framework.filedownloader.d.d.f(this.bdl.MC().Mo())) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final boolean d(MessageSnapshot messageSnapshot) {
        if (!this.bdl.MC().Mo().Mc() || messageSnapshot.Mg() != -4 || Mg() != 2) {
            return false;
        }
        e(messageSnapshot);
        return true;
    }

    private void b(byte b) {
        this.bdm = b;
        this.bdn = System.currentTimeMillis();
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final t ME() {
        return this.bdk;
    }

    @Override // com.kwad.framework.filedownloader.x.a
    public final MessageSnapshot j(Throwable th) {
        b((byte) -1);
        this.bdo = th;
        return com.kwad.framework.filedownloader.message.f.a(getId(), MG(), th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e(MessageSnapshot messageSnapshot) {
        com.kwad.framework.filedownloader.a aVarMo = this.bdl.MC().Mo();
        byte bMg = messageSnapshot.Mg();
        b(bMg);
        this.bdt = messageSnapshot.Mm();
        if (bMg == -4) {
            this.bdp.reset();
            int iDb = h.MM().db(aVarMo.getId());
            if (iDb + ((iDb > 1 || !aVarMo.Mc()) ? 0 : h.MM().db(com.kwad.framework.filedownloader.f.f.G(aVarMo.getUrl(), aVarMo.getTargetFilePath()))) <= 1) {
                byte bDg = n.MW().dg(aVarMo.getId());
                com.kwad.framework.filedownloader.f.d.d(this, "warn, but no mListener to receive, switch to pending %d %d", Integer.valueOf(aVarMo.getId()), Integer.valueOf(bDg));
                if (com.kwad.framework.filedownloader.d.d.dI(bDg)) {
                    b((byte) 1);
                    this.mTotalBytes = messageSnapshot.Ok();
                    long jOm = messageSnapshot.Om();
                    this.bdr = jOm;
                    this.bdp.start(jOm);
                    this.bdk.f(((MessageSnapshot.a) messageSnapshot).Oo());
                    return;
                }
            }
            h.MM().a(this.bdl.MC(), messageSnapshot);
            return;
        }
        if (bMg == -3) {
            this.bdw = messageSnapshot.Ol();
            this.bdr = messageSnapshot.Ok();
            this.mTotalBytes = messageSnapshot.Ok();
            h.MM().a(this.bdl.MC(), messageSnapshot);
            return;
        }
        if (bMg == -1) {
            this.bdo = messageSnapshot.On();
            this.bdr = messageSnapshot.Om();
            h.MM().a(this.bdl.MC(), messageSnapshot);
            return;
        }
        if (bMg == 1) {
            this.bdr = messageSnapshot.Om();
            this.mTotalBytes = messageSnapshot.Ok();
            this.bdk.f(messageSnapshot);
            return;
        }
        if (bMg == 2) {
            this.mTotalBytes = messageSnapshot.Ok();
            this.bdu = messageSnapshot.Oa();
            this.bdv = messageSnapshot.getEtag();
            String fileName = messageSnapshot.getFileName();
            if (fileName != null) {
                if (aVarMo.getFilename() != null) {
                    com.kwad.framework.filedownloader.f.d.d(this, "already has mFilename[%s], but assign mFilename[%s] again", aVarMo.getFilename(), fileName);
                }
                this.bdl.setFileName(fileName);
            }
            this.bdp.start(this.bdr);
            this.bdk.h(messageSnapshot);
            return;
        }
        if (bMg == 3) {
            this.bdr = messageSnapshot.Om();
            this.bdp.as(messageSnapshot.Om());
            this.bdk.i(messageSnapshot);
        } else if (bMg != 5) {
            if (bMg != 6) {
                return;
            }
            this.bdk.g(messageSnapshot);
        } else {
            this.bdr = messageSnapshot.Om();
            this.bdo = messageSnapshot.On();
            this.bds = messageSnapshot.Mk();
            this.bdp.reset();
            this.bdk.k(messageSnapshot);
        }
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void onBegin() {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:start %s by %d ", toString(), Byte.valueOf(Mg()));
        }
    }

    @Override // com.kwad.framework.filedownloader.a.c
    public final void Mx() {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.e(this, "filedownloader:lifecycle:over %s by %d ", toString(), Byte.valueOf(Mg()));
        }
        this.bdp.end(this.bdr);
        if (this.bdl.MD() != null) {
            ArrayList arrayList = (ArrayList) this.bdl.MD().clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
        }
        r.Ne().Ni().e(this.bdl.MC());
    }

    d(a aVar, Object obj) {
        this.bdg = obj;
        this.bdl = aVar;
        b bVar = new b();
        this.bdp = bVar;
        this.bdq = bVar;
        this.bdk = new k(aVar.MC(), this);
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void MF() {
        boolean z;
        synchronized (this.bdg) {
            if (this.bdm != 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not input to launch pool, because of the status isn't idle : %d", Integer.valueOf(getId()), Byte.valueOf(this.bdm));
                return;
            }
            b((byte) 10);
            a.InterfaceC0551a interfaceC0551aMC = this.bdl.MC();
            com.kwad.framework.filedownloader.a aVarMo = interfaceC0551aMC.Mo();
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.e(this, "call start Url[%s], Path[%s] Listener[%s], Tag[%s]", aVarMo.getUrl(), aVarMo.getPath(), aVarMo.Md(), aVarMo.getTag());
            }
            try {
                prepare();
                z = true;
            } catch (Throwable th) {
                h.MM().b(interfaceC0551aMC);
                h.MM().a(interfaceC0551aMC, j(th));
                z = false;
            }
            if (z) {
                q.Nc().a(this);
            }
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been into the launch pool.", Integer.valueOf(getId()));
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean pause() {
        if (com.kwad.framework.filedownloader.d.d.dH(Mg())) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already is over, can't pause again, %d %d", Byte.valueOf(Mg()), Integer.valueOf(this.bdl.MC().Mo().getId()));
            }
            return false;
        }
        b((byte) -2);
        a.InterfaceC0551a interfaceC0551aMC = this.bdl.MC();
        com.kwad.framework.filedownloader.a aVarMo = interfaceC0551aMC.Mo();
        q.Nc().b(this);
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.e(this, "the task[%d] has been expired from the launch pool.", Integer.valueOf(getId()));
        }
        r.Ne();
        if (!r.Ng()) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "request pause the task[%d] to the download service, but the download service isn't connected yet.", Integer.valueOf(aVarMo.getId()));
            }
        } else {
            n.MW().df(aVarMo.getId());
        }
        h.MM().b(interfaceC0551aMC);
        h.MM().a(interfaceC0551aMC, com.kwad.framework.filedownloader.message.f.e(aVarMo));
        r.Ne().Ni().e(interfaceC0551aMC);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final byte Mg() {
        return this.bdm;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getStatusUpdateTime() {
        return this.bdn;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void reset() {
        this.bdo = null;
        this.bdv = null;
        this.bdu = false;
        this.bds = 0;
        this.bdw = false;
        this.bdt = false;
        this.bdr = 0L;
        this.mTotalBytes = 0L;
        this.bdp.reset();
        if (com.kwad.framework.filedownloader.d.d.dH(this.bdm)) {
            this.bdk.discard();
            this.bdk = new k(this.bdl.MC(), this);
        } else {
            this.bdk.b(this.bdl.MC(), this);
        }
        b((byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.bdq.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long MG() {
        return this.bdr;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final long getTotalBytes() {
        return this.mTotalBytes;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final Throwable Mi() {
        return this.bdo;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final int Mk() {
        return this.bds;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final boolean Mm() {
        return this.bdt;
    }

    @Override // com.kwad.framework.filedownloader.x
    public final void free() {
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "free the task %d, when the status is %d", Integer.valueOf(getId()), Byte.valueOf(this.bdm));
        }
        b((byte) 0);
    }

    private void prepare() throws IOException {
        File file;
        com.kwad.framework.filedownloader.a aVarMo = this.bdl.MC().Mo();
        if (aVarMo.getPath() == null) {
            aVarMo.cm(com.kwad.framework.filedownloader.f.f.cD(aVarMo.getUrl()));
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "save Path is null to %s", aVarMo.getPath());
            }
        }
        if (aVarMo.Mc()) {
            file = new File(aVarMo.getPath());
        } else {
            String strCH = com.kwad.framework.filedownloader.f.f.cH(aVarMo.getPath());
            if (strCH == null) {
                throw new InvalidParameterException(com.kwad.framework.filedownloader.f.f.c("the provided mPath[%s] is invalid, can't find its directory", aVarMo.getPath()));
            }
            file = new File(strCH);
        }
        if (!file.exists() && !file.mkdirs() && !file.exists()) {
            throw new IOException(com.kwad.framework.filedownloader.f.f.c("Create parent directory failed, please make sure you have permission to create file or directory on the path: %s", file.getAbsolutePath()));
        }
    }

    private int getId() {
        return this.bdl.MC().Mo().getId();
    }

    @Override // com.kwad.framework.filedownloader.x.b
    public final void start() {
        if (this.bdm != 10) {
            com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, because the of status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.bdm));
            return;
        }
        a.InterfaceC0551a interfaceC0551aMC = this.bdl.MC();
        com.kwad.framework.filedownloader.a aVarMo = interfaceC0551aMC.Mo();
        v vVarNi = r.Ne().Ni();
        try {
            if (vVarNi.f(interfaceC0551aMC)) {
                return;
            }
            synchronized (this.bdg) {
                if (this.bdm != 10) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will not start, the status can't assign to toFileDownloadService, because the status isn't toLaunchPool: %d", Integer.valueOf(getId()), Byte.valueOf(this.bdm));
                    return;
                }
                b((byte) 11);
                h.MM().b(interfaceC0551aMC);
                if (com.kwad.framework.filedownloader.f.c.a(aVarMo.getId(), aVarMo.getTargetFilePath(), aVarMo.Mh(), true)) {
                    return;
                }
                boolean zA = n.MW().a(aVarMo.getUrl(), aVarMo.getPath(), aVarMo.Mc(), aVarMo.Ma(), aVarMo.Mb(), aVarMo.Mj(), aVarMo.Mh(), this.bdl.MB(), aVarMo.Mn());
                if (this.bdm == -2) {
                    com.kwad.framework.filedownloader.f.d.d(this, "High concurrent cause, this task %d will be paused,because of the status is paused, so the pause action must be applied", Integer.valueOf(getId()));
                    if (zA) {
                        n.MW().df(getId());
                        return;
                    }
                    return;
                }
                if (!zA) {
                    if (vVarNi.f(interfaceC0551aMC)) {
                        return;
                    }
                    MessageSnapshot messageSnapshotJ = j(new RuntimeException("Occur Unknown Error, when request to start maybe some problem in binder, maybe the process was killed in unexpected."));
                    if (h.MM().a(interfaceC0551aMC)) {
                        vVarNi.e(interfaceC0551aMC);
                        h.MM().b(interfaceC0551aMC);
                    }
                    h.MM().a(interfaceC0551aMC, messageSnapshotJ);
                    return;
                }
                vVarNi.e(interfaceC0551aMC);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            h.MM().a(interfaceC0551aMC, j(th));
        }
    }
}
