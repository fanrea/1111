package com.kwad.components.ct.response.model.hotspot;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class NewsInfo extends a implements Serializable {
    private static final long serialVersionUID = 2846473099852025182L;
    public String content;
    public int contentSourceType;
    public String graphicSourceDesc;
    public long photoId;
    public long publishTimestamp;
    public String templateUrl;
    public String title;
    public CtPhotoInfo.AuthorInfo authorInfo = new CtPhotoInfo.AuthorInfo();
    public List<ImageInfo> imageInfo = new ArrayList();
    public List<ImageInfo> thumbnailInfo = new ArrayList();

    public static class ImageInfo extends a implements Serializable {
        private static final long serialVersionUID = 4257305450674055184L;
        public int height;
        public String origin;
        public String url;
        public int width;
    }
}
