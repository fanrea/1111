package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.download.ConnectTask;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements Runnable {
    private final String adR;
    private final int beF;
    private final ConnectTask bfB;
    private final f bfC;
    private e bfD;
    final int bfE;
    private final boolean bfc;
    private volatile boolean oW;

    /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.beF = i;
        this.bfE = i2;
        this.oW = false;
        this.bfC = fVar;
        this.adR = str;
        this.bfB = connectTask;
        this.bfc = z;
    }

    public final void pause() {
        this.oW = true;
        e eVar = this.bfD;
        if (eVar != null) {
            eVar.pause();
        }
    }

    public final void discard() {
        pause();
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        boolean z;
        Exception e;
        Process.setThreadPriority(10);
        long j = this.bfB.Nw().beO;
        com.kwad.framework.filedownloader.a.b bVarNt = null;
        boolean z2 = false;
        while (!this.oW) {
            try {
                try {
                    bVarNt = this.bfB.Nt();
                    int responseCode = bVarNt.getResponseCode();
                    if (com.kwad.framework.filedownloader.f.d.bhj) {
                        com.kwad.framework.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.bfE), Integer.valueOf(this.beF), this.bfB.Nw(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(com.kwad.framework.filedownloader.f.f.c("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.bfB.getRequestHeader(), bVarNt.Nn(), Integer.valueOf(responseCode), Integer.valueOf(this.beF), Integer.valueOf(this.bfE)));
                    }
                    try {
                        e.a aVar = new e.a();
                        if (this.oW) {
                            if (bVarNt != null) {
                                bVarNt.No();
                                return;
                            }
                            return;
                        } else {
                            e eVarOc = aVar.dy(this.beF).dx(this.bfE).b(this.bfC).a(this).ck(this.bfc).d(bVarNt).c(this.bfB.Nw()).cx(this.adR).Oc();
                            this.bfD = eVarOc;
                            eVarOc.run();
                            if (this.oW) {
                                this.bfD.pause();
                            }
                            if (bVarNt != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e2) {
                        e = e2;
                        z = true;
                        try {
                            if (!this.bfC.a(e)) {
                                this.bfC.b(e);
                                if (bVarNt != null) {
                                    bVarNt.No();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                e eVar = this.bfD;
                                if (eVar == null) {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.bfC.b(e);
                                    if (bVarNt != null) {
                                        bVarNt.No();
                                        return;
                                    }
                                    return;
                                }
                                this.bfC.a(e, eVar.beO - j);
                            } else {
                                this.bfC.a(e, 0L);
                            }
                            if (bVarNt != null) {
                                bVarNt.No();
                            }
                            z2 = z;
                        } finally {
                            if (bVarNt != null) {
                                bVarNt.No();
                            }
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e3) {
                    e = e3;
                    z = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e4) {
                z = z2;
                e = e4;
            }
        }
        if (bVarNt != null) {
            bVarNt.No();
        }
    }

    public static class a {
        private String adR;
        private f bfC;
        private final ConnectTask.a bfF = new ConnectTask.a();
        private Integer bfG;
        private Boolean bfz;

        public final a a(f fVar) {
            this.bfC = fVar;
            return this;
        }

        public final a dv(int i) {
            this.bfF.du(i);
            return this;
        }

        public final a cu(String str) {
            this.bfF.cr(str);
            return this;
        }

        public final a cv(String str) {
            this.bfF.cs(str);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.bfF.a(bVar);
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.bfF.a(aVar);
            return this;
        }

        public final a cw(String str) {
            this.adR = str;
            return this;
        }

        public final a ci(boolean z) {
            this.bfz = Boolean.valueOf(z);
            return this;
        }

        public final a i(Integer num) {
            this.bfG = num;
            return this;
        }

        public final c NP() {
            if (this.bfC == null || this.adR == null || this.bfz == null || this.bfG == null) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("%s %s %B", this.bfC, this.adR, this.bfz));
            }
            ConnectTask connectTaskNx = this.bfF.Nx();
            return new c(connectTaskNx.beF, this.bfG.intValue(), connectTaskNx, this.bfC, this.bfz.booleanValue(), this.adR, (byte) 0);
        }
    }
}
