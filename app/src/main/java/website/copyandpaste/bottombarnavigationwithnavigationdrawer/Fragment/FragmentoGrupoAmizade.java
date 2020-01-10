package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import website.copyandpaste.bottombarnavigationwithnavigationdrawer.R;

public class FragmentoGrupoAmizade extends Fragment {

    public static FragmentoGrupoAmizade newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        FragmentoGrupoAmizade fragmentoGrupoAmizade = new FragmentoGrupoAmizade();
        fragmentoGrupoAmizade.setArguments(args);
        return fragmentoGrupoAmizade;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

}
