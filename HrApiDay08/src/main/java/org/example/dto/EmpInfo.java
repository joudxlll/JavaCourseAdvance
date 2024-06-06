package org.example.dto;

public class EmpInfo {
    private String depCode;
    private int idSeq;
    private int hire_date;

//    public EmpInfo(){}
//    public EmpInfo(String depCode, int idSeq, int hire_date) {
//        this.depCode = depCode;
//        this.idSeq = idSeq;
//        this.hire_date = hire_date;
//    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public int getIdSeq() {
        return idSeq;
    }

    public void setIdSeq(int idSeq) {
        this.idSeq = idSeq;
    }

    public int getHire_date() {
        return hire_date;
    }

    public void setHire_date(int hire_date) {
        this.hire_date = hire_date;
    }

    @Override
    public String toString() {
        return depCode + idSeq + hire_date;
    }
}
