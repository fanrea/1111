package com.kwad.components.ct.hotspot.b;

import com.baidu.mobads.container.n.f;
import com.kwad.components.ct.f.c;
import com.kwad.components.ct.f.e;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements c {
    public String aDq = "#E6191A1C";
    public String aQk = "#80FFFFFF";
    public String aQl = "#FFFFFFFF";
    public String aQm = "#99FFFFFF";
    public String aQn = "#99FFFFFF";

    public final void a(XmlPullParser xmlPullParser) {
        if (f.T.equals(xmlPullParser.getName())) {
            this.aDq = e.a(xmlPullParser, this.aDq);
            return;
        }
        if ("videoFromTextColor".equals(xmlPullParser.getName())) {
            this.aQk = e.a(xmlPullParser, this.aQk);
            return;
        }
        if ("entryTitleTextColor".equals(xmlPullParser.getName())) {
            this.aQl = e.a(xmlPullParser, this.aQl);
        } else if ("videoDescribeTextColor".equals(xmlPullParser.getName())) {
            this.aQm = e.a(xmlPullParser, this.aQm);
        } else if ("likeInfoTextColor".equals(xmlPullParser.getName())) {
            this.aQn = e.a(xmlPullParser, this.aQn);
        }
    }
}
