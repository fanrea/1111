package com.baidu.mobads.container.components.j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobstat.forbes.Config;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements Handler.Callback {
    public static final String a = "bd_log/";
    public static final String b = "log";
    public static final String c = "\n";
    private static final int d = 50;
    private static final long e = 3000;
    private static final int f = 1024;
    private static final int g = 1;
    private static final int h = 2;
    private HandlerThread n;
    private Handler o;
    private int j = 1;
    private int k = 0;
    private CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<String> m = new CopyOnWriteArrayList<>();
    private String p = "";
    private final long i = System.currentTimeMillis();

    /* renamed from: com.baidu.mobads.container.components.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0123a {
        boolean a(b bVar);

        void b(b bVar);
    }

    public interface c {
        void a(String str);
    }

    static /* synthetic */ int c(a aVar) {
        int i = aVar.j;
        aVar.j = i + 1;
        return i;
    }

    public a() {
        b();
    }

    public long a() {
        return this.i;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.l.add(str);
        c();
    }

    public void a(List<String> list) {
        this.l.addAll(list);
        c();
    }

    public void a(InterfaceC0123a interfaceC0123a, long j) {
        b(interfaceC0123a, j);
    }

    public int a(File file, c cVar) throws IOException {
        String strA = a(file);
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        int i = 0;
        for (String str : strA.split("\n")) {
            String strC = c(str);
            if (!TextUtils.isEmpty(strC)) {
                i++;
                if (cVar != null) {
                    cVar.a(strC);
                }
            }
        }
        return i;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (1 == message.what) {
            d();
            return true;
        }
        if (2 == message.what && (message.obj instanceof InterfaceC0123a)) {
            a((InterfaceC0123a) message.obj);
            return true;
        }
        return false;
    }

    private void b() {
        if (this.n == null) {
            this.n = new HandlerThread("bd_log_cache_thread");
        }
        if (!this.n.isAlive()) {
            this.n.start();
        }
        this.o = new Handler(this.n.getLooper(), this);
    }

    private void c() {
        if (!this.o.hasMessages(1)) {
            this.o.sendEmptyMessageDelayed(1, 3000L);
        }
    }

    private void b(InterfaceC0123a interfaceC0123a, long j) {
        if (!this.o.hasMessages(2, interfaceC0123a)) {
            Message messageObtain = Message.obtain(this.o, 2, interfaceC0123a);
            if (messageObtain != null) {
                this.o.sendMessageDelayed(messageObtain, j);
            } else {
                com.baidu.mobads.container.l.g.c("LogDataCacheManager read disk message is null.");
            }
        }
    }

    private void a(InterfaceC0123a interfaceC0123a) {
        File file = new File(g());
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles(new com.baidu.mobads.container.components.j.b(this, interfaceC0123a));
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                com.baidu.mobads.container.l.g.c("LogDataCacheManager match no file.");
            }
        }
    }

    private String a(File file) throws IOException {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr, 0, 1024);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        byteArrayOutputStream.flush();
                        String string = byteArrayOutputStream.toString();
                        com.component.lottie.g.g.a(fileInputStream);
                        com.component.lottie.g.g.a(byteArrayOutputStream);
                        return string;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                try {
                    com.baidu.mobads.container.l.g.b(th);
                    return "";
                } finally {
                    com.component.lottie.g.g.a(fileInputStream2);
                    com.component.lottie.g.g.a(byteArrayOutputStream);
                }
            }
        } else {
            return "";
        }
    }

    private void d() {
        if (this.m.isEmpty()) {
            e();
        }
        f();
        this.m.clear();
        if (!this.l.isEmpty()) {
            c();
        }
    }

    private void e() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.l;
        this.l = this.m;
        this.m = copyOnWriteArrayList;
    }

    private void f() {
        int size = this.m.size();
        if (size > 0) {
            try {
                String str = g() + b + this.i;
                FileOutputStream fileOutputStreamA = null;
                try {
                    fileOutputStreamA = a(str + Config.replace + this.j, true);
                    for (int i = 0; i < size; i++) {
                        String str2 = this.m.get(i);
                        if (fileOutputStreamA == null) {
                            break;
                        }
                        String strB = b(str2);
                        if (!TextUtils.isEmpty(strB)) {
                            if (this.k != 0) {
                                strB = "\n" + strB;
                            }
                            byte[] bytes = strB.getBytes();
                            fileOutputStreamA.write(bytes, 0, bytes.length);
                            this.k++;
                            if (this.k >= 50) {
                                fileOutputStreamA.flush();
                                fileOutputStreamA.close();
                                this.k = 0;
                                this.j++;
                                fileOutputStreamA = a(str + Config.replace + this.j, true);
                            }
                        }
                    }
                } finally {
                    if (fileOutputStreamA != null) {
                        fileOutputStreamA.close();
                    }
                }
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }
    }

    private String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str.trim(), "utf-8");
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }
        return str;
    }

    private String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
            }
        }
        return str;
    }

    private FileOutputStream a(String str, boolean z) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            return new FileOutputStream(file, z);
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
            return null;
        }
    }

    private String g() {
        if (TextUtils.isEmpty(this.p)) {
            this.p = bw.j(com.baidu.mobads.container.config.b.a().c()) + a;
        }
        File file = new File(this.p);
        if (!file.exists()) {
            file.mkdir();
        }
        return this.p;
    }

    public static class b {
        private final long a;
        private final int b;
        private final String c;
        private final File d;

        private b(File file, String str, long j, int i) {
            this.d = file;
            this.c = str;
            this.a = j;
            this.b = i;
        }

        public static b a(String str, String str2) {
            try {
                if (str2.matches("log[0-9]{13}_[0-9]+")) {
                    return new b(new File(str + "/" + str2), str2, Long.parseLong(str2.substring(3, 16)), Integer.parseInt(str2.substring(17)));
                }
                return null;
            } catch (Throwable th) {
                com.baidu.mobads.container.l.g.b(th);
                return null;
            }
        }

        public String a() {
            return this.c;
        }

        public long b() {
            return this.a;
        }

        public int c() {
            return this.b;
        }

        public File d() {
            return this.d;
        }
    }
}
