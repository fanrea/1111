package com.kwad.sdk.core.network;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    public final int errorCode;
    public final String msg;
    public static e bCt = new e(-1, "请求超时事件");
    public static e bCu = new e(-2, "请求异常");
    public static e bCv = new e(-1000, "该业务组件未加载");
    public static e bCw = new e(40001, "网络错误");
    public static e bCx = new e(40002, "数据解析错误");
    public static e bCy = new e(40003, "数据为空");
    public static e bCz = new e(40004, "视频资源缓存失败");
    public static e bCA = new e(40005, "网络超时");
    public static e bCB = new e(40007, "图片下载失败");
    public static e bCC = new e(40008, "广告场景不匹配");
    public static e bCD = new e(40009, "广告加载异常");
    public static e bCE = new e(40010, "activity场景不匹配");
    public static e bCF = new e(40011, "sdk初始化失败");
    public static e bCG = new e(40012, "权限未开启");
    public static e bCH = new e(40013, "SDK未调用start方法");
    public static e bCI = new e(100006, "更多视频请前往快手App查看");
    public static e bCJ = new e(100007, "复制链接失败，请稍后重试");
    public static e bCK = new e(100008, "内容有点敏感，不可以发送哦");
    public static e bCL = new e(130001, "数据不存在");
    public static e bCM = new e(0, "网络超时");

    private e(int i, String str) {
        this.errorCode = i;
        this.msg = str;
    }
}
