package com.bytedance.sdk.djx.core.vod.thumb;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.ThumbM;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ThumbManager {
    private static final String TAG = "ThumbManager";
    private static volatile ThumbManager sInstance;
    private final Map<String, ThumbTask> mTaskMap = new ConcurrentHashMap();

    public static ThumbManager getInstance() {
        if (sInstance == null) {
            synchronized (ThumbManager.class) {
                if (sInstance == null) {
                    sInstance = new ThumbManager();
                }
            }
        }
        return sInstance;
    }

    private ThumbManager() {
    }

    public void getThumb(List<ThumbM> list, DramaDetail dramaDetail, long j, long j2) {
        if (dramaDetail == null || list == null || list.isEmpty()) {
            return;
        }
        String strTaskId = taskId(dramaDetail);
        ThumbTask thumbTask = this.mTaskMap.get(strTaskId);
        if (thumbTask == null) {
            thumbTask = new ThumbTask(list, dramaDetail);
            this.mTaskMap.put(strTaskId, thumbTask);
        }
        thumbTask.handleThumb(j, j2);
    }

    public void cancelTask(DramaDetail dramaDetail) {
        try {
            ThumbTask thumbTaskRemove = this.mTaskMap.remove(taskId(dramaDetail));
            if (thumbTaskRemove != null) {
                thumbTaskRemove.cancel();
            }
        } catch (Exception unused) {
        }
    }

    private String taskId(DramaDetail dramaDetail) {
        return (dramaDetail == null || dramaDetail.getDrama() == null) ? ILogConst.PLAY_SOURCE_DEFAULT : dramaDetail.getDrama().id + Config.replace + dramaDetail.getIndex();
    }
}
