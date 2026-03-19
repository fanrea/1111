package com.bytedance.sdk.component.b.d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class mq {
    static final Logger d = Logger.getLogger(mq.class.getName());

    private mq() {
    }

    public static u d(rf rfVar) {
        return new k(rfVar);
    }

    public static c d(yo yoVar) {
        return new uo(yoVar);
    }

    public static yo d(OutputStream outputStream) {
        return d(outputStream, new jh());
    }

    private static yo d(final OutputStream outputStream, final jh jhVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (jhVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new yo() { // from class: com.bytedance.sdk.component.b.d.mq.1
            @Override // com.bytedance.sdk.component.b.d.yo
            public void a_(b bVar, long j) throws IOException {
                try {
                    sy.d(bVar.hc, 0L, j);
                    while (j > 0) {
                        jhVar.h();
                        e eVar = bVar.d;
                        int iMin = (int) Math.min(j, eVar.b - eVar.hc);
                        outputStream.write(eVar.d, eVar.hc, iMin);
                        eVar.hc += iMin;
                        long j2 = iMin;
                        j -= j2;
                        bVar.hc -= j2;
                        if (eVar.hc == eVar.b) {
                            bVar.d = eVar.hc();
                            cb.d(eVar);
                        }
                    }
                } catch (IOException | Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
            public jh d() {
                return jhVar;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static yo d(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        d dVarB = b(socket);
        return dVarB.d(d(socket.getOutputStream(), dVarB));
    }

    public static rf d(InputStream inputStream) {
        return d(inputStream, new jh());
    }

    private static rf d(final InputStream inputStream, final jh jhVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (jhVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new rf() { // from class: com.bytedance.sdk.component.b.d.mq.2
            @Override // com.bytedance.sdk.component.b.d.rf
            public long d(b bVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    jhVar.h();
                    e eVarU = bVar.u(1);
                    int i = inputStream.read(eVarU.d, eVarU.b, (int) Math.min(j, 8192 - eVarU.b));
                    if (i == -1) {
                        return -1L;
                    }
                    eVarU.b += i;
                    long j2 = i;
                    bVar.hc += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (mq.d(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }

            @Override // com.bytedance.sdk.component.b.d.rf, java.lang.AutoCloseable, java.nio.channels.Channel
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // com.bytedance.sdk.component.b.d.rf
            public jh d() {
                return jhVar;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static rf d(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return d(new FileInputStream(file));
    }

    public static yo hc(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return d(new FileOutputStream(file));
    }

    public static yo b(File file) throws FileNotFoundException {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return d(new FileOutputStream(file, true));
    }

    public static yo d() {
        return new yo() { // from class: com.bytedance.sdk.component.b.d.mq.3
            @Override // com.bytedance.sdk.component.b.d.yo, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.bytedance.sdk.component.b.d.rf
            public void close() throws IOException {
            }

            @Override // com.bytedance.sdk.component.b.d.yo, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.bytedance.sdk.component.b.d.yo
            public void a_(b bVar, long j) throws IOException {
                bVar.gb(j);
            }

            @Override // com.bytedance.sdk.component.b.d.yo, com.bytedance.sdk.component.b.d.rf
            public jh d() {
                return jh.b;
            }
        };
    }

    public static rf hc(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        d dVarB = b(socket);
        return dVarB.d(d(socket.getInputStream(), dVarB));
    }

    private static d b(final Socket socket) {
        return new d() { // from class: com.bytedance.sdk.component.b.d.mq.4
            @Override // com.bytedance.sdk.component.b.d.d
            protected IOException hc(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.bytedance.sdk.component.b.d.d
            protected void m_() throws IOException {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (mq.d(e)) {
                        mq.d.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    mq.d.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    static boolean d(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
