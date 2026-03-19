package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class si extends uu {
    protected final pe f;
    private final String g;
    private boolean h;

    private String d() {
        return "HTTP/1.1 400 Bad Request\r\nContent-Type: application/json\r\nContent-Length: 41\r\nAccept-Ranges: bytes\r\n\r\n{\"code\":400,\"msg\":\"Filename is illegal.\"}\r\n";
    }

    @Override // com.qq.e.comm.plugin.uu
    protected void a(OutputStream outputStream) throws IOException {
    }

    si(pe peVar, String str) {
        super(peVar);
        this.f = peVar;
        this.g = str;
    }

    void a(vh vhVar, Socket socket) throws IOException, vu {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        if (this.h) {
            bufferedOutputStream.write(d().getBytes(d6.a));
            bufferedOutputStream.flush();
        } else {
            bufferedOutputStream.write(b(vhVar).getBytes(d6.a));
            a(bufferedOutputStream, vhVar.b, vhVar);
        }
    }

    private String b(vh vhVar) throws IOException, vu {
        String strD = this.f.d();
        boolean z = !TextUtils.isEmpty(strD);
        long jH = this.f.h();
        boolean z2 = jH >= 0;
        boolean z3 = vhVar.c;
        long j = z3 ? jH - vhVar.b : jH;
        boolean z4 = z2 && z3;
        boolean z5 = vhVar.c;
        StringBuilder sb = new StringBuilder();
        sb.append(vhVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\r\n" : "HTTP/1.1 200 OK\r\n");
        sb.append("Accept-Ranges: bytes\r\n");
        sb.append(z2 ? a("Content-Length: %d\r\n", Long.valueOf(j)) : "");
        sb.append(z4 ? a("Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(vhVar.b), Long.valueOf(jH - 1), Long.valueOf(jH)) : "");
        sb.append(z ? a("Content-Type: %s\r\n", strD) : "");
        sb.append("\r\n");
        return sb.toString();
    }

    private void a(OutputStream outputStream, long j, vh vhVar) throws IOException, vu {
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int iA = a(bArr, j, 8192, outputStream, vhVar);
                if (iA == -1) {
                    return;
                }
                outputStream.write(bArr, 0, iA);
                j += iA;
            } finally {
                outputStream.flush();
            }
        }
    }

    void a(boolean z) {
        this.h = z;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
