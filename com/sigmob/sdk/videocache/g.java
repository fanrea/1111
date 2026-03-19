package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class g extends p {
    private static final float a = 0.2f;
    private final u b;
    private final com.sigmob.sdk.videocache.file.b c;
    private d d;

    public g(u source, com.sigmob.sdk.videocache.file.b cache) {
        super(source, cache);
        this.c = cache;
        this.b = source;
    }

    private String a(String pattern, Object... args) {
        return String.format(Locale.US, pattern, args);
    }

    private void a(OutputStream out, long offset) throws IOException, q {
        byte[] bArr = new byte[8192];
        while (true) {
            int iA = a(bArr, offset, 8192);
            if (iA == -1) {
                out.flush();
                return;
            } else {
                out.write(bArr, 0, iA);
                offset += iA;
            }
        }
    }

    private boolean a(f request) throws q {
        long jA = this.b.a();
        return (((jA > 0L ? 1 : (jA == 0L ? 0 : -1)) > 0) && request.c && ((float) request.b) > ((float) this.c.a()) + (((float) jA) * 0.2f)) ? false : true;
    }

    private String b(f request) throws IOException, q {
        String strC = this.b.c();
        boolean z = !TextUtils.isEmpty(strC);
        long jA = this.c.d() ? this.c.a() : this.b.a();
        boolean z2 = jA >= 0;
        return (request.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (z2 ? a("Content-Length: %d\n", Long.valueOf(request.c ? jA - request.b : jA)) : "") + (z2 && request.c ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(request.b), Long.valueOf(jA - 1), Long.valueOf(jA)) : "") + (z ? a("Content-Type: %s\n", strC) : "") + "\n";
    }

    private void b(OutputStream out, long offset) throws IOException, q {
        u uVarA = t.a(this.b);
        try {
            uVarA.a((int) offset);
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = uVarA.a(bArr);
                if (iA == -1) {
                    out.flush();
                    return;
                }
                out.write(bArr, 0, iA);
            }
        } finally {
            uVarA.b();
        }
    }

    private String c(f request) {
        return "HTTP/1.1 404 Not Found\n";
    }

    @Override // com.sigmob.sdk.videocache.p
    protected void a(int percents) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.c.a, this.b.g(), percents);
        }
    }

    public void a(d cacheListener) {
        this.d = cacheListener;
    }

    public void a(f request, Socket socket) throws IOException, q {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(request).getBytes("UTF-8"));
        long j = request.b;
        if (a(request)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    @Override // com.sigmob.sdk.videocache.p
    protected void a(Throwable throwable) {
        super.a(throwable);
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(this.b.g(), throwable);
        }
    }
}
