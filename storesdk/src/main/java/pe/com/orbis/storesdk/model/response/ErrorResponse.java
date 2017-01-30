package pe.com.orbis.storesdk.model.response;

/**
 * Created by Ricardo Bravo on 30/01/17.
 */

public class ErrorResponse {


    /**
     * _meta : {"status":"error","code":"100","message":"No existe información"}
     */

    private MetaBean _meta;

    public MetaBean get_meta() {
        return _meta;
    }

    public void set_meta(MetaBean _meta) {
        this._meta = _meta;
    }

    public static class MetaBean {
        /**
         * status : error
         * code : 100
         * message : No existe información
         */

        private String status;
        private String code;
        private String message;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
