package com.kwad.framework.filedownloader.a;

import com.just.agentweb.AgentWebPermissions;
import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    private static boolean dk(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    public static b a(Map<String, List<String>> map, b bVar, List<String> list) throws IllegalAccessException {
        int responseCode = bVar.getResponseCode();
        String strCp = bVar.cp(AgentWebPermissions.ACTION_LOCATION);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (dk(responseCode)) {
            if (strCp == null) {
                throw new IllegalAccessException(f.c("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.Nn()));
            }
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", strCp, Integer.valueOf(responseCode), arrayList);
            }
            bVar.No();
            bVar = a(map, strCp);
            arrayList.add(strCp);
            bVar.execute();
            responseCode = bVar.getResponseCode();
            strCp = bVar.cp(AgentWebPermissions.ACTION_LOCATION);
            i++;
            if (i >= 10) {
                throw new IllegalAccessException(f.c("redirect too many times! %s", arrayList));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b bVarCt = com.kwad.framework.filedownloader.download.b.Ny().ct(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVarCt.addHeader(key, it.next());
                }
            }
        }
        return bVarCt;
    }
}
