package web.util;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import web.model.Article;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Vsm_luecene_search {



    public static List<Article> search(String model, String title,Integer search_num){
        List<Article> articleList = new ArrayList<>();
        try {
            // 索引目录对象
            Directory directory = FSDirectory.open(Paths.get(model+"_index"));
            // 索引读取工具
            IndexReader reader = DirectoryReader.open(directory);
            // 索引搜索工具
            IndexSearcher searcher = new IndexSearcher(reader);
            Analyzer analyzer = new SmartChineseAnalyzer();
            // 创建查询解析器,两个参数：默认要查询的字段的名称，分词器
            QueryParser parser = new QueryParser("title", analyzer);

            // 创建查询对象
            Query query = null;

            query = parser.parse(title);

            TopDocs topDocs = searcher.search(query, search_num);
            // 获取总条数
            System.out.println("本次搜索共找到" + topDocs.totalHits + "条数据");

            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {
                // 取出文档编号  lucene
                int docID = scoreDoc.doc;
                // 根据编号去找文档
                Document doc = reader.document(docID);
                String doc_title = doc.get("title");
                String doc_id = doc.get("id");
                System.out.println("title: " + doc_title);
                // 取出文档得分
                System.out.println("得分： " + scoreDoc.score);
                Article article = new Article();
                article.setId(Integer.valueOf(doc_id));
                article.setTitle(doc_title);
                articleList.add(article);

            }
            return articleList;
        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }
        return articleList;

    }

    public static void main(String[] args) {
        List<Article> search = search("jr", "天天向上",10);
        System.out.println(search);
    }

}
