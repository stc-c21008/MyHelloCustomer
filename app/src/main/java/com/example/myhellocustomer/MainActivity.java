package com.example.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btClick = findViewById(R.id.btClick);
        HelloListener listener = new HelloListener();   //リスナのインスタンス生成
        btClick.setOnClickListener(listener);           //ボタンにリスナを組み込む

        Button btlClear = findViewById(R.id.btLive);
        btlClear.setOnClickListener(listener);

        Button btnClear = findViewById(R.id.btName);
        btnClear.setOnClickListener(listener);
    }

    //リスナクラス <= イベントの監視
    private class HelloListener implements View.OnClickListener {

        //イベントハイドラ　<= イベント発生時
        @Override
        public void onClick(View view) {
            EditText inlive = findViewById(R.id.etLive);
            EditText inname = findViewById(R.id.etName);
            TextView output = findViewById(R.id.tvOutput);

            int id = view.getId();
            switch (id) {
                case R.id.btClick:
                    String inliveStr = inlive.getText().toString();
                    String innameStr = inname.getText().toString();
                    output.setText(inliveStr + "にお住いの" + innameStr + "さん、こんにちは！");
                    break;

                case R.id.btLive:
                    inlive.setText("");
                    output.setText("");
                    break;

                case R.id.btName:
                    inname.setText("");
                    output.setText("");
                    break;
            }
        }
    }
}