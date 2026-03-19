package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.utils.parser.XmlParser;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuUtils {
    private static final String TAG = "MokuUtils";

    public static String decode(String str) {
        char[][] cArr = {new char[]{'a', 'g', 'm', 's', 'y', '3', '9'}, new char[]{'b', 'h', 'n', 't', 'z', '4', ':'}, new char[]{'c', 'i', 'o', 'u', '.', '5'}, new char[]{'d', 'j', 'p', 'v', '0', '6', SignatureImpl.SEP}, new char[]{'e', 'k', 'q', 'w', '1', '7'}, new char[]{'f', 'l', 'r', 'x', '2', '8', '/'}};
        HashMap map = new HashMap();
        map.put('0', 0);
        map.put('2', 1);
        map.put('4', 2);
        map.put('6', 3);
        map.put('a', 4);
        map.put('c', 5);
        map.put('e', 6);
        HashMap map2 = new HashMap();
        map2.put('1', 0);
        map2.put('3', 1);
        map2.put('5', 2);
        map2.put('b', 3);
        map2.put('d', 4);
        map2.put('f', 5);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.length() % 2 == 0) {
            char[] charArray = str.toCharArray();
            char c = 0;
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0) {
                    c = charArray[i];
                } else {
                    char c2 = charArray[i];
                    Integer num = (Integer) map2.get(Character.valueOf(c));
                    Integer num2 = (Integer) map.get(Character.valueOf(c2));
                    if (num == null || num2 == null) {
                        return null;
                    }
                    sb.append(cArr[num.intValue()][num2.intValue()]);
                }
            }
        }
        return sb.toString();
    }

    public static boolean isAppExistEver(Context context, String str) {
        if (MokuConfigure.getInstance().getMokuOptions(context).getBoolean(context.getString(R.string.moku_option_is_check_usage), true)) {
            return SystemUtils.isAppExistEver(context, str);
        }
        return SystemUtils.isAppExist(context, str);
    }

    public static Spanned parserXml(final String str) {
        final String[] strArr = {str};
        final XmlParser xmlParser = new XmlParser();
        xmlParser.setStrXml(str);
        xmlParser.setXmlParserCallback(new XmlParser.XmlParserCallback() { // from class: com.fendasz.moku.planet.utils.MokuUtils.1
            private String mBeReplacedTag;
            private boolean mIsNeedReplace = false;
            private List<String> mReplaceTagList;
            private String mXmlContentAfterParse;

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void document(String str2) {
            }

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void endDocument(String str2) {
            }

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void endElement(String str2) {
            }

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void startDocument(String str2) {
                this.mXmlContentAfterParse = str;
                this.mReplaceTagList = new ArrayList();
            }

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void startElement(String str2, List<XmlParser.Attribute> list) {
                List<XmlParser.Attribute> styleAttributeList;
                boolean z;
                List<XmlParser.Attribute> styleAttributeList2;
                if (xmlParser.isCanNotCloseTag(str2)) {
                    return;
                }
                if ("p".equals(xmlParser.getTagName(str2).toLowerCase())) {
                    this.mReplaceTagList.add("");
                    this.mBeReplacedTag = str2;
                    this.mIsNeedReplace = true;
                    return;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    XmlParser.Attribute attribute = list.get(i);
                    String key = attribute.getKey();
                    String value = attribute.getValue();
                    XmlParser.Attribute attribute2 = new XmlParser.Attribute();
                    if (TypedValues.Custom.S_COLOR.equals(key.trim())) {
                        attribute2.setKey(key.trim());
                        if (value.contains("#")) {
                            attribute2.setValue(value.trim());
                        } else if (value.contains("rgb")) {
                            attribute2.setValue(xmlParser.rgb2Hex(value.trim()));
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    if ("style".equals(key.trim()) && (styleAttributeList2 = xmlParser.getStyleAttributeList(value.trim())) != null && styleAttributeList2.size() > 0) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= styleAttributeList2.size()) {
                                break;
                            }
                            XmlParser.Attribute attribute3 = styleAttributeList2.get(i2);
                            if (TypedValues.Custom.S_COLOR.equals(attribute3.getKey().trim())) {
                                attribute2.setKey(attribute3.getKey().trim());
                                if (attribute3.getValue().contains("#")) {
                                    attribute2.setValue(attribute3.getValue().trim());
                                } else if (attribute3.getValue().contains("rgb")) {
                                    attribute2.setValue(xmlParser.rgb2Hex(attribute3.getValue().trim()));
                                }
                                z = true;
                            } else {
                                i2++;
                            }
                        }
                    }
                    if (z) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(attribute2);
                        if ("a".equals(xmlParser.getTagName(str2).toLowerCase())) {
                            List<String> list2 = this.mReplaceTagList;
                            XmlParser xmlParser2 = xmlParser;
                            list2.add(xmlParser2.getStartTag(xmlParser2.getTagName(str2), list));
                        }
                        this.mReplaceTagList.add(xmlParser.getStartTag("font", arrayList));
                        if (t.i.equals(xmlParser.getTagName(str2).toLowerCase()) || t.l.equals(xmlParser.getTagName(str2).toLowerCase())) {
                            List<String> list3 = this.mReplaceTagList;
                            XmlParser xmlParser3 = xmlParser;
                            list3.add(xmlParser3.getStartTag(xmlParser3.getTagName(str2), null));
                        }
                        this.mIsNeedReplace = true;
                    } else {
                        i++;
                    }
                }
                for (int i3 = 0; i3 < list.size(); i3++) {
                    XmlParser.Attribute attribute4 = list.get(i3);
                    String key2 = attribute4.getKey();
                    String value2 = attribute4.getValue();
                    if ("style".equals(key2.trim()) && (styleAttributeList = xmlParser.getStyleAttributeList(value2.trim())) != null && styleAttributeList.size() > 0) {
                        for (int i4 = 0; i4 < styleAttributeList.size(); i4++) {
                            XmlParser.Attribute attribute5 = styleAttributeList.get(i4);
                            if ("text-decoration-line".equals(attribute5.getKey().trim()) && "underline".equals(attribute5.getValue().trim())) {
                                this.mReplaceTagList.add(xmlParser.getStartTag(t.i, null));
                                this.mIsNeedReplace = true;
                            }
                            if ("font-weight".equals(attribute5.getKey().trim()) && "bold".equals(attribute5.getValue().trim())) {
                                this.mReplaceTagList.add(xmlParser.getStartTag(t.l, null));
                                this.mIsNeedReplace = true;
                            }
                        }
                    }
                }
                if (this.mIsNeedReplace) {
                    this.mBeReplacedTag = str2;
                }
            }

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void content(String str2) {
                if (this.mIsNeedReplace) {
                    this.mIsNeedReplace = false;
                    replaceTag(str2);
                }
            }

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void error(String str2) {
                LogUtils.log(MokuUtils.TAG, str2);
            }

            @Override // com.fendasz.moku.planet.utils.parser.XmlParser.XmlParserCallback
            public void success() {
                LogUtils.log(MokuUtils.TAG, "task process desc after parse >> " + this.mXmlContentAfterParse);
                strArr[0] = this.mXmlContentAfterParse;
            }

            private void replaceTag(String str2) {
                String string;
                if (this.mReplaceTagList.size() > 0) {
                    string = str2;
                    for (int i = 0; i < this.mReplaceTagList.size(); i++) {
                        String str3 = this.mReplaceTagList.get(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(str3);
                        sb.append(string);
                        String tagName = xmlParser.getTagName(str3);
                        if (tagName != null && !"".equals(tagName.trim())) {
                            XmlParser xmlParser2 = xmlParser;
                            sb.append(xmlParser2.getEndTag(xmlParser2.getTagName(str3)));
                        } else {
                            sb.append(" ");
                        }
                        string = sb.toString();
                    }
                } else {
                    string = str2;
                }
                this.mReplaceTagList.clear();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mBeReplacedTag);
                sb2.append(str2);
                XmlParser xmlParser3 = xmlParser;
                sb2.append(xmlParser3.getEndTag(xmlParser3.getTagName(this.mBeReplacedTag)));
                this.mXmlContentAfterParse = this.mXmlContentAfterParse.replace(sb2.toString(), string);
            }
        });
        try {
            xmlParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(strArr[0], 63);
        }
        return Html.fromHtml(strArr[0]);
    }
}
