package com.kwad.components.ct.feed.b;

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
        if (i == 2 && "feedNightStyle".equals(xmlPullParser.getName())) {
            a aVar = new a();
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next == 2) {
                    aVar.a(xmlPullParser);
                } else if (next == 3 && "feedNightStyle".equals(xmlPullParser.getName())) {
                    map.put("feedNightStyle", aVar);
                }
                next = xmlPullParser.next();
            }
        }
    }

    public final a Fd() {
        if (d.Kb().wR() == 1) {
            d.Kb();
            return (a) d.b("feedNightStyle", Ff());
        }
        d.Kb();
        return (a) d.b("feedStyle", Fe());
    }

    private static a Fe() {
        a aVar = new a();
        aVar.aDq = "#FFFFFFFF";
        aVar.asm = "#FF222222";
        aVar.aDu = "#FF9C9C9C";
        aVar.aDt = "#FF222222";
        aVar.aGc = "#FFFF0063";
        aVar.aGd = R.drawable.ksad_feed_item_covert_btn_idle_bg;
        aVar.aGe = R.drawable.ksad_content_feed_item_close;
        aVar.aGf = R.drawable.ksad_feed_item_cover_bg;
        aVar.aGg = R.drawable.ksad_feed_item_cover_large_bg;
        aVar.aGh = R.drawable.ksad_feed_item_cover_small_bg;
        return aVar;
    }

    private static a Ff() {
        return new a();
    }
}
