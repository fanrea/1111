package com.bytedance.sdk.djx.net.k3.sse.internal;

import com.bytedance.sdk.djx.net.k3.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseUtil.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"stripBody", "Lcom/bytedance/sdk/djx/net/k3/Response;", "net_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ResponseUtilKt {
    public static final Response stripBody(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Response responseBuild = response.newBuilder().body(new UnreadableResponseBody(response.body.getMediaType(), response.body.getContentLength())).build();
        Intrinsics.checkNotNullExpressionValue(responseBuild, "newBuilder()\n        .bo…ngth()))\n        .build()");
        return responseBuild;
    }
}
