package com.ss.texturerender.overlay;

import com.alipay.sdk.m.u.i;
import java.io.Serializable;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FrameTimeQueue {
    private LinkedList<FrameTime> mTimeQueue = new LinkedList<>();

    public void add(FrameTime frameTime) {
        this.mTimeQueue.offer(frameTime);
    }

    public FrameTime poll(long j) {
        FrameTime frameTimePoll = null;
        while (!this.mTimeQueue.isEmpty()) {
            FrameTime frameTimeElement = this.mTimeQueue.element();
            if (j <= frameTimeElement.updateClockTime) {
                if (frameTimePoll == null) {
                    return this.mTimeQueue.poll();
                }
                if (j > frameTimePoll.updateClockTime) {
                    return j - frameTimePoll.updateClockTime < frameTimeElement.updateClockTime - j ? frameTimePoll : this.mTimeQueue.poll();
                }
            }
            frameTimePoll = this.mTimeQueue.poll();
            if (this.mTimeQueue.isEmpty()) {
                return frameTimePoll;
            }
        }
        return null;
    }

    public FrameTime getLast() {
        return this.mTimeQueue.getLast();
    }

    public static class FrameTime implements Serializable {
        public long pts;
        public long updateClockTime;

        public FrameTime(long j, long j2) {
            this.pts = j;
            this.updateClockTime = j2;
        }
    }

    public int getSize() {
        return this.mTimeQueue.size();
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.mTimeQueue.size(); i++) {
            str = str + "pts[" + i + "]:" + this.mTimeQueue.get(i).pts + i.b;
        }
        return str;
    }

    public void clear() {
        this.mTimeQueue.clear();
    }
}
