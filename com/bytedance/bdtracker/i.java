package com.bytedance.bdtracker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class i extends Lambda implements Function1<String, String> {
    public static final i a = new i();

    public i() {
        super(1);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String invoke(String str) {
        return str == null ? "DDL failed" : (str.hashCode() == -1867169789 && str.equals("success")) ? "DDL response data empty" : str;
    }
}
