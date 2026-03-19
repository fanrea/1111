package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CpaData implements Serializable {
    private Integer count;
    private Boolean flag;
    private List<Boolean> flags;
    private Integer length;

    public Integer getLength() {
        return this.length;
    }

    public void setLength(Integer num) {
        this.length = num;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public boolean isFlag() {
        return this.flag.booleanValue();
    }

    public void setFlag(boolean z) {
        this.flag = Boolean.valueOf(z);
    }

    public Boolean getFlag() {
        return this.flag;
    }

    public void setFlag(Boolean bool) {
        this.flag = bool;
    }

    public List<Boolean> getFlags() {
        return this.flags;
    }

    public void setFlags(List<Boolean> list) {
        this.flags = list;
    }
}
