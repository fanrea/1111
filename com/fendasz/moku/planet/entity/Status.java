package com.fendasz.moku.planet.entity;

import com.fendasz.moku.planet.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public enum Status {
    NO_DATA_UNDERWAY(Integer.valueOf(R.drawable.moku_no_data), "暂无任务", "每天不定时更新,请稍后再来", "刷新任务", null),
    NO_APP_INFO(Integer.valueOf(R.drawable.moku_no_data), "暂无数据", null, "刷新", null),
    NO_NET(Integer.valueOf(R.drawable.moku_no_net), "您的网络去火星啦", null, "检查网络", "刷新"),
    NO_DATA_OTHER(Integer.valueOf(R.drawable.moku_no_data), "您还没有做任务，去做点任务吧~", null, "去做任务", null),
    BLACKLIST(Integer.valueOf(R.drawable.moku_no_data), "暂无任务", "每天不定时更新,请稍后再来", "刷新任务", null),
    I_KNOW(Integer.valueOf(R.drawable.moku_no_data), "您还没有做任务，去做点任务吧~", null, "我知道了", null),
    DIAN_SEARCH_EMPTY(Integer.valueOf(R.drawable.moku_no_data), "暂无任务", "没有找到任务，换个词搜索吧~", null, null);

    private String btnBottom;
    private String btnTop;
    private String detail;
    private Integer image;
    private String title;

    Status(Integer num, String str, String str2, String str3, String str4) {
        this.image = num;
        this.title = str;
        this.detail = str2;
        this.btnTop = str3;
        this.btnBottom = str4;
    }

    public Integer getImage() {
        return this.image;
    }

    public void setImage(Integer num) {
        this.image = num;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String str) {
        this.detail = str;
    }

    public String getBtnTop() {
        return this.btnTop;
    }

    public void setBtnTop(String str) {
        this.btnTop = str;
    }

    public String getBtnBottom() {
        return this.btnBottom;
    }

    public void setBtnBottom(String str) {
        this.btnBottom = str;
    }
}
