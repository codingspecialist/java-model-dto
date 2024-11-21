package ex05;

public class App {
    public static void main(String[] args) {
        ControllerAdvice controllerAdvice = new ControllerAdvice();
        Repository repository = new Repository();
        Service service = new Service(repository);
        Controller con = new Controller(service);
        DispatcherServlet ds = new DispatcherServlet(con, controllerAdvice);

        ds.route("/board");
    }
}
