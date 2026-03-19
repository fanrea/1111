package com.baidu.enan.e.a.b;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import com.baidu.enan.f.b;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return b(context);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static String b(Context context) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (Build.VERSION.SDK_INT >= 14 && (enabledAccessibilityServiceList = ((AccessibilityManager) context.getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1)) != null && enabledAccessibilityServiceList.size() != 0) {
                boolean z = true;
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    if (!z) {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(accessibilityServiceInfo.getId());
                    z = false;
                }
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return stringBuffer.toString();
    }
}
