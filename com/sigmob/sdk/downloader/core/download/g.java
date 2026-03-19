package com.sigmob.sdk.downloader.core.download;

import android.net.ConnectivityManager;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.exception.i;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g {
    private static final String b = "DownloadStrategy";
    private static final long c = 1048576;
    private static final long d = 5242880;
    private static final long e = 52428800;
    private static final long f = 104857600;
    private static final Pattern g = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    Boolean a = null;
    private ConnectivityManager h = null;

    public static class a {
        private volatile String a;
        private final boolean b = false;

        public a() {
        }

        public a(String filename) {
            this.a = filename;
        }

        public String a() {
            return this.a;
        }

        void a(String filename) {
            this.a = filename;
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                return this.a == null ? ((a) obj).a == null : this.a.equals(((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            if (this.a == null) {
                return 0;
            }
            return this.a.hashCode();
        }
    }

    public static class b {
        private a.InterfaceC0732a a;
        private com.sigmob.sdk.downloader.core.breakpoint.c b;
        private int c;

        protected b(a.InterfaceC0732a connected, int blockIndex, com.sigmob.sdk.downloader.core.breakpoint.c info) {
            this.a = connected;
            this.b = info;
            this.c = blockIndex;
        }

        public void a() throws IOException {
            com.sigmob.sdk.downloader.core.breakpoint.a aVarB = this.b.b(this.c);
            int iD = this.a.d();
            com.sigmob.sdk.downloader.core.cause.b bVarA = com.sigmob.sdk.downloader.g.j().g().a(iD, aVarB.a() != 0, this.b, this.a.c("Etag"));
            if (bVarA != null) {
                throw new com.sigmob.sdk.downloader.core.exception.f(bVarA);
            }
            if (com.sigmob.sdk.downloader.g.j().g().a(iD, aVarB.a() != 0)) {
                throw new i(iD, aVarB.a());
            }
        }
    }

    public int a(com.sigmob.sdk.downloader.f task, long totalLength) {
        if (task.u() != null) {
            return task.u().intValue();
        }
        if (totalLength < 1048576) {
            return 1;
        }
        if (totalLength < d) {
            return 2;
        }
        if (totalLength < 52428800) {
            return 3;
        }
        return totalLength < f ? 4 : 5;
    }

    public long a() {
        return 10240L;
    }

    public com.sigmob.sdk.downloader.core.cause.b a(int responseCode, boolean isAlreadyProceed, com.sigmob.sdk.downloader.core.breakpoint.c info, String responseEtag) {
        String strK = info.k();
        if (responseCode == 412) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_PRECONDITION_FAILED;
        }
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) strK) && !com.sigmob.sdk.downloader.core.c.a((CharSequence) responseEtag) && !responseEtag.equals(strK)) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_ETAG_CHANGED;
        }
        if (responseCode == 201 && isAlreadyProceed) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (responseCode == 205 && isAlreadyProceed) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public b a(a.InterfaceC0732a connected, int blockIndex, com.sigmob.sdk.downloader.core.breakpoint.c info) {
        return new b(connected, blockIndex, info);
    }

    public void a(com.sigmob.sdk.downloader.f task, j store) {
        long length;
        com.sigmob.sdk.downloader.core.breakpoint.c cVarE = store.e(task.c());
        if (cVarE == null) {
            cVarE = new com.sigmob.sdk.downloader.core.breakpoint.c(task.c(), task.i(), task.l(), task.d());
            if (com.sigmob.sdk.downloader.core.c.a(task.h())) {
                length = com.sigmob.sdk.downloader.core.c.c(task.h());
            } else {
                File fileM = task.m();
                if (fileM == null) {
                    length = 0;
                    com.sigmob.sdk.downloader.core.c.a(b, "file is not ready on valid info for task on complete state " + task);
                } else {
                    length = fileM.length();
                }
            }
            long j = length;
            cVarE.a(new com.sigmob.sdk.downloader.core.breakpoint.a(0L, j, j));
        }
        f.c.a(task, cVarE);
    }

    public void a(String filenameOnStore, com.sigmob.sdk.downloader.f task) {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) task.d())) {
            task.g().a(filenameOnStore);
        }
    }

    public void a(String responseFileName, com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info) throws IOException {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) task.d())) {
            String strB = b(responseFileName, task);
            if (com.sigmob.sdk.downloader.core.c.a((CharSequence) task.d())) {
                synchronized (task) {
                    if (com.sigmob.sdk.downloader.core.c.a((CharSequence) task.d())) {
                        task.g().a(strB);
                        info.n().a(strB);
                    }
                }
            }
        }
    }

    public boolean a(int responseCode, boolean isAlreadyProceed) {
        if (responseCode == 206 || responseCode == 200) {
            return responseCode == 200 && isAlreadyProceed;
        }
        return true;
    }

    public boolean a(com.sigmob.sdk.downloader.f task) {
        String strA = com.sigmob.sdk.downloader.g.j().c().a(task.i());
        if (strA == null) {
            return false;
        }
        task.g().a(strA);
        return true;
    }

    public boolean a(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info, long instanceLength) {
        com.sigmob.sdk.downloader.core.breakpoint.g gVarC;
        com.sigmob.sdk.downloader.core.breakpoint.c cVarA;
        if (!task.a() || (cVarA = (gVarC = com.sigmob.sdk.downloader.g.j().c()).a(task, info)) == null) {
            return false;
        }
        gVarC.b(cVarA.a());
        if (cVarA.i() <= com.sigmob.sdk.downloader.g.j().g().a()) {
            return false;
        }
        if ((cVarA.k() != null && !cVarA.k().equals(info.k())) || cVarA.j() != instanceLength || cVarA.o() == null || !cVarA.o().exists()) {
            return false;
        }
        info.a(cVarA);
        com.sigmob.sdk.downloader.core.c.b(b, "Reuse another same info: " + info);
        return true;
    }

    public boolean a(final boolean isAcceptRange) {
        if (com.sigmob.sdk.downloader.g.j().e().a()) {
            return isAcceptRange;
        }
        return false;
    }

    protected String b(String responseFileName, com.sigmob.sdk.downloader.f task) throws IOException {
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) responseFileName)) {
            return responseFileName;
        }
        String strI = task.i();
        Matcher matcher = g.matcher(strI);
        String strA = null;
        while (matcher.find()) {
            strA = matcher.group(1);
        }
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) strA)) {
            strA = com.sigmob.sdk.downloader.core.c.a(strI);
        }
        if (strA != null) {
            return strA;
        }
        throw new IOException("Can't find valid filename.");
    }

    public void b() throws UnknownHostException {
        if (this.a == null) {
            this.a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.c(com.kuaishou.weapon.p0.g.b));
        }
        if (this.a.booleanValue()) {
            if (this.h == null) {
                this.h = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().h().getSystemService("connectivity");
            }
            if (!com.sigmob.sdk.downloader.core.c.b(this.h)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void b(com.sigmob.sdk.downloader.f task) throws IOException {
        if (this.a == null) {
            this.a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.c(com.kuaishou.weapon.p0.g.b));
        }
        if (task.f()) {
            if (!this.a.booleanValue()) {
                throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
            }
            if (this.h == null) {
                this.h = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().h().getSystemService("connectivity");
            }
            if (com.sigmob.sdk.downloader.core.c.a(this.h)) {
                throw new com.sigmob.sdk.downloader.core.exception.d();
            }
        }
    }
}
