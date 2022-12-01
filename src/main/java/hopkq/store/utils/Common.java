package hopkq.store.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

public class Common {

    public static Timestamp getCurrentTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }


    public class Status {
        public static final String STATUS_PRODUCT_AVAILABLE = "1";
        public static final String STATUS_PRODUCT_SALE = "2";
        public static final int ACCOUNT_ACTIVE = 1;

        public static final String REGISTER_SUCCESS = "REGISTER_SUCCESS";

        public static final String REGISTER_FAILED = "REGISTER_FAILED";

        public static final int PROCESSING_ORDER = 1;

        public static final int PROCESSING_DELIVERY = 2;

        public static final int DELIVERY_SUCCESSFUL = 3;

        public static final int CANCELING_ORDER = 4;

        public static final int CANCELED_ORDER = 5;


        // public static final String STATUS_PRODUCT_NOT_AVAILABLE = "3";
    }

    public class Role {
        public static final int ADMIN = 1;

        public static final int CUSTOMER = 2;
    }

/*    public class Login {

        public static final int LOGIN_SUCCESSFULLY = 1;

        public static final int INVALID_USER_PASSWORD = 2;


    }*/

}
