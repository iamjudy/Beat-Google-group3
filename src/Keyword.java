public class Keyword {
	public String name;
	public int count;
	public double weight;
	
	public Keyword(String name, int weight){
		this.name = name;
		this.weight = weight;
	}
	
	public String toString(){
		return "[" + name +","+ count + "]" ;
	}


}