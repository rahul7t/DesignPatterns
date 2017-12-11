package genericSerDeser.strategy;

import genericSerDeser.fileOperations.FileProcessor;
/***
 * Definition for DPML strategy
 * 
 */
public interface SerStrategy {
	public void createDPMLFormat(Object firstOrSecondRef, FileProcessor fp);
}
