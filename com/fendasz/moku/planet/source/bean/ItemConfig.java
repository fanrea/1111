package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ItemConfig implements Serializable {
    private static final long serialVersionUID = -8990021743223861873L;
    private Integer itemId;
    private String itemName;
    private List<TagForm> tagForm;

    public Integer getItemId() {
        return this.itemId;
    }

    public void setItemId(Integer num) {
        this.itemId = num;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public List<TagForm> getTagForm() {
        return this.tagForm;
    }

    public void setTagForm(List<TagForm> list) {
        this.tagForm = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ItemConfig itemConfig = (ItemConfig) obj;
        return Objects.equals(this.itemId, itemConfig.itemId) && Objects.equals(this.itemName, itemConfig.itemName);
    }

    public int hashCode() {
        return Objects.hash(this.itemId, this.itemName);
    }

    public List<Integer> getTagIdList() {
        if (this.tagForm == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.tagForm.size());
        Iterator<TagForm> it = this.tagForm.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTagId());
        }
        return arrayList;
    }
}
