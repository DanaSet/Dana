package com.example.duitku.util;

public class Sisa {
    public static final int UANG = 0;
    public static final int TABUNGAN = 1;

    public static final int MAKAN = 0;
    public static final int KEBUTUHAN = 1;
    public static final int URGENT = 2;

    private int uang;
    private int pengeluaran;
    private int pemasukan;
    private int makan;
    private int kebutuhan;
    private int urgent;
    private int tabungan;
    private int total;

    public Sisa(int pengeluaran, int pemasukan, int uang, int makan, int urgent, int
                tabungan){
        this.pengeluaran = pengeluaran;
        this.pemasukan = pemasukan;
        this.uang = uang;
        this.makan = makan;
        this.urgent = urgent;
        this.tabungan = tabungan;
        this.total = calculate1() - calculate2();
    }

    public int getTotal(){
        return this.total;
    }

    private int calculate1() {
        switch (pemasukan) {
            case 0:
                return (uang + tabungan);
            default:
                return 0;
        }
    }

    private int calculate2(){
        switch (pengeluaran) {
            case 0:
                return (makan + kebutuhan + urgent);
            default:return 0;
        }
    }

}
