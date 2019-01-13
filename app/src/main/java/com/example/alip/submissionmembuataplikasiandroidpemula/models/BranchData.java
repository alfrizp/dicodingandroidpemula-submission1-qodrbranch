package com.example.alip.submissionmembuataplikasiandroidpemula.models;

import android.content.Context;
import android.content.res.Resources;

import com.example.alip.submissionmembuataplikasiandroidpemula.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BranchData {
    public Map[] data = new Map[6];

    public BranchData() {
        Map hq = new HashMap();
        hq.put("name", "QODR HQ (Pusat)");
        hq.put("address", "Sukorame RT 17 Mangunan, Dlingo, Bantul, 55783. Yogyakarta.");
        hq.put("phone", "08975835238");
        hq.put("email", "info@qodr.or.id");
        hq.put("photo", R.drawable.hq);

        Map pkl = new HashMap();
        pkl.put("name", "QODR Pekalongan");
        pkl.put("address", "Jl. Raya Karanganyar No.17, Kulu, Karanganyar, 51182. Pekalongan.");
        pkl.put("phone", "087859517906");
        pkl.put("email", "kajen@qodr.or.id");
        pkl.put("photo", R.drawable.pekalongan);

        Map smg = new HashMap();
        smg.put("name", "QODR Semarang");
        smg.put("address", "Jl. Raya Manyaran Gunung Pati KM 10 Gunungpati, 50223. Semarang.");
        smg.put("phone", "08157755959");
        smg.put("email", "ngrembel@qodr.or.id");
        smg.put("photo", R.drawable.semarang);

        Map mgt = new HashMap();
        mgt.put("name", "QODR Magetan");
        mgt.put("address", "Jl. Gorang gareng Madium Genengan RT 006/002, Kawedanan, Magetan.");
        mgt.put("phone", "089629796473");
        mgt.put("email", "magetan@qodr.or.id");
        mgt.put("photo", R.drawable.magetan);

        Map mgl = new HashMap();
        mgl.put("name", "QODR Magelang");
        mgl.put("address", "MI Terpadu Al Muttaqin, Trono, Jati Sawangan, 56481. Magelang.");
        mgl.put("phone", "089658773371");
        mgl.put("email", "magelang@qodr.or.id");
        mgl.put("photo", R.drawable.magelang);

        Map andalus = new HashMap();
        andalus.put("name", "QODR Andalus (Coming Soon)");
        andalus.put("address", "-");
        andalus.put("phone", "-");
        andalus.put("email", "-");
        andalus.put("photo", R.drawable.andalus);


        data[0] = hq;
        data[1] = pkl;
        data[2] = smg;
        data[3] = mgt;
        data[4] = mgl;
        data[5] = andalus;
    }

    public ArrayList<Branch> getListData() {
        Branch branch = null;
        ArrayList<Branch> list = new ArrayList<>();
        for (Map aData:data) {
            branch = new Branch();
            branch.setName((String) aData.get("name"));
            branch.setAddress((String) aData.get("address"));
            branch.setPhone((String) aData.get("phone"));
            branch.setEmail((String) aData.get("email"));
            branch.setPhoto((int) aData.get("photo"));

            list.add(branch);
        }

        return list;
    }
}
