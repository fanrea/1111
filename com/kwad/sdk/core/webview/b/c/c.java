package com.kwad.sdk.core.webview.b.c;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static final List<String> bMj;

    static {
        ArrayList arrayList = new ArrayList();
        bMj = arrayList;
        arrayList.add("application/x-javascript");
        arrayList.add("image/jpeg");
        arrayList.add("image/tiff");
        arrayList.add("text/css");
        arrayList.add("text/html");
        arrayList.add("image/gif");
        arrayList.add(PictureMimeType.PNG_Q);
        arrayList.add(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE);
        arrayList.add("video/mp4");
        arrayList.add("audio/mpeg");
        arrayList.add("application/json");
        arrayList.add("image/webp");
        arrayList.add("image/apng");
        arrayList.add("image/svg+xml");
        arrayList.add(MediaTypeUtils.APPLICATION_OCTET_STREAM);
    }

    public static boolean gy(String str) {
        return bMj.contains(str);
    }
}
