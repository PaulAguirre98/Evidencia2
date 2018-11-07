package mipp.com.avance2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

import adaptadores.CurpAdapter;
import db.DataBaseManagerCurp;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnInsertar, btnConsultar;
    private DataBaseManagerCurp managerCurp;
    private RecyclerView recycler;
    private CurpAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<model.curp> listaitemacurp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adViews();
        managerCurp= new DataBaseManagerCurp(this);
        listaitemacurp = managerCurp.getcurpList();
        inicializarRecicler();

    }



    private void adViews() {
        btnInsertar = (Button) findViewById(R.id.ingresar);
        btnInsertar.setOnClickListener(this);
        btnConsultar = (Button) findViewById(R.id.consultar);
        btnConsultar.setOnClickListener(this);
    }
    private void inicializarRecicler() {
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new CurpAdapter(listaitemacurp, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());

    }
    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.ingresar:
        for (int i=0; i<10; i++){
            managerCurp.insertar("Anzures","Estrada", "Abner", "Masculino", "23/02/99","NuevoLeon");

        }
    break;
    case R.id.consultar:
    break;
}
    }
}
