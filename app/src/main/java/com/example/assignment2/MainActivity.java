package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView navigationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationTV = findViewById(R.id.navigationTV);
        drawerLayout = findViewById(R.id.drawer_layout);
        loadFragment(new HomeFragment());
    }

    public void ClickMenu(View view) {
        openDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        closeDrawer(drawerLayout);
        navigationTV.setText("Home");
        loadFragment(new HomeFragment());
    }

    public void ClickBookmarks(View view){
        closeDrawer(drawerLayout);
        Intent intent;
        intent = new Intent(getApplicationContext(), BookmarksActivity.class);
        startActivity(intent);
    }

    public void ClickSearch(View view){
        closeDrawer(drawerLayout);
        Intent intent;
        intent = new Intent(getApplicationContext(), PhraseSearchActivity.class);
        startActivity(intent);
    }

    public void ClickAboutUs(View view){
        closeDrawer(drawerLayout);
        navigationTV.setText("About Us");
        loadFragment(new AboutUsFragment());
    }

    public void ClickGame(View view){
        closeDrawer(drawerLayout);
        Intent intent;
        intent = new Intent(getApplicationContext(), MatchingGameActivity.class);
        startActivity(intent);
    }

    public void ClickLogout(View view){
        logout(this);
    }

    public void ClickEmpty(View view){
        closeDrawer(drawerLayout);
    }

    public void logout(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure that you want to logout");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
            }
        });
        builder.show();
    }

    public void onButtonClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), PhrasesListActivity.class);
        switch (view.getId()) {
            case R.id.bank:
                intent.putExtra("ItemIndex", "0");
                break;
            case R.id.basic:
                intent.putExtra("ItemIndex", "1");
                break;
            case R.id.bus:
                intent.putExtra("ItemIndex", "2");
                break;
            case R.id.cafe:
                intent.putExtra("ItemIndex", "3");
                break;
            case R.id.common:
                intent.putExtra("ItemIndex", "4");
                break;
            case R.id.dating:
                intent.putExtra("ItemIndex", "5");
                break;
            case R.id.dentist:
                intent.putExtra("ItemIndex", "6");
                break;
            case R.id.dinner:
                intent.putExtra("ItemIndex", "7");
                break;
            case R.id.direction:
                intent.putExtra("ItemIndex", "8");
                break;
            case R.id.dry_cleaner:
                intent.putExtra("ItemIndex", "9");
                break;
            case R.id.emergency:
                intent.putExtra("ItemIndex", "10");
                break;
            case R.id.exclamation:
                intent.putExtra("ItemIndex", "11");
                break;
            case R.id.hair_salon:
                intent.putExtra("ItemIndex", "12");
                break;
            case R.id.hospital:
                intent.putExtra("ItemIndex", "13");
                break;
            case R.id.hotel:
                intent.putExtra("ItemIndex", "14");
                break;
            case R.id.meeting:
                intent.putExtra("ItemIndex", "15");
                break;
            case R.id.movie:
                intent.putExtra("ItemIndex", "16");
                break;
            case R.id.pharmacy:
                intent.putExtra("ItemIndex", "17");
                break;
            case R.id.post_office:
                intent.putExtra("ItemIndex", "18");
                break;
            case R.id.restaurant:
                intent.putExtra("ItemIndex", "19");
                break;
            case R.id.shopping:
                intent.putExtra("ItemIndex", "20");
                break;
            case R.id.taxi:
                intent.putExtra("ItemIndex", "21");
                break;
        }
        startActivity(intent);
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }


    private void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    private void loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent e){
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            logout(this);
            return true;
        }
        else
            return super.onKeyDown(keyCode, e);
    }
}
