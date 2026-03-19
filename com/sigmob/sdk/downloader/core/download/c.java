package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.connection.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static final String a = "ConnectTrial";
    private static final Pattern i = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern j = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
    private final com.sigmob.sdk.downloader.f b;
    private final com.sigmob.sdk.downloader.core.breakpoint.c c;
    private boolean d;
    private long e;
    private String f;
    private String g;
    private int h;

    public c(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info) {
        this.b = task;
        this.c = info;
    }

    private static String a(String contentDisposition) throws IOException {
        String strGroup;
        if (contentDisposition == null) {
            return null;
        }
        try {
            Matcher matcher = i.matcher(contentDisposition);
            if (matcher.find()) {
                strGroup = matcher.group(1);
            } else {
                Matcher matcher2 = j.matcher(contentDisposition);
                strGroup = matcher2.find() ? matcher2.group(1) : null;
            }
            if (strGroup != null && strGroup.contains("../")) {
                throw new com.sigmob.sdk.downloader.core.exception.a("The filename [" + strGroup + "] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability");
            }
            return strGroup;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    private static boolean a(a.InterfaceC0732a connected) throws IOException {
        if (connected.d() == 206) {
            return true;
        }
        return "bytes".equals(connected.c("Accept-Ranges"));
    }

    private static String b(a.InterfaceC0732a connected) throws IOException {
        return a(connected.c("Content-Disposition"));
    }

    private static boolean b(String transferEncoding) {
        return transferEncoding != null && transferEncoding.equals("chunked");
    }

    private static long c(String contentRange) {
        if (contentRange == null) {
            return -1L;
        }
        String[] strArrSplit = contentRange.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                com.sigmob.sdk.downloader.core.c.a(a, "parse instance length failed with " + contentRange);
            }
        }
        return -1L;
    }

    private static String c(a.InterfaceC0732a connected) {
        return connected.c("Etag");
    }

    private static long d(a.InterfaceC0732a connected) {
        long jC = c(connected.c("Content-Range"));
        if (jC != -1) {
            return jC;
        }
        if (!b(connected.c("Transfer-Encoding"))) {
            com.sigmob.sdk.downloader.core.c.a(a, "Transfer-Encoding isn't chunked but there is no valid instance length found either!");
        }
        return -1L;
    }

    public void a() throws IOException {
        com.sigmob.sdk.downloader.g.j().g().b(this.b);
        com.sigmob.sdk.downloader.g.j().g().b();
        com.sigmob.sdk.downloader.core.connection.a aVarA = com.sigmob.sdk.downloader.g.j().d().a(this.b.i());
        try {
            if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) this.c.k())) {
                aVarA.a("If-Match", this.c.k());
            }
            aVarA.a("Range", "bytes=0-0");
            Map<String, List<String>> mapB = this.b.b();
            if (mapB != null) {
                com.sigmob.sdk.downloader.core.c.a(mapB, aVarA);
            }
            com.sigmob.sdk.downloader.c cVarA = com.sigmob.sdk.downloader.g.j().b().a();
            cVarA.a(this.b, aVarA.c());
            a.InterfaceC0732a interfaceC0732aA = aVarA.a();
            this.b.a(interfaceC0732aA.g());
            com.sigmob.sdk.downloader.core.c.b(a, "task[" + this.b.c() + "] redirect location: " + this.b.j());
            this.h = interfaceC0732aA.d();
            this.d = a(interfaceC0732aA);
            this.e = d(interfaceC0732aA);
            this.f = c(interfaceC0732aA);
            this.g = b(interfaceC0732aA);
            Map<String, List<String>> mapF = interfaceC0732aA.f();
            if (mapF == null) {
                mapF = new HashMap<>();
            }
            cVarA.a(this.b, this.h, mapF);
            if (a(this.e, interfaceC0732aA)) {
                i();
            }
        } finally {
            aVarA.b();
        }
    }

    boolean a(long oldInstanceLength, a.InterfaceC0732a connected) {
        String strC;
        if (oldInstanceLength != -1) {
            return false;
        }
        String strC2 = connected.c("Content-Range");
        return (strC2 == null || strC2.length() <= 0) && !b(connected.c("Transfer-Encoding")) && (strC = connected.c("Content-Length")) != null && strC.length() > 0;
    }

    public long b() {
        return this.e;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.e == -1;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public boolean h() {
        return (this.c.k() == null || this.c.k().equals(this.f)) ? false : true;
    }

    void i() throws IOException {
        com.sigmob.sdk.downloader.core.connection.a aVarA = com.sigmob.sdk.downloader.g.j().d().a(this.b.i());
        com.sigmob.sdk.downloader.c cVarA = com.sigmob.sdk.downloader.g.j().b().a();
        try {
            aVarA.a("HEAD");
            Map<String, List<String>> mapB = this.b.b();
            if (mapB != null) {
                com.sigmob.sdk.downloader.core.c.a(mapB, aVarA);
            }
            cVarA.a(this.b, aVarA.c());
            a.InterfaceC0732a interfaceC0732aA = aVarA.a();
            cVarA.a(this.b, interfaceC0732aA.d(), interfaceC0732aA.f());
            this.e = com.sigmob.sdk.downloader.core.c.b(interfaceC0732aA.c("Content-Length"));
        } finally {
            aVarA.b();
        }
    }
}
