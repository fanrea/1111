package com.bytedance.sdk.component.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class tt implements Comparable<tt>, Runnable {
    private int mPriority;
    private String name;

    public tt(String str, int i) {
        this.mPriority = 0;
        this.mPriority = i == 0 ? 5 : i;
        this.name = str;
    }

    public tt(String str) {
        this.mPriority = 5;
        this.name = str;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public int getPriority() {
        return this.mPriority;
    }

    @Override // java.lang.Comparable
    public int compareTo(tt ttVar) {
        if (getPriority() < ttVar.getPriority()) {
            return 1;
        }
        return getPriority() >= ttVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.name;
    }
}
