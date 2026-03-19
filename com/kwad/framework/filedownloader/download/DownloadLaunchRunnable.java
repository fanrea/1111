package com.kwad.framework.filedownloader.download;

import com.kuaishou.weapon.p0.g;
import com.kwad.framework.filedownloader.download.c;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor bfk = com.kwad.framework.filedownloader.f.b.cC("ConnectionBlock");
    private final com.kwad.framework.filedownloader.b.a beU;
    private final d beX;
    private final int beY;
    private final com.kwad.framework.filedownloader.d.c beZ;
    private final com.kwad.framework.filedownloader.d.b bfa;
    private final boolean bfb;
    private final boolean bfc;
    private final y bfd;
    private boolean bfe;
    int bff;
    private final boolean bfg;
    private final ArrayList<c> bfh;
    private e bfi;
    private boolean bfj;
    private boolean bfl;
    private boolean bfm;
    private boolean bfn;
    private final AtomicBoolean bfo;
    private volatile boolean bfp;
    private volatile Exception bfq;
    private String bfr;
    private long bfs;
    private long bft;
    private long bfu;
    private long bfv;
    private volatile boolean oW;

    /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    private DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.beY = 5;
        this.bfh = new ArrayList<>(5);
        this.bfs = 0L;
        this.bft = 0L;
        this.bfu = 0L;
        this.bfv = 0L;
        this.bfo = new AtomicBoolean(true);
        this.oW = false;
        this.bfe = false;
        this.beZ = cVar;
        this.bfa = bVar;
        this.bfb = z;
        this.bfc = z2;
        this.beU = b.Ny().NA();
        this.bfg = b.Ny().NC();
        this.bfd = yVar;
        this.bff = i3;
        this.beX = new d(cVar, i3, i, i2);
    }

    public final void pause() {
        this.oW = true;
        e eVar = this.bfi;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.bfh.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    public final void NI() {
        if (this.beZ.Oy() > 1) {
            List<com.kwad.framework.filedownloader.d.a> listDn = this.beU.dn(this.beZ.getId());
            if (this.beZ.Oy() == listDn.size()) {
                this.beZ.ax(com.kwad.framework.filedownloader.d.a.Z(listDn));
            } else {
                this.beZ.ax(0L);
                this.beU.mo454do(this.beZ.getId());
            }
        }
        this.beX.NR();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e7, code lost:
    
        if (r9 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e9, code lost:
    
        r9.No();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01fd, code lost:
    
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.f.f.c("invalid connection count %d, the connection count must be larger than 0", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (com.kwad.framework.filedownloader.f.d.bhj == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
    
        com.kwad.framework.filedownloader.f.d.c(r19, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r19.beZ.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b2, code lost:
    
        r19.beX.NQ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        if (r19.oW == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
    
        if (r19.bfp == false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
    
        r19.beX.NV();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0120, code lost:
    
        if (r19.oW == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0122, code lost:
    
        r19.beZ.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0127, code lost:
    
        if (r9 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
    
        r9.No();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012c, code lost:
    
        r19.beX.NQ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
    
        if (r19.oW == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0139, code lost:
    
        if (r19.bfp == false) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
    
        r19.beX.NV();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0144, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0145, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
    
        NM();
        r14 = r19.beZ.getTotal();
        a(r14, r19.beZ.NN());
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015e, code lost:
    
        if (NJ() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0162, code lost:
    
        if (r19.bfl == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0164, code lost:
    
        r10 = r19.beZ.Oy();
        r17 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
    
        r17 = r14;
        r10 = com.kwad.framework.filedownloader.download.b.Ny().a(r19.beZ.getId(), r19.beZ.getUrl(), r19.beZ.getPath(), r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018d, code lost:
    
        r17 = r14;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0190, code lost:
    
        if (r10 <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
    
        if (r19.oW == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
    
        r19.beZ.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x019b, code lost:
    
        if (r9 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019d, code lost:
    
        r9.No();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a0, code lost:
    
        r19.beX.NQ();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01a7, code lost:
    
        if (r19.oW == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01ad, code lost:
    
        if (r19.bfp == false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b1, code lost:
    
        r19.beX.NV();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b9, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bc, code lost:
    
        if (r10 != 1) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c1, code lost:
    
        r19.bfj = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c3, code lost:
    
        if (r11 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c5, code lost:
    
        a(r8.Nw(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cd, code lost:
    
        if (r9 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cf, code lost:
    
        r9.No();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d4, code lost:
    
        r19.beX.NT();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01db, code lost:
    
        if (r19.bfl == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01dd, code lost:
    
        b(r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e1, code lost:
    
        f(r17, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01e6, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025c A[Catch: all -> 0x0217, TryCatch #25 {all -> 0x0217, blocks: (B:46:0x00cf, B:95:0x01d4, B:97:0x01dd, B:98:0x01e1, B:154:0x0256, B:156:0x025c, B:159:0x0264, B:125:0x021a), top: B:205:0x0256 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x026f A[Catch: all -> 0x028f, TryCatch #24 {all -> 0x028f, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:163:0x026f, B:164:0x0272, B:127:0x0222, B:161:0x0269, B:129:0x0229), top: B:204:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[Catch: all -> 0x028f, SYNTHETIC, TRY_LEAVE, TryCatch #24 {all -> 0x028f, blocks: (B:3:0x0005, B:6:0x0014, B:8:0x001c, B:10:0x0020, B:11:0x0032, B:25:0x0090, B:27:0x0094, B:28:0x0099, B:30:0x009d, B:32:0x00a1, B:43:0x00ca, B:51:0x0129, B:74:0x019d, B:101:0x01e9, B:163:0x026f, B:164:0x0272, B:127:0x0222, B:161:0x0269, B:129:0x0229), top: B:204:0x0005 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.run():void");
    }

    private boolean NJ() {
        return (!this.bfl || this.beZ.Oy() > 1) && this.bfm && this.bfg && !this.bfn;
    }

    private com.kwad.framework.filedownloader.download.a Y(List<com.kwad.framework.filedownloader.d.a> list) {
        long jOv;
        long j;
        int iOy = this.beZ.Oy();
        String strNN = this.beZ.NN();
        String targetFilePath = this.beZ.getTargetFilePath();
        boolean z = iOy > 1;
        if ((!z || this.bfg) && com.kwad.framework.filedownloader.f.f.b(this.beZ.getId(), this.beZ)) {
            if (!this.bfg) {
                jOv = new File(strNN).length();
            } else if (z) {
                if (iOy == list.size()) {
                    jOv = com.kwad.framework.filedownloader.d.a.Z(list);
                }
                j = 0;
            } else {
                jOv = this.beZ.Ov();
            }
            j = jOv;
        } else {
            j = 0;
        }
        this.beZ.ax(j);
        boolean z2 = j > 0;
        this.bfl = z2;
        if (!z2) {
            this.beU.mo454do(this.beZ.getId());
            com.kwad.framework.filedownloader.f.f.H(targetFilePath, strNN);
        }
        return new com.kwad.framework.filedownloader.download.a(0L, j, 0L, this.beZ.getTotal() - j);
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) throws FileDownloadHttpException, RetryDirectly {
        int id = this.beZ.getId();
        int responseCode = bVar.getResponseCode();
        this.bfm = responseCode == 206 || responseCode == 1;
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String strOw = this.beZ.Ow();
        String strA = com.kwad.framework.filedownloader.f.f.a(id, bVar);
        if (responseCode == 412 || !(strOw == null || strOw.equals(strA) || (!z && !this.bfm)) || ((responseCode == 201 && connectTask.Nu()) || (responseCode == 416 && this.beZ.Ov() > 0))) {
            if (this.bfl) {
                com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), strOw, strA, Integer.valueOf(responseCode));
            }
            this.beU.mo454do(this.beZ.getId());
            com.kwad.framework.filedownloader.f.f.H(this.beZ.getTargetFilePath(), this.beZ.NN());
            this.bfl = false;
            if (strOw != null && strOw.equals(strA)) {
                com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", strOw, strA, Integer.valueOf(responseCode), Integer.valueOf(id));
                strA = null;
            }
            this.beZ.ax(0L);
            this.beZ.az(0L);
            this.beZ.cz(strA);
            this.beZ.Oz();
            this.beU.a(id, this.beZ.Ow(), this.beZ.Ov(), this.beZ.getTotal(), this.beZ.Oy());
            throw new RetryDirectly();
        }
        this.bfr = connectTask.Nv();
        if (this.bfm || z) {
            long jB = com.kwad.framework.filedownloader.f.f.b(id, bVar);
            String strA2 = this.beZ.Mc() ? com.kwad.framework.filedownloader.f.f.a(bVar, this.beZ.getUrl()) : null;
            boolean z2 = jB == -1;
            this.bfn = z2;
            this.beX.a(this.bfl && this.bfm, !z2 ? this.beZ.Ov() + jB : jB, strA, strA2);
            return;
        }
        throw new FileDownloadHttpException(responseCode, map, bVar.Nn());
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) throws Throwable {
        if (!this.bfm) {
            this.beZ.ax(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.beP, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).dy(this.beZ.getId()).dx(-1).ck(this.bfc).d(bVar).c(aVar).cx(this.beZ.NN());
        this.beZ.dF(1);
        this.beU.C(this.beZ.getId(), 1);
        this.bfi = aVar2.Oc();
        if (this.oW) {
            this.beZ.d((byte) -2);
            this.bfi.pause();
        } else {
            this.bfi.run();
        }
    }

    private void b(int i, List<com.kwad.framework.filedownloader.d.a> list) {
        if (i <= 1 || list.size() != i) {
            throw new IllegalArgumentException();
        }
        d(list, this.beZ.getTotal());
    }

    private void f(long j, int i) {
        long j2 = j / i;
        int id = this.beZ.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            long j4 = i2 == i + (-1) ? 0L : (j3 + j2) - 1;
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id);
            aVar.setIndex(i2);
            aVar.setStartOffset(j3);
            aVar.av(j3);
            aVar.aw(j4);
            arrayList.add(aVar);
            this.beU.a(aVar);
            j3 += j2;
            i2++;
        }
        this.beZ.dF(i);
        this.beU.C(id, i);
        d(arrayList, j);
    }

    private void d(List<com.kwad.framework.filedownloader.d.a> list, long j) {
        long jOs;
        int id = this.beZ.getId();
        String strOw = this.beZ.Ow();
        String url = this.bfr;
        if (url == null) {
            url = this.beZ.getUrl();
        }
        String strNN = this.beZ.NN();
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.bfl;
        long j2 = 0;
        long jOr = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            if (aVar.Os() == j2) {
                jOs = j - aVar.Or();
            } else {
                jOs = (aVar.Os() - aVar.Or()) + 1;
            }
            long j3 = jOs;
            jOr += aVar.Or() - aVar.getStartOffset();
            if (j3 == j2) {
                if (com.kwad.framework.filedownloader.f.d.bhj) {
                    com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
                }
            } else {
                c cVarNP = new c.a().dv(id).i(Integer.valueOf(aVar.getIndex())).a(this).cu(url).cv(z ? strOw : null).c(this.bfa).ci(this.bfc).b(new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.Or(), aVar.Os(), j3)).cw(strNN).NP();
                if (com.kwad.framework.filedownloader.f.d.bhj) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.bfh.add(cVarNP);
            }
            j2 = 0;
        }
        if (jOr != this.beZ.Ov()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.beZ.Ov()), Long.valueOf(jOr));
            this.beZ.ax(jOr);
        }
        ArrayList arrayList = new ArrayList(this.bfh.size());
        Iterator<c> it = this.bfh.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.oW) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.oW) {
            this.beZ.d((byte) -2);
            return;
        }
        List<Future> listInvokeAll = bfk.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            for (Future future : listInvokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void a(long j, String str) {
        com.kwad.framework.filedownloader.e.a aVarCL = null;
        if (j != -1) {
            try {
                aVarCL = com.kwad.framework.filedownloader.f.f.cL(this.beZ.NN());
                long length = new File(str).length();
                long j2 = j - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes < j2) {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                }
                if (!com.kwad.framework.filedownloader.f.e.OX().bhp) {
                    aVarCL.setLength(j);
                }
            } finally {
                if (0 != 0) {
                    aVarCL.close();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j) {
        if (this.oW) {
            return;
        }
        this.beX.onProgress(j);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j, long j2) {
        if (this.oW) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.beZ.getId()));
                return;
            }
            return;
        }
        int i = cVar == null ? -1 : cVar.bfE;
        if (com.kwad.framework.filedownloader.f.d.bhj) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.beZ.getTotal()));
        }
        if (!this.bfj) {
            synchronized (this.bfh) {
                this.bfh.remove(cVar);
            }
        } else {
            if (j == 0 || j2 == this.beZ.getTotal()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.beZ.getTotal()), Integer.valueOf(this.beZ.getId()));
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.bfj && code == 416 && !this.bfe) {
                com.kwad.framework.filedownloader.f.f.H(this.beZ.getTargetFilePath(), this.beZ.NN());
                this.bfe = true;
                return true;
            }
        }
        return this.bff > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.bfp = true;
        this.bfq = exc;
        if (this.oW) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.beZ.getId()));
            }
        } else {
            Iterator it = ((ArrayList) this.bfh.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.discard();
                }
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j) {
        if (this.oW) {
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.beZ.getId()));
            }
        } else {
            int i = this.bff;
            int i2 = i - 1;
            this.bff = i2;
            if (i < 0) {
                com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.beZ.getId()));
            }
            this.beX.a(exc, this.bff, j);
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void NK() {
        this.beU.f(this.beZ.getId(), this.beZ.Ov());
    }

    private void NL() {
        if (this.bfc && !com.kwad.framework.filedownloader.f.f.cJ(g.b)) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.beZ.getId()), g.b));
        }
        if (this.bfc && com.kwad.framework.filedownloader.f.f.Pc()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void NM() throws RetryDirectly, DiscardSafely {
        int id = this.beZ.getId();
        if (this.beZ.Mc()) {
            String targetFilePath = this.beZ.getTargetFilePath();
            int iG = com.kwad.framework.filedownloader.f.f.G(this.beZ.getUrl(), targetFilePath);
            if (com.kwad.framework.filedownloader.f.c.a(id, targetFilePath, this.bfb, false)) {
                this.beU.dp(id);
                this.beU.mo454do(id);
                throw new DiscardSafely();
            }
            com.kwad.framework.filedownloader.d.c cVarDm = this.beU.dm(iG);
            if (cVarDm != null) {
                if (com.kwad.framework.filedownloader.f.c.a(id, cVarDm, this.bfd, false)) {
                    this.beU.dp(id);
                    this.beU.mo454do(id);
                    throw new DiscardSafely();
                }
                List<com.kwad.framework.filedownloader.d.a> listDn = this.beU.dn(iG);
                this.beU.dp(iG);
                this.beU.mo454do(iG);
                com.kwad.framework.filedownloader.f.f.cN(this.beZ.getTargetFilePath());
                if (com.kwad.framework.filedownloader.f.f.b(iG, cVarDm)) {
                    this.beZ.ax(cVarDm.Ov());
                    this.beZ.az(cVarDm.getTotal());
                    this.beZ.cz(cVarDm.Ow());
                    this.beZ.dF(cVarDm.Oy());
                    this.beU.b(this.beZ);
                    if (listDn != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : listDn) {
                            aVar.setId(id);
                            this.beU.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwad.framework.filedownloader.f.c.a(id, this.beZ.Ov(), this.beZ.NN(), targetFilePath, this.bfd)) {
                this.beU.dp(id);
                this.beU.mo454do(id);
                throw new DiscardSafely();
            }
        }
    }

    public final int getId() {
        return this.beZ.getId();
    }

    public final boolean isAlive() {
        return this.bfo.get() || this.beX.isAlive();
    }

    public final String NN() {
        return this.beZ.NN();
    }

    class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        RetryDirectly() {
        }
    }

    class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        DiscardSafely() {
        }
    }

    public static class a {
        private com.kwad.framework.filedownloader.d.b beG;
        private com.kwad.framework.filedownloader.d.c beZ;
        private Integer bfA;
        private y bfd;
        private Integer bfw;
        private Integer bfx;
        private Boolean bfy;
        private Boolean bfz;

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.beZ = cVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.beG = bVar;
            return this;
        }

        public final a a(y yVar) {
            this.bfd = yVar;
            return this;
        }

        public final a f(Integer num) {
            this.bfw = num;
            return this;
        }

        public final a g(Integer num) {
            this.bfx = num;
            return this;
        }

        public final a a(Boolean bool) {
            this.bfy = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.bfz = bool;
            return this;
        }

        public final a h(Integer num) {
            this.bfA = num;
            return this;
        }

        public final DownloadLaunchRunnable NO() {
            if (this.beZ == null || this.bfd == null || this.bfw == null || this.bfx == null || this.bfy == null || this.bfz == null || this.bfA == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.beZ, this.beG, this.bfd, this.bfw.intValue(), this.bfx.intValue(), this.bfy.booleanValue(), this.bfz.booleanValue(), this.bfA.intValue(), (byte) 0);
        }
    }
}
