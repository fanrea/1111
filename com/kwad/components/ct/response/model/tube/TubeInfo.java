package com.kwad.components.ct.response.model.tube;

import com.kwad.sdk.core.response.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeInfo extends a implements Serializable {
    private static final long serialVersionUID = 4200733339719277993L;
    public long authorId;
    public String authorName;
    public String coverUrl;
    public List<Integer> episodeNumberList = new ArrayList();
    public int freeEpisodeCount;
    public boolean isFinished;
    public String lastEpisodeName;
    public int lastEpisodeNum;
    public long lastWatchTime;
    public boolean mIsShowTitle;
    public String name;
    public int nextLockedEpisodeNum;
    public int pcursor;
    public String recoReason;
    public String secondChannelName;
    public String summary;
    public List<String> tagList;
    public int totalEpisodeSize;
    public long tubeId;
    public int unlockEpisodeCount;
    public int viewCount;
    public boolean viewCountHide;
    public int watchEpisodeNum;
}
