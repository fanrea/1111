package com.baidu.mobads.container.components.h.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bw;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    public static final int a = 2048;
    public static final String b = "!!";
    public static final String c = "0";
    public static final String d = "1";
    private static final int f = 61440;
    private static final int g = 1;
    private static volatile e k;
    private Context e;
    private MappedByteBuffer h;
    private ConcurrentHashMap<String, Integer> i = new ConcurrentHashMap<>();
    private final AtomicInteger j = new AtomicInteger(0);
    private File l;
    private File m;

    private e(Context context) {
        this.e = context;
        c();
    }

    public static e a(Context context) {
        if (k == null) {
            synchronized (e.class) {
                if (k == null) {
                    k = new e(context);
                }
            }
        }
        return k;
    }

    private File a(String str) throws IOException {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0076 A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #5 {Exception -> 0x0072, blocks: (B:37:0x006e, B:41:0x0076), top: B:48:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = "rw"
            java.io.File r1 = r11.l
            if (r1 == 0) goto L7b
            java.io.File r1 = r11.m
            if (r1 != 0) goto Lc
            goto L7b
        Lc:
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.io.File r3 = r11.l     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            java.io.File r4 = r11.m     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            java.nio.channels.FileChannel r1 = r3.getChannel()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            long r6 = r2.size()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            long r8 = r1.size()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r4 = r2
            r5 = r1
            r4.transferFrom(r5, r6, r8)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            if (r2 == 0) goto L37
            r2.close()     // Catch: java.lang.Exception -> L60
        L37:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.lang.Exception -> L60
            goto L69
        L3d:
            r0 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L6c
        L42:
            r0 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L4c
        L47:
            r0 = move-exception
            r2 = r1
            goto L6c
        L4a:
            r0 = move-exception
            r2 = r1
        L4c:
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L6b
            java.lang.String r4 = "cache——file transfer fail"
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L6b
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L6b
            com.baidu.mobads.container.l.g.e(r3)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L62
            r1.close()     // Catch: java.lang.Exception -> L60
            goto L62
        L60:
            r0 = move-exception
            goto L68
        L62:
            if (r2 == 0) goto L69
            r2.close()     // Catch: java.lang.Exception -> L60
            goto L69
        L68:
            goto L6a
        L69:
        L6a:
            return
        L6b:
            r0 = move-exception
        L6c:
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.lang.Exception -> L72
            goto L74
        L72:
            r1 = move-exception
            goto L7a
        L74:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.lang.Exception -> L72
        L79:
        L7a:
            throw r0
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.components.h.c.e.a():void");
    }

    private void b() {
        try {
            FileWriter fileWriter = new FileWriter(this.m);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            com.baidu.mobads.container.l.g.e("clear cache file fail", e);
        }
    }

    private void c() {
        FileChannel channel = null;
        try {
            this.m = a(e());
            channel = new RandomAccessFile(this.m, "rw").getChannel();
            this.l = a(f());
            this.h = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 61440L);
            try {
                a(this.h.slice());
            } catch (Exception e) {
                com.baidu.mobads.container.l.g.e("restore position fail", e);
                d();
            }
        } catch (Throwable th) {
            try {
                com.baidu.mobads.container.l.g.e("mmap init fail", th);
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th2) {
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Exception e3) {
                    }
                }
                throw th2;
            }
        }
    }

    private void a(ByteBuffer byteBuffer) throws Exception {
        int i = 1;
        while (true) {
            int i2 = byteBuffer.getInt();
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new Exception("magic is illegal.");
                }
                byteBuffer.position(i * 2048);
                i++;
            } else {
                this.j.addAndGet(byteBuffer.position() - 4);
                return;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:29:0x0048). Please report as a decompilation issue!!! */
    private void d() throws Throwable {
        a();
        a(this.h);
        b();
        FileChannel channel = null;
        try {
            try {
                try {
                    channel = new RandomAccessFile(this.m, "rw").getChannel();
                    this.h = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 61440L);
                    if (channel != null) {
                        channel.close();
                    }
                } catch (Throwable th) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                com.baidu.mobads.container.l.g.e("again mmap fail", e2);
                if (channel != null) {
                    channel.close();
                }
            }
        } catch (Exception e3) {
        }
        this.j.set(0);
        this.i.clear();
    }

    public synchronized void a(com.baidu.mobads.container.components.h.b.d dVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.h != null && dVar != null) {
                try {
                    Integer num = this.i.get(dVar.a());
                    if (num != null) {
                        byte[] bytes = (("1!!" + str) + System.getProperty("line.separator")).getBytes();
                        this.h.position(num.intValue());
                        this.h.limit(num.intValue() + 2048);
                        this.h.putInt(1);
                        this.h.put(bytes);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public synchronized void b(com.baidu.mobads.container.components.h.b.d dVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.h != null && dVar != null) {
                try {
                    String strA = dVar.a();
                    byte[] bytes = (("0!!" + str) + System.getProperty("line.separator")).getBytes();
                    Integer num = this.i.get(strA);
                    if (num == null && this.j.get() + 2048 > f) {
                        d();
                    }
                    try {
                        if (num == null) {
                            this.i.put(strA, Integer.valueOf(this.j.get()));
                            this.h.position(this.j.get());
                            this.h.limit(this.j.get() + 2048);
                            this.j.addAndGet(2048);
                        } else {
                            int iIntValue = num.intValue();
                            this.h.position(iIntValue);
                            this.h.limit(iIntValue + 2048);
                        }
                        this.h.putInt(1);
                        this.h.put(bytes);
                        if (num != null) {
                            this.h.limit(this.j.get() + 2048);
                        }
                    } catch (IllegalArgumentException e) {
                        d();
                    } catch (BufferOverflowException e2) {
                        d();
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    private String e() {
        return bw.j(this.e) + "bd_state_cache/_ad_cache";
    }

    private String f() {
        return bw.j(this.e) + "bd_state_log/_ad_log";
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        try {
            Method declaredMethod = Class.forName("sun.nio.ch.FileChannelImpl").getDeclaredMethod("unmap", MappedByteBuffer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, mappedByteBuffer);
        } catch (Throwable th) {
        }
    }
}
