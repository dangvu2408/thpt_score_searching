package com.example.tracuudiemthi.tracuu.Fragment;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tracuudiemthi.R;
import com.example.tracuudiemthi.tracuu.Model.ThongTinModel;

public class TraCuuFrag extends Fragment {
    private EditText inputSBD;
    private Button findBtn;
    private TextView noData, mainTitle;
    private TextView scoreToan, scoreVan, scoreNN, scoreValtli, scoreHoahoc, scoreSinhhoc, scoreLichsu, scoreDiali, scoreGDCD;

    private LinearLayout linear;
    private String SRC_DATABASE_NAME = "database2024.db";
    SQLiteDatabase database = null;
    public TraCuuFrag() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.tracuu_fragment, container, false);
        inputSBD = view.findViewById(R.id.sbdInput);
        findBtn = view.findViewById(R.id.findBtn01);
        noData = view.findViewById(R.id.noData);
        linear = view.findViewById(R.id.listScoreFull);
        mainTitle = view.findViewById(R.id.mainTitle);

        scoreToan = view.findViewById(R.id.toanScore);
        scoreVan = view.findViewById(R.id.vanScore);
        scoreNN = view.findViewById(R.id.ngoainguScore);
        scoreValtli = view.findViewById(R.id.vatliScore);
        scoreHoahoc = view.findViewById(R.id.hoaScore);
        scoreSinhhoc = view.findViewById(R.id.sinhScore);
        scoreLichsu = view.findViewById(R.id.lichsuScore);
        scoreDiali = view.findViewById(R.id.dialiScore);
        scoreGDCD = view.findViewById(R.id.gdcdScore);
        findBtn.setOnClickListener(v -> {
            String sobaodanh = inputSBD.getText().toString();
            ThongTinModel model = getScore(sobaodanh);
            if (model != null) {
                noData.setVisibility(View.GONE);
                linear.setVisibility(View.VISIBLE);
                mainTitle.setText("Điểm thi của thí sinh " + model.getSbd());
                scoreToan.setText(String.valueOf(model.getToan()));
                scoreVan.setText(String.valueOf(model.getNgu_van()));
                scoreNN.setText(model.getNgoai_ngu() + " - " + model.getMa_ngoai_ngu());
                scoreValtli.setText(String.valueOf(model.getVat_li()));
                scoreHoahoc.setText(String.valueOf(model.getHoa_hoc()));
                scoreSinhhoc.setText(String.valueOf(model.getSinh_hoc()));
                scoreLichsu.setText(String.valueOf(model.getLich_su()));
                scoreDiali.setText(String.valueOf(model.getDia_li()));
                scoreGDCD.setText(String.valueOf(model.getGdcd()));
            } else {
                noData.setVisibility(View.VISIBLE);
                linear.setVisibility(View.GONE);
            }
        });
        return view;
    }

    @SuppressLint("Range")
    public ThongTinModel getScore(String sbd) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        ThongTinModel model = null;
        Cursor cursor = database.query("diem_thi_thpt_2024", null, "sbd = ?", new String[]{sbd}, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                model = new ThongTinModel();
                model.setSbd(cursor.getString(cursor.getColumnIndex("sbd")));
                model.setToan(cursor.getFloat(cursor.getColumnIndex("toan")));
                model.setNgu_van(cursor.getFloat(cursor.getColumnIndex("ngu_van")));
                model.setNgoai_ngu(cursor.getFloat(cursor.getColumnIndex("ngoai_ngu")));
                model.setVat_li(cursor.getFloat(cursor.getColumnIndex("vat_li")));
                model.setHoa_hoc(cursor.getFloat(cursor.getColumnIndex("hoa_hoc")));
                model.setSinh_hoc(cursor.getFloat(cursor.getColumnIndex("sinh_hoc")));
                model.setLich_su(cursor.getFloat(cursor.getColumnIndex("lich_su")));
                model.setDia_li(cursor.getFloat(cursor.getColumnIndex("dia_li")));
                model.setGdcd(cursor.getFloat(cursor.getColumnIndex("gdcd")));
                model.setMa_ngoai_ngu(cursor.getString(cursor.getColumnIndex("ma_ngoai_ngu")));
            }
        }
        cursor.close();
        return model;
    }
}
