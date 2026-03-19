package com.kwad.components.ct.f;

import android.app.Application;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Xml;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.p.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public static void cd(String str) {
        Application applicationArl = m.arl();
        if (applicationArl == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = SdkConfig.DEF_NIGHT_THEME_STYLE_FILE_NAME;
        }
        com.kwad.sdk.core.d.c.d("StyleXmlParseUtils", "parseNightStyleXml start ");
        long jCurrentTimeMillis = System.currentTimeMillis();
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = applicationArl.getAssets().open(str);
            for (Map.Entry<String, c> entry : a(inputStreamOpen).entrySet()) {
                if (entry.getValue() != null) {
                    d.Kb();
                    d.a(entry.getKey(), entry.getValue());
                }
            }
        } finally {
            try {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
                com.kwad.sdk.core.d.c.d("StyleXmlParseUtils", "parseNightStyleXml end time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th) {
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
        com.kwad.sdk.core.d.c.d("StyleXmlParseUtils", "parseNightStyleXml end time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private static Map<String, c> a(InputStream inputStream) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, "utf-8");
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            b(xmlPullParserNewPullParser, eventType, map);
        }
        return map;
    }

    @ForInvoker(methodId = "parseNightStyleXmlForInvoker")
    private static void b(XmlPullParser xmlPullParser, int i, Map map) {
        com.kwad.components.ct.entry.c.b.a(xmlPullParser, i, map);
        com.kwad.components.ct.feed.b.b.a(xmlPullParser, i, map);
        com.kwad.components.ct.hotspot.b.b.a(xmlPullParser, i, map);
        com.kwad.components.ct.tube.c.b.a(xmlPullParser, i, map);
    }

    public static String a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            String strNextText = xmlPullParser.nextText();
            if (!TextUtils.isEmpty(strNextText)) {
                Color.parseColor(strNextText);
                return strNextText;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
        }
        return str;
    }
}
