package com.ahmeturunveren.mardin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.ahmeturunveren.mardin.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Bolgeler> bolgeler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        bolgeler=new ArrayList<>();
        Bolgeler dara_mezopotamya=new Bolgeler("Dara Mezopotamya Harabeleri","Açıklama...",R.drawable.dara_mezopotamya);
        Bolgeler kasimiye_medresesi=new Bolgeler("Kasımiye Medresesi","Açıklama...",R.drawable.kasimiye_medresesi);
        Bolgeler kirklar_kilisesi=new Bolgeler("Kırklar Kilisesi","Açıklama...",R.drawable.kirklar_kilisesi);
        Bolgeler latifiye_camisi=new Bolgeler("Latifiye Camisi","Açıklama...",R.drawable.latifiye_camisi);
        Bolgeler mardin_kalesi=new Bolgeler("Mardin Kalesi","Açıklama...",R.drawable.mardin_kalesi);
        Bolgeler mardin_protestan=new Bolgeler("Mardin Protestan Kilisesi","Açıklama...",R.drawable.mardin_protestan_kilisesi);
        Bolgeler mardin_ulucamisi=new Bolgeler("Mardin Ulucamisi","Açıklama...",R.drawable.mardin_ulucamisi);
        Bolgeler saint_hirmiz=new Bolgeler("Saint Hirmiz","Açıklama...",R.drawable.saint_hirmiz);
        Bolgeler sehidiyee_camisi=new Bolgeler("Şehidiye Camisi","Açıklama...",R.drawable.sehidiye_camisi);
        Bolgeler zinciriye_medresesi=new Bolgeler("Zinciriye Medresesi","Açıklama...",R.drawable.zinciriye_medresesi);

        bolgeler.add(dara_mezopotamya);
        bolgeler.add(kasimiye_medresesi);
        bolgeler.add(kirklar_kilisesi);
        bolgeler.add(latifiye_camisi);
        bolgeler.add(mardin_kalesi);
        bolgeler.add(mardin_protestan);
        bolgeler.add(mardin_ulucamisi);
        bolgeler.add(saint_hirmiz);
        bolgeler.add(sehidiyee_camisi);
        bolgeler.add(zinciriye_medresesi);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bolgelerAdapter bolgelerAdapter=new bolgelerAdapter(bolgeler);
        binding.recyclerView.setAdapter(bolgelerAdapter);

    }
}