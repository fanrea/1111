package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f {
    public static JSONArray Wp() throws NoSuchMethodException, SecurityException {
        Context context = ServiceProvider.getContext();
        List<g> listBy = by(context);
        listBy.add(bx(context));
        return g.af(listBy);
    }

    private static g bx(Context context) {
        boolean zEc = au.ec(context);
        com.kwad.sdk.core.d.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + zEc);
        return new g(com.kuaishou.weapon.p0.g.k, zEc ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    private static List<g> by(Context context) throws NoSuchMethodException, SecurityException {
        String[] strArrDl;
        int i;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (context != null && (strArrDl = y.dl(context)) != null) {
            for (String str : strArrDl) {
                int iAI = au.aI(context, str);
                if (iAI == 0) {
                    i = g.PERMISSION_GRANTED;
                } else if (iAI == -1) {
                    i = g.PERMISSION_DENIED;
                } else {
                    i = g.btv;
                }
                copyOnWriteArrayList.add(new g(str, i));
            }
        }
        return copyOnWriteArrayList;
    }
}
