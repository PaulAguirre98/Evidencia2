package adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


import model.curp;

public class CurpAdapter extends RecyclerView.Adapter<CurpAdapter.CartaViewHolder> {
private Context maincontext;
private List<curp> items;

    public CurpAdapter(List<curp> items, Context contexto) {
        this.maincontext = contexto;
        this.items = items;
    }


    static class CartaViewHolder extends RecyclerView.ViewHolder {
        protected TextView AP;
        protected TextView AM;
        protected TextView name;
        protected TextView SX;
        protected TextView date;
        protected TextView estado;

        public CartaViewHolder(View v) {
            super(v);
            this.AP = (TextView) v.findViewById(R.id.ap);
            this.AM = (TextView) v.findViewById(R.id.am);
            this.name = (TextView) v.findViewById(R.id.nombre);
            this.SX = (TextView) v.findViewById(R.id.sx);
            this.date = (TextView) v.findViewById(R.id.fec);
            this.estado = (TextView) v.findViewById(R.id.state);
        }
    }
    public CartaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.Layout.card_curp, viewGroup, false);

        return new CartaViewHolder(v);
    }
    public void onBindViewHolder(CartaViewHolder viewHolder, int position){
        curp item = items.get(position);
        viewHolder.itemView.setTag(items);
        viewHolder.AP.setText("N°:"+ item.getAp());
        viewHolder.AM.setText("N°:"+ item.getAm());
        viewHolder.name.setText("N°:"+ item.getName());
        viewHolder.SX.setText("N°:"+ item.getSx());
        viewHolder.date.setText("N°:"+ item.getDate());
        viewHolder.estado.setText("N°:"+ item.getEstado());

    }
    public int getItemCount(){
        return 0;
    }
}
