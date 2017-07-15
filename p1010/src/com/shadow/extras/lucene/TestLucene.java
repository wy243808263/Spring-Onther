package com.shadow.extras.lucene;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class TestLucene {

	private static final Logger logger = Logger.getLogger(TestLucene.class);

	private static final Version VERSION = Version.LUCENE_36;

	private static final Analyzer ANALYZER = new IKAnalyzer();

	/** 获取文件路径 */
	private String getDir(String key) {
		InputStream in = ClassLoader
				.getSystemResourceAsStream("properties/lucene.properties");
		Properties p = new Properties();
		try {
			p.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p);
		return p.getProperty(key);
	}

	/** 获取路径文件 */
	private File getFile(String dir) {
		return new File(dir);
	}

	/** 检测文件夹是否存在 */
	private boolean checkIsExist(File file) {
		return file.exists();
	}

	/** 读取文件目录 */
	private Directory getDirectory(String dir) {
		try {
			Directory directory = new SimpleFSDirectory(new File(dir));
			return directory;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("读取文件目录失败: " + e.getMessage());
			return null;
		}
	}

	/** 获取索引器 */
	private IndexWriter getIndexWriter(String dir) {
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(VERSION,
				ANALYZER);
		try {
			Directory directory = getDirectory(dir);
			return new IndexWriter(directory, indexWriterConfig);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("错误信息: " + e.getMessage());
		}
		return null;
	}

	/** 创建索引文件 */
	private void createIndexFile(String dir, List<Document> documents) {
		File file = getFile(dir);
		System.out.println(checkIsExist(file));
		if (checkIsExist(file)) {
			logger.info("已经存在文件路径");
			return;
		}
		IndexWriter writer = getIndexWriter(dir);
		if (writer == null) {
			logger.error("IndexWriter尚未初始化成功!");
			return;
		}
		try {
			for (Document document : documents) {
				writer.addDocument(document);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/** 获取读取器 */
	private IndexReader getIndexReader(String dir) {
		try {
			// 得到索引的目录
			Directory directory = getDirectory(dir);
			// 根据目录打开一个indexReader
			IndexReader indexReader = IndexReader.open(directory);
			return indexReader;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("错误信息: " + e.getMessage());
		}
		return null;
	}

	/** 获取查询器 */
	private IndexSearcher getIndexSearcher(String dir) {
		Directory directory = getDirectory(dir);
		IndexReader reader;
		try {
			reader = IndexReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			return searcher;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 获取QueryParser */
	private QueryParser getQueryParser(String[] fields) {
		return new MultiFieldQueryParser(VERSION, fields, ANALYZER);
	}

	/** 获取查询对象 */
	private Query getQuery(String[] fields, String content) {
		QueryParser queryParser = getQueryParser(fields);
		try {
			Query query = queryParser.parse(content);
			return query;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 删除索引 */
	@SuppressWarnings("unused")
	private void deleteIndex(String dir, String key, String value) {
		IndexWriter writer = getIndexWriter(dir);
		try {
			writer.deleteDocuments(new Term(key, value));
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 更新索引 */
	@SuppressWarnings("unused")
	private void updateIndex(String dir, String key, String value, Document doc) {
		IndexWriter writer = getIndexWriter(dir);
		try {
			writer.updateDocument(new Term(key, value), doc);
			writer.commit();
			writer.close();
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 测试writer
	private void testWriter() {
		// 索引对象
		Document d1 = new Document();
		Document d2 = new Document();
		Document d3 = new Document();
		Document d4 = new Document();
		Document d5 = new Document();
		Document d6 = new Document();

		// 设置对象内容
		d1.add(new Field("id", "1", Store.YES, Index.ANALYZED));
		d1.add(new Field("word", "欧姆定律", Store.YES, Index.ANALYZED));
		d1.add(new Field("hit", "10", Store.YES, Index.ANALYZED));

		d2.add(new Field("id", "2", Store.YES, Index.ANALYZED));
		d2.add(new Field("word", "牛顿三定律", Store.YES, Index.ANALYZED));
		d2.add(new Field("hit", "8", Store.YES, Index.ANALYZED));

		d3.add(new Field("id", "3", Store.YES, Index.ANALYZED));
		d3.add(new Field("word", "能量守恒定律", Store.YES, Index.ANALYZED));
		d3.add(new Field("hit", "9", Store.YES, Index.ANALYZED));

		d4.add(new Field("id", "4", Store.YES, Index.ANALYZED));
		d4.add(new Field("word", "雪莉定律", Store.YES, Index.ANALYZED));
		d4.add(new Field("hit", "11", Store.YES, Index.ANALYZED));

		d5.add(new Field("id", "5", Store.YES, Index.ANALYZED));
		d5.add(new Field("word", "苹果定律", Store.YES, Index.ANALYZED));
		d5.add(new Field("hit", "6", Store.YES, Index.ANALYZED));

		d6.add(new Field("id", "6", Store.YES, Index.ANALYZED));
		d6.add(new Field("word", "test", Store.YES, Index.ANALYZED));
		d6.add(new Field("hit", "5", Store.YES, Index.ANALYZED));

		List<Document> documents = new ArrayList<Document>();
		documents.add(d1);
		documents.add(d2);
		documents.add(d3);
		documents.add(d4);
		documents.add(d5);
		documents.add(d6);

		String dir = getDir("keyword");

		createIndexFile(dir, documents);
	}

	// 测试读取信息
	private void testReader() {
		String dir = getDir("keyword");
		List<KeyWord> keyWords = new ArrayList<KeyWord>();
		IndexReader indexReader = getIndexReader(dir);
		int n = indexReader.maxDoc();
		Document doc = null;
		KeyWord keyWord = null;
		try {
			for (int i = 0; i < n; i++) {
				doc = indexReader.document(i);
				keyWord = new KeyWord();
				keyWord.setId(Integer.valueOf(doc.get("id")));
				keyWord.setWord(doc.get("word"));
				keyWord.setHit(Integer.parseInt(doc.get("hit")));
				keyWords.add(keyWord);
			}
		} catch (IOException e) {
		}
		if (indexReader != null) {
			try {
				indexReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("当前数据量: " + keyWords.size());
	}

	// 测试模糊查询
	private void testSearch() {

		// 模糊查询
		getQuery(new String[] { "word" }, "欧定律");

		// 精准查询
		Query tQuery = new TermQuery(new Term("word", "欧姆定律"));

		String dir = getDir("keyword");

		IndexSearcher searcher = getIndexSearcher(dir);
		try {
			SortField field = new SortField("hit", SortField.INT, true);
			Sort sort = new Sort(field);
			ScoreDoc[] docs = searcher.search(tQuery, 10, sort).scoreDocs;
			for (ScoreDoc doc : docs) {
				Document d = searcher.doc(doc.doc);
				System.out.println(d.get("id") + "__" + d.get("word") + "__"
						+ d.get("hit"));
			}
			if (searcher != null)
				searcher.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		TestLucene test = new TestLucene();
		test.testWriter();
		test.testReader();
		test.testSearch();
		// test.deleteIndex("id", "4");
	}
}