package cur;

public class ABC {
    //    Spring MVC是对servlet进行封装的Spring框架的组成部分。
//            1.浏览器发送请求到服务器，然后被前端控制器DispatchServlet进行捕获。
//            2.DispatchServlet通过请求中的url来获取uri，然后到HandlerMap中获取对应Handler，最后会返回一个ExecutorHandlerChain，里面封装了拦截器和Handler。
//            3.DispatchServlet请求HandlerAdaptor执行Handler，再次之前，会对Handler中的参数进行绑定，并且会进行个数转换。
//            4.Handler执行完之后会返回ModelAndView对象给HandlerAdaptor，HandlerAdaptor再返回给DispatchServlet。
//            5.DispatchServlet在接收到ModelAndView对象后，会请求视图解析器（VIewResolver）进行解析，将model对象解析到View中，再返回给DispatchServlet​。
//            6.DispatchServlet将View对象返回给浏览器进行渲染。​
    public static void main(String[] args) {
        System.out.println(1);
        String a = new String();
        System.out.println(a);
    }
}
