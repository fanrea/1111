package com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888;

import com.netease.htprotect.p010Ooo.p014o0o0.Oo0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.netease.htprotect.〇Ooo.〇o0〇o0.O8〇oO8〇88.〇oO, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class oO {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private String f395O8oO888;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private Oo0 f396O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private short f397Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private Oo0 f398o0o0;

    /* renamed from: 〇oO, reason: contains not printable characters */
    private Map f399oO = new HashMap();
    private Map Oo0 = new HashMap();

    public oO(O8oO888 o8oO888) {
        this.f395O8oO888 = o8oO888.m832oO();
        this.f397Ooo = (short) o8oO888.m830o0o0();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m916O8oO888(String str) {
        this.f395O8oO888 = str;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m917O8oO888(Map map) {
        this.f399oO = map;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private void m918O8oO888(short s) {
        this.f397Ooo = s;
    }

    private Map Oo0() {
        return this.Oo0;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private void m919Ooo(Map map) {
        this.Oo0 = map;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private String m920o0o0() {
        return this.f395O8oO888;
    }

    /* renamed from: 〇oO, reason: contains not printable characters */
    private Map m921oO() {
        return this.f399oO;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final OO8 m922O8oO888(Short sh) {
        return (OO8) this.f399oO.get(sh);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final short m923O8oO888() {
        return this.f397Ooo;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m924O8oO888(OO8 oo8) {
        this.f399oO.put(Short.valueOf(oo8.m840Ooo()), oo8);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m925O8oO888(C0679 c0679) {
        List arrayList = (List) this.Oo0.get(Short.valueOf(c0679.m947O8oO888()));
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.Oo0.put(Short.valueOf(c0679.m947O8oO888()), arrayList);
        }
        arrayList.add(c0679);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void m926O8oO888(Oo0 oo0) {
        this.f396O8 = oo0;
    }

    /* renamed from: 〇O8, reason: contains not printable characters */
    public final Oo0 m927O8() {
        return this.f398o0o0;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final Oo0 m928Ooo() {
        return this.f396O8;
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final List m929Ooo(Short sh) {
        return (List) this.Oo0.get(sh);
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    public final void m930Ooo(Oo0 oo0) {
        this.f398o0o0 = oo0;
    }
}
