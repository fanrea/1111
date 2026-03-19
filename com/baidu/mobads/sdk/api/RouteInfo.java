package com.baidu.mobads.sdk.api;

import javax.lang.model.element.Element;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class RouteInfo {
    private Class<?> destination;
    private String path;
    private Element rawType;

    public RouteInfo() {
    }

    public RouteInfo(Class<?> cls, String str) {
        this.destination = cls;
        this.path = str;
    }

    public RouteInfo(Element element, String str) {
        this.rawType = element;
        this.path = str;
    }

    public Class<?> getDestination() {
        return this.destination;
    }

    public RouteInfo setDestination(Class<?> cls) {
        this.destination = cls;
        return this;
    }

    public String getPath() {
        return this.path;
    }

    public RouteInfo setPath(String str) {
        this.path = str;
        return this;
    }

    public Element getRawType() {
        return this.rawType;
    }

    public static RouteInfo build(Class<?> cls, String str) {
        return new RouteInfo(cls, str);
    }
}
