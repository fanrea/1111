package com.kwad.framework.tachikoma.gen;

import com.tk.core.manager.IProviderCollector;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class TKProviderCollector implements IProviderCollector {
    @Override // com.tk.core.manager.IProviderCollector
    public final ArrayList<com.tk.core.manager.b> collectProviders() {
        ArrayList<com.tk.core.manager.b> arrayList = new ArrayList<>();
        arrayList.add(new a());
        arrayList.add(new b());
        return arrayList;
    }
}
