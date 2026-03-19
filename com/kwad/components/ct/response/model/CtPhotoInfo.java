package com.kwad.components.ct.response.model;

import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.live.LiveInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CtPhotoInfo extends PhotoInfo implements Serializable {
    private static final long serialVersionUID = -7520065240120578865L;
    public AuthorInfo authorInfo;
    public CoverInfo coverInfo;
    public LiveInfo liveInfo;
    public HotspotInfo mHotspotInfo;
    public ProductInfo productInfo;
    public TubeEpisode tubeEpisode;
    public WallpaperInfo wallpaperInfo;

    public static class AuthorInfo extends a implements Serializable {
        private static final long serialVersionUID = 3647144332352243129L;
        public String authorArea;
        public String authorEid;
        public String authorGender;
        public String authorIcon;
        public String authorIconGuide;
        public long authorId;
        public String authorName;
        public String authorText;
        public boolean isJoinedBlacklist;
        public String kwaiId;
        public String rawAuthorName;
    }

    public static class CoverInfo extends a implements Serializable {
        private static final long serialVersionUID = 9136122984250063738L;
        public String blurBackgroundUrl;
        public String blurCoverUrl;
        public String coverUrl;
        public int height;
        public String webpCoverUrl;
        public int width;
    }

    public static class WallpaperInfo extends a implements Serializable {
        private static final long serialVersionUID = -8572865298854850054L;
        public boolean isWallpaperPhoto = false;
    }

    public CtPhotoInfo() {
        this.mHotspotInfo = new HotspotInfo();
        this.coverInfo = new CoverInfo();
        this.authorInfo = new AuthorInfo();
        this.tubeEpisode = new TubeEpisode();
        this.wallpaperInfo = new WallpaperInfo();
        this.productInfo = new ProductInfo();
        this.liveInfo = new LiveInfo();
    }

    public CtPhotoInfo(PhotoInfo photoInfo) {
        this.mHotspotInfo = new HotspotInfo();
        this.coverInfo = new CoverInfo();
        this.authorInfo = new AuthorInfo();
        this.tubeEpisode = new TubeEpisode();
        this.wallpaperInfo = new WallpaperInfo();
        this.productInfo = new ProductInfo();
        this.liveInfo = new LiveInfo();
        parseJson(photoInfo.toJson());
        this.mOriginJString = photoInfo.mOriginJString;
        if (photoInfo instanceof CtPhotoInfo) {
            CtPhotoInfo ctPhotoInfo = (CtPhotoInfo) photoInfo;
            this.mHotspotInfo = ctPhotoInfo.mHotspotInfo;
            this.productInfo.productDetail = ctPhotoInfo.productInfo.productDetail;
        }
    }

    public static class ProductInfo extends a implements Serializable {
        private static final long serialVersionUID = -6976688557388750318L;
        public ProductDetail productDetail = new ProductDetail();
        public String productDetails;
        public long productId;
        public String shennongjiaLog;

        public static class ProductDetail extends a implements Serializable {
            private static final long serialVersionUID = -3610510819973783411L;
            public String linkCode;
            public String nebulaKwaiLink;
            public int platformTypeCode;
            public String strongStyleAdMark;
            public int strongStyleAppearTime;
            public String strongStyleCardUrl;
            public boolean strongStyleEnableClose;
            public long strongStyleItemId;
            public String strongStyleItemPrice;
            public String strongStyleItemUrl;
            public String strongStylePicUrl;
            public String strongStylePriceAfterComm;
            public String strongStyleTitle;
            public String strongStyleUserCommAmountBuying;
            public String strongStyleUserCommAmountSharing;
            public String weakStyleAdMark;
            public int weakStyleAppearTime;
            public boolean weakStyleEnableClose;
            public String weakStyleIcon;
            public int weakStyleShowTime;
            public String weakStyleTitle;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(JSONObject jSONObject) {
            if (this.productDetails == null) {
                return;
            }
            super.afterParseJson(jSONObject);
            try {
                this.productDetail.parseJson(new JSONObject(this.productDetails));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
