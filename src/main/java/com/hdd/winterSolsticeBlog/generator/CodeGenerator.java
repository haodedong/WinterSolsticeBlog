package com.hdd.winterSolsticeBlog.generator;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * describe :
 *
 * @author hao.dd
 * @date 2023/11/10
 */
public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();//代码生成器

        DataSourceConfig dataSource = new DataSourceConfig();//数据库配置
        dataSource.setDriverName("com.mysql.jdbc.Driver"); //驱动名称
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/blog?serverTimezone=UTC"); //数据库的Url
        dataSource.setUsername("root"); //数据库用户名
        dataSource.setPassword("IsuffUd89"); //数据库密码
        autoGenerator.setDataSource(dataSource);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");//设置生成位置
        globalConfig.setOpen(false); //设置生成完毕后是否打开生成代码所在的目录
        globalConfig.setAuthor("haodedong"); //设置作者
        globalConfig.setFileOverride(true); //设置是否覆盖原始生成的文件
        globalConfig.setMapperName("%sDao"); //设置数据层接口名，%s为占位符，指代码模块名称
        globalConfig.setIdType(IdType.ASSIGN_ID); //设置ID生成策略
        autoGenerator.setGlobalConfig(globalConfig);

        //设置包名
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.hdd.winterSolsticeBlog"); //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageConfig.setEntity("entity"); //设置实体类包名
        packageConfig.setMapper("dao"); //设置数据访问层包名
        autoGenerator.setPackageInfo(packageConfig);

        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        //strategyConfig.setInclude("smsbms_user","smbms_provider"); //设置指定表的内容，参数可变
//        strategyConfig.setTablePrefix("smbms_"); //设置数据库前缀的名称，模块名 = 数据库名-前缀名 例如:User = smbms_user-smbms_
        strategyConfig.setRestControllerStyle(true); //是否采用Rest风格
        strategyConfig.setEntityLombokModel(true); //设置实体类是否使用Lombok
        strategyConfig.setVersionFieldName("version"); //设置乐观锁字段名
        strategyConfig.setLogicDeleteFieldName("deleted"); //设置逻辑删除字段名
        // 设置表名、字段名的命名策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute(); //执行生成操作
    }
}
