package com.kwad.components.ct.hotspot.b;

import com.kwad.components.ct.f.c;
import com.kwad.components.ct.f.d;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements com.kwad.components.ct.f.a {
    public static void register() {
        d.Kb().a(b.class, new b());
    }

    public static void a(XmlPullParser xmlPullParser, int i, Map<String, c> map) {
        if (i == 2 && "hotspotNightStyle".equals(xmlPullParser.getName())) {
            a aVar = new a();
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    aVar.a(xmlPullParser);
                } else if (next == 3 && "hotspotNightStyle".equals(xmlPullParser.getName())) {
                    map.put("hotspotNightStyle", aVar);
                }
                next = xmlPullParser.next();
            }
        }
    }

    public final a IS() {
        if (d.Kb().wR() == 1) {
            d.Kb();
            return (a) d.b("hotspotNightStyle", IU());
        }
        d.Kb();
        return (a) d.b("hotspotStyle", IT());
    }

    private static a IT() {
        a aVar = new a();
        aVar.aDq = "#00000000";
        aVar.aQk = "#80000000";
        aVar.aQl = "#FF222222";
        aVar.aQm = "#FF9C9C9C";
        aVar.aQn = "#FF9C9C9C";
        return aVar;
    }

    public static a IU() {
        return new a();
    }
}
