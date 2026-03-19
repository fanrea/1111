package com.duoyou.task.sdk.xutils.http.app;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.duoyou.task.sdk.xutils.http.HttpMethod;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.request.HttpRequest;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import com.just.agentweb.AgentWebPermissions;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DefaultRedirectHandler implements RedirectHandler {
    @Override // com.duoyou.task.sdk.xutils.http.app.RedirectHandler
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
                if (iLastIndexOf >= 8) {
                    uri = uri.substring(0, iLastIndexOf + 1);
                } else {
                    uri = uri + "/";
                }
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
