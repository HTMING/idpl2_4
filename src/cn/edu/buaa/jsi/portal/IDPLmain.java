package cn.edu.buaa.jsi.portal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

public class IDPLmain {

	public static void main(String[] args) throws IOException, ServiceException{
		
		SExperiment exp = new SExperiment(1, "CNIC", "WISC", "FTP", "put",
				"ipv6", "1G", 1, 1, 1);
//		SExperiment exp2 = new SExperiment(2, "CNIC", "UCSD", "HTTP", "GET",
//				"ipv4", "10G", 1, 1, 2);
//		SExperiment exp3 = new SExperiment(3, "UCSD", "BUAA", "FTP", "PUT",
//				"ipv4", "650M", 3, 1, 2);
		List<SExperiment> list = new ArrayList<SExperiment>();
		list.add(exp);
//		list.add(exp2);
//		list.add(exp3);

		Transfer transfer = Transfer.getInstance();
		transfer.setExpList(list);
		transfer.setId(1);
		transfer.setStarttime(0);
		transfer.setStoptime(0);
		transfer.setUser("yyq");
		transfer.submit();

	}
}
