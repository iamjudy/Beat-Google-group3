import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;



public class GoogleQuery 

{

	public String searchKeyword;

	public String url;

	public String content;
	//public WordCounter counter;
	public ArrayList<WebPage> list=new ArrayList<WebPage>();

	public GoogleQuery(String searchKeyword)

	{

		this.searchKeyword = searchKeyword;

		this.url = "http://www.google.com/search?q="+searchKeyword+"&oe=utf8&num=10";

	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();

		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	public void sort() {
		quickSort(0, (list.size()-1));

	}
	private void quickSort(int leftbound, int rightbound){
		//implement quickSort algorithm
		if(leftbound>=rightbound) {
			return;
		}
		WebPage x=list.get(rightbound);
		int j=leftbound;
		int k=rightbound-1;
		if(j<k) {
			while(j<k&&list.get(j).score<=x.score) {
				j++;
				while(j<k&&list.get(k).score>x.score) {
					k--;
					if(list.get(j).score>list.get(k).score) {
						WebPage a = list.get(j);
					    WebPage b=list.get(k);
						list.set(j, b);
						list.set(k, a);
					}
				}
			}
			
			
		}
		swap(list.indexOf(x),j);
		quickSort(leftbound,j-1);
		quickSort(j+1,rightbound);
	}
	
	
	private void swap(int aIndex, int bIndex){
		WebPage temp = list.get(aIndex);
		list.set(aIndex, list.get(bIndex));
		list.set(bIndex, temp);
	}
	

	public HashMap<String, String> query(ArrayList<Keyword> lst) throws IOException

	{

		if(content==null)

		{

			content= fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		System.out.println(doc.text());
		Elements lis = doc.select("div");
		lis = lis.select(".ZINbbc");
		System.out.println(lis.size());
		list=new ArrayList<WebPage>();
		for(Element li : lis)
		{
			
			
			try 

			{
				WebPage web=new WebPage(li.select("a").get(0).attr("href"),li.select(".BNeawe").get(0).text());
				list.add(web);
				for(int i=0;i<lst.size();i++) {
					lst.get(i).count=web.counter.countKeyword(lst.get(i).name);
				}
				web.setScore(lst);
				
//				System.out.println(li.select(".BNeawe").get(0).text());
//				System.out.println(li.select("a").get(0).attr("href"));
//				for(int i = 0 ; i < block.size(); i++)
//					System.out.println(block.get(i).text());
				
//				System.out.println(block.get(1).text());
//				System.out.println(block.get(2).text());
				
//				String title = block.get(1).text();
//				String citeUrl = block.get(2).text();
				
//				System.out.println(title+" "+citeUrl);

//				retVal.put(title, citeUrl);

				

			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}

		}
		try {
			sort();
			for(int i=0;i<list.size();i++) {
				retVal.put(list.get(i).name,list.get(i).url);
			}
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return retVal;

	}

	

	

}