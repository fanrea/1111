package com.kwad.components.ct.response.model.live;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LiveInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -6382708726460249425L;
    public int audienceCount;
    public String caption;
    public String coverUrl;
    public String exp_tag;
    public String linkCode;
    public String liveStreamId;
    public String livingLink;
    public String nebulaKwaiLink;
    public transient String pcursor;
    public String playInfo;
    public String shennongjiaLog;
    public String title;
    public User user = new User();
    public CoverUrlCdn coverUrlCdn = new CoverUrlCdn();
    public List<CoverThumbnailUrl> cover_thumbnail_urls = new ArrayList();
    public List<LiveStreamPlayCDNNode> liveStreamPlayCdnList = new ArrayList();

    public static class CoverThumbnailUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -9411857293708312L;
        public String cdn;
        public String url;
        public String urlPattern;
    }

    public static class CoverUrlCdn extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 6749700043335441902L;
        public String coverUrlCdn;
    }

    public static class LiveStreamPlayCDNNode extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 4809830877910908561L;
        public String cdn;
        public String url;
    }

    public static class User extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 8394855164198099170L;
        public List<HeadUrl> headurls = new ArrayList();
        public long user_id;
        public String user_name;

        public static class HeadUrl extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = 7710129978455547652L;
            public String cdn;
            public String url;
        }
    }
}
