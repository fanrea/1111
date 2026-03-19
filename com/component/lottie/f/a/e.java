package com.component.lottie.f.a;

import com.bytedance.sdk.djx.core.log.ILogConst;
import com.component.lottie.e.j;
import com.component.lottie.f.a.c;
import io.netty.util.internal.StringUtil;
import java.io.EOFException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class e extends c {
    private static final int A = 14;
    private static final int B = 15;
    private static final int C = 16;
    private static final int D = 17;
    private static final int E = 18;
    private static final int F = 0;
    private static final int G = 1;
    private static final int H = 2;
    private static final int I = 3;
    private static final int J = 4;

    /* renamed from: K, reason: collision with root package name */
    private static final int f760K = 5;
    private static final int L = 6;
    private static final int M = 7;
    private static final long g = -922337203685477580L;
    private static final j h = j.a("'\\");
    private static final j i = j.a("\"\\");
    private static final j j = j.a("{}[]:, \n\t\r\f/\\;#=");
    private static final j k = j.a("\n\r");
    private static final j l = j.a("*/");
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private static final int q = 4;
    private static final int r = 5;
    private static final int s = 6;
    private static final int t = 7;
    private static final int u = 8;
    private static final int v = 9;
    private static final int w = 10;
    private static final int x = 11;
    private static final int y = 12;
    private static final int z = 13;
    private final com.component.lottie.e.i N;
    private final com.component.lottie.e.e O;
    private int P = 0;
    private long Q;
    private int R;
    private String S;

    e(com.component.lottie.e.i iVar) {
        if (iVar == null) {
            throw new NullPointerException("source == null");
        }
        this.N = iVar;
        this.O = iVar.d();
        a(6);
    }

    @Override // com.component.lottie.f.a.c
    public void a() throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 3) {
            a(1);
            this.d[this.a - 1] = 0;
            this.P = 0;
            return;
        }
        throw new a("Expected BEGIN_ARRAY but was " + f() + " at path " + n());
    }

    @Override // com.component.lottie.f.a.c
    public void b() throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 4) {
            this.a--;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.P = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + f() + " at path " + n());
    }

    @Override // com.component.lottie.f.a.c
    public void c() throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 1) {
            a(3);
            this.P = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + f() + " at path " + n());
    }

    @Override // com.component.lottie.f.a.c
    public void d() throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 2) {
            this.a--;
            this.c[this.a] = null;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            this.P = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + f() + " at path " + n());
    }

    @Override // com.component.lottie.f.a.c
    public boolean e() throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        return (iO == 2 || iO == 4 || iO == 18) ? false : true;
    }

    @Override // com.component.lottie.f.a.c
    public c.b f() throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        switch (iO) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private int o() throws EOFException, b {
        int i2 = this.b[this.a - 1];
        if (i2 == 1) {
            this.b[this.a - 1] = 2;
        } else if (i2 == 2) {
            int iA = a(true);
            this.O.l();
            switch (iA) {
                case 44:
                    break;
                case 59:
                    t();
                    break;
                case 93:
                    this.P = 4;
                    return 4;
                default:
                    throw a("Unterminated array");
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                this.b[this.a - 1] = 4;
                if (i2 == 5) {
                    int iA2 = a(true);
                    this.O.l();
                    switch (iA2) {
                        case 44:
                            break;
                        case 59:
                            t();
                            break;
                        case 125:
                            this.P = 2;
                            return 2;
                        default:
                            throw a("Unterminated object");
                    }
                }
                int iA3 = a(true);
                switch (iA3) {
                    case 34:
                        this.O.l();
                        this.P = 13;
                        return 13;
                    case 39:
                        this.O.l();
                        t();
                        this.P = 12;
                        return 12;
                    case 125:
                        if (i2 != 5) {
                            this.O.l();
                            this.P = 2;
                            return 2;
                        }
                        throw a("Expected name");
                    default:
                        t();
                        if (b((char) iA3)) {
                            this.P = 14;
                            return 14;
                        }
                        throw a("Expected name");
                }
            }
            if (i2 == 4) {
                this.b[this.a - 1] = 5;
                int iA4 = a(true);
                this.O.l();
                switch (iA4) {
                    case 58:
                        break;
                    case 61:
                        t();
                        if (this.N.b(1L) && this.O.c(0L) == 62) {
                            this.O.l();
                            break;
                        }
                        break;
                    default:
                        throw a("Expected ':'");
                }
            } else if (i2 == 6) {
                this.b[this.a - 1] = 7;
            } else if (i2 == 7) {
                if (a(false) == -1) {
                    this.P = 18;
                    return 18;
                }
                t();
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        switch (a(true)) {
            case 34:
                this.O.l();
                this.P = 9;
                return 9;
            case 39:
                t();
                this.O.l();
                this.P = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.O.l();
                this.P = 3;
                return 3;
            case 93:
                if (i2 == 1) {
                    this.O.l();
                    this.P = 4;
                    return 4;
                }
                break;
            case 123:
                this.O.l();
                this.P = 1;
                return 1;
            default:
                int iP = p();
                if (iP != 0) {
                    return iP;
                }
                int iQ = q();
                if (iQ == 0) {
                    if (!b(this.O.c(0L))) {
                        throw a("Expected value");
                    }
                    t();
                    this.P = 10;
                    return 10;
                }
                return iQ;
        }
        if (i2 == 1 || i2 == 2) {
            t();
            this.P = 7;
            return 7;
        }
        throw a("Unexpected value");
    }

    private int p() throws EOFException {
        String str;
        String str2;
        int i2;
        byte bC = this.O.c(0L);
        if (bC == 116 || bC == 84) {
            str = "true";
            str2 = "TRUE";
            i2 = 5;
        } else if (bC == 102 || bC == 70) {
            str = "false";
            str2 = "FALSE";
            i2 = 6;
        } else {
            if (bC != 110 && bC != 78) {
                return 0;
            }
            str = ILogConst.CACHE_PLAY_REASON_NULL;
            str2 = "NULL";
            i2 = 7;
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.N.b(i4)) {
                return 0;
            }
            byte bC2 = this.O.c(i3);
            if (bC2 != str.charAt(i3) && bC2 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.N.b(length + 1) && b(this.O.c(length))) {
            return 0;
        }
        this.O.i(length);
        this.P = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x009a, code lost:
    
        if (b(r1) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009d, code lost:
    
        if (r6 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
    
        if (r7 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a5, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a7, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ad, code lost:
    
        if (r8 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00af, code lost:
    
        if (r10 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b1, code lost:
    
        if (r10 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b4, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b5, code lost:
    
        r16.Q = r8;
        r16.O.i(r5);
        r16.P = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c1, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c2, code lost:
    
        if (r6 == 2) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c5, code lost:
    
        if (r6 == 4) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c8, code lost:
    
        if (r6 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00cb, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00cc, code lost:
    
        r16.R = r5;
        r16.P = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d2, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00d3, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int q() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.f.a.e.q():int");
    }

    private boolean b(int i2) throws b {
        switch (i2) {
            case 9:
            case 10:
            case 12:
            case 13:
            case 32:
            case 44:
            case 58:
            case 91:
            case 93:
            case 123:
            case 125:
                return false;
            case 35:
            case 47:
            case 59:
            case 61:
            case 92:
                t();
                return false;
            default:
                return true;
        }
    }

    @Override // com.component.lottie.f.a.c
    public String g() throws EOFException, b {
        String strA;
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 14) {
            strA = r();
        } else if (iO == 13) {
            strA = a(i);
        } else if (iO == 12) {
            strA = a(h);
        } else if (iO == 15) {
            strA = this.S;
        } else {
            throw new a("Expected a name but was " + f() + " at path " + n());
        }
        this.P = 0;
        this.c[this.a - 1] = strA;
        return strA;
    }

    @Override // com.component.lottie.f.a.c
    public int a(c.a aVar) throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO < 12 || iO > 15) {
            return -1;
        }
        if (iO == 15) {
            return a(this.S, aVar);
        }
        int iA = this.N.a(aVar.b);
        if (iA != -1) {
            this.P = 0;
            this.c[this.a - 1] = aVar.a[iA];
            return iA;
        }
        String str = this.c[this.a - 1];
        String strG = g();
        int iA2 = a(strG, aVar);
        if (iA2 == -1) {
            this.P = 15;
            this.S = strG;
            this.c[this.a - 1] = str;
        }
        return iA2;
    }

    @Override // com.component.lottie.f.a.c
    public void h() throws EOFException, b {
        if (this.f) {
            throw new a("Cannot skip unexpected " + f() + " at " + n());
        }
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 14) {
            s();
        } else if (iO == 13) {
            b(i);
        } else if (iO == 12) {
            b(h);
        } else if (iO != 15) {
            throw new a("Expected a name but was " + f() + " at path " + n());
        }
        this.P = 0;
        this.c[this.a - 1] = ILogConst.CACHE_PLAY_REASON_NULL;
    }

    private int a(String str, c.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.P = 0;
                this.c[this.a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    @Override // com.component.lottie.f.a.c
    public String i() throws EOFException, b {
        String strE;
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 10) {
            strE = r();
        } else if (iO == 9) {
            strE = a(i);
        } else if (iO == 8) {
            strE = a(h);
        } else if (iO == 11) {
            strE = this.S;
            this.S = null;
        } else if (iO == 16) {
            strE = Long.toString(this.Q);
        } else if (iO == 17) {
            strE = this.O.e(this.R);
        } else {
            throw new a("Expected a string but was " + f() + " at path " + n());
        }
        this.P = 0;
        int[] iArr = this.d;
        int i2 = this.a - 1;
        iArr[i2] = iArr[i2] + 1;
        return strE;
    }

    @Override // com.component.lottie.f.a.c
    public boolean j() throws EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 5) {
            this.P = 0;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iO == 6) {
            this.P = 0;
            int[] iArr2 = this.d;
            int i3 = this.a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new a("Expected a boolean but was " + f() + " at path " + n());
    }

    @Override // com.component.lottie.f.a.c
    public double k() throws NumberFormatException, EOFException, b {
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 16) {
            this.P = 0;
            int[] iArr = this.d;
            int i2 = this.a - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.Q;
        }
        if (iO == 17) {
            this.S = this.O.e(this.R);
        } else if (iO == 9) {
            this.S = a(i);
        } else if (iO == 8) {
            this.S = a(h);
        } else if (iO == 10) {
            this.S = r();
        } else if (iO != 11) {
            throw new a("Expected a double but was " + f() + " at path " + n());
        }
        this.P = 11;
        try {
            double d = Double.parseDouble(this.S);
            if (!this.e && (Double.isNaN(d) || Double.isInfinite(d))) {
                throw new b("JSON forbids NaN and infinities: " + d + " at path " + n());
            }
            this.S = null;
            this.P = 0;
            int[] iArr2 = this.d;
            int i3 = this.a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return d;
        } catch (NumberFormatException e) {
            throw new a("Expected a double but was " + this.S + " at path " + n());
        }
    }

    private String a(j jVar) throws b {
        StringBuilder sb = null;
        while (true) {
            long jC = this.N.c(jVar);
            if (jC == -1) {
                throw a("Unterminated string");
            }
            if (this.O.c(jC) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.O.e(jC));
                this.O.l();
                sb.append(w());
            } else {
                if (sb == null) {
                    String strE = this.O.e(jC);
                    this.O.l();
                    return strE;
                }
                sb.append(this.O.e(jC));
                this.O.l();
                return sb.toString();
            }
        }
    }

    private String r() {
        long jC = this.N.c(j);
        return jC != -1 ? this.O.e(jC) : this.O.v();
    }

    private void b(j jVar) throws EOFException, b {
        while (true) {
            long jC = this.N.c(jVar);
            if (jC == -1) {
                throw a("Unterminated string");
            }
            if (this.O.c(jC) == 92) {
                this.O.i(jC + 1);
                w();
            } else {
                this.O.i(jC + 1);
                return;
            }
        }
    }

    private void s() throws EOFException {
        long jC = this.N.c(j);
        com.component.lottie.e.e eVar = this.O;
        if (jC == -1) {
            jC = this.O.b();
        }
        eVar.i(jC);
    }

    @Override // com.component.lottie.f.a.c
    public int l() throws NumberFormatException, EOFException, b {
        String strA;
        int iO = this.P;
        if (iO == 0) {
            iO = o();
        }
        if (iO == 16) {
            int i2 = (int) this.Q;
            if (this.Q != i2) {
                throw new a("Expected an int but was " + this.Q + " at path " + n());
            }
            this.P = 0;
            int[] iArr = this.d;
            int i3 = this.a - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (iO == 17) {
            this.S = this.O.e(this.R);
        } else if (iO == 9 || iO == 8) {
            if (iO == 9) {
                strA = a(i);
            } else {
                strA = a(h);
            }
            this.S = strA;
            try {
                int i4 = Integer.parseInt(this.S);
                this.P = 0;
                int[] iArr2 = this.d;
                int i5 = this.a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException e) {
            }
        } else if (iO != 11) {
            throw new a("Expected an int but was " + f() + " at path " + n());
        }
        this.P = 11;
        try {
            double d = Double.parseDouble(this.S);
            int i6 = (int) d;
            if (i6 != d) {
                throw new a("Expected an int but was " + this.S + " at path " + n());
            }
            this.S = null;
            this.P = 0;
            int[] iArr3 = this.d;
            int i7 = this.a - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        } catch (NumberFormatException e2) {
            throw new a("Expected an int but was " + this.S + " at path " + n());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.P = 0;
        this.b[0] = 8;
        this.a = 1;
        this.O.A();
        this.N.close();
    }

    @Override // com.component.lottie.f.a.c
    public void m() throws EOFException, b {
        if (this.f) {
            throw new a("Cannot skip unexpected " + f() + " at " + n());
        }
        int i2 = 0;
        do {
            int iO = this.P;
            if (iO == 0) {
                iO = o();
            }
            if (iO == 3) {
                a(1);
                i2++;
            } else if (iO == 1) {
                a(3);
                i2++;
            } else if (iO == 4) {
                i2--;
                if (i2 < 0) {
                    throw new a("Expected a value but was " + f() + " at path " + n());
                }
                this.a--;
            } else if (iO == 2) {
                i2--;
                if (i2 < 0) {
                    throw new a("Expected a value but was " + f() + " at path " + n());
                }
                this.a--;
            } else if (iO == 14 || iO == 10) {
                s();
            } else if (iO == 9 || iO == 13) {
                b(i);
            } else if (iO == 8 || iO == 12) {
                b(h);
            } else if (iO == 17) {
                this.O.i(this.R);
            } else if (iO == 18) {
                throw new a("Expected a value but was " + f() + " at path " + n());
            }
            this.P = 0;
        } while (i2 != 0);
        int[] iArr = this.d;
        int i3 = this.a - 1;
        iArr[i3] = iArr[i3] + 1;
        this.c[this.a - 1] = ILogConst.CACHE_PLAY_REASON_NULL;
    }

    private int a(boolean z2) throws EOFException, b {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (this.N.b(i3)) {
                byte bC = this.O.c(i2);
                if (bC == 10 || bC == 32 || bC == 13 || bC == 9) {
                    i2 = i3;
                } else {
                    this.O.i(i3 - 1);
                    if (bC == 47) {
                        if (!this.N.b(2L)) {
                            return bC;
                        }
                        t();
                        switch (this.O.c(1L)) {
                            case 42:
                                this.O.l();
                                this.O.l();
                                if (!v()) {
                                    throw a("Unterminated comment");
                                }
                                i2 = 0;
                                break;
                            case 47:
                                this.O.l();
                                this.O.l();
                                u();
                                i2 = 0;
                                break;
                            default:
                                return bC;
                        }
                    } else if (bC == 35) {
                        t();
                        u();
                        i2 = 0;
                    } else {
                        return bC;
                    }
                }
            } else {
                if (z2) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
        }
    }

    private void t() throws b {
        if (!this.e) {
            throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void u() throws EOFException {
        long jC = this.N.c(k);
        this.O.i(jC != -1 ? jC + 1 : this.O.b());
    }

    private boolean v() throws EOFException {
        long jB = this.N.b(l);
        boolean z2 = jB != -1;
        this.O.i(z2 ? jB + l.k() : this.O.b());
        return z2;
    }

    public String toString() {
        return "JsonReader(" + this.N + ")";
    }

    private char w() throws b, EOFException {
        int i2;
        if (!this.N.b(1L)) {
            throw a("Unterminated escape sequence");
        }
        byte bL = this.O.l();
        switch (bL) {
            case 10:
            case 34:
            case 39:
            case 47:
            case 92:
                return (char) bL;
            case 98:
                return '\b';
            case 102:
                return '\f';
            case 110:
                return '\n';
            case 114:
                return StringUtil.CARRIAGE_RETURN;
            case 116:
                return '\t';
            case 117:
                if (!this.N.b(4L)) {
                    throw new EOFException("Unterminated escape sequence at path " + n());
                }
                char c = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    byte bC = this.O.c(i3);
                    char c2 = (char) (c << 4);
                    if (bC >= 48 && bC <= 57) {
                        i2 = bC - 48;
                    } else if (bC >= 97 && bC <= 102) {
                        i2 = (bC - 97) + 10;
                    } else if (bC >= 65 && bC <= 70) {
                        i2 = (bC - 65) + 10;
                    } else {
                        throw a("\\u" + this.O.e(4L));
                    }
                    c = (char) (c2 + i2);
                }
                this.O.i(4L);
                return c;
            default:
                if (!this.e) {
                    throw a("Invalid escape sequence: \\" + ((char) bL));
                }
                return (char) bL;
        }
    }
}
