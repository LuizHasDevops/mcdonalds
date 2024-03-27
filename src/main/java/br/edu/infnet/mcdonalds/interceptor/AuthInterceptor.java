package br.edu.infnet.mcdonalds.interceptor;
import br.edu.infnet.mcdonalds.model.Sobremesa;
import br.edu.infnet.mcdonalds.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
        if(usuarioLogado != null){
            logger.info("Estou logado");
        }else{
            logger.info("Nao estou logado");
            if (!request.getRequestURI().contains("/signup") && !request.getRequestURI().contains("/forgotpassword")) {
                response.sendRedirect("/login");
                return false;
            }else{
                return true;
            }

        }
        return true;
    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {}
}