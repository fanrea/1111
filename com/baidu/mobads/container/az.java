package com.baidu.mobads.container;

import android.content.Context;
import android.webkit.WebView;
import com.baidu.mobads.container.util.bq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class az extends WebView {
    protected final bq b;

    public az(Context context, bq bqVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super(context);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        getSettings().setAllowContentAccess(false);
        getSettings().setSavePassword(false);
        getSettings().setAllowFileAccess(false);
        this.b = bqVar;
        a();
    }

    private void a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (com.baidu.mobads.container.util.x.a(null).a() >= 11 && com.baidu.mobads.container.util.x.a(null).a() <= 17) {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("removeJavascriptInterface", String.class);
                declaredMethod.invoke(this, "searchBoxJavaBridge_");
                declaredMethod.invoke(this, "accessibility");
                declaredMethod.invoke(this, "accessibilityTraversal");
            }
        } catch (Exception e) {
        }
    }
}
