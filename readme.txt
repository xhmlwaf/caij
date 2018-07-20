1.表的划分需要改
任务表(task) id,name,start_page_url,list_xpath,is_dynamic,status,created_at,multi_page,page_url_template,start_page,end_page
元素表(element) id,task_id,param_name,element_type,content_type,xpath,attr_name,regex,associate_page_id,deal_type
关联页表(associate_page) id,task_id,name,xpath,content_type,attr_name,regex

任务详情表(detailed_task) id,task_id,page_url,result_size,start_time,end_time,status


2.更多的功能
浏览器设置IP代理
登陆账户


自定义的，模版批量删除


技术点：
即Springboot中默认的静态资源路径有4个，分别是：

classpath:/METAINF/resources/，

classpath:/resources/，

classpath:/static/，

classpath:/public/

优先级顺序为：META-INF/resources  >  resources  >  static  >  public

datatable
https://www.cnblogs.com/ma-lijun/p/5565977.html



可以通过修改application.properties文件中的spring.mvc.static-path-pattern属性来修改默认的映射**，配置如下

