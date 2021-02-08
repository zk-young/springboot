# springboot
springboot入门学习
###1什么是springboot?
    springboot是spring项目中的一个子工程,与spring-framework 同属于spring的产品
###2Spring Boot 主要特点是：
    创建独立的Spring应用，为所有 Spring 的开发者提供一个非常快速的、广泛接受的入门体验
    直接嵌入应用服务器，如tomcat、jetty、undertow等；不需要去部署war包
    提供固定的启动器依赖去简化组件配置；实现开箱即用（启动器starter-其实就是Spring Boot提供的一个jar
    包），通过自己设置参数（.properties或.yml的配置文件），即可快速使用。
    自动地配置Spring和其它有需要的第三方依赖
    提供了一些大型项目中常见的非功能性特性，如内嵌服务器、安全、指标，健康检测、外部化配置等
    绝对没有代码生成，也无需 XML 配置。
### 3步骤:
    1.创建maven工程 
    2.添加依赖
    3.添加父工程坐标
    4.添加web启动器
    5.管理jdk版本
    6.编写启动类
###4 java配置
    java配置主要靠java类和一些注解，比较常用的注解有：
    @Configuration ：声明一个类作为配置类，代替xml文件
    @Bean ：声明在方法上，将方法的返回值加入Bean容器，代替 <bean> 标签
    @Value ：属性注入
    @PropertySource ：指定外部属性文件，
    使用autowired 注入
### 5属性的注入
    应用:可以将springboot配置文件中(默认)中的配置读取到一个对象中@ConfigurationProperties
    @value注解只能注入基本类型值。
    在Spring Boot中，提供了一种新的属性注入方式，支持各种java基本数据类型及复杂类型的注入
    属性文件的名称有变化，默认的文件名必须是：application.properties或application.yml
    
    在类上通过@ConfigurationProperties注解声明当前类为属性读取类
    prefix="jdbc" 读取属性文件中，前缀为jdbc的值。
    在类上定义各个属性，名称必须与属性文件中 jdbc. 后面部分一致
    需要注意的是，这里我们并没有指定属性文件的地址，所以我们需要把jdbc.properties名称改为
    application.properties，这是Spring Boot默认读取的属性文件名：
    通过 @EnableConfigurationProperties(JdbcProperties.class) 来声明要使用 JdbcProperties 这个类的
    对象
    然后要使用配置的话；可以通过以下方式注入JdbcProperties：
    @Autowired
    private JdbcProperties prop;
    2构造函数注入
    private JdbcProperties prop;
    public JdbcConfig(Jdbcproperties prop){
    this.prop = prop;
    }
    3@Bean
    public Datasource dataSource(JdbcProperties prop){
    // ...
    }

    步骤:    1. 创建配置项类JdbcProperties类，在该类名上面添加@ConfigurationProperties；
            2. 创建application.properties；
            3. 将JdbcProperties对象注入到JdbcConfig；
            
        注:在方法上能直接使用@ConfigurationProperties
            @Bean
            @ConfigurationProperties(prefix = "jdbc")
            public DataSource dataSource() {
                return new DruidDataSource();
            }
### 6多个yml文件配置
    yaml与properties配置文件除了展示形式不相同以外，其它功能和作用都是一样的；在项目中原路的读取方式不需要改变。

    1）yml配置文件的特征：
    
    1. 树状层级结构展示配置项；
    2. 配置项之间如果有关系的话需要分行空两格；
    3. 配置项如果有值的话，那么需要在 `:`之后空一格再写配置项值；
    
    1)将application.properties配置文件修改为application.yml的话：
        jdbc:
          driverClassName: com.mysql.jdbc.Driver
          url: jdbc:mysql://127.0.0.1:3306/heima
          username: root
          password: root
    2）多个yml配置文件；在spring boot中是被允许的。这些配置文件的名称必须为application-***.yml，并且这些配置文件必须要在application.yml配置文件中激活之后才可以使用。
    3）如果properties和yml配置文件同时存在在spring boot项目中；那么这两类配置文件都有效。在两个配置文件中如果存在同名的配置项的话会以properties文件的为主。


    