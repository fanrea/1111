package com.kwad.components.model;

import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_TEXT_IMMERSE(1, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_TEXT_LEFT(2, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_TEXT_RIGHT(3, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_TEXT_ABOVE(4, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_TEXT_BELOW(5, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_TEXT_ABOVE_GROUP(6, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_TEXT_NEW(7, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_CONTENT_11(11, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_CONTENT_12(12, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_CONTENT_13(13, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_THREE_IMAGE(20, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_VERTICAL_ORIGIN(21, FeedDefaultType.FEED_VERTICAL_ORIGIN),
    FEED_TYPE_VERTICAL_NOVEL(21, FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT),
    FEED_TYPE_VERTICAL_BISERIAL(21, FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT);

    private FeedDefaultType mFeedDefaultType;
    private int type;

    private static boolean isH5Type(int i) {
        return i == 7 || i == 8 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i >= 2000;
    }

    public static boolean isNewVerticalType(int i) {
        return i == 21;
    }

    FeedType(int i, FeedDefaultType feedDefaultType) {
        this.type = i;
        this.mFeedDefaultType = feedDefaultType;
    }

    public final int getType() {
        return this.type;
    }

    public final FeedDefaultType getFeedDefaultType() {
        return this.mFeedDefaultType;
    }

    public static FeedType fromInt(int i, int i2) {
        if (isH5Type(i)) {
            return FEED_TYPE_TEXT_NEW;
        }
        for (FeedType feedType : values()) {
            if (feedType.type == i && !isNewVerticalType(i)) {
                return feedType;
            }
            if (feedType.type == i && isNewVerticalType(i) && feedType.mFeedDefaultType.getDefaultType() == i2) {
                return feedType;
            }
        }
        return FEED_TYPE_UNKNOWN;
    }

    public static boolean checkTypeValid(AdTemplate adTemplate) {
        int iBk = a.bk(e.eP(adTemplate));
        if (isH5Type(adTemplate.type)) {
            return true;
        }
        FeedType feedTypeFromInt = fromInt(adTemplate.type, adTemplate.defaultType);
        if (iBk != 1) {
            if (iBk == 2) {
                return (feedTypeFromInt == FEED_TYPE_UNKNOWN || feedTypeFromInt == FEED_TYPE_TEXT_ABOVE_GROUP) ? false : true;
            }
            if (iBk == 3) {
                return (feedTypeFromInt == FEED_TYPE_UNKNOWN || feedTypeFromInt == FEED_TYPE_VERTICAL_ORIGIN || feedTypeFromInt == FEED_TYPE_VERTICAL_NOVEL || feedTypeFromInt == FEED_TYPE_VERTICAL_BISERIAL) ? false : true;
            }
            if (iBk != 8) {
                return false;
            }
        }
        return feedTypeFromInt == FEED_TYPE_TEXT_ABOVE || feedTypeFromInt == FEED_TYPE_TEXT_BELOW || feedTypeFromInt == FEED_TYPE_TEXT_IMMERSE || feedTypeFromInt == FEED_TYPE_VERTICAL_ORIGIN || feedTypeFromInt == FEED_TYPE_VERTICAL_NOVEL || feedTypeFromInt == FEED_TYPE_VERTICAL_BISERIAL;
    }

    public enum FeedDefaultType {
        FEED_VERTICAL_ORIGIN(0),
        FEED_VERTICAL_NOVEL_DEFAULT(1),
        FEED_VERTICAL_BISERIAL_DEFAULT(2);

        private int defaultType;

        FeedDefaultType(int i) {
            this.defaultType = i;
        }

        public final int getDefaultType() {
            return this.defaultType;
        }
    }
}
