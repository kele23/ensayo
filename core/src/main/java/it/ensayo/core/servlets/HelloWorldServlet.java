package it.ensayo.core.servlets;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ensayo.core.models.HelloWorldModel;
import it.ensayo.core.models.HelloWorldModel2;
import it.ensayo.core.utils.ResponseUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.jetbrains.annotations.NotNull;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(
    service = {Servlet.class},
    property = {
        SLING_SERVLET_RESOURCE_TYPES + "=ensayo/components/content/hello-world",
        SLING_SERVLET_METHODS + "=GET",
        SLING_SERVLET_SELECTORS + "=export",
        SLING_SERVLET_EXTENSIONS + "=json",
    }
)
public class HelloWorldServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, @NotNull SlingHttpServletResponse response) {

        Resource resource = request.getResource();
        String map = request.getParameter("map");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = "";
            if ("one".equals(map)) {
                HelloWorldModel2 helloWorldModel2 = resource.adaptTo(HelloWorldModel2.class);
                json = objectMapper.writeValueAsString(helloWorldModel2);
            } else {
                HelloWorldModel helloWorldModel = resource.adaptTo(HelloWorldModel.class);
                json = objectMapper.writeValueAsString(helloWorldModel);
            }
            ResponseUtils.writeJSONResponse(response, 200, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
