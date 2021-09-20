package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 1)));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Volvo", 2)));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("VW", 3)));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Tesla", 4)));


        List<Car> cars = carService.listCars();
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car id = " + user.getCar());
            System.out.println();
        }

        for (Car car : cars) {
            System.out.println("model = " + car.getModel());
            System.out.println("series = " + car.getSeries());
            System.out.println();
        }

        List<User> getUsers = userService.getUserByCar("Tesla", 4);
        for (User user : getUsers) {
            System.out.println();
            System.out.println(user.toString());
        }
        context.close();
    }
}