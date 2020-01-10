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
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Adapter.AdapterConversas;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models.ModelsConversas;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoConversas extends Fragment {

    View view;
    private RecyclerView myrecycleView;
    private List<ModelsConversas> listModelsConversas;

    public static FragmentoConversas newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        FragmentoConversas fragmentoConversas = new FragmentoConversas();
        fragmentoConversas.setArguments(args);
        return fragmentoConversas;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_conversa, container, false);
        myrecycleView = (RecyclerView) view.findViewById(R.id.conversas_recycleview);
        AdapterConversas adapterConversas = new AdapterConversas(getContext(), listModelsConversas);
        myrecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleView.setAdapter(adapterConversas);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listModelsConversas = new ArrayList<>();
        listModelsConversas.add(new ModelsConversas("Daphene Dumond", "(21) 6548-1546", R.drawable.img1));
        listModelsConversas.add(new ModelsConversas("Angelina Jolie", "(21) 6548-1546", R.drawable.img2));
        listModelsConversas.add(new ModelsConversas("Carole Jean ", "(21) 6548-1546", R.drawable.img3));
        listModelsConversas.add(new ModelsConversas("Naica Louis", "(21) 6548-1546", R.drawable.img4));
        listModelsConversas.add(new ModelsConversas("Samuela Pardieu", "(21) 6548-1546", R.drawable.img5));
        listModelsConversas.add(new ModelsConversas("Josseline Success ", "(21) 6548-1546", R.drawable.img6));
        listModelsConversas.add(new ModelsConversas("Fabiola ", "(21) 6548-1546", R.drawable.img7));
        listModelsConversas.add(new ModelsConversas("Samuel ", "(21) 6548-1546", R.drawable.img8));

    }
}
