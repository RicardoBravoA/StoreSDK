package pe.com.orbis.storesdk.model.entity;

/**
 * Created by Ricardo Bravo on 23/02/17.
 */


public class UrlEntity {

    /**
     * url_base : http://192.168.2.10:8888/StoreApi/v1/
     * url_login : login/
     * url_register : register/
     */

    private String url_base;
    private String url_login;
    private String url_register;

    public String getUrl_base() {
        return url_base;
    }

    public void setUrl_base(String url_base) {
        this.url_base = url_base;
    }

    public String getUrl_login() {
        return url_login;
    }

    public void setUrl_login(String url_login) {
        this.url_login = url_login;
    }

    public String getUrl_register() {
        return url_register;
    }

    public void setUrl_register(String url_register) {
        this.url_register = url_register;
    }
}
