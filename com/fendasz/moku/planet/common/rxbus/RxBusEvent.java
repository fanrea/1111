package com.fendasz.moku.planet.common.rxbus;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RxBusEvent<T> {
    private T data;
    private String des;
    private long event;
    private String tag;

    public static <T> RxBusEvent<T> newInstance() {
        return new RxBusEvent<>();
    }

    public static <T> RxBusEvent<T> newInstance(String str, T t) {
        return new RxBusEvent<>(str, t);
    }

    public static <T> RxBusEvent<T> newInstance(String str, T t, String str2) {
        return new RxBusEvent<>(str, t, str2);
    }

    public static <T> RxBusEvent<List<T>> newInstance(String str, List<T> list, String str2) {
        return new RxBusEvent<>(str, list, str2);
    }

    private RxBusEvent() {
    }

    private RxBusEvent(String str, T t) {
        this.event = System.currentTimeMillis();
        this.tag = str;
        this.data = t;
    }

    private RxBusEvent(String str, T t, String str2) {
        this.event = System.currentTimeMillis();
        this.tag = str;
        this.data = t;
        this.des = str2;
    }

    public long getEvent() {
        return this.event;
    }

    public void setEvent(long j) {
        this.event = j;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String str) {
        this.des = str;
    }
}
