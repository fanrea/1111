package com.kwad.components.ct.response.a;

import android.text.TextUtils;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    public static long a(NewsInfo newsInfo) {
        return newsInfo.photoId;
    }

    public static int b(NewsInfo newsInfo) {
        return newsInfo.contentSourceType;
    }

    public static String c(NewsInfo newsInfo) {
        return newsInfo.templateUrl;
    }

    public static String d(NewsInfo newsInfo) {
        return newsInfo.title;
    }

    public static String e(NewsInfo newsInfo) {
        return (newsInfo.authorInfo.rawAuthorName == null || newsInfo.authorInfo.rawAuthorName == "") ? "来源" : newsInfo.authorInfo.rawAuthorName;
    }

    public static String f(NewsInfo newsInfo) {
        return newsInfo.graphicSourceDesc;
    }

    public static long g(NewsInfo newsInfo) {
        return newsInfo.publishTimestamp;
    }

    public static String h(NewsInfo newsInfo) {
        return j(newsInfo).url;
    }

    public static com.kwad.sdk.core.response.model.b i(NewsInfo newsInfo) {
        NewsInfo.ImageInfo imageInfoJ = j(newsInfo);
        return new com.kwad.sdk.core.response.model.b(imageInfoJ.url, imageInfoJ.width, imageInfoJ.height, false, false);
    }

    public static NewsInfo.ImageInfo j(NewsInfo newsInfo) {
        List<NewsInfo.ImageInfo> list = newsInfo.thumbnailInfo;
        if (list == null || list.isEmpty()) {
            return new NewsInfo.ImageInfo();
        }
        for (NewsInfo.ImageInfo imageInfo : list) {
            if (!TextUtils.isEmpty(imageInfo.url)) {
                return imageInfo;
            }
        }
        return new NewsInfo.ImageInfo();
    }

    public static int k(NewsInfo newsInfo) {
        if (m(newsInfo)) {
            return 1;
        }
        if (n(newsInfo)) {
            return 3;
        }
        return o(newsInfo) ? 2 : 0;
    }

    public static List<NewsInfo.ImageInfo> l(NewsInfo newsInfo) {
        if (newsInfo.thumbnailInfo == null) {
            return new ArrayList();
        }
        return newsInfo.thumbnailInfo;
    }

    public static boolean m(NewsInfo newsInfo) {
        return newsInfo.thumbnailInfo == null || newsInfo.thumbnailInfo.isEmpty();
    }

    public static boolean n(NewsInfo newsInfo) {
        return newsInfo.thumbnailInfo != null && newsInfo.thumbnailInfo.size() > 0 && newsInfo.thumbnailInfo.size() < 3;
    }

    public static boolean o(NewsInfo newsInfo) {
        return newsInfo.thumbnailInfo != null && newsInfo.thumbnailInfo.size() >= 3;
    }

    public static String p(NewsInfo newsInfo) {
        return newsInfo.authorInfo.authorIcon;
    }
}
