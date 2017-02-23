package pe.com.orbis.storesdk.api;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import pe.com.orbis.storesdk.model.response.ErrorResponse;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public class ErrorUtil {

    public static ErrorResponse parseError(Response<?> response) {

        Converter<ResponseBody, ErrorResponse> converter = StoreApiManager.getRetrofit()
                .responseBodyConverter(ErrorResponse.class,
                        new Annotation[0]);

        ErrorResponse error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ErrorResponse();
        }

        return error;
    }

}
