package Reflection_Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Field> fields = Arrays.stream(RichSoilLand.class.getDeclaredFields()).toList();
        Map<Commands, List<Field>> fieldsMap = new LinkedHashMap<>();

        filledCommandsInMap(fields, fieldsMap);
        filledMapWithFields(fields, fieldsMap);

        Consumer<Field> printer = field -> {
            StringBuilder builder = new StringBuilder();
            builder.append(Modifier.toString(field.getModifiers()))
                    .append(" ")
                    .append(field.getType().getSimpleName())
                    .append(" ")
                    .append(field.getName());
            System.out.println(builder);};

        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {
            switch (input) {
                case "public":
                    fieldsMap.get(Commands.PUBLIC).forEach(printer::accept);
                    break;
                case "private":
                    fieldsMap.get(Commands.PRIVATE).forEach(printer::accept);
                    break;
                case "protected":
                    fieldsMap.get(Commands.PROTECTED).forEach(printer::accept);
                    break;
                case "all":
                    fieldsMap.get(Commands.ALL).forEach(printer::accept);
                    break;
            }
            input = scanner.nextLine();
        }


    }
    private static void filledMapWithFields(List<Field> fields, Map<Commands, List<Field>> fieldsMap) {
        for (Field field : fields) {
            String accessModifier = Modifier.toString(field.getModifiers());
            switch (accessModifier) {
                case "public":
                    fieldsMap.get(Commands.PUBLIC).add(field);
                    break;
                case "private":
                    fieldsMap.get(Commands.PRIVATE).add(field);
                    break;
                case "protected":
                    fieldsMap.get(Commands.PROTECTED).add(field);
                    break;
            }
        }
    }

    private static void filledCommandsInMap(List<Field> fields, Map<Commands, List<Field>> fieldsMap) {
        fieldsMap.put(Commands.PRIVATE, new ArrayList<>());
        fieldsMap.put(Commands.PUBLIC, new ArrayList<>());
        fieldsMap.put(Commands.PROTECTED, new ArrayList<>());
        fieldsMap.put(Commands.ALL, fields);
    }
}

