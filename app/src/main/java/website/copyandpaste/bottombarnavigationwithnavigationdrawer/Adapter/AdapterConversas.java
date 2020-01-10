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
import website.copyandpaste.bottombarnavigationwithnavigationdrawer.Models.ModelsConversas;

public class AdapterConversas extends RecyclerView.Adapter<AdapterConversas.MyViewHolder> {
    Context mcontext;
    List<ModelsConversas> mData;
    Dialog mDialog;

    public AdapterConversas(Context mcontext, List<ModelsConversas> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_contact;
        private TextView nome;
        private TextView telefone;
        private ImageView imagem;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_contact = (LinearLayout) itemView.findViewById(R.id.contact_item_id);
            nome = (TextView) itemView.findViewById(R.id.name_contact);
            telefone = (TextView) itemView.findViewById(R.id.phone_contact);
            imagem = (ImageView) itemView.findViewById(R.id.img_contact);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType ) {

        View view;
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_conversas,parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        // Dialog ini

        mDialog = new Dialog(mcontext);
        mDialog.setContentView(R.layout.dialog_conversas);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_nameTextView = (TextView) mDialog.findViewById(R.id.dialod_name_id);
                TextView dialog_phoneTextView = (TextView) mDialog.findViewById(R.id.dialog_phone_id);
                ImageView dialog_image = (ImageView) mDialog.findViewById(R.id.dialog_image);
                dialog_nameTextView.setText(mData.get(viewHolder.getAdapterPosition()).getNome());
                dialog_phoneTextView.setText(mData.get(viewHolder.getAdapterPosition()).getTelefone());
                dialog_image.setImageResource(mData.get(viewHolder.getAdapterPosition()).getFoto());

//                Toast.makeText(mcontext,"Text click" + String.valueOf(viewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();
                mDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.nome.setText(mData.get(position).getNome());
        myViewHolder.telefone.setText(mData.get(position).getTelefone());
        myViewHolder.imagem.setImageResource(mData.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
