package com.google.zxing.oned;

import com.baidu.mobads.container.util.bu;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.kuaishou.socket.nano.SocketMessages;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class EANManufacturerOrgSupport {
    private final List<int[]> ranges = new ArrayList();
    private final List<String> countryIdentifiers = new ArrayList();

    EANManufacturerOrgSupport() {
    }

    String lookupCountryIdentifier(String str) throws NumberFormatException {
        int[] iArr;
        int i;
        initIfNeeded();
        int i2 = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i3 = 0; i3 < size && i2 >= (i = (iArr = this.ranges.get(i3))[0]); i3++) {
            if (iArr.length != 1) {
                i = iArr[1];
            }
            if (i2 <= i) {
                return this.countryIdentifiers.get(i3);
            }
        }
        return null;
    }

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{300, 379}, "FR");
            add(new int[]{380}, "BG");
            add(new int[]{383}, "SI");
            add(new int[]{385}, "HR");
            add(new int[]{387}, "BA");
            add(new int[]{400, SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION_INFO}, "DE");
            add(new int[]{450, 459}, "JP");
            add(new int[]{460, MediaPlayer.MEDIA_PLAYER_OPTION_GET_NETWORK_CONNECT_COUNT}, "RU");
            add(new int[]{471}, "TW");
            add(new int[]{474}, "EE");
            add(new int[]{475}, "LV");
            add(new int[]{476}, "AZ");
            add(new int[]{477}, "LT");
            add(new int[]{478}, "UZ");
            add(new int[]{479}, "LK");
            add(new int[]{480}, "PH");
            add(new int[]{481}, "BY");
            add(new int[]{SocketMessages.PayloadType.SC_AUTHOR_CHAT_END}, "UA");
            add(new int[]{484}, "MD");
            add(new int[]{485}, "AM");
            add(new int[]{486}, "GE");
            add(new int[]{487}, "KZ");
            add(new int[]{489}, "HK");
            add(new int[]{SocketMessages.PayloadType.SC_AUTHOR_MUSIC_OPENED, 499}, "JP");
            add(new int[]{500, 509}, "GB");
            add(new int[]{520}, "GR");
            add(new int[]{bu.h}, ExpandedProductParsedResult.POUND);
            add(new int[]{bu.i}, "CY");
            add(new int[]{531}, "MK");
            add(new int[]{535}, "MT");
            add(new int[]{539}, "IE");
            add(new int[]{540, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_CLOSE_IO_COST}, "BE/LU");
            add(new int[]{560}, "PT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_LINE_STRIDE}, "IS");
            add(new int[]{570, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_TONEW}, "DK");
            add(new int[]{590}, "PL");
            add(new int[]{594}, "RO");
            add(new int[]{599}, "HU");
            add(new int[]{600, 601}, "ZA");
            add(new int[]{603}, "GH");
            add(new int[]{608}, "BH");
            add(new int[]{609}, "MU");
            add(new int[]{611}, "MA");
            add(new int[]{613}, "DZ");
            add(new int[]{616}, "KE");
            add(new int[]{618}, "CI");
            add(new int[]{619}, "TN");
            add(new int[]{621}, "SY");
            add(new int[]{622}, "EG");
            add(new int[]{624}, "LY");
            add(new int[]{625}, "JO");
            add(new int[]{626}, "IR");
            add(new int[]{627}, "KW");
            add(new int[]{628}, "SA");
            add(new int[]{629}, "AE");
            add(new int[]{640, 649}, "FI");
            add(new int[]{690, 695}, "CN");
            add(new int[]{700, 709}, "NO");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_FANS_TOP_QUICK_ORDER_NOTICE}, "IL");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_LINE_CHAT_INVITE, SocketMessages.PayloadType.SC_LIVE_CONDITION_RED_PACK_CLOSE}, "SE");
            add(new int[]{SocketMessages.PayloadType.SC_GZONE_ACCOMPANY_ENTRANCE_SHOW}, "GT");
            add(new int[]{SocketMessages.PayloadType.SC_GZONE_ACCOMPANY_ENTRANCE_HIDE}, "SV");
            add(new int[]{SocketMessages.PayloadType.SC_GZONE_ACCOMPANY_STATE_REFRESH}, "HN");
            add(new int[]{SocketMessages.PayloadType.SC_KWAISHOP_ARROW_MESSAGE}, "NI");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_OVER_ROOM_MESSAGE}, "CR");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_CHAT_CALL_V2}, "PA");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_OVER_ROOM_MESSAGE_V2}, "DO");
            add(new int[]{750}, "MX");
            add(new int[]{754, 755}, "CA");
            add(new int[]{759}, "VE");
            add(new int[]{760, 769}, "CH");
            add(new int[]{770}, "CO");
            add(new int[]{SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_GUEST_REJECTED}, "UY");
            add(new int[]{SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_USER_LEAVE_INFO}, "PE");
            add(new int[]{SocketMessages.PayloadType.SC_KWAISHOP_AUCTION_NOTICE}, "BO");
            add(new int[]{SocketMessages.PayloadType.SC_GZONE_LIVE_MATE_COVER_AUDIT_STATUS_PUSH}, "AR");
            add(new int[]{780}, "CL");
            add(new int[]{784}, "PY");
            add(new int[]{SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_INFO}, "PE");
            add(new int[]{SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_USER_APPLY_AUTHOR_ACCEPT}, "EC");
            add(new int[]{SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_APPLY_INFO, SocketMessages.PayloadType.SC_LIVE_GIFT_RAMPAGE}, "BR");
            add(new int[]{800, 839}, "IT");
            add(new int[]{840, 849}, "ES");
            add(new int[]{850}, "CU");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_POPULARITY_RANK_INFO}, "SK");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_POPULARITY_RANK_CLOSED}, "CZ");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_GUEST_VIDEO_AUTHORITY}, "YU");
            add(new int[]{SocketMessages.PayloadType.SC_KWAISHOP_LIVE_COMMON_DIALOG}, "MN");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT}, "KP");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT_CLOSE, SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_APPLY}, "TR");
            add(new int[]{870, SocketMessages.PayloadType.SC_LIVE_KLINK_MESSAGE}, "NL");
            add(new int[]{880}, "KR");
            add(new int[]{885}, "TH");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_WISHROOM_BULLET_COMMENT_PUSH_INFOS}, "SG");
            add(new int[]{890}, "IN");
            add(new int[]{SocketMessages.PayloadType.SC_GZONE_GIFT_LOTTERY_NOTIFY}, "VN");
            add(new int[]{896}, "PK");
            add(new int[]{899}, "ID");
            add(new int[]{900, SocketMessages.PayloadType.SC_GZONE_PREDICTION_PK_END}, "AT");
            add(new int[]{930, 939}, "AU");
            add(new int[]{940, 949}, "AZ");
            add(new int[]{955}, "MY");
            add(new int[]{SocketMessages.PayloadType.SC_LIVE_USER_TASK_STATUS_UPDATE}, "MO");
        }
    }
}
