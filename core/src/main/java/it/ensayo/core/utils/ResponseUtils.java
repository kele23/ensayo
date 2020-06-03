package it.ensayo.core.utils;

import org.apache.sling.api.SlingHttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * UtilsImpl for write http responses.
 *
 * @author m.scala
 * @author f.costingo
 */
public final class ResponseUtils {

    /**
     * JSON mime type
     */
    public static final String APPLICATION_JSON = "application/json";
    /**
     * XML mime type
     */
    public static final String APPLICATION_XML = "application/xml";
    /**
     * HTML mime type
     */
    public static final String TEXT_HTML = "text/html";
    /**
     * TEXT mime type
     */
    public static final String TEXT_PLAIN = "text/plain";
    /**
     * UTF-8 Encoding code
     */
    public static final String UTF8 = "UTF-8";

    /**
     * FOUR KYLOBYTE
     */
    private static final int FOUR_KB = 4096;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseUtils.class);

    private ResponseUtils() {
        //do nothing
    }

    /**
     * Writes an html response
     *
     * @param response The sling response
     * @param status   The response status code
     * @param message  The body message of the response (html string)
     */
    public static void writeHTMLResponse(SlingHttpServletResponse response, int status, String message) {
        writeResponse(response, TEXT_HTML, status, message);
    }

    /**
     * Writes an xml response
     *
     * @param response The sling response
     * @param status   The response status code
     * @param message  The body message of the response (xml string)
     * @param head     Include the xml header declaration
     */
    public static void writeXMLResponse(SlingHttpServletResponse response, int status, String message, boolean head) {
        if (head) message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + message;
        writeResponse(response, APPLICATION_XML, status, message);
    }

    /**
     * Writes a JSON response
     *
     * @param response The sling response
     * @param status   The response status code
     * @param message  The body message of the response (json string)
     */
    public static void writeJSONResponse(SlingHttpServletResponse response, int status, String message) {
        writeResponse(response, APPLICATION_JSON, status, message);
    }

    /**
     * Writes a txt response
     *
     * @param response The sling response
     * @param status   The response status code
     * @param message  The body message of the response (txt string)
     */
    public static void writeResponse(SlingHttpServletResponse response, int status, String message) {
        writeResponse(response, TEXT_PLAIN, status, message);
    }

    /**
     * Writes the response.
     *
     * @param response The sling response
     * @param mimeType The response mimeType
     * @param status   The response status code
     * @param data     The data to write in the response
     */
    public static void writeResponse(final SlingHttpServletResponse response, String mimeType,
                                     int status, String data) {
        try {
            response.setStatus(status);
            response.setContentType(mimeType);
            response.setCharacterEncoding(UTF8);
            response.getWriter().write(data);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    /**
     * Writes a binary data response.
     *
     * @param response The sling response
     * @param mimeType The response mimeType
     * @param status   The response status code
     * @param input    The data to write in the response
     */
    public static void writeResponse(final SlingHttpServletResponse response, String mimeType,
                                     int status, InputStream input) {
        try {
            response.setStatus(status);
            response.setContentType(mimeType);

            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[FOUR_KB];

            for (int length; (length = input.read(buffer)) > 0; ) {
                outputStream.write(buffer, 0, length);
                outputStream.flush();
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    public static void sendRedirect(final SlingHttpServletResponse response,
                                    int status, String url) {
        response.setStatus(status);
        response.setHeader("Location", url);
    }


}
