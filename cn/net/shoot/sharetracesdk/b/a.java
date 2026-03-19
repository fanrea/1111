package cn.net.shoot.sharetracesdk.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static volatile a c;
    public ClipboardManager a;
    public String b = null;

    public static a d() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public String a() {
        if (!cn.net.shoot.sharetracesdk.f.a.c().h) {
            return null;
        }
        if (this.b == null) {
            c();
        }
        return this.b;
    }

    public String b() throws InterruptedException {
        if (!cn.net.shoot.sharetracesdk.f.a.c().h) {
            return null;
        }
        if (this.a == null) {
            Log.e("ShareTrace", "ClipTask has not initialized yet.");
            return null;
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC) || Build.VERSION.SDK_INT < 29) {
            return strC;
        }
        try {
            Thread.sleep(300L);
        } catch (Exception unused) {
        }
        return c();
    }

    public final String c() {
        ClipboardManager clipboardManager = this.a;
        if (clipboardManager == null) {
            return "";
        }
        ClipData primaryClip = null;
        try {
            primaryClip = clipboardManager.getPrimaryClip();
        } catch (Throwable unused) {
        }
        if (primaryClip == null) {
            return "";
        }
        int itemCount = primaryClip.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            ClipData.Item itemAt = primaryClip.getItemAt(i);
            if (itemAt != null && itemAt.getText() != null) {
                String string = itemAt.getText().toString();
                this.b = string;
                String str = "get clip plain data=" + string;
                if (string.startsWith("-st-")) {
                    try {
                        return new String(Base64.decode(string.substring(4), 0), Charset.forName("UTF-8"));
                    } catch (Exception unused2) {
                    }
                }
                if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(itemAt.getHtmlText())) {
                    String htmlText = itemAt.getHtmlText();
                    String str2 = "get clip html data=" + htmlText;
                    this.b = htmlText;
                    if (htmlText.startsWith("<a") && htmlText.contains("id=\"") && htmlText.contains("\">")) {
                        Matcher matcher = Pattern.compile("<a\\s*id=\"(.+?)\"", 8).matcher(htmlText);
                        htmlText = matcher.find() ? matcher.group(1) : "";
                        String str3 = "get html tag clip data=" + htmlText;
                    }
                    if (htmlText.startsWith("SHARETRACE:")) {
                        String strSubstring = htmlText.substring(11);
                        if (strSubstring.contains(":")) {
                            String[] strArrSplit = strSubstring.split(":");
                            if (strArrSplit.length != 2) {
                                continue;
                            } else {
                                String str4 = strArrSplit[0];
                                if (!TextUtils.isEmpty(str4) && str4.length() > 8) {
                                    String strSubstring2 = str4.substring(5);
                                    str4 = strSubstring2.substring(0, 5) + strSubstring2.substring(8);
                                    String str5 = "get clip data rel key = " + str4;
                                }
                                String str6 = strArrSplit[1];
                                if (!TextUtils.isEmpty(str6) && str6.length() > 15) {
                                    String strSubstring3 = str6.substring(3);
                                    str6 = strSubstring3.substring(0, 10) + strSubstring3.substring(15);
                                    String str7 = "get clip data rel tid = " + str6;
                                }
                                if (cn.net.shoot.sharetracesdk.f.a.c().c.equals(str4)) {
                                    String str8 = "get clip data success, tid=" + str6;
                                    return str6;
                                }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return "";
    }
}
