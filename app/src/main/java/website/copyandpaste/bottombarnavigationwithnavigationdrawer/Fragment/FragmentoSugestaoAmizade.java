package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import website.copyandpaste.bottombarnavigationwithnavigationdrawer.R;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Adapter.AdapterSugestaoAmizade;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models.ModelsSugestaoAmizade;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoSugestaoAmizade extends Fragment {

    View view;
    private RecyclerView myrecycleView;
    private List<ModelsSugestaoAmizade> listModelsSugestaoAmizade;

    public static FragmentoSugestaoAmizade newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        FragmentoSugestaoAmizade fragmentoSugestaoAmizade = new FragmentoSugestaoAmizade();
        fragmentoSugestaoAmizade.setArguments(args);
        return fragmentoSugestaoAmizade;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sugestao_amizade, container, false);
        myrecycleView = (RecyclerView) view.findViewById(R.id.sugestao_amizade_recycleview);
        AdapterSugestaoAmizade adapterSugestaoAmizade = new AdapterSugestaoAmizade(getContext(), listModelsSugestaoAmizade);
        myrecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleView.setAdapter(adapterSugestaoAmizade);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listModelsSugestaoAmizade = new ArrayList<>();
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Daphene Dumond", "Stephanie", R.drawable.img1, "22/05/2016"));
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Angelina Jolie", "(21) 6548-1546", R.drawable.img2, "29//05/1954"));
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Carole Jean ", "(21) 6548-1546", R.drawable.img3, "26/06/2014"));
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Naica Louis", "(21) 6548-1546", R.drawable.img4, "21/05/1990"));
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Samuela Pardieu", "(21) 6548-1546", R.drawable.img5, "26/08/1992"));
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Josseline Success ", "(21) 6548-1546", R.drawable.img6,"21/05/1999"));
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Fabiola ", "(21) 6548-1546", R.drawable.img7, "06/12/1998"));
        listModelsSugestaoAmizade.add(new ModelsSugestaoAmizade("Samuel ", "(21) 6548-1546", R.drawable.img8, "11/25/1992"));

    }

}
