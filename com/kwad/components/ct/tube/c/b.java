package com.kwad.components.ct.tube.c;

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
        if (i == 2 && "tubeNightStyle".equals(xmlPullParser.getName())) {
            a aVar = new a();
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    aVar.a(xmlPullParser);
                } else if (next == 3 && "tubeNightStyle".equals(xmlPullParser.getName())) {
                    map.put("tubeNightStyle", aVar);
                }
                next = xmlPullParser.next();
            }
        }
    }

    public final a Lc() {
        if (d.Kb().wR() == 1) {
            d.Kb();
            return (a) d.b("tubeNightStyle", Ee());
        }
        d.Kb();
        return (a) d.b("tubeStyle", Ed());
    }

    private static c Ed() {
        a aVar = new a();
        aVar.aZc = "#FFFFFF";
        aVar.aZd = "#222222";
        aVar.aZe = "#666666";
        aVar.aZf = "#EAEAEA";
        aVar.aZg = "#FFFFFF";
        aVar.aZh = "#F8F8F8";
        aVar.aZi = "#222222";
        aVar.aZj = "#9C9C9C";
        aVar.aZk = "#9C9C9C";
        aVar.aZl = "#FFFFFF";
        aVar.aZm = "#222222";
        aVar.aZn = "#E0E0E0";
        aVar.aZo = "#222222";
        aVar.aZp = "#9C9C9C";
        aVar.aZq = "#222222";
        aVar.aZr = "#9C9C9C";
        aVar.aZv = R.color.ksad_tube_pannel_tab_color;
        aVar.aZt = R.drawable.ksad_tube_pannel_item_view_count_icon;
        aVar.aZu = R.drawable.ksad_tube_pannel_collapse_arrow;
        aVar.aZw = R.drawable.ksad_tube_page_back_icon;
        aVar.aZx = R.drawable.ksad_tube_channel_enter_icon;
        return aVar;
    }

    private static c Ee() {
        return new a();
    }
}
