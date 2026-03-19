package com.netease.htprotect.p010Ooo;

import com.netease.htprotect.p010Ooo.p012O8.C0677;
import com.netease.htprotect.p010Ooo.p012O8.Ooo;
import com.netease.htprotect.p010Ooo.p012O8.o0O0O;
import com.netease.htprotect.p010Ooo.p013Ooo.O8;
import com.netease.htprotect.p010Ooo.p013Ooo.o0o0;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.Oo0;
import com.netease.htprotect.p010Ooo.p017oO.O;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.netease.htprotect.〇Ooo.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 implements Closeable {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final Locale f251O8oO888 = Locale.CHINA;
    private Set Oo0;

    /* renamed from: 〇O, reason: contains not printable characters */
    private final ZipFile f252O;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private O8 f253O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private Oo0 f254Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private String f255o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private o0o0 f256oO;

    /* renamed from: 〇o〇0O〇0O, reason: contains not printable characters */
    private Locale f257o0O0O = f251O8oO888;

    /* renamed from: com.netease.htprotect.〇Ooo.O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
    public static class C0676O8oO888 extends RuntimeException {
        public C0676O8oO888(String str, Throwable th) {
            super(str, th);
        }
    }

    private O8oO888(File file) throws C0676O8oO888 {
        try {
            this.f252O = new ZipFile(file);
        } catch (IOException e) {
            throw new C0676O8oO888(String.format("Invalid APK: %s", file.getAbsolutePath()), e);
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static O8oO888 m721O8oO888(String str) {
        return new O8oO888(new File(str));
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m722O8oO888(String str, o0O0O o0o0o) throws IOException, NumberFormatException {
        ZipEntry entry = this.f252O.getEntry(str);
        if (entry == null) {
            return;
        }
        if (this.f254Ooo == null) {
            Oo0();
        }
        Ooo ooo = new Ooo(ByteBuffer.wrap(O.m1059O8oO888(this.f252O.getInputStream(entry))), this.f254Ooo);
        ooo.m752O8oO888(this.f257o0O0O);
        ooo.m751O8oO888(o0o0o);
        ooo.m750O8oO888();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m723O8oO888(Locale locale) {
        Locale locale2 = this.f257o0O0O;
        if (locale2 == null ? locale == null : locale2.equals(locale)) {
            return;
        }
        this.f257o0O0O = locale;
        this.f255o0o0 = null;
        this.f256oO = null;
    }

    private void Oo0() throws IOException {
        Set setM757O8;
        ZipEntry entry = this.f252O.getEntry(com.netease.htprotect.p010Ooo.p014o0o0.O8oO888.f342O8oO888);
        if (entry == null) {
            this.f254Ooo = new Oo0();
            setM757O8 = Collections.emptySet();
        } else {
            this.f254Ooo = new Oo0();
            this.Oo0 = Collections.emptySet();
            com.netease.htprotect.p010Ooo.p012O8.o0o0 o0o0Var = new com.netease.htprotect.p010Ooo.p012O8.o0o0(ByteBuffer.wrap(O.m1059O8oO888(this.f252O.getInputStream(entry))));
            o0o0Var.m756O8oO888();
            this.f254Ooo = o0o0Var.m758Ooo();
            setM757O8 = o0o0Var.m757O8();
        }
        this.Oo0 = setM757O8;
    }

    /* renamed from: 〇O, reason: contains not printable characters */
    private Locale m724O() {
        return this.f257o0O0O;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    private Set m725O8() throws IOException {
        if (this.Oo0 == null) {
            Oo0();
        }
        return this.Oo0;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private void m726o0o0() throws IOException, NumberFormatException {
        if (this.f255o0o0 == null) {
            m727oO();
        }
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private void m727oO() throws IOException, NumberFormatException {
        C0677 c0677 = new C0677();
        com.netease.htprotect.p010Ooo.p012O8.O8oO888 o8oO888 = new com.netease.htprotect.p010Ooo.p012O8.O8oO888();
        m722O8oO888(com.netease.htprotect.p010Ooo.p014o0o0.O8oO888.f344Ooo, new com.netease.htprotect.p010Ooo.p012O8.O8(c0677, o8oO888));
        String strM761O8oO888 = c0677.m761O8oO888();
        this.f255o0o0 = strM761O8oO888;
        if (strM761O8oO888 == null) {
            throw new com.netease.htprotect.p010Ooo.p011O8oO888.O8oO888("manifest xml not exists");
        }
        this.f256oO = o8oO888.m730O8oO888();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final O8 m728O8oO888() throws IOException, ParseException {
        if (this.f253O8 == null) {
            this.f253O8 = new O8(m729Ooo(), this.f255o0o0);
        }
        return this.f253O8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f254Ooo = null;
        try {
            this.f252O.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final o0o0 m729Ooo() throws IOException, NumberFormatException {
        if (this.f256oO == null) {
            m726o0o0();
        }
        return this.f256oO;
    }
}
