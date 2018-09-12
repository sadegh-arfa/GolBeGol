package health.sport.oxygen.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by S_ on 9/11/2018.
 * Sadegh.arfa@gmail.com
 * +989303033100
 */
public class User {

    @SerializedName("error")
    @Expose
    private boolean error;


    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("user")
    @Expose
    private userItem item;


    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public userItem getItem() {
        return item;
    }

    public void setItem(userItem item) {
        this.item = item;
    }

    public class userItem {

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("api_key")
        @Expose
        private String api_key;

        @SerializedName("created_at")
        @Expose
        private String created_at;

        @SerializedName("status")
        @Expose
        private int status;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getApi_key() {
            return api_key;
        }

        public void setApi_key(String api_key) {
            this.api_key = api_key;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }


}
