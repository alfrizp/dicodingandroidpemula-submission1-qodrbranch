package com.example.alip.submissionmembuataplikasiandroidpemula;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBranch;
    TextView tvBranchName, tvBranchAddress, tvDetailTitle, tvBranchPhone, tvBranchEmail;
    String name, address, phone, email;
    int imgID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgBranch = findViewById(R.id.img_branch);
        tvDetailTitle = findViewById(R.id.tv_detail_title);
        tvBranchName = findViewById(R.id.tv_branch_name);
        tvBranchAddress = findViewById(R.id.tv_branch_address);
        tvBranchPhone = findViewById(R.id.tv_branch_phone);
        tvBranchEmail = findViewById(R.id.tv_branch_email);

        name = getIntent().getStringExtra("name");
        address = getIntent().getStringExtra("address");
        phone = getIntent().getStringExtra("phone");
        email = getIntent().getStringExtra("email");
        imgID = getIntent().getIntExtra("photo", R.drawable.hq);

        getSupportActionBar().setTitle("Detail " + name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvDetailTitle.setText(name);
        tvBranchName.setText(name);
        tvBranchAddress.setText(address);
        tvBranchPhone.setText(Html.fromHtml("<u>"+phone+"</u>"));
        tvBranchPhone.setTextColor(Color.BLUE);
        tvBranchEmail.setText(Html.fromHtml("<u>"+email+"</u>"));
        tvBranchEmail.setTextColor(Color.BLUE);
        imgBranch.setImageResource(imgID);

        tvBranchPhone.setOnClickListener(this);
        tvBranchEmail.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_branch_phone:
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(dialPhoneIntent);
                break;
            case R.id.tv_branch_email:
                Intent emailSendIntent = new Intent(Intent.ACTION_SENDTO);
                emailSendIntent.setData(Uri.parse("mailto:"+email));
                startActivity(emailSendIntent);

                break;
        }
    }
}
