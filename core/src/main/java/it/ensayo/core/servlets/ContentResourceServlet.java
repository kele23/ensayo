package it.ensayo.core.servlets;


import it.ensayo.core.utils.ResponseUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.jetbrains.annotations.NotNull;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(
    service = {Servlet.class},
    property = {
        SLING_SERVLET_RESOURCE_TYPES + "=test-resource/resource",
        SLING_SERVLET_METHODS + "=GET",
        SLING_SERVLET_SELECTORS + "=export",
        SLING_SERVLET_EXTENSIONS + "=json",
    }
)
public class ContentResourceServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, @NotNull SlingHttpServletResponse response) {
        ResponseUtils.writeJSONResponse(response, 200, "{\"servlet\":\"servlet\"}");
    }

}
