package com.kuaishou.security.kste.logic.model;

import com.kuaishou.security.kste.logic.model.AutoValue_ScheduleTask;
import java.util.concurrent.ScheduledFuture;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ScheduleTask {

    public abstract class Builder {
        public abstract ScheduleTask build();

        public abstract Builder scheduledFutureDelay(ScheduledFuture scheduledFuture);

        public abstract Builder schedulerFinished(boolean z);

        public abstract Builder tag(String str);

        public abstract Builder taskFinished(boolean z);
    }

    public static Builder builder() {
        return new AutoValue_ScheduleTask.Builder();
    }

    public static ScheduleTask create(String str, boolean z, boolean z2, ScheduledFuture scheduledFuture) {
        return builder().tag(str).taskFinished(z).schedulerFinished(z2).scheduledFutureDelay(scheduledFuture).build();
    }

    public abstract ScheduledFuture scheduledFutureDelay();

    public abstract boolean schedulerFinished();

    public abstract String tag();

    public abstract boolean taskFinished();
}
