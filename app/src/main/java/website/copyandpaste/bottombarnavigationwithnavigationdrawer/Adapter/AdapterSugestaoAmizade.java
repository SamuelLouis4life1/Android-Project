package website.copyandpaste.bottombarnavigationwithnavigationdrawer.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import website.copyandpaste.bottombarnavigationwithnavigationdrawer.R;
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models.ModelsSugestaoAmizade;

public class AdapterSugestaoAmizade extends RecyclerView.Adapter<AdapterSugestaoAmizade.MyViewHolder> {

    Context mcontext;
    List<ModelsSugestaoAmizade> mData;
    Dialog mDialog;

    public AdapterSugestaoAmizade(Context mcontext, List<ModelsSugestaoAmizade> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_sugestao_amizade;
        private TextView nome;
        private TextView sobreNome;
        private ImageView imagem;
        private TextView dataAniversario;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_sugestao_amizade = (LinearLayout) itemView.findViewById(R.id.sugestao_amizade_item_id);
            nome = (TextView) itemView.findViewById(R.id.name_contact_sugestao_amizade);
            sobreNome = (TextView) itemView.findViewById(R.id.sobrenome_contact_sugestao_amizade);
            imagem = (ImageView) itemView.findViewById(R.id.img_contact_sugestao_amizade);
            dataAniversario = (TextView) itemView.findViewById(R.id.data_aniversaio);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType ) {

        View view;
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_sugestao_amizade,parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        // Dialog ini

        mDialog = new Dialog(mcontext);
        mDialog.setContentView(R.layout.dialog_sugestao_amizade);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_sugestao_amizade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_nameTextView = (TextView) mDialog.findViewById(R.id.dialod_name_id);
                TextView dialog_sobrenomeTextView = (TextView) mDialog.findViewById(R.id.dialog_sobrenome_id);
                ImageView dialog_image = (ImageView) mDialog.findViewById(R.id.dialog_image);
//                Date dialog_dataAniversario = (Date) mDialog.findViewById(R.id.data_aniversario_sugestao_amizade);
                dialog_nameTextView.setText(mData.get(viewHolder.getAdapterPosition()).getNome());
                dialog_image.setImageResource(mData.get(viewHolder.getAdapterPosition()).getFoto());
                dialog_sobrenomeTextView.setText(mData.get(viewHolder.getAdapterPosition()).getSobrenome());

//                Toast.makeText(mcontext,"Text click" + String.valueOf(viewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();
                mDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSugestaoAmizade.MyViewHolder myViewHolder, int position) {

        myViewHolder.nome.setText(mData.get(position).getNome());
        myViewHolder.sobreNome.setText(mData.get(position).getSobrenome());
        myViewHolder.imagem.setImageResource(mData.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
