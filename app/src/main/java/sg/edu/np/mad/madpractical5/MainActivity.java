package sg.edu.np.mad.madpractical5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String userName = "MAD " + generateRandomNumber(); // Combine "MAD" with the random number

        User user = new User(userName, "MAD Developer",1,false);

        TextView tvName = findViewById(R.id.textView);
        TextView tvDescription = findViewById(R.id.textView1);
        Button btnFollow = findViewById(R.id.button1);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = btnFollow.getText().toString();

                if (buttonText.equals("Follow")) {
                    btnFollow.setText("Unfollow");
                    Toast t = Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_LONG);
                    t.show();

                } else {
                    btnFollow.setText("Follow");
                    Toast t = Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_LONG);
                    t.show();

                }
            }
        });
    }
    private String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Generates a random 6-digit number
        return String.valueOf(randomNumber);
    }
}