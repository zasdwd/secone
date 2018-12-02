package com.example.mex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Class<EnventMessage> enventMessageClass = EnventMessage.class;
                    Method eat = enventMessageClass.getDeclaredMethod("eat");

                    eat.invoke(enventMessageClass, 10);
                    Test annotation = enventMessageClass.getAnnotation(Test.class);

                    String s = annotation.userName();
                    String s1 = annotation.Password();
                    if (s.equals("zhangsan")) {
                        Toast.makeText(MainActivity.this, "用户名正确!", Toast.LENGTH_SHORT).show();
                        if (s1.equals("123456")) {
                            Toast.makeText(MainActivity.this, "密码正确!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "有错误哦!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
