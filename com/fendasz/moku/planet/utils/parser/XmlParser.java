package com.fendasz.moku.planet.utils.parser;

import com.alipay.sdk.m.u.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class XmlParser {
    private static final String TAG = "XmlParser";
    private int branchPointer;
    private String errorReason;
    private boolean mIsError;
    private boolean mIsSuccess;
    private String mStrXml;
    private char[] mXmlChars;
    private XmlParserCallback mXmlParserCallback;
    private int mainPointer;
    private List<String> mainTagList = new ArrayList();
    private List<String> branchTagList = new ArrayList();

    private interface TagCallback {
        void callback(boolean z, int i, String str);
    }

    public interface XmlParserCallback {
        void content(String str);

        void document(String str);

        void endDocument(String str);

        void endElement(String str);

        void error(String str);

        void startDocument(String str);

        void startElement(String str, List<Attribute> list);

        void success();
    }

    static /* synthetic */ int access$008(XmlParser xmlParser) {
        int i = xmlParser.branchPointer;
        xmlParser.branchPointer = i + 1;
        return i;
    }

    public XmlParser(String str, XmlParserCallback xmlParserCallback) {
        this.mStrXml = str;
        this.mXmlParserCallback = xmlParserCallback;
    }

    public XmlParser() {
    }

    public void setXmlParserCallback(XmlParserCallback xmlParserCallback) {
        this.mXmlParserCallback = xmlParserCallback;
    }

    public void setStrXml(String str) {
        this.mStrXml = str;
    }

    public void parse() {
        boolean z;
        if (this.mXmlParserCallback == null) {
            return;
        }
        String str = this.mStrXml;
        if (str == null || str.length() == 0) {
            this.mIsError = true;
            this.errorReason = "no xml string";
            this.mXmlParserCallback.error("no xml string");
            return;
        }
        this.mXmlChars = ("<Trailwalker>" + this.mStrXml + "</Trailwalker>").toCharArray();
        this.mainPointer = 0;
        this.mIsSuccess = false;
        this.mIsError = false;
        String startDocument = getStartDocument();
        this.mXmlParserCallback.startDocument(startDocument);
        if (!isCanNotCloseTag(startDocument)) {
            this.branchTagList.add(startDocument);
        }
        this.mXmlParserCallback.document(getDocument());
        this.mXmlParserCallback.endDocument(getEndDocument());
        while (true) {
            z = this.mIsSuccess;
            if (z || this.mIsError) {
                break;
            }
            String startElement = getStartElement();
            if (startElement != null) {
                this.mXmlParserCallback.startElement(startElement, getAttributeList(startElement.toCharArray()));
                if (!isCanNotCloseTag(startElement)) {
                    this.mainTagList.add(startElement);
                    this.branchTagList.add(startElement);
                }
            }
            if (!this.mIsSuccess && !this.mIsError) {
                this.mXmlParserCallback.content(getContent());
            }
            if (!this.mIsSuccess && !this.mIsError) {
                this.mXmlParserCallback.endElement(getEndElement());
            }
        }
        if (z) {
            this.mXmlParserCallback.success();
        }
    }

    private List<Attribute> getAttributeList(char[] cArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < cArr.length && cArr[i] != ' ') {
            i++;
        }
        while (i < cArr.length && cArr[i] == ' ') {
            i++;
        }
        while (i < cArr.length - 1) {
            Attribute attribute = new Attribute();
            StringBuilder sb = new StringBuilder();
            while (true) {
                char c = cArr[i];
                if (c == '=') {
                    break;
                }
                sb.append(c);
                i++;
            }
            while (cArr[i] != '\"') {
                i++;
            }
            int i2 = i + 1;
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                char c2 = cArr[i2];
                if (c2 == '\"') {
                    break;
                }
                sb2.append(c2);
                i2++;
            }
            i = i2 + 1;
            attribute.setKey(sb.toString().trim());
            attribute.setValue(sb2.toString().trim());
            arrayList.add(attribute);
            while (cArr[i] == ' ') {
                i++;
            }
        }
        return arrayList;
    }

    private String getEndElement() {
        final String[] strArr = {null};
        int i = this.branchPointer;
        char[] cArr = this.mXmlChars;
        if (i < cArr.length) {
            getTag(i, cArr, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.1
                @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
                public void callback(boolean z, int i2, String str) {
                    if (z) {
                        XmlParser.this.branchPointer = i2 + str.length();
                        strArr[0] = str;
                    }
                }
            });
        }
        return strArr[0];
    }

    private String getEndDocument() {
        int i = this.branchPointer;
        char[] cArr = this.mXmlChars;
        if (i >= cArr.length) {
            return "</>";
        }
        final String[] strArr = {"</>"};
        getTag(i, cArr, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.2
            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
            public void callback(boolean z, int i2, String str) {
                if (z) {
                    XmlParser.this.branchPointer = i2 + str.length();
                    strArr[0] = str;
                }
            }
        });
        return strArr[0];
    }

    private String getStartElement() {
        this.branchTagList.clear();
        this.branchPointer = 0;
        final String[] strArr = {null};
        do {
            getTag(this.mainPointer, this.mXmlChars, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.3
                @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
                public void callback(boolean z, int i, String str) {
                    if (!z) {
                        XmlParser.this.mIsSuccess = true;
                        return;
                    }
                    XmlParser.this.mainPointer = str.length() + i;
                    XmlParser.this.branchPointer = i + str.length();
                    strArr[0] = str;
                }
            });
            String str = strArr[0];
            if (str == null || !isEndTag(str)) {
                break;
            }
        } while (!this.mIsSuccess);
        if (this.mIsSuccess) {
            strArr[0] = null;
        }
        return strArr[0];
    }

    private String getStartDocument() {
        final String[] strArr = new String[1];
        getTag(this.mainPointer, this.mXmlChars, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.4
            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
            public void callback(boolean z, int i, String str) {
                if (z) {
                    XmlParser.this.branchPointer = i + str.length();
                    strArr[0] = str;
                }
            }
        });
        return strArr[0];
    }

    private String getContent() {
        final StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.branchPointer;
            char[] cArr = this.mXmlChars;
            if (i < cArr.length) {
                char c = cArr[i];
                if (c == '<') {
                    final boolean[] zArr = {false};
                    getTag(i, cArr, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.5
                        @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
                        public void callback(boolean z, int i2, String str) {
                            if (z) {
                                while (XmlParser.this.branchPointer < i2) {
                                    sb.append(XmlParser.this.mXmlChars[XmlParser.this.branchPointer]);
                                    XmlParser.access$008(XmlParser.this);
                                }
                                if (XmlParser.this.isStartTag(str)) {
                                    if (!XmlParser.this.isCanNotCloseTag(str)) {
                                        XmlParser.this.branchTagList.add(str);
                                    }
                                } else {
                                    if (!XmlParser.this.isCanNotCloseTag(str)) {
                                        XmlParser.this.branchTagList.remove(XmlParser.this.branchTagList.size() - 1);
                                    }
                                    if (XmlParser.this.branchTagList.size() == 0) {
                                        zArr[0] = true;
                                        return;
                                    }
                                }
                                while (XmlParser.this.branchPointer < str.length() + i2) {
                                    sb.append(XmlParser.this.mXmlChars[XmlParser.this.branchPointer]);
                                    XmlParser.access$008(XmlParser.this);
                                }
                            }
                        }
                    });
                    if (zArr[0]) {
                        return sb.toString();
                    }
                } else {
                    sb.append(c);
                    this.branchPointer++;
                }
            } else {
                this.mIsError = true;
                this.mXmlParserCallback.error("no end tag");
                return sb.toString();
            }
        }
    }

    private String getDocument() {
        final StringBuilder sb = new StringBuilder();
        while (true) {
            int i = this.branchPointer;
            char[] cArr = this.mXmlChars;
            if (i < cArr.length) {
                char c = cArr[i];
                if (c == '<') {
                    final boolean[] zArr = {false};
                    getTag(i, cArr, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.6
                        @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
                        public void callback(boolean z, int i2, String str) {
                            if (z) {
                                while (XmlParser.this.branchPointer < i2) {
                                    sb.append(XmlParser.this.mXmlChars[XmlParser.this.branchPointer]);
                                    XmlParser.access$008(XmlParser.this);
                                }
                                if (XmlParser.this.isStartTag(str)) {
                                    if (!XmlParser.this.isCanNotCloseTag(str)) {
                                        XmlParser.this.branchTagList.add(str);
                                    }
                                } else {
                                    if (!XmlParser.this.isCanNotCloseTag(str)) {
                                        XmlParser.this.branchTagList.remove(XmlParser.this.branchTagList.size() - 1);
                                    }
                                    if (XmlParser.this.branchPointer + str.length() == XmlParser.this.mXmlChars.length) {
                                        if (XmlParser.this.branchTagList.size() != 0 && (XmlParser.this.branchTagList.size() != 1 || !((String) XmlParser.this.branchTagList.get(0)).equals(""))) {
                                            XmlParser.this.mIsError = true;
                                            XmlParser.this.mXmlParserCallback.error("parse error");
                                        } else {
                                            zArr[0] = true;
                                            return;
                                        }
                                    }
                                }
                                while (XmlParser.this.branchPointer < str.length() + i2) {
                                    sb.append(XmlParser.this.mXmlChars[XmlParser.this.branchPointer]);
                                    XmlParser.access$008(XmlParser.this);
                                }
                            }
                        }
                    });
                    if (zArr[0]) {
                        return sb.toString();
                    }
                } else {
                    sb.append(c);
                    this.branchPointer++;
                }
            } else {
                if (this.branchTagList.size() == 0 || (this.branchTagList.size() == 1 && this.branchTagList.get(0).equals(""))) {
                    return sb.toString();
                }
                this.mIsError = true;
                this.mXmlParserCallback.error("parse error");
                return sb.toString();
            }
        }
    }

    public boolean isEndTag(String str) {
        return isTag(str) && str.startsWith("</");
    }

    public boolean isStartTag(String str) {
        return isTag(str) && !isEndTag(str);
    }

    public boolean isCanNotCloseTag(String str) {
        return "br".equals(getTagName(str));
    }

    public String getTagName(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (!isTag(strTrim)) {
            return null;
        }
        int iIndexOf = strTrim.indexOf(" ");
        if (isStartTag(strTrim)) {
            if (iIndexOf > 0) {
                return strTrim.substring(1, iIndexOf);
            }
            return strTrim.substring(1, strTrim.length() - 1);
        }
        if (iIndexOf > 0) {
            return strTrim.substring(2, iIndexOf);
        }
        return strTrim.substring(2, strTrim.length() - 1);
    }

    public String getStartTag(String str, List<Attribute> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(str);
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Attribute attribute = list.get(i);
                sb.append(" ");
                sb.append(attribute.getKey());
                sb.append("=");
                sb.append("\"");
                sb.append(attribute.getValue());
                sb.append("\"");
            }
        }
        sb.append(">");
        return sb.toString();
    }

    public String getEndTag(String str) {
        return "</" + str + ">";
    }

    public List<Attribute> getStyleAttributeList(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() > 0) {
            for (String str2 : str.trim().split(i.b)) {
                String[] strArrSplit = str2.trim().split(":");
                Attribute attribute = new Attribute();
                if (strArrSplit.length == 2) {
                    attribute.setKey(strArrSplit[0].trim());
                    attribute.setValue(strArrSplit[1].trim());
                    arrayList.add(attribute);
                } else if (strArrSplit.length == 1) {
                    Attribute attribute2 = (Attribute) arrayList.get(arrayList.size() - 1);
                    attribute2.setValue(attribute2.getValue() + i.b + strArrSplit[0]);
                    arrayList.set(arrayList.size() - 1, attribute2);
                }
            }
        }
        return arrayList;
    }

    public String rgb2Hex(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")).trim().split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (String str2 : strArrSplit) {
            sb.append(intToHex(Integer.parseInt(str2.trim())));
        }
        return sb.toString();
    }

    private static String intToHex(int i) {
        StringBuilder sb = new StringBuilder(8);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        do {
            sb = sb.append(cArr[i % 16]);
            i /= 16;
        } while (i != 0);
        if (sb.length() < 2) {
            sb.append('0');
        }
        return sb.reverse().toString();
    }

    private boolean isTag(String str) {
        return str.startsWith("<") && str.endsWith(">") && !str.substring(1, str.length() - 1).contains("<") && !str.substring(1, str.length() - 1).contains(">");
    }

    public boolean isStartWithTag(char[] cArr) {
        final boolean[] zArr = {false};
        getTag(0, cArr, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.7
            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
            public void callback(boolean z, int i, String str) {
                if (z && i == 0 && XmlParser.this.isStartTag(str) && !XmlParser.this.isCanNotCloseTag(str)) {
                    zArr[0] = true;
                }
            }
        });
        return zArr[0];
    }

    public void getTag(int i, char[] cArr, TagCallback tagCallback) {
        StringBuilder sb = new StringBuilder();
        int i2 = i;
        int i3 = i2;
        while (i < cArr.length) {
            char c = cArr[i3];
            if (c == '<') {
                sb.delete(0, sb.length());
                sb.append(c);
                i2 = i3;
            } else {
                if (c == '>' && sb.toString().contains("<")) {
                    sb.append(c);
                    tagCallback.callback(true, i2, sb.toString());
                    return;
                }
                sb.append(c);
            }
            i3++;
            i++;
        }
        tagCallback.callback(false, i2, null);
    }

    public String getFirstTag(char[] cArr) {
        final String[] strArr = {null};
        getTag(0, cArr, new TagCallback() { // from class: com.fendasz.moku.planet.utils.parser.XmlParser.8
            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.TagCallback
            public void callback(boolean z, int i, String str) {
                if (z && i == 0) {
                    strArr[0] = str;
                }
            }
        });
        return strArr[0];
    }

    public static class Attribute {
        private String key;
        private String value;

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }
}
