package com.just.agentweb;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.just.agentweb.AgentWeb;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class JsBaseInterfaceHolder implements JsInterfaceHolder {
    private AgentWeb.SecurityType mSecurityType;
    private WebCreator mWebCreator;

    protected JsBaseInterfaceHolder(WebCreator webCreator, AgentWeb.SecurityType securityType) {
        this.mSecurityType = securityType;
        this.mWebCreator = webCreator;
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public boolean checkObject(Object obj) throws SecurityException {
        if (Build.VERSION.SDK_INT < 17 || this.mWebCreator.getWebViewType() == 2) {
            return true;
        }
        boolean z = false;
        for (Method method : obj.getClass().getMethods()) {
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (annotations[i] instanceof JavascriptInterface) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                break;
            }
        }
        return z;
    }

    protected boolean checkSecurity() {
        return this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK || this.mWebCreator.getWebViewType() == 2 || Build.VERSION.SDK_INT > 17;
    }
}
