import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Keyword k1=new Keyword("�s�~",50);
		Keyword k2=new Keyword("�h�f",45);
		Keyword k3=new Keyword("���P",40);
		Keyword k4=new Keyword("�ʪ���",35);
		Keyword k5=new Keyword("�u�f",30);
		Keyword k6=new Keyword("�q��d��",30);
		Keyword k7=new Keyword("�p���ʶR",20);
		Keyword k8=new Keyword("����ڭ�",10);
		ArrayList<Keyword> lst=new ArrayList<Keyword>();
		lst.add(k1);
		lst.add(k2);
		lst.add(k3);
		lst.add(k4);
		lst.add(k5);
		lst.add(k6);
		lst.add(k7);
		lst.add(k8);
		
		
		try {
			GoogleQuery google=new GoogleQuery("����");
			
			System.out.println(google.query(lst));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}