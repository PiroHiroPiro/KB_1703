package haruurara.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FeedbackActivity extends AppCompatActivity {

    Globals globals;
    int user_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        globals = (Globals)this.getApplication();

        Intent intent = getIntent();
        user_num = intent.getIntExtra("user_num", 0);
        TextView feedbackView = (TextView) findViewById(R.id.feedback_view);
        String feedbackText = "";
        for(int i = 0; i < globals.users.get(user_num).feedbacks.size();i++){
            feedbackText += "・";
            feedbackText += globals.users.get(user_num).feedbacks.get(i);
            feedbackText += "\n\n";
        }
        if(feedbackText == ""){
            feedbackText = "フィードバック無し！すごい！！";
        }
        feedbackView.setText(feedbackText);
        Button Feedback_ok_button = (Button)findViewById(R.id.Feedback_ok_button);

        Feedback_ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globals.users.get(user_num).is_alive = true;
                globals.users.get(user_num).clearFeedbacks();
                user_num++;
                if(user_num < globals.users.size()) {
                    Intent intent = new Intent();
                    intent.setClassName("haruurara.android", "haruurara.android.ConfirmActivity");
                    intent.putExtra("user_num", user_num);
                    startActivity(intent);
                    FeedbackActivity.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.setClassName("haruurara.android", "haruurara.android.WriteIdeaActivity");
                    startActivity(intent);
                    FeedbackActivity.this.finish();
                }
            }
        });
    }
}
