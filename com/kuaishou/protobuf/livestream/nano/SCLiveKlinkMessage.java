package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.SocketMessages;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveKlinkMessage extends MessageNano {
    private static volatile SCLiveKlinkMessage[] _emptyArray;
    public LiveKlinkProcessCondition liveKlinkProcessCondition;
    public byte[] payload;
    public int payloadType;

    public static SCLiveKlinkMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveKlinkMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveKlinkMessage() {
        clear();
    }

    public final SCLiveKlinkMessage clear() {
        this.payloadType = 0;
        this.payload = WireFormatNano.EMPTY_BYTES;
        this.liveKlinkProcessCondition = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.payloadType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.payload);
        }
        LiveKlinkProcessCondition liveKlinkProcessCondition = this.liveKlinkProcessCondition;
        if (liveKlinkProcessCondition != null) {
            codedOutputByteBufferNano.writeMessage(3, liveKlinkProcessCondition);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.payloadType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.payload);
        }
        LiveKlinkProcessCondition liveKlinkProcessCondition = this.liveKlinkProcessCondition;
        return liveKlinkProcessCondition != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, liveKlinkProcessCondition) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveKlinkMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 3:
                    case 4:
                    case 51:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 200:
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                    case 205:
                    case 206:
                    case 207:
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                    case 304:
                    case 305:
                    case 306:
                    case 307:
                    case 308:
                    case 310:
                    case 311:
                    case 312:
                    case 320:
                    case 321:
                    case 322:
                    case 323:
                    case 324:
                    case 325:
                    case 326:
                    case 327:
                    case 328:
                    case 329:
                    case 330:
                    case 331:
                    case 340:
                    case SocketMessages.PayloadType.SC_LIVE_QUIZ_QUESTION_ASKED /* 350 */:
                    case 351:
                    case 352:
                    case 353:
                    case 354:
                    case 355:
                    case 356:
                    case 357:
                    case 360:
                    case 361:
                    case 362:
                    case 363:
                    case 370:
                    case 371:
                    case 380:
                    case 381:
                    case 382:
                    case 383:
                    case 384:
                    case 385:
                    case 386:
                    case 387:
                    case 388:
                    case 389:
                    case 390:
                    case 391:
                    case 399:
                    case 400:
                    case 401:
                    case 402:
                    case 403:
                    case SocketMessages.PayloadType.SC_WISH_LIST_OPENED /* 410 */:
                    case SocketMessages.PayloadType.SC_WISH_LIST_CLOSED /* 411 */:
                    case SocketMessages.PayloadType.SC_RIDE_CHANGED /* 412 */:
                    case 414:
                    case 415:
                    case 416:
                    case SocketMessages.PayloadType.SC_FANS_TOP_OPENED /* 417 */:
                    case 418:
                    case SocketMessages.PayloadType.SC_POP_COMMODITY /* 419 */:
                    case 420:
                    case 421:
                    case 422:
                    case 423:
                    case 424:
                    case 425:
                    case 426:
                    case SocketMessages.PayloadType.SC_RED_PACK_RAIN_RESOURCE /* 427 */:
                    case 430:
                    case 431:
                    case 432:
                    case 433:
                    case SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION /* 434 */:
                    case SocketMessages.PayloadType.SC_MIC_SEATS_MIC_FORCED_STATUS /* 435 */:
                    case SocketMessages.PayloadType.SC_MIC_SEATS_APPLY_INFO /* 436 */:
                    case SocketMessages.PayloadType.SC_VOICE_PARTY_COMMON_INFO /* 437 */:
                    case SocketMessages.PayloadType.SC_VOICE_PARTY_ENTER_ROOM_NOTICE /* 438 */:
                    case SocketMessages.PayloadType.SC_MIC_SEATS_INFO /* 439 */:
                    case SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION_INFO /* 440 */:
                    case SocketMessages.PayloadType.SC_BET_CHANGED /* 441 */:
                    case SocketMessages.PayloadType.SC_BET_CLOSED /* 442 */:
                    case 460:
                    case 461:
                    case 462:
                    case 463:
                    case 470:
                    case 471:
                    case 472:
                    case 474:
                    case 475:
                    case 476:
                    case 477:
                    case 478:
                    case 479:
                    case 480:
                    case 481:
                    case SocketMessages.PayloadType.SC_AUTHOR_CHAT_END /* 482 */:
                    case SocketMessages.PayloadType.SC_AUTHOR_CHAT_REJECT /* 483 */:
                    case SocketMessages.PayloadType.SC_AUTHOR_MUSIC_OPENED /* 490 */:
                    case SocketMessages.PayloadType.SC_AUTHOR_MUSIC_CLOSED /* 491 */:
                    case 500:
                    case 501:
                    case 510:
                    case 511:
                    case 521:
                    case 522:
                    case 531:
                    case 532:
                    case 533:
                    case 541:
                    case 542:
                    case 550:
                    case 551:
                    case 552:
                    case 553:
                    case 554:
                    case 560:
                    case 561:
                    case 562:
                    case 565:
                    case 570:
                    case 571:
                    case 581:
                    case 582:
                    case 583:
                    case 584:
                    case 585:
                    case 586:
                    case 587:
                    case 588:
                    case 590:
                    case 591:
                    case 592:
                    case 593:
                    case 594:
                    case 595:
                    case 596:
                    case 600:
                    case 601:
                    case 602:
                    case 603:
                    case 604:
                    case 605:
                    case 606:
                    case 607:
                    case 608:
                    case 610:
                    case 611:
                    case 612:
                    case 613:
                    case 614:
                    case 615:
                    case 616:
                    case 617:
                    case 620:
                    case 621:
                    case 622:
                    case 623:
                    case 630:
                    case 631:
                    case 632:
                    case 633:
                    case SocketMessages.PayloadType.SC_THEATER_EPISODE_SWITCH_TOAST /* 634 */:
                    case 641:
                    case 642:
                    case 643:
                    case 644:
                    case 645:
                    case 646:
                    case 647:
                    case 648:
                    case 649:
                    case 650:
                    case 651:
                    case 652:
                    case 653:
                    case 654:
                    case 655:
                    case 656:
                    case 657:
                    case 660:
                    case 661:
                    case 662:
                    case 663:
                    case 664:
                    case 665:
                    case 666:
                    case 667:
                    case 670:
                    case 671:
                    case 672:
                    case 673:
                    case 674:
                    case 675:
                    case 676:
                    case 677:
                    case 678:
                    case 679:
                    case 680:
                    case 681:
                    case 682:
                    case 683:
                    case 684:
                    case 685:
                    case 686:
                    case 687:
                    case 688:
                    case 689:
                    case 690:
                    case 691:
                    case 692:
                    case 693:
                    case 694:
                    case 695:
                    case 696:
                    case 697:
                    case 698:
                    case 699:
                    case 700:
                    case 701:
                    case 702:
                    case 703:
                    case 704:
                    case 705:
                    case 706:
                    case 707:
                    case 708:
                    case 709:
                    case 710:
                    case 711:
                    case 712:
                    case 713:
                    case 714:
                    case 715:
                    case 716:
                    case 717:
                    case 718:
                    case 719:
                    case 720:
                    case 721:
                    case 722:
                    case 723:
                    case 727:
                    case 728:
                    case SocketMessages.PayloadType.SC_LIVE_FANS_TOP_QUICK_ORDER_NOTICE /* 729 */:
                    case SocketMessages.PayloadType.SC_LIVE_LINE_CHAT_INVITE /* 730 */:
                    case SocketMessages.PayloadType.SC_LIVE_LINE_CHAT_MATCHED /* 731 */:
                    case SocketMessages.PayloadType.SC_LIVE_LINE_CHAT_READY /* 732 */:
                    case SocketMessages.PayloadType.SC_LIVE_LINE_CHAT_END /* 733 */:
                    case SocketMessages.PayloadType.SC_LIVE_LINE_CHAT_INFO_UPDATE /* 734 */:
                    case SocketMessages.PayloadType.SC_LIVE_CONDITION_RED_PACK /* 735 */:
                    case SocketMessages.PayloadType.SC_LIVE_CONDITION_RED_PACK_UPDATE /* 736 */:
                    case SocketMessages.PayloadType.SC_LIVE_CONDITION_RED_PACK_ROLL_USER /* 737 */:
                    case SocketMessages.PayloadType.SC_LIVE_CONDITION_RED_PACK_OPEN /* 738 */:
                    case SocketMessages.PayloadType.SC_LIVE_CONDITION_RED_PACK_CLOSE /* 739 */:
                    case SocketMessages.PayloadType.SC_GZONE_ACCOMPANY_ENTRANCE_SHOW /* 740 */:
                    case SocketMessages.PayloadType.SC_GZONE_ACCOMPANY_ENTRANCE_HIDE /* 741 */:
                    case SocketMessages.PayloadType.SC_GZONE_ACCOMPANY_STATE_REFRESH /* 742 */:
                    case SocketMessages.PayloadType.SC_KWAISHOP_ARROW_MESSAGE /* 743 */:
                    case SocketMessages.PayloadType.SC_LIVE_OVER_ROOM_MESSAGE /* 744 */:
                    case SocketMessages.PayloadType.SC_LIVE_CHAT_CALL_V2 /* 745 */:
                    case SocketMessages.PayloadType.SC_LIVE_OVER_ROOM_MESSAGE_V2 /* 746 */:
                    case SocketMessages.PayloadType.SC_LIVE_BEAUTY_LABEL_CHANGE /* 747 */:
                    case SocketMessages.PayloadType.SC_LIVE_TREASURE_BOX_SHOW /* 748 */:
                    case SocketMessages.PayloadType.SC_LIVE_ROOM_VOICE_NOTIFICATION_MESSAGE /* 749 */:
                    case 750:
                    case 751:
                    case 752:
                    case 753:
                    case 754:
                    case 755:
                    case 756:
                    case 757:
                    case 758:
                    case 759:
                    case 760:
                    case 761:
                    case 762:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_ABOARD_APPLY_RESULT /* 763 */:
                    case SocketMessages.PayloadType.SC_LIVE_TOP_USER_FORBIDDEN_DIALOG /* 764 */:
                    case SocketMessages.PayloadType.SC_LIVE_TAG_UPDATE /* 765 */:
                    case SocketMessages.PayloadType.SC_LIVE_TAG_CLOSE /* 766 */:
                    case SocketMessages.PayloadType.SC_LIVE_PK_KO_INFO /* 767 */:
                    case SocketMessages.PayloadType.SC_LIVE_PK_KO_MODE /* 768 */:
                    case 770:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_OUTSIDE_MESSAGE /* 771 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_CALL /* 772 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_GUEST_REJECTED /* 773 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_USER_INFO /* 774 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_USER_LEAVE_INFO /* 775 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_CLOSED /* 776 */:
                    case SocketMessages.PayloadType.SC_KWAISHOP_AUCTION_NOTICE /* 777 */:
                    case SocketMessages.PayloadType.SC_COMMENT_FOLDING_MESSAGE /* 778 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_MATE_COVER_AUDIT_STATUS_PUSH /* 779 */:
                    case 780:
                    case 781:
                    case 782:
                    case SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_INFO /* 785 */:
                    case SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_USER_APPLY_AUTHOR_ACCEPT /* 786 */:
                    case SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_USER_APPLY_AUTHOR_REJECT /* 787 */:
                    case SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_LEFT /* 788 */:
                    case SocketMessages.PayloadType.SC_GAME_INTERACTION_MIC_SEATS_APPLY_INFO /* 789 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_RAMPAGE /* 790 */:
                    case SocketMessages.PayloadType.SC_GZONE_PREDICTION_SHOW /* 791 */:
                    case SocketMessages.PayloadType.SC_GZONE_PREDICTION_HIDE /* 792 */:
                    case SocketMessages.PayloadType.SC_LIVE_UNION_LIVE_INVITE_INVALID /* 794 */:
                    case SocketMessages.PayloadType.SC_LIVE_UNION_LIVE_APPLY_INVALID /* 795 */:
                    case SocketMessages.PayloadType.SC_LIVE_UNION_LIVE_AUTHORITY_CHANGED /* 796 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_PANEL_REFRESH /* 797 */:
                    case SocketMessages.PayloadType.SC_LIVE_HOUR_RANK_INFO /* 798 */:
                    case SocketMessages.PayloadType.SC_LIVE_MAGIC_FACE_STATE /* 799 */:
                    case 800:
                    case 801:
                    case 803:
                    case 804:
                    case 805:
                    case 806:
                    case 807:
                    case 808:
                    case 809:
                    case 810:
                    case 811:
                    case 812:
                    case 813:
                    case 814:
                    case 815:
                    case 816:
                    case 817:
                    case 818:
                    case 819:
                    case 820:
                    case 821:
                    case 822:
                    case 823:
                    case 824:
                    case 825:
                    case 826:
                    case 827:
                    case 828:
                    case 829:
                    case 830:
                    case 831:
                    case 832:
                    case 833:
                    case 834:
                    case 835:
                    case 836:
                    case 837:
                    case 838:
                    case 839:
                    case 840:
                    case 841:
                    case 842:
                    case 843:
                    case 844:
                    case 845:
                    case 846:
                    case 847:
                    case 848:
                    case 849:
                    case 850:
                    case 851:
                    case 852:
                    case 853:
                    case 854:
                    case 856:
                    case SocketMessages.PayloadType.SC_KWAISHOP_LIVE_SKY_FALL_PENDANT_DESTROY /* 857 */:
                    case SocketMessages.PayloadType.SC_LIVE_POPULARITY_RANK_INFO /* 858 */:
                    case SocketMessages.PayloadType.SC_LIVE_POPULARITY_RANK_CLOSED /* 859 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_GUEST_VIDEO_AUTHORITY /* 860 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_INVITE_GUEST_OPEN_VIDEO /* 861 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_CLOSE_GUEST_VIDEO /* 862 */:
                    case SocketMessages.PayloadType.SC_KWAISHOP_LIVE_ITEM_PENDANT /* 863 */:
                    case SocketMessages.PayloadType.SC_LIVE_FANS_GROUP_ATTACH_GIFT_REPLACE_NOTICE /* 864 */:
                    case SocketMessages.PayloadType.SC_KWAISHOP_LIVE_COMMON_DIALOG /* 865 */:
                    case SocketMessages.PayloadType.SC_KWAISHOP_LIVE_COMMON_TOAST /* 866 */:
                    case SocketMessages.PayloadType.SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT /* 867 */:
                    case SocketMessages.PayloadType.SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT_CLOSE /* 868 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_APPLY /* 869 */:
                    case 870:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_APPLY_REJECT /* 871 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_MATCHED /* 872 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_INFO_UPDATE /* 873 */:
                    case SocketMessages.PayloadType.SC_LIVE_GUIDE_FOLLOW_AUTHOR_CARD_INFO /* 874 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_MATE_MESSAGE_CENTER_NOTIFY /* 875 */:
                    case SocketMessages.PayloadType.SC_LIVE_CORE_USER_CRM_ROOM_ACTION /* 876 */:
                    case SocketMessages.PayloadType.SC_LIVE_CORE_USER_CRM_INTERACTIVE_CHANGE /* 877 */:
                    case SocketMessages.PayloadType.SC_LIVE_EXCLUSIVE_COMMON_ROUTE /* 878 */:
                    case SocketMessages.PayloadType.SC_LIVE_KLINK_MESSAGE /* 879 */:
                    case 880:
                    case 881:
                    case 882:
                    case 883:
                    case 884:
                    case 885:
                    case 886:
                    case 887:
                    case SocketMessages.PayloadType.SC_LIVE_WISHROOM_BULLET_COMMENT_PUSH_INFOS /* 888 */:
                    case 889:
                    case 890:
                    case 891:
                    case SocketMessages.PayloadType.SC_LIVE_REVENUE_ACTIVITY_INFO_UPDATE /* 892 */:
                    case SocketMessages.PayloadType.SC_GZONE_GIFT_LOTTERY_NOTIFY /* 893 */:
                    case SocketMessages.PayloadType.SC_X_STREAM_LIVE_CARD_LIST_INFO /* 894 */:
                    case 900:
                    case 901:
                    case 902:
                    case 903:
                    case 904:
                    case 905:
                    case 906:
                    case SocketMessages.PayloadType.SC_LIVE_RESERVATION_STICKER_INFO /* 907 */:
                    case SocketMessages.PayloadType.SC_LIVE_RESERVATION_STICKER_CLOSE /* 908 */:
                    case 909:
                    case 911:
                    case 912:
                    case SocketMessages.PayloadType.SC_KUAISHOU_NIGHT_LOTTERY_CHANGING /* 913 */:
                    case SocketMessages.PayloadType.SC_LIVE_INTERACTIVE_WIDGET /* 914 */:
                    case SocketMessages.PayloadType.SC_KWAISHOP_RESOURCE_LIVE_PENDANT_DATA /* 915 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_ACTIVITY_COMMON_NOTICE /* 916 */:
                    case SocketMessages.PayloadType.SC_LIVE_PK_BUFF_CARD_MOMENT /* 917 */:
                    case SocketMessages.PayloadType.SC_GZONE_PREDICTION_PK_PROGRESS /* 918 */:
                    case SocketMessages.PayloadType.SC_GZONE_PREDICTION_PK_END /* 919 */:
                    case 920:
                    case 921:
                    case 922:
                    case 923:
                    case 924:
                    case 925:
                    case 926:
                    case 927:
                    case 928:
                    case 929:
                    case 930:
                    case 931:
                    case 932:
                    case 933:
                    case 934:
                    case 935:
                    case 936:
                    case 937:
                    case 938:
                    case 939:
                    case 940:
                    case 941:
                    case 942:
                    case 943:
                    case 944:
                    case 945:
                    case 946:
                    case 947:
                    case 948:
                    case 949:
                    case 950:
                    case 951:
                    case 953:
                    case 954:
                    case 955:
                    case 956:
                    case 957:
                    case SocketMessages.PayloadType.SC_LIVE_USER_TASK_STATUS_UPDATE /* 958 */:
                    case 959:
                    case 960:
                    case 961:
                    case 962:
                    case 963:
                    case 964:
                    case 965:
                    case SocketMessages.PayloadType.SC_LIVE_RECRUIT_SHARE_GUIDE /* 966 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_WIDGET_SHOW_MESSAGE /* 967 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_WIDGET_HIDE_MESSAGE /* 968 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_BOTTOM_POP_UP_MESSAGE /* 969 */:
                    case 970:
                    case SocketMessages.PayloadType.SC_LIVE_RECRUIT_COMMENT_BROADCAST /* 971 */:
                    case SocketMessages.PayloadType.SC_AD_WATCH_LIVE_TASK_SIGNAL /* 972 */:
                    case SocketMessages.PayloadType.SC_MULTI_LINE_CHAT_WISH_LIST /* 973 */:
                    case SocketMessages.PayloadType.SC_LIVE_PK_STATE /* 974 */:
                    case SocketMessages.PayloadType.SC_KWAISHOP_LIVE_SELLER_RANK_PENDANT_V2 /* 975 */:
                    case SocketMessages.PayloadType.SC_LIVE_BLIND_DATE_OPEN /* 976 */:
                    case SocketMessages.PayloadType.SC_LIVE_MULTI_PK_CRIT_MOMENT /* 977 */:
                    case SocketMessages.PayloadType.SC_LIVE_BLIND_DATE_CLOSE /* 978 */:
                    case SocketMessages.PayloadType.SC_LIVE_MULTI_PK_MATCH_GUIDE_SHOW /* 979 */:
                    case 980:
                    case 981:
                    case 982:
                    case 983:
                    case 984:
                    case 985:
                    case 986:
                    case 987:
                    case 988:
                    case 989:
                    case 990:
                    case 991:
                    case 992:
                    case 993:
                    case 994:
                    case 995:
                    case 996:
                    case 997:
                    case 998:
                    case 999:
                    case 1000:
                    case 1001:
                    case 1002:
                    case 1003:
                    case 1004:
                    case 1005:
                    case 1006:
                    case 1007:
                    case 1008:
                    case 1009:
                    case 1010:
                    case 1011:
                    case 1012:
                    case 1013:
                    case 1014:
                    case 1015:
                    case 1016:
                    case 1017:
                    case 1018:
                    case 1019:
                    case 1020:
                    case 1021:
                    case 1022:
                    case 1023:
                    case 1024:
                    case 1025:
                    case 1026:
                    case 1027:
                    case 1028:
                    case 1029:
                    case 1030:
                    case 1031:
                    case 1032:
                    case 1033:
                    case 1034:
                    case 1035:
                    case 1036:
                    case 1037:
                    case 1038:
                    case 1039:
                    case 1040:
                    case 1041:
                    case 1042:
                    case 1043:
                    case 1044:
                    case 1045:
                    case 1046:
                    case 1047:
                    case 1048:
                    case 1049:
                    case 1050:
                    case 1051:
                    case 1052:
                    case 1053:
                    case 1054:
                    case 1055:
                    case 1056:
                    case 1057:
                    case 1058:
                    case 1059:
                    case 1060:
                    case 1061:
                    case 1062:
                    case 1063:
                    case 1064:
                    case 1065:
                    case 1066:
                    case 1067:
                    case 1068:
                    case 1069:
                    case 1070:
                    case 1071:
                    case 1072:
                    case 1073:
                    case 1074:
                    case 1075:
                    case 1076:
                    case 1077:
                    case 1078:
                    case 1079:
                    case 1080:
                    case 1081:
                    case 1082:
                    case 1083:
                    case 1084:
                    case 1085:
                    case 1086:
                    case 1087:
                    case SocketMessages.PayloadType.SC_GIFT_CORNER_RED_DOT_SIGNAL /* 1088 */:
                    case SocketMessages.PayloadType.SC_LIVE_PK_PANEL_NOTICE_TIP_V2 /* 1089 */:
                    case 1090:
                    case 1091:
                    case 1092:
                    case 1093:
                    case 1094:
                    case 1095:
                    case 1096:
                    case 1097:
                    case 1098:
                    case 1099:
                    case 1100:
                    case 1101:
                    case 1102:
                    case 1103:
                    case 1104:
                    case 1105:
                    case 1106:
                    case 1107:
                    case 1108:
                    case 1109:
                    case SocketMessages.PayloadType.SC_LIVE_OFFICIAL_PROGRAMME_DUMP_AUDIENCE /* 1110 */:
                    case SocketMessages.PayloadType.SC_LIVE_OFFICIAL_PROGRAMME_SHUNT_AUDIENCE /* 1111 */:
                    case SocketMessages.PayloadType.SC_LIVE_AUTHOR_HEAD_INFO_CHANGE /* 1112 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_BIG_CARD_SIGNAL /* 1113 */:
                    case SocketMessages.PayloadType.SC_LIVE_HOUSE_ANCHOR_EXPLAIN_CARD_SIGNAL /* 1114 */:
                    case SocketMessages.PayloadType.SC_LIVE_STREAM_LATENCY_CHANGED_SIGNAL /* 1115 */:
                    case SocketMessages.PayloadType.SC_LIVE_INTERACTIVE_CHAT_LAYOUT_CHANGE /* 1116 */:
                    case SocketMessages.PayloadType.SC_LIVE_ACTIVITY_PASTER_SIGNAL /* 1117 */:
                    case SocketMessages.PayloadType.SC_LIVE_LOCAL_LIFE_PENDANT_SHOW_NOTICE /* 1118 */:
                    case SocketMessages.PayloadType.SC_LIVE_LOCAL_LIFE_PENDANT_OPEN_NOTICE /* 1119 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_CANCEL_APPLY /* 1120 */:
                    case SocketMessages.PayloadType.SC_LIVE_IDEAT_COMMENT_BROADCAST /* 1121 */:
                    case SocketMessages.PayloadType.SC_LIVE_STICKER_DECORATION /* 1122 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_SCREEN_DATA_PUSH_STATUS_SIGNAL /* 1123 */:
                    case SocketMessages.PayloadType.SC_LIVE_LOCAL_LIFE_EXPLAIN_CARD_STOCK_NOTICE /* 1124 */:
                    case SocketMessages.PayloadType.SC_LIVE_MODULE_SHIELD_CONFIG_SIGNAL /* 1125 */:
                    case SocketMessages.PayloadType.SC_LIVE_COMMENT_STYLE_CONFIG_SIGNAL /* 1126 */:
                    case SocketMessages.PayloadType.SC_LIVE_RECRUIT_EXPLAIN_PANEL_DISPLAY_SIGNAL /* 1127 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_QUICK_INTERACTIVE_PANEL /* 1128 */:
                    case SocketMessages.PayloadType.SC_LIVE_CHAT_APPLY_USER_CNT_UPDATE /* 1129 */:
                    case 1130:
                    case 1131:
                    case 1132:
                    case 1133:
                    case 1134:
                    case 1135:
                    case 1136:
                    case 1137:
                    case 1138:
                    case 1139:
                    case SocketMessages.PayloadType.SC_LIVE_AUTHOR_RADAR /* 1140 */:
                    case SocketMessages.PayloadType.SC_LIVE_INTERACTIVE_CHAT_ENTER_ROOM /* 1141 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_PLAY_CHAT_ENTRANCE /* 1142 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_PLAY_CHAT_PLACEHOLDER_LAYOUT /* 1143 */:
                    case SocketMessages.PayloadType.SC_GZONE_LUCKY_PLAYER_ENTRANCE_SHOW /* 1144 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_GRID_CHAT_SOLO_PK_STATISTIC /* 1145 */:
                    case SocketMessages.PayloadType.SC_GZONE_PARTNER_EXPLAIN_BIG_CARD_SHOW /* 1146 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_PLAY_BOTTOM_ENTRANCE /* 1147 */:
                    case SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_RESERVATION_AVAILABLE_EVENT /* 1148 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_LAST_LAYOUT_INFO_SNAPSHOT /* 1149 */:
                    case 1150:
                    case 1151:
                    case 1152:
                    case 1153:
                    case 1154:
                    case 1155:
                    case 1156:
                    case 1157:
                    case 1158:
                    case 1159:
                    case 1160:
                    case 1161:
                    case 1162:
                    case 1163:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_RENDER_SIGNAL /* 1164 */:
                    case SocketMessages.PayloadType.SC_ECO_CONSULT_CARD_NOTICE /* 1165 */:
                    case SocketMessages.PayloadType.SC_LIVE_TRAFFIC_OP_PENDANT_CLOSED /* 1166 */:
                    case SocketMessages.PayloadType.SC_LIVE_AUTHOR_PERCEPTION_TOP_USER_CLOSED /* 1167 */:
                    case SocketMessages.PayloadType.SC_LIVE_ORG_RECRUIT_UPDATE /* 1168 */:
                    case SocketMessages.PayloadType.SC_LIVE_ORG_RECRUIT_USER_APPLY_SUCCESS /* 1169 */:
                    case SocketMessages.PayloadType.SC_GZONE_DISPLAY_FACE_PORTRAIT_LAYOUT /* 1170 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_PANEL_ITEM_REFRESH /* 1171 */:
                    case SocketMessages.PayloadType.SC_LIVE_FLOATING_LAYER_RN_OPEN /* 1172 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_PC_ALERT_SIGNAL /* 1173 */:
                    case SocketMessages.PayloadType.SC_LIVE_START_SUPER_FANS_WISH_NOTICE /* 1174 */:
                    case SocketMessages.PayloadType.SC_LIVE_HELP_WISH_NOTICE /* 1175 */:
                    case SocketMessages.PayloadType.SC_LIVE_WISH_POINT_NOTICE /* 1176 */:
                    case SocketMessages.PayloadType.SC_LIVE_ORDERS_ENTRANCE /* 1177 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_ROOM_BOTTOM_MASK_LAYER_STATUS /* 1178 */:
                    case SocketMessages.PayloadType.SC_KTV_SIGNER_VIDEO_STATUS /* 1179 */:
                    case SocketMessages.PayloadType.SC_LIVE_YEAR_CEREMONY23_FINGER_GUESS_QUICK_GIFT_UPDATE /* 1180 */:
                    case SocketMessages.PayloadType.SC_GZONE_CP_PREDICTION_CHANGED /* 1181 */:
                    case SocketMessages.PayloadType.SC_GZONE_CP_ENTRANCE_HIDE /* 1182 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_PLAY_TYPE_SWITCH_NEW /* 1183 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_FANS_ADD_RPR_NOTICE /* 1184 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_REPLACE /* 1185 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_UPDATE_LIKE_TEXT /* 1186 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_ENHANCE_LIKE_DISPLAY /* 1187 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_ENHANCE_VIEW_TEXT /* 1188 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_ENHANCE_PENDANT_DISPLAY /* 1189 */:
                    case 1190:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BATTLE_STATE /* 1191 */:
                    case 1192:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BATTLE_STATISTIC /* 1193 */:
                    case 1194:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_PROGRAM /* 1195 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_RIGHT_BOTTOM_PENDANT_ACTION /* 1196 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_CORE_OPERATION_PENDANT_ACTION /* 1197 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BASIC_OPERATION_PENDANT_REFRESH /* 1198 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BASIC_OPERATION_PENDANT_HIGHLIGHT /* 1199 */:
                    case SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC /* 1200 */:
                    case 1201:
                    case 1203:
                    case 1204:
                    case 1205:
                    case 1206:
                    case 1207:
                    case 1208:
                    case 1209:
                    case 1210:
                    case 1211:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_GIFT_BOOTH_UPDATE /* 1212 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BATTLE_TOKEN_READY /* 1213 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BATTLE_SHOW /* 1214 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_WARMUP_PRAY_PULL_REQUEST /* 1222 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_WARMUP_PRAY_TREASURE_BOX_TOKEN_READY /* 1223 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_CORE_OPERATION_PENDANT_REFRESH /* 1224 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_CDN_DEGRADE_COMMAND /* 1225 */:
                    case SocketMessages.PayloadType.SC_LIVE_QUICK_INTERACT_GIFT_AREA /* 1226 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_INDICATOR_PENDANT /* 1227 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_ENTRANCE_INFO /* 1228 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_SHARE_INFO /* 1229 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_MAGIC_EFFECT /* 1230 */:
                    case SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION /* 1231 */:
                    case SocketMessages.PayloadType.SC_LIVE_QUIZ3_END_WINNER_CALCULATION /* 1232 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_EFFECTIVE_TASK_PROGRESS /* 1233 */:
                    case SocketMessages.PayloadType.SC_LIVE_ACTIVITY_POPUP_ROUTE /* 1234 */:
                    case SocketMessages.PayloadType.SC_LIVE_ACTIVITY_IN_ROOM_PUSH_CNY2024 /* 1235 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_BACK_PACK_INFO /* 1236 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO /* 1237 */:
                    case SocketMessages.PayloadType.SC_LIVE_STREAM_PLATFORM_NOTIFICATION /* 1238 */:
                    case SocketMessages.PayloadType.SC_LIVE_CNY2024_WARMUP_PRAY_WISH_UPDATE /* 1239 */:
                    case SocketMessages.PayloadType.SC_LIVE_QUICK_INTERACT_GIFT_UPDATE /* 1240 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_MATE_AUTHOR_OPEN /* 1241 */:
                    case SocketMessages.PayloadType.SC_GZONE_LIVE_MATE_AUTHOR_CLOSE /* 1242 */:
                    case SocketMessages.PayloadType.SC_GZONE_WATCHING_PLAY_USER_IM_MESSAGE /* 1243 */:
                    case SocketMessages.PayloadType.SC_GZONE_ACTIVITY_LIVE_MARK_MESSAGE /* 1244 */:
                    case SocketMessages.PayloadType.SC_GZONE_ACTIVITY_UPPER_RIGHT_WIDGET_MESSAGE /* 1245 */:
                    case SocketMessages.PayloadType.SC_LIVE_TOOL_PLAY_CUSTOMISE_PANEL_SIGNAL /* 1246 */:
                    case SocketMessages.PayloadType.SC_LIVE_SERVER_SIGNAL_BLOCK_MESSAGE /* 1247 */:
                    case SocketMessages.PayloadType.SC_GIFT_ACHIEVEMENT_OPENED /* 1248 */:
                    case SocketMessages.PayloadType.SC_GIFT_ACHIEVEMENT_CLOSED /* 1249 */:
                    case 1250:
                    case 1251:
                    case 1252:
                    case 1253:
                    case 1254:
                    case 1255:
                    case 1256:
                    case 1257:
                    case 1258:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_VIDEO_OPENED /* 1259 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_VIDEO_CLOSED /* 1260 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_ACHIEVEMENT_NOTICE_USER /* 1261 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_ACHIEVEMENT_USER_SEND_GIFT /* 1262 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_ACHIEVEMENT_LIGHT_ON_NOTICE /* 1263 */:
                    case SocketMessages.PayloadType.SC_LIVE_REVENUE_ALIPAY_DISCOUNT_QUICK_ENTRANCE /* 1264 */:
                    case SocketMessages.PayloadType.SC_LIVE_MULTI_PK_MISSION_START /* 1265 */:
                    case SocketMessages.PayloadType.SC_LIVE_MULTI_PK_MISSION_STATISTIC /* 1266 */:
                    case SocketMessages.PayloadType.SC_LIVE_MULTI_PK_MISSION_EASTER_MOMENT /* 1267 */:
                    case SocketMessages.PayloadType.SC_LIVE_PLUTUS_ENHANCE_MODE /* 1268 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_BOOTH_UPDATE /* 1269 */:
                    case SocketMessages.PayloadType.SC_LIVE_SMALL_PLAY_BOTTOM_UPDATE /* 1270 */:
                    case SocketMessages.PayloadType.SC_LIVE_PARTY_PLAY_APP_CLOSE /* 1271 */:
                    case SocketMessages.PayloadType.SC_LIVE_PARTY_PLAY_ROOM_LAYOUT_UPDATE /* 1272 */:
                    case SocketMessages.PayloadType.SC_LIVE_PARTY_PLAY_SCREEN_CLEAN /* 1273 */:
                    case SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_COMMON_TOAST /* 1274 */:
                    case SocketMessages.PayloadType.SC_LIVE_PARTY_PLAY_BOTTOM_HIDE /* 1275 */:
                    case SocketMessages.PayloadType.SC_LIVE_SMALL_PLAY_RIGHT_BOTTOM_PENDANT /* 1276 */:
                    case SocketMessages.PayloadType.SC_LIVE_POPULARITY_RANK_NEW_TEMPLATE_EFFECT_INFO /* 1277 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_BOTTOM_UPDATE /* 1278 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_LAYOUT_UPDATE /* 1279 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE /* 1280 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_SCREEN_CLEAN /* 1281 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_BOTTOM_HIDE /* 1282 */:
                    case SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_CLOSE_CONNECT_ALERT /* 1283 */:
                    case SocketMessages.PayloadType.SC_LIVE_PARTY_PLAY_STATUS /* 1284 */:
                    case SocketMessages.PayloadType.SC_LIVE_PARTY_PLAY_PARTICIPATE_STATUS /* 1285 */:
                    case SocketMessages.PayloadType.SC_LIVE_REVENUE_FUNCTION_SWITCH_CONFIG /* 1286 */:
                    case SocketMessages.PayloadType.SC_LIVE_POPULARITY_TICKET_ENCOURAGE_BATTLE_INFO /* 1287 */:
                    case SocketMessages.PayloadType.SC_LIVE_GIFT_BANNER_REFRESH_MSG /* 1288 */:
                    case SocketMessages.PayloadType.SC_LIVE_ACTIVITY_ATMOSPHERE_SIGNAL /* 1289 */:
                        this.payloadType = int32;
                        break;
                }
            } else if (tag == 18) {
                this.payload = codedInputByteBufferNano.readBytes();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.liveKlinkProcessCondition == null) {
                    this.liveKlinkProcessCondition = new LiveKlinkProcessCondition();
                }
                codedInputByteBufferNano.readMessage(this.liveKlinkProcessCondition);
            }
        }
    }

    public static SCLiveKlinkMessage parseFrom(byte[] bArr) {
        return (SCLiveKlinkMessage) MessageNano.mergeFrom(new SCLiveKlinkMessage(), bArr);
    }

    public static SCLiveKlinkMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveKlinkMessage().mergeFrom(codedInputByteBufferNano);
    }
}
