package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class fv implements hw {
    private boolean a;
    private c b;
    public b c;
    private ByteArrayOutputStream d;
    private ByteArrayInputStream e;
    private byte[] f;
    private boolean g;

    public fv() {
        this.g = true;
    }

    @Override // com.qq.e.comm.plugin.hw
    public void close() throws IllegalStateException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.d;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }
        ByteArrayInputStream byteArrayInputStream = this.e;
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
        }
    }

    @Override // com.qq.e.comm.plugin.hw
    public String c() throws IllegalStateException, IOException {
        byte[] bArrD = d();
        if (bArrD == null) {
            return null;
        }
        return bArrD.length == 0 ? "" : new String(bArrD, d6.a);
    }

    public boolean f() {
        return this.a;
    }

    public fv(boolean z) {
        this.g = z;
    }

    public byte[] d() throws IllegalStateException, IOException {
        byte[] bArr = this.f;
        return (bArr == null || bArr.length <= 0) ? new byte[0] : bArr;
    }

    public void a(byte[] bArr) throws IOException {
        if (!this.a) {
            if (b(bArr)) {
                this.a = true;
                return;
            }
            throw new IllegalArgumentException("http header parse error");
        }
        if (this.d == null) {
            this.d = new ByteArrayOutputStream();
        }
        this.d.write(bArr);
    }

    public boolean e() throws Throwable {
        if (a() == 204) {
            return true;
        }
        if (!this.g && as.a(a())) {
            return true;
        }
        if ((!this.g || !as.a(a())) && this.d != null) {
            String strA = a("Content-Encoding");
            if (!TextUtils.isEmpty(strA) && strA.contains("gzip")) {
                byte[] bArrB = s60.b(this.d.toByteArray());
                if (bArrB != null) {
                    this.f = bArrB;
                    this.e = new ByteArrayInputStream(this.f);
                    return true;
                }
            } else {
                this.f = this.d.toByteArray();
                this.e = new ByteArrayInputStream(this.f);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    private boolean b(byte[] bArr) throws Throwable {
        ?? bufferedReader;
        a aVar = null;
        aVar = null;
        ?? r0 = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), d6.a));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (this.b == null) {
                            this.b = c.a(line);
                        } else {
                            if (this.c == null) {
                                this.c = new b();
                            }
                            if (!TextUtils.equals("", line)) {
                                this.c.a(line);
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        r0 = bufferedReader;
                        e.toString();
                        bArr = 0;
                        bArr = 0;
                        aVar = r0;
                        if (r0 != 0) {
                            r0.close();
                            aVar = r0;
                        }
                        return bArr;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                bArr = 1;
                bufferedReader.close();
            } catch (Exception e2) {
                e = e2;
            }
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = aVar;
        }
    }

    /* compiled from: A */
    private static final class c {
        public final String a;
        public final int b;
        public final String c;

        public c(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        public static c a(String str) throws NumberFormatException, IOException {
            int i;
            String strSubstring;
            String str2 = "HTTP/1.0";
            if (str.startsWith("HTTP/1.")) {
                i = 9;
                if (str.length() >= 9 && str.charAt(8) == ' ') {
                    int iCharAt = str.charAt(7) - '0';
                    if (iCharAt != 0) {
                        if (iCharAt != 1) {
                            throw new ProtocolException("Unexpected status line: " + str);
                        }
                        str2 = "HTTP/1.1";
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                if (!str.startsWith("ICY ")) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() >= i2) {
                try {
                    int i3 = Integer.parseInt(str.substring(i, i2));
                    if (str.length() <= i2) {
                        strSubstring = "";
                    } else if (str.charAt(i2) == ' ') {
                        strSubstring = str.substring(i + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new c(str2, i3, strSubstring);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            }
            throw new ProtocolException("Unexpected status line: " + str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(' ');
            sb.append(this.b);
            if (this.c != null) {
                sb.append(' ');
                sb.append(this.c);
            }
            return sb.toString();
        }
    }

    @Override // com.qq.e.comm.plugin.hw
    public String a(String str) {
        b bVar;
        if (!this.a || (bVar = this.c) == null) {
            return null;
        }
        return bVar.b(str);
    }

    /* compiled from: A */
    private static final class b {
        private final List<String> a;

        private b() {
            this.a = new ArrayList(20);
        }

        b a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return a(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return a("", str.substring(1));
            }
            return a("", str);
        }

        public String b(String str) {
            for (int size = this.a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.a.get(size))) {
                    return this.a.get(size + 1);
                }
            }
            return null;
        }

        b a(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }
    }

    @Override // com.qq.e.comm.plugin.hw
    public int a() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.b;
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.hw
    public InputStream b() throws IllegalStateException, IOException {
        return this.e;
    }
}
