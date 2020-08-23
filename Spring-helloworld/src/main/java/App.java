import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");

        Cat catOne = (Cat) applicationContext.getBean(Cat.class);
        Cat catTwo = (Cat) applicationContext.getBean(Cat.class);

        System.out.println("equals one: " + (bean == bean2));
        System.out.println("equals two: " + (catOne == catTwo));

        System.out.println(bean.getMessage());
    }
}