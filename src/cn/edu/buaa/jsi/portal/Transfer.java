package cn.edu.buaa.jsi.portal;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author yyq @{2014/10/23}
 *
 */
public class Transfer {

	private static Transfer transfer;
	private List<SExperiment> expList;
	private String user;
	private long starttime;
	private long stoptime;
	private long id;
	private static ExecutorService pool;

	private Transfer() {
		// TODO:thread pool!
		// Transfer.pool = new ThreadPoolExecutor(5, 20, 60L, TimeUnit.SECONDS,
		// new SynchronousQueue<Runnable>());
		Transfer.pool = Executors.newCachedThreadPool();
	}

	public static synchronized Transfer getInstance() {
		if (transfer == null) {
			transfer = new Transfer();
		}
		return transfer;
	}

	public void submit() throws IOException {

		ExpAnalyze expAnalyze = new ExpAnalyze(expList, user, id, starttime,
				stoptime);
		Thread th = new Thread(expAnalyze);
		pool.execute(th);
	}

	public void setExpList(List<SExperiment> expList) {
		this.expList = expList;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setStarttime(long starttime) {
		this.starttime = starttime;
	}

	public void setStoptime(long stoptime) {
		this.stoptime = stoptime;
	}

	public void setId(long id) {
		this.id = id;
	}

}
