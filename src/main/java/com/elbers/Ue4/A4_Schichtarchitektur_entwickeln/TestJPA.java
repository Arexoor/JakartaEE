package com.elbers.Ue4.A4_Schichtarchitektur_entwickeln;

import java.util.List;

public class TestJPA {
    public static void main(String[] args) {
        DatabaseService service = DatabaseService.getInstance();
        TestJPA instance = new TestJPA();

        DataController dataController = new DataController(34, 56, 90);

        service.addDataModel(dataController.getEntity());
        instance.outputListToTerminal(service.readDataModelFromDatabase());
        service.close();
    }

    private void outputListToTerminal(List<DataModelEntity> entitys) {
        for (DataModelEntity dme:
             entitys) {
            DataController dataController = new DataController(dme);
            StringBuilder stringBuilder = new StringBuilder("RGB values:");
            stringBuilder.append(" Red: ");
            stringBuilder.append(integerToString(dataController.getRedValue()));
            stringBuilder.append(" Green: ");
            stringBuilder.append(integerToString(dataController.getGreenValue()));
            stringBuilder.append(" Blue: ");
            stringBuilder.append(integerToString(dataController.getBlueValue()));

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
