package tyf.yhy.base.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tyf.yhy.base.entity.Id;
import tyf.yhy.base.entity.Paginator;
import tyf.yhy.base.service.BaseService;

/**
* @author:sola
* @version:1.0 create time£º2017Äê10ÔÂ30ÈÕ
*
* 
*/
public abstract class SContenController<T extends Id,S extends BaseService<T>> {

	protected final String RETURN_SCONTENT_PAGE;
	protected S service;
	public SContenController(String model){
		this.RETURN_SCONTENT_PAGE=String.format("/%s/show", model);
	}
	@RequestMapping({"/show"})
	public String show(T query,BindingResult errors,Model model, HttpServletRequest request, HttpServletResponse response){
		int page =this.getPage(request);
		return this.toShow(page,query,errors, model, request, response);
	}
	@RequestMapping({"/show/{page}"})
	public String show(@PathVariable("page")int page,T query,BindingResult errors,Model model, HttpServletRequest request, HttpServletResponse response){
		return this.toShow(page,query, errors, model, request, response);
	}
	protected int getPage(HttpServletRequest request){
		String page =request.getParameter("page");
		if(page!=null&&!page.isEmpty()){
			try{
				return Integer.parseInt(page);
			}catch(Exception e){
				return -1;
			}
		}else{
			return -1;
		}
		
	}
	protected String toShow(int page,T query,BindingResult errors,Model model, HttpServletRequest request, HttpServletResponse response){
		
		Paginator<T> paginator=this.getPaginator(page,query);
		boolean toShowDataOrNot=this.preShow(page, paginator, query, model, request, response);
		List<T> datas=Collections.emptyList();
		if (toShowDataOrNot) {
			datas=this.service.getByCondition(paginator);
		}
		model.addAttribute("datas",datas);
		model.addAttribute("paginator",paginator);
		model.addAttribute("hasDatas",datas!=null&&!datas.isEmpty());
		return this.RETURN_SCONTENT_PAGE;
	}
	protected Paginator<T> getPaginator(int page,T query){
		Paginator<T> paginator=new Paginator<T>(page);
		paginator.setQuery(query);
		return paginator;
	}
	protected boolean preShow(int page,Paginator<T> paginator,T query,Model model, HttpServletRequest request, HttpServletResponse response){
		return true;
	}
}
