package com.alibaba.fastjson.support.geo;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = {"type", "bbox", "coordinates"}, typeName = "Point")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class Point extends Geometry {
    private double[] coordinates;

    public Point() {
        super("Point");
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(double[] dArr) {
        this.coordinates = dArr;
    }
}
