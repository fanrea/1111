package com.kuaishou.protobuf.livestream.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCommentTypeProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommentType {
        public static final int COMMENT_TYPE_UNKNOWN = 0;
        public static final int EMOTICON_COMMENT = 4;
        public static final int NORMAL_COMMENT = 1;
        public static final int SPRING_FESTIVAL_COMMENT = 2;
        public static final int VOICE_COMMENT = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveTextCommentSubBiz {
        public static final int BULLET_COMMENT = 4;
        public static final int COMBO_COMBINE_COMMENT = 3;
        public static final int COPIED_COMMENT = 2;
        public static final int INNER_COMMENT = 5;
        public static final int QUICK_GIFT_COMMENT = 8;
        public static final int QUIZ_COMMENT = 7;
        public static final int UNKNOWN_SUB_BIZ = 0;
        public static final int USER_COMMENT = 1;
        public static final int USER_EMOTICON_COMMENT = 9;
        public static final int VOICE_TRANSFORM = 6;
    }
}
