package tyf.yhy.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.Strings;

import tyf.yhy.base.entity.Id;
import tyf.yhy.base.entity.IdForm;
import tyf.yhy.base.entity.Query;
import tyf.yhy.base.service.BaseService;
import tyf.yhy.util.Ids;

/**
* @author:sola
* @version:1.0 create time£º2017Äê10ÔÂ30ÈÕ
*
* 
*/
public abstract class CDUContentController<T extends Id,S extends BaseService<T>,F extends IdForm<T>,Q extends Query> extends SContenController<T, S, Q>{

	protected final String ADD_PAGE;
	protected final String REDIRECT_PAGE;
	public CDUContentController(String model) {
		super(model);
		this.ADD_PAGE=String.format("/%s/addPage",model);
		this.REDIRECT_PAGE=String.format("redirect:/%s/show",model);
	}
	@RequestMapping({"/addData"})
	protected String addData(Model model){
		this.postAddData(model);
		return this.ADD_PAGE;
	}
	@RequestMapping({"/save"})
	protected String save(@Valid F form,BindingResult errors,Model model,HttpServletRequest request,HttpServletResponse response){
		model.addAttribute("form", form);
		String queryStr=request.getParameter("queryStr");
		if(!errors.hasErrors()){
			this.toSave(form, errors, model, request, response);
		}
		if(errors.hasErrors()){
			model.addAttribute("errors", errors);
			return this.ADD_PAGE;
		}else{
			return Strings.isNullOrEmpty(queryStr)?this.REDIRECT_PAGE:this.REDIRECT_PAGE+"?"+queryStr;
		}
		
	}
	protected abstract void toSave(F form,BindingResult errors,Model model,HttpServletRequest request,HttpServletResponse response);
	protected void postAddData(Model model){
		
	}
	@RequestMapping({"/update/{id}"})
	protected String updateData(@PathVariable("id")int id,Model model){
		T t=service.get(id);
		model.addAttribute("update", t);
		this.postupdateData(id,t,model);
		return this.ADD_PAGE;
	}
	protected void postupdateData(int id,T obj,Model model){
		
	}
	@RequestMapping({"/delete/{ids}"})
	protected String deleteData(@Ids("ids")int ids[],HttpServletRequest request){
		this.service.deleteByIds(ids);
		String queryStr =request.getParameter("queryStr");
		return Strings.isNullOrEmpty(queryStr)?this.REDIRECT_PAGE:this.REDIRECT_PAGE+"?"+queryStr;
	}
}
