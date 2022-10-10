package com.myapp.controller;

 
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.myapp.service.BoardService;
import com.myapp.vo.BoardVO;
 

@Controller
@SessionAttributes("boardVO")
public class BoardController {
    
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    
    @Autowired
    private BoardService boardService;
    
    @RequestMapping(value = "/")
    public String home() throws Exception{
        
        return "home";
        
    }
    
    @RequestMapping(value ="/list")
    public String list(Model model) throws Exception{
        
    	model.addAttribute("boardList", boardService.list());
    	
        return "list";
        
    }
    
    @RequestMapping(value ="/read/{seq}")
    public String read(Model model, @PathVariable int seq) throws Exception{
        
    	model.addAttribute("boardVO", boardService.read(seq));
    	
        return "read";
        
    }
    
    @RequestMapping(value ="/write", method=RequestMethod.GET)
    public String write(Model model) throws Exception{
        
    	model.addAttribute("boardVO", new BoardVO());
    	
        return "write";
        
    }
    
    @RequestMapping(value ="/write", method=RequestMethod.POST)
    public String write(@Valid BoardVO boardVO, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()) {
        	return "/write";
        }
        else {
        	boardService.write(boardVO);
        	
        	return "redirect:/list";
        }
    }
    
    @RequestMapping(value ="/edit/{seq}", method=RequestMethod.GET)
    public String edit(Model model, @PathVariable int seq) throws Exception{
        
    	BoardVO boardVO = boardService.read(seq);
    	model.addAttribute("boardVO", boardVO);
    	
        return "edit";
        
    }
    
    @RequestMapping(value ="/edit/{seq}", method=RequestMethod.POST)
    public String edit(@Valid @ModelAttribute BoardVO boardVO,
    		BindingResult bindingResult, String pwd, SessionStatus sessionStatus, Model model) throws Exception{
        
    	if(bindingResult.hasErrors()) {
    		return "edit";
    	}
    	else {
    		if(boardVO.getPassword().equals(pwd)) {
    			boardService.edit(boardVO);
    			sessionStatus.setComplete();
    			return "redirect:/list";
    		}
    	}
    	model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
    	
        return "edit";
        
    }
    
    @RequestMapping(value ="/delete/{seq}", method=RequestMethod.GET)
    public String delete(Model model, @PathVariable int seq) throws Exception{
        
    	model.addAttribute("seq", seq);
    	
        return "delete";
        
    }
    
    @RequestMapping(value ="/delete", method=RequestMethod.POST)
    public String delete(Model model, int seq, String pwd) throws Exception{
        int rowCount;
        
        BoardVO boardVO = new BoardVO();
        
        boardVO.setSeq(seq);
        boardVO.setPassword(pwd);
        
        if(!boardVO.getPassword().matches("-?\\d+(\\.\\d+)?")) {
        	model.addAttribute("seq", seq);
        	model.addAttribute("msg", "비밀번호는 숫자만 입력 가능합니다.");
        	return "delete";
        }
        
        rowCount = boardService.delete(boardVO);
        
        if(rowCount == 0) {
        	model.addAttribute("seq", seq);
        	model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
        	return "delete";
        }
        else {
        	return "redirect:/list";
        }
        
    }
}

