package it.ensayo.core.filters;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

import static org.apache.sling.engine.EngineConstants.*;


@Component(service = Filter.class,
    property = {
        SLING_FILTER_SCOPE + "=" + FILTER_SCOPE_REQUEST,
        SLING_FILTER_PATTERN + "=/content/ensayo.*"
    })
public class EnsayoFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnsayoFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //do nothing
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Ensayo Filter!!!!");
        servletRequest.setAttribute("ensayo-attribute", "CIAO");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        //do nothing
    }
}
