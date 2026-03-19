package com.sigmob.windad.rewardVideo;

import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindRewardInfo {
    private final boolean a;
    private HashMap<String, String> b;

    public WindRewardInfo(boolean isReward) {
        this.a = isReward;
    }

    public WindRewardInfo(boolean isReward, HashMap<String, String> options) {
        this.a = isReward;
        this.b = options;
    }

    public HashMap<String, String> getOptions() {
        return this.b;
    }

    public boolean isReward() {
        return this.a;
    }

    public void setOptions(HashMap<String, String> options) {
        this.b = options;
    }

    public String toString() {
        return "WindRewardInfo{isReward=" + this.a + ", options=" + this.b + '}';
    }
}
