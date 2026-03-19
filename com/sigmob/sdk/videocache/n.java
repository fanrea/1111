package com.sigmob.sdk.videocache;

import com.czhj.sdk.logger.SigmobLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class n {
    private static final String a = "ping";
    private static final String b = "ping ok";
    private final ExecutorService c = Executors.newSingleThreadExecutor();
    private final String d;
    private final int e;

    private class a implements Callable<Boolean> {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(n.this.b());
        }
    }

    n(String host, int port) {
        this.d = (String) o.a(host);
        this.e = port;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() throws q {
        u uVarA = t.a(c());
        try {
            byte[] bytes = b.getBytes();
            uVarA.a(0L);
            byte[] bArr = new byte[bytes.length];
            uVarA.a(bArr);
            boolean zEquals = Arrays.equals(bytes, bArr);
            SigmobLog.i("Ping response: `" + new String(bArr) + "`, pinged? " + zEquals);
            return zEquals;
        } catch (q e) {
            SigmobLog.e("Error reading ping response", e);
            return false;
        } finally {
            uVarA.b();
        }
    }

    private String c() {
        return String.format(Locale.US, "http://%s:%d/%s", this.d, Integer.valueOf(this.e), a);
    }

    void a(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(b.getBytes());
    }

    boolean a(int maxAttempts, int startTimeout) {
        int i = 0;
        while (i < maxAttempts) {
            try {
            } catch (InterruptedException e) {
                e = e;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                SigmobLog.w("Error pinging server (attempt: " + i + ", timeout: " + startTimeout + "). ");
            }
            if (((Boolean) this.c.submit(new a()).get(startTimeout, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i++;
            startTimeout *= 2;
        }
        SigmobLog.e(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). Default proxies are: %s", Integer.valueOf(i), Integer.valueOf(startTimeout / 2), a()));
        return false;
    }

    boolean a(String request) {
        return a.equals(request);
    }
}
