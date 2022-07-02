package pk.edu.iqra.oric.utility;

import pk.edu.iqra.oric.domain.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DTOGenerator {

    public static String generateDTO(String dtoName, String dtoPackage, String className, String classPackage) throws ClassNotFoundException {

        StringBuffer buffer = new StringBuffer();
        buffer.append("package " + dtoPackage + ";").append("\n");
        buffer.append("import " + classPackage + "." + className + ";").append("\n");
        buffer.append("import pk.edu.iqra.oric.utility.UtilityFunctions;").append("\n");
        buffer.append("import pk.edu.iqra.oric.utility.UserUtility;").append("\n");
        buffer.append("").append("\n");
        buffer.append("").append("\n");
        buffer.append("public class " + dtoName + " extends DtoInterface{").append("\n");
        buffer.append("").append("\n");
        buffer.append("").append("\n");
        List<String> copyList = new ArrayList<>();
        List<String> reverseList = new ArrayList<>();

        String dtoObject = getObjectNameFromClassName(dtoName);
        String classObject = getObjectNameFromClassName(className);

        Class aClass = Class.forName(classPackage + "." + className);
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {


            String camelCase = getCamelCasing(field.getName());
            String copyName = dtoObject + "." + field.getName() + " = classObject.get" + camelCase + "();";
            String reverseName = "classObject.set" + camelCase + "(" + dtoObject + "." + field.getName() + ");";
            if (field.getType().equals(Integer.class)) {
                buffer.append("private Integer " + field.getName() + ";").append("\n");
                copyList.add(copyName);
                reverseList.add(reverseName);
            } else if (field.getType().equals(String.class)) {
                buffer.append("private String " + field.getName() + ";").append("\n");
                copyList.add(copyName);
                reverseList.add(reverseName);
            } else if (field.getType().equals(Float.class)) {
                buffer.append("private Float " + field.getName() + ";").append("\n");
                copyList.add(copyName);
                reverseList.add(reverseName);
            } else if (field.getType().equals(Boolean.class)) {
                buffer.append("private Boolean " + field.getName() + ";").append("\n");
                copyList.add(copyName);
                reverseList.add(reverseName);
            } else if (field.getType().equals(Double.class)) {
                buffer.append("private Double " + field.getName() + ";").append("\n");
                copyList.add(copyName);
                reverseList.add(reverseName);
            } else if (field.getType().equals(LocalDate.class)) {
                buffer.append("private String " + field.getName() + ";").append("\n");
                copyList.add(dtoObject + "." + field.getName() + " = UtilityFunctions.localDateToString(classObject.get" + camelCase + "());");
                reverseList.add("classObject.set" + camelCase + "(UtilityFunctions.stringToLocalDate(" + dtoObject + "." + field.getName() + "));");
            } else if (field.getType().equals(Instant.class)) {
                buffer.append("private String " + field.getName() + ";").append("\n");
                copyList.add(dtoObject + "." + field.getName() + " = UtilityFunctions.localDateToString(classObject.get" + camelCase + "());");
                reverseList.add("classObject.set" + camelCase + "(UtilityFunctions.stringToInstantDate(" + dtoObject + "." + field.getName() + "));");
            } else {
                copyList.add("if(classObject.get" + camelCase + "() != null ) {");
                if (checkForField(field, "id")) {
                    buffer.append("private Integer " + field.getName() + "Id;").append("\n");
                    copyList.add(dtoObject + "." + field.getName() + "Id = classObject.get" + camelCase + "().getId();");
                }

                if (checkForField(field, "name")) {
                    buffer.append("private String " + field.getName() + "Name;").append("\n");
                    copyList.add(dtoObject + "." + field.getName() + "Name = classObject.get" + camelCase + "().getName();");
                } else if (checkForField(field, "firstname")) {
                    buffer.append("private String " + field.getName() + "Name;").append("\n");
                    copyList.add(dtoObject + "." + field.getName() + "Name = UserUtility.getNameFromUser(classObject.get" + camelCase + "());");
                }
                copyList.add("}");
            }

        }

        buffer.append(createDefaultConstructor(dtoName));
        buffer.append(createCopyConstructor(dtoName, className, classObject));
        buffer.append(createCopyMethod(copyList, dtoName, dtoObject, className));
        buffer.append(createReverseCopyMethod(reverseList, dtoName, dtoObject, className));

        buffer.append("    @Override\n" +
                "    public Integer getId() {\n" +
                "        return id;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void setId(Integer id) {\n" +
                "        this.id = id;\n" +
                "    }\n");


        buffer.append("").append("\n");
        buffer.append("").append("\n");
        buffer.append("}").append("\n");
        return buffer.toString();
    }

    public static String createDefaultConstructor(String dtoName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("").append("\n");
        buffer.append("public " + dtoName + " (){}").append("\n");
        buffer.append("").append("\n");
        return buffer.toString();
    }

    public static String createCopyConstructor(String dtoName, String className, String classObject) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("").append("\n");
        buffer.append("public " + dtoName + " (" + className + " " + classObject + "){").append("\n");
        buffer.append("copyFromObject(this," + classObject + ");").append("\n");
        buffer.append("}").append("\n");
        return buffer.toString();
    }

    public static String createCopyMethod(List<String> list, String dtoName, String dtoObject, String className) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("").append("\n");
        buffer.append("").append("\n");
        buffer.append("public static void copyFromObject(" + dtoName + " " + dtoObject + ", " + className + " classObject) {").append("\n");
        list.forEach(x -> {
            buffer.append(x).append("\n");
        });
        buffer.append("}").append("\n");
        buffer.append("").append("\n");
        return buffer.toString();
    }

    public static String createReverseCopyMethod(List<String> list, String dtoName, String dtoObject, String className) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("").append("\n");
        buffer.append("").append("\n");
        buffer.append("public static void copyFromDto(" + dtoName + " " + dtoObject + ", " + className + " classObject) {").append("\n");
        list.forEach(x -> {
            buffer.append(x).append("\n");
        });

        buffer.append("}").append("\n");
        buffer.append("").append("\n");

        return buffer.toString();
    }

    public static String getCamelCasing(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static String getObjectNameFromClassName(String str) {
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    public static Boolean checkForField(Field field, String fieldToCheck) {

        Class aClass = field.getType();
        Field[] fields = aClass.getDeclaredFields();

        for (Field f : fields) {
            if (f.getName().equalsIgnoreCase(fieldToCheck))
                return true;
        }
        return false;
    }

    public static String generateIfClauseOfUser(String className, String packageName) throws ClassNotFoundException {
        StringBuffer buffer = new StringBuffer();
        Class aClass = Class.forName(packageName + "." + className);
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getType().equals(User.class)) {

                buffer.append("if(dto.get" + getCamelCasing(field.getName()) + "Id() != null)").append("\n");
                buffer.append(" userList.add(dto.get" + getCamelCasing(field.getName()) + "Id());").append("\n");
            }
        }
        buffer.append("Map<Integer,User> userMap = userService.getAllUsersOfList(userList).stream().collect(Collectors.toMap(User::getId,x->x));").append("\n");

        for (Field field : fields) {
            if (field.getType().equals(User.class)) {

                buffer.append("if(dto.get" + getCamelCasing(field.getName()) + "Id() != null){").append("\n");
                buffer.append(" classObject.set" + getCamelCasing(field.getName()) + "(userMap.get(dto.get" + getCamelCasing(field.getName()) + "Id()));").append("\n");
                buffer.append(" dto.set"+ getCamelCasing(field.getName()) + "Name(UserUtility.getNameFromUser(classObject.get"+getCamelCasing(field.getName())+"()));").append("\n");
                buffer.append("}").append("\n");
                buffer.append("else").append("\n");
                buffer.append(" classObject.set" + getCamelCasing(field.getName()) + "(null);").append("\n");
            }
        }

        return buffer.toString();
    }

    public static void generateServiceFile(String dtoName, String dtoPackage,
                                           String className, String classPackage,
                                           String outputFolder) throws ClassNotFoundException, IOException {
        String serviceName = className + "Service.java";
        String serviceImplName = className + "ServiceImpl.java";
        String basePackage = classPackage.substring(0, classPackage.lastIndexOf('.') + 1) + "service;";

        File file = new File(outputFolder);
        file.mkdirs();

        try (BufferedWriter serviceWriter = new BufferedWriter(new FileWriter(new File(outputFolder + File.separator + serviceName)));
             BufferedWriter serviceImplWriter = new BufferedWriter(new FileWriter(new File(outputFolder + File.separator + serviceImplName)))) {

            StringBuffer serviceBuffer = new StringBuffer();
            StringBuffer implBuffer = new StringBuffer();
            serviceBuffer.append("package ").append(basePackage).append("\n\n\n");
            serviceBuffer.append(
                    "import pk.edu.iqra.oric.domain." + className + ";\n" +
                            "import pk.edu.iqra.oric.dto." + dtoName + ";\n\n");
            serviceBuffer.append("public interface " + className + "Service extends GenericResourceService<" + className + ", " + dtoName + "> {\n" +
                    "}\n");


            implBuffer.append("package pk.edu.iqra.oric.service.impl;\n" +
                    "\n" +
                    "import com.fasterxml.jackson.databind.ObjectMapper;\n" +
                    "import org.springframework.beans.factory.annotation.Autowired;\n" +
                    "import org.springframework.stereotype.Service;\n" +
                    "import pk.edu.iqra.oric.domain.OricSession;\n" +
                    "import pk.edu.iqra.oric.domain." + className + ";\n" +
                    "import pk.edu.iqra.oric.domain.User;\n" +
                    "import pk.edu.iqra.oric.dto.DtoInterface;\n" +
                    "import pk.edu.iqra.oric.dto." + className + "DTO;\n" +
                    "import pk.edu.iqra.oric.repository.OricSessionRepository;\n" +
                    "import pk.edu.iqra.oric.repository." + className + "Repository;\n" +
                    "import pk.edu.iqra.oric.service.FacultyService;\n" +
                    "import pk.edu.iqra.oric.service." + className + "Service;\n" +
                    "import pk.edu.iqra.oric.service.UserService;\n" +
                    "import pk.edu.iqra.oric.utility.UserUtility;\n" +
                    "\n" +
                    "import java.time.Instant;\n" +
                    "import java.util.ArrayList;\n" +
                    "import java.util.List;\n" +
                    "import java.util.Map;\n" +
                    "import java.util.stream.Collectors;\n" +
                    "\n" +
                    "@Service\n" +
                    "public class " + className + "ServiceImpl implements " + className + "Service {\n" +
                    "\n" +
                    "\n" +
                    "    private " + className + "Repository repository;\n" +
                    "    private UserService userService;\n" +
                    "\n" +
                    "    private FacultyService facultyService;\n" +
                    "\n" +
                    "    private OricSessionRepository oricSessionRepository;\n" +
                    "\n" +
                    "    @Autowired\n" +
                    "    public " + className + "ServiceImpl(" + className + "Repository repository,\n" +
                    "                                   UserService userService,\n" +
                    "                                   OricSessionRepository oricSessionRepository,\n" +
                    "                                   FacultyService facultyService){\n" +
                    "        this.repository = repository;\n" +
                    "        this.userService = userService;\n" +
                    "        this.oricSessionRepository = oricSessionRepository;\n" +
                    "        this.facultyService = facultyService;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public List<" + className + "> getResource(Integer oricSessionId) {\n" +
                    "        return repository.findOfOricSession(oricSessionId);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public List<" + className + "DTO> getResourceDTO(Integer oricSessionId) {\n" +
                    "        return getResource(oricSessionId).stream().map(x->new " + className + "DTO(x)).collect(Collectors.toList());\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public DtoInterface saveResource(Integer oricSessionId, Integer userId, String dtoString) throws Exception {\n" +
                    "        " + className + " classObject = null;\n" +
                    "        ObjectMapper mapper = new ObjectMapper();\n" +
                    "        " + className + "DTO dto = mapper.readValue(dtoString," + className + "DTO.class);\n" +
                    "\n" +
                    "        User creator = userService.getUserByUserId(userId);\n" +
                    "        OricSession oricSession = oricSessionRepository.findById(oricSessionId).get();\n" +
                    "\n" +
                    "        if (dto.getId() == null || dto.getId().equals(0)) {\n" +
                    "            classObject = new " + className + "();\n" +
                    "            classObject.setCreatedOn(Instant.now());\n" +
                    "            classObject.setCreatedBy(creator);\n" +
                    "            classObject.setOricSession(oricSession);\n" +
                    "\n" +
                    "        } else {\n" +
                    "            classObject = repository.findById(dto.getId()).get();\n" +
                    "            if (classObject == null)\n" +
                    "                throw new Exception(\"Illegal Request\");\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "        " + className + "DTO.copyFromDto(dto, classObject);\n" +
                    "        classObject.setModifiedBy(creator);\n" +
                    "        classObject.setModifiedOn(Instant.now());\n" +
                    "\n" +
                    "        List<Integer> userList = new ArrayList<>();\n\n" +

                    "");
            implBuffer.append(generateIfClauseOfUser(className, classPackage));
            implBuffer.append("                dto.setId(repository.save(classObject).getId());\n" +
                    "\n" +
                    "        return dto;" +
                    "}\n\n\n" +
                    "" +
                    "}");
            serviceWriter.append(serviceBuffer.toString());
            serviceImplWriter.append(implBuffer.toString());
        }
    }

    public static void generateRepositoryFile(String dtoName, String dtoPackage,
                                              String className, String classPackage,
                                              String outputFolder) throws IOException {
        String serviceName = className + "Repository.java";

        String basePackage = classPackage.substring(0, classPackage.lastIndexOf('.') + 1) + "repository;";

        File file = new File(outputFolder);
        file.mkdirs();

        try (BufferedWriter serviceWriter = new BufferedWriter(new FileWriter(new File(outputFolder + File.separator + serviceName)));) {

            StringBuffer buffer = new StringBuffer();

            buffer.append("package pk.edu.iqra.oric.repository;\n\n" +
                    "" +
                    "import pk.edu.iqra.oric.domain." + className + ";\n" +
                    "\n" +
                    "\n" +
                    "import java.util.List;\n" +
                    "import org.springframework.data.jpa.repository.Query;\n" +
                    "import org.springframework.data.repository.CrudRepository;\n" +
                    "import org.springframework.stereotype.Repository;\n" +
                    "\n" +
                    "@Repository\n" +
                    "public interface " + className + "Repository extends CrudRepository<" + className + ",Integer> {\n" +
                    "\n" +
                    "    @Query(\"from " + className + " rl where rl.oricSession.id = ?1\")\n" +
                    "    List<" + className + "> findOfOricSession(Integer oricSessionId);\n" +
                    "}\n");

            serviceWriter.append(buffer.toString());
        }
    }

    public static void generateDTOFile(String dtoName, String dtoPackage,
                                              String className, String classPackage,
                                              String outputFolder) throws ClassNotFoundException,IOException {
        String serviceName = className + "DTO.java";

        String basePackage = classPackage.substring(0, classPackage.lastIndexOf('.') + 1) + "dto;";

        File file = new File(outputFolder);
        file.mkdirs();

        try (BufferedWriter serviceWriter = new BufferedWriter(new FileWriter(new File(outputFolder + File.separator + serviceName)));) {

            StringBuffer buffer = new StringBuffer();

            serviceWriter.append(generateDTO(dtoName, dtoPackage, className, classPackage));
        }
    }
    public static void gernrateHelperFiles(String dtoName, String dtoPackage,
                                           String className, String classPackage,
                                           String outputFolder) throws ClassNotFoundException, IOException {
        generateServiceFile(dtoName, dtoPackage, className, classPackage, outputFolder);
        generateRepositoryFile(dtoName, dtoPackage, className, classPackage, outputFolder);
        generateDTOFile(dtoName, dtoPackage, className, classPackage, outputFolder);
    }


    public static void main(String[] ar) {
        try {
            String dtoName = "AnnouncementDTO";
            String dtoPackage = "pk.edu.iqra.oric.dto";
            String className = "Announcement";
            String classPackage = "pk.edu.iqra.oric.domain";
            String outputFolder = "d:\\outputOric\\";

            //  generateDTO(dtoName,dtoPackage,className,classPackage);

            gernrateHelperFiles(dtoName, dtoPackage, className, classPackage, outputFolder);
//            generateIfClauseOfUser(className,classPackage);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
