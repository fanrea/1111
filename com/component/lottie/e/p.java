package com.component.lottie.e;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p extends a {
    final /* synthetic */ Socket b;

    p(Socket socket) {
        this.b = socket;
    }

    @Override // com.component.lottie.e.a
    protected IOException b(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // com.component.lottie.e.a
    protected void b() throws IOException {
        try {
            this.b.close();
        } catch (AssertionError e) {
            if (l.a(e)) {
                l.a.log(Level.WARNING, "Failed to close timed out socket " + this.b, (Throwable) e);
                return;
            }
            throw e;
        } catch (Exception e2) {
            l.a.log(Level.WARNING, "Failed to close timed out socket " + this.b, (Throwable) e2);
        }
    }
}
