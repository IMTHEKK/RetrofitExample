package com.abc.example;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<EmailListResponse> arrayList = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(actionBar.getDisplayOptions() | ActionBar.DISPLAY_SHOW_CUSTOM);
            ImageView imageView = new ImageView(actionBar.getThemedContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.drawable.ic_add_black_24dp);
            ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT, Gravity.END
                    | Gravity.CENTER_VERTICAL);
            layoutParams.rightMargin = 40;
            imageView.setLayoutParams(layoutParams);
            actionBar.setCustomView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Edit");

                    final AppCompatEditText input = new AppCompatEditText(MainActivity.this);
                    input.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT));
                    input.setHint("Email here");
                    builder.setView(input);
                    builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Call<EmailListResponse> result = Api.getClient().addEmail(new EmailListResponse(String.valueOf(input.getText()), true));
                            result.enqueue(new Callback<EmailListResponse>() {
                                @Override
                                public void onResponse(Call<EmailListResponse> call, Response<EmailListResponse> response) {
                                    arrayList.add(response.body());
                                    recyclerAdapter = new RecyclerAdapter(MainActivity.this, arrayList);
                                    recyclerView.setAdapter(recyclerAdapter);
                                }

                                @Override
                                public void onFailure(Call<EmailListResponse> call, Throwable t) {

                                }
                            });
                        }
                    });
                    builder.show();
                }
            });
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<ArrayList<EmailListResponse>> result = Api.getClient().getEmails();
        result.enqueue(new Callback<ArrayList<EmailListResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<EmailListResponse>> call, Response<ArrayList<EmailListResponse>> response) {
                arrayList = response.body();
                recyclerAdapter = new RecyclerAdapter(MainActivity.this, arrayList);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<EmailListResponse>> call, Throwable t) {

            }
        });
    }

}
