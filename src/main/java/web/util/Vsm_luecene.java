package web.util;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import web.model.Article;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Vsm_luecene {


    /**
     * 创建索引,新创建的时候，删除旧的索引
     */
    public static void create_index(String model, List<Article> articleList){
        try {
            String model_path = model+"_index";
            File file_index = new File(model_path);
            if(!file_index.exists()&& !file_index.isDirectory()){
                System.out.println("索引不存在,创建索引");
            }else {
                System.out.println("索引存在,删除索引");
                file_index.delete();
            }
            Directory directory = FSDirectory.open(Paths.get(model_path));
            //Directory directory=new RAMDirectory();
            //3 创建分词器对象
            //标准分词器，并不合适中文分词，因此一般我们会用第三方提供的分词器：(比如 ChineseAnalyzer CollationAnalyzer等等，不过ChineseAnalyzer已经废弃了)，这里使用的是IK分词器
            Analyzer analyzer = new SmartChineseAnalyzer();
            //4 索引写出工具的配置对象
            IndexWriterConfig conf = new IndexWriterConfig(analyzer);
            conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            IndexWriter indexWriter = new IndexWriter(directory, conf);
            //循环添加将问答添加进入索引,以下示例同一个问题切分以及不切分形成两个答案
            for (Article article : articleList) {
                Document documentqiefen = new Document();
                documentqiefen.add(new TextField("id", article.getId()+"", Field.Store.YES));
                documentqiefen.add(new TextField("title", article.getTitle(), Field.Store.YES));
                indexWriter.addDocument(documentqiefen);
            }
            //7 提交
            indexWriter.commit();
            //8 关闭
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setId(1);
        article.setTitle("天天向上");
        articles.add(article);
        create_index("jr",articles);
    }
}
