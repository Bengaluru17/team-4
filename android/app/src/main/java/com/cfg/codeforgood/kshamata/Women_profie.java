package com.cfg.codeforgood.kshamata;

import android.content.Intent;
import android.provider.BlockedNumberContract;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import dalvik.system.BaseDexClassLoader;

public class Women_profie extends AppCompatActivity {


    FirebaseAuth Auth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private RecyclerView mCardView;
    DatabaseReference mDatabase;
    StringBuffer buffer = new StringBuffer();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_profie);

        Auth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("women");
        mDatabase.keepSynced(true);
        mCardView = (RecyclerView)findViewById(R.id.recycler_view);
        mCardView.setHasFixedSize(true);
        mCardView.setLayoutManager(new LinearLayoutManager(this));



        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {

                    Intent loginIntent = new Intent(Women_profie.this, LoginActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);

                }
            }
        };



    }
    protected void onStart() {
        super.onStart();
        Auth.addAuthStateListener(mAuthListener);
        FirebaseRecyclerAdapter<Blog, CardViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, CardViewHolder>(
                Blog.class,
                R.layout.blog_row,
                CardViewHolder.class,
                mDatabase
        ) {
            @Override
            protected void populateViewHolder(CardViewHolder viewHolder, Blog model, final int position) {
                viewHolder.setFullname(model.getFullname());
                viewHolder.setlocation(model.getLocation());
                viewHolder.setlocation(model.getId());


                }
        };
        mCardView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public CardViewHolder(View itemView) {
            super(itemView);

            mView =  itemView;
        }

        public void setFullname(String fullName){
            TextView post_name = (TextView) mView.findViewById(R.id.name_field);
            post_name.setText(fullName);
        }
        public void setlocation(String location){
            TextView post_location = (TextView) mView.findViewById(R.id.location_field);
            post_location.setText(location);

        }



    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.action_logout) {
         logout();
        }

        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        Auth.signOut();
    }



}
