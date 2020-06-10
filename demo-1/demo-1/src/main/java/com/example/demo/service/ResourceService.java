package com.example.demo.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookInfoItem;
@Service
public class ResourceService {
	private String RequestHtml(String searchText) throws ClientProtocolException, IOException{
		StringBuffer sb = new StringBuffer();
		sb.append("http://202.114.202.207:80/opac/openlink.php?strSearchType=title&strText=");
		sb.append(searchText);
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(sb.toString());
		CloseableHttpResponse response  = null;
		response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		String result  = null;
		if(entity != null) {
			result = EntityUtils.toString(entity,"UTF-8");
		}
		httpClient.close();
		response.close();
		return result;
	}
	private List<BookInfoItem> parseBookInfoItems(String htmlText) throws IOException {
		Document doc = Jsoup.parse(htmlText);
		Element e = doc.getElementById("search_book_list");
		Elements infoes = e.getElementsByTag("li");
		List<BookInfoItem> items = new ArrayList<BookInfoItem>();
		for(Element child : infoes) {
			items.add(parseBookInfo(child));
		}
		return items;
	}
	private BookInfoItem parseBookInfo(Element e) {
		BookInfoItem item = new BookInfoItem();
		String detail = e.select(">p").text();
		String[] detailText = detail.split(" ");
		String title = e.select(">h3>a").text();
		item.setTitle(title);
		item.setStoredDetail(detailText[0]);
		item.setAvailDetail(detailText[1]);
		item.setAuthor(detailText[2]);
		item.setPublisher(detailText[3]);
		String link = e.select(">h3>a").attr("href");
		item.setDetailLink("http://202.114.202.207:80/opac/"+ link);
		return item;
	}
	public List<BookInfoItem> bookSearch(String searchText) throws ClientProtocolException, IOException{
		String htmlText =RequestHtml(searchText);
		return parseBookInfoItems(htmlText);
	}
	public static void main(String[]args) throws ClientProtocolException, IOException {
		ResourceService rs = new ResourceService();
	}
}
