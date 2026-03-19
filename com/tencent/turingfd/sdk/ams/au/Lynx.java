package com.tencent.turingfd.sdk.ams.au;

import android.os.LocaleList;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Lynx implements Leo {
    public final LocaleList a;

    public Lynx(Object obj) {
        this.a = (LocaleList) obj;
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Leo
    public Locale a(int i) {
        return this.a.get(i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Leo
    public int a() {
        return this.a.size();
    }
}
