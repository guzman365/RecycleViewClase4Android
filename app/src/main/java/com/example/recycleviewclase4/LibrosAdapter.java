package com.example.recycleviewclase4;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//Heredar de la clase RecyclerView el adapter
public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Vincular nuestros objetos con los del layout lista_libros
        private TextView titulo, descripcion;
        ImageView fotoPortada;
        //Creamos el método ViewHolder
        //Este se encargará de contener y gestionar las vistas o
        // controles asociados a cada elemento individual de la lista
        public ViewHolder(View itemView){
            super(itemView);
            titulo = itemView.findViewById(R.id.txvTitulo);
            descripcion = itemView.findViewById(R.id.txvDescripcion);
            fotoPortada = itemView.findViewById(R.id.imvPortada);
        }//Fin ViewHolder
    }//Fin class ViewHolder

    //Proceder a crear una lista para almacenar los datos a mostrar en cada ITEM
    public List<LibrosModelo> listaLibros;

    //Generar el constructor de la lista creada para que pueda recibir los valores
    public LibrosAdapter(List<LibrosModelo> listaLibros) {
        this.listaLibros = listaLibros;
    }

    @NonNull
    @Override
    //Inflate: Método para hacer uso de un layout dentro de otro layout
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.lista_libros,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    //Método que realiza las modificaciones del contenido para cada item
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(listaLibros.get(position).getTitulo());
        holder.descripcion.setText(listaLibros.get(position).getDescripcion());
        holder.fotoPortada.setImageResource(listaLibros.get(position).getPortada());
    }//Fin onBindViewHolder

    @Override
    //Permite determinar al adaptador la cantidad de elementos que se procesaran
    public int getItemCount() {
        return listaLibros.size();
    }
}
