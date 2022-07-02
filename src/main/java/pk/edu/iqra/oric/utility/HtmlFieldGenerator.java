package pk.edu.iqra.oric.utility;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.util.Scanner;

public class HtmlFieldGenerator {
    private static ApplyString textFieldApplu = field -> {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<input  type='text' id='"+field.getName()+"' class='form-control ' style='width: 100%;'>\n")
                .append("\n");
        return buffer.toString();
    };

    private static ApplyString selectFieldApplu = field -> {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<select id='"+field.getName()+"' class='form-control select2' style='width: 100%;'>\n")
                .append("</select>\n");
        return buffer.toString();
    };

    private static ApplyString textareaFieldApplu = field -> {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<textarea id='"+field.getName()+"' class='form-control ' style='width: 100%;'>\n")
                .append("</textarea>\n");
        return buffer.toString();
    };

    private static ApplyString numberFieldApplu = field -> {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<input  type='number' id='"+field.getName()+"' class='form-control ' style='width: 100%;'>\n")
                .append("\n");
        return buffer.toString();
    };


    private static ApplyString dateFieldApplu = field -> {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<input  type='text' id='"+field.getName()+"' class='form-control dateInput' style='width: 100%;'>\n")
                .append("\n");
        return buffer.toString();
    };



    public static void generateHTMLFields(String className, String packageName) throws ClassNotFoundException {
        Class aClass = Class.forName(packageName+"."+className);
        Field[] fields = aClass.getDeclaredFields();

        Scanner sc = new Scanner(System.in);

        StringBuffer buffer = new StringBuffer();
        StringBuffer emptyDtoBuffer = new StringBuffer();
        StringBuffer fieldToDtoBuffer = new StringBuffer();
        StringBuffer dtoToFieldBuffer = new StringBuffer();

        for(Field field : fields){
            ApplyString applyString = null;
            System.out.println("For field "+field.getName() + " -- "+field.getType().getName());
            System.out.println("1. ignore");
            System.out.println("2. select");
            System.out.println("3. text");
            System.out.println("4. textArea");
            System.out.println("5. number");
            System.out.println("6. date");
            int i = sc.nextInt();

            switch (i){
                case 2:
                    applyString = selectFieldApplu;
                    break;
                case 3:
                    applyString = textFieldApplu;
                    break;
                case 4:
                    applyString = textareaFieldApplu;
                    break;
                case 5:
                    applyString = numberFieldApplu;
                    break;
                case 6:
                    applyString = dateFieldApplu;
                break;
                case 1:
                default:break;
            }

            if( i != 1 && applyString != null) {
                buffer.append(returnBefore()).append("\n")
                        .append(labelGenerator(field)).append("\n")
                        .append(applyString.apply(field)).append("\n")
                        .append(returnAfter()).append("\n");
                emptyDtoBuffer.append("obj."+field.getName() +" = '';").append("\n");
                fieldToDtoBuffer.append("obj."+field.getName() +" = $('#"+field.getName()+"').val();").append("\n");
                dtoToFieldBuffer.append("$('#"+field.getName()+"').val(obj."+field.getName()+");").append("\n");

            }
        }

        System.out.println("Final Output");
        System.out.println(buffer);

        System.out.println("Functions");
        System.out.println(returnEmptyDTOFunctionString(emptyDtoBuffer.toString()));

        System.out.println();
        System.out.println(returnFormToDTO(fieldToDtoBuffer.toString()));


        System.out.println();
        System.out.println(returnDTOToForm(dtoToFieldBuffer.toString()));

    }

    public static String returnEmptyDTOFunctionString(String body){
        StringBuffer buffer = new StringBuffer();
        buffer.append("function getEmptyDTO(){\n");
        buffer.append("let obj = new Object();\n");
        buffer.append(body).append("\n");
        buffer.append("return obj;\n}\n");
        return  buffer.toString();
    }

    public static String returnFormToDTO(String body){
        StringBuffer buffer = new StringBuffer();
        buffer.append("function makeDtoFromForm(dto){\n");
        buffer.append("let obj = new Object();\n");

        buffer.append("        if(dto != null && typeof dto !== 'undefined')\n" +
                "            obj = dto;\n" +
                "        obj.id = $(\"#researchId\").val();");

        buffer.append("\n\n");
        buffer.append(body).append("\n");
        buffer.append("return obj;\n}\n");
        return  buffer.toString();
    }

    public static String returnDTOToForm(String body){
        StringBuffer buffer = new StringBuffer();
        buffer.append("function populateFields(userDTO){\n");
        buffer.append("let obj = new Object();\n");
        buffer.append("        if(typeof userDTO === 'undefined' || userDTO == null){\n" +
                "          obj =  getEmptyDTO();\n" +
                "        }\n" +
                "        else{\n" +
                "            obj = userDTO;\n" +
                "        }").append("\n");
        buffer.append(body).append("\n");

        buffer.append("    $(\"#fileListBody\").empty();\n" +
                "        $(\"#fileBtn\").val(null);\n\n");
        buffer.append("\n}\n");
        return  buffer.toString();
    }

    public static String returnBefore(){
        return " <div class=\"col-md-3\">\n  <div class=\"form-group\">\n";
    }

    public static String labelGenerator(Field field){
        return " <label>"+field.getName()+"</label>\n";
    }

    public static String returnAfter(){
        return " </div>\n  </div>\n";
    }
    public static void main(String []ar){
        try {

            generateHTMLFields("AnnouncementDTO","pk.edu.iqra.oric.dto");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

interface ApplyString{
    public String apply(Field field);
}