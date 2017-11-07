package com.redoop.modules.front.website;
import com.redoop.common.exception.SystemException;
import com.redoop.common.utils.HtmlUtil;
import com.redoop.common.utils.Uuid;
import com.redoop.modules.admin.component.entity.Component;
import com.redoop.modules.admin.component.service.ComponentService;
import com.redoop.modules.admin.customer.entity.Customer;
import com.redoop.modules.admin.customer.service.CustomerService;
import com.redoop.modules.admin.download.entity.Download;
import com.redoop.modules.admin.download.service.DownloadService;
import com.redoop.modules.admin.mess.entity.Mess;
import com.redoop.modules.admin.mess.service.MessService;
import com.redoop.modules.admin.messbriefing.entity.Briefing;
import com.redoop.modules.admin.messbriefing.service.MessbriefingService;
import com.redoop.modules.admin.news.entity.New;
import com.redoop.modules.admin.news.entity.News;
import com.redoop.modules.admin.news.service.NewService;
import com.redoop.modules.admin.partner.entity.Partner;
import com.redoop.modules.admin.partner.service.PartnerService;
import com.redoop.modules.admin.product.entity.Product;
import com.redoop.modules.admin.product.service.ProductService;
import com.redoop.modules.admin.solution.entity.Solution;
import com.redoop.modules.admin.solution.service.SolutionService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 官网Controller
 */
@Controller
@RequestMapping(value = "/front")
public class WebsiteController {
    @Autowired
    private NewService newService;
    @Autowired
    private ComponentService componentService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PartnerService partnerService;
    @Autowired
    private DownloadService downloadService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SolutionService solutionService;

    @Autowired
    private MessbriefingService messbriefingService;

    @Autowired
    private JavaMailSender javaMailSender;
    private void setStyle(Model model,String state){
        model.addAttribute("product","");
        model.addAttribute("solution","");
        model.addAttribute("news","");
        model.addAttribute("download","");
        model.addAttribute("partners","");
        model.addAttribute("aboutus","");
        model.addAttribute("appstore","");
        model.addAttribute("redoopCRH","");
        model.addAttribute("redoopAI","");
        model.addAttribute(state,"on");
    }

    /**
     * 官网首页
     * @return
     */
    @GetMapping(value = "")
    public String home(Model model) {

        setStyle(model,"");
        return "front/website/";
    }

    /**
     * 产品（临时）
     * @param model
     * @return
     */
    @GetMapping(value = "/product")
    public String product(Model model) {
        List<Solution> solutionList2=solutionService.listByName2();
        model.addAttribute("solutionList2",solutionList2);
        setStyle(model,"product");
        return "front/website/product";
    }

    /**
     * 方案和案例首页
     * @param model
     * @return
     */
    @GetMapping(value = "/solution")
    public String casePolice(Model model) {
        List<Solution> solutionList=solutionService.listByName();
        model.addAttribute("solutionList",solutionList);

        List<Solution> solutionList2=solutionService.listByName2();
        model.addAttribute("solutionList2",solutionList2);
        setStyle(model,"solution");
        return "front/website/solution";
    }

    /**
     * 方案|案例详情页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/solutiondetail/{id}",method = RequestMethod.GET)
    public String onesolution(@PathVariable String id,Model model) {
        Solution solutiondetail = solutionService.findById(id);
        model.addAttribute("solutiondetail",solutiondetail);
        setStyle(model,"solution");
        return "front/website/solutiondetail";
    }


    /**
     * 官网新闻首页
     * @param model
     * @return
     */
    @RequestMapping(value = "/news",method = RequestMethod.GET)
    public String news(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {

        Page<News> pageList = newService.listByState(page);

        model.addAttribute("pageList",pageList);
        model.addAttribute("url","front/news?");

        setStyle(model,"news");
        return "front/website/news";
    }

    /**
     * 新闻详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/onenew/{id}",method = RequestMethod.GET)
    public String onenew(@PathVariable String id,Model model) {
        News onenew = newService.findById(id);
        model.addAttribute("onenew",onenew);
        setStyle(model,"news");
        return "front/website/onenew";
    }


    /**
     * 产品资料
     * @param model
     * @return
     */
    @GetMapping(value = "/download")
    public String download(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model,
                           @RequestParam(value ="producttype",defaultValue = "0") String producttype) {
        Page<Product> pageList= productService.byProducttype(producttype,page);
        model.addAttribute("pageList", pageList);

        model.addAttribute("producttype",producttype);
        model.addAttribute("url","/front/download?producttype=" + producttype + "&");

        setStyle(model,"download");
        return "front/website/productinformation";
    }

    /**
     * 产品资料下载次数
     * @param id
     * @return
     * @throws SystemException
     */
    @ResponseBody
    @RequestMapping(value = "/download/addProductCount/{id}", method = RequestMethod.POST)
    public boolean addProductCount(@PathVariable(value = "id") String id) throws SystemException {
        int i=productService.addProductCount(id);
        if (i>0){
            return true;
        }
        return false;
    }


    /**
     * 合作伙伴
     * @param model
     * @return
     */
    @RequestMapping(value = "/partners",method = RequestMethod.GET)
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        Page<Partner> pageList= partnerService.listByIntention(page);
        model.addAttribute("pageList",pageList);

        model.addAttribute("url","front/partners?");
        setStyle(model,"partners");
        return "front/website/partners";
    }

    /**
     * 前台合作伙伴申请
     * @param mode
     * @param partner
     * @param request
     * @param attach
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/partners/addPartner", method = RequestMethod.POST)
    public boolean addPartner(Model mode, Partner partner, HttpServletRequest request, @RequestParam(value = "logo", required = false) MultipartFile attach) {
        try {
            request.setCharacterEncoding( "utf-8" );
            String logoPath = request.getSession().getServletContext().getRealPath("/");
            partnerService.applySave(partner,attach,logoPath);
            return true;
        } catch (Exception e) {
            mode.addAttribute("message", e.getMessage());
            mode.addAttribute("form", partner);
            return false;
        }
    }
    /**
     * 前台点击图片查询详细信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/partners/findByPicId", method= RequestMethod.GET)
    public Partner findByPicId(Model model, Partner partner,@RequestParam(value = "id") String id)throws Exception{

        partner =partnerService.findById(id);
        model.addAttribute("partner",partner.getAuthentication());
        return partner;
    }


    /**
     * 前台多选搜索(checkbox)
     * @param partnertype
     * @param model
     * @return
     */
    @RequestMapping(value = "/partners/findByPartnertype" ,method = RequestMethod.GET)
    public String select(@RequestParam(value = "partnertype",required = false,defaultValue = "") String partnertype,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,Model model)throws Exception {

        Page<Partner> pageList = partnerService.findByPartnertype(page, partnertype);

        String[] arrs = partnertype.split(",");
        List<String> partnertypeList = new ArrayList<>();
        for(int i = 0;i<arrs.length;i++){
            partnertypeList.add(arrs[i]);
        }
        model.addAttribute("pageList",pageList);
        model.addAttribute("url","front/partners/findByPartnertype?partnertype="+ partnertype + "&");
        model.addAttribute("partnertype",partnertype);
        model.addAttribute("partnertypeList",partnertypeList);

        return "front/website/partners";
    }


    //应用商城页面AppStore
    @RequestMapping(value = "/appstore",method = RequestMethod.GET)
    public String appstore(@RequestParam(value = "type", defaultValue = "0") String type,
                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                           Model model) {
        Page<Component> pageList = componentService.listByType(type,page);
        model.addAttribute("pageList",pageList);
        model.addAttribute("login", "display:none");
        model.addAttribute("type",type);
        model.addAttribute("url","/front/appstore?type="+ type + "&");
        setStyle(model,"appstore");
        return "front/website/appstore";

    }

    /**
     * 应用商城 点击申请时进行判断登录状态  AppStore
     * 2017年8月31日22:56:39
     * @param request
     * @param customer
     * @param model
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/appstore/apply", method= RequestMethod.GET)
    public int apply(HttpServletRequest request, Customer customer,
                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                     Model model,@RequestParam(value = "id") String id) {
        // 状态： 0 表示系统错误 1 表示没有登录 2 登录失败  3 表示没有这个用户  4 表示没有登录权限  5 已经登录  6 去登录  7 去注册 8 注册失败
        //点击申请 一共有  0  1  5这三种状态
        customer = (Customer) request.getSession().getAttribute("customer");
        Page<Component> pageList = componentService.listByType("0",page);
        model.addAttribute("id", id);
        model.addAttribute("pageList", pageList);
        //第一步判断ID是否为空
        if (id == null) {
            return 0;
        }
        //第二步判断是否登录
        if (customer == null) {
            return 6;
        } else {
            return 5;
        }
    }

    /**
     * 应用商城 客户登录 AppStore
     * 2017年9月1日11:56:45
     * @param customer
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/customerLogin", method = RequestMethod.GET)
    public int customerLogin(Customer customer, HttpServletRequest request, HttpSession session) throws Exception {
        //  0 邮箱格式错误    1 邮箱名称错误    2 密码错误  3 登录成功   4 （未激活）请激活再登录
        customer.setLogindate(new Date());
        int s = this.customerService.login(customer);
        if (s==0){//邮箱格式错误
            return 0;
        } else if (s==1){//邮箱名称错误
            return 1;
        }else if(s==2) {//密码错误
            return 2;
        }else if (s==4){//邮箱未激活
            return 4;
        }
        session.setAttribute("customer", customer);
        return 3;//登录成功
    }

    /**
     * 应用商城 根据服务id查询详细信息 AppStore
     * 2017年8月31日23:57:25
     * @param request
     * @param mode
     * @param customer
     * @param id
     * @return
     */
    @RequestMapping(value="/appstore/applyById", method= RequestMethod.GET)
    @ResponseBody
    public Component applyById(HttpServletRequest request, Model mode, Customer customer,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "id") String id){
        customer = (Customer)request.getSession().getAttribute("customer");
        Page<Component> pageList = componentService.listByType("0",page);
        mode.addAttribute("pageList", pageList);
        Component component = null;
        if(customer!=null){
            component = componentService.findById(id);
            return component;
        }else {
            System.out.println("错误，获取服务数据有误！");
        }
        return null;
    }

    /**
     * 应用商城 前端客户注册信息增加 AppStore
     * 2017年9月4日21:50:45
     * huangtianhao
     * @param mode
     * @param customer
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRegiste", method = RequestMethod.POST)
    public boolean addRegiste(Model mode, Customer customer,HttpServletRequest request){
        //域名
        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        String code = Uuid.getUuid() + Uuid.getUuid();
        String repassword = request.getParameter("repassword");
        Pattern p=null;
        Matcher m=null;
        String rex = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$";
        p = Pattern.compile(rex);
        m= p.matcher(customer.getPassword());
        //Customer cu_name = customerService.findByUserName(customer.getUsername());
        Customer cu_email = customerService.findByUserEmail(customer.getEmail());
        if (customer==null){
            return false;
        }
       /* if (cu_name != null) {
            return false;
        }*/
        if (cu_email != null) {
            return false;
        }
        if (customer.getPassword() == null || "".equals(customer.getPassword())
                ||!customer.getPassword().matches("^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$")) {
            return false;
        }
        if (repassword == null || "".equals(repassword)) {
            return false;
        }
        if (!customer.getPassword().equals(repassword)) {
            return false;
        }
        if (customer.getEmail()==null||"".equals(customer.getEmail())){
            return false;
        }
        try {
            customer.setCode(code);
            customerService.regAdd(customer, repassword,tempContextUrl);
           // System.out.println("注册信息"+customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m.matches();
    }

    /**
     * 应用商城 用户注册成功后激活连接 AppStore
     * @param mode
     * @param customer
     * @param request
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regJH", method = RequestMethod.GET)
    public String  regJH(Model mode, Customer customer,HttpServletRequest request,@RequestParam(value = "code") String code) throws Exception {
        //接收激活码
        code = request.getParameter("code");
        customer = customerService.findByCode(code);
        if(customer!=null){
            //已经查到用户，修改用户状态
            customer.setActivatestate(1);//1:已经激活
            //customer.setCode(null);
            customerService.startActivate(customer.getId());
            request.setAttribute("msg","尊敬的用户,您好!您的邮箱激活成功，请您前往刚刚的页面登录即可...");
            //return "front/website/msg";
        }else {
            //没有查到
            request.setAttribute("msg","尊敬的用户,您好!您的邮箱激活失败，请您检查连接地址是否正确后,请重新激活...");
        }
        return "front/website/msg";
    }

    /**
     * 应用商城 搜索（根据商品的名字进行搜索）AppStore
     * @param model
     * @param name
     * @param session
     * @return
     */
    @RequestMapping(value = "/appstore/select", method = RequestMethod.GET)
    public  String select(Model model,@RequestParam String name,
                          @RequestParam(value = "page", defaultValue = "0") Integer page,HttpSession session){

        Page<Component> pageList=componentService.selectByName(page,"%" + name + "%");

        model.addAttribute("pageList", pageList);
        model.addAttribute("url","/front/appstore/select?name=" + name + "&");
        model.addAttribute("login", "display:none");
        model.addAttribute("name",name);

        return "front/website/appstore";

    }


    /**
     * 关于我们
     * @param model
     * @return
     */
    @GetMapping(value = "/aboutus")
    public String aboutus(Model model) {
        setStyle(model,"aboutus");
        return "front/website/aboutus";
    }



    @GetMapping(value = "/event")
    public String event(Model model) {
        return "front/website/event";
    }

    /**
     * 下载CRH
     * @param model
     * @return
     */
    @GetMapping(value = "/redoopCRH")
    public String redoopCRH(Model model,@RequestParam(value ="platformtype",defaultValue = "0") String platformtype) {

        List<Download> list= downloadService.listByDocumenttype(platformtype);
        model.addAttribute("list", list);
        model.addAttribute("platformtype",platformtype);
        setStyle(model,"redoopCRH");
        return "front/website/redoopCRH";
    }


    /**
     * 前端查看
     * @return
     * @throws SystemException
     */
    @RequestMapping(value = "/byCRH/{id}", method = RequestMethod.GET)
    public String addDocumenCount(@PathVariable String id,Download markDown, Mess mess,Model model){

        markDown = downloadService.findMarkDownId(id);
        model.addAttribute("markDown",markDown);
        setStyle(model,"redoopCRH");

        return "front/website/crhMarkDown";
    }


    @ResponseBody
    @RequestMapping(value = "/redoopCRH/addDocumenCount/{id}", method = RequestMethod.POST)
    public boolean addDocumenCount(@PathVariable(value = "id") String id) throws SystemException {
        int i=downloadService.addDocumenCount(id);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 首页轮播跳转航天
     * @param model
     * @return
     */
    @GetMapping(value = "/caseSpace")
    public String caseSpace(Model model) {
        setStyle(model,"solution");
        return "front/website/caseSpace";
    }

    @GetMapping(value = "/caseLenovo")
    public String caseLenovo(Model model) {
       setStyle(model,"solution");
       return "front/website/caseLenovo";
    }

    @GetMapping(value = "/caseTraffic")
    public String caseTraffic(Model model) {
        setStyle(model,"solution");
        return "front/website/caseTraffic";
    }

    @GetMapping(value = "/caseUnicom")
    public String caseUnicom(Model model) {
        setStyle(model,"solution");
        return "front/website/caseUnicom";
    }


    @GetMapping(value = "/solutionPolice")
    public String solutionPolice(Model model) {
        setStyle(model,"solution");
        return "front/website/solutionPolice";
    }


    @GetMapping(value = "/solutionBridge")
    public String solutionBridge(Model model) {
        setStyle(model,"solution");
        return "front/website/solutionBridge";
    }

    @GetMapping(value = "/solutionCloudCount")
    public String solutionCloudCount(Model model) {
        setStyle(model,"solution");
        return "front/website/solutionCloudCount";
    }

    @GetMapping(value = "/solutionGene")
    public String solutionGene(Model model) {
        setStyle(model,"solution");
        return "front/website/solutionGene";
    }



    @GetMapping(value = "/solutionSpace")
    public String solutionSpace(Model model) {
        setStyle(model,"solution");
        return "front/website/solutionSpace";
    }

    @GetMapping(value = "/solutionTraffic")
    public String solutionTraffic(Model model) {
        setStyle(model,"solution");
        return "front/website/solutionTraffic";
    }

    @GetMapping(value = "/solutionVideo")
    public String solutionVideo(Model model) {
        setStyle(model,"solution");
        return "front/website/solutionVideo";
    }


    /**
     * 最终简报表（前端单独页面用）
     * @param model
     * @return
     */
    @GetMapping(value = "/weekly")
    public String message(Model model) {
        List<Briefing> list=messbriefingService.briefingList();
        //System.out.println(list);
        model.addAttribute("list",list);
        return "front/website/week";
    }




}