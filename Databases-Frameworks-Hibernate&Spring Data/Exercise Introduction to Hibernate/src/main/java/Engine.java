import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;

public class Engine implements Runnable{
    final private EntityManager entityManager;
    private Scanner scanner ;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter exercise number:");

        try {
            int exerciseNum = Integer.parseInt(scanner.nextLine());
            switch (exerciseNum){
                case 2 -> ex2();
                case 3 -> ex3();
                case 4 -> ex4();
                case 5 -> ex5();
                case 6 -> ex6();
                case 7 -> ex7();
                case 8 -> ex8();
                case 9 -> ex9();
                case 10 -> ex10();
                case 11 -> ex11();
                case 12 -> ex12();
                case 13 -> ex13();
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            entityManager.close();
        }
    }

    private void ex11() {
        System.out.println("Enter first name start pattern:");
        String preFix = scanner.nextLine();
        List<Employee> resultList = entityManager.createQuery("select e from Employee e where e.firstName like :pre", Employee.class)
                .setParameter("pre", preFix + "%")
                .getResultList();

        for (Employee employee : resultList) {
            System.out.printf("%s %s - %s - ($%.2f)%n"
                    ,employee.getFirstName()
                    ,employee.getLastName()
                    ,employee.getJobTitle()
                    ,employee.getSalary());
        }
    }

    private void ex9() {
        List<Project> resultList = entityManager.createQuery
                ("select p from Project p order by p.startDate desc ",Project.class)
                .setMaxResults(10)
                .getResultList();
        Comparator<Project> byName = Comparator.comparing(Project::getName);
        Collections.sort(resultList,byName);
        for (Project project : resultList) {

            System.out.printf("Project name:%s %n" +
                            "   Project Description:%s%n" +
                            "   Project Start Date:%s%n" +
                            "   Project End Date:%s%n"
                    ,project.getName()
                    ,project.getDescription()
                    ,project.getStartDate()
                    ,project.getEndDate()  == null ? "null" : project.getEndDate());
        }
    }

    private void ex8() {
        System.out.println("Enter employee id:");
        int employeeId = Integer.parseInt(scanner.nextLine());
        Employee employee = entityManager.createQuery
                        ("SELECT e from Employee e where e.id = :e_id", Employee.class)
                .setParameter("e_id", employeeId)
                .getSingleResult();
        Set<Project> projects = employee.getProjects();
        System.out.printf("%s %s - %s%n",employee.getFirstName(),employee.getLastName(),employee.getJobTitle());
        for (Project project : projects) {
            System.out.printf("%s%n",project.getName());
        }

    }

    private void ex13() {
        System.out.println("Enter town name:");
        String townName = scanner.nextLine();

        Town town = entityManager.createQuery("SELECT t from  Town t where t.name = :t_name",Town.class)
                .setParameter("t_name",townName)
                .getSingleResult();

        int affectedRows =  removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d addresses in %s is deleted%n",affectedRows,town.getName());
    }

    private int removeAddressesByTownId(Integer id) {

        List<Address> addresses = entityManager.createQuery("select a from Address a where a.town.id = :t_id", Address.class)
                .setParameter("t_id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }

    @SuppressWarnings("unchecked")
    private void ex12() {
        List<Object[]> rows = entityManager.createNativeQuery("select  d.name, max(e.salary) as `m_salary` from departments d\n" +
                "join employees e on d.department_id = e.department_id\n" +
                "group by d.name\n" +
                "having `m_salary` not between 30000 and 50000;")
                .getResultList();

        for (Object[] row : rows) {
            String name = (String) row[0];
            BigDecimal salary = (BigDecimal) row[1];
            System.out.printf("%s %.2f%n",name,salary);

        }

    }

    private void ex10() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager.createQuery
                ("update Employee e set e.salary = e.salary * 1.2 where e.department.id in :ids")
                .setParameter("ids", Set.of(1,2,4,11))
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println(affectedRows);
    }

    private void ex7() {
        List<Address> resultList = entityManager.createQuery
                        ("select a from Address a order by a.employees.size desc ", Address.class)
                .setMaxResults(10)
                .getResultList();

        resultList.forEach(address -> System.out.printf("%s, %s - %d employees%n"
                ,address.getText()
                ,address.getTown() == null ? "Unknown" : address.getTown().getName()
                ,address.getEmployees().size()));
    }

    private void ex6() {
        System.out.println("Enter employee last name:");
        String lastName = scanner.nextLine();

        Employee employee = entityManager.createQuery("select e from Employee e where e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName).getSingleResult();

        Address address = createAddress("Vitoshka 15");
        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createAddress(String addressName) {
        Address address = new Address();
        address.setText(addressName);
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private void ex5() {
        List<Employee> resultList = entityManager.createQuery
                        ("SELECT e from Employee e where e.department.name = :dep_name " +
                                "order by e.salary asc ,e.id asc ", Employee.class)
                .setParameter("dep_name", "Research and Development")
                .getResultList();

        for (Employee employee : resultList) {
            System.out.printf("%s %s from %s - $%.2f %n",
                    employee.getFirstName(),employee.getLastName(),
                    employee.getDepartment().getName(),employee.getSalary());
        }
    }

    private void ex4() {
        BigDecimal minSalary = new BigDecimal(50000);
        List<Employee> employeeList = entityManager.createQuery
                        ("SELECT e from Employee e where e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", minSalary)
                .getResultList();

        for (Employee employee : employeeList) {
            System.out.println(employee.getFirstName());
        }
    }

    private void ex3() {
        System.out.println("Enter employee full name:");
        String [] fullName = scanner.nextLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery
                        ("SELECT count (e) from Employee e where  e.firstName = :f_name and e.lastName =: l_name", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        if (singleResult == 0){
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }


    }

    private void ex2() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery
                ("UPDATE Town t " +
                        "SET t.name = upper(t.name) where length(t.name) <= 5 ");

        System.out.println("Affected rows " + query.executeUpdate());
        entityManager.getTransaction().commit();
    }
}
