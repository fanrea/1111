package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TagForm implements Serializable {
    private static final long serialVersionUID = 1143146971459540134L;
    private boolean select = false;
    private Integer tagId;
    private String tagName;

    public Integer getTagId() {
        return this.tagId;
    }

    public void setTagId(Integer num) {
        this.tagId = num;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TagForm tagForm = (TagForm) obj;
        return this.tagId.equals(tagForm.tagId) && this.tagName.equals(tagForm.tagName);
    }

    public int hashCode() {
        return Objects.hash(this.tagId, this.tagName);
    }

    public boolean isSelect() {
        return this.select;
    }

    public void setSelect(boolean z) {
        this.select = z;
    }
}
