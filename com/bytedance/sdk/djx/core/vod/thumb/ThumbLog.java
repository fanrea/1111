package com.bytedance.sdk.djx.core.vod.thumb;

import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.ThumbM;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ThumbLog {
    public static void download(boolean z, DramaDetail dramaDetail, ThumbM thumbM, long j, int i, String str) {
        if (dramaDetail == null || thumbM == null) {
            return;
        }
        BLogAgent.build("", ILogConst.EVENT_T_THUMB_DOWNLOAD, null).putLong("group_id", dramaDetail.getGroupId()).putString("position", "detail").putLong("duration", j).putInt("index", dramaDetail.getIndex()).putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getDrama() != null ? dramaDetail.getDrama().id : 0L).putInt("result", z ? 1 : 0).putString("video_id", dramaDetail.getVideoId()).putInt("err_code", i).putString("err_msg", str).putInt("width", thumbM.width * thumbM.xLen).putInt("height", thumbM.height * thumbM.yLen).send();
    }

    public static void cut(DramaDetail dramaDetail, ThumbM thumbM, long j) {
        if (dramaDetail == null || thumbM == null) {
            return;
        }
        BLogAgent.build("", ILogConst.EVENT_T_THUMB_CUT, null).putLong("group_id", dramaDetail.getGroupId()).putString("position", "detail").putLong("duration", j).putInt("index", dramaDetail.getIndex()).putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getDrama() != null ? dramaDetail.getDrama().id : 0L).putString("video_id", dramaDetail.getVideoId()).putInt("width", thumbM.width * thumbM.xLen).putInt("height", thumbM.height * thumbM.yLen).putInt("sub_width", thumbM.width).putInt("sub_height", thumbM.height).send();
    }
}
