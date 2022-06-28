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
            EditText inlive = findViewById(R.id.etLive);    //入力した住所を挿入
            EditText inname = findViewById(R.id.etName);    //入力した名前を挿入
            TextView output = findViewById(R.id.tvOutput);  //出力関数

            int id = view.getId();
            switch (id) {   //ボタン入力
                case R.id.btClick:  //表示ボタン
                    String inliveStr = inlive.getText().toString(); //住所を文字列型へ
                    String innameStr = inname.getText().toString(); //名前を文字列型へ
                    output.setText(inliveStr + "にお住いの" + innameStr + "さん、こんにちは！");  //出力
                    break;

                case R.id.btLive:   //住所クリア
                    inlive.setText("");
                    output.setText("");
                    break;

                case R.id.btName:   //名前クリア
                    inname.setText("");
                    output.setText("");
                    break;
            }
        }
    }
}