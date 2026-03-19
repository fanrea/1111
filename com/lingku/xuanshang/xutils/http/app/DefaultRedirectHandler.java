package com.lingku.xuanshang.xutils.http.app;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.just.agentweb.AgentWebPermissions;
import com.lingku.xuanshang.xutils.http.HttpMethod;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.request.HttpRequest;
import com.lingku.xuanshang.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DefaultRedirectHandler implements RedirectHandler {
    @Override // com.lingku.xuanshang.xutils.http.app.RedirectHandler
    public RequestParams getRedirectParams(UriRequest uriRequest) {
        if (!(uriRequest instanceof HttpRequest)) {
            return null;
        }
        HttpRequest httpRequest = (HttpRequest) uriRequest;
        RequestParams params = httpRequest.getParams();
        String responseHeader = httpRequest.getResponseHeader(AgentWebPermissions.ACTION_LOCATION);
        if (TextUtils.isEmpty(responseHeader)) {
            return null;
        }
        if (!URLUtil.isHttpsUrl(responseHeader) && !URLUtil.isHttpUrl(responseHeader)) {
            String uri = params.getUri();
            if (responseHeader.startsWith("/")) {
                int iIndexOf = uri.indexOf("/", 8);
                if (iIndexOf != -1) {
                    uri = uri.substring(0, iIndexOf);
                }
            } else {
                int iLastIndexOf = uri.lastIndexOf("/");
                uri = iLastIndexOf >= 8 ? uri.substring(0, iLastIndexOf + 1) : uri + "/";
            }
            responseHeader = uri + responseHeader;
        }
        params.setUri(responseHeader);
        int responseCode = uriRequest.getResponseCode();
        if (responseCode == 301 || responseCode == 302 || responseCode == 303) {
            params.clearParams();
            params.setMethod(HttpMethod.GET);
        }
        return params;
    }
}
