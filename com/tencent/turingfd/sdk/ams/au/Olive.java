package com.tencent.turingfd.sdk.ams.au;

import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Olive {
    public final Object a;
    public final Object b;
    public Process c;
    public DataOutputStream d;
    public Cdo e;
    public Cdo f;
    public ByteArrayOutputStream g;
    public ByteArrayOutputStream h;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Olive$for, reason: invalid class name */
    public static class Cfor {
        public final String a;
        public final String b;
        public final long c;

        public Cfor(String str, String str2, long j) {
            this.a = str;
            this.b = str2;
            this.c = j;
        }
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Olive$if, reason: invalid class name */
    public static class Cif {
        public final String a;
        public final String b;

        public Cif(String str, Integer num, String str2, String str3) {
            this.a = str2;
            this.b = str3;
        }
    }

    public Olive(String str) throws InterruptedException, IOException, IllegalArgumentException {
        Object obj = new Object();
        this.a = obj;
        this.b = new Object();
        this.g = new ByteArrayOutputStream();
        this.h = new ByteArrayOutputStream();
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith("/") && !new File(str).exists()) {
            throw new FileNotFoundException();
        }
        this.c = Runtime.getRuntime().exec(str);
        synchronized (obj) {
            obj.wait(10L);
        }
        try {
            this.c.exitValue();
            throw new IOException();
        } catch (Exception unused) {
            this.d = new DataOutputStream(this.c.getOutputStream());
            this.e = new Cdo("s", this.c.getInputStream(), this.g);
            this.f = new Cdo("e", this.c.getErrorStream(), this.h);
            synchronized (this.a) {
                this.a.wait(10L);
                this.e.start();
                this.f.start();
            }
        }
    }

    public final Cif a(Cfor cfor, long j) throws InterruptedException {
        boolean z;
        synchronized (this.a) {
            synchronized (this.b) {
                z = new String(this.g.toByteArray()).lastIndexOf(":RET=") == -1;
            }
            if (z) {
                this.a.wait(j);
            }
        }
        synchronized (this.b) {
            byte[] byteArray = this.g.toByteArray();
            byte[] byteArray2 = this.h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") == -1) {
                return null;
            }
            this.g.reset();
            this.h.reset();
            if (str.lastIndexOf(":RET=0") != -1) {
                return new Cif(cfor.a, 0, str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            return new Cif(cfor.a, Integer.valueOf((str.lastIndexOf(":RET=EOF") == -1 && str2.lastIndexOf(":RET=EOF") == -1) ? 1 : 2), str.substring(0, str.lastIndexOf(":RET=")), str2);
        }
    }

    public void finalize() throws Throwable {
        try {
            a();
        } catch (Throwable unused) {
        }
        super.finalize();
    }

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Olive$do, reason: invalid class name */
    public class Cdo extends Thread {
        public InputStream a;
        public ByteArrayOutputStream b;

        public Cdo(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            this.a = inputStream;
            this.b = byteArrayOutputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            byte[] bArr;
            try {
                bArr = new byte[1024];
            } catch (Exception unused) {
                return;
            }
            while (true) {
                int i = this.a.read(bArr);
                if (i < 0) {
                    synchronized (Olive.this.b) {
                        this.b.write(":RET=EOF".getBytes());
                        this.b.flush();
                    }
                    synchronized (Olive.this.a) {
                        Olive.this.a.notifyAll();
                    }
                    return;
                }
                if (i > 0) {
                    synchronized (Olive.this.b) {
                        this.b.write(bArr, 0, i);
                        this.b.flush();
                    }
                    synchronized (Olive.this.a) {
                        Olive.this.a.notifyAll();
                    }
                }
                return;
            }
        }
    }

    public final void a() throws InterruptedException, IOException {
        try {
            this.d.write(ShellAdbUtils.COMMAND_EXIT.getBytes());
            this.d.flush();
            this.c.wait(100L);
        } catch (Exception unused) {
        }
        Cdo cdo = this.e;
        if (cdo != null) {
            cdo.interrupt();
            this.e = null;
        }
        Cdo cdo2 = this.f;
        if (cdo2 != null) {
            cdo2.interrupt();
            this.f = null;
        }
        Process process = this.c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable unused2) {
            }
            this.c = null;
        }
    }

    public synchronized Cif a(Cfor cfor) throws InterruptedException, TimeoutException, IOException, IllegalArgumentException {
        String str;
        Cif cifA;
        if (cfor != null) {
            String str2 = cfor.a;
            if (str2 != null && str2.length() > 0 && (str = cfor.b) != null && str.length() > 0 && cfor.c >= 0) {
                synchronized (this.b) {
                    this.g.reset();
                    this.h.reset();
                }
                this.d.write((cfor.b + "\n").getBytes());
                this.d.flush();
                synchronized (this.a) {
                    this.a.wait(10L);
                }
                this.d.writeBytes("echo :RET=$?\n");
                this.d.flush();
                long jNanoTime = System.nanoTime();
                long jNanoTime2 = 0;
                do {
                    long j = cfor.c;
                    if (j != 0) {
                        jNanoTime2 = j - ((System.nanoTime() - jNanoTime) / 1000000);
                        if (jNanoTime2 <= 0) {
                            throw new TimeoutException("t");
                        }
                    }
                    cifA = a(cfor, jNanoTime2);
                } while (cifA == null);
            }
        }
        throw new IllegalArgumentException("v");
        return cifA;
    }
}
