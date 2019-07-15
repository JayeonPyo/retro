package com.example.applpiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkHelper.getInstance().Ssing("qwer").enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(MainActivity.this,response.body(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("error",t.toString());

                    }
                });
            }
        });
    }

}
