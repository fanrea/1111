package com.dhylive.app.data.task;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TJTaskInfo.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003Jó\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001J\u0013\u0010I\u001a\u00020\n2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0016\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010!R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010+R\u0016\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010!R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010!R\u0016\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010!R\u0016\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010!R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010!R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001f¨\u0006M"}, d2 = {"Lcom/dhylive/app/data/task/TJTask;", "", "idTask", "", "appName", "dateStart", "", "dateEnd", "credentialID", "isHot", "", "isSupportOldUser", "byStagesNum", "logo", "label", "", "mtTaskFeeSum", "goldSum", "goldFirst", "unit", "isIng", "isSupportAndroid10", "isIngOther", "raiders", "isLastIng", "idJeType", "isHighCashBack", "firstRecharge", "Lcom/dhylive/app/data/task/FirstRecharge;", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZIILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/util/List;IIILcom/dhylive/app/data/task/FirstRecharge;)V", "getAppName", "()Ljava/lang/String;", "getByStagesNum", "()I", "getCredentialID", "getDateEnd", "getDateStart", "getFirstRecharge", "()Lcom/dhylive/app/data/task/FirstRecharge;", "getGoldFirst", "getGoldSum", "getIdJeType", "getIdTask", "()Z", "getLabel", "()Ljava/util/List;", "getLogo", "getMtTaskFeeSum", "getRaiders", "getUnit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class TJTask {

    @SerializedName("AppName")
    private final String appName;

    @SerializedName("ByStagesNum")
    private final int byStagesNum;

    @SerializedName("CredentialID")
    private final String credentialID;

    @SerializedName("DateEnd")
    private final int dateEnd;

    @SerializedName("DateStart")
    private final int dateStart;

    @SerializedName("firstRecharge")
    private final FirstRecharge firstRecharge;

    @SerializedName("GoldFirst")
    private final String goldFirst;

    @SerializedName("GoldSum")
    private final String goldSum;

    @SerializedName("IDJeType")
    private final int idJeType;

    @SerializedName("IDTask")
    private final String idTask;

    @SerializedName("IsHighCashBack")
    private final int isHighCashBack;

    @SerializedName("IsHot")
    private final boolean isHot;

    @SerializedName("IsIng")
    private final int isIng;

    @SerializedName("IsIngOther")
    private final int isIngOther;

    @SerializedName("IsLastIng")
    private final int isLastIng;

    @SerializedName("IsSupportAndroid10")
    private final int isSupportAndroid10;

    @SerializedName("IsSupportOldUser")
    private final int isSupportOldUser;

    @SerializedName("Label")
    private final List<String> label;

    @SerializedName("Logo")
    private final String logo;

    @SerializedName("MtTaskFeeSum")
    private final String mtTaskFeeSum;

    @SerializedName("Raiders")
    private final List<String> raiders;

    @SerializedName("Unit")
    private final String unit;

    /* renamed from: component1, reason: from getter */
    public final String getIdTask() {
        return this.idTask;
    }

    public final List<String> component10() {
        return this.label;
    }

    /* renamed from: component11, reason: from getter */
    public final String getMtTaskFeeSum() {
        return this.mtTaskFeeSum;
    }

    /* renamed from: component12, reason: from getter */
    public final String getGoldSum() {
        return this.goldSum;
    }

    /* renamed from: component13, reason: from getter */
    public final String getGoldFirst() {
        return this.goldFirst;
    }

    /* renamed from: component14, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* renamed from: component15, reason: from getter */
    public final int getIsIng() {
        return this.isIng;
    }

    /* renamed from: component16, reason: from getter */
    public final int getIsSupportAndroid10() {
        return this.isSupportAndroid10;
    }

    /* renamed from: component17, reason: from getter */
    public final int getIsIngOther() {
        return this.isIngOther;
    }

    public final List<String> component18() {
        return this.raiders;
    }

    /* renamed from: component19, reason: from getter */
    public final int getIsLastIng() {
        return this.isLastIng;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component20, reason: from getter */
    public final int getIdJeType() {
        return this.idJeType;
    }

    /* renamed from: component21, reason: from getter */
    public final int getIsHighCashBack() {
        return this.isHighCashBack;
    }

    /* renamed from: component22, reason: from getter */
    public final FirstRecharge getFirstRecharge() {
        return this.firstRecharge;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDateStart() {
        return this.dateStart;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDateEnd() {
        return this.dateEnd;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCredentialID() {
        return this.credentialID;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsHot() {
        return this.isHot;
    }

    /* renamed from: component7, reason: from getter */
    public final int getIsSupportOldUser() {
        return this.isSupportOldUser;
    }

    /* renamed from: component8, reason: from getter */
    public final int getByStagesNum() {
        return this.byStagesNum;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    public final TJTask copy(String idTask, String appName, int dateStart, int dateEnd, String credentialID, boolean isHot, int isSupportOldUser, int byStagesNum, String logo, List<String> label, String mtTaskFeeSum, String goldSum, String goldFirst, String unit, int isIng, int isSupportAndroid10, int isIngOther, List<String> raiders, int isLastIng, int idJeType, int isHighCashBack, FirstRecharge firstRecharge) {
        Intrinsics.checkNotNullParameter(idTask, "idTask");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(credentialID, "credentialID");
        Intrinsics.checkNotNullParameter(logo, "logo");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(mtTaskFeeSum, "mtTaskFeeSum");
        Intrinsics.checkNotNullParameter(goldSum, "goldSum");
        Intrinsics.checkNotNullParameter(goldFirst, "goldFirst");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(raiders, "raiders");
        return new TJTask(idTask, appName, dateStart, dateEnd, credentialID, isHot, isSupportOldUser, byStagesNum, logo, label, mtTaskFeeSum, goldSum, goldFirst, unit, isIng, isSupportAndroid10, isIngOther, raiders, isLastIng, idJeType, isHighCashBack, firstRecharge);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TJTask)) {
            return false;
        }
        TJTask tJTask = (TJTask) other;
        return Intrinsics.areEqual(this.idTask, tJTask.idTask) && Intrinsics.areEqual(this.appName, tJTask.appName) && this.dateStart == tJTask.dateStart && this.dateEnd == tJTask.dateEnd && Intrinsics.areEqual(this.credentialID, tJTask.credentialID) && this.isHot == tJTask.isHot && this.isSupportOldUser == tJTask.isSupportOldUser && this.byStagesNum == tJTask.byStagesNum && Intrinsics.areEqual(this.logo, tJTask.logo) && Intrinsics.areEqual(this.label, tJTask.label) && Intrinsics.areEqual(this.mtTaskFeeSum, tJTask.mtTaskFeeSum) && Intrinsics.areEqual(this.goldSum, tJTask.goldSum) && Intrinsics.areEqual(this.goldFirst, tJTask.goldFirst) && Intrinsics.areEqual(this.unit, tJTask.unit) && this.isIng == tJTask.isIng && this.isSupportAndroid10 == tJTask.isSupportAndroid10 && this.isIngOther == tJTask.isIngOther && Intrinsics.areEqual(this.raiders, tJTask.raiders) && this.isLastIng == tJTask.isLastIng && this.idJeType == tJTask.idJeType && this.isHighCashBack == tJTask.isHighCashBack && Intrinsics.areEqual(this.firstRecharge, tJTask.firstRecharge);
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((this.idTask.hashCode() * 31) + this.appName.hashCode()) * 31) + Integer.hashCode(this.dateStart)) * 31) + Integer.hashCode(this.dateEnd)) * 31) + this.credentialID.hashCode()) * 31) + Boolean.hashCode(this.isHot)) * 31) + Integer.hashCode(this.isSupportOldUser)) * 31) + Integer.hashCode(this.byStagesNum)) * 31) + this.logo.hashCode()) * 31) + this.label.hashCode()) * 31) + this.mtTaskFeeSum.hashCode()) * 31) + this.goldSum.hashCode()) * 31) + this.goldFirst.hashCode()) * 31) + this.unit.hashCode()) * 31) + Integer.hashCode(this.isIng)) * 31) + Integer.hashCode(this.isSupportAndroid10)) * 31) + Integer.hashCode(this.isIngOther)) * 31) + this.raiders.hashCode()) * 31) + Integer.hashCode(this.isLastIng)) * 31) + Integer.hashCode(this.idJeType)) * 31) + Integer.hashCode(this.isHighCashBack)) * 31;
        FirstRecharge firstRecharge = this.firstRecharge;
        return iHashCode + (firstRecharge == null ? 0 : firstRecharge.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TJTask(idTask=").append(this.idTask).append(", appName=").append(this.appName).append(", dateStart=").append(this.dateStart).append(", dateEnd=").append(this.dateEnd).append(", credentialID=").append(this.credentialID).append(", isHot=").append(this.isHot).append(", isSupportOldUser=").append(this.isSupportOldUser).append(", byStagesNum=").append(this.byStagesNum).append(", logo=").append(this.logo).append(", label=").append(this.label).append(", mtTaskFeeSum=").append(this.mtTaskFeeSum).append(", goldSum=");
        sb.append(this.goldSum).append(", goldFirst=").append(this.goldFirst).append(", unit=").append(this.unit).append(", isIng=").append(this.isIng).append(", isSupportAndroid10=").append(this.isSupportAndroid10).append(", isIngOther=").append(this.isIngOther).append(", raiders=").append(this.raiders).append(", isLastIng=").append(this.isLastIng).append(", idJeType=").append(this.idJeType).append(", isHighCashBack=").append(this.isHighCashBack).append(", firstRecharge=").append(this.firstRecharge).append(')');
        return sb.toString();
    }

    public TJTask(String str, String str2, int i, int i2, String str3, boolean z, int i3, int i4, String str4, List<String> list, String str5, String str6, String str7, String str8, int i5, int i6, int i7, List<String> list2, int i8, int i9, int i10, FirstRecharge firstRecharge) {
        Intrinsics.checkNotNullParameter(str, "idTask");
        Intrinsics.checkNotNullParameter(str2, "appName");
        Intrinsics.checkNotNullParameter(str3, "credentialID");
        Intrinsics.checkNotNullParameter(str4, "logo");
        Intrinsics.checkNotNullParameter(list, "label");
        Intrinsics.checkNotNullParameter(str5, "mtTaskFeeSum");
        Intrinsics.checkNotNullParameter(str6, "goldSum");
        Intrinsics.checkNotNullParameter(str7, "goldFirst");
        Intrinsics.checkNotNullParameter(str8, "unit");
        Intrinsics.checkNotNullParameter(list2, "raiders");
        this.idTask = str;
        this.appName = str2;
        this.dateStart = i;
        this.dateEnd = i2;
        this.credentialID = str3;
        this.isHot = z;
        this.isSupportOldUser = i3;
        this.byStagesNum = i4;
        this.logo = str4;
        this.label = list;
        this.mtTaskFeeSum = str5;
        this.goldSum = str6;
        this.goldFirst = str7;
        this.unit = str8;
        this.isIng = i5;
        this.isSupportAndroid10 = i6;
        this.isIngOther = i7;
        this.raiders = list2;
        this.isLastIng = i8;
        this.idJeType = i9;
        this.isHighCashBack = i10;
        this.firstRecharge = firstRecharge;
    }

    public final String getIdTask() {
        return this.idTask;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getDateStart() {
        return this.dateStart;
    }

    public final int getDateEnd() {
        return this.dateEnd;
    }

    public final String getCredentialID() {
        return this.credentialID;
    }

    public final boolean isHot() {
        return this.isHot;
    }

    public final int isSupportOldUser() {
        return this.isSupportOldUser;
    }

    public final int getByStagesNum() {
        return this.byStagesNum;
    }

    public final String getLogo() {
        return this.logo;
    }

    public final List<String> getLabel() {
        return this.label;
    }

    public final String getMtTaskFeeSum() {
        return this.mtTaskFeeSum;
    }

    public final String getGoldSum() {
        return this.goldSum;
    }

    public final String getGoldFirst() {
        return this.goldFirst;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final int isIng() {
        return this.isIng;
    }

    public final int isSupportAndroid10() {
        return this.isSupportAndroid10;
    }

    public final int isIngOther() {
        return this.isIngOther;
    }

    public final List<String> getRaiders() {
        return this.raiders;
    }

    public final int isLastIng() {
        return this.isLastIng;
    }

    public final int getIdJeType() {
        return this.idJeType;
    }

    public final int isHighCashBack() {
        return this.isHighCashBack;
    }

    public final FirstRecharge getFirstRecharge() {
        return this.firstRecharge;
    }
}
