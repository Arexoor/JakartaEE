package com.elbers.Ue4.A4_Schichtarchitektur_entwickeln;

import java.util.List;

public class TestJPA {
    public static void main(String[] args) {
        DatabaseService service = DatabaseService.getInstance();
        TestJPA instance = new TestJPA();

        DataModel dataModel = new DataModel(34, 56, 90);

        service.addDataModel(dataModel.getEntity());
        instance.outputListToTerminal(service.readDataModelFromDatabase());
        service.close();
    }

    private void outputListToTerminal(List<DataModelEntity> entitys) {
        for (DataModelEntity dme:
             entitys) {
            DataModel dataModel = new DataModel(dme);
            StringBuilder stringBuilder = new StringBuilder("RGB values:");
            stringBuilder.append(" Red: ");
            stringBuilder.append(integerToString(dataModel.getRedValue()));
            stringBuilder.append(" Green: ");
            stringBuilder.append(integerToString(dataModel.getGreenValue()));
            stringBuilder.append(" Blue: ");
            stringBuilder.append(integerToString(dataModel.getBlueValue()));

            System.out.println(stringBuilder);
        }
    }

    private String integerToString (Integer input) {
        if(input != null) {
            return String.valueOf(input);
        }
        return "null";
    }
}
