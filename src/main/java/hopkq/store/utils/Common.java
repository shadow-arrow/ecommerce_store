package hopkq.store.utils;

import org.springframework.stereotype.Component;

public class Common {

    public class Status {
        public static final String STATUS_PRODUCT_AVAILABLE = "1";
        public static final String STATUS_PRODUCT_SALE = "2";
        public static final int ACCOUNT_ACTIVE = 1;

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
