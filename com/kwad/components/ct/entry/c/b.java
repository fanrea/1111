package com.kwad.components.ct.entry.c;

import com.kwad.components.ct.f.c;
import com.kwad.components.ct.f.d;
import com.kwad.sdk.R;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements com.kwad.components.ct.f.a {
    public static void register() {
        d.Kb().a(b.class, new b());
    }

    public static void a(XmlPullParser xmlPullParser, int i, Map<String, c> map) {
        if (i == 2 && "entryNightStyle".equals(xmlPullParser.getName())) {
            a aVar = new a();
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    aVar.a(xmlPullParser);
                } else if (next == 3 && "entryNightStyle".equals(xmlPullParser.getName())) {
                    map.put("entryNightStyle", aVar);
                }
                next = xmlPullParser.next();
            }
        }
    }

    public final c Ec() {
        if (d.Kb().wR() == 1) {
            d.Kb();
            return d.b("entryNightStyle", Ee());
        }
        d.Kb();
        return d.b("entryStyle", Ed());
    }

    private static c Ed() {
        a aVar = new a();
        aVar.aDq = "#00000000";
        aVar.aDr = "#FF9C9C9C";
        aVar.aDs = "#FF323232";
        aVar.aDt = "#FF323232";
        aVar.aDu = "#FF9C9C9C";
        aVar.aDv = R.drawable.ksad_entrytitle_arrow;
        return aVar;
    }

    private static c Ee() {
        return new a();
    }
}
