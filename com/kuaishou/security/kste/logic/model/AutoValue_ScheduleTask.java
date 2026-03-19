package com.kuaishou.security.kste.logic.model;

import com.alipay.sdk.m.u.i;
import com.kuaishou.security.kste.logic.model.ScheduleTask;
import com.kuaishou.socket.nano.SocketMessages;
import java.util.concurrent.ScheduledFuture;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_ScheduleTask extends ScheduleTask {
    private final ScheduledFuture scheduledFutureDelay;
    private final boolean schedulerFinished;
    private final String tag;
    private final boolean taskFinished;

    final class Builder extends ScheduleTask.Builder {
        private ScheduledFuture scheduledFutureDelay;
        private Boolean schedulerFinished;
        private String tag;
        private Boolean taskFinished;

        Builder() {
        }

        @Override // com.kuaishou.security.kste.logic.model.ScheduleTask.Builder
        public final ScheduleTask build() {
            String str = "";
            if (this.tag == null) {
                str = " tag";
            }
            if (this.taskFinished == null) {
                str = str + " taskFinished";
            }
            if (this.schedulerFinished == null) {
                str = str + " schedulerFinished";
            }
            if (this.scheduledFutureDelay == null) {
                str = str + " scheduledFutureDelay";
            }
            if (str.isEmpty()) {
                return new AutoValue_ScheduleTask(this.tag, this.taskFinished.booleanValue(), this.schedulerFinished.booleanValue(), this.scheduledFutureDelay);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.kuaishou.security.kste.logic.model.ScheduleTask.Builder
        public final ScheduleTask.Builder scheduledFutureDelay(ScheduledFuture scheduledFuture) {
            if (scheduledFuture == null) {
                throw new NullPointerException("Null scheduledFutureDelay");
            }
            this.scheduledFutureDelay = scheduledFuture;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.ScheduleTask.Builder
        public final ScheduleTask.Builder schedulerFinished(boolean z) {
            this.schedulerFinished = Boolean.valueOf(z);
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.ScheduleTask.Builder
        public final ScheduleTask.Builder tag(String str) {
            if (str == null) {
                throw new NullPointerException("Null tag");
            }
            this.tag = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.ScheduleTask.Builder
        public final ScheduleTask.Builder taskFinished(boolean z) {
            this.taskFinished = Boolean.valueOf(z);
            return this;
        }
    }

    private AutoValue_ScheduleTask(String str, boolean z, boolean z2, ScheduledFuture scheduledFuture) {
        this.tag = str;
        this.taskFinished = z;
        this.schedulerFinished = z2;
        this.scheduledFutureDelay = scheduledFuture;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ScheduleTask) {
            ScheduleTask scheduleTask = (ScheduleTask) obj;
            if (this.tag.equals(scheduleTask.tag()) && this.taskFinished == scheduleTask.taskFinished() && this.schedulerFinished == scheduleTask.schedulerFinished() && this.scheduledFutureDelay.equals(scheduleTask.scheduledFutureDelay())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.tag.hashCode() ^ 1000003) * 1000003;
        boolean z = this.taskFinished;
        int i = SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION;
        int i2 = (iHashCode ^ (z ? SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION : SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO)) * 1000003;
        if (!this.schedulerFinished) {
            i = SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO;
        }
        return ((i2 ^ i) * 1000003) ^ this.scheduledFutureDelay.hashCode();
    }

    @Override // com.kuaishou.security.kste.logic.model.ScheduleTask
    public final ScheduledFuture scheduledFutureDelay() {
        return this.scheduledFutureDelay;
    }

    @Override // com.kuaishou.security.kste.logic.model.ScheduleTask
    public final boolean schedulerFinished() {
        return this.schedulerFinished;
    }

    @Override // com.kuaishou.security.kste.logic.model.ScheduleTask
    public final String tag() {
        return this.tag;
    }

    @Override // com.kuaishou.security.kste.logic.model.ScheduleTask
    public final boolean taskFinished() {
        return this.taskFinished;
    }

    public final String toString() {
        return "ScheduleTask{tag=" + this.tag + ", taskFinished=" + this.taskFinished + ", schedulerFinished=" + this.schedulerFinished + ", scheduledFutureDelay=" + this.scheduledFutureDelay + i.d;
    }
}
