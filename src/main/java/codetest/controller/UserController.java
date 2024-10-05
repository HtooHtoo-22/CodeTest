package codetest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Model.CartBean;
import Model.ProductBean;
import codetest.repository.CartRepo;
import codetest.repository.ProductRepo;

@Controller
@RequestMapping("/User")
public class UserController {
//	private CartRepo crepo;
//	private ProductRepo prepo;
	
	@GetMapping("/viewproducts")
	public String showBooks(Model model) {
		ProductRepo prepo=new ProductRepo();
		List<ProductBean> list=prepo.showAllProducts();
		model.addAttribute("product", list);
		System.out.println(list.get(1).get());
		//repos showbook method
		//model list
		return "viewproduct";
	}
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("id")int id) {
		CartRepo repo=new CartRepo();
		int i=repo.addToCart(id);
		if(i>0) {
			return "redirect:viewproducts";
		}else {
			System.out.println("Error");
		}
		return null;
	}
	
	@GetMapping("/showcart")
	public String showMyCart(Model model) {
		CartRepo crepo=new CartRepo();
		List <CartBean> list=crepo.showMyCart();
		if(list!=null) {
			model.addAttribute("Cart", list);
			return "showmycart";
		}else {
			System.out.println("ShowCart error pr tharthar yay");
		}
		return null;
	}
	@PostMapping("/order")
	public String order() {
		CartRepo crepo=new CartRepo();
		int i=crepo.order();
		if(i>0) {
			return "ordersuccess";
		}
		return null;
	}
	@PostMapping("/deleteFromCart")
	public String deleteFromCart(@RequestParam("id")int id) {
		CartRepo repo=new CartRepo();
		int i=repo.deleteFromCart(id);
		if(i>0) {
			return "redirect:showcart";
		}else {
			System.out.println("Delete from cart mhr tr pr TharThar");
		}
		return null;
	}
}
