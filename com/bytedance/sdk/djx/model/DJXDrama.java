package com.bytedance.sdk.djx.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrama {
    public static final int STATUS_DRAMA_FINISHED = 0;
    public static final int STATUS_DRAMA_UNFINISHED = 1;
    public String coverImage;
    public List<DJXImage> coverImages2;
    public long createTime;
    public String desc;
    public List<DJXEpisodeStatus> episodeStatusList;
    public int freeSet;
    public long groupId;
    public String icpNumber;
    public long id;
    public boolean isPotential;
    public int levelLabel;
    public int lockSet;
    public String scriptAuthor;
    public String scriptName;
    public String title;
    public int total;
    public String type;
    public int typeId;

    @Deprecated
    public int unlockIndex;
    public int status = 0;
    public int index = 0;
    public long actionTime = 0;
    public boolean isFavor = false;
    public long favoriteTime = 0;
    public int favoriteCount = 0;
    public Map<String, Object> recMap = new HashMap();

    public String toString() {
        return "DJXDrama{id=" + this.id + "', title='" + this.title + "', coverImage='" + this.coverImage + "', coverImages2='" + this.coverImages2 + "', status=" + this.status + "', total=" + this.total + "', index=" + this.index + "', type='" + this.type + "', desc='" + this.desc + "', scriptName='" + this.scriptName + "', scriptAuthor='" + this.scriptAuthor + "', createTime=" + this.createTime + "', actionTime=" + this.actionTime + ", unlockIndex=" + this.unlockIndex + ", episodeStatuses=" + this.episodeStatusList + ", icpNumber=" + this.icpNumber + ", isFavor=" + this.isFavor + ", favoriteTime=" + this.favoriteTime + ", favoriteCount=" + this.favoriteCount + ", groupId=" + this.groupId + ", isPotential=" + this.isPotential + ", levelLabel=" + this.levelLabel + '}';
    }
}
