package com.lingku.xuanshang.core.data.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tagProtocol {
    public BtnData btn;
    public String message;
    public String title;

    public static class BtnData {
        public BtnItem left;
        public BtnItem right;
    }

    public static class BtnItem {
        public String name;
        public String tips;
        public int type;
    }
}
