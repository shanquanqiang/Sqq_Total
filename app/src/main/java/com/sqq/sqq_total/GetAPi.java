package com.sqq.sqq_total;

import com.sqq.sqq_total.servicedata.HeadlineItem;
import com.sqq.sqq_total.servicedata.PicCommetItem;
import com.sqq.sqq_total.servicedata.PicItem;
import com.sqq.sqq_total.servicedata.SlideviewItem;
import com.sqq.sqq_total.servicedata.TextItem;
import com.sqq.sqq_total.servicedata.VideoCommentItem;
import com.sqq.sqq_total.servicedata.VideoItem;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sqq on 2016/6/8.
 * 不指定Cache-Control也缓存了，但是过期时间很短
 */
public interface GetAPi {

    ///////////////////headlineitem///////////////////
    /**
     * 加载最新的count条数据，用于下拉刷新和一开始加载的时候
     *
     * @param count
     * @return
     */
    @Headers("Cache-Control:max-age=10")
    @GET("headlineitem.php")
    Observable<List<HeadlineItem>> getLatestItemInfo(@Query("count") int count);

    /**
     * 取小于这个id的count条数据，用于加载更多
     * @param count
     * @param id
     * @return
     */
    @Headers("Cache-Control:max-age=3600")
    @GET("headlineitem.php")
    Observable<List<HeadlineItem>> getItemInfo(@Query("count") int count,@Query("id") long id);

    /**
     * 加载最新的count条数据，用于下拉刷新和一开始加载的时候,默认是4
     * @param count
     * @return
     */
    @Headers("Cache-Control:max-age=10")
    @GET("slideviewitem.php")
    Observable<List<SlideviewItem>> getLatestSlideviewInfo(@Query("count") int count);

/*    *//**
     * 取小于这个id的count条数据，用于加载更多
     * @param count
     * @param id
     * @return
     *//*
    @GET("slideviewitem.php")
    Observable<List<SlideviewItem>> getSlideviewInfo(@Query("count") int count,@Query("id") int id);*/

///////////////////textitem///////////////////
    /**
     * 加载最新的count条数据，用于下拉刷新和一开始加载的时候,默认是4
     * @param count
     * @return
     */
    @Headers("Cache-Control:max-age=10")
    @GET("textitem.php")
    Observable<List<TextItem>> getLatestTextItemInfo(@Query("count") int count);

    /**
     * 取小于这个id的count条数据，用于加载更多
     * @param count
     * @param id
     * @return
     */
    @Headers("Cache-Control:max-age=3600")
    @GET("textitem.php")
    Observable<List<TextItem>> getTextItemInfo(@Query("count") int count,@Query("id") long id);

    ///////////////////picitem///////////////////
    /**
     * 加载最新的count条数据，用于下拉刷新和一开始加载的时候,默认是4
     * @param count
     * @return
     */
    @Headers("Cache-Control:max-age=10")
    @GET("picitem.php")
    Observable<List<PicItem>> getLatestPicItemInfo(@Query("count") int count);

    /**
     * 取小于这个id的count条数据，用于加载更多
     * @param count
     * @param id
     * @return
     */
    @Headers("Cache-Control:max-age=3600")
    @GET("picitem.php")
    Observable<List<PicItem>> getPicItemInfo(@Query("count") int count,@Query("id") long id);

    ///////////////////videoitem///////////////////
    /**
     * 加载最新的count条数据，用于下拉刷新和一开始加载的时候,默认是4
     * @param count
     * @return
     */
    @Headers("Cache-Control:max-age=10")
    @GET("videoitem.php")
    Observable<List<VideoItem>> getLatestVideoItemInfo(@Query("count") int count);

    /**
     * 取小于这个id的count条数据，用于加载更多
     * @param count
     * @param id
     * @return
     */
    @Headers("Cache-Control:max-age=3600")
    @GET("videoitem.php")
    Observable<List<VideoItem>> getVideoItemInfo(@Query("count") int count,@Query("id") long id);


    ///////////////////获取评论以及发表评论/////////////
    //////////////图片的评论
    /**
     * 加载最新的count条数据，用于下拉刷新和一开始加载的时候,默认是4
     * @param count
     * @return
     */
    @Headers("Cache-Control:max-age=10")
    @GET("pic_comment.php")
    Observable<List<PicCommetItem>> getLatestPicCommentInfo(@Query("count") int count,@Query("picId") long picId);

    /**
     * 取小于这个id的count条数据，用于加载更多
     * @param count
     * @param id
     * @return
     */
    @Headers("Cache-Control:max-age=3600")
    @GET("pic_comment.php")
    Observable<List<PicCommetItem>> getPicCommentInfo(@Query("count") int count,@Query("picId") long picId
            ,@Query("id") long id);

    @Multipart
    @POST("publishComment.php")
    Observable<Void> publishComment(@Part("picId") RequestBody picId,@Part("userId") RequestBody userId,
                                    @Part("comment") RequestBody comment);

    //////////////视频的评论
    /**
     * 加载最新的count条数据，用于下拉刷新和一开始加载的时候,默认是4
     * @param count
     * @return
     */
    @Headers("Cache-Control:max-age=10")
    @GET("video_comment.php")
    Observable<List<VideoCommentItem>> getLatestVideoCommentItemInfo(@Query("count") int count,@Query("videoId") long videoId);

    /**
     * 取小于这个id的count条数据，用于加载更多
     * @param count
     * @param id
     * @return
     */
    @Headers("Cache-Control:max-age=3600")
    @GET("video_comment.php")
    Observable<List<VideoCommentItem>> getVideoCommentItemInfo(@Query("count") int count,@Query("videoId") long videoId
            ,@Query("id") long id);

    @Multipart
    @POST("publishVideoComment.php")
    Observable<Void> publishVideoComment(@Part("videoId") RequestBody videoId,@Part("userId") RequestBody userId,
                                    @Part("comment") RequestBody comment);


    //////////////上传图片
    @Multipart
    @POST("uploadpic.php")
    Observable<Void> uploadPic(@Part MultipartBody.Part pic,@Part("itemTitle") RequestBody title
    ,@Part("userId") RequestBody userId);


    /**
     * 测试缓存用的
     * @return
     */
    /*@Headers("Cache-Control:max-age=640000")
    @GET("index.php")
    Observable<String> getPassword(@Query("id") int id);

    @Headers("Cache-Control:public,max-age=10")
    @GET("index2.php")
    Observable<String> getPassword();

    @FormUrlEncoded
    @POST("test.php")
    Observable<Boolean> setUrl(@Field("url") String url);
    @FormUrlEncoded
    @POST("test.php")
    Observable<Boolean> setDate(@Field("date") long date);*/
}
