package css.cis3334trace.fishguidefinal;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btnBass, btnCrappie, btnCatfish, btnTrout, btnNorthern, btnMuskey;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//sets up the firebase authentication
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // User is signed in
                    Log.d("cis3334", "onAuthStateChanged -user is not signed in");
                    Intent loginIntent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(loginIntent);
                }

                // ...
            }
        };



    }
//starts the authentication listener to check if the user is logged in
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    // stops the authentication listener
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
// large if statement that will start the next activity based on which botton is selected
    public void OnClickResult(View view){
    if(view.getId() == R.id.buttonBass){
        Intent intent = new Intent(this, BassActivity.class);
        startActivity(intent);

    }else if(view.getId() == R.id.buttonCrappie){
        Intent intent = new Intent(this, CrappieActivity.class);
        startActivity(intent);
    }else if(view.getId() == R.id.buttonNorthern){
        Intent intent = new Intent(this,NorthernActivity.class);
        startActivity(intent);
    }else if(view.getId() == R.id.buttonCatfish){
        Intent intent = new Intent(this, CatfishActivity.class);
        startActivity(intent);
    }else if(view.getId() == R.id.buttonTrout){
        Intent intent = new Intent(this, TroutActivity.class);
        startActivity(intent);
    }else if(view.getId() == R.id.buttonMuskey){
        Intent intent = new Intent(this, MuskeyActivity.class);
        startActivity(intent);
    }else if(view.getId() == R.id.buttonLakes){
        Intent intent = new Intent(this, LakeActivity.class);
        startActivity(intent);
    }else if(view.getId() == R.id.buttonLures){
        Intent intent = new Intent(this, LuresActivity.class);
        startActivity(intent);
    }else if(view.getId() == R.id.buttonLogout){
        mAuth.signOut(); //End user session
        startActivity(new Intent(this, LoginActivity.class)); //Go back to home page
        finish();
    }
}





}
