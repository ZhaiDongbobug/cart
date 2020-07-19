package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

public class OrderItemDeleteServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		List<OrderItem> ois4Delete = new ArrayList<>();
		
		if(null != ois) {
			for(OrderItem io:ois) {
				if(io.getProduct().getId()==pid) {
					ois4Delete.add(io);
				}
			}
		}
		
		ois.remove(ois4Delete);
		
		response.sendRedirect("/cart/listOrderItem");
	}
}
