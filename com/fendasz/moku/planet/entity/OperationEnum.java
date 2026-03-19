package com.fendasz.moku.planet.entity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public enum OperationEnum {
    SUCCESS_START(1, "开始任务"),
    SUCCESS_APPLY(2, "任务进行中"),
    SUCCESS_DOWNLOAD(3, "下载应用市场"),
    SUCCESS_DOWNLOAD_APP(4, "下载应用"),
    SUCCESS_OPEN(5, "打开应用市场"),
    SUCCESS_OPEN_APP(6, "打开应用"),
    SUCCESS_INSTALL(7, "安装应用市场"),
    SUCCESS_INSTALL_APP(8, "安装应用"),
    SUCCESS_AUTO_INSTALL_APP(9, "自动安装应用"),
    SUCCESS_DOWNLOAD_LOADING(10, "正在下载"),
    SUCCESS_CONTINUE_DOWNLOAD(11, "继续下载"),
    SUCCESS_CONTINUE_DEMO(12, "继续试玩"),
    SUCCESS_SUBMIT(0, "提交任务"),
    SUCCESS_OPEN_MARKETDOWNLOAD(13, "跳转应用市场"),
    SUCCESS_APPMARKET_INSTALLED(14, "开始任务"),
    ERROR_OVERTIME(-1, "任务超时"),
    ERROR_TAKEUP(-2, "任务已抢完"),
    ERROR_DOWNLOAD(-3, "下载失败");

    private int code;
    private String message;

    OperationEnum(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
