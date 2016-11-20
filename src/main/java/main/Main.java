package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

/**
 * @author v.chibrikov
 *         <p>
 *         ������ ���� ��� ����� �� https://stepic.org/
 *         <p>
 *         �������� ����� � ��������: https://github.com/vitaly-chibrikov/stepic_java_webserver
 *
 *         ������:
�������� �������, ������� ����� ������������ ������� �� /mirror
��� ��������� GET ������� � ���������� key=value ������� ������ ������� � response ������ ���������� value.
��������, ��� GET ������� /mirror?key=hello ������ ������ ������� ��������, �� ������� ���� ����� "hello".

 */
public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
