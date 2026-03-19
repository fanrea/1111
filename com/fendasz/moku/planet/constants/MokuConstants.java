package com.fendasz.moku.planet.constants;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuConstants {
    public static final String APK_DOWNLOAD_TYPE_APPMARKET = "3";
    public static final String APK_DOWNLOAD_TYPE_INNER = "1";
    public static final String APK_DOWNLOAD_TYPE_NULL = "0";
    public static final String APK_DOWNLOAD_TYPE_OUTER = "2";
    public static final String APPLISTSTATUS = "0";
    public static final int APPLY_ERROR_STATUS_APPLY_TWICE = 5003;
    public static final int APPLY_ERROR_STATUS_EXIST_ANOTHER_APPLYING_TASK = 5000;
    public static final int APPLY_ERROR_STATUS_NOT_EXIST = 5001;
    public static final int APPLY_ERROR_STATUS_NO_COMMENT = 5007;
    public static final int APPLY_ERROR_STATUS_NUM_IS_EMPTY = 5004;
    public static final int APPLY_ERROR_STATUS_RULE_CONFLICT = 5006;
    public static final int CANCEL_TASK_ERROR_STATUS_NOT_EXIST = 5001;
    public static final int CPL_FROM_DEFAULT = 1000;
    public static final int CPL_FROM_TASKDIALOG = 1001;
    public static final String DATE_CONTROL_TYPE_NATURALDAY = "naturalDay";
    public static final String DATE_CONTROL_TYPE_NON_NATURALDAY = "nonNaturalDay";
    public static final int ERROR = -1;
    public static final int ERROR_NO_CONTEXT = -200;
    public static final int ERROR_TIME_OUT = -201;
    public static final int ERROR_WRONG_DOMAIN_NAME = -202;
    public static final int GET_DETAIL_ERROR_STATUS_NOT_EXIST = 5001;
    public static final int GET_DETAIL_ERROR_STATUS_SUBMITED = 5000;
    public static final String INTENT_KEY_UNBLOCKRESULT = "unblockResult";
    public static final String MOKU_APP_EXCEPTION = "Media data(AppId or AppSecret) was not found";
    public static final String MOKU_CONTEXT_EXCEPTION = "Context was not found";
    public static final String MOKU_IMEI_EXCEPTION = "Both OAID and IMEI are empty";
    public static final String MOKU_OPTION_EXCEPTION = "MokuOption can not be null";
    public static final String MOKU_READ_EXTERNAL_STORAGE_PERMISSION_EXCEPTION = "PERMISSION_READ_EXTERNAL_STORAGE was required";
    public static final String MOKU_READ_PHONE_STATE_PERMISSION_EXCEPTION = "PERMISSION_READ_PHONE_STATE was required";
    public static final String MOKU_TASK_ID_EXCEPTION = "request task detail,but task id is null,that not allowed null";
    public static final String MOKU_USERID_EXCEPTION = "UserId was not found";
    public static final String MOKU_WRITE_EXTERNAL_STORAGE_PERMISSION_EXCEPTION = "PERMISSION_WRITE_EXTERNAL_STORAGE was required";
    public static final int NO_POPUP_TASK = 6001;
    public static final int NO_SHOULD_POPUP = 6002;
    public static final int REQUEST_CODE_OVERLAY_PERMISSION = 605;
    public static final int REQUEST_CODE_TO_ARBITRATION = 604;
    public static final int REQUEST_CODE_TO_RESUBMITARBITRATION = 603;
    public static final int RESULT_CDOE_FROM_MYPARTICIPATEIN = 601;
    public static final int RESULT_CODE_FROM_APPEALUNBLOCK = 800;
    public static final int RESULT_CODE_FROM_REWARDTASKRESUBMIT = 602;
    public static final int RESULT_CODE_TO_SHOW_ARBITRAMENTF = 600;
    public static final String SP_DIAN_USER_TYPE_KEY = "moku_dian_sp_user_type";
    public static final String SP_USER_TYPE_KEY = "moku_sp_user_type";
    public static final int SUBMIT_ERROR_STATUS_5001 = 5001;
    public static final int SUBMIT_ERROR_STATUS_PICTURE_FORMAT_ERROR = 6000;
    public static final int SUBMIT_ERROR_STATUS_RULE_CONFLICT = 5006;
    public static final int SUBMIT_ERROR_STATUS_SUBMITED = 5000;
    public static final int SUCCESS = 0;
    public static final int TASK_DETAIL_OPERATION_FROMLIST = 100;
    public static final int TASK_DETAIL_OPERATION_JSRESUBMIT = 101;
    public static final String TASK_TAG_ALL = "all";
    public static final String TASK_TAG_HIGH_PRICE = "high_price";
    public static final String TASK_TAG_SIMPLE = "simple";
    public static final String TASK_TAG_TOP_POSITION = "top_position";

    @Deprecated
    public static final String TASK_TYPE_COMMENT = "comment";
    public static final String TASK_TYPE_CPA = "cpa";
    public static final String TASK_TYPE_CPL = "cpl";
    public static final String TASK_TYPE_HP = "hp";
    public static final String TASK_TYPE_KEYWORD = "keyword";
    public static final int USER_TYPE_NEW = 6004;
    public static final int USER_TYPE_OLD = 6005;
    public static final Integer CPA_TYPE_NORMAL = 0;
    public static final Integer CPA_TYPE_NORMAL_GAP_FILLING = 1;
    public static final Integer CPA_TYPE_NORMAL_CHOICE_QUESTION = 2;
    public static final Integer CPA_TYPE_NORMAL_FORM = 3;
    public static final Integer COMMENTTYPE_SPECIFIED = 1;
    public static final Integer COMMENTTYPE_KEYWORD = 2;
    public static final Integer COMMENTTYPE_FREE = 3;
    public static final Integer CUSTOM_DESC = 1;
    public static final Integer STATUS_OF_APPLYING = 0;
    public static final Integer STATUS_OF_COMPLETED = 1;
    public static final Integer STATUS_OF_CANCELLED = -1;
    public static final Integer STATUS_OF_OVERTIME = -2;
    public static final Integer TYPE_OF_EXAMPLE = 1;
    public static final Integer TYPE_OF_NORMAL = 2;
    public static final Integer TASK_RECORD_FAIL = -1;
    public static final Integer TASK_RECORD_UNDER_REVIEW = 1;
    public static final Integer CHECK_NO_USAGE_STATS = -1;
    public static final Integer CHECK_APP_EXIST = -2;
    public static final Integer CHECK_CAN_START_TASK = 0;

    public enum H5Url {
        H5_REWARD_DEBUG_LOCAL("http://192.168.0.248:5502/C-task-details/C-task.html"),
        H5_REWARD_DEBUG("http://billion318.tpddns.cn:8081/moku-planet-sdk-C-h5/C-task-details/C-task.html"),
        H5_REWARD_RELEASE("http://channel.moguxingqiu.com.cn/moku-planet-sdk-C-h5/C-task-details/C-task.html"),
        H5_CPL_DEBUG_LOCAL("http://192.168.0.248:5501/cpl-preview.html"),
        H5_CPL_DEBUG("http://billion318.tpddns.cn:81/moku-plant-sdk-cpl-h5/cpl-preview.html"),
        H5_CPL_RELEASE("http://sdk.moguxingqiu.com.cn/moku-plant-sdk-cpl-h5/cpl-preview.html"),
        H5_ARBITRATION_DEBUG_LOCAL("http://192.168.0.248:5502/C-task-failure-and-ing/C-task-failure-and-ing.html"),
        H5_ARBITRATION_DEBUG("http://billion318.tpddns.cn:80/moku-planet-sdk-C-h5/C-task-failure-and-ing/C-task-failure-and-ing.html"),
        H5_ARBITRATION_DEBUG_RELEASE("http://channel.moguxingqiu.com.cn/moku-planet-sdk-C-h5/C-task-failure-and-ing/C-task-failure-and-ing.html"),
        H5_ARBITRATION_DETAIL_DEBUG_LOCAL("http://192.168.0.248:5502/C-arbitration-details/C-arbitration-details.html"),
        H5_ARBITRATION_DETAIL_DEBUG("http://123.60.30.124/moku-planet-sdk-C-h5/C-arbitration-details/C-arbitration-details.html"),
        H5_ARBITRATION_DETAIL_RELEASE("http://channel.moguxingqiu.com.cn/moku-planet-sdk-C-h5/C-arbitration-details/C-arbitration-details.html"),
        H5_EASYTASK_LOCAL("http://192.168.0.248:5500/moku-planet-simple-task-list/list/simple-task-list.html"),
        H5_EASYTASK_DEBUG("http://192.168.0.230:5500/moku-planet-simple-task-list/list/simple-task-list.html"),
        H5_EASYTASK_RELEASE("http://sdk.moguxingqiu.com.cn/moku-planet-simple-task-list/list/simple-task-list.html"),
        H5_COMPLAINT_DEBUG_LOCAL("http://billion318.tpddns.cn:8081/C-task-complaint-apply/C-task-complaint-apply.html"),
        H5_COMPLAINT_DEBUG("http://192.168.0.248:5502/C-task-complaint-apply/C-task-complaint-apply.html"),
        H5_COMPLAINT_RELEASE("http://channel.moguxingqiu.com.cn/moku-planet-sdk-C-h5/C-task-complaint-apply/C-task-complaint-apply.html"),
        H5_APPEALUNBLOCK_DEBUG_LOCAL("http://192.168.1.248:5502/moku-plant-sdk-blacklist/view/appeal.html"),
        H5_APPEALUNBLOCK_DEBUG("http://192.168.1.202:8081/moku-planet-sdk-C-h5/moku-plant-sdk-blacklist/view/appeal.html"),
        H5_APPEALUNBLOCK_RELEASE("http://channel.moguxingqiu.com.cn/moku-planet-sdk-C-h5/moku-plant-sdk-blacklist/view/appeal.html");

        private String url;

        H5Url(String str) {
            this.url = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }
}
