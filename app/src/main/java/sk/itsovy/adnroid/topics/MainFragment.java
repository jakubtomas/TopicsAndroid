package sk.itsovy.adnroid.topics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainFragment extends Fragment implements OnTopicClickListener {
    //
    public MainFragment() {
        // Required empty public constructor
    }



    @Override                  //infalter ktore bude nafukovat UI
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment  //nafukne tam nejaky layout
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    // pri vytvarani fragmentu sa najprv zavola onCreateView  sa nafukne layout
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { // vieme dalse veci s layoutom
        super.onViewCreated(view, savedInstanceState);
       RecyclerView recyclerView = view.findViewById(R.id.recyclerViewTopics); // zavolam view ktory mame nafuknuty
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // vieme sa spytať aka je jeho aktivita aka je jeho kontext getActivity
        TopicsAdapter adapter = new TopicsAdapter();
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onTopicClick(Topic topic) { // ked sa klikne na onTOpic potrebujem ziskat view model a nastavit selected topic
        TopicsViewModel model = new ViewModelProvider(requireActivity()).get(TopicsViewModel.class);

    }
}