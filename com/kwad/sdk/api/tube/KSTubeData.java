package com.kwad.sdk.api.tube;

import com.kwad.sdk.api.core.KsAdSdkApi;
import java.io.Serializable;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSTubeData implements Serializable {
    private static final long serialVersionUID = -2618824273024970605L;
    private String authorId;
    private String authorName;
    private String coverUrl;
    private int episodeNumber;
    private int freeEpisodeCount;
    private boolean isFinished;
    private boolean locked;
    private long playCount;
    private int totalEpisodeCount;
    private long tubeId;
    private String tubeName;
    private int unlockEpisodeCount;
    private String videoDesc;

    private KSTubeData() {
    }

    public static KSTubeData obtain() {
        return new KSTubeData();
    }

    public KSTubeData setAuthorId(String str) {
        this.authorId = str;
        return this;
    }

    public KSTubeData setAuthorName(String str) {
        this.authorName = str;
        return this;
    }

    public KSTubeData setTubeId(long j) {
        this.tubeId = j;
        return this;
    }

    public KSTubeData setTubeName(String str) {
        this.tubeName = str;
        return this;
    }

    public KSTubeData setEpisodeNumber(int i) {
        this.episodeNumber = i;
        return this;
    }

    public KSTubeData setTotalEpisodeCount(int i) {
        this.totalEpisodeCount = i;
        return this;
    }

    public KSTubeData setPlayCount(long j) {
        this.playCount = j;
        return this;
    }

    public KSTubeData setCoverUrl(String str) {
        this.coverUrl = str;
        return this;
    }

    public KSTubeData setFinished(boolean z) {
        this.isFinished = z;
        return this;
    }

    public KSTubeData setLocked(boolean z) {
        this.locked = z;
        return this;
    }

    public KSTubeData setFreeEpisodeCount(int i) {
        this.freeEpisodeCount = i;
        return this;
    }

    public KSTubeData setUnlockEpisodeCount(int i) {
        this.unlockEpisodeCount = i;
        return this;
    }

    public KSTubeData setVideoDesc(String str) {
        this.videoDesc = str;
        return this;
    }

    public String getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public long getTubeId() {
        return this.tubeId;
    }

    public String getTubeName() {
        return this.tubeName;
    }

    public int getEpisodeNumber() {
        return this.episodeNumber;
    }

    public int getTotalEpisodeCount() {
        return this.totalEpisodeCount;
    }

    public long getPlayCount() {
        return this.playCount;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public int getFreeEpisodeCount() {
        return this.freeEpisodeCount;
    }

    public int getUnlockEpisodeCount() {
        return this.unlockEpisodeCount;
    }

    public String getVideoDesc() {
        return this.videoDesc;
    }

    public String toString() {
        return "KSTubeData{authorId='" + this.authorId + "', authorName='" + this.authorName + "', tubeId=" + this.tubeId + ", tubeName='" + this.tubeName + "', episodeNumber=" + this.episodeNumber + ", totalEpisodeCount=" + this.totalEpisodeCount + ", playCount=" + this.playCount + ", coverUrl='" + this.coverUrl + "', isFinished=" + this.isFinished + ", locked=" + this.locked + ", freeEpisodeCount=" + this.freeEpisodeCount + ", unlockEpisodeCount=" + this.unlockEpisodeCount + ", videoDesc=" + this.videoDesc + '}';
    }
}
