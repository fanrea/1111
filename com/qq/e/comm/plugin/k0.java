package com.qq.e.comm.plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class k0 {
    protected final InputStream a;
    protected final File b;
    protected final il c;
    protected String d;
    protected AtomicBoolean e = new AtomicBoolean(false);

    public int a() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.b, true);
            try {
                try {
                    try {
                        try {
                            return a(fileOutputStream);
                        } catch (a e) {
                            this.d = "ReadIOExceptionWhileDoPartitionRW:" + e.getMessage();
                            try {
                                fileOutputStream.close();
                                return 524288;
                            } catch (Throwable unused) {
                                return 524288;
                            }
                        } catch (b e2) {
                            this.d = "WriteIOExceptionWhileDoPartitionRW:" + e2.getMessage();
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused2) {
                            }
                            return 512;
                        }
                    } catch (SocketException e3) {
                        this.d = "UnknowSocketExceptionWhileDoPartitionRW:" + e3.getMessage();
                        try {
                            fileOutputStream.close();
                            return 4194304;
                        } catch (Throwable unused3) {
                            return 4194304;
                        }
                    } catch (SocketTimeoutException e4) {
                        this.d = "SocketTimeoutExceptionWhileDoPartitionRW:" + e4.getMessage();
                        try {
                            fileOutputStream.close();
                            return 16777216;
                        } catch (Throwable unused4) {
                            return 16777216;
                        }
                    }
                } catch (IOException e5) {
                    this.d = "UnknowIOExceptionWhileDoPartitionRW:" + e5.getMessage();
                    try {
                        fileOutputStream.close();
                        return 2;
                    } catch (Throwable unused5) {
                        return 2;
                    }
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused6) {
                }
            }
        } catch (IOException e6) {
            this.d = "UnKnownExceptionWhileCreateOutputStreamForPartitionFile:" + e6.getMessage();
            return 512;
        }
    }

    protected abstract int a(FileOutputStream fileOutputStream) throws IOException;

    public k0(InputStream inputStream, File file, il ilVar) {
        this.a = inputStream;
        this.b = file;
        this.c = ilVar;
    }

    public final void c() {
        this.e.set(true);
    }

    public String b() {
        return this.d;
    }

    /* compiled from: A */
    protected static class a extends IOException {
        protected a(IOException iOException) {
            super(iOException);
        }
    }

    /* compiled from: A */
    protected static class b extends IOException {
        protected b(IOException iOException) {
            super(iOException);
        }
    }
}
