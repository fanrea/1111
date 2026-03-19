package io.netty.util.internal;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AppendableCharSequence implements Appendable, CharSequence {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("length: " + i + " (length: >= 1)");
        }
        this.chars = new char[i];
    }

    private AppendableCharSequence(char[] cArr) {
        if (cArr.length <= 0) {
            throw new IllegalArgumentException("length: " + cArr.length + " (length: >= 1)");
        }
        this.chars = cArr;
        this.pos = cArr.length;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.pos;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        if (i > this.pos) {
            throw new IndexOutOfBoundsException();
        }
        return this.chars[i];
    }

    public final char charAtUnsafe(int i) {
        return this.chars[i];
    }

    @Override // java.lang.CharSequence
    public final AppendableCharSequence subSequence(int i, int i2) {
        return new AppendableCharSequence(Arrays.copyOfRange(this.chars, i, i2));
    }

    @Override // java.lang.Appendable
    public final AppendableCharSequence append(char c) {
        try {
            char[] cArr = this.chars;
            int i = this.pos;
            this.pos = i + 1;
            cArr[i] = c;
        } catch (IndexOutOfBoundsException unused) {
            expand();
            this.chars[this.pos - 1] = c;
        }
        return this;
    }

    @Override // java.lang.Appendable
    public final AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public final AppendableCharSequence append(CharSequence charSequence, int i, int i2) {
        if (charSequence.length() < i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        char[] cArr = this.chars;
        int length = cArr.length;
        int i4 = this.pos;
        if (i3 > length - i4) {
            this.chars = expand(cArr, i4 + i3, i4);
        }
        if (charSequence instanceof AppendableCharSequence) {
            System.arraycopy(((AppendableCharSequence) charSequence).chars, i, this.chars, this.pos, i3);
            this.pos += i3;
            return this;
        }
        while (i < i2) {
            char[] cArr2 = this.chars;
            int i5 = this.pos;
            this.pos = i5 + 1;
            cArr2[i5] = charSequence.charAt(i);
            i++;
        }
        return this;
    }

    public final void reset() {
        this.pos = 0;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return new String(this.chars, 0, this.pos);
    }

    public final String substring(int i, int i2) {
        int i3 = i2 - i;
        int i4 = this.pos;
        if (i > i4 || i3 > i4) {
            throw new IndexOutOfBoundsException();
        }
        return new String(this.chars, i, i3);
    }

    public final String subStringUnsafe(int i, int i2) {
        return new String(this.chars, i, i2 - i);
    }

    private void expand() {
        char[] cArr = this.chars;
        int length = cArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        this.chars = new char[length];
        System.arraycopy(cArr, 0, this.chars, 0, cArr.length);
    }

    private static char[] expand(char[] cArr, int i, int i2) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i2);
        return cArr2;
    }
}
