package com.bytedance.bdtracker;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import java.nio.charset.Charset;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class r {
    public static final r a = new r();

    public final JSONObject a(Context context) {
        Object systemService;
        if (context != null) {
            try {
                systemService = context.getSystemService("clipboard");
            } catch (Throwable unused) {
            }
        } else {
            systemService = null;
        }
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip != null) {
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            Intrinsics.checkExpressionValueIsNotNull(itemAt, "clipData.getItemAt(0)");
            String string = itemAt.getText().toString();
            if (StringsKt.startsWith$default(string, "datatracer:", false, 2, (Object) null)) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
                if (string == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = string.substring(11);
                Intrinsics.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                Charset charset = Charsets.UTF_8;
                if (strSubstring == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = strSubstring.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                byte[] bArrDecode = Base64.decode(bytes, 2);
                StringBuilder sbAppend = new StringBuilder().append("?");
                Intrinsics.checkExpressionValueIsNotNull(bArrDecode, "data");
                return a(Uri.parse(sbAppend.append(new String(bArrDecode, Charsets.UTF_8)).toString()));
            }
        }
        return null;
    }

    public final JSONObject a(Uri uri) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (uri == null) {
                return jSONObject;
            }
            String scheme = uri.getScheme();
            if (Intrinsics.areEqual(scheme, com.alipay.sdk.m.l.a.r) || Intrinsics.areEqual(scheme, "https")) {
                jSONObject.put("tr_token", uri.getLastPathSegment());
            }
            for (String str : uri.getQueryParameterNames()) {
                jSONObject.put(str, uri.getQueryParameter(str));
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
