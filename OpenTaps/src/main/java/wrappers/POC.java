package wrappers;

public class POC {

	public static void main(String[] args) {

		String name = "CTS (6542643)";
		String[] temp = name.split(" ");
		String companyId = temp[1];
		companyId = companyId.replace("(", "").replace(")", "");
		System.out.println(companyId);
		
		System.out.println(name.replaceAll("\\D", ""));
	}

}
