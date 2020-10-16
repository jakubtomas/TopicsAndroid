package sk.itsovy.adnroid.topics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // manager fragmentov                             /// layout sa nahradi fragmentom
        if (smallDevice()) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_activity, new MainFragment())
                    .commit();// nejaky view nahradim fragmentom

            // this pre tuto aktivitu
            TopicsViewModel model = new ViewModelProvider(this).get(TopicsViewModel.class);
            model.getSelectedTopic().observe(this, this::showDetailAcitivity); // nastavit poyorovatela

        }

    }

    private boolean smallDevice() {
        return findViewById(R.id.main_activity) != null ;
    }
    // nafukne layout
    // nahradim aktulany fragmentom

    private void showDetailAcitivity(Topic topic) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity, new DetailFragment())
                .addToBackStack(null) // sipka naspat vrati  napat fragment
                .commit();// nejaky view nahradim fragmentom
    }




}