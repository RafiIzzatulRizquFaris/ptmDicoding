package com.example.myapplication;

import java.util.ArrayList;

public class PTMData {

    private static String[] namaPTM = {
      "Universitas Ahmad Dahlan",
      "Universitas Muhammadiyah Yogyakarta",
      "Universitas Aisyiyah Yogyakarta",
      "Universitas Muhammadiyah Surakarta",
      "Universitas Muhammadiyah Dr.Hamka",
      "Universitas Muhammadiyah Magelang",
      "Universitas Muhammadiyah Malang",
      "Universitas Muhamadiyah Makassar",
      "Universitas Muhammadiyah Palembang",
      "Universitas Muhammadiyah Tangerang"

    };

    private static String[] deskripsiPTM= {
            "Alamat di Yogyakarta",
            "Alamat di Yogyakarta",
            "Alamat di Yogyakarta",
            "Alamat di Surakarta / Solo",
            "Alamat di Jakarta",
            "Alamat di Magelang",
            "Alamat di Malang",
            "Alamat di Makassar",
            "Alamat di Palembang",
            "Alamat di Tangerang"

    };

    private static String[] detailPTM= {
            "Universitas Ahmad Dahlan (UAD) merupakan pengembangan dari Institut Keguruan dan Ilmu Pendidikan (IKIP) Muhammadiyah Yogyakarta, Institut Keguruan dan Ilmu Pendidikan Muhammadiyah Yogyakarta sebagai lembaga Pendidikan Tinggi merupakan pengembangan FKIP Muhammadiyah Cabang Jakarta di Yogyakarta yang didirikan pada tanggal 18 November 1960. FKIP Muhamadiyah merupakan kelanjutan kursus BI Muhammadiyah di Yogyakarta yang didirikan tahun 1957, pada waktu itu kursus BI memiliki Jurusan Ilmu Mendidik, Civic Hukum dan Ekonomi. Pada tanggal 19 Desember 1994 dengan Surat Keputusan (SK) Mentri Pendidikan dan Kebudayaan Republik Indonesia Nomor: 102 /D0/1994 diterapkan bahwa IKIP Muhamadiyah Yogyakarta beralih Fungsi menjadi Universitas Ahmad Dahlan. Kini UAD memiliki lebih dari 30 program studi sarjana dan pasca-sarjana tersebar di 6 kampus di provinsi DIY. (Sumber : wikipedia)",
            "UMY",
            "UNISA jaya",
            "UMS debes",
            "UHAMKA mantap jiwa",
            "UM Magelang gemilang",
            "UM Malang Cemerlang",
            "UM Makassar Duar",
            "UM Palembang bang",
            "UMT dong UMT"
    };

    private static int[] logoPTM = {
            R.drawable.uad,
            R.drawable.umy,
            R.drawable.unisa,
            R.drawable.ums,
            R.drawable.uhamka,
            R.drawable.ummgl,
            R.drawable.umm,
            R.drawable.ummks,
            R.drawable.ump,
            R.drawable.umt

    };

    static ArrayList<PTM> getListData() {
        ArrayList<PTM> list = new ArrayList<>();
        for (int pos = 0;pos < namaPTM.length; pos++) {
            PTM ptm = new PTM();
            ptm.setNama(namaPTM[pos]);
            ptm.setDeskripsi(deskripsiPTM[pos]);
            ptm.setDetail(detailPTM[pos]);
            ptm.setImg(logoPTM[pos]);



            list.add(ptm);
        }return list;
    }
}
