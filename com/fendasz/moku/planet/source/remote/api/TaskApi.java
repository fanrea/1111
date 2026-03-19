package com.fendasz.moku.planet.source.remote.api;

import com.fendasz.moku.diandian.entity.requestmodel.DianParameterModel;
import com.fendasz.moku.planet.common.network.result.ApiResult;
import com.fendasz.moku.planet.entity.EasyCollectionEntity;
import com.fendasz.moku.planet.entity.PhoneInfo;
import com.fendasz.moku.planet.source.bean.AlipayConfigData;
import com.fendasz.moku.planet.source.bean.AppConfig;
import com.fendasz.moku.planet.source.bean.BaiduConfigData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskData;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataList;
import com.fendasz.moku.planet.source.bean.ClientSampleTaskDataRecord;
import com.fendasz.moku.planet.source.bean.ClientTaskData;
import com.fendasz.moku.planet.source.bean.ClientTaskDataRecord;
import com.fendasz.moku.planet.source.bean.ClientTaskRecordListInfo;
import com.fendasz.moku.planet.source.bean.CustomerServiceConfig;
import com.fendasz.moku.planet.source.bean.DianClientTaskRecordListInfo;
import com.fendasz.moku.planet.source.bean.ItemConfig;
import com.fendasz.moku.planet.source.bean.TaskDataApplyRecord;
import com.fendasz.moku.planet.source.bean.UploadVideoReponse;
import com.fendasz.moku.planet.source.bean.VideoConfig;
import com.fendasz.moku.planet.source.requestmodel.AliyunTokenBasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.BasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.CPLBasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.DianCPLBasicParameterModel;
import com.fendasz.moku.planet.source.requestmodel.UserDeviceBasicParameterModel;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface TaskApi {
    @Headers({"needToken:true"})
    @POST("api/ali/safe/getType")
    Observable<ApiResult<AlipayConfigData>> alipayKey(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/easy/apply/{id}/{recordId}")
    Observable<ApiResult<TaskDataApplyRecord>> applyEasyTask(@Path("id") Integer num, @Path("recordId") Integer num2, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/apply/{id}")
    Observable<ApiResult<TaskDataApplyRecord>> applyTask(@Path("id") Integer num, @Body CPLBasicParameterModel cPLBasicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/arbitrament/{id}")
    Observable<ApiResult<String>> arbitrament(@Path("id") Integer num, @Body RequestBody requestBody);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/arbitrament/record")
    Observable<ApiResult<List<ClientSampleTaskDataRecord>>> arbitramentRecordList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @GET("api/v2/client/taskData/baiduConfig")
    Observable<ApiResult<BaiduConfigData>> bdConfig();

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/easyCollection/begin/{id}")
    Observable<ApiResult<EasyCollectionEntity>> beginEasyCollection(@Path("id") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/apply/cancel/{id}/{applyId}")
    Observable<ApiResult<TaskDataApplyRecord>> cancelTask(@Path("id") Integer num, @Path("applyId") Integer num2, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/apply/cancelWithMonitor/{id}/{applyId}")
    Observable<ApiResult<Object>> cancelWithoutMonitor(@Path("id") Integer num, @Path("applyId") Integer num2, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/popUp/update")
    Observable<ApiResult<ClientTaskData>> changeTask(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/confirmReSubmitted")
    Observable<ApiResult<Object>> confirmReSubmitted(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/cpaLog/{recordType}/{taskDataId}")
    Observable<ApiResult<Object>> cpaLog(@Path("recordType") String str, @Path("taskDataId") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/cpl/partake/groups")
    Observable<ApiResult<List<ClientSampleTaskData>>> cplMyPartInList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/cpl/openGame/{id}")
    Observable<ApiResult<Object>> cplOpenGame(@Path("id") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/apply/{id}")
    Observable<ApiResult<TaskDataApplyRecord>> dianApplyTask(@Path("id") Integer num, @Body DianCPLBasicParameterModel dianCPLBasicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/{id}")
    Observable<ApiResult<ClientTaskData>> dianCPLTaskDetail(@Path("id") Integer num, @Body DianCPLBasicParameterModel dianCPLBasicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/apply/cancel/{id}/{applyId}")
    Observable<ApiResult<TaskDataApplyRecord>> dianCancelTask(@Path("id") Integer num, @Path("applyId") Integer num2, @Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/apply/cancelWithMonitor/{id}/{applyId}")
    Observable<ApiResult<Object>> dianCancelWithoutMonitor(@Path("id") Integer num, @Path("applyId") Integer num2, @Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/cpaLog/{recordType}/{taskDataId}")
    Observable<ApiResult<Object>> dianCpaLog(@Path("recordType") String str, @Path("taskDataId") Integer num, @Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/cpl/openGame/{id}")
    Observable<ApiResult<Object>> dianCplOpenGame(@Path("id") Integer num, @Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/app/getItemConfig")
    Observable<ApiResult<List<ItemConfig>>> dianGetItemConfig(@Body DianParameterModel dianParameterModel);

    @Headers({"needToken:false"})
    @POST("api/dian/client/taskData/getTaskDataStatus")
    Observable<ApiResult<TaskDataApplyRecord>> dianGetTaskDataStatus(@Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/partake/groups")
    Observable<ApiResult<List<ClientSampleTaskData>>> dianMyPartInList(@Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/popUpAllList")
    Observable<ApiResult<List<ClientTaskData>>> dianPopUpList(@Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/logRecordGoDetail/{gateType}/{taskDataId}")
    Observable<ApiResult<Object>> dianPostGateType(@Path("gateType") String str, @Path("taskDataId") Integer num, @Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/submit/{id}")
    Observable<ApiResult<String>> dianSubmitTask(@Path("id") Integer num, @Body RequestBody requestBody);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/easyCollection/{id}")
    Observable<ApiResult<Object>> easyCollection(@Path("id") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:false"})
    @POST("api/v2/client/taskData/app/conf")
    Observable<ApiResult<List<AppConfig>>> getAppConfig(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:false"})
    @GET("api/v2/client/taskData/appInfoList/{developerAppId}")
    Observable<ApiResult<List<String>>> getAppInfoList(@Path("developerAppId") String str);

    @Headers({"needToken:true"})
    @POST("api/antiCheating/getAppeal")
    Observable<ApiResult<Object>> getAppeal(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/appeal/{submitRecordId}")
    Observable<ApiResult<ClientTaskData>> getAppealTaskDetail(@Path("submitRecordId") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/cpl")
    Observable<ApiResult<ClientSampleTaskDataList>> getCPLTaskList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:false"})
    @GET("api/v2/client/taskData/customerServiceConfig")
    Observable<ApiResult<CustomerServiceConfig>> getCustomerServiceConfig();

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/{id}")
    Observable<ApiResult<ClientTaskData>> getDianTaskDetail(@Path("id") Integer num, @Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/page")
    Observable<ApiResult<ClientSampleTaskDataList>> getDianTaskList(@Body DianParameterModel dianParameterModel);

    @Headers({"needToken:true"})
    @POST("api/dian/client/taskData/record/list")
    Observable<ApiResult<List<ClientSampleTaskDataRecord>>> getDianTaskRecordList(@Body DianClientTaskRecordListInfo dianClientTaskRecordListInfo);

    @Headers({"needToken:false"})
    @GET("http://d1.xingqiudazhuan.cn/moguxingqiu/cfg.json")
    Observable<String> getDomainConfig();

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/{id}")
    Observable<ApiResult<ClientTaskData>> getGameTaskDetail(@Path("id") Integer num, @Body CPLBasicParameterModel cPLBasicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v3/client/taskData/app/getItemConfig")
    Observable<ApiResult<List<ItemConfig>>> getItemConfig(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:false"})
    @GET("api/v2/client/taskData/getTime")
    Observable<ApiResult<Long>> getNetTime();

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/page")
    Observable<ApiResult<ClientSampleTaskDataList>> getPagedTaskList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v3/client/taskData/page")
    Observable<ApiResult<ClientSampleTaskDataList>> getPagedTaskList3(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/getReSubmittedStatus")
    Observable<ApiResult<Integer>> getReSubmittedStatus(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/getSurplusCreditScore")
    Observable<ApiResult<Map<String, Object>>> getSurplusCreditScore(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:false"})
    @POST("api/v2/client/taskData/getTaskDataStatus")
    Observable<ApiResult<TaskDataApplyRecord>> getTaskDataStatus(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v3/client/taskData/{id}")
    Observable<ApiResult<ClientTaskData>> getTaskDetail(@Path("id") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/client/taskData/")
    Observable<ApiResult<List<ClientSampleTaskData>>> getTaskList(@Body PhoneInfo phoneInfo);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/")
    Observable<ApiResult<List<ClientSampleTaskData>>> getTaskList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/partake/groups")
    Observable<ApiResult<List<ClientSampleTaskData>>> getTaskMyPartInList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/record/{id}")
    Observable<ApiResult<ClientTaskDataRecord>> getTaskRecordDetail(@Path("id") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/record/list")
    Observable<ApiResult<List<ClientSampleTaskDataRecord>>> getTaskRecordList(@Body ClientTaskRecordListInfo clientTaskRecordListInfo);

    @Headers({"needToken:true"})
    @POST("api/v3/client/taskData/app/getUserType")
    Observable<ApiResult<Object>> getUserType(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:false"})
    @GET("api/v2/client/taskData/videoConfig")
    Observable<ApiResult<VideoConfig>> getVideoConfig();

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/popUp")
    Observable<ApiResult<ClientTaskData>> isCanPopUpDialog(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v3/client/taskData/itemLog/{recordType}/{taskDataId}")
    Observable<ApiResult<Object>> itemLog(@Path("recordType") String str, @Path("taskDataId") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v3/client/taskData/popUpAllList")
    Observable<ApiResult<List<ClientTaskData>>> popUpList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/logRecordGoDetail/{gateType}/{taskDataId}")
    Observable<ApiResult<Object>> postGateType(@Path("gateType") String str, @Path("taskDataId") Integer num, @Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/add/packageInfos/")
    Observable<ApiResult<String>> postPackages(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/readUserReported")
    Observable<ApiResult<Object>> readUserReported(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/reward/")
    Observable<ApiResult<List<ClientSampleTaskData>>> rewardTaskList(@Body BasicParameterModel basicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/v2/client/taskData/appeal/submit/{id}")
    Observable<ApiResult<String>> submitAppealTask(@Path("id") Integer num, @Body RequestBody requestBody);

    @Headers({"needToken:true"})
    @POST("api/v3/client/taskData/submit/{id}")
    Observable<ApiResult<String>> submitTask(@Path("id") Integer num, @Body RequestBody requestBody);

    @Headers({"needToken:true"})
    @POST("api/ali/safe/deviceToken")
    Observable<ApiResult<Object>> uploadAliyunToken(@Body AliyunTokenBasicParameterModel aliyunTokenBasicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/antiCheating/deviceInfo")
    Observable<ApiResult<Object>> uploadUserDevice(@Body UserDeviceBasicParameterModel userDeviceBasicParameterModel);

    @Headers({"needToken:true"})
    @POST("api/file/upload")
    Observable<ApiResult<UploadVideoReponse>> uploadVideo(@Body RequestBody requestBody);
}
