package org.example.helper;

import jakarta.ws.rs.ext.ParamConverter;
import org.example.dto.EmpInfo;

public class EmpInfoParamConverter implements ParamConverter {
    @Override
    public Object fromString(String value) {
//        String deptCode =value.substring(0,2);
//        int idseq = Integer.parseInt(value.substring(2,5));
//        String hire_date = value.substring(6,9);

        EmpInfo emp = new EmpInfo();
        emp.setDepCode(value.substring(0,2));
        emp.setIdSeq(Integer.parseInt(value.substring(2,6)));
        emp.setHire_date(Integer.parseInt(value.substring(6)));

        return emp;
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }
}
