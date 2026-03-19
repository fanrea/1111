package com.dhylive.app.data.task;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XSTaskInfo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006+"}, d2 = {"Lcom/dhylive/app/data/task/XSTask;", "", "taskId", "", "title", "", "taskIcon", "typeName", "projectTag", "amount", "allNum", "doneUserNum", "doneNum", "spareNum", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V", "getAllNum", "()I", "getAmount", "()Ljava/lang/String;", "getDoneNum", "getDoneUserNum", "getProjectTag", "getSpareNum", "getTaskIcon", "getTaskId", "getTitle", "getTypeName", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class XSTask {

    @SerializedName("all_num")
    private final int allNum;

    @SerializedName("amount")
    private final String amount;

    @SerializedName("done_num")
    private final int doneNum;

    @SerializedName("done_user_num")
    private final int doneUserNum;

    @SerializedName("project_tag")
    private final String projectTag;

    @SerializedName("spare_num")
    private final int spareNum;

    @SerializedName("task_icon")
    private final String taskIcon;

    @SerializedName("task_id")
    private final int taskId;

    @SerializedName("title")
    private final String title;

    @SerializedName("type_name")
    private final String typeName;

    /* renamed from: component1, reason: from getter */
    public final int getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final int getSpareNum() {
        return this.spareNum;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTaskIcon() {
        return this.taskIcon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTypeName() {
        return this.typeName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getProjectTag() {
        return this.projectTag;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component7, reason: from getter */
    public final int getAllNum() {
        return this.allNum;
    }

    /* renamed from: component8, reason: from getter */
    public final int getDoneUserNum() {
        return this.doneUserNum;
    }

    /* renamed from: component9, reason: from getter */
    public final int getDoneNum() {
        return this.doneNum;
    }

    public final XSTask copy(int taskId, String title, String taskIcon, String typeName, String projectTag, String amount, int allNum, int doneUserNum, int doneNum, int spareNum) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(taskIcon, "taskIcon");
        Intrinsics.checkNotNullParameter(typeName, "typeName");
        Intrinsics.checkNotNullParameter(projectTag, "projectTag");
        Intrinsics.checkNotNullParameter(amount, "amount");
        return new XSTask(taskId, title, taskIcon, typeName, projectTag, amount, allNum, doneUserNum, doneNum, spareNum);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XSTask)) {
            return false;
        }
        XSTask xSTask = (XSTask) other;
        return this.taskId == xSTask.taskId && Intrinsics.areEqual(this.title, xSTask.title) && Intrinsics.areEqual(this.taskIcon, xSTask.taskIcon) && Intrinsics.areEqual(this.typeName, xSTask.typeName) && Intrinsics.areEqual(this.projectTag, xSTask.projectTag) && Intrinsics.areEqual(this.amount, xSTask.amount) && this.allNum == xSTask.allNum && this.doneUserNum == xSTask.doneUserNum && this.doneNum == xSTask.doneNum && this.spareNum == xSTask.spareNum;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.taskId) * 31) + this.title.hashCode()) * 31) + this.taskIcon.hashCode()) * 31) + this.typeName.hashCode()) * 31) + this.projectTag.hashCode()) * 31) + this.amount.hashCode()) * 31) + Integer.hashCode(this.allNum)) * 31) + Integer.hashCode(this.doneUserNum)) * 31) + Integer.hashCode(this.doneNum)) * 31) + Integer.hashCode(this.spareNum);
    }

    public String toString() {
        return "XSTask(taskId=" + this.taskId + ", title=" + this.title + ", taskIcon=" + this.taskIcon + ", typeName=" + this.typeName + ", projectTag=" + this.projectTag + ", amount=" + this.amount + ", allNum=" + this.allNum + ", doneUserNum=" + this.doneUserNum + ", doneNum=" + this.doneNum + ", spareNum=" + this.spareNum + ')';
    }

    public XSTask(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "taskIcon");
        Intrinsics.checkNotNullParameter(str3, "typeName");
        Intrinsics.checkNotNullParameter(str4, "projectTag");
        Intrinsics.checkNotNullParameter(str5, "amount");
        this.taskId = i;
        this.title = str;
        this.taskIcon = str2;
        this.typeName = str3;
        this.projectTag = str4;
        this.amount = str5;
        this.allNum = i2;
        this.doneUserNum = i3;
        this.doneNum = i4;
        this.spareNum = i5;
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTaskIcon() {
        return this.taskIcon;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final String getProjectTag() {
        return this.projectTag;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final int getAllNum() {
        return this.allNum;
    }

    public final int getDoneUserNum() {
        return this.doneUserNum;
    }

    public final int getDoneNum() {
        return this.doneNum;
    }

    public final int getSpareNum() {
        return this.spareNum;
    }
}
