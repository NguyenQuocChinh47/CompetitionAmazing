package com.example.randomimage;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    TextView txt1;
    int diemSo =100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
        click();

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });
    }

    private void click() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked()) {
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    btn1.setVisibility(View.INVISIBLE);
                    CountDownTimer countDownTimer = new CountDownTimer(60000, 500) {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int number = 5;
                            Random random = new Random();
                            int timer1 = random.nextInt(number);
                            int timer2 = random.nextInt(number);
                            int timer3 = random.nextInt(number);

                            if(sb1.getProgress()>= sb1.getMax()){
                                this.cancel();
                                btn1.setVisibility(View.VISIBLE);
                                if(cb1.isChecked()){
                                    diemSo = diemSo + 10;
                                    Toast.makeText(MainActivity.this, "Bạn đoán đúng số 1 đã về đích sớm nhất", Toast.LENGTH_SHORT).show();
                                }else {
                                    diemSo -=5;
                                    Toast.makeText(MainActivity.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                                }
                                txt1.setText("Điểm: " + diemSo);
                                enableCheckBox();
                            }

                            if(sb2.getProgress()>= sb2.getMax()){
                                this.cancel();
                                btn1.setVisibility(View.VISIBLE);
                                if(cb2.isChecked()){
                                    diemSo +=10;
                                    Toast.makeText(MainActivity.this, "Bạn đoán đúng số 2 đã về đích sớm nhất", Toast.LENGTH_SHORT).show();
                                }else {
                                    diemSo -=5;
                                    Toast.makeText(MainActivity.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                                }
                                txt1.setText("Điểm: " + diemSo);
                                enableCheckBox();
                            }

                            if(sb3.getProgress()>= sb3.getMax()){
                                this.cancel();
                                btn1.setVisibility(View.VISIBLE);
                                if(cb3.isChecked()){
                                    diemSo +=10;
                                    Toast.makeText(MainActivity.this, "Bạn đoán đúng số 3 đã về đích sớm nhất", Toast.LENGTH_SHORT).show();
                                }else {
                                    diemSo -=5;
                                    Toast.makeText(MainActivity.this, "Bạn đoán sai", Toast.LENGTH_SHORT).show();
                                }
                                txt1.setText("Điểm: " + diemSo);
                                enableCheckBox();
                            }
                            sb1.setProgress(sb1.getProgress()+ timer1+1);
                            sb2.setProgress(sb2.getProgress()+ timer2+1);
                            sb3.setProgress(sb3.getProgress()+ timer3+1);
                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();
                    disEnableCheckBox();
                } else{
                    Toast.makeText(MainActivity.this,"Dat cuoc", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    private void enableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void disEnableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void anhXa() {
        txt1 = findViewById(R.id.txt_1);
        sb1 = findViewById(R.id.sb_1);
        sb2 = findViewById(R.id.sb_2);
        sb3 = findViewById(R.id.sb_3);
        cb1 = findViewById(R.id.cb_1);
        cb2 = findViewById(R.id.cb_2);
        cb3 = findViewById(R.id.cb_3);
        btn1 = findViewById(R.id.btn_1);
    }
}