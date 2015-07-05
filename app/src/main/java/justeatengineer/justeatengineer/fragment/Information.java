package justeatengineer.justeatengineer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import justeatengineer.justeatengineer.R;
import justeatengineer.justeatengineer.adapter.AdapterInformation;
import justeatengineer.justeatengineer.dto.DtoEntity;

/**
 * Created by luisangelgarcia on 7/5/15.
 */
public class Information extends Fragment {

    private View view;

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    private AdapterInformation adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_information, container, false);
        init();
        return view;
    }

    private void init() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    public void setInformation(List<DtoEntity> items) {
        adapter = new AdapterInformation(getActivity(), items);
        recyclerView.setAdapter(adapter);
    }

}
