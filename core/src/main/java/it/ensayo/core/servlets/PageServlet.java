package it.ensayo.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.ensayo.core.models.PageModel;
import it.ensayo.core.utils.ResponseUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.jetbrains.annotations.NotNull;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(
    service = {Servlet.class},
    property = {
        SLING_SERVLET_RESOURCE_TYPES + "=ensayo/components/structure/pages/page",
        SLING_SERVLET_METHODS + "=GET",
        SLING_SERVLET_SELECTORS + "=export",
        SLING_SERVLET_EXTENSIONS + "=json",

    }
)
public class PageServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, @NotNull SlingHttpServletResponse response) throws ServletException, IOException {
        Resource resource = request.getResource();
        PageModel pageModel = resource.adaptTo(PageModel.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseUtils.writeJSONResponse(response, 200, objectMapper.writeValueAsString(pageModel));
    }
}
