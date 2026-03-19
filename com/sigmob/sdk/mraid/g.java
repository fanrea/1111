package com.sigmob.sdk.mraid;

import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.sigmob.sdk.base.models.PlacementType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum g {
    CLOSE("close"),
    EXPAND("expand") { // from class: com.sigmob.sdk.mraid.g.1
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN(FeedReqParams.REQ_TYPE_OPEN) { // from class: com.sigmob.sdk.mraid.g.2
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return true;
        }
    },
    feedBack("feedback") { // from class: com.sigmob.sdk.mraid.g.3
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return true;
        }
    },
    UNLOAD("unload"),
    OPENFOURELEMENTS("openFourElements"),
    RESIZE("resize") { // from class: com.sigmob.sdk.mraid.g.4
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo") { // from class: com.sigmob.sdk.mraid.g.5
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    STORE_PICTURE("storePicture") { // from class: com.sigmob.sdk.mraid.g.6
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT("createCalendarEvent") { // from class: com.sigmob.sdk.mraid.g.7
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return true;
        }
    },
    VPAID("vpaid") { // from class: com.sigmob.sdk.mraid.g.8
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return true;
        }
    },
    EXTENSION("extension") { // from class: com.sigmob.sdk.mraid.g.9
        @Override // com.sigmob.sdk.mraid.g
        boolean a(final PlacementType placementType) {
            return true;
        }
    },
    UNSPECIFIED("");

    private final String p;

    g(String javascriptString) {
        this.p = javascriptString;
    }

    public static g a(String string) {
        for (g gVar : values()) {
            if (gVar.p.equals(string)) {
                return gVar;
            }
        }
        return UNSPECIFIED;
    }

    public String a() {
        return this.p;
    }

    boolean a(PlacementType placementType) {
        return false;
    }
}
