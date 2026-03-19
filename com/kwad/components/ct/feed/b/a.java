package com.kwad.components.ct.feed.b;

import com.baidu.mobads.container.n.f;
import com.kwad.components.ct.f.c;
import com.kwad.components.ct.f.e;
import com.kwad.sdk.R;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements c {
    public String aDq = "#FF19191E";
    public String asm = "#FF909092";
    public String aDt = "#FFE6E6E6";
    public String aDu = "#FF9C9C9C";
    public String aGc = "#FFFFFFFF";
    public int aGd = R.drawable.ksad_feed_item_covert_btn_idle_bg_night;
    public int aGe = R.drawable.ksad_content_feed_item_close_night;
    public int aGf = R.drawable.ksad_feed_item_cover_bg_night;
    public int aGg = R.drawable.ksad_feed_item_cover_large_bg_night;
    public int aGh = R.drawable.ksad_feed_item_cover_small_bg_night;

    public final void a(XmlPullParser xmlPullParser) {
        if (f.T.equals(xmlPullParser.getName())) {
            this.aDq = e.a(xmlPullParser, this.aDq);
            return;
        }
        if ("authorNameTextColor".equals(xmlPullParser.getName())) {
            this.asm = e.a(xmlPullParser, this.asm);
        } else if ("likeInfoTextColor".equals(xmlPullParser.getName())) {
            this.aDu = e.a(xmlPullParser, this.aDt);
        } else if ("videoDescribeTextColor".equals(xmlPullParser.getName())) {
            this.aDt = e.a(xmlPullParser, this.aDu);
        }
    }
}
