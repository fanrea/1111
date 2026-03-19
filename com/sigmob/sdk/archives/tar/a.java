package com.sigmob.sdk.archives.tar;

import com.kuaishou.socket.nano.SocketMessages;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a implements com.sigmob.sdk.archives.a, e {
    public static final int b = 31;
    public static final int c = 16877;
    public static final int d = 33188;
    public static final int e = 1000;
    private String ac;
    private int ad;
    private int ae;
    private int af;
    private long ag;
    private long ah;
    private byte ai;
    private String aj;
    private String ak;
    private String al;
    private String am;
    private String an;
    private int ao;
    private int ap;
    private boolean aq;
    private long ar;
    private File as;

    private a() {
        this.ak = "ustar\u0000";
        this.al = "00";
        this.ac = "";
        this.aj = "";
        String property = System.getProperty("user.name", "");
        property = property.length() > 31 ? property.substring(0, 31) : property;
        this.ae = 0;
        this.af = 0;
        this.am = property;
        this.an = "";
        this.as = null;
    }

    public a(File file) {
        this(file, a(file.getPath(), false));
    }

    public a(File file, String fileName) {
        this();
        this.as = file;
        this.aj = "";
        if (file.isDirectory()) {
            this.ad = c;
            this.ai = e.M;
            int length = fileName.length();
            this.ac = (length == 0 || fileName.charAt(length + (-1)) != '/') ? fileName + "/" : fileName;
            this.ag = 0L;
        } else {
            this.ad = d;
            this.ai = e.H;
            this.ag = file.length();
            this.ac = fileName;
        }
        this.ah = file.lastModified() / 1000;
        this.ao = 0;
        this.ap = 0;
    }

    public a(String name) {
        this(name, false);
    }

    public a(String name, byte linkFlag) {
        this(name);
        this.ai = linkFlag;
        if (linkFlag == 76) {
            this.ak = e.W;
            this.al = e.X;
        }
    }

    public a(String name, boolean preserveLeadingSlashes) {
        this();
        String strA = a(name, preserveLeadingSlashes);
        boolean zEndsWith = strA.endsWith("/");
        this.ao = 0;
        this.ap = 0;
        this.ac = strA;
        this.ad = zEndsWith ? c : d;
        this.ai = zEndsWith ? e.M : e.H;
        this.ae = 0;
        this.af = 0;
        this.ag = 0L;
        this.ah = new Date().getTime() / 1000;
        this.aj = "";
        this.am = "";
        this.an = "";
        this.ao = 0;
        this.ap = 0;
    }

    public a(byte[] headerBuf) {
        this();
        b(headerBuf);
    }

    private static String a(String fileName, boolean preserveLeadingSlashes) {
        int iIndexOf;
        String lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (lowerCase != null) {
            if (lowerCase.startsWith("windows")) {
                if (fileName.length() > 2) {
                    char cCharAt = fileName.charAt(0);
                    if (fileName.charAt(1) == ':' && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                        fileName = fileName.substring(2);
                    }
                }
            } else if (lowerCase.indexOf("netware") > -1 && (iIndexOf = fileName.indexOf(58)) != -1) {
                fileName = fileName.substring(iIndexOf + 1);
            }
        }
        String strReplace = fileName.replace(File.separatorChar, '/');
        while (!preserveLeadingSlashes && strReplace.startsWith("/")) {
            strReplace = strReplace.substring(1);
        }
        return strReplace;
    }

    private int c(byte[] header) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(header, 257, 6);
        if (byteBufferWrap.compareTo(ByteBuffer.wrap(e.W.getBytes())) == 0) {
            return 2;
        }
        return byteBufferWrap.compareTo(ByteBuffer.wrap("ustar\u0000".getBytes())) == 0 ? 3 : 0;
    }

    @Override // com.sigmob.sdk.archives.a
    public String a() {
        return this.ac.toString();
    }

    public void a(int mode) {
        this.ad = mode;
    }

    public void a(int userId, int groupId) {
        b(userId);
        c(groupId);
    }

    public void a(long time) {
        this.ah = time / 1000;
    }

    public void a(String name) {
        this.ac = a(name, false);
    }

    public void a(String userName, String groupName) {
        c(userName);
        d(groupName);
    }

    public void a(Date time) {
        this.ah = time.getTime() / 1000;
    }

    public void a(byte[] outbuf) {
        int iC = f.c(this.ah, outbuf, f.c(this.ag, outbuf, f.b(this.af, outbuf, f.b(this.ae, outbuf, f.b(this.ad, outbuf, f.a(this.ac, outbuf, 0, 100), 8), 8), 8), 12), 12);
        int i = iC;
        int i2 = 0;
        while (i2 < 8) {
            outbuf[i] = 32;
            i2++;
            i++;
        }
        outbuf[i] = this.ai;
        for (int iB = f.b(this.ap, outbuf, f.b(this.ao, outbuf, f.a(this.an, outbuf, f.a(this.am, outbuf, f.a(this.al, outbuf, f.a(this.ak, outbuf, f.a(this.aj, outbuf, i + 1, 100), 6), 2), 32), 32), 8), 8); iB < outbuf.length; iB++) {
            outbuf[iB] = 0;
        }
        f.d(f.a(outbuf), outbuf, iC, 8);
    }

    public boolean a(a it) {
        return a().equals(it.a());
    }

    @Override // com.sigmob.sdk.archives.a
    public long b() {
        return this.ag;
    }

    public void b(int userId) {
        this.ae = userId;
    }

    public void b(long size) {
        if (size > e.m || size < 0) {
            throw new IllegalArgumentException("Size is out of range: " + size);
        }
        this.ag = size;
    }

    public void b(String link) {
        this.aj = link;
    }

    public void b(byte[] header) {
        this.ac = f.b(header, 0, 100);
        this.ad = (int) f.a(header, 100, 8);
        this.ae = (int) f.a(header, 108, 8);
        this.af = (int) f.a(header, 116, 8);
        this.ag = f.a(header, 124, 12);
        this.ah = f.a(header, 136, 12);
        this.ai = header[156];
        this.aj = f.b(header, 157, 100);
        this.ak = f.b(header, 257, 6);
        this.al = f.b(header, 263, 2);
        this.am = f.b(header, 265, 32);
        this.an = f.b(header, 297, 32);
        this.ao = (int) f.a(header, 329, 8);
        this.ap = (int) f.a(header, 337, 8);
        if (c(header) == 2) {
            this.aq = f.a(header, SocketMessages.PayloadType.SC_AUTHOR_CHAT_END);
            this.ar = f.a(header, SocketMessages.PayloadType.SC_AUTHOR_CHAT_REJECT, 12);
            return;
        }
        String strB = f.b(header, 345, 155);
        if (c() && !this.ac.endsWith("/")) {
            this.ac += "/";
        }
        if (strB.length() > 0) {
            this.ac = strB + "/" + this.ac;
        }
    }

    public boolean b(a desc) {
        return desc.a().startsWith(a());
    }

    public void c(int groupId) {
        this.af = groupId;
    }

    public void c(String userName) {
        this.am = userName;
    }

    @Override // com.sigmob.sdk.archives.a
    public boolean c() {
        File file = this.as;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.ai == 53) {
            return true;
        }
        return a().endsWith("/");
    }

    @Override // com.sigmob.sdk.archives.a
    public Date d() {
        return j();
    }

    public void d(String groupName) {
        this.an = groupName;
    }

    public String e() {
        return this.aj.toString();
    }

    public boolean equals(Object it) {
        if (it == null || getClass() != it.getClass()) {
            return false;
        }
        return a((a) it);
    }

    public int f() {
        return this.ae;
    }

    public int g() {
        return this.af;
    }

    public String h() {
        return this.am.toString();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String i() {
        return this.an.toString();
    }

    public Date j() {
        return new Date(this.ah * 1000);
    }

    public File k() {
        return this.as;
    }

    public int l() {
        return this.ad;
    }

    public boolean m() {
        return this.aq;
    }

    public long n() {
        return this.ar;
    }

    public boolean o() {
        return this.ai == 83;
    }

    public boolean p() {
        return this.ai == 76 && this.ac.toString().equals(e.ab);
    }

    public boolean q() {
        byte b2 = this.ai;
        return b2 == 120 || b2 == 88;
    }

    public boolean r() {
        return this.ai == 103;
    }

    public boolean s() {
        File file = this.as;
        if (file != null) {
            return file.isFile();
        }
        byte b2 = this.ai;
        if (b2 == 0 || b2 == 48) {
            return true;
        }
        return !a().endsWith("/");
    }

    public boolean t() {
        return this.ai == 50;
    }

    public boolean u() {
        return this.ai == 49;
    }

    public boolean v() {
        return this.ai == 51;
    }

    public boolean w() {
        return this.ai == 52;
    }

    public boolean x() {
        return this.ai == 54;
    }

    public a[] y() {
        File file = this.as;
        if (file == null || !file.isDirectory()) {
            return new a[0];
        }
        String[] list = this.as.list();
        a[] aVarArr = new a[list.length];
        for (int i = 0; i < list.length; i++) {
            aVarArr[i] = new a(new File(this.as, list[i]));
        }
        return aVarArr;
    }
}
