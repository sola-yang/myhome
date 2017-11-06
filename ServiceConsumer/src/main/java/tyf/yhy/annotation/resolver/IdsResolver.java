package tyf.yhy.annotation.resolver;

import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.AbstractNamedValueMethodArgumentResolver;
import org.springframework.web.servlet.HandlerMapping;

import tyf.yhy.util.Ids;

/**
* @author:sola
* @version:1.0 create time£º2017Äê11ÔÂ2ÈÕ
*
* 
*/
public class IdsResolver extends AbstractNamedValueMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return parameter.hasParameterAnnotation(Ids.class);
	}

	@Override
	protected NamedValueInfo createNamedValueInfo(MethodParameter parameter) {
		 Ids annotation = (Ids)parameter.getParameterAnnotation(Ids.class);
		return new IdsNamedValueInfo(annotation);
	}

	@Override
	protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
		// TODO Auto-generated method stub
		  Map<String, String> uriTemplateVars = (Map)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, 0);
	      return uriTemplateVars != null?splitInts((String)uriTemplateVars.get(name)):null;
	}
    public static int[] splitInts(String ids) {
        if(ids == null) {
            return null;
        } else {
            ids = ids.trim();
            String[] _ids = ids.split("-", -1);
            if(_ids.length <= 0) {
                return null;
            } else {
                int[] ret = new int[_ids.length];

                for(int i = 0; i < _ids.length; ++i) {
                    ret[i] = Integer.valueOf(_ids[i]).intValue();
                }

                return ret;
            }
        }
    }

	@Override
	protected void handleMissingValue(String name, MethodParameter parameter) throws ServletException {
		// TODO Auto-generated method stub
		   String paramType = parameter.getParameterType().getName();
	       throw new ServletRequestBindingException("Missing URI template variable '" + name + "' for method parameter type [" + paramType + "]");
	}
    public static class IdsNamedValueInfo extends NamedValueInfo{

		public IdsNamedValueInfo(Ids annotation) {
			 super(annotation.value(), true, "\n\t\t\n\t\t\n\ue000\ue001\ue002\n\t\t\t\t\n");
			// TODO Auto-generated constructor stub
		}
    	
    }
}
