import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] arguments) throws Exception
    {
        ApplicationContext context    = new ClassPathXmlApplicationContext("main.xml");
        JDABuilder         jdaBuilder = (JDABuilder) context.getBean("jda_builder");
        JDA                api        = jdaBuilder.build();

        api.awaitReady();
    }
}
