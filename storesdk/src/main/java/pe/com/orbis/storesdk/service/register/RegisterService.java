package pe.com.orbis.storesdk.service.register;

import pe.com.orbis.storesdk.api.ErrorUtil;
import pe.com.orbis.storesdk.api.StoreApiManager;
import pe.com.orbis.storesdk.model.request.RegisterRequest;
import pe.com.orbis.storesdk.model.response.ErrorResponse;
import pe.com.orbis.storesdk.model.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 31/01/17.
 */

public class RegisterService {

    public static void register(RegisterRequest registerRequest, final RegisterCallback callback){

        Call<RegisterResponse> call = StoreApiManager.apiManager().register(registerRequest);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    callback.onRegisterResponse(response.body());
                }else{
                    callback.onRegisterError(ErrorUtil.parseError(response));
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                ErrorResponse errorResponse = new ErrorResponse();
                ErrorResponse.MetaBean metaBean = new ErrorResponse.MetaBean();
                metaBean.setCode("1000");
                metaBean.setMessage(t.getMessage());
                metaBean.setStatus("500");
                errorResponse.set_meta(metaBean);
                callback.onRegisterError(errorResponse);
            }
        });

    }

}
