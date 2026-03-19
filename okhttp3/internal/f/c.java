package okhttp3.internal.f;

import javax.security.auth.x500.X500Principal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class c {
    private final String DM;
    private int DN;
    private int DO;
    private char[] chars;
    private int end;
    private final int length;
    private int pos;

    public c(X500Principal x500Principal) {
        this.DM = x500Principal.getName("RFC2253");
        this.length = this.DM.length();
    }

    private String hn() {
        int i;
        while (true) {
            int i2 = this.pos;
            if (i2 >= this.length || this.chars[i2] != ' ') {
                break;
            }
            this.pos = i2 + 1;
        }
        int i3 = this.pos;
        if (i3 == this.length) {
            return null;
        }
        this.DN = i3;
        this.pos = i3 + 1;
        while (true) {
            int i4 = this.pos;
            if (i4 >= this.length) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.pos = i4 + 1;
        }
        int i5 = this.pos;
        if (i5 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.DM);
        }
        this.end = i5;
        if (this.chars[i5] == ' ') {
            while (true) {
                int i6 = this.pos;
                if (i6 >= this.length) {
                    break;
                }
                char[] cArr2 = this.chars;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.pos = i6 + 1;
            }
            char[] cArr3 = this.chars;
            int i7 = this.pos;
            if (cArr3[i7] != '=' || i7 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.DM);
            }
        }
        do {
            this.pos++;
            i = this.pos;
            if (i >= this.length) {
                break;
            }
        } while (this.chars[i] == ' ');
        int i8 = this.end;
        int i9 = this.DN;
        if (i8 - i9 > 4) {
            char[] cArr4 = this.chars;
            if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                char[] cArr5 = this.chars;
                int i10 = this.DN;
                if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                    char[] cArr6 = this.chars;
                    int i11 = this.DN;
                    if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                        this.DN += 4;
                    }
                }
            }
        }
        char[] cArr7 = this.chars;
        int i12 = this.DN;
        return new String(cArr7, i12, this.end - i12);
    }

    private String ho() {
        this.pos++;
        this.DN = this.pos;
        this.end = this.DN;
        while (true) {
            int i = this.pos;
            if (i == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.DM);
            }
            char[] cArr = this.chars;
            if (cArr[i] == '\"') {
                this.pos = i + 1;
                while (true) {
                    int i2 = this.pos;
                    if (i2 >= this.length || this.chars[i2] != ' ') {
                        break;
                    }
                    this.pos = i2 + 1;
                }
                char[] cArr2 = this.chars;
                int i3 = this.DN;
                return new String(cArr2, i3, this.end - i3);
            }
            if (cArr[i] == '\\') {
                cArr[this.end] = hr();
            } else {
                cArr[this.end] = cArr[i];
            }
            this.pos++;
            this.end++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r6.end = r6.pos;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String hp() {
        /*
            r6 = this;
            int r0 = r6.pos
            int r1 = r0 + 4
            int r2 = r6.length
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto La5
            r6.DN = r0
            int r0 = r0 + 1
            r6.pos = r0
        L10:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 == r1) goto L61
            char[] r1 = r6.chars
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 44
            if (r2 == r4) goto L61
            char r2 = r1[r0]
            r4 = 59
            if (r2 != r4) goto L2b
            goto L61
        L2b:
            char r2 = r1[r0]
            r4 = 32
            if (r2 != r4) goto L48
            r6.end = r0
            int r0 = r0 + 1
            r6.pos = r0
        L37:
            int r0 = r6.pos
            int r1 = r6.length
            if (r0 >= r1) goto L65
            char[] r1 = r6.chars
            char r1 = r1[r0]
            if (r1 != r4) goto L65
            int r0 = r0 + 1
            r6.pos = r0
            goto L37
        L48:
            char r2 = r1[r0]
            r5 = 65
            if (r2 < r5) goto L5a
            char r2 = r1[r0]
            r5 = 70
            if (r2 > r5) goto L5a
            char r2 = r1[r0]
            int r2 = r2 + r4
            char r2 = (char) r2
            r1[r0] = r2
        L5a:
            int r0 = r6.pos
            int r0 = r0 + 1
            r6.pos = r0
            goto L10
        L61:
            int r0 = r6.pos
            r6.end = r0
        L65:
            int r0 = r6.end
            int r1 = r6.DN
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L91
            r2 = r0 & 1
            if (r2 == 0) goto L91
            int r2 = r0 / 2
            byte[] r2 = new byte[r2]
            r3 = 0
            int r1 = r1 + 1
        L78:
            int r4 = r2.length
            if (r3 >= r4) goto L87
            int r4 = r6.bI(r1)
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 2
            int r3 = r3 + 1
            goto L78
        L87:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.chars
            int r3 = r6.DN
            r1.<init>(r2, r3, r0)
            return r1
        L91:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.DM
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.DM
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            goto Lba
        Lb9:
            throw r0
        Lba:
            goto Lb9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.f.c.hp():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r1 = r8.chars;
        r2 = r8.DN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return new java.lang.String(r1, r2, r8.end - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String hq() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.DN = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.DN
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.end
            int r3 = r2 + 1
            r8.end = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L40:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.hr()
            r1[r0] = r2
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.DN
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.end
            r8.DO = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L87
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.end
            int r7 = r2 + 1
            r8.end = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L6e
        L87:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 == r1) goto L9b
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.DN
            int r3 = r8.DO
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.f.c.hq():java.lang.String");
    }

    private char hr() {
        this.pos++;
        int i = this.pos;
        if (i == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.DM);
        }
        char c = this.chars[i];
        if (c != ' ' && c != '%' && c != '\\' && c != '_' && c != '\"' && c != '#') {
            switch (c) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return hs();
                    }
            }
        }
        return this.chars[this.pos];
    }

    private char hs() {
        int i;
        int i2;
        int iBI = bI(this.pos);
        this.pos++;
        if (iBI < 128) {
            return (char) iBI;
        }
        if (iBI < 192 || iBI > 247) {
            return '?';
        }
        if (iBI <= 223) {
            i2 = iBI & 31;
            i = 1;
        } else if (iBI <= 239) {
            i = 2;
            i2 = iBI & 15;
        } else {
            i = 3;
            i2 = iBI & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.pos++;
            int i4 = this.pos;
            if (i4 == this.length || this.chars[i4] != '\\') {
                return '?';
            }
            this.pos = i4 + 1;
            int iBI2 = bI(this.pos);
            this.pos++;
            if ((iBI2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (iBI2 & 63);
        }
        return (char) i2;
    }

    private int bI(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.DM);
        }
        char c = this.chars[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.DM);
            }
            i2 = c - '7';
        }
        char c2 = this.chars[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.DM);
            }
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public final String G(String str) {
        String strHo;
        this.pos = 0;
        this.DN = 0;
        this.end = 0;
        this.DO = 0;
        this.chars = this.DM.toCharArray();
        String strHn = hn();
        if (strHn == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.chars[i];
            if (c == '\"') {
                strHo = ho();
            } else if (c == '#') {
                strHo = hp();
            } else {
                strHo = (c == '+' || c == ',' || c == ';') ? "" : hq();
            }
            if (str.equalsIgnoreCase(strHn)) {
                return strHo;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.DM);
            }
            this.pos++;
            strHn = hn();
        } while (strHn != null);
        throw new IllegalStateException("Malformed DN: " + this.DM);
    }
}
