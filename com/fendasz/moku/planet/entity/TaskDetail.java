package com.fendasz.moku.planet.entity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDetail {
    private String additionalData;
    private Integer applyRecordStatus;
    private Integer collectionDataId;
    private Boolean cpl;
    private Boolean easy;
    private Integer easyTaskType;
    private String gateType;
    private OnEasyTaskClickListener onEasyTaskClickListener;
    private Integer surplusNum;
    private Integer taskDataId;
    private Integer taskType;
    private String url;

    public interface OnEasyTaskClickListener {
        void onDismissLoading();

        void onLoading();
    }

    private TaskDetail(Builder builder) {
        this.applyRecordStatus = builder.applyRecordStatus;
        this.easyTaskType = builder.easyTaskType;
        this.surplusNum = builder.surplusNum;
        this.easy = builder.easy;
        this.taskDataId = builder.taskDataId;
        this.url = builder.url;
        this.gateType = builder.gateType;
        this.cpl = builder.cpl;
        this.taskType = builder.taskType;
        this.additionalData = builder.additionalData;
        this.onEasyTaskClickListener = builder.onEasyTaskClickListener;
        this.collectionDataId = builder.collectionDataId;
    }

    public Integer getApplyRecordStatus() {
        return this.applyRecordStatus;
    }

    public Integer getEasyTaskType() {
        return this.easyTaskType;
    }

    public Integer getSurplusNum() {
        Integer num = this.surplusNum;
        return Integer.valueOf(num != null ? num.intValue() : 0);
    }

    public Boolean getEasy() {
        Boolean bool = this.easy;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    public String getUrl() {
        return this.url;
    }

    public String getGateType() {
        return this.gateType;
    }

    public Boolean getCpl() {
        Boolean bool = this.cpl;
        return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
    }

    public Integer getTaskType() {
        return this.taskType;
    }

    public String getAdditionalData() {
        return this.additionalData;
    }

    public OnEasyTaskClickListener getOnEasyTaskClickListener() {
        return this.onEasyTaskClickListener;
    }

    public void setOnEasyTaskClickListener(OnEasyTaskClickListener onEasyTaskClickListener) {
        this.onEasyTaskClickListener = onEasyTaskClickListener;
    }

    public Integer getCollectionDataId() {
        return this.collectionDataId;
    }

    public void setCollectionDataId(Integer num) {
        this.collectionDataId = num;
    }

    public static class Builder {
        private String additionalData;
        private Integer applyRecordStatus;
        private Integer collectionDataId;
        private Boolean cpl;
        private Boolean easy;
        private Integer easyTaskType;
        private String gateType;
        private OnEasyTaskClickListener onEasyTaskClickListener;
        private Integer surplusNum;
        private Integer taskDataId;
        private Integer taskType;
        private String url;

        public Builder(Integer num) {
            this.taskDataId = num;
        }

        public Builder applyRecordStatus(Integer num) {
            this.applyRecordStatus = num;
            return this;
        }

        public Builder easyTaskType(Integer num) {
            this.easyTaskType = num;
            return this;
        }

        public Builder surplusNum(Integer num) {
            this.surplusNum = num;
            return this;
        }

        public Builder easy(Boolean bool) {
            this.easy = bool;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder gateType(String str) {
            this.gateType = str;
            return this;
        }

        public Builder cpl(Boolean bool) {
            this.cpl = bool;
            return this;
        }

        public Builder taskType(Integer num) {
            this.taskType = num;
            return this;
        }

        public Builder additionalData(String str) {
            this.additionalData = str;
            return this;
        }

        public Builder setOnEasyTaskClickListener(OnEasyTaskClickListener onEasyTaskClickListener) {
            this.onEasyTaskClickListener = onEasyTaskClickListener;
            return this;
        }

        public Builder collectionDataId(Integer num) {
            this.collectionDataId = num;
            return this;
        }

        public TaskDetail builder() {
            return new TaskDetail(this);
        }
    }
}
