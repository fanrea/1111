package com.bytedance.sdk.component.h.b;

import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements com.bytedance.sdk.component.h.d, com.bytedance.sdk.component.h.hc {
    private final com.bytedance.sdk.component.c.d.d d;
    private final boolean hc;

    public an(com.bytedance.sdk.component.c.d.d dVar) {
        this.d = dVar;
        this.hc = false;
    }

    public an(com.bytedance.sdk.component.c.d.d dVar, boolean z) {
        this.d = dVar;
        this.hc = z;
    }

    @Override // com.bytedance.sdk.component.h.d
    public Map<String, Object> d(File file) throws Throwable {
        FileInputStream fileInputStream;
        HashMap map = new HashMap();
        if (!file.exists()) {
            return map;
        }
        if (!file.canRead()) {
            mq.hc("XmlSimpleReader", "can't read file " + file);
            return map;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, null);
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (TypedValues.Custom.S_STRING.equals(name) || "int".equals(name) || "long".equals(name) || TypedValues.Custom.S_FLOAT.equals(name) || TypedValues.Custom.S_BOOLEAN.equals(name) || "set".equals(name)) {
                            String attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "name");
                            Object objD = d(xmlPullParserNewPullParser, name);
                            if (attributeValue != null && objD != null) {
                                map.put(attributeValue, objD);
                            }
                        }
                    }
                }
                fileInputStream.close();
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return new com.bytedance.sdk.component.h.d.hc().d(map, this.d, this.hc);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return new com.bytedance.sdk.component.h.d.hc().d(map, this.d, this.hc);
    }

    private Object d(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        str.hashCode();
        switch (str) {
            case "string":
                return xmlPullParser.nextText();
            case "int":
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, com.alipay.sdk.m.p0.b.d)));
            case "set":
                return d(xmlPullParser);
            case "long":
                return Long.valueOf(Long.parseLong(xmlPullParser.getAttributeValue(null, com.alipay.sdk.m.p0.b.d)));
            case "boolean":
                return Boolean.valueOf(Boolean.parseBoolean(xmlPullParser.getAttributeValue(null, com.alipay.sdk.m.p0.b.d)));
            case "float":
                return Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue(null, com.alipay.sdk.m.p0.b.d)));
            default:
                return null;
        }
    }

    private Set<String> d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && "set".equals(xmlPullParser.getName())) {
                return hashSet;
            }
            if (eventType == 2 && TypedValues.Custom.S_STRING.equals(xmlPullParser.getName())) {
                hashSet.add(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    private void d(String str, Object obj, XmlSerializer xmlSerializer) throws IllegalStateException, IOException, IllegalArgumentException {
        if (obj instanceof String) {
            xmlSerializer.startTag(null, TypedValues.Custom.S_STRING);
            xmlSerializer.attribute(null, "name", str);
            xmlSerializer.text(d((String) obj));
            xmlSerializer.endTag(null, TypedValues.Custom.S_STRING);
            return;
        }
        if (obj instanceof Integer) {
            d(str, (Integer) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Long) {
            d(str, (Long) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Float) {
            d(str, (Float) obj, xmlSerializer);
            return;
        }
        if (obj instanceof Double) {
            d(str, (Double) obj, xmlSerializer);
        } else if (obj instanceof Boolean) {
            d(str, (Boolean) obj, xmlSerializer);
        } else if (obj instanceof Set) {
            d(str, (Set<String>) obj, xmlSerializer);
        }
    }

    private void d(String str, Integer num, XmlSerializer xmlSerializer) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, "int");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, com.alipay.sdk.m.p0.b.d, Integer.toString(num.intValue()));
        xmlSerializer.endTag(null, "int");
    }

    private void d(String str, Long l, XmlSerializer xmlSerializer) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, "long");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, com.alipay.sdk.m.p0.b.d, Long.toString(l.longValue()));
        xmlSerializer.endTag(null, "long");
    }

    private void d(String str, Float f, XmlSerializer xmlSerializer) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, TypedValues.Custom.S_FLOAT);
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, com.alipay.sdk.m.p0.b.d, Float.toString(f.floatValue()));
        xmlSerializer.endTag(null, TypedValues.Custom.S_FLOAT);
    }

    private void d(String str, Double d, XmlSerializer xmlSerializer) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, "double");
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, com.alipay.sdk.m.p0.b.d, Double.toString(d.doubleValue()));
        xmlSerializer.endTag(null, "double");
    }

    private void d(String str, Boolean bool, XmlSerializer xmlSerializer) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, TypedValues.Custom.S_BOOLEAN);
        xmlSerializer.attribute(null, "name", str);
        xmlSerializer.attribute(null, com.alipay.sdk.m.p0.b.d, Boolean.toString(bool.booleanValue()));
        xmlSerializer.endTag(null, TypedValues.Custom.S_BOOLEAN);
    }

    private void d(String str, Set<String> set, XmlSerializer xmlSerializer) throws IllegalStateException, IOException, IllegalArgumentException {
        xmlSerializer.startTag(null, "set");
        xmlSerializer.attribute(null, "name", str);
        for (String str2 : set) {
            xmlSerializer.startTag(null, TypedValues.Custom.S_STRING);
            xmlSerializer.text(d(str2));
            xmlSerializer.endTag(null, TypedValues.Custom.S_STRING);
        }
        xmlSerializer.endTag(null, "set");
    }

    @Override // com.bytedance.sdk.component.h.hc
    public void d(Map<String, Object> map, File file) throws Throwable {
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Map<String, Object> mapHc = new com.bytedance.sdk.component.h.d.hc().hc(map, this.d, this.hc);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                    xmlSerializerNewSerializer.setOutput(fileOutputStream2, "utf-8");
                    xmlSerializerNewSerializer.startDocument(null, Boolean.TRUE);
                    xmlSerializerNewSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    xmlSerializerNewSerializer.startTag(null, "map");
                    for (String str : mapHc.keySet()) {
                        if (str != null) {
                            d(str, mapHc.get(str), xmlSerializerNewSerializer);
                        }
                    }
                    xmlSerializerNewSerializer.endTag(null, "map");
                    xmlSerializerNewSerializer.endDocument();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    mq.hc("XmlSimpleReader", "write file exception ", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private String d(String str) {
        int i;
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt < ' ' || cCharAt > 55295) && !((cCharAt >= 57344 && cCharAt <= 65533) || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) {
                if (sb == null) {
                    sb = new StringBuilder();
                    if (i2 > 0) {
                        sb.append(str.substring(0, i2));
                    }
                }
                if (cCharAt == '\"') {
                    sb.append("&quot;");
                } else if (cCharAt == '<') {
                    sb.append("&lt;");
                } else if (cCharAt == '>') {
                    sb.append("&gt;");
                } else if (cCharAt == '&') {
                    sb.append("&amp;");
                } else if (cCharAt == '\'') {
                    sb.append("&apos;");
                } else if (Character.isHighSurrogate(cCharAt) && (i = i2 + 1) < length) {
                    char cCharAt2 = str.charAt(i);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        sb.append(cCharAt);
                        sb.append(cCharAt2);
                        i2 = i;
                    }
                } else {
                    sb.append("&#").append((int) cCharAt).append(i.b);
                }
            } else if (sb != null) {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb != null ? sb.toString() : str;
    }
}
