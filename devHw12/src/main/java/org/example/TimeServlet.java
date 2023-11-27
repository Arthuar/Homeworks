package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.example.TimeConfig.*;


@WebServlet(urlPatterns = "/time")
public class TimeServlet extends HttpServlet {

    private transient TemplateEngine engine;


    @Override
    public void init() {
        engine = new TemplateEngine();

        FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix("C:\\myproject\\devHw12\\templates\\");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setOrder(engine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        engine.addTemplateResolver(resolver);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(CONTENT_TYPE_HTML);

        String timezoneParam = request.getParameter(PARAM_TIMEZONE);

        TimeZone timezone = TimeZone.getTimeZone(DEFAULT_TIMEZONE);

        if (timezoneParam != null) {
            String stringZoneID = timezoneParam.substring(3).trim();

            int zoneId = Integer.parseInt(stringZoneID);
            timezone.setRawOffset(zoneId * MILLISECONDS_IN_HOUR);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        dateFormat.setTimeZone(timezone);
        String currentTime = dateFormat.format(new Date());

        Context context = new Context();
        context.setVariable("currentTime", currentTime);

        engine.process("time", context, response.getWriter());
        response.getWriter().close();
    }
}