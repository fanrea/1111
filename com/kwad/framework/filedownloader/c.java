package com.kwad.framework.filedownloader;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.d;
import com.kwad.framework.filedownloader.x;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements com.kwad.framework.filedownloader.a, a.InterfaceC0551a, d.a {
    private final x bcO;
    private final x.a bcP;
    private int bcQ;
    private ArrayList<Object> bcR;
    private String bcS;
    private String bcT;
    private boolean bcU;
    private com.kwad.framework.filedownloader.d.b bcV;
    private i bcW;
    private Object bcX;
    private final Object bdg;
    private final String mUrl;
    private int bcY = 0;
    private boolean bcZ = false;
    private boolean bda = false;
    private int bdb = 100;
    private int bdc = 10;
    private boolean bdd = false;
    volatile int bde = 0;
    private boolean bdf = false;
    private final Object bdh = new Object();
    private volatile boolean bdi = false;

    @Override // com.kwad.framework.filedownloader.d.a
    public final a.InterfaceC0551a MC() {
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final com.kwad.framework.filedownloader.a Mo() {
        return this;
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.bdf = true;
        return true;
    }

    c(String str) {
        this.mUrl = str;
        Object obj = new Object();
        this.bdg = obj;
        d dVar = new d(this, obj);
        this.bcO = dVar;
        this.bcP = dVar;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a cm(String str) {
        return f(str, false);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a f(String str, boolean z) {
        this.bcS = str;
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "setPath %s", str);
        }
        this.bcU = z;
        if (z) {
            this.bcT = null;
        } else {
            this.bcT = new File(str).getName();
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a a(i iVar) {
        this.bcW = iVar;
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "setListener %s", iVar);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a j(Object obj) {
        this.bcX = obj;
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "setTag %s", obj);
        }
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a cf(boolean z) {
        this.bdd = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a cZ(int i) {
        this.bcY = 3;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a B(String str, String str2) {
        MA();
        this.bcV.D(str, str2);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a cn(String str) {
        if (this.bcV == null) {
            synchronized (this.bdh) {
                if (this.bcV == null) {
                    return this;
                }
            }
        }
        this.bcV.cy(str);
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a cg(boolean z) {
        this.bcZ = true;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final com.kwad.framework.filedownloader.a ch(boolean z) {
        this.bda = z;
        return this;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final a.b LX() {
        return new a(this, (byte) 0);
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean LY() {
        if (isRunning()) {
            com.kwad.framework.filedownloader.f.d.d(this, "This task[%d] is running, if you want start the same task, please create a new one by FileDownloader#create", Integer.valueOf(getId()));
            return false;
        }
        this.bde = 0;
        this.bdf = false;
        this.bdi = false;
        this.bcO.reset();
        return true;
    }

    private boolean My() {
        return this.bcO.Mg() != 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean isRunning() {
        if (r.Ne().Ni().d(this)) {
            return true;
        }
        return com.kwad.framework.filedownloader.d.d.dI(Mg());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean LZ() {
        return this.bde != 0;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int start() {
        if (this.bdf) {
            throw new IllegalStateException("If you start the task manually, it means this task doesn't belong to a queue, so you must not invoke BaseDownloadTask#ready() or InQueueTask#enqueue() before you start() this method. For detail: If this task doesn't belong to a queue, what is just an isolated task, you just need to invoke BaseDownloadTask#start() to start this task, that's all. In other words, If this task doesn't belong to a queue, you must not invoke BaseDownloadTask#ready() method or InQueueTask#enqueue() method before invoke BaseDownloadTask#start(), If you do that and if there is the same listener object to start a queue in another thread, this task may be assembled by the queue, in that case, when you invoke BaseDownloadTask#start() manually to start this task or this task is started by the queue, there is an exception buried in there, because this task object is started two times without declare BaseDownloadTask#reuse() : 1. you invoke BaseDownloadTask#start() manually;  2. the queue start this task automatically.");
        }
        return Mz();
    }

    private int Mz() {
        if (My()) {
            if (isRunning()) {
                throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("This task is running %d, if you want to start the same task, please create a new one by FileDownloader.create", Integer.valueOf(getId())));
            }
            throw new IllegalStateException("This task is dirty to restart, If you want to reuse this task, please invoke #reuse method manually and retry to restart again." + this.bcO.toString());
        }
        if (!LZ()) {
            Mr();
        }
        this.bcO.MF();
        return getId();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean pause() {
        boolean zPause;
        synchronized (this.bdg) {
            zPause = this.bcO.pause();
        }
        return zPause;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean cancel() {
        return pause();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getId() {
        int i = this.bcQ;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.bcS) || TextUtils.isEmpty(this.mUrl)) {
            return 0;
        }
        int i2 = com.kwad.framework.filedownloader.f.f.i(this.mUrl, this.bcS, this.bcU);
        this.bcQ = i2;
        return i2;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getUrl() {
        return this.mUrl;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int Ma() {
        return this.bdb;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int Mb() {
        return this.bdc;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getPath() {
        return this.bcS;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean Mc() {
        return this.bcU;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getFilename() {
        return this.bcT;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), Mc(), getFilename());
    }

    @Override // com.kwad.framework.filedownloader.a
    public final i Md() {
        return this.bcW;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileSoFarBytes() {
        if (this.bcO.MG() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.bcO.MG();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long Me() {
        return this.bcO.MG();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSmallFileTotalBytes() {
        if (this.bcO.getTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.bcO.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long Mf() {
        return this.bcO.getTotalBytes();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int getSpeed() {
        return this.bcO.getSpeed();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final byte Mg() {
        return this.bcO.Mg();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final long getStatusUpdateTime() {
        return this.bcO.getStatusUpdateTime();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean Mh() {
        return this.bdd;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Throwable Mi() {
        return this.bcO.Mi();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final Object getTag() {
        return this.bcX;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int Mj() {
        return this.bcY;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final int Mk() {
        return this.bcO.Mk();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean Ml() {
        return this.bcZ;
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean Mm() {
        return this.bcO.Mm();
    }

    @Override // com.kwad.framework.filedownloader.a
    public final boolean Mn() {
        return this.bda;
    }

    private void MA() {
        if (this.bcV == null) {
            synchronized (this.bdh) {
                if (this.bcV == null) {
                    this.bcV = new com.kwad.framework.filedownloader.d.b();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final com.kwad.framework.filedownloader.d.b MB() {
        return this.bcV;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final void Mt() {
        this.bdi = true;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final void free() {
        this.bcO.free();
        if (h.MM().a(this)) {
            this.bdi = false;
        }
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final void Mu() {
        Mz();
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final boolean Mv() {
        ArrayList<Object> arrayList = this.bcR;
        return arrayList != null && arrayList.size() > 0;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final boolean Ms() {
        return this.bdi;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final void setFileName(String str) {
        this.bcT = str;
    }

    @Override // com.kwad.framework.filedownloader.d.a
    public final ArrayList<Object> MD() {
        return this.bcR;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final x.a Mp() {
        return this.bcP;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final boolean da(int i) {
        return getId() == i;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final boolean isOver() {
        return com.kwad.framework.filedownloader.d.d.dH(Mg());
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final int Mq() {
        return this.bde;
    }

    @Override // com.kwad.framework.filedownloader.a.InterfaceC0551a
    public final void Mr() {
        int iHashCode;
        if (Md() != null) {
            iHashCode = Md().hashCode();
        } else {
            iHashCode = hashCode();
        }
        this.bde = iHashCode;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("%d@%s", Integer.valueOf(getId()), super.toString());
    }

    static final class a implements a.b {
        private final c bdj;

        /* synthetic */ a(c cVar, byte b) {
            this(cVar);
        }

        private a(c cVar) {
            this.bdj = cVar;
            c.a(cVar, true);
        }

        @Override // com.kwad.framework.filedownloader.a.b
        public final int Mw() {
            int id = this.bdj.getId();
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "add the task[%d] to the queue", Integer.valueOf(id));
            }
            h.MM().c(this.bdj);
            return id;
        }
    }
}
