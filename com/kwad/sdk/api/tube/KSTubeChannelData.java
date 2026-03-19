package com.kwad.sdk.api.tube;

import com.kwad.sdk.api.core.KsAdSdkApi;
import java.io.Serializable;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSTubeChannelData implements Serializable {
    private static final long serialVersionUID = -1798077816653692263L;
    private String authorId;
    private String authorName;
    private String coverUrl;
    private int freeEpisodeCount;
    private String innerDataStr;
    private boolean isFinished;
    private int lastEpisodeNum;
    private long lastWatchTime;
    private long playCount;
    private String secondChannelName;
    private int totalEpisodeCount;
    private long tubeId;
    private String tubeName;
    private int unlockEpisodeCount;
    private int watchEpisodeNum;

    private KSTubeChannelData() {
    }

    public static KSTubeChannelData obtain() {
        return new KSTubeChannelData();
    }

    public KSTubeChannelData setAuthorId(String str) {
        this.authorId = str;
        return this;
    }

    public KSTubeChannelData setAuthorName(String str) {
        this.authorName = str;
        return this;
    }

    public KSTubeChannelData setTubeId(long j) {
        this.tubeId = j;
        return this;
    }

    public KSTubeChannelData setTubeName(String str) {
        this.tubeName = str;
        return this;
    }

    public KSTubeChannelData setTotalEpisodeCount(int i) {
        this.totalEpisodeCount = i;
        return this;
    }

    public KSTubeChannelData setPlayCount(long j) {
        this.playCount = j;
        return this;
    }

    public KSTubeChannelData setCoverUrl(String str) {
        this.coverUrl = str;
        return this;
    }

    public KSTubeChannelData setFinished(boolean z) {
        this.isFinished = z;
        return this;
    }

    public KSTubeChannelData setFreeEpisodeCount(int i) {
        this.freeEpisodeCount = i;
        return this;
    }

    public KSTubeChannelData setUnlockEpisodeCount(int i) {
        this.unlockEpisodeCount = i;
        return this;
    }

    public KSTubeChannelData setSecondChannelName(String str) {
        this.secondChannelName = str;
        return this;
    }

    public KSTubeChannelData setLastEpisodeNum(int i) {
        this.lastEpisodeNum = i;
        return this;
    }

    public KSTubeChannelData setLastWatchTime(long j) {
        this.lastWatchTime = j;
        return this;
    }

    public KSTubeChannelData setWatchEpisodeNum(int i) {
        this.watchEpisodeNum = i;
        return this;
    }

    public KSTubeChannelData setInnerDataStr(String str) {
        this.innerDataStr = str;
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

    public int getFreeEpisodeCount() {
        return this.freeEpisodeCount;
    }

    public int getUnlockEpisodeCount() {
        return this.unlockEpisodeCount;
    }

    public String getSecondChannelName() {
        return this.secondChannelName;
    }

    public int getLastEpisodeNum() {
        return this.lastEpisodeNum;
    }

    public long getLastWatchTime() {
        return this.lastWatchTime;
    }

    public int getWatchEpisodeNum() {
        return this.watchEpisodeNum;
    }

    public String getInnerDataStr() {
        return this.innerDataStr;
    }

    public String toString() {
        return "KSTubeChannelData{authorId='" + this.authorId + "', authorName='" + this.authorName + "', tubeId=" + this.tubeId + ", tubeName='" + this.tubeName + "', totalEpisodeCount=" + this.totalEpisodeCount + ", playCount=" + this.playCount + ", coverUrl='" + this.coverUrl + "', isFinished=" + this.isFinished + ", freeEpisodeCount=" + this.freeEpisodeCount + ", unlockEpisodeCount=" + this.unlockEpisodeCount + ", secondChannelName='" + this.secondChannelName + "', lastEpisodeNum=" + this.lastEpisodeNum + ", lastWatchTime=" + this.lastWatchTime + ", watchEpisodeNum='" + this.watchEpisodeNum + "'}";
    }
}
