package com.kwad.components.ct.tube.c;

import com.kwad.components.ct.f.c;
import com.kwad.components.ct.f.e;
import com.kwad.sdk.R;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements c {
    public String aZc = "#19191E";
    public String aZd = "#FFFFFFFF";
    public String aZe = "#E6E6E6";
    public String aZf = "#2B2B2F";
    public String aZg = "#19191E";
    public String aZh = "#14FFFFFF";
    public String aZi = "#E6E6E6";
    public String aZj = "#909092";
    public String aZk = "#909092";
    public String aZl = "#191A1E";
    public String aZm = "#E6E6E6";
    public String aZn = "#2B2B2F";
    public String aZo = "#E6E6E6";
    public String aZp = "#909092";
    public String aZq = "#E6E6E6";
    public String aZr = "#909092";
    public String aZs = "#FFFFFF";
    public int aZt = R.drawable.ksad_tube_pannel_item_view_count_icon_dark;
    public int aZu = R.drawable.ksad_tube_pannel_collapse_arrow_dark;
    public int aZv = R.color.ksad_tube_pannel_tab_color_dark;
    public int aZw = R.drawable.ksad_tube_page_back_icon_dark;
    public int aZx = R.drawable.ksad_tube_channel_enter_icon_dark;

    public final void a(XmlPullParser xmlPullParser) {
        if ("tubePannelBg".equals(xmlPullParser.getName())) {
            this.aZc = e.a(xmlPullParser, this.aZc);
            return;
        }
        if ("tubePannelTitleText".equals(xmlPullParser.getName())) {
            this.aZd = e.a(xmlPullParser, this.aZd);
            return;
        }
        if ("tubePannelBottomText".equals(xmlPullParser.getName())) {
            this.aZe = e.a(xmlPullParser, this.aZe);
            return;
        }
        if ("tubePannelDivider".equals(xmlPullParser.getName())) {
            this.aZf = e.a(xmlPullParser, this.aZf);
            return;
        }
        if ("tubePannelItemBg".equals(xmlPullParser.getName())) {
            this.aZg = e.a(xmlPullParser, this.aZg);
            return;
        }
        if ("tubePannelItemChooseBg".equals(xmlPullParser.getName())) {
            this.aZh = e.a(xmlPullParser, this.aZh);
            return;
        }
        if ("tubePannelItemDesc".equals(xmlPullParser.getName())) {
            this.aZi = e.a(xmlPullParser, this.aZi);
            return;
        }
        if ("tubePannelItemTime".equals(xmlPullParser.getName())) {
            this.aZj = e.a(xmlPullParser, this.aZj);
            return;
        }
        if ("tubePannelItemViewCount".equals(xmlPullParser.getName())) {
            this.aZk = e.a(xmlPullParser, this.aZk);
            return;
        }
        if ("tubePageBg".equals(xmlPullParser.getName())) {
            this.aZl = e.a(xmlPullParser, this.aZl);
            return;
        }
        if ("tubePageDivider".equals(xmlPullParser.getName())) {
            this.aZn = e.a(xmlPullParser, this.aZn);
            return;
        }
        if ("tubeChannelEnterText".equals(xmlPullParser.getName())) {
            this.aZp = e.a(xmlPullParser, this.aZp);
        } else if ("tubeItemNameText".equals(xmlPullParser.getName())) {
            this.aZq = e.a(xmlPullParser, this.aZq);
        } else if ("tubeItemDescText".equals(xmlPullParser.getName())) {
            this.aZr = e.a(xmlPullParser, this.aZr);
        }
    }
}
