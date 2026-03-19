package com.fendasz.moku.planet.source.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskDataDetail implements Serializable {
    private String answer;
    private String appName;
    private String applicationId;
    private String commentKeyword;
    private List<String> commentList;
    private Integer commentStar;
    private String commentStr;
    private Integer commentType;
    private List<CpaQuestionData> cpaQuestionData;
    private Integer customRange;
    private String form;
    private List<String> formList;
    private Map<Integer, Map<Integer, List<TaskDataStep>>> groupedMap;
    private String id;
    private Map<Integer, List<TaskDataStep>> integerListMap;
    private Integer isCustomDesc;
    private String keyword;
    private Integer listenerTime;
    private Integer productFlavorId;
    private BasicDataProductFlavors productFlavors;
    private Integer rank;
    private Integer ratingTemplate;
    private String taskDataIconUrl;
    private Integer taskDataId;
    private List<TaskDataStep> taskDataStepList;
    private String thirdStep;
    public static final Integer COMMENTTYPE_SPECIFIED = 1;
    public static final Integer COMMENTTYPE_KEYWORD = 2;
    public static final Integer COMMENTTYPE_FREE = 3;

    public Integer getRatingTemplate() {
        return this.ratingTemplate;
    }

    public void setRatingTemplate(Integer num) {
        this.ratingTemplate = num;
    }

    public String getThirdStep() {
        return this.thirdStep;
    }

    public void setThirdStep(String str) {
        this.thirdStep = str;
    }

    public List<HashMap> getAnswerList() {
        if (TextUtils.isEmpty(this.answer)) {
            return null;
        }
        return JSONObject.parseArray(this.answer, HashMap.class);
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String str) {
        this.answer = str;
    }

    public String getCommentStr() {
        return this.commentStr;
    }

    public void setCommentStr(String str) {
        this.commentStr = str;
    }

    public Integer getCommentType() {
        return this.commentType;
    }

    public void setCommentType(Integer num) {
        this.commentType = num;
    }

    public Map<Integer, List<TaskDataStep>> getIntegerListMap() {
        return this.integerListMap;
    }

    public void setIntegerListMap(Map<Integer, List<TaskDataStep>> map) {
        this.integerListMap = map;
    }

    public List<String> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<String> list) {
        this.commentList = list;
    }

    public List<String> getFormList() {
        return this.formList;
    }

    public void setFormList(List<String> list) {
        setForm(JSONObject.toJSONString(list));
        this.formList = list;
    }

    public List<TaskDataStep> getTaskDataStepList() {
        return this.taskDataStepList;
    }

    public void setTaskDataStepList(List<TaskDataStep> list) {
        this.taskDataStepList = list;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public String getCommentKeyword() {
        return this.commentKeyword;
    }

    public void setCommentKeyword(String str) {
        this.commentKeyword = str;
    }

    public Integer getCommentStar() {
        return this.commentStar;
    }

    public void setCommentStar(Integer num) {
        this.commentStar = num;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getForm() {
        return this.form;
    }

    public void setForm(String str) {
        this.form = str;
    }

    public Integer getTaskDataId() {
        return this.taskDataId;
    }

    public void setTaskDataId(Integer num) {
        this.taskDataId = num;
    }

    public Integer getIsCustomDesc() {
        return this.isCustomDesc;
    }

    public void setIsCustomDesc(Integer num) {
        this.isCustomDesc = num;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public Integer getListenerTime() {
        return this.listenerTime;
    }

    public void setListenerTime(Integer num) {
        this.listenerTime = num;
    }

    public Integer getProductFlavorId() {
        return this.productFlavorId;
    }

    public void setProductFlavorId(Integer num) {
        this.productFlavorId = num;
    }

    public Integer getRank() {
        return this.rank;
    }

    public void setRank(Integer num) {
        this.rank = num;
    }

    public BasicDataProductFlavors getProductFlavors() {
        return this.productFlavors;
    }

    public void setProductFlavors(BasicDataProductFlavors basicDataProductFlavors) {
        this.productFlavors = basicDataProductFlavors;
    }

    public String getTaskDataIconUrl() {
        return this.taskDataIconUrl;
    }

    public void setTaskDataIconUrl(String str) {
        this.taskDataIconUrl = str;
    }

    public Integer getCustomRange() {
        return this.customRange;
    }

    public void setCustomRange(Integer num) {
        this.customRange = num;
    }

    public Map<Integer, Map<Integer, List<TaskDataStep>>> getGroupedMap() {
        return this.groupedMap;
    }

    public void setGroupedMap(Map<Integer, Map<Integer, List<TaskDataStep>>> map) {
        this.groupedMap = map;
    }

    public List<CpaQuestionData> getCpaQuestionData() {
        return this.cpaQuestionData;
    }

    public void setCpaQuestionData(List<CpaQuestionData> list) {
        this.cpaQuestionData = list;
    }
}
