import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Main {
    private static final String CONNECTION_STR = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;
    private static boolean exit = false;
    private static boolean successLogin = false;
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void main(String[] args) throws SQLException, IOException {

        executeConnection();

        while (!exit) {
            System.out.printf(ANSI_BLUE +"---------------------------%nEnter exercise number%n[1][2][3][4][5][7][8][9]%nOr enter 0 to exit%n---------------------------%n" + ANSI_BLUE);
            int exerciseNum = Integer.parseInt(reader.readLine());

            switch (exerciseNum) {
                case 1 -> runExercise1();
                case 2 -> runExercise2();
                case 3 -> runExercise3();
                case 4 -> runExercise4();
                case 5 -> runExercise5();
                case 7 -> runExercise7();
                case 8 -> runExercise8();
                case 9 -> runExercise9();
                case 0 -> terminateProgram();
            }
        }
    }


    private static void runExercise1() throws SQLException {
        System.out.println(ANSI_PURPLE + "The initial setup is ready!" + ANSI_PURPLE);
    }
    private static void runExercise2() throws IOException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT v.name, count(distinct mv.minion_id)  count_minions " +
                        "from villains  v " +
                        "JOIN minions_villains as mv on v.id = mv.villain_id " +
                        "group by v.name " +
                        "having count_minions > ? " +
                        "ORDER BY count_minions desc;");

        preparedStatement.setInt(1,15);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf(ANSI_PURPLE + "%s %d %n" + ANSI_PURPLE, resultSet.getString(1), resultSet.getInt(2));
        }
    }
    private static void runExercise3() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());

        PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT m.name, m.age from minions as m " +
                        "join minions_villains mv on m.id = mv.minion_id " +
                        "where  mv.villain_id = ?;");
        preparedStatement.setInt(1,villainId);
        String villainName = getVillainNameById(villainId);

        if (villainName != null ){
            System.out.println(ANSI_PURPLE +"Villain: " + villainName + ANSI_PURPLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.printf(ANSI_PURPLE +"%d. %s %d%n" + ANSI_PURPLE,resultSet.getRow(),resultSet.getString(1),resultSet.getInt(2));
            }
        }else {
            System.out.printf(ANSI_RED + "No villain with ID %d exists in the database.%n" + ANSI_RED,villainId);
        }
    }
    private static void runExercise4() {
        System.out.println("In progress");
    }
    private static void runExercise5() throws IOException, SQLException {
        System.out.println("Enter country name:");
        String country = reader.readLine();

        PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE towns SET name = upper(name) where country = ?;");
        preparedStatement.setString(1,country);
        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows == 0){
            System.out.println(ANSI_RED + "No town names were affected." + ANSI_RED);
        } else {
            PreparedStatement preparedStatementTowns = connection.prepareStatement
                    ("Select name From towns where country = ?");
            preparedStatementTowns.setString(1,country);
            ResultSet resultSetTowns = preparedStatementTowns.executeQuery();
            List<String> towns = new ArrayList<>();
            while (resultSetTowns.next()){
                towns.add(resultSetTowns.getString(1));
            }
            System.out.printf(ANSI_PURPLE + "%d town names were affected.%n" + ANSI_PURPLE,affectedRows);
            System.out.println(ANSI_PURPLE + "[" + String.join(", ",towns) + "]" + ANSI_PURPLE);
        }
    }
    private static void runExercise7() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name from minions;");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayDeque<String> minionsNames = new ArrayDeque<>();

        while (resultSet.next()){
            minionsNames.offer(resultSet.getString(1));
        }
        while (!minionsNames.isEmpty()){
            System.out.println(ANSI_PURPLE + minionsNames.removeFirst() + ANSI_PURPLE);
            System.out.println(ANSI_PURPLE + minionsNames.removeLast() + ANSI_PURPLE);
        }
    }
    private static void runExercise8() throws IOException, SQLException {
        System.out.println("Enter minion id's with space:");

        int[] minionIds = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (var id:minionIds){
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE minions set age = age+1, name = lower(name) where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,age from minions;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.printf( ANSI_PURPLE +"%s %d%n" + ANSI_PURPLE,resultSet.getString("name"),resultSet.getInt("age"));
        }

    }
    private static void runExercise9() throws IOException, SQLException {
        System.out.println("Enter minion's id:");
        int minionId = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1,minionId);
        callableStatement.executeUpdate();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, age from minions where id = ?");
        preparedStatement.setInt(1,minionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.printf("%s %d%n",resultSet.getString(1),resultSet.getInt(2));
        }
    }
    private static String getVillainNameById(int villainId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name from villains where id = ?");
        preparedStatement.setInt(1,villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()){
            return null;
        }else {
            return resultSet.getString(1);
        }
    }
    private static void executeConnection() throws IOException, SQLException {
        while (!successLogin) {
            System.out.println(ANSI_BLUE + "Enter user:" + ANSI_BLUE);
            String user = reader.readLine();
            System.out.println(ANSI_BLUE + "Enter password" + ANSI_BLUE);
            String password = reader.readLine();

            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            try {
                connection = DriverManager.getConnection(CONNECTION_STR + DB_NAME, properties);
                successLogin = true;
            } catch (SQLException ex) {
                System.out.println(ANSI_RED + "Wrong login credential or missing database" + ANSI_RED);
                System.out.println(ex.getMessage());
            }
        }
    }
    private static void terminateProgram() {
        exit = true;
    }
}
