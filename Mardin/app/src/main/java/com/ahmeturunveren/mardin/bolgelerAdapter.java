package com.ahmeturunveren.mardin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmeturunveren.mardin.databinding.RecyclerRowBinding;

import java.util.ArrayList;

/*
Uygulamamızda RecyclerView kullanmak istersek RecyclerView'in kendine ait bir sınıfı vardır
ve bizim bunu oluşturmamız gerekir. Ör: bolgelerAdapter
Oluşturduğumuz sınıfı RecyclerView.Adapter sınıfından kalıtmamız gerekir.
 */
public class bolgelerAdapter extends RecyclerView.Adapter<bolgelerAdapter.bolgelerHolder> {

    ArrayList<Bolgeler> bolgelerArrayList;

    public bolgelerAdapter(ArrayList<Bolgeler> bolgelerArrayList) {
        this.bolgelerArrayList = bolgelerArrayList;
    }

    @NonNull
    @Override
    public bolgelerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 1- Burada bağlama işlemi yapılacak
        /*
        Burada ise aşağıda oluşturmuş olduğumuz bolgelerHolder sınıfının kalıttığı ViewHolder sınıfından
        bir obje oluşturulduğunda çağrılacak metodtur. Burada binding'imizi bağlayacağız. Yani xml'imizi bağlama işlemini burada
        yapacağız.
         */
        RecyclerRowBinding recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new bolgelerHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull bolgelerHolder holder, @SuppressLint("RecyclerView") int position) {

        // 2- Burada değer verilecek
    //Layout içerisinde hangi verileri göstermek istiyorsak burada göstereceğiz.
        holder.binding.recyclerViewTextView.setText(bolgelerArrayList.get(position).isim);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("bolgeler", String.valueOf(bolgelerArrayList.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        // 3- xml'in kaç defa oluşturulması gerektiğini buraya giriyoruz
        return bolgelerArrayList.size();
    }

    public class bolgelerHolder extends RecyclerView.ViewHolder{
        /* Bu sınıf;
        bolgelerAdapter sınıfını oluşturduğumuzda RecyclerView.Adapter sınıfını kalıtmak istediğimizde
        bizden istediği RecyclerView.Adapter<VH> [VH:ViewHolder] parametresi için oluşturduğumuz yardımcı bir sınıftır.
        Parametreye direk bu sınıfın adını yani bolgelerHolder'ı yazmayız. Çünkü biz bu yardımcı sınıfı bolgelerAdapter sınıfının
        içerisinde oluşturduk. Onun için parametreye <bolgelerAdapter.bolgelerHolder> yazdık. Bu işlemi yaptıktan sonra
        üstte görünen 3 metodu @Override etmiş olduk. Bu metodlar kullanılmak zorunda.
         */
        // Ayrıca binding işlemini burada yapıyoruz.
        private RecyclerRowBinding binding;
        public bolgelerHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }




}
