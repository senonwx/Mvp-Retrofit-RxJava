package com.cars.mvpsenon.buildermode;

import android.content.Context;

/**
 * 作者：senon on 2017/11/6 15:09
 * 邮箱：a1083911695@163.com
 */

public class MyBuilder {
    private Context context;
    private String name;
    private String sex;
    private int age;
    private float height;
    private float weight;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (!name.isEmpty()) {
            sb.append("姓名：" + name);
        }
        if (!sex.isEmpty()) {
            sb.append("\n性别：" + sex);
        }
        if (age != 0) {
            sb.append("\n年龄：" + age);
        }
        if (height != 0) {
            sb.append("\n身高：" + height);
        }
        if (weight != 0) {
            sb.append("\n体重：" + weight);
        }
        return "MyBuilder{" +
                "context=" + context +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}' + "\n" + sb;
    }

    public static class Builder {
        private Context context;
        private String name;
        private String sex;
        private int age;
        private float height;
        private float weight;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setHeight(float height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(float weight) {
            this.weight = weight;
            return this;
        }

        private void apply(MyBuilder myBuilder) {
            myBuilder.context = context;
            myBuilder.age = age;
            myBuilder.height = height;
            myBuilder.name = name;
            myBuilder.sex = sex;
            myBuilder.weight = weight;
        }

        public MyBuilder builder() {
            MyBuilder myBuilder = new MyBuilder();
            apply(myBuilder);
            return myBuilder;
        }
    }
}
