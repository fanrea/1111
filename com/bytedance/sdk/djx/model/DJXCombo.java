package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXCombo {
    public static final int TYPE_DRAMA = 2;
    public static final int TYPE_VIP = 1;
    public String desc;
    public long duration;
    public int durationType;
    public long id;
    public long money;
    public String moneyType;
    public String name;
    public int number;
    public long payAmount;
    public String payMoney;
    public int payType;
    public int type;

    public boolean isVipType() {
        return this.type == 1;
    }

    public boolean isDramaType() {
        return this.type == 2;
    }

    public String toString() {
        return "DJXCombo{id=" + this.id + ", name='" + this.name + "', desc='" + this.desc + "', type=" + this.type + ", durationType=" + this.durationType + ", duration=" + this.duration + ", number=" + this.number + ", moneyType='" + this.moneyType + "', money=" + this.money + ", payType=" + this.payType + ", payAmount=" + this.payAmount + ", payMoney='" + this.payMoney + "'}";
    }
}
