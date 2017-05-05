package cn.edu.buaa.jsi.portal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

public class IDPLmain {

	public static void main(String[] args) throws IOException, ServiceException{
		
		
 
//		SExperiment(long exp_id, String source, String destination,
//				String protocol, String putorget, String v4orv6, String FilesSize,
//				int FilesNumber, int parallel, int repeat) 
		
//		SExperiment exp1 = new SExperiment(0, "BUAA", "WISC", "FTP", "put",
//				"ipv6", "1G", 1, 1, 1);
		
//		SExperiment exp2 = new SExperiment(2, "CNIC", "UCSD", "HTTP", "GET",
//				"ipv4", "10G", 1, 1, 2);
//		SExperiment exp3 = new SExperiment(3, "UCSD", "BUAA", "FTP", "PUT",
//				"ipv4", "650M", 3, 1, 2);
		
//		VARS A EXPERIMENT="buaa2a" SRC_HOST="mickey.buaa.edu.cn" SRC_PATH="/home/idpl/testdata/10MB.dat" DST_HOST="komatsu.chtc.wisc.edu" DST_PATH="10MB.dat"  TESTSEQUENCE="iperf" TIMEOUT="120"

				////		String var = ' VARS A EXPERIMENT="buaa2a" SRC_HOST="mickey.buaa.edu.cn" \"
//				+ "SRC_PATH="/home/idpl/testdata/10MB.dat" \"
//						+ "DST_HOST="komatsu.chtc.wisc.edu" \"
//								+ "DST_PATH="10MB.dat"  \"
//										+ "TESTSEQUENCE="iperf" ';"

//		VARS A EXPERIMENT=\"buaa2a\" 
//		String var="SRC_HOST=\"mickey.buaa.edu.cn\" SRC_PATH=\"/home/idpl/testdata/10MB.dat\" "
//				+ "DST_HOST=\"komatsu.chtc.wisc.edu\" DST_PATH=\"10MB.dat\"  TESTSEQUENCE=\"iperf,scp\" TIMEOUT=\"120\"  ";
//		String v =" s  //////  \" \"sfsf";                  
//		priority=\"1\"  cron_minute=\"20\"
		String var="SRC_HOST=\"idpl.elab.cnic.cn\" SRC_PATH=\"/home/idpl/testdata/10MB.dat\" "
				+ "DST_HOST=\"mickey.buaa.edu.cn\" DST_PATH=\"10MB.dat\"  TESTSEQUENCE=\"traceroute,traceroute6\" TIMEOUT=\"120\"  cron_minute=\"0,15,30,45\" ";
		SExperiment exp = new SExperiment(0, var );
		
		System.out.print(exp.getVar());
//		System.exit(0);;
		
		List<SExperiment> list = new ArrayList<SExperiment>();
		list.add(exp);
//		list.add(exp2);
//		list.add(exp3);

		Transfer transfer = Transfer.getInstance();
		transfer.setExpList(list);
		
		transfer.setId(2000);
		transfer.setStarttime(0);
		transfer.setStoptime(0);
		transfer.setUser("yyq");//这个后面，提交作业时，直接重新设了
		transfer.submit();

	}
}
