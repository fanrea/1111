package com.dhylive.app.data.task;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TJTaskInfo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/dhylive/app/data/task/FirstRecharge;", "", "taskContent", "", "taskDone", "taskGold", "taskIndex", "", "taskSubIndex", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getTaskContent", "()Ljava/lang/String;", "getTaskDone", "getTaskGold", "getTaskIndex", "()I", "getTaskSubIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class FirstRecharge {

    @SerializedName("TaskContent")
    private final String taskContent;

    @SerializedName("TaskDone")
    private final String taskDone;

    @SerializedName("TaskGold")
    private final String taskGold;

    @SerializedName("TaskIndex")
    private final int taskIndex;

    @SerializedName("TaskSubIndex")
    private final int taskSubIndex;

    public static /* synthetic */ FirstRecharge copy$default(FirstRecharge firstRecharge, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = firstRecharge.taskContent;
        }
        if ((i3 & 2) != 0) {
            str2 = firstRecharge.taskDone;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = firstRecharge.taskGold;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i = firstRecharge.taskIndex;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = firstRecharge.taskSubIndex;
        }
        return firstRecharge.copy(str, str4, str5, i4, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskContent() {
        return this.taskContent;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskDone() {
        return this.taskDone;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTaskGold() {
        return this.taskGold;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTaskIndex() {
        return this.taskIndex;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTaskSubIndex() {
        return this.taskSubIndex;
    }

    public final FirstRecharge copy(String taskContent, String taskDone, String taskGold, int taskIndex, int taskSubIndex) {
        Intrinsics.checkNotNullParameter(taskContent, "taskContent");
        Intrinsics.checkNotNullParameter(taskDone, "taskDone");
        Intrinsics.checkNotNullParameter(taskGold, "taskGold");
        return new FirstRecharge(taskContent, taskDone, taskGold, taskIndex, taskSubIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirstRecharge)) {
            return false;
        }
        FirstRecharge firstRecharge = (FirstRecharge) other;
        return Intrinsics.areEqual(this.taskContent, firstRecharge.taskContent) && Intrinsics.areEqual(this.taskDone, firstRecharge.taskDone) && Intrinsics.areEqual(this.taskGold, firstRecharge.taskGold) && this.taskIndex == firstRecharge.taskIndex && this.taskSubIndex == firstRecharge.taskSubIndex;
    }

    public int hashCode() {
        return (((((((this.taskContent.hashCode() * 31) + this.taskDone.hashCode()) * 31) + this.taskGold.hashCode()) * 31) + Integer.hashCode(this.taskIndex)) * 31) + Integer.hashCode(this.taskSubIndex);
    }

    public String toString() {
        return "FirstRecharge(taskContent=" + this.taskContent + ", taskDone=" + this.taskDone + ", taskGold=" + this.taskGold + ", taskIndex=" + this.taskIndex + ", taskSubIndex=" + this.taskSubIndex + ')';
    }

    public FirstRecharge(String str, String str2, String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "taskContent");
        Intrinsics.checkNotNullParameter(str2, "taskDone");
        Intrinsics.checkNotNullParameter(str3, "taskGold");
        this.taskContent = str;
        this.taskDone = str2;
        this.taskGold = str3;
        this.taskIndex = i;
        this.taskSubIndex = i2;
    }

    public final String getTaskContent() {
        return this.taskContent;
    }

    public final String getTaskDone() {
        return this.taskDone;
    }

    public final String getTaskGold() {
        return this.taskGold;
    }

    public final int getTaskIndex() {
        return this.taskIndex;
    }

    public final int getTaskSubIndex() {
        return this.taskSubIndex;
    }
}
