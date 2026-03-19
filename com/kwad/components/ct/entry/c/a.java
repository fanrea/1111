package com.kwad.components.ct.entry.c;

import com.baidu.mobads.container.n.f;
import com.kwad.components.ct.f.c;
import com.kwad.components.ct.f.e;
import com.kwad.sdk.R;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements c {
    public String aDq = "#FF19191E";
    public String aDr = "#FF909092";
    public String aDs = "#FFE6E6E6";
    public String aDt = "#FFE6E6E6";
    public String aDu = "#FF909092";
    public int aDv = R.drawable.ksad_entrytitle_arrow_night;

    public final void a(XmlPullParser xmlPullParser) {
        if (f.T.equals(xmlPullParser.getName())) {
            this.aDq = e.a(xmlPullParser, this.aDq);
            return;
        }
        if ("videoFromTextColor".equals(xmlPullParser.getName())) {
            this.aDr = e.a(xmlPullParser, this.aDr);
            return;
        }
        if ("entryTitleTextColor".equals(xmlPullParser.getName())) {
            this.aDs = e.a(xmlPullParser, this.aDs);
        } else if ("videoDescribeTextColor".equals(xmlPullParser.getName())) {
            this.aDt = e.a(xmlPullParser, this.aDt);
        } else if ("likeInfoTextColor".equals(xmlPullParser.getName())) {
            this.aDu = e.a(xmlPullParser, this.aDu);
        }
    }
}
