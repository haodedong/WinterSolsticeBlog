package com.hdd.winterSolsticeBlog.generator;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe :
 *
 * @author hao.dd
 * @date 2023/11/10
 */
public class CodeGenerator {
    public static void main(String[] args) {
        //数据库及路径信息
        String rootPackage = "com.hdd.winterSolsticeBlog";
        String url = "jdbc:mysql://localhost:3306/blog" ;
        String username = "root";
        String password = "IsuffUd89" ;

        //添加表名称
        List<String> tableList = new ArrayList<>();
//        tableList.add("category");
//        tableList.add("article_category");
//        tableList.add("my_table_teacher");

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder(url, username, password).build();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .author("haodedong")
                .dateType(DateType.TIME_PACK)
                .outputDir(projectPath + "/src/main/")
                .build();
        //包配置
        Map<OutputFile, String> map = new HashMap<OutputFile, String>();
        map.put(OutputFile.xml,projectPath+"/src/main/resources/mapper/");
        map.put(OutputFile.entity,projectPath+"/src/main/java/com/hdd/winterSolsticeBlog/entity/");
        map.put(OutputFile.mapper,projectPath+"/src/main/java/com/hdd/winterSolsticeBlog/mapper/");
        map.put(OutputFile.controller,projectPath+"/src/main/java/com/hdd/winterSolsticeBlog/controller/");
        map.put(OutputFile.service,projectPath+"/src/main/java/com/hdd/winterSolsticeBlog/service/");
        map.put(OutputFile.serviceImpl,projectPath+"/src/main/java/com/hdd/winterSolsticeBlog/service/impl/");
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent(rootPackage)
                .pathInfo(map)
                .build();
        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder().addInclude(tableList).build();
        strategyConfig.entityBuilder().enableFileOverride().enableLombok().enableFileOverride().enableTableFieldAnnotation().idType(IdType.AUTO).build();
        strategyConfig.serviceBuilder().enableFileOverride().formatServiceFileName("%sService").formatServiceImplFileName("%sServiceImp").build();//不要I开头
        strategyConfig.mapperBuilder().enableFileOverride().enableMapperAnnotation().enableBaseResultMap().build();

        //修改模板
        TemplateConfig templateConfig = new TemplateConfig.Builder().entity("/templates/entity.java.vm").build();


        //代码生成
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);
        autoGenerator.global(globalConfig).packageInfo(packageConfig).strategy(strategyConfig).template(templateConfig);

        autoGenerator.execute();
    }
}
