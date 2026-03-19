package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class w {
    private final e cjs;
    private final boolean cjt;

    public w(e eVar) {
        this.cjs = eVar;
        if (eVar instanceof f) {
            this.cjt = false;
        } else {
            this.cjt = true;
        }
    }

    private List<? extends t> hZ(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.cjs.at("tEXt", str));
        arrayList.addAll(this.cjs.at("zTXt", str));
        arrayList.addAll(this.cjs.at("iTXt", str));
        return arrayList;
    }

    public final String ia(String str) {
        List<? extends t> listHZ = hZ(str);
        if (listHZ.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = listHZ.iterator();
        while (it.hasNext()) {
            sb.append(it.next().anf()).append("\n");
        }
        return sb.toString().trim();
    }
}
