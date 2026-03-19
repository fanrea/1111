package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class e extends k {
    private final p bJf;
    private final com.kwad.sdk.core.videocache.a.b bJg;
    private b bJh;

    public e(p pVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(pVar, bVar);
        this.bJg = bVar;
        this.bJf = pVar;
    }

    public final void a(b bVar) {
        this.bJh = bVar;
    }

    public final void a(d dVar, Socket socket) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.bJd;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    private boolean a(d dVar) {
        long length = this.bJf.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.bJe && ((float) dVar.bJd) > ((float) this.bJg.acU()) + (((float) length) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String strAde = this.bJf.ade();
        boolean z = !TextUtils.isEmpty(strAde);
        long jAcU = this.bJg.isCompleted() ? this.bJg.acU() : this.bJf.length();
        boolean z2 = jAcU >= 0;
        return (dVar.bJe ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (z2 ? format("Content-Length: %d\n", Long.valueOf(dVar.bJe ? jAcU - dVar.bJd : jAcU)) : "") + (z2 && dVar.bJe ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.bJd), Long.valueOf(jAcU - 1), Long.valueOf(jAcU)) : "") + (z ? format("Content-Type: %s\n", strAde) : "") + "\n";
    }

    private void a(OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int iA = a(bArr, j, 1024);
            if (iA == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, iA);
                j += iA;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    private void b(OutputStream outputStream, long j) {
        m jVar = this.bJf;
        if (jVar instanceof h) {
            jVar = new h((h) this.bJf);
        } else if (jVar instanceof j) {
            jVar = new j((j) this.bJf);
        }
        try {
            jVar.bj((int) j);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = jVar.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            jVar.close();
        }
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    @Override // com.kwad.sdk.core.videocache.k
    protected final void fC(int i) {
        b bVar = this.bJh;
        if (bVar != null) {
            bVar.a(this.bJg.file, i);
        }
    }
}
