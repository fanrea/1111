package com.kwai.kanas.vader.persistent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class a {
    private final List<LogRecord> a;
    private final EnumC0655a b;

    /* renamed from: com.kwai.kanas.vader.persistent.a$a, reason: collision with other inner class name */
    public enum EnumC0655a {
        Add,
        Delete,
        Sentinel
    }

    public a(LogRecord logRecord, EnumC0655a enumC0655a) {
        this.a = new ArrayList();
        this.a.add(logRecord);
        this.b = enumC0655a;
    }

    public a(List<LogRecord> list, EnumC0655a enumC0655a) {
        this.a = list;
        this.b = enumC0655a;
    }

    public List<LogRecord> a() {
        return Collections.unmodifiableList(this.a);
    }

    public EnumC0655a b() {
        return this.b;
    }

    public boolean a(a aVar) {
        if (this.b == EnumC0655a.Sentinel || aVar.b == EnumC0655a.Sentinel || this.b != aVar.b) {
            return false;
        }
        this.a.addAll(aVar.a());
        return true;
    }
}
