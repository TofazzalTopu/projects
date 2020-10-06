package info.com.member.config;

import org.springframework.stereotype.Component;

/**
 * Created by mdtofazzal.hossain on 4/3/2019.
 */

@Component
public class LoggingAccessDeniedHandler {
//public class LoggingAccessDeniedHandler implements AccessDeniedHandler {

    /*private static Logger log = LoggerFactory.getLogger(LoggingAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException ex) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            log.info(auth.getName()
                    + " was trying to access protected resource: "
                    + request.getRequestURI());
        }

        response.sendRedirect(request.getContextPath() + "/access-denied");

    }*/
}