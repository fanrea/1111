package com.bytedance.sdk.component.b.hc.d.tt;

import javax.security.auth.x500.X500Principal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class c {
    private int an;
    private int b;
    private int c;
    private final String d;
    private char[] h;
    private final int hc;
    private int u;

    c(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.d = name;
        this.hc = name.length();
    }

    private String d() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c3;
        while (true) {
            i = this.b;
            i2 = this.hc;
            if (i >= i2 || this.h[i] != ' ') {
                break;
            }
            this.b = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.c = i;
        this.b = i + 1;
        while (true) {
            i3 = this.b;
            i4 = this.hc;
            if (i3 >= i4 || (c3 = this.h[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.b = i3 + 1;
        }
        if (i3 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.d);
        }
        this.u = i3;
        if (this.h[i3] == ' ') {
            while (true) {
                i6 = this.b;
                i7 = this.hc;
                if (i6 >= i7 || (c2 = this.h[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.b = i6 + 1;
            }
            if (this.h[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.d);
            }
        }
        do {
            i5 = this.b + 1;
            this.b = i5;
            if (i5 >= this.hc) {
                break;
            }
        } while (this.h[i5] == ' ');
        int i8 = this.u;
        int i9 = this.c;
        if (i8 - i9 > 4) {
            char[] cArr = this.h;
            if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && ((cArr[i9 + 1] == 'I' || cArr[i9 + 1] == 'i') && (cArr[i9 + 2] == 'D' || cArr[i9 + 2] == 'd')))) {
                this.c = i9 + 4;
            }
        }
        char[] cArr2 = this.h;
        int i10 = this.c;
        return new String(cArr2, i10, this.u - i10);
    }

    private String hc() {
        int i = this.b + 1;
        this.b = i;
        this.c = i;
        this.u = i;
        while (true) {
            int i2 = this.b;
            if (i2 == this.hc) {
                throw new IllegalStateException("Unexpected end of DN: " + this.d);
            }
            char[] cArr = this.h;
            char c = cArr[i2];
            if (c == '\"') {
                this.b = i2 + 1;
                while (true) {
                    int i3 = this.b;
                    if (i3 >= this.hc || this.h[i3] != ' ') {
                        break;
                    }
                    this.b = i3 + 1;
                }
                char[] cArr2 = this.h;
                int i4 = this.c;
                return new String(cArr2, i4, this.u - i4);
            }
            if (c == '\\') {
                cArr[this.u] = u();
            } else {
                cArr[this.u] = c;
            }
            this.b++;
            this.u++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.u = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b() {
        /*
            r6 = this;
            int r0 = r6.b
            int r1 = r0 + 4
            int r2 = r6.hc
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L96
            r6.c = r0
            int r0 = r0 + 1
            r6.b = r0
        L10:
            int r0 = r6.b
            int r1 = r6.hc
            if (r0 == r1) goto L54
            char[] r1 = r6.h
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L54
            r4 = 44
            if (r2 == r4) goto L54
            r4 = 59
            if (r2 != r4) goto L27
            goto L54
        L27:
            r4 = 32
            if (r2 != r4) goto L42
            r6.u = r0
            int r0 = r0 + 1
            r6.b = r0
        L31:
            int r0 = r6.b
            int r1 = r6.hc
            if (r0 >= r1) goto L56
            char[] r1 = r6.h
            char r1 = r1[r0]
            if (r1 != r4) goto L56
            int r0 = r0 + 1
            r6.b = r0
            goto L31
        L42:
            r4 = 65
            if (r2 < r4) goto L4f
            r4 = 70
            if (r2 > r4) goto L4f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L4f:
            int r0 = r0 + 1
            r6.b = r0
            goto L10
        L54:
            r6.u = r0
        L56:
            int r0 = r6.u
            int r1 = r6.c
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L81
            r2 = r0 & 1
            if (r2 == 0) goto L81
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            r4 = 0
            int r1 = r1 + 1
        L69:
            if (r4 >= r2) goto L77
            int r5 = r6.d(r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L69
        L77:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.h
            int r3 = r6.c
            r1.<init>(r2, r3, r0)
            return r1
        L81:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.d
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L96:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.d
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.tt.c.b():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r1 = r8.h;
        r2 = r8.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        return new java.lang.String(r1, r2, r8.u - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c() {
        /*
            r8 = this;
            int r0 = r8.b
            r8.c = r0
            r8.u = r0
        L6:
            int r0 = r8.b
            int r1 = r8.hc
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.h
            int r2 = r8.c
            int r3 = r8.u
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.h
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5e
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.u
            int r4 = r3 + 1
            r8.u = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.b = r0
            goto L6
        L3e:
            int r0 = r8.u
            int r2 = r0 + 1
            r8.u = r2
            char r2 = r8.u()
            r1[r0] = r2
            int r0 = r8.b
            int r0 = r0 + 1
            r8.b = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.h
            int r2 = r8.c
            int r3 = r8.u
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.u
            r8.an = r2
            int r0 = r0 + 1
            r8.b = r0
            int r0 = r2 + 1
            r8.u = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.b
            int r1 = r8.hc
            if (r0 >= r1) goto L85
            char[] r2 = r8.h
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.u
            int r7 = r1 + 1
            r8.u = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.b = r0
            goto L6c
        L85:
            if (r0 == r1) goto L91
            char[] r1 = r8.h
            char r0 = r1[r0]
            if (r0 == r3) goto L91
            if (r0 == r4) goto L91
            if (r0 != r5) goto L6
        L91:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.h
            int r2 = r8.c
            int r3 = r8.an
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.tt.c.c():java.lang.String");
    }

    private char u() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.hc) {
            throw new IllegalStateException("Unexpected end of DN: " + this.d);
        }
        char c = this.h[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return an();
                }
        }
    }

    private char an() {
        int i;
        int i2;
        int iD = d(this.b);
        this.b++;
        if (iD < 128) {
            return (char) iD;
        }
        if (iD < 192 || iD > 247) {
            return '?';
        }
        if (iD <= 223) {
            i2 = iD & 31;
            i = 1;
        } else if (iD <= 239) {
            i = 2;
            i2 = iD & 15;
        } else {
            i = 3;
            i2 = iD & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.b + 1;
            this.b = i4;
            if (i4 == this.hc || this.h[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.b = i5;
            int iD2 = d(i5);
            this.b++;
            if ((iD2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (iD2 & 63);
        }
        return (char) i2;
    }

    private int d(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.hc) {
            throw new IllegalStateException("Malformed DN: " + this.d);
        }
        char[] cArr = this.h;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.d);
            }
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.d);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public String d(String str) {
        String strHc;
        this.b = 0;
        this.c = 0;
        this.u = 0;
        this.an = 0;
        this.h = this.d.toCharArray();
        String strD = d();
        if (strD == null) {
            return null;
        }
        do {
            int i = this.b;
            if (i == this.hc) {
                return null;
            }
            char c = this.h[i];
            if (c == '\"') {
                strHc = hc();
            } else if (c == '#') {
                strHc = b();
            } else {
                strHc = (c == '+' || c == ',' || c == ';') ? "" : c();
            }
            if (str.equalsIgnoreCase(strD)) {
                return strHc;
            }
            int i2 = this.b;
            if (i2 >= this.hc) {
                return null;
            }
            char c2 = this.h[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.d);
            }
            this.b = i2 + 1;
            strD = d();
        } while (strD != null);
        throw new IllegalStateException("Malformed DN: " + this.d);
    }
}
