package com.cars.mvpsenon.data;

/**
 * 登录成功的实体类
 */

public class Login {

    /**
     * msg : 成功
     * code : 0
     * data : {"sex":2,"fullName":"系统管理员","userType":2,"userName":"admin","tele":"3455",
     * "userId":"861809597140168704","orgId":"904636674188767232"}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sex : 2
         * fullName : 系统管理员
         * userType : 2
         * userName : admin
         * tele : 3455
         * userId : 861809597140168704
         * orgId : 904636674188767232
         */

        private int sex;
        private String fullName;
        private int userType;
        private String userName;
        private String tele;
        private String userId;
        private String orgId;

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getTele() {
            return tele;
        }

        public void setTele(String tele) {
            this.tele = tele;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }
    }
}
