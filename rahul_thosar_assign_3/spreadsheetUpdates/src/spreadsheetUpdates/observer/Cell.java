package spreadsheetUpdates.observer;

import java.util.ArrayList;
import java.util.List;

public class Cell implements SubjectInterface, ListenerInterface{

	//private datastructure
	private int value = 0;
	private String operand1="-",operand2="-";
	private int operand1Val=-99, operand2Val=-99;  
	private String cellName;
	private Boolean litFlag = false;
	List<Cell> observerList = new ArrayList<Cell>();
	/*
	 * Method used to update dependent observers
	 * (non-Javadoc)
	 * @param temp, cellName
	 * @see spreadsheetUpdates.observer.ListenerInterface#update(int, java.lang.String)
	 */
	@Override
	public void update(int temp, String cellName2) {
		// TODO Auto-generated method stub
		if(this.operand1.equalsIgnoreCase(cellName2)){
			this.operand1Val=temp;
		}
		if(this.operand2.equalsIgnoreCase(cellName2)){
			this.operand2Val=temp;
		}
		this.value=operand1Val+operand2Val;
	}
	
	
	/*
	 * Method used to register observer
	 * @param Cell object
	 * (non-Javadoc)
	 * @see spreadsheetUpdates.observer.SubjectInterface#registerObserver(spreadsheetUpdates.observer.Cell)
	 */
	@Override
	public void registerObserver(Cell o) {
		// TODO Auto-generated method stub
		//System.out.println(" Test"+o.toString());
		observerList.add(o);
	}
	
	/*
	 * Method used to remove oberver
	 * (non-Javadoc)
	 * @param Cell object
	 * @see spreadsheetUpdates.observer.SubjectInterface#removeObserver(spreadsheetUpdates.observer.Cell)
	 */
	@Override
	public void removeObserver(Cell o) {
		// TODO Auto-generated method stub
		int i = observerList.indexOf(o);
		if(i>=0){
			observerList.remove(i);
		}
	}

	/*
	 * Method used to notify observer list
	 * (non-Javadoc)
	 * @see spreadsheetUpdates.observer.SubjectInterface#notifyObserver()
	 */
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i=0;i<observerList.size();i++){
			Cell observer = (Cell)observerList.get(i);
			observer.update(this.value, this.cellName);
			observer.notifyObserver();
			
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getOperand1() {
		return operand1;
	}

	public void setOperand1(String operand1) {
		this.operand1 = operand1;
	}

	public String getOperand2() {
		return operand2;
	}

	public void setOperand2(String operand2) {
		this.operand2 = operand2;
	}

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public List<Cell> getObserverList() {
		return observerList;
	}

	public void setObserverList(List<Cell> observerList) {
		this.observerList = observerList;
	}

	public Boolean getLitFlag() {
		return litFlag;
	}

	public void setLitFlag(Boolean litFlag) {
		this.litFlag = litFlag;
	}
	

	public int getOperand1Val() {
		return operand1Val;
	}

	public void setOperand1Val(int operand1Val) {
		this.operand1Val = operand1Val;
	}

	public int getOperand2Val() {
		return operand2Val;
	}

	public void setOperand2Val(int operand2Val) {
		this.operand2Val = operand2Val;
	}

	/*Method used to print all the values of cell object
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cell [cellName=" + cellName + ",  value=" + value + ", operand1=" + operand1 + ", operand1Val="+operand1Val+ ", operand2=" + operand2 + 
				", operand2Val=" + operand2Val+ ", litFlag=" + litFlag + ", observerList=" + observerList + "]";
	}
	
	
	
}
