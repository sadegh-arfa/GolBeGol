package health.sport.oxygen.server;


import health.sport.oxygen.BuildConfig;
import health.sport.oxygen.models.User;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    String Version = BuildConfig.VERSION_NAME;
    String Agent = BuildConfig.APPLICATION_ID;


    @POST("login")
    @Headers({"User-Agent:" + Agent,
            "App-Version:" + Version })
    @FormUrlEncoded
    Call<User> login(@Field("email") String email,
                     @Field("password") String password);


    @POST("register")
    @Headers({"User-Agent:" + Agent,
            "App-Version:" + Version })
    @FormUrlEncoded
    Call<User> register(@Field("name") String name,
                        @Field("email") String email,
                        @Field("password") String password);




     @GET("news?catID=9&instant=y&mobile=y&khabarjoo")
    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
    Call<ResponseBody> getNews(@Query("page") int number);

//
//    @POST("Account/Firebase")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> setToken(@Header("language") String language, @Header("Authorization") String token, @Body FireBaseToken fireBaseToken);
//
//    @POST("profile/gift")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<StatusResponce> setGift(@Header("language") String language, @Header("Authorization") String token, @Body SetGiftQuery setGiftQuery);
//
//    @POST("profile/name")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<StatusResponce> setUsername(@Header("language") String language, @Header("Authorization") String token, @Body SetUsernameQuery query);
//
//    @POST("Account/SetPassword")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> setPass(@Header("language") String language, @Header("Authorization") String token, @Body PasswordQuery query);
//
//    @POST("Account/ChangePassword")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> changePass(@Header("language") String language, @Header("Authorization") String token, @Body PasswordQuery query);
//
//    @GET("profile")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ProfileModel> getProfile(@Header("language") String language, @Header("Authorization") String token);
//
//    @POST("Account/VerifyPhoneNumber")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<LoginUserItem> validate(@Header("language") String language, @Body RegisterValidateRequest validateRequest);
//
//
//    @POST("Account/Login")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<LoginUserItem> login(@Header("language") String language, @Body RegisterRequest userRequest);
//
//
//    @POST("statistics/InstalledApps")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<UpdatedApps> sendPackages(@Header("language") String language, @Header("Authorization") String token, @Body installedApps apps);
//
//
//    @POST("Comment")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> addComment(@Header("language") String language, @Header("Authorization") String token, @Body CommentForm commentForm);
//
//
//    @POST("Comment/report")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> reportComment(@Header("language") String language, @Header("Authorization") String token, @Body CommentReport CommentReport);
//
//    @POST("Comment/vote")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> voteComment(@Header("language") String language, @Header("Authorization") String token, @Body CommentVote commentVote);
//
//
//    @POST("app/ToggleBookmark/{packageName}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> setBookmark(@Header("language") String language, @Header("Authorization") String token, @Path(value = "packageName", encoded = true) String packageName);
//
//
//    @POST("app/{packageName}/report")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> sendAppReport(@Header("language") String language, @Header("Authorization") String token, @Path(value = "packageName", encoded = true) String packageName, @Body appReport report);
//
//
//    @GET("Comment/{packageName}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<CommentsPage> getAllComments(@Header("language") String language, @Header("Authorization") String token, @Path(value = "packageName", encoded = true) String packageName, @Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);
//
//
//
//    @GET("page")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<BasePage> getBasetPage(@Header("language") String language, @Header("Authorization") String token, @Query("place") int placeId);
//
//    @GET("category")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<List<CategoryPage>> getCategories(@Header("language") String language, @Header("Authorization") String token);
//
//    @GET("category/{name}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<BasePage> getSubCategory(@Header("language") String language, @Header("Authorization") String token, @Path(value = "name", encoded = true) String name);
//
//
//    @GET("q/{query}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<List<SearchFastQuery>> getForceSearch(@Header("language") String language, @Header("Authorization") String token, @Path(value = "query", encoded = true) String name);
//
//
//    @GET("search/{query}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<Box> getSearch(@Header("language") String language, @Header("Authorization") String token, @Path(value = "query", encoded = true) String name, @Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);
//
//
//
//    @GET("{query}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<Box> getAppList(@Header("language") String language, @Header("Authorization") String token, @Path(value = "query", encoded = true) String name, @Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);
//
//
//    @GET("{query}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<UpdatedApps> getBookmarks(@Header("language") String language, @Header("Authorization") String token, @Path(value = "query", encoded = true) String name, @Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);
//
//
//
//    @GET("app/{packageName}?fromApp=true")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version , "Content-Type:application/json"})
//    Call<Application> getApplication(@Header("language") String language, @Header("Authorization") String token, @Path(value = "packageName", encoded = true) String packageName);
//
//
//    @POST("app/buy/{packageName}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version , "Content-Type:application/json"})
//    Call<InstallResponse> buyApp(@Header("language") String language, @Header("Authorization") String token, @Path(value = "packageName", encoded = true) String packageName);
//
//
//    @GET("Payment/Prices")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<Prices> getPrices(@Header("language") String language, @Header("Authorization") String token);
//
//
//    @GET("Payment/Bankes")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<Banks> getBanks(@Header("language") String language, @Header("Authorization") String token);
//
//
//    @GET("profile/Transcation")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<TransactionsModel> getTransActions(@Header("language") String language, @Header("Authorization") String token, @Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);
//
//
//
//
//    @GET("marketversion/0/{number}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<UpdateRes> getUpdate(@Header("language") String language, @Header("Authorization") String token, @Query("number") int number);
//
//
//
//
//    @GET("Account/ValidateQrCode/{id}")
//    @Headers({"User-Agent:" + Agent, "App-Version:" + Version})
//    Call<ResponseBody> getLoginStatus(@Header("language") String language, @Header("Authorization") String token, @Query("id") String id);
//
//


}
