package com.bytedance.rpc.serialize;

import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum SerializeType {
    JSON(MediaTypeUtils.APPLICATION_JSON),
    PB("application/x-protobuf"),
    THRIFT("application/application/x-thrift"),
    FORM("application/x-www-form-urlencoded; charset=UTF-8");

    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    String mContentType;

    SerializeType(String str) {
        this.mContentType = str;
    }

    public String getContentType() {
        return this.mContentType;
    }

    public String[] getTypeAndSubType() {
        return getTypeAndSubType(this.mContentType);
    }

    public static String[] getTypeAndSubType(String str) {
        Matcher matcher = TYPE_SUBTYPE.matcher(str);
        if (matcher.lookingAt()) {
            return new String[]{matcher.group(1).toLowerCase(Locale.US), matcher.group(2).toLowerCase(Locale.US)};
        }
        return com.bytedance.sdk.djx.proguard3.c.d.a;
    }

    public static SerializeType parser(String str) {
        if (!com.bytedance.sdk.djx.proguard3.c.d.b(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        for (SerializeType serializeType : values()) {
            if (serializeType.getContentType().equals(lowerCase)) {
                return serializeType;
            }
        }
        return null;
    }
}
