package com.dhylive.app.data.mine;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VipLevelInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0011HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u008b\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00066"}, d2 = {"Lcom/dhylive/app/data/mine/Level;", "Ljava/io/Serializable;", "add_time", "", "first_price", "", "first_status", "grade", "id", "is_del", "month_price", "movie_num", "name", "price", "update_time", "validity_day", "isSelect", "", "(ILjava/lang/String;IIIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZ)V", "getAdd_time", "()I", "getFirst_price", "()Ljava/lang/String;", "getFirst_status", "getGrade", "getId", "()Z", "setSelect", "(Z)V", "getMonth_price", "getMovie_num", "getName", "getPrice", "getUpdate_time", "getValidity_day", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final /* data */ class Level implements Serializable {
    private final int add_time;
    private final String first_price;
    private final int first_status;
    private final int grade;
    private final int id;
    private boolean isSelect;
    private final int is_del;
    private final String month_price;
    private final int movie_num;
    private final String name;
    private final String price;
    private final int update_time;
    private final int validity_day;

    /* renamed from: component1, reason: from getter */
    public final int getAdd_time() {
        return this.add_time;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* renamed from: component11, reason: from getter */
    public final int getUpdate_time() {
        return this.update_time;
    }

    /* renamed from: component12, reason: from getter */
    public final int getValidity_day() {
        return this.validity_day;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFirst_price() {
        return this.first_price;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFirst_status() {
        return this.first_status;
    }

    /* renamed from: component4, reason: from getter */
    public final int getGrade() {
        return this.grade;
    }

    /* renamed from: component5, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component6, reason: from getter */
    public final int getIs_del() {
        return this.is_del;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMonth_price() {
        return this.month_price;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMovie_num() {
        return this.movie_num;
    }

    /* renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Level copy(int add_time, String first_price, int first_status, int grade, int id, int is_del, String month_price, int movie_num, String name, String price, int update_time, int validity_day, boolean isSelect) {
        Intrinsics.checkNotNullParameter(first_price, "first_price");
        Intrinsics.checkNotNullParameter(month_price, "month_price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        return new Level(add_time, first_price, first_status, grade, id, is_del, month_price, movie_num, name, price, update_time, validity_day, isSelect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Level)) {
            return false;
        }
        Level level = (Level) other;
        return this.add_time == level.add_time && Intrinsics.areEqual(this.first_price, level.first_price) && this.first_status == level.first_status && this.grade == level.grade && this.id == level.id && this.is_del == level.is_del && Intrinsics.areEqual(this.month_price, level.month_price) && this.movie_num == level.movie_num && Intrinsics.areEqual(this.name, level.name) && Intrinsics.areEqual(this.price, level.price) && this.update_time == level.update_time && this.validity_day == level.validity_day && this.isSelect == level.isSelect;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Integer.hashCode(this.add_time) * 31) + this.first_price.hashCode()) * 31) + Integer.hashCode(this.first_status)) * 31) + Integer.hashCode(this.grade)) * 31) + Integer.hashCode(this.id)) * 31) + Integer.hashCode(this.is_del)) * 31) + this.month_price.hashCode()) * 31) + Integer.hashCode(this.movie_num)) * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31) + Integer.hashCode(this.update_time)) * 31) + Integer.hashCode(this.validity_day)) * 31) + Boolean.hashCode(this.isSelect);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Level(add_time=").append(this.add_time).append(", first_price=").append(this.first_price).append(", first_status=").append(this.first_status).append(", grade=").append(this.grade).append(", id=").append(this.id).append(", is_del=").append(this.is_del).append(", month_price=").append(this.month_price).append(", movie_num=").append(this.movie_num).append(", name=").append(this.name).append(", price=").append(this.price).append(", update_time=").append(this.update_time).append(", validity_day=");
        sb.append(this.validity_day).append(", isSelect=").append(this.isSelect).append(')');
        return sb.toString();
    }

    public Level(int i, String str, int i2, int i3, int i4, int i5, String str2, int i6, String str3, String str4, int i7, int i8, boolean z) {
        Intrinsics.checkNotNullParameter(str, "first_price");
        Intrinsics.checkNotNullParameter(str2, "month_price");
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "price");
        this.add_time = i;
        this.first_price = str;
        this.first_status = i2;
        this.grade = i3;
        this.id = i4;
        this.is_del = i5;
        this.month_price = str2;
        this.movie_num = i6;
        this.name = str3;
        this.price = str4;
        this.update_time = i7;
        this.validity_day = i8;
        this.isSelect = z;
    }

    public /* synthetic */ Level(int i, String str, int i2, int i3, int i4, int i5, String str2, int i6, String str3, String str4, int i7, int i8, boolean z, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, i4, i5, str2, i6, str3, str4, i7, i8, (i9 & 4096) != 0 ? false : z);
    }

    public final int getAdd_time() {
        return this.add_time;
    }

    public final String getFirst_price() {
        return this.first_price;
    }

    public final int getFirst_status() {
        return this.first_status;
    }

    public final int getGrade() {
        return this.grade;
    }

    public final int getId() {
        return this.id;
    }

    public final int is_del() {
        return this.is_del;
    }

    public final String getMonth_price() {
        return this.month_price;
    }

    public final int getMovie_num() {
        return this.movie_num;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPrice() {
        return this.price;
    }

    public final int getUpdate_time() {
        return this.update_time;
    }

    public final int getValidity_day() {
        return this.validity_day;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
